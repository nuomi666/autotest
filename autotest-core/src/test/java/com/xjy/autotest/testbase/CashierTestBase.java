package com.xjy.autotest.testbase;

import com.xjy.autotest.config.CashierDataSourceConfig;
import dal.dao.cashier.*;
import dal.model.cashier.*;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author autotest
 * Created on 2018/09/29.
 */
@Service
@Import({
        CashierDataSourceConfig.class
})
public class CashierTestBase {

	@Autowired
	ChannelDAO channelDAO;

	@Autowired
	ChannelMappingDAO channelMappingDAO;

	@Autowired
	PayChannelDAO payChannelDAO;

	@Autowired
	RouteMappingDAO routeMappingDAO;

	@Autowired
	RouteStrategyDAO routeStrategyDAO;

	@Autowired
	SettleChannelDAO settleChannelDAO;

	@Autowired
	SettleChannelMappingDAO settleChannelMappingDAO;

	public ChannelDAO getChannelDAO() {
		return this.channelDAO;
	}

	public ChannelMappingDAO getChannelMappingDAO() {
		return this.channelMappingDAO;
	}

	public PayChannelDAO getPayChannelDAO() {
		return this.payChannelDAO;
	}

	public RouteMappingDAO getRouteMappingDAO() {
		return this.routeMappingDAO;
	}

	public RouteStrategyDAO getRouteStrategyDAO() {
		return this.routeStrategyDAO;
	}

	public SettleChannelDAO getSettleChannelDAO() {
		return this.settleChannelDAO;
	}

	public SettleChannelMappingDAO getSettleChannelMappingDAO() {
		return this.settleChannelMappingDAO;
	}


	/**
	 * 断言channel表数据
	 */
	public void assertChannel(ChannelDO expect, ChannelDO channelDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			channelDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != channelDO.getRawAddTime());
		expect.setRawAddTime(channelDO.getRawAddTime());
        Assertions.assertTrue(null != channelDO.getRawUpdateTime());
		expect.setRawUpdateTime(channelDO.getRawUpdateTime());
		Assertions.assertEquals(expect, channelDO);
	}

    /**
	 * 插入channel表数据
	 */
	public void insertChannel(ChannelDO channelDO) {
		channelDAO.insert(channelDO);
	}

    /**
	 * 插入channel表数据
	 */
	public void insertChannel(
			long id, 
			String channelId, 
			String channelName, 
			String channelConfig, 
			String state, 
			String channelType, 
			String merchantRateType, 
			String merchantRateRule, 
			Integer merchantRateDecimal, 
			String channelRateType, 
			String channelRateRule, 
			Integer channelRateDecimal, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String markDelete
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ChannelDO channelDO = new ChannelDO();
		channelDO.setId(id);
		channelDO.setChannelId(channelId);
		channelDO.setChannelName(channelName);
		channelDO.setChannelConfig(channelConfig);
		channelDO.setState(state);
		channelDO.setChannelType(channelType);
		channelDO.setMerchantRateType(merchantRateType);
		channelDO.setMerchantRateRule(merchantRateRule);
		channelDO.setMerchantRateDecimal(merchantRateDecimal);
		channelDO.setChannelRateType(channelRateType);
		channelDO.setChannelRateRule(channelRateRule);
		channelDO.setChannelRateDecimal(channelRateDecimal);
		channelDO.setRawAddTime(rawAddTime);
		channelDO.setRawUpdateTime(rawUpdateTime);
		channelDO.setMarkDelete(markDelete);
		channelDAO.insert(channelDO);
	}
	

	/**
	 * 根据id删除channel表数据
	 */
	public void cleanChannelById(long id) {
		ChannelDOExample exam = new ChannelDOExample();
		exam.createCriteria().andIdEqualTo(id);
		channelDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除channel表数据
	 */
	public void cleanChannelByChannelId(String channelId) {
		if (StringUtils.isBlank(channelId)){
			channelId = "test_channelId";
		}
		ChannelDOExample exam = new ChannelDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		channelDAO.deleteByExample(exam);
	}

	/**
	* 根据channelName删除channel表数据
	*/
	public void cleanChannelByChannelName(String channelName) {
		if (StringUtils.isBlank(channelName)){
			channelName = "test_channelName";
		}
		ChannelDOExample exam = new ChannelDOExample();
		exam.createCriteria().andChannelNameEqualTo(channelName);
		channelDAO.deleteByExample(exam);
	}


    /**
	 * 根据id查询channel表数据
	 */
	public List<ChannelDO> findChannelById(long id) {
		ChannelDOExample exam = new ChannelDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return channelDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询channel表数据
	 */
	public List<ChannelDO> findChannelByChannelId(String channelId) {
		if (StringUtils.isBlank(channelId)){
			channelId = "test_channelId";
		}
		ChannelDOExample exam = new ChannelDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return channelDAO.selectByExample(exam);
	}

	/**
	* 根据channelName查询channel表数据
	*/
	public List<ChannelDO> findChannelByChannelName(String channelName) {
		if (StringUtils.isBlank(channelName)){
			channelName = "test_channelName";
		}
		ChannelDOExample exam = new ChannelDOExample();
		exam.createCriteria().andChannelNameEqualTo(channelName);
		return channelDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新channel表数据
	 */
	public void updateChannelById(long id,ChannelDO channelDO) {
		ChannelDOExample exam = new ChannelDOExample();
		exam.createCriteria().andIdEqualTo(id);
		channelDAO.updateByExample(channelDO, exam);
	}

    /**
	 * 根据channelId更新channel表数据
	 */
	public void updateChannelByChannelId(String channelId,ChannelDO channelDO) {
		if (StringUtils.isBlank(channelId)){
			channelId = "test_channelId";
		}
		ChannelDOExample exam = new ChannelDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		channelDAO.updateByExample(channelDO, exam);
	}

	/**
	* 根据channelName更新channel表数据
	*/
	public void updateChannelByChannelName(String channelName,ChannelDO channelDO) {
		if (StringUtils.isBlank(channelName)){
			channelName = "test_channelName";
		}
		ChannelDOExample exam = new ChannelDOExample();
		exam.createCriteria().andChannelNameEqualTo(channelName);
		channelDAO.updateByExample(channelDO, exam);
	}

	/**
	 * 断言channel_mapping表数据
	 */
	public void assertChannelMapping(ChannelMappingDO expect, ChannelMappingDO channelMappingDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			channelMappingDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != channelMappingDO.getRawAddTime());
		expect.setRawAddTime(channelMappingDO.getRawAddTime());
        Assertions.assertTrue(null != channelMappingDO.getRawUpdateTime());
		expect.setRawUpdateTime(channelMappingDO.getRawUpdateTime());
		Assertions.assertEquals(expect, channelMappingDO);
	}

    /**
	 * 插入channel_mapping表数据
	 */
	public void insertChannelMapping(ChannelMappingDO channelMappingDO) {
		channelMappingDAO.insert(channelMappingDO);
	}

    /**
	 * 插入channel_mapping表数据
	 */
	public void insertChannelMapping(
			long id, 
			String channelMappingId, 
			String channelId, 
			String channelName, 
			String partnerId, 
			String partnerName, 
			String wechatAppid, 
			String alipayAppid, 
			String wechatAppAppid, 
			String alipayAppAppid, 
			String password, 
			String channelPartnerId, 
			String subChannelPartnerId, 
			String sign, 
			String publicKey, 
			String systemPublicKey, 
			String privateKey, 
			String notifyUrl, 
			String returnUrl, 
			String state, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String markDelete, 
			String cert, 
			String availablePayChannel
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		ChannelMappingDO channelMappingDO = new ChannelMappingDO();
		channelMappingDO.setId(id);
		channelMappingDO.setChannelMappingId(channelMappingId);
		channelMappingDO.setChannelId(channelId);
		channelMappingDO.setChannelName(channelName);
		channelMappingDO.setPartnerId(partnerId);
		channelMappingDO.setPartnerName(partnerName);
		channelMappingDO.setWechatAppid(wechatAppid);
		channelMappingDO.setAlipayAppid(alipayAppid);
		channelMappingDO.setWechatAppAppid(wechatAppAppid);
		channelMappingDO.setAlipayAppAppid(alipayAppAppid);
		channelMappingDO.setPassword(password);
		channelMappingDO.setChannelPartnerId(channelPartnerId);
		channelMappingDO.setSubChannelPartnerId(subChannelPartnerId);
		channelMappingDO.setSign(sign);
		channelMappingDO.setPublicKey(publicKey);
		channelMappingDO.setSystemPublicKey(systemPublicKey);
		channelMappingDO.setPrivateKey(privateKey);
		channelMappingDO.setNotifyUrl(notifyUrl);
		channelMappingDO.setReturnUrl(returnUrl);
		channelMappingDO.setState(state);
		channelMappingDO.setRawAddTime(rawAddTime);
		channelMappingDO.setRawUpdateTime(rawUpdateTime);
		channelMappingDO.setMarkDelete(markDelete);
		channelMappingDO.setCert(cert);
		channelMappingDO.setAvailablePayChannel(availablePayChannel);
		channelMappingDAO.insert(channelMappingDO);
	}
	

	/**
	 * 根据id删除channel_mapping表数据
	 */
	public void cleanChannelMappingById(long id) {
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andIdEqualTo(id);
		channelMappingDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelMappingId删除channel_mapping表数据
	 */
	public void cleanChannelMappingByChannelMappingId(String channelMappingId) {
		if (StringUtils.isBlank(channelMappingId)){
			channelMappingId = "test_channelMappingId";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andChannelMappingIdEqualTo(channelMappingId);
		channelMappingDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除channel_mapping表数据
	 */
	public void cleanChannelMappingByChannelId(String channelId) {
		if (StringUtils.isBlank(channelId)){
			channelId = "test_channelId";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		channelMappingDAO.deleteByExample(exam);
	}

	/**
	* 根据channelName删除channel_mapping表数据
	*/
	public void cleanChannelMappingByChannelName(String channelName) {
		if (StringUtils.isBlank(channelName)){
			channelName = "test_channelName";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andChannelNameEqualTo(channelName);
		channelMappingDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除channel_mapping表数据
	 */
	public void cleanChannelMappingByPartnerId(String partnerId) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		channelMappingDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除channel_mapping表数据
	*/
	public void cleanChannelMappingByPartnerName(String partnerName) {
		if (StringUtils.isBlank(partnerName)){
			partnerName = "test_partnerName";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		channelMappingDAO.deleteByExample(exam);
	}

	/**
	 * 根据wechatAppid删除channel_mapping表数据
	 */
	public void cleanChannelMappingByWechatAppid(String wechatAppid) {
		if (StringUtils.isBlank(wechatAppid)){
			wechatAppid = "test_wechatAppid";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andWechatAppidEqualTo(wechatAppid);
		channelMappingDAO.deleteByExample(exam);
	}

	/**
	 * 根据alipayAppid删除channel_mapping表数据
	 */
	public void cleanChannelMappingByAlipayAppid(String alipayAppid) {
		if (StringUtils.isBlank(alipayAppid)){
			alipayAppid = "test_alipayAppid";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andAlipayAppidEqualTo(alipayAppid);
		channelMappingDAO.deleteByExample(exam);
	}

	/**
	 * 根据wechatAppAppid删除channel_mapping表数据
	 */
	public void cleanChannelMappingByWechatAppAppid(String wechatAppAppid) {
		if (StringUtils.isBlank(wechatAppAppid)){
			wechatAppAppid = "test_wechatAppAppid";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andWechatAppAppidEqualTo(wechatAppAppid);
		channelMappingDAO.deleteByExample(exam);
	}

	/**
	 * 根据alipayAppAppid删除channel_mapping表数据
	 */
	public void cleanChannelMappingByAlipayAppAppid(String alipayAppAppid) {
		if (StringUtils.isBlank(alipayAppAppid)){
			alipayAppAppid = "test_alipayAppAppid";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andAlipayAppAppidEqualTo(alipayAppAppid);
		channelMappingDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelPartnerId删除channel_mapping表数据
	 */
	public void cleanChannelMappingByChannelPartnerId(String channelPartnerId) {
		if (StringUtils.isBlank(channelPartnerId)){
			channelPartnerId = "test_channelPartnerId";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andChannelPartnerIdEqualTo(channelPartnerId);
		channelMappingDAO.deleteByExample(exam);
	}

	/**
	 * 根据subChannelPartnerId删除channel_mapping表数据
	 */
	public void cleanChannelMappingBySubChannelPartnerId(String subChannelPartnerId) {
		if (StringUtils.isBlank(subChannelPartnerId)){
			subChannelPartnerId = "test_subChannelPartnerId";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andSubChannelPartnerIdEqualTo(subChannelPartnerId);
		channelMappingDAO.deleteByExample(exam);
	}


    /**
	 * 根据id查询channel_mapping表数据
	 */
	public List<ChannelMappingDO> findChannelMappingById(long id) {
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return channelMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据channelMappingId查询channel_mapping表数据
	 */
	public List<ChannelMappingDO> findChannelMappingByChannelMappingId(String channelMappingId) {
		if (StringUtils.isBlank(channelMappingId)){
			channelMappingId = "test_channelMappingId";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andChannelMappingIdEqualTo(channelMappingId);
		return channelMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询channel_mapping表数据
	 */
	public List<ChannelMappingDO> findChannelMappingByChannelId(String channelId) {
		if (StringUtils.isBlank(channelId)){
			channelId = "test_channelId";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return channelMappingDAO.selectByExample(exam);
	}

	/**
	* 根据channelName查询channel_mapping表数据
	*/
	public List<ChannelMappingDO> findChannelMappingByChannelName(String channelName) {
		if (StringUtils.isBlank(channelName)){
			channelName = "test_channelName";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andChannelNameEqualTo(channelName);
		return channelMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询channel_mapping表数据
	 */
	public List<ChannelMappingDO> findChannelMappingByPartnerId(String partnerId) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return channelMappingDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询channel_mapping表数据
	*/
	public List<ChannelMappingDO> findChannelMappingByPartnerName(String partnerName) {
		if (StringUtils.isBlank(partnerName)){
			partnerName = "test_partnerName";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return channelMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据wechatAppid查询channel_mapping表数据
	 */
	public List<ChannelMappingDO> findChannelMappingByWechatAppid(String wechatAppid) {
		if (StringUtils.isBlank(wechatAppid)){
			wechatAppid = "test_wechatAppid";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andWechatAppidEqualTo(wechatAppid);
		return channelMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据alipayAppid查询channel_mapping表数据
	 */
	public List<ChannelMappingDO> findChannelMappingByAlipayAppid(String alipayAppid) {
		if (StringUtils.isBlank(alipayAppid)){
			alipayAppid = "test_alipayAppid";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andAlipayAppidEqualTo(alipayAppid);
		return channelMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据wechatAppAppid查询channel_mapping表数据
	 */
	public List<ChannelMappingDO> findChannelMappingByWechatAppAppid(String wechatAppAppid) {
		if (StringUtils.isBlank(wechatAppAppid)){
			wechatAppAppid = "test_wechatAppAppid";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andWechatAppAppidEqualTo(wechatAppAppid);
		return channelMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据alipayAppAppid查询channel_mapping表数据
	 */
	public List<ChannelMappingDO> findChannelMappingByAlipayAppAppid(String alipayAppAppid) {
		if (StringUtils.isBlank(alipayAppAppid)){
			alipayAppAppid = "test_alipayAppAppid";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andAlipayAppAppidEqualTo(alipayAppAppid);
		return channelMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据channelPartnerId查询channel_mapping表数据
	 */
	public List<ChannelMappingDO> findChannelMappingByChannelPartnerId(String channelPartnerId) {
		if (StringUtils.isBlank(channelPartnerId)){
			channelPartnerId = "test_channelPartnerId";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andChannelPartnerIdEqualTo(channelPartnerId);
		return channelMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据subChannelPartnerId查询channel_mapping表数据
	 */
	public List<ChannelMappingDO> findChannelMappingBySubChannelPartnerId(String subChannelPartnerId) {
		if (StringUtils.isBlank(subChannelPartnerId)){
			subChannelPartnerId = "test_subChannelPartnerId";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andSubChannelPartnerIdEqualTo(subChannelPartnerId);
		return channelMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新channel_mapping表数据
	 */
	public void updateChannelMappingById(long id,ChannelMappingDO channelMappingDO) {
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andIdEqualTo(id);
		channelMappingDAO.updateByExample(channelMappingDO, exam);
	}

    /**
	 * 根据channelMappingId更新channel_mapping表数据
	 */
	public void updateChannelMappingByChannelMappingId(String channelMappingId,ChannelMappingDO channelMappingDO) {
		if (StringUtils.isBlank(channelMappingId)){
			channelMappingId = "test_channelMappingId";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andChannelMappingIdEqualTo(channelMappingId);
		channelMappingDAO.updateByExample(channelMappingDO, exam);
	}

    /**
	 * 根据channelId更新channel_mapping表数据
	 */
	public void updateChannelMappingByChannelId(String channelId,ChannelMappingDO channelMappingDO) {
		if (StringUtils.isBlank(channelId)){
			channelId = "test_channelId";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		channelMappingDAO.updateByExample(channelMappingDO, exam);
	}

	/**
	* 根据channelName更新channel_mapping表数据
	*/
	public void updateChannelMappingByChannelName(String channelName,ChannelMappingDO channelMappingDO) {
		if (StringUtils.isBlank(channelName)){
			channelName = "test_channelName";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andChannelNameEqualTo(channelName);
		channelMappingDAO.updateByExample(channelMappingDO, exam);
	}

    /**
	 * 根据partnerId更新channel_mapping表数据
	 */
	public void updateChannelMappingByPartnerId(String partnerId,ChannelMappingDO channelMappingDO) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		channelMappingDAO.updateByExample(channelMappingDO, exam);
	}

	/**
	* 根据partnerName更新channel_mapping表数据
	*/
	public void updateChannelMappingByPartnerName(String partnerName,ChannelMappingDO channelMappingDO) {
		if (StringUtils.isBlank(partnerName)){
			partnerName = "test_partnerName";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		channelMappingDAO.updateByExample(channelMappingDO, exam);
	}

    /**
	 * 根据wechatAppid更新channel_mapping表数据
	 */
	public void updateChannelMappingByWechatAppid(String wechatAppid,ChannelMappingDO channelMappingDO) {
		if (StringUtils.isBlank(wechatAppid)){
			wechatAppid = "test_wechatAppid";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andWechatAppidEqualTo(wechatAppid);
		channelMappingDAO.updateByExample(channelMappingDO, exam);
	}

    /**
	 * 根据alipayAppid更新channel_mapping表数据
	 */
	public void updateChannelMappingByAlipayAppid(String alipayAppid,ChannelMappingDO channelMappingDO) {
		if (StringUtils.isBlank(alipayAppid)){
			alipayAppid = "test_alipayAppid";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andAlipayAppidEqualTo(alipayAppid);
		channelMappingDAO.updateByExample(channelMappingDO, exam);
	}

    /**
	 * 根据wechatAppAppid更新channel_mapping表数据
	 */
	public void updateChannelMappingByWechatAppAppid(String wechatAppAppid,ChannelMappingDO channelMappingDO) {
		if (StringUtils.isBlank(wechatAppAppid)){
			wechatAppAppid = "test_wechatAppAppid";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andWechatAppAppidEqualTo(wechatAppAppid);
		channelMappingDAO.updateByExample(channelMappingDO, exam);
	}

    /**
	 * 根据alipayAppAppid更新channel_mapping表数据
	 */
	public void updateChannelMappingByAlipayAppAppid(String alipayAppAppid,ChannelMappingDO channelMappingDO) {
		if (StringUtils.isBlank(alipayAppAppid)){
			alipayAppAppid = "test_alipayAppAppid";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andAlipayAppAppidEqualTo(alipayAppAppid);
		channelMappingDAO.updateByExample(channelMappingDO, exam);
	}

    /**
	 * 根据channelPartnerId更新channel_mapping表数据
	 */
	public void updateChannelMappingByChannelPartnerId(String channelPartnerId,ChannelMappingDO channelMappingDO) {
		if (StringUtils.isBlank(channelPartnerId)){
			channelPartnerId = "test_channelPartnerId";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andChannelPartnerIdEqualTo(channelPartnerId);
		channelMappingDAO.updateByExample(channelMappingDO, exam);
	}

    /**
	 * 根据subChannelPartnerId更新channel_mapping表数据
	 */
	public void updateChannelMappingBySubChannelPartnerId(String subChannelPartnerId,ChannelMappingDO channelMappingDO) {
		if (StringUtils.isBlank(subChannelPartnerId)){
			subChannelPartnerId = "test_subChannelPartnerId";
		}
		ChannelMappingDOExample exam = new ChannelMappingDOExample();
		exam.createCriteria().andSubChannelPartnerIdEqualTo(subChannelPartnerId);
		channelMappingDAO.updateByExample(channelMappingDO, exam);
	}

	/**
	 * 断言pay_channel表数据
	 */
	public void assertPayChannel(PayChannelDO expect, PayChannelDO payChannelDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			payChannelDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != payChannelDO.getRawAddTime());
		expect.setRawAddTime(payChannelDO.getRawAddTime());
        Assertions.assertTrue(null != payChannelDO.getRawUpdateTime());
		expect.setRawUpdateTime(payChannelDO.getRawUpdateTime());
		Assertions.assertEquals(expect, payChannelDO);
	}

    /**
	 * 插入pay_channel表数据
	 */
	public void insertPayChannel(PayChannelDO payChannelDO) {
		payChannelDAO.insert(payChannelDO);
	}

    /**
	 * 插入pay_channel表数据
	 */
	public void insertPayChannel(
			long id, 
			String payChannelId, 
			String payType, 
			String state, 
			String payChannel, 
			String payChannelType, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String markDelete
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		PayChannelDO payChannelDO = new PayChannelDO();
		payChannelDO.setId(id);
		payChannelDO.setPayChannelId(payChannelId);
		payChannelDO.setPayType(payType);
		payChannelDO.setState(state);
		payChannelDO.setPayChannel(payChannel);
		payChannelDO.setPayChannelType(payChannelType);
		payChannelDO.setRawAddTime(rawAddTime);
		payChannelDO.setRawUpdateTime(rawUpdateTime);
		payChannelDO.setMarkDelete(markDelete);
		payChannelDAO.insert(payChannelDO);
	}
	

	/**
	 * 根据id删除pay_channel表数据
	 */
	public void cleanPayChannelById(long id) {
		PayChannelDOExample exam = new PayChannelDOExample();
		exam.createCriteria().andIdEqualTo(id);
		payChannelDAO.deleteByExample(exam);
	}

	/**
	 * 根据payChannelId删除pay_channel表数据
	 */
	public void cleanPayChannelByPayChannelId(String payChannelId) {
		if (StringUtils.isBlank(payChannelId)){
			payChannelId = "test_payChannelId";
		}
		PayChannelDOExample exam = new PayChannelDOExample();
		exam.createCriteria().andPayChannelIdEqualTo(payChannelId);
		payChannelDAO.deleteByExample(exam);
	}


    /**
	 * 根据id查询pay_channel表数据
	 */
	public List<PayChannelDO> findPayChannelById(long id) {
		PayChannelDOExample exam = new PayChannelDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return payChannelDAO.selectByExample(exam);
	}

    /**
	 * 根据payChannelId查询pay_channel表数据
	 */
	public List<PayChannelDO> findPayChannelByPayChannelId(String payChannelId) {
		if (StringUtils.isBlank(payChannelId)){
			payChannelId = "test_payChannelId";
		}
		PayChannelDOExample exam = new PayChannelDOExample();
		exam.createCriteria().andPayChannelIdEqualTo(payChannelId);
		return payChannelDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新pay_channel表数据
	 */
	public void updatePayChannelById(long id,PayChannelDO payChannelDO) {
		PayChannelDOExample exam = new PayChannelDOExample();
		exam.createCriteria().andIdEqualTo(id);
		payChannelDAO.updateByExample(payChannelDO, exam);
	}

    /**
	 * 根据payChannelId更新pay_channel表数据
	 */
	public void updatePayChannelByPayChannelId(String payChannelId,PayChannelDO payChannelDO) {
		if (StringUtils.isBlank(payChannelId)){
			payChannelId = "test_payChannelId";
		}
		PayChannelDOExample exam = new PayChannelDOExample();
		exam.createCriteria().andPayChannelIdEqualTo(payChannelId);
		payChannelDAO.updateByExample(payChannelDO, exam);
	}

	/**
	 * 断言route_mapping表数据
	 */
	public void assertRouteMapping(RouteMappingDO expect, RouteMappingDO routeMappingDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			routeMappingDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != routeMappingDO.getRawAddTime());
		expect.setRawAddTime(routeMappingDO.getRawAddTime());
        Assertions.assertTrue(null != routeMappingDO.getRawUpdateTime());
		expect.setRawUpdateTime(routeMappingDO.getRawUpdateTime());
		Assertions.assertEquals(expect, routeMappingDO);
	}

    /**
	 * 插入route_mapping表数据
	 */
	public void insertRouteMapping(RouteMappingDO routeMappingDO) {
		routeMappingDAO.insert(routeMappingDO);
	}

    /**
	 * 插入route_mapping表数据
	 */
	public void insertRouteMapping(
			long id, 
			String partnerId, 
			String partnerName, 
			String routeStrategyId, 
			String routeStrategyName, 
			String routeExpression, 
			String expressionData, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String markDelete
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		RouteMappingDO routeMappingDO = new RouteMappingDO();
		routeMappingDO.setId(id);
		routeMappingDO.setPartnerId(partnerId);
		routeMappingDO.setPartnerName(partnerName);
		routeMappingDO.setRouteStrategyId(routeStrategyId);
		routeMappingDO.setRouteStrategyName(routeStrategyName);
		routeMappingDO.setRouteExpression(routeExpression);
		routeMappingDO.setExpressionData(expressionData);
		routeMappingDO.setRawAddTime(rawAddTime);
		routeMappingDO.setRawUpdateTime(rawUpdateTime);
		routeMappingDO.setMarkDelete(markDelete);
		routeMappingDAO.insert(routeMappingDO);
	}
	

	/**
	 * 根据id删除route_mapping表数据
	 */
	public void cleanRouteMappingById(long id) {
		RouteMappingDOExample exam = new RouteMappingDOExample();
		exam.createCriteria().andIdEqualTo(id);
		routeMappingDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除route_mapping表数据
	 */
	public void cleanRouteMappingByPartnerId(String partnerId) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		RouteMappingDOExample exam = new RouteMappingDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		routeMappingDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除route_mapping表数据
	*/
	public void cleanRouteMappingByPartnerName(String partnerName) {
		if (StringUtils.isBlank(partnerName)){
			partnerName = "test_partnerName";
		}
		RouteMappingDOExample exam = new RouteMappingDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		routeMappingDAO.deleteByExample(exam);
	}

	/**
	 * 根据routeStrategyId删除route_mapping表数据
	 */
	public void cleanRouteMappingByRouteStrategyId(String routeStrategyId) {
		if (StringUtils.isBlank(routeStrategyId)){
			routeStrategyId = "test_routeStrategyId";
		}
		RouteMappingDOExample exam = new RouteMappingDOExample();
		exam.createCriteria().andRouteStrategyIdEqualTo(routeStrategyId);
		routeMappingDAO.deleteByExample(exam);
	}

	/**
	* 根据routeStrategyName删除route_mapping表数据
	*/
	public void cleanRouteMappingByRouteStrategyName(String routeStrategyName) {
		if (StringUtils.isBlank(routeStrategyName)){
			routeStrategyName = "test_routeStrategyName";
		}
		RouteMappingDOExample exam = new RouteMappingDOExample();
		exam.createCriteria().andRouteStrategyNameEqualTo(routeStrategyName);
		routeMappingDAO.deleteByExample(exam);
	}


    /**
	 * 根据id查询route_mapping表数据
	 */
	public List<RouteMappingDO> findRouteMappingById(long id) {
		RouteMappingDOExample exam = new RouteMappingDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return routeMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询route_mapping表数据
	 */
	public List<RouteMappingDO> findRouteMappingByPartnerId(String partnerId) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		RouteMappingDOExample exam = new RouteMappingDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return routeMappingDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询route_mapping表数据
	*/
	public List<RouteMappingDO> findRouteMappingByPartnerName(String partnerName) {
		if (StringUtils.isBlank(partnerName)){
			partnerName = "test_partnerName";
		}
		RouteMappingDOExample exam = new RouteMappingDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return routeMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据routeStrategyId查询route_mapping表数据
	 */
	public List<RouteMappingDO> findRouteMappingByRouteStrategyId(String routeStrategyId) {
		if (StringUtils.isBlank(routeStrategyId)){
			routeStrategyId = "test_routeStrategyId";
		}
		RouteMappingDOExample exam = new RouteMappingDOExample();
		exam.createCriteria().andRouteStrategyIdEqualTo(routeStrategyId);
		return routeMappingDAO.selectByExample(exam);
	}

	/**
	* 根据routeStrategyName查询route_mapping表数据
	*/
	public List<RouteMappingDO> findRouteMappingByRouteStrategyName(String routeStrategyName) {
		if (StringUtils.isBlank(routeStrategyName)){
			routeStrategyName = "test_routeStrategyName";
		}
		RouteMappingDOExample exam = new RouteMappingDOExample();
		exam.createCriteria().andRouteStrategyNameEqualTo(routeStrategyName);
		return routeMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新route_mapping表数据
	 */
	public void updateRouteMappingById(long id,RouteMappingDO routeMappingDO) {
		RouteMappingDOExample exam = new RouteMappingDOExample();
		exam.createCriteria().andIdEqualTo(id);
		routeMappingDAO.updateByExample(routeMappingDO, exam);
	}

    /**
	 * 根据partnerId更新route_mapping表数据
	 */
	public void updateRouteMappingByPartnerId(String partnerId,RouteMappingDO routeMappingDO) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		RouteMappingDOExample exam = new RouteMappingDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		routeMappingDAO.updateByExample(routeMappingDO, exam);
	}

	/**
	* 根据partnerName更新route_mapping表数据
	*/
	public void updateRouteMappingByPartnerName(String partnerName,RouteMappingDO routeMappingDO) {
		if (StringUtils.isBlank(partnerName)){
			partnerName = "test_partnerName";
		}
		RouteMappingDOExample exam = new RouteMappingDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		routeMappingDAO.updateByExample(routeMappingDO, exam);
	}

    /**
	 * 根据routeStrategyId更新route_mapping表数据
	 */
	public void updateRouteMappingByRouteStrategyId(String routeStrategyId,RouteMappingDO routeMappingDO) {
		if (StringUtils.isBlank(routeStrategyId)){
			routeStrategyId = "test_routeStrategyId";
		}
		RouteMappingDOExample exam = new RouteMappingDOExample();
		exam.createCriteria().andRouteStrategyIdEqualTo(routeStrategyId);
		routeMappingDAO.updateByExample(routeMappingDO, exam);
	}

	/**
	* 根据routeStrategyName更新route_mapping表数据
	*/
	public void updateRouteMappingByRouteStrategyName(String routeStrategyName,RouteMappingDO routeMappingDO) {
		if (StringUtils.isBlank(routeStrategyName)){
			routeStrategyName = "test_routeStrategyName";
		}
		RouteMappingDOExample exam = new RouteMappingDOExample();
		exam.createCriteria().andRouteStrategyNameEqualTo(routeStrategyName);
		routeMappingDAO.updateByExample(routeMappingDO, exam);
	}

	/**
	 * 断言route_strategy表数据
	 */
	public void assertRouteStrategy(RouteStrategyDO expect, RouteStrategyDO routeStrategyDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			routeStrategyDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != routeStrategyDO.getRawAddTime());
		expect.setRawAddTime(routeStrategyDO.getRawAddTime());
        Assertions.assertTrue(null != routeStrategyDO.getRawUpdateTime());
		expect.setRawUpdateTime(routeStrategyDO.getRawUpdateTime());
		Assertions.assertEquals(expect, routeStrategyDO);
	}

    /**
	 * 插入route_strategy表数据
	 */
	public void insertRouteStrategy(RouteStrategyDO routeStrategyDO) {
		routeStrategyDAO.insert(routeStrategyDO);
	}

    /**
	 * 插入route_strategy表数据
	 */
	public void insertRouteStrategy(
			long id, 
			String routeStrategyId, 
			String routeStrategyName, 
			String routeStrategyAlgs, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String markDelete
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		RouteStrategyDO routeStrategyDO = new RouteStrategyDO();
		routeStrategyDO.setId(id);
		routeStrategyDO.setRouteStrategyId(routeStrategyId);
		routeStrategyDO.setRouteStrategyName(routeStrategyName);
		routeStrategyDO.setRouteStrategyAlgs(routeStrategyAlgs);
		routeStrategyDO.setRawAddTime(rawAddTime);
		routeStrategyDO.setRawUpdateTime(rawUpdateTime);
		routeStrategyDO.setMarkDelete(markDelete);
		routeStrategyDAO.insert(routeStrategyDO);
	}
	

	/**
	 * 根据id删除route_strategy表数据
	 */
	public void cleanRouteStrategyById(long id) {
		RouteStrategyDOExample exam = new RouteStrategyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		routeStrategyDAO.deleteByExample(exam);
	}

	/**
	 * 根据routeStrategyId删除route_strategy表数据
	 */
	public void cleanRouteStrategyByRouteStrategyId(String routeStrategyId) {
		if (StringUtils.isBlank(routeStrategyId)){
			routeStrategyId = "test_routeStrategyId";
		}
		RouteStrategyDOExample exam = new RouteStrategyDOExample();
		exam.createCriteria().andRouteStrategyIdEqualTo(routeStrategyId);
		routeStrategyDAO.deleteByExample(exam);
	}

	/**
	* 根据routeStrategyName删除route_strategy表数据
	*/
	public void cleanRouteStrategyByRouteStrategyName(String routeStrategyName) {
		if (StringUtils.isBlank(routeStrategyName)){
			routeStrategyName = "test_routeStrategyName";
		}
		RouteStrategyDOExample exam = new RouteStrategyDOExample();
		exam.createCriteria().andRouteStrategyNameEqualTo(routeStrategyName);
		routeStrategyDAO.deleteByExample(exam);
	}


    /**
	 * 根据id查询route_strategy表数据
	 */
	public List<RouteStrategyDO> findRouteStrategyById(long id) {
		RouteStrategyDOExample exam = new RouteStrategyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return routeStrategyDAO.selectByExample(exam);
	}

    /**
	 * 根据routeStrategyId查询route_strategy表数据
	 */
	public List<RouteStrategyDO> findRouteStrategyByRouteStrategyId(String routeStrategyId) {
		if (StringUtils.isBlank(routeStrategyId)){
			routeStrategyId = "test_routeStrategyId";
		}
		RouteStrategyDOExample exam = new RouteStrategyDOExample();
		exam.createCriteria().andRouteStrategyIdEqualTo(routeStrategyId);
		return routeStrategyDAO.selectByExample(exam);
	}

	/**
	* 根据routeStrategyName查询route_strategy表数据
	*/
	public List<RouteStrategyDO> findRouteStrategyByRouteStrategyName(String routeStrategyName) {
		if (StringUtils.isBlank(routeStrategyName)){
			routeStrategyName = "test_routeStrategyName";
		}
		RouteStrategyDOExample exam = new RouteStrategyDOExample();
		exam.createCriteria().andRouteStrategyNameEqualTo(routeStrategyName);
		return routeStrategyDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新route_strategy表数据
	 */
	public void updateRouteStrategyById(long id,RouteStrategyDO routeStrategyDO) {
		RouteStrategyDOExample exam = new RouteStrategyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		routeStrategyDAO.updateByExample(routeStrategyDO, exam);
	}

    /**
	 * 根据routeStrategyId更新route_strategy表数据
	 */
	public void updateRouteStrategyByRouteStrategyId(String routeStrategyId,RouteStrategyDO routeStrategyDO) {
		if (StringUtils.isBlank(routeStrategyId)){
			routeStrategyId = "test_routeStrategyId";
		}
		RouteStrategyDOExample exam = new RouteStrategyDOExample();
		exam.createCriteria().andRouteStrategyIdEqualTo(routeStrategyId);
		routeStrategyDAO.updateByExample(routeStrategyDO, exam);
	}

	/**
	* 根据routeStrategyName更新route_strategy表数据
	*/
	public void updateRouteStrategyByRouteStrategyName(String routeStrategyName,RouteStrategyDO routeStrategyDO) {
		if (StringUtils.isBlank(routeStrategyName)){
			routeStrategyName = "test_routeStrategyName";
		}
		RouteStrategyDOExample exam = new RouteStrategyDOExample();
		exam.createCriteria().andRouteStrategyNameEqualTo(routeStrategyName);
		routeStrategyDAO.updateByExample(routeStrategyDO, exam);
	}

	/**
	 * 断言settle_channel表数据
	 */
	public void assertSettleChannel(SettleChannelDO expect, SettleChannelDO settleChannelDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			settleChannelDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != settleChannelDO.getRawAddTime());
		expect.setRawAddTime(settleChannelDO.getRawAddTime());
        Assertions.assertTrue(null != settleChannelDO.getRawUpdateTime());
		expect.setRawUpdateTime(settleChannelDO.getRawUpdateTime());
		Assertions.assertEquals(expect, settleChannelDO);
	}

    /**
	 * 插入settle_channel表数据
	 */
	public void insertSettleChannel(SettleChannelDO settleChannelDO) {
		settleChannelDAO.insert(settleChannelDO);
	}

    /**
	 * 插入settle_channel表数据
	 */
	public void insertSettleChannel(
			long id, 
			String settleChannelId, 
			String channelId, 
			String channelName, 
			String payChannelId, 
			String settleChannelName, 
			String state, 
			String rateType, 
			Integer rate, 
			Integer synTimeDelay, 
			Integer synTps, 
			Integer asynTimeDelay, 
			String retryType, 
			String metadatas, 
			long maxCeiling, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String markDelete
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		SettleChannelDO settleChannelDO = new SettleChannelDO();
		settleChannelDO.setId(id);
		settleChannelDO.setSettleChannelId(settleChannelId);
		settleChannelDO.setChannelId(channelId);
		settleChannelDO.setChannelName(channelName);
		settleChannelDO.setPayChannelId(payChannelId);
		settleChannelDO.setSettleChannelName(settleChannelName);
		settleChannelDO.setState(state);
		settleChannelDO.setRateType(rateType);
		settleChannelDO.setRate(rate);
		settleChannelDO.setSynTimeDelay(synTimeDelay);
		settleChannelDO.setSynTps(synTps);
		settleChannelDO.setAsynTimeDelay(asynTimeDelay);
		settleChannelDO.setRetryType(retryType);
		settleChannelDO.setMetadatas(metadatas);
		settleChannelDO.setMaxCeiling(maxCeiling);
		settleChannelDO.setRawAddTime(rawAddTime);
		settleChannelDO.setRawUpdateTime(rawUpdateTime);
		settleChannelDO.setMarkDelete(markDelete);
		settleChannelDAO.insert(settleChannelDO);
	}
	

	/**
	 * 根据id删除settle_channel表数据
	 */
	public void cleanSettleChannelById(long id) {
		SettleChannelDOExample exam = new SettleChannelDOExample();
		exam.createCriteria().andIdEqualTo(id);
		settleChannelDAO.deleteByExample(exam);
	}

	/**
	 * 根据settleChannelId删除settle_channel表数据
	 */
	public void cleanSettleChannelBySettleChannelId(String settleChannelId) {
		if (StringUtils.isBlank(settleChannelId)){
			settleChannelId = "test_settleChannelId";
		}
		SettleChannelDOExample exam = new SettleChannelDOExample();
		exam.createCriteria().andSettleChannelIdEqualTo(settleChannelId);
		settleChannelDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除settle_channel表数据
	 */
	public void cleanSettleChannelByChannelId(String channelId) {
		if (StringUtils.isBlank(channelId)){
			channelId = "test_channelId";
		}
		SettleChannelDOExample exam = new SettleChannelDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		settleChannelDAO.deleteByExample(exam);
	}

	/**
	* 根据channelName删除settle_channel表数据
	*/
	public void cleanSettleChannelByChannelName(String channelName) {
		if (StringUtils.isBlank(channelName)){
			channelName = "test_channelName";
		}
		SettleChannelDOExample exam = new SettleChannelDOExample();
		exam.createCriteria().andChannelNameEqualTo(channelName);
		settleChannelDAO.deleteByExample(exam);
	}

	/**
	 * 根据payChannelId删除settle_channel表数据
	 */
	public void cleanSettleChannelByPayChannelId(String payChannelId) {
		if (StringUtils.isBlank(payChannelId)){
			payChannelId = "test_payChannelId";
		}
		SettleChannelDOExample exam = new SettleChannelDOExample();
		exam.createCriteria().andPayChannelIdEqualTo(payChannelId);
		settleChannelDAO.deleteByExample(exam);
	}

	/**
	* 根据settleChannelName删除settle_channel表数据
	*/
	public void cleanSettleChannelBySettleChannelName(String settleChannelName) {
		if (StringUtils.isBlank(settleChannelName)){
			settleChannelName = "test_settleChannelName";
		}
		SettleChannelDOExample exam = new SettleChannelDOExample();
		exam.createCriteria().andSettleChannelNameEqualTo(settleChannelName);
		settleChannelDAO.deleteByExample(exam);
	}


    /**
	 * 根据id查询settle_channel表数据
	 */
	public List<SettleChannelDO> findSettleChannelById(long id) {
		SettleChannelDOExample exam = new SettleChannelDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return settleChannelDAO.selectByExample(exam);
	}

    /**
	 * 根据settleChannelId查询settle_channel表数据
	 */
	public List<SettleChannelDO> findSettleChannelBySettleChannelId(String settleChannelId) {
		if (StringUtils.isBlank(settleChannelId)){
			settleChannelId = "test_settleChannelId";
		}
		SettleChannelDOExample exam = new SettleChannelDOExample();
		exam.createCriteria().andSettleChannelIdEqualTo(settleChannelId);
		return settleChannelDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询settle_channel表数据
	 */
	public List<SettleChannelDO> findSettleChannelByChannelId(String channelId) {
		if (StringUtils.isBlank(channelId)){
			channelId = "test_channelId";
		}
		SettleChannelDOExample exam = new SettleChannelDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return settleChannelDAO.selectByExample(exam);
	}

	/**
	* 根据channelName查询settle_channel表数据
	*/
	public List<SettleChannelDO> findSettleChannelByChannelName(String channelName) {
		if (StringUtils.isBlank(channelName)){
			channelName = "test_channelName";
		}
		SettleChannelDOExample exam = new SettleChannelDOExample();
		exam.createCriteria().andChannelNameEqualTo(channelName);
		return settleChannelDAO.selectByExample(exam);
	}

    /**
	 * 根据payChannelId查询settle_channel表数据
	 */
	public List<SettleChannelDO> findSettleChannelByPayChannelId(String payChannelId) {
		if (StringUtils.isBlank(payChannelId)){
			payChannelId = "test_payChannelId";
		}
		SettleChannelDOExample exam = new SettleChannelDOExample();
		exam.createCriteria().andPayChannelIdEqualTo(payChannelId);
		return settleChannelDAO.selectByExample(exam);
	}

	/**
	* 根据settleChannelName查询settle_channel表数据
	*/
	public List<SettleChannelDO> findSettleChannelBySettleChannelName(String settleChannelName) {
		if (StringUtils.isBlank(settleChannelName)){
			settleChannelName = "test_settleChannelName";
		}
		SettleChannelDOExample exam = new SettleChannelDOExample();
		exam.createCriteria().andSettleChannelNameEqualTo(settleChannelName);
		return settleChannelDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新settle_channel表数据
	 */
	public void updateSettleChannelById(long id,SettleChannelDO settleChannelDO) {
		SettleChannelDOExample exam = new SettleChannelDOExample();
		exam.createCriteria().andIdEqualTo(id);
		settleChannelDAO.updateByExample(settleChannelDO, exam);
	}

    /**
	 * 根据settleChannelId更新settle_channel表数据
	 */
	public void updateSettleChannelBySettleChannelId(String settleChannelId,SettleChannelDO settleChannelDO) {
		if (StringUtils.isBlank(settleChannelId)){
			settleChannelId = "test_settleChannelId";
		}
		SettleChannelDOExample exam = new SettleChannelDOExample();
		exam.createCriteria().andSettleChannelIdEqualTo(settleChannelId);
		settleChannelDAO.updateByExample(settleChannelDO, exam);
	}

    /**
	 * 根据channelId更新settle_channel表数据
	 */
	public void updateSettleChannelByChannelId(String channelId,SettleChannelDO settleChannelDO) {
		if (StringUtils.isBlank(channelId)){
			channelId = "test_channelId";
		}
		SettleChannelDOExample exam = new SettleChannelDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		settleChannelDAO.updateByExample(settleChannelDO, exam);
	}

	/**
	* 根据channelName更新settle_channel表数据
	*/
	public void updateSettleChannelByChannelName(String channelName,SettleChannelDO settleChannelDO) {
		if (StringUtils.isBlank(channelName)){
			channelName = "test_channelName";
		}
		SettleChannelDOExample exam = new SettleChannelDOExample();
		exam.createCriteria().andChannelNameEqualTo(channelName);
		settleChannelDAO.updateByExample(settleChannelDO, exam);
	}

    /**
	 * 根据payChannelId更新settle_channel表数据
	 */
	public void updateSettleChannelByPayChannelId(String payChannelId,SettleChannelDO settleChannelDO) {
		if (StringUtils.isBlank(payChannelId)){
			payChannelId = "test_payChannelId";
		}
		SettleChannelDOExample exam = new SettleChannelDOExample();
		exam.createCriteria().andPayChannelIdEqualTo(payChannelId);
		settleChannelDAO.updateByExample(settleChannelDO, exam);
	}

	/**
	* 根据settleChannelName更新settle_channel表数据
	*/
	public void updateSettleChannelBySettleChannelName(String settleChannelName,SettleChannelDO settleChannelDO) {
		if (StringUtils.isBlank(settleChannelName)){
			settleChannelName = "test_settleChannelName";
		}
		SettleChannelDOExample exam = new SettleChannelDOExample();
		exam.createCriteria().andSettleChannelNameEqualTo(settleChannelName);
		settleChannelDAO.updateByExample(settleChannelDO, exam);
	}

	/**
	 * 断言settle_channel_mapping表数据
	 */
	public void assertSettleChannelMapping(SettleChannelMappingDO expect, SettleChannelMappingDO settleChannelMappingDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			settleChannelMappingDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != settleChannelMappingDO.getRawAddTime());
		expect.setRawAddTime(settleChannelMappingDO.getRawAddTime());
        Assertions.assertTrue(null != settleChannelMappingDO.getRawUpdateTime());
		expect.setRawUpdateTime(settleChannelMappingDO.getRawUpdateTime());
		Assertions.assertEquals(expect, settleChannelMappingDO);
	}

    /**
	 * 插入settle_channel_mapping表数据
	 */
	public void insertSettleChannelMapping(SettleChannelMappingDO settleChannelMappingDO) {
		settleChannelMappingDAO.insert(settleChannelMappingDO);
	}

    /**
	 * 插入settle_channel_mapping表数据
	 */
	public void insertSettleChannelMapping(
			long id, 
			String partnerId, 
			String partnerName, 
			String settleChannelId, 
			String settleChannelName, 
			String channelId, 
			String channelName, 
			Integer rate, 
			String state, 
			long maxCeiling, 
			Integer priority, 
			String rateType, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String markDelete
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		SettleChannelMappingDO settleChannelMappingDO = new SettleChannelMappingDO();
		settleChannelMappingDO.setId(id);
		settleChannelMappingDO.setPartnerId(partnerId);
		settleChannelMappingDO.setPartnerName(partnerName);
		settleChannelMappingDO.setSettleChannelId(settleChannelId);
		settleChannelMappingDO.setSettleChannelName(settleChannelName);
		settleChannelMappingDO.setChannelId(channelId);
		settleChannelMappingDO.setChannelName(channelName);
		settleChannelMappingDO.setRate(rate);
		settleChannelMappingDO.setState(state);
		settleChannelMappingDO.setMaxCeiling(maxCeiling);
		settleChannelMappingDO.setPriority(priority);
		settleChannelMappingDO.setRateType(rateType);
		settleChannelMappingDO.setRawAddTime(rawAddTime);
		settleChannelMappingDO.setRawUpdateTime(rawUpdateTime);
		settleChannelMappingDO.setMarkDelete(markDelete);
		settleChannelMappingDAO.insert(settleChannelMappingDO);
	}
	

	/**
	 * 根据id删除settle_channel_mapping表数据
	 */
	public void cleanSettleChannelMappingById(long id) {
		SettleChannelMappingDOExample exam = new SettleChannelMappingDOExample();
		exam.createCriteria().andIdEqualTo(id);
		settleChannelMappingDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除settle_channel_mapping表数据
	 */
	public void cleanSettleChannelMappingByPartnerId(String partnerId) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		SettleChannelMappingDOExample exam = new SettleChannelMappingDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		settleChannelMappingDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除settle_channel_mapping表数据
	*/
	public void cleanSettleChannelMappingByPartnerName(String partnerName) {
		if (StringUtils.isBlank(partnerName)){
			partnerName = "test_partnerName";
		}
		SettleChannelMappingDOExample exam = new SettleChannelMappingDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		settleChannelMappingDAO.deleteByExample(exam);
	}

	/**
	 * 根据settleChannelId删除settle_channel_mapping表数据
	 */
	public void cleanSettleChannelMappingBySettleChannelId(String settleChannelId) {
		if (StringUtils.isBlank(settleChannelId)){
			settleChannelId = "test_settleChannelId";
		}
		SettleChannelMappingDOExample exam = new SettleChannelMappingDOExample();
		exam.createCriteria().andSettleChannelIdEqualTo(settleChannelId);
		settleChannelMappingDAO.deleteByExample(exam);
	}

	/**
	* 根据settleChannelName删除settle_channel_mapping表数据
	*/
	public void cleanSettleChannelMappingBySettleChannelName(String settleChannelName) {
		if (StringUtils.isBlank(settleChannelName)){
			settleChannelName = "test_settleChannelName";
		}
		SettleChannelMappingDOExample exam = new SettleChannelMappingDOExample();
		exam.createCriteria().andSettleChannelNameEqualTo(settleChannelName);
		settleChannelMappingDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除settle_channel_mapping表数据
	 */
	public void cleanSettleChannelMappingByChannelId(String channelId) {
		if (StringUtils.isBlank(channelId)){
			channelId = "test_channelId";
		}
		SettleChannelMappingDOExample exam = new SettleChannelMappingDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		settleChannelMappingDAO.deleteByExample(exam);
	}

	/**
	* 根据channelName删除settle_channel_mapping表数据
	*/
	public void cleanSettleChannelMappingByChannelName(String channelName) {
		if (StringUtils.isBlank(channelName)){
			channelName = "test_channelName";
		}
		SettleChannelMappingDOExample exam = new SettleChannelMappingDOExample();
		exam.createCriteria().andChannelNameEqualTo(channelName);
		settleChannelMappingDAO.deleteByExample(exam);
	}


    /**
	 * 根据id查询settle_channel_mapping表数据
	 */
	public List<SettleChannelMappingDO> findSettleChannelMappingById(long id) {
		SettleChannelMappingDOExample exam = new SettleChannelMappingDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return settleChannelMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询settle_channel_mapping表数据
	 */
	public List<SettleChannelMappingDO> findSettleChannelMappingByPartnerId(String partnerId) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		SettleChannelMappingDOExample exam = new SettleChannelMappingDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return settleChannelMappingDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询settle_channel_mapping表数据
	*/
	public List<SettleChannelMappingDO> findSettleChannelMappingByPartnerName(String partnerName) {
		if (StringUtils.isBlank(partnerName)){
			partnerName = "test_partnerName";
		}
		SettleChannelMappingDOExample exam = new SettleChannelMappingDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return settleChannelMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据settleChannelId查询settle_channel_mapping表数据
	 */
	public List<SettleChannelMappingDO> findSettleChannelMappingBySettleChannelId(String settleChannelId) {
		if (StringUtils.isBlank(settleChannelId)){
			settleChannelId = "test_settleChannelId";
		}
		SettleChannelMappingDOExample exam = new SettleChannelMappingDOExample();
		exam.createCriteria().andSettleChannelIdEqualTo(settleChannelId);
		return settleChannelMappingDAO.selectByExample(exam);
	}

	/**
	* 根据settleChannelName查询settle_channel_mapping表数据
	*/
	public List<SettleChannelMappingDO> findSettleChannelMappingBySettleChannelName(String settleChannelName) {
		if (StringUtils.isBlank(settleChannelName)){
			settleChannelName = "test_settleChannelName";
		}
		SettleChannelMappingDOExample exam = new SettleChannelMappingDOExample();
		exam.createCriteria().andSettleChannelNameEqualTo(settleChannelName);
		return settleChannelMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询settle_channel_mapping表数据
	 */
	public List<SettleChannelMappingDO> findSettleChannelMappingByChannelId(String channelId) {
		if (StringUtils.isBlank(channelId)){
			channelId = "test_channelId";
		}
		SettleChannelMappingDOExample exam = new SettleChannelMappingDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return settleChannelMappingDAO.selectByExample(exam);
	}

	/**
	* 根据channelName查询settle_channel_mapping表数据
	*/
	public List<SettleChannelMappingDO> findSettleChannelMappingByChannelName(String channelName) {
		if (StringUtils.isBlank(channelName)){
			channelName = "test_channelName";
		}
		SettleChannelMappingDOExample exam = new SettleChannelMappingDOExample();
		exam.createCriteria().andChannelNameEqualTo(channelName);
		return settleChannelMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新settle_channel_mapping表数据
	 */
	public void updateSettleChannelMappingById(long id,SettleChannelMappingDO settleChannelMappingDO) {
		SettleChannelMappingDOExample exam = new SettleChannelMappingDOExample();
		exam.createCriteria().andIdEqualTo(id);
		settleChannelMappingDAO.updateByExample(settleChannelMappingDO, exam);
	}

    /**
	 * 根据partnerId更新settle_channel_mapping表数据
	 */
	public void updateSettleChannelMappingByPartnerId(String partnerId,SettleChannelMappingDO settleChannelMappingDO) {
		if (StringUtils.isBlank(partnerId)){
			partnerId = "test_partnerId";
		}
		SettleChannelMappingDOExample exam = new SettleChannelMappingDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		settleChannelMappingDAO.updateByExample(settleChannelMappingDO, exam);
	}

	/**
	* 根据partnerName更新settle_channel_mapping表数据
	*/
	public void updateSettleChannelMappingByPartnerName(String partnerName,SettleChannelMappingDO settleChannelMappingDO) {
		if (StringUtils.isBlank(partnerName)){
			partnerName = "test_partnerName";
		}
		SettleChannelMappingDOExample exam = new SettleChannelMappingDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		settleChannelMappingDAO.updateByExample(settleChannelMappingDO, exam);
	}

    /**
	 * 根据settleChannelId更新settle_channel_mapping表数据
	 */
	public void updateSettleChannelMappingBySettleChannelId(String settleChannelId,SettleChannelMappingDO settleChannelMappingDO) {
		if (StringUtils.isBlank(settleChannelId)){
			settleChannelId = "test_settleChannelId";
		}
		SettleChannelMappingDOExample exam = new SettleChannelMappingDOExample();
		exam.createCriteria().andSettleChannelIdEqualTo(settleChannelId);
		settleChannelMappingDAO.updateByExample(settleChannelMappingDO, exam);
	}

	/**
	* 根据settleChannelName更新settle_channel_mapping表数据
	*/
	public void updateSettleChannelMappingBySettleChannelName(String settleChannelName,SettleChannelMappingDO settleChannelMappingDO) {
		if (StringUtils.isBlank(settleChannelName)){
			settleChannelName = "test_settleChannelName";
		}
		SettleChannelMappingDOExample exam = new SettleChannelMappingDOExample();
		exam.createCriteria().andSettleChannelNameEqualTo(settleChannelName);
		settleChannelMappingDAO.updateByExample(settleChannelMappingDO, exam);
	}

    /**
	 * 根据channelId更新settle_channel_mapping表数据
	 */
	public void updateSettleChannelMappingByChannelId(String channelId,SettleChannelMappingDO settleChannelMappingDO) {
		if (StringUtils.isBlank(channelId)){
			channelId = "test_channelId";
		}
		SettleChannelMappingDOExample exam = new SettleChannelMappingDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		settleChannelMappingDAO.updateByExample(settleChannelMappingDO, exam);
	}

	/**
	* 根据channelName更新settle_channel_mapping表数据
	*/
	public void updateSettleChannelMappingByChannelName(String channelName,SettleChannelMappingDO settleChannelMappingDO) {
		if (StringUtils.isBlank(channelName)){
			channelName = "test_channelName";
		}
		SettleChannelMappingDOExample exam = new SettleChannelMappingDOExample();
		exam.createCriteria().andChannelNameEqualTo(channelName);
		settleChannelMappingDAO.updateByExample(settleChannelMappingDO, exam);
	}

}
