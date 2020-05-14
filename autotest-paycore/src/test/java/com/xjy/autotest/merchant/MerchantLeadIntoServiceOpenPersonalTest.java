package com.xjy.autotest.merchant;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.InitData.MerchantInitDataBase;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.DateUtil;
import dal.model.merchant.MerchantDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.merchant.api.result.info.MerchantResult;
import com.xyb.merchant.api.service.MerchantLeadIntoService;
import com.xyb.merchant.api.order.PersonalOrder;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author miantiao Created on 2019/07/03.
 */
public class MerchantLeadIntoServiceOpenPersonalTest extends SpringBootTestBase {
	
	@Reference(version = DUBBO_VERSION)
	MerchantLeadIntoService merchantLeadIntoService;
	
	@Autowired
	MerchantTestBase merchantTestBase;
	
	@Autowired
	MerchantInitDataBase merchantInitDataBase;
	
	@Autowired
	UserTestBase userTestBase;
	
	/**
	 * 1001
	 */
	@AutoTest(file = "merchant/merchantLeadIntoServiceOpenPersonalTestSuccess.csv")
	@DisplayName("--成功用例")
	public void merchantLeadIntoServiceOpenPersonalTestSuccess(
																// 基本参数
																int testId, Status status, String code,
																// 业务参数
																PersonalOrder personalOrder) {
		String partnerId;
		String appId;
		String channelId;
		String appRefreshToken;
		// 清除数据
		merchantTestBase.cleanMerchantByOutUserId(personalOrder.getOutUserId());
		// 准备数据
		Map<String, Object> param = merchantInitDataBase.initPlatMerchant();
		partnerId = param.get("partnerId").toString();
		appId = param.get("appId").toString();
		appRefreshToken = param.get("appRefreshToken").toString();
		channelId = param.get("channelId").toString();
		// 测试过程
		// 调用接口
		MerchantResult result = merchantLeadIntoService.openPersonal(personalOrder);
		// 结果验证
		print(result);
		assertEquals(status, result.getStatus());
		assertEquals(code, result.getCode());
		assertNotNull(result.getUserId());
		// 数据验证
		
		merchantByOutUserIdAssert(personalOrder.getOutUserId(), 1, 1, null, partnerId, personalOrder.getRealName(),
			"SUB_MERCHANT", "ACTIVE", "VERIFICATION", appId, appRefreshToken, channelId);
		// 清除数据
	}
	
	/**
	 * 根据outUserId查询断言merchant表数据
	 * @param outUserId
	 * @param total
	 * @param size
	 * @param partnerId
	 * @param parentPartnerId
	 * @param merchantName
	 * @param merchantType
	 * @param status
	 * @param leadStatus
	 * @param appId
	 * @param appRefreshToken
	 * @param channelId
	 */
	private void merchantByOutUserIdAssert(	String outUserId, int total, int size, String partnerId,
											String parentPartnerId, String merchantName, String merchantType,
											String status, String leadStatus, String appId, String appRefreshToken,
											String channelId) {
		List<MerchantDO> merchantDOS = merchantTestBase.findMerchantByOutUserId(outUserId);
		if (total <= 0) {
			assertEquals(total, merchantDOS.size());
			return;
		}
		assertEquals(total, merchantDOS.size());
		MerchantDO merchantDO = merchantDOS.get(size - 1);
		assertEquals(appId, merchantDO.getAppId());
		assertEquals(appRefreshToken, merchantDO.getAppRefreshToken());
		assertEquals(channelId, merchantDO.getChannelId());
		assertEquals(leadStatus, merchantDO.getLeadStatus());
		assertEquals(merchantName, merchantDO.getMerchantName());
		assertEquals(merchantType, merchantDO.getMerchantType());
		assertEquals(parentPartnerId, merchantDO.getParentPartnerId());
		assertEquals(partnerId, merchantDO.getPartnerId());
		assertEquals(status, merchantDO.getStatus());
		//基本不会有业务场景变化所以直接校验--------------------------------------------------------------------------------
		assertNotNull(merchantDO.getId());
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(merchantDO.getRawUpdateTime()));
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(merchantDO.getRawAddTime()));
	}
	
}
