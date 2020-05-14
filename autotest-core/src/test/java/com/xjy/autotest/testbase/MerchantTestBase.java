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
import dal.dao.merchant.*;
import dal.model.merchant.*;
import com.xjy.autotest.config.MerchantDataSourceConfig;

/**
 * @author autotest
 * Created on 2020/02/24.
 */
@Service
@Import({
        MerchantDataSourceConfig.class
})
public class MerchantTestBase extends AutoTestBase{

	@Autowired
	BankDictionaryDAO bankDictionaryDAO;

	@Autowired
	BusinessLogDAO businessLogDAO;

	@Autowired
	InstructionDAO instructionDAO;

	@Autowired
	MerchantAuthDAO merchantAuthDAO;

	@Autowired
	MerchantChannelBankCardDAO merchantChannelBankCardDAO;

	@Autowired
	MerchantChannelBankCardHisDAO merchantChannelBankCardHisDAO;

	@Autowired
	MerchantChannelTransLogDAO merchantChannelTransLogDAO;

	@Autowired
	MerchantDAO merchantDAO;

	@Autowired
	MerchantEntryDAO merchantEntryDAO;

	@Autowired
	MerchantImgDAO merchantImgDAO;

	@Autowired
	MerchantInfoDAO merchantInfoDAO;

	@Autowired
	MerchantOperatorDAO merchantOperatorDAO;

	@Autowired
	MerchantOperatorLoginLogDAO merchantOperatorLoginLogDAO;

	@Autowired
	MerchantRoleDAO merchantRoleDAO;

	@Autowired
	MerchantSettlementDAO merchantSettlementDAO;

	@Autowired
	NotifyTaskDAO notifyTaskDAO;

	@Autowired
	SysLockDAO sysLockDAO;

	@Autowired
	SysMenuDAO sysMenuDAO;

	@Autowired
	SysSequenceDAO sysSequenceDAO;

	public BankDictionaryDAO getBankDictionaryDAO() {
		return this.bankDictionaryDAO;
	}

	public BusinessLogDAO getBusinessLogDAO() {
		return this.businessLogDAO;
	}

	public InstructionDAO getInstructionDAO() {
		return this.instructionDAO;
	}

	public MerchantAuthDAO getMerchantAuthDAO() {
		return this.merchantAuthDAO;
	}

	public MerchantChannelBankCardDAO getMerchantChannelBankCardDAO() {
		return this.merchantChannelBankCardDAO;
	}

	public MerchantChannelBankCardHisDAO getMerchantChannelBankCardHisDAO() {
		return this.merchantChannelBankCardHisDAO;
	}

	public MerchantChannelTransLogDAO getMerchantChannelTransLogDAO() {
		return this.merchantChannelTransLogDAO;
	}

	public MerchantDAO getMerchantDAO() {
		return this.merchantDAO;
	}

	public MerchantEntryDAO getMerchantEntryDAO() {
		return this.merchantEntryDAO;
	}

	public MerchantImgDAO getMerchantImgDAO() {
		return this.merchantImgDAO;
	}

	public MerchantInfoDAO getMerchantInfoDAO() {
		return this.merchantInfoDAO;
	}

	public MerchantOperatorDAO getMerchantOperatorDAO() {
		return this.merchantOperatorDAO;
	}

	public MerchantOperatorLoginLogDAO getMerchantOperatorLoginLogDAO() {
		return this.merchantOperatorLoginLogDAO;
	}

	public MerchantRoleDAO getMerchantRoleDAO() {
		return this.merchantRoleDAO;
	}

	public MerchantSettlementDAO getMerchantSettlementDAO() {
		return this.merchantSettlementDAO;
	}

	public NotifyTaskDAO getNotifyTaskDAO() {
		return this.notifyTaskDAO;
	}

	public SysLockDAO getSysLockDAO() {
		return this.sysLockDAO;
	}

	public SysMenuDAO getSysMenuDAO() {
		return this.sysMenuDAO;
	}

	public SysSequenceDAO getSysSequenceDAO() {
		return this.sysSequenceDAO;
	}


    /**
	 * 断言bank_dictionary表
	 */
	public void bankDictionaryAssert(
	        BankDictionaryDO bankDictionaryDO,
			Long id, 
			String bankNumber, 
			String bankName
	) {
        assertEquals(id, bankDictionaryDO.getId());
        assertEquals(bankNumber, bankDictionaryDO.getBankNumber());
        assertEquals(bankName, bankDictionaryDO.getBankName());
	}

	/**
	 * 断言bank_dictionary表数据
	 */
	public void assertBankDictionary(BankDictionaryDO expect, BankDictionaryDO bankDictionaryDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			bankDictionaryDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, bankDictionaryDO);
	}

    /**
	 * 插入bank_dictionary表数据
	 */
	public void insertBankDictionary(BankDictionaryDO bankDictionaryDO) {
		bankDictionaryDAO.insert(bankDictionaryDO);
	}

    /**
	 * 插入bank_dictionary表数据
	 */
	public void insertBankDictionary(
			Long id, 
			String bankNumber, 
			String bankName
	) {
		BankDictionaryDO bankDictionaryDO = new BankDictionaryDO();
		bankDictionaryDO.setId(id);
		bankDictionaryDO.setBankNumber(bankNumber);
		bankDictionaryDO.setBankName(bankName);
		bankDictionaryDAO.insert(bankDictionaryDO);
	}

    /**
     * 删除bank_dictionary表所有数据
     */
    public void cleanBankDictionary() {
        BankDictionaryDOExample exam = new BankDictionaryDOExample();
        exam.createCriteria();
        bankDictionaryDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除bank_dictionary表数据
	 */
	public void cleanBankDictionaryById(Long id) {
		BankDictionaryDOExample exam = new BankDictionaryDOExample();
		exam.createCriteria().andIdEqualTo(id);
		bankDictionaryDAO.deleteByExample(exam);
	}

	/**
	* 根据bankNumber删除bank_dictionary表数据
	*/
	public void cleanBankDictionaryByBankNumber(String bankNumber) {
        if (StringUtils.isBlank(bankNumber)){
            bankNumber = "test_bankNumber";
        }
		BankDictionaryDOExample exam = new BankDictionaryDOExample();
		exam.createCriteria().andBankNumberEqualTo(bankNumber);
		bankDictionaryDAO.deleteByExample(exam);
	}

	/**
	* 根据bankName删除bank_dictionary表数据
	*/
	public void cleanBankDictionaryByBankName(String bankName) {
        if (StringUtils.isBlank(bankName)){
            bankName = "test_bankName";
        }
		BankDictionaryDOExample exam = new BankDictionaryDOExample();
		exam.createCriteria().andBankNameEqualTo(bankName);
		bankDictionaryDAO.deleteByExample(exam);
	}

    /**
     * 查询bank_dictionary表所有数据
     */
    public List<BankDictionaryDO> findBankDictionaryAll() {
        BankDictionaryDOExample exam = new BankDictionaryDOExample();
        exam.createCriteria();
		return bankDictionaryDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询bank_dictionary表数据
	 */
	public List<BankDictionaryDO> findBankDictionaryById(Long id) {
		BankDictionaryDOExample exam = new BankDictionaryDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return bankDictionaryDAO.selectByExample(exam);
	}

	/**
	* 根据bankNumber查询bank_dictionary表数据
	*/
	public List<BankDictionaryDO> findBankDictionaryByBankNumber(String bankNumber) {
		BankDictionaryDOExample exam = new BankDictionaryDOExample();
		exam.createCriteria().andBankNumberEqualTo(bankNumber);
		return bankDictionaryDAO.selectByExample(exam);
	}

	/**
	* 根据bankName查询bank_dictionary表数据
	*/
	public List<BankDictionaryDO> findBankDictionaryByBankName(String bankName) {
		BankDictionaryDOExample exam = new BankDictionaryDOExample();
		exam.createCriteria().andBankNameEqualTo(bankName);
		return bankDictionaryDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新bank_dictionary表数据
	 */
	public void updateBankDictionaryById(Long id,BankDictionaryDO bankDictionaryDO) {
		BankDictionaryDOExample exam = new BankDictionaryDOExample();
		exam.createCriteria().andIdEqualTo(id);
		bankDictionaryDAO.updateByExample(bankDictionaryDO, exam);
	}

	/**
	* 根据bankName更新bank_dictionary表数据
	*/
	public void updateBankDictionaryByBankName(String bankName,BankDictionaryDO bankDictionaryDO) {
		BankDictionaryDOExample exam = new BankDictionaryDOExample();
		exam.createCriteria().andBankNameEqualTo(bankName);
		bankDictionaryDAO.updateByExample(bankDictionaryDO, exam);
	}

    /**
	 * 断言business_log表
	 */
	public void businessLogAssert(
	        BusinessLogDO businessLogDO,
			Long id, 
			String partnerId, 
			String businessType, 
			String gid, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, businessLogDO.getId());
        assertEquals(partnerId, businessLogDO.getPartnerId());
        assertEquals(businessType, businessLogDO.getBusinessType());
        assertEquals(gid, businessLogDO.getGid());
        assertEquals(rawAddTime, businessLogDO.getRawAddTime());
        assertEquals(rawUpdateTime, businessLogDO.getRawUpdateTime());
	}

	/**
	 * 断言business_log表数据
	 */
	public void assertBusinessLog(BusinessLogDO expect, BusinessLogDO businessLogDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			businessLogDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != businessLogDO.getRawAddTime());
		expect.setRawAddTime(businessLogDO.getRawAddTime());
        Assertions.assertTrue(null != businessLogDO.getRawUpdateTime());
		expect.setRawUpdateTime(businessLogDO.getRawUpdateTime());
		Assertions.assertEquals(expect, businessLogDO);
	}

    /**
	 * 插入business_log表数据
	 */
	public void insertBusinessLog(BusinessLogDO businessLogDO) {
		businessLogDAO.insert(businessLogDO);
	}

    /**
	 * 插入business_log表数据
	 */
	public void insertBusinessLog(
			Long id, 
			String partnerId, 
			String businessType, 
			String gid, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		BusinessLogDO businessLogDO = new BusinessLogDO();
		businessLogDO.setId(id);
		businessLogDO.setPartnerId(partnerId);
		businessLogDO.setBusinessType(businessType);
		businessLogDO.setGid(gid);
		businessLogDO.setRawAddTime(rawAddTime);
		businessLogDO.setRawUpdateTime(rawUpdateTime);
		businessLogDAO.insert(businessLogDO);
	}

    /**
     * 删除business_log表所有数据
     */
    public void cleanBusinessLog() {
        BusinessLogDOExample exam = new BusinessLogDOExample();
        exam.createCriteria();
        businessLogDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除business_log表数据
	 */
	public void cleanBusinessLogById(Long id) {
		BusinessLogDOExample exam = new BusinessLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		businessLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除business_log表数据
	 */
	public void cleanBusinessLogByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		BusinessLogDOExample exam = new BusinessLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		businessLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除business_log表数据
	 */
	public void cleanBusinessLogByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		BusinessLogDOExample exam = new BusinessLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		businessLogDAO.deleteByExample(exam);
	}

    /**
     * 查询business_log表所有数据
     */
    public List<BusinessLogDO> findBusinessLogAll() {
        BusinessLogDOExample exam = new BusinessLogDOExample();
        exam.createCriteria();
		return businessLogDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询business_log表数据
	 */
	public List<BusinessLogDO> findBusinessLogById(Long id) {
		BusinessLogDOExample exam = new BusinessLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return businessLogDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询business_log表数据
	 */
	public List<BusinessLogDO> findBusinessLogByPartnerId(String partnerId) {
		BusinessLogDOExample exam = new BusinessLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return businessLogDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询business_log表数据
	 */
	public List<BusinessLogDO> findBusinessLogByGid(String gid) {
		BusinessLogDOExample exam = new BusinessLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return businessLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新business_log表数据
	 */
	public void updateBusinessLogById(Long id,BusinessLogDO businessLogDO) {
		BusinessLogDOExample exam = new BusinessLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		businessLogDAO.updateByExample(businessLogDO, exam);
	}

    /**
	 * 根据partnerId更新business_log表数据
	 */
	public void updateBusinessLogByPartnerId(String partnerId,BusinessLogDO businessLogDO) {
		BusinessLogDOExample exam = new BusinessLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		businessLogDAO.updateByExample(businessLogDO, exam);
	}

    /**
	 * 根据gid更新business_log表数据
	 */
	public void updateBusinessLogByGid(String gid,BusinessLogDO businessLogDO) {
		BusinessLogDOExample exam = new BusinessLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		businessLogDAO.updateByExample(businessLogDO, exam);
	}

    /**
	 * 断言instruction表
	 */
	public void instructionAssert(
	        InstructionDO instructionDO,
			Integer id, 
			String instructionId, 
			String platPartnerId, 
			String partnerId, 
			String gid, 
			String reqId, 
			String platMerchantOrderNo, 
			String merchantOrderNo, 
			String instructionType, 
			String state, 
			String status, 
			String code, 
			String message, 
			String description, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String instructionJson
	) {
        assertEquals(id, instructionDO.getId());
        assertEquals(instructionId, instructionDO.getInstructionId());
        assertEquals(platPartnerId, instructionDO.getPlatPartnerId());
        assertEquals(partnerId, instructionDO.getPartnerId());
        assertEquals(gid, instructionDO.getGid());
        assertEquals(reqId, instructionDO.getReqId());
        assertEquals(platMerchantOrderNo, instructionDO.getPlatMerchantOrderNo());
        assertEquals(merchantOrderNo, instructionDO.getMerchantOrderNo());
        assertEquals(instructionType, instructionDO.getInstructionType());
        assertEquals(state, instructionDO.getState());
        assertEquals(status, instructionDO.getStatus());
        assertEquals(code, instructionDO.getCode());
        assertEquals(message, instructionDO.getMessage());
        assertEquals(description, instructionDO.getDescription());
        assertEquals(memo, instructionDO.getMemo());
        assertEquals(rawAddTime, instructionDO.getRawAddTime());
        assertEquals(rawUpdateTime, instructionDO.getRawUpdateTime());
        assertEquals(instructionJson, instructionDO.getInstructionJson());
	}

	/**
	 * 断言instruction表数据
	 */
	public void assertInstruction(InstructionDO expect, InstructionDO instructionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			instructionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != instructionDO.getRawAddTime());
		expect.setRawAddTime(instructionDO.getRawAddTime());
        Assertions.assertTrue(null != instructionDO.getRawUpdateTime());
		expect.setRawUpdateTime(instructionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, instructionDO);
	}

    /**
	 * 插入instruction表数据
	 */
	public void insertInstruction(InstructionDO instructionDO) {
		instructionDAO.insert(instructionDO);
	}

    /**
	 * 插入instruction表数据
	 */
	public void insertInstruction(
			Integer id, 
			String instructionId, 
			String platPartnerId, 
			String partnerId, 
			String gid, 
			String reqId, 
			String platMerchantOrderNo, 
			String merchantOrderNo, 
			String instructionType, 
			String state, 
			String status, 
			String code, 
			String message, 
			String description, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String instructionJson
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		InstructionDO instructionDO = new InstructionDO();
		instructionDO.setId(id);
		instructionDO.setInstructionId(instructionId);
		instructionDO.setPlatPartnerId(platPartnerId);
		instructionDO.setPartnerId(partnerId);
		instructionDO.setGid(gid);
		instructionDO.setReqId(reqId);
		instructionDO.setPlatMerchantOrderNo(platMerchantOrderNo);
		instructionDO.setMerchantOrderNo(merchantOrderNo);
		instructionDO.setInstructionType(instructionType);
		instructionDO.setState(state);
		instructionDO.setStatus(status);
		instructionDO.setCode(code);
		instructionDO.setMessage(message);
		instructionDO.setDescription(description);
		instructionDO.setMemo(memo);
		instructionDO.setRawAddTime(rawAddTime);
		instructionDO.setRawUpdateTime(rawUpdateTime);
		instructionDO.setInstructionJson(instructionJson);
		instructionDAO.insert(instructionDO);
	}

    /**
     * 删除instruction表所有数据
     */
    public void cleanInstruction() {
        InstructionDOExample exam = new InstructionDOExample();
        exam.createCriteria();
        instructionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除instruction表数据
	 */
	public void cleanInstructionById(Integer id) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		instructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据instructionId删除instruction表数据
	 */
	public void cleanInstructionByInstructionId(String instructionId) {
        if (StringUtils.isBlank(instructionId)){
            instructionId = "test_instructionId";
        }
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andInstructionIdEqualTo(instructionId);
		instructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除instruction表数据
	 */
	public void cleanInstructionByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		instructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除instruction表数据
	 */
	public void cleanInstructionByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		instructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除instruction表数据
	 */
	public void cleanInstructionByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		instructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除instruction表数据
	 */
	public void cleanInstructionByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		instructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据platMerchantOrderNo删除instruction表数据
	 */
	public void cleanInstructionByPlatMerchantOrderNo(String platMerchantOrderNo) {
        if (StringUtils.isBlank(platMerchantOrderNo)){
            platMerchantOrderNo = "test_platMerchantOrderNo";
        }
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		instructionDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantOrderNo删除instruction表数据
	 */
	public void cleanInstructionByMerchantOrderNo(String merchantOrderNo) {
        if (StringUtils.isBlank(merchantOrderNo)){
            merchantOrderNo = "test_merchantOrderNo";
        }
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		instructionDAO.deleteByExample(exam);
	}

	/**
	* 根据code删除instruction表数据
	*/
	public void cleanInstructionByCode(String code) {
        if (StringUtils.isBlank(code)){
            code = "test_code";
        }
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		instructionDAO.deleteByExample(exam);
	}

    /**
     * 查询instruction表所有数据
     */
    public List<InstructionDO> findInstructionAll() {
        InstructionDOExample exam = new InstructionDOExample();
        exam.createCriteria();
		return instructionDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询instruction表数据
	 */
	public List<InstructionDO> findInstructionById(Integer id) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return instructionDAO.selectByExample(exam);
	}

    /**
	 * 根据instructionId查询instruction表数据
	 */
	public List<InstructionDO> findInstructionByInstructionId(String instructionId) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andInstructionIdEqualTo(instructionId);
		return instructionDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询instruction表数据
	 */
	public List<InstructionDO> findInstructionByPlatPartnerId(String platPartnerId) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return instructionDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询instruction表数据
	 */
	public List<InstructionDO> findInstructionByPartnerId(String partnerId) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return instructionDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询instruction表数据
	 */
	public List<InstructionDO> findInstructionByGid(String gid) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return instructionDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询instruction表数据
	 */
	public List<InstructionDO> findInstructionByReqId(String reqId) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return instructionDAO.selectByExample(exam);
	}

    /**
	 * 根据platMerchantOrderNo查询instruction表数据
	 */
	public List<InstructionDO> findInstructionByPlatMerchantOrderNo(String platMerchantOrderNo) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		return instructionDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantOrderNo查询instruction表数据
	 */
	public List<InstructionDO> findInstructionByMerchantOrderNo(String merchantOrderNo) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		return instructionDAO.selectByExample(exam);
	}

	/**
	* 根据code查询instruction表数据
	*/
	public List<InstructionDO> findInstructionByCode(String code) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		return instructionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新instruction表数据
	 */
	public void updateInstructionById(Integer id,InstructionDO instructionDO) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		instructionDAO.updateByExample(instructionDO, exam);
	}

    /**
	 * 根据instructionId更新instruction表数据
	 */
	public void updateInstructionByInstructionId(String instructionId,InstructionDO instructionDO) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andInstructionIdEqualTo(instructionId);
		instructionDAO.updateByExample(instructionDO, exam);
	}

    /**
	 * 根据platPartnerId更新instruction表数据
	 */
	public void updateInstructionByPlatPartnerId(String platPartnerId,InstructionDO instructionDO) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		instructionDAO.updateByExample(instructionDO, exam);
	}

    /**
	 * 根据partnerId更新instruction表数据
	 */
	public void updateInstructionByPartnerId(String partnerId,InstructionDO instructionDO) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		instructionDAO.updateByExample(instructionDO, exam);
	}

    /**
	 * 根据gid更新instruction表数据
	 */
	public void updateInstructionByGid(String gid,InstructionDO instructionDO) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		instructionDAO.updateByExample(instructionDO, exam);
	}

    /**
	 * 根据reqId更新instruction表数据
	 */
	public void updateInstructionByReqId(String reqId,InstructionDO instructionDO) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		instructionDAO.updateByExample(instructionDO, exam);
	}

    /**
	 * 根据platMerchantOrderNo更新instruction表数据
	 */
	public void updateInstructionByPlatMerchantOrderNo(String platMerchantOrderNo,InstructionDO instructionDO) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		instructionDAO.updateByExample(instructionDO, exam);
	}

    /**
	 * 根据merchantOrderNo更新instruction表数据
	 */
	public void updateInstructionByMerchantOrderNo(String merchantOrderNo,InstructionDO instructionDO) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		instructionDAO.updateByExample(instructionDO, exam);
	}

	/**
	* 根据code更新instruction表数据
	*/
	public void updateInstructionByCode(String code,InstructionDO instructionDO) {
		InstructionDOExample exam = new InstructionDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		instructionDAO.updateByExample(instructionDO, exam);
	}

    /**
	 * 断言merchant_auth表
	 */
	public void merchantAuthAssert(
	        MerchantAuthDO merchantAuthDO,
			Long id, 
			String partnerId, 
			String partnerAbbrName, 
			String businessCategory, 
			String storeAddress, 
			String storeEntrancePicsUrl, 
			String storeIndoorPicsUrl, 
			String qualificationsPicUrl, 
			String businessAdditionPicsUrl, 
			String businessLicense, 
			String businessLicensePicUrl, 
			String businessTime, 
			String businessScope, 
			String accountOpeningLicensePicUrl, 
			String legalName, 
			String legalCertType, 
			String legalCertNo, 
			String legalCertValidTime, 
			String legalCertFrontPicUrl, 
			String legalCertBackPicUrl, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, merchantAuthDO.getId());
        assertEquals(partnerId, merchantAuthDO.getPartnerId());
        assertEquals(partnerAbbrName, merchantAuthDO.getPartnerAbbrName());
        assertEquals(businessCategory, merchantAuthDO.getBusinessCategory());
        assertEquals(storeAddress, merchantAuthDO.getStoreAddress());
        assertEquals(storeEntrancePicsUrl, merchantAuthDO.getStoreEntrancePicsUrl());
        assertEquals(storeIndoorPicsUrl, merchantAuthDO.getStoreIndoorPicsUrl());
        assertEquals(qualificationsPicUrl, merchantAuthDO.getQualificationsPicUrl());
        assertEquals(businessAdditionPicsUrl, merchantAuthDO.getBusinessAdditionPicsUrl());
        assertEquals(businessLicense, merchantAuthDO.getBusinessLicense());
        assertEquals(businessLicensePicUrl, merchantAuthDO.getBusinessLicensePicUrl());
        assertEquals(businessTime, merchantAuthDO.getBusinessTime());
        assertEquals(businessScope, merchantAuthDO.getBusinessScope());
        assertEquals(accountOpeningLicensePicUrl, merchantAuthDO.getAccountOpeningLicensePicUrl());
        assertEquals(legalName, merchantAuthDO.getLegalName());
        assertEquals(legalCertType, merchantAuthDO.getLegalCertType());
        assertEquals(legalCertNo, merchantAuthDO.getLegalCertNo());
        assertEquals(legalCertValidTime, merchantAuthDO.getLegalCertValidTime());
        assertEquals(legalCertFrontPicUrl, merchantAuthDO.getLegalCertFrontPicUrl());
        assertEquals(legalCertBackPicUrl, merchantAuthDO.getLegalCertBackPicUrl());
        assertEquals(rawAddTime, merchantAuthDO.getRawAddTime());
        assertEquals(rawUpdateTime, merchantAuthDO.getRawUpdateTime());
	}

	/**
	 * 断言merchant_auth表数据
	 */
	public void assertMerchantAuth(MerchantAuthDO expect, MerchantAuthDO merchantAuthDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			merchantAuthDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != merchantAuthDO.getRawAddTime());
		expect.setRawAddTime(merchantAuthDO.getRawAddTime());
        Assertions.assertTrue(null != merchantAuthDO.getRawUpdateTime());
		expect.setRawUpdateTime(merchantAuthDO.getRawUpdateTime());
		Assertions.assertEquals(expect, merchantAuthDO);
	}

    /**
	 * 插入merchant_auth表数据
	 */
	public void insertMerchantAuth(MerchantAuthDO merchantAuthDO) {
		merchantAuthDAO.insert(merchantAuthDO);
	}

    /**
	 * 插入merchant_auth表数据
	 */
	public void insertMerchantAuth(
			Long id, 
			String partnerId, 
			String partnerAbbrName, 
			String businessCategory, 
			String storeAddress, 
			String storeEntrancePicsUrl, 
			String storeIndoorPicsUrl, 
			String qualificationsPicUrl, 
			String businessAdditionPicsUrl, 
			String businessLicense, 
			String businessLicensePicUrl, 
			String businessTime, 
			String businessScope, 
			String accountOpeningLicensePicUrl, 
			String legalName, 
			String legalCertType, 
			String legalCertNo, 
			String legalCertValidTime, 
			String legalCertFrontPicUrl, 
			String legalCertBackPicUrl, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		MerchantAuthDO merchantAuthDO = new MerchantAuthDO();
		merchantAuthDO.setId(id);
		merchantAuthDO.setPartnerId(partnerId);
		merchantAuthDO.setPartnerAbbrName(partnerAbbrName);
		merchantAuthDO.setBusinessCategory(businessCategory);
		merchantAuthDO.setStoreAddress(storeAddress);
		merchantAuthDO.setStoreEntrancePicsUrl(storeEntrancePicsUrl);
		merchantAuthDO.setStoreIndoorPicsUrl(storeIndoorPicsUrl);
		merchantAuthDO.setQualificationsPicUrl(qualificationsPicUrl);
		merchantAuthDO.setBusinessAdditionPicsUrl(businessAdditionPicsUrl);
		merchantAuthDO.setBusinessLicense(businessLicense);
		merchantAuthDO.setBusinessLicensePicUrl(businessLicensePicUrl);
		merchantAuthDO.setBusinessTime(businessTime);
		merchantAuthDO.setBusinessScope(businessScope);
		merchantAuthDO.setAccountOpeningLicensePicUrl(accountOpeningLicensePicUrl);
		merchantAuthDO.setLegalName(legalName);
		merchantAuthDO.setLegalCertType(legalCertType);
		merchantAuthDO.setLegalCertNo(legalCertNo);
		merchantAuthDO.setLegalCertValidTime(legalCertValidTime);
		merchantAuthDO.setLegalCertFrontPicUrl(legalCertFrontPicUrl);
		merchantAuthDO.setLegalCertBackPicUrl(legalCertBackPicUrl);
		merchantAuthDO.setRawAddTime(rawAddTime);
		merchantAuthDO.setRawUpdateTime(rawUpdateTime);
		merchantAuthDAO.insert(merchantAuthDO);
	}

    /**
     * 删除merchant_auth表所有数据
     */
    public void cleanMerchantAuth() {
        MerchantAuthDOExample exam = new MerchantAuthDOExample();
        exam.createCriteria();
        merchantAuthDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除merchant_auth表数据
	 */
	public void cleanMerchantAuthById(Long id) {
		MerchantAuthDOExample exam = new MerchantAuthDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantAuthDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除merchant_auth表数据
	 */
	public void cleanMerchantAuthByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		MerchantAuthDOExample exam = new MerchantAuthDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantAuthDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerAbbrName删除merchant_auth表数据
	*/
	public void cleanMerchantAuthByPartnerAbbrName(String partnerAbbrName) {
        if (StringUtils.isBlank(partnerAbbrName)){
            partnerAbbrName = "test_partnerAbbrName";
        }
		MerchantAuthDOExample exam = new MerchantAuthDOExample();
		exam.createCriteria().andPartnerAbbrNameEqualTo(partnerAbbrName);
		merchantAuthDAO.deleteByExample(exam);
	}

	/**
	* 根据legalName删除merchant_auth表数据
	*/
	public void cleanMerchantAuthByLegalName(String legalName) {
        if (StringUtils.isBlank(legalName)){
            legalName = "test_legalName";
        }
		MerchantAuthDOExample exam = new MerchantAuthDOExample();
		exam.createCriteria().andLegalNameEqualTo(legalName);
		merchantAuthDAO.deleteByExample(exam);
	}

	/**
	 * 根据legalCertNo删除merchant_auth表数据
	 */
	public void cleanMerchantAuthByLegalCertNo(String legalCertNo) {
        if (StringUtils.isBlank(legalCertNo)){
            legalCertNo = "test_legalCertNo";
        }
		MerchantAuthDOExample exam = new MerchantAuthDOExample();
		exam.createCriteria().andLegalCertNoEqualTo(legalCertNo);
		merchantAuthDAO.deleteByExample(exam);
	}

	/**
	 * 根据legalCertValidTime删除merchant_auth表数据
	 */
	public void cleanMerchantAuthByLegalCertValidTime(String legalCertValidTime) {
        if (StringUtils.isBlank(legalCertValidTime)){
            legalCertValidTime = "test_legalCertValidTime";
        }
		MerchantAuthDOExample exam = new MerchantAuthDOExample();
		exam.createCriteria().andLegalCertValidTimeEqualTo(legalCertValidTime);
		merchantAuthDAO.deleteByExample(exam);
	}

    /**
     * 查询merchant_auth表所有数据
     */
    public List<MerchantAuthDO> findMerchantAuthAll() {
        MerchantAuthDOExample exam = new MerchantAuthDOExample();
        exam.createCriteria();
		return merchantAuthDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询merchant_auth表数据
	 */
	public List<MerchantAuthDO> findMerchantAuthById(Long id) {
		MerchantAuthDOExample exam = new MerchantAuthDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return merchantAuthDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询merchant_auth表数据
	 */
	public List<MerchantAuthDO> findMerchantAuthByPartnerId(String partnerId) {
		MerchantAuthDOExample exam = new MerchantAuthDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return merchantAuthDAO.selectByExample(exam);
	}

	/**
	* 根据partnerAbbrName查询merchant_auth表数据
	*/
	public List<MerchantAuthDO> findMerchantAuthByPartnerAbbrName(String partnerAbbrName) {
		MerchantAuthDOExample exam = new MerchantAuthDOExample();
		exam.createCriteria().andPartnerAbbrNameEqualTo(partnerAbbrName);
		return merchantAuthDAO.selectByExample(exam);
	}

	/**
	* 根据legalName查询merchant_auth表数据
	*/
	public List<MerchantAuthDO> findMerchantAuthByLegalName(String legalName) {
		MerchantAuthDOExample exam = new MerchantAuthDOExample();
		exam.createCriteria().andLegalNameEqualTo(legalName);
		return merchantAuthDAO.selectByExample(exam);
	}

    /**
	 * 根据legalCertNo查询merchant_auth表数据
	 */
	public List<MerchantAuthDO> findMerchantAuthByLegalCertNo(String legalCertNo) {
		MerchantAuthDOExample exam = new MerchantAuthDOExample();
		exam.createCriteria().andLegalCertNoEqualTo(legalCertNo);
		return merchantAuthDAO.selectByExample(exam);
	}

    /**
	 * 根据legalCertValidTime查询merchant_auth表数据
	 */
	public List<MerchantAuthDO> findMerchantAuthByLegalCertValidTime(String legalCertValidTime) {
		MerchantAuthDOExample exam = new MerchantAuthDOExample();
		exam.createCriteria().andLegalCertValidTimeEqualTo(legalCertValidTime);
		return merchantAuthDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新merchant_auth表数据
	 */
	public void updateMerchantAuthById(Long id,MerchantAuthDO merchantAuthDO) {
		MerchantAuthDOExample exam = new MerchantAuthDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantAuthDAO.updateByExample(merchantAuthDO, exam);
	}

    /**
	 * 根据partnerId更新merchant_auth表数据
	 */
	public void updateMerchantAuthByPartnerId(String partnerId,MerchantAuthDO merchantAuthDO) {
		MerchantAuthDOExample exam = new MerchantAuthDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantAuthDAO.updateByExample(merchantAuthDO, exam);
	}

	/**
	* 根据partnerAbbrName更新merchant_auth表数据
	*/
	public void updateMerchantAuthByPartnerAbbrName(String partnerAbbrName,MerchantAuthDO merchantAuthDO) {
		MerchantAuthDOExample exam = new MerchantAuthDOExample();
		exam.createCriteria().andPartnerAbbrNameEqualTo(partnerAbbrName);
		merchantAuthDAO.updateByExample(merchantAuthDO, exam);
	}

	/**
	* 根据legalName更新merchant_auth表数据
	*/
	public void updateMerchantAuthByLegalName(String legalName,MerchantAuthDO merchantAuthDO) {
		MerchantAuthDOExample exam = new MerchantAuthDOExample();
		exam.createCriteria().andLegalNameEqualTo(legalName);
		merchantAuthDAO.updateByExample(merchantAuthDO, exam);
	}

    /**
	 * 根据legalCertNo更新merchant_auth表数据
	 */
	public void updateMerchantAuthByLegalCertNo(String legalCertNo,MerchantAuthDO merchantAuthDO) {
		MerchantAuthDOExample exam = new MerchantAuthDOExample();
		exam.createCriteria().andLegalCertNoEqualTo(legalCertNo);
		merchantAuthDAO.updateByExample(merchantAuthDO, exam);
	}

    /**
	 * 根据legalCertValidTime更新merchant_auth表数据
	 */
	public void updateMerchantAuthByLegalCertValidTime(String legalCertValidTime,MerchantAuthDO merchantAuthDO) {
		MerchantAuthDOExample exam = new MerchantAuthDOExample();
		exam.createCriteria().andLegalCertValidTimeEqualTo(legalCertValidTime);
		merchantAuthDAO.updateByExample(merchantAuthDO, exam);
	}

    /**
	 * 断言merchant_channel_bank_card表
	 */
	public void merchantChannelBankCardAssert(
	        MerchantChannelBankCardDO merchantChannelBankCardDO,
			Long id, 
			String gid, 
			String reqId, 
			String userId, 
			String channelId, 
			String bankCardNo, 
			String bankCardName, 
			String bankCardPhone, 
			String certType, 
			String certNo, 
			String province, 
			String city, 
			String bankName, 
			String bankId, 
			String bankKey, 
			String subBankName, 
			String defaultBind, 
			String bankCardType, 
			String bankAccountType, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, merchantChannelBankCardDO.getId());
        assertEquals(gid, merchantChannelBankCardDO.getGid());
        assertEquals(reqId, merchantChannelBankCardDO.getReqId());
        assertEquals(userId, merchantChannelBankCardDO.getUserId());
        assertEquals(channelId, merchantChannelBankCardDO.getChannelId());
        assertEquals(bankCardNo, merchantChannelBankCardDO.getBankCardNo());
        assertEquals(bankCardName, merchantChannelBankCardDO.getBankCardName());
        assertEquals(bankCardPhone, merchantChannelBankCardDO.getBankCardPhone());
        assertEquals(certType, merchantChannelBankCardDO.getCertType());
        assertEquals(certNo, merchantChannelBankCardDO.getCertNo());
        assertEquals(province, merchantChannelBankCardDO.getProvince());
        assertEquals(city, merchantChannelBankCardDO.getCity());
        assertEquals(bankName, merchantChannelBankCardDO.getBankName());
        assertEquals(bankId, merchantChannelBankCardDO.getBankId());
        assertEquals(bankKey, merchantChannelBankCardDO.getBankKey());
        assertEquals(subBankName, merchantChannelBankCardDO.getSubBankName());
        assertEquals(defaultBind, merchantChannelBankCardDO.getDefaultBind());
        assertEquals(bankCardType, merchantChannelBankCardDO.getBankCardType());
        assertEquals(bankAccountType, merchantChannelBankCardDO.getBankAccountType());
        assertEquals(rawAddTime, merchantChannelBankCardDO.getRawAddTime());
        assertEquals(rawUpdateTime, merchantChannelBankCardDO.getRawUpdateTime());
	}

	/**
	 * 断言merchant_channel_bank_card表数据
	 */
	public void assertMerchantChannelBankCard(MerchantChannelBankCardDO expect, MerchantChannelBankCardDO merchantChannelBankCardDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			merchantChannelBankCardDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != merchantChannelBankCardDO.getRawAddTime());
		expect.setRawAddTime(merchantChannelBankCardDO.getRawAddTime());
        Assertions.assertTrue(null != merchantChannelBankCardDO.getRawUpdateTime());
		expect.setRawUpdateTime(merchantChannelBankCardDO.getRawUpdateTime());
		Assertions.assertEquals(expect, merchantChannelBankCardDO);
	}

    /**
	 * 插入merchant_channel_bank_card表数据
	 */
	public void insertMerchantChannelBankCard(MerchantChannelBankCardDO merchantChannelBankCardDO) {
		merchantChannelBankCardDAO.insert(merchantChannelBankCardDO);
	}

    /**
	 * 插入merchant_channel_bank_card表数据
	 */
	public void insertMerchantChannelBankCard(
			Long id, 
			String gid, 
			String reqId, 
			String userId, 
			String channelId, 
			String bankCardNo, 
			String bankCardName, 
			String bankCardPhone, 
			String certType, 
			String certNo, 
			String province, 
			String city, 
			String bankName, 
			String bankId, 
			String bankKey, 
			String subBankName, 
			String defaultBind, 
			String bankCardType, 
			String bankAccountType, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		MerchantChannelBankCardDO merchantChannelBankCardDO = new MerchantChannelBankCardDO();
		merchantChannelBankCardDO.setId(id);
		merchantChannelBankCardDO.setGid(gid);
		merchantChannelBankCardDO.setReqId(reqId);
		merchantChannelBankCardDO.setUserId(userId);
		merchantChannelBankCardDO.setChannelId(channelId);
		merchantChannelBankCardDO.setBankCardNo(bankCardNo);
		merchantChannelBankCardDO.setBankCardName(bankCardName);
		merchantChannelBankCardDO.setBankCardPhone(bankCardPhone);
		merchantChannelBankCardDO.setCertType(certType);
		merchantChannelBankCardDO.setCertNo(certNo);
		merchantChannelBankCardDO.setProvince(province);
		merchantChannelBankCardDO.setCity(city);
		merchantChannelBankCardDO.setBankName(bankName);
		merchantChannelBankCardDO.setBankId(bankId);
		merchantChannelBankCardDO.setBankKey(bankKey);
		merchantChannelBankCardDO.setSubBankName(subBankName);
		merchantChannelBankCardDO.setDefaultBind(defaultBind);
		merchantChannelBankCardDO.setBankCardType(bankCardType);
		merchantChannelBankCardDO.setBankAccountType(bankAccountType);
		merchantChannelBankCardDO.setRawAddTime(rawAddTime);
		merchantChannelBankCardDO.setRawUpdateTime(rawUpdateTime);
		merchantChannelBankCardDAO.insert(merchantChannelBankCardDO);
	}

    /**
     * 删除merchant_channel_bank_card表所有数据
     */
    public void cleanMerchantChannelBankCard() {
        MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
        exam.createCriteria();
        merchantChannelBankCardDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除merchant_channel_bank_card表数据
	 */
	public void cleanMerchantChannelBankCardById(Long id) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantChannelBankCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除merchant_channel_bank_card表数据
	 */
	public void cleanMerchantChannelBankCardByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		merchantChannelBankCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除merchant_channel_bank_card表数据
	 */
	public void cleanMerchantChannelBankCardByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		merchantChannelBankCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除merchant_channel_bank_card表数据
	 */
	public void cleanMerchantChannelBankCardByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		merchantChannelBankCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除merchant_channel_bank_card表数据
	 */
	public void cleanMerchantChannelBankCardByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		merchantChannelBankCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据bankCardNo删除merchant_channel_bank_card表数据
	 */
	public void cleanMerchantChannelBankCardByBankCardNo(String bankCardNo) {
        if (StringUtils.isBlank(bankCardNo)){
            bankCardNo = "test_bankCardNo";
        }
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andBankCardNoEqualTo(bankCardNo);
		merchantChannelBankCardDAO.deleteByExample(exam);
	}

	/**
	* 根据bankCardName删除merchant_channel_bank_card表数据
	*/
	public void cleanMerchantChannelBankCardByBankCardName(String bankCardName) {
        if (StringUtils.isBlank(bankCardName)){
            bankCardName = "test_bankCardName";
        }
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andBankCardNameEqualTo(bankCardName);
		merchantChannelBankCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据certNo删除merchant_channel_bank_card表数据
	 */
	public void cleanMerchantChannelBankCardByCertNo(String certNo) {
        if (StringUtils.isBlank(certNo)){
            certNo = "test_certNo";
        }
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		merchantChannelBankCardDAO.deleteByExample(exam);
	}

	/**
	* 根据bankName删除merchant_channel_bank_card表数据
	*/
	public void cleanMerchantChannelBankCardByBankName(String bankName) {
        if (StringUtils.isBlank(bankName)){
            bankName = "test_bankName";
        }
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andBankNameEqualTo(bankName);
		merchantChannelBankCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据bankId删除merchant_channel_bank_card表数据
	 */
	public void cleanMerchantChannelBankCardByBankId(String bankId) {
        if (StringUtils.isBlank(bankId)){
            bankId = "test_bankId";
        }
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andBankIdEqualTo(bankId);
		merchantChannelBankCardDAO.deleteByExample(exam);
	}

	/**
	* 根据subBankName删除merchant_channel_bank_card表数据
	*/
	public void cleanMerchantChannelBankCardBySubBankName(String subBankName) {
        if (StringUtils.isBlank(subBankName)){
            subBankName = "test_subBankName";
        }
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andSubBankNameEqualTo(subBankName);
		merchantChannelBankCardDAO.deleteByExample(exam);
	}

    /**
     * 查询merchant_channel_bank_card表所有数据
     */
    public List<MerchantChannelBankCardDO> findMerchantChannelBankCardAll() {
        MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
        exam.createCriteria();
		return merchantChannelBankCardDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询merchant_channel_bank_card表数据
	 */
	public List<MerchantChannelBankCardDO> findMerchantChannelBankCardById(Long id) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return merchantChannelBankCardDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询merchant_channel_bank_card表数据
	 */
	public List<MerchantChannelBankCardDO> findMerchantChannelBankCardByGid(String gid) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return merchantChannelBankCardDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询merchant_channel_bank_card表数据
	 */
	public List<MerchantChannelBankCardDO> findMerchantChannelBankCardByReqId(String reqId) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return merchantChannelBankCardDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询merchant_channel_bank_card表数据
	 */
	public List<MerchantChannelBankCardDO> findMerchantChannelBankCardByUserId(String userId) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return merchantChannelBankCardDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询merchant_channel_bank_card表数据
	 */
	public List<MerchantChannelBankCardDO> findMerchantChannelBankCardByChannelId(String channelId) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return merchantChannelBankCardDAO.selectByExample(exam);
	}

    /**
	 * 根据bankCardNo查询merchant_channel_bank_card表数据
	 */
	public List<MerchantChannelBankCardDO> findMerchantChannelBankCardByBankCardNo(String bankCardNo) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andBankCardNoEqualTo(bankCardNo);
		return merchantChannelBankCardDAO.selectByExample(exam);
	}

	/**
	* 根据bankCardName查询merchant_channel_bank_card表数据
	*/
	public List<MerchantChannelBankCardDO> findMerchantChannelBankCardByBankCardName(String bankCardName) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andBankCardNameEqualTo(bankCardName);
		return merchantChannelBankCardDAO.selectByExample(exam);
	}

    /**
	 * 根据certNo查询merchant_channel_bank_card表数据
	 */
	public List<MerchantChannelBankCardDO> findMerchantChannelBankCardByCertNo(String certNo) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		return merchantChannelBankCardDAO.selectByExample(exam);
	}

	/**
	* 根据bankName查询merchant_channel_bank_card表数据
	*/
	public List<MerchantChannelBankCardDO> findMerchantChannelBankCardByBankName(String bankName) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andBankNameEqualTo(bankName);
		return merchantChannelBankCardDAO.selectByExample(exam);
	}

    /**
	 * 根据bankId查询merchant_channel_bank_card表数据
	 */
	public List<MerchantChannelBankCardDO> findMerchantChannelBankCardByBankId(String bankId) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andBankIdEqualTo(bankId);
		return merchantChannelBankCardDAO.selectByExample(exam);
	}

	/**
	* 根据subBankName查询merchant_channel_bank_card表数据
	*/
	public List<MerchantChannelBankCardDO> findMerchantChannelBankCardBySubBankName(String subBankName) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andSubBankNameEqualTo(subBankName);
		return merchantChannelBankCardDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新merchant_channel_bank_card表数据
	 */
	public void updateMerchantChannelBankCardById(Long id,MerchantChannelBankCardDO merchantChannelBankCardDO) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantChannelBankCardDAO.updateByExample(merchantChannelBankCardDO, exam);
	}

    /**
	 * 根据gid更新merchant_channel_bank_card表数据
	 */
	public void updateMerchantChannelBankCardByGid(String gid,MerchantChannelBankCardDO merchantChannelBankCardDO) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		merchantChannelBankCardDAO.updateByExample(merchantChannelBankCardDO, exam);
	}

    /**
	 * 根据reqId更新merchant_channel_bank_card表数据
	 */
	public void updateMerchantChannelBankCardByReqId(String reqId,MerchantChannelBankCardDO merchantChannelBankCardDO) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		merchantChannelBankCardDAO.updateByExample(merchantChannelBankCardDO, exam);
	}

    /**
	 * 根据userId更新merchant_channel_bank_card表数据
	 */
	public void updateMerchantChannelBankCardByUserId(String userId,MerchantChannelBankCardDO merchantChannelBankCardDO) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		merchantChannelBankCardDAO.updateByExample(merchantChannelBankCardDO, exam);
	}

    /**
	 * 根据channelId更新merchant_channel_bank_card表数据
	 */
	public void updateMerchantChannelBankCardByChannelId(String channelId,MerchantChannelBankCardDO merchantChannelBankCardDO) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		merchantChannelBankCardDAO.updateByExample(merchantChannelBankCardDO, exam);
	}

    /**
	 * 根据bankCardNo更新merchant_channel_bank_card表数据
	 */
	public void updateMerchantChannelBankCardByBankCardNo(String bankCardNo,MerchantChannelBankCardDO merchantChannelBankCardDO) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andBankCardNoEqualTo(bankCardNo);
		merchantChannelBankCardDAO.updateByExample(merchantChannelBankCardDO, exam);
	}

	/**
	* 根据bankCardName更新merchant_channel_bank_card表数据
	*/
	public void updateMerchantChannelBankCardByBankCardName(String bankCardName,MerchantChannelBankCardDO merchantChannelBankCardDO) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andBankCardNameEqualTo(bankCardName);
		merchantChannelBankCardDAO.updateByExample(merchantChannelBankCardDO, exam);
	}

    /**
	 * 根据certNo更新merchant_channel_bank_card表数据
	 */
	public void updateMerchantChannelBankCardByCertNo(String certNo,MerchantChannelBankCardDO merchantChannelBankCardDO) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		merchantChannelBankCardDAO.updateByExample(merchantChannelBankCardDO, exam);
	}

	/**
	* 根据bankName更新merchant_channel_bank_card表数据
	*/
	public void updateMerchantChannelBankCardByBankName(String bankName,MerchantChannelBankCardDO merchantChannelBankCardDO) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andBankNameEqualTo(bankName);
		merchantChannelBankCardDAO.updateByExample(merchantChannelBankCardDO, exam);
	}

    /**
	 * 根据bankId更新merchant_channel_bank_card表数据
	 */
	public void updateMerchantChannelBankCardByBankId(String bankId,MerchantChannelBankCardDO merchantChannelBankCardDO) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andBankIdEqualTo(bankId);
		merchantChannelBankCardDAO.updateByExample(merchantChannelBankCardDO, exam);
	}

	/**
	* 根据subBankName更新merchant_channel_bank_card表数据
	*/
	public void updateMerchantChannelBankCardBySubBankName(String subBankName,MerchantChannelBankCardDO merchantChannelBankCardDO) {
		MerchantChannelBankCardDOExample exam = new MerchantChannelBankCardDOExample();
		exam.createCriteria().andSubBankNameEqualTo(subBankName);
		merchantChannelBankCardDAO.updateByExample(merchantChannelBankCardDO, exam);
	}

    /**
	 * 断言merchant_channel_bank_card_his表
	 */
	public void merchantChannelBankCardHisAssert(
	        MerchantChannelBankCardHisDO merchantChannelBankCardHisDO,
			Long id, 
			String gid, 
			String reqId, 
			String userId, 
			String channelId, 
			String bankCardNo, 
			String bankCardName, 
			String bankCardPhone, 
			String certType, 
			String certNo, 
			String province, 
			String city, 
			String bankName, 
			String bankId, 
			String bankKey, 
			String subBankName, 
			String defaultBind, 
			String bankCardType, 
			String bankAccountType, 
			Date bindCardTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, merchantChannelBankCardHisDO.getId());
        assertEquals(gid, merchantChannelBankCardHisDO.getGid());
        assertEquals(reqId, merchantChannelBankCardHisDO.getReqId());
        assertEquals(userId, merchantChannelBankCardHisDO.getUserId());
        assertEquals(channelId, merchantChannelBankCardHisDO.getChannelId());
        assertEquals(bankCardNo, merchantChannelBankCardHisDO.getBankCardNo());
        assertEquals(bankCardName, merchantChannelBankCardHisDO.getBankCardName());
        assertEquals(bankCardPhone, merchantChannelBankCardHisDO.getBankCardPhone());
        assertEquals(certType, merchantChannelBankCardHisDO.getCertType());
        assertEquals(certNo, merchantChannelBankCardHisDO.getCertNo());
        assertEquals(province, merchantChannelBankCardHisDO.getProvince());
        assertEquals(city, merchantChannelBankCardHisDO.getCity());
        assertEquals(bankName, merchantChannelBankCardHisDO.getBankName());
        assertEquals(bankId, merchantChannelBankCardHisDO.getBankId());
        assertEquals(bankKey, merchantChannelBankCardHisDO.getBankKey());
        assertEquals(subBankName, merchantChannelBankCardHisDO.getSubBankName());
        assertEquals(defaultBind, merchantChannelBankCardHisDO.getDefaultBind());
        assertEquals(bankCardType, merchantChannelBankCardHisDO.getBankCardType());
        assertEquals(bankAccountType, merchantChannelBankCardHisDO.getBankAccountType());
        assertEquals(bindCardTime, merchantChannelBankCardHisDO.getBindCardTime());
        assertEquals(rawAddTime, merchantChannelBankCardHisDO.getRawAddTime());
        assertEquals(rawUpdateTime, merchantChannelBankCardHisDO.getRawUpdateTime());
	}

	/**
	 * 断言merchant_channel_bank_card_his表数据
	 */
	public void assertMerchantChannelBankCardHis(MerchantChannelBankCardHisDO expect, MerchantChannelBankCardHisDO merchantChannelBankCardHisDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			merchantChannelBankCardHisDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != merchantChannelBankCardHisDO.getRawAddTime());
		expect.setRawAddTime(merchantChannelBankCardHisDO.getRawAddTime());
        Assertions.assertTrue(null != merchantChannelBankCardHisDO.getRawUpdateTime());
		expect.setRawUpdateTime(merchantChannelBankCardHisDO.getRawUpdateTime());
		Assertions.assertEquals(expect, merchantChannelBankCardHisDO);
	}

    /**
	 * 插入merchant_channel_bank_card_his表数据
	 */
	public void insertMerchantChannelBankCardHis(MerchantChannelBankCardHisDO merchantChannelBankCardHisDO) {
		merchantChannelBankCardHisDAO.insert(merchantChannelBankCardHisDO);
	}

    /**
	 * 插入merchant_channel_bank_card_his表数据
	 */
	public void insertMerchantChannelBankCardHis(
			Long id, 
			String gid, 
			String reqId, 
			String userId, 
			String channelId, 
			String bankCardNo, 
			String bankCardName, 
			String bankCardPhone, 
			String certType, 
			String certNo, 
			String province, 
			String city, 
			String bankName, 
			String bankId, 
			String bankKey, 
			String subBankName, 
			String defaultBind, 
			String bankCardType, 
			String bankAccountType, 
			Date bindCardTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		MerchantChannelBankCardHisDO merchantChannelBankCardHisDO = new MerchantChannelBankCardHisDO();
		merchantChannelBankCardHisDO.setId(id);
		merchantChannelBankCardHisDO.setGid(gid);
		merchantChannelBankCardHisDO.setReqId(reqId);
		merchantChannelBankCardHisDO.setUserId(userId);
		merchantChannelBankCardHisDO.setChannelId(channelId);
		merchantChannelBankCardHisDO.setBankCardNo(bankCardNo);
		merchantChannelBankCardHisDO.setBankCardName(bankCardName);
		merchantChannelBankCardHisDO.setBankCardPhone(bankCardPhone);
		merchantChannelBankCardHisDO.setCertType(certType);
		merchantChannelBankCardHisDO.setCertNo(certNo);
		merchantChannelBankCardHisDO.setProvince(province);
		merchantChannelBankCardHisDO.setCity(city);
		merchantChannelBankCardHisDO.setBankName(bankName);
		merchantChannelBankCardHisDO.setBankId(bankId);
		merchantChannelBankCardHisDO.setBankKey(bankKey);
		merchantChannelBankCardHisDO.setSubBankName(subBankName);
		merchantChannelBankCardHisDO.setDefaultBind(defaultBind);
		merchantChannelBankCardHisDO.setBankCardType(bankCardType);
		merchantChannelBankCardHisDO.setBankAccountType(bankAccountType);
		merchantChannelBankCardHisDO.setBindCardTime(bindCardTime);
		merchantChannelBankCardHisDO.setRawAddTime(rawAddTime);
		merchantChannelBankCardHisDO.setRawUpdateTime(rawUpdateTime);
		merchantChannelBankCardHisDAO.insert(merchantChannelBankCardHisDO);
	}

    /**
     * 删除merchant_channel_bank_card_his表所有数据
     */
    public void cleanMerchantChannelBankCardHis() {
        MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
        exam.createCriteria();
        merchantChannelBankCardHisDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除merchant_channel_bank_card_his表数据
	 */
	public void cleanMerchantChannelBankCardHisById(Long id) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantChannelBankCardHisDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除merchant_channel_bank_card_his表数据
	 */
	public void cleanMerchantChannelBankCardHisByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		merchantChannelBankCardHisDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除merchant_channel_bank_card_his表数据
	 */
	public void cleanMerchantChannelBankCardHisByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		merchantChannelBankCardHisDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除merchant_channel_bank_card_his表数据
	 */
	public void cleanMerchantChannelBankCardHisByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		merchantChannelBankCardHisDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除merchant_channel_bank_card_his表数据
	 */
	public void cleanMerchantChannelBankCardHisByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		merchantChannelBankCardHisDAO.deleteByExample(exam);
	}

	/**
	 * 根据bankCardNo删除merchant_channel_bank_card_his表数据
	 */
	public void cleanMerchantChannelBankCardHisByBankCardNo(String bankCardNo) {
        if (StringUtils.isBlank(bankCardNo)){
            bankCardNo = "test_bankCardNo";
        }
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andBankCardNoEqualTo(bankCardNo);
		merchantChannelBankCardHisDAO.deleteByExample(exam);
	}

	/**
	* 根据bankCardName删除merchant_channel_bank_card_his表数据
	*/
	public void cleanMerchantChannelBankCardHisByBankCardName(String bankCardName) {
        if (StringUtils.isBlank(bankCardName)){
            bankCardName = "test_bankCardName";
        }
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andBankCardNameEqualTo(bankCardName);
		merchantChannelBankCardHisDAO.deleteByExample(exam);
	}

	/**
	 * 根据certNo删除merchant_channel_bank_card_his表数据
	 */
	public void cleanMerchantChannelBankCardHisByCertNo(String certNo) {
        if (StringUtils.isBlank(certNo)){
            certNo = "test_certNo";
        }
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		merchantChannelBankCardHisDAO.deleteByExample(exam);
	}

	/**
	* 根据bankName删除merchant_channel_bank_card_his表数据
	*/
	public void cleanMerchantChannelBankCardHisByBankName(String bankName) {
        if (StringUtils.isBlank(bankName)){
            bankName = "test_bankName";
        }
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andBankNameEqualTo(bankName);
		merchantChannelBankCardHisDAO.deleteByExample(exam);
	}

	/**
	 * 根据bankId删除merchant_channel_bank_card_his表数据
	 */
	public void cleanMerchantChannelBankCardHisByBankId(String bankId) {
        if (StringUtils.isBlank(bankId)){
            bankId = "test_bankId";
        }
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andBankIdEqualTo(bankId);
		merchantChannelBankCardHisDAO.deleteByExample(exam);
	}

	/**
	* 根据subBankName删除merchant_channel_bank_card_his表数据
	*/
	public void cleanMerchantChannelBankCardHisBySubBankName(String subBankName) {
        if (StringUtils.isBlank(subBankName)){
            subBankName = "test_subBankName";
        }
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andSubBankNameEqualTo(subBankName);
		merchantChannelBankCardHisDAO.deleteByExample(exam);
	}

    /**
     * 查询merchant_channel_bank_card_his表所有数据
     */
    public List<MerchantChannelBankCardHisDO> findMerchantChannelBankCardHisAll() {
        MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
        exam.createCriteria();
		return merchantChannelBankCardHisDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询merchant_channel_bank_card_his表数据
	 */
	public List<MerchantChannelBankCardHisDO> findMerchantChannelBankCardHisById(Long id) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return merchantChannelBankCardHisDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询merchant_channel_bank_card_his表数据
	 */
	public List<MerchantChannelBankCardHisDO> findMerchantChannelBankCardHisByGid(String gid) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return merchantChannelBankCardHisDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询merchant_channel_bank_card_his表数据
	 */
	public List<MerchantChannelBankCardHisDO> findMerchantChannelBankCardHisByReqId(String reqId) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return merchantChannelBankCardHisDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询merchant_channel_bank_card_his表数据
	 */
	public List<MerchantChannelBankCardHisDO> findMerchantChannelBankCardHisByUserId(String userId) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return merchantChannelBankCardHisDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询merchant_channel_bank_card_his表数据
	 */
	public List<MerchantChannelBankCardHisDO> findMerchantChannelBankCardHisByChannelId(String channelId) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return merchantChannelBankCardHisDAO.selectByExample(exam);
	}

    /**
	 * 根据bankCardNo查询merchant_channel_bank_card_his表数据
	 */
	public List<MerchantChannelBankCardHisDO> findMerchantChannelBankCardHisByBankCardNo(String bankCardNo) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andBankCardNoEqualTo(bankCardNo);
		return merchantChannelBankCardHisDAO.selectByExample(exam);
	}

	/**
	* 根据bankCardName查询merchant_channel_bank_card_his表数据
	*/
	public List<MerchantChannelBankCardHisDO> findMerchantChannelBankCardHisByBankCardName(String bankCardName) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andBankCardNameEqualTo(bankCardName);
		return merchantChannelBankCardHisDAO.selectByExample(exam);
	}

    /**
	 * 根据certNo查询merchant_channel_bank_card_his表数据
	 */
	public List<MerchantChannelBankCardHisDO> findMerchantChannelBankCardHisByCertNo(String certNo) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		return merchantChannelBankCardHisDAO.selectByExample(exam);
	}

	/**
	* 根据bankName查询merchant_channel_bank_card_his表数据
	*/
	public List<MerchantChannelBankCardHisDO> findMerchantChannelBankCardHisByBankName(String bankName) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andBankNameEqualTo(bankName);
		return merchantChannelBankCardHisDAO.selectByExample(exam);
	}

    /**
	 * 根据bankId查询merchant_channel_bank_card_his表数据
	 */
	public List<MerchantChannelBankCardHisDO> findMerchantChannelBankCardHisByBankId(String bankId) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andBankIdEqualTo(bankId);
		return merchantChannelBankCardHisDAO.selectByExample(exam);
	}

	/**
	* 根据subBankName查询merchant_channel_bank_card_his表数据
	*/
	public List<MerchantChannelBankCardHisDO> findMerchantChannelBankCardHisBySubBankName(String subBankName) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andSubBankNameEqualTo(subBankName);
		return merchantChannelBankCardHisDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新merchant_channel_bank_card_his表数据
	 */
	public void updateMerchantChannelBankCardHisById(Long id,MerchantChannelBankCardHisDO merchantChannelBankCardHisDO) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantChannelBankCardHisDAO.updateByExample(merchantChannelBankCardHisDO, exam);
	}

    /**
	 * 根据gid更新merchant_channel_bank_card_his表数据
	 */
	public void updateMerchantChannelBankCardHisByGid(String gid,MerchantChannelBankCardHisDO merchantChannelBankCardHisDO) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		merchantChannelBankCardHisDAO.updateByExample(merchantChannelBankCardHisDO, exam);
	}

    /**
	 * 根据reqId更新merchant_channel_bank_card_his表数据
	 */
	public void updateMerchantChannelBankCardHisByReqId(String reqId,MerchantChannelBankCardHisDO merchantChannelBankCardHisDO) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		merchantChannelBankCardHisDAO.updateByExample(merchantChannelBankCardHisDO, exam);
	}

    /**
	 * 根据userId更新merchant_channel_bank_card_his表数据
	 */
	public void updateMerchantChannelBankCardHisByUserId(String userId,MerchantChannelBankCardHisDO merchantChannelBankCardHisDO) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		merchantChannelBankCardHisDAO.updateByExample(merchantChannelBankCardHisDO, exam);
	}

    /**
	 * 根据channelId更新merchant_channel_bank_card_his表数据
	 */
	public void updateMerchantChannelBankCardHisByChannelId(String channelId,MerchantChannelBankCardHisDO merchantChannelBankCardHisDO) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		merchantChannelBankCardHisDAO.updateByExample(merchantChannelBankCardHisDO, exam);
	}

    /**
	 * 根据bankCardNo更新merchant_channel_bank_card_his表数据
	 */
	public void updateMerchantChannelBankCardHisByBankCardNo(String bankCardNo,MerchantChannelBankCardHisDO merchantChannelBankCardHisDO) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andBankCardNoEqualTo(bankCardNo);
		merchantChannelBankCardHisDAO.updateByExample(merchantChannelBankCardHisDO, exam);
	}

	/**
	* 根据bankCardName更新merchant_channel_bank_card_his表数据
	*/
	public void updateMerchantChannelBankCardHisByBankCardName(String bankCardName,MerchantChannelBankCardHisDO merchantChannelBankCardHisDO) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andBankCardNameEqualTo(bankCardName);
		merchantChannelBankCardHisDAO.updateByExample(merchantChannelBankCardHisDO, exam);
	}

    /**
	 * 根据certNo更新merchant_channel_bank_card_his表数据
	 */
	public void updateMerchantChannelBankCardHisByCertNo(String certNo,MerchantChannelBankCardHisDO merchantChannelBankCardHisDO) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		merchantChannelBankCardHisDAO.updateByExample(merchantChannelBankCardHisDO, exam);
	}

	/**
	* 根据bankName更新merchant_channel_bank_card_his表数据
	*/
	public void updateMerchantChannelBankCardHisByBankName(String bankName,MerchantChannelBankCardHisDO merchantChannelBankCardHisDO) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andBankNameEqualTo(bankName);
		merchantChannelBankCardHisDAO.updateByExample(merchantChannelBankCardHisDO, exam);
	}

    /**
	 * 根据bankId更新merchant_channel_bank_card_his表数据
	 */
	public void updateMerchantChannelBankCardHisByBankId(String bankId,MerchantChannelBankCardHisDO merchantChannelBankCardHisDO) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andBankIdEqualTo(bankId);
		merchantChannelBankCardHisDAO.updateByExample(merchantChannelBankCardHisDO, exam);
	}

	/**
	* 根据subBankName更新merchant_channel_bank_card_his表数据
	*/
	public void updateMerchantChannelBankCardHisBySubBankName(String subBankName,MerchantChannelBankCardHisDO merchantChannelBankCardHisDO) {
		MerchantChannelBankCardHisDOExample exam = new MerchantChannelBankCardHisDOExample();
		exam.createCriteria().andSubBankNameEqualTo(subBankName);
		merchantChannelBankCardHisDAO.updateByExample(merchantChannelBankCardHisDO, exam);
	}

    /**
	 * 断言merchant_channel_trans_log表
	 */
	public void merchantChannelTransLogAssert(
	        MerchantChannelTransLogDO merchantChannelTransLogDO,
			Long id, 
			String gid, 
			String bizNo, 
			String partnerId, 
			String channelTransId, 
			String channel, 
			String channelSubMerchantId, 
			String settlementAccount, 
			Long amount, 
			Long handlingFee, 
			String memo, 
			String tradeStatus, 
			String transDescription, 
			String transAmountType, 
			String channelProcessingTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, merchantChannelTransLogDO.getId());
        assertEquals(gid, merchantChannelTransLogDO.getGid());
        assertEquals(bizNo, merchantChannelTransLogDO.getBizNo());
        assertEquals(partnerId, merchantChannelTransLogDO.getPartnerId());
        assertEquals(channelTransId, merchantChannelTransLogDO.getChannelTransId());
        assertEquals(channel, merchantChannelTransLogDO.getChannel());
        assertEquals(channelSubMerchantId, merchantChannelTransLogDO.getChannelSubMerchantId());
        assertEquals(settlementAccount, merchantChannelTransLogDO.getSettlementAccount());
        assertEquals(amount, merchantChannelTransLogDO.getAmount());
        assertEquals(handlingFee, merchantChannelTransLogDO.getHandlingFee());
        assertEquals(memo, merchantChannelTransLogDO.getMemo());
        assertEquals(tradeStatus, merchantChannelTransLogDO.getTradeStatus());
        assertEquals(transDescription, merchantChannelTransLogDO.getTransDescription());
        assertEquals(transAmountType, merchantChannelTransLogDO.getTransAmountType());
        assertEquals(channelProcessingTime, merchantChannelTransLogDO.getChannelProcessingTime());
        assertEquals(rawAddTime, merchantChannelTransLogDO.getRawAddTime());
        assertEquals(rawUpdateTime, merchantChannelTransLogDO.getRawUpdateTime());
	}

	/**
	 * 断言merchant_channel_trans_log表数据
	 */
	public void assertMerchantChannelTransLog(MerchantChannelTransLogDO expect, MerchantChannelTransLogDO merchantChannelTransLogDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			merchantChannelTransLogDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != merchantChannelTransLogDO.getRawAddTime());
		expect.setRawAddTime(merchantChannelTransLogDO.getRawAddTime());
        Assertions.assertTrue(null != merchantChannelTransLogDO.getRawUpdateTime());
		expect.setRawUpdateTime(merchantChannelTransLogDO.getRawUpdateTime());
		Assertions.assertEquals(expect, merchantChannelTransLogDO);
	}

    /**
	 * 插入merchant_channel_trans_log表数据
	 */
	public void insertMerchantChannelTransLog(MerchantChannelTransLogDO merchantChannelTransLogDO) {
		merchantChannelTransLogDAO.insert(merchantChannelTransLogDO);
	}

    /**
	 * 插入merchant_channel_trans_log表数据
	 */
	public void insertMerchantChannelTransLog(
			Long id, 
			String gid, 
			String bizNo, 
			String partnerId, 
			String channelTransId, 
			String channel, 
			String channelSubMerchantId, 
			String settlementAccount, 
			Long amount, 
			Long handlingFee, 
			String memo, 
			String tradeStatus, 
			String transDescription, 
			String transAmountType, 
			String channelProcessingTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		MerchantChannelTransLogDO merchantChannelTransLogDO = new MerchantChannelTransLogDO();
		merchantChannelTransLogDO.setId(id);
		merchantChannelTransLogDO.setGid(gid);
		merchantChannelTransLogDO.setBizNo(bizNo);
		merchantChannelTransLogDO.setPartnerId(partnerId);
		merchantChannelTransLogDO.setChannelTransId(channelTransId);
		merchantChannelTransLogDO.setChannel(channel);
		merchantChannelTransLogDO.setChannelSubMerchantId(channelSubMerchantId);
		merchantChannelTransLogDO.setSettlementAccount(settlementAccount);
		merchantChannelTransLogDO.setAmount(amount);
		merchantChannelTransLogDO.setHandlingFee(handlingFee);
		merchantChannelTransLogDO.setMemo(memo);
		merchantChannelTransLogDO.setTradeStatus(tradeStatus);
		merchantChannelTransLogDO.setTransDescription(transDescription);
		merchantChannelTransLogDO.setTransAmountType(transAmountType);
		merchantChannelTransLogDO.setChannelProcessingTime(channelProcessingTime);
		merchantChannelTransLogDO.setRawAddTime(rawAddTime);
		merchantChannelTransLogDO.setRawUpdateTime(rawUpdateTime);
		merchantChannelTransLogDAO.insert(merchantChannelTransLogDO);
	}

    /**
     * 删除merchant_channel_trans_log表所有数据
     */
    public void cleanMerchantChannelTransLog() {
        MerchantChannelTransLogDOExample exam = new MerchantChannelTransLogDOExample();
        exam.createCriteria();
        merchantChannelTransLogDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除merchant_channel_trans_log表数据
	 */
	public void cleanMerchantChannelTransLogById(Long id) {
		MerchantChannelTransLogDOExample exam = new MerchantChannelTransLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantChannelTransLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除merchant_channel_trans_log表数据
	 */
	public void cleanMerchantChannelTransLogByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		MerchantChannelTransLogDOExample exam = new MerchantChannelTransLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		merchantChannelTransLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除merchant_channel_trans_log表数据
	 */
	public void cleanMerchantChannelTransLogByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		MerchantChannelTransLogDOExample exam = new MerchantChannelTransLogDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		merchantChannelTransLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除merchant_channel_trans_log表数据
	 */
	public void cleanMerchantChannelTransLogByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		MerchantChannelTransLogDOExample exam = new MerchantChannelTransLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantChannelTransLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelTransId删除merchant_channel_trans_log表数据
	 */
	public void cleanMerchantChannelTransLogByChannelTransId(String channelTransId) {
        if (StringUtils.isBlank(channelTransId)){
            channelTransId = "test_channelTransId";
        }
		MerchantChannelTransLogDOExample exam = new MerchantChannelTransLogDOExample();
		exam.createCriteria().andChannelTransIdEqualTo(channelTransId);
		merchantChannelTransLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelSubMerchantId删除merchant_channel_trans_log表数据
	 */
	public void cleanMerchantChannelTransLogByChannelSubMerchantId(String channelSubMerchantId) {
        if (StringUtils.isBlank(channelSubMerchantId)){
            channelSubMerchantId = "test_channelSubMerchantId";
        }
		MerchantChannelTransLogDOExample exam = new MerchantChannelTransLogDOExample();
		exam.createCriteria().andChannelSubMerchantIdEqualTo(channelSubMerchantId);
		merchantChannelTransLogDAO.deleteByExample(exam);
	}

    /**
     * 查询merchant_channel_trans_log表所有数据
     */
    public List<MerchantChannelTransLogDO> findMerchantChannelTransLogAll() {
        MerchantChannelTransLogDOExample exam = new MerchantChannelTransLogDOExample();
        exam.createCriteria();
		return merchantChannelTransLogDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询merchant_channel_trans_log表数据
	 */
	public List<MerchantChannelTransLogDO> findMerchantChannelTransLogById(Long id) {
		MerchantChannelTransLogDOExample exam = new MerchantChannelTransLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return merchantChannelTransLogDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询merchant_channel_trans_log表数据
	 */
	public List<MerchantChannelTransLogDO> findMerchantChannelTransLogByGid(String gid) {
		MerchantChannelTransLogDOExample exam = new MerchantChannelTransLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return merchantChannelTransLogDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询merchant_channel_trans_log表数据
	 */
	public List<MerchantChannelTransLogDO> findMerchantChannelTransLogByBizNo(String bizNo) {
		MerchantChannelTransLogDOExample exam = new MerchantChannelTransLogDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return merchantChannelTransLogDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询merchant_channel_trans_log表数据
	 */
	public List<MerchantChannelTransLogDO> findMerchantChannelTransLogByPartnerId(String partnerId) {
		MerchantChannelTransLogDOExample exam = new MerchantChannelTransLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return merchantChannelTransLogDAO.selectByExample(exam);
	}

    /**
	 * 根据channelTransId查询merchant_channel_trans_log表数据
	 */
	public List<MerchantChannelTransLogDO> findMerchantChannelTransLogByChannelTransId(String channelTransId) {
		MerchantChannelTransLogDOExample exam = new MerchantChannelTransLogDOExample();
		exam.createCriteria().andChannelTransIdEqualTo(channelTransId);
		return merchantChannelTransLogDAO.selectByExample(exam);
	}

    /**
	 * 根据channelSubMerchantId查询merchant_channel_trans_log表数据
	 */
	public List<MerchantChannelTransLogDO> findMerchantChannelTransLogByChannelSubMerchantId(String channelSubMerchantId) {
		MerchantChannelTransLogDOExample exam = new MerchantChannelTransLogDOExample();
		exam.createCriteria().andChannelSubMerchantIdEqualTo(channelSubMerchantId);
		return merchantChannelTransLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新merchant_channel_trans_log表数据
	 */
	public void updateMerchantChannelTransLogById(Long id,MerchantChannelTransLogDO merchantChannelTransLogDO) {
		MerchantChannelTransLogDOExample exam = new MerchantChannelTransLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantChannelTransLogDAO.updateByExample(merchantChannelTransLogDO, exam);
	}

    /**
	 * 根据gid更新merchant_channel_trans_log表数据
	 */
	public void updateMerchantChannelTransLogByGid(String gid,MerchantChannelTransLogDO merchantChannelTransLogDO) {
		MerchantChannelTransLogDOExample exam = new MerchantChannelTransLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		merchantChannelTransLogDAO.updateByExample(merchantChannelTransLogDO, exam);
	}

    /**
	 * 根据bizNo更新merchant_channel_trans_log表数据
	 */
	public void updateMerchantChannelTransLogByBizNo(String bizNo,MerchantChannelTransLogDO merchantChannelTransLogDO) {
		MerchantChannelTransLogDOExample exam = new MerchantChannelTransLogDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		merchantChannelTransLogDAO.updateByExample(merchantChannelTransLogDO, exam);
	}

    /**
	 * 根据partnerId更新merchant_channel_trans_log表数据
	 */
	public void updateMerchantChannelTransLogByPartnerId(String partnerId,MerchantChannelTransLogDO merchantChannelTransLogDO) {
		MerchantChannelTransLogDOExample exam = new MerchantChannelTransLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantChannelTransLogDAO.updateByExample(merchantChannelTransLogDO, exam);
	}

    /**
	 * 根据channelTransId更新merchant_channel_trans_log表数据
	 */
	public void updateMerchantChannelTransLogByChannelTransId(String channelTransId,MerchantChannelTransLogDO merchantChannelTransLogDO) {
		MerchantChannelTransLogDOExample exam = new MerchantChannelTransLogDOExample();
		exam.createCriteria().andChannelTransIdEqualTo(channelTransId);
		merchantChannelTransLogDAO.updateByExample(merchantChannelTransLogDO, exam);
	}

    /**
	 * 根据channelSubMerchantId更新merchant_channel_trans_log表数据
	 */
	public void updateMerchantChannelTransLogByChannelSubMerchantId(String channelSubMerchantId,MerchantChannelTransLogDO merchantChannelTransLogDO) {
		MerchantChannelTransLogDOExample exam = new MerchantChannelTransLogDOExample();
		exam.createCriteria().andChannelSubMerchantIdEqualTo(channelSubMerchantId);
		merchantChannelTransLogDAO.updateByExample(merchantChannelTransLogDO, exam);
	}

    /**
	 * 断言merchant表
	 */
	public void merchantAssert(
	        MerchantDO merchantDO,
			Long id, 
			String partnerId, 
			String parentPartnerId, 
			String outUserId, 
			String merchantName, 
			String merchantType, 
			String status, 
			String leadStatus, 
			String appId, 
			String appRefreshToken, 
			String channelId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, merchantDO.getId());
        assertEquals(partnerId, merchantDO.getPartnerId());
        assertEquals(parentPartnerId, merchantDO.getParentPartnerId());
        assertEquals(outUserId, merchantDO.getOutUserId());
        assertEquals(merchantName, merchantDO.getMerchantName());
        assertEquals(merchantType, merchantDO.getMerchantType());
        assertEquals(status, merchantDO.getStatus());
        assertEquals(leadStatus, merchantDO.getLeadStatus());
        assertEquals(appId, merchantDO.getAppId());
        assertEquals(appRefreshToken, merchantDO.getAppRefreshToken());
        assertEquals(channelId, merchantDO.getChannelId());
        assertEquals(rawAddTime, merchantDO.getRawAddTime());
        assertEquals(rawUpdateTime, merchantDO.getRawUpdateTime());
	}

	/**
	 * 断言merchant表数据
	 */
	public void assertMerchant(MerchantDO expect, MerchantDO merchantDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			merchantDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != merchantDO.getRawAddTime());
		expect.setRawAddTime(merchantDO.getRawAddTime());
        Assertions.assertTrue(null != merchantDO.getRawUpdateTime());
		expect.setRawUpdateTime(merchantDO.getRawUpdateTime());
		Assertions.assertEquals(expect, merchantDO);
	}

    /**
	 * 插入merchant表数据
	 */
	public void insertMerchant(MerchantDO merchantDO) {
		merchantDAO.insert(merchantDO);
	}

    /**
	 * 插入merchant表数据
	 */
	public void insertMerchant(
			Long id, 
			String partnerId, 
			String parentPartnerId, 
			String outUserId, 
			String merchantName, 
			String merchantType, 
			String status, 
			String leadStatus, 
			String appId, 
			String appRefreshToken, 
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
		MerchantDO merchantDO = new MerchantDO();
		merchantDO.setId(id);
		merchantDO.setPartnerId(partnerId);
		merchantDO.setParentPartnerId(parentPartnerId);
		merchantDO.setOutUserId(outUserId);
		merchantDO.setMerchantName(merchantName);
		merchantDO.setMerchantType(merchantType);
		merchantDO.setStatus(status);
		merchantDO.setLeadStatus(leadStatus);
		merchantDO.setAppId(appId);
		merchantDO.setAppRefreshToken(appRefreshToken);
		merchantDO.setChannelId(channelId);
		merchantDO.setRawAddTime(rawAddTime);
		merchantDO.setRawUpdateTime(rawUpdateTime);
		merchantDAO.insert(merchantDO);
	}

    /**
     * 删除merchant表所有数据
     */
    public void cleanMerchant() {
        MerchantDOExample exam = new MerchantDOExample();
        exam.createCriteria();
        merchantDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除merchant表数据
	 */
	public void cleanMerchantById(Long id) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除merchant表数据
	 */
	public void cleanMerchantByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantDAO.deleteByExample(exam);
	}
	/**
	 * 根据parentPartnerId,id删除merchant表数据
	 */
	public void cleanMerchantByParentPartnerIdAndId(String parentPartnerId,Long id) {
        if (StringUtils.isBlank(parentPartnerId)){
            parentPartnerId = "test_parentPartnerId";
        }
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andParentPartnerIdEqualTo(parentPartnerId).andIdEqualTo(id);
		merchantDAO.deleteByExample(exam);
	}
	/**
	 * 根据parentPartnerId,outUserId删除merchant表数据
	 */
	public void cleanMerchantByParentPartnerIdAndOutUserId(String parentPartnerId,String outUserId) {
        if (StringUtils.isBlank(parentPartnerId)){
            parentPartnerId = "test_parentPartnerId";
        }
        if (StringUtils.isBlank(outUserId)){
            outUserId = "test_outUserId";
        }
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andParentPartnerIdEqualTo(parentPartnerId).andOutUserIdEqualTo(outUserId);
		merchantDAO.deleteByExample(exam);
	}

	/**
	 * 根据parentPartnerId删除merchant表数据
	 */
	public void cleanMerchantByParentPartnerId(String parentPartnerId) {
        if (StringUtils.isBlank(parentPartnerId)){
            parentPartnerId = "test_parentPartnerId";
        }
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andParentPartnerIdEqualTo(parentPartnerId);
		merchantDAO.deleteByExample(exam);
	}

	/**
	 * 根据outUserId删除merchant表数据
	 */
	public void cleanMerchantByOutUserId(String outUserId) {
        if (StringUtils.isBlank(outUserId)){
            outUserId = "test_outUserId";
        }
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andOutUserIdEqualTo(outUserId);
		merchantDAO.deleteByExample(exam);
	}

	/**
	* 根据merchantName删除merchant表数据
	*/
	public void cleanMerchantByMerchantName(String merchantName) {
        if (StringUtils.isBlank(merchantName)){
            merchantName = "test_merchantName";
        }
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andMerchantNameEqualTo(merchantName);
		merchantDAO.deleteByExample(exam);
	}

	/**
	 * 根据appId删除merchant表数据
	 */
	public void cleanMerchantByAppId(String appId) {
        if (StringUtils.isBlank(appId)){
            appId = "test_appId";
        }
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andAppIdEqualTo(appId);
		merchantDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除merchant表数据
	 */
	public void cleanMerchantByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		merchantDAO.deleteByExample(exam);
	}

    /**
     * 查询merchant表所有数据
     */
    public List<MerchantDO> findMerchantAll() {
        MerchantDOExample exam = new MerchantDOExample();
        exam.createCriteria();
		return merchantDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询merchant表数据
	 */
	public List<MerchantDO> findMerchantById(Long id) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return merchantDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询merchant表数据
	 */
	public List<MerchantDO> findMerchantByPartnerId(String partnerId) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return merchantDAO.selectByExample(exam);
	}

	/**
	 * 根据parentPartnerId,id查询merchant表数据
	 */
	public List<MerchantDO> findMerchantByParentPartnerIdAndId(String parentPartnerId,Long id) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andParentPartnerIdEqualTo(parentPartnerId).andIdEqualTo(id);
		return merchantDAO.selectByExample(exam);
	}

	/**
	 * 根据parentPartnerId,outUserId查询merchant表数据
	 */
	public List<MerchantDO> findMerchantByParentPartnerIdAndOutUserId(String parentPartnerId,String outUserId) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andParentPartnerIdEqualTo(parentPartnerId).andOutUserIdEqualTo(outUserId);
		return merchantDAO.selectByExample(exam);
	}

    /**
	 * 根据parentPartnerId查询merchant表数据
	 */
	public List<MerchantDO> findMerchantByParentPartnerId(String parentPartnerId) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andParentPartnerIdEqualTo(parentPartnerId);
		return merchantDAO.selectByExample(exam);
	}

    /**
	 * 根据outUserId查询merchant表数据
	 */
	public List<MerchantDO> findMerchantByOutUserId(String outUserId) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andOutUserIdEqualTo(outUserId);
		return merchantDAO.selectByExample(exam);
	}

	/**
	* 根据merchantName查询merchant表数据
	*/
	public List<MerchantDO> findMerchantByMerchantName(String merchantName) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andMerchantNameEqualTo(merchantName);
		return merchantDAO.selectByExample(exam);
	}

    /**
	 * 根据appId查询merchant表数据
	 */
	public List<MerchantDO> findMerchantByAppId(String appId) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andAppIdEqualTo(appId);
		return merchantDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询merchant表数据
	 */
	public List<MerchantDO> findMerchantByChannelId(String channelId) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return merchantDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新merchant表数据
	 */
	public void updateMerchantById(Long id,MerchantDO merchantDO) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantDAO.updateByExample(merchantDO, exam);
	}

    /**
	 * 根据partnerId更新merchant表数据
	 */
	public void updateMerchantByPartnerId(String partnerId,MerchantDO merchantDO) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantDAO.updateByExample(merchantDO, exam);
	}

	/**
	 * 根据parentPartnerId,id更新merchant表数据
	 */
	public void updateMerchantByParentPartnerIdAndId(String parentPartnerId,Long id,MerchantDO merchantDO) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andParentPartnerIdEqualTo(parentPartnerId).andIdEqualTo(id);
		merchantDAO.updateByExample(merchantDO, exam);
	}

	/**
	 * 根据parentPartnerId,outUserId更新merchant表数据
	 */
	public void updateMerchantByParentPartnerIdAndOutUserId(String parentPartnerId,String outUserId,MerchantDO merchantDO) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andParentPartnerIdEqualTo(parentPartnerId).andOutUserIdEqualTo(outUserId);
		merchantDAO.updateByExample(merchantDO, exam);
	}

    /**
	 * 根据parentPartnerId更新merchant表数据
	 */
	public void updateMerchantByParentPartnerId(String parentPartnerId,MerchantDO merchantDO) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andParentPartnerIdEqualTo(parentPartnerId);
		merchantDAO.updateByExample(merchantDO, exam);
	}

    /**
	 * 根据outUserId更新merchant表数据
	 */
	public void updateMerchantByOutUserId(String outUserId,MerchantDO merchantDO) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andOutUserIdEqualTo(outUserId);
		merchantDAO.updateByExample(merchantDO, exam);
	}

	/**
	* 根据merchantName更新merchant表数据
	*/
	public void updateMerchantByMerchantName(String merchantName,MerchantDO merchantDO) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andMerchantNameEqualTo(merchantName);
		merchantDAO.updateByExample(merchantDO, exam);
	}

    /**
	 * 根据appId更新merchant表数据
	 */
	public void updateMerchantByAppId(String appId,MerchantDO merchantDO) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andAppIdEqualTo(appId);
		merchantDAO.updateByExample(merchantDO, exam);
	}

    /**
	 * 根据channelId更新merchant表数据
	 */
	public void updateMerchantByChannelId(String channelId,MerchantDO merchantDO) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		merchantDAO.updateByExample(merchantDO, exam);
	}

    /**
	 * 断言merchant_entry表
	 */
	public void merchantEntryAssert(
	        MerchantEntryDO merchantEntryDO,
			Long id, 
			String reqId, 
			String gid, 
			String entryUserId, 
			String partnerId, 
			String platPartnerId, 
			String accountNo, 
			String channelId, 
			String channelPlatMerchantId, 
			String subMerchantProperty, 
			String subMerchantId, 
			String channelSubMerchantId, 
			String merchantEntryType, 
			String signedStatus, 
			Integer node, 
			String nodeMemo, 
			String errorMemo, 
			String certifyStatus, 
			String paymentVerifyStatus, 
			String merchantEntryStatus, 
			String channelSubMerchantAccount, 
			String externalMetaData, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, merchantEntryDO.getId());
        assertEquals(reqId, merchantEntryDO.getReqId());
        assertEquals(gid, merchantEntryDO.getGid());
        assertEquals(entryUserId, merchantEntryDO.getEntryUserId());
        assertEquals(partnerId, merchantEntryDO.getPartnerId());
        assertEquals(platPartnerId, merchantEntryDO.getPlatPartnerId());
        assertEquals(accountNo, merchantEntryDO.getAccountNo());
        assertEquals(channelId, merchantEntryDO.getChannelId());
        assertEquals(channelPlatMerchantId, merchantEntryDO.getChannelPlatMerchantId());
        assertEquals(subMerchantProperty, merchantEntryDO.getSubMerchantProperty());
        assertEquals(subMerchantId, merchantEntryDO.getSubMerchantId());
        assertEquals(channelSubMerchantId, merchantEntryDO.getChannelSubMerchantId());
        assertEquals(merchantEntryType, merchantEntryDO.getMerchantEntryType());
        assertEquals(signedStatus, merchantEntryDO.getSignedStatus());
        assertEquals(node, merchantEntryDO.getNode());
        assertEquals(nodeMemo, merchantEntryDO.getNodeMemo());
        assertEquals(errorMemo, merchantEntryDO.getErrorMemo());
        assertEquals(certifyStatus, merchantEntryDO.getCertifyStatus());
        assertEquals(paymentVerifyStatus, merchantEntryDO.getPaymentVerifyStatus());
        assertEquals(merchantEntryStatus, merchantEntryDO.getMerchantEntryStatus());
        assertEquals(channelSubMerchantAccount, merchantEntryDO.getChannelSubMerchantAccount());
        assertEquals(externalMetaData, merchantEntryDO.getExternalMetaData());
        assertEquals(rawAddTime, merchantEntryDO.getRawAddTime());
        assertEquals(rawUpdateTime, merchantEntryDO.getRawUpdateTime());
	}

	/**
	 * 断言merchant_entry表数据
	 */
	public void assertMerchantEntry(MerchantEntryDO expect, MerchantEntryDO merchantEntryDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			merchantEntryDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != merchantEntryDO.getRawAddTime());
		expect.setRawAddTime(merchantEntryDO.getRawAddTime());
        Assertions.assertTrue(null != merchantEntryDO.getRawUpdateTime());
		expect.setRawUpdateTime(merchantEntryDO.getRawUpdateTime());
		Assertions.assertEquals(expect, merchantEntryDO);
	}

    /**
	 * 插入merchant_entry表数据
	 */
	public void insertMerchantEntry(MerchantEntryDO merchantEntryDO) {
		merchantEntryDAO.insert(merchantEntryDO);
	}

    /**
	 * 插入merchant_entry表数据
	 */
	public void insertMerchantEntry(
			Long id, 
			String reqId, 
			String gid, 
			String entryUserId, 
			String partnerId, 
			String platPartnerId, 
			String accountNo, 
			String channelId, 
			String channelPlatMerchantId, 
			String subMerchantProperty, 
			String subMerchantId, 
			String channelSubMerchantId, 
			String merchantEntryType, 
			String signedStatus, 
			Integer node, 
			String nodeMemo, 
			String errorMemo, 
			String certifyStatus, 
			String paymentVerifyStatus, 
			String merchantEntryStatus, 
			String channelSubMerchantAccount, 
			String externalMetaData, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		MerchantEntryDO merchantEntryDO = new MerchantEntryDO();
		merchantEntryDO.setId(id);
		merchantEntryDO.setReqId(reqId);
		merchantEntryDO.setGid(gid);
		merchantEntryDO.setEntryUserId(entryUserId);
		merchantEntryDO.setPartnerId(partnerId);
		merchantEntryDO.setPlatPartnerId(platPartnerId);
		merchantEntryDO.setAccountNo(accountNo);
		merchantEntryDO.setChannelId(channelId);
		merchantEntryDO.setChannelPlatMerchantId(channelPlatMerchantId);
		merchantEntryDO.setSubMerchantProperty(subMerchantProperty);
		merchantEntryDO.setSubMerchantId(subMerchantId);
		merchantEntryDO.setChannelSubMerchantId(channelSubMerchantId);
		merchantEntryDO.setMerchantEntryType(merchantEntryType);
		merchantEntryDO.setSignedStatus(signedStatus);
		merchantEntryDO.setNode(node);
		merchantEntryDO.setNodeMemo(nodeMemo);
		merchantEntryDO.setErrorMemo(errorMemo);
		merchantEntryDO.setCertifyStatus(certifyStatus);
		merchantEntryDO.setPaymentVerifyStatus(paymentVerifyStatus);
		merchantEntryDO.setMerchantEntryStatus(merchantEntryStatus);
		merchantEntryDO.setChannelSubMerchantAccount(channelSubMerchantAccount);
		merchantEntryDO.setExternalMetaData(externalMetaData);
		merchantEntryDO.setRawAddTime(rawAddTime);
		merchantEntryDO.setRawUpdateTime(rawUpdateTime);
		merchantEntryDAO.insert(merchantEntryDO);
	}

    /**
     * 删除merchant_entry表所有数据
     */
    public void cleanMerchantEntry() {
        MerchantEntryDOExample exam = new MerchantEntryDOExample();
        exam.createCriteria();
        merchantEntryDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除merchant_entry表数据
	 */
	public void cleanMerchantEntryById(Long id) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantEntryDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除merchant_entry表数据
	 */
	public void cleanMerchantEntryByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		merchantEntryDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除merchant_entry表数据
	 */
	public void cleanMerchantEntryByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		merchantEntryDAO.deleteByExample(exam);
	}

	/**
	 * 根据entryUserId删除merchant_entry表数据
	 */
	public void cleanMerchantEntryByEntryUserId(String entryUserId) {
        if (StringUtils.isBlank(entryUserId)){
            entryUserId = "test_entryUserId";
        }
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andEntryUserIdEqualTo(entryUserId);
		merchantEntryDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除merchant_entry表数据
	 */
	public void cleanMerchantEntryByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantEntryDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除merchant_entry表数据
	 */
	public void cleanMerchantEntryByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		merchantEntryDAO.deleteByExample(exam);
	}

	/**
	 * 根据accountNo删除merchant_entry表数据
	 */
	public void cleanMerchantEntryByAccountNo(String accountNo) {
        if (StringUtils.isBlank(accountNo)){
            accountNo = "test_accountNo";
        }
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		merchantEntryDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除merchant_entry表数据
	 */
	public void cleanMerchantEntryByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		merchantEntryDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelPlatMerchantId删除merchant_entry表数据
	 */
	public void cleanMerchantEntryByChannelPlatMerchantId(String channelPlatMerchantId) {
        if (StringUtils.isBlank(channelPlatMerchantId)){
            channelPlatMerchantId = "test_channelPlatMerchantId";
        }
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andChannelPlatMerchantIdEqualTo(channelPlatMerchantId);
		merchantEntryDAO.deleteByExample(exam);
	}

	/**
	 * 根据subMerchantId删除merchant_entry表数据
	 */
	public void cleanMerchantEntryBySubMerchantId(String subMerchantId) {
        if (StringUtils.isBlank(subMerchantId)){
            subMerchantId = "test_subMerchantId";
        }
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andSubMerchantIdEqualTo(subMerchantId);
		merchantEntryDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelSubMerchantId删除merchant_entry表数据
	 */
	public void cleanMerchantEntryByChannelSubMerchantId(String channelSubMerchantId) {
        if (StringUtils.isBlank(channelSubMerchantId)){
            channelSubMerchantId = "test_channelSubMerchantId";
        }
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andChannelSubMerchantIdEqualTo(channelSubMerchantId);
		merchantEntryDAO.deleteByExample(exam);
	}

    /**
     * 查询merchant_entry表所有数据
     */
    public List<MerchantEntryDO> findMerchantEntryAll() {
        MerchantEntryDOExample exam = new MerchantEntryDOExample();
        exam.createCriteria();
		return merchantEntryDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询merchant_entry表数据
	 */
	public List<MerchantEntryDO> findMerchantEntryById(Long id) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return merchantEntryDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询merchant_entry表数据
	 */
	public List<MerchantEntryDO> findMerchantEntryByReqId(String reqId) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return merchantEntryDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询merchant_entry表数据
	 */
	public List<MerchantEntryDO> findMerchantEntryByGid(String gid) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return merchantEntryDAO.selectByExample(exam);
	}

    /**
	 * 根据entryUserId查询merchant_entry表数据
	 */
	public List<MerchantEntryDO> findMerchantEntryByEntryUserId(String entryUserId) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andEntryUserIdEqualTo(entryUserId);
		return merchantEntryDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询merchant_entry表数据
	 */
	public List<MerchantEntryDO> findMerchantEntryByPartnerId(String partnerId) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return merchantEntryDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询merchant_entry表数据
	 */
	public List<MerchantEntryDO> findMerchantEntryByPlatPartnerId(String platPartnerId) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return merchantEntryDAO.selectByExample(exam);
	}

    /**
	 * 根据accountNo查询merchant_entry表数据
	 */
	public List<MerchantEntryDO> findMerchantEntryByAccountNo(String accountNo) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		return merchantEntryDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询merchant_entry表数据
	 */
	public List<MerchantEntryDO> findMerchantEntryByChannelId(String channelId) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return merchantEntryDAO.selectByExample(exam);
	}

    /**
	 * 根据channelPlatMerchantId查询merchant_entry表数据
	 */
	public List<MerchantEntryDO> findMerchantEntryByChannelPlatMerchantId(String channelPlatMerchantId) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andChannelPlatMerchantIdEqualTo(channelPlatMerchantId);
		return merchantEntryDAO.selectByExample(exam);
	}

    /**
	 * 根据subMerchantId查询merchant_entry表数据
	 */
	public List<MerchantEntryDO> findMerchantEntryBySubMerchantId(String subMerchantId) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andSubMerchantIdEqualTo(subMerchantId);
		return merchantEntryDAO.selectByExample(exam);
	}

    /**
	 * 根据channelSubMerchantId查询merchant_entry表数据
	 */
	public List<MerchantEntryDO> findMerchantEntryByChannelSubMerchantId(String channelSubMerchantId) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andChannelSubMerchantIdEqualTo(channelSubMerchantId);
		return merchantEntryDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新merchant_entry表数据
	 */
	public void updateMerchantEntryById(Long id,MerchantEntryDO merchantEntryDO) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantEntryDAO.updateByExample(merchantEntryDO, exam);
	}

    /**
	 * 根据reqId更新merchant_entry表数据
	 */
	public void updateMerchantEntryByReqId(String reqId,MerchantEntryDO merchantEntryDO) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		merchantEntryDAO.updateByExample(merchantEntryDO, exam);
	}

    /**
	 * 根据gid更新merchant_entry表数据
	 */
	public void updateMerchantEntryByGid(String gid,MerchantEntryDO merchantEntryDO) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		merchantEntryDAO.updateByExample(merchantEntryDO, exam);
	}

    /**
	 * 根据entryUserId更新merchant_entry表数据
	 */
	public void updateMerchantEntryByEntryUserId(String entryUserId,MerchantEntryDO merchantEntryDO) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andEntryUserIdEqualTo(entryUserId);
		merchantEntryDAO.updateByExample(merchantEntryDO, exam);
	}

    /**
	 * 根据partnerId更新merchant_entry表数据
	 */
	public void updateMerchantEntryByPartnerId(String partnerId,MerchantEntryDO merchantEntryDO) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantEntryDAO.updateByExample(merchantEntryDO, exam);
	}

    /**
	 * 根据platPartnerId更新merchant_entry表数据
	 */
	public void updateMerchantEntryByPlatPartnerId(String platPartnerId,MerchantEntryDO merchantEntryDO) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		merchantEntryDAO.updateByExample(merchantEntryDO, exam);
	}

    /**
	 * 根据accountNo更新merchant_entry表数据
	 */
	public void updateMerchantEntryByAccountNo(String accountNo,MerchantEntryDO merchantEntryDO) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		merchantEntryDAO.updateByExample(merchantEntryDO, exam);
	}

    /**
	 * 根据channelId更新merchant_entry表数据
	 */
	public void updateMerchantEntryByChannelId(String channelId,MerchantEntryDO merchantEntryDO) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		merchantEntryDAO.updateByExample(merchantEntryDO, exam);
	}

    /**
	 * 根据channelPlatMerchantId更新merchant_entry表数据
	 */
	public void updateMerchantEntryByChannelPlatMerchantId(String channelPlatMerchantId,MerchantEntryDO merchantEntryDO) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andChannelPlatMerchantIdEqualTo(channelPlatMerchantId);
		merchantEntryDAO.updateByExample(merchantEntryDO, exam);
	}

    /**
	 * 根据subMerchantId更新merchant_entry表数据
	 */
	public void updateMerchantEntryBySubMerchantId(String subMerchantId,MerchantEntryDO merchantEntryDO) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andSubMerchantIdEqualTo(subMerchantId);
		merchantEntryDAO.updateByExample(merchantEntryDO, exam);
	}

    /**
	 * 根据channelSubMerchantId更新merchant_entry表数据
	 */
	public void updateMerchantEntryByChannelSubMerchantId(String channelSubMerchantId,MerchantEntryDO merchantEntryDO) {
		MerchantEntryDOExample exam = new MerchantEntryDOExample();
		exam.createCriteria().andChannelSubMerchantIdEqualTo(channelSubMerchantId);
		merchantEntryDAO.updateByExample(merchantEntryDO, exam);
	}

    /**
	 * 断言merchant_img表
	 */
	public void merchantImgAssert(
	        MerchantImgDO merchantImgDO,
			Long id, 
			String partnerId, 
			String businessLicenseUrl, 
			String organizationCodeUrl, 
			String taxCertificateUrl, 
			String bankSettlementUrl, 
			String legalCerificateFrontUrl, 
			String legalCerificateBackUrl, 
			String oldBusinessLicenseUrl, 
			String oldOrganizationCodeUrl, 
			String oldTaxCertificateUrl, 
			String oldBankSettlementUrl, 
			String oldLegalCerificateFrontUrl, 
			String oldLegalCerificateBackUrl, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, merchantImgDO.getId());
        assertEquals(partnerId, merchantImgDO.getPartnerId());
        assertEquals(businessLicenseUrl, merchantImgDO.getBusinessLicenseUrl());
        assertEquals(organizationCodeUrl, merchantImgDO.getOrganizationCodeUrl());
        assertEquals(taxCertificateUrl, merchantImgDO.getTaxCertificateUrl());
        assertEquals(bankSettlementUrl, merchantImgDO.getBankSettlementUrl());
        assertEquals(legalCerificateFrontUrl, merchantImgDO.getLegalCerificateFrontUrl());
        assertEquals(legalCerificateBackUrl, merchantImgDO.getLegalCerificateBackUrl());
        assertEquals(oldBusinessLicenseUrl, merchantImgDO.getOldBusinessLicenseUrl());
        assertEquals(oldOrganizationCodeUrl, merchantImgDO.getOldOrganizationCodeUrl());
        assertEquals(oldTaxCertificateUrl, merchantImgDO.getOldTaxCertificateUrl());
        assertEquals(oldBankSettlementUrl, merchantImgDO.getOldBankSettlementUrl());
        assertEquals(oldLegalCerificateFrontUrl, merchantImgDO.getOldLegalCerificateFrontUrl());
        assertEquals(oldLegalCerificateBackUrl, merchantImgDO.getOldLegalCerificateBackUrl());
        assertEquals(status, merchantImgDO.getStatus());
        assertEquals(rawAddTime, merchantImgDO.getRawAddTime());
        assertEquals(rawUpdateTime, merchantImgDO.getRawUpdateTime());
	}

	/**
	 * 断言merchant_img表数据
	 */
	public void assertMerchantImg(MerchantImgDO expect, MerchantImgDO merchantImgDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			merchantImgDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != merchantImgDO.getRawAddTime());
		expect.setRawAddTime(merchantImgDO.getRawAddTime());
        Assertions.assertTrue(null != merchantImgDO.getRawUpdateTime());
		expect.setRawUpdateTime(merchantImgDO.getRawUpdateTime());
		Assertions.assertEquals(expect, merchantImgDO);
	}

    /**
	 * 插入merchant_img表数据
	 */
	public void insertMerchantImg(MerchantImgDO merchantImgDO) {
		merchantImgDAO.insert(merchantImgDO);
	}

    /**
	 * 插入merchant_img表数据
	 */
	public void insertMerchantImg(
			Long id, 
			String partnerId, 
			String businessLicenseUrl, 
			String organizationCodeUrl, 
			String taxCertificateUrl, 
			String bankSettlementUrl, 
			String legalCerificateFrontUrl, 
			String legalCerificateBackUrl, 
			String oldBusinessLicenseUrl, 
			String oldOrganizationCodeUrl, 
			String oldTaxCertificateUrl, 
			String oldBankSettlementUrl, 
			String oldLegalCerificateFrontUrl, 
			String oldLegalCerificateBackUrl, 
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
		MerchantImgDO merchantImgDO = new MerchantImgDO();
		merchantImgDO.setId(id);
		merchantImgDO.setPartnerId(partnerId);
		merchantImgDO.setBusinessLicenseUrl(businessLicenseUrl);
		merchantImgDO.setOrganizationCodeUrl(organizationCodeUrl);
		merchantImgDO.setTaxCertificateUrl(taxCertificateUrl);
		merchantImgDO.setBankSettlementUrl(bankSettlementUrl);
		merchantImgDO.setLegalCerificateFrontUrl(legalCerificateFrontUrl);
		merchantImgDO.setLegalCerificateBackUrl(legalCerificateBackUrl);
		merchantImgDO.setOldBusinessLicenseUrl(oldBusinessLicenseUrl);
		merchantImgDO.setOldOrganizationCodeUrl(oldOrganizationCodeUrl);
		merchantImgDO.setOldTaxCertificateUrl(oldTaxCertificateUrl);
		merchantImgDO.setOldBankSettlementUrl(oldBankSettlementUrl);
		merchantImgDO.setOldLegalCerificateFrontUrl(oldLegalCerificateFrontUrl);
		merchantImgDO.setOldLegalCerificateBackUrl(oldLegalCerificateBackUrl);
		merchantImgDO.setStatus(status);
		merchantImgDO.setRawAddTime(rawAddTime);
		merchantImgDO.setRawUpdateTime(rawUpdateTime);
		merchantImgDAO.insert(merchantImgDO);
	}

    /**
     * 删除merchant_img表所有数据
     */
    public void cleanMerchantImg() {
        MerchantImgDOExample exam = new MerchantImgDOExample();
        exam.createCriteria();
        merchantImgDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除merchant_img表数据
	 */
	public void cleanMerchantImgById(Long id) {
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantImgDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除merchant_img表数据
	 */
	public void cleanMerchantImgByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantImgDAO.deleteByExample(exam);
	}

	/**
	* 根据organizationCodeUrl删除merchant_img表数据
	*/
	public void cleanMerchantImgByOrganizationCodeUrl(String organizationCodeUrl) {
        if (StringUtils.isBlank(organizationCodeUrl)){
            organizationCodeUrl = "test_organizationCodeUrl";
        }
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andOrganizationCodeUrlEqualTo(organizationCodeUrl);
		merchantImgDAO.deleteByExample(exam);
	}

	/**
	* 根据oldOrganizationCodeUrl删除merchant_img表数据
	*/
	public void cleanMerchantImgByOldOrganizationCodeUrl(String oldOrganizationCodeUrl) {
        if (StringUtils.isBlank(oldOrganizationCodeUrl)){
            oldOrganizationCodeUrl = "test_oldOrganizationCodeUrl";
        }
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andOldOrganizationCodeUrlEqualTo(oldOrganizationCodeUrl);
		merchantImgDAO.deleteByExample(exam);
	}

    /**
     * 查询merchant_img表所有数据
     */
    public List<MerchantImgDO> findMerchantImgAll() {
        MerchantImgDOExample exam = new MerchantImgDOExample();
        exam.createCriteria();
		return merchantImgDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询merchant_img表数据
	 */
	public List<MerchantImgDO> findMerchantImgById(Long id) {
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return merchantImgDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询merchant_img表数据
	 */
	public List<MerchantImgDO> findMerchantImgByPartnerId(String partnerId) {
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return merchantImgDAO.selectByExample(exam);
	}

	/**
	* 根据organizationCodeUrl查询merchant_img表数据
	*/
	public List<MerchantImgDO> findMerchantImgByOrganizationCodeUrl(String organizationCodeUrl) {
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andOrganizationCodeUrlEqualTo(organizationCodeUrl);
		return merchantImgDAO.selectByExample(exam);
	}

	/**
	* 根据oldOrganizationCodeUrl查询merchant_img表数据
	*/
	public List<MerchantImgDO> findMerchantImgByOldOrganizationCodeUrl(String oldOrganizationCodeUrl) {
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andOldOrganizationCodeUrlEqualTo(oldOrganizationCodeUrl);
		return merchantImgDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新merchant_img表数据
	 */
	public void updateMerchantImgById(Long id,MerchantImgDO merchantImgDO) {
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantImgDAO.updateByExample(merchantImgDO, exam);
	}

    /**
	 * 根据partnerId更新merchant_img表数据
	 */
	public void updateMerchantImgByPartnerId(String partnerId,MerchantImgDO merchantImgDO) {
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantImgDAO.updateByExample(merchantImgDO, exam);
	}

	/**
	* 根据organizationCodeUrl更新merchant_img表数据
	*/
	public void updateMerchantImgByOrganizationCodeUrl(String organizationCodeUrl,MerchantImgDO merchantImgDO) {
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andOrganizationCodeUrlEqualTo(organizationCodeUrl);
		merchantImgDAO.updateByExample(merchantImgDO, exam);
	}

	/**
	* 根据oldOrganizationCodeUrl更新merchant_img表数据
	*/
	public void updateMerchantImgByOldOrganizationCodeUrl(String oldOrganizationCodeUrl,MerchantImgDO merchantImgDO) {
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andOldOrganizationCodeUrlEqualTo(oldOrganizationCodeUrl);
		merchantImgDAO.updateByExample(merchantImgDO, exam);
	}

    /**
	 * 断言merchant_info表
	 */
	public void merchantInfoAssert(
	        MerchantInfoDO merchantInfoDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String industryLine, 
			String outPartnerId, 
			String partnerName, 
			String partnerAbbrName, 
			String partnerRegisterAddress, 
			String registerFrom, 
			String partnerType, 
			String partnerStatus, 
			String securityCode, 
			String digestType, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String ownService
	) {
        assertEquals(id, merchantInfoDO.getId());
        assertEquals(partnerId, merchantInfoDO.getPartnerId());
        assertEquals(platPartnerId, merchantInfoDO.getPlatPartnerId());
        assertEquals(industryLine, merchantInfoDO.getIndustryLine());
        assertEquals(outPartnerId, merchantInfoDO.getOutPartnerId());
        assertEquals(partnerName, merchantInfoDO.getPartnerName());
        assertEquals(partnerAbbrName, merchantInfoDO.getPartnerAbbrName());
        assertEquals(partnerRegisterAddress, merchantInfoDO.getPartnerRegisterAddress());
        assertEquals(registerFrom, merchantInfoDO.getRegisterFrom());
        assertEquals(partnerType, merchantInfoDO.getPartnerType());
        assertEquals(partnerStatus, merchantInfoDO.getPartnerStatus());
        assertEquals(securityCode, merchantInfoDO.getSecurityCode());
        assertEquals(digestType, merchantInfoDO.getDigestType());
        assertEquals(rawAddTime, merchantInfoDO.getRawAddTime());
        assertEquals(rawUpdateTime, merchantInfoDO.getRawUpdateTime());
        assertEquals(ownService, merchantInfoDO.getOwnService());
	}

	/**
	 * 断言merchant_info表数据
	 */
	public void assertMerchantInfo(MerchantInfoDO expect, MerchantInfoDO merchantInfoDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			merchantInfoDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != merchantInfoDO.getRawAddTime());
		expect.setRawAddTime(merchantInfoDO.getRawAddTime());
        Assertions.assertTrue(null != merchantInfoDO.getRawUpdateTime());
		expect.setRawUpdateTime(merchantInfoDO.getRawUpdateTime());
		Assertions.assertEquals(expect, merchantInfoDO);
	}

    /**
	 * 插入merchant_info表数据
	 */
	public void insertMerchantInfo(MerchantInfoDO merchantInfoDO) {
		merchantInfoDAO.insert(merchantInfoDO);
	}

    /**
	 * 插入merchant_info表数据
	 */
	public void insertMerchantInfo(
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String industryLine, 
			String outPartnerId, 
			String partnerName, 
			String partnerAbbrName, 
			String partnerRegisterAddress, 
			String registerFrom, 
			String partnerType, 
			String partnerStatus, 
			String securityCode, 
			String digestType, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String ownService
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		MerchantInfoDO merchantInfoDO = new MerchantInfoDO();
		merchantInfoDO.setId(id);
		merchantInfoDO.setPartnerId(partnerId);
		merchantInfoDO.setPlatPartnerId(platPartnerId);
		merchantInfoDO.setIndustryLine(industryLine);
		merchantInfoDO.setOutPartnerId(outPartnerId);
		merchantInfoDO.setPartnerName(partnerName);
		merchantInfoDO.setPartnerAbbrName(partnerAbbrName);
		merchantInfoDO.setPartnerRegisterAddress(partnerRegisterAddress);
		merchantInfoDO.setRegisterFrom(registerFrom);
		merchantInfoDO.setPartnerType(partnerType);
		merchantInfoDO.setPartnerStatus(partnerStatus);
		merchantInfoDO.setSecurityCode(securityCode);
		merchantInfoDO.setDigestType(digestType);
		merchantInfoDO.setRawAddTime(rawAddTime);
		merchantInfoDO.setRawUpdateTime(rawUpdateTime);
		merchantInfoDO.setOwnService(ownService);
		merchantInfoDAO.insert(merchantInfoDO);
	}

    /**
     * 删除merchant_info表所有数据
     */
    public void cleanMerchantInfo() {
        MerchantInfoDOExample exam = new MerchantInfoDOExample();
        exam.createCriteria();
        merchantInfoDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除merchant_info表数据
	 */
	public void cleanMerchantInfoById(Long id) {
		MerchantInfoDOExample exam = new MerchantInfoDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantInfoDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除merchant_info表数据
	 */
	public void cleanMerchantInfoByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		MerchantInfoDOExample exam = new MerchantInfoDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantInfoDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除merchant_info表数据
	 */
	public void cleanMerchantInfoByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		MerchantInfoDOExample exam = new MerchantInfoDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		merchantInfoDAO.deleteByExample(exam);
	}

	/**
	 * 根据outPartnerId删除merchant_info表数据
	 */
	public void cleanMerchantInfoByOutPartnerId(String outPartnerId) {
        if (StringUtils.isBlank(outPartnerId)){
            outPartnerId = "test_outPartnerId";
        }
		MerchantInfoDOExample exam = new MerchantInfoDOExample();
		exam.createCriteria().andOutPartnerIdEqualTo(outPartnerId);
		merchantInfoDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除merchant_info表数据
	*/
	public void cleanMerchantInfoByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		MerchantInfoDOExample exam = new MerchantInfoDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		merchantInfoDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerAbbrName删除merchant_info表数据
	*/
	public void cleanMerchantInfoByPartnerAbbrName(String partnerAbbrName) {
        if (StringUtils.isBlank(partnerAbbrName)){
            partnerAbbrName = "test_partnerAbbrName";
        }
		MerchantInfoDOExample exam = new MerchantInfoDOExample();
		exam.createCriteria().andPartnerAbbrNameEqualTo(partnerAbbrName);
		merchantInfoDAO.deleteByExample(exam);
	}

	/**
	* 根据securityCode删除merchant_info表数据
	*/
	public void cleanMerchantInfoBySecurityCode(String securityCode) {
        if (StringUtils.isBlank(securityCode)){
            securityCode = "test_securityCode";
        }
		MerchantInfoDOExample exam = new MerchantInfoDOExample();
		exam.createCriteria().andSecurityCodeEqualTo(securityCode);
		merchantInfoDAO.deleteByExample(exam);
	}

    /**
     * 查询merchant_info表所有数据
     */
    public List<MerchantInfoDO> findMerchantInfoAll() {
        MerchantInfoDOExample exam = new MerchantInfoDOExample();
        exam.createCriteria();
		return merchantInfoDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询merchant_info表数据
	 */
	public List<MerchantInfoDO> findMerchantInfoById(Long id) {
		MerchantInfoDOExample exam = new MerchantInfoDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return merchantInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询merchant_info表数据
	 */
	public List<MerchantInfoDO> findMerchantInfoByPartnerId(String partnerId) {
		MerchantInfoDOExample exam = new MerchantInfoDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return merchantInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询merchant_info表数据
	 */
	public List<MerchantInfoDO> findMerchantInfoByPlatPartnerId(String platPartnerId) {
		MerchantInfoDOExample exam = new MerchantInfoDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return merchantInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据outPartnerId查询merchant_info表数据
	 */
	public List<MerchantInfoDO> findMerchantInfoByOutPartnerId(String outPartnerId) {
		MerchantInfoDOExample exam = new MerchantInfoDOExample();
		exam.createCriteria().andOutPartnerIdEqualTo(outPartnerId);
		return merchantInfoDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询merchant_info表数据
	*/
	public List<MerchantInfoDO> findMerchantInfoByPartnerName(String partnerName) {
		MerchantInfoDOExample exam = new MerchantInfoDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return merchantInfoDAO.selectByExample(exam);
	}

	/**
	* 根据partnerAbbrName查询merchant_info表数据
	*/
	public List<MerchantInfoDO> findMerchantInfoByPartnerAbbrName(String partnerAbbrName) {
		MerchantInfoDOExample exam = new MerchantInfoDOExample();
		exam.createCriteria().andPartnerAbbrNameEqualTo(partnerAbbrName);
		return merchantInfoDAO.selectByExample(exam);
	}

	/**
	* 根据securityCode查询merchant_info表数据
	*/
	public List<MerchantInfoDO> findMerchantInfoBySecurityCode(String securityCode) {
		MerchantInfoDOExample exam = new MerchantInfoDOExample();
		exam.createCriteria().andSecurityCodeEqualTo(securityCode);
		return merchantInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新merchant_info表数据
	 */
	public void updateMerchantInfoById(Long id,MerchantInfoDO merchantInfoDO) {
		MerchantInfoDOExample exam = new MerchantInfoDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantInfoDAO.updateByExample(merchantInfoDO, exam);
	}

    /**
	 * 根据partnerId更新merchant_info表数据
	 */
	public void updateMerchantInfoByPartnerId(String partnerId,MerchantInfoDO merchantInfoDO) {
		MerchantInfoDOExample exam = new MerchantInfoDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantInfoDAO.updateByExample(merchantInfoDO, exam);
	}

    /**
	 * 根据platPartnerId更新merchant_info表数据
	 */
	public void updateMerchantInfoByPlatPartnerId(String platPartnerId,MerchantInfoDO merchantInfoDO) {
		MerchantInfoDOExample exam = new MerchantInfoDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		merchantInfoDAO.updateByExample(merchantInfoDO, exam);
	}

    /**
	 * 根据outPartnerId更新merchant_info表数据
	 */
	public void updateMerchantInfoByOutPartnerId(String outPartnerId,MerchantInfoDO merchantInfoDO) {
		MerchantInfoDOExample exam = new MerchantInfoDOExample();
		exam.createCriteria().andOutPartnerIdEqualTo(outPartnerId);
		merchantInfoDAO.updateByExample(merchantInfoDO, exam);
	}

	/**
	* 根据partnerName更新merchant_info表数据
	*/
	public void updateMerchantInfoByPartnerName(String partnerName,MerchantInfoDO merchantInfoDO) {
		MerchantInfoDOExample exam = new MerchantInfoDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		merchantInfoDAO.updateByExample(merchantInfoDO, exam);
	}

	/**
	* 根据partnerAbbrName更新merchant_info表数据
	*/
	public void updateMerchantInfoByPartnerAbbrName(String partnerAbbrName,MerchantInfoDO merchantInfoDO) {
		MerchantInfoDOExample exam = new MerchantInfoDOExample();
		exam.createCriteria().andPartnerAbbrNameEqualTo(partnerAbbrName);
		merchantInfoDAO.updateByExample(merchantInfoDO, exam);
	}

	/**
	* 根据securityCode更新merchant_info表数据
	*/
	public void updateMerchantInfoBySecurityCode(String securityCode,MerchantInfoDO merchantInfoDO) {
		MerchantInfoDOExample exam = new MerchantInfoDOExample();
		exam.createCriteria().andSecurityCodeEqualTo(securityCode);
		merchantInfoDAO.updateByExample(merchantInfoDO, exam);
	}

    /**
	 * 断言merchant_operator表
	 */
	public void merchantOperatorAssert(
	        MerchantOperatorDO merchantOperatorDO,
			Long id, 
			String partnerId, 
			String username, 
			String password, 
			String salt, 
			String nikename, 
			String email, 
			String phone, 
			String roleIds, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, merchantOperatorDO.getId());
        assertEquals(partnerId, merchantOperatorDO.getPartnerId());
        assertEquals(username, merchantOperatorDO.getUsername());
        assertEquals(password, merchantOperatorDO.getPassword());
        assertEquals(salt, merchantOperatorDO.getSalt());
        assertEquals(nikename, merchantOperatorDO.getNikename());
        assertEquals(email, merchantOperatorDO.getEmail());
        assertEquals(phone, merchantOperatorDO.getPhone());
        assertEquals(roleIds, merchantOperatorDO.getRoleIds());
        assertEquals(status, merchantOperatorDO.getStatus());
        assertEquals(rawAddTime, merchantOperatorDO.getRawAddTime());
        assertEquals(rawUpdateTime, merchantOperatorDO.getRawUpdateTime());
	}

	/**
	 * 断言merchant_operator表数据
	 */
	public void assertMerchantOperator(MerchantOperatorDO expect, MerchantOperatorDO merchantOperatorDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			merchantOperatorDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != merchantOperatorDO.getRawAddTime());
		expect.setRawAddTime(merchantOperatorDO.getRawAddTime());
        Assertions.assertTrue(null != merchantOperatorDO.getRawUpdateTime());
		expect.setRawUpdateTime(merchantOperatorDO.getRawUpdateTime());
		Assertions.assertEquals(expect, merchantOperatorDO);
	}

    /**
	 * 插入merchant_operator表数据
	 */
	public void insertMerchantOperator(MerchantOperatorDO merchantOperatorDO) {
		merchantOperatorDAO.insert(merchantOperatorDO);
	}

    /**
	 * 插入merchant_operator表数据
	 */
	public void insertMerchantOperator(
			Long id, 
			String partnerId, 
			String username, 
			String password, 
			String salt, 
			String nikename, 
			String email, 
			String phone, 
			String roleIds, 
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
		MerchantOperatorDO merchantOperatorDO = new MerchantOperatorDO();
		merchantOperatorDO.setId(id);
		merchantOperatorDO.setPartnerId(partnerId);
		merchantOperatorDO.setUsername(username);
		merchantOperatorDO.setPassword(password);
		merchantOperatorDO.setSalt(salt);
		merchantOperatorDO.setNikename(nikename);
		merchantOperatorDO.setEmail(email);
		merchantOperatorDO.setPhone(phone);
		merchantOperatorDO.setRoleIds(roleIds);
		merchantOperatorDO.setStatus(status);
		merchantOperatorDO.setRawAddTime(rawAddTime);
		merchantOperatorDO.setRawUpdateTime(rawUpdateTime);
		merchantOperatorDAO.insert(merchantOperatorDO);
	}

    /**
     * 删除merchant_operator表所有数据
     */
    public void cleanMerchantOperator() {
        MerchantOperatorDOExample exam = new MerchantOperatorDOExample();
        exam.createCriteria();
        merchantOperatorDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除merchant_operator表数据
	 */
	public void cleanMerchantOperatorById(Long id) {
		MerchantOperatorDOExample exam = new MerchantOperatorDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantOperatorDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除merchant_operator表数据
	 */
	public void cleanMerchantOperatorByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		MerchantOperatorDOExample exam = new MerchantOperatorDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantOperatorDAO.deleteByExample(exam);
	}

	/**
	* 根据username删除merchant_operator表数据
	*/
	public void cleanMerchantOperatorByUsername(String username) {
        if (StringUtils.isBlank(username)){
            username = "test_username";
        }
		MerchantOperatorDOExample exam = new MerchantOperatorDOExample();
		exam.createCriteria().andUsernameEqualTo(username);
		merchantOperatorDAO.deleteByExample(exam);
	}

	/**
	* 根据nikename删除merchant_operator表数据
	*/
	public void cleanMerchantOperatorByNikename(String nikename) {
        if (StringUtils.isBlank(nikename)){
            nikename = "test_nikename";
        }
		MerchantOperatorDOExample exam = new MerchantOperatorDOExample();
		exam.createCriteria().andNikenameEqualTo(nikename);
		merchantOperatorDAO.deleteByExample(exam);
	}

	/**
	 * 根据roleIds删除merchant_operator表数据
	 */
	public void cleanMerchantOperatorByRoleIds(String roleIds) {
        if (StringUtils.isBlank(roleIds)){
            roleIds = "test_roleIds";
        }
		MerchantOperatorDOExample exam = new MerchantOperatorDOExample();
		exam.createCriteria().andRoleIdsEqualTo(roleIds);
		merchantOperatorDAO.deleteByExample(exam);
	}

    /**
     * 查询merchant_operator表所有数据
     */
    public List<MerchantOperatorDO> findMerchantOperatorAll() {
        MerchantOperatorDOExample exam = new MerchantOperatorDOExample();
        exam.createCriteria();
		return merchantOperatorDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询merchant_operator表数据
	 */
	public List<MerchantOperatorDO> findMerchantOperatorById(Long id) {
		MerchantOperatorDOExample exam = new MerchantOperatorDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return merchantOperatorDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询merchant_operator表数据
	 */
	public List<MerchantOperatorDO> findMerchantOperatorByPartnerId(String partnerId) {
		MerchantOperatorDOExample exam = new MerchantOperatorDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return merchantOperatorDAO.selectByExample(exam);
	}

	/**
	* 根据username查询merchant_operator表数据
	*/
	public List<MerchantOperatorDO> findMerchantOperatorByUsername(String username) {
		MerchantOperatorDOExample exam = new MerchantOperatorDOExample();
		exam.createCriteria().andUsernameEqualTo(username);
		return merchantOperatorDAO.selectByExample(exam);
	}

	/**
	* 根据nikename查询merchant_operator表数据
	*/
	public List<MerchantOperatorDO> findMerchantOperatorByNikename(String nikename) {
		MerchantOperatorDOExample exam = new MerchantOperatorDOExample();
		exam.createCriteria().andNikenameEqualTo(nikename);
		return merchantOperatorDAO.selectByExample(exam);
	}

    /**
	 * 根据roleIds查询merchant_operator表数据
	 */
	public List<MerchantOperatorDO> findMerchantOperatorByRoleIds(String roleIds) {
		MerchantOperatorDOExample exam = new MerchantOperatorDOExample();
		exam.createCriteria().andRoleIdsEqualTo(roleIds);
		return merchantOperatorDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新merchant_operator表数据
	 */
	public void updateMerchantOperatorById(Long id,MerchantOperatorDO merchantOperatorDO) {
		MerchantOperatorDOExample exam = new MerchantOperatorDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantOperatorDAO.updateByExample(merchantOperatorDO, exam);
	}

    /**
	 * 根据partnerId更新merchant_operator表数据
	 */
	public void updateMerchantOperatorByPartnerId(String partnerId,MerchantOperatorDO merchantOperatorDO) {
		MerchantOperatorDOExample exam = new MerchantOperatorDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantOperatorDAO.updateByExample(merchantOperatorDO, exam);
	}

	/**
	* 根据username更新merchant_operator表数据
	*/
	public void updateMerchantOperatorByUsername(String username,MerchantOperatorDO merchantOperatorDO) {
		MerchantOperatorDOExample exam = new MerchantOperatorDOExample();
		exam.createCriteria().andUsernameEqualTo(username);
		merchantOperatorDAO.updateByExample(merchantOperatorDO, exam);
	}

	/**
	* 根据nikename更新merchant_operator表数据
	*/
	public void updateMerchantOperatorByNikename(String nikename,MerchantOperatorDO merchantOperatorDO) {
		MerchantOperatorDOExample exam = new MerchantOperatorDOExample();
		exam.createCriteria().andNikenameEqualTo(nikename);
		merchantOperatorDAO.updateByExample(merchantOperatorDO, exam);
	}

    /**
	 * 根据roleIds更新merchant_operator表数据
	 */
	public void updateMerchantOperatorByRoleIds(String roleIds,MerchantOperatorDO merchantOperatorDO) {
		MerchantOperatorDOExample exam = new MerchantOperatorDOExample();
		exam.createCriteria().andRoleIdsEqualTo(roleIds);
		merchantOperatorDAO.updateByExample(merchantOperatorDO, exam);
	}

    /**
	 * 断言merchant_operator_login_log表
	 */
	public void merchantOperatorLoginLogAssert(
	        MerchantOperatorLoginLogDO merchantOperatorLoginLogDO,
			Long id, 
			String username, 
			Long userId, 
			String loginIp, 
			String message, 
			String loginStatus, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, merchantOperatorLoginLogDO.getId());
        assertEquals(username, merchantOperatorLoginLogDO.getUsername());
        assertEquals(userId, merchantOperatorLoginLogDO.getUserId());
        assertEquals(loginIp, merchantOperatorLoginLogDO.getLoginIp());
        assertEquals(message, merchantOperatorLoginLogDO.getMessage());
        assertEquals(loginStatus, merchantOperatorLoginLogDO.getLoginStatus());
        assertEquals(rawAddTime, merchantOperatorLoginLogDO.getRawAddTime());
        assertEquals(rawUpdateTime, merchantOperatorLoginLogDO.getRawUpdateTime());
	}

	/**
	 * 断言merchant_operator_login_log表数据
	 */
	public void assertMerchantOperatorLoginLog(MerchantOperatorLoginLogDO expect, MerchantOperatorLoginLogDO merchantOperatorLoginLogDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			merchantOperatorLoginLogDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != merchantOperatorLoginLogDO.getRawAddTime());
		expect.setRawAddTime(merchantOperatorLoginLogDO.getRawAddTime());
        Assertions.assertTrue(null != merchantOperatorLoginLogDO.getRawUpdateTime());
		expect.setRawUpdateTime(merchantOperatorLoginLogDO.getRawUpdateTime());
		Assertions.assertEquals(expect, merchantOperatorLoginLogDO);
	}

    /**
	 * 插入merchant_operator_login_log表数据
	 */
	public void insertMerchantOperatorLoginLog(MerchantOperatorLoginLogDO merchantOperatorLoginLogDO) {
		merchantOperatorLoginLogDAO.insert(merchantOperatorLoginLogDO);
	}

    /**
	 * 插入merchant_operator_login_log表数据
	 */
	public void insertMerchantOperatorLoginLog(
			Long id, 
			String username, 
			Long userId, 
			String loginIp, 
			String message, 
			String loginStatus, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		MerchantOperatorLoginLogDO merchantOperatorLoginLogDO = new MerchantOperatorLoginLogDO();
		merchantOperatorLoginLogDO.setId(id);
		merchantOperatorLoginLogDO.setUsername(username);
		merchantOperatorLoginLogDO.setUserId(userId);
		merchantOperatorLoginLogDO.setLoginIp(loginIp);
		merchantOperatorLoginLogDO.setMessage(message);
		merchantOperatorLoginLogDO.setLoginStatus(loginStatus);
		merchantOperatorLoginLogDO.setRawAddTime(rawAddTime);
		merchantOperatorLoginLogDO.setRawUpdateTime(rawUpdateTime);
		merchantOperatorLoginLogDAO.insert(merchantOperatorLoginLogDO);
	}

    /**
     * 删除merchant_operator_login_log表所有数据
     */
    public void cleanMerchantOperatorLoginLog() {
        MerchantOperatorLoginLogDOExample exam = new MerchantOperatorLoginLogDOExample();
        exam.createCriteria();
        merchantOperatorLoginLogDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除merchant_operator_login_log表数据
	 */
	public void cleanMerchantOperatorLoginLogById(Long id) {
		MerchantOperatorLoginLogDOExample exam = new MerchantOperatorLoginLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantOperatorLoginLogDAO.deleteByExample(exam);
	}

	/**
	* 根据username删除merchant_operator_login_log表数据
	*/
	public void cleanMerchantOperatorLoginLogByUsername(String username) {
        if (StringUtils.isBlank(username)){
            username = "test_username";
        }
		MerchantOperatorLoginLogDOExample exam = new MerchantOperatorLoginLogDOExample();
		exam.createCriteria().andUsernameEqualTo(username);
		merchantOperatorLoginLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除merchant_operator_login_log表数据
	 */
	public void cleanMerchantOperatorLoginLogByUserId(Long userId) {
		MerchantOperatorLoginLogDOExample exam = new MerchantOperatorLoginLogDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		merchantOperatorLoginLogDAO.deleteByExample(exam);
	}

    /**
     * 查询merchant_operator_login_log表所有数据
     */
    public List<MerchantOperatorLoginLogDO> findMerchantOperatorLoginLogAll() {
        MerchantOperatorLoginLogDOExample exam = new MerchantOperatorLoginLogDOExample();
        exam.createCriteria();
		return merchantOperatorLoginLogDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询merchant_operator_login_log表数据
	 */
	public List<MerchantOperatorLoginLogDO> findMerchantOperatorLoginLogById(Long id) {
		MerchantOperatorLoginLogDOExample exam = new MerchantOperatorLoginLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return merchantOperatorLoginLogDAO.selectByExample(exam);
	}

	/**
	* 根据username查询merchant_operator_login_log表数据
	*/
	public List<MerchantOperatorLoginLogDO> findMerchantOperatorLoginLogByUsername(String username) {
		MerchantOperatorLoginLogDOExample exam = new MerchantOperatorLoginLogDOExample();
		exam.createCriteria().andUsernameEqualTo(username);
		return merchantOperatorLoginLogDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询merchant_operator_login_log表数据
	 */
	public List<MerchantOperatorLoginLogDO> findMerchantOperatorLoginLogByUserId(Long userId) {
		MerchantOperatorLoginLogDOExample exam = new MerchantOperatorLoginLogDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return merchantOperatorLoginLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新merchant_operator_login_log表数据
	 */
	public void updateMerchantOperatorLoginLogById(Long id,MerchantOperatorLoginLogDO merchantOperatorLoginLogDO) {
		MerchantOperatorLoginLogDOExample exam = new MerchantOperatorLoginLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantOperatorLoginLogDAO.updateByExample(merchantOperatorLoginLogDO, exam);
	}

	/**
	* 根据username更新merchant_operator_login_log表数据
	*/
	public void updateMerchantOperatorLoginLogByUsername(String username,MerchantOperatorLoginLogDO merchantOperatorLoginLogDO) {
		MerchantOperatorLoginLogDOExample exam = new MerchantOperatorLoginLogDOExample();
		exam.createCriteria().andUsernameEqualTo(username);
		merchantOperatorLoginLogDAO.updateByExample(merchantOperatorLoginLogDO, exam);
	}

    /**
	 * 根据userId更新merchant_operator_login_log表数据
	 */
	public void updateMerchantOperatorLoginLogByUserId(Long userId,MerchantOperatorLoginLogDO merchantOperatorLoginLogDO) {
		MerchantOperatorLoginLogDOExample exam = new MerchantOperatorLoginLogDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		merchantOperatorLoginLogDAO.updateByExample(merchantOperatorLoginLogDO, exam);
	}

    /**
	 * 断言merchant_role表
	 */
	public void merchantRoleAssert(
	        MerchantRoleDO merchantRoleDO,
			Long id, 
			String roleId, 
			String roleName, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, merchantRoleDO.getId());
        assertEquals(roleId, merchantRoleDO.getRoleId());
        assertEquals(roleName, merchantRoleDO.getRoleName());
        assertEquals(memo, merchantRoleDO.getMemo());
        assertEquals(rawAddTime, merchantRoleDO.getRawAddTime());
        assertEquals(rawUpdateTime, merchantRoleDO.getRawUpdateTime());
	}

	/**
	 * 断言merchant_role表数据
	 */
	public void assertMerchantRole(MerchantRoleDO expect, MerchantRoleDO merchantRoleDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			merchantRoleDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != merchantRoleDO.getRawAddTime());
		expect.setRawAddTime(merchantRoleDO.getRawAddTime());
        Assertions.assertTrue(null != merchantRoleDO.getRawUpdateTime());
		expect.setRawUpdateTime(merchantRoleDO.getRawUpdateTime());
		Assertions.assertEquals(expect, merchantRoleDO);
	}

    /**
	 * 插入merchant_role表数据
	 */
	public void insertMerchantRole(MerchantRoleDO merchantRoleDO) {
		merchantRoleDAO.insert(merchantRoleDO);
	}

    /**
	 * 插入merchant_role表数据
	 */
	public void insertMerchantRole(
			Long id, 
			String roleId, 
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
		MerchantRoleDO merchantRoleDO = new MerchantRoleDO();
		merchantRoleDO.setId(id);
		merchantRoleDO.setRoleId(roleId);
		merchantRoleDO.setRoleName(roleName);
		merchantRoleDO.setMemo(memo);
		merchantRoleDO.setRawAddTime(rawAddTime);
		merchantRoleDO.setRawUpdateTime(rawUpdateTime);
		merchantRoleDAO.insert(merchantRoleDO);
	}

    /**
     * 删除merchant_role表所有数据
     */
    public void cleanMerchantRole() {
        MerchantRoleDOExample exam = new MerchantRoleDOExample();
        exam.createCriteria();
        merchantRoleDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除merchant_role表数据
	 */
	public void cleanMerchantRoleById(Long id) {
		MerchantRoleDOExample exam = new MerchantRoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantRoleDAO.deleteByExample(exam);
	}

	/**
	 * 根据roleId删除merchant_role表数据
	 */
	public void cleanMerchantRoleByRoleId(String roleId) {
        if (StringUtils.isBlank(roleId)){
            roleId = "test_roleId";
        }
		MerchantRoleDOExample exam = new MerchantRoleDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		merchantRoleDAO.deleteByExample(exam);
	}

	/**
	* 根据roleName删除merchant_role表数据
	*/
	public void cleanMerchantRoleByRoleName(String roleName) {
        if (StringUtils.isBlank(roleName)){
            roleName = "test_roleName";
        }
		MerchantRoleDOExample exam = new MerchantRoleDOExample();
		exam.createCriteria().andRoleNameEqualTo(roleName);
		merchantRoleDAO.deleteByExample(exam);
	}

    /**
     * 查询merchant_role表所有数据
     */
    public List<MerchantRoleDO> findMerchantRoleAll() {
        MerchantRoleDOExample exam = new MerchantRoleDOExample();
        exam.createCriteria();
		return merchantRoleDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询merchant_role表数据
	 */
	public List<MerchantRoleDO> findMerchantRoleById(Long id) {
		MerchantRoleDOExample exam = new MerchantRoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return merchantRoleDAO.selectByExample(exam);
	}

    /**
	 * 根据roleId查询merchant_role表数据
	 */
	public List<MerchantRoleDO> findMerchantRoleByRoleId(String roleId) {
		MerchantRoleDOExample exam = new MerchantRoleDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		return merchantRoleDAO.selectByExample(exam);
	}

	/**
	* 根据roleName查询merchant_role表数据
	*/
	public List<MerchantRoleDO> findMerchantRoleByRoleName(String roleName) {
		MerchantRoleDOExample exam = new MerchantRoleDOExample();
		exam.createCriteria().andRoleNameEqualTo(roleName);
		return merchantRoleDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新merchant_role表数据
	 */
	public void updateMerchantRoleById(Long id,MerchantRoleDO merchantRoleDO) {
		MerchantRoleDOExample exam = new MerchantRoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantRoleDAO.updateByExample(merchantRoleDO, exam);
	}

    /**
	 * 根据roleId更新merchant_role表数据
	 */
	public void updateMerchantRoleByRoleId(String roleId,MerchantRoleDO merchantRoleDO) {
		MerchantRoleDOExample exam = new MerchantRoleDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		merchantRoleDAO.updateByExample(merchantRoleDO, exam);
	}

	/**
	* 根据roleName更新merchant_role表数据
	*/
	public void updateMerchantRoleByRoleName(String roleName,MerchantRoleDO merchantRoleDO) {
		MerchantRoleDOExample exam = new MerchantRoleDOExample();
		exam.createCriteria().andRoleNameEqualTo(roleName);
		merchantRoleDAO.updateByExample(merchantRoleDO, exam);
	}

    /**
	 * 断言merchant_settlement表
	 */
	public void merchantSettlementAssert(
	        MerchantSettlementDO merchantSettlementDO,
			Long id, 
			String partnerId, 
			String partnerAbbrName, 
			String settlementAccountType, 
			String settlementAccountName, 
			String settlementAccount, 
			String settlementAccountBank, 
			String settlementAccountBankCode, 
			String settlementAccountSubBank, 
			String settlementAccountSubBankNo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, merchantSettlementDO.getId());
        assertEquals(partnerId, merchantSettlementDO.getPartnerId());
        assertEquals(partnerAbbrName, merchantSettlementDO.getPartnerAbbrName());
        assertEquals(settlementAccountType, merchantSettlementDO.getSettlementAccountType());
        assertEquals(settlementAccountName, merchantSettlementDO.getSettlementAccountName());
        assertEquals(settlementAccount, merchantSettlementDO.getSettlementAccount());
        assertEquals(settlementAccountBank, merchantSettlementDO.getSettlementAccountBank());
        assertEquals(settlementAccountBankCode, merchantSettlementDO.getSettlementAccountBankCode());
        assertEquals(settlementAccountSubBank, merchantSettlementDO.getSettlementAccountSubBank());
        assertEquals(settlementAccountSubBankNo, merchantSettlementDO.getSettlementAccountSubBankNo());
        assertEquals(rawAddTime, merchantSettlementDO.getRawAddTime());
        assertEquals(rawUpdateTime, merchantSettlementDO.getRawUpdateTime());
	}

	/**
	 * 断言merchant_settlement表数据
	 */
	public void assertMerchantSettlement(MerchantSettlementDO expect, MerchantSettlementDO merchantSettlementDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			merchantSettlementDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != merchantSettlementDO.getRawAddTime());
		expect.setRawAddTime(merchantSettlementDO.getRawAddTime());
        Assertions.assertTrue(null != merchantSettlementDO.getRawUpdateTime());
		expect.setRawUpdateTime(merchantSettlementDO.getRawUpdateTime());
		Assertions.assertEquals(expect, merchantSettlementDO);
	}

    /**
	 * 插入merchant_settlement表数据
	 */
	public void insertMerchantSettlement(MerchantSettlementDO merchantSettlementDO) {
		merchantSettlementDAO.insert(merchantSettlementDO);
	}

    /**
	 * 插入merchant_settlement表数据
	 */
	public void insertMerchantSettlement(
			Long id, 
			String partnerId, 
			String partnerAbbrName, 
			String settlementAccountType, 
			String settlementAccountName, 
			String settlementAccount, 
			String settlementAccountBank, 
			String settlementAccountBankCode, 
			String settlementAccountSubBank, 
			String settlementAccountSubBankNo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		MerchantSettlementDO merchantSettlementDO = new MerchantSettlementDO();
		merchantSettlementDO.setId(id);
		merchantSettlementDO.setPartnerId(partnerId);
		merchantSettlementDO.setPartnerAbbrName(partnerAbbrName);
		merchantSettlementDO.setSettlementAccountType(settlementAccountType);
		merchantSettlementDO.setSettlementAccountName(settlementAccountName);
		merchantSettlementDO.setSettlementAccount(settlementAccount);
		merchantSettlementDO.setSettlementAccountBank(settlementAccountBank);
		merchantSettlementDO.setSettlementAccountBankCode(settlementAccountBankCode);
		merchantSettlementDO.setSettlementAccountSubBank(settlementAccountSubBank);
		merchantSettlementDO.setSettlementAccountSubBankNo(settlementAccountSubBankNo);
		merchantSettlementDO.setRawAddTime(rawAddTime);
		merchantSettlementDO.setRawUpdateTime(rawUpdateTime);
		merchantSettlementDAO.insert(merchantSettlementDO);
	}

    /**
     * 删除merchant_settlement表所有数据
     */
    public void cleanMerchantSettlement() {
        MerchantSettlementDOExample exam = new MerchantSettlementDOExample();
        exam.createCriteria();
        merchantSettlementDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除merchant_settlement表数据
	 */
	public void cleanMerchantSettlementById(Long id) {
		MerchantSettlementDOExample exam = new MerchantSettlementDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantSettlementDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除merchant_settlement表数据
	 */
	public void cleanMerchantSettlementByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		MerchantSettlementDOExample exam = new MerchantSettlementDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantSettlementDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerAbbrName删除merchant_settlement表数据
	*/
	public void cleanMerchantSettlementByPartnerAbbrName(String partnerAbbrName) {
        if (StringUtils.isBlank(partnerAbbrName)){
            partnerAbbrName = "test_partnerAbbrName";
        }
		MerchantSettlementDOExample exam = new MerchantSettlementDOExample();
		exam.createCriteria().andPartnerAbbrNameEqualTo(partnerAbbrName);
		merchantSettlementDAO.deleteByExample(exam);
	}

	/**
	* 根据settlementAccountName删除merchant_settlement表数据
	*/
	public void cleanMerchantSettlementBySettlementAccountName(String settlementAccountName) {
        if (StringUtils.isBlank(settlementAccountName)){
            settlementAccountName = "test_settlementAccountName";
        }
		MerchantSettlementDOExample exam = new MerchantSettlementDOExample();
		exam.createCriteria().andSettlementAccountNameEqualTo(settlementAccountName);
		merchantSettlementDAO.deleteByExample(exam);
	}

	/**
	* 根据settlementAccountBankCode删除merchant_settlement表数据
	*/
	public void cleanMerchantSettlementBySettlementAccountBankCode(String settlementAccountBankCode) {
        if (StringUtils.isBlank(settlementAccountBankCode)){
            settlementAccountBankCode = "test_settlementAccountBankCode";
        }
		MerchantSettlementDOExample exam = new MerchantSettlementDOExample();
		exam.createCriteria().andSettlementAccountBankCodeEqualTo(settlementAccountBankCode);
		merchantSettlementDAO.deleteByExample(exam);
	}

	/**
	 * 根据settlementAccountSubBankNo删除merchant_settlement表数据
	 */
	public void cleanMerchantSettlementBySettlementAccountSubBankNo(String settlementAccountSubBankNo) {
        if (StringUtils.isBlank(settlementAccountSubBankNo)){
            settlementAccountSubBankNo = "test_settlementAccountSubBankNo";
        }
		MerchantSettlementDOExample exam = new MerchantSettlementDOExample();
		exam.createCriteria().andSettlementAccountSubBankNoEqualTo(settlementAccountSubBankNo);
		merchantSettlementDAO.deleteByExample(exam);
	}

    /**
     * 查询merchant_settlement表所有数据
     */
    public List<MerchantSettlementDO> findMerchantSettlementAll() {
        MerchantSettlementDOExample exam = new MerchantSettlementDOExample();
        exam.createCriteria();
		return merchantSettlementDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询merchant_settlement表数据
	 */
	public List<MerchantSettlementDO> findMerchantSettlementById(Long id) {
		MerchantSettlementDOExample exam = new MerchantSettlementDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return merchantSettlementDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询merchant_settlement表数据
	 */
	public List<MerchantSettlementDO> findMerchantSettlementByPartnerId(String partnerId) {
		MerchantSettlementDOExample exam = new MerchantSettlementDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return merchantSettlementDAO.selectByExample(exam);
	}

	/**
	* 根据partnerAbbrName查询merchant_settlement表数据
	*/
	public List<MerchantSettlementDO> findMerchantSettlementByPartnerAbbrName(String partnerAbbrName) {
		MerchantSettlementDOExample exam = new MerchantSettlementDOExample();
		exam.createCriteria().andPartnerAbbrNameEqualTo(partnerAbbrName);
		return merchantSettlementDAO.selectByExample(exam);
	}

	/**
	* 根据settlementAccountName查询merchant_settlement表数据
	*/
	public List<MerchantSettlementDO> findMerchantSettlementBySettlementAccountName(String settlementAccountName) {
		MerchantSettlementDOExample exam = new MerchantSettlementDOExample();
		exam.createCriteria().andSettlementAccountNameEqualTo(settlementAccountName);
		return merchantSettlementDAO.selectByExample(exam);
	}

	/**
	* 根据settlementAccountBankCode查询merchant_settlement表数据
	*/
	public List<MerchantSettlementDO> findMerchantSettlementBySettlementAccountBankCode(String settlementAccountBankCode) {
		MerchantSettlementDOExample exam = new MerchantSettlementDOExample();
		exam.createCriteria().andSettlementAccountBankCodeEqualTo(settlementAccountBankCode);
		return merchantSettlementDAO.selectByExample(exam);
	}

    /**
	 * 根据settlementAccountSubBankNo查询merchant_settlement表数据
	 */
	public List<MerchantSettlementDO> findMerchantSettlementBySettlementAccountSubBankNo(String settlementAccountSubBankNo) {
		MerchantSettlementDOExample exam = new MerchantSettlementDOExample();
		exam.createCriteria().andSettlementAccountSubBankNoEqualTo(settlementAccountSubBankNo);
		return merchantSettlementDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新merchant_settlement表数据
	 */
	public void updateMerchantSettlementById(Long id,MerchantSettlementDO merchantSettlementDO) {
		MerchantSettlementDOExample exam = new MerchantSettlementDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantSettlementDAO.updateByExample(merchantSettlementDO, exam);
	}

    /**
	 * 根据partnerId更新merchant_settlement表数据
	 */
	public void updateMerchantSettlementByPartnerId(String partnerId,MerchantSettlementDO merchantSettlementDO) {
		MerchantSettlementDOExample exam = new MerchantSettlementDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantSettlementDAO.updateByExample(merchantSettlementDO, exam);
	}

	/**
	* 根据partnerAbbrName更新merchant_settlement表数据
	*/
	public void updateMerchantSettlementByPartnerAbbrName(String partnerAbbrName,MerchantSettlementDO merchantSettlementDO) {
		MerchantSettlementDOExample exam = new MerchantSettlementDOExample();
		exam.createCriteria().andPartnerAbbrNameEqualTo(partnerAbbrName);
		merchantSettlementDAO.updateByExample(merchantSettlementDO, exam);
	}

	/**
	* 根据settlementAccountName更新merchant_settlement表数据
	*/
	public void updateMerchantSettlementBySettlementAccountName(String settlementAccountName,MerchantSettlementDO merchantSettlementDO) {
		MerchantSettlementDOExample exam = new MerchantSettlementDOExample();
		exam.createCriteria().andSettlementAccountNameEqualTo(settlementAccountName);
		merchantSettlementDAO.updateByExample(merchantSettlementDO, exam);
	}

	/**
	* 根据settlementAccountBankCode更新merchant_settlement表数据
	*/
	public void updateMerchantSettlementBySettlementAccountBankCode(String settlementAccountBankCode,MerchantSettlementDO merchantSettlementDO) {
		MerchantSettlementDOExample exam = new MerchantSettlementDOExample();
		exam.createCriteria().andSettlementAccountBankCodeEqualTo(settlementAccountBankCode);
		merchantSettlementDAO.updateByExample(merchantSettlementDO, exam);
	}

    /**
	 * 根据settlementAccountSubBankNo更新merchant_settlement表数据
	 */
	public void updateMerchantSettlementBySettlementAccountSubBankNo(String settlementAccountSubBankNo,MerchantSettlementDO merchantSettlementDO) {
		MerchantSettlementDOExample exam = new MerchantSettlementDOExample();
		exam.createCriteria().andSettlementAccountSubBankNoEqualTo(settlementAccountSubBankNo);
		merchantSettlementDAO.updateByExample(merchantSettlementDO, exam);
	}

    /**
	 * 断言notify_task表
	 */
	public void notifyTaskAssert(
	        NotifyTaskDO notifyTaskDO,
			Long id, 
			String bizNo, 
			String status, 
			String notifyCategory, 
			String notifyType, 
			Integer retryCount, 
			Integer maxRetryCount, 
			String notifyGroup, 
			String notifyVersion, 
			String notifyUrl, 
			String notifyInterface, 
			String detail, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, notifyTaskDO.getId());
        assertEquals(bizNo, notifyTaskDO.getBizNo());
        assertEquals(status, notifyTaskDO.getStatus());
        assertEquals(notifyCategory, notifyTaskDO.getNotifyCategory());
        assertEquals(notifyType, notifyTaskDO.getNotifyType());
        assertEquals(retryCount, notifyTaskDO.getRetryCount());
        assertEquals(maxRetryCount, notifyTaskDO.getMaxRetryCount());
        assertEquals(notifyGroup, notifyTaskDO.getNotifyGroup());
        assertEquals(notifyVersion, notifyTaskDO.getNotifyVersion());
        assertEquals(notifyUrl, notifyTaskDO.getNotifyUrl());
        assertEquals(notifyInterface, notifyTaskDO.getNotifyInterface());
        assertEquals(detail, notifyTaskDO.getDetail());
        assertEquals(rawAddTime, notifyTaskDO.getRawAddTime());
        assertEquals(rawUpdateTime, notifyTaskDO.getRawUpdateTime());
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
			String bizNo, 
			String status, 
			String notifyCategory, 
			String notifyType, 
			Integer retryCount, 
			Integer maxRetryCount, 
			String notifyGroup, 
			String notifyVersion, 
			String notifyUrl, 
			String notifyInterface, 
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
		NotifyTaskDO notifyTaskDO = new NotifyTaskDO();
		notifyTaskDO.setId(id);
		notifyTaskDO.setBizNo(bizNo);
		notifyTaskDO.setStatus(status);
		notifyTaskDO.setNotifyCategory(notifyCategory);
		notifyTaskDO.setNotifyType(notifyType);
		notifyTaskDO.setRetryCount(retryCount);
		notifyTaskDO.setMaxRetryCount(maxRetryCount);
		notifyTaskDO.setNotifyGroup(notifyGroup);
		notifyTaskDO.setNotifyVersion(notifyVersion);
		notifyTaskDO.setNotifyUrl(notifyUrl);
		notifyTaskDO.setNotifyInterface(notifyInterface);
		notifyTaskDO.setDetail(detail);
		notifyTaskDO.setRawAddTime(rawAddTime);
		notifyTaskDO.setRawUpdateTime(rawUpdateTime);
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
	 * 根据bizNo删除notify_task表数据
	 */
	public void cleanNotifyTaskByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		NotifyTaskDOExample exam = new NotifyTaskDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
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
	 * 根据bizNo查询notify_task表数据
	 */
	public List<NotifyTaskDO> findNotifyTaskByBizNo(String bizNo) {
		NotifyTaskDOExample exam = new NotifyTaskDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
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
	 * 根据bizNo更新notify_task表数据
	 */
	public void updateNotifyTaskByBizNo(String bizNo,NotifyTaskDO notifyTaskDO) {
		NotifyTaskDOExample exam = new NotifyTaskDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		notifyTaskDAO.updateByExample(notifyTaskDO, exam);
	}

    /**
	 * 断言sys_lock表
	 */
	public void sysLockAssert(
	        SysLockDO sysLockDO,
			Long identity, 
			String module, 
			String policy, 
			String lockName, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(identity, sysLockDO.getIdentity());
        assertEquals(module, sysLockDO.getModule());
        assertEquals(policy, sysLockDO.getPolicy());
        assertEquals(lockName, sysLockDO.getLockName());
        assertEquals(rawAddTime, sysLockDO.getRawAddTime());
        assertEquals(rawUpdateTime, sysLockDO.getRawUpdateTime());
	}

	/**
	 * 断言sys_lock表数据
	 */
	public void assertSysLock(SysLockDO expect, SysLockDO sysLockDO) {
		Assertions.assertTrue(null != sysLockDO.getRawAddTime());
		expect.setRawAddTime(sysLockDO.getRawAddTime());
        Assertions.assertTrue(null != sysLockDO.getRawUpdateTime());
		expect.setRawUpdateTime(sysLockDO.getRawUpdateTime());
		Assertions.assertEquals(expect, sysLockDO);
	}

    /**
	 * 插入sys_lock表数据
	 */
	public void insertSysLock(SysLockDO sysLockDO) {
		sysLockDAO.insert(sysLockDO);
	}

    /**
	 * 插入sys_lock表数据
	 */
	public void insertSysLock(
			Long identity, 
			String module, 
			String policy, 
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
		SysLockDO sysLockDO = new SysLockDO();
		sysLockDO.setIdentity(identity);
		sysLockDO.setModule(module);
		sysLockDO.setPolicy(policy);
		sysLockDO.setLockName(lockName);
		sysLockDO.setRawAddTime(rawAddTime);
		sysLockDO.setRawUpdateTime(rawUpdateTime);
		sysLockDAO.insert(sysLockDO);
	}

    /**
     * 删除sys_lock表所有数据
     */
    public void cleanSysLock() {
        SysLockDOExample exam = new SysLockDOExample();
        exam.createCriteria();
        sysLockDAO.deleteByExample(exam);
    }


	/**
	 * 根据identity删除sys_lock表数据
	 */
	public void cleanSysLockByIdentity(Long identity) {
		SysLockDOExample exam = new SysLockDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		sysLockDAO.deleteByExample(exam);
	}

	/**
	* 根据lockName删除sys_lock表数据
	*/
	public void cleanSysLockByLockName(String lockName) {
        if (StringUtils.isBlank(lockName)){
            lockName = "test_lockName";
        }
		SysLockDOExample exam = new SysLockDOExample();
		exam.createCriteria().andLockNameEqualTo(lockName);
		sysLockDAO.deleteByExample(exam);
	}

    /**
     * 查询sys_lock表所有数据
     */
    public List<SysLockDO> findSysLockAll() {
        SysLockDOExample exam = new SysLockDOExample();
        exam.createCriteria();
		return sysLockDAO.selectByExample(exam);
    }

    /**
	 * 根据identity查询sys_lock表数据
	 */
	public List<SysLockDO> findSysLockByIdentity(Long identity) {
		SysLockDOExample exam = new SysLockDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		return sysLockDAO.selectByExample(exam);
	}

	/**
	* 根据lockName查询sys_lock表数据
	*/
	public List<SysLockDO> findSysLockByLockName(String lockName) {
		SysLockDOExample exam = new SysLockDOExample();
		exam.createCriteria().andLockNameEqualTo(lockName);
		return sysLockDAO.selectByExample(exam);
	}

    /**
	 * 根据identity更新sys_lock表数据
	 */
	public void updateSysLockByIdentity(Long identity,SysLockDO sysLockDO) {
		SysLockDOExample exam = new SysLockDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		sysLockDAO.updateByExample(sysLockDO, exam);
	}

	/**
	* 根据lockName更新sys_lock表数据
	*/
	public void updateSysLockByLockName(String lockName,SysLockDO sysLockDO) {
		SysLockDOExample exam = new SysLockDOExample();
		exam.createCriteria().andLockNameEqualTo(lockName);
		sysLockDAO.updateByExample(sysLockDO, exam);
	}

    /**
	 * 断言sys_menu表
	 */
	public void sysMenuAssert(
	        SysMenuDO sysMenuDO,
			Long id, 
			String code, 
			String pcode, 
			String pcodes, 
			String name, 
			String icon, 
			String url, 
			Integer num, 
			Integer levels, 
			Integer ismenu, 
			String tips, 
			String status, 
			Integer isopen
	) {
        assertEquals(id, sysMenuDO.getId());
        assertEquals(code, sysMenuDO.getCode());
        assertEquals(pcode, sysMenuDO.getPcode());
        assertEquals(pcodes, sysMenuDO.getPcodes());
        assertEquals(name, sysMenuDO.getName());
        assertEquals(icon, sysMenuDO.getIcon());
        assertEquals(url, sysMenuDO.getUrl());
        assertEquals(num, sysMenuDO.getNum());
        assertEquals(levels, sysMenuDO.getLevels());
        assertEquals(ismenu, sysMenuDO.getIsmenu());
        assertEquals(tips, sysMenuDO.getTips());
        assertEquals(status, sysMenuDO.getStatus());
        assertEquals(isopen, sysMenuDO.getIsopen());
	}

	/**
	 * 断言sys_menu表数据
	 */
	public void assertSysMenu(SysMenuDO expect, SysMenuDO sysMenuDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			sysMenuDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, sysMenuDO);
	}

    /**
	 * 插入sys_menu表数据
	 */
	public void insertSysMenu(SysMenuDO sysMenuDO) {
		sysMenuDAO.insert(sysMenuDO);
	}

    /**
	 * 插入sys_menu表数据
	 */
	public void insertSysMenu(
			Long id, 
			String code, 
			String pcode, 
			String pcodes, 
			String name, 
			String icon, 
			String url, 
			Integer num, 
			Integer levels, 
			Integer ismenu, 
			String tips, 
			String status, 
			Integer isopen
	) {
		SysMenuDO sysMenuDO = new SysMenuDO();
		sysMenuDO.setId(id);
		sysMenuDO.setCode(code);
		sysMenuDO.setPcode(pcode);
		sysMenuDO.setPcodes(pcodes);
		sysMenuDO.setName(name);
		sysMenuDO.setIcon(icon);
		sysMenuDO.setUrl(url);
		sysMenuDO.setNum(num);
		sysMenuDO.setLevels(levels);
		sysMenuDO.setIsmenu(ismenu);
		sysMenuDO.setTips(tips);
		sysMenuDO.setStatus(status);
		sysMenuDO.setIsopen(isopen);
		sysMenuDAO.insert(sysMenuDO);
	}

    /**
     * 删除sys_menu表所有数据
     */
    public void cleanSysMenu() {
        SysMenuDOExample exam = new SysMenuDOExample();
        exam.createCriteria();
        sysMenuDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除sys_menu表数据
	 */
	public void cleanSysMenuById(Long id) {
		SysMenuDOExample exam = new SysMenuDOExample();
		exam.createCriteria().andIdEqualTo(id);
		sysMenuDAO.deleteByExample(exam);
	}

	/**
	* 根据code删除sys_menu表数据
	*/
	public void cleanSysMenuByCode(String code) {
        if (StringUtils.isBlank(code)){
            code = "test_code";
        }
		SysMenuDOExample exam = new SysMenuDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		sysMenuDAO.deleteByExample(exam);
	}

	/**
	* 根据pcode删除sys_menu表数据
	*/
	public void cleanSysMenuByPcode(String pcode) {
        if (StringUtils.isBlank(pcode)){
            pcode = "test_pcode";
        }
		SysMenuDOExample exam = new SysMenuDOExample();
		exam.createCriteria().andPcodeEqualTo(pcode);
		sysMenuDAO.deleteByExample(exam);
	}

	/**
	* 根据pcodes删除sys_menu表数据
	*/
	public void cleanSysMenuByPcodes(String pcodes) {
        if (StringUtils.isBlank(pcodes)){
            pcodes = "test_pcodes";
        }
		SysMenuDOExample exam = new SysMenuDOExample();
		exam.createCriteria().andPcodesEqualTo(pcodes);
		sysMenuDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除sys_menu表数据
	*/
	public void cleanSysMenuByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		SysMenuDOExample exam = new SysMenuDOExample();
		exam.createCriteria().andNameEqualTo(name);
		sysMenuDAO.deleteByExample(exam);
	}

    /**
     * 查询sys_menu表所有数据
     */
    public List<SysMenuDO> findSysMenuAll() {
        SysMenuDOExample exam = new SysMenuDOExample();
        exam.createCriteria();
		return sysMenuDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询sys_menu表数据
	 */
	public List<SysMenuDO> findSysMenuById(Long id) {
		SysMenuDOExample exam = new SysMenuDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return sysMenuDAO.selectByExample(exam);
	}

	/**
	* 根据code查询sys_menu表数据
	*/
	public List<SysMenuDO> findSysMenuByCode(String code) {
		SysMenuDOExample exam = new SysMenuDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		return sysMenuDAO.selectByExample(exam);
	}

	/**
	* 根据pcode查询sys_menu表数据
	*/
	public List<SysMenuDO> findSysMenuByPcode(String pcode) {
		SysMenuDOExample exam = new SysMenuDOExample();
		exam.createCriteria().andPcodeEqualTo(pcode);
		return sysMenuDAO.selectByExample(exam);
	}

	/**
	* 根据pcodes查询sys_menu表数据
	*/
	public List<SysMenuDO> findSysMenuByPcodes(String pcodes) {
		SysMenuDOExample exam = new SysMenuDOExample();
		exam.createCriteria().andPcodesEqualTo(pcodes);
		return sysMenuDAO.selectByExample(exam);
	}

	/**
	* 根据name查询sys_menu表数据
	*/
	public List<SysMenuDO> findSysMenuByName(String name) {
		SysMenuDOExample exam = new SysMenuDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return sysMenuDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新sys_menu表数据
	 */
	public void updateSysMenuById(Long id,SysMenuDO sysMenuDO) {
		SysMenuDOExample exam = new SysMenuDOExample();
		exam.createCriteria().andIdEqualTo(id);
		sysMenuDAO.updateByExample(sysMenuDO, exam);
	}

	/**
	* 根据code更新sys_menu表数据
	*/
	public void updateSysMenuByCode(String code,SysMenuDO sysMenuDO) {
		SysMenuDOExample exam = new SysMenuDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		sysMenuDAO.updateByExample(sysMenuDO, exam);
	}

	/**
	* 根据pcode更新sys_menu表数据
	*/
	public void updateSysMenuByPcode(String pcode,SysMenuDO sysMenuDO) {
		SysMenuDOExample exam = new SysMenuDOExample();
		exam.createCriteria().andPcodeEqualTo(pcode);
		sysMenuDAO.updateByExample(sysMenuDO, exam);
	}

	/**
	* 根据pcodes更新sys_menu表数据
	*/
	public void updateSysMenuByPcodes(String pcodes,SysMenuDO sysMenuDO) {
		SysMenuDOExample exam = new SysMenuDOExample();
		exam.createCriteria().andPcodesEqualTo(pcodes);
		sysMenuDAO.updateByExample(sysMenuDO, exam);
	}

	/**
	* 根据name更新sys_menu表数据
	*/
	public void updateSysMenuByName(String name,SysMenuDO sysMenuDO) {
		SysMenuDOExample exam = new SysMenuDOExample();
		exam.createCriteria().andNameEqualTo(name);
		sysMenuDAO.updateByExample(sysMenuDO, exam);
	}

    /**
	 * 断言sys_sequence表
	 */
	public void sysSequenceAssert(
	        SysSequenceDO sysSequenceDO,
			Long identity, 
			String seqName
	) {
        assertEquals(identity, sysSequenceDO.getIdentity());
        assertEquals(seqName, sysSequenceDO.getSeqName());
	}

	/**
	 * 断言sys_sequence表数据
	 */
	public void assertSysSequence(SysSequenceDO expect, SysSequenceDO sysSequenceDO) {
		Assertions.assertEquals(expect, sysSequenceDO);
	}

    /**
	 * 插入sys_sequence表数据
	 */
	public void insertSysSequence(SysSequenceDO sysSequenceDO) {
		sysSequenceDAO.insert(sysSequenceDO);
	}

    /**
	 * 插入sys_sequence表数据
	 */
	public void insertSysSequence(
			Long identity, 
			String seqName
	) {
		SysSequenceDO sysSequenceDO = new SysSequenceDO();
		sysSequenceDO.setIdentity(identity);
		sysSequenceDO.setSeqName(seqName);
		sysSequenceDAO.insert(sysSequenceDO);
	}

    /**
     * 删除sys_sequence表所有数据
     */
    public void cleanSysSequence() {
        SysSequenceDOExample exam = new SysSequenceDOExample();
        exam.createCriteria();
        sysSequenceDAO.deleteByExample(exam);
    }


	/**
	 * 根据identity删除sys_sequence表数据
	 */
	public void cleanSysSequenceByIdentity(Long identity) {
		SysSequenceDOExample exam = new SysSequenceDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		sysSequenceDAO.deleteByExample(exam);
	}

	/**
	* 根据seqName删除sys_sequence表数据
	*/
	public void cleanSysSequenceBySeqName(String seqName) {
        if (StringUtils.isBlank(seqName)){
            seqName = "test_seqName";
        }
		SysSequenceDOExample exam = new SysSequenceDOExample();
		exam.createCriteria().andSeqNameEqualTo(seqName);
		sysSequenceDAO.deleteByExample(exam);
	}

    /**
     * 查询sys_sequence表所有数据
     */
    public List<SysSequenceDO> findSysSequenceAll() {
        SysSequenceDOExample exam = new SysSequenceDOExample();
        exam.createCriteria();
		return sysSequenceDAO.selectByExample(exam);
    }

    /**
	 * 根据identity查询sys_sequence表数据
	 */
	public List<SysSequenceDO> findSysSequenceByIdentity(Long identity) {
		SysSequenceDOExample exam = new SysSequenceDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		return sysSequenceDAO.selectByExample(exam);
	}

	/**
	* 根据seqName查询sys_sequence表数据
	*/
	public List<SysSequenceDO> findSysSequenceBySeqName(String seqName) {
		SysSequenceDOExample exam = new SysSequenceDOExample();
		exam.createCriteria().andSeqNameEqualTo(seqName);
		return sysSequenceDAO.selectByExample(exam);
	}

    /**
	 * 根据identity更新sys_sequence表数据
	 */
	public void updateSysSequenceByIdentity(Long identity,SysSequenceDO sysSequenceDO) {
		SysSequenceDOExample exam = new SysSequenceDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		sysSequenceDAO.updateByExample(sysSequenceDO, exam);
	}

	/**
	* 根据seqName更新sys_sequence表数据
	*/
	public void updateSysSequenceBySeqName(String seqName,SysSequenceDO sysSequenceDO) {
		SysSequenceDOExample exam = new SysSequenceDOExample();
		exam.createCriteria().andSeqNameEqualTo(seqName);
		sysSequenceDAO.updateByExample(sysSequenceDO, exam);
	}
}
