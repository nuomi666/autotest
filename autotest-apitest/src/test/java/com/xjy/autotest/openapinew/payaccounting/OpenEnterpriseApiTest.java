package com.xjy.autotest.openapinew.payaccounting;

import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.testbase.InitData.MerchantInitDataBase;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.testbase.OpenapiTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.util.DateUtil;
import dal.model.merchant.MerchantDO;
import dal.model.merchant.MerchantImgDO;
import dal.model.user.AccountDO;
import dal.model.user.UserNotifyTaskDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import com.xjy.autotest.testbase.openapi.OpenapiTestBasis;
import com.xjy.autotest.utils.DigestUtil;
import com.xjy.autotest.annotation.AutoTest;
import org.junit.jupiter.api.DisplayName;

/**
 * @author miantiao Created on 2019/07/15.
 */

/**
 * 注册》发送绑手机短信》确认绑定》签约》绑卡》支付
 */
public class OpenEnterpriseApiTest extends OpenapiTestBasis {
	
	@Autowired
	MerchantTestBase merchantTestBase;
	
	@Autowired
	MerchantInitDataBase merchantInitDataBase;
	
	@Autowired
	UserTestBase userTestBase;
	
	@Autowired
	OpenapiTestBase openapiTestBase;
	
	/**
	 * 签名key配置：在BOSS>>商户接入配置>>API商户管理>>商户ID（20180615001234567800）的签名KEY（haofangtong20190710）
	 * 业务处理流程：注册>进件>实名 1001、注册、进件和实名都成功。---调用成功环境。 1002、注册、进件和实名都成功,重复请求。
	 * 如果因为证件号或真实名不匹配导致修改后再注册请求，需要使用新的merchantOrderNo才生效。
	 * 以后测试------------------------- 1003、注册失败，重试。---调用孤立的商户测试环境。
	 * 1004、注册成功，进件失败，重试。---把神马付会员启动至孤立环境，改变其进件服务版本号致无法调用。
	 * 1005、注册成功，进件成功，实名失败，重试成功。---把神马付会员启动至孤立环境，改变其实名服务版本号致无法调用。
	 * 1006、注册成功，进件成功，实名失败，重试时外部userId不变，真实名和证件号改变如何处理？(目前是以第一次为准）。
	 */
	
	/**
	 * 1001和1002、正常用户 1003未通过实名 1004正常
	 */
	
	@AutoTest(file = "openapinew/payaccounting/openEnterpriseApiTestSuccess.csv")
	@DisplayName("会员注册(企业)--成功用例")
	public void openEnterpriseApiTestSuccess(	int testId, String status, String code,
												// 基本参数
												String service, String version, String partnerId,
												String securityCheckCode, String signType, String merchantOrderNo,
												String context, String returnUrl, String notifyUrl,
												// 业务参数
												String accountNo, String authType, String bankName,
												String bankSettlementUrl, String businessLicense,
												String businessLicenseUrl, String companyName,
												String legalCerificateBackUrl, String legalCerificateFrontUrl,
												String legalIds, String legalName, String legalPhone,
												String organizationCode, String organizationCodeUrl, String outUserId,
												String parentBankName, String taxCertificateUrl, String taxRegister,
												String uniCredit, String unionBank) {
		if (testId == 1003 ) {
			return;
		}
		//初始化数据
		service = "openEnterprise";
		partnerId = pId;
		securityCheckCode = secretKey;
		merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		//		业务初始数据
		String appId;//通过代码插入准备并获取
		String channelId;//通过代码插入准备并获取
		String appRefreshToken;//通过代码插入准备并获取
		securityCheckCode = secretKey;//在BOSS>>商户接入配置>>API商户管理>>商户ID（20180615001234567800）的签名KEY（haofangtong20190710）
		//清除数据
		merchantTestBase.cleanMerchantByOutUserId(outUserId);
		userTestBase.cleanUserByRealName(companyName);
		// 准备数据
		Map<String, Object> param = merchantInitDataBase.initPlatMerchant();
		appId = param.get("appId").toString();
		appRefreshToken = param.get("appRefreshToken").toString();
		channelId = param.get("channelId").toString();
		//测试过程
		//主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("accountNo", accountNo);//企业对公银行卡账户
		dataMap.put("authType", authType);//认证类型
		dataMap.put("bankName", bankName);//开户行支行名称
		dataMap.put("bankSettlementUrl", bankSettlementUrl);//对公户开户许可证图片URL
		dataMap.put("businessLicense", businessLicense);//营业执照号(三证)
		dataMap.put("businessLicenseUrl", businessLicenseUrl);//营业执照图片URL
		dataMap.put("companyName", companyName);//企业名称
		dataMap.put("legalCerificateBackUrl", legalCerificateBackUrl);//企业法人证件-反面图片URL
		dataMap.put("legalCerificateFrontUrl", legalCerificateFrontUrl);//企业法人证件-正面图片URL
		dataMap.put("legalIds", legalIds);//法人身份证号码
		dataMap.put("legalName", legalName);//法人姓名
		dataMap.put("legalPhone", legalPhone);//法人手机号码
		dataMap.put("organizationCode", organizationCode);//组织机构代码(三证)
		dataMap.put("organizationCodeUrl", organizationCodeUrl);//组织机构代码证图片URL
		dataMap.put("outUserId", outUserId);//外部用户ID
		dataMap.put("parentBankName", parentBankName);//开户银行名称
		dataMap.put("taxCertificateUrl", taxCertificateUrl);//税务登记证图片URL
		dataMap.put("taxRegister", taxRegister);//税务登记证(三证)
		dataMap.put("uniCredit", uniCredit);//统一社会信用(一证) 三证一证 二选一
		dataMap.put("unionBank", unionBank);//开户行支付行号
		//签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
		print("会员注册(企业)response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		String resultStatus = result.getString("status");
		String resultCode = result.getString("code");
			assertEquals(status, resultStatus);
			assertEquals(code, resultCode);
			assertNull(result.getString("userId"));

		// 数据验证
		String resultUserId = merchantTestBase.findMerchantByOutUserId(outUserId).get(0).getPartnerId();
		
		merchantByOutUserIdAssert(outUserId, 1, 1, resultUserId, partnerId, companyName, "SUB_MERCHANT", "ACTIVE",
			"VERIFICATE_DEAL", appId, appRefreshToken, channelId);
		
		merchantImgByPartnerIdAssert(resultUserId, 1, 1, null, null, null, null, null, null, businessLicenseUrl,
			organizationCodeUrl, taxCertificateUrl, bankSettlementUrl, legalCerificateFrontUrl, legalCerificateBackUrl);
		xybUserByUserIdAssert(resultUserId, 1, 1, partnerId, null, companyName, null, null, null);
		
		//签约商会创建三个账户（标准账户（用户自由操作）、资金池账户（用于给签约上记录类似电商关键应收账款--实资金在XYB/加好油实体卡）、结算账户（商家可提现金额）
		accountByUserIdAssert(resultUserId, 2, partnerId);

		//根据partnerId查询断言userNotifyTask表
		userNotifyTaskAssert(resultUserId,1, 1, status, "DUBBO", "ENTERPRISE_CERTIFICATION_RECEIPT", 0,
				"MerchantAuditSyncService", "1.0.0", null, "处理中");
		//清除数据
	}
	
	/**
	 * 1001、
	 */
	@AutoTest(file = "openapinew/payaccounting/openEnterpriseApiTestFailOne.csv")
	@DisplayName("会员注册(企业)--参数检查用例")
	public void openEnterpriseApiTestFailOne(	int testId, String status, String code,
												// 基本参数
												String service, String version, String partnerId,
												String securityCheckCode, String signType, String merchantOrderNo,
												String context, String returnUrl, String notifyUrl,
												// 业务参数
												String accountNo, String authType, String bankName,
												String bankSettlementUrl, String businessLicense,
												String businessLicenseUrl, String companyName,
												String legalCerificateBackUrl, String legalCerificateFrontUrl,
												String legalIds, String legalName, String legalPhone,
												String organizationCode, String organizationCodeUrl, String outUserId,
												String parentBankName, String taxCertificateUrl, String taxRegister,
												String uniCredit, String unionBank) {
		//初始化数据
		service = "openEnterprise";
		partnerId = pId;
		securityCheckCode = secretKey;
		merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		//		业务初始数据
		String appId;//通过代码插入准备并获取
		String channelId;//通过代码插入准备并获取
		String appRefreshToken;//通过代码插入准备并获取
		securityCheckCode = secretKey;//在BOSS>>商户接入配置>>API商户管理>>商户ID（20180615001234567800）的签名KEY（haofangtong20190710）
		//清除数据
		merchantTestBase.cleanMerchantByOutUserId(outUserId);
		// 准备数据
		Map<String, Object> param = merchantInitDataBase.initPlatMerchant();
		appId = param.get("appId").toString();
		appRefreshToken = param.get("appRefreshToken").toString();
		channelId = param.get("channelId").toString();
		//测试过程
		//主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		if (testId != 1001) {
			dataMap.put("accountNo", accountNo);//企业对公银行卡账户
		}
		if (testId != 1002) {
			dataMap.put("authType", authType);//认证类型
		}
		if (testId != 1003) {
			dataMap.put("bankName", bankName);//开户行支行名称
		}
		if (testId != 1004) {
			dataMap.put("bankSettlementUrl", bankSettlementUrl);//对公户开户许可证图片URL
		}
		if (testId != 1005) {
			dataMap.put("businessLicenseUrl", businessLicenseUrl);//营业执照图片URL
		}
		if (testId != 1006) {
			dataMap.put("companyName", companyName);//企业名称
		}
		if (testId != 1007) {
			dataMap.put("legalCerificateBackUrl", legalCerificateBackUrl);//企业法人证件-反面图片URL
		}
		if (testId != 1008) {
			dataMap.put("legalCerificateFrontUrl", legalCerificateFrontUrl);//企业法人证件-正面图片URL
		}
		if (testId != 1009) {
			dataMap.put("legalIds", legalIds);//法人身份证号码
		}
		if (testId != 1010) {
			dataMap.put("legalName", legalName);//法人姓名
		}
		if (testId != 1011) {
			dataMap.put("legalPhone", legalPhone);//法人手机号码
		}
		if (testId != 1012) {
			dataMap.put("unionBank", unionBank);//开户行支付行号
		}
		if (testId != 1013) {
			dataMap.put("outUserId", outUserId);//外部用户ID
		}
		if (testId != 1014) {
			dataMap.put("parentBankName", parentBankName);//开户银行名称
		}
		if (testId != 1015) {
			dataMap.put("uniCredit", uniCredit);//统一社会信用(一证) 三证一证 二选一
		}
		if (testId != 1016) {
			dataMap.put("taxRegister", taxRegister);//税务登记证(三证)
		}
		if (testId != 1017) {
			dataMap.put("businessLicense", businessLicense);//营业执照号(三证)
		}
		if (testId != 1018) {
			dataMap.put("organizationCode", organizationCode);//组织机构代码(三证)
		}
		if (testId != 1019) {
			dataMap.put("organizationCodeUrl", organizationCodeUrl);//组织机构代码证图片URL
		}
		if (testId != 1020) {
			dataMap.put("taxCertificateUrl", taxCertificateUrl);//税务登记证图片URL
		}
		
		//签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
		print("会员注册(企业)response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		String resultStatus = result.getString("status");
		String resultCode = result.getString("code");
		String resultUserId = result.getString("userId");
		assertEquals(status, resultStatus);
		assertEquals(code, resultCode);
		assertNull(resultUserId);
		// 数据验证
		
		if (testId != 1013) {
			merchantByOutUserIdAssert(outUserId, 0, 1, resultUserId, partnerId, companyName, "SUB_MERCHANT", "ACTIVE",
				"VERIFICATION", appId, appRefreshToken, channelId);
		}
		//清除数据
	}
	
	/**
	 * 1001、注册、进件和实名都成功,重复请求。 如果因为证件号或真实名不匹配导致修改后再注册请求，需要使用新的merchantOrderNo才生效。
	 * 以后测试------------------------- 1002、注册失败，重试。---调用孤立的商户测试环境。
	 * 1003、注册成功，进件失败，重试。---把神马付会员启动至孤立环境，改变其进件服务版本号致无法调用。
	 * 1004、注册成功，进件成功，实名失败，重试成功。---把神马付会员启动至孤立环境，改变其实名服务版本号致无法调用。
	 * 1005、注册成功，进件成功，实名失败，重试时外部userId不变，真实名和证件号改变如何处理？(目前是以第一次为准）。
	 */
	/**
	 * 1001、未审核通过时，重复注册，采用重复调用接口实现。
	 * 1002、已审核通过的外部outUserId,采用使用成功用例已审核通过的outUserId测试。
	 * 1003、网关挂掉的情况。
	 * 1004、采用网关挂掉，测试重试请求法定代表人真实名、法定代表人证件号、企业证件号、企业名称信息
	 */
	@AutoTest(file = "openapinew/payaccounting/openEnterpriseApiTestFailTwo.csv")
	@DisplayName("会员注册(企业)--成功用例")
	public void openEnterpriseApiTestFailTwo(	int testId, String status, String code,
												// 基本参数
												String service, String version, String partnerId,
												String securityCheckCode, String signType, String merchantOrderNo,
												String context, String returnUrl, String notifyUrl,
												// 业务参数
												String accountNo, String authType, String bankName,
												String bankSettlementUrl, String businessLicense,
												String businessLicenseUrl, String companyName,
												String legalCerificateBackUrl, String legalCerificateFrontUrl,
												String legalIds, String legalName, String legalPhone,
												String organizationCode, String organizationCodeUrl, String outUserId,
												String parentBankName, String taxCertificateUrl, String taxRegister,
												String uniCredit, String unionBank) {
		if (testId == 1001 ||testId == 1002 ||testId == 1003) {
			return;
		}
		//初始化数据
		service = "openEnterprise";
		partnerId = pId;
		securityCheckCode = secretKey;
		merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		//		业务初始数据
		String appId;//通过代码插入准备并获取
		String channelId;//通过代码插入准备并获取
		String appRefreshToken;//通过代码插入准备并获取
		securityCheckCode = secretKey;//在BOSS>>商户接入配置>>API商户管理>>商户ID（20180615001234567800）的签名KEY（haofangtong20190710）
		//清除数据
		if (testId == 1001||testId == 1003||testId == 1004) {
//			merchantTestBase.cleanMerchantByOutUserId(outUserId);
//			userTestBase.cleanUserNotifyTask();
		}

		// 准备数据
		//		把已经成功的数据查询出来，作为重复请求后的预期结果。
		 MerchantDO merchantDO=null;
		if(testId==1002){
			merchantDO = merchantTestBase.findMerchantByOutUserId(outUserId).get(0);
		}

		Map<String, Object> param = merchantInitDataBase.initPlatMerchant();
		appId = param.get("appId").toString();
		appRefreshToken = param.get("appRefreshToken").toString();
		channelId = param.get("channelId").toString();
		//测试过程
		//主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("accountNo", accountNo);//企业对公银行卡账户
		dataMap.put("authType", authType);//认证类型
		dataMap.put("bankName", bankName);//开户行支行名称
		dataMap.put("bankSettlementUrl", bankSettlementUrl);//对公户开户许可证图片URL
		dataMap.put("businessLicense", businessLicense);//营业执照号(三证)
		dataMap.put("businessLicenseUrl", businessLicenseUrl);//营业执照图片URL
		dataMap.put("companyName", companyName);//企业名称
		dataMap.put("legalCerificateBackUrl", legalCerificateBackUrl);//企业法人证件-反面图片URL
		dataMap.put("legalCerificateFrontUrl", legalCerificateFrontUrl);//企业法人证件-正面图片URL
		dataMap.put("legalIds", legalIds);//法人身份证号码
		dataMap.put("legalName", legalName);//法人姓名
		dataMap.put("legalPhone", legalPhone);//法人手机号码
		dataMap.put("organizationCode", organizationCode);//组织机构代码(三证)
		dataMap.put("organizationCodeUrl", organizationCodeUrl);//组织机构代码证图片URL
		dataMap.put("outUserId", outUserId);//外部用户ID
		dataMap.put("parentBankName", parentBankName);//开户银行名称
		dataMap.put("taxCertificateUrl", taxCertificateUrl);//税务登记证图片URL
		dataMap.put("taxRegister", taxRegister);//税务登记证(三证)
		dataMap.put("uniCredit", uniCredit);//统一社会信用(一证) 三证一证 二选一
		dataMap.put("unionBank", unionBank);//开户行支付行号
		//签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		ResponseEntity<String> response0 = null;
		if (testId == 1001) {
			response0 = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		}
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
		print("会员注册(企业)response:" + response.toString());
		
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		assertNull(result.getString("userId"));
		
		// 数据验证
		if (testId == 1001) {
			String resultUserId = merchantTestBase.findMerchantByOutUserId(outUserId).get(0).getPartnerId();
			merchantByOutUserIdAssert(outUserId, 1, 1, resultUserId, partnerId, companyName, "SUB_MERCHANT", "ACTIVE",
				"VERIFICATE_DEAL", appId, appRefreshToken, channelId);
			
			merchantImgByPartnerIdAssert(resultUserId, 1, 1, null, null, null, null, null, null, businessLicenseUrl,
				organizationCodeUrl, taxCertificateUrl, bankSettlementUrl, legalCerificateFrontUrl,
				legalCerificateBackUrl);
			xybUserByUserIdAssert(resultUserId, 1, 1, partnerId, null, companyName, null, null, businessLicense);
			
			//签约商会创建三个账户（标准账户（用户自由操作）、资金池账户（用于给签约上记录类似电商关键应收账款--实资金在XYB/加好油实体卡）、结算账户（商家可提现金额）
			accountByUserIdAssert(resultUserId, 2, partnerId);
			
			//根据partnerId查询断言userNotifyTask表
			userNotifyTaskAssert(resultUserId,1, 1,  status, "DUBBO", "ENTERPRISE_CERTIFICATION_RECEIPT", 0,
				"MerchantAuditSyncService", "1.0.0", null, "处理中");
		}
		// 数据验证
		if (testId == 1002) {
			String resultUserId = merchantTestBase.findMerchantByOutUserId(outUserId).get(0).getPartnerId();
			merchantByOutUserIdAssert(outUserId, 1, 1, resultUserId, partnerId, companyName, "SUB_MERCHANT", "ACTIVE",
					"VERIFICATION", appId, appRefreshToken, channelId,merchantDO.getRawUpdateTime(),merchantDO.getRawAddTime());
		}
		//清除数据
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
	 *
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
	 * @param rawUpdateTime
	 * @param rawAddTime
	 */
	private void merchantByOutUserIdAssert(String outUserId, int total, int size, String partnerId,
										   String parentPartnerId, String merchantName, String merchantType,
										   String status, String leadStatus, String appId, String appRefreshToken,
										   String channelId, Date rawUpdateTime,Date rawAddTime) {
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
		assertEquals(DateUtil.dtSimpleFormat(rawUpdateTime), DateUtil.dtSimpleFormat(merchantDO.getRawUpdateTime()));
		assertEquals(DateUtil.dtSimpleFormat(rawAddTime), DateUtil.dtSimpleFormat(merchantDO.getRawAddTime()));
		//基本不会有业务场景变化所以直接校验--------------------------------------------------------------------------------
		assertNotNull(merchantDO.getId());
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
	 * 根据userId查询断言xyb-user表
	 * @param userId
	 * @param total
	 * @param size
	 * @param partnerId
	 * @param mobile
	 * @param realName
	 * @param certifyStatus
	 * @param certType
	 * @param certNo
	 */
	private void xybUserByUserIdAssert(	String userId, int total, int size, String partnerId, String mobile,
										String realName, String certifyStatus, String certType, String certNo) {
		List<dal.model.user.UserDO> userDOS = userTestBase.findUserByUserId(userId);
		if (total <= 0) {
			assertEquals(total, userDOS.size());
			return;
		}
		assertEquals(total, userDOS.size());
		dal.model.user.UserDO userDO = userDOS.get(size - 1);
		assertEquals(userId, userDO.getPartnerId());
		assertEquals(partnerId, userDO.getParentUserId());
		assertEquals(partnerId, userDO.getPlatPartnerId());
		assertEquals(realName, userDO.getRealName());
		assertEquals(mobile, userDO.getMobile());
		assertEquals(certifyStatus, userDO.getCertifyStatus());
		assertEquals(certType, userDO.getCertType());
		assertEquals(certNo, userDO.getCertNo());
		//基本不会有业务场景变化所以直接校验--------------------------------------------------------------------------------
		assertNotNull(userDO.getId());
		assertEquals(null, userDO.getMerchantUserId());
		//目前油品系统未使用该属性，如果要传入，当与业务的nickName
		assertEquals(null, userDO.getUserName());
		//该状态是根据父级会员的状态而定，神马付注册接口未让调用方传入
		assertEquals("NORMAL", userDO.getUserStatus());
		//只要是注册商户的会员，都是个人的，除非新增商户，并在后台BOSS开立为平台商（PLATFORM）/签约商（PARTNER）。
		assertEquals("PARTNER", userDO.getUserType());
		//欣业邦内部产品注册都属于站内，只有外部商户独立对接神马付才是外部引入OUTSIDE_INTO
		assertEquals("OUTSIDE_INTO", userDO.getRegisterFrom());
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
		assertEquals(null, userDO.getMerchantMode());
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(userDO.getRawUpdateTime()));
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(userDO.getRawAddTime()));
	}
	
	/**
	 * 根据userId查询断言account表
	 * @param userId
	 * @param total
	 * @param platPartnerId
	 */
	private void accountByUserIdAssert(String userId, int total, String platPartnerId) {
		List<AccountDO> accountDOS = userTestBase.findAccountByUserId(userId);
		if (total <= 0) {
			assertEquals(total, accountDOS.size());
			return;
		}
		assertEquals(total, accountDOS.size());
		AccountDO acountPoolDO = userTestBase.findAccountByUserIdAndAccountType(userId, "POOL").get(0);
		AccountDO acountSettleMentDO = userTestBase.findAccountByUserIdAndAccountType(userId, "SETTLEMENT").get(0);
		//		-----------------------------资金池记账户-创建会员时默认创建的，用于消费总账记录-------------------------------------------------------
		assertEquals(platPartnerId, acountPoolDO.getPlatPartnerId());
		assertEquals(userId, acountPoolDO.getPartnerId());
		assertNotNull(acountPoolDO.getAccountNo());
		//基本不会有业务场景变化所以直接校验--------------------------------------------------------------------------------
		assertNotNull(acountPoolDO.getId());
		assertNotNull(acountPoolDO.getAccountNo());
		//tag为支持业务层一个会员有多个账户，不同账户不同场景用途打的标签。一个userId+tag可获得唯一账号
		assertEquals(null, acountPoolDO.getBandAccountNo());
		assertEquals(0L, acountPoolDO.getBalance());
		assertEquals(0L, acountPoolDO.getFreezeBalance());
		assertEquals(0L, acountPoolDO.getCreditAmount());
		assertEquals(0L, acountPoolDO.getHisInAmount());
		assertEquals(0L, acountPoolDO.getHisOutAmount());
		assertEquals("111", acountPoolDO.getPayModel());
		assertEquals("ACTIVE", acountPoolDO.getStatus());
		assertEquals(null, acountPoolDO.getMemo());
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(acountPoolDO.getRawUpdateTime()));
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil.dtSimpleFormat(acountPoolDO.getRawAddTime()));
		
		//		----------------------------------------签约商结算账户---进件时创建的，用于提现----------------------------------------------------------
		assertEquals(platPartnerId, acountSettleMentDO.getPlatPartnerId());
		assertEquals(userId, acountSettleMentDO.getPartnerId());
		assertNotNull(acountSettleMentDO.getAccountNo());
		//基本不会有业务场景变化所以直接校验--------------------------------------------------------------------------------
		assertNotNull(acountSettleMentDO.getId());
		assertNotNull(acountSettleMentDO.getAccountNo());
		//tag为支持业务层一个会员有多个账户，不同账户不同场景用途打的标签。一个userId+tag可获得唯一账号
		assertEquals(null, acountSettleMentDO.getBandAccountNo());
		assertEquals(0L, acountSettleMentDO.getBalance());
		assertEquals(0L, acountSettleMentDO.getFreezeBalance());
		assertEquals(0L, acountSettleMentDO.getCreditAmount());
		assertEquals(0L, acountSettleMentDO.getHisInAmount());
		assertEquals(0L, acountSettleMentDO.getHisOutAmount());
		assertEquals("111", acountSettleMentDO.getPayModel());
		assertEquals("ACTIVE", acountSettleMentDO.getStatus());
		assertEquals(null, acountSettleMentDO.getMemo());
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()),
			DateUtil.dtSimpleFormat(acountSettleMentDO.getRawUpdateTime()));
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()),
			DateUtil.dtSimpleFormat(acountSettleMentDO.getRawAddTime()));
		
	}
	
	/**
	 * 根据partnerId查询断言userNotifyTask表
	 * @param partnerId
	 * @param total
	 * @param size
	 * @param status
	 * @param notifyCategory
	 * @param notifyType
	 * @param retryCount
	 * @param notifyGroup
	 * @param notifyVersion
	 * @param notifyUrl
	 * @param detail
	 */
	private void userNotifyTaskAssert(	String partnerId,int total, int size,  String status, String notifyCategory,
										String notifyType, Integer retryCount, String notifyGroup, String notifyVersion,
										String notifyUrl, String detail) {
		List<UserNotifyTaskDO> userNotifyTaskDOS = userTestBase.findUserNotifyTaskByPartnerId(partnerId);
		if (total <= 0) {
			assertEquals(total, userNotifyTaskDOS.size());
			return;
		}
		assertEquals(total, userNotifyTaskDOS.size());
		UserNotifyTaskDO userNotifyTaskDO = userNotifyTaskDOS.get(size - 1);
		assertEquals(status, userNotifyTaskDO.getStatus());
		assertEquals(notifyCategory, userNotifyTaskDO.getNotifyCategory());
		assertEquals(notifyType, userNotifyTaskDO.getNotifyType());
		assertEquals(retryCount, userNotifyTaskDO.getRetryCount());
		assertEquals(notifyGroup, userNotifyTaskDO.getNotifyGroup());
		assertEquals(notifyVersion, userNotifyTaskDO.getNotifyVersion());
		assertEquals(notifyUrl, userNotifyTaskDO.getNotifyUrl());
		assertEquals(detail, userNotifyTaskDO.getDetail());
		//基本不会有业务场景变化所以直接校验--------------------------------------------------------------------------------
		assertNotNull(userNotifyTaskDO.getGid());
		assertNotNull(userNotifyTaskDO.getReqId());
		assertEquals(20, userNotifyTaskDO.getMaxRetryCount());
		assertNotNull(userNotifyTaskDO.getId());
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()),
			DateUtil.dtSimpleFormat(userNotifyTaskDO.getRawUpdateTime()));
		assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()),
			DateUtil.dtSimpleFormat(userNotifyTaskDO.getRawAddTime()));
	}
	
}
