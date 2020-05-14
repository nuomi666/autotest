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
import dal.dao.shelluser.*;
import dal.model.shelluser.*;
import com.xjy.autotest.config.ShelluserDataSourceConfig;

/**
 * @author autotest
 * Created on 2019/08/01.
 */
@Service
@Import({
        ShelluserDataSourceConfig.class
})
public class ShelluserTestBase extends AutoTestBase{

	@Autowired
	NotifyTaskDAO notifyTaskDAO;

	@Autowired
	UserCarInfoDAO userCarInfoDAO;

	@Autowired
	UserCardInfoDAO userCardInfoDAO;

	@Autowired
	UserChangeMessageTaskDAO userChangeMessageTaskDAO;

	@Autowired
	UserDAO userDAO;

	@Autowired
	UserFollowWeChatInfoDAO userFollowWeChatInfoDAO;

	@Autowired
	UserIntegralResetRuleDAO userIntegralResetRuleDAO;

	@Autowired
	UserIntegralResetTaskDAO userIntegralResetTaskDAO;

	@Autowired
	UserInviteLogDAO userInviteLogDAO;

	@Autowired
	UserLabelDAO userLabelDAO;

	@Autowired
	UserLevelRuleDAO userLevelRuleDAO;

	@Autowired
	UserLevelTaskDAO userLevelTaskDAO;

	@Autowired
	UserLevelUpdFailDAO userLevelUpdFailDAO;

	@Autowired
	UserPayToolInfoDAO userPayToolInfoDAO;

	@Autowired
	UserSpreadLogDAO userSpreadLogDAO;

	public NotifyTaskDAO getNotifyTaskDAO() {
		return this.notifyTaskDAO;
	}

	public UserCarInfoDAO getUserCarInfoDAO() {
		return this.userCarInfoDAO;
	}

	public UserCardInfoDAO getUserCardInfoDAO() {
		return this.userCardInfoDAO;
	}

	public UserChangeMessageTaskDAO getUserChangeMessageTaskDAO() {
		return this.userChangeMessageTaskDAO;
	}

	public UserDAO getUserDAO() {
		return this.userDAO;
	}

	public UserFollowWeChatInfoDAO getUserFollowWeChatInfoDAO() {
		return this.userFollowWeChatInfoDAO;
	}

	public UserIntegralResetRuleDAO getUserIntegralResetRuleDAO() {
		return this.userIntegralResetRuleDAO;
	}

	public UserIntegralResetTaskDAO getUserIntegralResetTaskDAO() {
		return this.userIntegralResetTaskDAO;
	}

	public UserInviteLogDAO getUserInviteLogDAO() {
		return this.userInviteLogDAO;
	}

	public UserLabelDAO getUserLabelDAO() {
		return this.userLabelDAO;
	}

	public UserLevelRuleDAO getUserLevelRuleDAO() {
		return this.userLevelRuleDAO;
	}

	public UserLevelTaskDAO getUserLevelTaskDAO() {
		return this.userLevelTaskDAO;
	}

	public UserLevelUpdFailDAO getUserLevelUpdFailDAO() {
		return this.userLevelUpdFailDAO;
	}

	public UserPayToolInfoDAO getUserPayToolInfoDAO() {
		return this.userPayToolInfoDAO;
	}

	public UserSpreadLogDAO getUserSpreadLogDAO() {
		return this.userSpreadLogDAO;
	}


    /**
	 * 断言notify_task表
	 */
	public void notifyTaskAssert(
	        NotifyTaskDO notifyTaskDO,
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

    /**
	 * 断言user_car_info表
	 */
	public void userCarInfoAssert(
	        UserCarInfoDO userCarInfoDO,
			long id, 
			String userId, 
			String carNumber, 
			String carType, 
			String authenticateImg, 
			String auditStatus, 
			Date applyDate, 
			Date auditDate, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userCarInfoDO.getId());
        assertEquals(userId, userCarInfoDO.getUserId());
        assertEquals(carNumber, userCarInfoDO.getCarNumber());
        assertEquals(carType, userCarInfoDO.getCarType());
        assertEquals(authenticateImg, userCarInfoDO.getAuthenticateImg());
        assertEquals(auditStatus, userCarInfoDO.getAuditStatus());
        assertEquals(applyDate, userCarInfoDO.getApplyDate());
        assertEquals(auditDate, userCarInfoDO.getAuditDate());
        assertEquals(rawAddTime, userCarInfoDO.getRawAddTime());
        assertEquals(rawUpdateTime, userCarInfoDO.getRawUpdateTime());
	}

	/**
	 * 断言user_car_info表数据
	 */
	public void assertUserCarInfo(UserCarInfoDO expect, UserCarInfoDO userCarInfoDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userCarInfoDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userCarInfoDO.getRawAddTime());
		expect.setRawAddTime(userCarInfoDO.getRawAddTime());
        Assertions.assertTrue(null != userCarInfoDO.getRawUpdateTime());
		expect.setRawUpdateTime(userCarInfoDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userCarInfoDO);
	}

    /**
	 * 插入user_car_info表数据
	 */
	public void insertUserCarInfo(UserCarInfoDO userCarInfoDO) {
		userCarInfoDAO.insert(userCarInfoDO);
	}

    /**
	 * 插入user_car_info表数据
	 */
	public void insertUserCarInfo(
			long id, 
			String userId, 
			String carNumber, 
			String carType, 
			String authenticateImg, 
			String auditStatus, 
			Date applyDate, 
			Date auditDate, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (applyDate == null) {
			applyDate = new Date();
		}
		if (auditDate == null) {
			auditDate = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		UserCarInfoDO userCarInfoDO = new UserCarInfoDO();
		userCarInfoDO.setId(id);
		userCarInfoDO.setUserId(userId);
		userCarInfoDO.setCarNumber(carNumber);
		userCarInfoDO.setCarType(carType);
		userCarInfoDO.setAuthenticateImg(authenticateImg);
		userCarInfoDO.setAuditStatus(auditStatus);
		userCarInfoDO.setApplyDate(applyDate);
		userCarInfoDO.setAuditDate(auditDate);
		userCarInfoDO.setRawAddTime(rawAddTime);
		userCarInfoDO.setRawUpdateTime(rawUpdateTime);
		userCarInfoDAO.insert(userCarInfoDO);
	}

    /**
     * 删除user_car_info表所有数据
     */
    public void cleanUserCarInfo() {
        UserCarInfoDOExample exam = new UserCarInfoDOExample();
        exam.createCriteria();
        userCarInfoDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_car_info表数据
	 */
	public void cleanUserCarInfoById(long id) {
		UserCarInfoDOExample exam = new UserCarInfoDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userCarInfoDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除user_car_info表数据
	 */
	public void cleanUserCarInfoByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		UserCarInfoDOExample exam = new UserCarInfoDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userCarInfoDAO.deleteByExample(exam);
	}

	/**
	* 根据carNumber删除user_car_info表数据
	*/
	public void cleanUserCarInfoByCarNumber(String carNumber) {
        if (StringUtils.isBlank(carNumber)){
            carNumber = "test_carNumber";
        }
		UserCarInfoDOExample exam = new UserCarInfoDOExample();
		exam.createCriteria().andCarNumberEqualTo(carNumber);
		userCarInfoDAO.deleteByExample(exam);
	}

    /**
     * 查询user_car_info表所有数据
     */
    public List<UserCarInfoDO> findUserCarInfoAll() {
        UserCarInfoDOExample exam = new UserCarInfoDOExample();
        exam.createCriteria();
		return userCarInfoDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_car_info表数据
	 */
	public List<UserCarInfoDO> findUserCarInfoById(long id) {
		UserCarInfoDOExample exam = new UserCarInfoDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userCarInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询user_car_info表数据
	 */
	public List<UserCarInfoDO> findUserCarInfoByUserId(String userId) {
		UserCarInfoDOExample exam = new UserCarInfoDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return userCarInfoDAO.selectByExample(exam);
	}

	/**
	* 根据carNumber查询user_car_info表数据
	*/
	public List<UserCarInfoDO> findUserCarInfoByCarNumber(String carNumber) {
		UserCarInfoDOExample exam = new UserCarInfoDOExample();
		exam.createCriteria().andCarNumberEqualTo(carNumber);
		return userCarInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_car_info表数据
	 */
	public void updateUserCarInfoById(long id,UserCarInfoDO userCarInfoDO) {
		UserCarInfoDOExample exam = new UserCarInfoDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userCarInfoDAO.updateByExample(userCarInfoDO, exam);
	}

    /**
	 * 根据userId更新user_car_info表数据
	 */
	public void updateUserCarInfoByUserId(String userId,UserCarInfoDO userCarInfoDO) {
		UserCarInfoDOExample exam = new UserCarInfoDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userCarInfoDAO.updateByExample(userCarInfoDO, exam);
	}

    /**
	 * 断言user_card_info表
	 */
	public void userCardInfoAssert(
	        UserCardInfoDO userCardInfoDO,
			long id, 
			String userId, 
			String partnerId, 
			String cardNo, 
			String internalNo, 
			String parentCardAccountNo, 
			String cardType, 
			String tag, 
			String accountTag, 
			String accountNo, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userCardInfoDO.getId());
        assertEquals(userId, userCardInfoDO.getUserId());
        assertEquals(partnerId, userCardInfoDO.getPartnerId());
        assertEquals(cardNo, userCardInfoDO.getCardNo());
        assertEquals(internalNo, userCardInfoDO.getInternalNo());
        assertEquals(parentCardAccountNo, userCardInfoDO.getParentCardAccountNo());
        assertEquals(cardType, userCardInfoDO.getCardType());
        assertEquals(tag, userCardInfoDO.getTag());
        assertEquals(accountTag, userCardInfoDO.getAccountTag());
        assertEquals(accountNo, userCardInfoDO.getAccountNo());
        assertEquals(status, userCardInfoDO.getStatus());
        assertEquals(rawAddTime, userCardInfoDO.getRawAddTime());
        assertEquals(rawUpdateTime, userCardInfoDO.getRawUpdateTime());
	}

	/**
	 * 断言user_card_info表数据
	 */
	public void assertUserCardInfo(UserCardInfoDO expect, UserCardInfoDO userCardInfoDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userCardInfoDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userCardInfoDO.getRawAddTime());
		expect.setRawAddTime(userCardInfoDO.getRawAddTime());
        Assertions.assertTrue(null != userCardInfoDO.getRawUpdateTime());
		expect.setRawUpdateTime(userCardInfoDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userCardInfoDO);
	}

    /**
	 * 插入user_card_info表数据
	 */
	public void insertUserCardInfo(UserCardInfoDO userCardInfoDO) {
		userCardInfoDAO.insert(userCardInfoDO);
	}

    /**
	 * 插入user_card_info表数据
	 */
	public void insertUserCardInfo(
			long id, 
			String userId, 
			String partnerId, 
			String cardNo, 
			String internalNo, 
			String parentCardAccountNo, 
			String cardType, 
			String tag, 
			String accountTag, 
			String accountNo, 
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
		UserCardInfoDO userCardInfoDO = new UserCardInfoDO();
		userCardInfoDO.setId(id);
		userCardInfoDO.setUserId(userId);
		userCardInfoDO.setPartnerId(partnerId);
		userCardInfoDO.setCardNo(cardNo);
		userCardInfoDO.setInternalNo(internalNo);
		userCardInfoDO.setParentCardAccountNo(parentCardAccountNo);
		userCardInfoDO.setCardType(cardType);
		userCardInfoDO.setTag(tag);
		userCardInfoDO.setAccountTag(accountTag);
		userCardInfoDO.setAccountNo(accountNo);
		userCardInfoDO.setStatus(status);
		userCardInfoDO.setRawAddTime(rawAddTime);
		userCardInfoDO.setRawUpdateTime(rawUpdateTime);
		userCardInfoDAO.insert(userCardInfoDO);
	}

    /**
     * 删除user_card_info表所有数据
     */
    public void cleanUserCardInfo() {
        UserCardInfoDOExample exam = new UserCardInfoDOExample();
        exam.createCriteria();
        userCardInfoDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_card_info表数据
	 */
	public void cleanUserCardInfoById(long id) {
		UserCardInfoDOExample exam = new UserCardInfoDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userCardInfoDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除user_card_info表数据
	 */
	public void cleanUserCardInfoByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		UserCardInfoDOExample exam = new UserCardInfoDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userCardInfoDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除user_card_info表数据
	 */
	public void cleanUserCardInfoByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		UserCardInfoDOExample exam = new UserCardInfoDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userCardInfoDAO.deleteByExample(exam);
	}

	/**
	 * 根据cardNo删除user_card_info表数据
	 */
	public void cleanUserCardInfoByCardNo(String cardNo) {
        if (StringUtils.isBlank(cardNo)){
            cardNo = "test_cardNo";
        }
		UserCardInfoDOExample exam = new UserCardInfoDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		userCardInfoDAO.deleteByExample(exam);
	}

	/**
	 * 根据internalNo删除user_card_info表数据
	 */
	public void cleanUserCardInfoByInternalNo(String internalNo) {
        if (StringUtils.isBlank(internalNo)){
            internalNo = "test_internalNo";
        }
		UserCardInfoDOExample exam = new UserCardInfoDOExample();
		exam.createCriteria().andInternalNoEqualTo(internalNo);
		userCardInfoDAO.deleteByExample(exam);
	}

	/**
	 * 根据parentCardAccountNo删除user_card_info表数据
	 */
	public void cleanUserCardInfoByParentCardAccountNo(String parentCardAccountNo) {
        if (StringUtils.isBlank(parentCardAccountNo)){
            parentCardAccountNo = "test_parentCardAccountNo";
        }
		UserCardInfoDOExample exam = new UserCardInfoDOExample();
		exam.createCriteria().andParentCardAccountNoEqualTo(parentCardAccountNo);
		userCardInfoDAO.deleteByExample(exam);
	}

	/**
	 * 根据accountNo删除user_card_info表数据
	 */
	public void cleanUserCardInfoByAccountNo(String accountNo) {
        if (StringUtils.isBlank(accountNo)){
            accountNo = "test_accountNo";
        }
		UserCardInfoDOExample exam = new UserCardInfoDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		userCardInfoDAO.deleteByExample(exam);
	}

    /**
     * 查询user_card_info表所有数据
     */
    public List<UserCardInfoDO> findUserCardInfoAll() {
        UserCardInfoDOExample exam = new UserCardInfoDOExample();
        exam.createCriteria();
		return userCardInfoDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_card_info表数据
	 */
	public List<UserCardInfoDO> findUserCardInfoById(long id) {
		UserCardInfoDOExample exam = new UserCardInfoDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userCardInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询user_card_info表数据
	 */
	public List<UserCardInfoDO> findUserCardInfoByUserId(String userId) {
		UserCardInfoDOExample exam = new UserCardInfoDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return userCardInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询user_card_info表数据
	 */
	public List<UserCardInfoDO> findUserCardInfoByPartnerId(String partnerId) {
		UserCardInfoDOExample exam = new UserCardInfoDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return userCardInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据cardNo查询user_card_info表数据
	 */
	public List<UserCardInfoDO> findUserCardInfoByCardNo(String cardNo) {
		UserCardInfoDOExample exam = new UserCardInfoDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		return userCardInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据internalNo查询user_card_info表数据
	 */
	public List<UserCardInfoDO> findUserCardInfoByInternalNo(String internalNo) {
		UserCardInfoDOExample exam = new UserCardInfoDOExample();
		exam.createCriteria().andInternalNoEqualTo(internalNo);
		return userCardInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据parentCardAccountNo查询user_card_info表数据
	 */
	public List<UserCardInfoDO> findUserCardInfoByParentCardAccountNo(String parentCardAccountNo) {
		UserCardInfoDOExample exam = new UserCardInfoDOExample();
		exam.createCriteria().andParentCardAccountNoEqualTo(parentCardAccountNo);
		return userCardInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据accountNo查询user_card_info表数据
	 */
	public List<UserCardInfoDO> findUserCardInfoByAccountNo(String accountNo) {
		UserCardInfoDOExample exam = new UserCardInfoDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		return userCardInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_card_info表数据
	 */
	public void updateUserCardInfoById(long id,UserCardInfoDO userCardInfoDO) {
		UserCardInfoDOExample exam = new UserCardInfoDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userCardInfoDAO.updateByExample(userCardInfoDO, exam);
	}

    /**
	 * 根据userId更新user_card_info表数据
	 */
	public void updateUserCardInfoByUserId(String userId,UserCardInfoDO userCardInfoDO) {
		UserCardInfoDOExample exam = new UserCardInfoDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userCardInfoDAO.updateByExample(userCardInfoDO, exam);
	}

    /**
	 * 根据partnerId更新user_card_info表数据
	 */
	public void updateUserCardInfoByPartnerId(String partnerId,UserCardInfoDO userCardInfoDO) {
		UserCardInfoDOExample exam = new UserCardInfoDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userCardInfoDAO.updateByExample(userCardInfoDO, exam);
	}

    /**
	 * 根据cardNo更新user_card_info表数据
	 */
	public void updateUserCardInfoByCardNo(String cardNo,UserCardInfoDO userCardInfoDO) {
		UserCardInfoDOExample exam = new UserCardInfoDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		userCardInfoDAO.updateByExample(userCardInfoDO, exam);
	}

    /**
	 * 根据internalNo更新user_card_info表数据
	 */
	public void updateUserCardInfoByInternalNo(String internalNo,UserCardInfoDO userCardInfoDO) {
		UserCardInfoDOExample exam = new UserCardInfoDOExample();
		exam.createCriteria().andInternalNoEqualTo(internalNo);
		userCardInfoDAO.updateByExample(userCardInfoDO, exam);
	}

    /**
	 * 根据parentCardAccountNo更新user_card_info表数据
	 */
	public void updateUserCardInfoByParentCardAccountNo(String parentCardAccountNo,UserCardInfoDO userCardInfoDO) {
		UserCardInfoDOExample exam = new UserCardInfoDOExample();
		exam.createCriteria().andParentCardAccountNoEqualTo(parentCardAccountNo);
		userCardInfoDAO.updateByExample(userCardInfoDO, exam);
	}

    /**
	 * 根据accountNo更新user_card_info表数据
	 */
	public void updateUserCardInfoByAccountNo(String accountNo,UserCardInfoDO userCardInfoDO) {
		UserCardInfoDOExample exam = new UserCardInfoDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		userCardInfoDAO.updateByExample(userCardInfoDO, exam);
	}

    /**
	 * 断言user_change_message_task表
	 */
	public void userChangeMessageTaskAssert(
	        UserChangeMessageTaskDO userChangeMessageTaskDO,
			long id, 
			String partnerId, 
			String userId, 
			Date useTimeUnit, 
			String messageDetails, 
			String messageStatus, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userChangeMessageTaskDO.getId());
        assertEquals(partnerId, userChangeMessageTaskDO.getPartnerId());
        assertEquals(userId, userChangeMessageTaskDO.getUserId());
        assertEquals(useTimeUnit, userChangeMessageTaskDO.getUseTimeUnit());
        assertEquals(messageDetails, userChangeMessageTaskDO.getMessageDetails());
        assertEquals(messageStatus, userChangeMessageTaskDO.getMessageStatus());
        assertEquals(memo, userChangeMessageTaskDO.getMemo());
        assertEquals(rawAddTime, userChangeMessageTaskDO.getRawAddTime());
        assertEquals(rawUpdateTime, userChangeMessageTaskDO.getRawUpdateTime());
	}

	/**
	 * 断言user_change_message_task表数据
	 */
	public void assertUserChangeMessageTask(UserChangeMessageTaskDO expect, UserChangeMessageTaskDO userChangeMessageTaskDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userChangeMessageTaskDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userChangeMessageTaskDO.getRawAddTime());
		expect.setRawAddTime(userChangeMessageTaskDO.getRawAddTime());
        Assertions.assertTrue(null != userChangeMessageTaskDO.getRawUpdateTime());
		expect.setRawUpdateTime(userChangeMessageTaskDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userChangeMessageTaskDO);
	}

    /**
	 * 插入user_change_message_task表数据
	 */
	public void insertUserChangeMessageTask(UserChangeMessageTaskDO userChangeMessageTaskDO) {
		userChangeMessageTaskDAO.insert(userChangeMessageTaskDO);
	}

    /**
	 * 插入user_change_message_task表数据
	 */
	public void insertUserChangeMessageTask(
			long id, 
			String partnerId, 
			String userId, 
			Date useTimeUnit, 
			String messageDetails, 
			String messageStatus, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (useTimeUnit == null) {
			useTimeUnit = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		UserChangeMessageTaskDO userChangeMessageTaskDO = new UserChangeMessageTaskDO();
		userChangeMessageTaskDO.setId(id);
		userChangeMessageTaskDO.setPartnerId(partnerId);
		userChangeMessageTaskDO.setUserId(userId);
		userChangeMessageTaskDO.setUseTimeUnit(useTimeUnit);
		userChangeMessageTaskDO.setMessageDetails(messageDetails);
		userChangeMessageTaskDO.setMessageStatus(messageStatus);
		userChangeMessageTaskDO.setMemo(memo);
		userChangeMessageTaskDO.setRawAddTime(rawAddTime);
		userChangeMessageTaskDO.setRawUpdateTime(rawUpdateTime);
		userChangeMessageTaskDAO.insert(userChangeMessageTaskDO);
	}

    /**
     * 删除user_change_message_task表所有数据
     */
    public void cleanUserChangeMessageTask() {
        UserChangeMessageTaskDOExample exam = new UserChangeMessageTaskDOExample();
        exam.createCriteria();
        userChangeMessageTaskDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_change_message_task表数据
	 */
	public void cleanUserChangeMessageTaskById(long id) {
		UserChangeMessageTaskDOExample exam = new UserChangeMessageTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userChangeMessageTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除user_change_message_task表数据
	 */
	public void cleanUserChangeMessageTaskByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		UserChangeMessageTaskDOExample exam = new UserChangeMessageTaskDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userChangeMessageTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除user_change_message_task表数据
	 */
	public void cleanUserChangeMessageTaskByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		UserChangeMessageTaskDOExample exam = new UserChangeMessageTaskDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userChangeMessageTaskDAO.deleteByExample(exam);
	}

    /**
     * 查询user_change_message_task表所有数据
     */
    public List<UserChangeMessageTaskDO> findUserChangeMessageTaskAll() {
        UserChangeMessageTaskDOExample exam = new UserChangeMessageTaskDOExample();
        exam.createCriteria();
		return userChangeMessageTaskDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_change_message_task表数据
	 */
	public List<UserChangeMessageTaskDO> findUserChangeMessageTaskById(long id) {
		UserChangeMessageTaskDOExample exam = new UserChangeMessageTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userChangeMessageTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询user_change_message_task表数据
	 */
	public List<UserChangeMessageTaskDO> findUserChangeMessageTaskByPartnerId(String partnerId) {
		UserChangeMessageTaskDOExample exam = new UserChangeMessageTaskDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return userChangeMessageTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询user_change_message_task表数据
	 */
	public List<UserChangeMessageTaskDO> findUserChangeMessageTaskByUserId(String userId) {
		UserChangeMessageTaskDOExample exam = new UserChangeMessageTaskDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return userChangeMessageTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_change_message_task表数据
	 */
	public void updateUserChangeMessageTaskById(long id,UserChangeMessageTaskDO userChangeMessageTaskDO) {
		UserChangeMessageTaskDOExample exam = new UserChangeMessageTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userChangeMessageTaskDAO.updateByExample(userChangeMessageTaskDO, exam);
	}

    /**
	 * 根据partnerId更新user_change_message_task表数据
	 */
	public void updateUserChangeMessageTaskByPartnerId(String partnerId,UserChangeMessageTaskDO userChangeMessageTaskDO) {
		UserChangeMessageTaskDOExample exam = new UserChangeMessageTaskDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userChangeMessageTaskDAO.updateByExample(userChangeMessageTaskDO, exam);
	}

    /**
	 * 根据userId更新user_change_message_task表数据
	 */
	public void updateUserChangeMessageTaskByUserId(String userId,UserChangeMessageTaskDO userChangeMessageTaskDO) {
		UserChangeMessageTaskDOExample exam = new UserChangeMessageTaskDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userChangeMessageTaskDAO.updateByExample(userChangeMessageTaskDO, exam);
	}

    /**
	 * 断言user表
	 */
	public void userAssert(
	        UserDO userDO,
			long id, 
			String userId, 
			String partnerId, 
			String mobile, 
			Date birthday, 
			String shortBirthday, 
			String nickName, 
			String realName, 
			String headImgUrl, 
			String sex, 
			String memberType, 
			String registerFrom, 
			String grade, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String certNo, 
			String identifier, 
			String importSource
	) {
        assertEquals(id, userDO.getId());
        assertEquals(userId, userDO.getUserId());
        assertEquals(partnerId, userDO.getPartnerId());
        assertEquals(mobile, userDO.getMobile());
        assertEquals(birthday, userDO.getBirthday());
        assertEquals(shortBirthday, userDO.getShortBirthday());
        assertEquals(nickName, userDO.getNickName());
        assertEquals(realName, userDO.getRealName());
        assertEquals(headImgUrl, userDO.getHeadImgUrl());
        assertEquals(sex, userDO.getSex());
        assertEquals(memberType, userDO.getMemberType());
        assertEquals(registerFrom, userDO.getRegisterFrom());
        assertEquals(grade, userDO.getGrade());
        assertEquals(rawAddTime, userDO.getRawAddTime());
        assertEquals(rawUpdateTime, userDO.getRawUpdateTime());
        assertEquals(certNo, userDO.getCertNo());
        assertEquals(identifier, userDO.getIdentifier());
        assertEquals(importSource, userDO.getImportSource());
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
			long id, 
			String userId, 
			String partnerId, 
			String mobile, 
			Date birthday, 
			String shortBirthday, 
			String nickName, 
			String realName, 
			String headImgUrl, 
			String sex, 
			String memberType, 
			String registerFrom, 
			String grade, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String certNo, 
			String identifier, 
			String importSource
	) {
		if (birthday == null) {
			birthday = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		UserDO userDO = new UserDO();
		userDO.setId(id);
		userDO.setUserId(userId);
		userDO.setPartnerId(partnerId);
		userDO.setMobile(mobile);
		userDO.setBirthday(birthday);
		userDO.setShortBirthday(shortBirthday);
		userDO.setNickName(nickName);
		userDO.setRealName(realName);
		userDO.setHeadImgUrl(headImgUrl);
		userDO.setSex(sex);
		userDO.setMemberType(memberType);
		userDO.setRegisterFrom(registerFrom);
		userDO.setGrade(grade);
		userDO.setRawAddTime(rawAddTime);
		userDO.setRawUpdateTime(rawUpdateTime);
		userDO.setCertNo(certNo);
		userDO.setIdentifier(identifier);
		userDO.setImportSource(importSource);
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
	public void cleanUserById(long id) {
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
	* 根据nickName删除user表数据
	*/
	public void cleanUserByNickName(String nickName) {
        if (StringUtils.isBlank(nickName)){
            nickName = "test_nickName";
        }
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
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
	 * 根据identifier删除user表数据
	 */
	public void cleanUserByIdentifier(String identifier) {
        if (StringUtils.isBlank(identifier)){
            identifier = "test_identifier";
        }
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andIdentifierEqualTo(identifier);
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
	public List<UserDO> findUserById(long id) {
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
	 * 根据partnerId查询user表数据
	 */
	public List<UserDO> findUserByPartnerId(String partnerId) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
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
	* 根据nickName查询user表数据
	*/
	public List<UserDO> findUserByNickName(String nickName) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
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
	 * 根据identifier查询user表数据
	 */
	public List<UserDO> findUserByIdentifier(String identifier) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andIdentifierEqualTo(identifier);
		return userDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user表数据
	 */
	public void updateUserById(long id,UserDO userDO) {
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
	 * 根据partnerId更新user表数据
	 */
	public void updateUserByPartnerId(String partnerId,UserDO userDO) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
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
	* 根据nickName更新user表数据
	*/
	public void updateUserByNickName(String nickName,UserDO userDO) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andNickNameEqualTo(nickName);
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
	 * 根据identifier更新user表数据
	 */
	public void updateUserByIdentifier(String identifier,UserDO userDO) {
		UserDOExample exam = new UserDOExample();
		exam.createCriteria().andIdentifierEqualTo(identifier);
		userDAO.updateByExample(userDO, exam);
	}

    /**
	 * 断言user_follow_we_chat_info表
	 */
	public void userFollowWeChatInfoAssert(
	        UserFollowWeChatInfoDO userFollowWeChatInfoDO,
			long id, 
			String openId, 
			String partnerId, 
			String bindStatus, 
			String follow, 
			Date firstFollowTime, 
			Date lastFollowTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userFollowWeChatInfoDO.getId());
        assertEquals(openId, userFollowWeChatInfoDO.getOpenId());
        assertEquals(partnerId, userFollowWeChatInfoDO.getPartnerId());
        assertEquals(bindStatus, userFollowWeChatInfoDO.getBindStatus());
        assertEquals(follow, userFollowWeChatInfoDO.getFollow());
        assertEquals(firstFollowTime, userFollowWeChatInfoDO.getFirstFollowTime());
        assertEquals(lastFollowTime, userFollowWeChatInfoDO.getLastFollowTime());
        assertEquals(rawAddTime, userFollowWeChatInfoDO.getRawAddTime());
        assertEquals(rawUpdateTime, userFollowWeChatInfoDO.getRawUpdateTime());
	}

	/**
	 * 断言user_follow_we_chat_info表数据
	 */
	public void assertUserFollowWeChatInfo(UserFollowWeChatInfoDO expect, UserFollowWeChatInfoDO userFollowWeChatInfoDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userFollowWeChatInfoDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userFollowWeChatInfoDO.getRawAddTime());
		expect.setRawAddTime(userFollowWeChatInfoDO.getRawAddTime());
        Assertions.assertTrue(null != userFollowWeChatInfoDO.getRawUpdateTime());
		expect.setRawUpdateTime(userFollowWeChatInfoDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userFollowWeChatInfoDO);
	}

    /**
	 * 插入user_follow_we_chat_info表数据
	 */
	public void insertUserFollowWeChatInfo(UserFollowWeChatInfoDO userFollowWeChatInfoDO) {
		userFollowWeChatInfoDAO.insert(userFollowWeChatInfoDO);
	}

    /**
	 * 插入user_follow_we_chat_info表数据
	 */
	public void insertUserFollowWeChatInfo(
			long id, 
			String openId, 
			String partnerId, 
			String bindStatus, 
			String follow, 
			Date firstFollowTime, 
			Date lastFollowTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (firstFollowTime == null) {
			firstFollowTime = new Date();
		}
		if (lastFollowTime == null) {
			lastFollowTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		UserFollowWeChatInfoDO userFollowWeChatInfoDO = new UserFollowWeChatInfoDO();
		userFollowWeChatInfoDO.setId(id);
		userFollowWeChatInfoDO.setOpenId(openId);
		userFollowWeChatInfoDO.setPartnerId(partnerId);
		userFollowWeChatInfoDO.setBindStatus(bindStatus);
		userFollowWeChatInfoDO.setFollow(follow);
		userFollowWeChatInfoDO.setFirstFollowTime(firstFollowTime);
		userFollowWeChatInfoDO.setLastFollowTime(lastFollowTime);
		userFollowWeChatInfoDO.setRawAddTime(rawAddTime);
		userFollowWeChatInfoDO.setRawUpdateTime(rawUpdateTime);
		userFollowWeChatInfoDAO.insert(userFollowWeChatInfoDO);
	}

    /**
     * 删除user_follow_we_chat_info表所有数据
     */
    public void cleanUserFollowWeChatInfo() {
        UserFollowWeChatInfoDOExample exam = new UserFollowWeChatInfoDOExample();
        exam.createCriteria();
        userFollowWeChatInfoDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_follow_we_chat_info表数据
	 */
	public void cleanUserFollowWeChatInfoById(long id) {
		UserFollowWeChatInfoDOExample exam = new UserFollowWeChatInfoDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userFollowWeChatInfoDAO.deleteByExample(exam);
	}

	/**
	 * 根据openId删除user_follow_we_chat_info表数据
	 */
	public void cleanUserFollowWeChatInfoByOpenId(String openId) {
        if (StringUtils.isBlank(openId)){
            openId = "test_openId";
        }
		UserFollowWeChatInfoDOExample exam = new UserFollowWeChatInfoDOExample();
		exam.createCriteria().andOpenIdEqualTo(openId);
		userFollowWeChatInfoDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除user_follow_we_chat_info表数据
	 */
	public void cleanUserFollowWeChatInfoByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		UserFollowWeChatInfoDOExample exam = new UserFollowWeChatInfoDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userFollowWeChatInfoDAO.deleteByExample(exam);
	}

    /**
     * 查询user_follow_we_chat_info表所有数据
     */
    public List<UserFollowWeChatInfoDO> findUserFollowWeChatInfoAll() {
        UserFollowWeChatInfoDOExample exam = new UserFollowWeChatInfoDOExample();
        exam.createCriteria();
		return userFollowWeChatInfoDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_follow_we_chat_info表数据
	 */
	public List<UserFollowWeChatInfoDO> findUserFollowWeChatInfoById(long id) {
		UserFollowWeChatInfoDOExample exam = new UserFollowWeChatInfoDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userFollowWeChatInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据openId查询user_follow_we_chat_info表数据
	 */
	public List<UserFollowWeChatInfoDO> findUserFollowWeChatInfoByOpenId(String openId) {
		UserFollowWeChatInfoDOExample exam = new UserFollowWeChatInfoDOExample();
		exam.createCriteria().andOpenIdEqualTo(openId);
		return userFollowWeChatInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询user_follow_we_chat_info表数据
	 */
	public List<UserFollowWeChatInfoDO> findUserFollowWeChatInfoByPartnerId(String partnerId) {
		UserFollowWeChatInfoDOExample exam = new UserFollowWeChatInfoDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return userFollowWeChatInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_follow_we_chat_info表数据
	 */
	public void updateUserFollowWeChatInfoById(long id,UserFollowWeChatInfoDO userFollowWeChatInfoDO) {
		UserFollowWeChatInfoDOExample exam = new UserFollowWeChatInfoDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userFollowWeChatInfoDAO.updateByExample(userFollowWeChatInfoDO, exam);
	}

    /**
	 * 根据openId更新user_follow_we_chat_info表数据
	 */
	public void updateUserFollowWeChatInfoByOpenId(String openId,UserFollowWeChatInfoDO userFollowWeChatInfoDO) {
		UserFollowWeChatInfoDOExample exam = new UserFollowWeChatInfoDOExample();
		exam.createCriteria().andOpenIdEqualTo(openId);
		userFollowWeChatInfoDAO.updateByExample(userFollowWeChatInfoDO, exam);
	}

    /**
	 * 根据partnerId更新user_follow_we_chat_info表数据
	 */
	public void updateUserFollowWeChatInfoByPartnerId(String partnerId,UserFollowWeChatInfoDO userFollowWeChatInfoDO) {
		UserFollowWeChatInfoDOExample exam = new UserFollowWeChatInfoDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userFollowWeChatInfoDAO.updateByExample(userFollowWeChatInfoDO, exam);
	}

    /**
	 * 断言user_integral_reset_rule表
	 */
	public void userIntegralResetRuleAssert(
	        UserIntegralResetRuleDO userIntegralResetRuleDO,
			long id, 
			String partnerId, 
			String resetSwitch, 
			String integralResetType, 
			String useTimeUnit, 
			String corn, 
			String days, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userIntegralResetRuleDO.getId());
        assertEquals(partnerId, userIntegralResetRuleDO.getPartnerId());
        assertEquals(resetSwitch, userIntegralResetRuleDO.getResetSwitch());
        assertEquals(integralResetType, userIntegralResetRuleDO.getIntegralResetType());
        assertEquals(useTimeUnit, userIntegralResetRuleDO.getUseTimeUnit());
        assertEquals(corn, userIntegralResetRuleDO.getCorn());
        assertEquals(days, userIntegralResetRuleDO.getDays());
        assertEquals(rawAddTime, userIntegralResetRuleDO.getRawAddTime());
        assertEquals(rawUpdateTime, userIntegralResetRuleDO.getRawUpdateTime());
	}

	/**
	 * 断言user_integral_reset_rule表数据
	 */
	public void assertUserIntegralResetRule(UserIntegralResetRuleDO expect, UserIntegralResetRuleDO userIntegralResetRuleDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userIntegralResetRuleDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userIntegralResetRuleDO.getRawAddTime());
		expect.setRawAddTime(userIntegralResetRuleDO.getRawAddTime());
        Assertions.assertTrue(null != userIntegralResetRuleDO.getRawUpdateTime());
		expect.setRawUpdateTime(userIntegralResetRuleDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userIntegralResetRuleDO);
	}

    /**
	 * 插入user_integral_reset_rule表数据
	 */
	public void insertUserIntegralResetRule(UserIntegralResetRuleDO userIntegralResetRuleDO) {
		userIntegralResetRuleDAO.insert(userIntegralResetRuleDO);
	}

    /**
	 * 插入user_integral_reset_rule表数据
	 */
	public void insertUserIntegralResetRule(
			long id, 
			String partnerId, 
			String resetSwitch, 
			String integralResetType, 
			String useTimeUnit, 
			String corn, 
			String days, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		UserIntegralResetRuleDO userIntegralResetRuleDO = new UserIntegralResetRuleDO();
		userIntegralResetRuleDO.setId(id);
		userIntegralResetRuleDO.setPartnerId(partnerId);
		userIntegralResetRuleDO.setResetSwitch(resetSwitch);
		userIntegralResetRuleDO.setIntegralResetType(integralResetType);
		userIntegralResetRuleDO.setUseTimeUnit(useTimeUnit);
		userIntegralResetRuleDO.setCorn(corn);
		userIntegralResetRuleDO.setDays(days);
		userIntegralResetRuleDO.setRawAddTime(rawAddTime);
		userIntegralResetRuleDO.setRawUpdateTime(rawUpdateTime);
		userIntegralResetRuleDAO.insert(userIntegralResetRuleDO);
	}

    /**
     * 删除user_integral_reset_rule表所有数据
     */
    public void cleanUserIntegralResetRule() {
        UserIntegralResetRuleDOExample exam = new UserIntegralResetRuleDOExample();
        exam.createCriteria();
        userIntegralResetRuleDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_integral_reset_rule表数据
	 */
	public void cleanUserIntegralResetRuleById(long id) {
		UserIntegralResetRuleDOExample exam = new UserIntegralResetRuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userIntegralResetRuleDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除user_integral_reset_rule表数据
	 */
	public void cleanUserIntegralResetRuleByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		UserIntegralResetRuleDOExample exam = new UserIntegralResetRuleDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userIntegralResetRuleDAO.deleteByExample(exam);
	}

    /**
     * 查询user_integral_reset_rule表所有数据
     */
    public List<UserIntegralResetRuleDO> findUserIntegralResetRuleAll() {
        UserIntegralResetRuleDOExample exam = new UserIntegralResetRuleDOExample();
        exam.createCriteria();
		return userIntegralResetRuleDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_integral_reset_rule表数据
	 */
	public List<UserIntegralResetRuleDO> findUserIntegralResetRuleById(long id) {
		UserIntegralResetRuleDOExample exam = new UserIntegralResetRuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userIntegralResetRuleDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询user_integral_reset_rule表数据
	 */
	public List<UserIntegralResetRuleDO> findUserIntegralResetRuleByPartnerId(String partnerId) {
		UserIntegralResetRuleDOExample exam = new UserIntegralResetRuleDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return userIntegralResetRuleDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_integral_reset_rule表数据
	 */
	public void updateUserIntegralResetRuleById(long id,UserIntegralResetRuleDO userIntegralResetRuleDO) {
		UserIntegralResetRuleDOExample exam = new UserIntegralResetRuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userIntegralResetRuleDAO.updateByExample(userIntegralResetRuleDO, exam);
	}

    /**
	 * 根据partnerId更新user_integral_reset_rule表数据
	 */
	public void updateUserIntegralResetRuleByPartnerId(String partnerId,UserIntegralResetRuleDO userIntegralResetRuleDO) {
		UserIntegralResetRuleDOExample exam = new UserIntegralResetRuleDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userIntegralResetRuleDAO.updateByExample(userIntegralResetRuleDO, exam);
	}

    /**
	 * 断言user_integral_reset_task表
	 */
	public void userIntegralResetTaskAssert(
	        UserIntegralResetTaskDO userIntegralResetTaskDO,
			long id, 
			String partnerId, 
			String integralResetType, 
			String useTimeUnit, 
			Date resetTime, 
			String executionStatus, 
			String memo, 
			Integer subscript, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userIntegralResetTaskDO.getId());
        assertEquals(partnerId, userIntegralResetTaskDO.getPartnerId());
        assertEquals(integralResetType, userIntegralResetTaskDO.getIntegralResetType());
        assertEquals(useTimeUnit, userIntegralResetTaskDO.getUseTimeUnit());
        assertEquals(resetTime, userIntegralResetTaskDO.getResetTime());
        assertEquals(executionStatus, userIntegralResetTaskDO.getExecutionStatus());
        assertEquals(memo, userIntegralResetTaskDO.getMemo());
        assertEquals(subscript, userIntegralResetTaskDO.getSubscript());
        assertEquals(rawAddTime, userIntegralResetTaskDO.getRawAddTime());
        assertEquals(rawUpdateTime, userIntegralResetTaskDO.getRawUpdateTime());
	}

	/**
	 * 断言user_integral_reset_task表数据
	 */
	public void assertUserIntegralResetTask(UserIntegralResetTaskDO expect, UserIntegralResetTaskDO userIntegralResetTaskDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userIntegralResetTaskDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userIntegralResetTaskDO.getRawAddTime());
		expect.setRawAddTime(userIntegralResetTaskDO.getRawAddTime());
        Assertions.assertTrue(null != userIntegralResetTaskDO.getRawUpdateTime());
		expect.setRawUpdateTime(userIntegralResetTaskDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userIntegralResetTaskDO);
	}

    /**
	 * 插入user_integral_reset_task表数据
	 */
	public void insertUserIntegralResetTask(UserIntegralResetTaskDO userIntegralResetTaskDO) {
		userIntegralResetTaskDAO.insert(userIntegralResetTaskDO);
	}

    /**
	 * 插入user_integral_reset_task表数据
	 */
	public void insertUserIntegralResetTask(
			long id, 
			String partnerId, 
			String integralResetType, 
			String useTimeUnit, 
			Date resetTime, 
			String executionStatus, 
			String memo, 
			Integer subscript, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (resetTime == null) {
			resetTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		UserIntegralResetTaskDO userIntegralResetTaskDO = new UserIntegralResetTaskDO();
		userIntegralResetTaskDO.setId(id);
		userIntegralResetTaskDO.setPartnerId(partnerId);
		userIntegralResetTaskDO.setIntegralResetType(integralResetType);
		userIntegralResetTaskDO.setUseTimeUnit(useTimeUnit);
		userIntegralResetTaskDO.setResetTime(resetTime);
		userIntegralResetTaskDO.setExecutionStatus(executionStatus);
		userIntegralResetTaskDO.setMemo(memo);
		userIntegralResetTaskDO.setSubscript(subscript);
		userIntegralResetTaskDO.setRawAddTime(rawAddTime);
		userIntegralResetTaskDO.setRawUpdateTime(rawUpdateTime);
		userIntegralResetTaskDAO.insert(userIntegralResetTaskDO);
	}

    /**
     * 删除user_integral_reset_task表所有数据
     */
    public void cleanUserIntegralResetTask() {
        UserIntegralResetTaskDOExample exam = new UserIntegralResetTaskDOExample();
        exam.createCriteria();
        userIntegralResetTaskDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_integral_reset_task表数据
	 */
	public void cleanUserIntegralResetTaskById(long id) {
		UserIntegralResetTaskDOExample exam = new UserIntegralResetTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userIntegralResetTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除user_integral_reset_task表数据
	 */
	public void cleanUserIntegralResetTaskByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		UserIntegralResetTaskDOExample exam = new UserIntegralResetTaskDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userIntegralResetTaskDAO.deleteByExample(exam);
	}

    /**
     * 查询user_integral_reset_task表所有数据
     */
    public List<UserIntegralResetTaskDO> findUserIntegralResetTaskAll() {
        UserIntegralResetTaskDOExample exam = new UserIntegralResetTaskDOExample();
        exam.createCriteria();
		return userIntegralResetTaskDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_integral_reset_task表数据
	 */
	public List<UserIntegralResetTaskDO> findUserIntegralResetTaskById(long id) {
		UserIntegralResetTaskDOExample exam = new UserIntegralResetTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userIntegralResetTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询user_integral_reset_task表数据
	 */
	public List<UserIntegralResetTaskDO> findUserIntegralResetTaskByPartnerId(String partnerId) {
		UserIntegralResetTaskDOExample exam = new UserIntegralResetTaskDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return userIntegralResetTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_integral_reset_task表数据
	 */
	public void updateUserIntegralResetTaskById(long id,UserIntegralResetTaskDO userIntegralResetTaskDO) {
		UserIntegralResetTaskDOExample exam = new UserIntegralResetTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userIntegralResetTaskDAO.updateByExample(userIntegralResetTaskDO, exam);
	}

    /**
	 * 根据partnerId更新user_integral_reset_task表数据
	 */
	public void updateUserIntegralResetTaskByPartnerId(String partnerId,UserIntegralResetTaskDO userIntegralResetTaskDO) {
		UserIntegralResetTaskDOExample exam = new UserIntegralResetTaskDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userIntegralResetTaskDAO.updateByExample(userIntegralResetTaskDO, exam);
	}

    /**
	 * 断言user_invite_log表
	 */
	public void userInviteLogAssert(
	        UserInviteLogDO userInviteLogDO,
			long id, 
			String userId, 
			String partnerId, 
			String nickName, 
			String userInviteId, 
			String userInviteName, 
			String userInviteMobile, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userInviteLogDO.getId());
        assertEquals(userId, userInviteLogDO.getUserId());
        assertEquals(partnerId, userInviteLogDO.getPartnerId());
        assertEquals(nickName, userInviteLogDO.getNickName());
        assertEquals(userInviteId, userInviteLogDO.getUserInviteId());
        assertEquals(userInviteName, userInviteLogDO.getUserInviteName());
        assertEquals(userInviteMobile, userInviteLogDO.getUserInviteMobile());
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
			long id, 
			String userId, 
			String partnerId, 
			String nickName, 
			String userInviteId, 
			String userInviteName, 
			String userInviteMobile, 
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
		userInviteLogDO.setUserId(userId);
		userInviteLogDO.setPartnerId(partnerId);
		userInviteLogDO.setNickName(nickName);
		userInviteLogDO.setUserInviteId(userInviteId);
		userInviteLogDO.setUserInviteName(userInviteName);
		userInviteLogDO.setUserInviteMobile(userInviteMobile);
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
	public void cleanUserInviteLogById(long id) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
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
	 * 根据userInviteId删除user_invite_log表数据
	 */
	public void cleanUserInviteLogByUserInviteId(String userInviteId) {
        if (StringUtils.isBlank(userInviteId)){
            userInviteId = "test_userInviteId";
        }
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andUserInviteIdEqualTo(userInviteId);
		userInviteLogDAO.deleteByExample(exam);
	}

	/**
	* 根据userInviteName删除user_invite_log表数据
	*/
	public void cleanUserInviteLogByUserInviteName(String userInviteName) {
        if (StringUtils.isBlank(userInviteName)){
            userInviteName = "test_userInviteName";
        }
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andUserInviteNameEqualTo(userInviteName);
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
	public List<UserInviteLogDO> findUserInviteLogById(long id) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
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
	 * 根据partnerId查询user_invite_log表数据
	 */
	public List<UserInviteLogDO> findUserInviteLogByPartnerId(String partnerId) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
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
	 * 根据userInviteId查询user_invite_log表数据
	 */
	public List<UserInviteLogDO> findUserInviteLogByUserInviteId(String userInviteId) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andUserInviteIdEqualTo(userInviteId);
		return userInviteLogDAO.selectByExample(exam);
	}

	/**
	* 根据userInviteName查询user_invite_log表数据
	*/
	public List<UserInviteLogDO> findUserInviteLogByUserInviteName(String userInviteName) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andUserInviteNameEqualTo(userInviteName);
		return userInviteLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_invite_log表数据
	 */
	public void updateUserInviteLogById(long id,UserInviteLogDO userInviteLogDO) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
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
	 * 根据partnerId更新user_invite_log表数据
	 */
	public void updateUserInviteLogByPartnerId(String partnerId,UserInviteLogDO userInviteLogDO) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
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
	 * 根据userInviteId更新user_invite_log表数据
	 */
	public void updateUserInviteLogByUserInviteId(String userInviteId,UserInviteLogDO userInviteLogDO) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andUserInviteIdEqualTo(userInviteId);
		userInviteLogDAO.updateByExample(userInviteLogDO, exam);
	}

	/**
	* 根据userInviteName更新user_invite_log表数据
	*/
	public void updateUserInviteLogByUserInviteName(String userInviteName,UserInviteLogDO userInviteLogDO) {
		UserInviteLogDOExample exam = new UserInviteLogDOExample();
		exam.createCriteria().andUserInviteNameEqualTo(userInviteName);
		userInviteLogDAO.updateByExample(userInviteLogDO, exam);
	}

    /**
	 * 断言user_label表
	 */
	public void userLabelAssert(
	        UserLabelDO userLabelDO,
			long id, 
			String partnerId, 
			String userId, 
			String lableEname, 
			String lableName, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userLabelDO.getId());
        assertEquals(partnerId, userLabelDO.getPartnerId());
        assertEquals(userId, userLabelDO.getUserId());
        assertEquals(lableEname, userLabelDO.getLableEname());
        assertEquals(lableName, userLabelDO.getLableName());
        assertEquals(rawAddTime, userLabelDO.getRawAddTime());
        assertEquals(rawUpdateTime, userLabelDO.getRawUpdateTime());
	}

	/**
	 * 断言user_label表数据
	 */
	public void assertUserLabel(UserLabelDO expect, UserLabelDO userLabelDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userLabelDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userLabelDO.getRawAddTime());
		expect.setRawAddTime(userLabelDO.getRawAddTime());
        Assertions.assertTrue(null != userLabelDO.getRawUpdateTime());
		expect.setRawUpdateTime(userLabelDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userLabelDO);
	}

    /**
	 * 插入user_label表数据
	 */
	public void insertUserLabel(UserLabelDO userLabelDO) {
		userLabelDAO.insert(userLabelDO);
	}

    /**
	 * 插入user_label表数据
	 */
	public void insertUserLabel(
			long id, 
			String partnerId, 
			String userId, 
			String lableEname, 
			String lableName, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		UserLabelDO userLabelDO = new UserLabelDO();
		userLabelDO.setId(id);
		userLabelDO.setPartnerId(partnerId);
		userLabelDO.setUserId(userId);
		userLabelDO.setLableEname(lableEname);
		userLabelDO.setLableName(lableName);
		userLabelDO.setRawAddTime(rawAddTime);
		userLabelDO.setRawUpdateTime(rawUpdateTime);
		userLabelDAO.insert(userLabelDO);
	}

    /**
     * 删除user_label表所有数据
     */
    public void cleanUserLabel() {
        UserLabelDOExample exam = new UserLabelDOExample();
        exam.createCriteria();
        userLabelDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_label表数据
	 */
	public void cleanUserLabelById(long id) {
		UserLabelDOExample exam = new UserLabelDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userLabelDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除user_label表数据
	 */
	public void cleanUserLabelByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		UserLabelDOExample exam = new UserLabelDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userLabelDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除user_label表数据
	 */
	public void cleanUserLabelByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		UserLabelDOExample exam = new UserLabelDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userLabelDAO.deleteByExample(exam);
	}

	/**
	* 根据lableEname删除user_label表数据
	*/
	public void cleanUserLabelByLableEname(String lableEname) {
        if (StringUtils.isBlank(lableEname)){
            lableEname = "test_lableEname";
        }
		UserLabelDOExample exam = new UserLabelDOExample();
		exam.createCriteria().andLableEnameEqualTo(lableEname);
		userLabelDAO.deleteByExample(exam);
	}

	/**
	* 根据lableName删除user_label表数据
	*/
	public void cleanUserLabelByLableName(String lableName) {
        if (StringUtils.isBlank(lableName)){
            lableName = "test_lableName";
        }
		UserLabelDOExample exam = new UserLabelDOExample();
		exam.createCriteria().andLableNameEqualTo(lableName);
		userLabelDAO.deleteByExample(exam);
	}

    /**
     * 查询user_label表所有数据
     */
    public List<UserLabelDO> findUserLabelAll() {
        UserLabelDOExample exam = new UserLabelDOExample();
        exam.createCriteria();
		return userLabelDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_label表数据
	 */
	public List<UserLabelDO> findUserLabelById(long id) {
		UserLabelDOExample exam = new UserLabelDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userLabelDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询user_label表数据
	 */
	public List<UserLabelDO> findUserLabelByPartnerId(String partnerId) {
		UserLabelDOExample exam = new UserLabelDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return userLabelDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询user_label表数据
	 */
	public List<UserLabelDO> findUserLabelByUserId(String userId) {
		UserLabelDOExample exam = new UserLabelDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return userLabelDAO.selectByExample(exam);
	}

	/**
	* 根据lableEname查询user_label表数据
	*/
	public List<UserLabelDO> findUserLabelByLableEname(String lableEname) {
		UserLabelDOExample exam = new UserLabelDOExample();
		exam.createCriteria().andLableEnameEqualTo(lableEname);
		return userLabelDAO.selectByExample(exam);
	}

	/**
	* 根据lableName查询user_label表数据
	*/
	public List<UserLabelDO> findUserLabelByLableName(String lableName) {
		UserLabelDOExample exam = new UserLabelDOExample();
		exam.createCriteria().andLableNameEqualTo(lableName);
		return userLabelDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_label表数据
	 */
	public void updateUserLabelById(long id,UserLabelDO userLabelDO) {
		UserLabelDOExample exam = new UserLabelDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userLabelDAO.updateByExample(userLabelDO, exam);
	}

    /**
	 * 根据partnerId更新user_label表数据
	 */
	public void updateUserLabelByPartnerId(String partnerId,UserLabelDO userLabelDO) {
		UserLabelDOExample exam = new UserLabelDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userLabelDAO.updateByExample(userLabelDO, exam);
	}

    /**
	 * 根据userId更新user_label表数据
	 */
	public void updateUserLabelByUserId(String userId,UserLabelDO userLabelDO) {
		UserLabelDOExample exam = new UserLabelDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userLabelDAO.updateByExample(userLabelDO, exam);
	}

	/**
	* 根据lableEname更新user_label表数据
	*/
	public void updateUserLabelByLableEname(String lableEname,UserLabelDO userLabelDO) {
		UserLabelDOExample exam = new UserLabelDOExample();
		exam.createCriteria().andLableEnameEqualTo(lableEname);
		userLabelDAO.updateByExample(userLabelDO, exam);
	}

	/**
	* 根据lableName更新user_label表数据
	*/
	public void updateUserLabelByLableName(String lableName,UserLabelDO userLabelDO) {
		UserLabelDOExample exam = new UserLabelDOExample();
		exam.createCriteria().andLableNameEqualTo(lableName);
		userLabelDAO.updateByExample(userLabelDO, exam);
	}

    /**
	 * 断言user_level_rule表
	 */
	public void userLevelRuleAssert(
	        UserLevelRuleDO userLevelRuleDO,
			long id, 
			String partnerId, 
			String useTimeUnit, 
			String levelUpdateType, 
			String days, 
			String levelRule, 
			String corn, 
			Integer cumulativeOfDays, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userLevelRuleDO.getId());
        assertEquals(partnerId, userLevelRuleDO.getPartnerId());
        assertEquals(useTimeUnit, userLevelRuleDO.getUseTimeUnit());
        assertEquals(levelUpdateType, userLevelRuleDO.getLevelUpdateType());
        assertEquals(days, userLevelRuleDO.getDays());
        assertEquals(levelRule, userLevelRuleDO.getLevelRule());
        assertEquals(corn, userLevelRuleDO.getCorn());
        assertEquals(cumulativeOfDays, userLevelRuleDO.getCumulativeOfDays());
        assertEquals(status, userLevelRuleDO.getStatus());
        assertEquals(rawAddTime, userLevelRuleDO.getRawAddTime());
        assertEquals(rawUpdateTime, userLevelRuleDO.getRawUpdateTime());
	}

	/**
	 * 断言user_level_rule表数据
	 */
	public void assertUserLevelRule(UserLevelRuleDO expect, UserLevelRuleDO userLevelRuleDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userLevelRuleDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userLevelRuleDO.getRawAddTime());
		expect.setRawAddTime(userLevelRuleDO.getRawAddTime());
        Assertions.assertTrue(null != userLevelRuleDO.getRawUpdateTime());
		expect.setRawUpdateTime(userLevelRuleDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userLevelRuleDO);
	}

    /**
	 * 插入user_level_rule表数据
	 */
	public void insertUserLevelRule(UserLevelRuleDO userLevelRuleDO) {
		userLevelRuleDAO.insert(userLevelRuleDO);
	}

    /**
	 * 插入user_level_rule表数据
	 */
	public void insertUserLevelRule(
			long id, 
			String partnerId, 
			String useTimeUnit, 
			String levelUpdateType, 
			String days, 
			String levelRule, 
			String corn, 
			Integer cumulativeOfDays, 
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
		UserLevelRuleDO userLevelRuleDO = new UserLevelRuleDO();
		userLevelRuleDO.setId(id);
		userLevelRuleDO.setPartnerId(partnerId);
		userLevelRuleDO.setUseTimeUnit(useTimeUnit);
		userLevelRuleDO.setLevelUpdateType(levelUpdateType);
		userLevelRuleDO.setDays(days);
		userLevelRuleDO.setLevelRule(levelRule);
		userLevelRuleDO.setCorn(corn);
		userLevelRuleDO.setCumulativeOfDays(cumulativeOfDays);
		userLevelRuleDO.setStatus(status);
		userLevelRuleDO.setRawAddTime(rawAddTime);
		userLevelRuleDO.setRawUpdateTime(rawUpdateTime);
		userLevelRuleDAO.insert(userLevelRuleDO);
	}

    /**
     * 删除user_level_rule表所有数据
     */
    public void cleanUserLevelRule() {
        UserLevelRuleDOExample exam = new UserLevelRuleDOExample();
        exam.createCriteria();
        userLevelRuleDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_level_rule表数据
	 */
	public void cleanUserLevelRuleById(long id) {
		UserLevelRuleDOExample exam = new UserLevelRuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userLevelRuleDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除user_level_rule表数据
	 */
	public void cleanUserLevelRuleByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		UserLevelRuleDOExample exam = new UserLevelRuleDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userLevelRuleDAO.deleteByExample(exam);
	}

    /**
     * 查询user_level_rule表所有数据
     */
    public List<UserLevelRuleDO> findUserLevelRuleAll() {
        UserLevelRuleDOExample exam = new UserLevelRuleDOExample();
        exam.createCriteria();
		return userLevelRuleDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_level_rule表数据
	 */
	public List<UserLevelRuleDO> findUserLevelRuleById(long id) {
		UserLevelRuleDOExample exam = new UserLevelRuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userLevelRuleDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询user_level_rule表数据
	 */
	public List<UserLevelRuleDO> findUserLevelRuleByPartnerId(String partnerId) {
		UserLevelRuleDOExample exam = new UserLevelRuleDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return userLevelRuleDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_level_rule表数据
	 */
	public void updateUserLevelRuleById(long id,UserLevelRuleDO userLevelRuleDO) {
		UserLevelRuleDOExample exam = new UserLevelRuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userLevelRuleDAO.updateByExample(userLevelRuleDO, exam);
	}

    /**
	 * 根据partnerId更新user_level_rule表数据
	 */
	public void updateUserLevelRuleByPartnerId(String partnerId,UserLevelRuleDO userLevelRuleDO) {
		UserLevelRuleDOExample exam = new UserLevelRuleDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userLevelRuleDAO.updateByExample(userLevelRuleDO, exam);
	}

    /**
	 * 断言user_level_task表
	 */
	public void userLevelTaskAssert(
	        UserLevelTaskDO userLevelTaskDO,
			long id, 
			String partnerId, 
			String levelUpdateType, 
			String useTimeUnit, 
			Date updateTime, 
			String executionStatus, 
			String memo, 
			Integer subscript, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userLevelTaskDO.getId());
        assertEquals(partnerId, userLevelTaskDO.getPartnerId());
        assertEquals(levelUpdateType, userLevelTaskDO.getLevelUpdateType());
        assertEquals(useTimeUnit, userLevelTaskDO.getUseTimeUnit());
        assertEquals(updateTime, userLevelTaskDO.getUpdateTime());
        assertEquals(executionStatus, userLevelTaskDO.getExecutionStatus());
        assertEquals(memo, userLevelTaskDO.getMemo());
        assertEquals(subscript, userLevelTaskDO.getSubscript());
        assertEquals(rawAddTime, userLevelTaskDO.getRawAddTime());
        assertEquals(rawUpdateTime, userLevelTaskDO.getRawUpdateTime());
	}

	/**
	 * 断言user_level_task表数据
	 */
	public void assertUserLevelTask(UserLevelTaskDO expect, UserLevelTaskDO userLevelTaskDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userLevelTaskDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userLevelTaskDO.getRawAddTime());
		expect.setRawAddTime(userLevelTaskDO.getRawAddTime());
        Assertions.assertTrue(null != userLevelTaskDO.getRawUpdateTime());
		expect.setRawUpdateTime(userLevelTaskDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userLevelTaskDO);
	}

    /**
	 * 插入user_level_task表数据
	 */
	public void insertUserLevelTask(UserLevelTaskDO userLevelTaskDO) {
		userLevelTaskDAO.insert(userLevelTaskDO);
	}

    /**
	 * 插入user_level_task表数据
	 */
	public void insertUserLevelTask(
			long id, 
			String partnerId, 
			String levelUpdateType, 
			String useTimeUnit, 
			Date updateTime, 
			String executionStatus, 
			String memo, 
			Integer subscript, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (updateTime == null) {
			updateTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		UserLevelTaskDO userLevelTaskDO = new UserLevelTaskDO();
		userLevelTaskDO.setId(id);
		userLevelTaskDO.setPartnerId(partnerId);
		userLevelTaskDO.setLevelUpdateType(levelUpdateType);
		userLevelTaskDO.setUseTimeUnit(useTimeUnit);
		userLevelTaskDO.setUpdateTime(updateTime);
		userLevelTaskDO.setExecutionStatus(executionStatus);
		userLevelTaskDO.setMemo(memo);
		userLevelTaskDO.setSubscript(subscript);
		userLevelTaskDO.setRawAddTime(rawAddTime);
		userLevelTaskDO.setRawUpdateTime(rawUpdateTime);
		userLevelTaskDAO.insert(userLevelTaskDO);
	}

    /**
     * 删除user_level_task表所有数据
     */
    public void cleanUserLevelTask() {
        UserLevelTaskDOExample exam = new UserLevelTaskDOExample();
        exam.createCriteria();
        userLevelTaskDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_level_task表数据
	 */
	public void cleanUserLevelTaskById(long id) {
		UserLevelTaskDOExample exam = new UserLevelTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userLevelTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除user_level_task表数据
	 */
	public void cleanUserLevelTaskByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		UserLevelTaskDOExample exam = new UserLevelTaskDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userLevelTaskDAO.deleteByExample(exam);
	}

    /**
     * 查询user_level_task表所有数据
     */
    public List<UserLevelTaskDO> findUserLevelTaskAll() {
        UserLevelTaskDOExample exam = new UserLevelTaskDOExample();
        exam.createCriteria();
		return userLevelTaskDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_level_task表数据
	 */
	public List<UserLevelTaskDO> findUserLevelTaskById(long id) {
		UserLevelTaskDOExample exam = new UserLevelTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userLevelTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询user_level_task表数据
	 */
	public List<UserLevelTaskDO> findUserLevelTaskByPartnerId(String partnerId) {
		UserLevelTaskDOExample exam = new UserLevelTaskDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return userLevelTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_level_task表数据
	 */
	public void updateUserLevelTaskById(long id,UserLevelTaskDO userLevelTaskDO) {
		UserLevelTaskDOExample exam = new UserLevelTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userLevelTaskDAO.updateByExample(userLevelTaskDO, exam);
	}

    /**
	 * 根据partnerId更新user_level_task表数据
	 */
	public void updateUserLevelTaskByPartnerId(String partnerId,UserLevelTaskDO userLevelTaskDO) {
		UserLevelTaskDOExample exam = new UserLevelTaskDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userLevelTaskDAO.updateByExample(userLevelTaskDO, exam);
	}

    /**
	 * 断言user_level_upd_fail表
	 */
	public void userLevelUpdFailAssert(
	        UserLevelUpdFailDO userLevelUpdFailDO,
			long id, 
			String partnerId, 
			String userId, 
			long maxId, 
			long batchMinId, 
			long batchMaxId, 
			String failType, 
			Integer failNum, 
			String status, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userLevelUpdFailDO.getId());
        assertEquals(partnerId, userLevelUpdFailDO.getPartnerId());
        assertEquals(userId, userLevelUpdFailDO.getUserId());
        assertEquals(maxId, userLevelUpdFailDO.getMaxId());
        assertEquals(batchMinId, userLevelUpdFailDO.getBatchMinId());
        assertEquals(batchMaxId, userLevelUpdFailDO.getBatchMaxId());
        assertEquals(failType, userLevelUpdFailDO.getFailType());
        assertEquals(failNum, userLevelUpdFailDO.getFailNum());
        assertEquals(status, userLevelUpdFailDO.getStatus());
        assertEquals(memo, userLevelUpdFailDO.getMemo());
        assertEquals(rawAddTime, userLevelUpdFailDO.getRawAddTime());
        assertEquals(rawUpdateTime, userLevelUpdFailDO.getRawUpdateTime());
	}

	/**
	 * 断言user_level_upd_fail表数据
	 */
	public void assertUserLevelUpdFail(UserLevelUpdFailDO expect, UserLevelUpdFailDO userLevelUpdFailDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userLevelUpdFailDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userLevelUpdFailDO.getRawAddTime());
		expect.setRawAddTime(userLevelUpdFailDO.getRawAddTime());
        Assertions.assertTrue(null != userLevelUpdFailDO.getRawUpdateTime());
		expect.setRawUpdateTime(userLevelUpdFailDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userLevelUpdFailDO);
	}

    /**
	 * 插入user_level_upd_fail表数据
	 */
	public void insertUserLevelUpdFail(UserLevelUpdFailDO userLevelUpdFailDO) {
		userLevelUpdFailDAO.insert(userLevelUpdFailDO);
	}

    /**
	 * 插入user_level_upd_fail表数据
	 */
	public void insertUserLevelUpdFail(
			long id, 
			String partnerId, 
			String userId, 
			long maxId, 
			long batchMinId, 
			long batchMaxId, 
			String failType, 
			Integer failNum, 
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
		UserLevelUpdFailDO userLevelUpdFailDO = new UserLevelUpdFailDO();
		userLevelUpdFailDO.setId(id);
		userLevelUpdFailDO.setPartnerId(partnerId);
		userLevelUpdFailDO.setUserId(userId);
		userLevelUpdFailDO.setMaxId(maxId);
		userLevelUpdFailDO.setBatchMinId(batchMinId);
		userLevelUpdFailDO.setBatchMaxId(batchMaxId);
		userLevelUpdFailDO.setFailType(failType);
		userLevelUpdFailDO.setFailNum(failNum);
		userLevelUpdFailDO.setStatus(status);
		userLevelUpdFailDO.setMemo(memo);
		userLevelUpdFailDO.setRawAddTime(rawAddTime);
		userLevelUpdFailDO.setRawUpdateTime(rawUpdateTime);
		userLevelUpdFailDAO.insert(userLevelUpdFailDO);
	}

    /**
     * 删除user_level_upd_fail表所有数据
     */
    public void cleanUserLevelUpdFail() {
        UserLevelUpdFailDOExample exam = new UserLevelUpdFailDOExample();
        exam.createCriteria();
        userLevelUpdFailDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_level_upd_fail表数据
	 */
	public void cleanUserLevelUpdFailById(long id) {
		UserLevelUpdFailDOExample exam = new UserLevelUpdFailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userLevelUpdFailDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除user_level_upd_fail表数据
	 */
	public void cleanUserLevelUpdFailByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		UserLevelUpdFailDOExample exam = new UserLevelUpdFailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userLevelUpdFailDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除user_level_upd_fail表数据
	 */
	public void cleanUserLevelUpdFailByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		UserLevelUpdFailDOExample exam = new UserLevelUpdFailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userLevelUpdFailDAO.deleteByExample(exam);
	}

	/**
	 * 根据maxId删除user_level_upd_fail表数据
	 */
	public void cleanUserLevelUpdFailByMaxId(long maxId) {
		UserLevelUpdFailDOExample exam = new UserLevelUpdFailDOExample();
		exam.createCriteria().andMaxIdEqualTo(maxId);
		userLevelUpdFailDAO.deleteByExample(exam);
	}

	/**
	 * 根据batchMinId删除user_level_upd_fail表数据
	 */
	public void cleanUserLevelUpdFailByBatchMinId(long batchMinId) {
		UserLevelUpdFailDOExample exam = new UserLevelUpdFailDOExample();
		exam.createCriteria().andBatchMinIdEqualTo(batchMinId);
		userLevelUpdFailDAO.deleteByExample(exam);
	}

	/**
	 * 根据batchMaxId删除user_level_upd_fail表数据
	 */
	public void cleanUserLevelUpdFailByBatchMaxId(long batchMaxId) {
		UserLevelUpdFailDOExample exam = new UserLevelUpdFailDOExample();
		exam.createCriteria().andBatchMaxIdEqualTo(batchMaxId);
		userLevelUpdFailDAO.deleteByExample(exam);
	}

    /**
     * 查询user_level_upd_fail表所有数据
     */
    public List<UserLevelUpdFailDO> findUserLevelUpdFailAll() {
        UserLevelUpdFailDOExample exam = new UserLevelUpdFailDOExample();
        exam.createCriteria();
		return userLevelUpdFailDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_level_upd_fail表数据
	 */
	public List<UserLevelUpdFailDO> findUserLevelUpdFailById(long id) {
		UserLevelUpdFailDOExample exam = new UserLevelUpdFailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userLevelUpdFailDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询user_level_upd_fail表数据
	 */
	public List<UserLevelUpdFailDO> findUserLevelUpdFailByPartnerId(String partnerId) {
		UserLevelUpdFailDOExample exam = new UserLevelUpdFailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return userLevelUpdFailDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询user_level_upd_fail表数据
	 */
	public List<UserLevelUpdFailDO> findUserLevelUpdFailByUserId(String userId) {
		UserLevelUpdFailDOExample exam = new UserLevelUpdFailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return userLevelUpdFailDAO.selectByExample(exam);
	}

    /**
	 * 根据maxId查询user_level_upd_fail表数据
	 */
	public List<UserLevelUpdFailDO> findUserLevelUpdFailByMaxId(long maxId) {
		UserLevelUpdFailDOExample exam = new UserLevelUpdFailDOExample();
		exam.createCriteria().andMaxIdEqualTo(maxId);
		return userLevelUpdFailDAO.selectByExample(exam);
	}

    /**
	 * 根据batchMinId查询user_level_upd_fail表数据
	 */
	public List<UserLevelUpdFailDO> findUserLevelUpdFailByBatchMinId(long batchMinId) {
		UserLevelUpdFailDOExample exam = new UserLevelUpdFailDOExample();
		exam.createCriteria().andBatchMinIdEqualTo(batchMinId);
		return userLevelUpdFailDAO.selectByExample(exam);
	}

    /**
	 * 根据batchMaxId查询user_level_upd_fail表数据
	 */
	public List<UserLevelUpdFailDO> findUserLevelUpdFailByBatchMaxId(long batchMaxId) {
		UserLevelUpdFailDOExample exam = new UserLevelUpdFailDOExample();
		exam.createCriteria().andBatchMaxIdEqualTo(batchMaxId);
		return userLevelUpdFailDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_level_upd_fail表数据
	 */
	public void updateUserLevelUpdFailById(long id,UserLevelUpdFailDO userLevelUpdFailDO) {
		UserLevelUpdFailDOExample exam = new UserLevelUpdFailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userLevelUpdFailDAO.updateByExample(userLevelUpdFailDO, exam);
	}

    /**
	 * 根据partnerId更新user_level_upd_fail表数据
	 */
	public void updateUserLevelUpdFailByPartnerId(String partnerId,UserLevelUpdFailDO userLevelUpdFailDO) {
		UserLevelUpdFailDOExample exam = new UserLevelUpdFailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userLevelUpdFailDAO.updateByExample(userLevelUpdFailDO, exam);
	}

    /**
	 * 根据userId更新user_level_upd_fail表数据
	 */
	public void updateUserLevelUpdFailByUserId(String userId,UserLevelUpdFailDO userLevelUpdFailDO) {
		UserLevelUpdFailDOExample exam = new UserLevelUpdFailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userLevelUpdFailDAO.updateByExample(userLevelUpdFailDO, exam);
	}

    /**
	 * 根据maxId更新user_level_upd_fail表数据
	 */
	public void updateUserLevelUpdFailByMaxId(long maxId,UserLevelUpdFailDO userLevelUpdFailDO) {
		UserLevelUpdFailDOExample exam = new UserLevelUpdFailDOExample();
		exam.createCriteria().andMaxIdEqualTo(maxId);
		userLevelUpdFailDAO.updateByExample(userLevelUpdFailDO, exam);
	}

    /**
	 * 根据batchMinId更新user_level_upd_fail表数据
	 */
	public void updateUserLevelUpdFailByBatchMinId(long batchMinId,UserLevelUpdFailDO userLevelUpdFailDO) {
		UserLevelUpdFailDOExample exam = new UserLevelUpdFailDOExample();
		exam.createCriteria().andBatchMinIdEqualTo(batchMinId);
		userLevelUpdFailDAO.updateByExample(userLevelUpdFailDO, exam);
	}

    /**
	 * 根据batchMaxId更新user_level_upd_fail表数据
	 */
	public void updateUserLevelUpdFailByBatchMaxId(long batchMaxId,UserLevelUpdFailDO userLevelUpdFailDO) {
		UserLevelUpdFailDOExample exam = new UserLevelUpdFailDOExample();
		exam.createCriteria().andBatchMaxIdEqualTo(batchMaxId);
		userLevelUpdFailDAO.updateByExample(userLevelUpdFailDO, exam);
	}

    /**
	 * 断言user_pay_tool_info表
	 */
	public void userPayToolInfoAssert(
	        UserPayToolInfoDO userPayToolInfoDO,
			long id, 
			String userId, 
			String partnerId, 
			String bindStatus, 
			String openId, 
			String type, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userPayToolInfoDO.getId());
        assertEquals(userId, userPayToolInfoDO.getUserId());
        assertEquals(partnerId, userPayToolInfoDO.getPartnerId());
        assertEquals(bindStatus, userPayToolInfoDO.getBindStatus());
        assertEquals(openId, userPayToolInfoDO.getOpenId());
        assertEquals(type, userPayToolInfoDO.getType());
        assertEquals(rawAddTime, userPayToolInfoDO.getRawAddTime());
        assertEquals(rawUpdateTime, userPayToolInfoDO.getRawUpdateTime());
	}

	/**
	 * 断言user_pay_tool_info表数据
	 */
	public void assertUserPayToolInfo(UserPayToolInfoDO expect, UserPayToolInfoDO userPayToolInfoDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userPayToolInfoDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userPayToolInfoDO.getRawAddTime());
		expect.setRawAddTime(userPayToolInfoDO.getRawAddTime());
        Assertions.assertTrue(null != userPayToolInfoDO.getRawUpdateTime());
		expect.setRawUpdateTime(userPayToolInfoDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userPayToolInfoDO);
	}

    /**
	 * 插入user_pay_tool_info表数据
	 */
	public void insertUserPayToolInfo(UserPayToolInfoDO userPayToolInfoDO) {
		userPayToolInfoDAO.insert(userPayToolInfoDO);
	}

    /**
	 * 插入user_pay_tool_info表数据
	 */
	public void insertUserPayToolInfo(
			long id, 
			String userId, 
			String partnerId, 
			String bindStatus, 
			String openId, 
			String type, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		UserPayToolInfoDO userPayToolInfoDO = new UserPayToolInfoDO();
		userPayToolInfoDO.setId(id);
		userPayToolInfoDO.setUserId(userId);
		userPayToolInfoDO.setPartnerId(partnerId);
		userPayToolInfoDO.setBindStatus(bindStatus);
		userPayToolInfoDO.setOpenId(openId);
		userPayToolInfoDO.setType(type);
		userPayToolInfoDO.setRawAddTime(rawAddTime);
		userPayToolInfoDO.setRawUpdateTime(rawUpdateTime);
		userPayToolInfoDAO.insert(userPayToolInfoDO);
	}

    /**
     * 删除user_pay_tool_info表所有数据
     */
    public void cleanUserPayToolInfo() {
        UserPayToolInfoDOExample exam = new UserPayToolInfoDOExample();
        exam.createCriteria();
        userPayToolInfoDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_pay_tool_info表数据
	 */
	public void cleanUserPayToolInfoById(long id) {
		UserPayToolInfoDOExample exam = new UserPayToolInfoDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userPayToolInfoDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除user_pay_tool_info表数据
	 */
	public void cleanUserPayToolInfoByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		UserPayToolInfoDOExample exam = new UserPayToolInfoDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userPayToolInfoDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除user_pay_tool_info表数据
	 */
	public void cleanUserPayToolInfoByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		UserPayToolInfoDOExample exam = new UserPayToolInfoDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userPayToolInfoDAO.deleteByExample(exam);
	}

	/**
	 * 根据openId删除user_pay_tool_info表数据
	 */
	public void cleanUserPayToolInfoByOpenId(String openId) {
        if (StringUtils.isBlank(openId)){
            openId = "test_openId";
        }
		UserPayToolInfoDOExample exam = new UserPayToolInfoDOExample();
		exam.createCriteria().andOpenIdEqualTo(openId);
		userPayToolInfoDAO.deleteByExample(exam);
	}

    /**
     * 查询user_pay_tool_info表所有数据
     */
    public List<UserPayToolInfoDO> findUserPayToolInfoAll() {
        UserPayToolInfoDOExample exam = new UserPayToolInfoDOExample();
        exam.createCriteria();
		return userPayToolInfoDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_pay_tool_info表数据
	 */
	public List<UserPayToolInfoDO> findUserPayToolInfoById(long id) {
		UserPayToolInfoDOExample exam = new UserPayToolInfoDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userPayToolInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询user_pay_tool_info表数据
	 */
	public List<UserPayToolInfoDO> findUserPayToolInfoByUserId(String userId) {
		UserPayToolInfoDOExample exam = new UserPayToolInfoDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return userPayToolInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询user_pay_tool_info表数据
	 */
	public List<UserPayToolInfoDO> findUserPayToolInfoByPartnerId(String partnerId) {
		UserPayToolInfoDOExample exam = new UserPayToolInfoDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return userPayToolInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据openId查询user_pay_tool_info表数据
	 */
	public List<UserPayToolInfoDO> findUserPayToolInfoByOpenId(String openId) {
		UserPayToolInfoDOExample exam = new UserPayToolInfoDOExample();
		exam.createCriteria().andOpenIdEqualTo(openId);
		return userPayToolInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_pay_tool_info表数据
	 */
	public void updateUserPayToolInfoById(long id,UserPayToolInfoDO userPayToolInfoDO) {
		UserPayToolInfoDOExample exam = new UserPayToolInfoDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userPayToolInfoDAO.updateByExample(userPayToolInfoDO, exam);
	}

    /**
	 * 根据userId更新user_pay_tool_info表数据
	 */
	public void updateUserPayToolInfoByUserId(String userId,UserPayToolInfoDO userPayToolInfoDO) {
		UserPayToolInfoDOExample exam = new UserPayToolInfoDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userPayToolInfoDAO.updateByExample(userPayToolInfoDO, exam);
	}

    /**
	 * 根据partnerId更新user_pay_tool_info表数据
	 */
	public void updateUserPayToolInfoByPartnerId(String partnerId,UserPayToolInfoDO userPayToolInfoDO) {
		UserPayToolInfoDOExample exam = new UserPayToolInfoDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userPayToolInfoDAO.updateByExample(userPayToolInfoDO, exam);
	}

    /**
	 * 根据openId更新user_pay_tool_info表数据
	 */
	public void updateUserPayToolInfoByOpenId(String openId,UserPayToolInfoDO userPayToolInfoDO) {
		UserPayToolInfoDOExample exam = new UserPayToolInfoDOExample();
		exam.createCriteria().andOpenIdEqualTo(openId);
		userPayToolInfoDAO.updateByExample(userPayToolInfoDO, exam);
	}

    /**
	 * 断言user_spread_log表
	 */
	public void userSpreadLogAssert(
	        UserSpreadLogDO userSpreadLogDO,
			long id, 
			String userId, 
			String partnerId, 
			String nickName, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String operatorId, 
			String operatorName, 
			String operatorMobile, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userSpreadLogDO.getId());
        assertEquals(userId, userSpreadLogDO.getUserId());
        assertEquals(partnerId, userSpreadLogDO.getPartnerId());
        assertEquals(nickName, userSpreadLogDO.getNickName());
        assertEquals(stationId, userSpreadLogDO.getStationId());
        assertEquals(stationCode, userSpreadLogDO.getStationCode());
        assertEquals(stationName, userSpreadLogDO.getStationName());
        assertEquals(operatorId, userSpreadLogDO.getOperatorId());
        assertEquals(operatorName, userSpreadLogDO.getOperatorName());
        assertEquals(operatorMobile, userSpreadLogDO.getOperatorMobile());
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
			long id, 
			String userId, 
			String partnerId, 
			String nickName, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String operatorId, 
			String operatorName, 
			String operatorMobile, 
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
		userSpreadLogDO.setUserId(userId);
		userSpreadLogDO.setPartnerId(partnerId);
		userSpreadLogDO.setNickName(nickName);
		userSpreadLogDO.setStationId(stationId);
		userSpreadLogDO.setStationCode(stationCode);
		userSpreadLogDO.setStationName(stationName);
		userSpreadLogDO.setOperatorId(operatorId);
		userSpreadLogDO.setOperatorName(operatorName);
		userSpreadLogDO.setOperatorMobile(operatorMobile);
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
	public void cleanUserSpreadLogById(long id) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
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
	public List<UserSpreadLogDO> findUserSpreadLogById(long id) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
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
	 * 根据partnerId查询user_spread_log表数据
	 */
	public List<UserSpreadLogDO> findUserSpreadLogByPartnerId(String partnerId) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
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
	 * 根据stationId查询user_spread_log表数据
	 */
	public List<UserSpreadLogDO> findUserSpreadLogByStationId(String stationId) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
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
	* 根据stationName查询user_spread_log表数据
	*/
	public List<UserSpreadLogDO> findUserSpreadLogByStationName(String stationName) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
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
	public void updateUserSpreadLogById(long id,UserSpreadLogDO userSpreadLogDO) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
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
	 * 根据partnerId更新user_spread_log表数据
	 */
	public void updateUserSpreadLogByPartnerId(String partnerId,UserSpreadLogDO userSpreadLogDO) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
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
	 * 根据stationId更新user_spread_log表数据
	 */
	public void updateUserSpreadLogByStationId(String stationId,UserSpreadLogDO userSpreadLogDO) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
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
	* 根据stationName更新user_spread_log表数据
	*/
	public void updateUserSpreadLogByStationName(String stationName,UserSpreadLogDO userSpreadLogDO) {
		UserSpreadLogDOExample exam = new UserSpreadLogDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
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
}
