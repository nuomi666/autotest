package com.xjy.autotest.merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.InitData.MerchantInitDataBase;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.DateUtil;
import com.xyb.merchant.api.order.EnterpriseOrder;
import com.xyb.merchant.api.service.MerchantLeadIntoService;
import dal.model.merchant.MerchantDO;
import dal.model.merchant.MerchantImgDO;
import dal.model.user.AccountDO;
import dal.model.user.UserNotifyTaskDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author miantiao Created on 2019/07/03.
 */
public class MerchantLeadIntoServiceOpenEnterpriseTest extends SpringBootTestBase {
	
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
	@AutoTest(file = "merchant/merchantLeadIntoServiceOpenEnterpriseTestSuccess.csv")
	@DisplayName("--成功用例")
	public void merchantLeadIntoServiceOpenEnterpriseTestSuccess(// 基本参数
																	int testId, Status status, String code,
																	// 业务参数
																	EnterpriseOrder enterpriseOrder) {
		String partnerId;
		String appId;
		String channelId;
		String appRefreshToken;
		
		// 清除数据
		merchantTestBase.cleanMerchant();
		merchantTestBase.cleanMerchantImg();
		userTestBase.cleanUserByMerchantUserId(enterpriseOrder.getOutUserId());
		// 准备数据
		Map<String, Object> param = merchantInitDataBase.initPlatMerchant();
		partnerId = param.get("partnerId").toString();
		appId = param.get("appId").toString();
		appRefreshToken = param.get("appRefreshToken").toString();
		channelId = param.get("channelId").toString();
		// 测试过程
		// 调用接口
		//MerchantResult result = merchantLeadIntoService.openEnterprise(enterpriseOrder);
		//// 结果验证
		//print(result);
		//assertEquals(status, result.getStatus());
		//assertEquals(code, result.getCode());
		//assertNotNull(result.getUserId());
		// 数据验证
		
		merchantByOutUserIdAssert(enterpriseOrder.getOutUserId(), 1, 1, null, partnerId,
			enterpriseOrder.getCompanyName(), "SUB_MERCHANT", "ACTIVE", "BEFORE_REGISTER", appId,
			appRefreshToken, channelId);
		
		//merchantImgByPartnerIdAssert(result.getUserId(), 1, 1, null, null, null, null, null, null,
		//	enterpriseOrder.getBusinessLicenseUrl(), enterpriseOrder.getOrganizationCodeUrl(),
		//	enterpriseOrder.getTaxCertificateUrl(), enterpriseOrder.getBankSettlementUrl(),
		//	enterpriseOrder.getLegalCerificateFrontUrl(), enterpriseOrder.getLegalCerificateBackUrl());
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
	
	/**
	 * 根据partnerId查询断言merchantImg表
	 * @param partnerId
	 * @param total
	 * @param size
	 * @param businessLicenseUrl
	 * @param organizationCodeUrl
	 * @param taxCertificateUrl
	 * @param bankSettlementUrl
	 * @param legalCerificateFrontUrl
	 * @param legalCerificateBackUrl
	 * @param oldBusinessLicenseUrl
	 * @param oldOrganizationCodeUrl
	 * @param oldTaxCertificateUrl
	 * @param oldBankSettlementUrl
	 * @param oldLegalCerificateFrontUrl
	 * @param oldLegalCerificateBackUrl
	 */
	private void merchantImgByPartnerIdAssert(	String partnerId, int total, int size, String businessLicenseUrl,
												String organizationCodeUrl, String taxCertificateUrl,
												String bankSettlementUrl, String legalCerificateFrontUrl,
												String legalCerificateBackUrl, String oldBusinessLicenseUrl,
												String oldOrganizationCodeUrl, String oldTaxCertificateUrl,
												String oldBankSettlementUrl, String oldLegalCerificateFrontUrl,
												String oldLegalCerificateBackUrl) {
		List<MerchantImgDO> merchantImgDOS = merchantTestBase.findMerchantImgByPartnerId(partnerId);
		if (total <= 0) {
			assertEquals(total, merchantImgDOS.size());
			return;
		}
		assertEquals(total, merchantImgDOS.size());
		MerchantImgDO merchantImgDO = merchantImgDOS.get(size - 1);
		assertEquals(bankSettlementUrl, merchantImgDO.getBankSettlementUrl());
		assertEquals(businessLicenseUrl, merchantImgDO.getBusinessLicenseUrl());
		assertEquals(legalCerificateBackUrl, merchantImgDO.getLegalCerificateBackUrl());
		assertEquals(legalCerificateFrontUrl, merchantImgDO.getLegalCerificateFrontUrl());
		assertEquals(oldBankSettlementUrl, merchantImgDO.getOldBankSettlementUrl());
		assertEquals(oldBusinessLicenseUrl, merchantImgDO.getOldBusinessLicenseUrl());
		assertEquals(oldLegalCerificateBackUrl, merchantImgDO.getOldLegalCerificateBackUrl());
		assertEquals(oldLegalCerificateFrontUrl, merchantImgDO.getOldLegalCerificateFrontUrl());
		assertEquals(oldOrganizationCodeUrl, merchantImgDO.getOldOrganizationCodeUrl());
		assertEquals(oldTaxCertificateUrl, merchantImgDO.getOldTaxCertificateUrl());
		assertEquals(organizationCodeUrl, merchantImgDO.getOrganizationCodeUrl());
		assertEquals(taxCertificateUrl, merchantImgDO.getTaxCertificateUrl());
		//基本不会有业务场景变化所以直接校验--------------------------------------------------------------------------------
		assertNotNull(merchantImgDO.getId());
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()),
			DateUtil.dtSimpleFormat(merchantImgDO.getRawUpdateTime()));
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(merchantImgDO.getRawAddTime()));
	}
	
	/**
	 * 根据merchantUserId查询断言xyb-user表
	 * @param merchantUserId
	 * @param total
	 * @param size
	 * @param userId
	 * @param partnerId
	 * @param mobile
	 * @param realName
	 * @param certifyStatus
	 * @param certType
	 * @param certNo
	 */
	private void xybUserByMerchantUserIdAssert(	String merchantUserId, int total, int size, String userId,
												String partnerId, String mobile, String realName, String certifyStatus,
												String certType, String certNo) {
		List<dal.model.user.UserDO> userDOS = userTestBase.findUserByMerchantUserId(merchantUserId);
		if (total <= 0) {
			assertEquals(total, userDOS.size());
			return;
		}
		assertEquals(total, userDOS.size());
		dal.model.user.UserDO userDO = userDOS.get(size - 1);
		assertEquals(userId, userDO.getUserId());
		assertEquals(partnerId, userDO.getPartnerId());
		//	壳牌的partnerId与parentUserId是同一个，都在壳牌的会员系统properties中指定
		assertEquals(partnerId, userDO.getParentUserId());
		assertEquals(partnerId, userDO.getPlatPartnerId());
		assertEquals(realName, userDO.getRealName());
		assertEquals(mobile, userDO.getMobile());
		assertEquals(certifyStatus, userDO.getCertifyStatus());
		assertEquals(certType, userDO.getCertType());
		assertEquals(certNo, userDO.getCertNo());
		//基本不会有业务场景变化所以直接校验--------------------------------------------------------------------------------
		assertNotNull(userDO.getId());
		//目前油品系统未使用该属性，如果要传入，当与业务的nickName
		assertEquals(null, userDO.getUserName());
		//该状态是根据父级会员的状态而定，神马付注册接口未让调用方传入
		assertEquals("NORMAL", userDO.getUserStatus());
		//只要是注册商户的会员，都是个人的，除非新增商户，并在后台BOSS开立为平台商（PLATFORM）/签约商（PARTNER）。
		assertEquals("PERSONAL", userDO.getUserType());
		//欣业邦内部产品注册都属于站内，只有外部商户独立对接神马付才是外部引入OUTSIDE_INTO
		assertEquals("INSIDE", userDO.getRegisterFrom());
		//商户业务系统的会员ID，目前基本没有其它外部商户使用神马付，故没值；欣业邦内部的壳牌和加好油的会员ID与神马付生成的userId一致，故也没值。
		assertEquals(null, userDO.getMerchantUserId());
		//加好油、壳牌、房产这样的平台标识。目前上游系统（油品）并没有用此设计,神马付会员系统在（api1.0.5)版本之后才有该属性，数据为空。
		assertEquals(null, userDO.getPayPassword());
		assertEquals(null, userDO.getRegisterIp());
		assertEquals(null, userDO.getCountry());
		assertEquals(null, userDO.getProvince());
		assertEquals(null, userDO.getCity());
		assertEquals(null, userDO.getDistrict());
		assertEquals(null, userDO.getAddress());
		assertEquals(null, userDO.getZipCode());
		assertEquals(null, userDO.getMemo());
		assertEquals(null, userDO.getCustomerId());
		//该字段原设计用于区别商户的结算模式：普通模式（渠道直接结算给商户），电商管家模式（由神马付向电商管家发起清分结算），不过目前该配置项存放在路由，该配置已弃用。
		assertEquals("NORMAL", userDO.getMerchantMode());
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(userDO.getRawUpdateTime()));
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(userDO.getRawAddTime()));
	}
	
	/**
	 * 根据userId查询断言account表
	 * @param userId
	 * @param total
	 * @param size
	 * @param partnerId
	 * @param accountNo
	 * @param tag
	 */
	private void accountByUserIdAssert(	String userId, int total, int size, String partnerId, String accountNo,
										String tag) {
		List<AccountDO> accountDOS = userTestBase.findAccountByUserId(userId);
		if (total <= 0) {
			assertEquals(total, accountDOS.size());
			return;
		}
		assertEquals(total, accountDOS.size());
		AccountDO accountDO = accountDOS.get(size - 1);
		assertEquals(partnerId, accountDO.getPlatPartnerId());
		assertEquals(partnerId, accountDO.getPartnerId());
		assertEquals(tag, accountDO.getTag());
		assertNotNull(accountDO.getAccountNo());
		//基本不会有业务场景变化所以直接校验--------------------------------------------------------------------------------
		assertNotNull(accountDO.getId());
		//当时为了支持加好油，但目前无法追述其设计意图
		assertEquals(null, accountDO.getBandAccountNo());
		assertEquals(0L, accountDO.getBalance());
		assertEquals(0L, accountDO.getFreezeBalance());
		assertEquals(0L, accountDO.getCreditAmount());
		assertEquals(0L, accountDO.getHisInAmount());
		assertEquals(0L, accountDO.getHisOutAmount());
		assertEquals("111", accountDO.getPayModel());
		assertEquals("NORMAL", accountDO.getAccountType());
		assertEquals("ACTIVE", accountDO.getStatus());
		assertEquals(null, accountDO.getMemo());
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(accountDO.getRawUpdateTime()));
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(accountDO.getRawAddTime()));
	}
	
	/**
	 * 查询所有断言userNotifyTask表
	 * @param total
	 * @param size
	 * @param gid
	 * @param partnerId
	 * @param channelId
	 * @param certifyType
	 * @param certifyStatus
	 * @param pushStatus
	 * @param retryCount
	 * @param notifyGroup
	 * @param notifyVersion
	 */
	private void userNotifyTaskAssert(	int total, int size, String gid, String partnerId, String channelId,
										String certifyType, String certifyStatus, String pushStatus, Integer retryCount,
										String notifyGroup, String notifyVersion) {
		List<UserNotifyTaskDO> userNotifyTaskDOS = userTestBase.findUserNotifyTaskAll();
		if (total <= 0) {
			assertEquals(total, userNotifyTaskDOS.size());
			return;
		}
		assertEquals(total, userNotifyTaskDOS.size());
		UserNotifyTaskDO userNotifyTaskDO = userNotifyTaskDOS.get(size - 1);
		assertEquals(gid, userNotifyTaskDO.getGid());
		assertEquals(partnerId, userNotifyTaskDO.getPartnerId());
		assertEquals(retryCount, userNotifyTaskDO.getRetryCount());
		assertEquals(notifyGroup, userNotifyTaskDO.getNotifyGroup());
		assertEquals(notifyVersion, userNotifyTaskDO.getNotifyVersion());
		//基本不会有业务场景变化所以直接校验--------------------------------------------------------------------------------
		assertNotNull(userNotifyTaskDO.getReqId());
		assertEquals(null, userNotifyTaskDO.getDetail());
		assertEquals(20, userNotifyTaskDO.getMaxRetryCount());
		assertNotNull(userNotifyTaskDO.getId());
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()),
			DateUtil.dtSimpleFormat(userNotifyTaskDO.getRawUpdateTime()));
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()),
			DateUtil.dtSimpleFormat(userNotifyTaskDO.getRawAddTime()));
	}
	
}
