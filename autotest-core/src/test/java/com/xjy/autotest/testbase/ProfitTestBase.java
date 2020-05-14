package com.xjy.autotest.testbase;

import com.xjy.autotest.config.ProfitDataSourceConfig;
import com.xjy.autotest.utils.DateUtils;
import dal.dao.profit.*;
import dal.model.profit.*;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author autotest
 * Created on 2018/07/13.
 */
@Service
@Import({
        ProfitDataSourceConfig.class
})
public class ProfitTestBase {

	@Autowired
	ActionExecuteRecordDAO actionExecuteRecordDAO;

	@Autowired
	ActionItemDAO actionItemDAO;

	@Autowired
	ActionStrategyDAO actionStrategyDAO;

	@Autowired
	ConditionItemDAO conditionItemDAO;

	@Autowired
	ConditionStrategyDAO conditionStrategyDAO;

	@Autowired
	CronTaskDAO cronTaskDAO;

	@Autowired
	ProfitOrderDAO profitOrderDAO;

	@Autowired
	ProfitRefundDAO profitRefundDAO;

	@Autowired
	RefundExecuteRecordDAO refundExecuteRecordDAO;

	@Autowired
	RuleDAO ruleDAO;

	@Autowired
	TaskExecuteRecordDAO taskExecuteRecordDAO;

	public ActionExecuteRecordDAO getActionExecuteRecordDAO() {
		return this.actionExecuteRecordDAO;
	}

	public ActionItemDAO getActionItemDAO() {
		return this.actionItemDAO;
	}

	public ActionStrategyDAO getActionStrategyDAO() {
		return this.actionStrategyDAO;
	}

	public ConditionItemDAO getConditionItemDAO() {
		return this.conditionItemDAO;
	}

	public ConditionStrategyDAO getConditionStrategyDAO() {
		return this.conditionStrategyDAO;
	}

	public CronTaskDAO getCronTaskDAO() {
		return this.cronTaskDAO;
	}

	public ProfitOrderDAO getProfitOrderDAO() {
		return this.profitOrderDAO;
	}

	public ProfitRefundDAO getProfitRefundDAO() {
		return this.profitRefundDAO;
	}

	public RefundExecuteRecordDAO getRefundExecuteRecordDAO() {
		return this.refundExecuteRecordDAO;
	}

	public RuleDAO getRuleDAO() {
		return this.ruleDAO;
	}

	public TaskExecuteRecordDAO getTaskExecuteRecordDAO() {
		return this.taskExecuteRecordDAO;
	}


	/**
	 * 断言action_execute_record表数据
	 */
	public void assertActionExecuteRecord(ActionExecuteRecordDO expect, ActionExecuteRecordDO actionExecuteRecordDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			actionExecuteRecordDO.setId(expect.getId());
		}
		Assertions.assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd"), DateUtils.formatDate
				(actionExecuteRecordDO.getRawAddTime(), "yyyy-MM-dd"));
		expect.setRawAddTime(actionExecuteRecordDO.getRawAddTime());
		Assertions.assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd"), DateUtils.formatDate
				(actionExecuteRecordDO.getRawUpdateTime(), "yyyy-MM-dd"));
		expect.setRawUpdateTime(actionExecuteRecordDO.getRawUpdateTime());
		Assertions.assertEquals(expect, actionExecuteRecordDO);
	}

    /**
	 * 插入action_execute_record表数据
	 */
	public void insertActionExecuteRecord(ActionExecuteRecordDO actionExecuteRecordDO) {
		actionExecuteRecordDAO.insert(actionExecuteRecordDO);
	}

    /**
	 * 插入action_execute_record表数据
	 */
	public void insertActionExecuteRecord(
			long id, 
			long taskRecordId, 
			String outOrderNo, 
			String source, 
			String termini, 
			Integer sequence, 
			long amount, 
			String state, 
			String memo, 
			String reqId, 
			String gid, 
			String partnerId, 
			String merchOrderNo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ActionExecuteRecordDO actionExecuteRecordDO = new ActionExecuteRecordDO();
		actionExecuteRecordDO.setId(id);
		actionExecuteRecordDO.setTaskRecordId(taskRecordId);
		actionExecuteRecordDO.setOutOrderNo(outOrderNo);
		actionExecuteRecordDO.setSource(source);
		actionExecuteRecordDO.setTermini(termini);
		actionExecuteRecordDO.setSequence(sequence);
		actionExecuteRecordDO.setAmount(amount);
		actionExecuteRecordDO.setState(state);
		actionExecuteRecordDO.setMemo(memo);
		actionExecuteRecordDO.setReqId(reqId);
		actionExecuteRecordDO.setGid(gid);
		actionExecuteRecordDO.setPartnerId(partnerId);
		actionExecuteRecordDO.setMerchOrderNo(merchOrderNo);
		actionExecuteRecordDO.setRawAddTime(rawAddTime);
		actionExecuteRecordDO.setRawUpdateTime(rawUpdateTime);
		actionExecuteRecordDAO.insert(actionExecuteRecordDO);
	}
	

	/**
	 * 根据id删除action_execute_record表数据
	 */
	public void cleanActionExecuteRecordById(long id) {
		ActionExecuteRecordDOExample exam = new ActionExecuteRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		actionExecuteRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据taskRecordId删除action_execute_record表数据
	 */
	public void cleanActionExecuteRecordByTaskRecordId(long taskRecordId) {
		ActionExecuteRecordDOExample exam = new ActionExecuteRecordDOExample();
		exam.createCriteria().andTaskRecordIdEqualTo(taskRecordId);
		actionExecuteRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据outOrderNo删除action_execute_record表数据
	 */
	public void cleanActionExecuteRecordByOutOrderNo(String outOrderNo) {
		if (StringUtils.isBlank(outOrderNo)){
			outOrderNo = "test_outOrderNo";
		}
		ActionExecuteRecordDOExample exam = new ActionExecuteRecordDOExample();
		exam.createCriteria().andOutOrderNoEqualTo(outOrderNo);
		actionExecuteRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除action_execute_record表数据
	 */
	public void cleanActionExecuteRecordByReqId(String reqId) {
		if (StringUtils.isBlank(reqId)){
			reqId = "test_reqId";
		}
		ActionExecuteRecordDOExample exam = new ActionExecuteRecordDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		actionExecuteRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除action_execute_record表数据
	 */
	public void cleanActionExecuteRecordByGid(String gid) {
		if (StringUtils.isBlank(gid)){
			gid = "test_gid";
		}
		ActionExecuteRecordDOExample exam = new ActionExecuteRecordDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		actionExecuteRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除action_execute_record表数据
	 */
	public void cleanActionExecuteRecordByPartnerId(String partnerId) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		ActionExecuteRecordDOExample exam = new ActionExecuteRecordDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		actionExecuteRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchOrderNo删除action_execute_record表数据
	 */
	public void cleanActionExecuteRecordByMerchOrderNo(String merchOrderNo) {
		if (StringUtils.isBlank(merchOrderNo)){
			merchOrderNo = "test_merchOrderNo";
		}
		ActionExecuteRecordDOExample exam = new ActionExecuteRecordDOExample();
		exam.createCriteria().andMerchOrderNoEqualTo(merchOrderNo);
		actionExecuteRecordDAO.deleteByExample(exam);
	}


    /**
	 * 根据id查询action_execute_record表数据
	 */
	public List<ActionExecuteRecordDO> findActionExecuteRecordById(long id) {
		ActionExecuteRecordDOExample exam = new ActionExecuteRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return actionExecuteRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据taskRecordId查询action_execute_record表数据
	 */
	public List<ActionExecuteRecordDO> findActionExecuteRecordByTaskRecordId(long taskRecordId) {
		ActionExecuteRecordDOExample exam = new ActionExecuteRecordDOExample();
		exam.createCriteria().andTaskRecordIdEqualTo(taskRecordId);
		return actionExecuteRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据outOrderNo查询action_execute_record表数据
	 */
	public List<ActionExecuteRecordDO> findActionExecuteRecordByOutOrderNo(String outOrderNo) {
		if (StringUtils.isBlank(outOrderNo)){
			outOrderNo = "test_outOrderNo";
		}
		ActionExecuteRecordDOExample exam = new ActionExecuteRecordDOExample();
		exam.createCriteria().andOutOrderNoEqualTo(outOrderNo);
		return actionExecuteRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询action_execute_record表数据
	 */
	public List<ActionExecuteRecordDO> findActionExecuteRecordByReqId(String reqId) {
		if (StringUtils.isBlank(reqId)){
			reqId = "test_reqId";
		}
		ActionExecuteRecordDOExample exam = new ActionExecuteRecordDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return actionExecuteRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询action_execute_record表数据
	 */
	public List<ActionExecuteRecordDO> findActionExecuteRecordByGid(String gid) {
		if (StringUtils.isBlank(gid)){
			gid = "test_gid";
		}
		ActionExecuteRecordDOExample exam = new ActionExecuteRecordDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return actionExecuteRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询action_execute_record表数据
	 */
	public List<ActionExecuteRecordDO> findActionExecuteRecordByPartnerId(String partnerId) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		ActionExecuteRecordDOExample exam = new ActionExecuteRecordDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return actionExecuteRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据merchOrderNo查询action_execute_record表数据
	 */
	public List<ActionExecuteRecordDO> findActionExecuteRecordByMerchOrderNo(String merchOrderNo) {
		if (StringUtils.isBlank(merchOrderNo)){
			merchOrderNo = "test_merchOrderNo";
		}
		ActionExecuteRecordDOExample exam = new ActionExecuteRecordDOExample();
		exam.createCriteria().andMerchOrderNoEqualTo(merchOrderNo);
		return actionExecuteRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新action_execute_record表数据
	 */
	public void updateActionExecuteRecordById(long id,ActionExecuteRecordDO actionExecuteRecordDO) {
		ActionExecuteRecordDOExample exam = new ActionExecuteRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		actionExecuteRecordDAO.updateByExample(actionExecuteRecordDO, exam);
	}

    /**
	 * 根据taskRecordId更新action_execute_record表数据
	 */
	public void updateActionExecuteRecordByTaskRecordId(long taskRecordId,ActionExecuteRecordDO actionExecuteRecordDO) {
		ActionExecuteRecordDOExample exam = new ActionExecuteRecordDOExample();
		exam.createCriteria().andTaskRecordIdEqualTo(taskRecordId);
		actionExecuteRecordDAO.updateByExample(actionExecuteRecordDO, exam);
	}

    /**
	 * 根据outOrderNo更新action_execute_record表数据
	 */
	public void updateActionExecuteRecordByOutOrderNo(String outOrderNo,ActionExecuteRecordDO actionExecuteRecordDO) {
		if (StringUtils.isBlank(outOrderNo)){
			outOrderNo = "test_outOrderNo";
		}
		ActionExecuteRecordDOExample exam = new ActionExecuteRecordDOExample();
		exam.createCriteria().andOutOrderNoEqualTo(outOrderNo);
		actionExecuteRecordDAO.updateByExample(actionExecuteRecordDO, exam);
	}

    /**
	 * 根据reqId更新action_execute_record表数据
	 */
	public void updateActionExecuteRecordByReqId(String reqId,ActionExecuteRecordDO actionExecuteRecordDO) {
		if (StringUtils.isBlank(reqId)){
			reqId = "test_reqId";
		}
		ActionExecuteRecordDOExample exam = new ActionExecuteRecordDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		actionExecuteRecordDAO.updateByExample(actionExecuteRecordDO, exam);
	}

    /**
	 * 根据gid更新action_execute_record表数据
	 */
	public void updateActionExecuteRecordByGid(String gid,ActionExecuteRecordDO actionExecuteRecordDO) {
		if (StringUtils.isBlank(gid)){
			gid = "test_gid";
		}
		ActionExecuteRecordDOExample exam = new ActionExecuteRecordDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		actionExecuteRecordDAO.updateByExample(actionExecuteRecordDO, exam);
	}

    /**
	 * 根据partnerId更新action_execute_record表数据
	 */
	public void updateActionExecuteRecordByPartnerId(String partnerId,ActionExecuteRecordDO actionExecuteRecordDO) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		ActionExecuteRecordDOExample exam = new ActionExecuteRecordDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		actionExecuteRecordDAO.updateByExample(actionExecuteRecordDO, exam);
	}

    /**
	 * 根据merchOrderNo更新action_execute_record表数据
	 */
	public void updateActionExecuteRecordByMerchOrderNo(String merchOrderNo,ActionExecuteRecordDO actionExecuteRecordDO) {
		if (StringUtils.isBlank(merchOrderNo)){
			merchOrderNo = "test_merchOrderNo";
		}
		ActionExecuteRecordDOExample exam = new ActionExecuteRecordDOExample();
		exam.createCriteria().andMerchOrderNoEqualTo(merchOrderNo);
		actionExecuteRecordDAO.updateByExample(actionExecuteRecordDO, exam);
	}

	/**
	 * 断言action_item表数据
	 */
	public void assertActionItem(ActionItemDO expect, ActionItemDO actionItemDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			actionItemDO.setId(expect.getId());
		}
		Assertions.assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd"), DateUtils.formatDate
				(actionItemDO.getRawAddTime(), "yyyy-MM-dd"));
		expect.setRawAddTime(actionItemDO.getRawAddTime());
		Assertions.assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd"), DateUtils.formatDate
				(actionItemDO.getRawUpdateTime(), "yyyy-MM-dd"));
		expect.setRawUpdateTime(actionItemDO.getRawUpdateTime());
		Assertions.assertEquals(expect, actionItemDO);
	}

    /**
	 * 插入action_item表数据
	 */
	public void insertActionItem(ActionItemDO actionItemDO) {
		actionItemDAO.insert(actionItemDO);
	}

    /**
	 * 插入action_item表数据
	 */
	public void insertActionItem(
			long id, 
			String source, 
			String termini, 
			String actionExpr, 
			String alg, 
			Integer sequence, 
			long actionStrategyId, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String serialExpr
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ActionItemDO actionItemDO = new ActionItemDO();
		actionItemDO.setId(id);
		actionItemDO.setSource(source);
		actionItemDO.setTermini(termini);
		actionItemDO.setActionExpr(actionExpr);
		actionItemDO.setAlg(alg);
		actionItemDO.setSequence(sequence);
		actionItemDO.setActionStrategyId(actionStrategyId);
		actionItemDO.setRawAddTime(rawAddTime);
		actionItemDO.setRawUpdateTime(rawUpdateTime);
		actionItemDO.setSerialExpr(serialExpr);
		actionItemDAO.insert(actionItemDO);
	}
	

	/**
	 * 根据id删除action_item表数据
	 */
	public void cleanActionItemById(long id) {
		ActionItemDOExample exam = new ActionItemDOExample();
		exam.createCriteria().andIdEqualTo(id);
		actionItemDAO.deleteByExample(exam);
	}

	/**
	 * 根据actionStrategyId删除action_item表数据
	 */
	public void cleanActionItemByActionStrategyId(long actionStrategyId) {
		ActionItemDOExample exam = new ActionItemDOExample();
		exam.createCriteria().andActionStrategyIdEqualTo(actionStrategyId);
		actionItemDAO.deleteByExample(exam);
	}


    /**
	 * 根据id查询action_item表数据
	 */
	public List<ActionItemDO> findActionItemById(long id) {
		ActionItemDOExample exam = new ActionItemDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return actionItemDAO.selectByExample(exam);
	}

    /**
	 * 根据actionStrategyId查询action_item表数据
	 */
	public List<ActionItemDO> findActionItemByActionStrategyId(long actionStrategyId) {
		ActionItemDOExample exam = new ActionItemDOExample();
		exam.createCriteria().andActionStrategyIdEqualTo(actionStrategyId);
		return actionItemDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新action_item表数据
	 */
	public void updateActionItemById(long id,ActionItemDO actionItemDO) {
		ActionItemDOExample exam = new ActionItemDOExample();
		exam.createCriteria().andIdEqualTo(id);
		actionItemDAO.updateByExample(actionItemDO, exam);
	}

    /**
	 * 根据actionStrategyId更新action_item表数据
	 */
	public void updateActionItemByActionStrategyId(long actionStrategyId,ActionItemDO actionItemDO) {
		ActionItemDOExample exam = new ActionItemDOExample();
		exam.createCriteria().andActionStrategyIdEqualTo(actionStrategyId);
		actionItemDAO.updateByExample(actionItemDO, exam);
	}

	/**
	 * 断言action_strategy表数据
	 */
	public void assertActionStrategy(ActionStrategyDO expect, ActionStrategyDO actionStrategyDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			actionStrategyDO.setId(expect.getId());
		}
		Assertions.assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd"), DateUtils.formatDate
				(actionStrategyDO.getRawAddTime(), "yyyy-MM-dd"));
		expect.setRawAddTime(actionStrategyDO.getRawAddTime());
		Assertions.assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd"), DateUtils.formatDate
				(actionStrategyDO.getRawUpdateTime(), "yyyy-MM-dd"));
		expect.setRawUpdateTime(actionStrategyDO.getRawUpdateTime());
		Assertions.assertEquals(expect, actionStrategyDO);
	}

    /**
	 * 插入action_strategy表数据
	 */
	public void insertActionStrategy(ActionStrategyDO actionStrategyDO) {
		actionStrategyDAO.insert(actionStrategyDO);
	}

    /**
	 * 插入action_strategy表数据
	 */
	public void insertActionStrategy(
			long id, 
			String state, 
			String type, 
			long conditionStrategyId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ActionStrategyDO actionStrategyDO = new ActionStrategyDO();
		actionStrategyDO.setId(id);
		actionStrategyDO.setState(state);
		actionStrategyDO.setType(type);
		actionStrategyDO.setConditionStrategyId(conditionStrategyId);
		actionStrategyDO.setRawAddTime(rawAddTime);
		actionStrategyDO.setRawUpdateTime(rawUpdateTime);
		actionStrategyDAO.insert(actionStrategyDO);
	}
	

	/**
	 * 根据id删除action_strategy表数据
	 */
	public void cleanActionStrategyById(long id) {
		ActionStrategyDOExample exam = new ActionStrategyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		actionStrategyDAO.deleteByExample(exam);
	}

	/**
	 * 根据conditionStrategyId删除action_strategy表数据
	 */
	public void cleanActionStrategyByConditionStrategyId(long conditionStrategyId) {
		ActionStrategyDOExample exam = new ActionStrategyDOExample();
		exam.createCriteria().andConditionStrategyIdEqualTo(conditionStrategyId);
		actionStrategyDAO.deleteByExample(exam);
	}


    /**
	 * 根据id查询action_strategy表数据
	 */
	public List<ActionStrategyDO> findActionStrategyById(long id) {
		ActionStrategyDOExample exam = new ActionStrategyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return actionStrategyDAO.selectByExample(exam);
	}

    /**
	 * 根据conditionStrategyId查询action_strategy表数据
	 */
	public List<ActionStrategyDO> findActionStrategyByConditionStrategyId(long conditionStrategyId) {
		ActionStrategyDOExample exam = new ActionStrategyDOExample();
		exam.createCriteria().andConditionStrategyIdEqualTo(conditionStrategyId);
		return actionStrategyDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新action_strategy表数据
	 */
	public void updateActionStrategyById(long id,ActionStrategyDO actionStrategyDO) {
		ActionStrategyDOExample exam = new ActionStrategyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		actionStrategyDAO.updateByExample(actionStrategyDO, exam);
	}

    /**
	 * 根据conditionStrategyId更新action_strategy表数据
	 */
	public void updateActionStrategyByConditionStrategyId(long conditionStrategyId,ActionStrategyDO actionStrategyDO) {
		ActionStrategyDOExample exam = new ActionStrategyDOExample();
		exam.createCriteria().andConditionStrategyIdEqualTo(conditionStrategyId);
		actionStrategyDAO.updateByExample(actionStrategyDO, exam);
	}

	/**
	 * 断言condition_item表数据
	 */
	public void assertConditionItem(ConditionItemDO expect, ConditionItemDO conditionItemDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			conditionItemDO.setId(expect.getId());
		}
		Assertions.assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd"), DateUtils.formatDate
				(conditionItemDO.getRawAddTime(), "yyyy-MM-dd"));
		expect.setRawAddTime(conditionItemDO.getRawAddTime());
		Assertions.assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd"), DateUtils.formatDate
				(conditionItemDO.getRawUpdateTime(), "yyyy-MM-dd"));
		expect.setRawUpdateTime(conditionItemDO.getRawUpdateTime());
		Assertions.assertEquals(expect, conditionItemDO);
	}

    /**
	 * 插入condition_item表数据
	 */
	public void insertConditionItem(ConditionItemDO conditionItemDO) {
		conditionItemDAO.insert(conditionItemDO);
	}

    /**
	 * 插入condition_item表数据
	 */
	public void insertConditionItem(
			long id, 
			String variable, 
			String symbol, 
			String valueExpr, 
			String state, 
			long conditionStrategyId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ConditionItemDO conditionItemDO = new ConditionItemDO();
		conditionItemDO.setId(id);
		conditionItemDO.setVariable(variable);
		conditionItemDO.setSymbol(symbol);
		conditionItemDO.setValueExpr(valueExpr);
		conditionItemDO.setState(state);
		conditionItemDO.setConditionStrategyId(conditionStrategyId);
		conditionItemDO.setRawAddTime(rawAddTime);
		conditionItemDO.setRawUpdateTime(rawUpdateTime);
		conditionItemDAO.insert(conditionItemDO);
	}
	

	/**
	 * 根据id删除condition_item表数据
	 */
	public void cleanConditionItemById(long id) {
		ConditionItemDOExample exam = new ConditionItemDOExample();
		exam.createCriteria().andIdEqualTo(id);
		conditionItemDAO.deleteByExample(exam);
	}

	/**
	 * 根据conditionStrategyId删除condition_item表数据
	 */
	public void cleanConditionItemByConditionStrategyId(long conditionStrategyId) {
		ConditionItemDOExample exam = new ConditionItemDOExample();
		exam.createCriteria().andConditionStrategyIdEqualTo(conditionStrategyId);
		conditionItemDAO.deleteByExample(exam);
	}


    /**
	 * 根据id查询condition_item表数据
	 */
	public List<ConditionItemDO> findConditionItemById(long id) {
		ConditionItemDOExample exam = new ConditionItemDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return conditionItemDAO.selectByExample(exam);
	}

    /**
	 * 根据conditionStrategyId查询condition_item表数据
	 */
	public List<ConditionItemDO> findConditionItemByConditionStrategyId(long conditionStrategyId) {
		ConditionItemDOExample exam = new ConditionItemDOExample();
		exam.createCriteria().andConditionStrategyIdEqualTo(conditionStrategyId);
		return conditionItemDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新condition_item表数据
	 */
	public void updateConditionItemById(long id,ConditionItemDO conditionItemDO) {
		ConditionItemDOExample exam = new ConditionItemDOExample();
		exam.createCriteria().andIdEqualTo(id);
		conditionItemDAO.updateByExample(conditionItemDO, exam);
	}

    /**
	 * 根据conditionStrategyId更新condition_item表数据
	 */
	public void updateConditionItemByConditionStrategyId(long conditionStrategyId,ConditionItemDO conditionItemDO) {
		ConditionItemDOExample exam = new ConditionItemDOExample();
		exam.createCriteria().andConditionStrategyIdEqualTo(conditionStrategyId);
		conditionItemDAO.updateByExample(conditionItemDO, exam);
	}

	/**
	 * 断言condition_strategy表数据
	 */
	public void assertConditionStrategy(ConditionStrategyDO expect, ConditionStrategyDO conditionStrategyDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			conditionStrategyDO.setId(expect.getId());
		}
		Assertions.assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd"), DateUtils.formatDate
				(conditionStrategyDO.getRawAddTime(), "yyyy-MM-dd"));
		expect.setRawAddTime(conditionStrategyDO.getRawAddTime());
		Assertions.assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd"), DateUtils.formatDate
				(conditionStrategyDO.getRawUpdateTime(), "yyyy-MM-dd"));
		expect.setRawUpdateTime(conditionStrategyDO.getRawUpdateTime());
		Assertions.assertEquals(expect, conditionStrategyDO);
	}

    /**
	 * 插入condition_strategy表数据
	 */
	public void insertConditionStrategy(ConditionStrategyDO conditionStrategyDO) {
		conditionStrategyDAO.insert(conditionStrategyDO);
	}

    /**
	 * 插入condition_strategy表数据
	 */
	public void insertConditionStrategy(
			long id, 
			Integer priority, 
			String type, 
			String cronExpress, 
			String conditionExpress, 
			String state, 
			long ruleId, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String serialExpress
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ConditionStrategyDO conditionStrategyDO = new ConditionStrategyDO();
		conditionStrategyDO.setId(id);
		conditionStrategyDO.setPriority(priority);
		conditionStrategyDO.setType(type);
		conditionStrategyDO.setCronExpress(cronExpress);
		conditionStrategyDO.setConditionExpress(conditionExpress);
		conditionStrategyDO.setState(state);
		conditionStrategyDO.setRuleId(ruleId);
		conditionStrategyDO.setRawAddTime(rawAddTime);
		conditionStrategyDO.setRawUpdateTime(rawUpdateTime);
		conditionStrategyDO.setSerialExpress(serialExpress);
		conditionStrategyDAO.insert(conditionStrategyDO);
	}
	

	/**
	 * 根据id删除condition_strategy表数据
	 */
	public void cleanConditionStrategyById(long id) {
		ConditionStrategyDOExample exam = new ConditionStrategyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		conditionStrategyDAO.deleteByExample(exam);
	}

	/**
	 * 根据ruleId删除condition_strategy表数据
	 */
	public void cleanConditionStrategyByRuleId(long ruleId) {
		ConditionStrategyDOExample exam = new ConditionStrategyDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		conditionStrategyDAO.deleteByExample(exam);
	}


    /**
	 * 根据id查询condition_strategy表数据
	 */
	public List<ConditionStrategyDO> findConditionStrategyById(long id) {
		ConditionStrategyDOExample exam = new ConditionStrategyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return conditionStrategyDAO.selectByExample(exam);
	}

    /**
	 * 根据ruleId查询condition_strategy表数据
	 */
	public List<ConditionStrategyDO> findConditionStrategyByRuleId(long ruleId) {
		ConditionStrategyDOExample exam = new ConditionStrategyDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		return conditionStrategyDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新condition_strategy表数据
	 */
	public void updateConditionStrategyById(long id,ConditionStrategyDO conditionStrategyDO) {
		ConditionStrategyDOExample exam = new ConditionStrategyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		conditionStrategyDAO.updateByExample(conditionStrategyDO, exam);
	}

    /**
	 * 根据ruleId更新condition_strategy表数据
	 */
	public void updateConditionStrategyByRuleId(long ruleId,ConditionStrategyDO conditionStrategyDO) {
		ConditionStrategyDOExample exam = new ConditionStrategyDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		conditionStrategyDAO.updateByExample(conditionStrategyDO, exam);
	}

	/**
	 * 断言cron_task表数据
	 */
	public void assertCronTask(CronTaskDO expect, CronTaskDO cronTaskDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			cronTaskDO.setId(expect.getId());
		}
		Assertions.assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd"), DateUtils.formatDate
				(cronTaskDO.getRawAddTime(), "yyyy-MM-dd"));
		expect.setRawAddTime(cronTaskDO.getRawAddTime());
		Assertions.assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd"), DateUtils.formatDate
				(cronTaskDO.getRawUpdateTime(), "yyyy-MM-dd"));
		expect.setRawUpdateTime(cronTaskDO.getRawUpdateTime());
		Assertions.assertEquals(expect, cronTaskDO);
	}

    /**
	 * 插入cron_task表数据
	 */
	public void insertCronTask(CronTaskDO cronTaskDO) {
		cronTaskDAO.insert(cronTaskDO);
	}

    /**
	 * 插入cron_task表数据
	 */
	public void insertCronTask(
			long id, 
			Date nextScheduleTime, 
			Date lastScheduleTime, 
			long ruleId, 
			long conditionStrategyId, 
			long actionStrategyId, 
			String state, 
			String executeState, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (nextScheduleTime == null) {
			nextScheduleTime = new Date();
		}
		if (lastScheduleTime == null) {
			lastScheduleTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		CronTaskDO cronTaskDO = new CronTaskDO();
		cronTaskDO.setId(id);
		cronTaskDO.setNextScheduleTime(nextScheduleTime);
		cronTaskDO.setLastScheduleTime(lastScheduleTime);
		cronTaskDO.setRuleId(ruleId);
		cronTaskDO.setConditionStrategyId(conditionStrategyId);
		cronTaskDO.setActionStrategyId(actionStrategyId);
		cronTaskDO.setState(state);
		cronTaskDO.setExecuteState(executeState);
		cronTaskDO.setRawAddTime(rawAddTime);
		cronTaskDO.setRawUpdateTime(rawUpdateTime);
		cronTaskDAO.insert(cronTaskDO);
	}
	

	/**
	 * 根据id删除cron_task表数据
	 */
	public void cleanCronTaskById(long id) {
		CronTaskDOExample exam = new CronTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		cronTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据ruleId删除cron_task表数据
	 */
	public void cleanCronTaskByRuleId(long ruleId) {
		CronTaskDOExample exam = new CronTaskDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		cronTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据conditionStrategyId删除cron_task表数据
	 */
	public void cleanCronTaskByConditionStrategyId(long conditionStrategyId) {
		CronTaskDOExample exam = new CronTaskDOExample();
		exam.createCriteria().andConditionStrategyIdEqualTo(conditionStrategyId);
		cronTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据actionStrategyId删除cron_task表数据
	 */
	public void cleanCronTaskByActionStrategyId(long actionStrategyId) {
		CronTaskDOExample exam = new CronTaskDOExample();
		exam.createCriteria().andActionStrategyIdEqualTo(actionStrategyId);
		cronTaskDAO.deleteByExample(exam);
	}


    /**
	 * 根据id查询cron_task表数据
	 */
	public List<CronTaskDO> findCronTaskById(long id) {
		CronTaskDOExample exam = new CronTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return cronTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据ruleId查询cron_task表数据
	 */
	public List<CronTaskDO> findCronTaskByRuleId(long ruleId) {
		CronTaskDOExample exam = new CronTaskDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		return cronTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据conditionStrategyId查询cron_task表数据
	 */
	public List<CronTaskDO> findCronTaskByConditionStrategyId(long conditionStrategyId) {
		CronTaskDOExample exam = new CronTaskDOExample();
		exam.createCriteria().andConditionStrategyIdEqualTo(conditionStrategyId);
		return cronTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据actionStrategyId查询cron_task表数据
	 */
	public List<CronTaskDO> findCronTaskByActionStrategyId(long actionStrategyId) {
		CronTaskDOExample exam = new CronTaskDOExample();
		exam.createCriteria().andActionStrategyIdEqualTo(actionStrategyId);
		return cronTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新cron_task表数据
	 */
	public void updateCronTaskById(long id,CronTaskDO cronTaskDO) {
		CronTaskDOExample exam = new CronTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		cronTaskDAO.updateByExample(cronTaskDO, exam);
	}

    /**
	 * 根据ruleId更新cron_task表数据
	 */
	public void updateCronTaskByRuleId(long ruleId,CronTaskDO cronTaskDO) {
		CronTaskDOExample exam = new CronTaskDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		cronTaskDAO.updateByExample(cronTaskDO, exam);
	}

    /**
	 * 根据conditionStrategyId更新cron_task表数据
	 */
	public void updateCronTaskByConditionStrategyId(long conditionStrategyId,CronTaskDO cronTaskDO) {
		CronTaskDOExample exam = new CronTaskDOExample();
		exam.createCriteria().andConditionStrategyIdEqualTo(conditionStrategyId);
		cronTaskDAO.updateByExample(cronTaskDO, exam);
	}

    /**
	 * 根据actionStrategyId更新cron_task表数据
	 */
	public void updateCronTaskByActionStrategyId(long actionStrategyId,CronTaskDO cronTaskDO) {
		CronTaskDOExample exam = new CronTaskDOExample();
		exam.createCriteria().andActionStrategyIdEqualTo(actionStrategyId);
		cronTaskDAO.updateByExample(cronTaskDO, exam);
	}

	/**
	 * 断言profit_order表数据
	 */
	public void assertProfitOrder(ProfitOrderDO expect, ProfitOrderDO profitOrderDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			profitOrderDO.setId(expect.getId());
		}
		Assertions.assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd"), DateUtils.formatDate
				(profitOrderDO.getRawAddTime(), "yyyy-MM-dd"));
		expect.setRawAddTime(profitOrderDO.getRawAddTime());
		Assertions.assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd"), DateUtils.formatDate
				(profitOrderDO.getRawUpdateTime(), "yyyy-MM-dd"));
		expect.setRawUpdateTime(profitOrderDO.getRawUpdateTime());
		Assertions.assertEquals(expect, profitOrderDO);
	}

    /**
	 * 插入profit_order表数据
	 */
	public void insertProfitOrder(ProfitOrderDO profitOrderDO) {
		profitOrderDAO.insert(profitOrderDO);
	}

    /**
	 * 插入profit_order表数据
	 */
	public void insertProfitOrder(
			long id, 
			String orderNo, 
			String tradeNo, 
			String state, 
			String partnerId, 
			String merchantOrderNo, 
			String platPartnerId, 
			String platMerchantOrderNo, 
			String reqId, 
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
		ProfitOrderDO profitOrderDO = new ProfitOrderDO();
		profitOrderDO.setId(id);
		profitOrderDO.setOrderNo(orderNo);
		profitOrderDO.setTradeNo(tradeNo);
		profitOrderDO.setState(state);
		profitOrderDO.setPartnerId(partnerId);
		profitOrderDO.setMerchantOrderNo(merchantOrderNo);
		profitOrderDO.setPlatPartnerId(platPartnerId);
		profitOrderDO.setPlatMerchantOrderNo(platMerchantOrderNo);
		profitOrderDO.setReqId(reqId);
		profitOrderDO.setGid(gid);
		profitOrderDO.setRawAddTime(rawAddTime);
		profitOrderDO.setRawUpdateTime(rawUpdateTime);
		profitOrderDAO.insert(profitOrderDO);
	}
	

	/**
	 * 根据id删除profit_order表数据
	 */
	public void cleanProfitOrderById(long id) {
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andIdEqualTo(id);
		profitOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据orderNo删除profit_order表数据
	 */
	public void cleanProfitOrderByOrderNo(String orderNo) {
		if (StringUtils.isBlank(orderNo)){
			orderNo = "test_orderNo";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		profitOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据tradeNo删除profit_order表数据
	 */
	public void cleanProfitOrderByTradeNo(String tradeNo) {
		if (StringUtils.isBlank(tradeNo)){
			tradeNo = "test_tradeNo";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		profitOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除profit_order表数据
	 */
	public void cleanProfitOrderByPartnerId(String partnerId) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		profitOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantOrderNo删除profit_order表数据
	 */
	public void cleanProfitOrderByMerchantOrderNo(String merchantOrderNo) {
		if (StringUtils.isBlank(merchantOrderNo)){
			merchantOrderNo = "test_merchantOrderNo";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		profitOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除profit_order表数据
	 */
	public void cleanProfitOrderByPlatPartnerId(String platPartnerId) {
		if (StringUtils.isBlank(platPartnerId)){
			platPartnerId = "test_platPartnerId";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		profitOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据platMerchantOrderNo删除profit_order表数据
	 */
	public void cleanProfitOrderByPlatMerchantOrderNo(String platMerchantOrderNo) {
		if (StringUtils.isBlank(platMerchantOrderNo)){
			platMerchantOrderNo = "test_platMerchantOrderNo";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		profitOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除profit_order表数据
	 */
	public void cleanProfitOrderByReqId(String reqId) {
		if (StringUtils.isBlank(reqId)){
			reqId = "test_reqId";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		profitOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除profit_order表数据
	 */
	public void cleanProfitOrderByGid(String gid) {
		if (StringUtils.isBlank(gid)){
			gid = "test_gid";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		profitOrderDAO.deleteByExample(exam);
	}


    /**
	 * 根据id查询profit_order表数据
	 */
	public List<ProfitOrderDO> findProfitOrderById(long id) {
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return profitOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据orderNo查询profit_order表数据
	 */
	public List<ProfitOrderDO> findProfitOrderByOrderNo(String orderNo) {
		if (StringUtils.isBlank(orderNo)){
			orderNo = "test_orderNo";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		return profitOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据tradeNo查询profit_order表数据
	 */
	public List<ProfitOrderDO> findProfitOrderByTradeNo(String tradeNo) {
		if (StringUtils.isBlank(tradeNo)){
			tradeNo = "test_tradeNo";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		return profitOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询profit_order表数据
	 */
	public List<ProfitOrderDO> findProfitOrderByPartnerId(String partnerId) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return profitOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantOrderNo查询profit_order表数据
	 */
	public List<ProfitOrderDO> findProfitOrderByMerchantOrderNo(String merchantOrderNo) {
		if (StringUtils.isBlank(merchantOrderNo)){
			merchantOrderNo = "test_merchantOrderNo";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		return profitOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询profit_order表数据
	 */
	public List<ProfitOrderDO> findProfitOrderByPlatPartnerId(String platPartnerId) {
		if (StringUtils.isBlank(platPartnerId)){
			platPartnerId = "test_platPartnerId";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return profitOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据platMerchantOrderNo查询profit_order表数据
	 */
	public List<ProfitOrderDO> findProfitOrderByPlatMerchantOrderNo(String platMerchantOrderNo) {
		if (StringUtils.isBlank(platMerchantOrderNo)){
			platMerchantOrderNo = "test_platMerchantOrderNo";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		return profitOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询profit_order表数据
	 */
	public List<ProfitOrderDO> findProfitOrderByReqId(String reqId) {
		if (StringUtils.isBlank(reqId)){
			reqId = "test_reqId";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return profitOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询profit_order表数据
	 */
	public List<ProfitOrderDO> findProfitOrderByGid(String gid) {
		if (StringUtils.isBlank(gid)){
			gid = "test_gid";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return profitOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新profit_order表数据
	 */
	public void updateProfitOrderById(long id,ProfitOrderDO profitOrderDO) {
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andIdEqualTo(id);
		profitOrderDAO.updateByExample(profitOrderDO, exam);
	}

    /**
	 * 根据orderNo更新profit_order表数据
	 */
	public void updateProfitOrderByOrderNo(String orderNo,ProfitOrderDO profitOrderDO) {
		if (StringUtils.isBlank(orderNo)){
			orderNo = "test_orderNo";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		profitOrderDAO.updateByExample(profitOrderDO, exam);
	}

    /**
	 * 根据tradeNo更新profit_order表数据
	 */
	public void updateProfitOrderByTradeNo(String tradeNo,ProfitOrderDO profitOrderDO) {
		if (StringUtils.isBlank(tradeNo)){
			tradeNo = "test_tradeNo";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		profitOrderDAO.updateByExample(profitOrderDO, exam);
	}

    /**
	 * 根据partnerId更新profit_order表数据
	 */
	public void updateProfitOrderByPartnerId(String partnerId,ProfitOrderDO profitOrderDO) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		profitOrderDAO.updateByExample(profitOrderDO, exam);
	}

    /**
	 * 根据merchantOrderNo更新profit_order表数据
	 */
	public void updateProfitOrderByMerchantOrderNo(String merchantOrderNo,ProfitOrderDO profitOrderDO) {
		if (StringUtils.isBlank(merchantOrderNo)){
			merchantOrderNo = "test_merchantOrderNo";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		profitOrderDAO.updateByExample(profitOrderDO, exam);
	}

    /**
	 * 根据platPartnerId更新profit_order表数据
	 */
	public void updateProfitOrderByPlatPartnerId(String platPartnerId,ProfitOrderDO profitOrderDO) {
		if (StringUtils.isBlank(platPartnerId)){
			platPartnerId = "test_platPartnerId";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		profitOrderDAO.updateByExample(profitOrderDO, exam);
	}

    /**
	 * 根据platMerchantOrderNo更新profit_order表数据
	 */
	public void updateProfitOrderByPlatMerchantOrderNo(String platMerchantOrderNo,ProfitOrderDO profitOrderDO) {
		if (StringUtils.isBlank(platMerchantOrderNo)){
			platMerchantOrderNo = "test_platMerchantOrderNo";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		profitOrderDAO.updateByExample(profitOrderDO, exam);
	}

    /**
	 * 根据reqId更新profit_order表数据
	 */
	public void updateProfitOrderByReqId(String reqId,ProfitOrderDO profitOrderDO) {
		if (StringUtils.isBlank(reqId)){
			reqId = "test_reqId";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		profitOrderDAO.updateByExample(profitOrderDO, exam);
	}

    /**
	 * 根据gid更新profit_order表数据
	 */
	public void updateProfitOrderByGid(String gid,ProfitOrderDO profitOrderDO) {
		if (StringUtils.isBlank(gid)){
			gid = "test_gid";
		}
		ProfitOrderDOExample exam = new ProfitOrderDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		profitOrderDAO.updateByExample(profitOrderDO, exam);
	}

	/**
	 * 断言profit_refund表数据
	 */
	public void assertProfitRefund(ProfitRefundDO expect, ProfitRefundDO profitRefundDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			profitRefundDO.setId(expect.getId());
		}
		Assertions.assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd"), DateUtils.formatDate
				(profitRefundDO.getRawAddTime(), "yyyy-MM-dd"));
		expect.setRawAddTime(profitRefundDO.getRawAddTime());
		Assertions.assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd"), DateUtils.formatDate
				(profitRefundDO.getRawUpdateTime(), "yyyy-MM-dd"));
		expect.setRawUpdateTime(profitRefundDO.getRawUpdateTime());
		Assertions.assertEquals(expect, profitRefundDO);
	}

    /**
	 * 插入profit_refund表数据
	 */
	public void insertProfitRefund(ProfitRefundDO profitRefundDO) {
		profitRefundDAO.insert(profitRefundDO);
	}

    /**
	 * 插入profit_refund表数据
	 */
	public void insertProfitRefund(
			long id, 
			String refundNo, 
			String profitOrderNo, 
			String tradeNo, 
			String state, 
			String partnerId, 
			String merchantOrderNo, 
			String platPartnerId, 
			String platMerchantOrderNo, 
			String reqId, 
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
		ProfitRefundDO profitRefundDO = new ProfitRefundDO();
		profitRefundDO.setId(id);
		profitRefundDO.setRefundNo(refundNo);
		profitRefundDO.setProfitOrderNo(profitOrderNo);
		profitRefundDO.setTradeNo(tradeNo);
		profitRefundDO.setState(state);
		profitRefundDO.setPartnerId(partnerId);
		profitRefundDO.setMerchantOrderNo(merchantOrderNo);
		profitRefundDO.setPlatPartnerId(platPartnerId);
		profitRefundDO.setPlatMerchantOrderNo(platMerchantOrderNo);
		profitRefundDO.setReqId(reqId);
		profitRefundDO.setGid(gid);
		profitRefundDO.setRawAddTime(rawAddTime);
		profitRefundDO.setRawUpdateTime(rawUpdateTime);
		profitRefundDAO.insert(profitRefundDO);
	}
	

	/**
	 * 根据id删除profit_refund表数据
	 */
	public void cleanProfitRefundById(long id) {
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andIdEqualTo(id);
		profitRefundDAO.deleteByExample(exam);
	}

	/**
	 * 根据refundNo删除profit_refund表数据
	 */
	public void cleanProfitRefundByRefundNo(String refundNo) {
		if (StringUtils.isBlank(refundNo)){
			refundNo = "test_refundNo";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andRefundNoEqualTo(refundNo);
		profitRefundDAO.deleteByExample(exam);
	}

	/**
	 * 根据profitOrderNo删除profit_refund表数据
	 */
	public void cleanProfitRefundByProfitOrderNo(String profitOrderNo) {
		if (StringUtils.isBlank(profitOrderNo)){
			profitOrderNo = "test_profitOrderNo";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andProfitOrderNoEqualTo(profitOrderNo);
		profitRefundDAO.deleteByExample(exam);
	}

	/**
	 * 根据tradeNo删除profit_refund表数据
	 */
	public void cleanProfitRefundByTradeNo(String tradeNo) {
		if (StringUtils.isBlank(tradeNo)){
			tradeNo = "test_tradeNo";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		profitRefundDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除profit_refund表数据
	 */
	public void cleanProfitRefundByPartnerId(String partnerId) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		profitRefundDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantOrderNo删除profit_refund表数据
	 */
	public void cleanProfitRefundByMerchantOrderNo(String merchantOrderNo) {
		if (StringUtils.isBlank(merchantOrderNo)){
			merchantOrderNo = "test_merchantOrderNo";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		profitRefundDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除profit_refund表数据
	 */
	public void cleanProfitRefundByPlatPartnerId(String platPartnerId) {
		if (StringUtils.isBlank(platPartnerId)){
			platPartnerId = "test_platPartnerId";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		profitRefundDAO.deleteByExample(exam);
	}

	/**
	 * 根据platMerchantOrderNo删除profit_refund表数据
	 */
	public void cleanProfitRefundByPlatMerchantOrderNo(String platMerchantOrderNo) {
		if (StringUtils.isBlank(platMerchantOrderNo)){
			platMerchantOrderNo = "test_platMerchantOrderNo";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		profitRefundDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除profit_refund表数据
	 */
	public void cleanProfitRefundByReqId(String reqId) {
		if (StringUtils.isBlank(reqId)){
			reqId = "test_reqId";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		profitRefundDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除profit_refund表数据
	 */
	public void cleanProfitRefundByGid(String gid) {
		if (StringUtils.isBlank(gid)){
			gid = "test_gid";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		profitRefundDAO.deleteByExample(exam);
	}


    /**
	 * 根据id查询profit_refund表数据
	 */
	public List<ProfitRefundDO> findProfitRefundById(long id) {
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return profitRefundDAO.selectByExample(exam);
	}

    /**
	 * 根据refundNo查询profit_refund表数据
	 */
	public List<ProfitRefundDO> findProfitRefundByRefundNo(String refundNo) {
		if (StringUtils.isBlank(refundNo)){
			refundNo = "test_refundNo";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andRefundNoEqualTo(refundNo);
		return profitRefundDAO.selectByExample(exam);
	}

    /**
	 * 根据profitOrderNo查询profit_refund表数据
	 */
	public List<ProfitRefundDO> findProfitRefundByProfitOrderNo(String profitOrderNo) {
		if (StringUtils.isBlank(profitOrderNo)){
			profitOrderNo = "test_profitOrderNo";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andProfitOrderNoEqualTo(profitOrderNo);
		return profitRefundDAO.selectByExample(exam);
	}

    /**
	 * 根据tradeNo查询profit_refund表数据
	 */
	public List<ProfitRefundDO> findProfitRefundByTradeNo(String tradeNo) {
		if (StringUtils.isBlank(tradeNo)){
			tradeNo = "test_tradeNo";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		return profitRefundDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询profit_refund表数据
	 */
	public List<ProfitRefundDO> findProfitRefundByPartnerId(String partnerId) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return profitRefundDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantOrderNo查询profit_refund表数据
	 */
	public List<ProfitRefundDO> findProfitRefundByMerchantOrderNo(String merchantOrderNo) {
		if (StringUtils.isBlank(merchantOrderNo)){
			merchantOrderNo = "test_merchantOrderNo";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		return profitRefundDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询profit_refund表数据
	 */
	public List<ProfitRefundDO> findProfitRefundByPlatPartnerId(String platPartnerId) {
		if (StringUtils.isBlank(platPartnerId)){
			platPartnerId = "test_platPartnerId";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return profitRefundDAO.selectByExample(exam);
	}

    /**
	 * 根据platMerchantOrderNo查询profit_refund表数据
	 */
	public List<ProfitRefundDO> findProfitRefundByPlatMerchantOrderNo(String platMerchantOrderNo) {
		if (StringUtils.isBlank(platMerchantOrderNo)){
			platMerchantOrderNo = "test_platMerchantOrderNo";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		return profitRefundDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询profit_refund表数据
	 */
	public List<ProfitRefundDO> findProfitRefundByReqId(String reqId) {
		if (StringUtils.isBlank(reqId)){
			reqId = "test_reqId";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return profitRefundDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询profit_refund表数据
	 */
	public List<ProfitRefundDO> findProfitRefundByGid(String gid) {
		if (StringUtils.isBlank(gid)){
			gid = "test_gid";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return profitRefundDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新profit_refund表数据
	 */
	public void updateProfitRefundById(long id,ProfitRefundDO profitRefundDO) {
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andIdEqualTo(id);
		profitRefundDAO.updateByExample(profitRefundDO, exam);
	}

    /**
	 * 根据refundNo更新profit_refund表数据
	 */
	public void updateProfitRefundByRefundNo(String refundNo,ProfitRefundDO profitRefundDO) {
		if (StringUtils.isBlank(refundNo)){
			refundNo = "test_refundNo";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andRefundNoEqualTo(refundNo);
		profitRefundDAO.updateByExample(profitRefundDO, exam);
	}

    /**
	 * 根据profitOrderNo更新profit_refund表数据
	 */
	public void updateProfitRefundByProfitOrderNo(String profitOrderNo,ProfitRefundDO profitRefundDO) {
		if (StringUtils.isBlank(profitOrderNo)){
			profitOrderNo = "test_profitOrderNo";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andProfitOrderNoEqualTo(profitOrderNo);
		profitRefundDAO.updateByExample(profitRefundDO, exam);
	}

    /**
	 * 根据tradeNo更新profit_refund表数据
	 */
	public void updateProfitRefundByTradeNo(String tradeNo,ProfitRefundDO profitRefundDO) {
		if (StringUtils.isBlank(tradeNo)){
			tradeNo = "test_tradeNo";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		profitRefundDAO.updateByExample(profitRefundDO, exam);
	}

    /**
	 * 根据partnerId更新profit_refund表数据
	 */
	public void updateProfitRefundByPartnerId(String partnerId,ProfitRefundDO profitRefundDO) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		profitRefundDAO.updateByExample(profitRefundDO, exam);
	}

    /**
	 * 根据merchantOrderNo更新profit_refund表数据
	 */
	public void updateProfitRefundByMerchantOrderNo(String merchantOrderNo,ProfitRefundDO profitRefundDO) {
		if (StringUtils.isBlank(merchantOrderNo)){
			merchantOrderNo = "test_merchantOrderNo";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		profitRefundDAO.updateByExample(profitRefundDO, exam);
	}

    /**
	 * 根据platPartnerId更新profit_refund表数据
	 */
	public void updateProfitRefundByPlatPartnerId(String platPartnerId,ProfitRefundDO profitRefundDO) {
		if (StringUtils.isBlank(platPartnerId)){
			platPartnerId = "test_platPartnerId";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		profitRefundDAO.updateByExample(profitRefundDO, exam);
	}

    /**
	 * 根据platMerchantOrderNo更新profit_refund表数据
	 */
	public void updateProfitRefundByPlatMerchantOrderNo(String platMerchantOrderNo,ProfitRefundDO profitRefundDO) {
		if (StringUtils.isBlank(platMerchantOrderNo)){
			platMerchantOrderNo = "test_platMerchantOrderNo";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andPlatMerchantOrderNoEqualTo(platMerchantOrderNo);
		profitRefundDAO.updateByExample(profitRefundDO, exam);
	}

    /**
	 * 根据reqId更新profit_refund表数据
	 */
	public void updateProfitRefundByReqId(String reqId,ProfitRefundDO profitRefundDO) {
		if (StringUtils.isBlank(reqId)){
			reqId = "test_reqId";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		profitRefundDAO.updateByExample(profitRefundDO, exam);
	}

    /**
	 * 根据gid更新profit_refund表数据
	 */
	public void updateProfitRefundByGid(String gid,ProfitRefundDO profitRefundDO) {
		if (StringUtils.isBlank(gid)){
			gid = "test_gid";
		}
		ProfitRefundDOExample exam = new ProfitRefundDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		profitRefundDAO.updateByExample(profitRefundDO, exam);
	}

	/**
	 * 断言refund_execute_record表数据
	 */
	public void assertRefundExecuteRecord(RefundExecuteRecordDO expect, RefundExecuteRecordDO refundExecuteRecordDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			refundExecuteRecordDO.setId(expect.getId());
		}
		Assertions.assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd"), DateUtils.formatDate
				(refundExecuteRecordDO.getRawAddTime(), "yyyy-MM-dd"));
		expect.setRawAddTime(refundExecuteRecordDO.getRawAddTime());
		Assertions.assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd"), DateUtils.formatDate
				(refundExecuteRecordDO.getRawUpdateTime(), "yyyy-MM-dd"));
		expect.setRawUpdateTime(refundExecuteRecordDO.getRawUpdateTime());
		Assertions.assertEquals(expect, refundExecuteRecordDO);
	}

    /**
	 * 插入refund_execute_record表数据
	 */
	public void insertRefundExecuteRecord(RefundExecuteRecordDO refundExecuteRecordDO) {
		refundExecuteRecordDAO.insert(refundExecuteRecordDO);
	}

    /**
	 * 插入refund_execute_record表数据
	 */
	public void insertRefundExecuteRecord(
			long id, 
			String tradeNo, 
			String refundNo, 
			String payer, 
			String payee, 
			Integer sequence, 
			long amount, 
			String state, 
			String memo, 
			String reqId, 
			String gid, 
			String partnerId, 
			String merchOrderNo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		RefundExecuteRecordDO refundExecuteRecordDO = new RefundExecuteRecordDO();
		refundExecuteRecordDO.setId(id);
		refundExecuteRecordDO.setTradeNo(tradeNo);
		refundExecuteRecordDO.setRefundNo(refundNo);
		refundExecuteRecordDO.setPayer(payer);
		refundExecuteRecordDO.setPayee(payee);
		refundExecuteRecordDO.setSequence(sequence);
		refundExecuteRecordDO.setAmount(amount);
		refundExecuteRecordDO.setState(state);
		refundExecuteRecordDO.setMemo(memo);
		refundExecuteRecordDO.setReqId(reqId);
		refundExecuteRecordDO.setGid(gid);
		refundExecuteRecordDO.setPartnerId(partnerId);
		refundExecuteRecordDO.setMerchOrderNo(merchOrderNo);
		refundExecuteRecordDO.setRawAddTime(rawAddTime);
		refundExecuteRecordDO.setRawUpdateTime(rawUpdateTime);
		refundExecuteRecordDAO.insert(refundExecuteRecordDO);
	}
	

	/**
	 * 根据id删除refund_execute_record表数据
	 */
	public void cleanRefundExecuteRecordById(long id) {
		RefundExecuteRecordDOExample exam = new RefundExecuteRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		refundExecuteRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据tradeNo删除refund_execute_record表数据
	 */
	public void cleanRefundExecuteRecordByTradeNo(String tradeNo) {
		if (StringUtils.isBlank(tradeNo)){
			tradeNo = "test_tradeNo";
		}
		RefundExecuteRecordDOExample exam = new RefundExecuteRecordDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		refundExecuteRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据refundNo删除refund_execute_record表数据
	 */
	public void cleanRefundExecuteRecordByRefundNo(String refundNo) {
		if (StringUtils.isBlank(refundNo)){
			refundNo = "test_refundNo";
		}
		RefundExecuteRecordDOExample exam = new RefundExecuteRecordDOExample();
		exam.createCriteria().andRefundNoEqualTo(refundNo);
		refundExecuteRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除refund_execute_record表数据
	 */
	public void cleanRefundExecuteRecordByReqId(String reqId) {
		if (StringUtils.isBlank(reqId)){
			reqId = "test_reqId";
		}
		RefundExecuteRecordDOExample exam = new RefundExecuteRecordDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		refundExecuteRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除refund_execute_record表数据
	 */
	public void cleanRefundExecuteRecordByGid(String gid) {
		if (StringUtils.isBlank(gid)){
			gid = "test_gid";
		}
		RefundExecuteRecordDOExample exam = new RefundExecuteRecordDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		refundExecuteRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除refund_execute_record表数据
	 */
	public void cleanRefundExecuteRecordByPartnerId(String partnerId) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		RefundExecuteRecordDOExample exam = new RefundExecuteRecordDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		refundExecuteRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchOrderNo删除refund_execute_record表数据
	 */
	public void cleanRefundExecuteRecordByMerchOrderNo(String merchOrderNo) {
		if (StringUtils.isBlank(merchOrderNo)){
			merchOrderNo = "test_merchOrderNo";
		}
		RefundExecuteRecordDOExample exam = new RefundExecuteRecordDOExample();
		exam.createCriteria().andMerchOrderNoEqualTo(merchOrderNo);
		refundExecuteRecordDAO.deleteByExample(exam);
	}


    /**
	 * 根据id查询refund_execute_record表数据
	 */
	public List<RefundExecuteRecordDO> findRefundExecuteRecordById(long id) {
		RefundExecuteRecordDOExample exam = new RefundExecuteRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return refundExecuteRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据tradeNo查询refund_execute_record表数据
	 */
	public List<RefundExecuteRecordDO> findRefundExecuteRecordByTradeNo(String tradeNo) {
		if (StringUtils.isBlank(tradeNo)){
			tradeNo = "test_tradeNo";
		}
		RefundExecuteRecordDOExample exam = new RefundExecuteRecordDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		return refundExecuteRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据refundNo查询refund_execute_record表数据
	 */
	public List<RefundExecuteRecordDO> findRefundExecuteRecordByRefundNo(String refundNo) {
		if (StringUtils.isBlank(refundNo)){
			refundNo = "test_refundNo";
		}
		RefundExecuteRecordDOExample exam = new RefundExecuteRecordDOExample();
		exam.createCriteria().andRefundNoEqualTo(refundNo);
		return refundExecuteRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询refund_execute_record表数据
	 */
	public List<RefundExecuteRecordDO> findRefundExecuteRecordByReqId(String reqId) {
		if (StringUtils.isBlank(reqId)){
			reqId = "test_reqId";
		}
		RefundExecuteRecordDOExample exam = new RefundExecuteRecordDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return refundExecuteRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询refund_execute_record表数据
	 */
	public List<RefundExecuteRecordDO> findRefundExecuteRecordByGid(String gid) {
		if (StringUtils.isBlank(gid)){
			gid = "test_gid";
		}
		RefundExecuteRecordDOExample exam = new RefundExecuteRecordDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return refundExecuteRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询refund_execute_record表数据
	 */
	public List<RefundExecuteRecordDO> findRefundExecuteRecordByPartnerId(String partnerId) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		RefundExecuteRecordDOExample exam = new RefundExecuteRecordDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return refundExecuteRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据merchOrderNo查询refund_execute_record表数据
	 */
	public List<RefundExecuteRecordDO> findRefundExecuteRecordByMerchOrderNo(String merchOrderNo) {
		if (StringUtils.isBlank(merchOrderNo)){
			merchOrderNo = "test_merchOrderNo";
		}
		RefundExecuteRecordDOExample exam = new RefundExecuteRecordDOExample();
		exam.createCriteria().andMerchOrderNoEqualTo(merchOrderNo);
		return refundExecuteRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新refund_execute_record表数据
	 */
	public void updateRefundExecuteRecordById(long id,RefundExecuteRecordDO refundExecuteRecordDO) {
		RefundExecuteRecordDOExample exam = new RefundExecuteRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		refundExecuteRecordDAO.updateByExample(refundExecuteRecordDO, exam);
	}

    /**
	 * 根据tradeNo更新refund_execute_record表数据
	 */
	public void updateRefundExecuteRecordByTradeNo(String tradeNo,RefundExecuteRecordDO refundExecuteRecordDO) {
		if (StringUtils.isBlank(tradeNo)){
			tradeNo = "test_tradeNo";
		}
		RefundExecuteRecordDOExample exam = new RefundExecuteRecordDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		refundExecuteRecordDAO.updateByExample(refundExecuteRecordDO, exam);
	}

    /**
	 * 根据refundNo更新refund_execute_record表数据
	 */
	public void updateRefundExecuteRecordByRefundNo(String refundNo,RefundExecuteRecordDO refundExecuteRecordDO) {
		if (StringUtils.isBlank(refundNo)){
			refundNo = "test_refundNo";
		}
		RefundExecuteRecordDOExample exam = new RefundExecuteRecordDOExample();
		exam.createCriteria().andRefundNoEqualTo(refundNo);
		refundExecuteRecordDAO.updateByExample(refundExecuteRecordDO, exam);
	}

    /**
	 * 根据reqId更新refund_execute_record表数据
	 */
	public void updateRefundExecuteRecordByReqId(String reqId,RefundExecuteRecordDO refundExecuteRecordDO) {
		if (StringUtils.isBlank(reqId)){
			reqId = "test_reqId";
		}
		RefundExecuteRecordDOExample exam = new RefundExecuteRecordDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		refundExecuteRecordDAO.updateByExample(refundExecuteRecordDO, exam);
	}

    /**
	 * 根据gid更新refund_execute_record表数据
	 */
	public void updateRefundExecuteRecordByGid(String gid,RefundExecuteRecordDO refundExecuteRecordDO) {
		if (StringUtils.isBlank(gid)){
			gid = "test_gid";
		}
		RefundExecuteRecordDOExample exam = new RefundExecuteRecordDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		refundExecuteRecordDAO.updateByExample(refundExecuteRecordDO, exam);
	}

    /**
	 * 根据partnerId更新refund_execute_record表数据
	 */
	public void updateRefundExecuteRecordByPartnerId(String partnerId,RefundExecuteRecordDO refundExecuteRecordDO) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		RefundExecuteRecordDOExample exam = new RefundExecuteRecordDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		refundExecuteRecordDAO.updateByExample(refundExecuteRecordDO, exam);
	}

    /**
	 * 根据merchOrderNo更新refund_execute_record表数据
	 */
	public void updateRefundExecuteRecordByMerchOrderNo(String merchOrderNo,RefundExecuteRecordDO refundExecuteRecordDO) {
		if (StringUtils.isBlank(merchOrderNo)){
			merchOrderNo = "test_merchOrderNo";
		}
		RefundExecuteRecordDOExample exam = new RefundExecuteRecordDOExample();
		exam.createCriteria().andMerchOrderNoEqualTo(merchOrderNo);
		refundExecuteRecordDAO.updateByExample(refundExecuteRecordDO, exam);
	}

	/**
	 * 断言rule表数据
	 */
	public void assertRule(RuleDO expect, RuleDO ruleDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			ruleDO.setId(expect.getId());
		}
		Assertions.assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd"), DateUtils.formatDate
				(ruleDO.getRawAddTime(), "yyyy-MM-dd"));
		expect.setRawAddTime(ruleDO.getRawAddTime());
		Assertions.assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd"), DateUtils.formatDate
				(ruleDO.getRawUpdateTime(), "yyyy-MM-dd"));
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
			long id, 
			String name, 
			String partnerId, 
			String partnerName, 
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
		ruleDO.setName(name);
		ruleDO.setPartnerId(partnerId);
		ruleDO.setPartnerName(partnerName);
		ruleDO.setRawAddTime(rawAddTime);
		ruleDO.setRawUpdateTime(rawUpdateTime);
		ruleDAO.insert(ruleDO);
	}
	

	/**
	 * 根据id删除rule表数据
	 */
	public void cleanRuleById(long id) {
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		ruleDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除rule表数据
	*/
	public void cleanRuleByName(String name) {
		if (StringUtils.isBlank(name)){
			name = "test_name";
		}
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andNameEqualTo(name);
		ruleDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除rule表数据
	 */
	public void cleanRuleByPartnerId(String partnerId) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		ruleDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除rule表数据
	*/
	public void cleanRuleByPartnerName(String partnerName) {
		if (StringUtils.isBlank(partnerName)){
			partnerName = "test_partnerName";
		}
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		ruleDAO.deleteByExample(exam);
	}


    /**
	 * 根据id查询rule表数据
	 */
	public List<RuleDO> findRuleById(long id) {
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return ruleDAO.selectByExample(exam);
	}

	/**
	* 根据name查询rule表数据
	*/
	public List<RuleDO> findRuleByName(String name) {
		if (StringUtils.isBlank(name)){
			name = "test_name";
		}
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return ruleDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询rule表数据
	 */
	public List<RuleDO> findRuleByPartnerId(String partnerId) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return ruleDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询rule表数据
	*/
	public List<RuleDO> findRuleByPartnerName(String partnerName) {
		if (StringUtils.isBlank(partnerName)){
			partnerName = "test_partnerName";
		}
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return ruleDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新rule表数据
	 */
	public void updateRuleById(long id,RuleDO ruleDO) {
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		ruleDAO.updateByExample(ruleDO, exam);
	}

	/**
	* 根据name更新rule表数据
	*/
	public void updateRuleByName(String name,RuleDO ruleDO) {
		if (StringUtils.isBlank(name)){
			name = "test_name";
		}
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andNameEqualTo(name);
		ruleDAO.updateByExample(ruleDO, exam);
	}

    /**
	 * 根据partnerId更新rule表数据
	 */
	public void updateRuleByPartnerId(String partnerId,RuleDO ruleDO) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		ruleDAO.updateByExample(ruleDO, exam);
	}

	/**
	* 根据partnerName更新rule表数据
	*/
	public void updateRuleByPartnerName(String partnerName,RuleDO ruleDO) {
		if (StringUtils.isBlank(partnerName)){
			partnerName = "test_partnerName";
		}
		RuleDOExample exam = new RuleDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		ruleDAO.updateByExample(ruleDO, exam);
	}

	/**
	 * 断言task_execute_record表数据
	 */
	public void assertTaskExecuteRecord(TaskExecuteRecordDO expect, TaskExecuteRecordDO taskExecuteRecordDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			taskExecuteRecordDO.setId(expect.getId());
		}
		Assertions.assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd"), DateUtils.formatDate
				(taskExecuteRecordDO.getRawAddTime(), "yyyy-MM-dd"));
		expect.setRawAddTime(taskExecuteRecordDO.getRawAddTime());
		Assertions.assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd"), DateUtils.formatDate
				(taskExecuteRecordDO.getRawUpdateTime(), "yyyy-MM-dd"));
		expect.setRawUpdateTime(taskExecuteRecordDO.getRawUpdateTime());
		Assertions.assertEquals(expect, taskExecuteRecordDO);
	}

    /**
	 * 插入task_execute_record表数据
	 */
	public void insertTaskExecuteRecord(TaskExecuteRecordDO taskExecuteRecordDO) {
		taskExecuteRecordDAO.insert(taskExecuteRecordDO);
	}

    /**
	 * 插入task_execute_record表数据
	 */
	public void insertTaskExecuteRecord(
			long id, 
			String tradeNo, 
			String serialNo, 
			long amount, 
			Date executeTime, 
			Date finishTime, 
			String state, 
			long conditionStrategyId, 
			String conditionExpr, 
			long actionStrategyId, 
			long ruleId, 
			String ruleType, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (executeTime == null) {
			executeTime = new Date();
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
		TaskExecuteRecordDO taskExecuteRecordDO = new TaskExecuteRecordDO();
		taskExecuteRecordDO.setId(id);
		taskExecuteRecordDO.setTradeNo(tradeNo);
		taskExecuteRecordDO.setSerialNo(serialNo);
		taskExecuteRecordDO.setAmount(amount);
		taskExecuteRecordDO.setExecuteTime(executeTime);
		taskExecuteRecordDO.setFinishTime(finishTime);
		taskExecuteRecordDO.setState(state);
		taskExecuteRecordDO.setConditionStrategyId(conditionStrategyId);
		taskExecuteRecordDO.setConditionExpr(conditionExpr);
		taskExecuteRecordDO.setActionStrategyId(actionStrategyId);
		taskExecuteRecordDO.setRuleId(ruleId);
		taskExecuteRecordDO.setRuleType(ruleType);
		taskExecuteRecordDO.setRawAddTime(rawAddTime);
		taskExecuteRecordDO.setRawUpdateTime(rawUpdateTime);
		taskExecuteRecordDAO.insert(taskExecuteRecordDO);
	}
	

	/**
	 * 根据id删除task_execute_record表数据
	 */
	public void cleanTaskExecuteRecordById(long id) {
		TaskExecuteRecordDOExample exam = new TaskExecuteRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		taskExecuteRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据tradeNo删除task_execute_record表数据
	 */
	public void cleanTaskExecuteRecordByTradeNo(String tradeNo) {
		if (StringUtils.isBlank(tradeNo)){
			tradeNo = "test_tradeNo";
		}
		TaskExecuteRecordDOExample exam = new TaskExecuteRecordDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		taskExecuteRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据serialNo删除task_execute_record表数据
	 */
	public void cleanTaskExecuteRecordBySerialNo(String serialNo) {
		if (StringUtils.isBlank(serialNo)){
			serialNo = "test_serialNo";
		}
		TaskExecuteRecordDOExample exam = new TaskExecuteRecordDOExample();
		exam.createCriteria().andSerialNoEqualTo(serialNo);
		taskExecuteRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据conditionStrategyId删除task_execute_record表数据
	 */
	public void cleanTaskExecuteRecordByConditionStrategyId(long conditionStrategyId) {
		TaskExecuteRecordDOExample exam = new TaskExecuteRecordDOExample();
		exam.createCriteria().andConditionStrategyIdEqualTo(conditionStrategyId);
		taskExecuteRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据actionStrategyId删除task_execute_record表数据
	 */
	public void cleanTaskExecuteRecordByActionStrategyId(long actionStrategyId) {
		TaskExecuteRecordDOExample exam = new TaskExecuteRecordDOExample();
		exam.createCriteria().andActionStrategyIdEqualTo(actionStrategyId);
		taskExecuteRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据ruleId删除task_execute_record表数据
	 */
	public void cleanTaskExecuteRecordByRuleId(long ruleId) {
		TaskExecuteRecordDOExample exam = new TaskExecuteRecordDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		taskExecuteRecordDAO.deleteByExample(exam);
	}


    /**
	 * 根据id查询task_execute_record表数据
	 */
	public List<TaskExecuteRecordDO> findTaskExecuteRecordById(long id) {
		TaskExecuteRecordDOExample exam = new TaskExecuteRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return taskExecuteRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据tradeNo查询task_execute_record表数据
	 */
	public List<TaskExecuteRecordDO> findTaskExecuteRecordByTradeNo(String tradeNo) {
		if (StringUtils.isBlank(tradeNo)){
			tradeNo = "test_tradeNo";
		}
		TaskExecuteRecordDOExample exam = new TaskExecuteRecordDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		return taskExecuteRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据serialNo查询task_execute_record表数据
	 */
	public List<TaskExecuteRecordDO> findTaskExecuteRecordBySerialNo(String serialNo) {
		if (StringUtils.isBlank(serialNo)){
			serialNo = "test_serialNo";
		}
		TaskExecuteRecordDOExample exam = new TaskExecuteRecordDOExample();
		exam.createCriteria().andSerialNoEqualTo(serialNo);
		return taskExecuteRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据conditionStrategyId查询task_execute_record表数据
	 */
	public List<TaskExecuteRecordDO> findTaskExecuteRecordByConditionStrategyId(long conditionStrategyId) {
		TaskExecuteRecordDOExample exam = new TaskExecuteRecordDOExample();
		exam.createCriteria().andConditionStrategyIdEqualTo(conditionStrategyId);
		return taskExecuteRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据actionStrategyId查询task_execute_record表数据
	 */
	public List<TaskExecuteRecordDO> findTaskExecuteRecordByActionStrategyId(long actionStrategyId) {
		TaskExecuteRecordDOExample exam = new TaskExecuteRecordDOExample();
		exam.createCriteria().andActionStrategyIdEqualTo(actionStrategyId);
		return taskExecuteRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据ruleId查询task_execute_record表数据
	 */
	public List<TaskExecuteRecordDO> findTaskExecuteRecordByRuleId(long ruleId) {
		TaskExecuteRecordDOExample exam = new TaskExecuteRecordDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		return taskExecuteRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新task_execute_record表数据
	 */
	public void updateTaskExecuteRecordById(long id,TaskExecuteRecordDO taskExecuteRecordDO) {
		TaskExecuteRecordDOExample exam = new TaskExecuteRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		taskExecuteRecordDAO.updateByExample(taskExecuteRecordDO, exam);
	}

    /**
	 * 根据tradeNo更新task_execute_record表数据
	 */
	public void updateTaskExecuteRecordByTradeNo(String tradeNo,TaskExecuteRecordDO taskExecuteRecordDO) {
		if (StringUtils.isBlank(tradeNo)){
			tradeNo = "test_tradeNo";
		}
		TaskExecuteRecordDOExample exam = new TaskExecuteRecordDOExample();
		exam.createCriteria().andTradeNoEqualTo(tradeNo);
		taskExecuteRecordDAO.updateByExample(taskExecuteRecordDO, exam);
	}

    /**
	 * 根据serialNo更新task_execute_record表数据
	 */
	public void updateTaskExecuteRecordBySerialNo(String serialNo,TaskExecuteRecordDO taskExecuteRecordDO) {
		if (StringUtils.isBlank(serialNo)){
			serialNo = "test_serialNo";
		}
		TaskExecuteRecordDOExample exam = new TaskExecuteRecordDOExample();
		exam.createCriteria().andSerialNoEqualTo(serialNo);
		taskExecuteRecordDAO.updateByExample(taskExecuteRecordDO, exam);
	}

    /**
	 * 根据conditionStrategyId更新task_execute_record表数据
	 */
	public void updateTaskExecuteRecordByConditionStrategyId(long conditionStrategyId,TaskExecuteRecordDO taskExecuteRecordDO) {
		TaskExecuteRecordDOExample exam = new TaskExecuteRecordDOExample();
		exam.createCriteria().andConditionStrategyIdEqualTo(conditionStrategyId);
		taskExecuteRecordDAO.updateByExample(taskExecuteRecordDO, exam);
	}

    /**
	 * 根据actionStrategyId更新task_execute_record表数据
	 */
	public void updateTaskExecuteRecordByActionStrategyId(long actionStrategyId,TaskExecuteRecordDO taskExecuteRecordDO) {
		TaskExecuteRecordDOExample exam = new TaskExecuteRecordDOExample();
		exam.createCriteria().andActionStrategyIdEqualTo(actionStrategyId);
		taskExecuteRecordDAO.updateByExample(taskExecuteRecordDO, exam);
	}

    /**
	 * 根据ruleId更新task_execute_record表数据
	 */
	public void updateTaskExecuteRecordByRuleId(long ruleId,TaskExecuteRecordDO taskExecuteRecordDO) {
		TaskExecuteRecordDOExample exam = new TaskExecuteRecordDOExample();
		exam.createCriteria().andRuleIdEqualTo(ruleId);
		taskExecuteRecordDAO.updateByExample(taskExecuteRecordDO, exam);
	}

}
