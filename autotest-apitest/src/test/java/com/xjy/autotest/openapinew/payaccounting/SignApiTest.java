package com.xjy.autotest.openapinew.payaccounting;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.testbase.MerchantTestBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import com.xjy.autotest.testbase.openapi.OpenapiTestBasis;
import com.xjy.autotest.utils.DigestUtil;
import com.xjy.autotest.annotation.AutoTest;
import org.junit.jupiter.api.DisplayName;

/**
 * @author miantiao Created on 2019/07/16.
 * 提现：必须先绑银行卡。
 * 收单：必须实名（所有会员都是实名的）。
 * 绑卡：必须先签约和绑定手机号（由会员系统做的校验，通联本身并未做校验）。
 * 签约：必须先实名。
 * 绑手机：企业需要实名才能绑手机。
 * 目前企业和个人签约用户，只要注册都必须是实名的。
 */
public class SignApiTest extends OpenapiTestBasis {
	@Autowired
	MerchantTestBase merchantTestBase;

	/**
	 * 签约采用异步查询回执给客户，而不是等待通联异步回执。
	 * 查询定时任务去235-BOSS-技术管理-任务调度-查找130ID的定时任务，立即执行即可。
	 */
	@AutoTest(file = "openapinew/payaccounting/signApiTestSuccess.csv")
	@DisplayName("会员电子协议签约--成功用例")
	public void signApiTestSuccess(	int testId, String status, String code,
									// 基本参数
									String service, String version, String partnerId, String securityCheckCode,
									String signType, String merchantOrderNo, String context, String returnUrl,
									String notifyUrl,
									// 业务参数
									 String outUserId) {
		//初始化数据
		service = "sign";
		partnerId = pId;
		securityCheckCode = secretKey;
		merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		//清除数据
		//准备数据
		//测试过程
		//主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("outUserId", outUserId);//外部用户ID
		//签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
		print("会员电子协议签约response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());

		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		//数据验证
		//	第一次获取签约地址
		JSONObject info=JSONObject.parseObject(result.getString("info"));
		assertNotNull(info.getString("url"));
		System.out.println("签约地址："+info.getString("url"));

		//清除数据
	}
	@AutoTest(file = "openapinew/payaccounting/signApiTestFailOne.csv")
	@DisplayName("会员电子协议签约--成功用例")
	public void signApiTestFailOne(	int testId, String status, String code,
									   // 基本参数
									   String service, String version, String partnerId, String securityCheckCode,
									   String signType, String merchantOrderNo, String context, String returnUrl,
									   String notifyUrl,
									   // 业务参数
									   String outUserId) {
		//初始化数据
		service = "sign";
		partnerId = pId;
		securityCheckCode = secretKey;
		merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		//清除数据
		//准备数据
		//测试过程
		//主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("outUserId", outUserId);//外部用户ID
		//签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
		print("会员电子协议签约response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());

		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		assertNull(result.getString("info"));
		//数据验证
		//清除数据
	}

	/**
	 * 1001.企业商户重复签约(目前在会员系统进行的拦截)
	 * 1002.个人商户重复签约
	 * 1003.outUserId未开户
	 * 1004.outUserId未实名通过
	 */
	@AutoTest(file = "openapinew/payaccounting/signApiTestFailTwo.csv")
	@DisplayName("会员电子协议签约--失败用例")
	public void signApiTestFailTwo(	int testId, String status, String code,
									   // 基本参数
									   String service, String version, String partnerId, String securityCheckCode,
									   String signType, String merchantOrderNo, String context, String returnUrl,
									   String notifyUrl,
									   // 业务参数
									   String outUserId) {

		//初始化数据
		service = "sign";
		partnerId = pId;
		securityCheckCode = secretKey;
		merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		//清除数据
		if(testId==1003){
			merchantTestBase.cleanMerchantByOutUserId(outUserId);
		}
		//准备数据
		//测试过程
		//主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("outUserId", outUserId);//外部用户ID
		//签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
		print("会员电子协议签约response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());

		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		//数据验证
		//	签约成功后再获取签约地址信息为空
		assertNull(JSONObject.parseObject(result.getString("info")));
		//清除数据
	}
}
