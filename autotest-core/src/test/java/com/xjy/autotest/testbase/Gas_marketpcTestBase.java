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
import dal.dao.gas_marketpc.*;
import dal.model.gas_marketpc.*;
import com.xjy.autotest.config.Gas_marketpcDataSourceConfig;

/**
 * @author autotest
 * Created on 2020/02/24.
 */
@Service
@Import({
        Gas_marketpcDataSourceConfig.class
})
public class Gas_marketpcTestBase extends AutoTestBase{

	@Autowired
	ActionDAO actionDAO;

	@Autowired
	CampaignBirthdayTaskDAO campaignBirthdayTaskDAO;

	@Autowired
	CampaignCompensateTaskDAO campaignCompensateTaskDAO;

	@Autowired
	CampaignTemplateDAO campaignTemplateDAO;

	@Autowired
	CampaignTemplatePartnerListDAO campaignTemplatePartnerListDAO;

	@Autowired
	CampaignUserPartakeRecordDAO campaignUserPartakeRecordDAO;

	@Autowired
	CampaignUserTaskDAO campaignUserTaskDAO;

	@Autowired
	CampaignUserTaskRetryDAO campaignUserTaskRetryDAO;

	@Autowired
	CouponCopyDAO couponCopyDAO;

	@Autowired
	CouponDAO couponDAO;

	@Autowired
	GiveCouponDetailDAO giveCouponDetailDAO;

	@Autowired
	GiveGoodsDetailDAO giveGoodsDetailDAO;

	@Autowired
	GiveLuckDrawDetailDAO giveLuckDrawDetailDAO;

	@Autowired
	GiveMoneyDetailDAO giveMoneyDetailDAO;

	@Autowired
	GivePointsDetailDAO givePointsDetailDAO;

	@Autowired
	LuckDrawAccountDAO luckDrawAccountDAO;

	@Autowired
	LuckDrawCampaignDAO luckDrawCampaignDAO;

	@Autowired
	LuckDrawPrizeDAO luckDrawPrizeDAO;

	@Autowired
	NotifyTaskDAO notifyTaskDAO;

	@Autowired
	PointSchemeDAO pointSchemeDAO;

	@Autowired
	PreciseGiveDAO preciseGiveDAO;

	@Autowired
	PromotionDAO promotionDAO;

	@Autowired
	ReissueGiveDAO reissueGiveDAO;

	@Autowired
	RuleConditionDAO ruleConditionDAO;

	@Autowired
	RuleDAO ruleDAO;

	@Autowired
	RuleSetDAO ruleSetDAO;

	@Autowired
	SalesCampaignDAO salesCampaignDAO;

	@Autowired
	SalesCampaignGroupDAO salesCampaignGroupDAO;

	@Autowired
	SysIdGenDAO sysIdGenDAO;

	@Autowired
	TriggerConditionDAO triggerConditionDAO;

	@Autowired
	TriggerEventDAO triggerEventDAO;

	@Autowired
	TriggerEventDataDAO triggerEventDataDAO;

	@Autowired
	UserActionEventDAO userActionEventDAO;

	@Autowired
	UserBirthdayTaskDAO userBirthdayTaskDAO;

	@Autowired
	UserGroupDAO userGroupDAO;

	@Autowired
	UserGroupListDAO userGroupListDAO;

	public ActionDAO getActionDAO() {
		return this.actionDAO;
	}

	public CampaignBirthdayTaskDAO getCampaignBirthdayTaskDAO() {
		return this.campaignBirthdayTaskDAO;
	}

	public CampaignCompensateTaskDAO getCampaignCompensateTaskDAO() {
		return this.campaignCompensateTaskDAO;
	}

	public CampaignTemplateDAO getCampaignTemplateDAO() {
		return this.campaignTemplateDAO;
	}

	public CampaignTemplatePartnerListDAO getCampaignTemplatePartnerListDAO() {
		return this.campaignTemplatePartnerListDAO;
	}

	public CampaignUserPartakeRecordDAO getCampaignUserPartakeRecordDAO() {
		return this.campaignUserPartakeRecordDAO;
	}

	public CampaignUserTaskDAO getCampaignUserTaskDAO() {
		return this.campaignUserTaskDAO;
	}

	public CampaignUserTaskRetryDAO getCampaignUserTaskRetryDAO() {
		return this.campaignUserTaskRetryDAO;
	}

	public CouponCopyDAO getCouponCopyDAO() {
		return this.couponCopyDAO;
	}

	public CouponDAO getCouponDAO() {
		return this.couponDAO;
	}

	public GiveCouponDetailDAO getGiveCouponDetailDAO() {
		return this.giveCouponDetailDAO;
	}

	public GiveGoodsDetailDAO getGiveGoodsDetailDAO() {
		return this.giveGoodsDetailDAO;
	}

	public GiveLuckDrawDetailDAO getGiveLuckDrawDetailDAO() {
		return this.giveLuckDrawDetailDAO;
	}

	public GiveMoneyDetailDAO getGiveMoneyDetailDAO() {
		return this.giveMoneyDetailDAO;
	}

	public GivePointsDetailDAO getGivePointsDetailDAO() {
		return this.givePointsDetailDAO;
	}

	public LuckDrawAccountDAO getLuckDrawAccountDAO() {
		return this.luckDrawAccountDAO;
	}

	public LuckDrawCampaignDAO getLuckDrawCampaignDAO() {
		return this.luckDrawCampaignDAO;
	}

	public LuckDrawPrizeDAO getLuckDrawPrizeDAO() {
		return this.luckDrawPrizeDAO;
	}

	public NotifyTaskDAO getNotifyTaskDAO() {
		return this.notifyTaskDAO;
	}

	public PointSchemeDAO getPointSchemeDAO() {
		return this.pointSchemeDAO;
	}

	public PreciseGiveDAO getPreciseGiveDAO() {
		return this.preciseGiveDAO;
	}

	public PromotionDAO getPromotionDAO() {
		return this.promotionDAO;
	}

	public ReissueGiveDAO getReissueGiveDAO() {
		return this.reissueGiveDAO;
	}

	public RuleConditionDAO getRuleConditionDAO() {
		return this.ruleConditionDAO;
	}

	public RuleDAO getRuleDAO() {
		return this.ruleDAO;
	}

	public RuleSetDAO getRuleSetDAO() {
		return this.ruleSetDAO;
	}

	public SalesCampaignDAO getSalesCampaignDAO() {
		return this.salesCampaignDAO;
	}

	public SalesCampaignGroupDAO getSalesCampaignGroupDAO() {
		return this.salesCampaignGroupDAO;
	}

	public SysIdGenDAO getSysIdGenDAO() {
		return this.sysIdGenDAO;
	}

	public TriggerConditionDAO getTriggerConditionDAO() {
		return this.triggerConditionDAO;
	}

	public TriggerEventDAO getTriggerEventDAO() {
		return this.triggerEventDAO;
	}

	public TriggerEventDataDAO getTriggerEventDataDAO() {
		return this.triggerEventDataDAO;
	}

	public UserActionEventDAO getUserActionEventDAO() {
		return this.userActionEventDAO;
	}

	public UserBirthdayTaskDAO getUserBirthdayTaskDAO() {
		return this.userBirthdayTaskDAO;
	}

	public UserGroupDAO getUserGroupDAO() {
		return this.userGroupDAO;
	}

	public UserGroupListDAO getUserGroupListDAO() {
		return this.userGroupListDAO;
	}


    /**
	 * 断言action表
	 */
	public void actionAssert(
	        ActionDO actionDO,
			Long id, 
			String actionName, 
			String description, 
			String discountType, 
			String promotionWay, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, actionDO.getId());
        assertEquals(actionName, actionDO.getActionName());
        assertEquals(description, actionDO.getDescription());
        assertEquals(discountType, actionDO.getDiscountType());
        assertEquals(promotionWay, actionDO.getPromotionWay());
        assertEquals(rawAddTime, actionDO.getRawAddTime());
        assertEquals(rawUpdateTime, actionDO.getRawUpdateTime());
	}

	/**
	 * 断言action表数据
	 */
	public void assertAction(ActionDO expect, ActionDO actionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			actionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != actionDO.getRawAddTime());
		expect.setRawAddTime(actionDO.getRawAddTime());
        Assertions.assertTrue(null != actionDO.getRawUpdateTime());
		expect.setRawUpdateTime(actionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, actionDO);
	}

    /**
	 * 插入action表数据
	 */
	public void insertAction(ActionDO actionDO) {
		actionDAO.insert(actionDO);
	}

    /**
	 * 插入action表数据
	 */
	public void insertAction(
			Long id, 
			String actionName, 
			String description, 
			String discountType, 
			String promotionWay, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ActionDO actionDO = new ActionDO();
		actionDO.setId(id);
		actionDO.setActionName(actionName);
		actionDO.setDescription(description);
		actionDO.setDiscountType(discountType);
		actionDO.setPromotionWay(promotionWay);
		actionDO.setRawAddTime(rawAddTime);
		actionDO.setRawUpdateTime(rawUpdateTime);
		actionDAO.insert(actionDO);
	}

    /**
     * 删除action表所有数据
     */
    public void cleanAction() {
        ActionDOExample exam = new ActionDOExample();
        exam.createCriteria();
        actionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除action表数据
	 */
	public void cleanActionById(Long id) {
		ActionDOExample exam = new ActionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		actionDAO.deleteByExample(exam);
	}

	/**
	* 根据actionName删除action表数据
	*/
	public void cleanActionByActionName(String actionName) {
        if (StringUtils.isBlank(actionName)){
            actionName = "test_actionName";
        }
		ActionDOExample exam = new ActionDOExample();
		exam.createCriteria().andActionNameEqualTo(actionName);
		actionDAO.deleteByExample(exam);
	}

    /**
     * 查询action表所有数据
     */
    public List<ActionDO> findActionAll() {
        ActionDOExample exam = new ActionDOExample();
        exam.createCriteria();
		return actionDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询action表数据
	 */
	public List<ActionDO> findActionById(Long id) {
		ActionDOExample exam = new ActionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return actionDAO.selectByExample(exam);
	}

	/**
	* 根据actionName查询action表数据
	*/
	public List<ActionDO> findActionByActionName(String actionName) {
		ActionDOExample exam = new ActionDOExample();
		exam.createCriteria().andActionNameEqualTo(actionName);
		return actionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新action表数据
	 */
	public void updateActionById(Long id,ActionDO actionDO) {
		ActionDOExample exam = new ActionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		actionDAO.updateByExample(actionDO, exam);
	}

	/**
	* 根据actionName更新action表数据
	*/
	public void updateActionByActionName(String actionName,ActionDO actionDO) {
		ActionDOExample exam = new ActionDOExample();
		exam.createCriteria().andActionNameEqualTo(actionName);
		actionDAO.updateByExample(actionDO, exam);
	}

    /**
	 * 断言campaign_birthday_task表
	 */
	public void campaignBirthdayTaskAssert(
	        CampaignBirthdayTaskDO campaignBirthdayTaskDO,
			Long id, 
			String executeTime, 
			String shortBirthday, 
			Long total, 
			String status, 
			String gid, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, campaignBirthdayTaskDO.getId());
        assertEquals(executeTime, campaignBirthdayTaskDO.getExecuteTime());
        assertEquals(shortBirthday, campaignBirthdayTaskDO.getShortBirthday());
        assertEquals(total, campaignBirthdayTaskDO.getTotal());
        assertEquals(status, campaignBirthdayTaskDO.getStatus());
        assertEquals(gid, campaignBirthdayTaskDO.getGid());
        assertEquals(rawAddTime, campaignBirthdayTaskDO.getRawAddTime());
        assertEquals(rawUpdateTime, campaignBirthdayTaskDO.getRawUpdateTime());
	}

	/**
	 * 断言campaign_birthday_task表数据
	 */
	public void assertCampaignBirthdayTask(CampaignBirthdayTaskDO expect, CampaignBirthdayTaskDO campaignBirthdayTaskDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			campaignBirthdayTaskDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != campaignBirthdayTaskDO.getRawAddTime());
		expect.setRawAddTime(campaignBirthdayTaskDO.getRawAddTime());
        Assertions.assertTrue(null != campaignBirthdayTaskDO.getRawUpdateTime());
		expect.setRawUpdateTime(campaignBirthdayTaskDO.getRawUpdateTime());
		Assertions.assertEquals(expect, campaignBirthdayTaskDO);
	}

    /**
	 * 插入campaign_birthday_task表数据
	 */
	public void insertCampaignBirthdayTask(CampaignBirthdayTaskDO campaignBirthdayTaskDO) {
		campaignBirthdayTaskDAO.insert(campaignBirthdayTaskDO);
	}

    /**
	 * 插入campaign_birthday_task表数据
	 */
	public void insertCampaignBirthdayTask(
			Long id, 
			String executeTime, 
			String shortBirthday, 
			Long total, 
			String status, 
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
		CampaignBirthdayTaskDO campaignBirthdayTaskDO = new CampaignBirthdayTaskDO();
		campaignBirthdayTaskDO.setId(id);
		campaignBirthdayTaskDO.setExecuteTime(executeTime);
		campaignBirthdayTaskDO.setShortBirthday(shortBirthday);
		campaignBirthdayTaskDO.setTotal(total);
		campaignBirthdayTaskDO.setStatus(status);
		campaignBirthdayTaskDO.setGid(gid);
		campaignBirthdayTaskDO.setRawAddTime(rawAddTime);
		campaignBirthdayTaskDO.setRawUpdateTime(rawUpdateTime);
		campaignBirthdayTaskDAO.insert(campaignBirthdayTaskDO);
	}

    /**
     * 删除campaign_birthday_task表所有数据
     */
    public void cleanCampaignBirthdayTask() {
        CampaignBirthdayTaskDOExample exam = new CampaignBirthdayTaskDOExample();
        exam.createCriteria();
        campaignBirthdayTaskDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除campaign_birthday_task表数据
	 */
	public void cleanCampaignBirthdayTaskById(Long id) {
		CampaignBirthdayTaskDOExample exam = new CampaignBirthdayTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		campaignBirthdayTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除campaign_birthday_task表数据
	 */
	public void cleanCampaignBirthdayTaskByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		CampaignBirthdayTaskDOExample exam = new CampaignBirthdayTaskDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		campaignBirthdayTaskDAO.deleteByExample(exam);
	}

    /**
     * 查询campaign_birthday_task表所有数据
     */
    public List<CampaignBirthdayTaskDO> findCampaignBirthdayTaskAll() {
        CampaignBirthdayTaskDOExample exam = new CampaignBirthdayTaskDOExample();
        exam.createCriteria();
		return campaignBirthdayTaskDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询campaign_birthday_task表数据
	 */
	public List<CampaignBirthdayTaskDO> findCampaignBirthdayTaskById(Long id) {
		CampaignBirthdayTaskDOExample exam = new CampaignBirthdayTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return campaignBirthdayTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询campaign_birthday_task表数据
	 */
	public List<CampaignBirthdayTaskDO> findCampaignBirthdayTaskByGid(String gid) {
		CampaignBirthdayTaskDOExample exam = new CampaignBirthdayTaskDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return campaignBirthdayTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新campaign_birthday_task表数据
	 */
	public void updateCampaignBirthdayTaskById(Long id,CampaignBirthdayTaskDO campaignBirthdayTaskDO) {
		CampaignBirthdayTaskDOExample exam = new CampaignBirthdayTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		campaignBirthdayTaskDAO.updateByExample(campaignBirthdayTaskDO, exam);
	}

    /**
	 * 根据gid更新campaign_birthday_task表数据
	 */
	public void updateCampaignBirthdayTaskByGid(String gid,CampaignBirthdayTaskDO campaignBirthdayTaskDO) {
		CampaignBirthdayTaskDOExample exam = new CampaignBirthdayTaskDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		campaignBirthdayTaskDAO.updateByExample(campaignBirthdayTaskDO, exam);
	}

    /**
	 * 断言campaign_compensate_task表
	 */
	public void campaignCompensateTaskAssert(
	        CampaignCompensateTaskDO campaignCompensateTaskDO,
			Long id, 
			String eventId, 
			String userId, 
			String giveType, 
			String campaignNo, 
			String campaignType, 
			String context, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, campaignCompensateTaskDO.getId());
        assertEquals(eventId, campaignCompensateTaskDO.getEventId());
        assertEquals(userId, campaignCompensateTaskDO.getUserId());
        assertEquals(giveType, campaignCompensateTaskDO.getGiveType());
        assertEquals(campaignNo, campaignCompensateTaskDO.getCampaignNo());
        assertEquals(campaignType, campaignCompensateTaskDO.getCampaignType());
        assertEquals(context, campaignCompensateTaskDO.getContext());
        assertEquals(rawAddTime, campaignCompensateTaskDO.getRawAddTime());
        assertEquals(rawUpdateTime, campaignCompensateTaskDO.getRawUpdateTime());
	}

	/**
	 * 断言campaign_compensate_task表数据
	 */
	public void assertCampaignCompensateTask(CampaignCompensateTaskDO expect, CampaignCompensateTaskDO campaignCompensateTaskDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			campaignCompensateTaskDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != campaignCompensateTaskDO.getRawAddTime());
		expect.setRawAddTime(campaignCompensateTaskDO.getRawAddTime());
        Assertions.assertTrue(null != campaignCompensateTaskDO.getRawUpdateTime());
		expect.setRawUpdateTime(campaignCompensateTaskDO.getRawUpdateTime());
		Assertions.assertEquals(expect, campaignCompensateTaskDO);
	}

    /**
	 * 插入campaign_compensate_task表数据
	 */
	public void insertCampaignCompensateTask(CampaignCompensateTaskDO campaignCompensateTaskDO) {
		campaignCompensateTaskDAO.insert(campaignCompensateTaskDO);
	}

    /**
	 * 插入campaign_compensate_task表数据
	 */
	public void insertCampaignCompensateTask(
			Long id, 
			String eventId, 
			String userId, 
			String giveType, 
			String campaignNo, 
			String campaignType, 
			String context, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		CampaignCompensateTaskDO campaignCompensateTaskDO = new CampaignCompensateTaskDO();
		campaignCompensateTaskDO.setId(id);
		campaignCompensateTaskDO.setEventId(eventId);
		campaignCompensateTaskDO.setUserId(userId);
		campaignCompensateTaskDO.setGiveType(giveType);
		campaignCompensateTaskDO.setCampaignNo(campaignNo);
		campaignCompensateTaskDO.setCampaignType(campaignType);
		campaignCompensateTaskDO.setContext(context);
		campaignCompensateTaskDO.setRawAddTime(rawAddTime);
		campaignCompensateTaskDO.setRawUpdateTime(rawUpdateTime);
		campaignCompensateTaskDAO.insert(campaignCompensateTaskDO);
	}

    /**
     * 删除campaign_compensate_task表所有数据
     */
    public void cleanCampaignCompensateTask() {
        CampaignCompensateTaskDOExample exam = new CampaignCompensateTaskDOExample();
        exam.createCriteria();
        campaignCompensateTaskDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除campaign_compensate_task表数据
	 */
	public void cleanCampaignCompensateTaskById(Long id) {
		CampaignCompensateTaskDOExample exam = new CampaignCompensateTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		campaignCompensateTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据eventId删除campaign_compensate_task表数据
	 */
	public void cleanCampaignCompensateTaskByEventId(String eventId) {
        if (StringUtils.isBlank(eventId)){
            eventId = "test_eventId";
        }
		CampaignCompensateTaskDOExample exam = new CampaignCompensateTaskDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		campaignCompensateTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除campaign_compensate_task表数据
	 */
	public void cleanCampaignCompensateTaskByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		CampaignCompensateTaskDOExample exam = new CampaignCompensateTaskDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		campaignCompensateTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNo删除campaign_compensate_task表数据
	 */
	public void cleanCampaignCompensateTaskByCampaignNo(String campaignNo) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
		CampaignCompensateTaskDOExample exam = new CampaignCompensateTaskDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		campaignCompensateTaskDAO.deleteByExample(exam);
	}

    /**
     * 查询campaign_compensate_task表所有数据
     */
    public List<CampaignCompensateTaskDO> findCampaignCompensateTaskAll() {
        CampaignCompensateTaskDOExample exam = new CampaignCompensateTaskDOExample();
        exam.createCriteria();
		return campaignCompensateTaskDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询campaign_compensate_task表数据
	 */
	public List<CampaignCompensateTaskDO> findCampaignCompensateTaskById(Long id) {
		CampaignCompensateTaskDOExample exam = new CampaignCompensateTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return campaignCompensateTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据eventId查询campaign_compensate_task表数据
	 */
	public List<CampaignCompensateTaskDO> findCampaignCompensateTaskByEventId(String eventId) {
		CampaignCompensateTaskDOExample exam = new CampaignCompensateTaskDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		return campaignCompensateTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询campaign_compensate_task表数据
	 */
	public List<CampaignCompensateTaskDO> findCampaignCompensateTaskByUserId(String userId) {
		CampaignCompensateTaskDOExample exam = new CampaignCompensateTaskDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return campaignCompensateTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNo查询campaign_compensate_task表数据
	 */
	public List<CampaignCompensateTaskDO> findCampaignCompensateTaskByCampaignNo(String campaignNo) {
		CampaignCompensateTaskDOExample exam = new CampaignCompensateTaskDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		return campaignCompensateTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新campaign_compensate_task表数据
	 */
	public void updateCampaignCompensateTaskById(Long id,CampaignCompensateTaskDO campaignCompensateTaskDO) {
		CampaignCompensateTaskDOExample exam = new CampaignCompensateTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		campaignCompensateTaskDAO.updateByExample(campaignCompensateTaskDO, exam);
	}

    /**
	 * 根据eventId更新campaign_compensate_task表数据
	 */
	public void updateCampaignCompensateTaskByEventId(String eventId,CampaignCompensateTaskDO campaignCompensateTaskDO) {
		CampaignCompensateTaskDOExample exam = new CampaignCompensateTaskDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		campaignCompensateTaskDAO.updateByExample(campaignCompensateTaskDO, exam);
	}

    /**
	 * 根据userId更新campaign_compensate_task表数据
	 */
	public void updateCampaignCompensateTaskByUserId(String userId,CampaignCompensateTaskDO campaignCompensateTaskDO) {
		CampaignCompensateTaskDOExample exam = new CampaignCompensateTaskDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		campaignCompensateTaskDAO.updateByExample(campaignCompensateTaskDO, exam);
	}

    /**
	 * 根据campaignNo更新campaign_compensate_task表数据
	 */
	public void updateCampaignCompensateTaskByCampaignNo(String campaignNo,CampaignCompensateTaskDO campaignCompensateTaskDO) {
		CampaignCompensateTaskDOExample exam = new CampaignCompensateTaskDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		campaignCompensateTaskDAO.updateByExample(campaignCompensateTaskDO, exam);
	}

    /**
	 * 断言campaign_template表
	 */
	public void campaignTemplateAssert(
	        CampaignTemplateDO campaignTemplateDO,
			Long id, 
			String templateName, 
			String templateType, 
			String templateNo, 
			String description, 
			String coverPhoto, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String campaignTemplateRules
	) {
        assertEquals(id, campaignTemplateDO.getId());
        assertEquals(templateName, campaignTemplateDO.getTemplateName());
        assertEquals(templateType, campaignTemplateDO.getTemplateType());
        assertEquals(templateNo, campaignTemplateDO.getTemplateNo());
        assertEquals(description, campaignTemplateDO.getDescription());
        assertEquals(coverPhoto, campaignTemplateDO.getCoverPhoto());
        assertEquals(status, campaignTemplateDO.getStatus());
        assertEquals(rawAddTime, campaignTemplateDO.getRawAddTime());
        assertEquals(rawUpdateTime, campaignTemplateDO.getRawUpdateTime());
        assertEquals(campaignTemplateRules, campaignTemplateDO.getCampaignTemplateRules());
	}

	/**
	 * 断言campaign_template表数据
	 */
	public void assertCampaignTemplate(CampaignTemplateDO expect, CampaignTemplateDO campaignTemplateDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			campaignTemplateDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != campaignTemplateDO.getRawAddTime());
		expect.setRawAddTime(campaignTemplateDO.getRawAddTime());
        Assertions.assertTrue(null != campaignTemplateDO.getRawUpdateTime());
		expect.setRawUpdateTime(campaignTemplateDO.getRawUpdateTime());
		Assertions.assertEquals(expect, campaignTemplateDO);
	}

    /**
	 * 插入campaign_template表数据
	 */
	public void insertCampaignTemplate(CampaignTemplateDO campaignTemplateDO) {
		campaignTemplateDAO.insert(campaignTemplateDO);
	}

    /**
	 * 插入campaign_template表数据
	 */
	public void insertCampaignTemplate(
			Long id, 
			String templateName, 
			String templateType, 
			String templateNo, 
			String description, 
			String coverPhoto, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String campaignTemplateRules
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		CampaignTemplateDO campaignTemplateDO = new CampaignTemplateDO();
		campaignTemplateDO.setId(id);
		campaignTemplateDO.setTemplateName(templateName);
		campaignTemplateDO.setTemplateType(templateType);
		campaignTemplateDO.setTemplateNo(templateNo);
		campaignTemplateDO.setDescription(description);
		campaignTemplateDO.setCoverPhoto(coverPhoto);
		campaignTemplateDO.setStatus(status);
		campaignTemplateDO.setRawAddTime(rawAddTime);
		campaignTemplateDO.setRawUpdateTime(rawUpdateTime);
		campaignTemplateDO.setCampaignTemplateRules(campaignTemplateRules);
		campaignTemplateDAO.insert(campaignTemplateDO);
	}

    /**
     * 删除campaign_template表所有数据
     */
    public void cleanCampaignTemplate() {
        CampaignTemplateDOExample exam = new CampaignTemplateDOExample();
        exam.createCriteria();
        campaignTemplateDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除campaign_template表数据
	 */
	public void cleanCampaignTemplateById(Long id) {
		CampaignTemplateDOExample exam = new CampaignTemplateDOExample();
		exam.createCriteria().andIdEqualTo(id);
		campaignTemplateDAO.deleteByExample(exam);
	}

	/**
	* 根据templateName删除campaign_template表数据
	*/
	public void cleanCampaignTemplateByTemplateName(String templateName) {
        if (StringUtils.isBlank(templateName)){
            templateName = "test_templateName";
        }
		CampaignTemplateDOExample exam = new CampaignTemplateDOExample();
		exam.createCriteria().andTemplateNameEqualTo(templateName);
		campaignTemplateDAO.deleteByExample(exam);
	}

	/**
	 * 根据templateNo删除campaign_template表数据
	 */
	public void cleanCampaignTemplateByTemplateNo(String templateNo) {
        if (StringUtils.isBlank(templateNo)){
            templateNo = "test_templateNo";
        }
		CampaignTemplateDOExample exam = new CampaignTemplateDOExample();
		exam.createCriteria().andTemplateNoEqualTo(templateNo);
		campaignTemplateDAO.deleteByExample(exam);
	}

    /**
     * 查询campaign_template表所有数据
     */
    public List<CampaignTemplateDO> findCampaignTemplateAll() {
        CampaignTemplateDOExample exam = new CampaignTemplateDOExample();
        exam.createCriteria();
		return campaignTemplateDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询campaign_template表数据
	 */
	public List<CampaignTemplateDO> findCampaignTemplateById(Long id) {
		CampaignTemplateDOExample exam = new CampaignTemplateDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return campaignTemplateDAO.selectByExample(exam);
	}

	/**
	* 根据templateName查询campaign_template表数据
	*/
	public List<CampaignTemplateDO> findCampaignTemplateByTemplateName(String templateName) {
		CampaignTemplateDOExample exam = new CampaignTemplateDOExample();
		exam.createCriteria().andTemplateNameEqualTo(templateName);
		return campaignTemplateDAO.selectByExample(exam);
	}

    /**
	 * 根据templateNo查询campaign_template表数据
	 */
	public List<CampaignTemplateDO> findCampaignTemplateByTemplateNo(String templateNo) {
		CampaignTemplateDOExample exam = new CampaignTemplateDOExample();
		exam.createCriteria().andTemplateNoEqualTo(templateNo);
		return campaignTemplateDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新campaign_template表数据
	 */
	public void updateCampaignTemplateById(Long id,CampaignTemplateDO campaignTemplateDO) {
		CampaignTemplateDOExample exam = new CampaignTemplateDOExample();
		exam.createCriteria().andIdEqualTo(id);
		campaignTemplateDAO.updateByExample(campaignTemplateDO, exam);
	}

	/**
	* 根据templateName更新campaign_template表数据
	*/
	public void updateCampaignTemplateByTemplateName(String templateName,CampaignTemplateDO campaignTemplateDO) {
		CampaignTemplateDOExample exam = new CampaignTemplateDOExample();
		exam.createCriteria().andTemplateNameEqualTo(templateName);
		campaignTemplateDAO.updateByExample(campaignTemplateDO, exam);
	}

    /**
	 * 根据templateNo更新campaign_template表数据
	 */
	public void updateCampaignTemplateByTemplateNo(String templateNo,CampaignTemplateDO campaignTemplateDO) {
		CampaignTemplateDOExample exam = new CampaignTemplateDOExample();
		exam.createCriteria().andTemplateNoEqualTo(templateNo);
		campaignTemplateDAO.updateByExample(campaignTemplateDO, exam);
	}

    /**
	 * 断言campaign_template_partner_list表
	 */
	public void campaignTemplatePartnerListAssert(
	        CampaignTemplatePartnerListDO campaignTemplatePartnerListDO,
			Long id, 
			String templateNo, 
			String partnerId, 
			String platPartnerId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, campaignTemplatePartnerListDO.getId());
        assertEquals(templateNo, campaignTemplatePartnerListDO.getTemplateNo());
        assertEquals(partnerId, campaignTemplatePartnerListDO.getPartnerId());
        assertEquals(platPartnerId, campaignTemplatePartnerListDO.getPlatPartnerId());
        assertEquals(rawAddTime, campaignTemplatePartnerListDO.getRawAddTime());
        assertEquals(rawUpdateTime, campaignTemplatePartnerListDO.getRawUpdateTime());
	}

	/**
	 * 断言campaign_template_partner_list表数据
	 */
	public void assertCampaignTemplatePartnerList(CampaignTemplatePartnerListDO expect, CampaignTemplatePartnerListDO campaignTemplatePartnerListDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			campaignTemplatePartnerListDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != campaignTemplatePartnerListDO.getRawAddTime());
		expect.setRawAddTime(campaignTemplatePartnerListDO.getRawAddTime());
        Assertions.assertTrue(null != campaignTemplatePartnerListDO.getRawUpdateTime());
		expect.setRawUpdateTime(campaignTemplatePartnerListDO.getRawUpdateTime());
		Assertions.assertEquals(expect, campaignTemplatePartnerListDO);
	}

    /**
	 * 插入campaign_template_partner_list表数据
	 */
	public void insertCampaignTemplatePartnerList(CampaignTemplatePartnerListDO campaignTemplatePartnerListDO) {
		campaignTemplatePartnerListDAO.insert(campaignTemplatePartnerListDO);
	}

    /**
	 * 插入campaign_template_partner_list表数据
	 */
	public void insertCampaignTemplatePartnerList(
			Long id, 
			String templateNo, 
			String partnerId, 
			String platPartnerId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		CampaignTemplatePartnerListDO campaignTemplatePartnerListDO = new CampaignTemplatePartnerListDO();
		campaignTemplatePartnerListDO.setId(id);
		campaignTemplatePartnerListDO.setTemplateNo(templateNo);
		campaignTemplatePartnerListDO.setPartnerId(partnerId);
		campaignTemplatePartnerListDO.setPlatPartnerId(platPartnerId);
		campaignTemplatePartnerListDO.setRawAddTime(rawAddTime);
		campaignTemplatePartnerListDO.setRawUpdateTime(rawUpdateTime);
		campaignTemplatePartnerListDAO.insert(campaignTemplatePartnerListDO);
	}

    /**
     * 删除campaign_template_partner_list表所有数据
     */
    public void cleanCampaignTemplatePartnerList() {
        CampaignTemplatePartnerListDOExample exam = new CampaignTemplatePartnerListDOExample();
        exam.createCriteria();
        campaignTemplatePartnerListDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除campaign_template_partner_list表数据
	 */
	public void cleanCampaignTemplatePartnerListById(Long id) {
		CampaignTemplatePartnerListDOExample exam = new CampaignTemplatePartnerListDOExample();
		exam.createCriteria().andIdEqualTo(id);
		campaignTemplatePartnerListDAO.deleteByExample(exam);
	}

	/**
	 * 根据templateNo删除campaign_template_partner_list表数据
	 */
	public void cleanCampaignTemplatePartnerListByTemplateNo(String templateNo) {
        if (StringUtils.isBlank(templateNo)){
            templateNo = "test_templateNo";
        }
		CampaignTemplatePartnerListDOExample exam = new CampaignTemplatePartnerListDOExample();
		exam.createCriteria().andTemplateNoEqualTo(templateNo);
		campaignTemplatePartnerListDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除campaign_template_partner_list表数据
	 */
	public void cleanCampaignTemplatePartnerListByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		CampaignTemplatePartnerListDOExample exam = new CampaignTemplatePartnerListDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		campaignTemplatePartnerListDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除campaign_template_partner_list表数据
	 */
	public void cleanCampaignTemplatePartnerListByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		CampaignTemplatePartnerListDOExample exam = new CampaignTemplatePartnerListDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		campaignTemplatePartnerListDAO.deleteByExample(exam);
	}

    /**
     * 查询campaign_template_partner_list表所有数据
     */
    public List<CampaignTemplatePartnerListDO> findCampaignTemplatePartnerListAll() {
        CampaignTemplatePartnerListDOExample exam = new CampaignTemplatePartnerListDOExample();
        exam.createCriteria();
		return campaignTemplatePartnerListDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询campaign_template_partner_list表数据
	 */
	public List<CampaignTemplatePartnerListDO> findCampaignTemplatePartnerListById(Long id) {
		CampaignTemplatePartnerListDOExample exam = new CampaignTemplatePartnerListDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return campaignTemplatePartnerListDAO.selectByExample(exam);
	}

    /**
	 * 根据templateNo查询campaign_template_partner_list表数据
	 */
	public List<CampaignTemplatePartnerListDO> findCampaignTemplatePartnerListByTemplateNo(String templateNo) {
		CampaignTemplatePartnerListDOExample exam = new CampaignTemplatePartnerListDOExample();
		exam.createCriteria().andTemplateNoEqualTo(templateNo);
		return campaignTemplatePartnerListDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询campaign_template_partner_list表数据
	 */
	public List<CampaignTemplatePartnerListDO> findCampaignTemplatePartnerListByPartnerId(String partnerId) {
		CampaignTemplatePartnerListDOExample exam = new CampaignTemplatePartnerListDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return campaignTemplatePartnerListDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询campaign_template_partner_list表数据
	 */
	public List<CampaignTemplatePartnerListDO> findCampaignTemplatePartnerListByPlatPartnerId(String platPartnerId) {
		CampaignTemplatePartnerListDOExample exam = new CampaignTemplatePartnerListDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return campaignTemplatePartnerListDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新campaign_template_partner_list表数据
	 */
	public void updateCampaignTemplatePartnerListById(Long id,CampaignTemplatePartnerListDO campaignTemplatePartnerListDO) {
		CampaignTemplatePartnerListDOExample exam = new CampaignTemplatePartnerListDOExample();
		exam.createCriteria().andIdEqualTo(id);
		campaignTemplatePartnerListDAO.updateByExample(campaignTemplatePartnerListDO, exam);
	}

    /**
	 * 根据templateNo更新campaign_template_partner_list表数据
	 */
	public void updateCampaignTemplatePartnerListByTemplateNo(String templateNo,CampaignTemplatePartnerListDO campaignTemplatePartnerListDO) {
		CampaignTemplatePartnerListDOExample exam = new CampaignTemplatePartnerListDOExample();
		exam.createCriteria().andTemplateNoEqualTo(templateNo);
		campaignTemplatePartnerListDAO.updateByExample(campaignTemplatePartnerListDO, exam);
	}

    /**
	 * 根据partnerId更新campaign_template_partner_list表数据
	 */
	public void updateCampaignTemplatePartnerListByPartnerId(String partnerId,CampaignTemplatePartnerListDO campaignTemplatePartnerListDO) {
		CampaignTemplatePartnerListDOExample exam = new CampaignTemplatePartnerListDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		campaignTemplatePartnerListDAO.updateByExample(campaignTemplatePartnerListDO, exam);
	}

    /**
	 * 根据platPartnerId更新campaign_template_partner_list表数据
	 */
	public void updateCampaignTemplatePartnerListByPlatPartnerId(String platPartnerId,CampaignTemplatePartnerListDO campaignTemplatePartnerListDO) {
		CampaignTemplatePartnerListDOExample exam = new CampaignTemplatePartnerListDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		campaignTemplatePartnerListDAO.updateByExample(campaignTemplatePartnerListDO, exam);
	}

    /**
	 * 断言campaign_user_partake_record表
	 */
	public void campaignUserPartakeRecordAssert(
	        CampaignUserPartakeRecordDO campaignUserPartakeRecordDO,
			Long id, 
			String eventId, 
			String platPartnerId, 
			String partnerId, 
			String userId, 
			String mobile, 
			String name, 
			String campaignNo, 
			String campaignType, 
			String status, 
			Date partakeTime, 
			Date finishTime, 
			String realName, 
			String giftNo, 
			String giftName, 
			String gid, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String giveDetails
	) {
        assertEquals(id, campaignUserPartakeRecordDO.getId());
        assertEquals(eventId, campaignUserPartakeRecordDO.getEventId());
        assertEquals(platPartnerId, campaignUserPartakeRecordDO.getPlatPartnerId());
        assertEquals(partnerId, campaignUserPartakeRecordDO.getPartnerId());
        assertEquals(userId, campaignUserPartakeRecordDO.getUserId());
        assertEquals(mobile, campaignUserPartakeRecordDO.getMobile());
        assertEquals(name, campaignUserPartakeRecordDO.getName());
        assertEquals(campaignNo, campaignUserPartakeRecordDO.getCampaignNo());
        assertEquals(campaignType, campaignUserPartakeRecordDO.getCampaignType());
        assertEquals(status, campaignUserPartakeRecordDO.getStatus());
        assertEquals(partakeTime, campaignUserPartakeRecordDO.getPartakeTime());
        assertEquals(finishTime, campaignUserPartakeRecordDO.getFinishTime());
        assertEquals(realName, campaignUserPartakeRecordDO.getRealName());
        assertEquals(giftNo, campaignUserPartakeRecordDO.getGiftNo());
        assertEquals(giftName, campaignUserPartakeRecordDO.getGiftName());
        assertEquals(gid, campaignUserPartakeRecordDO.getGid());
        assertEquals(rawAddTime, campaignUserPartakeRecordDO.getRawAddTime());
        assertEquals(rawUpdateTime, campaignUserPartakeRecordDO.getRawUpdateTime());
        assertEquals(giveDetails, campaignUserPartakeRecordDO.getGiveDetails());
	}

	/**
	 * 断言campaign_user_partake_record表数据
	 */
	public void assertCampaignUserPartakeRecord(CampaignUserPartakeRecordDO expect, CampaignUserPartakeRecordDO campaignUserPartakeRecordDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			campaignUserPartakeRecordDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != campaignUserPartakeRecordDO.getRawAddTime());
		expect.setRawAddTime(campaignUserPartakeRecordDO.getRawAddTime());
        Assertions.assertTrue(null != campaignUserPartakeRecordDO.getRawUpdateTime());
		expect.setRawUpdateTime(campaignUserPartakeRecordDO.getRawUpdateTime());
		Assertions.assertEquals(expect, campaignUserPartakeRecordDO);
	}

    /**
	 * 插入campaign_user_partake_record表数据
	 */
	public void insertCampaignUserPartakeRecord(CampaignUserPartakeRecordDO campaignUserPartakeRecordDO) {
		campaignUserPartakeRecordDAO.insert(campaignUserPartakeRecordDO);
	}

    /**
	 * 插入campaign_user_partake_record表数据
	 */
	public void insertCampaignUserPartakeRecord(
			Long id, 
			String eventId, 
			String platPartnerId, 
			String partnerId, 
			String userId, 
			String mobile, 
			String name, 
			String campaignNo, 
			String campaignType, 
			String status, 
			Date partakeTime, 
			Date finishTime, 
			String realName, 
			String giftNo, 
			String giftName, 
			String gid, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String giveDetails
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		CampaignUserPartakeRecordDO campaignUserPartakeRecordDO = new CampaignUserPartakeRecordDO();
		campaignUserPartakeRecordDO.setId(id);
		campaignUserPartakeRecordDO.setEventId(eventId);
		campaignUserPartakeRecordDO.setPlatPartnerId(platPartnerId);
		campaignUserPartakeRecordDO.setPartnerId(partnerId);
		campaignUserPartakeRecordDO.setUserId(userId);
		campaignUserPartakeRecordDO.setMobile(mobile);
		campaignUserPartakeRecordDO.setName(name);
		campaignUserPartakeRecordDO.setCampaignNo(campaignNo);
		campaignUserPartakeRecordDO.setCampaignType(campaignType);
		campaignUserPartakeRecordDO.setStatus(status);
		campaignUserPartakeRecordDO.setPartakeTime(partakeTime);
		campaignUserPartakeRecordDO.setFinishTime(finishTime);
		campaignUserPartakeRecordDO.setRealName(realName);
		campaignUserPartakeRecordDO.setGiftNo(giftNo);
		campaignUserPartakeRecordDO.setGiftName(giftName);
		campaignUserPartakeRecordDO.setGid(gid);
		campaignUserPartakeRecordDO.setRawAddTime(rawAddTime);
		campaignUserPartakeRecordDO.setRawUpdateTime(rawUpdateTime);
		campaignUserPartakeRecordDO.setGiveDetails(giveDetails);
		campaignUserPartakeRecordDAO.insert(campaignUserPartakeRecordDO);
	}

    /**
     * 删除campaign_user_partake_record表所有数据
     */
    public void cleanCampaignUserPartakeRecord() {
        CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
        exam.createCriteria();
        campaignUserPartakeRecordDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除campaign_user_partake_record表数据
	 */
	public void cleanCampaignUserPartakeRecordById(Long id) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		campaignUserPartakeRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据eventId删除campaign_user_partake_record表数据
	 */
	public void cleanCampaignUserPartakeRecordByEventId(String eventId) {
        if (StringUtils.isBlank(eventId)){
            eventId = "test_eventId";
        }
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		campaignUserPartakeRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除campaign_user_partake_record表数据
	 */
	public void cleanCampaignUserPartakeRecordByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		campaignUserPartakeRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除campaign_user_partake_record表数据
	 */
	public void cleanCampaignUserPartakeRecordByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		campaignUserPartakeRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除campaign_user_partake_record表数据
	 */
	public void cleanCampaignUserPartakeRecordByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		campaignUserPartakeRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据mobile删除campaign_user_partake_record表数据
	 */
	public void cleanCampaignUserPartakeRecordByMobile(String mobile) {
        if (StringUtils.isBlank(mobile)){
            mobile = "test_mobile";
        }
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		campaignUserPartakeRecordDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除campaign_user_partake_record表数据
	*/
	public void cleanCampaignUserPartakeRecordByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andNameEqualTo(name);
		campaignUserPartakeRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNo删除campaign_user_partake_record表数据
	 */
	public void cleanCampaignUserPartakeRecordByCampaignNo(String campaignNo) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		campaignUserPartakeRecordDAO.deleteByExample(exam);
	}

	/**
	* 根据realName删除campaign_user_partake_record表数据
	*/
	public void cleanCampaignUserPartakeRecordByRealName(String realName) {
        if (StringUtils.isBlank(realName)){
            realName = "test_realName";
        }
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		campaignUserPartakeRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据giftNo删除campaign_user_partake_record表数据
	 */
	public void cleanCampaignUserPartakeRecordByGiftNo(String giftNo) {
        if (StringUtils.isBlank(giftNo)){
            giftNo = "test_giftNo";
        }
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andGiftNoEqualTo(giftNo);
		campaignUserPartakeRecordDAO.deleteByExample(exam);
	}

	/**
	* 根据giftName删除campaign_user_partake_record表数据
	*/
	public void cleanCampaignUserPartakeRecordByGiftName(String giftName) {
        if (StringUtils.isBlank(giftName)){
            giftName = "test_giftName";
        }
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andGiftNameEqualTo(giftName);
		campaignUserPartakeRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除campaign_user_partake_record表数据
	 */
	public void cleanCampaignUserPartakeRecordByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		campaignUserPartakeRecordDAO.deleteByExample(exam);
	}

    /**
     * 查询campaign_user_partake_record表所有数据
     */
    public List<CampaignUserPartakeRecordDO> findCampaignUserPartakeRecordAll() {
        CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
        exam.createCriteria();
		return campaignUserPartakeRecordDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询campaign_user_partake_record表数据
	 */
	public List<CampaignUserPartakeRecordDO> findCampaignUserPartakeRecordById(Long id) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return campaignUserPartakeRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据eventId查询campaign_user_partake_record表数据
	 */
	public List<CampaignUserPartakeRecordDO> findCampaignUserPartakeRecordByEventId(String eventId) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		return campaignUserPartakeRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询campaign_user_partake_record表数据
	 */
	public List<CampaignUserPartakeRecordDO> findCampaignUserPartakeRecordByPlatPartnerId(String platPartnerId) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return campaignUserPartakeRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询campaign_user_partake_record表数据
	 */
	public List<CampaignUserPartakeRecordDO> findCampaignUserPartakeRecordByPartnerId(String partnerId) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return campaignUserPartakeRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询campaign_user_partake_record表数据
	 */
	public List<CampaignUserPartakeRecordDO> findCampaignUserPartakeRecordByUserId(String userId) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return campaignUserPartakeRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据mobile查询campaign_user_partake_record表数据
	 */
	public List<CampaignUserPartakeRecordDO> findCampaignUserPartakeRecordByMobile(String mobile) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		return campaignUserPartakeRecordDAO.selectByExample(exam);
	}

	/**
	* 根据name查询campaign_user_partake_record表数据
	*/
	public List<CampaignUserPartakeRecordDO> findCampaignUserPartakeRecordByName(String name) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return campaignUserPartakeRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNo查询campaign_user_partake_record表数据
	 */
	public List<CampaignUserPartakeRecordDO> findCampaignUserPartakeRecordByCampaignNo(String campaignNo) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		return campaignUserPartakeRecordDAO.selectByExample(exam);
	}

	/**
	* 根据realName查询campaign_user_partake_record表数据
	*/
	public List<CampaignUserPartakeRecordDO> findCampaignUserPartakeRecordByRealName(String realName) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		return campaignUserPartakeRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据giftNo查询campaign_user_partake_record表数据
	 */
	public List<CampaignUserPartakeRecordDO> findCampaignUserPartakeRecordByGiftNo(String giftNo) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andGiftNoEqualTo(giftNo);
		return campaignUserPartakeRecordDAO.selectByExample(exam);
	}

	/**
	* 根据giftName查询campaign_user_partake_record表数据
	*/
	public List<CampaignUserPartakeRecordDO> findCampaignUserPartakeRecordByGiftName(String giftName) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andGiftNameEqualTo(giftName);
		return campaignUserPartakeRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询campaign_user_partake_record表数据
	 */
	public List<CampaignUserPartakeRecordDO> findCampaignUserPartakeRecordByGid(String gid) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return campaignUserPartakeRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新campaign_user_partake_record表数据
	 */
	public void updateCampaignUserPartakeRecordById(Long id,CampaignUserPartakeRecordDO campaignUserPartakeRecordDO) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		campaignUserPartakeRecordDAO.updateByExample(campaignUserPartakeRecordDO, exam);
	}

    /**
	 * 根据eventId更新campaign_user_partake_record表数据
	 */
	public void updateCampaignUserPartakeRecordByEventId(String eventId,CampaignUserPartakeRecordDO campaignUserPartakeRecordDO) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		campaignUserPartakeRecordDAO.updateByExample(campaignUserPartakeRecordDO, exam);
	}

    /**
	 * 根据platPartnerId更新campaign_user_partake_record表数据
	 */
	public void updateCampaignUserPartakeRecordByPlatPartnerId(String platPartnerId,CampaignUserPartakeRecordDO campaignUserPartakeRecordDO) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		campaignUserPartakeRecordDAO.updateByExample(campaignUserPartakeRecordDO, exam);
	}

    /**
	 * 根据partnerId更新campaign_user_partake_record表数据
	 */
	public void updateCampaignUserPartakeRecordByPartnerId(String partnerId,CampaignUserPartakeRecordDO campaignUserPartakeRecordDO) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		campaignUserPartakeRecordDAO.updateByExample(campaignUserPartakeRecordDO, exam);
	}

    /**
	 * 根据userId更新campaign_user_partake_record表数据
	 */
	public void updateCampaignUserPartakeRecordByUserId(String userId,CampaignUserPartakeRecordDO campaignUserPartakeRecordDO) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		campaignUserPartakeRecordDAO.updateByExample(campaignUserPartakeRecordDO, exam);
	}

    /**
	 * 根据mobile更新campaign_user_partake_record表数据
	 */
	public void updateCampaignUserPartakeRecordByMobile(String mobile,CampaignUserPartakeRecordDO campaignUserPartakeRecordDO) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andMobileEqualTo(mobile);
		campaignUserPartakeRecordDAO.updateByExample(campaignUserPartakeRecordDO, exam);
	}

	/**
	* 根据name更新campaign_user_partake_record表数据
	*/
	public void updateCampaignUserPartakeRecordByName(String name,CampaignUserPartakeRecordDO campaignUserPartakeRecordDO) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andNameEqualTo(name);
		campaignUserPartakeRecordDAO.updateByExample(campaignUserPartakeRecordDO, exam);
	}

    /**
	 * 根据campaignNo更新campaign_user_partake_record表数据
	 */
	public void updateCampaignUserPartakeRecordByCampaignNo(String campaignNo,CampaignUserPartakeRecordDO campaignUserPartakeRecordDO) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		campaignUserPartakeRecordDAO.updateByExample(campaignUserPartakeRecordDO, exam);
	}

	/**
	* 根据realName更新campaign_user_partake_record表数据
	*/
	public void updateCampaignUserPartakeRecordByRealName(String realName,CampaignUserPartakeRecordDO campaignUserPartakeRecordDO) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		campaignUserPartakeRecordDAO.updateByExample(campaignUserPartakeRecordDO, exam);
	}

    /**
	 * 根据giftNo更新campaign_user_partake_record表数据
	 */
	public void updateCampaignUserPartakeRecordByGiftNo(String giftNo,CampaignUserPartakeRecordDO campaignUserPartakeRecordDO) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andGiftNoEqualTo(giftNo);
		campaignUserPartakeRecordDAO.updateByExample(campaignUserPartakeRecordDO, exam);
	}

	/**
	* 根据giftName更新campaign_user_partake_record表数据
	*/
	public void updateCampaignUserPartakeRecordByGiftName(String giftName,CampaignUserPartakeRecordDO campaignUserPartakeRecordDO) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andGiftNameEqualTo(giftName);
		campaignUserPartakeRecordDAO.updateByExample(campaignUserPartakeRecordDO, exam);
	}

    /**
	 * 根据gid更新campaign_user_partake_record表数据
	 */
	public void updateCampaignUserPartakeRecordByGid(String gid,CampaignUserPartakeRecordDO campaignUserPartakeRecordDO) {
		CampaignUserPartakeRecordDOExample exam = new CampaignUserPartakeRecordDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		campaignUserPartakeRecordDAO.updateByExample(campaignUserPartakeRecordDO, exam);
	}

    /**
	 * 断言campaign_user_task表
	 */
	public void campaignUserTaskAssert(
	        CampaignUserTaskDO campaignUserTaskDO,
			Long id, 
			String eventId, 
			String partnerId, 
			String platPartnerId, 
			String userId, 
			String name, 
			String campaignNo, 
			String status, 
			Date executeTime, 
			Date finishTime, 
			String gid, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String user, 
			String giveDetails
	) {
        assertEquals(id, campaignUserTaskDO.getId());
        assertEquals(eventId, campaignUserTaskDO.getEventId());
        assertEquals(partnerId, campaignUserTaskDO.getPartnerId());
        assertEquals(platPartnerId, campaignUserTaskDO.getPlatPartnerId());
        assertEquals(userId, campaignUserTaskDO.getUserId());
        assertEquals(name, campaignUserTaskDO.getName());
        assertEquals(campaignNo, campaignUserTaskDO.getCampaignNo());
        assertEquals(status, campaignUserTaskDO.getStatus());
        assertEquals(executeTime, campaignUserTaskDO.getExecuteTime());
        assertEquals(finishTime, campaignUserTaskDO.getFinishTime());
        assertEquals(gid, campaignUserTaskDO.getGid());
        assertEquals(rawAddTime, campaignUserTaskDO.getRawAddTime());
        assertEquals(rawUpdateTime, campaignUserTaskDO.getRawUpdateTime());
        assertEquals(user, campaignUserTaskDO.getUser());
        assertEquals(giveDetails, campaignUserTaskDO.getGiveDetails());
	}

	/**
	 * 断言campaign_user_task表数据
	 */
	public void assertCampaignUserTask(CampaignUserTaskDO expect, CampaignUserTaskDO campaignUserTaskDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			campaignUserTaskDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != campaignUserTaskDO.getRawAddTime());
		expect.setRawAddTime(campaignUserTaskDO.getRawAddTime());
        Assertions.assertTrue(null != campaignUserTaskDO.getRawUpdateTime());
		expect.setRawUpdateTime(campaignUserTaskDO.getRawUpdateTime());
		Assertions.assertEquals(expect, campaignUserTaskDO);
	}

    /**
	 * 插入campaign_user_task表数据
	 */
	public void insertCampaignUserTask(CampaignUserTaskDO campaignUserTaskDO) {
		campaignUserTaskDAO.insert(campaignUserTaskDO);
	}

    /**
	 * 插入campaign_user_task表数据
	 */
	public void insertCampaignUserTask(
			Long id, 
			String eventId, 
			String partnerId, 
			String platPartnerId, 
			String userId, 
			String name, 
			String campaignNo, 
			String status, 
			Date executeTime, 
			Date finishTime, 
			String gid, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String user, 
			String giveDetails
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		CampaignUserTaskDO campaignUserTaskDO = new CampaignUserTaskDO();
		campaignUserTaskDO.setId(id);
		campaignUserTaskDO.setEventId(eventId);
		campaignUserTaskDO.setPartnerId(partnerId);
		campaignUserTaskDO.setPlatPartnerId(platPartnerId);
		campaignUserTaskDO.setUserId(userId);
		campaignUserTaskDO.setName(name);
		campaignUserTaskDO.setCampaignNo(campaignNo);
		campaignUserTaskDO.setStatus(status);
		campaignUserTaskDO.setExecuteTime(executeTime);
		campaignUserTaskDO.setFinishTime(finishTime);
		campaignUserTaskDO.setGid(gid);
		campaignUserTaskDO.setRawAddTime(rawAddTime);
		campaignUserTaskDO.setRawUpdateTime(rawUpdateTime);
		campaignUserTaskDO.setUser(user);
		campaignUserTaskDO.setGiveDetails(giveDetails);
		campaignUserTaskDAO.insert(campaignUserTaskDO);
	}

    /**
     * 删除campaign_user_task表所有数据
     */
    public void cleanCampaignUserTask() {
        CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
        exam.createCriteria();
        campaignUserTaskDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除campaign_user_task表数据
	 */
	public void cleanCampaignUserTaskById(Long id) {
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		campaignUserTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据eventId删除campaign_user_task表数据
	 */
	public void cleanCampaignUserTaskByEventId(String eventId) {
        if (StringUtils.isBlank(eventId)){
            eventId = "test_eventId";
        }
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		campaignUserTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除campaign_user_task表数据
	 */
	public void cleanCampaignUserTaskByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		campaignUserTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除campaign_user_task表数据
	 */
	public void cleanCampaignUserTaskByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		campaignUserTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除campaign_user_task表数据
	 */
	public void cleanCampaignUserTaskByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		campaignUserTaskDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除campaign_user_task表数据
	*/
	public void cleanCampaignUserTaskByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andNameEqualTo(name);
		campaignUserTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNo删除campaign_user_task表数据
	 */
	public void cleanCampaignUserTaskByCampaignNo(String campaignNo) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		campaignUserTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除campaign_user_task表数据
	 */
	public void cleanCampaignUserTaskByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		campaignUserTaskDAO.deleteByExample(exam);
	}

    /**
     * 查询campaign_user_task表所有数据
     */
    public List<CampaignUserTaskDO> findCampaignUserTaskAll() {
        CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
        exam.createCriteria();
		return campaignUserTaskDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询campaign_user_task表数据
	 */
	public List<CampaignUserTaskDO> findCampaignUserTaskById(Long id) {
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return campaignUserTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据eventId查询campaign_user_task表数据
	 */
	public List<CampaignUserTaskDO> findCampaignUserTaskByEventId(String eventId) {
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		return campaignUserTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询campaign_user_task表数据
	 */
	public List<CampaignUserTaskDO> findCampaignUserTaskByPartnerId(String partnerId) {
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return campaignUserTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询campaign_user_task表数据
	 */
	public List<CampaignUserTaskDO> findCampaignUserTaskByPlatPartnerId(String platPartnerId) {
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return campaignUserTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询campaign_user_task表数据
	 */
	public List<CampaignUserTaskDO> findCampaignUserTaskByUserId(String userId) {
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return campaignUserTaskDAO.selectByExample(exam);
	}

	/**
	* 根据name查询campaign_user_task表数据
	*/
	public List<CampaignUserTaskDO> findCampaignUserTaskByName(String name) {
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return campaignUserTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNo查询campaign_user_task表数据
	 */
	public List<CampaignUserTaskDO> findCampaignUserTaskByCampaignNo(String campaignNo) {
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		return campaignUserTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询campaign_user_task表数据
	 */
	public List<CampaignUserTaskDO> findCampaignUserTaskByGid(String gid) {
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return campaignUserTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新campaign_user_task表数据
	 */
	public void updateCampaignUserTaskById(Long id,CampaignUserTaskDO campaignUserTaskDO) {
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		campaignUserTaskDAO.updateByExample(campaignUserTaskDO, exam);
	}

    /**
	 * 根据eventId更新campaign_user_task表数据
	 */
	public void updateCampaignUserTaskByEventId(String eventId,CampaignUserTaskDO campaignUserTaskDO) {
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		campaignUserTaskDAO.updateByExample(campaignUserTaskDO, exam);
	}

    /**
	 * 根据partnerId更新campaign_user_task表数据
	 */
	public void updateCampaignUserTaskByPartnerId(String partnerId,CampaignUserTaskDO campaignUserTaskDO) {
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		campaignUserTaskDAO.updateByExample(campaignUserTaskDO, exam);
	}

    /**
	 * 根据platPartnerId更新campaign_user_task表数据
	 */
	public void updateCampaignUserTaskByPlatPartnerId(String platPartnerId,CampaignUserTaskDO campaignUserTaskDO) {
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		campaignUserTaskDAO.updateByExample(campaignUserTaskDO, exam);
	}

    /**
	 * 根据userId更新campaign_user_task表数据
	 */
	public void updateCampaignUserTaskByUserId(String userId,CampaignUserTaskDO campaignUserTaskDO) {
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		campaignUserTaskDAO.updateByExample(campaignUserTaskDO, exam);
	}

	/**
	* 根据name更新campaign_user_task表数据
	*/
	public void updateCampaignUserTaskByName(String name,CampaignUserTaskDO campaignUserTaskDO) {
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andNameEqualTo(name);
		campaignUserTaskDAO.updateByExample(campaignUserTaskDO, exam);
	}

    /**
	 * 根据campaignNo更新campaign_user_task表数据
	 */
	public void updateCampaignUserTaskByCampaignNo(String campaignNo,CampaignUserTaskDO campaignUserTaskDO) {
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		campaignUserTaskDAO.updateByExample(campaignUserTaskDO, exam);
	}

    /**
	 * 根据gid更新campaign_user_task表数据
	 */
	public void updateCampaignUserTaskByGid(String gid,CampaignUserTaskDO campaignUserTaskDO) {
		CampaignUserTaskDOExample exam = new CampaignUserTaskDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		campaignUserTaskDAO.updateByExample(campaignUserTaskDO, exam);
	}

    /**
	 * 断言campaign_user_task_retry表
	 */
	public void campaignUserTaskRetryAssert(
	        CampaignUserTaskRetryDO campaignUserTaskRetryDO,
			Long id, 
			String eventId, 
			String partnerId, 
			String userId, 
			String name, 
			String campaignNo, 
			String status, 
			Date executeTime, 
			Date finishTime, 
			String gid, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String user, 
			String giveDetails
	) {
        assertEquals(id, campaignUserTaskRetryDO.getId());
        assertEquals(eventId, campaignUserTaskRetryDO.getEventId());
        assertEquals(partnerId, campaignUserTaskRetryDO.getPartnerId());
        assertEquals(userId, campaignUserTaskRetryDO.getUserId());
        assertEquals(name, campaignUserTaskRetryDO.getName());
        assertEquals(campaignNo, campaignUserTaskRetryDO.getCampaignNo());
        assertEquals(status, campaignUserTaskRetryDO.getStatus());
        assertEquals(executeTime, campaignUserTaskRetryDO.getExecuteTime());
        assertEquals(finishTime, campaignUserTaskRetryDO.getFinishTime());
        assertEquals(gid, campaignUserTaskRetryDO.getGid());
        assertEquals(rawAddTime, campaignUserTaskRetryDO.getRawAddTime());
        assertEquals(rawUpdateTime, campaignUserTaskRetryDO.getRawUpdateTime());
        assertEquals(user, campaignUserTaskRetryDO.getUser());
        assertEquals(giveDetails, campaignUserTaskRetryDO.getGiveDetails());
	}

	/**
	 * 断言campaign_user_task_retry表数据
	 */
	public void assertCampaignUserTaskRetry(CampaignUserTaskRetryDO expect, CampaignUserTaskRetryDO campaignUserTaskRetryDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			campaignUserTaskRetryDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != campaignUserTaskRetryDO.getRawAddTime());
		expect.setRawAddTime(campaignUserTaskRetryDO.getRawAddTime());
        Assertions.assertTrue(null != campaignUserTaskRetryDO.getRawUpdateTime());
		expect.setRawUpdateTime(campaignUserTaskRetryDO.getRawUpdateTime());
		Assertions.assertEquals(expect, campaignUserTaskRetryDO);
	}

    /**
	 * 插入campaign_user_task_retry表数据
	 */
	public void insertCampaignUserTaskRetry(CampaignUserTaskRetryDO campaignUserTaskRetryDO) {
		campaignUserTaskRetryDAO.insert(campaignUserTaskRetryDO);
	}

    /**
	 * 插入campaign_user_task_retry表数据
	 */
	public void insertCampaignUserTaskRetry(
			Long id, 
			String eventId, 
			String partnerId, 
			String userId, 
			String name, 
			String campaignNo, 
			String status, 
			Date executeTime, 
			Date finishTime, 
			String gid, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String user, 
			String giveDetails
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		CampaignUserTaskRetryDO campaignUserTaskRetryDO = new CampaignUserTaskRetryDO();
		campaignUserTaskRetryDO.setId(id);
		campaignUserTaskRetryDO.setEventId(eventId);
		campaignUserTaskRetryDO.setPartnerId(partnerId);
		campaignUserTaskRetryDO.setUserId(userId);
		campaignUserTaskRetryDO.setName(name);
		campaignUserTaskRetryDO.setCampaignNo(campaignNo);
		campaignUserTaskRetryDO.setStatus(status);
		campaignUserTaskRetryDO.setExecuteTime(executeTime);
		campaignUserTaskRetryDO.setFinishTime(finishTime);
		campaignUserTaskRetryDO.setGid(gid);
		campaignUserTaskRetryDO.setRawAddTime(rawAddTime);
		campaignUserTaskRetryDO.setRawUpdateTime(rawUpdateTime);
		campaignUserTaskRetryDO.setUser(user);
		campaignUserTaskRetryDO.setGiveDetails(giveDetails);
		campaignUserTaskRetryDAO.insert(campaignUserTaskRetryDO);
	}

    /**
     * 删除campaign_user_task_retry表所有数据
     */
    public void cleanCampaignUserTaskRetry() {
        CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
        exam.createCriteria();
        campaignUserTaskRetryDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除campaign_user_task_retry表数据
	 */
	public void cleanCampaignUserTaskRetryById(Long id) {
		CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
		exam.createCriteria().andIdEqualTo(id);
		campaignUserTaskRetryDAO.deleteByExample(exam);
	}

	/**
	 * 根据eventId删除campaign_user_task_retry表数据
	 */
	public void cleanCampaignUserTaskRetryByEventId(String eventId) {
        if (StringUtils.isBlank(eventId)){
            eventId = "test_eventId";
        }
		CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		campaignUserTaskRetryDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除campaign_user_task_retry表数据
	 */
	public void cleanCampaignUserTaskRetryByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		campaignUserTaskRetryDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除campaign_user_task_retry表数据
	 */
	public void cleanCampaignUserTaskRetryByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		campaignUserTaskRetryDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除campaign_user_task_retry表数据
	*/
	public void cleanCampaignUserTaskRetryByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
		exam.createCriteria().andNameEqualTo(name);
		campaignUserTaskRetryDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNo删除campaign_user_task_retry表数据
	 */
	public void cleanCampaignUserTaskRetryByCampaignNo(String campaignNo) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
		CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		campaignUserTaskRetryDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除campaign_user_task_retry表数据
	 */
	public void cleanCampaignUserTaskRetryByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		campaignUserTaskRetryDAO.deleteByExample(exam);
	}

    /**
     * 查询campaign_user_task_retry表所有数据
     */
    public List<CampaignUserTaskRetryDO> findCampaignUserTaskRetryAll() {
        CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
        exam.createCriteria();
		return campaignUserTaskRetryDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询campaign_user_task_retry表数据
	 */
	public List<CampaignUserTaskRetryDO> findCampaignUserTaskRetryById(Long id) {
		CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return campaignUserTaskRetryDAO.selectByExample(exam);
	}

    /**
	 * 根据eventId查询campaign_user_task_retry表数据
	 */
	public List<CampaignUserTaskRetryDO> findCampaignUserTaskRetryByEventId(String eventId) {
		CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		return campaignUserTaskRetryDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询campaign_user_task_retry表数据
	 */
	public List<CampaignUserTaskRetryDO> findCampaignUserTaskRetryByPartnerId(String partnerId) {
		CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return campaignUserTaskRetryDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询campaign_user_task_retry表数据
	 */
	public List<CampaignUserTaskRetryDO> findCampaignUserTaskRetryByUserId(String userId) {
		CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return campaignUserTaskRetryDAO.selectByExample(exam);
	}

	/**
	* 根据name查询campaign_user_task_retry表数据
	*/
	public List<CampaignUserTaskRetryDO> findCampaignUserTaskRetryByName(String name) {
		CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return campaignUserTaskRetryDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNo查询campaign_user_task_retry表数据
	 */
	public List<CampaignUserTaskRetryDO> findCampaignUserTaskRetryByCampaignNo(String campaignNo) {
		CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		return campaignUserTaskRetryDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询campaign_user_task_retry表数据
	 */
	public List<CampaignUserTaskRetryDO> findCampaignUserTaskRetryByGid(String gid) {
		CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return campaignUserTaskRetryDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新campaign_user_task_retry表数据
	 */
	public void updateCampaignUserTaskRetryById(Long id,CampaignUserTaskRetryDO campaignUserTaskRetryDO) {
		CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
		exam.createCriteria().andIdEqualTo(id);
		campaignUserTaskRetryDAO.updateByExample(campaignUserTaskRetryDO, exam);
	}

    /**
	 * 根据eventId更新campaign_user_task_retry表数据
	 */
	public void updateCampaignUserTaskRetryByEventId(String eventId,CampaignUserTaskRetryDO campaignUserTaskRetryDO) {
		CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		campaignUserTaskRetryDAO.updateByExample(campaignUserTaskRetryDO, exam);
	}

    /**
	 * 根据partnerId更新campaign_user_task_retry表数据
	 */
	public void updateCampaignUserTaskRetryByPartnerId(String partnerId,CampaignUserTaskRetryDO campaignUserTaskRetryDO) {
		CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		campaignUserTaskRetryDAO.updateByExample(campaignUserTaskRetryDO, exam);
	}

    /**
	 * 根据userId更新campaign_user_task_retry表数据
	 */
	public void updateCampaignUserTaskRetryByUserId(String userId,CampaignUserTaskRetryDO campaignUserTaskRetryDO) {
		CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		campaignUserTaskRetryDAO.updateByExample(campaignUserTaskRetryDO, exam);
	}

	/**
	* 根据name更新campaign_user_task_retry表数据
	*/
	public void updateCampaignUserTaskRetryByName(String name,CampaignUserTaskRetryDO campaignUserTaskRetryDO) {
		CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
		exam.createCriteria().andNameEqualTo(name);
		campaignUserTaskRetryDAO.updateByExample(campaignUserTaskRetryDO, exam);
	}

    /**
	 * 根据campaignNo更新campaign_user_task_retry表数据
	 */
	public void updateCampaignUserTaskRetryByCampaignNo(String campaignNo,CampaignUserTaskRetryDO campaignUserTaskRetryDO) {
		CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		campaignUserTaskRetryDAO.updateByExample(campaignUserTaskRetryDO, exam);
	}

    /**
	 * 根据gid更新campaign_user_task_retry表数据
	 */
	public void updateCampaignUserTaskRetryByGid(String gid,CampaignUserTaskRetryDO campaignUserTaskRetryDO) {
		CampaignUserTaskRetryDOExample exam = new CampaignUserTaskRetryDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		campaignUserTaskRetryDAO.updateByExample(campaignUserTaskRetryDO, exam);
	}

    /**
	 * 断言coupon_copy表
	 */
	public void couponCopyAssert(
	        CouponCopyDO couponCopyDO,
			Long id, 
			String definitionId, 
			String partnerId, 
			String couponName, 
			String couponBizType, 
			String useTimeUnit, 
			String days, 
			Integer maxUse, 
			String timeSlots, 
			String couponUseRule, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, couponCopyDO.getId());
        assertEquals(definitionId, couponCopyDO.getDefinitionId());
        assertEquals(partnerId, couponCopyDO.getPartnerId());
        assertEquals(couponName, couponCopyDO.getCouponName());
        assertEquals(couponBizType, couponCopyDO.getCouponBizType());
        assertEquals(useTimeUnit, couponCopyDO.getUseTimeUnit());
        assertEquals(days, couponCopyDO.getDays());
        assertEquals(maxUse, couponCopyDO.getMaxUse());
        assertEquals(timeSlots, couponCopyDO.getTimeSlots());
        assertEquals(couponUseRule, couponCopyDO.getCouponUseRule());
        assertEquals(rawAddTime, couponCopyDO.getRawAddTime());
        assertEquals(rawUpdateTime, couponCopyDO.getRawUpdateTime());
	}

	/**
	 * 断言coupon_copy表数据
	 */
	public void assertCouponCopy(CouponCopyDO expect, CouponCopyDO couponCopyDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			couponCopyDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != couponCopyDO.getRawAddTime());
		expect.setRawAddTime(couponCopyDO.getRawAddTime());
        Assertions.assertTrue(null != couponCopyDO.getRawUpdateTime());
		expect.setRawUpdateTime(couponCopyDO.getRawUpdateTime());
		Assertions.assertEquals(expect, couponCopyDO);
	}

    /**
	 * 插入coupon_copy表数据
	 */
	public void insertCouponCopy(CouponCopyDO couponCopyDO) {
		couponCopyDAO.insert(couponCopyDO);
	}

    /**
	 * 插入coupon_copy表数据
	 */
	public void insertCouponCopy(
			Long id, 
			String definitionId, 
			String partnerId, 
			String couponName, 
			String couponBizType, 
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
		CouponCopyDO couponCopyDO = new CouponCopyDO();
		couponCopyDO.setId(id);
		couponCopyDO.setDefinitionId(definitionId);
		couponCopyDO.setPartnerId(partnerId);
		couponCopyDO.setCouponName(couponName);
		couponCopyDO.setCouponBizType(couponBizType);
		couponCopyDO.setUseTimeUnit(useTimeUnit);
		couponCopyDO.setDays(days);
		couponCopyDO.setMaxUse(maxUse);
		couponCopyDO.setTimeSlots(timeSlots);
		couponCopyDO.setCouponUseRule(couponUseRule);
		couponCopyDO.setRawAddTime(rawAddTime);
		couponCopyDO.setRawUpdateTime(rawUpdateTime);
		couponCopyDAO.insert(couponCopyDO);
	}

    /**
     * 删除coupon_copy表所有数据
     */
    public void cleanCouponCopy() {
        CouponCopyDOExample exam = new CouponCopyDOExample();
        exam.createCriteria();
        couponCopyDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除coupon_copy表数据
	 */
	public void cleanCouponCopyById(Long id) {
		CouponCopyDOExample exam = new CouponCopyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		couponCopyDAO.deleteByExample(exam);
	}

	/**
	 * 根据definitionId删除coupon_copy表数据
	 */
	public void cleanCouponCopyByDefinitionId(String definitionId) {
        if (StringUtils.isBlank(definitionId)){
            definitionId = "test_definitionId";
        }
		CouponCopyDOExample exam = new CouponCopyDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		couponCopyDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除coupon_copy表数据
	 */
	public void cleanCouponCopyByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		CouponCopyDOExample exam = new CouponCopyDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		couponCopyDAO.deleteByExample(exam);
	}

	/**
	* 根据couponName删除coupon_copy表数据
	*/
	public void cleanCouponCopyByCouponName(String couponName) {
        if (StringUtils.isBlank(couponName)){
            couponName = "test_couponName";
        }
		CouponCopyDOExample exam = new CouponCopyDOExample();
		exam.createCriteria().andCouponNameEqualTo(couponName);
		couponCopyDAO.deleteByExample(exam);
	}

    /**
     * 查询coupon_copy表所有数据
     */
    public List<CouponCopyDO> findCouponCopyAll() {
        CouponCopyDOExample exam = new CouponCopyDOExample();
        exam.createCriteria();
		return couponCopyDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询coupon_copy表数据
	 */
	public List<CouponCopyDO> findCouponCopyById(Long id) {
		CouponCopyDOExample exam = new CouponCopyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return couponCopyDAO.selectByExample(exam);
	}

    /**
	 * 根据definitionId查询coupon_copy表数据
	 */
	public List<CouponCopyDO> findCouponCopyByDefinitionId(String definitionId) {
		CouponCopyDOExample exam = new CouponCopyDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		return couponCopyDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询coupon_copy表数据
	 */
	public List<CouponCopyDO> findCouponCopyByPartnerId(String partnerId) {
		CouponCopyDOExample exam = new CouponCopyDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return couponCopyDAO.selectByExample(exam);
	}

	/**
	* 根据couponName查询coupon_copy表数据
	*/
	public List<CouponCopyDO> findCouponCopyByCouponName(String couponName) {
		CouponCopyDOExample exam = new CouponCopyDOExample();
		exam.createCriteria().andCouponNameEqualTo(couponName);
		return couponCopyDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新coupon_copy表数据
	 */
	public void updateCouponCopyById(Long id,CouponCopyDO couponCopyDO) {
		CouponCopyDOExample exam = new CouponCopyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		couponCopyDAO.updateByExample(couponCopyDO, exam);
	}

    /**
	 * 根据definitionId更新coupon_copy表数据
	 */
	public void updateCouponCopyByDefinitionId(String definitionId,CouponCopyDO couponCopyDO) {
		CouponCopyDOExample exam = new CouponCopyDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		couponCopyDAO.updateByExample(couponCopyDO, exam);
	}

    /**
	 * 根据partnerId更新coupon_copy表数据
	 */
	public void updateCouponCopyByPartnerId(String partnerId,CouponCopyDO couponCopyDO) {
		CouponCopyDOExample exam = new CouponCopyDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		couponCopyDAO.updateByExample(couponCopyDO, exam);
	}

	/**
	* 根据couponName更新coupon_copy表数据
	*/
	public void updateCouponCopyByCouponName(String couponName,CouponCopyDO couponCopyDO) {
		CouponCopyDOExample exam = new CouponCopyDOExample();
		exam.createCriteria().andCouponNameEqualTo(couponName);
		couponCopyDAO.updateByExample(couponCopyDO, exam);
	}

    /**
	 * 断言coupon表
	 */
	public void couponAssert(
	        CouponDO couponDO,
			Long id, 
			String definitionId, 
			String partnerId, 
			String platPartnerId, 
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
        assertEquals(id, couponDO.getId());
        assertEquals(definitionId, couponDO.getDefinitionId());
        assertEquals(partnerId, couponDO.getPartnerId());
        assertEquals(platPartnerId, couponDO.getPlatPartnerId());
        assertEquals(couponName, couponDO.getCouponName());
        assertEquals(couponBizType, couponDO.getCouponBizType());
        assertEquals(status, couponDO.getStatus());
        assertEquals(useTimeUnit, couponDO.getUseTimeUnit());
        assertEquals(days, couponDO.getDays());
        assertEquals(maxUse, couponDO.getMaxUse());
        assertEquals(timeSlots, couponDO.getTimeSlots());
        assertEquals(couponUseRule, couponDO.getCouponUseRule());
        assertEquals(rawAddTime, couponDO.getRawAddTime());
        assertEquals(rawUpdateTime, couponDO.getRawUpdateTime());
	}

	/**
	 * 断言coupon表数据
	 */
	public void assertCoupon(CouponDO expect, CouponDO couponDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			couponDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != couponDO.getRawAddTime());
		expect.setRawAddTime(couponDO.getRawAddTime());
        Assertions.assertTrue(null != couponDO.getRawUpdateTime());
		expect.setRawUpdateTime(couponDO.getRawUpdateTime());
		Assertions.assertEquals(expect, couponDO);
	}

    /**
	 * 插入coupon表数据
	 */
	public void insertCoupon(CouponDO couponDO) {
		couponDAO.insert(couponDO);
	}

    /**
	 * 插入coupon表数据
	 */
	public void insertCoupon(
			Long id, 
			String definitionId, 
			String partnerId, 
			String platPartnerId, 
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
		CouponDO couponDO = new CouponDO();
		couponDO.setId(id);
		couponDO.setDefinitionId(definitionId);
		couponDO.setPartnerId(partnerId);
		couponDO.setPlatPartnerId(platPartnerId);
		couponDO.setCouponName(couponName);
		couponDO.setCouponBizType(couponBizType);
		couponDO.setStatus(status);
		couponDO.setUseTimeUnit(useTimeUnit);
		couponDO.setDays(days);
		couponDO.setMaxUse(maxUse);
		couponDO.setTimeSlots(timeSlots);
		couponDO.setCouponUseRule(couponUseRule);
		couponDO.setRawAddTime(rawAddTime);
		couponDO.setRawUpdateTime(rawUpdateTime);
		couponDAO.insert(couponDO);
	}

    /**
     * 删除coupon表所有数据
     */
    public void cleanCoupon() {
        CouponDOExample exam = new CouponDOExample();
        exam.createCriteria();
        couponDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除coupon表数据
	 */
	public void cleanCouponById(Long id) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andIdEqualTo(id);
		couponDAO.deleteByExample(exam);
	}

	/**
	 * 根据definitionId删除coupon表数据
	 */
	public void cleanCouponByDefinitionId(String definitionId) {
        if (StringUtils.isBlank(definitionId)){
            definitionId = "test_definitionId";
        }
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		couponDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除coupon表数据
	 */
	public void cleanCouponByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		couponDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除coupon表数据
	 */
	public void cleanCouponByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		couponDAO.deleteByExample(exam);
	}

	/**
	* 根据couponName删除coupon表数据
	*/
	public void cleanCouponByCouponName(String couponName) {
        if (StringUtils.isBlank(couponName)){
            couponName = "test_couponName";
        }
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andCouponNameEqualTo(couponName);
		couponDAO.deleteByExample(exam);
	}

    /**
     * 查询coupon表所有数据
     */
    public List<CouponDO> findCouponAll() {
        CouponDOExample exam = new CouponDOExample();
        exam.createCriteria();
		return couponDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询coupon表数据
	 */
	public List<CouponDO> findCouponById(Long id) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return couponDAO.selectByExample(exam);
	}

    /**
	 * 根据definitionId查询coupon表数据
	 */
	public List<CouponDO> findCouponByDefinitionId(String definitionId) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		return couponDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询coupon表数据
	 */
	public List<CouponDO> findCouponByPartnerId(String partnerId) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return couponDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询coupon表数据
	 */
	public List<CouponDO> findCouponByPlatPartnerId(String platPartnerId) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return couponDAO.selectByExample(exam);
	}

	/**
	* 根据couponName查询coupon表数据
	*/
	public List<CouponDO> findCouponByCouponName(String couponName) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andCouponNameEqualTo(couponName);
		return couponDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新coupon表数据
	 */
	public void updateCouponById(Long id,CouponDO couponDO) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andIdEqualTo(id);
		couponDAO.updateByExample(couponDO, exam);
	}

    /**
	 * 根据definitionId更新coupon表数据
	 */
	public void updateCouponByDefinitionId(String definitionId,CouponDO couponDO) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andDefinitionIdEqualTo(definitionId);
		couponDAO.updateByExample(couponDO, exam);
	}

    /**
	 * 根据partnerId更新coupon表数据
	 */
	public void updateCouponByPartnerId(String partnerId,CouponDO couponDO) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		couponDAO.updateByExample(couponDO, exam);
	}

    /**
	 * 根据platPartnerId更新coupon表数据
	 */
	public void updateCouponByPlatPartnerId(String platPartnerId,CouponDO couponDO) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		couponDAO.updateByExample(couponDO, exam);
	}

	/**
	* 根据couponName更新coupon表数据
	*/
	public void updateCouponByCouponName(String couponName,CouponDO couponDO) {
		CouponDOExample exam = new CouponDOExample();
		exam.createCriteria().andCouponNameEqualTo(couponName);
		couponDAO.updateByExample(couponDO, exam);
	}

    /**
	 * 断言give_coupon_detail表
	 */
	public void giveCouponDetailAssert(
	        GiveCouponDetailDO giveCouponDetailDO,
			Long id, 
			String eventId, 
			String giveBizNo, 
			String bizInstructionId, 
			String gid, 
			String partnerId, 
			String platPartnerId, 
			String campaignNo, 
			String campaignType, 
			String campaignName, 
			String promotionWay, 
			Long ruleId, 
			String userId, 
			String accountTag, 
			String marketUser, 
			String status, 
			String couponInfos, 
			String stationId, 
			String stationName, 
			String operatorId, 
			String operatorName, 
			String terminalType, 
			String terminalCode, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String groupNo, 
			String groupName, 
			String partakeUserId, 
			String partakeUser
	) {
        assertEquals(id, giveCouponDetailDO.getId());
        assertEquals(eventId, giveCouponDetailDO.getEventId());
        assertEquals(giveBizNo, giveCouponDetailDO.getGiveBizNo());
        assertEquals(bizInstructionId, giveCouponDetailDO.getBizInstructionId());
        assertEquals(gid, giveCouponDetailDO.getGid());
        assertEquals(partnerId, giveCouponDetailDO.getPartnerId());
        assertEquals(platPartnerId, giveCouponDetailDO.getPlatPartnerId());
        assertEquals(campaignNo, giveCouponDetailDO.getCampaignNo());
        assertEquals(campaignType, giveCouponDetailDO.getCampaignType());
        assertEquals(campaignName, giveCouponDetailDO.getCampaignName());
        assertEquals(promotionWay, giveCouponDetailDO.getPromotionWay());
        assertEquals(ruleId, giveCouponDetailDO.getRuleId());
        assertEquals(userId, giveCouponDetailDO.getUserId());
        assertEquals(accountTag, giveCouponDetailDO.getAccountTag());
        assertEquals(marketUser, giveCouponDetailDO.getMarketUser());
        assertEquals(status, giveCouponDetailDO.getStatus());
        assertEquals(couponInfos, giveCouponDetailDO.getCouponInfos());
        assertEquals(stationId, giveCouponDetailDO.getStationId());
        assertEquals(stationName, giveCouponDetailDO.getStationName());
        assertEquals(operatorId, giveCouponDetailDO.getOperatorId());
        assertEquals(operatorName, giveCouponDetailDO.getOperatorName());
        assertEquals(terminalType, giveCouponDetailDO.getTerminalType());
        assertEquals(terminalCode, giveCouponDetailDO.getTerminalCode());
        assertEquals(rawAddTime, giveCouponDetailDO.getRawAddTime());
        assertEquals(rawUpdateTime, giveCouponDetailDO.getRawUpdateTime());
        assertEquals(groupNo, giveCouponDetailDO.getGroupNo());
        assertEquals(groupName, giveCouponDetailDO.getGroupName());
        assertEquals(partakeUserId, giveCouponDetailDO.getPartakeUserId());
        assertEquals(partakeUser, giveCouponDetailDO.getPartakeUser());
	}

	/**
	 * 断言give_coupon_detail表数据
	 */
	public void assertGiveCouponDetail(GiveCouponDetailDO expect, GiveCouponDetailDO giveCouponDetailDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			giveCouponDetailDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != giveCouponDetailDO.getRawAddTime());
		expect.setRawAddTime(giveCouponDetailDO.getRawAddTime());
        Assertions.assertTrue(null != giveCouponDetailDO.getRawUpdateTime());
		expect.setRawUpdateTime(giveCouponDetailDO.getRawUpdateTime());
		Assertions.assertEquals(expect, giveCouponDetailDO);
	}

    /**
	 * 插入give_coupon_detail表数据
	 */
	public void insertGiveCouponDetail(GiveCouponDetailDO giveCouponDetailDO) {
		giveCouponDetailDAO.insert(giveCouponDetailDO);
	}

    /**
	 * 插入give_coupon_detail表数据
	 */
	public void insertGiveCouponDetail(
			Long id, 
			String eventId, 
			String giveBizNo, 
			String bizInstructionId, 
			String gid, 
			String partnerId, 
			String platPartnerId, 
			String campaignNo, 
			String campaignType, 
			String campaignName, 
			String promotionWay, 
			Long ruleId, 
			String userId, 
			String accountTag, 
			String marketUser, 
			String status, 
			String couponInfos, 
			String stationId, 
			String stationName, 
			String operatorId, 
			String operatorName, 
			String terminalType, 
			String terminalCode, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String groupNo, 
			String groupName, 
			String partakeUserId, 
			String partakeUser
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GiveCouponDetailDO giveCouponDetailDO = new GiveCouponDetailDO();
		giveCouponDetailDO.setId(id);
		giveCouponDetailDO.setEventId(eventId);
		giveCouponDetailDO.setGiveBizNo(giveBizNo);
		giveCouponDetailDO.setBizInstructionId(bizInstructionId);
		giveCouponDetailDO.setGid(gid);
		giveCouponDetailDO.setPartnerId(partnerId);
		giveCouponDetailDO.setPlatPartnerId(platPartnerId);
		giveCouponDetailDO.setCampaignNo(campaignNo);
		giveCouponDetailDO.setCampaignType(campaignType);
		giveCouponDetailDO.setCampaignName(campaignName);
		giveCouponDetailDO.setPromotionWay(promotionWay);
		giveCouponDetailDO.setRuleId(ruleId);
		giveCouponDetailDO.setUserId(userId);
		giveCouponDetailDO.setAccountTag(accountTag);
		giveCouponDetailDO.setMarketUser(marketUser);
		giveCouponDetailDO.setStatus(status);
		giveCouponDetailDO.setCouponInfos(couponInfos);
		giveCouponDetailDO.setStationId(stationId);
		giveCouponDetailDO.setStationName(stationName);
		giveCouponDetailDO.setOperatorId(operatorId);
		giveCouponDetailDO.setOperatorName(operatorName);
		giveCouponDetailDO.setTerminalType(terminalType);
		giveCouponDetailDO.setTerminalCode(terminalCode);
		giveCouponDetailDO.setRawAddTime(rawAddTime);
		giveCouponDetailDO.setRawUpdateTime(rawUpdateTime);
		giveCouponDetailDO.setGroupNo(groupNo);
		giveCouponDetailDO.setGroupName(groupName);
		giveCouponDetailDO.setPartakeUserId(partakeUserId);
		giveCouponDetailDO.setPartakeUser(partakeUser);
		giveCouponDetailDAO.insert(giveCouponDetailDO);
	}

    /**
     * 删除give_coupon_detail表所有数据
     */
    public void cleanGiveCouponDetail() {
        GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
        exam.createCriteria();
        giveCouponDetailDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除give_coupon_detail表数据
	 */
	public void cleanGiveCouponDetailById(Long id) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		giveCouponDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据eventId删除give_coupon_detail表数据
	 */
	public void cleanGiveCouponDetailByEventId(String eventId) {
        if (StringUtils.isBlank(eventId)){
            eventId = "test_eventId";
        }
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		giveCouponDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据giveBizNo删除give_coupon_detail表数据
	 */
	public void cleanGiveCouponDetailByGiveBizNo(String giveBizNo) {
        if (StringUtils.isBlank(giveBizNo)){
            giveBizNo = "test_giveBizNo";
        }
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andGiveBizNoEqualTo(giveBizNo);
		giveCouponDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizInstructionId删除give_coupon_detail表数据
	 */
	public void cleanGiveCouponDetailByBizInstructionId(String bizInstructionId) {
        if (StringUtils.isBlank(bizInstructionId)){
            bizInstructionId = "test_bizInstructionId";
        }
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andBizInstructionIdEqualTo(bizInstructionId);
		giveCouponDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除give_coupon_detail表数据
	 */
	public void cleanGiveCouponDetailByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		giveCouponDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除give_coupon_detail表数据
	 */
	public void cleanGiveCouponDetailByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		giveCouponDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除give_coupon_detail表数据
	 */
	public void cleanGiveCouponDetailByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		giveCouponDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNo删除give_coupon_detail表数据
	 */
	public void cleanGiveCouponDetailByCampaignNo(String campaignNo) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		giveCouponDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据campaignName删除give_coupon_detail表数据
	*/
	public void cleanGiveCouponDetailByCampaignName(String campaignName) {
        if (StringUtils.isBlank(campaignName)){
            campaignName = "test_campaignName";
        }
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andCampaignNameEqualTo(campaignName);
		giveCouponDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据ruleId删除give_coupon_detail表数据
	 */
	public void cleanGiveCouponDetailByRuleId(Long ruleId) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		giveCouponDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除give_coupon_detail表数据
	 */
	public void cleanGiveCouponDetailByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		giveCouponDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除give_coupon_detail表数据
	 */
	public void cleanGiveCouponDetailByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		giveCouponDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除give_coupon_detail表数据
	*/
	public void cleanGiveCouponDetailByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		giveCouponDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据operatorId删除give_coupon_detail表数据
	 */
	public void cleanGiveCouponDetailByOperatorId(String operatorId) {
        if (StringUtils.isBlank(operatorId)){
            operatorId = "test_operatorId";
        }
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		giveCouponDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据operatorName删除give_coupon_detail表数据
	*/
	public void cleanGiveCouponDetailByOperatorName(String operatorName) {
        if (StringUtils.isBlank(operatorName)){
            operatorName = "test_operatorName";
        }
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		giveCouponDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据terminalCode删除give_coupon_detail表数据
	*/
	public void cleanGiveCouponDetailByTerminalCode(String terminalCode) {
        if (StringUtils.isBlank(terminalCode)){
            terminalCode = "test_terminalCode";
        }
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		giveCouponDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据groupNo删除give_coupon_detail表数据
	 */
	public void cleanGiveCouponDetailByGroupNo(String groupNo) {
        if (StringUtils.isBlank(groupNo)){
            groupNo = "test_groupNo";
        }
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andGroupNoEqualTo(groupNo);
		giveCouponDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据groupName删除give_coupon_detail表数据
	*/
	public void cleanGiveCouponDetailByGroupName(String groupName) {
        if (StringUtils.isBlank(groupName)){
            groupName = "test_groupName";
        }
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		giveCouponDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据partakeUserId删除give_coupon_detail表数据
	 */
	public void cleanGiveCouponDetailByPartakeUserId(String partakeUserId) {
        if (StringUtils.isBlank(partakeUserId)){
            partakeUserId = "test_partakeUserId";
        }
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andPartakeUserIdEqualTo(partakeUserId);
		giveCouponDetailDAO.deleteByExample(exam);
	}

    /**
     * 查询give_coupon_detail表所有数据
     */
    public List<GiveCouponDetailDO> findGiveCouponDetailAll() {
        GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
        exam.createCriteria();
		return giveCouponDetailDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询give_coupon_detail表数据
	 */
	public List<GiveCouponDetailDO> findGiveCouponDetailById(Long id) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return giveCouponDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据eventId查询give_coupon_detail表数据
	 */
	public List<GiveCouponDetailDO> findGiveCouponDetailByEventId(String eventId) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		return giveCouponDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据giveBizNo查询give_coupon_detail表数据
	 */
	public List<GiveCouponDetailDO> findGiveCouponDetailByGiveBizNo(String giveBizNo) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andGiveBizNoEqualTo(giveBizNo);
		return giveCouponDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据bizInstructionId查询give_coupon_detail表数据
	 */
	public List<GiveCouponDetailDO> findGiveCouponDetailByBizInstructionId(String bizInstructionId) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andBizInstructionIdEqualTo(bizInstructionId);
		return giveCouponDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询give_coupon_detail表数据
	 */
	public List<GiveCouponDetailDO> findGiveCouponDetailByGid(String gid) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return giveCouponDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询give_coupon_detail表数据
	 */
	public List<GiveCouponDetailDO> findGiveCouponDetailByPartnerId(String partnerId) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return giveCouponDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询give_coupon_detail表数据
	 */
	public List<GiveCouponDetailDO> findGiveCouponDetailByPlatPartnerId(String platPartnerId) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return giveCouponDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNo查询give_coupon_detail表数据
	 */
	public List<GiveCouponDetailDO> findGiveCouponDetailByCampaignNo(String campaignNo) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		return giveCouponDetailDAO.selectByExample(exam);
	}

	/**
	* 根据campaignName查询give_coupon_detail表数据
	*/
	public List<GiveCouponDetailDO> findGiveCouponDetailByCampaignName(String campaignName) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andCampaignNameEqualTo(campaignName);
		return giveCouponDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据ruleId查询give_coupon_detail表数据
	 */
	public List<GiveCouponDetailDO> findGiveCouponDetailByRuleId(Long ruleId) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		return giveCouponDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询give_coupon_detail表数据
	 */
	public List<GiveCouponDetailDO> findGiveCouponDetailByUserId(String userId) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return giveCouponDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询give_coupon_detail表数据
	 */
	public List<GiveCouponDetailDO> findGiveCouponDetailByStationId(String stationId) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return giveCouponDetailDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询give_coupon_detail表数据
	*/
	public List<GiveCouponDetailDO> findGiveCouponDetailByStationName(String stationName) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return giveCouponDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据operatorId查询give_coupon_detail表数据
	 */
	public List<GiveCouponDetailDO> findGiveCouponDetailByOperatorId(String operatorId) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		return giveCouponDetailDAO.selectByExample(exam);
	}

	/**
	* 根据operatorName查询give_coupon_detail表数据
	*/
	public List<GiveCouponDetailDO> findGiveCouponDetailByOperatorName(String operatorName) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		return giveCouponDetailDAO.selectByExample(exam);
	}

	/**
	* 根据terminalCode查询give_coupon_detail表数据
	*/
	public List<GiveCouponDetailDO> findGiveCouponDetailByTerminalCode(String terminalCode) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		return giveCouponDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据groupNo查询give_coupon_detail表数据
	 */
	public List<GiveCouponDetailDO> findGiveCouponDetailByGroupNo(String groupNo) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andGroupNoEqualTo(groupNo);
		return giveCouponDetailDAO.selectByExample(exam);
	}

	/**
	* 根据groupName查询give_coupon_detail表数据
	*/
	public List<GiveCouponDetailDO> findGiveCouponDetailByGroupName(String groupName) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		return giveCouponDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据partakeUserId查询give_coupon_detail表数据
	 */
	public List<GiveCouponDetailDO> findGiveCouponDetailByPartakeUserId(String partakeUserId) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andPartakeUserIdEqualTo(partakeUserId);
		return giveCouponDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新give_coupon_detail表数据
	 */
	public void updateGiveCouponDetailById(Long id,GiveCouponDetailDO giveCouponDetailDO) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		giveCouponDetailDAO.updateByExample(giveCouponDetailDO, exam);
	}

    /**
	 * 根据eventId更新give_coupon_detail表数据
	 */
	public void updateGiveCouponDetailByEventId(String eventId,GiveCouponDetailDO giveCouponDetailDO) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		giveCouponDetailDAO.updateByExample(giveCouponDetailDO, exam);
	}

    /**
	 * 根据giveBizNo更新give_coupon_detail表数据
	 */
	public void updateGiveCouponDetailByGiveBizNo(String giveBizNo,GiveCouponDetailDO giveCouponDetailDO) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andGiveBizNoEqualTo(giveBizNo);
		giveCouponDetailDAO.updateByExample(giveCouponDetailDO, exam);
	}

    /**
	 * 根据bizInstructionId更新give_coupon_detail表数据
	 */
	public void updateGiveCouponDetailByBizInstructionId(String bizInstructionId,GiveCouponDetailDO giveCouponDetailDO) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andBizInstructionIdEqualTo(bizInstructionId);
		giveCouponDetailDAO.updateByExample(giveCouponDetailDO, exam);
	}

    /**
	 * 根据gid更新give_coupon_detail表数据
	 */
	public void updateGiveCouponDetailByGid(String gid,GiveCouponDetailDO giveCouponDetailDO) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		giveCouponDetailDAO.updateByExample(giveCouponDetailDO, exam);
	}

    /**
	 * 根据partnerId更新give_coupon_detail表数据
	 */
	public void updateGiveCouponDetailByPartnerId(String partnerId,GiveCouponDetailDO giveCouponDetailDO) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		giveCouponDetailDAO.updateByExample(giveCouponDetailDO, exam);
	}

    /**
	 * 根据platPartnerId更新give_coupon_detail表数据
	 */
	public void updateGiveCouponDetailByPlatPartnerId(String platPartnerId,GiveCouponDetailDO giveCouponDetailDO) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		giveCouponDetailDAO.updateByExample(giveCouponDetailDO, exam);
	}

    /**
	 * 根据campaignNo更新give_coupon_detail表数据
	 */
	public void updateGiveCouponDetailByCampaignNo(String campaignNo,GiveCouponDetailDO giveCouponDetailDO) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		giveCouponDetailDAO.updateByExample(giveCouponDetailDO, exam);
	}

	/**
	* 根据campaignName更新give_coupon_detail表数据
	*/
	public void updateGiveCouponDetailByCampaignName(String campaignName,GiveCouponDetailDO giveCouponDetailDO) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andCampaignNameEqualTo(campaignName);
		giveCouponDetailDAO.updateByExample(giveCouponDetailDO, exam);
	}

    /**
	 * 根据ruleId更新give_coupon_detail表数据
	 */
	public void updateGiveCouponDetailByRuleId(Long ruleId,GiveCouponDetailDO giveCouponDetailDO) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		giveCouponDetailDAO.updateByExample(giveCouponDetailDO, exam);
	}

    /**
	 * 根据userId更新give_coupon_detail表数据
	 */
	public void updateGiveCouponDetailByUserId(String userId,GiveCouponDetailDO giveCouponDetailDO) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		giveCouponDetailDAO.updateByExample(giveCouponDetailDO, exam);
	}

    /**
	 * 根据stationId更新give_coupon_detail表数据
	 */
	public void updateGiveCouponDetailByStationId(String stationId,GiveCouponDetailDO giveCouponDetailDO) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		giveCouponDetailDAO.updateByExample(giveCouponDetailDO, exam);
	}

	/**
	* 根据stationName更新give_coupon_detail表数据
	*/
	public void updateGiveCouponDetailByStationName(String stationName,GiveCouponDetailDO giveCouponDetailDO) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		giveCouponDetailDAO.updateByExample(giveCouponDetailDO, exam);
	}

    /**
	 * 根据operatorId更新give_coupon_detail表数据
	 */
	public void updateGiveCouponDetailByOperatorId(String operatorId,GiveCouponDetailDO giveCouponDetailDO) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		giveCouponDetailDAO.updateByExample(giveCouponDetailDO, exam);
	}

	/**
	* 根据operatorName更新give_coupon_detail表数据
	*/
	public void updateGiveCouponDetailByOperatorName(String operatorName,GiveCouponDetailDO giveCouponDetailDO) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		giveCouponDetailDAO.updateByExample(giveCouponDetailDO, exam);
	}

	/**
	* 根据terminalCode更新give_coupon_detail表数据
	*/
	public void updateGiveCouponDetailByTerminalCode(String terminalCode,GiveCouponDetailDO giveCouponDetailDO) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		giveCouponDetailDAO.updateByExample(giveCouponDetailDO, exam);
	}

    /**
	 * 根据groupNo更新give_coupon_detail表数据
	 */
	public void updateGiveCouponDetailByGroupNo(String groupNo,GiveCouponDetailDO giveCouponDetailDO) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andGroupNoEqualTo(groupNo);
		giveCouponDetailDAO.updateByExample(giveCouponDetailDO, exam);
	}

	/**
	* 根据groupName更新give_coupon_detail表数据
	*/
	public void updateGiveCouponDetailByGroupName(String groupName,GiveCouponDetailDO giveCouponDetailDO) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		giveCouponDetailDAO.updateByExample(giveCouponDetailDO, exam);
	}

    /**
	 * 根据partakeUserId更新give_coupon_detail表数据
	 */
	public void updateGiveCouponDetailByPartakeUserId(String partakeUserId,GiveCouponDetailDO giveCouponDetailDO) {
		GiveCouponDetailDOExample exam = new GiveCouponDetailDOExample();
		exam.createCriteria().andPartakeUserIdEqualTo(partakeUserId);
		giveCouponDetailDAO.updateByExample(giveCouponDetailDO, exam);
	}

    /**
	 * 断言give_goods_detail表
	 */
	public void giveGoodsDetailAssert(
	        GiveGoodsDetailDO giveGoodsDetailDO,
			Long id, 
			String eventId, 
			String giveBizNo, 
			String gid, 
			String partnerId, 
			String platPartnerId, 
			String campaignNo, 
			String campaignType, 
			String campaignName, 
			String promotionWay, 
			Long ruleId, 
			String userId, 
			String accountTag, 
			String marketUser, 
			String status, 
			String goodsCodes, 
			String stationId, 
			String stationName, 
			String operatorId, 
			String operatorName, 
			String terminalType, 
			String terminalCode, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, giveGoodsDetailDO.getId());
        assertEquals(eventId, giveGoodsDetailDO.getEventId());
        assertEquals(giveBizNo, giveGoodsDetailDO.getGiveBizNo());
        assertEquals(gid, giveGoodsDetailDO.getGid());
        assertEquals(partnerId, giveGoodsDetailDO.getPartnerId());
        assertEquals(platPartnerId, giveGoodsDetailDO.getPlatPartnerId());
        assertEquals(campaignNo, giveGoodsDetailDO.getCampaignNo());
        assertEquals(campaignType, giveGoodsDetailDO.getCampaignType());
        assertEquals(campaignName, giveGoodsDetailDO.getCampaignName());
        assertEquals(promotionWay, giveGoodsDetailDO.getPromotionWay());
        assertEquals(ruleId, giveGoodsDetailDO.getRuleId());
        assertEquals(userId, giveGoodsDetailDO.getUserId());
        assertEquals(accountTag, giveGoodsDetailDO.getAccountTag());
        assertEquals(marketUser, giveGoodsDetailDO.getMarketUser());
        assertEquals(status, giveGoodsDetailDO.getStatus());
        assertEquals(goodsCodes, giveGoodsDetailDO.getGoodsCodes());
        assertEquals(stationId, giveGoodsDetailDO.getStationId());
        assertEquals(stationName, giveGoodsDetailDO.getStationName());
        assertEquals(operatorId, giveGoodsDetailDO.getOperatorId());
        assertEquals(operatorName, giveGoodsDetailDO.getOperatorName());
        assertEquals(terminalType, giveGoodsDetailDO.getTerminalType());
        assertEquals(terminalCode, giveGoodsDetailDO.getTerminalCode());
        assertEquals(rawAddTime, giveGoodsDetailDO.getRawAddTime());
        assertEquals(rawUpdateTime, giveGoodsDetailDO.getRawUpdateTime());
	}

	/**
	 * 断言give_goods_detail表数据
	 */
	public void assertGiveGoodsDetail(GiveGoodsDetailDO expect, GiveGoodsDetailDO giveGoodsDetailDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			giveGoodsDetailDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != giveGoodsDetailDO.getRawAddTime());
		expect.setRawAddTime(giveGoodsDetailDO.getRawAddTime());
        Assertions.assertTrue(null != giveGoodsDetailDO.getRawUpdateTime());
		expect.setRawUpdateTime(giveGoodsDetailDO.getRawUpdateTime());
		Assertions.assertEquals(expect, giveGoodsDetailDO);
	}

    /**
	 * 插入give_goods_detail表数据
	 */
	public void insertGiveGoodsDetail(GiveGoodsDetailDO giveGoodsDetailDO) {
		giveGoodsDetailDAO.insert(giveGoodsDetailDO);
	}

    /**
	 * 插入give_goods_detail表数据
	 */
	public void insertGiveGoodsDetail(
			Long id, 
			String eventId, 
			String giveBizNo, 
			String gid, 
			String partnerId, 
			String platPartnerId, 
			String campaignNo, 
			String campaignType, 
			String campaignName, 
			String promotionWay, 
			Long ruleId, 
			String userId, 
			String accountTag, 
			String marketUser, 
			String status, 
			String goodsCodes, 
			String stationId, 
			String stationName, 
			String operatorId, 
			String operatorName, 
			String terminalType, 
			String terminalCode, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GiveGoodsDetailDO giveGoodsDetailDO = new GiveGoodsDetailDO();
		giveGoodsDetailDO.setId(id);
		giveGoodsDetailDO.setEventId(eventId);
		giveGoodsDetailDO.setGiveBizNo(giveBizNo);
		giveGoodsDetailDO.setGid(gid);
		giveGoodsDetailDO.setPartnerId(partnerId);
		giveGoodsDetailDO.setPlatPartnerId(platPartnerId);
		giveGoodsDetailDO.setCampaignNo(campaignNo);
		giveGoodsDetailDO.setCampaignType(campaignType);
		giveGoodsDetailDO.setCampaignName(campaignName);
		giveGoodsDetailDO.setPromotionWay(promotionWay);
		giveGoodsDetailDO.setRuleId(ruleId);
		giveGoodsDetailDO.setUserId(userId);
		giveGoodsDetailDO.setAccountTag(accountTag);
		giveGoodsDetailDO.setMarketUser(marketUser);
		giveGoodsDetailDO.setStatus(status);
		giveGoodsDetailDO.setGoodsCodes(goodsCodes);
		giveGoodsDetailDO.setStationId(stationId);
		giveGoodsDetailDO.setStationName(stationName);
		giveGoodsDetailDO.setOperatorId(operatorId);
		giveGoodsDetailDO.setOperatorName(operatorName);
		giveGoodsDetailDO.setTerminalType(terminalType);
		giveGoodsDetailDO.setTerminalCode(terminalCode);
		giveGoodsDetailDO.setRawAddTime(rawAddTime);
		giveGoodsDetailDO.setRawUpdateTime(rawUpdateTime);
		giveGoodsDetailDAO.insert(giveGoodsDetailDO);
	}

    /**
     * 删除give_goods_detail表所有数据
     */
    public void cleanGiveGoodsDetail() {
        GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
        exam.createCriteria();
        giveGoodsDetailDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除give_goods_detail表数据
	 */
	public void cleanGiveGoodsDetailById(Long id) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		giveGoodsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据eventId删除give_goods_detail表数据
	 */
	public void cleanGiveGoodsDetailByEventId(String eventId) {
        if (StringUtils.isBlank(eventId)){
            eventId = "test_eventId";
        }
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		giveGoodsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据giveBizNo删除give_goods_detail表数据
	 */
	public void cleanGiveGoodsDetailByGiveBizNo(String giveBizNo) {
        if (StringUtils.isBlank(giveBizNo)){
            giveBizNo = "test_giveBizNo";
        }
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andGiveBizNoEqualTo(giveBizNo);
		giveGoodsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除give_goods_detail表数据
	 */
	public void cleanGiveGoodsDetailByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		giveGoodsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除give_goods_detail表数据
	 */
	public void cleanGiveGoodsDetailByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		giveGoodsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除give_goods_detail表数据
	 */
	public void cleanGiveGoodsDetailByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		giveGoodsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNo删除give_goods_detail表数据
	 */
	public void cleanGiveGoodsDetailByCampaignNo(String campaignNo) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		giveGoodsDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据campaignName删除give_goods_detail表数据
	*/
	public void cleanGiveGoodsDetailByCampaignName(String campaignName) {
        if (StringUtils.isBlank(campaignName)){
            campaignName = "test_campaignName";
        }
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andCampaignNameEqualTo(campaignName);
		giveGoodsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据ruleId删除give_goods_detail表数据
	 */
	public void cleanGiveGoodsDetailByRuleId(Long ruleId) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		giveGoodsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除give_goods_detail表数据
	 */
	public void cleanGiveGoodsDetailByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		giveGoodsDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据goodsCodes删除give_goods_detail表数据
	*/
	public void cleanGiveGoodsDetailByGoodsCodes(String goodsCodes) {
        if (StringUtils.isBlank(goodsCodes)){
            goodsCodes = "test_goodsCodes";
        }
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andGoodsCodesEqualTo(goodsCodes);
		giveGoodsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除give_goods_detail表数据
	 */
	public void cleanGiveGoodsDetailByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		giveGoodsDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除give_goods_detail表数据
	*/
	public void cleanGiveGoodsDetailByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		giveGoodsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据operatorId删除give_goods_detail表数据
	 */
	public void cleanGiveGoodsDetailByOperatorId(String operatorId) {
        if (StringUtils.isBlank(operatorId)){
            operatorId = "test_operatorId";
        }
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		giveGoodsDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据operatorName删除give_goods_detail表数据
	*/
	public void cleanGiveGoodsDetailByOperatorName(String operatorName) {
        if (StringUtils.isBlank(operatorName)){
            operatorName = "test_operatorName";
        }
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		giveGoodsDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据terminalCode删除give_goods_detail表数据
	*/
	public void cleanGiveGoodsDetailByTerminalCode(String terminalCode) {
        if (StringUtils.isBlank(terminalCode)){
            terminalCode = "test_terminalCode";
        }
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		giveGoodsDetailDAO.deleteByExample(exam);
	}

    /**
     * 查询give_goods_detail表所有数据
     */
    public List<GiveGoodsDetailDO> findGiveGoodsDetailAll() {
        GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
        exam.createCriteria();
		return giveGoodsDetailDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询give_goods_detail表数据
	 */
	public List<GiveGoodsDetailDO> findGiveGoodsDetailById(Long id) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return giveGoodsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据eventId查询give_goods_detail表数据
	 */
	public List<GiveGoodsDetailDO> findGiveGoodsDetailByEventId(String eventId) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		return giveGoodsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据giveBizNo查询give_goods_detail表数据
	 */
	public List<GiveGoodsDetailDO> findGiveGoodsDetailByGiveBizNo(String giveBizNo) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andGiveBizNoEqualTo(giveBizNo);
		return giveGoodsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询give_goods_detail表数据
	 */
	public List<GiveGoodsDetailDO> findGiveGoodsDetailByGid(String gid) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return giveGoodsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询give_goods_detail表数据
	 */
	public List<GiveGoodsDetailDO> findGiveGoodsDetailByPartnerId(String partnerId) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return giveGoodsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询give_goods_detail表数据
	 */
	public List<GiveGoodsDetailDO> findGiveGoodsDetailByPlatPartnerId(String platPartnerId) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return giveGoodsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNo查询give_goods_detail表数据
	 */
	public List<GiveGoodsDetailDO> findGiveGoodsDetailByCampaignNo(String campaignNo) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		return giveGoodsDetailDAO.selectByExample(exam);
	}

	/**
	* 根据campaignName查询give_goods_detail表数据
	*/
	public List<GiveGoodsDetailDO> findGiveGoodsDetailByCampaignName(String campaignName) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andCampaignNameEqualTo(campaignName);
		return giveGoodsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据ruleId查询give_goods_detail表数据
	 */
	public List<GiveGoodsDetailDO> findGiveGoodsDetailByRuleId(Long ruleId) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		return giveGoodsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询give_goods_detail表数据
	 */
	public List<GiveGoodsDetailDO> findGiveGoodsDetailByUserId(String userId) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return giveGoodsDetailDAO.selectByExample(exam);
	}

	/**
	* 根据goodsCodes查询give_goods_detail表数据
	*/
	public List<GiveGoodsDetailDO> findGiveGoodsDetailByGoodsCodes(String goodsCodes) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andGoodsCodesEqualTo(goodsCodes);
		return giveGoodsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询give_goods_detail表数据
	 */
	public List<GiveGoodsDetailDO> findGiveGoodsDetailByStationId(String stationId) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return giveGoodsDetailDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询give_goods_detail表数据
	*/
	public List<GiveGoodsDetailDO> findGiveGoodsDetailByStationName(String stationName) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return giveGoodsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据operatorId查询give_goods_detail表数据
	 */
	public List<GiveGoodsDetailDO> findGiveGoodsDetailByOperatorId(String operatorId) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		return giveGoodsDetailDAO.selectByExample(exam);
	}

	/**
	* 根据operatorName查询give_goods_detail表数据
	*/
	public List<GiveGoodsDetailDO> findGiveGoodsDetailByOperatorName(String operatorName) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		return giveGoodsDetailDAO.selectByExample(exam);
	}

	/**
	* 根据terminalCode查询give_goods_detail表数据
	*/
	public List<GiveGoodsDetailDO> findGiveGoodsDetailByTerminalCode(String terminalCode) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		return giveGoodsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新give_goods_detail表数据
	 */
	public void updateGiveGoodsDetailById(Long id,GiveGoodsDetailDO giveGoodsDetailDO) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		giveGoodsDetailDAO.updateByExample(giveGoodsDetailDO, exam);
	}

    /**
	 * 根据eventId更新give_goods_detail表数据
	 */
	public void updateGiveGoodsDetailByEventId(String eventId,GiveGoodsDetailDO giveGoodsDetailDO) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		giveGoodsDetailDAO.updateByExample(giveGoodsDetailDO, exam);
	}

    /**
	 * 根据giveBizNo更新give_goods_detail表数据
	 */
	public void updateGiveGoodsDetailByGiveBizNo(String giveBizNo,GiveGoodsDetailDO giveGoodsDetailDO) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andGiveBizNoEqualTo(giveBizNo);
		giveGoodsDetailDAO.updateByExample(giveGoodsDetailDO, exam);
	}

    /**
	 * 根据gid更新give_goods_detail表数据
	 */
	public void updateGiveGoodsDetailByGid(String gid,GiveGoodsDetailDO giveGoodsDetailDO) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		giveGoodsDetailDAO.updateByExample(giveGoodsDetailDO, exam);
	}

    /**
	 * 根据partnerId更新give_goods_detail表数据
	 */
	public void updateGiveGoodsDetailByPartnerId(String partnerId,GiveGoodsDetailDO giveGoodsDetailDO) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		giveGoodsDetailDAO.updateByExample(giveGoodsDetailDO, exam);
	}

    /**
	 * 根据platPartnerId更新give_goods_detail表数据
	 */
	public void updateGiveGoodsDetailByPlatPartnerId(String platPartnerId,GiveGoodsDetailDO giveGoodsDetailDO) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		giveGoodsDetailDAO.updateByExample(giveGoodsDetailDO, exam);
	}

    /**
	 * 根据campaignNo更新give_goods_detail表数据
	 */
	public void updateGiveGoodsDetailByCampaignNo(String campaignNo,GiveGoodsDetailDO giveGoodsDetailDO) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		giveGoodsDetailDAO.updateByExample(giveGoodsDetailDO, exam);
	}

	/**
	* 根据campaignName更新give_goods_detail表数据
	*/
	public void updateGiveGoodsDetailByCampaignName(String campaignName,GiveGoodsDetailDO giveGoodsDetailDO) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andCampaignNameEqualTo(campaignName);
		giveGoodsDetailDAO.updateByExample(giveGoodsDetailDO, exam);
	}

    /**
	 * 根据ruleId更新give_goods_detail表数据
	 */
	public void updateGiveGoodsDetailByRuleId(Long ruleId,GiveGoodsDetailDO giveGoodsDetailDO) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		giveGoodsDetailDAO.updateByExample(giveGoodsDetailDO, exam);
	}

    /**
	 * 根据userId更新give_goods_detail表数据
	 */
	public void updateGiveGoodsDetailByUserId(String userId,GiveGoodsDetailDO giveGoodsDetailDO) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		giveGoodsDetailDAO.updateByExample(giveGoodsDetailDO, exam);
	}

	/**
	* 根据goodsCodes更新give_goods_detail表数据
	*/
	public void updateGiveGoodsDetailByGoodsCodes(String goodsCodes,GiveGoodsDetailDO giveGoodsDetailDO) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andGoodsCodesEqualTo(goodsCodes);
		giveGoodsDetailDAO.updateByExample(giveGoodsDetailDO, exam);
	}

    /**
	 * 根据stationId更新give_goods_detail表数据
	 */
	public void updateGiveGoodsDetailByStationId(String stationId,GiveGoodsDetailDO giveGoodsDetailDO) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		giveGoodsDetailDAO.updateByExample(giveGoodsDetailDO, exam);
	}

	/**
	* 根据stationName更新give_goods_detail表数据
	*/
	public void updateGiveGoodsDetailByStationName(String stationName,GiveGoodsDetailDO giveGoodsDetailDO) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		giveGoodsDetailDAO.updateByExample(giveGoodsDetailDO, exam);
	}

    /**
	 * 根据operatorId更新give_goods_detail表数据
	 */
	public void updateGiveGoodsDetailByOperatorId(String operatorId,GiveGoodsDetailDO giveGoodsDetailDO) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		giveGoodsDetailDAO.updateByExample(giveGoodsDetailDO, exam);
	}

	/**
	* 根据operatorName更新give_goods_detail表数据
	*/
	public void updateGiveGoodsDetailByOperatorName(String operatorName,GiveGoodsDetailDO giveGoodsDetailDO) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		giveGoodsDetailDAO.updateByExample(giveGoodsDetailDO, exam);
	}

	/**
	* 根据terminalCode更新give_goods_detail表数据
	*/
	public void updateGiveGoodsDetailByTerminalCode(String terminalCode,GiveGoodsDetailDO giveGoodsDetailDO) {
		GiveGoodsDetailDOExample exam = new GiveGoodsDetailDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		giveGoodsDetailDAO.updateByExample(giveGoodsDetailDO, exam);
	}

    /**
	 * 断言give_luck_draw_detail表
	 */
	public void giveLuckDrawDetailAssert(
	        GiveLuckDrawDetailDO giveLuckDrawDetailDO,
			Long id, 
			String eventId, 
			String giveBizNo, 
			String gid, 
			String platPartnerId, 
			String partnerId, 
			String groupNo, 
			String groupName, 
			String campaignNo, 
			String campaignType, 
			String campaignName, 
			String promotionWay, 
			Long ruleId, 
			String partakeUserId, 
			String userId, 
			String accountTag, 
			String partakeUser, 
			String marketUser, 
			String status, 
			String giveDraws, 
			String stationId, 
			String stationName, 
			String operatorId, 
			String operatorName, 
			String terminalType, 
			String terminalCode, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, giveLuckDrawDetailDO.getId());
        assertEquals(eventId, giveLuckDrawDetailDO.getEventId());
        assertEquals(giveBizNo, giveLuckDrawDetailDO.getGiveBizNo());
        assertEquals(gid, giveLuckDrawDetailDO.getGid());
        assertEquals(platPartnerId, giveLuckDrawDetailDO.getPlatPartnerId());
        assertEquals(partnerId, giveLuckDrawDetailDO.getPartnerId());
        assertEquals(groupNo, giveLuckDrawDetailDO.getGroupNo());
        assertEquals(groupName, giveLuckDrawDetailDO.getGroupName());
        assertEquals(campaignNo, giveLuckDrawDetailDO.getCampaignNo());
        assertEquals(campaignType, giveLuckDrawDetailDO.getCampaignType());
        assertEquals(campaignName, giveLuckDrawDetailDO.getCampaignName());
        assertEquals(promotionWay, giveLuckDrawDetailDO.getPromotionWay());
        assertEquals(ruleId, giveLuckDrawDetailDO.getRuleId());
        assertEquals(partakeUserId, giveLuckDrawDetailDO.getPartakeUserId());
        assertEquals(userId, giveLuckDrawDetailDO.getUserId());
        assertEquals(accountTag, giveLuckDrawDetailDO.getAccountTag());
        assertEquals(partakeUser, giveLuckDrawDetailDO.getPartakeUser());
        assertEquals(marketUser, giveLuckDrawDetailDO.getMarketUser());
        assertEquals(status, giveLuckDrawDetailDO.getStatus());
        assertEquals(giveDraws, giveLuckDrawDetailDO.getGiveDraws());
        assertEquals(stationId, giveLuckDrawDetailDO.getStationId());
        assertEquals(stationName, giveLuckDrawDetailDO.getStationName());
        assertEquals(operatorId, giveLuckDrawDetailDO.getOperatorId());
        assertEquals(operatorName, giveLuckDrawDetailDO.getOperatorName());
        assertEquals(terminalType, giveLuckDrawDetailDO.getTerminalType());
        assertEquals(terminalCode, giveLuckDrawDetailDO.getTerminalCode());
        assertEquals(rawAddTime, giveLuckDrawDetailDO.getRawAddTime());
        assertEquals(rawUpdateTime, giveLuckDrawDetailDO.getRawUpdateTime());
	}

	/**
	 * 断言give_luck_draw_detail表数据
	 */
	public void assertGiveLuckDrawDetail(GiveLuckDrawDetailDO expect, GiveLuckDrawDetailDO giveLuckDrawDetailDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			giveLuckDrawDetailDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != giveLuckDrawDetailDO.getRawAddTime());
		expect.setRawAddTime(giveLuckDrawDetailDO.getRawAddTime());
        Assertions.assertTrue(null != giveLuckDrawDetailDO.getRawUpdateTime());
		expect.setRawUpdateTime(giveLuckDrawDetailDO.getRawUpdateTime());
		Assertions.assertEquals(expect, giveLuckDrawDetailDO);
	}

    /**
	 * 插入give_luck_draw_detail表数据
	 */
	public void insertGiveLuckDrawDetail(GiveLuckDrawDetailDO giveLuckDrawDetailDO) {
		giveLuckDrawDetailDAO.insert(giveLuckDrawDetailDO);
	}

    /**
	 * 插入give_luck_draw_detail表数据
	 */
	public void insertGiveLuckDrawDetail(
			Long id, 
			String eventId, 
			String giveBizNo, 
			String gid, 
			String platPartnerId, 
			String partnerId, 
			String groupNo, 
			String groupName, 
			String campaignNo, 
			String campaignType, 
			String campaignName, 
			String promotionWay, 
			Long ruleId, 
			String partakeUserId, 
			String userId, 
			String accountTag, 
			String partakeUser, 
			String marketUser, 
			String status, 
			String giveDraws, 
			String stationId, 
			String stationName, 
			String operatorId, 
			String operatorName, 
			String terminalType, 
			String terminalCode, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GiveLuckDrawDetailDO giveLuckDrawDetailDO = new GiveLuckDrawDetailDO();
		giveLuckDrawDetailDO.setId(id);
		giveLuckDrawDetailDO.setEventId(eventId);
		giveLuckDrawDetailDO.setGiveBizNo(giveBizNo);
		giveLuckDrawDetailDO.setGid(gid);
		giveLuckDrawDetailDO.setPlatPartnerId(platPartnerId);
		giveLuckDrawDetailDO.setPartnerId(partnerId);
		giveLuckDrawDetailDO.setGroupNo(groupNo);
		giveLuckDrawDetailDO.setGroupName(groupName);
		giveLuckDrawDetailDO.setCampaignNo(campaignNo);
		giveLuckDrawDetailDO.setCampaignType(campaignType);
		giveLuckDrawDetailDO.setCampaignName(campaignName);
		giveLuckDrawDetailDO.setPromotionWay(promotionWay);
		giveLuckDrawDetailDO.setRuleId(ruleId);
		giveLuckDrawDetailDO.setPartakeUserId(partakeUserId);
		giveLuckDrawDetailDO.setUserId(userId);
		giveLuckDrawDetailDO.setAccountTag(accountTag);
		giveLuckDrawDetailDO.setPartakeUser(partakeUser);
		giveLuckDrawDetailDO.setMarketUser(marketUser);
		giveLuckDrawDetailDO.setStatus(status);
		giveLuckDrawDetailDO.setGiveDraws(giveDraws);
		giveLuckDrawDetailDO.setStationId(stationId);
		giveLuckDrawDetailDO.setStationName(stationName);
		giveLuckDrawDetailDO.setOperatorId(operatorId);
		giveLuckDrawDetailDO.setOperatorName(operatorName);
		giveLuckDrawDetailDO.setTerminalType(terminalType);
		giveLuckDrawDetailDO.setTerminalCode(terminalCode);
		giveLuckDrawDetailDO.setRawAddTime(rawAddTime);
		giveLuckDrawDetailDO.setRawUpdateTime(rawUpdateTime);
		giveLuckDrawDetailDAO.insert(giveLuckDrawDetailDO);
	}

    /**
     * 删除give_luck_draw_detail表所有数据
     */
    public void cleanGiveLuckDrawDetail() {
        GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
        exam.createCriteria();
        giveLuckDrawDetailDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除give_luck_draw_detail表数据
	 */
	public void cleanGiveLuckDrawDetailById(Long id) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		giveLuckDrawDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据eventId删除give_luck_draw_detail表数据
	 */
	public void cleanGiveLuckDrawDetailByEventId(String eventId) {
        if (StringUtils.isBlank(eventId)){
            eventId = "test_eventId";
        }
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		giveLuckDrawDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据giveBizNo删除give_luck_draw_detail表数据
	 */
	public void cleanGiveLuckDrawDetailByGiveBizNo(String giveBizNo) {
        if (StringUtils.isBlank(giveBizNo)){
            giveBizNo = "test_giveBizNo";
        }
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andGiveBizNoEqualTo(giveBizNo);
		giveLuckDrawDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除give_luck_draw_detail表数据
	 */
	public void cleanGiveLuckDrawDetailByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		giveLuckDrawDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除give_luck_draw_detail表数据
	 */
	public void cleanGiveLuckDrawDetailByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		giveLuckDrawDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除give_luck_draw_detail表数据
	 */
	public void cleanGiveLuckDrawDetailByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		giveLuckDrawDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据groupNo删除give_luck_draw_detail表数据
	 */
	public void cleanGiveLuckDrawDetailByGroupNo(String groupNo) {
        if (StringUtils.isBlank(groupNo)){
            groupNo = "test_groupNo";
        }
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andGroupNoEqualTo(groupNo);
		giveLuckDrawDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据groupName删除give_luck_draw_detail表数据
	*/
	public void cleanGiveLuckDrawDetailByGroupName(String groupName) {
        if (StringUtils.isBlank(groupName)){
            groupName = "test_groupName";
        }
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		giveLuckDrawDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNo删除give_luck_draw_detail表数据
	 */
	public void cleanGiveLuckDrawDetailByCampaignNo(String campaignNo) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		giveLuckDrawDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据campaignName删除give_luck_draw_detail表数据
	*/
	public void cleanGiveLuckDrawDetailByCampaignName(String campaignName) {
        if (StringUtils.isBlank(campaignName)){
            campaignName = "test_campaignName";
        }
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andCampaignNameEqualTo(campaignName);
		giveLuckDrawDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据ruleId删除give_luck_draw_detail表数据
	 */
	public void cleanGiveLuckDrawDetailByRuleId(Long ruleId) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		giveLuckDrawDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据partakeUserId删除give_luck_draw_detail表数据
	 */
	public void cleanGiveLuckDrawDetailByPartakeUserId(String partakeUserId) {
        if (StringUtils.isBlank(partakeUserId)){
            partakeUserId = "test_partakeUserId";
        }
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andPartakeUserIdEqualTo(partakeUserId);
		giveLuckDrawDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除give_luck_draw_detail表数据
	 */
	public void cleanGiveLuckDrawDetailByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		giveLuckDrawDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除give_luck_draw_detail表数据
	 */
	public void cleanGiveLuckDrawDetailByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		giveLuckDrawDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除give_luck_draw_detail表数据
	*/
	public void cleanGiveLuckDrawDetailByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		giveLuckDrawDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据operatorId删除give_luck_draw_detail表数据
	 */
	public void cleanGiveLuckDrawDetailByOperatorId(String operatorId) {
        if (StringUtils.isBlank(operatorId)){
            operatorId = "test_operatorId";
        }
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		giveLuckDrawDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据operatorName删除give_luck_draw_detail表数据
	*/
	public void cleanGiveLuckDrawDetailByOperatorName(String operatorName) {
        if (StringUtils.isBlank(operatorName)){
            operatorName = "test_operatorName";
        }
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		giveLuckDrawDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据terminalCode删除give_luck_draw_detail表数据
	*/
	public void cleanGiveLuckDrawDetailByTerminalCode(String terminalCode) {
        if (StringUtils.isBlank(terminalCode)){
            terminalCode = "test_terminalCode";
        }
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		giveLuckDrawDetailDAO.deleteByExample(exam);
	}

    /**
     * 查询give_luck_draw_detail表所有数据
     */
    public List<GiveLuckDrawDetailDO> findGiveLuckDrawDetailAll() {
        GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
        exam.createCriteria();
		return giveLuckDrawDetailDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询give_luck_draw_detail表数据
	 */
	public List<GiveLuckDrawDetailDO> findGiveLuckDrawDetailById(Long id) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return giveLuckDrawDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据eventId查询give_luck_draw_detail表数据
	 */
	public List<GiveLuckDrawDetailDO> findGiveLuckDrawDetailByEventId(String eventId) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		return giveLuckDrawDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据giveBizNo查询give_luck_draw_detail表数据
	 */
	public List<GiveLuckDrawDetailDO> findGiveLuckDrawDetailByGiveBizNo(String giveBizNo) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andGiveBizNoEqualTo(giveBizNo);
		return giveLuckDrawDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询give_luck_draw_detail表数据
	 */
	public List<GiveLuckDrawDetailDO> findGiveLuckDrawDetailByGid(String gid) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return giveLuckDrawDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询give_luck_draw_detail表数据
	 */
	public List<GiveLuckDrawDetailDO> findGiveLuckDrawDetailByPlatPartnerId(String platPartnerId) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return giveLuckDrawDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询give_luck_draw_detail表数据
	 */
	public List<GiveLuckDrawDetailDO> findGiveLuckDrawDetailByPartnerId(String partnerId) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return giveLuckDrawDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据groupNo查询give_luck_draw_detail表数据
	 */
	public List<GiveLuckDrawDetailDO> findGiveLuckDrawDetailByGroupNo(String groupNo) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andGroupNoEqualTo(groupNo);
		return giveLuckDrawDetailDAO.selectByExample(exam);
	}

	/**
	* 根据groupName查询give_luck_draw_detail表数据
	*/
	public List<GiveLuckDrawDetailDO> findGiveLuckDrawDetailByGroupName(String groupName) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		return giveLuckDrawDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNo查询give_luck_draw_detail表数据
	 */
	public List<GiveLuckDrawDetailDO> findGiveLuckDrawDetailByCampaignNo(String campaignNo) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		return giveLuckDrawDetailDAO.selectByExample(exam);
	}

	/**
	* 根据campaignName查询give_luck_draw_detail表数据
	*/
	public List<GiveLuckDrawDetailDO> findGiveLuckDrawDetailByCampaignName(String campaignName) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andCampaignNameEqualTo(campaignName);
		return giveLuckDrawDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据ruleId查询give_luck_draw_detail表数据
	 */
	public List<GiveLuckDrawDetailDO> findGiveLuckDrawDetailByRuleId(Long ruleId) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		return giveLuckDrawDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据partakeUserId查询give_luck_draw_detail表数据
	 */
	public List<GiveLuckDrawDetailDO> findGiveLuckDrawDetailByPartakeUserId(String partakeUserId) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andPartakeUserIdEqualTo(partakeUserId);
		return giveLuckDrawDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询give_luck_draw_detail表数据
	 */
	public List<GiveLuckDrawDetailDO> findGiveLuckDrawDetailByUserId(String userId) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return giveLuckDrawDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询give_luck_draw_detail表数据
	 */
	public List<GiveLuckDrawDetailDO> findGiveLuckDrawDetailByStationId(String stationId) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return giveLuckDrawDetailDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询give_luck_draw_detail表数据
	*/
	public List<GiveLuckDrawDetailDO> findGiveLuckDrawDetailByStationName(String stationName) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return giveLuckDrawDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据operatorId查询give_luck_draw_detail表数据
	 */
	public List<GiveLuckDrawDetailDO> findGiveLuckDrawDetailByOperatorId(String operatorId) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		return giveLuckDrawDetailDAO.selectByExample(exam);
	}

	/**
	* 根据operatorName查询give_luck_draw_detail表数据
	*/
	public List<GiveLuckDrawDetailDO> findGiveLuckDrawDetailByOperatorName(String operatorName) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		return giveLuckDrawDetailDAO.selectByExample(exam);
	}

	/**
	* 根据terminalCode查询give_luck_draw_detail表数据
	*/
	public List<GiveLuckDrawDetailDO> findGiveLuckDrawDetailByTerminalCode(String terminalCode) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		return giveLuckDrawDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新give_luck_draw_detail表数据
	 */
	public void updateGiveLuckDrawDetailById(Long id,GiveLuckDrawDetailDO giveLuckDrawDetailDO) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		giveLuckDrawDetailDAO.updateByExample(giveLuckDrawDetailDO, exam);
	}

    /**
	 * 根据eventId更新give_luck_draw_detail表数据
	 */
	public void updateGiveLuckDrawDetailByEventId(String eventId,GiveLuckDrawDetailDO giveLuckDrawDetailDO) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		giveLuckDrawDetailDAO.updateByExample(giveLuckDrawDetailDO, exam);
	}

    /**
	 * 根据giveBizNo更新give_luck_draw_detail表数据
	 */
	public void updateGiveLuckDrawDetailByGiveBizNo(String giveBizNo,GiveLuckDrawDetailDO giveLuckDrawDetailDO) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andGiveBizNoEqualTo(giveBizNo);
		giveLuckDrawDetailDAO.updateByExample(giveLuckDrawDetailDO, exam);
	}

    /**
	 * 根据gid更新give_luck_draw_detail表数据
	 */
	public void updateGiveLuckDrawDetailByGid(String gid,GiveLuckDrawDetailDO giveLuckDrawDetailDO) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		giveLuckDrawDetailDAO.updateByExample(giveLuckDrawDetailDO, exam);
	}

    /**
	 * 根据platPartnerId更新give_luck_draw_detail表数据
	 */
	public void updateGiveLuckDrawDetailByPlatPartnerId(String platPartnerId,GiveLuckDrawDetailDO giveLuckDrawDetailDO) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		giveLuckDrawDetailDAO.updateByExample(giveLuckDrawDetailDO, exam);
	}

    /**
	 * 根据partnerId更新give_luck_draw_detail表数据
	 */
	public void updateGiveLuckDrawDetailByPartnerId(String partnerId,GiveLuckDrawDetailDO giveLuckDrawDetailDO) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		giveLuckDrawDetailDAO.updateByExample(giveLuckDrawDetailDO, exam);
	}

    /**
	 * 根据groupNo更新give_luck_draw_detail表数据
	 */
	public void updateGiveLuckDrawDetailByGroupNo(String groupNo,GiveLuckDrawDetailDO giveLuckDrawDetailDO) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andGroupNoEqualTo(groupNo);
		giveLuckDrawDetailDAO.updateByExample(giveLuckDrawDetailDO, exam);
	}

	/**
	* 根据groupName更新give_luck_draw_detail表数据
	*/
	public void updateGiveLuckDrawDetailByGroupName(String groupName,GiveLuckDrawDetailDO giveLuckDrawDetailDO) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		giveLuckDrawDetailDAO.updateByExample(giveLuckDrawDetailDO, exam);
	}

    /**
	 * 根据campaignNo更新give_luck_draw_detail表数据
	 */
	public void updateGiveLuckDrawDetailByCampaignNo(String campaignNo,GiveLuckDrawDetailDO giveLuckDrawDetailDO) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		giveLuckDrawDetailDAO.updateByExample(giveLuckDrawDetailDO, exam);
	}

	/**
	* 根据campaignName更新give_luck_draw_detail表数据
	*/
	public void updateGiveLuckDrawDetailByCampaignName(String campaignName,GiveLuckDrawDetailDO giveLuckDrawDetailDO) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andCampaignNameEqualTo(campaignName);
		giveLuckDrawDetailDAO.updateByExample(giveLuckDrawDetailDO, exam);
	}

    /**
	 * 根据ruleId更新give_luck_draw_detail表数据
	 */
	public void updateGiveLuckDrawDetailByRuleId(Long ruleId,GiveLuckDrawDetailDO giveLuckDrawDetailDO) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		giveLuckDrawDetailDAO.updateByExample(giveLuckDrawDetailDO, exam);
	}

    /**
	 * 根据partakeUserId更新give_luck_draw_detail表数据
	 */
	public void updateGiveLuckDrawDetailByPartakeUserId(String partakeUserId,GiveLuckDrawDetailDO giveLuckDrawDetailDO) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andPartakeUserIdEqualTo(partakeUserId);
		giveLuckDrawDetailDAO.updateByExample(giveLuckDrawDetailDO, exam);
	}

    /**
	 * 根据userId更新give_luck_draw_detail表数据
	 */
	public void updateGiveLuckDrawDetailByUserId(String userId,GiveLuckDrawDetailDO giveLuckDrawDetailDO) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		giveLuckDrawDetailDAO.updateByExample(giveLuckDrawDetailDO, exam);
	}

    /**
	 * 根据stationId更新give_luck_draw_detail表数据
	 */
	public void updateGiveLuckDrawDetailByStationId(String stationId,GiveLuckDrawDetailDO giveLuckDrawDetailDO) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		giveLuckDrawDetailDAO.updateByExample(giveLuckDrawDetailDO, exam);
	}

	/**
	* 根据stationName更新give_luck_draw_detail表数据
	*/
	public void updateGiveLuckDrawDetailByStationName(String stationName,GiveLuckDrawDetailDO giveLuckDrawDetailDO) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		giveLuckDrawDetailDAO.updateByExample(giveLuckDrawDetailDO, exam);
	}

    /**
	 * 根据operatorId更新give_luck_draw_detail表数据
	 */
	public void updateGiveLuckDrawDetailByOperatorId(String operatorId,GiveLuckDrawDetailDO giveLuckDrawDetailDO) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		giveLuckDrawDetailDAO.updateByExample(giveLuckDrawDetailDO, exam);
	}

	/**
	* 根据operatorName更新give_luck_draw_detail表数据
	*/
	public void updateGiveLuckDrawDetailByOperatorName(String operatorName,GiveLuckDrawDetailDO giveLuckDrawDetailDO) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		giveLuckDrawDetailDAO.updateByExample(giveLuckDrawDetailDO, exam);
	}

	/**
	* 根据terminalCode更新give_luck_draw_detail表数据
	*/
	public void updateGiveLuckDrawDetailByTerminalCode(String terminalCode,GiveLuckDrawDetailDO giveLuckDrawDetailDO) {
		GiveLuckDrawDetailDOExample exam = new GiveLuckDrawDetailDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		giveLuckDrawDetailDAO.updateByExample(giveLuckDrawDetailDO, exam);
	}

    /**
	 * 断言give_money_detail表
	 */
	public void giveMoneyDetailAssert(
	        GiveMoneyDetailDO giveMoneyDetailDO,
			Long id, 
			String eventId, 
			String giveBizNo, 
			String gid, 
			String partnerId, 
			String platPartnerId, 
			String campaignNo, 
			String campaignType, 
			String campaignName, 
			String promotionWay, 
			Long ruleId, 
			String userId, 
			String accountTag, 
			String marketUser, 
			String status, 
			Long amount, 
			String stationId, 
			String stationName, 
			String operatorId, 
			String operatorName, 
			String terminalType, 
			String terminalCode, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String groupNo, 
			String groupName, 
			String partakeUserId, 
			String partakeUser
	) {
        assertEquals(id, giveMoneyDetailDO.getId());
        assertEquals(eventId, giveMoneyDetailDO.getEventId());
        assertEquals(giveBizNo, giveMoneyDetailDO.getGiveBizNo());
        assertEquals(gid, giveMoneyDetailDO.getGid());
        assertEquals(partnerId, giveMoneyDetailDO.getPartnerId());
        assertEquals(platPartnerId, giveMoneyDetailDO.getPlatPartnerId());
        assertEquals(campaignNo, giveMoneyDetailDO.getCampaignNo());
        assertEquals(campaignType, giveMoneyDetailDO.getCampaignType());
        assertEquals(campaignName, giveMoneyDetailDO.getCampaignName());
        assertEquals(promotionWay, giveMoneyDetailDO.getPromotionWay());
        assertEquals(ruleId, giveMoneyDetailDO.getRuleId());
        assertEquals(userId, giveMoneyDetailDO.getUserId());
        assertEquals(accountTag, giveMoneyDetailDO.getAccountTag());
        assertEquals(marketUser, giveMoneyDetailDO.getMarketUser());
        assertEquals(status, giveMoneyDetailDO.getStatus());
        assertEquals(amount, giveMoneyDetailDO.getAmount());
        assertEquals(stationId, giveMoneyDetailDO.getStationId());
        assertEquals(stationName, giveMoneyDetailDO.getStationName());
        assertEquals(operatorId, giveMoneyDetailDO.getOperatorId());
        assertEquals(operatorName, giveMoneyDetailDO.getOperatorName());
        assertEquals(terminalType, giveMoneyDetailDO.getTerminalType());
        assertEquals(terminalCode, giveMoneyDetailDO.getTerminalCode());
        assertEquals(rawAddTime, giveMoneyDetailDO.getRawAddTime());
        assertEquals(rawUpdateTime, giveMoneyDetailDO.getRawUpdateTime());
        assertEquals(groupNo, giveMoneyDetailDO.getGroupNo());
        assertEquals(groupName, giveMoneyDetailDO.getGroupName());
        assertEquals(partakeUserId, giveMoneyDetailDO.getPartakeUserId());
        assertEquals(partakeUser, giveMoneyDetailDO.getPartakeUser());
	}

	/**
	 * 断言give_money_detail表数据
	 */
	public void assertGiveMoneyDetail(GiveMoneyDetailDO expect, GiveMoneyDetailDO giveMoneyDetailDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			giveMoneyDetailDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != giveMoneyDetailDO.getRawAddTime());
		expect.setRawAddTime(giveMoneyDetailDO.getRawAddTime());
        Assertions.assertTrue(null != giveMoneyDetailDO.getRawUpdateTime());
		expect.setRawUpdateTime(giveMoneyDetailDO.getRawUpdateTime());
		Assertions.assertEquals(expect, giveMoneyDetailDO);
	}

    /**
	 * 插入give_money_detail表数据
	 */
	public void insertGiveMoneyDetail(GiveMoneyDetailDO giveMoneyDetailDO) {
		giveMoneyDetailDAO.insert(giveMoneyDetailDO);
	}

    /**
	 * 插入give_money_detail表数据
	 */
	public void insertGiveMoneyDetail(
			Long id, 
			String eventId, 
			String giveBizNo, 
			String gid, 
			String partnerId, 
			String platPartnerId, 
			String campaignNo, 
			String campaignType, 
			String campaignName, 
			String promotionWay, 
			Long ruleId, 
			String userId, 
			String accountTag, 
			String marketUser, 
			String status, 
			Long amount, 
			String stationId, 
			String stationName, 
			String operatorId, 
			String operatorName, 
			String terminalType, 
			String terminalCode, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String groupNo, 
			String groupName, 
			String partakeUserId, 
			String partakeUser
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GiveMoneyDetailDO giveMoneyDetailDO = new GiveMoneyDetailDO();
		giveMoneyDetailDO.setId(id);
		giveMoneyDetailDO.setEventId(eventId);
		giveMoneyDetailDO.setGiveBizNo(giveBizNo);
		giveMoneyDetailDO.setGid(gid);
		giveMoneyDetailDO.setPartnerId(partnerId);
		giveMoneyDetailDO.setPlatPartnerId(platPartnerId);
		giveMoneyDetailDO.setCampaignNo(campaignNo);
		giveMoneyDetailDO.setCampaignType(campaignType);
		giveMoneyDetailDO.setCampaignName(campaignName);
		giveMoneyDetailDO.setPromotionWay(promotionWay);
		giveMoneyDetailDO.setRuleId(ruleId);
		giveMoneyDetailDO.setUserId(userId);
		giveMoneyDetailDO.setAccountTag(accountTag);
		giveMoneyDetailDO.setMarketUser(marketUser);
		giveMoneyDetailDO.setStatus(status);
		giveMoneyDetailDO.setAmount(amount);
		giveMoneyDetailDO.setStationId(stationId);
		giveMoneyDetailDO.setStationName(stationName);
		giveMoneyDetailDO.setOperatorId(operatorId);
		giveMoneyDetailDO.setOperatorName(operatorName);
		giveMoneyDetailDO.setTerminalType(terminalType);
		giveMoneyDetailDO.setTerminalCode(terminalCode);
		giveMoneyDetailDO.setRawAddTime(rawAddTime);
		giveMoneyDetailDO.setRawUpdateTime(rawUpdateTime);
		giveMoneyDetailDO.setGroupNo(groupNo);
		giveMoneyDetailDO.setGroupName(groupName);
		giveMoneyDetailDO.setPartakeUserId(partakeUserId);
		giveMoneyDetailDO.setPartakeUser(partakeUser);
		giveMoneyDetailDAO.insert(giveMoneyDetailDO);
	}

    /**
     * 删除give_money_detail表所有数据
     */
    public void cleanGiveMoneyDetail() {
        GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
        exam.createCriteria();
        giveMoneyDetailDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除give_money_detail表数据
	 */
	public void cleanGiveMoneyDetailById(Long id) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		giveMoneyDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据eventId删除give_money_detail表数据
	 */
	public void cleanGiveMoneyDetailByEventId(String eventId) {
        if (StringUtils.isBlank(eventId)){
            eventId = "test_eventId";
        }
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		giveMoneyDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据giveBizNo删除give_money_detail表数据
	 */
	public void cleanGiveMoneyDetailByGiveBizNo(String giveBizNo) {
        if (StringUtils.isBlank(giveBizNo)){
            giveBizNo = "test_giveBizNo";
        }
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andGiveBizNoEqualTo(giveBizNo);
		giveMoneyDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除give_money_detail表数据
	 */
	public void cleanGiveMoneyDetailByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		giveMoneyDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除give_money_detail表数据
	 */
	public void cleanGiveMoneyDetailByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		giveMoneyDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除give_money_detail表数据
	 */
	public void cleanGiveMoneyDetailByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		giveMoneyDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNo删除give_money_detail表数据
	 */
	public void cleanGiveMoneyDetailByCampaignNo(String campaignNo) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		giveMoneyDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据campaignName删除give_money_detail表数据
	*/
	public void cleanGiveMoneyDetailByCampaignName(String campaignName) {
        if (StringUtils.isBlank(campaignName)){
            campaignName = "test_campaignName";
        }
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andCampaignNameEqualTo(campaignName);
		giveMoneyDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据ruleId删除give_money_detail表数据
	 */
	public void cleanGiveMoneyDetailByRuleId(Long ruleId) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		giveMoneyDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除give_money_detail表数据
	 */
	public void cleanGiveMoneyDetailByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		giveMoneyDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除give_money_detail表数据
	 */
	public void cleanGiveMoneyDetailByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		giveMoneyDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除give_money_detail表数据
	*/
	public void cleanGiveMoneyDetailByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		giveMoneyDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据operatorId删除give_money_detail表数据
	 */
	public void cleanGiveMoneyDetailByOperatorId(String operatorId) {
        if (StringUtils.isBlank(operatorId)){
            operatorId = "test_operatorId";
        }
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		giveMoneyDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据operatorName删除give_money_detail表数据
	*/
	public void cleanGiveMoneyDetailByOperatorName(String operatorName) {
        if (StringUtils.isBlank(operatorName)){
            operatorName = "test_operatorName";
        }
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		giveMoneyDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据terminalCode删除give_money_detail表数据
	*/
	public void cleanGiveMoneyDetailByTerminalCode(String terminalCode) {
        if (StringUtils.isBlank(terminalCode)){
            terminalCode = "test_terminalCode";
        }
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		giveMoneyDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据groupNo删除give_money_detail表数据
	 */
	public void cleanGiveMoneyDetailByGroupNo(String groupNo) {
        if (StringUtils.isBlank(groupNo)){
            groupNo = "test_groupNo";
        }
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andGroupNoEqualTo(groupNo);
		giveMoneyDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据groupName删除give_money_detail表数据
	*/
	public void cleanGiveMoneyDetailByGroupName(String groupName) {
        if (StringUtils.isBlank(groupName)){
            groupName = "test_groupName";
        }
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		giveMoneyDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据partakeUserId删除give_money_detail表数据
	 */
	public void cleanGiveMoneyDetailByPartakeUserId(String partakeUserId) {
        if (StringUtils.isBlank(partakeUserId)){
            partakeUserId = "test_partakeUserId";
        }
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andPartakeUserIdEqualTo(partakeUserId);
		giveMoneyDetailDAO.deleteByExample(exam);
	}

    /**
     * 查询give_money_detail表所有数据
     */
    public List<GiveMoneyDetailDO> findGiveMoneyDetailAll() {
        GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
        exam.createCriteria();
		return giveMoneyDetailDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询give_money_detail表数据
	 */
	public List<GiveMoneyDetailDO> findGiveMoneyDetailById(Long id) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return giveMoneyDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据eventId查询give_money_detail表数据
	 */
	public List<GiveMoneyDetailDO> findGiveMoneyDetailByEventId(String eventId) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		return giveMoneyDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据giveBizNo查询give_money_detail表数据
	 */
	public List<GiveMoneyDetailDO> findGiveMoneyDetailByGiveBizNo(String giveBizNo) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andGiveBizNoEqualTo(giveBizNo);
		return giveMoneyDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询give_money_detail表数据
	 */
	public List<GiveMoneyDetailDO> findGiveMoneyDetailByGid(String gid) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return giveMoneyDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询give_money_detail表数据
	 */
	public List<GiveMoneyDetailDO> findGiveMoneyDetailByPartnerId(String partnerId) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return giveMoneyDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询give_money_detail表数据
	 */
	public List<GiveMoneyDetailDO> findGiveMoneyDetailByPlatPartnerId(String platPartnerId) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return giveMoneyDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNo查询give_money_detail表数据
	 */
	public List<GiveMoneyDetailDO> findGiveMoneyDetailByCampaignNo(String campaignNo) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		return giveMoneyDetailDAO.selectByExample(exam);
	}

	/**
	* 根据campaignName查询give_money_detail表数据
	*/
	public List<GiveMoneyDetailDO> findGiveMoneyDetailByCampaignName(String campaignName) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andCampaignNameEqualTo(campaignName);
		return giveMoneyDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据ruleId查询give_money_detail表数据
	 */
	public List<GiveMoneyDetailDO> findGiveMoneyDetailByRuleId(Long ruleId) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		return giveMoneyDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询give_money_detail表数据
	 */
	public List<GiveMoneyDetailDO> findGiveMoneyDetailByUserId(String userId) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return giveMoneyDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询give_money_detail表数据
	 */
	public List<GiveMoneyDetailDO> findGiveMoneyDetailByStationId(String stationId) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return giveMoneyDetailDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询give_money_detail表数据
	*/
	public List<GiveMoneyDetailDO> findGiveMoneyDetailByStationName(String stationName) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return giveMoneyDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据operatorId查询give_money_detail表数据
	 */
	public List<GiveMoneyDetailDO> findGiveMoneyDetailByOperatorId(String operatorId) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		return giveMoneyDetailDAO.selectByExample(exam);
	}

	/**
	* 根据operatorName查询give_money_detail表数据
	*/
	public List<GiveMoneyDetailDO> findGiveMoneyDetailByOperatorName(String operatorName) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		return giveMoneyDetailDAO.selectByExample(exam);
	}

	/**
	* 根据terminalCode查询give_money_detail表数据
	*/
	public List<GiveMoneyDetailDO> findGiveMoneyDetailByTerminalCode(String terminalCode) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		return giveMoneyDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据groupNo查询give_money_detail表数据
	 */
	public List<GiveMoneyDetailDO> findGiveMoneyDetailByGroupNo(String groupNo) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andGroupNoEqualTo(groupNo);
		return giveMoneyDetailDAO.selectByExample(exam);
	}

	/**
	* 根据groupName查询give_money_detail表数据
	*/
	public List<GiveMoneyDetailDO> findGiveMoneyDetailByGroupName(String groupName) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		return giveMoneyDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据partakeUserId查询give_money_detail表数据
	 */
	public List<GiveMoneyDetailDO> findGiveMoneyDetailByPartakeUserId(String partakeUserId) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andPartakeUserIdEqualTo(partakeUserId);
		return giveMoneyDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新give_money_detail表数据
	 */
	public void updateGiveMoneyDetailById(Long id,GiveMoneyDetailDO giveMoneyDetailDO) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		giveMoneyDetailDAO.updateByExample(giveMoneyDetailDO, exam);
	}

    /**
	 * 根据eventId更新give_money_detail表数据
	 */
	public void updateGiveMoneyDetailByEventId(String eventId,GiveMoneyDetailDO giveMoneyDetailDO) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		giveMoneyDetailDAO.updateByExample(giveMoneyDetailDO, exam);
	}

    /**
	 * 根据giveBizNo更新give_money_detail表数据
	 */
	public void updateGiveMoneyDetailByGiveBizNo(String giveBizNo,GiveMoneyDetailDO giveMoneyDetailDO) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andGiveBizNoEqualTo(giveBizNo);
		giveMoneyDetailDAO.updateByExample(giveMoneyDetailDO, exam);
	}

    /**
	 * 根据gid更新give_money_detail表数据
	 */
	public void updateGiveMoneyDetailByGid(String gid,GiveMoneyDetailDO giveMoneyDetailDO) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		giveMoneyDetailDAO.updateByExample(giveMoneyDetailDO, exam);
	}

    /**
	 * 根据partnerId更新give_money_detail表数据
	 */
	public void updateGiveMoneyDetailByPartnerId(String partnerId,GiveMoneyDetailDO giveMoneyDetailDO) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		giveMoneyDetailDAO.updateByExample(giveMoneyDetailDO, exam);
	}

    /**
	 * 根据platPartnerId更新give_money_detail表数据
	 */
	public void updateGiveMoneyDetailByPlatPartnerId(String platPartnerId,GiveMoneyDetailDO giveMoneyDetailDO) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		giveMoneyDetailDAO.updateByExample(giveMoneyDetailDO, exam);
	}

    /**
	 * 根据campaignNo更新give_money_detail表数据
	 */
	public void updateGiveMoneyDetailByCampaignNo(String campaignNo,GiveMoneyDetailDO giveMoneyDetailDO) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		giveMoneyDetailDAO.updateByExample(giveMoneyDetailDO, exam);
	}

	/**
	* 根据campaignName更新give_money_detail表数据
	*/
	public void updateGiveMoneyDetailByCampaignName(String campaignName,GiveMoneyDetailDO giveMoneyDetailDO) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andCampaignNameEqualTo(campaignName);
		giveMoneyDetailDAO.updateByExample(giveMoneyDetailDO, exam);
	}

    /**
	 * 根据ruleId更新give_money_detail表数据
	 */
	public void updateGiveMoneyDetailByRuleId(Long ruleId,GiveMoneyDetailDO giveMoneyDetailDO) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		giveMoneyDetailDAO.updateByExample(giveMoneyDetailDO, exam);
	}

    /**
	 * 根据userId更新give_money_detail表数据
	 */
	public void updateGiveMoneyDetailByUserId(String userId,GiveMoneyDetailDO giveMoneyDetailDO) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		giveMoneyDetailDAO.updateByExample(giveMoneyDetailDO, exam);
	}

    /**
	 * 根据stationId更新give_money_detail表数据
	 */
	public void updateGiveMoneyDetailByStationId(String stationId,GiveMoneyDetailDO giveMoneyDetailDO) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		giveMoneyDetailDAO.updateByExample(giveMoneyDetailDO, exam);
	}

	/**
	* 根据stationName更新give_money_detail表数据
	*/
	public void updateGiveMoneyDetailByStationName(String stationName,GiveMoneyDetailDO giveMoneyDetailDO) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		giveMoneyDetailDAO.updateByExample(giveMoneyDetailDO, exam);
	}

    /**
	 * 根据operatorId更新give_money_detail表数据
	 */
	public void updateGiveMoneyDetailByOperatorId(String operatorId,GiveMoneyDetailDO giveMoneyDetailDO) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		giveMoneyDetailDAO.updateByExample(giveMoneyDetailDO, exam);
	}

	/**
	* 根据operatorName更新give_money_detail表数据
	*/
	public void updateGiveMoneyDetailByOperatorName(String operatorName,GiveMoneyDetailDO giveMoneyDetailDO) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		giveMoneyDetailDAO.updateByExample(giveMoneyDetailDO, exam);
	}

	/**
	* 根据terminalCode更新give_money_detail表数据
	*/
	public void updateGiveMoneyDetailByTerminalCode(String terminalCode,GiveMoneyDetailDO giveMoneyDetailDO) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		giveMoneyDetailDAO.updateByExample(giveMoneyDetailDO, exam);
	}

    /**
	 * 根据groupNo更新give_money_detail表数据
	 */
	public void updateGiveMoneyDetailByGroupNo(String groupNo,GiveMoneyDetailDO giveMoneyDetailDO) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andGroupNoEqualTo(groupNo);
		giveMoneyDetailDAO.updateByExample(giveMoneyDetailDO, exam);
	}

	/**
	* 根据groupName更新give_money_detail表数据
	*/
	public void updateGiveMoneyDetailByGroupName(String groupName,GiveMoneyDetailDO giveMoneyDetailDO) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		giveMoneyDetailDAO.updateByExample(giveMoneyDetailDO, exam);
	}

    /**
	 * 根据partakeUserId更新give_money_detail表数据
	 */
	public void updateGiveMoneyDetailByPartakeUserId(String partakeUserId,GiveMoneyDetailDO giveMoneyDetailDO) {
		GiveMoneyDetailDOExample exam = new GiveMoneyDetailDOExample();
		exam.createCriteria().andPartakeUserIdEqualTo(partakeUserId);
		giveMoneyDetailDAO.updateByExample(giveMoneyDetailDO, exam);
	}

    /**
	 * 断言give_points_detail表
	 */
	public void givePointsDetailAssert(
	        GivePointsDetailDO givePointsDetailDO,
			Long id, 
			String eventId, 
			String giveBizNo, 
			String gid, 
			String partnerId, 
			String platPartnerId, 
			String campaignNo, 
			String campaignType, 
			String campaignName, 
			String promotionWay, 
			Long ruleId, 
			String userId, 
			String accountTag, 
			String marketUser, 
			String pointSchemeNo, 
			String pointDetails, 
			String status, 
			Long points, 
			String stationId, 
			String stationName, 
			String operatorId, 
			String operatorName, 
			String terminalType, 
			String terminalCode, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String groupNo, 
			String groupName, 
			String partakeUserId, 
			String partakeUser
	) {
        assertEquals(id, givePointsDetailDO.getId());
        assertEquals(eventId, givePointsDetailDO.getEventId());
        assertEquals(giveBizNo, givePointsDetailDO.getGiveBizNo());
        assertEquals(gid, givePointsDetailDO.getGid());
        assertEquals(partnerId, givePointsDetailDO.getPartnerId());
        assertEquals(platPartnerId, givePointsDetailDO.getPlatPartnerId());
        assertEquals(campaignNo, givePointsDetailDO.getCampaignNo());
        assertEquals(campaignType, givePointsDetailDO.getCampaignType());
        assertEquals(campaignName, givePointsDetailDO.getCampaignName());
        assertEquals(promotionWay, givePointsDetailDO.getPromotionWay());
        assertEquals(ruleId, givePointsDetailDO.getRuleId());
        assertEquals(userId, givePointsDetailDO.getUserId());
        assertEquals(accountTag, givePointsDetailDO.getAccountTag());
        assertEquals(marketUser, givePointsDetailDO.getMarketUser());
        assertEquals(pointSchemeNo, givePointsDetailDO.getPointSchemeNo());
        assertEquals(pointDetails, givePointsDetailDO.getPointDetails());
        assertEquals(status, givePointsDetailDO.getStatus());
        assertEquals(points, givePointsDetailDO.getPoints());
        assertEquals(stationId, givePointsDetailDO.getStationId());
        assertEquals(stationName, givePointsDetailDO.getStationName());
        assertEquals(operatorId, givePointsDetailDO.getOperatorId());
        assertEquals(operatorName, givePointsDetailDO.getOperatorName());
        assertEquals(terminalType, givePointsDetailDO.getTerminalType());
        assertEquals(terminalCode, givePointsDetailDO.getTerminalCode());
        assertEquals(rawAddTime, givePointsDetailDO.getRawAddTime());
        assertEquals(rawUpdateTime, givePointsDetailDO.getRawUpdateTime());
        assertEquals(groupNo, givePointsDetailDO.getGroupNo());
        assertEquals(groupName, givePointsDetailDO.getGroupName());
        assertEquals(partakeUserId, givePointsDetailDO.getPartakeUserId());
        assertEquals(partakeUser, givePointsDetailDO.getPartakeUser());
	}

	/**
	 * 断言give_points_detail表数据
	 */
	public void assertGivePointsDetail(GivePointsDetailDO expect, GivePointsDetailDO givePointsDetailDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			givePointsDetailDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != givePointsDetailDO.getRawAddTime());
		expect.setRawAddTime(givePointsDetailDO.getRawAddTime());
        Assertions.assertTrue(null != givePointsDetailDO.getRawUpdateTime());
		expect.setRawUpdateTime(givePointsDetailDO.getRawUpdateTime());
		Assertions.assertEquals(expect, givePointsDetailDO);
	}

    /**
	 * 插入give_points_detail表数据
	 */
	public void insertGivePointsDetail(GivePointsDetailDO givePointsDetailDO) {
		givePointsDetailDAO.insert(givePointsDetailDO);
	}

    /**
	 * 插入give_points_detail表数据
	 */
	public void insertGivePointsDetail(
			Long id, 
			String eventId, 
			String giveBizNo, 
			String gid, 
			String partnerId, 
			String platPartnerId, 
			String campaignNo, 
			String campaignType, 
			String campaignName, 
			String promotionWay, 
			Long ruleId, 
			String userId, 
			String accountTag, 
			String marketUser, 
			String pointSchemeNo, 
			String pointDetails, 
			String status, 
			Long points, 
			String stationId, 
			String stationName, 
			String operatorId, 
			String operatorName, 
			String terminalType, 
			String terminalCode, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String groupNo, 
			String groupName, 
			String partakeUserId, 
			String partakeUser
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GivePointsDetailDO givePointsDetailDO = new GivePointsDetailDO();
		givePointsDetailDO.setId(id);
		givePointsDetailDO.setEventId(eventId);
		givePointsDetailDO.setGiveBizNo(giveBizNo);
		givePointsDetailDO.setGid(gid);
		givePointsDetailDO.setPartnerId(partnerId);
		givePointsDetailDO.setPlatPartnerId(platPartnerId);
		givePointsDetailDO.setCampaignNo(campaignNo);
		givePointsDetailDO.setCampaignType(campaignType);
		givePointsDetailDO.setCampaignName(campaignName);
		givePointsDetailDO.setPromotionWay(promotionWay);
		givePointsDetailDO.setRuleId(ruleId);
		givePointsDetailDO.setUserId(userId);
		givePointsDetailDO.setAccountTag(accountTag);
		givePointsDetailDO.setMarketUser(marketUser);
		givePointsDetailDO.setPointSchemeNo(pointSchemeNo);
		givePointsDetailDO.setPointDetails(pointDetails);
		givePointsDetailDO.setStatus(status);
		givePointsDetailDO.setPoints(points);
		givePointsDetailDO.setStationId(stationId);
		givePointsDetailDO.setStationName(stationName);
		givePointsDetailDO.setOperatorId(operatorId);
		givePointsDetailDO.setOperatorName(operatorName);
		givePointsDetailDO.setTerminalType(terminalType);
		givePointsDetailDO.setTerminalCode(terminalCode);
		givePointsDetailDO.setRawAddTime(rawAddTime);
		givePointsDetailDO.setRawUpdateTime(rawUpdateTime);
		givePointsDetailDO.setGroupNo(groupNo);
		givePointsDetailDO.setGroupName(groupName);
		givePointsDetailDO.setPartakeUserId(partakeUserId);
		givePointsDetailDO.setPartakeUser(partakeUser);
		givePointsDetailDAO.insert(givePointsDetailDO);
	}

    /**
     * 删除give_points_detail表所有数据
     */
    public void cleanGivePointsDetail() {
        GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
        exam.createCriteria();
        givePointsDetailDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除give_points_detail表数据
	 */
	public void cleanGivePointsDetailById(Long id) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		givePointsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据eventId删除give_points_detail表数据
	 */
	public void cleanGivePointsDetailByEventId(String eventId) {
        if (StringUtils.isBlank(eventId)){
            eventId = "test_eventId";
        }
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		givePointsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据giveBizNo删除give_points_detail表数据
	 */
	public void cleanGivePointsDetailByGiveBizNo(String giveBizNo) {
        if (StringUtils.isBlank(giveBizNo)){
            giveBizNo = "test_giveBizNo";
        }
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andGiveBizNoEqualTo(giveBizNo);
		givePointsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除give_points_detail表数据
	 */
	public void cleanGivePointsDetailByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		givePointsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除give_points_detail表数据
	 */
	public void cleanGivePointsDetailByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		givePointsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除give_points_detail表数据
	 */
	public void cleanGivePointsDetailByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		givePointsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNo删除give_points_detail表数据
	 */
	public void cleanGivePointsDetailByCampaignNo(String campaignNo) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		givePointsDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据campaignName删除give_points_detail表数据
	*/
	public void cleanGivePointsDetailByCampaignName(String campaignName) {
        if (StringUtils.isBlank(campaignName)){
            campaignName = "test_campaignName";
        }
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andCampaignNameEqualTo(campaignName);
		givePointsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据ruleId删除give_points_detail表数据
	 */
	public void cleanGivePointsDetailByRuleId(Long ruleId) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		givePointsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除give_points_detail表数据
	 */
	public void cleanGivePointsDetailByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		givePointsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据pointSchemeNo删除give_points_detail表数据
	 */
	public void cleanGivePointsDetailByPointSchemeNo(String pointSchemeNo) {
        if (StringUtils.isBlank(pointSchemeNo)){
            pointSchemeNo = "test_pointSchemeNo";
        }
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andPointSchemeNoEqualTo(pointSchemeNo);
		givePointsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除give_points_detail表数据
	 */
	public void cleanGivePointsDetailByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		givePointsDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除give_points_detail表数据
	*/
	public void cleanGivePointsDetailByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		givePointsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据operatorId删除give_points_detail表数据
	 */
	public void cleanGivePointsDetailByOperatorId(String operatorId) {
        if (StringUtils.isBlank(operatorId)){
            operatorId = "test_operatorId";
        }
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		givePointsDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据operatorName删除give_points_detail表数据
	*/
	public void cleanGivePointsDetailByOperatorName(String operatorName) {
        if (StringUtils.isBlank(operatorName)){
            operatorName = "test_operatorName";
        }
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		givePointsDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据terminalCode删除give_points_detail表数据
	*/
	public void cleanGivePointsDetailByTerminalCode(String terminalCode) {
        if (StringUtils.isBlank(terminalCode)){
            terminalCode = "test_terminalCode";
        }
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		givePointsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据groupNo删除give_points_detail表数据
	 */
	public void cleanGivePointsDetailByGroupNo(String groupNo) {
        if (StringUtils.isBlank(groupNo)){
            groupNo = "test_groupNo";
        }
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andGroupNoEqualTo(groupNo);
		givePointsDetailDAO.deleteByExample(exam);
	}

	/**
	* 根据groupName删除give_points_detail表数据
	*/
	public void cleanGivePointsDetailByGroupName(String groupName) {
        if (StringUtils.isBlank(groupName)){
            groupName = "test_groupName";
        }
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		givePointsDetailDAO.deleteByExample(exam);
	}

	/**
	 * 根据partakeUserId删除give_points_detail表数据
	 */
	public void cleanGivePointsDetailByPartakeUserId(String partakeUserId) {
        if (StringUtils.isBlank(partakeUserId)){
            partakeUserId = "test_partakeUserId";
        }
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andPartakeUserIdEqualTo(partakeUserId);
		givePointsDetailDAO.deleteByExample(exam);
	}

    /**
     * 查询give_points_detail表所有数据
     */
    public List<GivePointsDetailDO> findGivePointsDetailAll() {
        GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
        exam.createCriteria();
		return givePointsDetailDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询give_points_detail表数据
	 */
	public List<GivePointsDetailDO> findGivePointsDetailById(Long id) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return givePointsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据eventId查询give_points_detail表数据
	 */
	public List<GivePointsDetailDO> findGivePointsDetailByEventId(String eventId) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		return givePointsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据giveBizNo查询give_points_detail表数据
	 */
	public List<GivePointsDetailDO> findGivePointsDetailByGiveBizNo(String giveBizNo) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andGiveBizNoEqualTo(giveBizNo);
		return givePointsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询give_points_detail表数据
	 */
	public List<GivePointsDetailDO> findGivePointsDetailByGid(String gid) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return givePointsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询give_points_detail表数据
	 */
	public List<GivePointsDetailDO> findGivePointsDetailByPartnerId(String partnerId) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return givePointsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询give_points_detail表数据
	 */
	public List<GivePointsDetailDO> findGivePointsDetailByPlatPartnerId(String platPartnerId) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return givePointsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNo查询give_points_detail表数据
	 */
	public List<GivePointsDetailDO> findGivePointsDetailByCampaignNo(String campaignNo) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		return givePointsDetailDAO.selectByExample(exam);
	}

	/**
	* 根据campaignName查询give_points_detail表数据
	*/
	public List<GivePointsDetailDO> findGivePointsDetailByCampaignName(String campaignName) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andCampaignNameEqualTo(campaignName);
		return givePointsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据ruleId查询give_points_detail表数据
	 */
	public List<GivePointsDetailDO> findGivePointsDetailByRuleId(Long ruleId) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		return givePointsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询give_points_detail表数据
	 */
	public List<GivePointsDetailDO> findGivePointsDetailByUserId(String userId) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return givePointsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据pointSchemeNo查询give_points_detail表数据
	 */
	public List<GivePointsDetailDO> findGivePointsDetailByPointSchemeNo(String pointSchemeNo) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andPointSchemeNoEqualTo(pointSchemeNo);
		return givePointsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询give_points_detail表数据
	 */
	public List<GivePointsDetailDO> findGivePointsDetailByStationId(String stationId) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return givePointsDetailDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询give_points_detail表数据
	*/
	public List<GivePointsDetailDO> findGivePointsDetailByStationName(String stationName) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return givePointsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据operatorId查询give_points_detail表数据
	 */
	public List<GivePointsDetailDO> findGivePointsDetailByOperatorId(String operatorId) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		return givePointsDetailDAO.selectByExample(exam);
	}

	/**
	* 根据operatorName查询give_points_detail表数据
	*/
	public List<GivePointsDetailDO> findGivePointsDetailByOperatorName(String operatorName) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		return givePointsDetailDAO.selectByExample(exam);
	}

	/**
	* 根据terminalCode查询give_points_detail表数据
	*/
	public List<GivePointsDetailDO> findGivePointsDetailByTerminalCode(String terminalCode) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		return givePointsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据groupNo查询give_points_detail表数据
	 */
	public List<GivePointsDetailDO> findGivePointsDetailByGroupNo(String groupNo) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andGroupNoEqualTo(groupNo);
		return givePointsDetailDAO.selectByExample(exam);
	}

	/**
	* 根据groupName查询give_points_detail表数据
	*/
	public List<GivePointsDetailDO> findGivePointsDetailByGroupName(String groupName) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		return givePointsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据partakeUserId查询give_points_detail表数据
	 */
	public List<GivePointsDetailDO> findGivePointsDetailByPartakeUserId(String partakeUserId) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andPartakeUserIdEqualTo(partakeUserId);
		return givePointsDetailDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新give_points_detail表数据
	 */
	public void updateGivePointsDetailById(Long id,GivePointsDetailDO givePointsDetailDO) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andIdEqualTo(id);
		givePointsDetailDAO.updateByExample(givePointsDetailDO, exam);
	}

    /**
	 * 根据eventId更新give_points_detail表数据
	 */
	public void updateGivePointsDetailByEventId(String eventId,GivePointsDetailDO givePointsDetailDO) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		givePointsDetailDAO.updateByExample(givePointsDetailDO, exam);
	}

    /**
	 * 根据giveBizNo更新give_points_detail表数据
	 */
	public void updateGivePointsDetailByGiveBizNo(String giveBizNo,GivePointsDetailDO givePointsDetailDO) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andGiveBizNoEqualTo(giveBizNo);
		givePointsDetailDAO.updateByExample(givePointsDetailDO, exam);
	}

    /**
	 * 根据gid更新give_points_detail表数据
	 */
	public void updateGivePointsDetailByGid(String gid,GivePointsDetailDO givePointsDetailDO) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		givePointsDetailDAO.updateByExample(givePointsDetailDO, exam);
	}

    /**
	 * 根据partnerId更新give_points_detail表数据
	 */
	public void updateGivePointsDetailByPartnerId(String partnerId,GivePointsDetailDO givePointsDetailDO) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		givePointsDetailDAO.updateByExample(givePointsDetailDO, exam);
	}

    /**
	 * 根据platPartnerId更新give_points_detail表数据
	 */
	public void updateGivePointsDetailByPlatPartnerId(String platPartnerId,GivePointsDetailDO givePointsDetailDO) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		givePointsDetailDAO.updateByExample(givePointsDetailDO, exam);
	}

    /**
	 * 根据campaignNo更新give_points_detail表数据
	 */
	public void updateGivePointsDetailByCampaignNo(String campaignNo,GivePointsDetailDO givePointsDetailDO) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		givePointsDetailDAO.updateByExample(givePointsDetailDO, exam);
	}

	/**
	* 根据campaignName更新give_points_detail表数据
	*/
	public void updateGivePointsDetailByCampaignName(String campaignName,GivePointsDetailDO givePointsDetailDO) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andCampaignNameEqualTo(campaignName);
		givePointsDetailDAO.updateByExample(givePointsDetailDO, exam);
	}

    /**
	 * 根据ruleId更新give_points_detail表数据
	 */
	public void updateGivePointsDetailByRuleId(Long ruleId,GivePointsDetailDO givePointsDetailDO) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		givePointsDetailDAO.updateByExample(givePointsDetailDO, exam);
	}

    /**
	 * 根据userId更新give_points_detail表数据
	 */
	public void updateGivePointsDetailByUserId(String userId,GivePointsDetailDO givePointsDetailDO) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		givePointsDetailDAO.updateByExample(givePointsDetailDO, exam);
	}

    /**
	 * 根据pointSchemeNo更新give_points_detail表数据
	 */
	public void updateGivePointsDetailByPointSchemeNo(String pointSchemeNo,GivePointsDetailDO givePointsDetailDO) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andPointSchemeNoEqualTo(pointSchemeNo);
		givePointsDetailDAO.updateByExample(givePointsDetailDO, exam);
	}

    /**
	 * 根据stationId更新give_points_detail表数据
	 */
	public void updateGivePointsDetailByStationId(String stationId,GivePointsDetailDO givePointsDetailDO) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		givePointsDetailDAO.updateByExample(givePointsDetailDO, exam);
	}

	/**
	* 根据stationName更新give_points_detail表数据
	*/
	public void updateGivePointsDetailByStationName(String stationName,GivePointsDetailDO givePointsDetailDO) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		givePointsDetailDAO.updateByExample(givePointsDetailDO, exam);
	}

    /**
	 * 根据operatorId更新give_points_detail表数据
	 */
	public void updateGivePointsDetailByOperatorId(String operatorId,GivePointsDetailDO givePointsDetailDO) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		givePointsDetailDAO.updateByExample(givePointsDetailDO, exam);
	}

	/**
	* 根据operatorName更新give_points_detail表数据
	*/
	public void updateGivePointsDetailByOperatorName(String operatorName,GivePointsDetailDO givePointsDetailDO) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		givePointsDetailDAO.updateByExample(givePointsDetailDO, exam);
	}

	/**
	* 根据terminalCode更新give_points_detail表数据
	*/
	public void updateGivePointsDetailByTerminalCode(String terminalCode,GivePointsDetailDO givePointsDetailDO) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		givePointsDetailDAO.updateByExample(givePointsDetailDO, exam);
	}

    /**
	 * 根据groupNo更新give_points_detail表数据
	 */
	public void updateGivePointsDetailByGroupNo(String groupNo,GivePointsDetailDO givePointsDetailDO) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andGroupNoEqualTo(groupNo);
		givePointsDetailDAO.updateByExample(givePointsDetailDO, exam);
	}

	/**
	* 根据groupName更新give_points_detail表数据
	*/
	public void updateGivePointsDetailByGroupName(String groupName,GivePointsDetailDO givePointsDetailDO) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		givePointsDetailDAO.updateByExample(givePointsDetailDO, exam);
	}

    /**
	 * 根据partakeUserId更新give_points_detail表数据
	 */
	public void updateGivePointsDetailByPartakeUserId(String partakeUserId,GivePointsDetailDO givePointsDetailDO) {
		GivePointsDetailDOExample exam = new GivePointsDetailDOExample();
		exam.createCriteria().andPartakeUserIdEqualTo(partakeUserId);
		givePointsDetailDAO.updateByExample(givePointsDetailDO, exam);
	}

    /**
	 * 断言luck_draw_account表
	 */
	public void luckDrawAccountAssert(
	        LuckDrawAccountDO luckDrawAccountDO,
			Long id, 
			String userId, 
			String campaignNo, 
			String platPartnerId, 
			String partnerId, 
			Integer luckDrawNum, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, luckDrawAccountDO.getId());
        assertEquals(userId, luckDrawAccountDO.getUserId());
        assertEquals(campaignNo, luckDrawAccountDO.getCampaignNo());
        assertEquals(platPartnerId, luckDrawAccountDO.getPlatPartnerId());
        assertEquals(partnerId, luckDrawAccountDO.getPartnerId());
        assertEquals(luckDrawNum, luckDrawAccountDO.getLuckDrawNum());
        assertEquals(rawAddTime, luckDrawAccountDO.getRawAddTime());
        assertEquals(rawUpdateTime, luckDrawAccountDO.getRawUpdateTime());
	}

	/**
	 * 断言luck_draw_account表数据
	 */
	public void assertLuckDrawAccount(LuckDrawAccountDO expect, LuckDrawAccountDO luckDrawAccountDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			luckDrawAccountDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != luckDrawAccountDO.getRawAddTime());
		expect.setRawAddTime(luckDrawAccountDO.getRawAddTime());
        Assertions.assertTrue(null != luckDrawAccountDO.getRawUpdateTime());
		expect.setRawUpdateTime(luckDrawAccountDO.getRawUpdateTime());
		Assertions.assertEquals(expect, luckDrawAccountDO);
	}

    /**
	 * 插入luck_draw_account表数据
	 */
	public void insertLuckDrawAccount(LuckDrawAccountDO luckDrawAccountDO) {
		luckDrawAccountDAO.insert(luckDrawAccountDO);
	}

    /**
	 * 插入luck_draw_account表数据
	 */
	public void insertLuckDrawAccount(
			Long id, 
			String userId, 
			String campaignNo, 
			String platPartnerId, 
			String partnerId, 
			Integer luckDrawNum, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		LuckDrawAccountDO luckDrawAccountDO = new LuckDrawAccountDO();
		luckDrawAccountDO.setId(id);
		luckDrawAccountDO.setUserId(userId);
		luckDrawAccountDO.setCampaignNo(campaignNo);
		luckDrawAccountDO.setPlatPartnerId(platPartnerId);
		luckDrawAccountDO.setPartnerId(partnerId);
		luckDrawAccountDO.setLuckDrawNum(luckDrawNum);
		luckDrawAccountDO.setRawAddTime(rawAddTime);
		luckDrawAccountDO.setRawUpdateTime(rawUpdateTime);
		luckDrawAccountDAO.insert(luckDrawAccountDO);
	}

    /**
     * 删除luck_draw_account表所有数据
     */
    public void cleanLuckDrawAccount() {
        LuckDrawAccountDOExample exam = new LuckDrawAccountDOExample();
        exam.createCriteria();
        luckDrawAccountDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除luck_draw_account表数据
	 */
	public void cleanLuckDrawAccountById(Long id) {
		LuckDrawAccountDOExample exam = new LuckDrawAccountDOExample();
		exam.createCriteria().andIdEqualTo(id);
		luckDrawAccountDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除luck_draw_account表数据
	 */
	public void cleanLuckDrawAccountByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		LuckDrawAccountDOExample exam = new LuckDrawAccountDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		luckDrawAccountDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNo删除luck_draw_account表数据
	 */
	public void cleanLuckDrawAccountByCampaignNo(String campaignNo) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
		LuckDrawAccountDOExample exam = new LuckDrawAccountDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		luckDrawAccountDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除luck_draw_account表数据
	 */
	public void cleanLuckDrawAccountByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		LuckDrawAccountDOExample exam = new LuckDrawAccountDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		luckDrawAccountDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除luck_draw_account表数据
	 */
	public void cleanLuckDrawAccountByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		LuckDrawAccountDOExample exam = new LuckDrawAccountDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		luckDrawAccountDAO.deleteByExample(exam);
	}

    /**
     * 查询luck_draw_account表所有数据
     */
    public List<LuckDrawAccountDO> findLuckDrawAccountAll() {
        LuckDrawAccountDOExample exam = new LuckDrawAccountDOExample();
        exam.createCriteria();
		return luckDrawAccountDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询luck_draw_account表数据
	 */
	public List<LuckDrawAccountDO> findLuckDrawAccountById(Long id) {
		LuckDrawAccountDOExample exam = new LuckDrawAccountDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return luckDrawAccountDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询luck_draw_account表数据
	 */
	public List<LuckDrawAccountDO> findLuckDrawAccountByUserId(String userId) {
		LuckDrawAccountDOExample exam = new LuckDrawAccountDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return luckDrawAccountDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNo查询luck_draw_account表数据
	 */
	public List<LuckDrawAccountDO> findLuckDrawAccountByCampaignNo(String campaignNo) {
		LuckDrawAccountDOExample exam = new LuckDrawAccountDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		return luckDrawAccountDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询luck_draw_account表数据
	 */
	public List<LuckDrawAccountDO> findLuckDrawAccountByPlatPartnerId(String platPartnerId) {
		LuckDrawAccountDOExample exam = new LuckDrawAccountDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return luckDrawAccountDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询luck_draw_account表数据
	 */
	public List<LuckDrawAccountDO> findLuckDrawAccountByPartnerId(String partnerId) {
		LuckDrawAccountDOExample exam = new LuckDrawAccountDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return luckDrawAccountDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新luck_draw_account表数据
	 */
	public void updateLuckDrawAccountById(Long id,LuckDrawAccountDO luckDrawAccountDO) {
		LuckDrawAccountDOExample exam = new LuckDrawAccountDOExample();
		exam.createCriteria().andIdEqualTo(id);
		luckDrawAccountDAO.updateByExample(luckDrawAccountDO, exam);
	}

    /**
	 * 根据userId更新luck_draw_account表数据
	 */
	public void updateLuckDrawAccountByUserId(String userId,LuckDrawAccountDO luckDrawAccountDO) {
		LuckDrawAccountDOExample exam = new LuckDrawAccountDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		luckDrawAccountDAO.updateByExample(luckDrawAccountDO, exam);
	}

    /**
	 * 根据campaignNo更新luck_draw_account表数据
	 */
	public void updateLuckDrawAccountByCampaignNo(String campaignNo,LuckDrawAccountDO luckDrawAccountDO) {
		LuckDrawAccountDOExample exam = new LuckDrawAccountDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		luckDrawAccountDAO.updateByExample(luckDrawAccountDO, exam);
	}

    /**
	 * 根据platPartnerId更新luck_draw_account表数据
	 */
	public void updateLuckDrawAccountByPlatPartnerId(String platPartnerId,LuckDrawAccountDO luckDrawAccountDO) {
		LuckDrawAccountDOExample exam = new LuckDrawAccountDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		luckDrawAccountDAO.updateByExample(luckDrawAccountDO, exam);
	}

    /**
	 * 根据partnerId更新luck_draw_account表数据
	 */
	public void updateLuckDrawAccountByPartnerId(String partnerId,LuckDrawAccountDO luckDrawAccountDO) {
		LuckDrawAccountDOExample exam = new LuckDrawAccountDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		luckDrawAccountDAO.updateByExample(luckDrawAccountDO, exam);
	}

    /**
	 * 断言luck_draw_campaign表
	 */
	public void luckDrawCampaignAssert(
	        LuckDrawCampaignDO luckDrawCampaignDO,
			Long id, 
			String name, 
			String campaignNo, 
			String platPartnerId, 
			String partnerId, 
			String title, 
			String description, 
			String status, 
			String luckDrawType, 
			String calRateWay, 
			String lifeCycle, 
			String campaignUrl, 
			Date startTime, 
			Date endTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, luckDrawCampaignDO.getId());
        assertEquals(name, luckDrawCampaignDO.getName());
        assertEquals(campaignNo, luckDrawCampaignDO.getCampaignNo());
        assertEquals(platPartnerId, luckDrawCampaignDO.getPlatPartnerId());
        assertEquals(partnerId, luckDrawCampaignDO.getPartnerId());
        assertEquals(title, luckDrawCampaignDO.getTitle());
        assertEquals(description, luckDrawCampaignDO.getDescription());
        assertEquals(status, luckDrawCampaignDO.getStatus());
        assertEquals(luckDrawType, luckDrawCampaignDO.getLuckDrawType());
        assertEquals(calRateWay, luckDrawCampaignDO.getCalRateWay());
        assertEquals(lifeCycle, luckDrawCampaignDO.getLifeCycle());
        assertEquals(campaignUrl, luckDrawCampaignDO.getCampaignUrl());
        assertEquals(startTime, luckDrawCampaignDO.getStartTime());
        assertEquals(endTime, luckDrawCampaignDO.getEndTime());
        assertEquals(rawAddTime, luckDrawCampaignDO.getRawAddTime());
        assertEquals(rawUpdateTime, luckDrawCampaignDO.getRawUpdateTime());
	}

	/**
	 * 断言luck_draw_campaign表数据
	 */
	public void assertLuckDrawCampaign(LuckDrawCampaignDO expect, LuckDrawCampaignDO luckDrawCampaignDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			luckDrawCampaignDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != luckDrawCampaignDO.getRawAddTime());
		expect.setRawAddTime(luckDrawCampaignDO.getRawAddTime());
        Assertions.assertTrue(null != luckDrawCampaignDO.getRawUpdateTime());
		expect.setRawUpdateTime(luckDrawCampaignDO.getRawUpdateTime());
		Assertions.assertEquals(expect, luckDrawCampaignDO);
	}

    /**
	 * 插入luck_draw_campaign表数据
	 */
	public void insertLuckDrawCampaign(LuckDrawCampaignDO luckDrawCampaignDO) {
		luckDrawCampaignDAO.insert(luckDrawCampaignDO);
	}

    /**
	 * 插入luck_draw_campaign表数据
	 */
	public void insertLuckDrawCampaign(
			Long id, 
			String name, 
			String campaignNo, 
			String platPartnerId, 
			String partnerId, 
			String title, 
			String description, 
			String status, 
			String luckDrawType, 
			String calRateWay, 
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
		LuckDrawCampaignDO luckDrawCampaignDO = new LuckDrawCampaignDO();
		luckDrawCampaignDO.setId(id);
		luckDrawCampaignDO.setName(name);
		luckDrawCampaignDO.setCampaignNo(campaignNo);
		luckDrawCampaignDO.setPlatPartnerId(platPartnerId);
		luckDrawCampaignDO.setPartnerId(partnerId);
		luckDrawCampaignDO.setTitle(title);
		luckDrawCampaignDO.setDescription(description);
		luckDrawCampaignDO.setStatus(status);
		luckDrawCampaignDO.setLuckDrawType(luckDrawType);
		luckDrawCampaignDO.setCalRateWay(calRateWay);
		luckDrawCampaignDO.setLifeCycle(lifeCycle);
		luckDrawCampaignDO.setCampaignUrl(campaignUrl);
		luckDrawCampaignDO.setStartTime(startTime);
		luckDrawCampaignDO.setEndTime(endTime);
		luckDrawCampaignDO.setRawAddTime(rawAddTime);
		luckDrawCampaignDO.setRawUpdateTime(rawUpdateTime);
		luckDrawCampaignDAO.insert(luckDrawCampaignDO);
	}

    /**
     * 删除luck_draw_campaign表所有数据
     */
    public void cleanLuckDrawCampaign() {
        LuckDrawCampaignDOExample exam = new LuckDrawCampaignDOExample();
        exam.createCriteria();
        luckDrawCampaignDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除luck_draw_campaign表数据
	 */
	public void cleanLuckDrawCampaignById(Long id) {
		LuckDrawCampaignDOExample exam = new LuckDrawCampaignDOExample();
		exam.createCriteria().andIdEqualTo(id);
		luckDrawCampaignDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除luck_draw_campaign表数据
	*/
	public void cleanLuckDrawCampaignByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		LuckDrawCampaignDOExample exam = new LuckDrawCampaignDOExample();
		exam.createCriteria().andNameEqualTo(name);
		luckDrawCampaignDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNo删除luck_draw_campaign表数据
	 */
	public void cleanLuckDrawCampaignByCampaignNo(String campaignNo) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
		LuckDrawCampaignDOExample exam = new LuckDrawCampaignDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		luckDrawCampaignDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除luck_draw_campaign表数据
	 */
	public void cleanLuckDrawCampaignByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		LuckDrawCampaignDOExample exam = new LuckDrawCampaignDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		luckDrawCampaignDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除luck_draw_campaign表数据
	 */
	public void cleanLuckDrawCampaignByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		LuckDrawCampaignDOExample exam = new LuckDrawCampaignDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		luckDrawCampaignDAO.deleteByExample(exam);
	}

    /**
     * 查询luck_draw_campaign表所有数据
     */
    public List<LuckDrawCampaignDO> findLuckDrawCampaignAll() {
        LuckDrawCampaignDOExample exam = new LuckDrawCampaignDOExample();
        exam.createCriteria();
		return luckDrawCampaignDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询luck_draw_campaign表数据
	 */
	public List<LuckDrawCampaignDO> findLuckDrawCampaignById(Long id) {
		LuckDrawCampaignDOExample exam = new LuckDrawCampaignDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return luckDrawCampaignDAO.selectByExample(exam);
	}

	/**
	* 根据name查询luck_draw_campaign表数据
	*/
	public List<LuckDrawCampaignDO> findLuckDrawCampaignByName(String name) {
		LuckDrawCampaignDOExample exam = new LuckDrawCampaignDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return luckDrawCampaignDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNo查询luck_draw_campaign表数据
	 */
	public List<LuckDrawCampaignDO> findLuckDrawCampaignByCampaignNo(String campaignNo) {
		LuckDrawCampaignDOExample exam = new LuckDrawCampaignDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		return luckDrawCampaignDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询luck_draw_campaign表数据
	 */
	public List<LuckDrawCampaignDO> findLuckDrawCampaignByPlatPartnerId(String platPartnerId) {
		LuckDrawCampaignDOExample exam = new LuckDrawCampaignDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return luckDrawCampaignDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询luck_draw_campaign表数据
	 */
	public List<LuckDrawCampaignDO> findLuckDrawCampaignByPartnerId(String partnerId) {
		LuckDrawCampaignDOExample exam = new LuckDrawCampaignDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return luckDrawCampaignDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新luck_draw_campaign表数据
	 */
	public void updateLuckDrawCampaignById(Long id,LuckDrawCampaignDO luckDrawCampaignDO) {
		LuckDrawCampaignDOExample exam = new LuckDrawCampaignDOExample();
		exam.createCriteria().andIdEqualTo(id);
		luckDrawCampaignDAO.updateByExample(luckDrawCampaignDO, exam);
	}

	/**
	* 根据name更新luck_draw_campaign表数据
	*/
	public void updateLuckDrawCampaignByName(String name,LuckDrawCampaignDO luckDrawCampaignDO) {
		LuckDrawCampaignDOExample exam = new LuckDrawCampaignDOExample();
		exam.createCriteria().andNameEqualTo(name);
		luckDrawCampaignDAO.updateByExample(luckDrawCampaignDO, exam);
	}

    /**
	 * 根据campaignNo更新luck_draw_campaign表数据
	 */
	public void updateLuckDrawCampaignByCampaignNo(String campaignNo,LuckDrawCampaignDO luckDrawCampaignDO) {
		LuckDrawCampaignDOExample exam = new LuckDrawCampaignDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		luckDrawCampaignDAO.updateByExample(luckDrawCampaignDO, exam);
	}

    /**
	 * 根据platPartnerId更新luck_draw_campaign表数据
	 */
	public void updateLuckDrawCampaignByPlatPartnerId(String platPartnerId,LuckDrawCampaignDO luckDrawCampaignDO) {
		LuckDrawCampaignDOExample exam = new LuckDrawCampaignDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		luckDrawCampaignDAO.updateByExample(luckDrawCampaignDO, exam);
	}

    /**
	 * 根据partnerId更新luck_draw_campaign表数据
	 */
	public void updateLuckDrawCampaignByPartnerId(String partnerId,LuckDrawCampaignDO luckDrawCampaignDO) {
		LuckDrawCampaignDOExample exam = new LuckDrawCampaignDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		luckDrawCampaignDAO.updateByExample(luckDrawCampaignDO, exam);
	}

    /**
	 * 断言luck_draw_prize表
	 */
	public void luckDrawPrizeAssert(
	        LuckDrawPrizeDO luckDrawPrizeDO,
			Long id, 
			String prizeName, 
			String campaignNo, 
			String platPartnerId, 
			String partnerId, 
			String prizeType, 
			Integer stockNum, 
			Integer useNum, 
			String rate, 
			String prizeDetail, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, luckDrawPrizeDO.getId());
        assertEquals(prizeName, luckDrawPrizeDO.getPrizeName());
        assertEquals(campaignNo, luckDrawPrizeDO.getCampaignNo());
        assertEquals(platPartnerId, luckDrawPrizeDO.getPlatPartnerId());
        assertEquals(partnerId, luckDrawPrizeDO.getPartnerId());
        assertEquals(prizeType, luckDrawPrizeDO.getPrizeType());
        assertEquals(stockNum, luckDrawPrizeDO.getStockNum());
        assertEquals(useNum, luckDrawPrizeDO.getUseNum());
        assertEquals(rate, luckDrawPrizeDO.getRate());
        assertEquals(prizeDetail, luckDrawPrizeDO.getPrizeDetail());
        assertEquals(rawAddTime, luckDrawPrizeDO.getRawAddTime());
        assertEquals(rawUpdateTime, luckDrawPrizeDO.getRawUpdateTime());
	}

	/**
	 * 断言luck_draw_prize表数据
	 */
	public void assertLuckDrawPrize(LuckDrawPrizeDO expect, LuckDrawPrizeDO luckDrawPrizeDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			luckDrawPrizeDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != luckDrawPrizeDO.getRawAddTime());
		expect.setRawAddTime(luckDrawPrizeDO.getRawAddTime());
        Assertions.assertTrue(null != luckDrawPrizeDO.getRawUpdateTime());
		expect.setRawUpdateTime(luckDrawPrizeDO.getRawUpdateTime());
		Assertions.assertEquals(expect, luckDrawPrizeDO);
	}

    /**
	 * 插入luck_draw_prize表数据
	 */
	public void insertLuckDrawPrize(LuckDrawPrizeDO luckDrawPrizeDO) {
		luckDrawPrizeDAO.insert(luckDrawPrizeDO);
	}

    /**
	 * 插入luck_draw_prize表数据
	 */
	public void insertLuckDrawPrize(
			Long id, 
			String prizeName, 
			String campaignNo, 
			String platPartnerId, 
			String partnerId, 
			String prizeType, 
			Integer stockNum, 
			Integer useNum, 
			String rate, 
			String prizeDetail, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		LuckDrawPrizeDO luckDrawPrizeDO = new LuckDrawPrizeDO();
		luckDrawPrizeDO.setId(id);
		luckDrawPrizeDO.setPrizeName(prizeName);
		luckDrawPrizeDO.setCampaignNo(campaignNo);
		luckDrawPrizeDO.setPlatPartnerId(platPartnerId);
		luckDrawPrizeDO.setPartnerId(partnerId);
		luckDrawPrizeDO.setPrizeType(prizeType);
		luckDrawPrizeDO.setStockNum(stockNum);
		luckDrawPrizeDO.setUseNum(useNum);
		luckDrawPrizeDO.setRate(rate);
		luckDrawPrizeDO.setPrizeDetail(prizeDetail);
		luckDrawPrizeDO.setRawAddTime(rawAddTime);
		luckDrawPrizeDO.setRawUpdateTime(rawUpdateTime);
		luckDrawPrizeDAO.insert(luckDrawPrizeDO);
	}

    /**
     * 删除luck_draw_prize表所有数据
     */
    public void cleanLuckDrawPrize() {
        LuckDrawPrizeDOExample exam = new LuckDrawPrizeDOExample();
        exam.createCriteria();
        luckDrawPrizeDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除luck_draw_prize表数据
	 */
	public void cleanLuckDrawPrizeById(Long id) {
		LuckDrawPrizeDOExample exam = new LuckDrawPrizeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		luckDrawPrizeDAO.deleteByExample(exam);
	}

	/**
	* 根据prizeName删除luck_draw_prize表数据
	*/
	public void cleanLuckDrawPrizeByPrizeName(String prizeName) {
        if (StringUtils.isBlank(prizeName)){
            prizeName = "test_prizeName";
        }
		LuckDrawPrizeDOExample exam = new LuckDrawPrizeDOExample();
		exam.createCriteria().andPrizeNameEqualTo(prizeName);
		luckDrawPrizeDAO.deleteByExample(exam);
	}
	/**
	 * 根据campaignNo,prizeType删除luck_draw_prize表数据
	 */
	public void cleanLuckDrawPrizeByCampaignNoAndPrizeType(String campaignNo,String prizeType) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
        if (StringUtils.isBlank(prizeType)){
            prizeType = "test_prizeType";
        }
		LuckDrawPrizeDOExample exam = new LuckDrawPrizeDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo).andPrizeTypeEqualTo(prizeType);
		luckDrawPrizeDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNo删除luck_draw_prize表数据
	 */
	public void cleanLuckDrawPrizeByCampaignNo(String campaignNo) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
		LuckDrawPrizeDOExample exam = new LuckDrawPrizeDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		luckDrawPrizeDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除luck_draw_prize表数据
	 */
	public void cleanLuckDrawPrizeByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		LuckDrawPrizeDOExample exam = new LuckDrawPrizeDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		luckDrawPrizeDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除luck_draw_prize表数据
	 */
	public void cleanLuckDrawPrizeByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		LuckDrawPrizeDOExample exam = new LuckDrawPrizeDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		luckDrawPrizeDAO.deleteByExample(exam);
	}

    /**
     * 查询luck_draw_prize表所有数据
     */
    public List<LuckDrawPrizeDO> findLuckDrawPrizeAll() {
        LuckDrawPrizeDOExample exam = new LuckDrawPrizeDOExample();
        exam.createCriteria();
		return luckDrawPrizeDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询luck_draw_prize表数据
	 */
	public List<LuckDrawPrizeDO> findLuckDrawPrizeById(Long id) {
		LuckDrawPrizeDOExample exam = new LuckDrawPrizeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return luckDrawPrizeDAO.selectByExample(exam);
	}

	/**
	* 根据prizeName查询luck_draw_prize表数据
	*/
	public List<LuckDrawPrizeDO> findLuckDrawPrizeByPrizeName(String prizeName) {
		LuckDrawPrizeDOExample exam = new LuckDrawPrizeDOExample();
		exam.createCriteria().andPrizeNameEqualTo(prizeName);
		return luckDrawPrizeDAO.selectByExample(exam);
	}

	/**
	 * 根据campaignNo,prizeType查询luck_draw_prize表数据
	 */
	public List<LuckDrawPrizeDO> findLuckDrawPrizeByCampaignNoAndPrizeType(String campaignNo,String prizeType) {
		LuckDrawPrizeDOExample exam = new LuckDrawPrizeDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo).andPrizeTypeEqualTo(prizeType);
		return luckDrawPrizeDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNo查询luck_draw_prize表数据
	 */
	public List<LuckDrawPrizeDO> findLuckDrawPrizeByCampaignNo(String campaignNo) {
		LuckDrawPrizeDOExample exam = new LuckDrawPrizeDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		return luckDrawPrizeDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询luck_draw_prize表数据
	 */
	public List<LuckDrawPrizeDO> findLuckDrawPrizeByPlatPartnerId(String platPartnerId) {
		LuckDrawPrizeDOExample exam = new LuckDrawPrizeDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return luckDrawPrizeDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询luck_draw_prize表数据
	 */
	public List<LuckDrawPrizeDO> findLuckDrawPrizeByPartnerId(String partnerId) {
		LuckDrawPrizeDOExample exam = new LuckDrawPrizeDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return luckDrawPrizeDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新luck_draw_prize表数据
	 */
	public void updateLuckDrawPrizeById(Long id,LuckDrawPrizeDO luckDrawPrizeDO) {
		LuckDrawPrizeDOExample exam = new LuckDrawPrizeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		luckDrawPrizeDAO.updateByExample(luckDrawPrizeDO, exam);
	}

	/**
	* 根据prizeName更新luck_draw_prize表数据
	*/
	public void updateLuckDrawPrizeByPrizeName(String prizeName,LuckDrawPrizeDO luckDrawPrizeDO) {
		LuckDrawPrizeDOExample exam = new LuckDrawPrizeDOExample();
		exam.createCriteria().andPrizeNameEqualTo(prizeName);
		luckDrawPrizeDAO.updateByExample(luckDrawPrizeDO, exam);
	}

	/**
	 * 根据campaignNo,prizeType更新luck_draw_prize表数据
	 */
	public void updateLuckDrawPrizeByCampaignNoAndPrizeType(String campaignNo,String prizeType,LuckDrawPrizeDO luckDrawPrizeDO) {
		LuckDrawPrizeDOExample exam = new LuckDrawPrizeDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo).andPrizeTypeEqualTo(prizeType);
		luckDrawPrizeDAO.updateByExample(luckDrawPrizeDO, exam);
	}

    /**
	 * 根据campaignNo更新luck_draw_prize表数据
	 */
	public void updateLuckDrawPrizeByCampaignNo(String campaignNo,LuckDrawPrizeDO luckDrawPrizeDO) {
		LuckDrawPrizeDOExample exam = new LuckDrawPrizeDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		luckDrawPrizeDAO.updateByExample(luckDrawPrizeDO, exam);
	}

    /**
	 * 根据platPartnerId更新luck_draw_prize表数据
	 */
	public void updateLuckDrawPrizeByPlatPartnerId(String platPartnerId,LuckDrawPrizeDO luckDrawPrizeDO) {
		LuckDrawPrizeDOExample exam = new LuckDrawPrizeDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		luckDrawPrizeDAO.updateByExample(luckDrawPrizeDO, exam);
	}

    /**
	 * 根据partnerId更新luck_draw_prize表数据
	 */
	public void updateLuckDrawPrizeByPartnerId(String partnerId,LuckDrawPrizeDO luckDrawPrizeDO) {
		LuckDrawPrizeDOExample exam = new LuckDrawPrizeDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		luckDrawPrizeDAO.updateByExample(luckDrawPrizeDO, exam);
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
	 * 断言point_scheme表
	 */
	public void pointSchemeAssert(
	        PointSchemeDO pointSchemeDO,
			Long id, 
			String pointSchemeNo, 
			String partnerId, 
			String platPartnerId, 
			String pointSchemeType, 
			String pointRules, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, pointSchemeDO.getId());
        assertEquals(pointSchemeNo, pointSchemeDO.getPointSchemeNo());
        assertEquals(partnerId, pointSchemeDO.getPartnerId());
        assertEquals(platPartnerId, pointSchemeDO.getPlatPartnerId());
        assertEquals(pointSchemeType, pointSchemeDO.getPointSchemeType());
        assertEquals(pointRules, pointSchemeDO.getPointRules());
        assertEquals(rawAddTime, pointSchemeDO.getRawAddTime());
        assertEquals(rawUpdateTime, pointSchemeDO.getRawUpdateTime());
	}

	/**
	 * 断言point_scheme表数据
	 */
	public void assertPointScheme(PointSchemeDO expect, PointSchemeDO pointSchemeDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			pointSchemeDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != pointSchemeDO.getRawAddTime());
		expect.setRawAddTime(pointSchemeDO.getRawAddTime());
        Assertions.assertTrue(null != pointSchemeDO.getRawUpdateTime());
		expect.setRawUpdateTime(pointSchemeDO.getRawUpdateTime());
		Assertions.assertEquals(expect, pointSchemeDO);
	}

    /**
	 * 插入point_scheme表数据
	 */
	public void insertPointScheme(PointSchemeDO pointSchemeDO) {
		pointSchemeDAO.insert(pointSchemeDO);
	}

    /**
	 * 插入point_scheme表数据
	 */
	public void insertPointScheme(
			Long id, 
			String pointSchemeNo, 
			String partnerId, 
			String platPartnerId, 
			String pointSchemeType, 
			String pointRules, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		PointSchemeDO pointSchemeDO = new PointSchemeDO();
		pointSchemeDO.setId(id);
		pointSchemeDO.setPointSchemeNo(pointSchemeNo);
		pointSchemeDO.setPartnerId(partnerId);
		pointSchemeDO.setPlatPartnerId(platPartnerId);
		pointSchemeDO.setPointSchemeType(pointSchemeType);
		pointSchemeDO.setPointRules(pointRules);
		pointSchemeDO.setRawAddTime(rawAddTime);
		pointSchemeDO.setRawUpdateTime(rawUpdateTime);
		pointSchemeDAO.insert(pointSchemeDO);
	}

    /**
     * 删除point_scheme表所有数据
     */
    public void cleanPointScheme() {
        PointSchemeDOExample exam = new PointSchemeDOExample();
        exam.createCriteria();
        pointSchemeDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除point_scheme表数据
	 */
	public void cleanPointSchemeById(Long id) {
		PointSchemeDOExample exam = new PointSchemeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		pointSchemeDAO.deleteByExample(exam);
	}

	/**
	 * 根据pointSchemeNo删除point_scheme表数据
	 */
	public void cleanPointSchemeByPointSchemeNo(String pointSchemeNo) {
        if (StringUtils.isBlank(pointSchemeNo)){
            pointSchemeNo = "test_pointSchemeNo";
        }
		PointSchemeDOExample exam = new PointSchemeDOExample();
		exam.createCriteria().andPointSchemeNoEqualTo(pointSchemeNo);
		pointSchemeDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除point_scheme表数据
	 */
	public void cleanPointSchemeByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		PointSchemeDOExample exam = new PointSchemeDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		pointSchemeDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除point_scheme表数据
	 */
	public void cleanPointSchemeByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		PointSchemeDOExample exam = new PointSchemeDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		pointSchemeDAO.deleteByExample(exam);
	}

    /**
     * 查询point_scheme表所有数据
     */
    public List<PointSchemeDO> findPointSchemeAll() {
        PointSchemeDOExample exam = new PointSchemeDOExample();
        exam.createCriteria();
		return pointSchemeDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询point_scheme表数据
	 */
	public List<PointSchemeDO> findPointSchemeById(Long id) {
		PointSchemeDOExample exam = new PointSchemeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return pointSchemeDAO.selectByExample(exam);
	}

    /**
	 * 根据pointSchemeNo查询point_scheme表数据
	 */
	public List<PointSchemeDO> findPointSchemeByPointSchemeNo(String pointSchemeNo) {
		PointSchemeDOExample exam = new PointSchemeDOExample();
		exam.createCriteria().andPointSchemeNoEqualTo(pointSchemeNo);
		return pointSchemeDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询point_scheme表数据
	 */
	public List<PointSchemeDO> findPointSchemeByPartnerId(String partnerId) {
		PointSchemeDOExample exam = new PointSchemeDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return pointSchemeDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询point_scheme表数据
	 */
	public List<PointSchemeDO> findPointSchemeByPlatPartnerId(String platPartnerId) {
		PointSchemeDOExample exam = new PointSchemeDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return pointSchemeDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新point_scheme表数据
	 */
	public void updatePointSchemeById(Long id,PointSchemeDO pointSchemeDO) {
		PointSchemeDOExample exam = new PointSchemeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		pointSchemeDAO.updateByExample(pointSchemeDO, exam);
	}

    /**
	 * 根据pointSchemeNo更新point_scheme表数据
	 */
	public void updatePointSchemeByPointSchemeNo(String pointSchemeNo,PointSchemeDO pointSchemeDO) {
		PointSchemeDOExample exam = new PointSchemeDOExample();
		exam.createCriteria().andPointSchemeNoEqualTo(pointSchemeNo);
		pointSchemeDAO.updateByExample(pointSchemeDO, exam);
	}

    /**
	 * 根据partnerId更新point_scheme表数据
	 */
	public void updatePointSchemeByPartnerId(String partnerId,PointSchemeDO pointSchemeDO) {
		PointSchemeDOExample exam = new PointSchemeDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		pointSchemeDAO.updateByExample(pointSchemeDO, exam);
	}

    /**
	 * 根据platPartnerId更新point_scheme表数据
	 */
	public void updatePointSchemeByPlatPartnerId(String platPartnerId,PointSchemeDO pointSchemeDO) {
		PointSchemeDOExample exam = new PointSchemeDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		pointSchemeDAO.updateByExample(pointSchemeDO, exam);
	}

    /**
	 * 断言precise_give表
	 */
	public void preciseGiveAssert(
	        PreciseGiveDO preciseGiveDO,
			Long id, 
			String campaignNo, 
			String partnerId, 
			String platPartnerId, 
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
        assertEquals(id, preciseGiveDO.getId());
        assertEquals(campaignNo, preciseGiveDO.getCampaignNo());
        assertEquals(partnerId, preciseGiveDO.getPartnerId());
        assertEquals(platPartnerId, preciseGiveDO.getPlatPartnerId());
        assertEquals(name, preciseGiveDO.getName());
        assertEquals(filterType, preciseGiveDO.getFilterType());
        assertEquals(filterRule, preciseGiveDO.getFilterRule());
        assertEquals(userGroupNo, preciseGiveDO.getUserGroupNo());
        assertEquals(handleRules, preciseGiveDO.getHandleRules());
        assertEquals(giveTime, preciseGiveDO.getGiveTime());
        assertEquals(status, preciseGiveDO.getStatus());
        assertEquals(memo, preciseGiveDO.getMemo());
        assertEquals(operator, preciseGiveDO.getOperator());
        assertEquals(ruleSetCode, preciseGiveDO.getRuleSetCode());
        assertEquals(rawAddTime, preciseGiveDO.getRawAddTime());
        assertEquals(rawUpdateTime, preciseGiveDO.getRawUpdateTime());
        assertEquals(personaId, preciseGiveDO.getPersonaId());
	}

	/**
	 * 断言precise_give表数据
	 */
	public void assertPreciseGive(PreciseGiveDO expect, PreciseGiveDO preciseGiveDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			preciseGiveDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != preciseGiveDO.getRawAddTime());
		expect.setRawAddTime(preciseGiveDO.getRawAddTime());
        Assertions.assertTrue(null != preciseGiveDO.getRawUpdateTime());
		expect.setRawUpdateTime(preciseGiveDO.getRawUpdateTime());
		Assertions.assertEquals(expect, preciseGiveDO);
	}

    /**
	 * 插入precise_give表数据
	 */
	public void insertPreciseGive(PreciseGiveDO preciseGiveDO) {
		preciseGiveDAO.insert(preciseGiveDO);
	}

    /**
	 * 插入precise_give表数据
	 */
	public void insertPreciseGive(
			Long id, 
			String campaignNo, 
			String partnerId, 
			String platPartnerId, 
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
		PreciseGiveDO preciseGiveDO = new PreciseGiveDO();
		preciseGiveDO.setId(id);
		preciseGiveDO.setCampaignNo(campaignNo);
		preciseGiveDO.setPartnerId(partnerId);
		preciseGiveDO.setPlatPartnerId(platPartnerId);
		preciseGiveDO.setName(name);
		preciseGiveDO.setFilterType(filterType);
		preciseGiveDO.setFilterRule(filterRule);
		preciseGiveDO.setUserGroupNo(userGroupNo);
		preciseGiveDO.setHandleRules(handleRules);
		preciseGiveDO.setGiveTime(giveTime);
		preciseGiveDO.setStatus(status);
		preciseGiveDO.setMemo(memo);
		preciseGiveDO.setOperator(operator);
		preciseGiveDO.setRuleSetCode(ruleSetCode);
		preciseGiveDO.setRawAddTime(rawAddTime);
		preciseGiveDO.setRawUpdateTime(rawUpdateTime);
		preciseGiveDO.setPersonaId(personaId);
		preciseGiveDAO.insert(preciseGiveDO);
	}

    /**
     * 删除precise_give表所有数据
     */
    public void cleanPreciseGive() {
        PreciseGiveDOExample exam = new PreciseGiveDOExample();
        exam.createCriteria();
        preciseGiveDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除precise_give表数据
	 */
	public void cleanPreciseGiveById(Long id) {
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andIdEqualTo(id);
		preciseGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNo删除precise_give表数据
	 */
	public void cleanPreciseGiveByCampaignNo(String campaignNo) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		preciseGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除precise_give表数据
	 */
	public void cleanPreciseGiveByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		preciseGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除precise_give表数据
	 */
	public void cleanPreciseGiveByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		preciseGiveDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除precise_give表数据
	*/
	public void cleanPreciseGiveByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andNameEqualTo(name);
		preciseGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据userGroupNo删除precise_give表数据
	 */
	public void cleanPreciseGiveByUserGroupNo(String userGroupNo) {
        if (StringUtils.isBlank(userGroupNo)){
            userGroupNo = "test_userGroupNo";
        }
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andUserGroupNoEqualTo(userGroupNo);
		preciseGiveDAO.deleteByExample(exam);
	}

	/**
	* 根据ruleSetCode删除precise_give表数据
	*/
	public void cleanPreciseGiveByRuleSetCode(String ruleSetCode) {
        if (StringUtils.isBlank(ruleSetCode)){
            ruleSetCode = "test_ruleSetCode";
        }
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andRuleSetCodeEqualTo(ruleSetCode);
		preciseGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据personaId删除precise_give表数据
	 */
	public void cleanPreciseGiveByPersonaId(Long personaId) {
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andPersonaIdEqualTo(personaId);
		preciseGiveDAO.deleteByExample(exam);
	}

    /**
     * 查询precise_give表所有数据
     */
    public List<PreciseGiveDO> findPreciseGiveAll() {
        PreciseGiveDOExample exam = new PreciseGiveDOExample();
        exam.createCriteria();
		return preciseGiveDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询precise_give表数据
	 */
	public List<PreciseGiveDO> findPreciseGiveById(Long id) {
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return preciseGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNo查询precise_give表数据
	 */
	public List<PreciseGiveDO> findPreciseGiveByCampaignNo(String campaignNo) {
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		return preciseGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询precise_give表数据
	 */
	public List<PreciseGiveDO> findPreciseGiveByPartnerId(String partnerId) {
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return preciseGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询precise_give表数据
	 */
	public List<PreciseGiveDO> findPreciseGiveByPlatPartnerId(String platPartnerId) {
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return preciseGiveDAO.selectByExample(exam);
	}

	/**
	* 根据name查询precise_give表数据
	*/
	public List<PreciseGiveDO> findPreciseGiveByName(String name) {
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return preciseGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据userGroupNo查询precise_give表数据
	 */
	public List<PreciseGiveDO> findPreciseGiveByUserGroupNo(String userGroupNo) {
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andUserGroupNoEqualTo(userGroupNo);
		return preciseGiveDAO.selectByExample(exam);
	}

	/**
	* 根据ruleSetCode查询precise_give表数据
	*/
	public List<PreciseGiveDO> findPreciseGiveByRuleSetCode(String ruleSetCode) {
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andRuleSetCodeEqualTo(ruleSetCode);
		return preciseGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据personaId查询precise_give表数据
	 */
	public List<PreciseGiveDO> findPreciseGiveByPersonaId(Long personaId) {
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andPersonaIdEqualTo(personaId);
		return preciseGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新precise_give表数据
	 */
	public void updatePreciseGiveById(Long id,PreciseGiveDO preciseGiveDO) {
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andIdEqualTo(id);
		preciseGiveDAO.updateByExample(preciseGiveDO, exam);
	}

    /**
	 * 根据campaignNo更新precise_give表数据
	 */
	public void updatePreciseGiveByCampaignNo(String campaignNo,PreciseGiveDO preciseGiveDO) {
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		preciseGiveDAO.updateByExample(preciseGiveDO, exam);
	}

    /**
	 * 根据partnerId更新precise_give表数据
	 */
	public void updatePreciseGiveByPartnerId(String partnerId,PreciseGiveDO preciseGiveDO) {
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		preciseGiveDAO.updateByExample(preciseGiveDO, exam);
	}

    /**
	 * 根据platPartnerId更新precise_give表数据
	 */
	public void updatePreciseGiveByPlatPartnerId(String platPartnerId,PreciseGiveDO preciseGiveDO) {
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		preciseGiveDAO.updateByExample(preciseGiveDO, exam);
	}

	/**
	* 根据name更新precise_give表数据
	*/
	public void updatePreciseGiveByName(String name,PreciseGiveDO preciseGiveDO) {
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andNameEqualTo(name);
		preciseGiveDAO.updateByExample(preciseGiveDO, exam);
	}

    /**
	 * 根据userGroupNo更新precise_give表数据
	 */
	public void updatePreciseGiveByUserGroupNo(String userGroupNo,PreciseGiveDO preciseGiveDO) {
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andUserGroupNoEqualTo(userGroupNo);
		preciseGiveDAO.updateByExample(preciseGiveDO, exam);
	}

	/**
	* 根据ruleSetCode更新precise_give表数据
	*/
	public void updatePreciseGiveByRuleSetCode(String ruleSetCode,PreciseGiveDO preciseGiveDO) {
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andRuleSetCodeEqualTo(ruleSetCode);
		preciseGiveDAO.updateByExample(preciseGiveDO, exam);
	}

    /**
	 * 根据personaId更新precise_give表数据
	 */
	public void updatePreciseGiveByPersonaId(Long personaId,PreciseGiveDO preciseGiveDO) {
		PreciseGiveDOExample exam = new PreciseGiveDOExample();
		exam.createCriteria().andPersonaIdEqualTo(personaId);
		preciseGiveDAO.updateByExample(preciseGiveDO, exam);
	}

    /**
	 * 断言promotion表
	 */
	public void promotionAssert(
	        PromotionDO promotionDO,
			Long id, 
			String campaignNo, 
			String actionEvent, 
			String promotionWay, 
			String discountType, 
			String description, 
			String ruleSetCode, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, promotionDO.getId());
        assertEquals(campaignNo, promotionDO.getCampaignNo());
        assertEquals(actionEvent, promotionDO.getActionEvent());
        assertEquals(promotionWay, promotionDO.getPromotionWay());
        assertEquals(discountType, promotionDO.getDiscountType());
        assertEquals(description, promotionDO.getDescription());
        assertEquals(ruleSetCode, promotionDO.getRuleSetCode());
        assertEquals(rawAddTime, promotionDO.getRawAddTime());
        assertEquals(rawUpdateTime, promotionDO.getRawUpdateTime());
	}

	/**
	 * 断言promotion表数据
	 */
	public void assertPromotion(PromotionDO expect, PromotionDO promotionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			promotionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != promotionDO.getRawAddTime());
		expect.setRawAddTime(promotionDO.getRawAddTime());
        Assertions.assertTrue(null != promotionDO.getRawUpdateTime());
		expect.setRawUpdateTime(promotionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, promotionDO);
	}

    /**
	 * 插入promotion表数据
	 */
	public void insertPromotion(PromotionDO promotionDO) {
		promotionDAO.insert(promotionDO);
	}

    /**
	 * 插入promotion表数据
	 */
	public void insertPromotion(
			Long id, 
			String campaignNo, 
			String actionEvent, 
			String promotionWay, 
			String discountType, 
			String description, 
			String ruleSetCode, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		PromotionDO promotionDO = new PromotionDO();
		promotionDO.setId(id);
		promotionDO.setCampaignNo(campaignNo);
		promotionDO.setActionEvent(actionEvent);
		promotionDO.setPromotionWay(promotionWay);
		promotionDO.setDiscountType(discountType);
		promotionDO.setDescription(description);
		promotionDO.setRuleSetCode(ruleSetCode);
		promotionDO.setRawAddTime(rawAddTime);
		promotionDO.setRawUpdateTime(rawUpdateTime);
		promotionDAO.insert(promotionDO);
	}

    /**
     * 删除promotion表所有数据
     */
    public void cleanPromotion() {
        PromotionDOExample exam = new PromotionDOExample();
        exam.createCriteria();
        promotionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除promotion表数据
	 */
	public void cleanPromotionById(Long id) {
		PromotionDOExample exam = new PromotionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		promotionDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNo删除promotion表数据
	 */
	public void cleanPromotionByCampaignNo(String campaignNo) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
		PromotionDOExample exam = new PromotionDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		promotionDAO.deleteByExample(exam);
	}

	/**
	* 根据ruleSetCode删除promotion表数据
	*/
	public void cleanPromotionByRuleSetCode(String ruleSetCode) {
        if (StringUtils.isBlank(ruleSetCode)){
            ruleSetCode = "test_ruleSetCode";
        }
		PromotionDOExample exam = new PromotionDOExample();
		exam.createCriteria().andRuleSetCodeEqualTo(ruleSetCode);
		promotionDAO.deleteByExample(exam);
	}

    /**
     * 查询promotion表所有数据
     */
    public List<PromotionDO> findPromotionAll() {
        PromotionDOExample exam = new PromotionDOExample();
        exam.createCriteria();
		return promotionDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询promotion表数据
	 */
	public List<PromotionDO> findPromotionById(Long id) {
		PromotionDOExample exam = new PromotionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return promotionDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNo查询promotion表数据
	 */
	public List<PromotionDO> findPromotionByCampaignNo(String campaignNo) {
		PromotionDOExample exam = new PromotionDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		return promotionDAO.selectByExample(exam);
	}

	/**
	* 根据ruleSetCode查询promotion表数据
	*/
	public List<PromotionDO> findPromotionByRuleSetCode(String ruleSetCode) {
		PromotionDOExample exam = new PromotionDOExample();
		exam.createCriteria().andRuleSetCodeEqualTo(ruleSetCode);
		return promotionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新promotion表数据
	 */
	public void updatePromotionById(Long id,PromotionDO promotionDO) {
		PromotionDOExample exam = new PromotionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		promotionDAO.updateByExample(promotionDO, exam);
	}

    /**
	 * 根据campaignNo更新promotion表数据
	 */
	public void updatePromotionByCampaignNo(String campaignNo,PromotionDO promotionDO) {
		PromotionDOExample exam = new PromotionDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		promotionDAO.updateByExample(promotionDO, exam);
	}

	/**
	* 根据ruleSetCode更新promotion表数据
	*/
	public void updatePromotionByRuleSetCode(String ruleSetCode,PromotionDO promotionDO) {
		PromotionDOExample exam = new PromotionDOExample();
		exam.createCriteria().andRuleSetCodeEqualTo(ruleSetCode);
		promotionDAO.updateByExample(promotionDO, exam);
	}

    /**
	 * 断言reissue_give表
	 */
	public void reissueGiveAssert(
	        ReissueGiveDO reissueGiveDO,
			Long id, 
			String gid, 
			String userId, 
			String partnerId, 
			String platPartnerId, 
			String reissueNo, 
			String promotionWay, 
			String giveDetail, 
			String accountTag, 
			String status, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, reissueGiveDO.getId());
        assertEquals(gid, reissueGiveDO.getGid());
        assertEquals(userId, reissueGiveDO.getUserId());
        assertEquals(partnerId, reissueGiveDO.getPartnerId());
        assertEquals(platPartnerId, reissueGiveDO.getPlatPartnerId());
        assertEquals(reissueNo, reissueGiveDO.getReissueNo());
        assertEquals(promotionWay, reissueGiveDO.getPromotionWay());
        assertEquals(giveDetail, reissueGiveDO.getGiveDetail());
        assertEquals(accountTag, reissueGiveDO.getAccountTag());
        assertEquals(status, reissueGiveDO.getStatus());
        assertEquals(memo, reissueGiveDO.getMemo());
        assertEquals(rawAddTime, reissueGiveDO.getRawAddTime());
        assertEquals(rawUpdateTime, reissueGiveDO.getRawUpdateTime());
	}

	/**
	 * 断言reissue_give表数据
	 */
	public void assertReissueGive(ReissueGiveDO expect, ReissueGiveDO reissueGiveDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			reissueGiveDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != reissueGiveDO.getRawAddTime());
		expect.setRawAddTime(reissueGiveDO.getRawAddTime());
        Assertions.assertTrue(null != reissueGiveDO.getRawUpdateTime());
		expect.setRawUpdateTime(reissueGiveDO.getRawUpdateTime());
		Assertions.assertEquals(expect, reissueGiveDO);
	}

    /**
	 * 插入reissue_give表数据
	 */
	public void insertReissueGive(ReissueGiveDO reissueGiveDO) {
		reissueGiveDAO.insert(reissueGiveDO);
	}

    /**
	 * 插入reissue_give表数据
	 */
	public void insertReissueGive(
			Long id, 
			String gid, 
			String userId, 
			String partnerId, 
			String platPartnerId, 
			String reissueNo, 
			String promotionWay, 
			String giveDetail, 
			String accountTag, 
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
		ReissueGiveDO reissueGiveDO = new ReissueGiveDO();
		reissueGiveDO.setId(id);
		reissueGiveDO.setGid(gid);
		reissueGiveDO.setUserId(userId);
		reissueGiveDO.setPartnerId(partnerId);
		reissueGiveDO.setPlatPartnerId(platPartnerId);
		reissueGiveDO.setReissueNo(reissueNo);
		reissueGiveDO.setPromotionWay(promotionWay);
		reissueGiveDO.setGiveDetail(giveDetail);
		reissueGiveDO.setAccountTag(accountTag);
		reissueGiveDO.setStatus(status);
		reissueGiveDO.setMemo(memo);
		reissueGiveDO.setRawAddTime(rawAddTime);
		reissueGiveDO.setRawUpdateTime(rawUpdateTime);
		reissueGiveDAO.insert(reissueGiveDO);
	}

    /**
     * 删除reissue_give表所有数据
     */
    public void cleanReissueGive() {
        ReissueGiveDOExample exam = new ReissueGiveDOExample();
        exam.createCriteria();
        reissueGiveDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除reissue_give表数据
	 */
	public void cleanReissueGiveById(Long id) {
		ReissueGiveDOExample exam = new ReissueGiveDOExample();
		exam.createCriteria().andIdEqualTo(id);
		reissueGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除reissue_give表数据
	 */
	public void cleanReissueGiveByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		ReissueGiveDOExample exam = new ReissueGiveDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		reissueGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除reissue_give表数据
	 */
	public void cleanReissueGiveByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		ReissueGiveDOExample exam = new ReissueGiveDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		reissueGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除reissue_give表数据
	 */
	public void cleanReissueGiveByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		ReissueGiveDOExample exam = new ReissueGiveDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		reissueGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除reissue_give表数据
	 */
	public void cleanReissueGiveByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		ReissueGiveDOExample exam = new ReissueGiveDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		reissueGiveDAO.deleteByExample(exam);
	}

	/**
	 * 根据reissueNo删除reissue_give表数据
	 */
	public void cleanReissueGiveByReissueNo(String reissueNo) {
        if (StringUtils.isBlank(reissueNo)){
            reissueNo = "test_reissueNo";
        }
		ReissueGiveDOExample exam = new ReissueGiveDOExample();
		exam.createCriteria().andReissueNoEqualTo(reissueNo);
		reissueGiveDAO.deleteByExample(exam);
	}

    /**
     * 查询reissue_give表所有数据
     */
    public List<ReissueGiveDO> findReissueGiveAll() {
        ReissueGiveDOExample exam = new ReissueGiveDOExample();
        exam.createCriteria();
		return reissueGiveDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询reissue_give表数据
	 */
	public List<ReissueGiveDO> findReissueGiveById(Long id) {
		ReissueGiveDOExample exam = new ReissueGiveDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return reissueGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询reissue_give表数据
	 */
	public List<ReissueGiveDO> findReissueGiveByGid(String gid) {
		ReissueGiveDOExample exam = new ReissueGiveDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return reissueGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询reissue_give表数据
	 */
	public List<ReissueGiveDO> findReissueGiveByUserId(String userId) {
		ReissueGiveDOExample exam = new ReissueGiveDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return reissueGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询reissue_give表数据
	 */
	public List<ReissueGiveDO> findReissueGiveByPartnerId(String partnerId) {
		ReissueGiveDOExample exam = new ReissueGiveDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return reissueGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询reissue_give表数据
	 */
	public List<ReissueGiveDO> findReissueGiveByPlatPartnerId(String platPartnerId) {
		ReissueGiveDOExample exam = new ReissueGiveDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return reissueGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据reissueNo查询reissue_give表数据
	 */
	public List<ReissueGiveDO> findReissueGiveByReissueNo(String reissueNo) {
		ReissueGiveDOExample exam = new ReissueGiveDOExample();
		exam.createCriteria().andReissueNoEqualTo(reissueNo);
		return reissueGiveDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新reissue_give表数据
	 */
	public void updateReissueGiveById(Long id,ReissueGiveDO reissueGiveDO) {
		ReissueGiveDOExample exam = new ReissueGiveDOExample();
		exam.createCriteria().andIdEqualTo(id);
		reissueGiveDAO.updateByExample(reissueGiveDO, exam);
	}

    /**
	 * 根据gid更新reissue_give表数据
	 */
	public void updateReissueGiveByGid(String gid,ReissueGiveDO reissueGiveDO) {
		ReissueGiveDOExample exam = new ReissueGiveDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		reissueGiveDAO.updateByExample(reissueGiveDO, exam);
	}

    /**
	 * 根据userId更新reissue_give表数据
	 */
	public void updateReissueGiveByUserId(String userId,ReissueGiveDO reissueGiveDO) {
		ReissueGiveDOExample exam = new ReissueGiveDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		reissueGiveDAO.updateByExample(reissueGiveDO, exam);
	}

    /**
	 * 根据partnerId更新reissue_give表数据
	 */
	public void updateReissueGiveByPartnerId(String partnerId,ReissueGiveDO reissueGiveDO) {
		ReissueGiveDOExample exam = new ReissueGiveDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		reissueGiveDAO.updateByExample(reissueGiveDO, exam);
	}

    /**
	 * 根据platPartnerId更新reissue_give表数据
	 */
	public void updateReissueGiveByPlatPartnerId(String platPartnerId,ReissueGiveDO reissueGiveDO) {
		ReissueGiveDOExample exam = new ReissueGiveDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		reissueGiveDAO.updateByExample(reissueGiveDO, exam);
	}

    /**
	 * 根据reissueNo更新reissue_give表数据
	 */
	public void updateReissueGiveByReissueNo(String reissueNo,ReissueGiveDO reissueGiveDO) {
		ReissueGiveDOExample exam = new ReissueGiveDOExample();
		exam.createCriteria().andReissueNoEqualTo(reissueNo);
		reissueGiveDAO.updateByExample(reissueGiveDO, exam);
	}

    /**
	 * 断言rule_condition表
	 */
	public void ruleConditionAssert(
	        RuleConditionDO ruleConditionDO,
			Long id, 
			String ruleCode, 
			String leftValue, 
			String comparator, 
			String rightValue, 
			String type, 
			String script, 
			String context, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, ruleConditionDO.getId());
        assertEquals(ruleCode, ruleConditionDO.getRuleCode());
        assertEquals(leftValue, ruleConditionDO.getLeftValue());
        assertEquals(comparator, ruleConditionDO.getComparator());
        assertEquals(rightValue, ruleConditionDO.getRightValue());
        assertEquals(type, ruleConditionDO.getType());
        assertEquals(script, ruleConditionDO.getScript());
        assertEquals(context, ruleConditionDO.getContext());
        assertEquals(rawAddTime, ruleConditionDO.getRawAddTime());
        assertEquals(rawUpdateTime, ruleConditionDO.getRawUpdateTime());
	}

	/**
	 * 断言rule_condition表数据
	 */
	public void assertRuleCondition(RuleConditionDO expect, RuleConditionDO ruleConditionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			ruleConditionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != ruleConditionDO.getRawAddTime());
		expect.setRawAddTime(ruleConditionDO.getRawAddTime());
        Assertions.assertTrue(null != ruleConditionDO.getRawUpdateTime());
		expect.setRawUpdateTime(ruleConditionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, ruleConditionDO);
	}

    /**
	 * 插入rule_condition表数据
	 */
	public void insertRuleCondition(RuleConditionDO ruleConditionDO) {
		ruleConditionDAO.insert(ruleConditionDO);
	}

    /**
	 * 插入rule_condition表数据
	 */
	public void insertRuleCondition(
			Long id, 
			String ruleCode, 
			String leftValue, 
			String comparator, 
			String rightValue, 
			String type, 
			String script, 
			String context, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		RuleConditionDO ruleConditionDO = new RuleConditionDO();
		ruleConditionDO.setId(id);
		ruleConditionDO.setRuleCode(ruleCode);
		ruleConditionDO.setLeftValue(leftValue);
		ruleConditionDO.setComparator(comparator);
		ruleConditionDO.setRightValue(rightValue);
		ruleConditionDO.setType(type);
		ruleConditionDO.setScript(script);
		ruleConditionDO.setContext(context);
		ruleConditionDO.setRawAddTime(rawAddTime);
		ruleConditionDO.setRawUpdateTime(rawUpdateTime);
		ruleConditionDAO.insert(ruleConditionDO);
	}

    /**
     * 删除rule_condition表所有数据
     */
    public void cleanRuleCondition() {
        RuleConditionDOExample exam = new RuleConditionDOExample();
        exam.createCriteria();
        ruleConditionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除rule_condition表数据
	 */
	public void cleanRuleConditionById(Long id) {
		RuleConditionDOExample exam = new RuleConditionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		ruleConditionDAO.deleteByExample(exam);
	}

	/**
	* 根据ruleCode删除rule_condition表数据
	*/
	public void cleanRuleConditionByRuleCode(String ruleCode) {
        if (StringUtils.isBlank(ruleCode)){
            ruleCode = "test_ruleCode";
        }
		RuleConditionDOExample exam = new RuleConditionDOExample();
		exam.createCriteria().andRuleCodeEqualTo(ruleCode);
		ruleConditionDAO.deleteByExample(exam);
	}

    /**
     * 查询rule_condition表所有数据
     */
    public List<RuleConditionDO> findRuleConditionAll() {
        RuleConditionDOExample exam = new RuleConditionDOExample();
        exam.createCriteria();
		return ruleConditionDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询rule_condition表数据
	 */
	public List<RuleConditionDO> findRuleConditionById(Long id) {
		RuleConditionDOExample exam = new RuleConditionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return ruleConditionDAO.selectByExample(exam);
	}

	/**
	* 根据ruleCode查询rule_condition表数据
	*/
	public List<RuleConditionDO> findRuleConditionByRuleCode(String ruleCode) {
		RuleConditionDOExample exam = new RuleConditionDOExample();
		exam.createCriteria().andRuleCodeEqualTo(ruleCode);
		return ruleConditionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新rule_condition表数据
	 */
	public void updateRuleConditionById(Long id,RuleConditionDO ruleConditionDO) {
		RuleConditionDOExample exam = new RuleConditionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		ruleConditionDAO.updateByExample(ruleConditionDO, exam);
	}

	/**
	* 根据ruleCode更新rule_condition表数据
	*/
	public void updateRuleConditionByRuleCode(String ruleCode,RuleConditionDO ruleConditionDO) {
		RuleConditionDOExample exam = new RuleConditionDOExample();
		exam.createCriteria().andRuleCodeEqualTo(ruleCode);
		ruleConditionDAO.updateByExample(ruleConditionDO, exam);
	}

    /**
	 * 断言rule表
	 */
	public void ruleAssert(
	        RuleDO ruleDO,
			Long id, 
			String ruleName, 
			String ruleCode, 
			String ruleSetCode, 
			String ruleGroup, 
			Integer priority, 
			String script, 
			String context, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, ruleDO.getId());
        assertEquals(ruleName, ruleDO.getRuleName());
        assertEquals(ruleCode, ruleDO.getRuleCode());
        assertEquals(ruleSetCode, ruleDO.getRuleSetCode());
        assertEquals(ruleGroup, ruleDO.getRuleGroup());
        assertEquals(priority, ruleDO.getPriority());
        assertEquals(script, ruleDO.getScript());
        assertEquals(context, ruleDO.getContext());
        assertEquals(rawAddTime, ruleDO.getRawAddTime());
        assertEquals(rawUpdateTime, ruleDO.getRawUpdateTime());
	}

	/**
	 * 断言rule表数据
	 */
	public void assertRule(RuleDO expect, RuleDO ruleDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			ruleDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != ruleDO.getRawAddTime());
		expect.setRawAddTime(ruleDO.getRawAddTime());
        Assertions.assertTrue(null != ruleDO.getRawUpdateTime());
		expect.setRawUpdateTime(ruleDO.getRawUpdateTime());
		Assertions.assertEquals(expect, ruleDO);
	}

    /**
	 * 插入rule表数据
	 */
	public void insertRule(RuleDO ruleDO) {
		ruleDAO.insert(ruleDO);
	}

    /**
	 * 插入rule表数据
	 */
	public void insertRule(
			Long id, 
			String ruleName, 
			String ruleCode, 
			String ruleSetCode, 
			String ruleGroup, 
			Integer priority, 
			String script, 
			String context, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		RuleDO ruleDO = new RuleDO();
		ruleDO.setId(id);
		ruleDO.setRuleName(ruleName);
		ruleDO.setRuleCode(ruleCode);
		ruleDO.setRuleSetCode(ruleSetCode);
		ruleDO.setRuleGroup(ruleGroup);
		ruleDO.setPriority(priority);
		ruleDO.setScript(script);
		ruleDO.setContext(context);
		ruleDO.setRawAddTime(rawAddTime);
		ruleDO.setRawUpdateTime(rawUpdateTime);
		ruleDAO.insert(ruleDO);
	}

    /**
     * 删除rule表所有数据
     */
    public void cleanRule() {
        RuleDOExample exam = new RuleDOExample();
        exam.createCriteria();
        ruleDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除rule表数据
	 */
	public void cleanRuleById(Long id) {
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		ruleDAO.deleteByExample(exam);
	}

	/**
	* 根据ruleName删除rule表数据
	*/
	public void cleanRuleByRuleName(String ruleName) {
        if (StringUtils.isBlank(ruleName)){
            ruleName = "test_ruleName";
        }
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andRuleNameEqualTo(ruleName);
		ruleDAO.deleteByExample(exam);
	}

	/**
	* 根据ruleCode删除rule表数据
	*/
	public void cleanRuleByRuleCode(String ruleCode) {
        if (StringUtils.isBlank(ruleCode)){
            ruleCode = "test_ruleCode";
        }
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andRuleCodeEqualTo(ruleCode);
		ruleDAO.deleteByExample(exam);
	}

	/**
	* 根据ruleSetCode删除rule表数据
	*/
	public void cleanRuleByRuleSetCode(String ruleSetCode) {
        if (StringUtils.isBlank(ruleSetCode)){
            ruleSetCode = "test_ruleSetCode";
        }
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andRuleSetCodeEqualTo(ruleSetCode);
		ruleDAO.deleteByExample(exam);
	}

    /**
     * 查询rule表所有数据
     */
    public List<RuleDO> findRuleAll() {
        RuleDOExample exam = new RuleDOExample();
        exam.createCriteria();
		return ruleDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询rule表数据
	 */
	public List<RuleDO> findRuleById(Long id) {
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return ruleDAO.selectByExample(exam);
	}

	/**
	* 根据ruleName查询rule表数据
	*/
	public List<RuleDO> findRuleByRuleName(String ruleName) {
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andRuleNameEqualTo(ruleName);
		return ruleDAO.selectByExample(exam);
	}

	/**
	* 根据ruleCode查询rule表数据
	*/
	public List<RuleDO> findRuleByRuleCode(String ruleCode) {
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andRuleCodeEqualTo(ruleCode);
		return ruleDAO.selectByExample(exam);
	}

	/**
	* 根据ruleSetCode查询rule表数据
	*/
	public List<RuleDO> findRuleByRuleSetCode(String ruleSetCode) {
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andRuleSetCodeEqualTo(ruleSetCode);
		return ruleDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新rule表数据
	 */
	public void updateRuleById(Long id,RuleDO ruleDO) {
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		ruleDAO.updateByExample(ruleDO, exam);
	}

	/**
	* 根据ruleName更新rule表数据
	*/
	public void updateRuleByRuleName(String ruleName,RuleDO ruleDO) {
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andRuleNameEqualTo(ruleName);
		ruleDAO.updateByExample(ruleDO, exam);
	}

	/**
	* 根据ruleCode更新rule表数据
	*/
	public void updateRuleByRuleCode(String ruleCode,RuleDO ruleDO) {
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andRuleCodeEqualTo(ruleCode);
		ruleDAO.updateByExample(ruleDO, exam);
	}

	/**
	* 根据ruleSetCode更新rule表数据
	*/
	public void updateRuleByRuleSetCode(String ruleSetCode,RuleDO ruleDO) {
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andRuleSetCodeEqualTo(ruleSetCode);
		ruleDAO.updateByExample(ruleDO, exam);
	}

    /**
	 * 断言rule_set表
	 */
	public void ruleSetAssert(
	        RuleSetDO ruleSetDO,
			Long id, 
			String code, 
			String description, 
			Date rawUpdateTime, 
			String status
	) {
        assertEquals(id, ruleSetDO.getId());
        assertEquals(code, ruleSetDO.getCode());
        assertEquals(description, ruleSetDO.getDescription());
        assertEquals(rawUpdateTime, ruleSetDO.getRawUpdateTime());
        assertEquals(status, ruleSetDO.getStatus());
	}

	/**
	 * 断言rule_set表数据
	 */
	public void assertRuleSet(RuleSetDO expect, RuleSetDO ruleSetDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			ruleSetDO.setId(expect.getId());
		}
        Assertions.assertTrue(null != ruleSetDO.getRawUpdateTime());
		expect.setRawUpdateTime(ruleSetDO.getRawUpdateTime());
		Assertions.assertEquals(expect, ruleSetDO);
	}

    /**
	 * 插入rule_set表数据
	 */
	public void insertRuleSet(RuleSetDO ruleSetDO) {
		ruleSetDAO.insert(ruleSetDO);
	}

    /**
	 * 插入rule_set表数据
	 */
	public void insertRuleSet(
			Long id, 
			String code, 
			String description, 
			Date rawUpdateTime, 
			String status
	) {
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		RuleSetDO ruleSetDO = new RuleSetDO();
		ruleSetDO.setId(id);
		ruleSetDO.setCode(code);
		ruleSetDO.setDescription(description);
		ruleSetDO.setRawUpdateTime(rawUpdateTime);
		ruleSetDO.setStatus(status);
		ruleSetDAO.insert(ruleSetDO);
	}

    /**
     * 删除rule_set表所有数据
     */
    public void cleanRuleSet() {
        RuleSetDOExample exam = new RuleSetDOExample();
        exam.createCriteria();
        ruleSetDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除rule_set表数据
	 */
	public void cleanRuleSetById(Long id) {
		RuleSetDOExample exam = new RuleSetDOExample();
		exam.createCriteria().andIdEqualTo(id);
		ruleSetDAO.deleteByExample(exam);
	}

	/**
	* 根据code删除rule_set表数据
	*/
	public void cleanRuleSetByCode(String code) {
        if (StringUtils.isBlank(code)){
            code = "test_code";
        }
		RuleSetDOExample exam = new RuleSetDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		ruleSetDAO.deleteByExample(exam);
	}

    /**
     * 查询rule_set表所有数据
     */
    public List<RuleSetDO> findRuleSetAll() {
        RuleSetDOExample exam = new RuleSetDOExample();
        exam.createCriteria();
		return ruleSetDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询rule_set表数据
	 */
	public List<RuleSetDO> findRuleSetById(Long id) {
		RuleSetDOExample exam = new RuleSetDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return ruleSetDAO.selectByExample(exam);
	}

	/**
	* 根据code查询rule_set表数据
	*/
	public List<RuleSetDO> findRuleSetByCode(String code) {
		RuleSetDOExample exam = new RuleSetDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		return ruleSetDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新rule_set表数据
	 */
	public void updateRuleSetById(Long id,RuleSetDO ruleSetDO) {
		RuleSetDOExample exam = new RuleSetDOExample();
		exam.createCriteria().andIdEqualTo(id);
		ruleSetDAO.updateByExample(ruleSetDO, exam);
	}

	/**
	* 根据code更新rule_set表数据
	*/
	public void updateRuleSetByCode(String code,RuleSetDO ruleSetDO) {
		RuleSetDOExample exam = new RuleSetDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		ruleSetDAO.updateByExample(ruleSetDO, exam);
	}

    /**
	 * 断言sales_campaign表
	 */
	public void salesCampaignAssert(
	        SalesCampaignDO salesCampaignDO,
			Long id, 
			String campaignNo, 
			String partnerId, 
			String platPartnerId, 
			String name, 
			String description, 
			String lifeCycle, 
			Date startTime, 
			Date endTime, 
			String useTimeUnit, 
			String days, 
			String timeSlot, 
			String status, 
			String eventRoutes, 
			String partakeRule, 
			String context, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String campaignRules
	) {
        assertEquals(id, salesCampaignDO.getId());
        assertEquals(campaignNo, salesCampaignDO.getCampaignNo());
        assertEquals(partnerId, salesCampaignDO.getPartnerId());
        assertEquals(platPartnerId, salesCampaignDO.getPlatPartnerId());
        assertEquals(name, salesCampaignDO.getName());
        assertEquals(description, salesCampaignDO.getDescription());
        assertEquals(lifeCycle, salesCampaignDO.getLifeCycle());
        assertEquals(startTime, salesCampaignDO.getStartTime());
        assertEquals(endTime, salesCampaignDO.getEndTime());
        assertEquals(useTimeUnit, salesCampaignDO.getUseTimeUnit());
        assertEquals(days, salesCampaignDO.getDays());
        assertEquals(timeSlot, salesCampaignDO.getTimeSlot());
        assertEquals(status, salesCampaignDO.getStatus());
        assertEquals(eventRoutes, salesCampaignDO.getEventRoutes());
        assertEquals(partakeRule, salesCampaignDO.getPartakeRule());
        assertEquals(context, salesCampaignDO.getContext());
        assertEquals(rawAddTime, salesCampaignDO.getRawAddTime());
        assertEquals(rawUpdateTime, salesCampaignDO.getRawUpdateTime());
        assertEquals(campaignRules, salesCampaignDO.getCampaignRules());
	}

	/**
	 * 断言sales_campaign表数据
	 */
	public void assertSalesCampaign(SalesCampaignDO expect, SalesCampaignDO salesCampaignDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			salesCampaignDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != salesCampaignDO.getRawAddTime());
		expect.setRawAddTime(salesCampaignDO.getRawAddTime());
        Assertions.assertTrue(null != salesCampaignDO.getRawUpdateTime());
		expect.setRawUpdateTime(salesCampaignDO.getRawUpdateTime());
		Assertions.assertEquals(expect, salesCampaignDO);
	}

    /**
	 * 插入sales_campaign表数据
	 */
	public void insertSalesCampaign(SalesCampaignDO salesCampaignDO) {
		salesCampaignDAO.insert(salesCampaignDO);
	}

    /**
	 * 插入sales_campaign表数据
	 */
	public void insertSalesCampaign(
			Long id, 
			String campaignNo, 
			String partnerId, 
			String platPartnerId, 
			String name, 
			String description, 
			String lifeCycle, 
			Date startTime, 
			Date endTime, 
			String useTimeUnit, 
			String days, 
			String timeSlot, 
			String status, 
			String eventRoutes, 
			String partakeRule, 
			String context, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String campaignRules
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		SalesCampaignDO salesCampaignDO = new SalesCampaignDO();
		salesCampaignDO.setId(id);
		salesCampaignDO.setCampaignNo(campaignNo);
		salesCampaignDO.setPartnerId(partnerId);
		salesCampaignDO.setPlatPartnerId(platPartnerId);
		salesCampaignDO.setName(name);
		salesCampaignDO.setDescription(description);
		salesCampaignDO.setLifeCycle(lifeCycle);
		salesCampaignDO.setStartTime(startTime);
		salesCampaignDO.setEndTime(endTime);
		salesCampaignDO.setUseTimeUnit(useTimeUnit);
		salesCampaignDO.setDays(days);
		salesCampaignDO.setTimeSlot(timeSlot);
		salesCampaignDO.setStatus(status);
		salesCampaignDO.setEventRoutes(eventRoutes);
		salesCampaignDO.setPartakeRule(partakeRule);
		salesCampaignDO.setContext(context);
		salesCampaignDO.setRawAddTime(rawAddTime);
		salesCampaignDO.setRawUpdateTime(rawUpdateTime);
		salesCampaignDO.setCampaignRules(campaignRules);
		salesCampaignDAO.insert(salesCampaignDO);
	}

    /**
     * 删除sales_campaign表所有数据
     */
    public void cleanSalesCampaign() {
        SalesCampaignDOExample exam = new SalesCampaignDOExample();
        exam.createCriteria();
        salesCampaignDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除sales_campaign表数据
	 */
	public void cleanSalesCampaignById(Long id) {
		SalesCampaignDOExample exam = new SalesCampaignDOExample();
		exam.createCriteria().andIdEqualTo(id);
		salesCampaignDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNo删除sales_campaign表数据
	 */
	public void cleanSalesCampaignByCampaignNo(String campaignNo) {
        if (StringUtils.isBlank(campaignNo)){
            campaignNo = "test_campaignNo";
        }
		SalesCampaignDOExample exam = new SalesCampaignDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		salesCampaignDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除sales_campaign表数据
	 */
	public void cleanSalesCampaignByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		SalesCampaignDOExample exam = new SalesCampaignDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		salesCampaignDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除sales_campaign表数据
	 */
	public void cleanSalesCampaignByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		SalesCampaignDOExample exam = new SalesCampaignDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		salesCampaignDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除sales_campaign表数据
	*/
	public void cleanSalesCampaignByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		SalesCampaignDOExample exam = new SalesCampaignDOExample();
		exam.createCriteria().andNameEqualTo(name);
		salesCampaignDAO.deleteByExample(exam);
	}

    /**
     * 查询sales_campaign表所有数据
     */
    public List<SalesCampaignDO> findSalesCampaignAll() {
        SalesCampaignDOExample exam = new SalesCampaignDOExample();
        exam.createCriteria();
		return salesCampaignDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询sales_campaign表数据
	 */
	public List<SalesCampaignDO> findSalesCampaignById(Long id) {
		SalesCampaignDOExample exam = new SalesCampaignDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return salesCampaignDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNo查询sales_campaign表数据
	 */
	public List<SalesCampaignDO> findSalesCampaignByCampaignNo(String campaignNo) {
		SalesCampaignDOExample exam = new SalesCampaignDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		return salesCampaignDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询sales_campaign表数据
	 */
	public List<SalesCampaignDO> findSalesCampaignByPartnerId(String partnerId) {
		SalesCampaignDOExample exam = new SalesCampaignDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return salesCampaignDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询sales_campaign表数据
	 */
	public List<SalesCampaignDO> findSalesCampaignByPlatPartnerId(String platPartnerId) {
		SalesCampaignDOExample exam = new SalesCampaignDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return salesCampaignDAO.selectByExample(exam);
	}

	/**
	* 根据name查询sales_campaign表数据
	*/
	public List<SalesCampaignDO> findSalesCampaignByName(String name) {
		SalesCampaignDOExample exam = new SalesCampaignDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return salesCampaignDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新sales_campaign表数据
	 */
	public void updateSalesCampaignById(Long id,SalesCampaignDO salesCampaignDO) {
		SalesCampaignDOExample exam = new SalesCampaignDOExample();
		exam.createCriteria().andIdEqualTo(id);
		salesCampaignDAO.updateByExample(salesCampaignDO, exam);
	}

    /**
	 * 根据campaignNo更新sales_campaign表数据
	 */
	public void updateSalesCampaignByCampaignNo(String campaignNo,SalesCampaignDO salesCampaignDO) {
		SalesCampaignDOExample exam = new SalesCampaignDOExample();
		exam.createCriteria().andCampaignNoEqualTo(campaignNo);
		salesCampaignDAO.updateByExample(salesCampaignDO, exam);
	}

    /**
	 * 根据partnerId更新sales_campaign表数据
	 */
	public void updateSalesCampaignByPartnerId(String partnerId,SalesCampaignDO salesCampaignDO) {
		SalesCampaignDOExample exam = new SalesCampaignDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		salesCampaignDAO.updateByExample(salesCampaignDO, exam);
	}

    /**
	 * 根据platPartnerId更新sales_campaign表数据
	 */
	public void updateSalesCampaignByPlatPartnerId(String platPartnerId,SalesCampaignDO salesCampaignDO) {
		SalesCampaignDOExample exam = new SalesCampaignDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		salesCampaignDAO.updateByExample(salesCampaignDO, exam);
	}

	/**
	* 根据name更新sales_campaign表数据
	*/
	public void updateSalesCampaignByName(String name,SalesCampaignDO salesCampaignDO) {
		SalesCampaignDOExample exam = new SalesCampaignDOExample();
		exam.createCriteria().andNameEqualTo(name);
		salesCampaignDAO.updateByExample(salesCampaignDO, exam);
	}

    /**
	 * 断言sales_campaign_group表
	 */
	public void salesCampaignGroupAssert(
	        SalesCampaignGroupDO salesCampaignGroupDO,
			Long id, 
			String groupId, 
			String groupName, 
			String enableStatus, 
			String partnerId, 
			String platPartnerId, 
			Byte couponOverlap, 
			Long discountMaxAmount, 
			Integer priority, 
			String campaignNos, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, salesCampaignGroupDO.getId());
        assertEquals(groupId, salesCampaignGroupDO.getGroupId());
        assertEquals(groupName, salesCampaignGroupDO.getGroupName());
        assertEquals(enableStatus, salesCampaignGroupDO.getEnableStatus());
        assertEquals(partnerId, salesCampaignGroupDO.getPartnerId());
        assertEquals(platPartnerId, salesCampaignGroupDO.getPlatPartnerId());
        assertEquals(couponOverlap, salesCampaignGroupDO.getCouponOverlap());
        assertEquals(discountMaxAmount, salesCampaignGroupDO.getDiscountMaxAmount());
        assertEquals(priority, salesCampaignGroupDO.getPriority());
        assertEquals(campaignNos, salesCampaignGroupDO.getCampaignNos());
        assertEquals(rawAddTime, salesCampaignGroupDO.getRawAddTime());
        assertEquals(rawUpdateTime, salesCampaignGroupDO.getRawUpdateTime());
	}

	/**
	 * 断言sales_campaign_group表数据
	 */
	public void assertSalesCampaignGroup(SalesCampaignGroupDO expect, SalesCampaignGroupDO salesCampaignGroupDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			salesCampaignGroupDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != salesCampaignGroupDO.getRawAddTime());
		expect.setRawAddTime(salesCampaignGroupDO.getRawAddTime());
        Assertions.assertTrue(null != salesCampaignGroupDO.getRawUpdateTime());
		expect.setRawUpdateTime(salesCampaignGroupDO.getRawUpdateTime());
		Assertions.assertEquals(expect, salesCampaignGroupDO);
	}

    /**
	 * 插入sales_campaign_group表数据
	 */
	public void insertSalesCampaignGroup(SalesCampaignGroupDO salesCampaignGroupDO) {
		salesCampaignGroupDAO.insert(salesCampaignGroupDO);
	}

    /**
	 * 插入sales_campaign_group表数据
	 */
	public void insertSalesCampaignGroup(
			Long id, 
			String groupId, 
			String groupName, 
			String enableStatus, 
			String partnerId, 
			String platPartnerId, 
			Byte couponOverlap, 
			Long discountMaxAmount, 
			Integer priority, 
			String campaignNos, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		SalesCampaignGroupDO salesCampaignGroupDO = new SalesCampaignGroupDO();
		salesCampaignGroupDO.setId(id);
		salesCampaignGroupDO.setGroupId(groupId);
		salesCampaignGroupDO.setGroupName(groupName);
		salesCampaignGroupDO.setEnableStatus(enableStatus);
		salesCampaignGroupDO.setPartnerId(partnerId);
		salesCampaignGroupDO.setPlatPartnerId(platPartnerId);
		salesCampaignGroupDO.setCouponOverlap(couponOverlap);
		salesCampaignGroupDO.setDiscountMaxAmount(discountMaxAmount);
		salesCampaignGroupDO.setPriority(priority);
		salesCampaignGroupDO.setCampaignNos(campaignNos);
		salesCampaignGroupDO.setRawAddTime(rawAddTime);
		salesCampaignGroupDO.setRawUpdateTime(rawUpdateTime);
		salesCampaignGroupDAO.insert(salesCampaignGroupDO);
	}

    /**
     * 删除sales_campaign_group表所有数据
     */
    public void cleanSalesCampaignGroup() {
        SalesCampaignGroupDOExample exam = new SalesCampaignGroupDOExample();
        exam.createCriteria();
        salesCampaignGroupDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除sales_campaign_group表数据
	 */
	public void cleanSalesCampaignGroupById(Long id) {
		SalesCampaignGroupDOExample exam = new SalesCampaignGroupDOExample();
		exam.createCriteria().andIdEqualTo(id);
		salesCampaignGroupDAO.deleteByExample(exam);
	}

	/**
	 * 根据groupId删除sales_campaign_group表数据
	 */
	public void cleanSalesCampaignGroupByGroupId(String groupId) {
        if (StringUtils.isBlank(groupId)){
            groupId = "test_groupId";
        }
		SalesCampaignGroupDOExample exam = new SalesCampaignGroupDOExample();
		exam.createCriteria().andGroupIdEqualTo(groupId);
		salesCampaignGroupDAO.deleteByExample(exam);
	}

	/**
	* 根据groupName删除sales_campaign_group表数据
	*/
	public void cleanSalesCampaignGroupByGroupName(String groupName) {
        if (StringUtils.isBlank(groupName)){
            groupName = "test_groupName";
        }
		SalesCampaignGroupDOExample exam = new SalesCampaignGroupDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		salesCampaignGroupDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除sales_campaign_group表数据
	 */
	public void cleanSalesCampaignGroupByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		SalesCampaignGroupDOExample exam = new SalesCampaignGroupDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		salesCampaignGroupDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除sales_campaign_group表数据
	 */
	public void cleanSalesCampaignGroupByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		SalesCampaignGroupDOExample exam = new SalesCampaignGroupDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		salesCampaignGroupDAO.deleteByExample(exam);
	}

	/**
	 * 根据campaignNos删除sales_campaign_group表数据
	 */
	public void cleanSalesCampaignGroupByCampaignNos(String campaignNos) {
        if (StringUtils.isBlank(campaignNos)){
            campaignNos = "test_campaignNos";
        }
		SalesCampaignGroupDOExample exam = new SalesCampaignGroupDOExample();
		exam.createCriteria().andCampaignNosEqualTo(campaignNos);
		salesCampaignGroupDAO.deleteByExample(exam);
	}

    /**
     * 查询sales_campaign_group表所有数据
     */
    public List<SalesCampaignGroupDO> findSalesCampaignGroupAll() {
        SalesCampaignGroupDOExample exam = new SalesCampaignGroupDOExample();
        exam.createCriteria();
		return salesCampaignGroupDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询sales_campaign_group表数据
	 */
	public List<SalesCampaignGroupDO> findSalesCampaignGroupById(Long id) {
		SalesCampaignGroupDOExample exam = new SalesCampaignGroupDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return salesCampaignGroupDAO.selectByExample(exam);
	}

    /**
	 * 根据groupId查询sales_campaign_group表数据
	 */
	public List<SalesCampaignGroupDO> findSalesCampaignGroupByGroupId(String groupId) {
		SalesCampaignGroupDOExample exam = new SalesCampaignGroupDOExample();
		exam.createCriteria().andGroupIdEqualTo(groupId);
		return salesCampaignGroupDAO.selectByExample(exam);
	}

	/**
	* 根据groupName查询sales_campaign_group表数据
	*/
	public List<SalesCampaignGroupDO> findSalesCampaignGroupByGroupName(String groupName) {
		SalesCampaignGroupDOExample exam = new SalesCampaignGroupDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		return salesCampaignGroupDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询sales_campaign_group表数据
	 */
	public List<SalesCampaignGroupDO> findSalesCampaignGroupByPartnerId(String partnerId) {
		SalesCampaignGroupDOExample exam = new SalesCampaignGroupDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return salesCampaignGroupDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询sales_campaign_group表数据
	 */
	public List<SalesCampaignGroupDO> findSalesCampaignGroupByPlatPartnerId(String platPartnerId) {
		SalesCampaignGroupDOExample exam = new SalesCampaignGroupDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return salesCampaignGroupDAO.selectByExample(exam);
	}

    /**
	 * 根据campaignNos查询sales_campaign_group表数据
	 */
	public List<SalesCampaignGroupDO> findSalesCampaignGroupByCampaignNos(String campaignNos) {
		SalesCampaignGroupDOExample exam = new SalesCampaignGroupDOExample();
		exam.createCriteria().andCampaignNosEqualTo(campaignNos);
		return salesCampaignGroupDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新sales_campaign_group表数据
	 */
	public void updateSalesCampaignGroupById(Long id,SalesCampaignGroupDO salesCampaignGroupDO) {
		SalesCampaignGroupDOExample exam = new SalesCampaignGroupDOExample();
		exam.createCriteria().andIdEqualTo(id);
		salesCampaignGroupDAO.updateByExample(salesCampaignGroupDO, exam);
	}

    /**
	 * 根据groupId更新sales_campaign_group表数据
	 */
	public void updateSalesCampaignGroupByGroupId(String groupId,SalesCampaignGroupDO salesCampaignGroupDO) {
		SalesCampaignGroupDOExample exam = new SalesCampaignGroupDOExample();
		exam.createCriteria().andGroupIdEqualTo(groupId);
		salesCampaignGroupDAO.updateByExample(salesCampaignGroupDO, exam);
	}

	/**
	* 根据groupName更新sales_campaign_group表数据
	*/
	public void updateSalesCampaignGroupByGroupName(String groupName,SalesCampaignGroupDO salesCampaignGroupDO) {
		SalesCampaignGroupDOExample exam = new SalesCampaignGroupDOExample();
		exam.createCriteria().andGroupNameEqualTo(groupName);
		salesCampaignGroupDAO.updateByExample(salesCampaignGroupDO, exam);
	}

    /**
	 * 根据partnerId更新sales_campaign_group表数据
	 */
	public void updateSalesCampaignGroupByPartnerId(String partnerId,SalesCampaignGroupDO salesCampaignGroupDO) {
		SalesCampaignGroupDOExample exam = new SalesCampaignGroupDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		salesCampaignGroupDAO.updateByExample(salesCampaignGroupDO, exam);
	}

    /**
	 * 根据platPartnerId更新sales_campaign_group表数据
	 */
	public void updateSalesCampaignGroupByPlatPartnerId(String platPartnerId,SalesCampaignGroupDO salesCampaignGroupDO) {
		SalesCampaignGroupDOExample exam = new SalesCampaignGroupDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		salesCampaignGroupDAO.updateByExample(salesCampaignGroupDO, exam);
	}

    /**
	 * 根据campaignNos更新sales_campaign_group表数据
	 */
	public void updateSalesCampaignGroupByCampaignNos(String campaignNos,SalesCampaignGroupDO salesCampaignGroupDO) {
		SalesCampaignGroupDOExample exam = new SalesCampaignGroupDOExample();
		exam.createCriteria().andCampaignNosEqualTo(campaignNos);
		salesCampaignGroupDAO.updateByExample(salesCampaignGroupDO, exam);
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
	 * 断言trigger_condition表
	 */
	public void triggerConditionAssert(
	        TriggerConditionDO triggerConditionDO,
			Long id, 
			String conditionName, 
			String description, 
			String eventRoute, 
			String params, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, triggerConditionDO.getId());
        assertEquals(conditionName, triggerConditionDO.getConditionName());
        assertEquals(description, triggerConditionDO.getDescription());
        assertEquals(eventRoute, triggerConditionDO.getEventRoute());
        assertEquals(params, triggerConditionDO.getParams());
        assertEquals(rawAddTime, triggerConditionDO.getRawAddTime());
        assertEquals(rawUpdateTime, triggerConditionDO.getRawUpdateTime());
	}

	/**
	 * 断言trigger_condition表数据
	 */
	public void assertTriggerCondition(TriggerConditionDO expect, TriggerConditionDO triggerConditionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			triggerConditionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != triggerConditionDO.getRawAddTime());
		expect.setRawAddTime(triggerConditionDO.getRawAddTime());
        Assertions.assertTrue(null != triggerConditionDO.getRawUpdateTime());
		expect.setRawUpdateTime(triggerConditionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, triggerConditionDO);
	}

    /**
	 * 插入trigger_condition表数据
	 */
	public void insertTriggerCondition(TriggerConditionDO triggerConditionDO) {
		triggerConditionDAO.insert(triggerConditionDO);
	}

    /**
	 * 插入trigger_condition表数据
	 */
	public void insertTriggerCondition(
			Long id, 
			String conditionName, 
			String description, 
			String eventRoute, 
			String params, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		TriggerConditionDO triggerConditionDO = new TriggerConditionDO();
		triggerConditionDO.setId(id);
		triggerConditionDO.setConditionName(conditionName);
		triggerConditionDO.setDescription(description);
		triggerConditionDO.setEventRoute(eventRoute);
		triggerConditionDO.setParams(params);
		triggerConditionDO.setRawAddTime(rawAddTime);
		triggerConditionDO.setRawUpdateTime(rawUpdateTime);
		triggerConditionDAO.insert(triggerConditionDO);
	}

    /**
     * 删除trigger_condition表所有数据
     */
    public void cleanTriggerCondition() {
        TriggerConditionDOExample exam = new TriggerConditionDOExample();
        exam.createCriteria();
        triggerConditionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除trigger_condition表数据
	 */
	public void cleanTriggerConditionById(Long id) {
		TriggerConditionDOExample exam = new TriggerConditionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		triggerConditionDAO.deleteByExample(exam);
	}

	/**
	* 根据conditionName删除trigger_condition表数据
	*/
	public void cleanTriggerConditionByConditionName(String conditionName) {
        if (StringUtils.isBlank(conditionName)){
            conditionName = "test_conditionName";
        }
		TriggerConditionDOExample exam = new TriggerConditionDOExample();
		exam.createCriteria().andConditionNameEqualTo(conditionName);
		triggerConditionDAO.deleteByExample(exam);
	}

    /**
     * 查询trigger_condition表所有数据
     */
    public List<TriggerConditionDO> findTriggerConditionAll() {
        TriggerConditionDOExample exam = new TriggerConditionDOExample();
        exam.createCriteria();
		return triggerConditionDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询trigger_condition表数据
	 */
	public List<TriggerConditionDO> findTriggerConditionById(Long id) {
		TriggerConditionDOExample exam = new TriggerConditionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return triggerConditionDAO.selectByExample(exam);
	}

	/**
	* 根据conditionName查询trigger_condition表数据
	*/
	public List<TriggerConditionDO> findTriggerConditionByConditionName(String conditionName) {
		TriggerConditionDOExample exam = new TriggerConditionDOExample();
		exam.createCriteria().andConditionNameEqualTo(conditionName);
		return triggerConditionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新trigger_condition表数据
	 */
	public void updateTriggerConditionById(Long id,TriggerConditionDO triggerConditionDO) {
		TriggerConditionDOExample exam = new TriggerConditionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		triggerConditionDAO.updateByExample(triggerConditionDO, exam);
	}

	/**
	* 根据conditionName更新trigger_condition表数据
	*/
	public void updateTriggerConditionByConditionName(String conditionName,TriggerConditionDO triggerConditionDO) {
		TriggerConditionDOExample exam = new TriggerConditionDOExample();
		exam.createCriteria().andConditionNameEqualTo(conditionName);
		triggerConditionDAO.updateByExample(triggerConditionDO, exam);
	}

    /**
	 * 断言trigger_event表
	 */
	public void triggerEventAssert(
	        TriggerEventDO triggerEventDO,
			Long id, 
			String eventName, 
			String eventRoute, 
			String eventScope, 
			String eventStatus, 
			String eventDescription, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, triggerEventDO.getId());
        assertEquals(eventName, triggerEventDO.getEventName());
        assertEquals(eventRoute, triggerEventDO.getEventRoute());
        assertEquals(eventScope, triggerEventDO.getEventScope());
        assertEquals(eventStatus, triggerEventDO.getEventStatus());
        assertEquals(eventDescription, triggerEventDO.getEventDescription());
        assertEquals(rawAddTime, triggerEventDO.getRawAddTime());
        assertEquals(rawUpdateTime, triggerEventDO.getRawUpdateTime());
	}

	/**
	 * 断言trigger_event表数据
	 */
	public void assertTriggerEvent(TriggerEventDO expect, TriggerEventDO triggerEventDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			triggerEventDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != triggerEventDO.getRawAddTime());
		expect.setRawAddTime(triggerEventDO.getRawAddTime());
        Assertions.assertTrue(null != triggerEventDO.getRawUpdateTime());
		expect.setRawUpdateTime(triggerEventDO.getRawUpdateTime());
		Assertions.assertEquals(expect, triggerEventDO);
	}

    /**
	 * 插入trigger_event表数据
	 */
	public void insertTriggerEvent(TriggerEventDO triggerEventDO) {
		triggerEventDAO.insert(triggerEventDO);
	}

    /**
	 * 插入trigger_event表数据
	 */
	public void insertTriggerEvent(
			Long id, 
			String eventName, 
			String eventRoute, 
			String eventScope, 
			String eventStatus, 
			String eventDescription, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		TriggerEventDO triggerEventDO = new TriggerEventDO();
		triggerEventDO.setId(id);
		triggerEventDO.setEventName(eventName);
		triggerEventDO.setEventRoute(eventRoute);
		triggerEventDO.setEventScope(eventScope);
		triggerEventDO.setEventStatus(eventStatus);
		triggerEventDO.setEventDescription(eventDescription);
		triggerEventDO.setRawAddTime(rawAddTime);
		triggerEventDO.setRawUpdateTime(rawUpdateTime);
		triggerEventDAO.insert(triggerEventDO);
	}

    /**
     * 删除trigger_event表所有数据
     */
    public void cleanTriggerEvent() {
        TriggerEventDOExample exam = new TriggerEventDOExample();
        exam.createCriteria();
        triggerEventDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除trigger_event表数据
	 */
	public void cleanTriggerEventById(Long id) {
		TriggerEventDOExample exam = new TriggerEventDOExample();
		exam.createCriteria().andIdEqualTo(id);
		triggerEventDAO.deleteByExample(exam);
	}

	/**
	* 根据eventName删除trigger_event表数据
	*/
	public void cleanTriggerEventByEventName(String eventName) {
        if (StringUtils.isBlank(eventName)){
            eventName = "test_eventName";
        }
		TriggerEventDOExample exam = new TriggerEventDOExample();
		exam.createCriteria().andEventNameEqualTo(eventName);
		triggerEventDAO.deleteByExample(exam);
	}

    /**
     * 查询trigger_event表所有数据
     */
    public List<TriggerEventDO> findTriggerEventAll() {
        TriggerEventDOExample exam = new TriggerEventDOExample();
        exam.createCriteria();
		return triggerEventDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询trigger_event表数据
	 */
	public List<TriggerEventDO> findTriggerEventById(Long id) {
		TriggerEventDOExample exam = new TriggerEventDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return triggerEventDAO.selectByExample(exam);
	}

	/**
	* 根据eventName查询trigger_event表数据
	*/
	public List<TriggerEventDO> findTriggerEventByEventName(String eventName) {
		TriggerEventDOExample exam = new TriggerEventDOExample();
		exam.createCriteria().andEventNameEqualTo(eventName);
		return triggerEventDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新trigger_event表数据
	 */
	public void updateTriggerEventById(Long id,TriggerEventDO triggerEventDO) {
		TriggerEventDOExample exam = new TriggerEventDOExample();
		exam.createCriteria().andIdEqualTo(id);
		triggerEventDAO.updateByExample(triggerEventDO, exam);
	}

	/**
	* 根据eventName更新trigger_event表数据
	*/
	public void updateTriggerEventByEventName(String eventName,TriggerEventDO triggerEventDO) {
		TriggerEventDOExample exam = new TriggerEventDOExample();
		exam.createCriteria().andEventNameEqualTo(eventName);
		triggerEventDAO.updateByExample(triggerEventDO, exam);
	}

    /**
	 * 断言trigger_event_data表
	 */
	public void triggerEventDataAssert(
	        TriggerEventDataDO triggerEventDataDO,
			Long id, 
			String eventRoute, 
			String keyName, 
			String keyCode, 
			String dataSource, 
			String moduleName, 
			String keyType, 
			String enums, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, triggerEventDataDO.getId());
        assertEquals(eventRoute, triggerEventDataDO.getEventRoute());
        assertEquals(keyName, triggerEventDataDO.getKeyName());
        assertEquals(keyCode, triggerEventDataDO.getKeyCode());
        assertEquals(dataSource, triggerEventDataDO.getDataSource());
        assertEquals(moduleName, triggerEventDataDO.getModuleName());
        assertEquals(keyType, triggerEventDataDO.getKeyType());
        assertEquals(enums, triggerEventDataDO.getEnums());
        assertEquals(rawAddTime, triggerEventDataDO.getRawAddTime());
        assertEquals(rawUpdateTime, triggerEventDataDO.getRawUpdateTime());
	}

	/**
	 * 断言trigger_event_data表数据
	 */
	public void assertTriggerEventData(TriggerEventDataDO expect, TriggerEventDataDO triggerEventDataDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			triggerEventDataDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != triggerEventDataDO.getRawAddTime());
		expect.setRawAddTime(triggerEventDataDO.getRawAddTime());
        Assertions.assertTrue(null != triggerEventDataDO.getRawUpdateTime());
		expect.setRawUpdateTime(triggerEventDataDO.getRawUpdateTime());
		Assertions.assertEquals(expect, triggerEventDataDO);
	}

    /**
	 * 插入trigger_event_data表数据
	 */
	public void insertTriggerEventData(TriggerEventDataDO triggerEventDataDO) {
		triggerEventDataDAO.insert(triggerEventDataDO);
	}

    /**
	 * 插入trigger_event_data表数据
	 */
	public void insertTriggerEventData(
			Long id, 
			String eventRoute, 
			String keyName, 
			String keyCode, 
			String dataSource, 
			String moduleName, 
			String keyType, 
			String enums, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		TriggerEventDataDO triggerEventDataDO = new TriggerEventDataDO();
		triggerEventDataDO.setId(id);
		triggerEventDataDO.setEventRoute(eventRoute);
		triggerEventDataDO.setKeyName(keyName);
		triggerEventDataDO.setKeyCode(keyCode);
		triggerEventDataDO.setDataSource(dataSource);
		triggerEventDataDO.setModuleName(moduleName);
		triggerEventDataDO.setKeyType(keyType);
		triggerEventDataDO.setEnums(enums);
		triggerEventDataDO.setRawAddTime(rawAddTime);
		triggerEventDataDO.setRawUpdateTime(rawUpdateTime);
		triggerEventDataDAO.insert(triggerEventDataDO);
	}

    /**
     * 删除trigger_event_data表所有数据
     */
    public void cleanTriggerEventData() {
        TriggerEventDataDOExample exam = new TriggerEventDataDOExample();
        exam.createCriteria();
        triggerEventDataDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除trigger_event_data表数据
	 */
	public void cleanTriggerEventDataById(Long id) {
		TriggerEventDataDOExample exam = new TriggerEventDataDOExample();
		exam.createCriteria().andIdEqualTo(id);
		triggerEventDataDAO.deleteByExample(exam);
	}

	/**
	* 根据keyName删除trigger_event_data表数据
	*/
	public void cleanTriggerEventDataByKeyName(String keyName) {
        if (StringUtils.isBlank(keyName)){
            keyName = "test_keyName";
        }
		TriggerEventDataDOExample exam = new TriggerEventDataDOExample();
		exam.createCriteria().andKeyNameEqualTo(keyName);
		triggerEventDataDAO.deleteByExample(exam);
	}

	/**
	* 根据keyCode删除trigger_event_data表数据
	*/
	public void cleanTriggerEventDataByKeyCode(String keyCode) {
        if (StringUtils.isBlank(keyCode)){
            keyCode = "test_keyCode";
        }
		TriggerEventDataDOExample exam = new TriggerEventDataDOExample();
		exam.createCriteria().andKeyCodeEqualTo(keyCode);
		triggerEventDataDAO.deleteByExample(exam);
	}

	/**
	* 根据moduleName删除trigger_event_data表数据
	*/
	public void cleanTriggerEventDataByModuleName(String moduleName) {
        if (StringUtils.isBlank(moduleName)){
            moduleName = "test_moduleName";
        }
		TriggerEventDataDOExample exam = new TriggerEventDataDOExample();
		exam.createCriteria().andModuleNameEqualTo(moduleName);
		triggerEventDataDAO.deleteByExample(exam);
	}

    /**
     * 查询trigger_event_data表所有数据
     */
    public List<TriggerEventDataDO> findTriggerEventDataAll() {
        TriggerEventDataDOExample exam = new TriggerEventDataDOExample();
        exam.createCriteria();
		return triggerEventDataDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询trigger_event_data表数据
	 */
	public List<TriggerEventDataDO> findTriggerEventDataById(Long id) {
		TriggerEventDataDOExample exam = new TriggerEventDataDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return triggerEventDataDAO.selectByExample(exam);
	}

	/**
	* 根据keyName查询trigger_event_data表数据
	*/
	public List<TriggerEventDataDO> findTriggerEventDataByKeyName(String keyName) {
		TriggerEventDataDOExample exam = new TriggerEventDataDOExample();
		exam.createCriteria().andKeyNameEqualTo(keyName);
		return triggerEventDataDAO.selectByExample(exam);
	}

	/**
	* 根据keyCode查询trigger_event_data表数据
	*/
	public List<TriggerEventDataDO> findTriggerEventDataByKeyCode(String keyCode) {
		TriggerEventDataDOExample exam = new TriggerEventDataDOExample();
		exam.createCriteria().andKeyCodeEqualTo(keyCode);
		return triggerEventDataDAO.selectByExample(exam);
	}

	/**
	* 根据moduleName查询trigger_event_data表数据
	*/
	public List<TriggerEventDataDO> findTriggerEventDataByModuleName(String moduleName) {
		TriggerEventDataDOExample exam = new TriggerEventDataDOExample();
		exam.createCriteria().andModuleNameEqualTo(moduleName);
		return triggerEventDataDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新trigger_event_data表数据
	 */
	public void updateTriggerEventDataById(Long id,TriggerEventDataDO triggerEventDataDO) {
		TriggerEventDataDOExample exam = new TriggerEventDataDOExample();
		exam.createCriteria().andIdEqualTo(id);
		triggerEventDataDAO.updateByExample(triggerEventDataDO, exam);
	}

	/**
	* 根据keyName更新trigger_event_data表数据
	*/
	public void updateTriggerEventDataByKeyName(String keyName,TriggerEventDataDO triggerEventDataDO) {
		TriggerEventDataDOExample exam = new TriggerEventDataDOExample();
		exam.createCriteria().andKeyNameEqualTo(keyName);
		triggerEventDataDAO.updateByExample(triggerEventDataDO, exam);
	}

	/**
	* 根据keyCode更新trigger_event_data表数据
	*/
	public void updateTriggerEventDataByKeyCode(String keyCode,TriggerEventDataDO triggerEventDataDO) {
		TriggerEventDataDOExample exam = new TriggerEventDataDOExample();
		exam.createCriteria().andKeyCodeEqualTo(keyCode);
		triggerEventDataDAO.updateByExample(triggerEventDataDO, exam);
	}

	/**
	* 根据moduleName更新trigger_event_data表数据
	*/
	public void updateTriggerEventDataByModuleName(String moduleName,TriggerEventDataDO triggerEventDataDO) {
		TriggerEventDataDOExample exam = new TriggerEventDataDOExample();
		exam.createCriteria().andModuleNameEqualTo(moduleName);
		triggerEventDataDAO.updateByExample(triggerEventDataDO, exam);
	}

    /**
	 * 断言user_action_event表
	 */
	public void userActionEventAssert(
	        UserActionEventDO userActionEventDO,
			Long id, 
			String eventId, 
			String gid, 
			String actionEvent, 
			String partnerId, 
			String platPartnerId, 
			String userId, 
			String accountTag, 
			Date eventTime, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String context
	) {
        assertEquals(id, userActionEventDO.getId());
        assertEquals(eventId, userActionEventDO.getEventId());
        assertEquals(gid, userActionEventDO.getGid());
        assertEquals(actionEvent, userActionEventDO.getActionEvent());
        assertEquals(partnerId, userActionEventDO.getPartnerId());
        assertEquals(platPartnerId, userActionEventDO.getPlatPartnerId());
        assertEquals(userId, userActionEventDO.getUserId());
        assertEquals(accountTag, userActionEventDO.getAccountTag());
        assertEquals(eventTime, userActionEventDO.getEventTime());
        assertEquals(status, userActionEventDO.getStatus());
        assertEquals(rawAddTime, userActionEventDO.getRawAddTime());
        assertEquals(rawUpdateTime, userActionEventDO.getRawUpdateTime());
        assertEquals(context, userActionEventDO.getContext());
	}

	/**
	 * 断言user_action_event表数据
	 */
	public void assertUserActionEvent(UserActionEventDO expect, UserActionEventDO userActionEventDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userActionEventDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userActionEventDO.getRawAddTime());
		expect.setRawAddTime(userActionEventDO.getRawAddTime());
        Assertions.assertTrue(null != userActionEventDO.getRawUpdateTime());
		expect.setRawUpdateTime(userActionEventDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userActionEventDO);
	}

    /**
	 * 插入user_action_event表数据
	 */
	public void insertUserActionEvent(UserActionEventDO userActionEventDO) {
		userActionEventDAO.insert(userActionEventDO);
	}

    /**
	 * 插入user_action_event表数据
	 */
	public void insertUserActionEvent(
			Long id, 
			String eventId, 
			String gid, 
			String actionEvent, 
			String partnerId, 
			String platPartnerId, 
			String userId, 
			String accountTag, 
			Date eventTime, 
			String status, 
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
		UserActionEventDO userActionEventDO = new UserActionEventDO();
		userActionEventDO.setId(id);
		userActionEventDO.setEventId(eventId);
		userActionEventDO.setGid(gid);
		userActionEventDO.setActionEvent(actionEvent);
		userActionEventDO.setPartnerId(partnerId);
		userActionEventDO.setPlatPartnerId(platPartnerId);
		userActionEventDO.setUserId(userId);
		userActionEventDO.setAccountTag(accountTag);
		userActionEventDO.setEventTime(eventTime);
		userActionEventDO.setStatus(status);
		userActionEventDO.setRawAddTime(rawAddTime);
		userActionEventDO.setRawUpdateTime(rawUpdateTime);
		userActionEventDO.setContext(context);
		userActionEventDAO.insert(userActionEventDO);
	}

    /**
     * 删除user_action_event表所有数据
     */
    public void cleanUserActionEvent() {
        UserActionEventDOExample exam = new UserActionEventDOExample();
        exam.createCriteria();
        userActionEventDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_action_event表数据
	 */
	public void cleanUserActionEventById(Long id) {
		UserActionEventDOExample exam = new UserActionEventDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userActionEventDAO.deleteByExample(exam);
	}

	/**
	 * 根据eventId删除user_action_event表数据
	 */
	public void cleanUserActionEventByEventId(String eventId) {
        if (StringUtils.isBlank(eventId)){
            eventId = "test_eventId";
        }
		UserActionEventDOExample exam = new UserActionEventDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		userActionEventDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除user_action_event表数据
	 */
	public void cleanUserActionEventByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		UserActionEventDOExample exam = new UserActionEventDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		userActionEventDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除user_action_event表数据
	 */
	public void cleanUserActionEventByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		UserActionEventDOExample exam = new UserActionEventDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userActionEventDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除user_action_event表数据
	 */
	public void cleanUserActionEventByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		UserActionEventDOExample exam = new UserActionEventDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		userActionEventDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除user_action_event表数据
	 */
	public void cleanUserActionEventByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		UserActionEventDOExample exam = new UserActionEventDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userActionEventDAO.deleteByExample(exam);
	}

    /**
     * 查询user_action_event表所有数据
     */
    public List<UserActionEventDO> findUserActionEventAll() {
        UserActionEventDOExample exam = new UserActionEventDOExample();
        exam.createCriteria();
		return userActionEventDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_action_event表数据
	 */
	public List<UserActionEventDO> findUserActionEventById(Long id) {
		UserActionEventDOExample exam = new UserActionEventDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userActionEventDAO.selectByExample(exam);
	}

    /**
	 * 根据eventId查询user_action_event表数据
	 */
	public List<UserActionEventDO> findUserActionEventByEventId(String eventId) {
		UserActionEventDOExample exam = new UserActionEventDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		return userActionEventDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询user_action_event表数据
	 */
	public List<UserActionEventDO> findUserActionEventByGid(String gid) {
		UserActionEventDOExample exam = new UserActionEventDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return userActionEventDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询user_action_event表数据
	 */
	public List<UserActionEventDO> findUserActionEventByPartnerId(String partnerId) {
		UserActionEventDOExample exam = new UserActionEventDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return userActionEventDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询user_action_event表数据
	 */
	public List<UserActionEventDO> findUserActionEventByPlatPartnerId(String platPartnerId) {
		UserActionEventDOExample exam = new UserActionEventDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return userActionEventDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询user_action_event表数据
	 */
	public List<UserActionEventDO> findUserActionEventByUserId(String userId) {
		UserActionEventDOExample exam = new UserActionEventDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return userActionEventDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_action_event表数据
	 */
	public void updateUserActionEventById(Long id,UserActionEventDO userActionEventDO) {
		UserActionEventDOExample exam = new UserActionEventDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userActionEventDAO.updateByExample(userActionEventDO, exam);
	}

    /**
	 * 根据eventId更新user_action_event表数据
	 */
	public void updateUserActionEventByEventId(String eventId,UserActionEventDO userActionEventDO) {
		UserActionEventDOExample exam = new UserActionEventDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		userActionEventDAO.updateByExample(userActionEventDO, exam);
	}

    /**
	 * 根据gid更新user_action_event表数据
	 */
	public void updateUserActionEventByGid(String gid,UserActionEventDO userActionEventDO) {
		UserActionEventDOExample exam = new UserActionEventDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		userActionEventDAO.updateByExample(userActionEventDO, exam);
	}

    /**
	 * 根据partnerId更新user_action_event表数据
	 */
	public void updateUserActionEventByPartnerId(String partnerId,UserActionEventDO userActionEventDO) {
		UserActionEventDOExample exam = new UserActionEventDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userActionEventDAO.updateByExample(userActionEventDO, exam);
	}

    /**
	 * 根据platPartnerId更新user_action_event表数据
	 */
	public void updateUserActionEventByPlatPartnerId(String platPartnerId,UserActionEventDO userActionEventDO) {
		UserActionEventDOExample exam = new UserActionEventDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		userActionEventDAO.updateByExample(userActionEventDO, exam);
	}

    /**
	 * 根据userId更新user_action_event表数据
	 */
	public void updateUserActionEventByUserId(String userId,UserActionEventDO userActionEventDO) {
		UserActionEventDOExample exam = new UserActionEventDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userActionEventDAO.updateByExample(userActionEventDO, exam);
	}

    /**
	 * 断言user_birthday_task表
	 */
	public void userBirthdayTaskAssert(
	        UserBirthdayTaskDO userBirthdayTaskDO,
			Long id, 
			String userId, 
			String executeTime, 
			String eventId, 
			String birthday, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userBirthdayTaskDO.getId());
        assertEquals(userId, userBirthdayTaskDO.getUserId());
        assertEquals(executeTime, userBirthdayTaskDO.getExecuteTime());
        assertEquals(eventId, userBirthdayTaskDO.getEventId());
        assertEquals(birthday, userBirthdayTaskDO.getBirthday());
        assertEquals(status, userBirthdayTaskDO.getStatus());
        assertEquals(rawAddTime, userBirthdayTaskDO.getRawAddTime());
        assertEquals(rawUpdateTime, userBirthdayTaskDO.getRawUpdateTime());
	}

	/**
	 * 断言user_birthday_task表数据
	 */
	public void assertUserBirthdayTask(UserBirthdayTaskDO expect, UserBirthdayTaskDO userBirthdayTaskDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userBirthdayTaskDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userBirthdayTaskDO.getRawAddTime());
		expect.setRawAddTime(userBirthdayTaskDO.getRawAddTime());
        Assertions.assertTrue(null != userBirthdayTaskDO.getRawUpdateTime());
		expect.setRawUpdateTime(userBirthdayTaskDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userBirthdayTaskDO);
	}

    /**
	 * 插入user_birthday_task表数据
	 */
	public void insertUserBirthdayTask(UserBirthdayTaskDO userBirthdayTaskDO) {
		userBirthdayTaskDAO.insert(userBirthdayTaskDO);
	}

    /**
	 * 插入user_birthday_task表数据
	 */
	public void insertUserBirthdayTask(
			Long id, 
			String userId, 
			String executeTime, 
			String eventId, 
			String birthday, 
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
		UserBirthdayTaskDO userBirthdayTaskDO = new UserBirthdayTaskDO();
		userBirthdayTaskDO.setId(id);
		userBirthdayTaskDO.setUserId(userId);
		userBirthdayTaskDO.setExecuteTime(executeTime);
		userBirthdayTaskDO.setEventId(eventId);
		userBirthdayTaskDO.setBirthday(birthday);
		userBirthdayTaskDO.setStatus(status);
		userBirthdayTaskDO.setRawAddTime(rawAddTime);
		userBirthdayTaskDO.setRawUpdateTime(rawUpdateTime);
		userBirthdayTaskDAO.insert(userBirthdayTaskDO);
	}

    /**
     * 删除user_birthday_task表所有数据
     */
    public void cleanUserBirthdayTask() {
        UserBirthdayTaskDOExample exam = new UserBirthdayTaskDOExample();
        exam.createCriteria();
        userBirthdayTaskDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_birthday_task表数据
	 */
	public void cleanUserBirthdayTaskById(Long id) {
		UserBirthdayTaskDOExample exam = new UserBirthdayTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userBirthdayTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除user_birthday_task表数据
	 */
	public void cleanUserBirthdayTaskByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		UserBirthdayTaskDOExample exam = new UserBirthdayTaskDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userBirthdayTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据eventId删除user_birthday_task表数据
	 */
	public void cleanUserBirthdayTaskByEventId(String eventId) {
        if (StringUtils.isBlank(eventId)){
            eventId = "test_eventId";
        }
		UserBirthdayTaskDOExample exam = new UserBirthdayTaskDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		userBirthdayTaskDAO.deleteByExample(exam);
	}

    /**
     * 查询user_birthday_task表所有数据
     */
    public List<UserBirthdayTaskDO> findUserBirthdayTaskAll() {
        UserBirthdayTaskDOExample exam = new UserBirthdayTaskDOExample();
        exam.createCriteria();
		return userBirthdayTaskDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_birthday_task表数据
	 */
	public List<UserBirthdayTaskDO> findUserBirthdayTaskById(Long id) {
		UserBirthdayTaskDOExample exam = new UserBirthdayTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userBirthdayTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询user_birthday_task表数据
	 */
	public List<UserBirthdayTaskDO> findUserBirthdayTaskByUserId(String userId) {
		UserBirthdayTaskDOExample exam = new UserBirthdayTaskDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return userBirthdayTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据eventId查询user_birthday_task表数据
	 */
	public List<UserBirthdayTaskDO> findUserBirthdayTaskByEventId(String eventId) {
		UserBirthdayTaskDOExample exam = new UserBirthdayTaskDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		return userBirthdayTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_birthday_task表数据
	 */
	public void updateUserBirthdayTaskById(Long id,UserBirthdayTaskDO userBirthdayTaskDO) {
		UserBirthdayTaskDOExample exam = new UserBirthdayTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userBirthdayTaskDAO.updateByExample(userBirthdayTaskDO, exam);
	}

    /**
	 * 根据userId更新user_birthday_task表数据
	 */
	public void updateUserBirthdayTaskByUserId(String userId,UserBirthdayTaskDO userBirthdayTaskDO) {
		UserBirthdayTaskDOExample exam = new UserBirthdayTaskDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		userBirthdayTaskDAO.updateByExample(userBirthdayTaskDO, exam);
	}

    /**
	 * 根据eventId更新user_birthday_task表数据
	 */
	public void updateUserBirthdayTaskByEventId(String eventId,UserBirthdayTaskDO userBirthdayTaskDO) {
		UserBirthdayTaskDOExample exam = new UserBirthdayTaskDOExample();
		exam.createCriteria().andEventIdEqualTo(eventId);
		userBirthdayTaskDAO.updateByExample(userBirthdayTaskDO, exam);
	}

    /**
	 * 断言user_group表
	 */
	public void userGroupAssert(
	        UserGroupDO userGroupDO,
			Long id, 
			String userGroupNo, 
			String partnerId, 
			String platPartnerId, 
			String name, 
			String userGroupType, 
			String filterRule, 
			Integer totalList, 
			String memo, 
			String ruleSetCode, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userGroupDO.getId());
        assertEquals(userGroupNo, userGroupDO.getUserGroupNo());
        assertEquals(partnerId, userGroupDO.getPartnerId());
        assertEquals(platPartnerId, userGroupDO.getPlatPartnerId());
        assertEquals(name, userGroupDO.getName());
        assertEquals(userGroupType, userGroupDO.getUserGroupType());
        assertEquals(filterRule, userGroupDO.getFilterRule());
        assertEquals(totalList, userGroupDO.getTotalList());
        assertEquals(memo, userGroupDO.getMemo());
        assertEquals(ruleSetCode, userGroupDO.getRuleSetCode());
        assertEquals(rawAddTime, userGroupDO.getRawAddTime());
        assertEquals(rawUpdateTime, userGroupDO.getRawUpdateTime());
	}

	/**
	 * 断言user_group表数据
	 */
	public void assertUserGroup(UserGroupDO expect, UserGroupDO userGroupDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userGroupDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userGroupDO.getRawAddTime());
		expect.setRawAddTime(userGroupDO.getRawAddTime());
        Assertions.assertTrue(null != userGroupDO.getRawUpdateTime());
		expect.setRawUpdateTime(userGroupDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userGroupDO);
	}

    /**
	 * 插入user_group表数据
	 */
	public void insertUserGroup(UserGroupDO userGroupDO) {
		userGroupDAO.insert(userGroupDO);
	}

    /**
	 * 插入user_group表数据
	 */
	public void insertUserGroup(
			Long id, 
			String userGroupNo, 
			String partnerId, 
			String platPartnerId, 
			String name, 
			String userGroupType, 
			String filterRule, 
			Integer totalList, 
			String memo, 
			String ruleSetCode, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		UserGroupDO userGroupDO = new UserGroupDO();
		userGroupDO.setId(id);
		userGroupDO.setUserGroupNo(userGroupNo);
		userGroupDO.setPartnerId(partnerId);
		userGroupDO.setPlatPartnerId(platPartnerId);
		userGroupDO.setName(name);
		userGroupDO.setUserGroupType(userGroupType);
		userGroupDO.setFilterRule(filterRule);
		userGroupDO.setTotalList(totalList);
		userGroupDO.setMemo(memo);
		userGroupDO.setRuleSetCode(ruleSetCode);
		userGroupDO.setRawAddTime(rawAddTime);
		userGroupDO.setRawUpdateTime(rawUpdateTime);
		userGroupDAO.insert(userGroupDO);
	}

    /**
     * 删除user_group表所有数据
     */
    public void cleanUserGroup() {
        UserGroupDOExample exam = new UserGroupDOExample();
        exam.createCriteria();
        userGroupDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_group表数据
	 */
	public void cleanUserGroupById(Long id) {
		UserGroupDOExample exam = new UserGroupDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userGroupDAO.deleteByExample(exam);
	}

	/**
	 * 根据userGroupNo删除user_group表数据
	 */
	public void cleanUserGroupByUserGroupNo(String userGroupNo) {
        if (StringUtils.isBlank(userGroupNo)){
            userGroupNo = "test_userGroupNo";
        }
		UserGroupDOExample exam = new UserGroupDOExample();
		exam.createCriteria().andUserGroupNoEqualTo(userGroupNo);
		userGroupDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除user_group表数据
	 */
	public void cleanUserGroupByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		UserGroupDOExample exam = new UserGroupDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userGroupDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除user_group表数据
	 */
	public void cleanUserGroupByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		UserGroupDOExample exam = new UserGroupDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		userGroupDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除user_group表数据
	*/
	public void cleanUserGroupByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		UserGroupDOExample exam = new UserGroupDOExample();
		exam.createCriteria().andNameEqualTo(name);
		userGroupDAO.deleteByExample(exam);
	}

	/**
	* 根据ruleSetCode删除user_group表数据
	*/
	public void cleanUserGroupByRuleSetCode(String ruleSetCode) {
        if (StringUtils.isBlank(ruleSetCode)){
            ruleSetCode = "test_ruleSetCode";
        }
		UserGroupDOExample exam = new UserGroupDOExample();
		exam.createCriteria().andRuleSetCodeEqualTo(ruleSetCode);
		userGroupDAO.deleteByExample(exam);
	}

    /**
     * 查询user_group表所有数据
     */
    public List<UserGroupDO> findUserGroupAll() {
        UserGroupDOExample exam = new UserGroupDOExample();
        exam.createCriteria();
		return userGroupDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_group表数据
	 */
	public List<UserGroupDO> findUserGroupById(Long id) {
		UserGroupDOExample exam = new UserGroupDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userGroupDAO.selectByExample(exam);
	}

    /**
	 * 根据userGroupNo查询user_group表数据
	 */
	public List<UserGroupDO> findUserGroupByUserGroupNo(String userGroupNo) {
		UserGroupDOExample exam = new UserGroupDOExample();
		exam.createCriteria().andUserGroupNoEqualTo(userGroupNo);
		return userGroupDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询user_group表数据
	 */
	public List<UserGroupDO> findUserGroupByPartnerId(String partnerId) {
		UserGroupDOExample exam = new UserGroupDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return userGroupDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询user_group表数据
	 */
	public List<UserGroupDO> findUserGroupByPlatPartnerId(String platPartnerId) {
		UserGroupDOExample exam = new UserGroupDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return userGroupDAO.selectByExample(exam);
	}

	/**
	* 根据name查询user_group表数据
	*/
	public List<UserGroupDO> findUserGroupByName(String name) {
		UserGroupDOExample exam = new UserGroupDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return userGroupDAO.selectByExample(exam);
	}

	/**
	* 根据ruleSetCode查询user_group表数据
	*/
	public List<UserGroupDO> findUserGroupByRuleSetCode(String ruleSetCode) {
		UserGroupDOExample exam = new UserGroupDOExample();
		exam.createCriteria().andRuleSetCodeEqualTo(ruleSetCode);
		return userGroupDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_group表数据
	 */
	public void updateUserGroupById(Long id,UserGroupDO userGroupDO) {
		UserGroupDOExample exam = new UserGroupDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userGroupDAO.updateByExample(userGroupDO, exam);
	}

    /**
	 * 根据userGroupNo更新user_group表数据
	 */
	public void updateUserGroupByUserGroupNo(String userGroupNo,UserGroupDO userGroupDO) {
		UserGroupDOExample exam = new UserGroupDOExample();
		exam.createCriteria().andUserGroupNoEqualTo(userGroupNo);
		userGroupDAO.updateByExample(userGroupDO, exam);
	}

    /**
	 * 根据partnerId更新user_group表数据
	 */
	public void updateUserGroupByPartnerId(String partnerId,UserGroupDO userGroupDO) {
		UserGroupDOExample exam = new UserGroupDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		userGroupDAO.updateByExample(userGroupDO, exam);
	}

    /**
	 * 根据platPartnerId更新user_group表数据
	 */
	public void updateUserGroupByPlatPartnerId(String platPartnerId,UserGroupDO userGroupDO) {
		UserGroupDOExample exam = new UserGroupDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		userGroupDAO.updateByExample(userGroupDO, exam);
	}

	/**
	* 根据name更新user_group表数据
	*/
	public void updateUserGroupByName(String name,UserGroupDO userGroupDO) {
		UserGroupDOExample exam = new UserGroupDOExample();
		exam.createCriteria().andNameEqualTo(name);
		userGroupDAO.updateByExample(userGroupDO, exam);
	}

	/**
	* 根据ruleSetCode更新user_group表数据
	*/
	public void updateUserGroupByRuleSetCode(String ruleSetCode,UserGroupDO userGroupDO) {
		UserGroupDOExample exam = new UserGroupDOExample();
		exam.createCriteria().andRuleSetCodeEqualTo(ruleSetCode);
		userGroupDAO.updateByExample(userGroupDO, exam);
	}

    /**
	 * 断言user_group_list表
	 */
	public void userGroupListAssert(
	        UserGroupListDO userGroupListDO,
			Long id, 
			String userGroupNo, 
			String listType, 
			String realName, 
			String symbolNo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, userGroupListDO.getId());
        assertEquals(userGroupNo, userGroupListDO.getUserGroupNo());
        assertEquals(listType, userGroupListDO.getListType());
        assertEquals(realName, userGroupListDO.getRealName());
        assertEquals(symbolNo, userGroupListDO.getSymbolNo());
        assertEquals(rawAddTime, userGroupListDO.getRawAddTime());
        assertEquals(rawUpdateTime, userGroupListDO.getRawUpdateTime());
	}

	/**
	 * 断言user_group_list表数据
	 */
	public void assertUserGroupList(UserGroupListDO expect, UserGroupListDO userGroupListDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			userGroupListDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != userGroupListDO.getRawAddTime());
		expect.setRawAddTime(userGroupListDO.getRawAddTime());
        Assertions.assertTrue(null != userGroupListDO.getRawUpdateTime());
		expect.setRawUpdateTime(userGroupListDO.getRawUpdateTime());
		Assertions.assertEquals(expect, userGroupListDO);
	}

    /**
	 * 插入user_group_list表数据
	 */
	public void insertUserGroupList(UserGroupListDO userGroupListDO) {
		userGroupListDAO.insert(userGroupListDO);
	}

    /**
	 * 插入user_group_list表数据
	 */
	public void insertUserGroupList(
			Long id, 
			String userGroupNo, 
			String listType, 
			String realName, 
			String symbolNo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		UserGroupListDO userGroupListDO = new UserGroupListDO();
		userGroupListDO.setId(id);
		userGroupListDO.setUserGroupNo(userGroupNo);
		userGroupListDO.setListType(listType);
		userGroupListDO.setRealName(realName);
		userGroupListDO.setSymbolNo(symbolNo);
		userGroupListDO.setRawAddTime(rawAddTime);
		userGroupListDO.setRawUpdateTime(rawUpdateTime);
		userGroupListDAO.insert(userGroupListDO);
	}

    /**
     * 删除user_group_list表所有数据
     */
    public void cleanUserGroupList() {
        UserGroupListDOExample exam = new UserGroupListDOExample();
        exam.createCriteria();
        userGroupListDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除user_group_list表数据
	 */
	public void cleanUserGroupListById(Long id) {
		UserGroupListDOExample exam = new UserGroupListDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userGroupListDAO.deleteByExample(exam);
	}

	/**
	 * 根据userGroupNo删除user_group_list表数据
	 */
	public void cleanUserGroupListByUserGroupNo(String userGroupNo) {
        if (StringUtils.isBlank(userGroupNo)){
            userGroupNo = "test_userGroupNo";
        }
		UserGroupListDOExample exam = new UserGroupListDOExample();
		exam.createCriteria().andUserGroupNoEqualTo(userGroupNo);
		userGroupListDAO.deleteByExample(exam);
	}

	/**
	* 根据realName删除user_group_list表数据
	*/
	public void cleanUserGroupListByRealName(String realName) {
        if (StringUtils.isBlank(realName)){
            realName = "test_realName";
        }
		UserGroupListDOExample exam = new UserGroupListDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		userGroupListDAO.deleteByExample(exam);
	}

	/**
	 * 根据symbolNo删除user_group_list表数据
	 */
	public void cleanUserGroupListBySymbolNo(String symbolNo) {
        if (StringUtils.isBlank(symbolNo)){
            symbolNo = "test_symbolNo";
        }
		UserGroupListDOExample exam = new UserGroupListDOExample();
		exam.createCriteria().andSymbolNoEqualTo(symbolNo);
		userGroupListDAO.deleteByExample(exam);
	}

    /**
     * 查询user_group_list表所有数据
     */
    public List<UserGroupListDO> findUserGroupListAll() {
        UserGroupListDOExample exam = new UserGroupListDOExample();
        exam.createCriteria();
		return userGroupListDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询user_group_list表数据
	 */
	public List<UserGroupListDO> findUserGroupListById(Long id) {
		UserGroupListDOExample exam = new UserGroupListDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return userGroupListDAO.selectByExample(exam);
	}

    /**
	 * 根据userGroupNo查询user_group_list表数据
	 */
	public List<UserGroupListDO> findUserGroupListByUserGroupNo(String userGroupNo) {
		UserGroupListDOExample exam = new UserGroupListDOExample();
		exam.createCriteria().andUserGroupNoEqualTo(userGroupNo);
		return userGroupListDAO.selectByExample(exam);
	}

	/**
	* 根据realName查询user_group_list表数据
	*/
	public List<UserGroupListDO> findUserGroupListByRealName(String realName) {
		UserGroupListDOExample exam = new UserGroupListDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		return userGroupListDAO.selectByExample(exam);
	}

    /**
	 * 根据symbolNo查询user_group_list表数据
	 */
	public List<UserGroupListDO> findUserGroupListBySymbolNo(String symbolNo) {
		UserGroupListDOExample exam = new UserGroupListDOExample();
		exam.createCriteria().andSymbolNoEqualTo(symbolNo);
		return userGroupListDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新user_group_list表数据
	 */
	public void updateUserGroupListById(Long id,UserGroupListDO userGroupListDO) {
		UserGroupListDOExample exam = new UserGroupListDOExample();
		exam.createCriteria().andIdEqualTo(id);
		userGroupListDAO.updateByExample(userGroupListDO, exam);
	}

    /**
	 * 根据userGroupNo更新user_group_list表数据
	 */
	public void updateUserGroupListByUserGroupNo(String userGroupNo,UserGroupListDO userGroupListDO) {
		UserGroupListDOExample exam = new UserGroupListDOExample();
		exam.createCriteria().andUserGroupNoEqualTo(userGroupNo);
		userGroupListDAO.updateByExample(userGroupListDO, exam);
	}

	/**
	* 根据realName更新user_group_list表数据
	*/
	public void updateUserGroupListByRealName(String realName,UserGroupListDO userGroupListDO) {
		UserGroupListDOExample exam = new UserGroupListDOExample();
		exam.createCriteria().andRealNameEqualTo(realName);
		userGroupListDAO.updateByExample(userGroupListDO, exam);
	}

    /**
	 * 根据symbolNo更新user_group_list表数据
	 */
	public void updateUserGroupListBySymbolNo(String symbolNo,UserGroupListDO userGroupListDO) {
		UserGroupListDOExample exam = new UserGroupListDOExample();
		exam.createCriteria().andSymbolNoEqualTo(symbolNo);
		userGroupListDAO.updateByExample(userGroupListDO, exam);
	}
}
