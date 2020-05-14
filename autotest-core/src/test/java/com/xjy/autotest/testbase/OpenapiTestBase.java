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
import dal.dao.openapi.*;
import dal.model.openapi.*;
import com.xjy.autotest.config.OpenapiDataSourceConfig;

/**
 * @author autotest
 * Created on 2019/07/12.
 */
@Service
@Import({
        OpenapiDataSourceConfig.class
})
public class OpenapiTestBase {

	@Autowired
	OrderInfoDAO orderInfoDAO;

	public OrderInfoDAO getOrderInfoDAO() {
		return this.orderInfoDAO;
	}


	/**
	 * 断言order_info表数据
	 */
	public void assertOrderInfo(OrderInfoDO expect, OrderInfoDO orderInfoDO) {
		Assertions.assertTrue(null != orderInfoDO.getRawAddTime());
		expect.setRawAddTime(orderInfoDO.getRawAddTime());
        Assertions.assertTrue(null != orderInfoDO.getRawUpdateTime());
		expect.setRawUpdateTime(orderInfoDO.getRawUpdateTime());
		Assertions.assertEquals(expect, orderInfoDO);
	}

    /**
	 * 插入order_info表数据
	 */
	public void insertOrderInfo(OrderInfoDO orderInfoDO) {
		orderInfoDAO.insert(orderInfoDO);
	}

    /**
	 * 插入order_info表数据
	 */
	public void insertOrderInfo(
			long identity, 
			String merchantOrderNo, 
			String partnerId, 
			String service, 
			String version, 
			String returnUrl, 
			String notifyUrl, 
			String gid, 
			String reqId, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String requestData
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		OrderInfoDO orderInfoDO = new OrderInfoDO();
		orderInfoDO.setIdentity(identity);
		orderInfoDO.setMerchantOrderNo(merchantOrderNo);
		orderInfoDO.setPartnerId(partnerId);
		orderInfoDO.setService(service);
		orderInfoDO.setVersion(version);
		orderInfoDO.setReturnUrl(returnUrl);
		orderInfoDO.setNotifyUrl(notifyUrl);
		orderInfoDO.setGid(gid);
		orderInfoDO.setReqId(reqId);
		orderInfoDO.setRawAddTime(rawAddTime);
		orderInfoDO.setRawUpdateTime(rawUpdateTime);
		orderInfoDO.setRequestData(requestData);
		orderInfoDAO.insert(orderInfoDO);
	}

    /**
     * 删除order_info表所有数据
     */
    public void cleanOrderInfo() {
        OrderInfoDOExample exam = new OrderInfoDOExample();
        exam.createCriteria();
        orderInfoDAO.deleteByExample(exam);
    }


	/**
	 * 根据identity删除order_info表数据
	 */
	public void cleanOrderInfoByIdentity(long identity) {
		OrderInfoDOExample exam = new OrderInfoDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		orderInfoDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantOrderNo删除order_info表数据
	 */
	public void cleanOrderInfoByMerchantOrderNo(String merchantOrderNo) {
        if (StringUtils.isBlank(merchantOrderNo)){
            merchantOrderNo = "test_merchantOrderNo";
        }
		OrderInfoDOExample exam = new OrderInfoDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		orderInfoDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除order_info表数据
	 */
	public void cleanOrderInfoByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		OrderInfoDOExample exam = new OrderInfoDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		orderInfoDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除order_info表数据
	 */
	public void cleanOrderInfoByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		OrderInfoDOExample exam = new OrderInfoDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		orderInfoDAO.deleteByExample(exam);
	}

	/**
	 * 根据reqId删除order_info表数据
	 */
	public void cleanOrderInfoByReqId(String reqId) {
        if (StringUtils.isBlank(reqId)){
            reqId = "test_reqId";
        }
		OrderInfoDOExample exam = new OrderInfoDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		orderInfoDAO.deleteByExample(exam);
	}

    /**
     * 查询order_info表所有数据
     */
    public List<OrderInfoDO> findOrderInfoAll() {
        OrderInfoDOExample exam = new OrderInfoDOExample();
        exam.createCriteria();
		return orderInfoDAO.selectByExample(exam);
    }

    /**
	 * 根据identity查询order_info表数据
	 */
	public List<OrderInfoDO> findOrderInfoByIdentity(long identity) {
		OrderInfoDOExample exam = new OrderInfoDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		return orderInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantOrderNo查询order_info表数据
	 */
	public List<OrderInfoDO> findOrderInfoByMerchantOrderNo(String merchantOrderNo) {
		OrderInfoDOExample exam = new OrderInfoDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		return orderInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询order_info表数据
	 */
	public List<OrderInfoDO> findOrderInfoByPartnerId(String partnerId) {
		OrderInfoDOExample exam = new OrderInfoDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return orderInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询order_info表数据
	 */
	public List<OrderInfoDO> findOrderInfoByGid(String gid) {
		OrderInfoDOExample exam = new OrderInfoDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return orderInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据reqId查询order_info表数据
	 */
	public List<OrderInfoDO> findOrderInfoByReqId(String reqId) {
		OrderInfoDOExample exam = new OrderInfoDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		return orderInfoDAO.selectByExample(exam);
	}

    /**
	 * 根据identity更新order_info表数据
	 */
	public void updateOrderInfoByIdentity(long identity,OrderInfoDO orderInfoDO) {
		OrderInfoDOExample exam = new OrderInfoDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		orderInfoDAO.updateByExample(orderInfoDO, exam);
	}

    /**
	 * 根据merchantOrderNo更新order_info表数据
	 */
	public void updateOrderInfoByMerchantOrderNo(String merchantOrderNo,OrderInfoDO orderInfoDO) {
		OrderInfoDOExample exam = new OrderInfoDOExample();
		exam.createCriteria().andMerchantOrderNoEqualTo(merchantOrderNo);
		orderInfoDAO.updateByExample(orderInfoDO, exam);
	}

    /**
	 * 根据partnerId更新order_info表数据
	 */
	public void updateOrderInfoByPartnerId(String partnerId,OrderInfoDO orderInfoDO) {
		OrderInfoDOExample exam = new OrderInfoDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		orderInfoDAO.updateByExample(orderInfoDO, exam);
	}

    /**
	 * 根据gid更新order_info表数据
	 */
	public void updateOrderInfoByGid(String gid,OrderInfoDO orderInfoDO) {
		OrderInfoDOExample exam = new OrderInfoDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		orderInfoDAO.updateByExample(orderInfoDO, exam);
	}

    /**
	 * 根据reqId更新order_info表数据
	 */
	public void updateOrderInfoByReqId(String reqId,OrderInfoDO orderInfoDO) {
		OrderInfoDOExample exam = new OrderInfoDOExample();
		exam.createCriteria().andReqIdEqualTo(reqId);
		orderInfoDAO.updateByExample(orderInfoDO, exam);
	}
}
