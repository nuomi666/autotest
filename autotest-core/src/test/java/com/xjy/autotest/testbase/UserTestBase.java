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
import dal.dao.user.*;
import dal.model.user.*;
import com.xjy.autotest.config.UserDataSourceConfig;

/**
 * @author autotest
 * Created on 2019/11/15.
 */
@Service
@Import({
        UserDataSourceConfig.class
})
public class UserTestBase extends AutoTestBase{

	@Autowired
	AccountBatchLogDAO accountBatchLogDAO;

	@Autowired
	AccountDAO accountDAO;

	@Autowired
	AccountFreezeCodeAmountDAO accountFreezeCodeAmountDAO;

	@Autowired
	AccountFreezeLogDAO accountFreezeLogDAO;

	@Autowired
	AccountTransLogDAO accountTransLogDAO;

	@Autowired
	MerchantEntryDAO merchantEntryDAO;

	@Autowired
	SysLockDAO sysLockDAO;

	@Autowired
	SysMenuDAO sysMenuDAO;

	@Autowired
	SysSeqDAO sysSeqDAO;

	@Autowired
	UserBankCardDAO userBankCardDAO;

	@Autowired
	UserBankCardHisDAO userBankCardHisDAO;

	@Autowired
	UserDAO userDAO;

	@Autowired
	UserDaysStatisticsDAO userDaysStatisticsDAO;

	@Autowired
	UserNotifyTaskDAO userNotifyTaskDAO;

	public AccountBatchLogDAO getAccountBatchLogDAO() {
		return this.accountBatchLogDAO;
	}

	public AccountDAO getAccountDAO() {
		return this.accountDAO;
	}

	public AccountFreezeCodeAmountDAO getAccountFreezeCodeAmountDAO() {
		return this.accountFreezeCodeAmountDAO;
	}

	public AccountFreezeLogDAO getAccountFreezeLogDAO() {
		return this.accountFreezeLogDAO;
	}

	public AccountTransLogDAO getAccountTransLogDAO() {
		return this.accountTransLogDAO;
	}

	public MerchantEntryDAO getMerchantEntryDAO() {
		return this.merchantEntryDAO;
	}

	public SysLockDAO getSysLockDAO() {
		return this.sysLockDAO;
	}

	public SysMenuDAO getSysMenuDAO() {
		return this.sysMenuDAO;
	}

	public SysSeqDAO getSysSeqDAO() {
		return this.sysSeqDAO;
	}

	public UserBankCardDAO getUserBankCardDAO() {
		return this.userBankCardDAO;
	}

	public UserBankCardHisDAO getUserBankCardHisDAO() {
		return this.userBankCardHisDAO;
	}

	public UserDAO getUserDAO() {
		return this.userDAO;
	}

	public UserDaysStatisticsDAO getUserDaysStatisticsDAO() {
		return this.userDaysStatisticsDAO;
	}

	public UserNotifyTaskDAO getUserNotifyTaskDAO() {
		return this.userNotifyTaskDAO;
	}


    /**
	 * 断言account_batch_log表
	 */
	public void accountBatchLogAssert(
	        AccountBatchLogDO accountBatchLogDO,
			Long id, 
			String reqId, 
			String transReqIds, 
			String gid, 
			String merchantOrderNo, 
			String partnerId, 
			String platMerchantOrderNo, 
			String platPartnerId, 
			String billDate, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, accountBatchLogDO.getId());
        assertEquals(reqId, accountBatchLogDO.getReqId());
        assertEquals(transReqIds, accountBatchLogDO.getTransReqIds());
        assertEquals(gid, accountBatchLogDO.getGid());
        assertEquals(merchantOrderNo, accountBatchLogDO.getMerchantOrderNo());
        assertEquals(partnerId, accountBatchLogDO.getPartnerId());
        assertEquals(platMerchantOrderNo, accountBatchLogDO.getPlatMerchantOrderNo());
        assertEquals(platPartnerId, accountBatchLogDO.getPlatPartnerId());
        assertEquals(billDate, accountBatchLogDO.getBillDate());
        assertEquals(rawAddTime, accountBatchLogDO.getRawAddTime());
        assertEquals(rawUpdateTime, accountBatchLogDO.getRawUpdateTime());
	}

	/**
	 * 断言account_batch_log表数据
	 */
	public void assertAccountBatchLog(AccountBatchLogDO expect, AccountBatchLogDO accountBatchLogDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			accountBatchLogDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != accountBatchLogDO.getRawAddTime());
		expect.setRawAddTime(accountBatchLogDO.getRawAddTime());
        Assertions.assertTrue(null != accountBatchLogDO.getRawUpdateTime());
		expect.setRawUpdateTime(accountBatchLogDO.getRawUpdateTime());
		Assertions.assertEquals(expect, accountBatchLogDO);
	}

    /**
	 * 插入account_batch_log表数据
	 */
	public void insertAccountBatchLog(AccountBatchLogDO accountBatchLogDO) {
		accountBatchLogDAO.insert(accountBatchLogDO);
	}

    /**
	 * 插入account_batch_log表数据
	 */
	public void insertAccountBatchLog(
			Long id, 
			String reqId, 
			String transReqIds, 
			String gid, 
			String merchantOrderNo, 
			String partnerId, 
			String platMerchantOrderNo, 
			String platPartnerId, 
			String billDate, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		AccountBatchLogDO accountBatchLogDO = new AccountBatchLogDO();
		accountBatchLogDO.setId(id);
		accountBatchLogDO.setReqId(reqId);
		accountBatchLogDO.setTransReqIds(transReqIds);
		accountBatchLogDO.setGid(gid);
		accountBatchLogDO.setMerchantOrderNo(merchantOrderNo);
		accountBatchLogDO.setPartnerId(partnerId);
		accountBatchLogDO.setPlatMerchantOrderNo(platMerchantOrderNo);
		accountBatchLogDO.setPlatPartnerId(platPartnerId);
		accountBatchLogDO.setBillDate(billDate);
		accountBatchLogDO.setRawAddTime(rawAddTime);
		accountBatchLogDO.setRawUpdateTime(rawUpdateTime);
		accountBatchLogDAO.insert(accountBatchLogDO);
	}

    /**
     * 删除account_batch_log表所有数据
     */
    public void cleanAccountBatchLog() {
        AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
        exam.createCriteria();
        accountBatchLogDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除account_batch_log表数据
	 */
	public void cleanAccountBatchLogById(Long id) {
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		accountBatchLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除account_batch_log表数据
	 */
	public void cleanAccountBatchLogByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		accountBatchLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据transReqIds删除account_batch_log表数据
	 */
	public void cleanAccountBatchLogByTransReqIds(String transReqIds) {
        if (StringUtils.isBlank(transReqIds)){
            transReqIds = "test_transReqIds";
        }
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andTransReqIdsEqualTo(transReqIds);
		accountBatchLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除account_batch_log表数据
	 */
	public void cleanAccountBatchLogByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		accountBatchLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantOrderNo删除account_batch_log表数据
	 */
	public void cleanAccountBatchLogByMerchantOrderNo(String merchantOrderNo) {
        if (StringUtils.isBlank(merchantOrderNo)){
            merchantOrderNo = "test_merchantOrderNo";
        }
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		accountBatchLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除account_batch_log表数据
	 */
	public void cleanAccountBatchLogByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		accountBatchLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据platMerchantOrderNo删除account_batch_log表数据
	 */
	public void cleanAccountBatchLogByPlatMerchantOrderNo(String platMerchantOrderNo) {
        if (StringUtils.isBlank(platMerchantOrderNo)){
            platMerchantOrderNo = "test_platMerchantOrderNo";
        }
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		accountBatchLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除account_batch_log表数据
	 */
	public void cleanAccountBatchLogByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		accountBatchLogDAO.deleteByExample(exam);
	}

    /**
     * 查询account_batch_log表所有数据
     */
    public List<AccountBatchLogDO> findAccountBatchLogAll() {
        AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
        exam.createCriteria();
		return accountBatchLogDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询account_batch_log表数据
	 */
	public List<AccountBatchLogDO> findAccountBatchLogById(Long id) {
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return accountBatchLogDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询account_batch_log表数据
	 */
	public List<AccountBatchLogDO> findAccountBatchLogByReqId(String reqId) {
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return accountBatchLogDAO.selectByExample(exam);
	}

    /**
	 * 根据transReqIds查询account_batch_log表数据
	 */
	public List<AccountBatchLogDO> findAccountBatchLogByTransReqIds(String transReqIds) {
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andTransReqIdsEqualTo(transReqIds);
		return accountBatchLogDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询account_batch_log表数据
	 */
	public List<AccountBatchLogDO> findAccountBatchLogByGid(String gid) {
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return accountBatchLogDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantOrderNo查询account_batch_log表数据
	 */
	public List<AccountBatchLogDO> findAccountBatchLogByMerchantOrderNo(String merchantOrderNo) {
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		return accountBatchLogDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询account_batch_log表数据
	 */
	public List<AccountBatchLogDO> findAccountBatchLogByPartnerId(String partnerId) {
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return accountBatchLogDAO.selectByExample(exam);
	}

    /**
	 * 根据platMerchantOrderNo查询account_batch_log表数据
	 */
	public List<AccountBatchLogDO> findAccountBatchLogByPlatMerchantOrderNo(String platMerchantOrderNo) {
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		return accountBatchLogDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询account_batch_log表数据
	 */
	public List<AccountBatchLogDO> findAccountBatchLogByPlatPartnerId(String platPartnerId) {
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return accountBatchLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新account_batch_log表数据
	 */
	public void updateAccountBatchLogById(Long id,AccountBatchLogDO accountBatchLogDO) {
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		accountBatchLogDAO.updateByExample(accountBatchLogDO, exam);
	}

    /**
	 * 根据reqId更新account_batch_log表数据
	 */
	public void updateAccountBatchLogByReqId(String reqId,AccountBatchLogDO accountBatchLogDO) {
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		accountBatchLogDAO.updateByExample(accountBatchLogDO, exam);
	}

    /**
	 * 根据transReqIds更新account_batch_log表数据
	 */
	public void updateAccountBatchLogByTransReqIds(String transReqIds,AccountBatchLogDO accountBatchLogDO) {
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andTransReqIdsEqualTo(transReqIds);
		accountBatchLogDAO.updateByExample(accountBatchLogDO, exam);
	}

    /**
	 * 根据gid更新account_batch_log表数据
	 */
	public void updateAccountBatchLogByGid(String gid,AccountBatchLogDO accountBatchLogDO) {
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		accountBatchLogDAO.updateByExample(accountBatchLogDO, exam);
	}

    /**
	 * 根据merchantOrderNo更新account_batch_log表数据
	 */
	public void updateAccountBatchLogByMerchantOrderNo(String merchantOrderNo,AccountBatchLogDO accountBatchLogDO) {
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		accountBatchLogDAO.updateByExample(accountBatchLogDO, exam);
	}

    /**
	 * 根据partnerId更新account_batch_log表数据
	 */
	public void updateAccountBatchLogByPartnerId(String partnerId,AccountBatchLogDO accountBatchLogDO) {
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		accountBatchLogDAO.updateByExample(accountBatchLogDO, exam);
	}

    /**
	 * 根据platMerchantOrderNo更新account_batch_log表数据
	 */
	public void updateAccountBatchLogByPlatMerchantOrderNo(String platMerchantOrderNo,AccountBatchLogDO accountBatchLogDO) {
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		accountBatchLogDAO.updateByExample(accountBatchLogDO, exam);
	}

    /**
	 * 根据platPartnerId更新account_batch_log表数据
	 */
	public void updateAccountBatchLogByPlatPartnerId(String platPartnerId,AccountBatchLogDO accountBatchLogDO) {
		AccountBatchLogDOExample exam = new AccountBatchLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		accountBatchLogDAO.updateByExample(accountBatchLogDO, exam);
	}

    /**
	 * 断言account表
	 */
	public void accountAssert(
	        AccountDO accountDO,
			Long id, 
			String platPartnerId, 
			String partnerId, 
			String accountNo, 
			String bandAccountNo, 
			String userId, 
			Long balance, 
			Long freezeBalance, 
			Long creditAmount, 
			Long hisInAmount, 
			Long hisOutAmount, 
			String status, 
			String accountType, 
			String payModel, 
			String tag, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, accountDO.getId());
        assertEquals(platPartnerId, accountDO.getPlatPartnerId());
        assertEquals(partnerId, accountDO.getPartnerId());
        assertEquals(accountNo, accountDO.getAccountNo());
        assertEquals(bandAccountNo, accountDO.getBandAccountNo());
        assertEquals(userId, accountDO.getUserId());
        assertEquals(balance, accountDO.getBalance());
        assertEquals(freezeBalance, accountDO.getFreezeBalance());
        assertEquals(creditAmount, accountDO.getCreditAmount());
        assertEquals(hisInAmount, accountDO.getHisInAmount());
        assertEquals(hisOutAmount, accountDO.getHisOutAmount());
        assertEquals(status, accountDO.getStatus());
        assertEquals(accountType, accountDO.getAccountType());
        assertEquals(payModel, accountDO.getPayModel());
        assertEquals(tag, accountDO.getTag());
        assertEquals(memo, accountDO.getMemo());
        assertEquals(rawAddTime, accountDO.getRawAddTime());
        assertEquals(rawUpdateTime, accountDO.getRawUpdateTime());
	}

	/**
	 * 断言account表数据
	 */
	public void assertAccount(AccountDO expect, AccountDO accountDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			accountDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != accountDO.getRawAddTime());
		expect.setRawAddTime(accountDO.getRawAddTime());
        Assertions.assertTrue(null != accountDO.getRawUpdateTime());
		expect.setRawUpdateTime(accountDO.getRawUpdateTime());
		Assertions.assertEquals(expect, accountDO);
	}

    /**
	 * 插入account表数据
	 */
	public void insertAccount(AccountDO accountDO) {
		accountDAO.insert(accountDO);
	}

    /**
	 * 插入account表数据
	 */
	public void insertAccount(
			Long id, 
			String platPartnerId, 
			String partnerId, 
			String accountNo, 
			String bandAccountNo, 
			String userId, 
			Long balance, 
			Long freezeBalance, 
			Long creditAmount, 
			Long hisInAmount, 
			Long hisOutAmount, 
			String status, 
			String accountType, 
			String payModel, 
			String tag, 
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
		AccountDO accountDO = new AccountDO();
		accountDO.setId(id);
		accountDO.setPlatPartnerId(platPartnerId);
		accountDO.setPartnerId(partnerId);
		accountDO.setAccountNo(accountNo);
		accountDO.setBandAccountNo(bandAccountNo);
		accountDO.setUserId(userId);
		accountDO.setBalance(balance);
		accountDO.setFreezeBalance(freezeBalance);
		accountDO.setCreditAmount(creditAmount);
		accountDO.setHisInAmount(hisInAmount);
		accountDO.setHisOutAmount(hisOutAmount);
		accountDO.setStatus(status);
		accountDO.setAccountType(accountType);
		accountDO.setPayModel(payModel);
		accountDO.setTag(tag);
		accountDO.setMemo(memo);
		accountDO.setRawAddTime(rawAddTime);
		accountDO.setRawUpdateTime(rawUpdateTime);
		accountDAO.insert(accountDO);
	}

    /**
     * 删除account表所有数据
     */
    public void cleanAccount() {
        AccountDOExample exam = new AccountDOExample();
        exam.createCriteria();
        accountDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除account表数据
	 */
	public void cleanAccountById(Long id) {
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andIdEqualTo(id);
		accountDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除account表数据
	 */
	public void cleanAccountByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		accountDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除account表数据
	 */
	public void cleanAccountByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		accountDAO.deleteByExample(exam);
	}

	/**
	 * 根据accountNo删除account表数据
	 */
	public void cleanAccountByAccountNo(String accountNo) {
        if (StringUtils.isBlank(accountNo)){
            accountNo = "test_accountNo";
        }
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		accountDAO.deleteByExample(exam);
	}

	/**
	 * 根据bandAccountNo删除account表数据
	 */
	public void cleanAccountByBandAccountNo(String bandAccountNo) {
        if (StringUtils.isBlank(bandAccountNo)){
            bandAccountNo = "test_bandAccountNo";
        }
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andBandAccountNoEqualTo(bandAccountNo);
		accountDAO.deleteByExample(exam);
	}
	/**
	 * 根据userId,accountType删除account表数据
	 */
	public void cleanAccountByUserIdAndAccountType(String userId,String accountType) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
        if (StringUtils.isBlank(accountType)){
            accountType = "test_accountType";
        }
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andUserIdEqualTo(userId).andAccountTypeEqualTo(accountType);
		accountDAO.deleteByExample(exam);
	}
	/**
	 * 根据userId,tag删除account表数据
	 */
	public void cleanAccountByUserIdAndTag(String userId,String tag) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
        if (StringUtils.isBlank(tag)){
            tag = "test_tag";
        }
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andUserIdEqualTo(userId).andTagEqualTo(tag);
		accountDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除account表数据
	 */
	public void cleanAccountByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		accountDAO.deleteByExample(exam);
	}

    /**
     * 查询account表所有数据
     */
    public List<AccountDO> findAccountAll() {
        AccountDOExample exam = new AccountDOExample();
        exam.createCriteria();
		return accountDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询account表数据
	 */
	public List<AccountDO> findAccountById(Long id) {
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return accountDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询account表数据
	 */
	public List<AccountDO> findAccountByPlatPartnerId(String platPartnerId) {
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return accountDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询account表数据
	 */
	public List<AccountDO> findAccountByPartnerId(String partnerId) {
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return accountDAO.selectByExample(exam);
	}

    /**
	 * 根据accountNo查询account表数据
	 */
	public List<AccountDO> findAccountByAccountNo(String accountNo) {
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		return accountDAO.selectByExample(exam);
	}

    /**
	 * 根据bandAccountNo查询account表数据
	 */
	public List<AccountDO> findAccountByBandAccountNo(String bandAccountNo) {
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andBandAccountNoEqualTo(bandAccountNo);
		return accountDAO.selectByExample(exam);
	}

	/**
	 * 根据userId,accountType查询account表数据
	 */
	public List<AccountDO> findAccountByUserIdAndAccountType(String userId,String accountType) {
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andUserIdEqualTo(userId).andAccountTypeEqualTo(accountType);
		return accountDAO.selectByExample(exam);
	}

	/**
	 * 根据userId,tag查询account表数据
	 */
	public List<AccountDO> findAccountByUserIdAndTag(String userId,String tag) {
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andUserIdEqualTo(userId).andTagEqualTo(tag);
		return accountDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询account表数据
	 */
	public List<AccountDO> findAccountByUserId(String userId) {
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return accountDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新account表数据
	 */
	public void updateAccountById(Long id,AccountDO accountDO) {
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andIdEqualTo(id);
		accountDAO.updateByExample(accountDO, exam);
	}

    /**
	 * 根据platPartnerId更新account表数据
	 */
	public void updateAccountByPlatPartnerId(String platPartnerId,AccountDO accountDO) {
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		accountDAO.updateByExample(accountDO, exam);
	}

    /**
	 * 根据partnerId更新account表数据
	 */
	public void updateAccountByPartnerId(String partnerId,AccountDO accountDO) {
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		accountDAO.updateByExample(accountDO, exam);
	}

    /**
	 * 根据accountNo更新account表数据
	 */
	public void updateAccountByAccountNo(String accountNo,AccountDO accountDO) {
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		accountDAO.updateByExample(accountDO, exam);
	}

    /**
	 * 根据bandAccountNo更新account表数据
	 */
	public void updateAccountByBandAccountNo(String bandAccountNo,AccountDO accountDO) {
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andBandAccountNoEqualTo(bandAccountNo);
		accountDAO.updateByExample(accountDO, exam);
	}

	/**
	 * 根据userId,accountType更新account表数据
	 */
	public void updateAccountByUserIdAndAccountType(String userId,String accountType,AccountDO accountDO) {
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andUserIdEqualTo(userId).andAccountTypeEqualTo(accountType);
		accountDAO.updateByExample(accountDO, exam);
	}

	/**
	 * 根据userId,tag更新account表数据
	 */
	public void updateAccountByUserIdAndTag(String userId,String tag,AccountDO accountDO) {
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andUserIdEqualTo(userId).andTagEqualTo(tag);
		accountDAO.updateByExample(accountDO, exam);
	}

    /**
	 * 根据userId更新account表数据
	 */
	public void updateAccountByUserId(String userId,AccountDO accountDO) {
		AccountDOExample exam = new AccountDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		accountDAO.updateByExample(accountDO, exam);
	}

    /**
	 * 断言account_freeze_code_amount表
	 */
	public void accountFreezeCodeAmountAssert(
	        AccountFreezeCodeAmountDO accountFreezeCodeAmountDO,
			Long id, 
			String accountNo, 
			String freezeCode, 
			Long freezeAmount, 
			Long unfreezeAmount, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, accountFreezeCodeAmountDO.getId());
        assertEquals(accountNo, accountFreezeCodeAmountDO.getAccountNo());
        assertEquals(freezeCode, accountFreezeCodeAmountDO.getFreezeCode());
        assertEquals(freezeAmount, accountFreezeCodeAmountDO.getFreezeAmount());
        assertEquals(unfreezeAmount, accountFreezeCodeAmountDO.getUnfreezeAmount());
        assertEquals(rawAddTime, accountFreezeCodeAmountDO.getRawAddTime());
        assertEquals(rawUpdateTime, accountFreezeCodeAmountDO.getRawUpdateTime());
	}

	/**
	 * 断言account_freeze_code_amount表数据
	 */
	public void assertAccountFreezeCodeAmount(AccountFreezeCodeAmountDO expect, AccountFreezeCodeAmountDO accountFreezeCodeAmountDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			accountFreezeCodeAmountDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != accountFreezeCodeAmountDO.getRawAddTime());
		expect.setRawAddTime(accountFreezeCodeAmountDO.getRawAddTime());
        Assertions.assertTrue(null != accountFreezeCodeAmountDO.getRawUpdateTime());
		expect.setRawUpdateTime(accountFreezeCodeAmountDO.getRawUpdateTime());
		Assertions.assertEquals(expect, accountFreezeCodeAmountDO);
	}

    /**
	 * 插入account_freeze_code_amount表数据
	 */
	public void insertAccountFreezeCodeAmount(AccountFreezeCodeAmountDO accountFreezeCodeAmountDO) {
		accountFreezeCodeAmountDAO.insert(accountFreezeCodeAmountDO);
	}

    /**
	 * 插入account_freeze_code_amount表数据
	 */
	public void insertAccountFreezeCodeAmount(
			Long id, 
			String accountNo, 
			String freezeCode, 
			Long freezeAmount, 
			Long unfreezeAmount, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		AccountFreezeCodeAmountDO accountFreezeCodeAmountDO = new AccountFreezeCodeAmountDO();
		accountFreezeCodeAmountDO.setId(id);
		accountFreezeCodeAmountDO.setAccountNo(accountNo);
		accountFreezeCodeAmountDO.setFreezeCode(freezeCode);
		accountFreezeCodeAmountDO.setFreezeAmount(freezeAmount);
		accountFreezeCodeAmountDO.setUnfreezeAmount(unfreezeAmount);
		accountFreezeCodeAmountDO.setRawAddTime(rawAddTime);
		accountFreezeCodeAmountDO.setRawUpdateTime(rawUpdateTime);
		accountFreezeCodeAmountDAO.insert(accountFreezeCodeAmountDO);
	}

    /**
     * 删除account_freeze_code_amount表所有数据
     */
    public void cleanAccountFreezeCodeAmount() {
        AccountFreezeCodeAmountDOExample exam = new AccountFreezeCodeAmountDOExample();
        exam.createCriteria();
        accountFreezeCodeAmountDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除account_freeze_code_amount表数据
	 */
	public void cleanAccountFreezeCodeAmountById(Long id) {
		AccountFreezeCodeAmountDOExample exam = new AccountFreezeCodeAmountDOExample();
		exam.createCriteria().andIdEqualTo(id);
		accountFreezeCodeAmountDAO.deleteByExample(exam);
	}

	/**
	 * 根据accountNo删除account_freeze_code_amount表数据
	 */
	public void cleanAccountFreezeCodeAmountByAccountNo(String accountNo) {
        if (StringUtils.isBlank(accountNo)){
            accountNo = "test_accountNo";
        }
		AccountFreezeCodeAmountDOExample exam = new AccountFreezeCodeAmountDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		accountFreezeCodeAmountDAO.deleteByExample(exam);
	}

	/**
	* 根据freezeCode删除account_freeze_code_amount表数据
	*/
	public void cleanAccountFreezeCodeAmountByFreezeCode(String freezeCode) {
        if (StringUtils.isBlank(freezeCode)){
            freezeCode = "test_freezeCode";
        }
		AccountFreezeCodeAmountDOExample exam = new AccountFreezeCodeAmountDOExample();
		exam.createCriteria().andFreezeCodeEqualTo(freezeCode);
		accountFreezeCodeAmountDAO.deleteByExample(exam);
	}

    /**
     * 查询account_freeze_code_amount表所有数据
     */
    public List<AccountFreezeCodeAmountDO> findAccountFreezeCodeAmountAll() {
        AccountFreezeCodeAmountDOExample exam = new AccountFreezeCodeAmountDOExample();
        exam.createCriteria();
		return accountFreezeCodeAmountDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询account_freeze_code_amount表数据
	 */
	public List<AccountFreezeCodeAmountDO> findAccountFreezeCodeAmountById(Long id) {
		AccountFreezeCodeAmountDOExample exam = new AccountFreezeCodeAmountDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return accountFreezeCodeAmountDAO.selectByExample(exam);
	}

    /**
	 * 根据accountNo查询account_freeze_code_amount表数据
	 */
	public List<AccountFreezeCodeAmountDO> findAccountFreezeCodeAmountByAccountNo(String accountNo) {
		AccountFreezeCodeAmountDOExample exam = new AccountFreezeCodeAmountDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		return accountFreezeCodeAmountDAO.selectByExample(exam);
	}

	/**
	* 根据freezeCode查询account_freeze_code_amount表数据
	*/
	public List<AccountFreezeCodeAmountDO> findAccountFreezeCodeAmountByFreezeCode(String freezeCode) {
		AccountFreezeCodeAmountDOExample exam = new AccountFreezeCodeAmountDOExample();
		exam.createCriteria().andFreezeCodeEqualTo(freezeCode);
		return accountFreezeCodeAmountDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新account_freeze_code_amount表数据
	 */
	public void updateAccountFreezeCodeAmountById(Long id,AccountFreezeCodeAmountDO accountFreezeCodeAmountDO) {
		AccountFreezeCodeAmountDOExample exam = new AccountFreezeCodeAmountDOExample();
		exam.createCriteria().andIdEqualTo(id);
		accountFreezeCodeAmountDAO.updateByExample(accountFreezeCodeAmountDO, exam);
	}

    /**
	 * 根据accountNo更新account_freeze_code_amount表数据
	 */
	public void updateAccountFreezeCodeAmountByAccountNo(String accountNo,AccountFreezeCodeAmountDO accountFreezeCodeAmountDO) {
		AccountFreezeCodeAmountDOExample exam = new AccountFreezeCodeAmountDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		accountFreezeCodeAmountDAO.updateByExample(accountFreezeCodeAmountDO, exam);
	}

	/**
	* 根据freezeCode更新account_freeze_code_amount表数据
	*/
	public void updateAccountFreezeCodeAmountByFreezeCode(String freezeCode,AccountFreezeCodeAmountDO accountFreezeCodeAmountDO) {
		AccountFreezeCodeAmountDOExample exam = new AccountFreezeCodeAmountDOExample();
		exam.createCriteria().andFreezeCodeEqualTo(freezeCode);
		accountFreezeCodeAmountDAO.updateByExample(accountFreezeCodeAmountDO, exam);
	}

    /**
	 * 断言account_freeze_log表
	 */
	public void accountFreezeLogAssert(
	        AccountFreezeLogDO accountFreezeLogDO,
			Long id, 
			String accountNo, 
			String bizNo, 
			String reqId, 
			String freezeType, 
			String freezeCode, 
			Long amount, 
			Long freezeBalance, 
			String memo, 
			String gid, 
			String merchantOrderNo, 
			String partnerId, 
			String platMerchantOrderNo, 
			String platPartnerId, 
			String billDate, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, accountFreezeLogDO.getId());
        assertEquals(accountNo, accountFreezeLogDO.getAccountNo());
        assertEquals(bizNo, accountFreezeLogDO.getBizNo());
        assertEquals(reqId, accountFreezeLogDO.getReqId());
        assertEquals(freezeType, accountFreezeLogDO.getFreezeType());
        assertEquals(freezeCode, accountFreezeLogDO.getFreezeCode());
        assertEquals(amount, accountFreezeLogDO.getAmount());
        assertEquals(freezeBalance, accountFreezeLogDO.getFreezeBalance());
        assertEquals(memo, accountFreezeLogDO.getMemo());
        assertEquals(gid, accountFreezeLogDO.getGid());
        assertEquals(merchantOrderNo, accountFreezeLogDO.getMerchantOrderNo());
        assertEquals(partnerId, accountFreezeLogDO.getPartnerId());
        assertEquals(platMerchantOrderNo, accountFreezeLogDO.getPlatMerchantOrderNo());
        assertEquals(platPartnerId, accountFreezeLogDO.getPlatPartnerId());
        assertEquals(billDate, accountFreezeLogDO.getBillDate());
        assertEquals(rawAddTime, accountFreezeLogDO.getRawAddTime());
        assertEquals(rawUpdateTime, accountFreezeLogDO.getRawUpdateTime());
	}

	/**
	 * 断言account_freeze_log表数据
	 */
	public void assertAccountFreezeLog(AccountFreezeLogDO expect, AccountFreezeLogDO accountFreezeLogDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			accountFreezeLogDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != accountFreezeLogDO.getRawAddTime());
		expect.setRawAddTime(accountFreezeLogDO.getRawAddTime());
        Assertions.assertTrue(null != accountFreezeLogDO.getRawUpdateTime());
		expect.setRawUpdateTime(accountFreezeLogDO.getRawUpdateTime());
		Assertions.assertEquals(expect, accountFreezeLogDO);
	}

    /**
	 * 插入account_freeze_log表数据
	 */
	public void insertAccountFreezeLog(AccountFreezeLogDO accountFreezeLogDO) {
		accountFreezeLogDAO.insert(accountFreezeLogDO);
	}

    /**
	 * 插入account_freeze_log表数据
	 */
	public void insertAccountFreezeLog(
			Long id, 
			String accountNo, 
			String bizNo, 
			String reqId, 
			String freezeType, 
			String freezeCode, 
			Long amount, 
			Long freezeBalance, 
			String memo, 
			String gid, 
			String merchantOrderNo, 
			String partnerId, 
			String platMerchantOrderNo, 
			String platPartnerId, 
			String billDate, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		AccountFreezeLogDO accountFreezeLogDO = new AccountFreezeLogDO();
		accountFreezeLogDO.setId(id);
		accountFreezeLogDO.setAccountNo(accountNo);
		accountFreezeLogDO.setBizNo(bizNo);
		accountFreezeLogDO.setReqId(reqId);
		accountFreezeLogDO.setFreezeType(freezeType);
		accountFreezeLogDO.setFreezeCode(freezeCode);
		accountFreezeLogDO.setAmount(amount);
		accountFreezeLogDO.setFreezeBalance(freezeBalance);
		accountFreezeLogDO.setMemo(memo);
		accountFreezeLogDO.setGid(gid);
		accountFreezeLogDO.setMerchantOrderNo(merchantOrderNo);
		accountFreezeLogDO.setPartnerId(partnerId);
		accountFreezeLogDO.setPlatMerchantOrderNo(platMerchantOrderNo);
		accountFreezeLogDO.setPlatPartnerId(platPartnerId);
		accountFreezeLogDO.setBillDate(billDate);
		accountFreezeLogDO.setRawAddTime(rawAddTime);
		accountFreezeLogDO.setRawUpdateTime(rawUpdateTime);
		accountFreezeLogDAO.insert(accountFreezeLogDO);
	}

    /**
     * 删除account_freeze_log表所有数据
     */
    public void cleanAccountFreezeLog() {
        AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
        exam.createCriteria();
        accountFreezeLogDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除account_freeze_log表数据
	 */
	public void cleanAccountFreezeLogById(Long id) {
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		accountFreezeLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据accountNo删除account_freeze_log表数据
	 */
	public void cleanAccountFreezeLogByAccountNo(String accountNo) {
        if (StringUtils.isBlank(accountNo)){
            accountNo = "test_accountNo";
        }
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		accountFreezeLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除account_freeze_log表数据
	 */
	public void cleanAccountFreezeLogByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		accountFreezeLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除account_freeze_log表数据
	 */
	public void cleanAccountFreezeLogByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		accountFreezeLogDAO.deleteByExample(exam);
	}

	/**
	* 根据freezeCode删除account_freeze_log表数据
	*/
	public void cleanAccountFreezeLogByFreezeCode(String freezeCode) {
        if (StringUtils.isBlank(freezeCode)){
            freezeCode = "test_freezeCode";
        }
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andFreezeCodeEqualTo(freezeCode);
		accountFreezeLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除account_freeze_log表数据
	 */
	public void cleanAccountFreezeLogByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		accountFreezeLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantOrderNo删除account_freeze_log表数据
	 */
	public void cleanAccountFreezeLogByMerchantOrderNo(String merchantOrderNo) {
        if (StringUtils.isBlank(merchantOrderNo)){
            merchantOrderNo = "test_merchantOrderNo";
        }
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		accountFreezeLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除account_freeze_log表数据
	 */
	public void cleanAccountFreezeLogByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		accountFreezeLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据platMerchantOrderNo删除account_freeze_log表数据
	 */
	public void cleanAccountFreezeLogByPlatMerchantOrderNo(String platMerchantOrderNo) {
        if (StringUtils.isBlank(platMerchantOrderNo)){
            platMerchantOrderNo = "test_platMerchantOrderNo";
        }
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		accountFreezeLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除account_freeze_log表数据
	 */
	public void cleanAccountFreezeLogByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		accountFreezeLogDAO.deleteByExample(exam);
	}

    /**
     * 查询account_freeze_log表所有数据
     */
    public List<AccountFreezeLogDO> findAccountFreezeLogAll() {
        AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
        exam.createCriteria();
		return accountFreezeLogDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询account_freeze_log表数据
	 */
	public List<AccountFreezeLogDO> findAccountFreezeLogById(Long id) {
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return accountFreezeLogDAO.selectByExample(exam);
	}

    /**
	 * 根据accountNo查询account_freeze_log表数据
	 */
	public List<AccountFreezeLogDO> findAccountFreezeLogByAccountNo(String accountNo) {
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		return accountFreezeLogDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询account_freeze_log表数据
	 */
	public List<AccountFreezeLogDO> findAccountFreezeLogByBizNo(String bizNo) {
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return accountFreezeLogDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询account_freeze_log表数据
	 */
	public List<AccountFreezeLogDO> findAccountFreezeLogByReqId(String reqId) {
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return accountFreezeLogDAO.selectByExample(exam);
	}

	/**
	* 根据freezeCode查询account_freeze_log表数据
	*/
	public List<AccountFreezeLogDO> findAccountFreezeLogByFreezeCode(String freezeCode) {
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andFreezeCodeEqualTo(freezeCode);
		return accountFreezeLogDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询account_freeze_log表数据
	 */
	public List<AccountFreezeLogDO> findAccountFreezeLogByGid(String gid) {
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return accountFreezeLogDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantOrderNo查询account_freeze_log表数据
	 */
	public List<AccountFreezeLogDO> findAccountFreezeLogByMerchantOrderNo(String merchantOrderNo) {
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		return accountFreezeLogDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询account_freeze_log表数据
	 */
	public List<AccountFreezeLogDO> findAccountFreezeLogByPartnerId(String partnerId) {
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return accountFreezeLogDAO.selectByExample(exam);
	}

    /**
	 * 根据platMerchantOrderNo查询account_freeze_log表数据
	 */
	public List<AccountFreezeLogDO> findAccountFreezeLogByPlatMerchantOrderNo(String platMerchantOrderNo) {
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		return accountFreezeLogDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询account_freeze_log表数据
	 */
	public List<AccountFreezeLogDO> findAccountFreezeLogByPlatPartnerId(String platPartnerId) {
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return accountFreezeLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新account_freeze_log表数据
	 */
	public void updateAccountFreezeLogById(Long id,AccountFreezeLogDO accountFreezeLogDO) {
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		accountFreezeLogDAO.updateByExample(accountFreezeLogDO, exam);
	}

    /**
	 * 根据accountNo更新account_freeze_log表数据
	 */
	public void updateAccountFreezeLogByAccountNo(String accountNo,AccountFreezeLogDO accountFreezeLogDO) {
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		accountFreezeLogDAO.updateByExample(accountFreezeLogDO, exam);
	}

    /**
	 * 根据bizNo更新account_freeze_log表数据
	 */
	public void updateAccountFreezeLogByBizNo(String bizNo,AccountFreezeLogDO accountFreezeLogDO) {
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		accountFreezeLogDAO.updateByExample(accountFreezeLogDO, exam);
	}

    /**
	 * 根据reqId更新account_freeze_log表数据
	 */
	public void updateAccountFreezeLogByReqId(String reqId,AccountFreezeLogDO accountFreezeLogDO) {
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		accountFreezeLogDAO.updateByExample(accountFreezeLogDO, exam);
	}

	/**
	* 根据freezeCode更新account_freeze_log表数据
	*/
	public void updateAccountFreezeLogByFreezeCode(String freezeCode,AccountFreezeLogDO accountFreezeLogDO) {
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andFreezeCodeEqualTo(freezeCode);
		accountFreezeLogDAO.updateByExample(accountFreezeLogDO, exam);
	}

    /**
	 * 根据gid更新account_freeze_log表数据
	 */
	public void updateAccountFreezeLogByGid(String gid,AccountFreezeLogDO accountFreezeLogDO) {
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		accountFreezeLogDAO.updateByExample(accountFreezeLogDO, exam);
	}

    /**
	 * 根据merchantOrderNo更新account_freeze_log表数据
	 */
	public void updateAccountFreezeLogByMerchantOrderNo(String merchantOrderNo,AccountFreezeLogDO accountFreezeLogDO) {
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		accountFreezeLogDAO.updateByExample(accountFreezeLogDO, exam);
	}

    /**
	 * 根据partnerId更新account_freeze_log表数据
	 */
	public void updateAccountFreezeLogByPartnerId(String partnerId,AccountFreezeLogDO accountFreezeLogDO) {
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		accountFreezeLogDAO.updateByExample(accountFreezeLogDO, exam);
	}

    /**
	 * 根据platMerchantOrderNo更新account_freeze_log表数据
	 */
	public void updateAccountFreezeLogByPlatMerchantOrderNo(String platMerchantOrderNo,AccountFreezeLogDO accountFreezeLogDO) {
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		accountFreezeLogDAO.updateByExample(accountFreezeLogDO, exam);
	}

    /**
	 * 根据platPartnerId更新account_freeze_log表数据
	 */
	public void updateAccountFreezeLogByPlatPartnerId(String platPartnerId,AccountFreezeLogDO accountFreezeLogDO) {
		AccountFreezeLogDOExample exam = new AccountFreezeLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		accountFreezeLogDAO.updateByExample(accountFreezeLogDO, exam);
	}

    /**
	 * 断言account_trans_log表
	 */
	public void accountTransLogAssert(
	        AccountTransLogDO accountTransLogDO,
			Long id, 
			String accountNo, 
			String bizNo, 
			String reqId, 
			String transAmountType, 
			Long amount, 
			Long balance, 
			Long accountBalance, 
			Long creditAmount, 
			String transType, 
			String payChannel, 
			String memo, 
			String gid, 
			String merchantOrderNo, 
			String partnerId, 
			String platMerchantOrderNo, 
			String platPartnerId, 
			String billDate, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, accountTransLogDO.getId());
        assertEquals(accountNo, accountTransLogDO.getAccountNo());
        assertEquals(bizNo, accountTransLogDO.getBizNo());
        assertEquals(reqId, accountTransLogDO.getReqId());
        assertEquals(transAmountType, accountTransLogDO.getTransAmountType());
        assertEquals(amount, accountTransLogDO.getAmount());
        assertEquals(balance, accountTransLogDO.getBalance());
        assertEquals(accountBalance, accountTransLogDO.getAccountBalance());
        assertEquals(creditAmount, accountTransLogDO.getCreditAmount());
        assertEquals(transType, accountTransLogDO.getTransType());
        assertEquals(payChannel, accountTransLogDO.getPayChannel());
        assertEquals(memo, accountTransLogDO.getMemo());
        assertEquals(gid, accountTransLogDO.getGid());
        assertEquals(merchantOrderNo, accountTransLogDO.getMerchantOrderNo());
        assertEquals(partnerId, accountTransLogDO.getPartnerId());
        assertEquals(platMerchantOrderNo, accountTransLogDO.getPlatMerchantOrderNo());
        assertEquals(platPartnerId, accountTransLogDO.getPlatPartnerId());
        assertEquals(billDate, accountTransLogDO.getBillDate());
        assertEquals(rawAddTime, accountTransLogDO.getRawAddTime());
        assertEquals(rawUpdateTime, accountTransLogDO.getRawUpdateTime());
	}

	/**
	 * 断言account_trans_log表数据
	 */
	public void assertAccountTransLog(AccountTransLogDO expect, AccountTransLogDO accountTransLogDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			accountTransLogDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != accountTransLogDO.getRawAddTime());
		expect.setRawAddTime(accountTransLogDO.getRawAddTime());
        Assertions.assertTrue(null != accountTransLogDO.getRawUpdateTime());
		expect.setRawUpdateTime(accountTransLogDO.getRawUpdateTime());
		Assertions.assertEquals(expect, accountTransLogDO);
	}

    /**
	 * 插入account_trans_log表数据
	 */
	public void insertAccountTransLog(AccountTransLogDO accountTransLogDO) {
		accountTransLogDAO.insert(accountTransLogDO);
	}

    /**
	 * 插入account_trans_log表数据
	 */
	public void insertAccountTransLog(
			Long id, 
			String accountNo, 
			String bizNo, 
			String reqId, 
			String transAmountType, 
			Long amount, 
			Long balance, 
			Long accountBalance, 
			Long creditAmount, 
			String transType, 
			String payChannel, 
			String memo, 
			String gid, 
			String merchantOrderNo, 
			String partnerId, 
			String platMerchantOrderNo, 
			String platPartnerId, 
			String billDate, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		AccountTransLogDO accountTransLogDO = new AccountTransLogDO();
		accountTransLogDO.setId(id);
		accountTransLogDO.setAccountNo(accountNo);
		accountTransLogDO.setBizNo(bizNo);
		accountTransLogDO.setReqId(reqId);
		accountTransLogDO.setTransAmountType(transAmountType);
		accountTransLogDO.setAmount(amount);
		accountTransLogDO.setBalance(balance);
		accountTransLogDO.setAccountBalance(accountBalance);
		accountTransLogDO.setCreditAmount(creditAmount);
		accountTransLogDO.setTransType(transType);
		accountTransLogDO.setPayChannel(payChannel);
		accountTransLogDO.setMemo(memo);
		accountTransLogDO.setGid(gid);
		accountTransLogDO.setMerchantOrderNo(merchantOrderNo);
		accountTransLogDO.setPartnerId(partnerId);
		accountTransLogDO.setPlatMerchantOrderNo(platMerchantOrderNo);
		accountTransLogDO.setPlatPartnerId(platPartnerId);
		accountTransLogDO.setBillDate(billDate);
		accountTransLogDO.setRawAddTime(rawAddTime);
		accountTransLogDO.setRawUpdateTime(rawUpdateTime);
		accountTransLogDAO.insert(accountTransLogDO);
	}

    /**
     * 删除account_trans_log表所有数据
     */
    public void cleanAccountTransLog() {
        AccountTransLogDOExample exam = new AccountTransLogDOExample();
        exam.createCriteria();
        accountTransLogDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除account_trans_log表数据
	 */
	public void cleanAccountTransLogById(Long id) {
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		accountTransLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据accountNo删除account_trans_log表数据
	 */
	public void cleanAccountTransLogByAccountNo(String accountNo) {
        if (StringUtils.isBlank(accountNo)){
            accountNo = "test_accountNo";
        }
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		accountTransLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除account_trans_log表数据
	 */
	public void cleanAccountTransLogByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		accountTransLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除account_trans_log表数据
	 */
	public void cleanAccountTransLogByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		accountTransLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除account_trans_log表数据
	 */
	public void cleanAccountTransLogByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		accountTransLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantOrderNo删除account_trans_log表数据
	 */
	public void cleanAccountTransLogByMerchantOrderNo(String merchantOrderNo) {
        if (StringUtils.isBlank(merchantOrderNo)){
            merchantOrderNo = "test_merchantOrderNo";
        }
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		accountTransLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除account_trans_log表数据
	 */
	public void cleanAccountTransLogByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		accountTransLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据platMerchantOrderNo删除account_trans_log表数据
	 */
	public void cleanAccountTransLogByPlatMerchantOrderNo(String platMerchantOrderNo) {
        if (StringUtils.isBlank(platMerchantOrderNo)){
            platMerchantOrderNo = "test_platMerchantOrderNo";
        }
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		accountTransLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除account_trans_log表数据
	 */
	public void cleanAccountTransLogByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		accountTransLogDAO.deleteByExample(exam);
	}

    /**
     * 查询account_trans_log表所有数据
     */
    public List<AccountTransLogDO> findAccountTransLogAll() {
        AccountTransLogDOExample exam = new AccountTransLogDOExample();
        exam.createCriteria();
		return accountTransLogDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询account_trans_log表数据
	 */
	public List<AccountTransLogDO> findAccountTransLogById(Long id) {
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return accountTransLogDAO.selectByExample(exam);
	}

    /**
	 * 根据accountNo查询account_trans_log表数据
	 */
	public List<AccountTransLogDO> findAccountTransLogByAccountNo(String accountNo) {
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		return accountTransLogDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询account_trans_log表数据
	 */
	public List<AccountTransLogDO> findAccountTransLogByBizNo(String bizNo) {
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return accountTransLogDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询account_trans_log表数据
	 */
	public List<AccountTransLogDO> findAccountTransLogByReqId(String reqId) {
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return accountTransLogDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询account_trans_log表数据
	 */
	public List<AccountTransLogDO> findAccountTransLogByGid(String gid) {
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return accountTransLogDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantOrderNo查询account_trans_log表数据
	 */
	public List<AccountTransLogDO> findAccountTransLogByMerchantOrderNo(String merchantOrderNo) {
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		return accountTransLogDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询account_trans_log表数据
	 */
	public List<AccountTransLogDO> findAccountTransLogByPartnerId(String partnerId) {
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return accountTransLogDAO.selectByExample(exam);
	}

    /**
	 * 根据platMerchantOrderNo查询account_trans_log表数据
	 */
	public List<AccountTransLogDO> findAccountTransLogByPlatMerchantOrderNo(String platMerchantOrderNo) {
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		return accountTransLogDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询account_trans_log表数据
	 */
	public List<AccountTransLogDO> findAccountTransLogByPlatPartnerId(String platPartnerId) {
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return accountTransLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新account_trans_log表数据
	 */
	public void updateAccountTransLogById(Long id,AccountTransLogDO accountTransLogDO) {
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		accountTransLogDAO.updateByExample(accountTransLogDO, exam);
	}

    /**
	 * 根据accountNo更新account_trans_log表数据
	 */
	public void updateAccountTransLogByAccountNo(String accountNo,AccountTransLogDO accountTransLogDO) {
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		accountTransLogDAO.updateByExample(accountTransLogDO, exam);
	}

    /**
	 * 根据bizNo更新account_trans_log表数据
	 */
	public void updateAccountTransLogByBizNo(String bizNo,AccountTransLogDO accountTransLogDO) {
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		accountTransLogDAO.updateByExample(accountTransLogDO, exam);
	}

    /**
	 * 根据reqId更新account_trans_log表数据
	 */
	public void updateAccountTransLogByReqId(String reqId,AccountTransLogDO accountTransLogDO) {
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		accountTransLogDAO.updateByExample(accountTransLogDO, exam);
	}

    /**
	 * 根据gid更新account_trans_log表数据
	 */
	public void updateAccountTransLogByGid(String gid,AccountTransLogDO accountTransLogDO) {
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		accountTransLogDAO.updateByExample(accountTransLogDO, exam);
	}

    /**
	 * 根据merchantOrderNo更新account_trans_log表数据
	 */
	public void updateAccountTransLogByMerchantOrderNo(String merchantOrderNo,AccountTransLogDO accountTransLogDO) {
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		accountTransLogDAO.updateByExample(accountTransLogDO, exam);
	}

    /**
	 * 根据partnerId更新account_trans_log表数据
	 */
	public void updateAccountTransLogByPartnerId(String partnerId,AccountTransLogDO accountTransLogDO) {
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		accountTransLogDAO.updateByExample(accountTransLogDO, exam);
	}

    /**
	 * 根据platMerchantOrderNo更新account_trans_log表数据
	 */
	public void updateAccountTransLogByPlatMerchantOrderNo(String platMerchantOrderNo,AccountTransLogDO accountTransLogDO) {
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		accountTransLogDAO.updateByExample(accountTransLogDO, exam);
	}

    /**
	 * 根据platPartnerId更新account_trans_log表数据
	 */
	public void updateAccountTransLogByPlatPartnerId(String platPartnerId,AccountTransLogDO accountTransLogDO) {
		AccountTransLogDOExample exam = new AccountTransLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		accountTransLogDAO.updateByExample(accountTransLogDO, exam);
	}

    /**
	 * 断言merchant_entry表
	 */
	public void merchantEntryAssert(
	        MerchantEntryDO merchantEntryDO,
			Long id, 
			String reqId, 
			String gid, 
			String partnerId, 
			String platPartnerId, 
			String accountNo, 
			String channelId, 
			String channelPlatMerchantId, 
			String subMerchantProperty, 
			String subMerchantId, 
			String channelSubMerchantId, 
			String signedStatus, 
			String certifyStatus, 
			String channelSubMerchantAccount, 
			String externalMetaData, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, merchantEntryDO.getId());
        assertEquals(reqId, merchantEntryDO.getReqId());
        assertEquals(gid, merchantEntryDO.getGid());
        assertEquals(partnerId, merchantEntryDO.getPartnerId());
        assertEquals(platPartnerId, merchantEntryDO.getPlatPartnerId());
        assertEquals(accountNo, merchantEntryDO.getAccountNo());
        assertEquals(channelId, merchantEntryDO.getChannelId());
        assertEquals(channelPlatMerchantId, merchantEntryDO.getChannelPlatMerchantId());
        assertEquals(subMerchantProperty, merchantEntryDO.getSubMerchantProperty());
        assertEquals(subMerchantId, merchantEntryDO.getSubMerchantId());
        assertEquals(channelSubMerchantId, merchantEntryDO.getChannelSubMerchantId());
        assertEquals(signedStatus, merchantEntryDO.getSignedStatus());
        assertEquals(certifyStatus, merchantEntryDO.getCertifyStatus());
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
			String partnerId, 
			String platPartnerId, 
			String accountNo, 
			String channelId, 
			String channelPlatMerchantId, 
			String subMerchantProperty, 
			String subMerchantId, 
			String channelSubMerchantId, 
			String signedStatus, 
			String certifyStatus, 
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
		merchantEntryDO.setPartnerId(partnerId);
		merchantEntryDO.setPlatPartnerId(platPartnerId);
		merchantEntryDO.setAccountNo(accountNo);
		merchantEntryDO.setChannelId(channelId);
		merchantEntryDO.setChannelPlatMerchantId(channelPlatMerchantId);
		merchantEntryDO.setSubMerchantProperty(subMerchantProperty);
		merchantEntryDO.setSubMerchantId(subMerchantId);
		merchantEntryDO.setChannelSubMerchantId(channelSubMerchantId);
		merchantEntryDO.setSignedStatus(signedStatus);
		merchantEntryDO.setCertifyStatus(certifyStatus);
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
	 * 断言sys_seq表
	 */
	public void sysSeqAssert(
	        SysSeqDO sysSeqDO,
			Long identity, 
			String seqName
	) {
        assertEquals(identity, sysSeqDO.getIdentity());
        assertEquals(seqName, sysSeqDO.getSeqName());
	}

	/**
	 * 断言sys_seq表数据
	 */
	public void assertSysSeq(SysSeqDO expect, SysSeqDO sysSeqDO) {
		Assertions.assertEquals(expect, sysSeqDO);
	}

    /**
	 * 插入sys_seq表数据
	 */
	public void insertSysSeq(SysSeqDO sysSeqDO) {
		sysSeqDAO.insert(sysSeqDO);
	}

    /**
	 * 插入sys_seq表数据
	 */
	public void insertSysSeq(
			Long identity, 
			String seqName
	) {
		SysSeqDO sysSeqDO = new SysSeqDO();
		sysSeqDO.setIdentity(identity);
		sysSeqDO.setSeqName(seqName);
		sysSeqDAO.insert(sysSeqDO);
	}

    /**
     * 删除sys_seq表所有数据
     */
    public void cleanSysSeq() {
        SysSeqDOExample exam = new SysSeqDOExample();
        exam.createCriteria();
        sysSeqDAO.deleteByExample(exam);
    }


	/**
	 * 根据identity删除sys_seq表数据
	 */
	public void cleanSysSeqByIdentity(Long identity) {
		SysSeqDOExample exam = new SysSeqDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		sysSeqDAO.deleteByExample(exam);
	}

	/**
	* 根据seqName删除sys_seq表数据
	*/
	public void cleanSysSeqBySeqName(String seqName) {
        if (StringUtils.isBlank(seqName)){
            seqName = "test_seqName";
        }
		SysSeqDOExample exam = new SysSeqDOExample();
		exam.createCriteria().andSeqNameEqualTo(seqName);
		sysSeqDAO.deleteByExample(exam);
	}

    /**
     * 查询sys_seq表所有数据
     */
    public List<SysSeqDO> findSysSeqAll() {
        SysSeqDOExample exam = new SysSeqDOExample();
        exam.createCriteria();
		return sysSeqDAO.selectByExample(exam);
    }

    /**
	 * 根据identity查询sys_seq表数据
	 */
	public List<SysSeqDO> findSysSeqByIdentity(Long identity) {
		SysSeqDOExample exam = new SysSeqDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		return sysSeqDAO.selectByExample(exam);
	}

	/**
	* 根据seqName查询sys_seq表数据
	*/
	public List<SysSeqDO> findSysSeqBySeqName(String seqName) {
		SysSeqDOExample exam = new SysSeqDOExample();
		exam.createCriteria().andSeqNameEqualTo(seqName);
		return sysSeqDAO.selectByExample(exam);
	}

    /**
	 * 根据identity更新sys_seq表数据
	 */
	public void updateSysSeqByIdentity(Long identity,SysSeqDO sysSeqDO) {
		SysSeqDOExample exam = new SysSeqDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		sysSeqDAO.updateByExample(sysSeqDO, exam);
	}

	/**
	* 根据seqName更新sys_seq表数据
	*/
	public void updateSysSeqBySeqName(String seqName,SysSeqDO sysSeqDO) {
		SysSeqDOExample exam = new SysSeqDOExample();
		exam.createCriteria().andSeqNameEqualTo(seqName);
		sysSeqDAO.updateByExample(sysSeqDO, exam);
	}

    /**
	 * 断言user_bank_card表
	 */
	public void userBankCardAssert(
	        UserBankCardDO userBankCardDO,
			Long id, 
			String bizNo, 
			String gid, 
			String reqId, 
			String channelId, 
			String applyBindCard, 
			String userId, 
			String bankCardNo, 
			String bankCardName, 
			String bindCardSerialNum, 
			String bankCardIdcard, 
			String bankCardPhone, 
			String certType, 
			String certNo, 
			String province, 
			String city, 
			String address, 
			String bankAccountType, 
			String bankCardType, 
			String bankCode, 
			String bankName, 
			String bankKey, 
			String defaultBind, 
			String subBankName, 
			String subUnionBank, 
			String bankBindId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userBankCardDO.getId());
        assertEquals(bizNo, userBankCardDO.getBizNo());
        assertEquals(gid, userBankCardDO.getGid());
        assertEquals(reqId, userBankCardDO.getReqId());
        assertEquals(channelId, userBankCardDO.getChannelId());
        assertEquals(applyBindCard, userBankCardDO.getApplyBindCard());
        assertEquals(userId, userBankCardDO.getUserId());
        assertEquals(bankCardNo, userBankCardDO.getBankCardNo());
        assertEquals(bankCardName, userBankCardDO.getBankCardName());
        assertEquals(bindCardSerialNum, userBankCardDO.getBindCardSerialNum());
        assertEquals(bankCardIdcard, userBankCardDO.getBankCardIdcard());
        assertEquals(bankCardPhone, userBankCardDO.getBankCardPhone());
        assertEquals(certType, userBankCardDO.getCertType());
        assertEquals(certNo, userBankCardDO.getCertNo());
        assertEquals(province, userBankCardDO.getProvince());
        assertEquals(city, userBankCardDO.getCity());
        assertEquals(address, userBankCardDO.getAddress());
        assertEquals(bankAccountType, userBankCardDO.getBankAccountType());
        assertEquals(bankCardType, userBankCardDO.getBankCardType());
        assertEquals(bankCode, userBankCardDO.getBankCode());
        assertEquals(bankName, userBankCardDO.getBankName());
        assertEquals(bankKey, userBankCardDO.getBankKey());
        assertEquals(defaultBind, userBankCardDO.getDefaultBind());
        assertEquals(subBankName, userBankCardDO.getSubBankName());
        assertEquals(subUnionBank, userBankCardDO.getSubUnionBank());
        assertEquals(bankBindId, userBankCardDO.getBankBindId());
        assertEquals(rawAddTime, userBankCardDO.getRawAddTime());
        assertEquals(rawUpdateTime, userBankCardDO.getRawUpdateTime());
	}

	/**
	 * 断言user_bank_card表数据
	 */
	public void assertUserBankCard(UserBankCardDO expect, UserBankCardDO userBankCardDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userBankCardDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userBankCardDO.getRawAddTime());
		expect.setRawAddTime(userBankCardDO.getRawAddTime());
        Assertions.assertTrue(null != userBankCardDO.getRawUpdateTime());
		expect.setRawUpdateTime(userBankCardDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userBankCardDO);
	}

    /**
	 * 插入user_bank_card表数据
	 */
	public void insertUserBankCard(UserBankCardDO userBankCardDO) {
		userBankCardDAO.insert(userBankCardDO);
	}

    /**
	 * 插入user_bank_card表数据
	 */
	public void insertUserBankCard(
			Long id, 
			String bizNo, 
			String gid, 
			String reqId, 
			String channelId, 
			String applyBindCard, 
			String userId, 
			String bankCardNo, 
			String bankCardName, 
			String bindCardSerialNum, 
			String bankCardIdcard, 
			String bankCardPhone, 
			String certType, 
			String certNo, 
			String province, 
			String city, 
			String address, 
			String bankAccountType, 
			String bankCardType, 
			String bankCode, 
			String bankName, 
			String bankKey, 
			String defaultBind, 
			String subBankName, 
			String subUnionBank, 
			String bankBindId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		UserBankCardDO userBankCardDO = new UserBankCardDO();
		userBankCardDO.setId(id);
		userBankCardDO.setBizNo(bizNo);
		userBankCardDO.setGid(gid);
		userBankCardDO.setReqId(reqId);
		userBankCardDO.setChannelId(channelId);
		userBankCardDO.setApplyBindCard(applyBindCard);
		userBankCardDO.setUserId(userId);
		userBankCardDO.setBankCardNo(bankCardNo);
		userBankCardDO.setBankCardName(bankCardName);
		userBankCardDO.setBindCardSerialNum(bindCardSerialNum);
		userBankCardDO.setBankCardIdcard(bankCardIdcard);
		userBankCardDO.setBankCardPhone(bankCardPhone);
		userBankCardDO.setCertType(certType);
		userBankCardDO.setCertNo(certNo);
		userBankCardDO.setProvince(province);
		userBankCardDO.setCity(city);
		userBankCardDO.setAddress(address);
		userBankCardDO.setBankAccountType(bankAccountType);
		userBankCardDO.setBankCardType(bankCardType);
		userBankCardDO.setBankCode(bankCode);
		userBankCardDO.setBankName(bankName);
		userBankCardDO.setBankKey(bankKey);
		userBankCardDO.setDefaultBind(defaultBind);
		userBankCardDO.setSubBankName(subBankName);
		userBankCardDO.setSubUnionBank(subUnionBank);
		userBankCardDO.setBankBindId(bankBindId);
		userBankCardDO.setRawAddTime(rawAddTime);
		userBankCardDO.setRawUpdateTime(rawUpdateTime);
		userBankCardDAO.insert(userBankCardDO);
	}

    /**
     * 删除user_bank_card表所有数据
     */
    public void cleanUserBankCard() {
        UserBankCardDOExample exam = new UserBankCardDOExample();
        exam.createCriteria();
        userBankCardDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_bank_card表数据
	 */
	public void cleanUserBankCardById(Long id) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userBankCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除user_bank_card表数据
	 */
	public void cleanUserBankCardByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		userBankCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除user_bank_card表数据
	 */
	public void cleanUserBankCardByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		userBankCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除user_bank_card表数据
	 */
	public void cleanUserBankCardByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		userBankCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除user_bank_card表数据
	 */
	public void cleanUserBankCardByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		userBankCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除user_bank_card表数据
	 */
	public void cleanUserBankCardByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userBankCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据bankCardNo删除user_bank_card表数据
	 */
	public void cleanUserBankCardByBankCardNo(String bankCardNo) {
        if (StringUtils.isBlank(bankCardNo)){
            bankCardNo = "test_bankCardNo";
        }
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andBankCardNoEqualTo(bankCardNo);
		userBankCardDAO.deleteByExample(exam);
	}

	/**
	* 根据bankCardName删除user_bank_card表数据
	*/
	public void cleanUserBankCardByBankCardName(String bankCardName) {
        if (StringUtils.isBlank(bankCardName)){
            bankCardName = "test_bankCardName";
        }
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andBankCardNameEqualTo(bankCardName);
		userBankCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据bankCardIdcard删除user_bank_card表数据
	 */
	public void cleanUserBankCardByBankCardIdcard(String bankCardIdcard) {
        if (StringUtils.isBlank(bankCardIdcard)){
            bankCardIdcard = "test_bankCardIdcard";
        }
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andBankCardIdcardEqualTo(bankCardIdcard);
		userBankCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据certNo删除user_bank_card表数据
	 */
	public void cleanUserBankCardByCertNo(String certNo) {
        if (StringUtils.isBlank(certNo)){
            certNo = "test_certNo";
        }
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		userBankCardDAO.deleteByExample(exam);
	}

	/**
	* 根据bankCode删除user_bank_card表数据
	*/
	public void cleanUserBankCardByBankCode(String bankCode) {
        if (StringUtils.isBlank(bankCode)){
            bankCode = "test_bankCode";
        }
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andBankCodeEqualTo(bankCode);
		userBankCardDAO.deleteByExample(exam);
	}

	/**
	* 根据bankName删除user_bank_card表数据
	*/
	public void cleanUserBankCardByBankName(String bankName) {
        if (StringUtils.isBlank(bankName)){
            bankName = "test_bankName";
        }
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andBankNameEqualTo(bankName);
		userBankCardDAO.deleteByExample(exam);
	}

	/**
	* 根据subBankName删除user_bank_card表数据
	*/
	public void cleanUserBankCardBySubBankName(String subBankName) {
        if (StringUtils.isBlank(subBankName)){
            subBankName = "test_subBankName";
        }
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andSubBankNameEqualTo(subBankName);
		userBankCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据bankBindId删除user_bank_card表数据
	 */
	public void cleanUserBankCardByBankBindId(String bankBindId) {
        if (StringUtils.isBlank(bankBindId)){
            bankBindId = "test_bankBindId";
        }
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andBankBindIdEqualTo(bankBindId);
		userBankCardDAO.deleteByExample(exam);
	}

    /**
     * 查询user_bank_card表所有数据
     */
    public List<UserBankCardDO> findUserBankCardAll() {
        UserBankCardDOExample exam = new UserBankCardDOExample();
        exam.createCriteria();
		return userBankCardDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_bank_card表数据
	 */
	public List<UserBankCardDO> findUserBankCardById(Long id) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userBankCardDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询user_bank_card表数据
	 */
	public List<UserBankCardDO> findUserBankCardByBizNo(String bizNo) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return userBankCardDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询user_bank_card表数据
	 */
	public List<UserBankCardDO> findUserBankCardByGid(String gid) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return userBankCardDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询user_bank_card表数据
	 */
	public List<UserBankCardDO> findUserBankCardByReqId(String reqId) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return userBankCardDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询user_bank_card表数据
	 */
	public List<UserBankCardDO> findUserBankCardByChannelId(String channelId) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return userBankCardDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询user_bank_card表数据
	 */
	public List<UserBankCardDO> findUserBankCardByUserId(String userId) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return userBankCardDAO.selectByExample(exam);
	}

    /**
	 * 根据bankCardNo查询user_bank_card表数据
	 */
	public List<UserBankCardDO> findUserBankCardByBankCardNo(String bankCardNo) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andBankCardNoEqualTo(bankCardNo);
		return userBankCardDAO.selectByExample(exam);
	}

	/**
	* 根据bankCardName查询user_bank_card表数据
	*/
	public List<UserBankCardDO> findUserBankCardByBankCardName(String bankCardName) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andBankCardNameEqualTo(bankCardName);
		return userBankCardDAO.selectByExample(exam);
	}

    /**
	 * 根据bankCardIdcard查询user_bank_card表数据
	 */
	public List<UserBankCardDO> findUserBankCardByBankCardIdcard(String bankCardIdcard) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andBankCardIdcardEqualTo(bankCardIdcard);
		return userBankCardDAO.selectByExample(exam);
	}

    /**
	 * 根据certNo查询user_bank_card表数据
	 */
	public List<UserBankCardDO> findUserBankCardByCertNo(String certNo) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		return userBankCardDAO.selectByExample(exam);
	}

	/**
	* 根据bankCode查询user_bank_card表数据
	*/
	public List<UserBankCardDO> findUserBankCardByBankCode(String bankCode) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andBankCodeEqualTo(bankCode);
		return userBankCardDAO.selectByExample(exam);
	}

	/**
	* 根据bankName查询user_bank_card表数据
	*/
	public List<UserBankCardDO> findUserBankCardByBankName(String bankName) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andBankNameEqualTo(bankName);
		return userBankCardDAO.selectByExample(exam);
	}

	/**
	* 根据subBankName查询user_bank_card表数据
	*/
	public List<UserBankCardDO> findUserBankCardBySubBankName(String subBankName) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andSubBankNameEqualTo(subBankName);
		return userBankCardDAO.selectByExample(exam);
	}

    /**
	 * 根据bankBindId查询user_bank_card表数据
	 */
	public List<UserBankCardDO> findUserBankCardByBankBindId(String bankBindId) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andBankBindIdEqualTo(bankBindId);
		return userBankCardDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_bank_card表数据
	 */
	public void updateUserBankCardById(Long id,UserBankCardDO userBankCardDO) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userBankCardDAO.updateByExample(userBankCardDO, exam);
	}

    /**
	 * 根据bizNo更新user_bank_card表数据
	 */
	public void updateUserBankCardByBizNo(String bizNo,UserBankCardDO userBankCardDO) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		userBankCardDAO.updateByExample(userBankCardDO, exam);
	}

    /**
	 * 根据gid更新user_bank_card表数据
	 */
	public void updateUserBankCardByGid(String gid,UserBankCardDO userBankCardDO) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		userBankCardDAO.updateByExample(userBankCardDO, exam);
	}

    /**
	 * 根据reqId更新user_bank_card表数据
	 */
	public void updateUserBankCardByReqId(String reqId,UserBankCardDO userBankCardDO) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		userBankCardDAO.updateByExample(userBankCardDO, exam);
	}

    /**
	 * 根据channelId更新user_bank_card表数据
	 */
	public void updateUserBankCardByChannelId(String channelId,UserBankCardDO userBankCardDO) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		userBankCardDAO.updateByExample(userBankCardDO, exam);
	}

    /**
	 * 根据userId更新user_bank_card表数据
	 */
	public void updateUserBankCardByUserId(String userId,UserBankCardDO userBankCardDO) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userBankCardDAO.updateByExample(userBankCardDO, exam);
	}

    /**
	 * 根据bankCardNo更新user_bank_card表数据
	 */
	public void updateUserBankCardByBankCardNo(String bankCardNo,UserBankCardDO userBankCardDO) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andBankCardNoEqualTo(bankCardNo);
		userBankCardDAO.updateByExample(userBankCardDO, exam);
	}

	/**
	* 根据bankCardName更新user_bank_card表数据
	*/
	public void updateUserBankCardByBankCardName(String bankCardName,UserBankCardDO userBankCardDO) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andBankCardNameEqualTo(bankCardName);
		userBankCardDAO.updateByExample(userBankCardDO, exam);
	}

    /**
	 * 根据bankCardIdcard更新user_bank_card表数据
	 */
	public void updateUserBankCardByBankCardIdcard(String bankCardIdcard,UserBankCardDO userBankCardDO) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andBankCardIdcardEqualTo(bankCardIdcard);
		userBankCardDAO.updateByExample(userBankCardDO, exam);
	}

    /**
	 * 根据certNo更新user_bank_card表数据
	 */
	public void updateUserBankCardByCertNo(String certNo,UserBankCardDO userBankCardDO) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		userBankCardDAO.updateByExample(userBankCardDO, exam);
	}

	/**
	* 根据bankCode更新user_bank_card表数据
	*/
	public void updateUserBankCardByBankCode(String bankCode,UserBankCardDO userBankCardDO) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andBankCodeEqualTo(bankCode);
		userBankCardDAO.updateByExample(userBankCardDO, exam);
	}

	/**
	* 根据bankName更新user_bank_card表数据
	*/
	public void updateUserBankCardByBankName(String bankName,UserBankCardDO userBankCardDO) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andBankNameEqualTo(bankName);
		userBankCardDAO.updateByExample(userBankCardDO, exam);
	}

	/**
	* 根据subBankName更新user_bank_card表数据
	*/
	public void updateUserBankCardBySubBankName(String subBankName,UserBankCardDO userBankCardDO) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andSubBankNameEqualTo(subBankName);
		userBankCardDAO.updateByExample(userBankCardDO, exam);
	}

    /**
	 * 根据bankBindId更新user_bank_card表数据
	 */
	public void updateUserBankCardByBankBindId(String bankBindId,UserBankCardDO userBankCardDO) {
		UserBankCardDOExample exam = new UserBankCardDOExample();
		exam.createCriteria().andBankBindIdEqualTo(bankBindId);
		userBankCardDAO.updateByExample(userBankCardDO, exam);
	}

    /**
	 * 断言user_bank_card_his表
	 */
	public void userBankCardHisAssert(
	        UserBankCardHisDO userBankCardHisDO,
			Long id, 
			String bizNo, 
			String gid, 
			String reqId, 
			String channelId, 
			String userId, 
			String bankCardNo, 
			String bankCardName, 
			String certType, 
			String certNo, 
			String province, 
			String city, 
			String address, 
			String bankAccountType, 
			String bankCardType, 
			String bankCode, 
			String bankKey, 
			String bankBindId, 
			Date bindCardTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userBankCardHisDO.getId());
        assertEquals(bizNo, userBankCardHisDO.getBizNo());
        assertEquals(gid, userBankCardHisDO.getGid());
        assertEquals(reqId, userBankCardHisDO.getReqId());
        assertEquals(channelId, userBankCardHisDO.getChannelId());
        assertEquals(userId, userBankCardHisDO.getUserId());
        assertEquals(bankCardNo, userBankCardHisDO.getBankCardNo());
        assertEquals(bankCardName, userBankCardHisDO.getBankCardName());
        assertEquals(certType, userBankCardHisDO.getCertType());
        assertEquals(certNo, userBankCardHisDO.getCertNo());
        assertEquals(province, userBankCardHisDO.getProvince());
        assertEquals(city, userBankCardHisDO.getCity());
        assertEquals(address, userBankCardHisDO.getAddress());
        assertEquals(bankAccountType, userBankCardHisDO.getBankAccountType());
        assertEquals(bankCardType, userBankCardHisDO.getBankCardType());
        assertEquals(bankCode, userBankCardHisDO.getBankCode());
        assertEquals(bankKey, userBankCardHisDO.getBankKey());
        assertEquals(bankBindId, userBankCardHisDO.getBankBindId());
        assertEquals(bindCardTime, userBankCardHisDO.getBindCardTime());
        assertEquals(rawAddTime, userBankCardHisDO.getRawAddTime());
        assertEquals(rawUpdateTime, userBankCardHisDO.getRawUpdateTime());
	}

	/**
	 * 断言user_bank_card_his表数据
	 */
	public void assertUserBankCardHis(UserBankCardHisDO expect, UserBankCardHisDO userBankCardHisDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userBankCardHisDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userBankCardHisDO.getRawAddTime());
		expect.setRawAddTime(userBankCardHisDO.getRawAddTime());
        Assertions.assertTrue(null != userBankCardHisDO.getRawUpdateTime());
		expect.setRawUpdateTime(userBankCardHisDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userBankCardHisDO);
	}

    /**
	 * 插入user_bank_card_his表数据
	 */
	public void insertUserBankCardHis(UserBankCardHisDO userBankCardHisDO) {
		userBankCardHisDAO.insert(userBankCardHisDO);
	}

    /**
	 * 插入user_bank_card_his表数据
	 */
	public void insertUserBankCardHis(
			Long id, 
			String bizNo, 
			String gid, 
			String reqId, 
			String channelId, 
			String userId, 
			String bankCardNo, 
			String bankCardName, 
			String certType, 
			String certNo, 
			String province, 
			String city, 
			String address, 
			String bankAccountType, 
			String bankCardType, 
			String bankCode, 
			String bankKey, 
			String bankBindId, 
			Date bindCardTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (bindCardTime == null) {
			bindCardTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		UserBankCardHisDO userBankCardHisDO = new UserBankCardHisDO();
		userBankCardHisDO.setId(id);
		userBankCardHisDO.setBizNo(bizNo);
		userBankCardHisDO.setGid(gid);
		userBankCardHisDO.setReqId(reqId);
		userBankCardHisDO.setChannelId(channelId);
		userBankCardHisDO.setUserId(userId);
		userBankCardHisDO.setBankCardNo(bankCardNo);
		userBankCardHisDO.setBankCardName(bankCardName);
		userBankCardHisDO.setCertType(certType);
		userBankCardHisDO.setCertNo(certNo);
		userBankCardHisDO.setProvince(province);
		userBankCardHisDO.setCity(city);
		userBankCardHisDO.setAddress(address);
		userBankCardHisDO.setBankAccountType(bankAccountType);
		userBankCardHisDO.setBankCardType(bankCardType);
		userBankCardHisDO.setBankCode(bankCode);
		userBankCardHisDO.setBankKey(bankKey);
		userBankCardHisDO.setBankBindId(bankBindId);
		userBankCardHisDO.setBindCardTime(bindCardTime);
		userBankCardHisDO.setRawAddTime(rawAddTime);
		userBankCardHisDO.setRawUpdateTime(rawUpdateTime);
		userBankCardHisDAO.insert(userBankCardHisDO);
	}

    /**
     * 删除user_bank_card_his表所有数据
     */
    public void cleanUserBankCardHis() {
        UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
        exam.createCriteria();
        userBankCardHisDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_bank_card_his表数据
	 */
	public void cleanUserBankCardHisById(Long id) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userBankCardHisDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除user_bank_card_his表数据
	 */
	public void cleanUserBankCardHisByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		userBankCardHisDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除user_bank_card_his表数据
	 */
	public void cleanUserBankCardHisByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		userBankCardHisDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除user_bank_card_his表数据
	 */
	public void cleanUserBankCardHisByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		userBankCardHisDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除user_bank_card_his表数据
	 */
	public void cleanUserBankCardHisByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		userBankCardHisDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除user_bank_card_his表数据
	 */
	public void cleanUserBankCardHisByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userBankCardHisDAO.deleteByExample(exam);
	}

	/**
	 * 根据bankCardNo删除user_bank_card_his表数据
	 */
	public void cleanUserBankCardHisByBankCardNo(String bankCardNo) {
        if (StringUtils.isBlank(bankCardNo)){
            bankCardNo = "test_bankCardNo";
        }
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andBankCardNoEqualTo(bankCardNo);
		userBankCardHisDAO.deleteByExample(exam);
	}

	/**
	* 根据bankCardName删除user_bank_card_his表数据
	*/
	public void cleanUserBankCardHisByBankCardName(String bankCardName) {
        if (StringUtils.isBlank(bankCardName)){
            bankCardName = "test_bankCardName";
        }
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andBankCardNameEqualTo(bankCardName);
		userBankCardHisDAO.deleteByExample(exam);
	}

	/**
	 * 根据certNo删除user_bank_card_his表数据
	 */
	public void cleanUserBankCardHisByCertNo(String certNo) {
        if (StringUtils.isBlank(certNo)){
            certNo = "test_certNo";
        }
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		userBankCardHisDAO.deleteByExample(exam);
	}

	/**
	* 根据bankCode删除user_bank_card_his表数据
	*/
	public void cleanUserBankCardHisByBankCode(String bankCode) {
        if (StringUtils.isBlank(bankCode)){
            bankCode = "test_bankCode";
        }
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andBankCodeEqualTo(bankCode);
		userBankCardHisDAO.deleteByExample(exam);
	}

	/**
	 * 根据bankBindId删除user_bank_card_his表数据
	 */
	public void cleanUserBankCardHisByBankBindId(String bankBindId) {
        if (StringUtils.isBlank(bankBindId)){
            bankBindId = "test_bankBindId";
        }
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andBankBindIdEqualTo(bankBindId);
		userBankCardHisDAO.deleteByExample(exam);
	}

    /**
     * 查询user_bank_card_his表所有数据
     */
    public List<UserBankCardHisDO> findUserBankCardHisAll() {
        UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
        exam.createCriteria();
		return userBankCardHisDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_bank_card_his表数据
	 */
	public List<UserBankCardHisDO> findUserBankCardHisById(Long id) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userBankCardHisDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询user_bank_card_his表数据
	 */
	public List<UserBankCardHisDO> findUserBankCardHisByBizNo(String bizNo) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return userBankCardHisDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询user_bank_card_his表数据
	 */
	public List<UserBankCardHisDO> findUserBankCardHisByGid(String gid) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return userBankCardHisDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询user_bank_card_his表数据
	 */
	public List<UserBankCardHisDO> findUserBankCardHisByReqId(String reqId) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return userBankCardHisDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询user_bank_card_his表数据
	 */
	public List<UserBankCardHisDO> findUserBankCardHisByChannelId(String channelId) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return userBankCardHisDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询user_bank_card_his表数据
	 */
	public List<UserBankCardHisDO> findUserBankCardHisByUserId(String userId) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return userBankCardHisDAO.selectByExample(exam);
	}

    /**
	 * 根据bankCardNo查询user_bank_card_his表数据
	 */
	public List<UserBankCardHisDO> findUserBankCardHisByBankCardNo(String bankCardNo) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andBankCardNoEqualTo(bankCardNo);
		return userBankCardHisDAO.selectByExample(exam);
	}

	/**
	* 根据bankCardName查询user_bank_card_his表数据
	*/
	public List<UserBankCardHisDO> findUserBankCardHisByBankCardName(String bankCardName) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andBankCardNameEqualTo(bankCardName);
		return userBankCardHisDAO.selectByExample(exam);
	}

    /**
	 * 根据certNo查询user_bank_card_his表数据
	 */
	public List<UserBankCardHisDO> findUserBankCardHisByCertNo(String certNo) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		return userBankCardHisDAO.selectByExample(exam);
	}

	/**
	* 根据bankCode查询user_bank_card_his表数据
	*/
	public List<UserBankCardHisDO> findUserBankCardHisByBankCode(String bankCode) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andBankCodeEqualTo(bankCode);
		return userBankCardHisDAO.selectByExample(exam);
	}

    /**
	 * 根据bankBindId查询user_bank_card_his表数据
	 */
	public List<UserBankCardHisDO> findUserBankCardHisByBankBindId(String bankBindId) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andBankBindIdEqualTo(bankBindId);
		return userBankCardHisDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_bank_card_his表数据
	 */
	public void updateUserBankCardHisById(Long id,UserBankCardHisDO userBankCardHisDO) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userBankCardHisDAO.updateByExample(userBankCardHisDO, exam);
	}

    /**
	 * 根据bizNo更新user_bank_card_his表数据
	 */
	public void updateUserBankCardHisByBizNo(String bizNo,UserBankCardHisDO userBankCardHisDO) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		userBankCardHisDAO.updateByExample(userBankCardHisDO, exam);
	}

    /**
	 * 根据gid更新user_bank_card_his表数据
	 */
	public void updateUserBankCardHisByGid(String gid,UserBankCardHisDO userBankCardHisDO) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		userBankCardHisDAO.updateByExample(userBankCardHisDO, exam);
	}

    /**
	 * 根据reqId更新user_bank_card_his表数据
	 */
	public void updateUserBankCardHisByReqId(String reqId,UserBankCardHisDO userBankCardHisDO) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		userBankCardHisDAO.updateByExample(userBankCardHisDO, exam);
	}

    /**
	 * 根据channelId更新user_bank_card_his表数据
	 */
	public void updateUserBankCardHisByChannelId(String channelId,UserBankCardHisDO userBankCardHisDO) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		userBankCardHisDAO.updateByExample(userBankCardHisDO, exam);
	}

    /**
	 * 根据userId更新user_bank_card_his表数据
	 */
	public void updateUserBankCardHisByUserId(String userId,UserBankCardHisDO userBankCardHisDO) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userBankCardHisDAO.updateByExample(userBankCardHisDO, exam);
	}

    /**
	 * 根据bankCardNo更新user_bank_card_his表数据
	 */
	public void updateUserBankCardHisByBankCardNo(String bankCardNo,UserBankCardHisDO userBankCardHisDO) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andBankCardNoEqualTo(bankCardNo);
		userBankCardHisDAO.updateByExample(userBankCardHisDO, exam);
	}

	/**
	* 根据bankCardName更新user_bank_card_his表数据
	*/
	public void updateUserBankCardHisByBankCardName(String bankCardName,UserBankCardHisDO userBankCardHisDO) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andBankCardNameEqualTo(bankCardName);
		userBankCardHisDAO.updateByExample(userBankCardHisDO, exam);
	}

    /**
	 * 根据certNo更新user_bank_card_his表数据
	 */
	public void updateUserBankCardHisByCertNo(String certNo,UserBankCardHisDO userBankCardHisDO) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		userBankCardHisDAO.updateByExample(userBankCardHisDO, exam);
	}

	/**
	* 根据bankCode更新user_bank_card_his表数据
	*/
	public void updateUserBankCardHisByBankCode(String bankCode,UserBankCardHisDO userBankCardHisDO) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andBankCodeEqualTo(bankCode);
		userBankCardHisDAO.updateByExample(userBankCardHisDO, exam);
	}

    /**
	 * 根据bankBindId更新user_bank_card_his表数据
	 */
	public void updateUserBankCardHisByBankBindId(String bankBindId,UserBankCardHisDO userBankCardHisDO) {
		UserBankCardHisDOExample exam = new UserBankCardHisDOExample();
		exam.createCriteria().andBankBindIdEqualTo(bankBindId);
		userBankCardHisDAO.updateByExample(userBankCardHisDO, exam);
	}

    /**
	 * 断言user表
	 */
	public void userAssert(
	        UserDO userDO,
			Long id, 
			String userId, 
			String merchantUserId, 
			String parentUserId, 
			String platPartnerId, 
			String userName, 
			String payPassword, 
			String registerFrom, 
			String userType, 
			String userStatus, 
			String certifyStatus, 
			String realName, 
			String certType, 
			String certNo, 
			String registerIp, 
			String country, 
			String province, 
			String city, 
			String district, 
			String address, 
			String phone, 
			String mobile, 
			String zipCode, 
			String memo, 
			String customerId, 
			String partnerId, 
			String merchantMode, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userDO.getId());
        assertEquals(userId, userDO.getUserId());
        assertEquals(merchantUserId, userDO.getMerchantUserId());
        assertEquals(parentUserId, userDO.getParentUserId());
        assertEquals(platPartnerId, userDO.getPlatPartnerId());
        assertEquals(userName, userDO.getUserName());
        assertEquals(payPassword, userDO.getPayPassword());
        assertEquals(registerFrom, userDO.getRegisterFrom());
        assertEquals(userType, userDO.getUserType());
        assertEquals(userStatus, userDO.getUserStatus());
        assertEquals(certifyStatus, userDO.getCertifyStatus());
        assertEquals(realName, userDO.getRealName());
        assertEquals(certType, userDO.getCertType());
        assertEquals(certNo, userDO.getCertNo());
        assertEquals(registerIp, userDO.getRegisterIp());
        assertEquals(country, userDO.getCountry());
        assertEquals(province, userDO.getProvince());
        assertEquals(city, userDO.getCity());
        assertEquals(district, userDO.getDistrict());
        assertEquals(address, userDO.getAddress());
        assertEquals(phone, userDO.getPhone());
        assertEquals(mobile, userDO.getMobile());
        assertEquals(zipCode, userDO.getZipCode());
        assertEquals(memo, userDO.getMemo());
        assertEquals(customerId, userDO.getCustomerId());
        assertEquals(partnerId, userDO.getPartnerId());
        assertEquals(merchantMode, userDO.getMerchantMode());
        assertEquals(rawAddTime, userDO.getRawAddTime());
        assertEquals(rawUpdateTime, userDO.getRawUpdateTime());
	}

	/**
	 * 断言user表数据
	 */
	public void assertUser(UserDO expect, UserDO userDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userDO.getRawAddTime());
		expect.setRawAddTime(userDO.getRawAddTime());
        Assertions.assertTrue(null != userDO.getRawUpdateTime());
		expect.setRawUpdateTime(userDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userDO);
	}

    /**
	 * 插入user表数据
	 */
	public void insertUser(UserDO userDO) {
		userDAO.insert(userDO);
	}

    /**
	 * 插入user表数据
	 */
	public void insertUser(
			Long id, 
			String userId, 
			String merchantUserId, 
			String parentUserId, 
			String platPartnerId, 
			String userName, 
			String payPassword, 
			String registerFrom, 
			String userType, 
			String userStatus, 
			String certifyStatus, 
			String realName, 
			String certType, 
			String certNo, 
			String registerIp, 
			String country, 
			String province, 
			String city, 
			String district, 
			String address, 
			String phone, 
			String mobile, 
			String zipCode, 
			String memo, 
			String customerId, 
			String partnerId, 
			String merchantMode, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		UserDO userDO = new UserDO();
		userDO.setId(id);
		userDO.setUserId(userId);
		userDO.setMerchantUserId(merchantUserId);
		userDO.setParentUserId(parentUserId);
		userDO.setPlatPartnerId(platPartnerId);
		userDO.setUserName(userName);
		userDO.setPayPassword(payPassword);
		userDO.setRegisterFrom(registerFrom);
		userDO.setUserType(userType);
		userDO.setUserStatus(userStatus);
		userDO.setCertifyStatus(certifyStatus);
		userDO.setRealName(realName);
		userDO.setCertType(certType);
		userDO.setCertNo(certNo);
		userDO.setRegisterIp(registerIp);
		userDO.setCountry(country);
		userDO.setProvince(province);
		userDO.setCity(city);
		userDO.setDistrict(district);
		userDO.setAddress(address);
		userDO.setPhone(phone);
		userDO.setMobile(mobile);
		userDO.setZipCode(zipCode);
		userDO.setMemo(memo);
		userDO.setCustomerId(customerId);
		userDO.setPartnerId(partnerId);
		userDO.setMerchantMode(merchantMode);
		userDO.setRawAddTime(rawAddTime);
		userDO.setRawUpdateTime(rawUpdateTime);
		userDAO.insert(userDO);
	}

    /**
     * 删除user表所有数据
     */
    public void cleanUser() {
        UserDOExample exam = new UserDOExample();
        exam.createCriteria();
        userDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user表数据
	 */
	public void cleanUserById(Long id) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除user表数据
	 */
	public void cleanUserByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantUserId删除user表数据
	 */
	public void cleanUserByMerchantUserId(String merchantUserId) {
        if (StringUtils.isBlank(merchantUserId)){
            merchantUserId = "test_merchantUserId";
        }
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andMerchantUserIdEqualTo(merchantUserId);
		userDAO.deleteByExample(exam);
	}

	/**
	 * 根据parentUserId删除user表数据
	 */
	public void cleanUserByParentUserId(String parentUserId) {
        if (StringUtils.isBlank(parentUserId)){
            parentUserId = "test_parentUserId";
        }
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andParentUserIdEqualTo(parentUserId);
		userDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除user表数据
	 */
	public void cleanUserByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		userDAO.deleteByExample(exam);
	}

	/**
	* 根据userName删除user表数据
	*/
	public void cleanUserByUserName(String userName) {
        if (StringUtils.isBlank(userName)){
            userName = "test_userName";
        }
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		userDAO.deleteByExample(exam);
	}

	/**
	* 根据realName删除user表数据
	*/
	public void cleanUserByRealName(String realName) {
        if (StringUtils.isBlank(realName)){
            realName = "test_realName";
        }
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		userDAO.deleteByExample(exam);
	}

	/**
	 * 根据certNo删除user表数据
	 */
	public void cleanUserByCertNo(String certNo) {
        if (StringUtils.isBlank(certNo)){
            certNo = "test_certNo";
        }
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		userDAO.deleteByExample(exam);
	}

	/**
	 * 根据mobile删除user表数据
	 */
	public void cleanUserByMobile(String mobile) {
        if (StringUtils.isBlank(mobile)){
            mobile = "test_mobile";
        }
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		userDAO.deleteByExample(exam);
	}

	/**
	* 根据zipCode删除user表数据
	*/
	public void cleanUserByZipCode(String zipCode) {
        if (StringUtils.isBlank(zipCode)){
            zipCode = "test_zipCode";
        }
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andZipCodeEqualTo(zipCode);
		userDAO.deleteByExample(exam);
	}

	/**
	 * 根据customerId删除user表数据
	 */
	public void cleanUserByCustomerId(String customerId) {
        if (StringUtils.isBlank(customerId)){
            customerId = "test_customerId";
        }
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andCustomerIdEqualTo(customerId);
		userDAO.deleteByExample(exam);
	}
	/**
	 * 根据partnerId,mobile删除user表数据
	 */
	public void cleanUserByPartnerIdAndMobile(String partnerId,String mobile) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
        if (StringUtils.isBlank(mobile)){
            mobile = "test_mobile";
        }
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId).andMobileEqualTo(mobile);
		userDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除user表数据
	 */
	public void cleanUserByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userDAO.deleteByExample(exam);
	}

    /**
     * 查询user表所有数据
     */
    public List<UserDO> findUserAll() {
        UserDOExample exam = new UserDOExample();
        exam.createCriteria();
		return userDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user表数据
	 */
	public List<UserDO> findUserById(Long id) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询user表数据
	 */
	public List<UserDO> findUserByUserId(String userId) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return userDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantUserId查询user表数据
	 */
	public List<UserDO> findUserByMerchantUserId(String merchantUserId) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andMerchantUserIdEqualTo(merchantUserId);
		return userDAO.selectByExample(exam);
	}

    /**
	 * 根据parentUserId查询user表数据
	 */
	public List<UserDO> findUserByParentUserId(String parentUserId) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andParentUserIdEqualTo(parentUserId);
		return userDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询user表数据
	 */
	public List<UserDO> findUserByPlatPartnerId(String platPartnerId) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return userDAO.selectByExample(exam);
	}

	/**
	* 根据userName查询user表数据
	*/
	public List<UserDO> findUserByUserName(String userName) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		return userDAO.selectByExample(exam);
	}

	/**
	* 根据realName查询user表数据
	*/
	public List<UserDO> findUserByRealName(String realName) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		return userDAO.selectByExample(exam);
	}

    /**
	 * 根据certNo查询user表数据
	 */
	public List<UserDO> findUserByCertNo(String certNo) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		return userDAO.selectByExample(exam);
	}

    /**
	 * 根据mobile查询user表数据
	 */
	public List<UserDO> findUserByMobile(String mobile) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		return userDAO.selectByExample(exam);
	}

	/**
	* 根据zipCode查询user表数据
	*/
	public List<UserDO> findUserByZipCode(String zipCode) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andZipCodeEqualTo(zipCode);
		return userDAO.selectByExample(exam);
	}

    /**
	 * 根据customerId查询user表数据
	 */
	public List<UserDO> findUserByCustomerId(String customerId) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andCustomerIdEqualTo(customerId);
		return userDAO.selectByExample(exam);
	}

	/**
	 * 根据partnerId,mobile查询user表数据
	 */
	public List<UserDO> findUserByPartnerIdAndMobile(String partnerId,String mobile) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId).andMobileEqualTo(mobile);
		return userDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询user表数据
	 */
	public List<UserDO> findUserByPartnerId(String partnerId) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return userDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user表数据
	 */
	public void updateUserById(Long id,UserDO userDO) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userDAO.updateByExample(userDO, exam);
	}

    /**
	 * 根据userId更新user表数据
	 */
	public void updateUserByUserId(String userId,UserDO userDO) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userDAO.updateByExample(userDO, exam);
	}

    /**
	 * 根据merchantUserId更新user表数据
	 */
	public void updateUserByMerchantUserId(String merchantUserId,UserDO userDO) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andMerchantUserIdEqualTo(merchantUserId);
		userDAO.updateByExample(userDO, exam);
	}

    /**
	 * 根据parentUserId更新user表数据
	 */
	public void updateUserByParentUserId(String parentUserId,UserDO userDO) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andParentUserIdEqualTo(parentUserId);
		userDAO.updateByExample(userDO, exam);
	}

    /**
	 * 根据platPartnerId更新user表数据
	 */
	public void updateUserByPlatPartnerId(String platPartnerId,UserDO userDO) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		userDAO.updateByExample(userDO, exam);
	}

	/**
	* 根据userName更新user表数据
	*/
	public void updateUserByUserName(String userName,UserDO userDO) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		userDAO.updateByExample(userDO, exam);
	}

	/**
	* 根据realName更新user表数据
	*/
	public void updateUserByRealName(String realName,UserDO userDO) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		userDAO.updateByExample(userDO, exam);
	}

    /**
	 * 根据certNo更新user表数据
	 */
	public void updateUserByCertNo(String certNo,UserDO userDO) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andCertNoEqualTo(certNo);
		userDAO.updateByExample(userDO, exam);
	}

    /**
	 * 根据mobile更新user表数据
	 */
	public void updateUserByMobile(String mobile,UserDO userDO) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		userDAO.updateByExample(userDO, exam);
	}

	/**
	* 根据zipCode更新user表数据
	*/
	public void updateUserByZipCode(String zipCode,UserDO userDO) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andZipCodeEqualTo(zipCode);
		userDAO.updateByExample(userDO, exam);
	}

    /**
	 * 根据customerId更新user表数据
	 */
	public void updateUserByCustomerId(String customerId,UserDO userDO) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andCustomerIdEqualTo(customerId);
		userDAO.updateByExample(userDO, exam);
	}

	/**
	 * 根据partnerId,mobile更新user表数据
	 */
	public void updateUserByPartnerIdAndMobile(String partnerId,String mobile,UserDO userDO) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId).andMobileEqualTo(mobile);
		userDAO.updateByExample(userDO, exam);
	}

    /**
	 * 根据partnerId更新user表数据
	 */
	public void updateUserByPartnerId(String partnerId,UserDO userDO) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userDAO.updateByExample(userDO, exam);
	}

    /**
	 * 断言user_days_statistics表
	 */
	public void userDaysStatisticsAssert(
	        UserDaysStatisticsDO userDaysStatisticsDO,
			Long id, 
			Date days, 
			String partnerId, 
			String platPartnerId, 
			Long balanceAmount, 
			Long freezeAmount, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userDaysStatisticsDO.getId());
        assertEquals(days, userDaysStatisticsDO.getDays());
        assertEquals(partnerId, userDaysStatisticsDO.getPartnerId());
        assertEquals(platPartnerId, userDaysStatisticsDO.getPlatPartnerId());
        assertEquals(balanceAmount, userDaysStatisticsDO.getBalanceAmount());
        assertEquals(freezeAmount, userDaysStatisticsDO.getFreezeAmount());
        assertEquals(rawAddTime, userDaysStatisticsDO.getRawAddTime());
        assertEquals(rawUpdateTime, userDaysStatisticsDO.getRawUpdateTime());
	}

	/**
	 * 断言user_days_statistics表数据
	 */
	public void assertUserDaysStatistics(UserDaysStatisticsDO expect, UserDaysStatisticsDO userDaysStatisticsDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userDaysStatisticsDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userDaysStatisticsDO.getRawAddTime());
		expect.setRawAddTime(userDaysStatisticsDO.getRawAddTime());
        Assertions.assertTrue(null != userDaysStatisticsDO.getRawUpdateTime());
		expect.setRawUpdateTime(userDaysStatisticsDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userDaysStatisticsDO);
	}

    /**
	 * 插入user_days_statistics表数据
	 */
	public void insertUserDaysStatistics(UserDaysStatisticsDO userDaysStatisticsDO) {
		userDaysStatisticsDAO.insert(userDaysStatisticsDO);
	}

    /**
	 * 插入user_days_statistics表数据
	 */
	public void insertUserDaysStatistics(
			Long id, 
			Date days, 
			String partnerId, 
			String platPartnerId, 
			Long balanceAmount, 
			Long freezeAmount, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (days == null) {
			days = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		UserDaysStatisticsDO userDaysStatisticsDO = new UserDaysStatisticsDO();
		userDaysStatisticsDO.setId(id);
		userDaysStatisticsDO.setDays(days);
		userDaysStatisticsDO.setPartnerId(partnerId);
		userDaysStatisticsDO.setPlatPartnerId(platPartnerId);
		userDaysStatisticsDO.setBalanceAmount(balanceAmount);
		userDaysStatisticsDO.setFreezeAmount(freezeAmount);
		userDaysStatisticsDO.setRawAddTime(rawAddTime);
		userDaysStatisticsDO.setRawUpdateTime(rawUpdateTime);
		userDaysStatisticsDAO.insert(userDaysStatisticsDO);
	}

    /**
     * 删除user_days_statistics表所有数据
     */
    public void cleanUserDaysStatistics() {
        UserDaysStatisticsDOExample exam = new UserDaysStatisticsDOExample();
        exam.createCriteria();
        userDaysStatisticsDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_days_statistics表数据
	 */
	public void cleanUserDaysStatisticsById(Long id) {
		UserDaysStatisticsDOExample exam = new UserDaysStatisticsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userDaysStatisticsDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除user_days_statistics表数据
	 */
	public void cleanUserDaysStatisticsByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		UserDaysStatisticsDOExample exam = new UserDaysStatisticsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userDaysStatisticsDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除user_days_statistics表数据
	 */
	public void cleanUserDaysStatisticsByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		UserDaysStatisticsDOExample exam = new UserDaysStatisticsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		userDaysStatisticsDAO.deleteByExample(exam);
	}

    /**
     * 查询user_days_statistics表所有数据
     */
    public List<UserDaysStatisticsDO> findUserDaysStatisticsAll() {
        UserDaysStatisticsDOExample exam = new UserDaysStatisticsDOExample();
        exam.createCriteria();
		return userDaysStatisticsDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_days_statistics表数据
	 */
	public List<UserDaysStatisticsDO> findUserDaysStatisticsById(Long id) {
		UserDaysStatisticsDOExample exam = new UserDaysStatisticsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userDaysStatisticsDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询user_days_statistics表数据
	 */
	public List<UserDaysStatisticsDO> findUserDaysStatisticsByPartnerId(String partnerId) {
		UserDaysStatisticsDOExample exam = new UserDaysStatisticsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return userDaysStatisticsDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询user_days_statistics表数据
	 */
	public List<UserDaysStatisticsDO> findUserDaysStatisticsByPlatPartnerId(String platPartnerId) {
		UserDaysStatisticsDOExample exam = new UserDaysStatisticsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return userDaysStatisticsDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_days_statistics表数据
	 */
	public void updateUserDaysStatisticsById(Long id,UserDaysStatisticsDO userDaysStatisticsDO) {
		UserDaysStatisticsDOExample exam = new UserDaysStatisticsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userDaysStatisticsDAO.updateByExample(userDaysStatisticsDO, exam);
	}

    /**
	 * 根据partnerId更新user_days_statistics表数据
	 */
	public void updateUserDaysStatisticsByPartnerId(String partnerId,UserDaysStatisticsDO userDaysStatisticsDO) {
		UserDaysStatisticsDOExample exam = new UserDaysStatisticsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userDaysStatisticsDAO.updateByExample(userDaysStatisticsDO, exam);
	}

    /**
	 * 根据platPartnerId更新user_days_statistics表数据
	 */
	public void updateUserDaysStatisticsByPlatPartnerId(String platPartnerId,UserDaysStatisticsDO userDaysStatisticsDO) {
		UserDaysStatisticsDOExample exam = new UserDaysStatisticsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		userDaysStatisticsDAO.updateByExample(userDaysStatisticsDO, exam);
	}

    /**
	 * 断言user_notify_task表
	 */
	public void userNotifyTaskAssert(
	        UserNotifyTaskDO userNotifyTaskDO,
			Long id, 
			String reqId, 
			String gid, 
			String partnerId, 
			String status, 
			String notifyCategory, 
			String notifyType, 
			Integer retryCount, 
			Integer maxRetryCount, 
			String notifyGroup, 
			String notifyVersion, 
			String notifyUrl, 
			String detail, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userNotifyTaskDO.getId());
        assertEquals(reqId, userNotifyTaskDO.getReqId());
        assertEquals(gid, userNotifyTaskDO.getGid());
        assertEquals(partnerId, userNotifyTaskDO.getPartnerId());
        assertEquals(status, userNotifyTaskDO.getStatus());
        assertEquals(notifyCategory, userNotifyTaskDO.getNotifyCategory());
        assertEquals(notifyType, userNotifyTaskDO.getNotifyType());
        assertEquals(retryCount, userNotifyTaskDO.getRetryCount());
        assertEquals(maxRetryCount, userNotifyTaskDO.getMaxRetryCount());
        assertEquals(notifyGroup, userNotifyTaskDO.getNotifyGroup());
        assertEquals(notifyVersion, userNotifyTaskDO.getNotifyVersion());
        assertEquals(notifyUrl, userNotifyTaskDO.getNotifyUrl());
        assertEquals(detail, userNotifyTaskDO.getDetail());
        assertEquals(rawAddTime, userNotifyTaskDO.getRawAddTime());
        assertEquals(rawUpdateTime, userNotifyTaskDO.getRawUpdateTime());
	}

	/**
	 * 断言user_notify_task表数据
	 */
	public void assertUserNotifyTask(UserNotifyTaskDO expect, UserNotifyTaskDO userNotifyTaskDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userNotifyTaskDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userNotifyTaskDO.getRawAddTime());
		expect.setRawAddTime(userNotifyTaskDO.getRawAddTime());
        Assertions.assertTrue(null != userNotifyTaskDO.getRawUpdateTime());
		expect.setRawUpdateTime(userNotifyTaskDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userNotifyTaskDO);
	}

    /**
	 * 插入user_notify_task表数据
	 */
	public void insertUserNotifyTask(UserNotifyTaskDO userNotifyTaskDO) {
		userNotifyTaskDAO.insert(userNotifyTaskDO);
	}

    /**
	 * 插入user_notify_task表数据
	 */
	public void insertUserNotifyTask(
			Long id, 
			String reqId, 
			String gid, 
			String partnerId, 
			String status, 
			String notifyCategory, 
			String notifyType, 
			Integer retryCount, 
			Integer maxRetryCount, 
			String notifyGroup, 
			String notifyVersion, 
			String notifyUrl, 
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
		UserNotifyTaskDO userNotifyTaskDO = new UserNotifyTaskDO();
		userNotifyTaskDO.setId(id);
		userNotifyTaskDO.setReqId(reqId);
		userNotifyTaskDO.setGid(gid);
		userNotifyTaskDO.setPartnerId(partnerId);
		userNotifyTaskDO.setStatus(status);
		userNotifyTaskDO.setNotifyCategory(notifyCategory);
		userNotifyTaskDO.setNotifyType(notifyType);
		userNotifyTaskDO.setRetryCount(retryCount);
		userNotifyTaskDO.setMaxRetryCount(maxRetryCount);
		userNotifyTaskDO.setNotifyGroup(notifyGroup);
		userNotifyTaskDO.setNotifyVersion(notifyVersion);
		userNotifyTaskDO.setNotifyUrl(notifyUrl);
		userNotifyTaskDO.setDetail(detail);
		userNotifyTaskDO.setRawAddTime(rawAddTime);
		userNotifyTaskDO.setRawUpdateTime(rawUpdateTime);
		userNotifyTaskDAO.insert(userNotifyTaskDO);
	}

    /**
     * 删除user_notify_task表所有数据
     */
    public void cleanUserNotifyTask() {
        UserNotifyTaskDOExample exam = new UserNotifyTaskDOExample();
        exam.createCriteria();
        userNotifyTaskDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_notify_task表数据
	 */
	public void cleanUserNotifyTaskById(Long id) {
		UserNotifyTaskDOExample exam = new UserNotifyTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userNotifyTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除user_notify_task表数据
	 */
	public void cleanUserNotifyTaskByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		UserNotifyTaskDOExample exam = new UserNotifyTaskDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		userNotifyTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除user_notify_task表数据
	 */
	public void cleanUserNotifyTaskByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		UserNotifyTaskDOExample exam = new UserNotifyTaskDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		userNotifyTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除user_notify_task表数据
	 */
	public void cleanUserNotifyTaskByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		UserNotifyTaskDOExample exam = new UserNotifyTaskDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userNotifyTaskDAO.deleteByExample(exam);
	}

    /**
     * 查询user_notify_task表所有数据
     */
    public List<UserNotifyTaskDO> findUserNotifyTaskAll() {
        UserNotifyTaskDOExample exam = new UserNotifyTaskDOExample();
        exam.createCriteria();
		return userNotifyTaskDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_notify_task表数据
	 */
	public List<UserNotifyTaskDO> findUserNotifyTaskById(Long id) {
		UserNotifyTaskDOExample exam = new UserNotifyTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userNotifyTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询user_notify_task表数据
	 */
	public List<UserNotifyTaskDO> findUserNotifyTaskByReqId(String reqId) {
		UserNotifyTaskDOExample exam = new UserNotifyTaskDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return userNotifyTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询user_notify_task表数据
	 */
	public List<UserNotifyTaskDO> findUserNotifyTaskByGid(String gid) {
		UserNotifyTaskDOExample exam = new UserNotifyTaskDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return userNotifyTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询user_notify_task表数据
	 */
	public List<UserNotifyTaskDO> findUserNotifyTaskByPartnerId(String partnerId) {
		UserNotifyTaskDOExample exam = new UserNotifyTaskDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return userNotifyTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_notify_task表数据
	 */
	public void updateUserNotifyTaskById(Long id,UserNotifyTaskDO userNotifyTaskDO) {
		UserNotifyTaskDOExample exam = new UserNotifyTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userNotifyTaskDAO.updateByExample(userNotifyTaskDO, exam);
	}

    /**
	 * 根据reqId更新user_notify_task表数据
	 */
	public void updateUserNotifyTaskByReqId(String reqId,UserNotifyTaskDO userNotifyTaskDO) {
		UserNotifyTaskDOExample exam = new UserNotifyTaskDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		userNotifyTaskDAO.updateByExample(userNotifyTaskDO, exam);
	}

    /**
	 * 根据gid更新user_notify_task表数据
	 */
	public void updateUserNotifyTaskByGid(String gid,UserNotifyTaskDO userNotifyTaskDO) {
		UserNotifyTaskDOExample exam = new UserNotifyTaskDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		userNotifyTaskDAO.updateByExample(userNotifyTaskDO, exam);
	}

    /**
	 * 根据partnerId更新user_notify_task表数据
	 */
	public void updateUserNotifyTaskByPartnerId(String partnerId,UserNotifyTaskDO userNotifyTaskDO) {
		UserNotifyTaskDOExample exam = new UserNotifyTaskDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userNotifyTaskDAO.updateByExample(userNotifyTaskDO, exam);
	}
}
