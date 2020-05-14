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
import dal.dao.gas_merchant.*;
import dal.model.gas_merchant.*;
import com.xjy.autotest.config.Gas_merchantDataSourceConfig;

/**
 * @author autotest
 * Created on 2020/05/11.
 */
@Service
@Import({
        Gas_merchantDataSourceConfig.class
})
public class Gas_merchantTestBase extends AutoTestBase{

	@Autowired
	GasAppVersionDAO gasAppVersionDAO;

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
	GasInvoiceCompanyDAO gasInvoiceCompanyDAO;

	@Autowired
	GasInvoiceConfigDAO gasInvoiceConfigDAO;

	@Autowired
	GasLoginLogCopyDAO gasLoginLogCopyDAO;

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
	GasMerchantDeviceFunctionBkDAO gasMerchantDeviceFunctionBkDAO;

	@Autowired
	GasMerchantDeviceFunctionDAO gasMerchantDeviceFunctionDAO;

	@Autowired
	GasMerchantGoodsDAO gasMerchantGoodsDAO;

	@Autowired
	GasMerchantGoodsPricePlanCopyDAO gasMerchantGoodsPricePlanCopyDAO;

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
	GasOilStationDescriptionDAO gasOilStationDescriptionDAO;

	@Autowired
	GasPartnerMappingDAO gasPartnerMappingDAO;

	@Autowired
	GasProvinceDAO gasProvinceDAO;

	@Autowired
	GasRoleDAO gasRoleDAO;

	@Autowired
	GasRuleDescriptionDAO gasRuleDescriptionDAO;

	@Autowired
	GasStationGoodsDAO gasStationGoodsDAO;

	@Autowired
	GasStationGoodsPricePlanDAO gasStationGoodsPricePlanDAO;

	@Autowired
	GasStationOilGunDAO gasStationOilGunDAO;

	@Autowired
	GasStationVoiceBroadcastDAO gasStationVoiceBroadcastDAO;

	@Autowired
	GasTicketPrintDAO gasTicketPrintDAO;

	@Autowired
	GasVoiceBroadcastFieldDAO gasVoiceBroadcastFieldDAO;

	@Autowired
	MerchantProductDAO merchantProductDAO;

	@Autowired
	MerchantProtocolRuleDAO merchantProtocolRuleDAO;

	@Autowired
	NotifyTaskDAO notifyTaskDAO;

	@Autowired
	PermissionDAO permissionDAO;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	ProductPermissionDAO productPermissionDAO;

	@Autowired
	RoleDAO roleDAO;

	@Autowired
	RolePermissionDAO rolePermissionDAO;

	@Autowired
	RoleProductDAO roleProductDAO;

	@Autowired
	SysIdGenDAO sysIdGenDAO;

	@Autowired
	TmpPointsGoodsMapDAO tmpPointsGoodsMapDAO;

	@Autowired
	UserUniqueKeyDAO userUniqueKeyDAO;

	public GasAppVersionDAO getGasAppVersionDAO() {
		return this.gasAppVersionDAO;
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

	public GasInvoiceCompanyDAO getGasInvoiceCompanyDAO() {
		return this.gasInvoiceCompanyDAO;
	}

	public GasInvoiceConfigDAO getGasInvoiceConfigDAO() {
		return this.gasInvoiceConfigDAO;
	}

	public GasLoginLogCopyDAO getGasLoginLogCopyDAO() {
		return this.gasLoginLogCopyDAO;
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

	public GasMerchantDeviceFunctionBkDAO getGasMerchantDeviceFunctionBkDAO() {
		return this.gasMerchantDeviceFunctionBkDAO;
	}

	public GasMerchantDeviceFunctionDAO getGasMerchantDeviceFunctionDAO() {
		return this.gasMerchantDeviceFunctionDAO;
	}

	public GasMerchantGoodsDAO getGasMerchantGoodsDAO() {
		return this.gasMerchantGoodsDAO;
	}

	public GasMerchantGoodsPricePlanCopyDAO getGasMerchantGoodsPricePlanCopyDAO() {
		return this.gasMerchantGoodsPricePlanCopyDAO;
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

	public GasOilStationDescriptionDAO getGasOilStationDescriptionDAO() {
		return this.gasOilStationDescriptionDAO;
	}

	public GasPartnerMappingDAO getGasPartnerMappingDAO() {
		return this.gasPartnerMappingDAO;
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

	public GasStationGoodsDAO getGasStationGoodsDAO() {
		return this.gasStationGoodsDAO;
	}

	public GasStationGoodsPricePlanDAO getGasStationGoodsPricePlanDAO() {
		return this.gasStationGoodsPricePlanDAO;
	}

	public GasStationOilGunDAO getGasStationOilGunDAO() {
		return this.gasStationOilGunDAO;
	}

	public GasStationVoiceBroadcastDAO getGasStationVoiceBroadcastDAO() {
		return this.gasStationVoiceBroadcastDAO;
	}

	public GasTicketPrintDAO getGasTicketPrintDAO() {
		return this.gasTicketPrintDAO;
	}

	public GasVoiceBroadcastFieldDAO getGasVoiceBroadcastFieldDAO() {
		return this.gasVoiceBroadcastFieldDAO;
	}

	public MerchantProductDAO getMerchantProductDAO() {
		return this.merchantProductDAO;
	}

	public MerchantProtocolRuleDAO getMerchantProtocolRuleDAO() {
		return this.merchantProtocolRuleDAO;
	}

	public NotifyTaskDAO getNotifyTaskDAO() {
		return this.notifyTaskDAO;
	}

	public PermissionDAO getPermissionDAO() {
		return this.permissionDAO;
	}

	public ProductDAO getProductDAO() {
		return this.productDAO;
	}

	public ProductPermissionDAO getProductPermissionDAO() {
		return this.productPermissionDAO;
	}

	public RoleDAO getRoleDAO() {
		return this.roleDAO;
	}

	public RolePermissionDAO getRolePermissionDAO() {
		return this.rolePermissionDAO;
	}

	public RoleProductDAO getRoleProductDAO() {
		return this.roleProductDAO;
	}

	public SysIdGenDAO getSysIdGenDAO() {
		return this.sysIdGenDAO;
	}

	public TmpPointsGoodsMapDAO getTmpPointsGoodsMapDAO() {
		return this.tmpPointsGoodsMapDAO;
	}

	public UserUniqueKeyDAO getUserUniqueKeyDAO() {
		return this.userUniqueKeyDAO;
	}


    /**
	 * 断言gas_app_version表
	 */
	public void gasAppVersionAssert(
	        GasAppVersionDO gasAppVersionDO,
			Long id, 
			String appCode, 
			String appName, 
			Integer versionCode, 
			String versionName, 
			String storeCode, 
			String storeName, 
			String upgradeLevel, 
			String upgradeContent, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasAppVersionDO.getId());
        assertEquals(appCode, gasAppVersionDO.getAppCode());
        assertEquals(appName, gasAppVersionDO.getAppName());
        assertEquals(versionCode, gasAppVersionDO.getVersionCode());
        assertEquals(versionName, gasAppVersionDO.getVersionName());
        assertEquals(storeCode, gasAppVersionDO.getStoreCode());
        assertEquals(storeName, gasAppVersionDO.getStoreName());
        assertEquals(upgradeLevel, gasAppVersionDO.getUpgradeLevel());
        assertEquals(upgradeContent, gasAppVersionDO.getUpgradeContent());
        assertEquals(rawAddTime, gasAppVersionDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasAppVersionDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_app_version表数据
	 */
	public void assertGasAppVersion(GasAppVersionDO expect, GasAppVersionDO gasAppVersionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasAppVersionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasAppVersionDO.getRawAddTime());
		expect.setRawAddTime(gasAppVersionDO.getRawAddTime());
        Assertions.assertTrue(null != gasAppVersionDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasAppVersionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasAppVersionDO);
	}

    /**
	 * 插入gas_app_version表数据
	 */
	public void insertGasAppVersion(GasAppVersionDO gasAppVersionDO) {
		gasAppVersionDAO.insert(gasAppVersionDO);
	}

    /**
	 * 插入gas_app_version表数据
	 */
	public void insertGasAppVersion(
			Long id, 
			String appCode, 
			String appName, 
			Integer versionCode, 
			String versionName, 
			String storeCode, 
			String storeName, 
			String upgradeLevel, 
			String upgradeContent, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasAppVersionDO gasAppVersionDO = new GasAppVersionDO();
		gasAppVersionDO.setId(id);
		gasAppVersionDO.setAppCode(appCode);
		gasAppVersionDO.setAppName(appName);
		gasAppVersionDO.setVersionCode(versionCode);
		gasAppVersionDO.setVersionName(versionName);
		gasAppVersionDO.setStoreCode(storeCode);
		gasAppVersionDO.setStoreName(storeName);
		gasAppVersionDO.setUpgradeLevel(upgradeLevel);
		gasAppVersionDO.setUpgradeContent(upgradeContent);
		gasAppVersionDO.setRawAddTime(rawAddTime);
		gasAppVersionDO.setRawUpdateTime(rawUpdateTime);
		gasAppVersionDAO.insert(gasAppVersionDO);
	}

    /**
     * 删除gas_app_version表所有数据
     */
    public void cleanGasAppVersion() {
        GasAppVersionDOExample exam = new GasAppVersionDOExample();
        exam.createCriteria();
        gasAppVersionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_app_version表数据
	 */
	public void cleanGasAppVersionById(Long id) {
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasAppVersionDAO.deleteByExample(exam);
	}
	/**
	 * 根据appCode,storeCode删除gas_app_version表数据
	 */
	public void cleanGasAppVersionByAppCodeAndStoreCode(String appCode,String storeCode) {
        if (StringUtils.isBlank(appCode)){
            appCode = "test_appCode";
        }
        if (StringUtils.isBlank(storeCode)){
            storeCode = "test_storeCode";
        }
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andAppCodeEqualTo(appCode).andStoreCodeEqualTo(storeCode);
		gasAppVersionDAO.deleteByExample(exam);
	}

	/**
	* 根据appCode删除gas_app_version表数据
	*/
	public void cleanGasAppVersionByAppCode(String appCode) {
        if (StringUtils.isBlank(appCode)){
            appCode = "test_appCode";
        }
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andAppCodeEqualTo(appCode);
		gasAppVersionDAO.deleteByExample(exam);
	}

	/**
	* 根据appName删除gas_app_version表数据
	*/
	public void cleanGasAppVersionByAppName(String appName) {
        if (StringUtils.isBlank(appName)){
            appName = "test_appName";
        }
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andAppNameEqualTo(appName);
		gasAppVersionDAO.deleteByExample(exam);
	}

	/**
	* 根据versionCode删除gas_app_version表数据
	*/
	public void cleanGasAppVersionByVersionCode(Integer versionCode) {
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andVersionCodeEqualTo(versionCode);
		gasAppVersionDAO.deleteByExample(exam);
	}

	/**
	* 根据versionName删除gas_app_version表数据
	*/
	public void cleanGasAppVersionByVersionName(String versionName) {
        if (StringUtils.isBlank(versionName)){
            versionName = "test_versionName";
        }
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andVersionNameEqualTo(versionName);
		gasAppVersionDAO.deleteByExample(exam);
	}

	/**
	* 根据storeCode删除gas_app_version表数据
	*/
	public void cleanGasAppVersionByStoreCode(String storeCode) {
        if (StringUtils.isBlank(storeCode)){
            storeCode = "test_storeCode";
        }
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andStoreCodeEqualTo(storeCode);
		gasAppVersionDAO.deleteByExample(exam);
	}

	/**
	* 根据storeName删除gas_app_version表数据
	*/
	public void cleanGasAppVersionByStoreName(String storeName) {
        if (StringUtils.isBlank(storeName)){
            storeName = "test_storeName";
        }
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andStoreNameEqualTo(storeName);
		gasAppVersionDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_app_version表所有数据
     */
    public List<GasAppVersionDO> findGasAppVersionAll() {
        GasAppVersionDOExample exam = new GasAppVersionDOExample();
        exam.createCriteria();
		return gasAppVersionDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_app_version表数据
	 */
	public List<GasAppVersionDO> findGasAppVersionById(Long id) {
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasAppVersionDAO.selectByExample(exam);
	}

	/**
	 * 根据appCode,storeCode查询gas_app_version表数据
	 */
	public List<GasAppVersionDO> findGasAppVersionByAppCodeAndStoreCode(String appCode,String storeCode) {
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andAppCodeEqualTo(appCode).andStoreCodeEqualTo(storeCode);
		return gasAppVersionDAO.selectByExample(exam);
	}

	/**
	* 根据appCode查询gas_app_version表数据
	*/
	public List<GasAppVersionDO> findGasAppVersionByAppCode(String appCode) {
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andAppCodeEqualTo(appCode);
		return gasAppVersionDAO.selectByExample(exam);
	}

	/**
	* 根据appName查询gas_app_version表数据
	*/
	public List<GasAppVersionDO> findGasAppVersionByAppName(String appName) {
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andAppNameEqualTo(appName);
		return gasAppVersionDAO.selectByExample(exam);
	}

	/**
	* 根据versionCode查询gas_app_version表数据
	*/
	public List<GasAppVersionDO> findGasAppVersionByVersionCode(Integer versionCode) {
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andVersionCodeEqualTo(versionCode);
		return gasAppVersionDAO.selectByExample(exam);
	}

	/**
	* 根据versionName查询gas_app_version表数据
	*/
	public List<GasAppVersionDO> findGasAppVersionByVersionName(String versionName) {
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andVersionNameEqualTo(versionName);
		return gasAppVersionDAO.selectByExample(exam);
	}

	/**
	* 根据storeCode查询gas_app_version表数据
	*/
	public List<GasAppVersionDO> findGasAppVersionByStoreCode(String storeCode) {
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andStoreCodeEqualTo(storeCode);
		return gasAppVersionDAO.selectByExample(exam);
	}

	/**
	* 根据storeName查询gas_app_version表数据
	*/
	public List<GasAppVersionDO> findGasAppVersionByStoreName(String storeName) {
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andStoreNameEqualTo(storeName);
		return gasAppVersionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_app_version表数据
	 */
	public void updateGasAppVersionById(Long id,GasAppVersionDO gasAppVersionDO) {
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasAppVersionDAO.updateByExample(gasAppVersionDO, exam);
	}

	/**
	 * 根据appCode,storeCode更新gas_app_version表数据
	 */
	public void updateGasAppVersionByAppCodeAndStoreCode(String appCode,String storeCode,GasAppVersionDO gasAppVersionDO) {
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andAppCodeEqualTo(appCode).andStoreCodeEqualTo(storeCode);
		gasAppVersionDAO.updateByExample(gasAppVersionDO, exam);
	}

	/**
	* 根据appCode更新gas_app_version表数据
	*/
	public void updateGasAppVersionByAppCode(String appCode,GasAppVersionDO gasAppVersionDO) {
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andAppCodeEqualTo(appCode);
		gasAppVersionDAO.updateByExample(gasAppVersionDO, exam);
	}

	/**
	* 根据appName更新gas_app_version表数据
	*/
	public void updateGasAppVersionByAppName(String appName,GasAppVersionDO gasAppVersionDO) {
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andAppNameEqualTo(appName);
		gasAppVersionDAO.updateByExample(gasAppVersionDO, exam);
	}

	/**
	* 根据versionCode更新gas_app_version表数据
	*/
	public void updateGasAppVersionByVersionCode(Integer versionCode,GasAppVersionDO gasAppVersionDO) {
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andVersionCodeEqualTo(versionCode);
		gasAppVersionDAO.updateByExample(gasAppVersionDO, exam);
	}

	/**
	* 根据versionName更新gas_app_version表数据
	*/
	public void updateGasAppVersionByVersionName(String versionName,GasAppVersionDO gasAppVersionDO) {
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andVersionNameEqualTo(versionName);
		gasAppVersionDAO.updateByExample(gasAppVersionDO, exam);
	}

	/**
	* 根据storeCode更新gas_app_version表数据
	*/
	public void updateGasAppVersionByStoreCode(String storeCode,GasAppVersionDO gasAppVersionDO) {
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andStoreCodeEqualTo(storeCode);
		gasAppVersionDAO.updateByExample(gasAppVersionDO, exam);
	}

	/**
	* 根据storeName更新gas_app_version表数据
	*/
	public void updateGasAppVersionByStoreName(String storeName,GasAppVersionDO gasAppVersionDO) {
		GasAppVersionDOExample exam = new GasAppVersionDOExample();
		exam.createCriteria().andStoreNameEqualTo(storeName);
		gasAppVersionDAO.updateByExample(gasAppVersionDO, exam);
	}

    /**
	 * 断言gas_city表
	 */
	public void gasCityAssert(
	        GasCityDO gasCityDO,
			Long id, 
			String cityName, 
			String cityChar, 
			Long provinceId
	) {
        assertEquals(id, gasCityDO.getId());
        assertEquals(cityName, gasCityDO.getCityName());
        assertEquals(cityChar, gasCityDO.getCityChar());
        assertEquals(provinceId, gasCityDO.getProvinceId());
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
			Long id, 
			String cityName, 
			String cityChar, 
			Long provinceId
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
	public void cleanGasCityById(Long id) {
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
	public void cleanGasCityByProvinceId(Long provinceId) {
		GasCityDOExample exam = new GasCityDOExample();
		exam.createCriteria().andProvinceIdEqualTo(provinceId);
		gasCityDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_city表所有数据
     */
    public List<GasCityDO> findGasCityAll() {
        GasCityDOExample exam = new GasCityDOExample();
        exam.createCriteria();
		return gasCityDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_city表数据
	 */
	public List<GasCityDO> findGasCityById(Long id) {
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
	public List<GasCityDO> findGasCityByProvinceId(Long provinceId) {
		GasCityDOExample exam = new GasCityDOExample();
		exam.createCriteria().andProvinceIdEqualTo(provinceId);
		return gasCityDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_city表数据
	 */
	public void updateGasCityById(Long id,GasCityDO gasCityDO) {
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
	public void updateGasCityByProvinceId(Long provinceId,GasCityDO gasCityDO) {
		GasCityDOExample exam = new GasCityDOExample();
		exam.createCriteria().andProvinceIdEqualTo(provinceId);
		gasCityDAO.updateByExample(gasCityDO, exam);
	}

    /**
	 * 断言gas_device_print表
	 */
	public void gasDevicePrintAssert(
	        GasDevicePrintDO gasDevicePrintDO,
			Long id, 
			String printId, 
			String partnerId, 
			String platPartnerId, 
			String stationId, 
			String deviceType, 
			String printType, 
			String printTitle, 
			Integer printSleep, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasDevicePrintDO.getId());
        assertEquals(printId, gasDevicePrintDO.getPrintId());
        assertEquals(partnerId, gasDevicePrintDO.getPartnerId());
        assertEquals(platPartnerId, gasDevicePrintDO.getPlatPartnerId());
        assertEquals(stationId, gasDevicePrintDO.getStationId());
        assertEquals(deviceType, gasDevicePrintDO.getDeviceType());
        assertEquals(printType, gasDevicePrintDO.getPrintType());
        assertEquals(printTitle, gasDevicePrintDO.getPrintTitle());
        assertEquals(printSleep, gasDevicePrintDO.getPrintSleep());
        assertEquals(rawAddTime, gasDevicePrintDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasDevicePrintDO.getRawUpdateTime());
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
			Long id, 
			String printId, 
			String partnerId, 
			String platPartnerId, 
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
		gasDevicePrintDO.setPlatPartnerId(platPartnerId);
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
	public void cleanGasDevicePrintById(Long id) {
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
	 * 根据platPartnerId删除gas_device_print表数据
	 */
	public void cleanGasDevicePrintByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
     * 查询gas_device_print表所有数据
     */
    public List<GasDevicePrintDO> findGasDevicePrintAll() {
        GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
        exam.createCriteria();
		return gasDevicePrintDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_device_print表数据
	 */
	public List<GasDevicePrintDO> findGasDevicePrintById(Long id) {
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
	 * 根据platPartnerId查询gas_device_print表数据
	 */
	public List<GasDevicePrintDO> findGasDevicePrintByPlatPartnerId(String platPartnerId) {
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	public void updateGasDevicePrintById(Long id,GasDevicePrintDO gasDevicePrintDO) {
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
	 * 根据platPartnerId更新gas_device_print表数据
	 */
	public void updateGasDevicePrintByPlatPartnerId(String platPartnerId,GasDevicePrintDO gasDevicePrintDO) {
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	 * 断言gas_device_resource表
	 */
	public void gasDeviceResourceAssert(
	        GasDeviceResourceDO gasDeviceResourceDO,
			Long id, 
			String deviceType, 
			Long parentId, 
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
        assertEquals(id, gasDeviceResourceDO.getId());
        assertEquals(deviceType, gasDeviceResourceDO.getDeviceType());
        assertEquals(parentId, gasDeviceResourceDO.getParentId());
        assertEquals(name, gasDeviceResourceDO.getName());
        assertEquals(code, gasDeviceResourceDO.getCode());
        assertEquals(url, gasDeviceResourceDO.getUrl());
        assertEquals(resourceType, gasDeviceResourceDO.getResourceType());
        assertEquals(orderNo, gasDeviceResourceDO.getOrderNo());
        assertEquals(icon, gasDeviceResourceDO.getIcon());
        assertEquals(memo, gasDeviceResourceDO.getMemo());
        assertEquals(rawAddTime, gasDeviceResourceDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasDeviceResourceDO.getRawUpdateTime());
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
			Long id, 
			String deviceType, 
			Long parentId, 
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
	public void cleanGasDeviceResourceById(Long id) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasDeviceResourceDAO.deleteByExample(exam);
	}

	/**
	 * 根据parentId删除gas_device_resource表数据
	 */
	public void cleanGasDeviceResourceByParentId(Long parentId) {
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
     * 查询gas_device_resource表所有数据
     */
    public List<GasDeviceResourceDO> findGasDeviceResourceAll() {
        GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
        exam.createCriteria();
		return gasDeviceResourceDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_device_resource表数据
	 */
	public List<GasDeviceResourceDO> findGasDeviceResourceById(Long id) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasDeviceResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据parentId查询gas_device_resource表数据
	 */
	public List<GasDeviceResourceDO> findGasDeviceResourceByParentId(Long parentId) {
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
	public void updateGasDeviceResourceById(Long id,GasDeviceResourceDO gasDeviceResourceDO) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasDeviceResourceDAO.updateByExample(gasDeviceResourceDO, exam);
	}

    /**
	 * 根据parentId更新gas_device_resource表数据
	 */
	public void updateGasDeviceResourceByParentId(Long parentId,GasDeviceResourceDO gasDeviceResourceDO) {
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
	 * 断言gas_dict_data表
	 */
	public void gasDictDataAssert(
	        GasDictDataDO gasDictDataDO,
			Long id, 
			String typeCode, 
			String dataCode, 
			String dataName, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasDictDataDO.getId());
        assertEquals(typeCode, gasDictDataDO.getTypeCode());
        assertEquals(dataCode, gasDictDataDO.getDataCode());
        assertEquals(dataName, gasDictDataDO.getDataName());
        assertEquals(rawAddTime, gasDictDataDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasDictDataDO.getRawUpdateTime());
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
			Long id, 
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
	public void cleanGasDictDataById(Long id) {
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
     * 查询gas_dict_data表所有数据
     */
    public List<GasDictDataDO> findGasDictDataAll() {
        GasDictDataDOExample exam = new GasDictDataDOExample();
        exam.createCriteria();
		return gasDictDataDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_dict_data表数据
	 */
	public List<GasDictDataDO> findGasDictDataById(Long id) {
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
	public void updateGasDictDataById(Long id,GasDictDataDO gasDictDataDO) {
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
	 * 断言gas_dict_type表
	 */
	public void gasDictTypeAssert(
	        GasDictTypeDO gasDictTypeDO,
			Long id, 
			String typeCode, 
			String typeName, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasDictTypeDO.getId());
        assertEquals(typeCode, gasDictTypeDO.getTypeCode());
        assertEquals(typeName, gasDictTypeDO.getTypeName());
        assertEquals(memo, gasDictTypeDO.getMemo());
        assertEquals(rawAddTime, gasDictTypeDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasDictTypeDO.getRawUpdateTime());
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
			Long id, 
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
	public void cleanGasDictTypeById(Long id) {
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
     * 查询gas_dict_type表所有数据
     */
    public List<GasDictTypeDO> findGasDictTypeAll() {
        GasDictTypeDOExample exam = new GasDictTypeDOExample();
        exam.createCriteria();
		return gasDictTypeDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_dict_type表数据
	 */
	public List<GasDictTypeDO> findGasDictTypeById(Long id) {
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
	public void updateGasDictTypeById(Long id,GasDictTypeDO gasDictTypeDO) {
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
	 * 断言gas_district表
	 */
	public void gasDistrictAssert(
	        GasDistrictDO gasDistrictDO,
			Long id, 
			String districtName, 
			String districtChar, 
			Long cityId
	) {
        assertEquals(id, gasDistrictDO.getId());
        assertEquals(districtName, gasDistrictDO.getDistrictName());
        assertEquals(districtChar, gasDistrictDO.getDistrictChar());
        assertEquals(cityId, gasDistrictDO.getCityId());
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
			Long id, 
			String districtName, 
			String districtChar, 
			Long cityId
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
	public void cleanGasDistrictById(Long id) {
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
	public void cleanGasDistrictByCityId(Long cityId) {
		GasDistrictDOExample exam = new GasDistrictDOExample();
		exam.createCriteria().andCityIdEqualTo(cityId);
		gasDistrictDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_district表所有数据
     */
    public List<GasDistrictDO> findGasDistrictAll() {
        GasDistrictDOExample exam = new GasDistrictDOExample();
        exam.createCriteria();
		return gasDistrictDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_district表数据
	 */
	public List<GasDistrictDO> findGasDistrictById(Long id) {
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
	public List<GasDistrictDO> findGasDistrictByCityId(Long cityId) {
		GasDistrictDOExample exam = new GasDistrictDOExample();
		exam.createCriteria().andCityIdEqualTo(cityId);
		return gasDistrictDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_district表数据
	 */
	public void updateGasDistrictById(Long id,GasDistrictDO gasDistrictDO) {
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
	public void updateGasDistrictByCityId(Long cityId,GasDistrictDO gasDistrictDO) {
		GasDistrictDOExample exam = new GasDistrictDOExample();
		exam.createCriteria().andCityIdEqualTo(cityId);
		gasDistrictDAO.updateByExample(gasDistrictDO, exam);
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
			Double taxGoodsRate, 
			String taxGoodsCode, 
			String taxGoodsName, 
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
        assertEquals(taxGoodsRate, gasGoodsDO.getTaxGoodsRate());
        assertEquals(taxGoodsCode, gasGoodsDO.getTaxGoodsCode());
        assertEquals(taxGoodsName, gasGoodsDO.getTaxGoodsName());
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
			Double taxGoodsRate, 
			String taxGoodsCode, 
			String taxGoodsName, 
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
		gasGoodsDO.setTaxGoodsRate(taxGoodsRate);
		gasGoodsDO.setTaxGoodsCode(taxGoodsCode);
		gasGoodsDO.setTaxGoodsName(taxGoodsName);
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
	* 根据taxGoodsCode删除gas_goods表数据
	*/
	public void cleanGasGoodsByTaxGoodsCode(String taxGoodsCode) {
        if (StringUtils.isBlank(taxGoodsCode)){
            taxGoodsCode = "test_taxGoodsCode";
        }
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andTaxGoodsCodeEqualTo(taxGoodsCode);
		gasGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据taxGoodsName删除gas_goods表数据
	*/
	public void cleanGasGoodsByTaxGoodsName(String taxGoodsName) {
        if (StringUtils.isBlank(taxGoodsName)){
            taxGoodsName = "test_taxGoodsName";
        }
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andTaxGoodsNameEqualTo(taxGoodsName);
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
	* 根据taxGoodsCode查询gas_goods表数据
	*/
	public List<GasGoodsDO> findGasGoodsByTaxGoodsCode(String taxGoodsCode) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andTaxGoodsCodeEqualTo(taxGoodsCode);
		return gasGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据taxGoodsName查询gas_goods表数据
	*/
	public List<GasGoodsDO> findGasGoodsByTaxGoodsName(String taxGoodsName) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andTaxGoodsNameEqualTo(taxGoodsName);
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
	* 根据taxGoodsCode更新gas_goods表数据
	*/
	public void updateGasGoodsByTaxGoodsCode(String taxGoodsCode,GasGoodsDO gasGoodsDO) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andTaxGoodsCodeEqualTo(taxGoodsCode);
		gasGoodsDAO.updateByExample(gasGoodsDO, exam);
	}

	/**
	* 根据taxGoodsName更新gas_goods表数据
	*/
	public void updateGasGoodsByTaxGoodsName(String taxGoodsName,GasGoodsDO gasGoodsDO) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andTaxGoodsNameEqualTo(taxGoodsName);
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
	 * 断言gas_invoice_company表
	 */
	public void gasInvoiceCompanyAssert(
	        GasInvoiceCompanyDO gasInvoiceCompanyDO,
			Long id, 
			String platPartnerId, 
			String stationId, 
			String taxCompany, 
			String taxCode, 
			String taxAddress, 
			String taxMobile, 
			String taxDrawer, 
			String taxBankNo, 
			String taxReviewer, 
			String taxPayee, 
			String taxAppId, 
			String taxKey, 
			String taxCertPath, 
			String taxCertPwd, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasInvoiceCompanyDO.getId());
        assertEquals(platPartnerId, gasInvoiceCompanyDO.getPlatPartnerId());
        assertEquals(stationId, gasInvoiceCompanyDO.getStationId());
        assertEquals(taxCompany, gasInvoiceCompanyDO.getTaxCompany());
        assertEquals(taxCode, gasInvoiceCompanyDO.getTaxCode());
        assertEquals(taxAddress, gasInvoiceCompanyDO.getTaxAddress());
        assertEquals(taxMobile, gasInvoiceCompanyDO.getTaxMobile());
        assertEquals(taxDrawer, gasInvoiceCompanyDO.getTaxDrawer());
        assertEquals(taxBankNo, gasInvoiceCompanyDO.getTaxBankNo());
        assertEquals(taxReviewer, gasInvoiceCompanyDO.getTaxReviewer());
        assertEquals(taxPayee, gasInvoiceCompanyDO.getTaxPayee());
        assertEquals(taxAppId, gasInvoiceCompanyDO.getTaxAppId());
        assertEquals(taxKey, gasInvoiceCompanyDO.getTaxKey());
        assertEquals(taxCertPath, gasInvoiceCompanyDO.getTaxCertPath());
        assertEquals(taxCertPwd, gasInvoiceCompanyDO.getTaxCertPwd());
        assertEquals(rawAddTime, gasInvoiceCompanyDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasInvoiceCompanyDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_invoice_company表数据
	 */
	public void assertGasInvoiceCompany(GasInvoiceCompanyDO expect, GasInvoiceCompanyDO gasInvoiceCompanyDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasInvoiceCompanyDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasInvoiceCompanyDO.getRawAddTime());
		expect.setRawAddTime(gasInvoiceCompanyDO.getRawAddTime());
        Assertions.assertTrue(null != gasInvoiceCompanyDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasInvoiceCompanyDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasInvoiceCompanyDO);
	}

    /**
	 * 插入gas_invoice_company表数据
	 */
	public void insertGasInvoiceCompany(GasInvoiceCompanyDO gasInvoiceCompanyDO) {
		gasInvoiceCompanyDAO.insert(gasInvoiceCompanyDO);
	}

    /**
	 * 插入gas_invoice_company表数据
	 */
	public void insertGasInvoiceCompany(
			Long id, 
			String platPartnerId, 
			String stationId, 
			String taxCompany, 
			String taxCode, 
			String taxAddress, 
			String taxMobile, 
			String taxDrawer, 
			String taxBankNo, 
			String taxReviewer, 
			String taxPayee, 
			String taxAppId, 
			String taxKey, 
			String taxCertPath, 
			String taxCertPwd, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasInvoiceCompanyDO gasInvoiceCompanyDO = new GasInvoiceCompanyDO();
		gasInvoiceCompanyDO.setId(id);
		gasInvoiceCompanyDO.setPlatPartnerId(platPartnerId);
		gasInvoiceCompanyDO.setStationId(stationId);
		gasInvoiceCompanyDO.setTaxCompany(taxCompany);
		gasInvoiceCompanyDO.setTaxCode(taxCode);
		gasInvoiceCompanyDO.setTaxAddress(taxAddress);
		gasInvoiceCompanyDO.setTaxMobile(taxMobile);
		gasInvoiceCompanyDO.setTaxDrawer(taxDrawer);
		gasInvoiceCompanyDO.setTaxBankNo(taxBankNo);
		gasInvoiceCompanyDO.setTaxReviewer(taxReviewer);
		gasInvoiceCompanyDO.setTaxPayee(taxPayee);
		gasInvoiceCompanyDO.setTaxAppId(taxAppId);
		gasInvoiceCompanyDO.setTaxKey(taxKey);
		gasInvoiceCompanyDO.setTaxCertPath(taxCertPath);
		gasInvoiceCompanyDO.setTaxCertPwd(taxCertPwd);
		gasInvoiceCompanyDO.setRawAddTime(rawAddTime);
		gasInvoiceCompanyDO.setRawUpdateTime(rawUpdateTime);
		gasInvoiceCompanyDAO.insert(gasInvoiceCompanyDO);
	}

    /**
     * 删除gas_invoice_company表所有数据
     */
    public void cleanGasInvoiceCompany() {
        GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
        exam.createCriteria();
        gasInvoiceCompanyDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_invoice_company表数据
	 */
	public void cleanGasInvoiceCompanyById(Long id) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasInvoiceCompanyDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_invoice_company表数据
	 */
	public void cleanGasInvoiceCompanyByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasInvoiceCompanyDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_invoice_company表数据
	 */
	public void cleanGasInvoiceCompanyByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasInvoiceCompanyDAO.deleteByExample(exam);
	}

	/**
	* 根据taxCode删除gas_invoice_company表数据
	*/
	public void cleanGasInvoiceCompanyByTaxCode(String taxCode) {
        if (StringUtils.isBlank(taxCode)){
            taxCode = "test_taxCode";
        }
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andTaxCodeEqualTo(taxCode);
		gasInvoiceCompanyDAO.deleteByExample(exam);
	}

	/**
	 * 根据taxBankNo删除gas_invoice_company表数据
	 */
	public void cleanGasInvoiceCompanyByTaxBankNo(String taxBankNo) {
        if (StringUtils.isBlank(taxBankNo)){
            taxBankNo = "test_taxBankNo";
        }
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andTaxBankNoEqualTo(taxBankNo);
		gasInvoiceCompanyDAO.deleteByExample(exam);
	}

	/**
	 * 根据taxAppId删除gas_invoice_company表数据
	 */
	public void cleanGasInvoiceCompanyByTaxAppId(String taxAppId) {
        if (StringUtils.isBlank(taxAppId)){
            taxAppId = "test_taxAppId";
        }
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andTaxAppIdEqualTo(taxAppId);
		gasInvoiceCompanyDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_invoice_company表所有数据
     */
    public List<GasInvoiceCompanyDO> findGasInvoiceCompanyAll() {
        GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
        exam.createCriteria();
		return gasInvoiceCompanyDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_invoice_company表数据
	 */
	public List<GasInvoiceCompanyDO> findGasInvoiceCompanyById(Long id) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasInvoiceCompanyDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_invoice_company表数据
	 */
	public List<GasInvoiceCompanyDO> findGasInvoiceCompanyByPlatPartnerId(String platPartnerId) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasInvoiceCompanyDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_invoice_company表数据
	 */
	public List<GasInvoiceCompanyDO> findGasInvoiceCompanyByStationId(String stationId) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasInvoiceCompanyDAO.selectByExample(exam);
	}

	/**
	* 根据taxCode查询gas_invoice_company表数据
	*/
	public List<GasInvoiceCompanyDO> findGasInvoiceCompanyByTaxCode(String taxCode) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andTaxCodeEqualTo(taxCode);
		return gasInvoiceCompanyDAO.selectByExample(exam);
	}

    /**
	 * 根据taxBankNo查询gas_invoice_company表数据
	 */
	public List<GasInvoiceCompanyDO> findGasInvoiceCompanyByTaxBankNo(String taxBankNo) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andTaxBankNoEqualTo(taxBankNo);
		return gasInvoiceCompanyDAO.selectByExample(exam);
	}

    /**
	 * 根据taxAppId查询gas_invoice_company表数据
	 */
	public List<GasInvoiceCompanyDO> findGasInvoiceCompanyByTaxAppId(String taxAppId) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andTaxAppIdEqualTo(taxAppId);
		return gasInvoiceCompanyDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_invoice_company表数据
	 */
	public void updateGasInvoiceCompanyById(Long id,GasInvoiceCompanyDO gasInvoiceCompanyDO) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasInvoiceCompanyDAO.updateByExample(gasInvoiceCompanyDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_invoice_company表数据
	 */
	public void updateGasInvoiceCompanyByPlatPartnerId(String platPartnerId,GasInvoiceCompanyDO gasInvoiceCompanyDO) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasInvoiceCompanyDAO.updateByExample(gasInvoiceCompanyDO, exam);
	}

    /**
	 * 根据stationId更新gas_invoice_company表数据
	 */
	public void updateGasInvoiceCompanyByStationId(String stationId,GasInvoiceCompanyDO gasInvoiceCompanyDO) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasInvoiceCompanyDAO.updateByExample(gasInvoiceCompanyDO, exam);
	}

	/**
	* 根据taxCode更新gas_invoice_company表数据
	*/
	public void updateGasInvoiceCompanyByTaxCode(String taxCode,GasInvoiceCompanyDO gasInvoiceCompanyDO) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andTaxCodeEqualTo(taxCode);
		gasInvoiceCompanyDAO.updateByExample(gasInvoiceCompanyDO, exam);
	}

    /**
	 * 根据taxBankNo更新gas_invoice_company表数据
	 */
	public void updateGasInvoiceCompanyByTaxBankNo(String taxBankNo,GasInvoiceCompanyDO gasInvoiceCompanyDO) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andTaxBankNoEqualTo(taxBankNo);
		gasInvoiceCompanyDAO.updateByExample(gasInvoiceCompanyDO, exam);
	}

    /**
	 * 根据taxAppId更新gas_invoice_company表数据
	 */
	public void updateGasInvoiceCompanyByTaxAppId(String taxAppId,GasInvoiceCompanyDO gasInvoiceCompanyDO) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andTaxAppIdEqualTo(taxAppId);
		gasInvoiceCompanyDAO.updateByExample(gasInvoiceCompanyDO, exam);
	}

    /**
	 * 断言gas_invoice_config表
	 */
	public void gasInvoiceConfigAssert(
	        GasInvoiceConfigDO gasInvoiceConfigDO,
			Long id, 
			String platPartnerId, 
			Long expireTime, 
			Long minInvoiceAmount, 
			String remark, 
			String invoiceOils, 
			String invoicePayway, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasInvoiceConfigDO.getId());
        assertEquals(platPartnerId, gasInvoiceConfigDO.getPlatPartnerId());
        assertEquals(expireTime, gasInvoiceConfigDO.getExpireTime());
        assertEquals(minInvoiceAmount, gasInvoiceConfigDO.getMinInvoiceAmount());
        assertEquals(remark, gasInvoiceConfigDO.getRemark());
        assertEquals(invoiceOils, gasInvoiceConfigDO.getInvoiceOils());
        assertEquals(invoicePayway, gasInvoiceConfigDO.getInvoicePayway());
        assertEquals(rawAddTime, gasInvoiceConfigDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasInvoiceConfigDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_invoice_config表数据
	 */
	public void assertGasInvoiceConfig(GasInvoiceConfigDO expect, GasInvoiceConfigDO gasInvoiceConfigDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasInvoiceConfigDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasInvoiceConfigDO.getRawAddTime());
		expect.setRawAddTime(gasInvoiceConfigDO.getRawAddTime());
        Assertions.assertTrue(null != gasInvoiceConfigDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasInvoiceConfigDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasInvoiceConfigDO);
	}

    /**
	 * 插入gas_invoice_config表数据
	 */
	public void insertGasInvoiceConfig(GasInvoiceConfigDO gasInvoiceConfigDO) {
		gasInvoiceConfigDAO.insert(gasInvoiceConfigDO);
	}

    /**
	 * 插入gas_invoice_config表数据
	 */
	public void insertGasInvoiceConfig(
			Long id, 
			String platPartnerId, 
			Long expireTime, 
			Long minInvoiceAmount, 
			String remark, 
			String invoiceOils, 
			String invoicePayway, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasInvoiceConfigDO gasInvoiceConfigDO = new GasInvoiceConfigDO();
		gasInvoiceConfigDO.setId(id);
		gasInvoiceConfigDO.setPlatPartnerId(platPartnerId);
		gasInvoiceConfigDO.setExpireTime(expireTime);
		gasInvoiceConfigDO.setMinInvoiceAmount(minInvoiceAmount);
		gasInvoiceConfigDO.setRemark(remark);
		gasInvoiceConfigDO.setInvoiceOils(invoiceOils);
		gasInvoiceConfigDO.setInvoicePayway(invoicePayway);
		gasInvoiceConfigDO.setRawAddTime(rawAddTime);
		gasInvoiceConfigDO.setRawUpdateTime(rawUpdateTime);
		gasInvoiceConfigDAO.insert(gasInvoiceConfigDO);
	}

    /**
     * 删除gas_invoice_config表所有数据
     */
    public void cleanGasInvoiceConfig() {
        GasInvoiceConfigDOExample exam = new GasInvoiceConfigDOExample();
        exam.createCriteria();
        gasInvoiceConfigDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_invoice_config表数据
	 */
	public void cleanGasInvoiceConfigById(Long id) {
		GasInvoiceConfigDOExample exam = new GasInvoiceConfigDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasInvoiceConfigDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_invoice_config表数据
	 */
	public void cleanGasInvoiceConfigByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasInvoiceConfigDOExample exam = new GasInvoiceConfigDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasInvoiceConfigDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_invoice_config表所有数据
     */
    public List<GasInvoiceConfigDO> findGasInvoiceConfigAll() {
        GasInvoiceConfigDOExample exam = new GasInvoiceConfigDOExample();
        exam.createCriteria();
		return gasInvoiceConfigDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_invoice_config表数据
	 */
	public List<GasInvoiceConfigDO> findGasInvoiceConfigById(Long id) {
		GasInvoiceConfigDOExample exam = new GasInvoiceConfigDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasInvoiceConfigDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_invoice_config表数据
	 */
	public List<GasInvoiceConfigDO> findGasInvoiceConfigByPlatPartnerId(String platPartnerId) {
		GasInvoiceConfigDOExample exam = new GasInvoiceConfigDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasInvoiceConfigDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_invoice_config表数据
	 */
	public void updateGasInvoiceConfigById(Long id,GasInvoiceConfigDO gasInvoiceConfigDO) {
		GasInvoiceConfigDOExample exam = new GasInvoiceConfigDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasInvoiceConfigDAO.updateByExample(gasInvoiceConfigDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_invoice_config表数据
	 */
	public void updateGasInvoiceConfigByPlatPartnerId(String platPartnerId,GasInvoiceConfigDO gasInvoiceConfigDO) {
		GasInvoiceConfigDOExample exam = new GasInvoiceConfigDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasInvoiceConfigDAO.updateByExample(gasInvoiceConfigDO, exam);
	}

    /**
	 * 断言gas_login_log_copy表
	 */
	public void gasLoginLogCopyAssert(
	        GasLoginLogCopyDO gasLoginLogCopyDO,
			Long id, 
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
        assertEquals(id, gasLoginLogCopyDO.getId());
        assertEquals(deviceType, gasLoginLogCopyDO.getDeviceType());
        assertEquals(userId, gasLoginLogCopyDO.getUserId());
        assertEquals(account, gasLoginLogCopyDO.getAccount());
        assertEquals(partnerId, gasLoginLogCopyDO.getPartnerId());
        assertEquals(partnerName, gasLoginLogCopyDO.getPartnerName());
        assertEquals(stationId, gasLoginLogCopyDO.getStationId());
        assertEquals(stationName, gasLoginLogCopyDO.getStationName());
        assertEquals(userName, gasLoginLogCopyDO.getUserName());
        assertEquals(deviceCode, gasLoginLogCopyDO.getDeviceCode());
        assertEquals(loginTime, gasLoginLogCopyDO.getLoginTime());
        assertEquals(logoutTime, gasLoginLogCopyDO.getLogoutTime());
        assertEquals(rawAddTime, gasLoginLogCopyDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasLoginLogCopyDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_login_log_copy表数据
	 */
	public void assertGasLoginLogCopy(GasLoginLogCopyDO expect, GasLoginLogCopyDO gasLoginLogCopyDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasLoginLogCopyDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasLoginLogCopyDO.getRawAddTime());
		expect.setRawAddTime(gasLoginLogCopyDO.getRawAddTime());
        Assertions.assertTrue(null != gasLoginLogCopyDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasLoginLogCopyDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasLoginLogCopyDO);
	}

    /**
	 * 插入gas_login_log_copy表数据
	 */
	public void insertGasLoginLogCopy(GasLoginLogCopyDO gasLoginLogCopyDO) {
		gasLoginLogCopyDAO.insert(gasLoginLogCopyDO);
	}

    /**
	 * 插入gas_login_log_copy表数据
	 */
	public void insertGasLoginLogCopy(
			Long id, 
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
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasLoginLogCopyDO gasLoginLogCopyDO = new GasLoginLogCopyDO();
		gasLoginLogCopyDO.setId(id);
		gasLoginLogCopyDO.setDeviceType(deviceType);
		gasLoginLogCopyDO.setUserId(userId);
		gasLoginLogCopyDO.setAccount(account);
		gasLoginLogCopyDO.setPartnerId(partnerId);
		gasLoginLogCopyDO.setPartnerName(partnerName);
		gasLoginLogCopyDO.setStationId(stationId);
		gasLoginLogCopyDO.setStationName(stationName);
		gasLoginLogCopyDO.setUserName(userName);
		gasLoginLogCopyDO.setDeviceCode(deviceCode);
		gasLoginLogCopyDO.setLoginTime(loginTime);
		gasLoginLogCopyDO.setLogoutTime(logoutTime);
		gasLoginLogCopyDO.setRawAddTime(rawAddTime);
		gasLoginLogCopyDO.setRawUpdateTime(rawUpdateTime);
		gasLoginLogCopyDAO.insert(gasLoginLogCopyDO);
	}

    /**
     * 删除gas_login_log_copy表所有数据
     */
    public void cleanGasLoginLogCopy() {
        GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
        exam.createCriteria();
        gasLoginLogCopyDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_login_log_copy表数据
	 */
	public void cleanGasLoginLogCopyById(Long id) {
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasLoginLogCopyDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_login_log_copy表数据
	 */
	public void cleanGasLoginLogCopyByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasLoginLogCopyDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_login_log_copy表数据
	 */
	public void cleanGasLoginLogCopyByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasLoginLogCopyDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除gas_login_log_copy表数据
	*/
	public void cleanGasLoginLogCopyByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasLoginLogCopyDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_login_log_copy表数据
	 */
	public void cleanGasLoginLogCopyByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasLoginLogCopyDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除gas_login_log_copy表数据
	*/
	public void cleanGasLoginLogCopyByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasLoginLogCopyDAO.deleteByExample(exam);
	}

	/**
	* 根据userName删除gas_login_log_copy表数据
	*/
	public void cleanGasLoginLogCopyByUserName(String userName) {
        if (StringUtils.isBlank(userName)){
            userName = "test_userName";
        }
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		gasLoginLogCopyDAO.deleteByExample(exam);
	}

	/**
	* 根据deviceCode删除gas_login_log_copy表数据
	*/
	public void cleanGasLoginLogCopyByDeviceCode(String deviceCode) {
        if (StringUtils.isBlank(deviceCode)){
            deviceCode = "test_deviceCode";
        }
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		gasLoginLogCopyDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_login_log_copy表所有数据
     */
    public List<GasLoginLogCopyDO> findGasLoginLogCopyAll() {
        GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
        exam.createCriteria();
		return gasLoginLogCopyDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_login_log_copy表数据
	 */
	public List<GasLoginLogCopyDO> findGasLoginLogCopyById(Long id) {
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasLoginLogCopyDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_login_log_copy表数据
	 */
	public List<GasLoginLogCopyDO> findGasLoginLogCopyByUserId(String userId) {
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasLoginLogCopyDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_login_log_copy表数据
	 */
	public List<GasLoginLogCopyDO> findGasLoginLogCopyByPartnerId(String partnerId) {
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasLoginLogCopyDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询gas_login_log_copy表数据
	*/
	public List<GasLoginLogCopyDO> findGasLoginLogCopyByPartnerName(String partnerName) {
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return gasLoginLogCopyDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_login_log_copy表数据
	 */
	public List<GasLoginLogCopyDO> findGasLoginLogCopyByStationId(String stationId) {
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasLoginLogCopyDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询gas_login_log_copy表数据
	*/
	public List<GasLoginLogCopyDO> findGasLoginLogCopyByStationName(String stationName) {
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return gasLoginLogCopyDAO.selectByExample(exam);
	}

	/**
	* 根据userName查询gas_login_log_copy表数据
	*/
	public List<GasLoginLogCopyDO> findGasLoginLogCopyByUserName(String userName) {
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		return gasLoginLogCopyDAO.selectByExample(exam);
	}

	/**
	* 根据deviceCode查询gas_login_log_copy表数据
	*/
	public List<GasLoginLogCopyDO> findGasLoginLogCopyByDeviceCode(String deviceCode) {
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		return gasLoginLogCopyDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_login_log_copy表数据
	 */
	public void updateGasLoginLogCopyById(Long id,GasLoginLogCopyDO gasLoginLogCopyDO) {
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasLoginLogCopyDAO.updateByExample(gasLoginLogCopyDO, exam);
	}

    /**
	 * 根据userId更新gas_login_log_copy表数据
	 */
	public void updateGasLoginLogCopyByUserId(String userId,GasLoginLogCopyDO gasLoginLogCopyDO) {
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasLoginLogCopyDAO.updateByExample(gasLoginLogCopyDO, exam);
	}

    /**
	 * 根据partnerId更新gas_login_log_copy表数据
	 */
	public void updateGasLoginLogCopyByPartnerId(String partnerId,GasLoginLogCopyDO gasLoginLogCopyDO) {
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasLoginLogCopyDAO.updateByExample(gasLoginLogCopyDO, exam);
	}

	/**
	* 根据partnerName更新gas_login_log_copy表数据
	*/
	public void updateGasLoginLogCopyByPartnerName(String partnerName,GasLoginLogCopyDO gasLoginLogCopyDO) {
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasLoginLogCopyDAO.updateByExample(gasLoginLogCopyDO, exam);
	}

    /**
	 * 根据stationId更新gas_login_log_copy表数据
	 */
	public void updateGasLoginLogCopyByStationId(String stationId,GasLoginLogCopyDO gasLoginLogCopyDO) {
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasLoginLogCopyDAO.updateByExample(gasLoginLogCopyDO, exam);
	}

	/**
	* 根据stationName更新gas_login_log_copy表数据
	*/
	public void updateGasLoginLogCopyByStationName(String stationName,GasLoginLogCopyDO gasLoginLogCopyDO) {
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasLoginLogCopyDAO.updateByExample(gasLoginLogCopyDO, exam);
	}

	/**
	* 根据userName更新gas_login_log_copy表数据
	*/
	public void updateGasLoginLogCopyByUserName(String userName,GasLoginLogCopyDO gasLoginLogCopyDO) {
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		gasLoginLogCopyDAO.updateByExample(gasLoginLogCopyDO, exam);
	}

	/**
	* 根据deviceCode更新gas_login_log_copy表数据
	*/
	public void updateGasLoginLogCopyByDeviceCode(String deviceCode,GasLoginLogCopyDO gasLoginLogCopyDO) {
		GasLoginLogCopyDOExample exam = new GasLoginLogCopyDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		gasLoginLogCopyDAO.updateByExample(gasLoginLogCopyDO, exam);
	}

    /**
	 * 断言gas_login_log表
	 */
	public void gasLoginLogAssert(
	        GasLoginLogDO gasLoginLogDO,
			Long id, 
			String deviceType, 
			String userId, 
			String account, 
			String partnerId, 
			String platPartnerId, 
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
        assertEquals(id, gasLoginLogDO.getId());
        assertEquals(deviceType, gasLoginLogDO.getDeviceType());
        assertEquals(userId, gasLoginLogDO.getUserId());
        assertEquals(account, gasLoginLogDO.getAccount());
        assertEquals(partnerId, gasLoginLogDO.getPartnerId());
        assertEquals(platPartnerId, gasLoginLogDO.getPlatPartnerId());
        assertEquals(partnerName, gasLoginLogDO.getPartnerName());
        assertEquals(stationId, gasLoginLogDO.getStationId());
        assertEquals(stationName, gasLoginLogDO.getStationName());
        assertEquals(userName, gasLoginLogDO.getUserName());
        assertEquals(deviceCode, gasLoginLogDO.getDeviceCode());
        assertEquals(loginTime, gasLoginLogDO.getLoginTime());
        assertEquals(logoutTime, gasLoginLogDO.getLogoutTime());
        assertEquals(rawAddTime, gasLoginLogDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasLoginLogDO.getRawUpdateTime());
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
			Long id, 
			String deviceType, 
			String userId, 
			String account, 
			String partnerId, 
			String platPartnerId, 
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
		gasLoginLogDO.setPlatPartnerId(platPartnerId);
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
	public void cleanGasLoginLogById(Long id) {
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
	 * 根据platPartnerId删除gas_login_log表数据
	 */
	public void cleanGasLoginLogByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
     * 查询gas_login_log表所有数据
     */
    public List<GasLoginLogDO> findGasLoginLogAll() {
        GasLoginLogDOExample exam = new GasLoginLogDOExample();
        exam.createCriteria();
		return gasLoginLogDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_login_log表数据
	 */
	public List<GasLoginLogDO> findGasLoginLogById(Long id) {
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
	 * 根据platPartnerId查询gas_login_log表数据
	 */
	public List<GasLoginLogDO> findGasLoginLogByPlatPartnerId(String platPartnerId) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	public void updateGasLoginLogById(Long id,GasLoginLogDO gasLoginLogDO) {
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
	 * 根据platPartnerId更新gas_login_log表数据
	 */
	public void updateGasLoginLogByPlatPartnerId(String platPartnerId,GasLoginLogDO gasLoginLogDO) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	 * 断言gas_mall_exchange_goods表
	 */
	public void gasMallExchangeGoodsAssert(
	        GasMallExchangeGoodsDO gasMallExchangeGoodsDO,
			Long id, 
			String goodsId, 
			String partnerId, 
			String platPartnerId, 
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
        assertEquals(id, gasMallExchangeGoodsDO.getId());
        assertEquals(goodsId, gasMallExchangeGoodsDO.getGoodsId());
        assertEquals(partnerId, gasMallExchangeGoodsDO.getPartnerId());
        assertEquals(platPartnerId, gasMallExchangeGoodsDO.getPlatPartnerId());
        assertEquals(goodsType, gasMallExchangeGoodsDO.getGoodsType());
        assertEquals(goodsName, gasMallExchangeGoodsDO.getGoodsName());
        assertEquals(goodsDescription, gasMallExchangeGoodsDO.getGoodsDescription());
        assertEquals(goodsImg, gasMallExchangeGoodsDO.getGoodsImg());
        assertEquals(forSaleTime, gasMallExchangeGoodsDO.getForSaleTime());
        assertEquals(invalidTime, gasMallExchangeGoodsDO.getInvalidTime());
        assertEquals(exchangePoint, gasMallExchangeGoodsDO.getExchangePoint());
        assertEquals(storeNum, gasMallExchangeGoodsDO.getStoreNum());
        assertEquals(freezeStoreNum, gasMallExchangeGoodsDO.getFreezeStoreNum());
        assertEquals(oneExchangeTimes, gasMallExchangeGoodsDO.getOneExchangeTimes());
        assertEquals(gainStyle, gasMallExchangeGoodsDO.getGainStyle());
        assertEquals(gainStation, gasMallExchangeGoodsDO.getGainStation());
        assertEquals(exchangedCount, gasMallExchangeGoodsDO.getExchangedCount());
        assertEquals(rawAddTime, gasMallExchangeGoodsDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMallExchangeGoodsDO.getRawUpdateTime());
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
			Long id, 
			String goodsId, 
			String partnerId, 
			String platPartnerId, 
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
		gasMallExchangeGoodsDO.setPlatPartnerId(platPartnerId);
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
	public void cleanGasMallExchangeGoodsById(Long id) {
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
	 * 根据platPartnerId删除gas_mall_exchange_goods表数据
	 */
	public void cleanGasMallExchangeGoodsByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
     * 查询gas_mall_exchange_goods表所有数据
     */
    public List<GasMallExchangeGoodsDO> findGasMallExchangeGoodsAll() {
        GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
        exam.createCriteria();
		return gasMallExchangeGoodsDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_mall_exchange_goods表数据
	 */
	public List<GasMallExchangeGoodsDO> findGasMallExchangeGoodsById(Long id) {
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
	 * 根据platPartnerId查询gas_mall_exchange_goods表数据
	 */
	public List<GasMallExchangeGoodsDO> findGasMallExchangeGoodsByPlatPartnerId(String platPartnerId) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	public void updateGasMallExchangeGoodsById(Long id,GasMallExchangeGoodsDO gasMallExchangeGoodsDO) {
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
	 * 根据platPartnerId更新gas_mall_exchange_goods表数据
	 */
	public void updateGasMallExchangeGoodsByPlatPartnerId(String platPartnerId,GasMallExchangeGoodsDO gasMallExchangeGoodsDO) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	 * 断言gas_mall_exchange_record表
	 */
	public void gasMallExchangeRecordAssert(
	        GasMallExchangeRecordDO gasMallExchangeRecordDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String userId, 
			String goodsId, 
			String goodsType, 
			String orderNo, 
			Integer exchangeCount, 
			String exchangeStatus, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMallExchangeRecordDO.getId());
        assertEquals(partnerId, gasMallExchangeRecordDO.getPartnerId());
        assertEquals(platPartnerId, gasMallExchangeRecordDO.getPlatPartnerId());
        assertEquals(userId, gasMallExchangeRecordDO.getUserId());
        assertEquals(goodsId, gasMallExchangeRecordDO.getGoodsId());
        assertEquals(goodsType, gasMallExchangeRecordDO.getGoodsType());
        assertEquals(orderNo, gasMallExchangeRecordDO.getOrderNo());
        assertEquals(exchangeCount, gasMallExchangeRecordDO.getExchangeCount());
        assertEquals(exchangeStatus, gasMallExchangeRecordDO.getExchangeStatus());
        assertEquals(rawAddTime, gasMallExchangeRecordDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMallExchangeRecordDO.getRawUpdateTime());
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
			Long id, 
			String partnerId, 
			String platPartnerId, 
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
		gasMallExchangeRecordDO.setPlatPartnerId(platPartnerId);
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
	public void cleanGasMallExchangeRecordById(Long id) {
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
	 * 根据platPartnerId删除gas_mall_exchange_record表数据
	 */
	public void cleanGasMallExchangeRecordByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
     * 查询gas_mall_exchange_record表所有数据
     */
    public List<GasMallExchangeRecordDO> findGasMallExchangeRecordAll() {
        GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
        exam.createCriteria();
		return gasMallExchangeRecordDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_mall_exchange_record表数据
	 */
	public List<GasMallExchangeRecordDO> findGasMallExchangeRecordById(Long id) {
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
	 * 根据platPartnerId查询gas_mall_exchange_record表数据
	 */
	public List<GasMallExchangeRecordDO> findGasMallExchangeRecordByPlatPartnerId(String platPartnerId) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	public void updateGasMallExchangeRecordById(Long id,GasMallExchangeRecordDO gasMallExchangeRecordDO) {
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
	 * 根据platPartnerId更新gas_mall_exchange_record表数据
	 */
	public void updateGasMallExchangeRecordByPlatPartnerId(String platPartnerId,GasMallExchangeRecordDO gasMallExchangeRecordDO) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	 * 断言gas_merchant_card表
	 */
	public void gasMerchantCardAssert(
	        GasMerchantCardDO gasMerchantCardDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String cardObjectId, 
			String cardType, 
			String tag, 
			String parentCardNo, 
			String cardNo, 
			String internalNo, 
			Long cardRuleId, 
			String operatorAccount, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantCardDO.getId());
        assertEquals(partnerId, gasMerchantCardDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantCardDO.getPlatPartnerId());
        assertEquals(cardObjectId, gasMerchantCardDO.getCardObjectId());
        assertEquals(cardType, gasMerchantCardDO.getCardType());
        assertEquals(tag, gasMerchantCardDO.getTag());
        assertEquals(parentCardNo, gasMerchantCardDO.getParentCardNo());
        assertEquals(cardNo, gasMerchantCardDO.getCardNo());
        assertEquals(internalNo, gasMerchantCardDO.getInternalNo());
        assertEquals(cardRuleId, gasMerchantCardDO.getCardRuleId());
        assertEquals(operatorAccount, gasMerchantCardDO.getOperatorAccount());
        assertEquals(rawAddTime, gasMerchantCardDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantCardDO.getRawUpdateTime());
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
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String cardObjectId, 
			String cardType, 
			String tag, 
			String parentCardNo, 
			String cardNo, 
			String internalNo, 
			Long cardRuleId, 
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
		gasMerchantCardDO.setPlatPartnerId(platPartnerId);
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
	public void cleanGasMerchantCardById(Long id) {
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
	 * 根据platPartnerId删除gas_merchant_card表数据
	 */
	public void cleanGasMerchantCardByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	public void cleanGasMerchantCardByCardRuleId(Long cardRuleId) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardRuleIdEqualTo(cardRuleId);
		gasMerchantCardDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_card表所有数据
     */
    public List<GasMerchantCardDO> findGasMerchantCardAll() {
        GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
        exam.createCriteria();
		return gasMerchantCardDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_card表数据
	 */
	public List<GasMerchantCardDO> findGasMerchantCardById(Long id) {
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
	 * 根据platPartnerId查询gas_merchant_card表数据
	 */
	public List<GasMerchantCardDO> findGasMerchantCardByPlatPartnerId(String platPartnerId) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	public List<GasMerchantCardDO> findGasMerchantCardByCardRuleId(Long cardRuleId) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardRuleIdEqualTo(cardRuleId);
		return gasMerchantCardDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_card表数据
	 */
	public void updateGasMerchantCardById(Long id,GasMerchantCardDO gasMerchantCardDO) {
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
	 * 根据platPartnerId更新gas_merchant_card表数据
	 */
	public void updateGasMerchantCardByPlatPartnerId(String platPartnerId,GasMerchantCardDO gasMerchantCardDO) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	public void updateGasMerchantCardByCardRuleId(Long cardRuleId,GasMerchantCardDO gasMerchantCardDO) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardRuleIdEqualTo(cardRuleId);
		gasMerchantCardDAO.updateByExample(gasMerchantCardDO, exam);
	}

    /**
	 * 断言gas_merchant_card_object表
	 */
	public void gasMerchantCardObjectAssert(
	        GasMerchantCardObjectDO gasMerchantCardObjectDO,
			Long id, 
			String objectId, 
			String partnerId, 
			String platPartnerId, 
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
        assertEquals(id, gasMerchantCardObjectDO.getId());
        assertEquals(objectId, gasMerchantCardObjectDO.getObjectId());
        assertEquals(partnerId, gasMerchantCardObjectDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantCardObjectDO.getPlatPartnerId());
        assertEquals(cardType, gasMerchantCardObjectDO.getCardType());
        assertEquals(tag, gasMerchantCardObjectDO.getTag());
        assertEquals(objectName, gasMerchantCardObjectDO.getObjectName());
        assertEquals(objectCompany, gasMerchantCardObjectDO.getObjectCompany());
        assertEquals(status, gasMerchantCardObjectDO.getStatus());
        assertEquals(validStart, gasMerchantCardObjectDO.getValidStart());
        assertEquals(validEnd, gasMerchantCardObjectDO.getValidEnd());
        assertEquals(memo, gasMerchantCardObjectDO.getMemo());
        assertEquals(rawAddTime, gasMerchantCardObjectDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantCardObjectDO.getRawUpdateTime());
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
			Long id, 
			String objectId, 
			String partnerId, 
			String platPartnerId, 
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
		gasMerchantCardObjectDO.setPlatPartnerId(platPartnerId);
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
	public void cleanGasMerchantCardObjectById(Long id) {
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
	 * 根据platPartnerId删除gas_merchant_card_object表数据
	 */
	public void cleanGasMerchantCardObjectByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
     * 查询gas_merchant_card_object表所有数据
     */
    public List<GasMerchantCardObjectDO> findGasMerchantCardObjectAll() {
        GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
        exam.createCriteria();
		return gasMerchantCardObjectDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_card_object表数据
	 */
	public List<GasMerchantCardObjectDO> findGasMerchantCardObjectById(Long id) {
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
	 * 根据platPartnerId查询gas_merchant_card_object表数据
	 */
	public List<GasMerchantCardObjectDO> findGasMerchantCardObjectByPlatPartnerId(String platPartnerId) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	public void updateGasMerchantCardObjectById(Long id,GasMerchantCardObjectDO gasMerchantCardObjectDO) {
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
	 * 根据platPartnerId更新gas_merchant_card_object表数据
	 */
	public void updateGasMerchantCardObjectByPlatPartnerId(String platPartnerId,GasMerchantCardObjectDO gasMerchantCardObjectDO) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	 * 断言gas_merchant_card_rule表
	 */
	public void gasMerchantCardRuleAssert(
	        GasMerchantCardRuleDO gasMerchantCardRuleDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
			Integer rangeStart, 
			Integer rangeEnd, 
			String excludeCardNo, 
			String excludeNumber, 
			Integer validCount, 
			String operatorAccount, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantCardRuleDO.getId());
        assertEquals(partnerId, gasMerchantCardRuleDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantCardRuleDO.getPlatPartnerId());
        assertEquals(rangeStart, gasMerchantCardRuleDO.getRangeStart());
        assertEquals(rangeEnd, gasMerchantCardRuleDO.getRangeEnd());
        assertEquals(excludeCardNo, gasMerchantCardRuleDO.getExcludeCardNo());
        assertEquals(excludeNumber, gasMerchantCardRuleDO.getExcludeNumber());
        assertEquals(validCount, gasMerchantCardRuleDO.getValidCount());
        assertEquals(operatorAccount, gasMerchantCardRuleDO.getOperatorAccount());
        assertEquals(memo, gasMerchantCardRuleDO.getMemo());
        assertEquals(rawAddTime, gasMerchantCardRuleDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantCardRuleDO.getRawUpdateTime());
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
			Long id, 
			String partnerId, 
			String platPartnerId, 
			Integer rangeStart, 
			Integer rangeEnd, 
			String excludeCardNo, 
			String excludeNumber, 
			Integer validCount, 
			String operatorAccount, 
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
		gasMerchantCardRuleDO.setPlatPartnerId(platPartnerId);
		gasMerchantCardRuleDO.setRangeStart(rangeStart);
		gasMerchantCardRuleDO.setRangeEnd(rangeEnd);
		gasMerchantCardRuleDO.setExcludeCardNo(excludeCardNo);
		gasMerchantCardRuleDO.setExcludeNumber(excludeNumber);
		gasMerchantCardRuleDO.setValidCount(validCount);
		gasMerchantCardRuleDO.setOperatorAccount(operatorAccount);
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
	public void cleanGasMerchantCardRuleById(Long id) {
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
	 * 根据platPartnerId删除gas_merchant_card_rule表数据
	 */
	public void cleanGasMerchantCardRuleByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
     * 查询gas_merchant_card_rule表所有数据
     */
    public List<GasMerchantCardRuleDO> findGasMerchantCardRuleAll() {
        GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
        exam.createCriteria();
		return gasMerchantCardRuleDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_card_rule表数据
	 */
	public List<GasMerchantCardRuleDO> findGasMerchantCardRuleById(Long id) {
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
	 * 根据platPartnerId查询gas_merchant_card_rule表数据
	 */
	public List<GasMerchantCardRuleDO> findGasMerchantCardRuleByPlatPartnerId(String platPartnerId) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	public void updateGasMerchantCardRuleById(Long id,GasMerchantCardRuleDO gasMerchantCardRuleDO) {
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
	 * 根据platPartnerId更新gas_merchant_card_rule表数据
	 */
	public void updateGasMerchantCardRuleByPlatPartnerId(String platPartnerId,GasMerchantCardRuleDO gasMerchantCardRuleDO) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	 * 断言gas_merchant表
	 */
	public void gasMerchantAssert(
	        GasMerchantDO gasMerchantDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
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
			String monthTime, 
			String dayTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantDO.getId());
        assertEquals(partnerId, gasMerchantDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantDO.getPlatPartnerId());
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
        assertEquals(monthTime, gasMerchantDO.getMonthTime());
        assertEquals(dayTime, gasMerchantDO.getDayTime());
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
			String platPartnerId, 
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
			String monthTime, 
			String dayTime, 
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
		gasMerchantDO.setPlatPartnerId(platPartnerId);
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
		gasMerchantDO.setMonthTime(monthTime);
		gasMerchantDO.setDayTime(dayTime);
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
	 * 根据platPartnerId删除gas_merchant表数据
	 */
	public void cleanGasMerchantByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	 * 根据platPartnerId查询gas_merchant表数据
	 */
	public List<GasMerchantDO> findGasMerchantByPlatPartnerId(String platPartnerId) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	 * 根据platPartnerId更新gas_merchant表数据
	 */
	public void updateGasMerchantByPlatPartnerId(String platPartnerId,GasMerchantDO gasMerchantDO) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	 * 断言gas_merchant_device表
	 */
	public void gasMerchantDeviceAssert(
	        GasMerchantDeviceDO gasMerchantDeviceDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String deviceType, 
			String deviceCode, 
			String loginStatus, 
			String loginUserId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantDeviceDO.getId());
        assertEquals(partnerId, gasMerchantDeviceDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantDeviceDO.getPlatPartnerId());
        assertEquals(deviceType, gasMerchantDeviceDO.getDeviceType());
        assertEquals(deviceCode, gasMerchantDeviceDO.getDeviceCode());
        assertEquals(loginStatus, gasMerchantDeviceDO.getLoginStatus());
        assertEquals(loginUserId, gasMerchantDeviceDO.getLoginUserId());
        assertEquals(rawAddTime, gasMerchantDeviceDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantDeviceDO.getRawUpdateTime());
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
			Long id, 
			String partnerId, 
			String platPartnerId, 
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
		gasMerchantDeviceDO.setPlatPartnerId(platPartnerId);
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
	public void cleanGasMerchantDeviceById(Long id) {
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
	 * 根据platPartnerId删除gas_merchant_device表数据
	 */
	public void cleanGasMerchantDeviceByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
     * 查询gas_merchant_device表所有数据
     */
    public List<GasMerchantDeviceDO> findGasMerchantDeviceAll() {
        GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
        exam.createCriteria();
		return gasMerchantDeviceDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_device表数据
	 */
	public List<GasMerchantDeviceDO> findGasMerchantDeviceById(Long id) {
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
	 * 根据platPartnerId查询gas_merchant_device表数据
	 */
	public List<GasMerchantDeviceDO> findGasMerchantDeviceByPlatPartnerId(String platPartnerId) {
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	public void updateGasMerchantDeviceById(Long id,GasMerchantDeviceDO gasMerchantDeviceDO) {
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
	 * 根据platPartnerId更新gas_merchant_device表数据
	 */
	public void updateGasMerchantDeviceByPlatPartnerId(String platPartnerId,GasMerchantDeviceDO gasMerchantDeviceDO) {
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	 * 断言gas_merchant_device_function_bk表
	 */
	public void gasMerchantDeviceFunctionBkAssert(
	        GasMerchantDeviceFunctionBkDO gasMerchantDeviceFunctionBkDO,
			Long id, 
			String partnerId, 
			String stationId, 
			String funcType, 
			Byte open, 
			String deviceType, 
			String deviceCode, 
			Double longitude, 
			Double latitude, 
			String userId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantDeviceFunctionBkDO.getId());
        assertEquals(partnerId, gasMerchantDeviceFunctionBkDO.getPartnerId());
        assertEquals(stationId, gasMerchantDeviceFunctionBkDO.getStationId());
        assertEquals(funcType, gasMerchantDeviceFunctionBkDO.getFuncType());
        assertEquals(open, gasMerchantDeviceFunctionBkDO.getOpen());
        assertEquals(deviceType, gasMerchantDeviceFunctionBkDO.getDeviceType());
        assertEquals(deviceCode, gasMerchantDeviceFunctionBkDO.getDeviceCode());
        assertEquals(longitude, gasMerchantDeviceFunctionBkDO.getLongitude());
        assertEquals(latitude, gasMerchantDeviceFunctionBkDO.getLatitude());
        assertEquals(userId, gasMerchantDeviceFunctionBkDO.getUserId());
        assertEquals(rawAddTime, gasMerchantDeviceFunctionBkDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantDeviceFunctionBkDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_merchant_device_function_bk表数据
	 */
	public void assertGasMerchantDeviceFunctionBk(GasMerchantDeviceFunctionBkDO expect, GasMerchantDeviceFunctionBkDO gasMerchantDeviceFunctionBkDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantDeviceFunctionBkDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantDeviceFunctionBkDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantDeviceFunctionBkDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantDeviceFunctionBkDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantDeviceFunctionBkDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantDeviceFunctionBkDO);
	}

    /**
	 * 插入gas_merchant_device_function_bk表数据
	 */
	public void insertGasMerchantDeviceFunctionBk(GasMerchantDeviceFunctionBkDO gasMerchantDeviceFunctionBkDO) {
		gasMerchantDeviceFunctionBkDAO.insert(gasMerchantDeviceFunctionBkDO);
	}

    /**
	 * 插入gas_merchant_device_function_bk表数据
	 */
	public void insertGasMerchantDeviceFunctionBk(
			Long id, 
			String partnerId, 
			String stationId, 
			String funcType, 
			Byte open, 
			String deviceType, 
			String deviceCode, 
			Double longitude, 
			Double latitude, 
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
		GasMerchantDeviceFunctionBkDO gasMerchantDeviceFunctionBkDO = new GasMerchantDeviceFunctionBkDO();
		gasMerchantDeviceFunctionBkDO.setId(id);
		gasMerchantDeviceFunctionBkDO.setPartnerId(partnerId);
		gasMerchantDeviceFunctionBkDO.setStationId(stationId);
		gasMerchantDeviceFunctionBkDO.setFuncType(funcType);
		gasMerchantDeviceFunctionBkDO.setOpen(open);
		gasMerchantDeviceFunctionBkDO.setDeviceType(deviceType);
		gasMerchantDeviceFunctionBkDO.setDeviceCode(deviceCode);
		gasMerchantDeviceFunctionBkDO.setLongitude(longitude);
		gasMerchantDeviceFunctionBkDO.setLatitude(latitude);
		gasMerchantDeviceFunctionBkDO.setUserId(userId);
		gasMerchantDeviceFunctionBkDO.setRawAddTime(rawAddTime);
		gasMerchantDeviceFunctionBkDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantDeviceFunctionBkDAO.insert(gasMerchantDeviceFunctionBkDO);
	}

    /**
     * 删除gas_merchant_device_function_bk表所有数据
     */
    public void cleanGasMerchantDeviceFunctionBk() {
        GasMerchantDeviceFunctionBkDOExample exam = new GasMerchantDeviceFunctionBkDOExample();
        exam.createCriteria();
        gasMerchantDeviceFunctionBkDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_device_function_bk表数据
	 */
	public void cleanGasMerchantDeviceFunctionBkById(Long id) {
		GasMerchantDeviceFunctionBkDOExample exam = new GasMerchantDeviceFunctionBkDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantDeviceFunctionBkDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_device_function_bk表数据
	 */
	public void cleanGasMerchantDeviceFunctionBkByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantDeviceFunctionBkDOExample exam = new GasMerchantDeviceFunctionBkDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantDeviceFunctionBkDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_merchant_device_function_bk表数据
	 */
	public void cleanGasMerchantDeviceFunctionBkByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasMerchantDeviceFunctionBkDOExample exam = new GasMerchantDeviceFunctionBkDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasMerchantDeviceFunctionBkDAO.deleteByExample(exam);
	}

	/**
	* 根据deviceCode删除gas_merchant_device_function_bk表数据
	*/
	public void cleanGasMerchantDeviceFunctionBkByDeviceCode(String deviceCode) {
        if (StringUtils.isBlank(deviceCode)){
            deviceCode = "test_deviceCode";
        }
		GasMerchantDeviceFunctionBkDOExample exam = new GasMerchantDeviceFunctionBkDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		gasMerchantDeviceFunctionBkDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_merchant_device_function_bk表数据
	 */
	public void cleanGasMerchantDeviceFunctionBkByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasMerchantDeviceFunctionBkDOExample exam = new GasMerchantDeviceFunctionBkDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMerchantDeviceFunctionBkDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_device_function_bk表所有数据
     */
    public List<GasMerchantDeviceFunctionBkDO> findGasMerchantDeviceFunctionBkAll() {
        GasMerchantDeviceFunctionBkDOExample exam = new GasMerchantDeviceFunctionBkDOExample();
        exam.createCriteria();
		return gasMerchantDeviceFunctionBkDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_device_function_bk表数据
	 */
	public List<GasMerchantDeviceFunctionBkDO> findGasMerchantDeviceFunctionBkById(Long id) {
		GasMerchantDeviceFunctionBkDOExample exam = new GasMerchantDeviceFunctionBkDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantDeviceFunctionBkDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_device_function_bk表数据
	 */
	public List<GasMerchantDeviceFunctionBkDO> findGasMerchantDeviceFunctionBkByPartnerId(String partnerId) {
		GasMerchantDeviceFunctionBkDOExample exam = new GasMerchantDeviceFunctionBkDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantDeviceFunctionBkDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_merchant_device_function_bk表数据
	 */
	public List<GasMerchantDeviceFunctionBkDO> findGasMerchantDeviceFunctionBkByStationId(String stationId) {
		GasMerchantDeviceFunctionBkDOExample exam = new GasMerchantDeviceFunctionBkDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasMerchantDeviceFunctionBkDAO.selectByExample(exam);
	}

	/**
	* 根据deviceCode查询gas_merchant_device_function_bk表数据
	*/
	public List<GasMerchantDeviceFunctionBkDO> findGasMerchantDeviceFunctionBkByDeviceCode(String deviceCode) {
		GasMerchantDeviceFunctionBkDOExample exam = new GasMerchantDeviceFunctionBkDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		return gasMerchantDeviceFunctionBkDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_merchant_device_function_bk表数据
	 */
	public List<GasMerchantDeviceFunctionBkDO> findGasMerchantDeviceFunctionBkByUserId(String userId) {
		GasMerchantDeviceFunctionBkDOExample exam = new GasMerchantDeviceFunctionBkDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasMerchantDeviceFunctionBkDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_device_function_bk表数据
	 */
	public void updateGasMerchantDeviceFunctionBkById(Long id,GasMerchantDeviceFunctionBkDO gasMerchantDeviceFunctionBkDO) {
		GasMerchantDeviceFunctionBkDOExample exam = new GasMerchantDeviceFunctionBkDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantDeviceFunctionBkDAO.updateByExample(gasMerchantDeviceFunctionBkDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_device_function_bk表数据
	 */
	public void updateGasMerchantDeviceFunctionBkByPartnerId(String partnerId,GasMerchantDeviceFunctionBkDO gasMerchantDeviceFunctionBkDO) {
		GasMerchantDeviceFunctionBkDOExample exam = new GasMerchantDeviceFunctionBkDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantDeviceFunctionBkDAO.updateByExample(gasMerchantDeviceFunctionBkDO, exam);
	}

    /**
	 * 根据stationId更新gas_merchant_device_function_bk表数据
	 */
	public void updateGasMerchantDeviceFunctionBkByStationId(String stationId,GasMerchantDeviceFunctionBkDO gasMerchantDeviceFunctionBkDO) {
		GasMerchantDeviceFunctionBkDOExample exam = new GasMerchantDeviceFunctionBkDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasMerchantDeviceFunctionBkDAO.updateByExample(gasMerchantDeviceFunctionBkDO, exam);
	}

	/**
	* 根据deviceCode更新gas_merchant_device_function_bk表数据
	*/
	public void updateGasMerchantDeviceFunctionBkByDeviceCode(String deviceCode,GasMerchantDeviceFunctionBkDO gasMerchantDeviceFunctionBkDO) {
		GasMerchantDeviceFunctionBkDOExample exam = new GasMerchantDeviceFunctionBkDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		gasMerchantDeviceFunctionBkDAO.updateByExample(gasMerchantDeviceFunctionBkDO, exam);
	}

    /**
	 * 根据userId更新gas_merchant_device_function_bk表数据
	 */
	public void updateGasMerchantDeviceFunctionBkByUserId(String userId,GasMerchantDeviceFunctionBkDO gasMerchantDeviceFunctionBkDO) {
		GasMerchantDeviceFunctionBkDOExample exam = new GasMerchantDeviceFunctionBkDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMerchantDeviceFunctionBkDAO.updateByExample(gasMerchantDeviceFunctionBkDO, exam);
	}

    /**
	 * 断言gas_merchant_device_function表
	 */
	public void gasMerchantDeviceFunctionAssert(
	        GasMerchantDeviceFunctionDO gasMerchantDeviceFunctionDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String stationId, 
			String funcType, 
			Byte open, 
			String deviceType, 
			String deviceCode, 
			String userId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantDeviceFunctionDO.getId());
        assertEquals(partnerId, gasMerchantDeviceFunctionDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantDeviceFunctionDO.getPlatPartnerId());
        assertEquals(stationId, gasMerchantDeviceFunctionDO.getStationId());
        assertEquals(funcType, gasMerchantDeviceFunctionDO.getFuncType());
        assertEquals(open, gasMerchantDeviceFunctionDO.getOpen());
        assertEquals(deviceType, gasMerchantDeviceFunctionDO.getDeviceType());
        assertEquals(deviceCode, gasMerchantDeviceFunctionDO.getDeviceCode());
        assertEquals(userId, gasMerchantDeviceFunctionDO.getUserId());
        assertEquals(rawAddTime, gasMerchantDeviceFunctionDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantDeviceFunctionDO.getRawUpdateTime());
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
			Long id, 
			String partnerId, 
			String platPartnerId, 
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
		gasMerchantDeviceFunctionDO.setPlatPartnerId(platPartnerId);
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
	public void cleanGasMerchantDeviceFunctionById(Long id) {
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
	 * 根据platPartnerId删除gas_merchant_device_function表数据
	 */
	public void cleanGasMerchantDeviceFunctionByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
     * 查询gas_merchant_device_function表所有数据
     */
    public List<GasMerchantDeviceFunctionDO> findGasMerchantDeviceFunctionAll() {
        GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
        exam.createCriteria();
		return gasMerchantDeviceFunctionDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_device_function表数据
	 */
	public List<GasMerchantDeviceFunctionDO> findGasMerchantDeviceFunctionById(Long id) {
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
	 * 根据platPartnerId查询gas_merchant_device_function表数据
	 */
	public List<GasMerchantDeviceFunctionDO> findGasMerchantDeviceFunctionByPlatPartnerId(String platPartnerId) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	public void updateGasMerchantDeviceFunctionById(Long id,GasMerchantDeviceFunctionDO gasMerchantDeviceFunctionDO) {
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
	 * 根据platPartnerId更新gas_merchant_device_function表数据
	 */
	public void updateGasMerchantDeviceFunctionByPlatPartnerId(String platPartnerId,GasMerchantDeviceFunctionDO gasMerchantDeviceFunctionDO) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	 * 断言gas_merchant_goods表
	 */
	public void gasMerchantGoodsAssert(
	        GasMerchantGoodsDO gasMerchantGoodsDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String goodsName, 
			String goodsCode, 
			String goodsType, 
			String goodsGroupType, 
			Long groupId, 
			Double taxGoodsRate, 
			String taxGoodsCode, 
			String taxGoodsName, 
			Integer orderNo, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantGoodsDO.getId());
        assertEquals(partnerId, gasMerchantGoodsDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantGoodsDO.getPlatPartnerId());
        assertEquals(goodsName, gasMerchantGoodsDO.getGoodsName());
        assertEquals(goodsCode, gasMerchantGoodsDO.getGoodsCode());
        assertEquals(goodsType, gasMerchantGoodsDO.getGoodsType());
        assertEquals(goodsGroupType, gasMerchantGoodsDO.getGoodsGroupType());
        assertEquals(groupId, gasMerchantGoodsDO.getGroupId());
        assertEquals(taxGoodsRate, gasMerchantGoodsDO.getTaxGoodsRate());
        assertEquals(taxGoodsCode, gasMerchantGoodsDO.getTaxGoodsCode());
        assertEquals(taxGoodsName, gasMerchantGoodsDO.getTaxGoodsName());
        assertEquals(orderNo, gasMerchantGoodsDO.getOrderNo());
        assertEquals(status, gasMerchantGoodsDO.getStatus());
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
			String platPartnerId, 
			String goodsName, 
			String goodsCode, 
			String goodsType, 
			String goodsGroupType, 
			Long groupId, 
			Double taxGoodsRate, 
			String taxGoodsCode, 
			String taxGoodsName, 
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
		gasMerchantGoodsDO.setPlatPartnerId(platPartnerId);
		gasMerchantGoodsDO.setGoodsName(goodsName);
		gasMerchantGoodsDO.setGoodsCode(goodsCode);
		gasMerchantGoodsDO.setGoodsType(goodsType);
		gasMerchantGoodsDO.setGoodsGroupType(goodsGroupType);
		gasMerchantGoodsDO.setGroupId(groupId);
		gasMerchantGoodsDO.setTaxGoodsRate(taxGoodsRate);
		gasMerchantGoodsDO.setTaxGoodsCode(taxGoodsCode);
		gasMerchantGoodsDO.setTaxGoodsName(taxGoodsName);
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
	 * 根据platPartnerId删除gas_merchant_goods表数据
	 */
	public void cleanGasMerchantGoodsByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	* 根据taxGoodsCode删除gas_merchant_goods表数据
	*/
	public void cleanGasMerchantGoodsByTaxGoodsCode(String taxGoodsCode) {
        if (StringUtils.isBlank(taxGoodsCode)){
            taxGoodsCode = "test_taxGoodsCode";
        }
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andTaxGoodsCodeEqualTo(taxGoodsCode);
		gasMerchantGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据taxGoodsName删除gas_merchant_goods表数据
	*/
	public void cleanGasMerchantGoodsByTaxGoodsName(String taxGoodsName) {
        if (StringUtils.isBlank(taxGoodsName)){
            taxGoodsName = "test_taxGoodsName";
        }
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andTaxGoodsNameEqualTo(taxGoodsName);
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
	 * 根据platPartnerId查询gas_merchant_goods表数据
	 */
	public List<GasMerchantGoodsDO> findGasMerchantGoodsByPlatPartnerId(String platPartnerId) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	* 根据taxGoodsCode查询gas_merchant_goods表数据
	*/
	public List<GasMerchantGoodsDO> findGasMerchantGoodsByTaxGoodsCode(String taxGoodsCode) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andTaxGoodsCodeEqualTo(taxGoodsCode);
		return gasMerchantGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据taxGoodsName查询gas_merchant_goods表数据
	*/
	public List<GasMerchantGoodsDO> findGasMerchantGoodsByTaxGoodsName(String taxGoodsName) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andTaxGoodsNameEqualTo(taxGoodsName);
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
	 * 根据platPartnerId更新gas_merchant_goods表数据
	 */
	public void updateGasMerchantGoodsByPlatPartnerId(String platPartnerId,GasMerchantGoodsDO gasMerchantGoodsDO) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	* 根据taxGoodsCode更新gas_merchant_goods表数据
	*/
	public void updateGasMerchantGoodsByTaxGoodsCode(String taxGoodsCode,GasMerchantGoodsDO gasMerchantGoodsDO) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andTaxGoodsCodeEqualTo(taxGoodsCode);
		gasMerchantGoodsDAO.updateByExample(gasMerchantGoodsDO, exam);
	}

	/**
	* 根据taxGoodsName更新gas_merchant_goods表数据
	*/
	public void updateGasMerchantGoodsByTaxGoodsName(String taxGoodsName,GasMerchantGoodsDO gasMerchantGoodsDO) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andTaxGoodsNameEqualTo(taxGoodsName);
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
	 * 断言gas_merchant_goods_price_plan_copy表
	 */
	public void gasMerchantGoodsPricePlanCopyAssert(
	        GasMerchantGoodsPricePlanCopyDO gasMerchantGoodsPricePlanCopyDO,
			Long id, 
			String planId, 
			String priceName, 
			String partnerId, 
			Date effectTime, 
			String deleteFlag, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String goodsInfo
	) {
        assertEquals(id, gasMerchantGoodsPricePlanCopyDO.getId());
        assertEquals(planId, gasMerchantGoodsPricePlanCopyDO.getPlanId());
        assertEquals(priceName, gasMerchantGoodsPricePlanCopyDO.getPriceName());
        assertEquals(partnerId, gasMerchantGoodsPricePlanCopyDO.getPartnerId());
        assertEquals(effectTime, gasMerchantGoodsPricePlanCopyDO.getEffectTime());
        assertEquals(deleteFlag, gasMerchantGoodsPricePlanCopyDO.getDeleteFlag());
        assertEquals(rawAddTime, gasMerchantGoodsPricePlanCopyDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantGoodsPricePlanCopyDO.getRawUpdateTime());
        assertEquals(goodsInfo, gasMerchantGoodsPricePlanCopyDO.getGoodsInfo());
	}

	/**
	 * 断言gas_merchant_goods_price_plan_copy表数据
	 */
	public void assertGasMerchantGoodsPricePlanCopy(GasMerchantGoodsPricePlanCopyDO expect, GasMerchantGoodsPricePlanCopyDO gasMerchantGoodsPricePlanCopyDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantGoodsPricePlanCopyDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantGoodsPricePlanCopyDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantGoodsPricePlanCopyDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantGoodsPricePlanCopyDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantGoodsPricePlanCopyDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantGoodsPricePlanCopyDO);
	}

    /**
	 * 插入gas_merchant_goods_price_plan_copy表数据
	 */
	public void insertGasMerchantGoodsPricePlanCopy(GasMerchantGoodsPricePlanCopyDO gasMerchantGoodsPricePlanCopyDO) {
		gasMerchantGoodsPricePlanCopyDAO.insert(gasMerchantGoodsPricePlanCopyDO);
	}

    /**
	 * 插入gas_merchant_goods_price_plan_copy表数据
	 */
	public void insertGasMerchantGoodsPricePlanCopy(
			Long id, 
			String planId, 
			String priceName, 
			String partnerId, 
			Date effectTime, 
			String deleteFlag, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String goodsInfo
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantGoodsPricePlanCopyDO gasMerchantGoodsPricePlanCopyDO = new GasMerchantGoodsPricePlanCopyDO();
		gasMerchantGoodsPricePlanCopyDO.setId(id);
		gasMerchantGoodsPricePlanCopyDO.setPlanId(planId);
		gasMerchantGoodsPricePlanCopyDO.setPriceName(priceName);
		gasMerchantGoodsPricePlanCopyDO.setPartnerId(partnerId);
		gasMerchantGoodsPricePlanCopyDO.setEffectTime(effectTime);
		gasMerchantGoodsPricePlanCopyDO.setDeleteFlag(deleteFlag);
		gasMerchantGoodsPricePlanCopyDO.setRawAddTime(rawAddTime);
		gasMerchantGoodsPricePlanCopyDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantGoodsPricePlanCopyDO.setGoodsInfo(goodsInfo);
		gasMerchantGoodsPricePlanCopyDAO.insert(gasMerchantGoodsPricePlanCopyDO);
	}

    /**
     * 删除gas_merchant_goods_price_plan_copy表所有数据
     */
    public void cleanGasMerchantGoodsPricePlanCopy() {
        GasMerchantGoodsPricePlanCopyDOExample exam = new GasMerchantGoodsPricePlanCopyDOExample();
        exam.createCriteria();
        gasMerchantGoodsPricePlanCopyDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_goods_price_plan_copy表数据
	 */
	public void cleanGasMerchantGoodsPricePlanCopyById(Long id) {
		GasMerchantGoodsPricePlanCopyDOExample exam = new GasMerchantGoodsPricePlanCopyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantGoodsPricePlanCopyDAO.deleteByExample(exam);
	}

	/**
	 * 根据planId删除gas_merchant_goods_price_plan_copy表数据
	 */
	public void cleanGasMerchantGoodsPricePlanCopyByPlanId(String planId) {
        if (StringUtils.isBlank(planId)){
            planId = "test_planId";
        }
		GasMerchantGoodsPricePlanCopyDOExample exam = new GasMerchantGoodsPricePlanCopyDOExample();
		exam.createCriteria().andPlanIdEqualTo(planId);
		gasMerchantGoodsPricePlanCopyDAO.deleteByExample(exam);
	}

	/**
	* 根据priceName删除gas_merchant_goods_price_plan_copy表数据
	*/
	public void cleanGasMerchantGoodsPricePlanCopyByPriceName(String priceName) {
        if (StringUtils.isBlank(priceName)){
            priceName = "test_priceName";
        }
		GasMerchantGoodsPricePlanCopyDOExample exam = new GasMerchantGoodsPricePlanCopyDOExample();
		exam.createCriteria().andPriceNameEqualTo(priceName);
		gasMerchantGoodsPricePlanCopyDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_goods_price_plan_copy表数据
	 */
	public void cleanGasMerchantGoodsPricePlanCopyByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantGoodsPricePlanCopyDOExample exam = new GasMerchantGoodsPricePlanCopyDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantGoodsPricePlanCopyDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_goods_price_plan_copy表所有数据
     */
    public List<GasMerchantGoodsPricePlanCopyDO> findGasMerchantGoodsPricePlanCopyAll() {
        GasMerchantGoodsPricePlanCopyDOExample exam = new GasMerchantGoodsPricePlanCopyDOExample();
        exam.createCriteria();
		return gasMerchantGoodsPricePlanCopyDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_goods_price_plan_copy表数据
	 */
	public List<GasMerchantGoodsPricePlanCopyDO> findGasMerchantGoodsPricePlanCopyById(Long id) {
		GasMerchantGoodsPricePlanCopyDOExample exam = new GasMerchantGoodsPricePlanCopyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantGoodsPricePlanCopyDAO.selectByExample(exam);
	}

    /**
	 * 根据planId查询gas_merchant_goods_price_plan_copy表数据
	 */
	public List<GasMerchantGoodsPricePlanCopyDO> findGasMerchantGoodsPricePlanCopyByPlanId(String planId) {
		GasMerchantGoodsPricePlanCopyDOExample exam = new GasMerchantGoodsPricePlanCopyDOExample();
		exam.createCriteria().andPlanIdEqualTo(planId);
		return gasMerchantGoodsPricePlanCopyDAO.selectByExample(exam);
	}

	/**
	* 根据priceName查询gas_merchant_goods_price_plan_copy表数据
	*/
	public List<GasMerchantGoodsPricePlanCopyDO> findGasMerchantGoodsPricePlanCopyByPriceName(String priceName) {
		GasMerchantGoodsPricePlanCopyDOExample exam = new GasMerchantGoodsPricePlanCopyDOExample();
		exam.createCriteria().andPriceNameEqualTo(priceName);
		return gasMerchantGoodsPricePlanCopyDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_goods_price_plan_copy表数据
	 */
	public List<GasMerchantGoodsPricePlanCopyDO> findGasMerchantGoodsPricePlanCopyByPartnerId(String partnerId) {
		GasMerchantGoodsPricePlanCopyDOExample exam = new GasMerchantGoodsPricePlanCopyDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantGoodsPricePlanCopyDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_goods_price_plan_copy表数据
	 */
	public void updateGasMerchantGoodsPricePlanCopyById(Long id,GasMerchantGoodsPricePlanCopyDO gasMerchantGoodsPricePlanCopyDO) {
		GasMerchantGoodsPricePlanCopyDOExample exam = new GasMerchantGoodsPricePlanCopyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantGoodsPricePlanCopyDAO.updateByExample(gasMerchantGoodsPricePlanCopyDO, exam);
	}

    /**
	 * 根据planId更新gas_merchant_goods_price_plan_copy表数据
	 */
	public void updateGasMerchantGoodsPricePlanCopyByPlanId(String planId,GasMerchantGoodsPricePlanCopyDO gasMerchantGoodsPricePlanCopyDO) {
		GasMerchantGoodsPricePlanCopyDOExample exam = new GasMerchantGoodsPricePlanCopyDOExample();
		exam.createCriteria().andPlanIdEqualTo(planId);
		gasMerchantGoodsPricePlanCopyDAO.updateByExample(gasMerchantGoodsPricePlanCopyDO, exam);
	}

	/**
	* 根据priceName更新gas_merchant_goods_price_plan_copy表数据
	*/
	public void updateGasMerchantGoodsPricePlanCopyByPriceName(String priceName,GasMerchantGoodsPricePlanCopyDO gasMerchantGoodsPricePlanCopyDO) {
		GasMerchantGoodsPricePlanCopyDOExample exam = new GasMerchantGoodsPricePlanCopyDOExample();
		exam.createCriteria().andPriceNameEqualTo(priceName);
		gasMerchantGoodsPricePlanCopyDAO.updateByExample(gasMerchantGoodsPricePlanCopyDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_goods_price_plan_copy表数据
	 */
	public void updateGasMerchantGoodsPricePlanCopyByPartnerId(String partnerId,GasMerchantGoodsPricePlanCopyDO gasMerchantGoodsPricePlanCopyDO) {
		GasMerchantGoodsPricePlanCopyDOExample exam = new GasMerchantGoodsPricePlanCopyDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantGoodsPricePlanCopyDAO.updateByExample(gasMerchantGoodsPricePlanCopyDO, exam);
	}

    /**
	 * 断言gas_merchant_goods_price_plan表
	 */
	public void gasMerchantGoodsPricePlanAssert(
	        GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO,
			Long id, 
			String planId, 
			String priceName, 
			String partnerId, 
			String platPartnerId, 
			Date effectTime, 
			String deleteFlag, 
			String operatorId, 
			String operatorName, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String goodsInfo
	) {
        assertEquals(id, gasMerchantGoodsPricePlanDO.getId());
        assertEquals(planId, gasMerchantGoodsPricePlanDO.getPlanId());
        assertEquals(priceName, gasMerchantGoodsPricePlanDO.getPriceName());
        assertEquals(partnerId, gasMerchantGoodsPricePlanDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantGoodsPricePlanDO.getPlatPartnerId());
        assertEquals(effectTime, gasMerchantGoodsPricePlanDO.getEffectTime());
        assertEquals(deleteFlag, gasMerchantGoodsPricePlanDO.getDeleteFlag());
        assertEquals(operatorId, gasMerchantGoodsPricePlanDO.getOperatorId());
        assertEquals(operatorName, gasMerchantGoodsPricePlanDO.getOperatorName());
        assertEquals(rawAddTime, gasMerchantGoodsPricePlanDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantGoodsPricePlanDO.getRawUpdateTime());
        assertEquals(goodsInfo, gasMerchantGoodsPricePlanDO.getGoodsInfo());
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
			Long id, 
			String planId, 
			String priceName, 
			String partnerId, 
			String platPartnerId, 
			Date effectTime, 
			String deleteFlag, 
			String operatorId, 
			String operatorName, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String goodsInfo
	) {
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
		gasMerchantGoodsPricePlanDO.setPlatPartnerId(platPartnerId);
		gasMerchantGoodsPricePlanDO.setEffectTime(effectTime);
		gasMerchantGoodsPricePlanDO.setDeleteFlag(deleteFlag);
		gasMerchantGoodsPricePlanDO.setOperatorId(operatorId);
		gasMerchantGoodsPricePlanDO.setOperatorName(operatorName);
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
	public void cleanGasMerchantGoodsPricePlanById(Long id) {
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
	 * 根据platPartnerId删除gas_merchant_goods_price_plan表数据
	 */
	public void cleanGasMerchantGoodsPricePlanByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	 * 根据operatorId删除gas_merchant_goods_price_plan表数据
	 */
	public void cleanGasMerchantGoodsPricePlanByOperatorId(String operatorId) {
        if (StringUtils.isBlank(operatorId)){
            operatorId = "test_operatorId";
        }
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		gasMerchantGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	* 根据operatorName删除gas_merchant_goods_price_plan表数据
	*/
	public void cleanGasMerchantGoodsPricePlanByOperatorName(String operatorName) {
        if (StringUtils.isBlank(operatorName)){
            operatorName = "test_operatorName";
        }
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		gasMerchantGoodsPricePlanDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_goods_price_plan表所有数据
     */
    public List<GasMerchantGoodsPricePlanDO> findGasMerchantGoodsPricePlanAll() {
        GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
        exam.createCriteria();
		return gasMerchantGoodsPricePlanDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_goods_price_plan表数据
	 */
	public List<GasMerchantGoodsPricePlanDO> findGasMerchantGoodsPricePlanById(Long id) {
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
	 * 根据platPartnerId查询gas_merchant_goods_price_plan表数据
	 */
	public List<GasMerchantGoodsPricePlanDO> findGasMerchantGoodsPricePlanByPlatPartnerId(String platPartnerId) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasMerchantGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据operatorId查询gas_merchant_goods_price_plan表数据
	 */
	public List<GasMerchantGoodsPricePlanDO> findGasMerchantGoodsPricePlanByOperatorId(String operatorId) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		return gasMerchantGoodsPricePlanDAO.selectByExample(exam);
	}

	/**
	* 根据operatorName查询gas_merchant_goods_price_plan表数据
	*/
	public List<GasMerchantGoodsPricePlanDO> findGasMerchantGoodsPricePlanByOperatorName(String operatorName) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		return gasMerchantGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_goods_price_plan表数据
	 */
	public void updateGasMerchantGoodsPricePlanById(Long id,GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO) {
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
	 * 根据platPartnerId更新gas_merchant_goods_price_plan表数据
	 */
	public void updateGasMerchantGoodsPricePlanByPlatPartnerId(String platPartnerId,GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantGoodsPricePlanDAO.updateByExample(gasMerchantGoodsPricePlanDO, exam);
	}

    /**
	 * 根据operatorId更新gas_merchant_goods_price_plan表数据
	 */
	public void updateGasMerchantGoodsPricePlanByOperatorId(String operatorId,GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		gasMerchantGoodsPricePlanDAO.updateByExample(gasMerchantGoodsPricePlanDO, exam);
	}

	/**
	* 根据operatorName更新gas_merchant_goods_price_plan表数据
	*/
	public void updateGasMerchantGoodsPricePlanByOperatorName(String operatorName,GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		gasMerchantGoodsPricePlanDAO.updateByExample(gasMerchantGoodsPricePlanDO, exam);
	}

    /**
	 * 断言gas_merchant_payway表
	 */
	public void gasMerchantPaywayAssert(
	        GasMerchantPaywayDO gasMerchantPaywayDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String paywayCode, 
			String paywayName, 
			String paywayType, 
			String paywayIcon, 
			String paywaySmallIcon, 
			String channelCode, 
			String channelFunction, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String paywayScene, 
			String paywayAttribute
	) {
        assertEquals(id, gasMerchantPaywayDO.getId());
        assertEquals(partnerId, gasMerchantPaywayDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantPaywayDO.getPlatPartnerId());
        assertEquals(paywayCode, gasMerchantPaywayDO.getPaywayCode());
        assertEquals(paywayName, gasMerchantPaywayDO.getPaywayName());
        assertEquals(paywayType, gasMerchantPaywayDO.getPaywayType());
        assertEquals(paywayIcon, gasMerchantPaywayDO.getPaywayIcon());
        assertEquals(paywaySmallIcon, gasMerchantPaywayDO.getPaywaySmallIcon());
        assertEquals(channelCode, gasMerchantPaywayDO.getChannelCode());
        assertEquals(channelFunction, gasMerchantPaywayDO.getChannelFunction());
        assertEquals(status, gasMerchantPaywayDO.getStatus());
        assertEquals(rawAddTime, gasMerchantPaywayDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantPaywayDO.getRawUpdateTime());
        assertEquals(paywayScene, gasMerchantPaywayDO.getPaywayScene());
        assertEquals(paywayAttribute, gasMerchantPaywayDO.getPaywayAttribute());
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
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String paywayCode, 
			String paywayName, 
			String paywayType, 
			String paywayIcon, 
			String paywaySmallIcon, 
			String channelCode, 
			String channelFunction, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String paywayScene, 
			String paywayAttribute
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
		gasMerchantPaywayDO.setPlatPartnerId(platPartnerId);
		gasMerchantPaywayDO.setPaywayCode(paywayCode);
		gasMerchantPaywayDO.setPaywayName(paywayName);
		gasMerchantPaywayDO.setPaywayType(paywayType);
		gasMerchantPaywayDO.setPaywayIcon(paywayIcon);
		gasMerchantPaywayDO.setPaywaySmallIcon(paywaySmallIcon);
		gasMerchantPaywayDO.setChannelCode(channelCode);
		gasMerchantPaywayDO.setChannelFunction(channelFunction);
		gasMerchantPaywayDO.setStatus(status);
		gasMerchantPaywayDO.setRawAddTime(rawAddTime);
		gasMerchantPaywayDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantPaywayDO.setPaywayScene(paywayScene);
		gasMerchantPaywayDO.setPaywayAttribute(paywayAttribute);
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
	public void cleanGasMerchantPaywayById(Long id) {
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
	 * 根据platPartnerId,paywayCode删除gas_merchant_payway表数据
	 */
	public void cleanGasMerchantPaywayByPlatPartnerIdAndPaywayCode(String platPartnerId,String paywayCode) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
        if (StringUtils.isBlank(paywayCode)){
            paywayCode = "test_paywayCode";
        }
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId).andPaywayCodeEqualTo(paywayCode);
		gasMerchantPaywayDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_merchant_payway表数据
	 */
	public void cleanGasMerchantPaywayByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	* 根据channelCode删除gas_merchant_payway表数据
	*/
	public void cleanGasMerchantPaywayByChannelCode(String channelCode) {
        if (StringUtils.isBlank(channelCode)){
            channelCode = "test_channelCode";
        }
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andChannelCodeEqualTo(channelCode);
		gasMerchantPaywayDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_payway表所有数据
     */
    public List<GasMerchantPaywayDO> findGasMerchantPaywayAll() {
        GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
        exam.createCriteria();
		return gasMerchantPaywayDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_payway表数据
	 */
	public List<GasMerchantPaywayDO> findGasMerchantPaywayById(Long id) {
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
	 * 根据platPartnerId,paywayCode查询gas_merchant_payway表数据
	 */
	public List<GasMerchantPaywayDO> findGasMerchantPaywayByPlatPartnerIdAndPaywayCode(String platPartnerId,String paywayCode) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId).andPaywayCodeEqualTo(paywayCode);
		return gasMerchantPaywayDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_merchant_payway表数据
	 */
	public List<GasMerchantPaywayDO> findGasMerchantPaywayByPlatPartnerId(String platPartnerId) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	* 根据channelCode查询gas_merchant_payway表数据
	*/
	public List<GasMerchantPaywayDO> findGasMerchantPaywayByChannelCode(String channelCode) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andChannelCodeEqualTo(channelCode);
		return gasMerchantPaywayDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_payway表数据
	 */
	public void updateGasMerchantPaywayById(Long id,GasMerchantPaywayDO gasMerchantPaywayDO) {
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
	 * 根据platPartnerId,paywayCode更新gas_merchant_payway表数据
	 */
	public void updateGasMerchantPaywayByPlatPartnerIdAndPaywayCode(String platPartnerId,String paywayCode,GasMerchantPaywayDO gasMerchantPaywayDO) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId).andPaywayCodeEqualTo(paywayCode);
		gasMerchantPaywayDAO.updateByExample(gasMerchantPaywayDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_merchant_payway表数据
	 */
	public void updateGasMerchantPaywayByPlatPartnerId(String platPartnerId,GasMerchantPaywayDO gasMerchantPaywayDO) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	* 根据channelCode更新gas_merchant_payway表数据
	*/
	public void updateGasMerchantPaywayByChannelCode(String channelCode,GasMerchantPaywayDO gasMerchantPaywayDO) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andChannelCodeEqualTo(channelCode);
		gasMerchantPaywayDAO.updateByExample(gasMerchantPaywayDO, exam);
	}

    /**
	 * 断言gas_merchant_resource表
	 */
	public void gasMerchantResourceAssert(
	        GasMerchantResourceDO gasMerchantResourceDO,
			Long id, 
			String platPartnerId, 
			Long resourceId
	) {
        assertEquals(id, gasMerchantResourceDO.getId());
        assertEquals(platPartnerId, gasMerchantResourceDO.getPlatPartnerId());
        assertEquals(resourceId, gasMerchantResourceDO.getResourceId());
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
			Long id, 
			String platPartnerId, 
			Long resourceId
	) {
		GasMerchantResourceDO gasMerchantResourceDO = new GasMerchantResourceDO();
		gasMerchantResourceDO.setId(id);
		gasMerchantResourceDO.setPlatPartnerId(platPartnerId);
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
	public void cleanGasMerchantResourceById(Long id) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantResourceDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_merchant_resource表数据
	 */
	public void cleanGasMerchantResourceByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantResourceDAO.deleteByExample(exam);
	}

	/**
	 * 根据resourceId删除gas_merchant_resource表数据
	 */
	public void cleanGasMerchantResourceByResourceId(Long resourceId) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andResourceIdEqualTo(resourceId);
		gasMerchantResourceDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_resource表所有数据
     */
    public List<GasMerchantResourceDO> findGasMerchantResourceAll() {
        GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
        exam.createCriteria();
		return gasMerchantResourceDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_resource表数据
	 */
	public List<GasMerchantResourceDO> findGasMerchantResourceById(Long id) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_merchant_resource表数据
	 */
	public List<GasMerchantResourceDO> findGasMerchantResourceByPlatPartnerId(String platPartnerId) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasMerchantResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据resourceId查询gas_merchant_resource表数据
	 */
	public List<GasMerchantResourceDO> findGasMerchantResourceByResourceId(Long resourceId) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andResourceIdEqualTo(resourceId);
		return gasMerchantResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_resource表数据
	 */
	public void updateGasMerchantResourceById(Long id,GasMerchantResourceDO gasMerchantResourceDO) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantResourceDAO.updateByExample(gasMerchantResourceDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_merchant_resource表数据
	 */
	public void updateGasMerchantResourceByPlatPartnerId(String platPartnerId,GasMerchantResourceDO gasMerchantResourceDO) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantResourceDAO.updateByExample(gasMerchantResourceDO, exam);
	}

    /**
	 * 根据resourceId更新gas_merchant_resource表数据
	 */
	public void updateGasMerchantResourceByResourceId(Long resourceId,GasMerchantResourceDO gasMerchantResourceDO) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andResourceIdEqualTo(resourceId);
		gasMerchantResourceDAO.updateByExample(gasMerchantResourceDO, exam);
	}

    /**
	 * 断言gas_merchant_role表
	 */
	public void gasMerchantRoleAssert(
	        GasMerchantRoleDO gasMerchantRoleDO,
			Long id, 
			String platPartnerId, 
			Long roleId
	) {
        assertEquals(id, gasMerchantRoleDO.getId());
        assertEquals(platPartnerId, gasMerchantRoleDO.getPlatPartnerId());
        assertEquals(roleId, gasMerchantRoleDO.getRoleId());
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
			Long id, 
			String platPartnerId, 
			Long roleId
	) {
		GasMerchantRoleDO gasMerchantRoleDO = new GasMerchantRoleDO();
		gasMerchantRoleDO.setId(id);
		gasMerchantRoleDO.setPlatPartnerId(platPartnerId);
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
	public void cleanGasMerchantRoleById(Long id) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantRoleDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_merchant_role表数据
	 */
	public void cleanGasMerchantRoleByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantRoleDAO.deleteByExample(exam);
	}

	/**
	 * 根据roleId删除gas_merchant_role表数据
	 */
	public void cleanGasMerchantRoleByRoleId(Long roleId) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		gasMerchantRoleDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_role表所有数据
     */
    public List<GasMerchantRoleDO> findGasMerchantRoleAll() {
        GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
        exam.createCriteria();
		return gasMerchantRoleDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_role表数据
	 */
	public List<GasMerchantRoleDO> findGasMerchantRoleById(Long id) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantRoleDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_merchant_role表数据
	 */
	public List<GasMerchantRoleDO> findGasMerchantRoleByPlatPartnerId(String platPartnerId) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasMerchantRoleDAO.selectByExample(exam);
	}

    /**
	 * 根据roleId查询gas_merchant_role表数据
	 */
	public List<GasMerchantRoleDO> findGasMerchantRoleByRoleId(Long roleId) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		return gasMerchantRoleDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_role表数据
	 */
	public void updateGasMerchantRoleById(Long id,GasMerchantRoleDO gasMerchantRoleDO) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantRoleDAO.updateByExample(gasMerchantRoleDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_merchant_role表数据
	 */
	public void updateGasMerchantRoleByPlatPartnerId(String platPartnerId,GasMerchantRoleDO gasMerchantRoleDO) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantRoleDAO.updateByExample(gasMerchantRoleDO, exam);
	}

    /**
	 * 根据roleId更新gas_merchant_role表数据
	 */
	public void updateGasMerchantRoleByRoleId(Long roleId,GasMerchantRoleDO gasMerchantRoleDO) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		gasMerchantRoleDAO.updateByExample(gasMerchantRoleDO, exam);
	}

    /**
	 * 断言gas_merchant_role_resource表
	 */
	public void gasMerchantRoleResourceAssert(
	        GasMerchantRoleResourceDO gasMerchantRoleResourceDO,
			Long id, 
			Long roleId, 
			Long resourceId
	) {
        assertEquals(id, gasMerchantRoleResourceDO.getId());
        assertEquals(roleId, gasMerchantRoleResourceDO.getRoleId());
        assertEquals(resourceId, gasMerchantRoleResourceDO.getResourceId());
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
			Long id, 
			Long roleId, 
			Long resourceId
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
	public void cleanGasMerchantRoleResourceById(Long id) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantRoleResourceDAO.deleteByExample(exam);
	}

	/**
	 * 根据roleId删除gas_merchant_role_resource表数据
	 */
	public void cleanGasMerchantRoleResourceByRoleId(Long roleId) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		gasMerchantRoleResourceDAO.deleteByExample(exam);
	}

	/**
	 * 根据resourceId删除gas_merchant_role_resource表数据
	 */
	public void cleanGasMerchantRoleResourceByResourceId(Long resourceId) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andResourceIdEqualTo(resourceId);
		gasMerchantRoleResourceDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_role_resource表所有数据
     */
    public List<GasMerchantRoleResourceDO> findGasMerchantRoleResourceAll() {
        GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
        exam.createCriteria();
		return gasMerchantRoleResourceDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_role_resource表数据
	 */
	public List<GasMerchantRoleResourceDO> findGasMerchantRoleResourceById(Long id) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantRoleResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据roleId查询gas_merchant_role_resource表数据
	 */
	public List<GasMerchantRoleResourceDO> findGasMerchantRoleResourceByRoleId(Long roleId) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		return gasMerchantRoleResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据resourceId查询gas_merchant_role_resource表数据
	 */
	public List<GasMerchantRoleResourceDO> findGasMerchantRoleResourceByResourceId(Long resourceId) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andResourceIdEqualTo(resourceId);
		return gasMerchantRoleResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_role_resource表数据
	 */
	public void updateGasMerchantRoleResourceById(Long id,GasMerchantRoleResourceDO gasMerchantRoleResourceDO) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantRoleResourceDAO.updateByExample(gasMerchantRoleResourceDO, exam);
	}

    /**
	 * 根据roleId更新gas_merchant_role_resource表数据
	 */
	public void updateGasMerchantRoleResourceByRoleId(Long roleId,GasMerchantRoleResourceDO gasMerchantRoleResourceDO) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		gasMerchantRoleResourceDAO.updateByExample(gasMerchantRoleResourceDO, exam);
	}

    /**
	 * 根据resourceId更新gas_merchant_role_resource表数据
	 */
	public void updateGasMerchantRoleResourceByResourceId(Long resourceId,GasMerchantRoleResourceDO gasMerchantRoleResourceDO) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andResourceIdEqualTo(resourceId);
		gasMerchantRoleResourceDAO.updateByExample(gasMerchantRoleResourceDO, exam);
	}

    /**
	 * 断言gas_merchant_source_data表
	 */
	public void gasMerchantSourceDataAssert(
	        GasMerchantSourceDataDO gasMerchantSourceDataDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String sourceType, 
			String sourceKey, 
			Byte authorized, 
			String authorizerRefreshToken, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String authorizerAccessToken, 
			Date authorizerAccessTokenTime, 
			String sourceInfo, 
			String funcInfo
	) {
        assertEquals(id, gasMerchantSourceDataDO.getId());
        assertEquals(partnerId, gasMerchantSourceDataDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantSourceDataDO.getPlatPartnerId());
        assertEquals(sourceType, gasMerchantSourceDataDO.getSourceType());
        assertEquals(sourceKey, gasMerchantSourceDataDO.getSourceKey());
        assertEquals(authorized, gasMerchantSourceDataDO.getAuthorized());
        assertEquals(authorizerRefreshToken, gasMerchantSourceDataDO.getAuthorizerRefreshToken());
        assertEquals(rawAddTime, gasMerchantSourceDataDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantSourceDataDO.getRawUpdateTime());
        assertEquals(authorizerAccessToken, gasMerchantSourceDataDO.getAuthorizerAccessToken());
        assertEquals(authorizerAccessTokenTime, gasMerchantSourceDataDO.getAuthorizerAccessTokenTime());
        assertEquals(sourceInfo, gasMerchantSourceDataDO.getSourceInfo());
        assertEquals(funcInfo, gasMerchantSourceDataDO.getFuncInfo());
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
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String sourceType, 
			String sourceKey, 
			Byte authorized, 
			String authorizerRefreshToken, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String authorizerAccessToken, 
			Date authorizerAccessTokenTime, 
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
		gasMerchantSourceDataDO.setPlatPartnerId(platPartnerId);
		gasMerchantSourceDataDO.setSourceType(sourceType);
		gasMerchantSourceDataDO.setSourceKey(sourceKey);
		gasMerchantSourceDataDO.setAuthorized(authorized);
		gasMerchantSourceDataDO.setAuthorizerRefreshToken(authorizerRefreshToken);
		gasMerchantSourceDataDO.setRawAddTime(rawAddTime);
		gasMerchantSourceDataDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantSourceDataDO.setAuthorizerAccessToken(authorizerAccessToken);
		gasMerchantSourceDataDO.setAuthorizerAccessTokenTime(authorizerAccessTokenTime);
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
	public void cleanGasMerchantSourceDataById(Long id) {
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
	 * 根据platPartnerId删除gas_merchant_source_data表数据
	 */
	public void cleanGasMerchantSourceDataByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
     * 查询gas_merchant_source_data表所有数据
     */
    public List<GasMerchantSourceDataDO> findGasMerchantSourceDataAll() {
        GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
        exam.createCriteria();
		return gasMerchantSourceDataDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_source_data表数据
	 */
	public List<GasMerchantSourceDataDO> findGasMerchantSourceDataById(Long id) {
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
	 * 根据platPartnerId查询gas_merchant_source_data表数据
	 */
	public List<GasMerchantSourceDataDO> findGasMerchantSourceDataByPlatPartnerId(String platPartnerId) {
		GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	public void updateGasMerchantSourceDataById(Long id,GasMerchantSourceDataDO gasMerchantSourceDataDO) {
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
	 * 根据platPartnerId更新gas_merchant_source_data表数据
	 */
	public void updateGasMerchantSourceDataByPlatPartnerId(String platPartnerId,GasMerchantSourceDataDO gasMerchantSourceDataDO) {
		GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	 * 断言gas_merchant_station表
	 */
	public void gasMerchantStationAssert(
	        GasMerchantStationDO gasMerchantStationDO,
			Long id, 
			String stationId, 
			String partnerId, 
			String platPartnerId, 
			String stationName, 
			String stationCode, 
			String phoneNo, 
			String status, 
			Byte connectOilMachine, 
			Long provinceId, 
			Long cityId, 
			Long districtId, 
			String stationAddress, 
			Double longitude, 
			Double latitude, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantStationDO.getId());
        assertEquals(stationId, gasMerchantStationDO.getStationId());
        assertEquals(partnerId, gasMerchantStationDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantStationDO.getPlatPartnerId());
        assertEquals(stationName, gasMerchantStationDO.getStationName());
        assertEquals(stationCode, gasMerchantStationDO.getStationCode());
        assertEquals(phoneNo, gasMerchantStationDO.getPhoneNo());
        assertEquals(status, gasMerchantStationDO.getStatus());
        assertEquals(connectOilMachine, gasMerchantStationDO.getConnectOilMachine());
        assertEquals(provinceId, gasMerchantStationDO.getProvinceId());
        assertEquals(cityId, gasMerchantStationDO.getCityId());
        assertEquals(districtId, gasMerchantStationDO.getDistrictId());
        assertEquals(stationAddress, gasMerchantStationDO.getStationAddress());
        assertEquals(longitude, gasMerchantStationDO.getLongitude());
        assertEquals(latitude, gasMerchantStationDO.getLatitude());
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
			String stationId, 
			String partnerId, 
			String platPartnerId, 
			String stationName, 
			String stationCode, 
			String phoneNo, 
			String status, 
			Byte connectOilMachine, 
			Long provinceId, 
			Long cityId, 
			Long districtId, 
			String stationAddress, 
			Double longitude, 
			Double latitude, 
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
		gasMerchantStationDO.setPlatPartnerId(platPartnerId);
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
	 * 根据cityId删除gas_merchant_station表数据
	 */
	public void cleanGasMerchantStationByCityId(Long cityId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andCityIdEqualTo(cityId);
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
	 * 根据platPartnerId查询gas_merchant_station表数据
	 */
	public List<GasMerchantStationDO> findGasMerchantStationByPlatPartnerId(String platPartnerId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	 * 根据cityId查询gas_merchant_station表数据
	 */
	public List<GasMerchantStationDO> findGasMerchantStationByCityId(Long cityId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andCityIdEqualTo(cityId);
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
	 * 根据id更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationById(Long id,GasMerchantStationDO gasMerchantStationDO) {
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
	 * 根据platPartnerId更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationByPlatPartnerId(String platPartnerId,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	 * 根据cityId更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationByCityId(Long cityId,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andCityIdEqualTo(cityId);
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
	 * 断言gas_merchant_user表
	 */
	public void gasMerchantUserAssert(
	        GasMerchantUserDO gasMerchantUserDO,
			Long id, 
			String userId, 
			Long roleId, 
			String roleNo, 
			String userType, 
			String partnerId, 
			String platPartnerId, 
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
        assertEquals(id, gasMerchantUserDO.getId());
        assertEquals(userId, gasMerchantUserDO.getUserId());
        assertEquals(roleId, gasMerchantUserDO.getRoleId());
        assertEquals(roleNo, gasMerchantUserDO.getRoleNo());
        assertEquals(userType, gasMerchantUserDO.getUserType());
        assertEquals(partnerId, gasMerchantUserDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantUserDO.getPlatPartnerId());
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
			String userId, 
			Long roleId, 
			String roleNo, 
			String userType, 
			String partnerId, 
			String platPartnerId, 
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
		gasMerchantUserDO.setRoleNo(roleNo);
		gasMerchantUserDO.setUserType(userType);
		gasMerchantUserDO.setPartnerId(partnerId);
		gasMerchantUserDO.setPlatPartnerId(platPartnerId);
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
	public void cleanGasMerchantUserById(Long id) {
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
	 * 根据platPartnerId删除gas_merchant_user表数据
	 */
	public void cleanGasMerchantUserByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	 * 根据partnerId查询gas_merchant_user表数据
	 */
	public List<GasMerchantUserDO> findGasMerchantUserByPartnerId(String partnerId) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantUserDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_merchant_user表数据
	 */
	public List<GasMerchantUserDO> findGasMerchantUserByPlatPartnerId(String platPartnerId) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	 * 根据partnerId更新gas_merchant_user表数据
	 */
	public void updateGasMerchantUserByPartnerId(String partnerId,GasMerchantUserDO gasMerchantUserDO) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantUserDAO.updateByExample(gasMerchantUserDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_merchant_user表数据
	 */
	public void updateGasMerchantUserByPlatPartnerId(String platPartnerId,GasMerchantUserDO gasMerchantUserDO) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
			String userId, 
			String stationId
	) {
        assertEquals(id, gasMerchantUserStationDO.getId());
        assertEquals(userId, gasMerchantUserStationDO.getUserId());
        assertEquals(stationId, gasMerchantUserStationDO.getStationId());
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
			Long id, 
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
	public void cleanGasMerchantUserStationById(Long id) {
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
	public void updateGasMerchantUserStationById(Long id,GasMerchantUserStationDO gasMerchantUserStationDO) {
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
	 * 断言gas_oil_station_description表
	 */
	public void gasOilStationDescriptionAssert(
	        GasOilStationDescriptionDO gasOilStationDescriptionDO,
			Integer id, 
			String partnerId, 
			String platPartnerId, 
			String stationId, 
			String type, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String description
	) {
        assertEquals(id, gasOilStationDescriptionDO.getId());
        assertEquals(partnerId, gasOilStationDescriptionDO.getPartnerId());
        assertEquals(platPartnerId, gasOilStationDescriptionDO.getPlatPartnerId());
        assertEquals(stationId, gasOilStationDescriptionDO.getStationId());
        assertEquals(type, gasOilStationDescriptionDO.getType());
        assertEquals(rawAddTime, gasOilStationDescriptionDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasOilStationDescriptionDO.getRawUpdateTime());
        assertEquals(description, gasOilStationDescriptionDO.getDescription());
	}

	/**
	 * 断言gas_oil_station_description表数据
	 */
	public void assertGasOilStationDescription(GasOilStationDescriptionDO expect, GasOilStationDescriptionDO gasOilStationDescriptionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasOilStationDescriptionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasOilStationDescriptionDO.getRawAddTime());
		expect.setRawAddTime(gasOilStationDescriptionDO.getRawAddTime());
        Assertions.assertTrue(null != gasOilStationDescriptionDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasOilStationDescriptionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasOilStationDescriptionDO);
	}

    /**
	 * 插入gas_oil_station_description表数据
	 */
	public void insertGasOilStationDescription(GasOilStationDescriptionDO gasOilStationDescriptionDO) {
		gasOilStationDescriptionDAO.insert(gasOilStationDescriptionDO);
	}

    /**
	 * 插入gas_oil_station_description表数据
	 */
	public void insertGasOilStationDescription(
			Integer id, 
			String partnerId, 
			String platPartnerId, 
			String stationId, 
			String type, 
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
		GasOilStationDescriptionDO gasOilStationDescriptionDO = new GasOilStationDescriptionDO();
		gasOilStationDescriptionDO.setId(id);
		gasOilStationDescriptionDO.setPartnerId(partnerId);
		gasOilStationDescriptionDO.setPlatPartnerId(platPartnerId);
		gasOilStationDescriptionDO.setStationId(stationId);
		gasOilStationDescriptionDO.setType(type);
		gasOilStationDescriptionDO.setRawAddTime(rawAddTime);
		gasOilStationDescriptionDO.setRawUpdateTime(rawUpdateTime);
		gasOilStationDescriptionDO.setDescription(description);
		gasOilStationDescriptionDAO.insert(gasOilStationDescriptionDO);
	}

    /**
     * 删除gas_oil_station_description表所有数据
     */
    public void cleanGasOilStationDescription() {
        GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
        exam.createCriteria();
        gasOilStationDescriptionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_oil_station_description表数据
	 */
	public void cleanGasOilStationDescriptionById(Integer id) {
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasOilStationDescriptionDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_oil_station_description表数据
	 */
	public void cleanGasOilStationDescriptionByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasOilStationDescriptionDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_oil_station_description表数据
	 */
	public void cleanGasOilStationDescriptionByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasOilStationDescriptionDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_oil_station_description表数据
	 */
	public void cleanGasOilStationDescriptionByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasOilStationDescriptionDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_oil_station_description表所有数据
     */
    public List<GasOilStationDescriptionDO> findGasOilStationDescriptionAll() {
        GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
        exam.createCriteria();
		return gasOilStationDescriptionDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_oil_station_description表数据
	 */
	public List<GasOilStationDescriptionDO> findGasOilStationDescriptionById(Integer id) {
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasOilStationDescriptionDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_oil_station_description表数据
	 */
	public List<GasOilStationDescriptionDO> findGasOilStationDescriptionByPartnerId(String partnerId) {
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasOilStationDescriptionDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_oil_station_description表数据
	 */
	public List<GasOilStationDescriptionDO> findGasOilStationDescriptionByPlatPartnerId(String platPartnerId) {
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasOilStationDescriptionDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_oil_station_description表数据
	 */
	public List<GasOilStationDescriptionDO> findGasOilStationDescriptionByStationId(String stationId) {
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasOilStationDescriptionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_oil_station_description表数据
	 */
	public void updateGasOilStationDescriptionById(Integer id,GasOilStationDescriptionDO gasOilStationDescriptionDO) {
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasOilStationDescriptionDAO.updateByExample(gasOilStationDescriptionDO, exam);
	}

    /**
	 * 根据partnerId更新gas_oil_station_description表数据
	 */
	public void updateGasOilStationDescriptionByPartnerId(String partnerId,GasOilStationDescriptionDO gasOilStationDescriptionDO) {
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasOilStationDescriptionDAO.updateByExample(gasOilStationDescriptionDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_oil_station_description表数据
	 */
	public void updateGasOilStationDescriptionByPlatPartnerId(String platPartnerId,GasOilStationDescriptionDO gasOilStationDescriptionDO) {
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasOilStationDescriptionDAO.updateByExample(gasOilStationDescriptionDO, exam);
	}

    /**
	 * 根据stationId更新gas_oil_station_description表数据
	 */
	public void updateGasOilStationDescriptionByStationId(String stationId,GasOilStationDescriptionDO gasOilStationDescriptionDO) {
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasOilStationDescriptionDAO.updateByExample(gasOilStationDescriptionDO, exam);
	}

    /**
	 * 断言gas_partner_mapping表
	 */
	public void gasPartnerMappingAssert(
	        GasPartnerMappingDO gasPartnerMappingDO,
			Integer id, 
			String type, 
			String platPartnerId, 
			String partnerId
	) {
        assertEquals(id, gasPartnerMappingDO.getId());
        assertEquals(type, gasPartnerMappingDO.getType());
        assertEquals(platPartnerId, gasPartnerMappingDO.getPlatPartnerId());
        assertEquals(partnerId, gasPartnerMappingDO.getPartnerId());
	}

	/**
	 * 断言gas_partner_mapping表数据
	 */
	public void assertGasPartnerMapping(GasPartnerMappingDO expect, GasPartnerMappingDO gasPartnerMappingDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasPartnerMappingDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, gasPartnerMappingDO);
	}

    /**
	 * 插入gas_partner_mapping表数据
	 */
	public void insertGasPartnerMapping(GasPartnerMappingDO gasPartnerMappingDO) {
		gasPartnerMappingDAO.insert(gasPartnerMappingDO);
	}

    /**
	 * 插入gas_partner_mapping表数据
	 */
	public void insertGasPartnerMapping(
			Integer id, 
			String type, 
			String platPartnerId, 
			String partnerId
	) {
		GasPartnerMappingDO gasPartnerMappingDO = new GasPartnerMappingDO();
		gasPartnerMappingDO.setId(id);
		gasPartnerMappingDO.setType(type);
		gasPartnerMappingDO.setPlatPartnerId(platPartnerId);
		gasPartnerMappingDO.setPartnerId(partnerId);
		gasPartnerMappingDAO.insert(gasPartnerMappingDO);
	}

    /**
     * 删除gas_partner_mapping表所有数据
     */
    public void cleanGasPartnerMapping() {
        GasPartnerMappingDOExample exam = new GasPartnerMappingDOExample();
        exam.createCriteria();
        gasPartnerMappingDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_partner_mapping表数据
	 */
	public void cleanGasPartnerMappingById(Integer id) {
		GasPartnerMappingDOExample exam = new GasPartnerMappingDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasPartnerMappingDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_partner_mapping表数据
	 */
	public void cleanGasPartnerMappingByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasPartnerMappingDOExample exam = new GasPartnerMappingDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasPartnerMappingDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_partner_mapping表数据
	 */
	public void cleanGasPartnerMappingByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasPartnerMappingDOExample exam = new GasPartnerMappingDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasPartnerMappingDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_partner_mapping表所有数据
     */
    public List<GasPartnerMappingDO> findGasPartnerMappingAll() {
        GasPartnerMappingDOExample exam = new GasPartnerMappingDOExample();
        exam.createCriteria();
		return gasPartnerMappingDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_partner_mapping表数据
	 */
	public List<GasPartnerMappingDO> findGasPartnerMappingById(Integer id) {
		GasPartnerMappingDOExample exam = new GasPartnerMappingDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasPartnerMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_partner_mapping表数据
	 */
	public List<GasPartnerMappingDO> findGasPartnerMappingByPlatPartnerId(String platPartnerId) {
		GasPartnerMappingDOExample exam = new GasPartnerMappingDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasPartnerMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_partner_mapping表数据
	 */
	public List<GasPartnerMappingDO> findGasPartnerMappingByPartnerId(String partnerId) {
		GasPartnerMappingDOExample exam = new GasPartnerMappingDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasPartnerMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_partner_mapping表数据
	 */
	public void updateGasPartnerMappingById(Integer id,GasPartnerMappingDO gasPartnerMappingDO) {
		GasPartnerMappingDOExample exam = new GasPartnerMappingDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasPartnerMappingDAO.updateByExample(gasPartnerMappingDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_partner_mapping表数据
	 */
	public void updateGasPartnerMappingByPlatPartnerId(String platPartnerId,GasPartnerMappingDO gasPartnerMappingDO) {
		GasPartnerMappingDOExample exam = new GasPartnerMappingDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasPartnerMappingDAO.updateByExample(gasPartnerMappingDO, exam);
	}

    /**
	 * 根据partnerId更新gas_partner_mapping表数据
	 */
	public void updateGasPartnerMappingByPartnerId(String partnerId,GasPartnerMappingDO gasPartnerMappingDO) {
		GasPartnerMappingDOExample exam = new GasPartnerMappingDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasPartnerMappingDAO.updateByExample(gasPartnerMappingDO, exam);
	}

    /**
	 * 断言gas_province表
	 */
	public void gasProvinceAssert(
	        GasProvinceDO gasProvinceDO,
			Long id, 
			String provinceName, 
			String provinceShort, 
			String provinceChar
	) {
        assertEquals(id, gasProvinceDO.getId());
        assertEquals(provinceName, gasProvinceDO.getProvinceName());
        assertEquals(provinceShort, gasProvinceDO.getProvinceShort());
        assertEquals(provinceChar, gasProvinceDO.getProvinceChar());
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
			Long id, 
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
	public void cleanGasProvinceById(Long id) {
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
     * 查询gas_province表所有数据
     */
    public List<GasProvinceDO> findGasProvinceAll() {
        GasProvinceDOExample exam = new GasProvinceDOExample();
        exam.createCriteria();
		return gasProvinceDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_province表数据
	 */
	public List<GasProvinceDO> findGasProvinceById(Long id) {
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
	public void updateGasProvinceById(Long id,GasProvinceDO gasProvinceDO) {
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
	 * 断言gas_role表
	 */
	public void gasRoleAssert(
	        GasRoleDO gasRoleDO,
			Long id, 
			String roleType, 
			Long parentId, 
			String roleName, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasRoleDO.getId());
        assertEquals(roleType, gasRoleDO.getRoleType());
        assertEquals(parentId, gasRoleDO.getParentId());
        assertEquals(roleName, gasRoleDO.getRoleName());
        assertEquals(memo, gasRoleDO.getMemo());
        assertEquals(rawAddTime, gasRoleDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasRoleDO.getRawUpdateTime());
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
			Long id, 
			String roleType, 
			Long parentId, 
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
	public void cleanGasRoleById(Long id) {
		GasRoleDOExample exam = new GasRoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasRoleDAO.deleteByExample(exam);
	}

	/**
	 * 根据parentId删除gas_role表数据
	 */
	public void cleanGasRoleByParentId(Long parentId) {
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
     * 查询gas_role表所有数据
     */
    public List<GasRoleDO> findGasRoleAll() {
        GasRoleDOExample exam = new GasRoleDOExample();
        exam.createCriteria();
		return gasRoleDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_role表数据
	 */
	public List<GasRoleDO> findGasRoleById(Long id) {
		GasRoleDOExample exam = new GasRoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasRoleDAO.selectByExample(exam);
	}

    /**
	 * 根据parentId查询gas_role表数据
	 */
	public List<GasRoleDO> findGasRoleByParentId(Long parentId) {
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
	public void updateGasRoleById(Long id,GasRoleDO gasRoleDO) {
		GasRoleDOExample exam = new GasRoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasRoleDAO.updateByExample(gasRoleDO, exam);
	}

    /**
	 * 根据parentId更新gas_role表数据
	 */
	public void updateGasRoleByParentId(Long parentId,GasRoleDO gasRoleDO) {
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
	 * 断言gas_rule_description表
	 */
	public void gasRuleDescriptionAssert(
	        GasRuleDescriptionDO gasRuleDescriptionDO,
			Integer id, 
			String partnerId, 
			String platPartnerId, 
			String ruleType, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String description
	) {
        assertEquals(id, gasRuleDescriptionDO.getId());
        assertEquals(partnerId, gasRuleDescriptionDO.getPartnerId());
        assertEquals(platPartnerId, gasRuleDescriptionDO.getPlatPartnerId());
        assertEquals(ruleType, gasRuleDescriptionDO.getRuleType());
        assertEquals(rawAddTime, gasRuleDescriptionDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasRuleDescriptionDO.getRawUpdateTime());
        assertEquals(description, gasRuleDescriptionDO.getDescription());
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
			String platPartnerId, 
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
		gasRuleDescriptionDO.setPlatPartnerId(platPartnerId);
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
	 * 根据platPartnerId删除gas_rule_description表数据
	 */
	public void cleanGasRuleDescriptionByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasRuleDescriptionDOExample exam = new GasRuleDescriptionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasRuleDescriptionDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_rule_description表所有数据
     */
    public List<GasRuleDescriptionDO> findGasRuleDescriptionAll() {
        GasRuleDescriptionDOExample exam = new GasRuleDescriptionDOExample();
        exam.createCriteria();
		return gasRuleDescriptionDAO.selectByExample(exam);
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
	 * 根据platPartnerId查询gas_rule_description表数据
	 */
	public List<GasRuleDescriptionDO> findGasRuleDescriptionByPlatPartnerId(String platPartnerId) {
		GasRuleDescriptionDOExample exam = new GasRuleDescriptionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	 * 根据platPartnerId更新gas_rule_description表数据
	 */
	public void updateGasRuleDescriptionByPlatPartnerId(String platPartnerId,GasRuleDescriptionDO gasRuleDescriptionDO) {
		GasRuleDescriptionDOExample exam = new GasRuleDescriptionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasRuleDescriptionDAO.updateByExample(gasRuleDescriptionDO, exam);
	}

    /**
	 * 断言gas_station_goods表
	 */
	public void gasStationGoodsAssert(
	        GasStationGoodsDO gasStationGoodsDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String stationId, 
			String goodsName, 
			String goodsCode, 
			String goodsType, 
			Integer orderNo, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasStationGoodsDO.getId());
        assertEquals(partnerId, gasStationGoodsDO.getPartnerId());
        assertEquals(platPartnerId, gasStationGoodsDO.getPlatPartnerId());
        assertEquals(stationId, gasStationGoodsDO.getStationId());
        assertEquals(goodsName, gasStationGoodsDO.getGoodsName());
        assertEquals(goodsCode, gasStationGoodsDO.getGoodsCode());
        assertEquals(goodsType, gasStationGoodsDO.getGoodsType());
        assertEquals(orderNo, gasStationGoodsDO.getOrderNo());
        assertEquals(status, gasStationGoodsDO.getStatus());
        assertEquals(rawAddTime, gasStationGoodsDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasStationGoodsDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_station_goods表数据
	 */
	public void assertGasStationGoods(GasStationGoodsDO expect, GasStationGoodsDO gasStationGoodsDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasStationGoodsDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasStationGoodsDO.getRawAddTime());
		expect.setRawAddTime(gasStationGoodsDO.getRawAddTime());
        Assertions.assertTrue(null != gasStationGoodsDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasStationGoodsDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasStationGoodsDO);
	}

    /**
	 * 插入gas_station_goods表数据
	 */
	public void insertGasStationGoods(GasStationGoodsDO gasStationGoodsDO) {
		gasStationGoodsDAO.insert(gasStationGoodsDO);
	}

    /**
	 * 插入gas_station_goods表数据
	 */
	public void insertGasStationGoods(
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String stationId, 
			String goodsName, 
			String goodsCode, 
			String goodsType, 
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
		GasStationGoodsDO gasStationGoodsDO = new GasStationGoodsDO();
		gasStationGoodsDO.setId(id);
		gasStationGoodsDO.setPartnerId(partnerId);
		gasStationGoodsDO.setPlatPartnerId(platPartnerId);
		gasStationGoodsDO.setStationId(stationId);
		gasStationGoodsDO.setGoodsName(goodsName);
		gasStationGoodsDO.setGoodsCode(goodsCode);
		gasStationGoodsDO.setGoodsType(goodsType);
		gasStationGoodsDO.setOrderNo(orderNo);
		gasStationGoodsDO.setStatus(status);
		gasStationGoodsDO.setRawAddTime(rawAddTime);
		gasStationGoodsDO.setRawUpdateTime(rawUpdateTime);
		gasStationGoodsDAO.insert(gasStationGoodsDO);
	}

    /**
     * 删除gas_station_goods表所有数据
     */
    public void cleanGasStationGoods() {
        GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
        exam.createCriteria();
        gasStationGoodsDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_station_goods表数据
	 */
	public void cleanGasStationGoodsById(Long id) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasStationGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_station_goods表数据
	 */
	public void cleanGasStationGoodsByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasStationGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_station_goods表数据
	 */
	public void cleanGasStationGoodsByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasStationGoodsDAO.deleteByExample(exam);
	}
	/**
	 * 根据stationId,goodsCode删除gas_station_goods表数据
	 */
	public void cleanGasStationGoodsByStationIdAndGoodsCode(String stationId,String goodsCode) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
        if (StringUtils.isBlank(goodsCode)){
            goodsCode = "test_goodsCode";
        }
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId).andGoodsCodeEqualTo(goodsCode);
		gasStationGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_station_goods表数据
	 */
	public void cleanGasStationGoodsByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasStationGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据goodsName删除gas_station_goods表数据
	*/
	public void cleanGasStationGoodsByGoodsName(String goodsName) {
        if (StringUtils.isBlank(goodsName)){
            goodsName = "test_goodsName";
        }
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		gasStationGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据goodsCode删除gas_station_goods表数据
	*/
	public void cleanGasStationGoodsByGoodsCode(String goodsCode) {
        if (StringUtils.isBlank(goodsCode)){
            goodsCode = "test_goodsCode";
        }
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		gasStationGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据orderNo删除gas_station_goods表数据
	 */
	public void cleanGasStationGoodsByOrderNo(Integer orderNo) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		gasStationGoodsDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_station_goods表所有数据
     */
    public List<GasStationGoodsDO> findGasStationGoodsAll() {
        GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
        exam.createCriteria();
		return gasStationGoodsDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_station_goods表数据
	 */
	public List<GasStationGoodsDO> findGasStationGoodsById(Long id) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasStationGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_station_goods表数据
	 */
	public List<GasStationGoodsDO> findGasStationGoodsByPartnerId(String partnerId) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasStationGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_station_goods表数据
	 */
	public List<GasStationGoodsDO> findGasStationGoodsByPlatPartnerId(String platPartnerId) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasStationGoodsDAO.selectByExample(exam);
	}

	/**
	 * 根据stationId,goodsCode查询gas_station_goods表数据
	 */
	public List<GasStationGoodsDO> findGasStationGoodsByStationIdAndGoodsCode(String stationId,String goodsCode) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId).andGoodsCodeEqualTo(goodsCode);
		return gasStationGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_station_goods表数据
	 */
	public List<GasStationGoodsDO> findGasStationGoodsByStationId(String stationId) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasStationGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据goodsName查询gas_station_goods表数据
	*/
	public List<GasStationGoodsDO> findGasStationGoodsByGoodsName(String goodsName) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		return gasStationGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据goodsCode查询gas_station_goods表数据
	*/
	public List<GasStationGoodsDO> findGasStationGoodsByGoodsCode(String goodsCode) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		return gasStationGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据orderNo查询gas_station_goods表数据
	 */
	public List<GasStationGoodsDO> findGasStationGoodsByOrderNo(Integer orderNo) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		return gasStationGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_station_goods表数据
	 */
	public void updateGasStationGoodsById(Long id,GasStationGoodsDO gasStationGoodsDO) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasStationGoodsDAO.updateByExample(gasStationGoodsDO, exam);
	}

    /**
	 * 根据partnerId更新gas_station_goods表数据
	 */
	public void updateGasStationGoodsByPartnerId(String partnerId,GasStationGoodsDO gasStationGoodsDO) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasStationGoodsDAO.updateByExample(gasStationGoodsDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_station_goods表数据
	 */
	public void updateGasStationGoodsByPlatPartnerId(String platPartnerId,GasStationGoodsDO gasStationGoodsDO) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasStationGoodsDAO.updateByExample(gasStationGoodsDO, exam);
	}

	/**
	 * 根据stationId,goodsCode更新gas_station_goods表数据
	 */
	public void updateGasStationGoodsByStationIdAndGoodsCode(String stationId,String goodsCode,GasStationGoodsDO gasStationGoodsDO) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId).andGoodsCodeEqualTo(goodsCode);
		gasStationGoodsDAO.updateByExample(gasStationGoodsDO, exam);
	}

    /**
	 * 根据stationId更新gas_station_goods表数据
	 */
	public void updateGasStationGoodsByStationId(String stationId,GasStationGoodsDO gasStationGoodsDO) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasStationGoodsDAO.updateByExample(gasStationGoodsDO, exam);
	}

	/**
	* 根据goodsName更新gas_station_goods表数据
	*/
	public void updateGasStationGoodsByGoodsName(String goodsName,GasStationGoodsDO gasStationGoodsDO) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		gasStationGoodsDAO.updateByExample(gasStationGoodsDO, exam);
	}

	/**
	* 根据goodsCode更新gas_station_goods表数据
	*/
	public void updateGasStationGoodsByGoodsCode(String goodsCode,GasStationGoodsDO gasStationGoodsDO) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		gasStationGoodsDAO.updateByExample(gasStationGoodsDO, exam);
	}

    /**
	 * 根据orderNo更新gas_station_goods表数据
	 */
	public void updateGasStationGoodsByOrderNo(Integer orderNo,GasStationGoodsDO gasStationGoodsDO) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		gasStationGoodsDAO.updateByExample(gasStationGoodsDO, exam);
	}

    /**
	 * 断言gas_station_goods_price_plan表
	 */
	public void gasStationGoodsPricePlanAssert(
	        GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO,
			Long id, 
			String planId, 
			String merchantPlanId, 
			String priceName, 
			String partnerId, 
			String platPartnerId, 
			String stationId, 
			Date effectTime, 
			String deleteFlag, 
			String operatorId, 
			String operatorName, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String goodsInfo
	) {
        assertEquals(id, gasStationGoodsPricePlanDO.getId());
        assertEquals(planId, gasStationGoodsPricePlanDO.getPlanId());
        assertEquals(merchantPlanId, gasStationGoodsPricePlanDO.getMerchantPlanId());
        assertEquals(priceName, gasStationGoodsPricePlanDO.getPriceName());
        assertEquals(partnerId, gasStationGoodsPricePlanDO.getPartnerId());
        assertEquals(platPartnerId, gasStationGoodsPricePlanDO.getPlatPartnerId());
        assertEquals(stationId, gasStationGoodsPricePlanDO.getStationId());
        assertEquals(effectTime, gasStationGoodsPricePlanDO.getEffectTime());
        assertEquals(deleteFlag, gasStationGoodsPricePlanDO.getDeleteFlag());
        assertEquals(operatorId, gasStationGoodsPricePlanDO.getOperatorId());
        assertEquals(operatorName, gasStationGoodsPricePlanDO.getOperatorName());
        assertEquals(rawAddTime, gasStationGoodsPricePlanDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasStationGoodsPricePlanDO.getRawUpdateTime());
        assertEquals(goodsInfo, gasStationGoodsPricePlanDO.getGoodsInfo());
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
			Long id, 
			String planId, 
			String merchantPlanId, 
			String priceName, 
			String partnerId, 
			String platPartnerId, 
			String stationId, 
			Date effectTime, 
			String deleteFlag, 
			String operatorId, 
			String operatorName, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String goodsInfo
	) {
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
		gasStationGoodsPricePlanDO.setPlatPartnerId(platPartnerId);
		gasStationGoodsPricePlanDO.setStationId(stationId);
		gasStationGoodsPricePlanDO.setEffectTime(effectTime);
		gasStationGoodsPricePlanDO.setDeleteFlag(deleteFlag);
		gasStationGoodsPricePlanDO.setOperatorId(operatorId);
		gasStationGoodsPricePlanDO.setOperatorName(operatorName);
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
	public void cleanGasStationGoodsPricePlanById(Long id) {
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
	 * 根据platPartnerId删除gas_station_goods_price_plan表数据
	 */
	public void cleanGasStationGoodsPricePlanByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	 * 根据operatorId删除gas_station_goods_price_plan表数据
	 */
	public void cleanGasStationGoodsPricePlanByOperatorId(String operatorId) {
        if (StringUtils.isBlank(operatorId)){
            operatorId = "test_operatorId";
        }
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		gasStationGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	* 根据operatorName删除gas_station_goods_price_plan表数据
	*/
	public void cleanGasStationGoodsPricePlanByOperatorName(String operatorName) {
        if (StringUtils.isBlank(operatorName)){
            operatorName = "test_operatorName";
        }
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		gasStationGoodsPricePlanDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_station_goods_price_plan表所有数据
     */
    public List<GasStationGoodsPricePlanDO> findGasStationGoodsPricePlanAll() {
        GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
        exam.createCriteria();
		return gasStationGoodsPricePlanDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_station_goods_price_plan表数据
	 */
	public List<GasStationGoodsPricePlanDO> findGasStationGoodsPricePlanById(Long id) {
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
	 * 根据platPartnerId查询gas_station_goods_price_plan表数据
	 */
	public List<GasStationGoodsPricePlanDO> findGasStationGoodsPricePlanByPlatPartnerId(String platPartnerId) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	 * 根据operatorId查询gas_station_goods_price_plan表数据
	 */
	public List<GasStationGoodsPricePlanDO> findGasStationGoodsPricePlanByOperatorId(String operatorId) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		return gasStationGoodsPricePlanDAO.selectByExample(exam);
	}

	/**
	* 根据operatorName查询gas_station_goods_price_plan表数据
	*/
	public List<GasStationGoodsPricePlanDO> findGasStationGoodsPricePlanByOperatorName(String operatorName) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		return gasStationGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_station_goods_price_plan表数据
	 */
	public void updateGasStationGoodsPricePlanById(Long id,GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
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
	 * 根据platPartnerId更新gas_station_goods_price_plan表数据
	 */
	public void updateGasStationGoodsPricePlanByPlatPartnerId(String platPartnerId,GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	 * 根据operatorId更新gas_station_goods_price_plan表数据
	 */
	public void updateGasStationGoodsPricePlanByOperatorId(String operatorId,GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		gasStationGoodsPricePlanDAO.updateByExample(gasStationGoodsPricePlanDO, exam);
	}

	/**
	* 根据operatorName更新gas_station_goods_price_plan表数据
	*/
	public void updateGasStationGoodsPricePlanByOperatorName(String operatorName,GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		gasStationGoodsPricePlanDAO.updateByExample(gasStationGoodsPricePlanDO, exam);
	}

    /**
	 * 断言gas_station_oil_gun表
	 */
	public void gasStationOilGunAssert(
	        GasStationOilGunDO gasStationOilGunDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String stationId, 
			String oilGunNo, 
			String goodsCode, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			Integer sortNo
	) {
        assertEquals(id, gasStationOilGunDO.getId());
        assertEquals(partnerId, gasStationOilGunDO.getPartnerId());
        assertEquals(platPartnerId, gasStationOilGunDO.getPlatPartnerId());
        assertEquals(stationId, gasStationOilGunDO.getStationId());
        assertEquals(oilGunNo, gasStationOilGunDO.getOilGunNo());
        assertEquals(goodsCode, gasStationOilGunDO.getGoodsCode());
        assertEquals(rawAddTime, gasStationOilGunDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasStationOilGunDO.getRawUpdateTime());
        assertEquals(sortNo, gasStationOilGunDO.getSortNo());
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
			Long id, 
			String partnerId, 
			String platPartnerId, 
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
		gasStationOilGunDO.setPlatPartnerId(platPartnerId);
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
	public void cleanGasStationOilGunById(Long id) {
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
	 * 根据platPartnerId删除gas_station_oil_gun表数据
	 */
	public void cleanGasStationOilGunByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
     * 查询gas_station_oil_gun表所有数据
     */
    public List<GasStationOilGunDO> findGasStationOilGunAll() {
        GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
        exam.createCriteria();
		return gasStationOilGunDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_station_oil_gun表数据
	 */
	public List<GasStationOilGunDO> findGasStationOilGunById(Long id) {
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
	 * 根据platPartnerId查询gas_station_oil_gun表数据
	 */
	public List<GasStationOilGunDO> findGasStationOilGunByPlatPartnerId(String platPartnerId) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	public void updateGasStationOilGunById(Long id,GasStationOilGunDO gasStationOilGunDO) {
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
	 * 根据platPartnerId更新gas_station_oil_gun表数据
	 */
	public void updateGasStationOilGunByPlatPartnerId(String platPartnerId,GasStationOilGunDO gasStationOilGunDO) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
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
	 * 断言gas_station_voice_broadcast表
	 */
	public void gasStationVoiceBroadcastAssert(
	        GasStationVoiceBroadcastDO gasStationVoiceBroadcastDO,
			Integer id, 
			String stationId, 
			String broadcastType, 
			String fieldCodes, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasStationVoiceBroadcastDO.getId());
        assertEquals(stationId, gasStationVoiceBroadcastDO.getStationId());
        assertEquals(broadcastType, gasStationVoiceBroadcastDO.getBroadcastType());
        assertEquals(fieldCodes, gasStationVoiceBroadcastDO.getFieldCodes());
        assertEquals(rawAddTime, gasStationVoiceBroadcastDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasStationVoiceBroadcastDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_station_voice_broadcast表数据
	 */
	public void assertGasStationVoiceBroadcast(GasStationVoiceBroadcastDO expect, GasStationVoiceBroadcastDO gasStationVoiceBroadcastDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasStationVoiceBroadcastDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasStationVoiceBroadcastDO.getRawAddTime());
		expect.setRawAddTime(gasStationVoiceBroadcastDO.getRawAddTime());
        Assertions.assertTrue(null != gasStationVoiceBroadcastDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasStationVoiceBroadcastDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasStationVoiceBroadcastDO);
	}

    /**
	 * 插入gas_station_voice_broadcast表数据
	 */
	public void insertGasStationVoiceBroadcast(GasStationVoiceBroadcastDO gasStationVoiceBroadcastDO) {
		gasStationVoiceBroadcastDAO.insert(gasStationVoiceBroadcastDO);
	}

    /**
	 * 插入gas_station_voice_broadcast表数据
	 */
	public void insertGasStationVoiceBroadcast(
			Integer id, 
			String stationId, 
			String broadcastType, 
			String fieldCodes, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasStationVoiceBroadcastDO gasStationVoiceBroadcastDO = new GasStationVoiceBroadcastDO();
		gasStationVoiceBroadcastDO.setId(id);
		gasStationVoiceBroadcastDO.setStationId(stationId);
		gasStationVoiceBroadcastDO.setBroadcastType(broadcastType);
		gasStationVoiceBroadcastDO.setFieldCodes(fieldCodes);
		gasStationVoiceBroadcastDO.setRawAddTime(rawAddTime);
		gasStationVoiceBroadcastDO.setRawUpdateTime(rawUpdateTime);
		gasStationVoiceBroadcastDAO.insert(gasStationVoiceBroadcastDO);
	}

    /**
     * 删除gas_station_voice_broadcast表所有数据
     */
    public void cleanGasStationVoiceBroadcast() {
        GasStationVoiceBroadcastDOExample exam = new GasStationVoiceBroadcastDOExample();
        exam.createCriteria();
        gasStationVoiceBroadcastDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_station_voice_broadcast表数据
	 */
	public void cleanGasStationVoiceBroadcastById(Integer id) {
		GasStationVoiceBroadcastDOExample exam = new GasStationVoiceBroadcastDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasStationVoiceBroadcastDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_station_voice_broadcast表数据
	 */
	public void cleanGasStationVoiceBroadcastByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasStationVoiceBroadcastDOExample exam = new GasStationVoiceBroadcastDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasStationVoiceBroadcastDAO.deleteByExample(exam);
	}

	/**
	* 根据fieldCodes删除gas_station_voice_broadcast表数据
	*/
	public void cleanGasStationVoiceBroadcastByFieldCodes(String fieldCodes) {
        if (StringUtils.isBlank(fieldCodes)){
            fieldCodes = "test_fieldCodes";
        }
		GasStationVoiceBroadcastDOExample exam = new GasStationVoiceBroadcastDOExample();
		exam.createCriteria().andFieldCodesEqualTo(fieldCodes);
		gasStationVoiceBroadcastDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_station_voice_broadcast表所有数据
     */
    public List<GasStationVoiceBroadcastDO> findGasStationVoiceBroadcastAll() {
        GasStationVoiceBroadcastDOExample exam = new GasStationVoiceBroadcastDOExample();
        exam.createCriteria();
		return gasStationVoiceBroadcastDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_station_voice_broadcast表数据
	 */
	public List<GasStationVoiceBroadcastDO> findGasStationVoiceBroadcastById(Integer id) {
		GasStationVoiceBroadcastDOExample exam = new GasStationVoiceBroadcastDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasStationVoiceBroadcastDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_station_voice_broadcast表数据
	 */
	public List<GasStationVoiceBroadcastDO> findGasStationVoiceBroadcastByStationId(String stationId) {
		GasStationVoiceBroadcastDOExample exam = new GasStationVoiceBroadcastDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasStationVoiceBroadcastDAO.selectByExample(exam);
	}

	/**
	* 根据fieldCodes查询gas_station_voice_broadcast表数据
	*/
	public List<GasStationVoiceBroadcastDO> findGasStationVoiceBroadcastByFieldCodes(String fieldCodes) {
		GasStationVoiceBroadcastDOExample exam = new GasStationVoiceBroadcastDOExample();
		exam.createCriteria().andFieldCodesEqualTo(fieldCodes);
		return gasStationVoiceBroadcastDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_station_voice_broadcast表数据
	 */
	public void updateGasStationVoiceBroadcastById(Integer id,GasStationVoiceBroadcastDO gasStationVoiceBroadcastDO) {
		GasStationVoiceBroadcastDOExample exam = new GasStationVoiceBroadcastDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasStationVoiceBroadcastDAO.updateByExample(gasStationVoiceBroadcastDO, exam);
	}

    /**
	 * 根据stationId更新gas_station_voice_broadcast表数据
	 */
	public void updateGasStationVoiceBroadcastByStationId(String stationId,GasStationVoiceBroadcastDO gasStationVoiceBroadcastDO) {
		GasStationVoiceBroadcastDOExample exam = new GasStationVoiceBroadcastDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasStationVoiceBroadcastDAO.updateByExample(gasStationVoiceBroadcastDO, exam);
	}

	/**
	* 根据fieldCodes更新gas_station_voice_broadcast表数据
	*/
	public void updateGasStationVoiceBroadcastByFieldCodes(String fieldCodes,GasStationVoiceBroadcastDO gasStationVoiceBroadcastDO) {
		GasStationVoiceBroadcastDOExample exam = new GasStationVoiceBroadcastDOExample();
		exam.createCriteria().andFieldCodesEqualTo(fieldCodes);
		gasStationVoiceBroadcastDAO.updateByExample(gasStationVoiceBroadcastDO, exam);
	}

    /**
	 * 断言gas_ticket_print表
	 */
	public void gasTicketPrintAssert(
	        GasTicketPrintDO gasTicketPrintDO,
			Integer id, 
			String stationId, 
			String printType, 
			Integer printNum, 
			Integer printSleep, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasTicketPrintDO.getId());
        assertEquals(stationId, gasTicketPrintDO.getStationId());
        assertEquals(printType, gasTicketPrintDO.getPrintType());
        assertEquals(printNum, gasTicketPrintDO.getPrintNum());
        assertEquals(printSleep, gasTicketPrintDO.getPrintSleep());
        assertEquals(memo, gasTicketPrintDO.getMemo());
        assertEquals(rawAddTime, gasTicketPrintDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasTicketPrintDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_ticket_print表数据
	 */
	public void assertGasTicketPrint(GasTicketPrintDO expect, GasTicketPrintDO gasTicketPrintDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasTicketPrintDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasTicketPrintDO.getRawAddTime());
		expect.setRawAddTime(gasTicketPrintDO.getRawAddTime());
        Assertions.assertTrue(null != gasTicketPrintDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasTicketPrintDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasTicketPrintDO);
	}

    /**
	 * 插入gas_ticket_print表数据
	 */
	public void insertGasTicketPrint(GasTicketPrintDO gasTicketPrintDO) {
		gasTicketPrintDAO.insert(gasTicketPrintDO);
	}

    /**
	 * 插入gas_ticket_print表数据
	 */
	public void insertGasTicketPrint(
			Integer id, 
			String stationId, 
			String printType, 
			Integer printNum, 
			Integer printSleep, 
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
		GasTicketPrintDO gasTicketPrintDO = new GasTicketPrintDO();
		gasTicketPrintDO.setId(id);
		gasTicketPrintDO.setStationId(stationId);
		gasTicketPrintDO.setPrintType(printType);
		gasTicketPrintDO.setPrintNum(printNum);
		gasTicketPrintDO.setPrintSleep(printSleep);
		gasTicketPrintDO.setMemo(memo);
		gasTicketPrintDO.setRawAddTime(rawAddTime);
		gasTicketPrintDO.setRawUpdateTime(rawUpdateTime);
		gasTicketPrintDAO.insert(gasTicketPrintDO);
	}

    /**
     * 删除gas_ticket_print表所有数据
     */
    public void cleanGasTicketPrint() {
        GasTicketPrintDOExample exam = new GasTicketPrintDOExample();
        exam.createCriteria();
        gasTicketPrintDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_ticket_print表数据
	 */
	public void cleanGasTicketPrintById(Integer id) {
		GasTicketPrintDOExample exam = new GasTicketPrintDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasTicketPrintDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_ticket_print表数据
	 */
	public void cleanGasTicketPrintByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasTicketPrintDOExample exam = new GasTicketPrintDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasTicketPrintDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_ticket_print表所有数据
     */
    public List<GasTicketPrintDO> findGasTicketPrintAll() {
        GasTicketPrintDOExample exam = new GasTicketPrintDOExample();
        exam.createCriteria();
		return gasTicketPrintDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_ticket_print表数据
	 */
	public List<GasTicketPrintDO> findGasTicketPrintById(Integer id) {
		GasTicketPrintDOExample exam = new GasTicketPrintDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasTicketPrintDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_ticket_print表数据
	 */
	public List<GasTicketPrintDO> findGasTicketPrintByStationId(String stationId) {
		GasTicketPrintDOExample exam = new GasTicketPrintDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasTicketPrintDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_ticket_print表数据
	 */
	public void updateGasTicketPrintById(Integer id,GasTicketPrintDO gasTicketPrintDO) {
		GasTicketPrintDOExample exam = new GasTicketPrintDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasTicketPrintDAO.updateByExample(gasTicketPrintDO, exam);
	}

    /**
	 * 根据stationId更新gas_ticket_print表数据
	 */
	public void updateGasTicketPrintByStationId(String stationId,GasTicketPrintDO gasTicketPrintDO) {
		GasTicketPrintDOExample exam = new GasTicketPrintDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasTicketPrintDAO.updateByExample(gasTicketPrintDO, exam);
	}

    /**
	 * 断言gas_voice_broadcast_field表
	 */
	public void gasVoiceBroadcastFieldAssert(
	        GasVoiceBroadcastFieldDO gasVoiceBroadcastFieldDO,
			Integer id, 
			String broadcastType, 
			String fieldCode, 
			String fieldName, 
			String preValue, 
			String defaultValue, 
			String suffixValue, 
			String required, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasVoiceBroadcastFieldDO.getId());
        assertEquals(broadcastType, gasVoiceBroadcastFieldDO.getBroadcastType());
        assertEquals(fieldCode, gasVoiceBroadcastFieldDO.getFieldCode());
        assertEquals(fieldName, gasVoiceBroadcastFieldDO.getFieldName());
        assertEquals(preValue, gasVoiceBroadcastFieldDO.getPreValue());
        assertEquals(defaultValue, gasVoiceBroadcastFieldDO.getDefaultValue());
        assertEquals(suffixValue, gasVoiceBroadcastFieldDO.getSuffixValue());
        assertEquals(required, gasVoiceBroadcastFieldDO.getRequired());
        assertEquals(rawAddTime, gasVoiceBroadcastFieldDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasVoiceBroadcastFieldDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_voice_broadcast_field表数据
	 */
	public void assertGasVoiceBroadcastField(GasVoiceBroadcastFieldDO expect, GasVoiceBroadcastFieldDO gasVoiceBroadcastFieldDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasVoiceBroadcastFieldDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasVoiceBroadcastFieldDO.getRawAddTime());
		expect.setRawAddTime(gasVoiceBroadcastFieldDO.getRawAddTime());
        Assertions.assertTrue(null != gasVoiceBroadcastFieldDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasVoiceBroadcastFieldDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasVoiceBroadcastFieldDO);
	}

    /**
	 * 插入gas_voice_broadcast_field表数据
	 */
	public void insertGasVoiceBroadcastField(GasVoiceBroadcastFieldDO gasVoiceBroadcastFieldDO) {
		gasVoiceBroadcastFieldDAO.insert(gasVoiceBroadcastFieldDO);
	}

    /**
	 * 插入gas_voice_broadcast_field表数据
	 */
	public void insertGasVoiceBroadcastField(
			Integer id, 
			String broadcastType, 
			String fieldCode, 
			String fieldName, 
			String preValue, 
			String defaultValue, 
			String suffixValue, 
			String required, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasVoiceBroadcastFieldDO gasVoiceBroadcastFieldDO = new GasVoiceBroadcastFieldDO();
		gasVoiceBroadcastFieldDO.setId(id);
		gasVoiceBroadcastFieldDO.setBroadcastType(broadcastType);
		gasVoiceBroadcastFieldDO.setFieldCode(fieldCode);
		gasVoiceBroadcastFieldDO.setFieldName(fieldName);
		gasVoiceBroadcastFieldDO.setPreValue(preValue);
		gasVoiceBroadcastFieldDO.setDefaultValue(defaultValue);
		gasVoiceBroadcastFieldDO.setSuffixValue(suffixValue);
		gasVoiceBroadcastFieldDO.setRequired(required);
		gasVoiceBroadcastFieldDO.setRawAddTime(rawAddTime);
		gasVoiceBroadcastFieldDO.setRawUpdateTime(rawUpdateTime);
		gasVoiceBroadcastFieldDAO.insert(gasVoiceBroadcastFieldDO);
	}

    /**
     * 删除gas_voice_broadcast_field表所有数据
     */
    public void cleanGasVoiceBroadcastField() {
        GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
        exam.createCriteria();
        gasVoiceBroadcastFieldDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_voice_broadcast_field表数据
	 */
	public void cleanGasVoiceBroadcastFieldById(Integer id) {
		GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasVoiceBroadcastFieldDAO.deleteByExample(exam);
	}
	/**
	 * 根据broadcastType,fieldCode删除gas_voice_broadcast_field表数据
	 */
	public void cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(String broadcastType,String fieldCode) {
        if (StringUtils.isBlank(broadcastType)){
            broadcastType = "test_broadcastType";
        }
        if (StringUtils.isBlank(fieldCode)){
            fieldCode = "test_fieldCode";
        }
		GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
		exam.createCriteria().andBroadcastTypeEqualTo(broadcastType).andFieldCodeEqualTo(fieldCode);
		gasVoiceBroadcastFieldDAO.deleteByExample(exam);
	}

	/**
	* 根据fieldCode删除gas_voice_broadcast_field表数据
	*/
	public void cleanGasVoiceBroadcastFieldByFieldCode(String fieldCode) {
        if (StringUtils.isBlank(fieldCode)){
            fieldCode = "test_fieldCode";
        }
		GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
		exam.createCriteria().andFieldCodeEqualTo(fieldCode);
		gasVoiceBroadcastFieldDAO.deleteByExample(exam);
	}

	/**
	* 根据fieldName删除gas_voice_broadcast_field表数据
	*/
	public void cleanGasVoiceBroadcastFieldByFieldName(String fieldName) {
        if (StringUtils.isBlank(fieldName)){
            fieldName = "test_fieldName";
        }
		GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
		exam.createCriteria().andFieldNameEqualTo(fieldName);
		gasVoiceBroadcastFieldDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_voice_broadcast_field表所有数据
     */
    public List<GasVoiceBroadcastFieldDO> findGasVoiceBroadcastFieldAll() {
        GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
        exam.createCriteria();
		return gasVoiceBroadcastFieldDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_voice_broadcast_field表数据
	 */
	public List<GasVoiceBroadcastFieldDO> findGasVoiceBroadcastFieldById(Integer id) {
		GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasVoiceBroadcastFieldDAO.selectByExample(exam);
	}

	/**
	 * 根据broadcastType,fieldCode查询gas_voice_broadcast_field表数据
	 */
	public List<GasVoiceBroadcastFieldDO> findGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(String broadcastType,String fieldCode) {
		GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
		exam.createCriteria().andBroadcastTypeEqualTo(broadcastType).andFieldCodeEqualTo(fieldCode);
		return gasVoiceBroadcastFieldDAO.selectByExample(exam);
	}

	/**
	* 根据fieldCode查询gas_voice_broadcast_field表数据
	*/
	public List<GasVoiceBroadcastFieldDO> findGasVoiceBroadcastFieldByFieldCode(String fieldCode) {
		GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
		exam.createCriteria().andFieldCodeEqualTo(fieldCode);
		return gasVoiceBroadcastFieldDAO.selectByExample(exam);
	}

	/**
	* 根据fieldName查询gas_voice_broadcast_field表数据
	*/
	public List<GasVoiceBroadcastFieldDO> findGasVoiceBroadcastFieldByFieldName(String fieldName) {
		GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
		exam.createCriteria().andFieldNameEqualTo(fieldName);
		return gasVoiceBroadcastFieldDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_voice_broadcast_field表数据
	 */
	public void updateGasVoiceBroadcastFieldById(Integer id,GasVoiceBroadcastFieldDO gasVoiceBroadcastFieldDO) {
		GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasVoiceBroadcastFieldDAO.updateByExample(gasVoiceBroadcastFieldDO, exam);
	}

	/**
	 * 根据broadcastType,fieldCode更新gas_voice_broadcast_field表数据
	 */
	public void updateGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(String broadcastType,String fieldCode,GasVoiceBroadcastFieldDO gasVoiceBroadcastFieldDO) {
		GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
		exam.createCriteria().andBroadcastTypeEqualTo(broadcastType).andFieldCodeEqualTo(fieldCode);
		gasVoiceBroadcastFieldDAO.updateByExample(gasVoiceBroadcastFieldDO, exam);
	}

	/**
	* 根据fieldCode更新gas_voice_broadcast_field表数据
	*/
	public void updateGasVoiceBroadcastFieldByFieldCode(String fieldCode,GasVoiceBroadcastFieldDO gasVoiceBroadcastFieldDO) {
		GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
		exam.createCriteria().andFieldCodeEqualTo(fieldCode);
		gasVoiceBroadcastFieldDAO.updateByExample(gasVoiceBroadcastFieldDO, exam);
	}

	/**
	* 根据fieldName更新gas_voice_broadcast_field表数据
	*/
	public void updateGasVoiceBroadcastFieldByFieldName(String fieldName,GasVoiceBroadcastFieldDO gasVoiceBroadcastFieldDO) {
		GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
		exam.createCriteria().andFieldNameEqualTo(fieldName);
		gasVoiceBroadcastFieldDAO.updateByExample(gasVoiceBroadcastFieldDO, exam);
	}

    /**
	 * 断言merchant_product表
	 */
	public void merchantProductAssert(
	        MerchantProductDO merchantProductDO,
			Long id, 
			String productId, 
			String platPartnerId, 
			String status
	) {
        assertEquals(id, merchantProductDO.getId());
        assertEquals(productId, merchantProductDO.getProductId());
        assertEquals(platPartnerId, merchantProductDO.getPlatPartnerId());
        assertEquals(status, merchantProductDO.getStatus());
	}

	/**
	 * 断言merchant_product表数据
	 */
	public void assertMerchantProduct(MerchantProductDO expect, MerchantProductDO merchantProductDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			merchantProductDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, merchantProductDO);
	}

    /**
	 * 插入merchant_product表数据
	 */
	public void insertMerchantProduct(MerchantProductDO merchantProductDO) {
		merchantProductDAO.insert(merchantProductDO);
	}

    /**
	 * 插入merchant_product表数据
	 */
	public void insertMerchantProduct(
			Long id, 
			String productId, 
			String platPartnerId, 
			String status
	) {
		MerchantProductDO merchantProductDO = new MerchantProductDO();
		merchantProductDO.setId(id);
		merchantProductDO.setProductId(productId);
		merchantProductDO.setPlatPartnerId(platPartnerId);
		merchantProductDO.setStatus(status);
		merchantProductDAO.insert(merchantProductDO);
	}

    /**
     * 删除merchant_product表所有数据
     */
    public void cleanMerchantProduct() {
        MerchantProductDOExample exam = new MerchantProductDOExample();
        exam.createCriteria();
        merchantProductDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除merchant_product表数据
	 */
	public void cleanMerchantProductById(Long id) {
		MerchantProductDOExample exam = new MerchantProductDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantProductDAO.deleteByExample(exam);
	}

	/**
	 * 根据productId删除merchant_product表数据
	 */
	public void cleanMerchantProductByProductId(String productId) {
        if (StringUtils.isBlank(productId)){
            productId = "test_productId";
        }
		MerchantProductDOExample exam = new MerchantProductDOExample();
		exam.createCriteria().andProductIdEqualTo(productId);
		merchantProductDAO.deleteByExample(exam);
	}
	/**
	 * 根据platPartnerId,id删除merchant_product表数据
	 */
	public void cleanMerchantProductByPlatPartnerIdAndId(String platPartnerId,Long id) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		MerchantProductDOExample exam = new MerchantProductDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId).andIdEqualTo(id);
		merchantProductDAO.deleteByExample(exam);
	}
	/**
	 * 根据platPartnerId,productId删除merchant_product表数据
	 */
	public void cleanMerchantProductByPlatPartnerIdAndProductId(String platPartnerId,String productId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
        if (StringUtils.isBlank(productId)){
            productId = "test_productId";
        }
		MerchantProductDOExample exam = new MerchantProductDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId).andProductIdEqualTo(productId);
		merchantProductDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除merchant_product表数据
	 */
	public void cleanMerchantProductByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		MerchantProductDOExample exam = new MerchantProductDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		merchantProductDAO.deleteByExample(exam);
	}

    /**
     * 查询merchant_product表所有数据
     */
    public List<MerchantProductDO> findMerchantProductAll() {
        MerchantProductDOExample exam = new MerchantProductDOExample();
        exam.createCriteria();
		return merchantProductDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询merchant_product表数据
	 */
	public List<MerchantProductDO> findMerchantProductById(Long id) {
		MerchantProductDOExample exam = new MerchantProductDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return merchantProductDAO.selectByExample(exam);
	}

    /**
	 * 根据productId查询merchant_product表数据
	 */
	public List<MerchantProductDO> findMerchantProductByProductId(String productId) {
		MerchantProductDOExample exam = new MerchantProductDOExample();
		exam.createCriteria().andProductIdEqualTo(productId);
		return merchantProductDAO.selectByExample(exam);
	}

	/**
	 * 根据platPartnerId,id查询merchant_product表数据
	 */
	public List<MerchantProductDO> findMerchantProductByPlatPartnerIdAndId(String platPartnerId,Long id) {
		MerchantProductDOExample exam = new MerchantProductDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId).andIdEqualTo(id);
		return merchantProductDAO.selectByExample(exam);
	}

	/**
	 * 根据platPartnerId,productId查询merchant_product表数据
	 */
	public List<MerchantProductDO> findMerchantProductByPlatPartnerIdAndProductId(String platPartnerId,String productId) {
		MerchantProductDOExample exam = new MerchantProductDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId).andProductIdEqualTo(productId);
		return merchantProductDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询merchant_product表数据
	 */
	public List<MerchantProductDO> findMerchantProductByPlatPartnerId(String platPartnerId) {
		MerchantProductDOExample exam = new MerchantProductDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return merchantProductDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新merchant_product表数据
	 */
	public void updateMerchantProductById(Long id,MerchantProductDO merchantProductDO) {
		MerchantProductDOExample exam = new MerchantProductDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantProductDAO.updateByExample(merchantProductDO, exam);
	}

    /**
	 * 根据productId更新merchant_product表数据
	 */
	public void updateMerchantProductByProductId(String productId,MerchantProductDO merchantProductDO) {
		MerchantProductDOExample exam = new MerchantProductDOExample();
		exam.createCriteria().andProductIdEqualTo(productId);
		merchantProductDAO.updateByExample(merchantProductDO, exam);
	}

	/**
	 * 根据platPartnerId,id更新merchant_product表数据
	 */
	public void updateMerchantProductByPlatPartnerIdAndId(String platPartnerId,Long id,MerchantProductDO merchantProductDO) {
		MerchantProductDOExample exam = new MerchantProductDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId).andIdEqualTo(id);
		merchantProductDAO.updateByExample(merchantProductDO, exam);
	}

	/**
	 * 根据platPartnerId,productId更新merchant_product表数据
	 */
	public void updateMerchantProductByPlatPartnerIdAndProductId(String platPartnerId,String productId,MerchantProductDO merchantProductDO) {
		MerchantProductDOExample exam = new MerchantProductDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId).andProductIdEqualTo(productId);
		merchantProductDAO.updateByExample(merchantProductDO, exam);
	}

    /**
	 * 根据platPartnerId更新merchant_product表数据
	 */
	public void updateMerchantProductByPlatPartnerId(String platPartnerId,MerchantProductDO merchantProductDO) {
		MerchantProductDOExample exam = new MerchantProductDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		merchantProductDAO.updateByExample(merchantProductDO, exam);
	}

    /**
	 * 断言merchant_protocol_rule表
	 */
	public void merchantProtocolRuleAssert(
	        MerchantProtocolRuleDO merchantProtocolRuleDO,
			Long id, 
			String platPartnerId, 
			String status, 
			String ruleType, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String protocol, 
			String description, 
			String ruleData
	) {
        assertEquals(id, merchantProtocolRuleDO.getId());
        assertEquals(platPartnerId, merchantProtocolRuleDO.getPlatPartnerId());
        assertEquals(status, merchantProtocolRuleDO.getStatus());
        assertEquals(ruleType, merchantProtocolRuleDO.getRuleType());
        assertEquals(rawAddTime, merchantProtocolRuleDO.getRawAddTime());
        assertEquals(rawUpdateTime, merchantProtocolRuleDO.getRawUpdateTime());
        assertEquals(protocol, merchantProtocolRuleDO.getProtocol());
        assertEquals(description, merchantProtocolRuleDO.getDescription());
        assertEquals(ruleData, merchantProtocolRuleDO.getRuleData());
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
			Long id, 
			String platPartnerId, 
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
		merchantProtocolRuleDO.setPlatPartnerId(platPartnerId);
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
	public void cleanMerchantProtocolRuleById(Long id) {
		MerchantProtocolRuleDOExample exam = new MerchantProtocolRuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantProtocolRuleDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除merchant_protocol_rule表数据
	 */
	public void cleanMerchantProtocolRuleByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		MerchantProtocolRuleDOExample exam = new MerchantProtocolRuleDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		merchantProtocolRuleDAO.deleteByExample(exam);
	}

    /**
     * 查询merchant_protocol_rule表所有数据
     */
    public List<MerchantProtocolRuleDO> findMerchantProtocolRuleAll() {
        MerchantProtocolRuleDOExample exam = new MerchantProtocolRuleDOExample();
        exam.createCriteria();
		return merchantProtocolRuleDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询merchant_protocol_rule表数据
	 */
	public List<MerchantProtocolRuleDO> findMerchantProtocolRuleById(Long id) {
		MerchantProtocolRuleDOExample exam = new MerchantProtocolRuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return merchantProtocolRuleDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询merchant_protocol_rule表数据
	 */
	public List<MerchantProtocolRuleDO> findMerchantProtocolRuleByPlatPartnerId(String platPartnerId) {
		MerchantProtocolRuleDOExample exam = new MerchantProtocolRuleDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return merchantProtocolRuleDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新merchant_protocol_rule表数据
	 */
	public void updateMerchantProtocolRuleById(Long id,MerchantProtocolRuleDO merchantProtocolRuleDO) {
		MerchantProtocolRuleDOExample exam = new MerchantProtocolRuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantProtocolRuleDAO.updateByExample(merchantProtocolRuleDO, exam);
	}

    /**
	 * 根据platPartnerId更新merchant_protocol_rule表数据
	 */
	public void updateMerchantProtocolRuleByPlatPartnerId(String platPartnerId,MerchantProtocolRuleDO merchantProtocolRuleDO) {
		MerchantProtocolRuleDOExample exam = new MerchantProtocolRuleDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		merchantProtocolRuleDAO.updateByExample(merchantProtocolRuleDO, exam);
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
	 * 断言permission表
	 */
	public void permissionAssert(
	        PermissionDO permissionDO,
			Long id, 
			String deviceType, 
			String permissionId, 
			String parentId, 
			String name, 
			String code, 
			String url, 
			String resourceType, 
			String permissionCategory, 
			Integer orderNo, 
			String icon, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, permissionDO.getId());
        assertEquals(deviceType, permissionDO.getDeviceType());
        assertEquals(permissionId, permissionDO.getPermissionId());
        assertEquals(parentId, permissionDO.getParentId());
        assertEquals(name, permissionDO.getName());
        assertEquals(code, permissionDO.getCode());
        assertEquals(url, permissionDO.getUrl());
        assertEquals(resourceType, permissionDO.getResourceType());
        assertEquals(permissionCategory, permissionDO.getPermissionCategory());
        assertEquals(orderNo, permissionDO.getOrderNo());
        assertEquals(icon, permissionDO.getIcon());
        assertEquals(memo, permissionDO.getMemo());
        assertEquals(rawAddTime, permissionDO.getRawAddTime());
        assertEquals(rawUpdateTime, permissionDO.getRawUpdateTime());
	}

	/**
	 * 断言permission表数据
	 */
	public void assertPermission(PermissionDO expect, PermissionDO permissionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			permissionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != permissionDO.getRawAddTime());
		expect.setRawAddTime(permissionDO.getRawAddTime());
        Assertions.assertTrue(null != permissionDO.getRawUpdateTime());
		expect.setRawUpdateTime(permissionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, permissionDO);
	}

    /**
	 * 插入permission表数据
	 */
	public void insertPermission(PermissionDO permissionDO) {
		permissionDAO.insert(permissionDO);
	}

    /**
	 * 插入permission表数据
	 */
	public void insertPermission(
			Long id, 
			String deviceType, 
			String permissionId, 
			String parentId, 
			String name, 
			String code, 
			String url, 
			String resourceType, 
			String permissionCategory, 
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
		PermissionDO permissionDO = new PermissionDO();
		permissionDO.setId(id);
		permissionDO.setDeviceType(deviceType);
		permissionDO.setPermissionId(permissionId);
		permissionDO.setParentId(parentId);
		permissionDO.setName(name);
		permissionDO.setCode(code);
		permissionDO.setUrl(url);
		permissionDO.setResourceType(resourceType);
		permissionDO.setPermissionCategory(permissionCategory);
		permissionDO.setOrderNo(orderNo);
		permissionDO.setIcon(icon);
		permissionDO.setMemo(memo);
		permissionDO.setRawAddTime(rawAddTime);
		permissionDO.setRawUpdateTime(rawUpdateTime);
		permissionDAO.insert(permissionDO);
	}

    /**
     * 删除permission表所有数据
     */
    public void cleanPermission() {
        PermissionDOExample exam = new PermissionDOExample();
        exam.createCriteria();
        permissionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除permission表数据
	 */
	public void cleanPermissionById(Long id) {
		PermissionDOExample exam = new PermissionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		permissionDAO.deleteByExample(exam);
	}

	/**
	 * 根据permissionId删除permission表数据
	 */
	public void cleanPermissionByPermissionId(String permissionId) {
        if (StringUtils.isBlank(permissionId)){
            permissionId = "test_permissionId";
        }
		PermissionDOExample exam = new PermissionDOExample();
		exam.createCriteria().andPermissionIdEqualTo(permissionId);
		permissionDAO.deleteByExample(exam);
	}

	/**
	 * 根据parentId删除permission表数据
	 */
	public void cleanPermissionByParentId(String parentId) {
        if (StringUtils.isBlank(parentId)){
            parentId = "test_parentId";
        }
		PermissionDOExample exam = new PermissionDOExample();
		exam.createCriteria().andParentIdEqualTo(parentId);
		permissionDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除permission表数据
	*/
	public void cleanPermissionByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		PermissionDOExample exam = new PermissionDOExample();
		exam.createCriteria().andNameEqualTo(name);
		permissionDAO.deleteByExample(exam);
	}

	/**
	* 根据code删除permission表数据
	*/
	public void cleanPermissionByCode(String code) {
        if (StringUtils.isBlank(code)){
            code = "test_code";
        }
		PermissionDOExample exam = new PermissionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		permissionDAO.deleteByExample(exam);
	}

	/**
	 * 根据orderNo删除permission表数据
	 */
	public void cleanPermissionByOrderNo(Integer orderNo) {
		PermissionDOExample exam = new PermissionDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		permissionDAO.deleteByExample(exam);
	}

    /**
     * 查询permission表所有数据
     */
    public List<PermissionDO> findPermissionAll() {
        PermissionDOExample exam = new PermissionDOExample();
        exam.createCriteria();
		return permissionDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询permission表数据
	 */
	public List<PermissionDO> findPermissionById(Long id) {
		PermissionDOExample exam = new PermissionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return permissionDAO.selectByExample(exam);
	}

    /**
	 * 根据permissionId查询permission表数据
	 */
	public List<PermissionDO> findPermissionByPermissionId(String permissionId) {
		PermissionDOExample exam = new PermissionDOExample();
		exam.createCriteria().andPermissionIdEqualTo(permissionId);
		return permissionDAO.selectByExample(exam);
	}

    /**
	 * 根据parentId查询permission表数据
	 */
	public List<PermissionDO> findPermissionByParentId(String parentId) {
		PermissionDOExample exam = new PermissionDOExample();
		exam.createCriteria().andParentIdEqualTo(parentId);
		return permissionDAO.selectByExample(exam);
	}

	/**
	* 根据name查询permission表数据
	*/
	public List<PermissionDO> findPermissionByName(String name) {
		PermissionDOExample exam = new PermissionDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return permissionDAO.selectByExample(exam);
	}

	/**
	* 根据code查询permission表数据
	*/
	public List<PermissionDO> findPermissionByCode(String code) {
		PermissionDOExample exam = new PermissionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		return permissionDAO.selectByExample(exam);
	}

    /**
	 * 根据orderNo查询permission表数据
	 */
	public List<PermissionDO> findPermissionByOrderNo(Integer orderNo) {
		PermissionDOExample exam = new PermissionDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		return permissionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新permission表数据
	 */
	public void updatePermissionById(Long id,PermissionDO permissionDO) {
		PermissionDOExample exam = new PermissionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		permissionDAO.updateByExample(permissionDO, exam);
	}

    /**
	 * 根据permissionId更新permission表数据
	 */
	public void updatePermissionByPermissionId(String permissionId,PermissionDO permissionDO) {
		PermissionDOExample exam = new PermissionDOExample();
		exam.createCriteria().andPermissionIdEqualTo(permissionId);
		permissionDAO.updateByExample(permissionDO, exam);
	}

    /**
	 * 根据parentId更新permission表数据
	 */
	public void updatePermissionByParentId(String parentId,PermissionDO permissionDO) {
		PermissionDOExample exam = new PermissionDOExample();
		exam.createCriteria().andParentIdEqualTo(parentId);
		permissionDAO.updateByExample(permissionDO, exam);
	}

	/**
	* 根据name更新permission表数据
	*/
	public void updatePermissionByName(String name,PermissionDO permissionDO) {
		PermissionDOExample exam = new PermissionDOExample();
		exam.createCriteria().andNameEqualTo(name);
		permissionDAO.updateByExample(permissionDO, exam);
	}

	/**
	* 根据code更新permission表数据
	*/
	public void updatePermissionByCode(String code,PermissionDO permissionDO) {
		PermissionDOExample exam = new PermissionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		permissionDAO.updateByExample(permissionDO, exam);
	}

    /**
	 * 根据orderNo更新permission表数据
	 */
	public void updatePermissionByOrderNo(Integer orderNo,PermissionDO permissionDO) {
		PermissionDOExample exam = new PermissionDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		permissionDAO.updateByExample(permissionDO, exam);
	}

    /**
	 * 断言product表
	 */
	public void productAssert(
	        ProductDO productDO,
			Long id, 
			String productId, 
			String productName, 
			String productType, 
			String productCategory, 
			String status, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, productDO.getId());
        assertEquals(productId, productDO.getProductId());
        assertEquals(productName, productDO.getProductName());
        assertEquals(productType, productDO.getProductType());
        assertEquals(productCategory, productDO.getProductCategory());
        assertEquals(status, productDO.getStatus());
        assertEquals(memo, productDO.getMemo());
        assertEquals(rawAddTime, productDO.getRawAddTime());
        assertEquals(rawUpdateTime, productDO.getRawUpdateTime());
	}

	/**
	 * 断言product表数据
	 */
	public void assertProduct(ProductDO expect, ProductDO productDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			productDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != productDO.getRawAddTime());
		expect.setRawAddTime(productDO.getRawAddTime());
        Assertions.assertTrue(null != productDO.getRawUpdateTime());
		expect.setRawUpdateTime(productDO.getRawUpdateTime());
		Assertions.assertEquals(expect, productDO);
	}

    /**
	 * 插入product表数据
	 */
	public void insertProduct(ProductDO productDO) {
		productDAO.insert(productDO);
	}

    /**
	 * 插入product表数据
	 */
	public void insertProduct(
			Long id, 
			String productId, 
			String productName, 
			String productType, 
			String productCategory, 
			String status, 
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
		ProductDO productDO = new ProductDO();
		productDO.setId(id);
		productDO.setProductId(productId);
		productDO.setProductName(productName);
		productDO.setProductType(productType);
		productDO.setProductCategory(productCategory);
		productDO.setStatus(status);
		productDO.setMemo(memo);
		productDO.setRawAddTime(rawAddTime);
		productDO.setRawUpdateTime(rawUpdateTime);
		productDAO.insert(productDO);
	}

    /**
     * 删除product表所有数据
     */
    public void cleanProduct() {
        ProductDOExample exam = new ProductDOExample();
        exam.createCriteria();
        productDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除product表数据
	 */
	public void cleanProductById(Long id) {
		ProductDOExample exam = new ProductDOExample();
		exam.createCriteria().andIdEqualTo(id);
		productDAO.deleteByExample(exam);
	}

	/**
	 * 根据productId删除product表数据
	 */
	public void cleanProductByProductId(String productId) {
        if (StringUtils.isBlank(productId)){
            productId = "test_productId";
        }
		ProductDOExample exam = new ProductDOExample();
		exam.createCriteria().andProductIdEqualTo(productId);
		productDAO.deleteByExample(exam);
	}

	/**
	* 根据productName删除product表数据
	*/
	public void cleanProductByProductName(String productName) {
        if (StringUtils.isBlank(productName)){
            productName = "test_productName";
        }
		ProductDOExample exam = new ProductDOExample();
		exam.createCriteria().andProductNameEqualTo(productName);
		productDAO.deleteByExample(exam);
	}

    /**
     * 查询product表所有数据
     */
    public List<ProductDO> findProductAll() {
        ProductDOExample exam = new ProductDOExample();
        exam.createCriteria();
		return productDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询product表数据
	 */
	public List<ProductDO> findProductById(Long id) {
		ProductDOExample exam = new ProductDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return productDAO.selectByExample(exam);
	}

    /**
	 * 根据productId查询product表数据
	 */
	public List<ProductDO> findProductByProductId(String productId) {
		ProductDOExample exam = new ProductDOExample();
		exam.createCriteria().andProductIdEqualTo(productId);
		return productDAO.selectByExample(exam);
	}

	/**
	* 根据productName查询product表数据
	*/
	public List<ProductDO> findProductByProductName(String productName) {
		ProductDOExample exam = new ProductDOExample();
		exam.createCriteria().andProductNameEqualTo(productName);
		return productDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新product表数据
	 */
	public void updateProductById(Long id,ProductDO productDO) {
		ProductDOExample exam = new ProductDOExample();
		exam.createCriteria().andIdEqualTo(id);
		productDAO.updateByExample(productDO, exam);
	}

    /**
	 * 根据productId更新product表数据
	 */
	public void updateProductByProductId(String productId,ProductDO productDO) {
		ProductDOExample exam = new ProductDOExample();
		exam.createCriteria().andProductIdEqualTo(productId);
		productDAO.updateByExample(productDO, exam);
	}

	/**
	* 根据productName更新product表数据
	*/
	public void updateProductByProductName(String productName,ProductDO productDO) {
		ProductDOExample exam = new ProductDOExample();
		exam.createCriteria().andProductNameEqualTo(productName);
		productDAO.updateByExample(productDO, exam);
	}

    /**
	 * 断言product_permission表
	 */
	public void productPermissionAssert(
	        ProductPermissionDO productPermissionDO,
			Long id, 
			String productId, 
			String permissionId
	) {
        assertEquals(id, productPermissionDO.getId());
        assertEquals(productId, productPermissionDO.getProductId());
        assertEquals(permissionId, productPermissionDO.getPermissionId());
	}

	/**
	 * 断言product_permission表数据
	 */
	public void assertProductPermission(ProductPermissionDO expect, ProductPermissionDO productPermissionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			productPermissionDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, productPermissionDO);
	}

    /**
	 * 插入product_permission表数据
	 */
	public void insertProductPermission(ProductPermissionDO productPermissionDO) {
		productPermissionDAO.insert(productPermissionDO);
	}

    /**
	 * 插入product_permission表数据
	 */
	public void insertProductPermission(
			Long id, 
			String productId, 
			String permissionId
	) {
		ProductPermissionDO productPermissionDO = new ProductPermissionDO();
		productPermissionDO.setId(id);
		productPermissionDO.setProductId(productId);
		productPermissionDO.setPermissionId(permissionId);
		productPermissionDAO.insert(productPermissionDO);
	}

    /**
     * 删除product_permission表所有数据
     */
    public void cleanProductPermission() {
        ProductPermissionDOExample exam = new ProductPermissionDOExample();
        exam.createCriteria();
        productPermissionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除product_permission表数据
	 */
	public void cleanProductPermissionById(Long id) {
		ProductPermissionDOExample exam = new ProductPermissionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		productPermissionDAO.deleteByExample(exam);
	}

	/**
	 * 根据productId删除product_permission表数据
	 */
	public void cleanProductPermissionByProductId(String productId) {
        if (StringUtils.isBlank(productId)){
            productId = "test_productId";
        }
		ProductPermissionDOExample exam = new ProductPermissionDOExample();
		exam.createCriteria().andProductIdEqualTo(productId);
		productPermissionDAO.deleteByExample(exam);
	}

	/**
	 * 根据permissionId删除product_permission表数据
	 */
	public void cleanProductPermissionByPermissionId(String permissionId) {
        if (StringUtils.isBlank(permissionId)){
            permissionId = "test_permissionId";
        }
		ProductPermissionDOExample exam = new ProductPermissionDOExample();
		exam.createCriteria().andPermissionIdEqualTo(permissionId);
		productPermissionDAO.deleteByExample(exam);
	}

    /**
     * 查询product_permission表所有数据
     */
    public List<ProductPermissionDO> findProductPermissionAll() {
        ProductPermissionDOExample exam = new ProductPermissionDOExample();
        exam.createCriteria();
		return productPermissionDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询product_permission表数据
	 */
	public List<ProductPermissionDO> findProductPermissionById(Long id) {
		ProductPermissionDOExample exam = new ProductPermissionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return productPermissionDAO.selectByExample(exam);
	}

    /**
	 * 根据productId查询product_permission表数据
	 */
	public List<ProductPermissionDO> findProductPermissionByProductId(String productId) {
		ProductPermissionDOExample exam = new ProductPermissionDOExample();
		exam.createCriteria().andProductIdEqualTo(productId);
		return productPermissionDAO.selectByExample(exam);
	}

    /**
	 * 根据permissionId查询product_permission表数据
	 */
	public List<ProductPermissionDO> findProductPermissionByPermissionId(String permissionId) {
		ProductPermissionDOExample exam = new ProductPermissionDOExample();
		exam.createCriteria().andPermissionIdEqualTo(permissionId);
		return productPermissionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新product_permission表数据
	 */
	public void updateProductPermissionById(Long id,ProductPermissionDO productPermissionDO) {
		ProductPermissionDOExample exam = new ProductPermissionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		productPermissionDAO.updateByExample(productPermissionDO, exam);
	}

    /**
	 * 根据productId更新product_permission表数据
	 */
	public void updateProductPermissionByProductId(String productId,ProductPermissionDO productPermissionDO) {
		ProductPermissionDOExample exam = new ProductPermissionDOExample();
		exam.createCriteria().andProductIdEqualTo(productId);
		productPermissionDAO.updateByExample(productPermissionDO, exam);
	}

    /**
	 * 根据permissionId更新product_permission表数据
	 */
	public void updateProductPermissionByPermissionId(String permissionId,ProductPermissionDO productPermissionDO) {
		ProductPermissionDOExample exam = new ProductPermissionDOExample();
		exam.createCriteria().andPermissionIdEqualTo(permissionId);
		productPermissionDAO.updateByExample(productPermissionDO, exam);
	}

    /**
	 * 断言role表
	 */
	public void roleAssert(
	        RoleDO roleDO,
			Long id, 
			String roleNo, 
			String roleCode, 
			String roleType, 
			String platPartnerId, 
			String roleName, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, roleDO.getId());
        assertEquals(roleNo, roleDO.getRoleNo());
        assertEquals(roleCode, roleDO.getRoleCode());
        assertEquals(roleType, roleDO.getRoleType());
        assertEquals(platPartnerId, roleDO.getPlatPartnerId());
        assertEquals(roleName, roleDO.getRoleName());
        assertEquals(memo, roleDO.getMemo());
        assertEquals(rawAddTime, roleDO.getRawAddTime());
        assertEquals(rawUpdateTime, roleDO.getRawUpdateTime());
	}

	/**
	 * 断言role表数据
	 */
	public void assertRole(RoleDO expect, RoleDO roleDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			roleDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != roleDO.getRawAddTime());
		expect.setRawAddTime(roleDO.getRawAddTime());
        Assertions.assertTrue(null != roleDO.getRawUpdateTime());
		expect.setRawUpdateTime(roleDO.getRawUpdateTime());
		Assertions.assertEquals(expect, roleDO);
	}

    /**
	 * 插入role表数据
	 */
	public void insertRole(RoleDO roleDO) {
		roleDAO.insert(roleDO);
	}

    /**
	 * 插入role表数据
	 */
	public void insertRole(
			Long id, 
			String roleNo, 
			String roleCode, 
			String roleType, 
			String platPartnerId, 
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
		RoleDO roleDO = new RoleDO();
		roleDO.setId(id);
		roleDO.setRoleNo(roleNo);
		roleDO.setRoleCode(roleCode);
		roleDO.setRoleType(roleType);
		roleDO.setPlatPartnerId(platPartnerId);
		roleDO.setRoleName(roleName);
		roleDO.setMemo(memo);
		roleDO.setRawAddTime(rawAddTime);
		roleDO.setRawUpdateTime(rawUpdateTime);
		roleDAO.insert(roleDO);
	}

    /**
     * 删除role表所有数据
     */
    public void cleanRole() {
        RoleDOExample exam = new RoleDOExample();
        exam.createCriteria();
        roleDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除role表数据
	 */
	public void cleanRoleById(Long id) {
		RoleDOExample exam = new RoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		roleDAO.deleteByExample(exam);
	}

	/**
	 * 根据roleNo删除role表数据
	 */
	public void cleanRoleByRoleNo(String roleNo) {
        if (StringUtils.isBlank(roleNo)){
            roleNo = "test_roleNo";
        }
		RoleDOExample exam = new RoleDOExample();
		exam.createCriteria().andRoleNoEqualTo(roleNo);
		roleDAO.deleteByExample(exam);
	}

	/**
	* 根据roleCode删除role表数据
	*/
	public void cleanRoleByRoleCode(String roleCode) {
        if (StringUtils.isBlank(roleCode)){
            roleCode = "test_roleCode";
        }
		RoleDOExample exam = new RoleDOExample();
		exam.createCriteria().andRoleCodeEqualTo(roleCode);
		roleDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除role表数据
	 */
	public void cleanRoleByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		RoleDOExample exam = new RoleDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		roleDAO.deleteByExample(exam);
	}

	/**
	* 根据roleName删除role表数据
	*/
	public void cleanRoleByRoleName(String roleName) {
        if (StringUtils.isBlank(roleName)){
            roleName = "test_roleName";
        }
		RoleDOExample exam = new RoleDOExample();
		exam.createCriteria().andRoleNameEqualTo(roleName);
		roleDAO.deleteByExample(exam);
	}

    /**
     * 查询role表所有数据
     */
    public List<RoleDO> findRoleAll() {
        RoleDOExample exam = new RoleDOExample();
        exam.createCriteria();
		return roleDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询role表数据
	 */
	public List<RoleDO> findRoleById(Long id) {
		RoleDOExample exam = new RoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return roleDAO.selectByExample(exam);
	}

    /**
	 * 根据roleNo查询role表数据
	 */
	public List<RoleDO> findRoleByRoleNo(String roleNo) {
		RoleDOExample exam = new RoleDOExample();
		exam.createCriteria().andRoleNoEqualTo(roleNo);
		return roleDAO.selectByExample(exam);
	}

	/**
	* 根据roleCode查询role表数据
	*/
	public List<RoleDO> findRoleByRoleCode(String roleCode) {
		RoleDOExample exam = new RoleDOExample();
		exam.createCriteria().andRoleCodeEqualTo(roleCode);
		return roleDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询role表数据
	 */
	public List<RoleDO> findRoleByPlatPartnerId(String platPartnerId) {
		RoleDOExample exam = new RoleDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return roleDAO.selectByExample(exam);
	}

	/**
	* 根据roleName查询role表数据
	*/
	public List<RoleDO> findRoleByRoleName(String roleName) {
		RoleDOExample exam = new RoleDOExample();
		exam.createCriteria().andRoleNameEqualTo(roleName);
		return roleDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新role表数据
	 */
	public void updateRoleById(Long id,RoleDO roleDO) {
		RoleDOExample exam = new RoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		roleDAO.updateByExample(roleDO, exam);
	}

    /**
	 * 根据roleNo更新role表数据
	 */
	public void updateRoleByRoleNo(String roleNo,RoleDO roleDO) {
		RoleDOExample exam = new RoleDOExample();
		exam.createCriteria().andRoleNoEqualTo(roleNo);
		roleDAO.updateByExample(roleDO, exam);
	}

	/**
	* 根据roleCode更新role表数据
	*/
	public void updateRoleByRoleCode(String roleCode,RoleDO roleDO) {
		RoleDOExample exam = new RoleDOExample();
		exam.createCriteria().andRoleCodeEqualTo(roleCode);
		roleDAO.updateByExample(roleDO, exam);
	}

    /**
	 * 根据platPartnerId更新role表数据
	 */
	public void updateRoleByPlatPartnerId(String platPartnerId,RoleDO roleDO) {
		RoleDOExample exam = new RoleDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		roleDAO.updateByExample(roleDO, exam);
	}

	/**
	* 根据roleName更新role表数据
	*/
	public void updateRoleByRoleName(String roleName,RoleDO roleDO) {
		RoleDOExample exam = new RoleDOExample();
		exam.createCriteria().andRoleNameEqualTo(roleName);
		roleDAO.updateByExample(roleDO, exam);
	}

    /**
	 * 断言role_permission表
	 */
	public void rolePermissionAssert(
	        RolePermissionDO rolePermissionDO,
			Long id, 
			String roleNo, 
			String productId, 
			String permissionId
	) {
        assertEquals(id, rolePermissionDO.getId());
        assertEquals(roleNo, rolePermissionDO.getRoleNo());
        assertEquals(productId, rolePermissionDO.getProductId());
        assertEquals(permissionId, rolePermissionDO.getPermissionId());
	}

	/**
	 * 断言role_permission表数据
	 */
	public void assertRolePermission(RolePermissionDO expect, RolePermissionDO rolePermissionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			rolePermissionDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, rolePermissionDO);
	}

    /**
	 * 插入role_permission表数据
	 */
	public void insertRolePermission(RolePermissionDO rolePermissionDO) {
		rolePermissionDAO.insert(rolePermissionDO);
	}

    /**
	 * 插入role_permission表数据
	 */
	public void insertRolePermission(
			Long id, 
			String roleNo, 
			String productId, 
			String permissionId
	) {
		RolePermissionDO rolePermissionDO = new RolePermissionDO();
		rolePermissionDO.setId(id);
		rolePermissionDO.setRoleNo(roleNo);
		rolePermissionDO.setProductId(productId);
		rolePermissionDO.setPermissionId(permissionId);
		rolePermissionDAO.insert(rolePermissionDO);
	}

    /**
     * 删除role_permission表所有数据
     */
    public void cleanRolePermission() {
        RolePermissionDOExample exam = new RolePermissionDOExample();
        exam.createCriteria();
        rolePermissionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除role_permission表数据
	 */
	public void cleanRolePermissionById(Long id) {
		RolePermissionDOExample exam = new RolePermissionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		rolePermissionDAO.deleteByExample(exam);
	}

	/**
	 * 根据roleNo删除role_permission表数据
	 */
	public void cleanRolePermissionByRoleNo(String roleNo) {
        if (StringUtils.isBlank(roleNo)){
            roleNo = "test_roleNo";
        }
		RolePermissionDOExample exam = new RolePermissionDOExample();
		exam.createCriteria().andRoleNoEqualTo(roleNo);
		rolePermissionDAO.deleteByExample(exam);
	}

	/**
	 * 根据productId删除role_permission表数据
	 */
	public void cleanRolePermissionByProductId(String productId) {
        if (StringUtils.isBlank(productId)){
            productId = "test_productId";
        }
		RolePermissionDOExample exam = new RolePermissionDOExample();
		exam.createCriteria().andProductIdEqualTo(productId);
		rolePermissionDAO.deleteByExample(exam);
	}

	/**
	 * 根据permissionId删除role_permission表数据
	 */
	public void cleanRolePermissionByPermissionId(String permissionId) {
        if (StringUtils.isBlank(permissionId)){
            permissionId = "test_permissionId";
        }
		RolePermissionDOExample exam = new RolePermissionDOExample();
		exam.createCriteria().andPermissionIdEqualTo(permissionId);
		rolePermissionDAO.deleteByExample(exam);
	}

    /**
     * 查询role_permission表所有数据
     */
    public List<RolePermissionDO> findRolePermissionAll() {
        RolePermissionDOExample exam = new RolePermissionDOExample();
        exam.createCriteria();
		return rolePermissionDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询role_permission表数据
	 */
	public List<RolePermissionDO> findRolePermissionById(Long id) {
		RolePermissionDOExample exam = new RolePermissionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return rolePermissionDAO.selectByExample(exam);
	}

    /**
	 * 根据roleNo查询role_permission表数据
	 */
	public List<RolePermissionDO> findRolePermissionByRoleNo(String roleNo) {
		RolePermissionDOExample exam = new RolePermissionDOExample();
		exam.createCriteria().andRoleNoEqualTo(roleNo);
		return rolePermissionDAO.selectByExample(exam);
	}

    /**
	 * 根据productId查询role_permission表数据
	 */
	public List<RolePermissionDO> findRolePermissionByProductId(String productId) {
		RolePermissionDOExample exam = new RolePermissionDOExample();
		exam.createCriteria().andProductIdEqualTo(productId);
		return rolePermissionDAO.selectByExample(exam);
	}

    /**
	 * 根据permissionId查询role_permission表数据
	 */
	public List<RolePermissionDO> findRolePermissionByPermissionId(String permissionId) {
		RolePermissionDOExample exam = new RolePermissionDOExample();
		exam.createCriteria().andPermissionIdEqualTo(permissionId);
		return rolePermissionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新role_permission表数据
	 */
	public void updateRolePermissionById(Long id,RolePermissionDO rolePermissionDO) {
		RolePermissionDOExample exam = new RolePermissionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		rolePermissionDAO.updateByExample(rolePermissionDO, exam);
	}

    /**
	 * 根据roleNo更新role_permission表数据
	 */
	public void updateRolePermissionByRoleNo(String roleNo,RolePermissionDO rolePermissionDO) {
		RolePermissionDOExample exam = new RolePermissionDOExample();
		exam.createCriteria().andRoleNoEqualTo(roleNo);
		rolePermissionDAO.updateByExample(rolePermissionDO, exam);
	}

    /**
	 * 根据productId更新role_permission表数据
	 */
	public void updateRolePermissionByProductId(String productId,RolePermissionDO rolePermissionDO) {
		RolePermissionDOExample exam = new RolePermissionDOExample();
		exam.createCriteria().andProductIdEqualTo(productId);
		rolePermissionDAO.updateByExample(rolePermissionDO, exam);
	}

    /**
	 * 根据permissionId更新role_permission表数据
	 */
	public void updateRolePermissionByPermissionId(String permissionId,RolePermissionDO rolePermissionDO) {
		RolePermissionDOExample exam = new RolePermissionDOExample();
		exam.createCriteria().andPermissionIdEqualTo(permissionId);
		rolePermissionDAO.updateByExample(rolePermissionDO, exam);
	}

    /**
	 * 断言role_product表
	 */
	public void roleProductAssert(
	        RoleProductDO roleProductDO,
			Long id, 
			String roleNo, 
			String productId
	) {
        assertEquals(id, roleProductDO.getId());
        assertEquals(roleNo, roleProductDO.getRoleNo());
        assertEquals(productId, roleProductDO.getProductId());
	}

	/**
	 * 断言role_product表数据
	 */
	public void assertRoleProduct(RoleProductDO expect, RoleProductDO roleProductDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			roleProductDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, roleProductDO);
	}

    /**
	 * 插入role_product表数据
	 */
	public void insertRoleProduct(RoleProductDO roleProductDO) {
		roleProductDAO.insert(roleProductDO);
	}

    /**
	 * 插入role_product表数据
	 */
	public void insertRoleProduct(
			Long id, 
			String roleNo, 
			String productId
	) {
		RoleProductDO roleProductDO = new RoleProductDO();
		roleProductDO.setId(id);
		roleProductDO.setRoleNo(roleNo);
		roleProductDO.setProductId(productId);
		roleProductDAO.insert(roleProductDO);
	}

    /**
     * 删除role_product表所有数据
     */
    public void cleanRoleProduct() {
        RoleProductDOExample exam = new RoleProductDOExample();
        exam.createCriteria();
        roleProductDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除role_product表数据
	 */
	public void cleanRoleProductById(Long id) {
		RoleProductDOExample exam = new RoleProductDOExample();
		exam.createCriteria().andIdEqualTo(id);
		roleProductDAO.deleteByExample(exam);
	}

	/**
	 * 根据roleNo删除role_product表数据
	 */
	public void cleanRoleProductByRoleNo(String roleNo) {
        if (StringUtils.isBlank(roleNo)){
            roleNo = "test_roleNo";
        }
		RoleProductDOExample exam = new RoleProductDOExample();
		exam.createCriteria().andRoleNoEqualTo(roleNo);
		roleProductDAO.deleteByExample(exam);
	}

	/**
	 * 根据productId删除role_product表数据
	 */
	public void cleanRoleProductByProductId(String productId) {
        if (StringUtils.isBlank(productId)){
            productId = "test_productId";
        }
		RoleProductDOExample exam = new RoleProductDOExample();
		exam.createCriteria().andProductIdEqualTo(productId);
		roleProductDAO.deleteByExample(exam);
	}

    /**
     * 查询role_product表所有数据
     */
    public List<RoleProductDO> findRoleProductAll() {
        RoleProductDOExample exam = new RoleProductDOExample();
        exam.createCriteria();
		return roleProductDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询role_product表数据
	 */
	public List<RoleProductDO> findRoleProductById(Long id) {
		RoleProductDOExample exam = new RoleProductDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return roleProductDAO.selectByExample(exam);
	}

    /**
	 * 根据roleNo查询role_product表数据
	 */
	public List<RoleProductDO> findRoleProductByRoleNo(String roleNo) {
		RoleProductDOExample exam = new RoleProductDOExample();
		exam.createCriteria().andRoleNoEqualTo(roleNo);
		return roleProductDAO.selectByExample(exam);
	}

    /**
	 * 根据productId查询role_product表数据
	 */
	public List<RoleProductDO> findRoleProductByProductId(String productId) {
		RoleProductDOExample exam = new RoleProductDOExample();
		exam.createCriteria().andProductIdEqualTo(productId);
		return roleProductDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新role_product表数据
	 */
	public void updateRoleProductById(Long id,RoleProductDO roleProductDO) {
		RoleProductDOExample exam = new RoleProductDOExample();
		exam.createCriteria().andIdEqualTo(id);
		roleProductDAO.updateByExample(roleProductDO, exam);
	}

    /**
	 * 根据roleNo更新role_product表数据
	 */
	public void updateRoleProductByRoleNo(String roleNo,RoleProductDO roleProductDO) {
		RoleProductDOExample exam = new RoleProductDOExample();
		exam.createCriteria().andRoleNoEqualTo(roleNo);
		roleProductDAO.updateByExample(roleProductDO, exam);
	}

    /**
	 * 根据productId更新role_product表数据
	 */
	public void updateRoleProductByProductId(String productId,RoleProductDO roleProductDO) {
		RoleProductDOExample exam = new RoleProductDOExample();
		exam.createCriteria().andProductIdEqualTo(productId);
		roleProductDAO.updateByExample(roleProductDO, exam);
	}

    /**
	 * 断言sys_id_gen表
	 */
	public void sysIdGenAssert(
	        SysIdGenDO sysIdGenDO,
			Long identity, 
			Date rawUpdateTime
	) {
        assertEquals(identity, sysIdGenDO.getIdentity());
        assertEquals(rawUpdateTime, sysIdGenDO.getRawUpdateTime());
	}

	/**
	 * 断言sys_id_gen表数据
	 */
	public void assertSysIdGen(SysIdGenDO expect, SysIdGenDO sysIdGenDO) {
        Assertions.assertTrue(null != sysIdGenDO.getRawUpdateTime());
		expect.setRawUpdateTime(sysIdGenDO.getRawUpdateTime());
		Assertions.assertEquals(expect, sysIdGenDO);
	}

    /**
	 * 插入sys_id_gen表数据
	 */
	public void insertSysIdGen(SysIdGenDO sysIdGenDO) {
		sysIdGenDAO.insert(sysIdGenDO);
	}

    /**
	 * 插入sys_id_gen表数据
	 */
	public void insertSysIdGen(
			Long identity, 
			Date rawUpdateTime
	) {
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		SysIdGenDO sysIdGenDO = new SysIdGenDO();
		sysIdGenDO.setIdentity(identity);
		sysIdGenDO.setRawUpdateTime(rawUpdateTime);
		sysIdGenDAO.insert(sysIdGenDO);
	}

    /**
     * 删除sys_id_gen表所有数据
     */
    public void cleanSysIdGen() {
        SysIdGenDOExample exam = new SysIdGenDOExample();
        exam.createCriteria();
        sysIdGenDAO.deleteByExample(exam);
    }


	/**
	 * 根据identity删除sys_id_gen表数据
	 */
	public void cleanSysIdGenByIdentity(Long identity) {
		SysIdGenDOExample exam = new SysIdGenDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		sysIdGenDAO.deleteByExample(exam);
	}

    /**
     * 查询sys_id_gen表所有数据
     */
    public List<SysIdGenDO> findSysIdGenAll() {
        SysIdGenDOExample exam = new SysIdGenDOExample();
        exam.createCriteria();
		return sysIdGenDAO.selectByExample(exam);
    }

    /**
	 * 根据identity查询sys_id_gen表数据
	 */
	public List<SysIdGenDO> findSysIdGenByIdentity(Long identity) {
		SysIdGenDOExample exam = new SysIdGenDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		return sysIdGenDAO.selectByExample(exam);
	}

    /**
	 * 根据identity更新sys_id_gen表数据
	 */
	public void updateSysIdGenByIdentity(Long identity,SysIdGenDO sysIdGenDO) {
		SysIdGenDOExample exam = new SysIdGenDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		sysIdGenDAO.updateByExample(sysIdGenDO, exam);
	}

    /**
	 * 断言tmp_points_goods_map表
	 */
	public void tmpPointsGoodsMapAssert(
	        TmpPointsGoodsMapDO tmpPointsGoodsMapDO,
			String oldPointsGoodsId, 
			String newPointsGoodsId, 
			String goodsType
	) {
        assertEquals(oldPointsGoodsId, tmpPointsGoodsMapDO.getOldPointsGoodsId());
        assertEquals(newPointsGoodsId, tmpPointsGoodsMapDO.getNewPointsGoodsId());
        assertEquals(goodsType, tmpPointsGoodsMapDO.getGoodsType());
	}

	/**
	 * 断言tmp_points_goods_map表数据
	 */
	public void assertTmpPointsGoodsMap(TmpPointsGoodsMapDO expect, TmpPointsGoodsMapDO tmpPointsGoodsMapDO) {
		Assertions.assertEquals(expect, tmpPointsGoodsMapDO);
	}

    /**
	 * 插入tmp_points_goods_map表数据
	 */
	public void insertTmpPointsGoodsMap(TmpPointsGoodsMapDO tmpPointsGoodsMapDO) {
		tmpPointsGoodsMapDAO.insert(tmpPointsGoodsMapDO);
	}

    /**
	 * 插入tmp_points_goods_map表数据
	 */
	public void insertTmpPointsGoodsMap(
			String oldPointsGoodsId, 
			String newPointsGoodsId, 
			String goodsType
	) {
		TmpPointsGoodsMapDO tmpPointsGoodsMapDO = new TmpPointsGoodsMapDO();
		tmpPointsGoodsMapDO.setOldPointsGoodsId(oldPointsGoodsId);
		tmpPointsGoodsMapDO.setNewPointsGoodsId(newPointsGoodsId);
		tmpPointsGoodsMapDO.setGoodsType(goodsType);
		tmpPointsGoodsMapDAO.insert(tmpPointsGoodsMapDO);
	}

    /**
     * 删除tmp_points_goods_map表所有数据
     */
    public void cleanTmpPointsGoodsMap() {
        TmpPointsGoodsMapDOExample exam = new TmpPointsGoodsMapDOExample();
        exam.createCriteria();
        tmpPointsGoodsMapDAO.deleteByExample(exam);
    }


	/**
	 * 根据oldPointsGoodsId删除tmp_points_goods_map表数据
	 */
	public void cleanTmpPointsGoodsMapByOldPointsGoodsId(String oldPointsGoodsId) {
        if (StringUtils.isBlank(oldPointsGoodsId)){
            oldPointsGoodsId = "test_oldPointsGoodsId";
        }
		TmpPointsGoodsMapDOExample exam = new TmpPointsGoodsMapDOExample();
		exam.createCriteria().andOldPointsGoodsIdEqualTo(oldPointsGoodsId);
		tmpPointsGoodsMapDAO.deleteByExample(exam);
	}

	/**
	 * 根据newPointsGoodsId删除tmp_points_goods_map表数据
	 */
	public void cleanTmpPointsGoodsMapByNewPointsGoodsId(String newPointsGoodsId) {
        if (StringUtils.isBlank(newPointsGoodsId)){
            newPointsGoodsId = "test_newPointsGoodsId";
        }
		TmpPointsGoodsMapDOExample exam = new TmpPointsGoodsMapDOExample();
		exam.createCriteria().andNewPointsGoodsIdEqualTo(newPointsGoodsId);
		tmpPointsGoodsMapDAO.deleteByExample(exam);
	}

    /**
     * 查询tmp_points_goods_map表所有数据
     */
    public List<TmpPointsGoodsMapDO> findTmpPointsGoodsMapAll() {
        TmpPointsGoodsMapDOExample exam = new TmpPointsGoodsMapDOExample();
        exam.createCriteria();
		return tmpPointsGoodsMapDAO.selectByExample(exam);
    }

    /**
	 * 根据oldPointsGoodsId查询tmp_points_goods_map表数据
	 */
	public List<TmpPointsGoodsMapDO> findTmpPointsGoodsMapByOldPointsGoodsId(String oldPointsGoodsId) {
		TmpPointsGoodsMapDOExample exam = new TmpPointsGoodsMapDOExample();
		exam.createCriteria().andOldPointsGoodsIdEqualTo(oldPointsGoodsId);
		return tmpPointsGoodsMapDAO.selectByExample(exam);
	}

    /**
	 * 根据newPointsGoodsId查询tmp_points_goods_map表数据
	 */
	public List<TmpPointsGoodsMapDO> findTmpPointsGoodsMapByNewPointsGoodsId(String newPointsGoodsId) {
		TmpPointsGoodsMapDOExample exam = new TmpPointsGoodsMapDOExample();
		exam.createCriteria().andNewPointsGoodsIdEqualTo(newPointsGoodsId);
		return tmpPointsGoodsMapDAO.selectByExample(exam);
	}

    /**
	 * 根据oldPointsGoodsId更新tmp_points_goods_map表数据
	 */
	public void updateTmpPointsGoodsMapByOldPointsGoodsId(String oldPointsGoodsId,TmpPointsGoodsMapDO tmpPointsGoodsMapDO) {
		TmpPointsGoodsMapDOExample exam = new TmpPointsGoodsMapDOExample();
		exam.createCriteria().andOldPointsGoodsIdEqualTo(oldPointsGoodsId);
		tmpPointsGoodsMapDAO.updateByExample(tmpPointsGoodsMapDO, exam);
	}

    /**
	 * 根据newPointsGoodsId更新tmp_points_goods_map表数据
	 */
	public void updateTmpPointsGoodsMapByNewPointsGoodsId(String newPointsGoodsId,TmpPointsGoodsMapDO tmpPointsGoodsMapDO) {
		TmpPointsGoodsMapDOExample exam = new TmpPointsGoodsMapDOExample();
		exam.createCriteria().andNewPointsGoodsIdEqualTo(newPointsGoodsId);
		tmpPointsGoodsMapDAO.updateByExample(tmpPointsGoodsMapDO, exam);
	}

    /**
	 * 断言user_unique_key表
	 */
	public void userUniqueKeyAssert(
	        UserUniqueKeyDO userUniqueKeyDO,
			Long id, 
			String userId, 
			String ukType, 
			String uniqueKey
	) {
        assertEquals(id, userUniqueKeyDO.getId());
        assertEquals(userId, userUniqueKeyDO.getUserId());
        assertEquals(ukType, userUniqueKeyDO.getUkType());
        assertEquals(uniqueKey, userUniqueKeyDO.getUniqueKey());
	}

	/**
	 * 断言user_unique_key表数据
	 */
	public void assertUserUniqueKey(UserUniqueKeyDO expect, UserUniqueKeyDO userUniqueKeyDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userUniqueKeyDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, userUniqueKeyDO);
	}

    /**
	 * 插入user_unique_key表数据
	 */
	public void insertUserUniqueKey(UserUniqueKeyDO userUniqueKeyDO) {
		userUniqueKeyDAO.insert(userUniqueKeyDO);
	}

    /**
	 * 插入user_unique_key表数据
	 */
	public void insertUserUniqueKey(
			Long id, 
			String userId, 
			String ukType, 
			String uniqueKey
	) {
		UserUniqueKeyDO userUniqueKeyDO = new UserUniqueKeyDO();
		userUniqueKeyDO.setId(id);
		userUniqueKeyDO.setUserId(userId);
		userUniqueKeyDO.setUkType(ukType);
		userUniqueKeyDO.setUniqueKey(uniqueKey);
		userUniqueKeyDAO.insert(userUniqueKeyDO);
	}

    /**
     * 删除user_unique_key表所有数据
     */
    public void cleanUserUniqueKey() {
        UserUniqueKeyDOExample exam = new UserUniqueKeyDOExample();
        exam.createCriteria();
        userUniqueKeyDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_unique_key表数据
	 */
	public void cleanUserUniqueKeyById(Long id) {
		UserUniqueKeyDOExample exam = new UserUniqueKeyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userUniqueKeyDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除user_unique_key表数据
	 */
	public void cleanUserUniqueKeyByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		UserUniqueKeyDOExample exam = new UserUniqueKeyDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userUniqueKeyDAO.deleteByExample(exam);
	}

    /**
     * 查询user_unique_key表所有数据
     */
    public List<UserUniqueKeyDO> findUserUniqueKeyAll() {
        UserUniqueKeyDOExample exam = new UserUniqueKeyDOExample();
        exam.createCriteria();
		return userUniqueKeyDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_unique_key表数据
	 */
	public List<UserUniqueKeyDO> findUserUniqueKeyById(Long id) {
		UserUniqueKeyDOExample exam = new UserUniqueKeyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userUniqueKeyDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询user_unique_key表数据
	 */
	public List<UserUniqueKeyDO> findUserUniqueKeyByUserId(String userId) {
		UserUniqueKeyDOExample exam = new UserUniqueKeyDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return userUniqueKeyDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_unique_key表数据
	 */
	public void updateUserUniqueKeyById(Long id,UserUniqueKeyDO userUniqueKeyDO) {
		UserUniqueKeyDOExample exam = new UserUniqueKeyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userUniqueKeyDAO.updateByExample(userUniqueKeyDO, exam);
	}

    /**
	 * 根据userId更新user_unique_key表数据
	 */
	public void updateUserUniqueKeyByUserId(String userId,UserUniqueKeyDO userUniqueKeyDO) {
		UserUniqueKeyDOExample exam = new UserUniqueKeyDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userUniqueKeyDAO.updateByExample(userUniqueKeyDO, exam);
	}
}
