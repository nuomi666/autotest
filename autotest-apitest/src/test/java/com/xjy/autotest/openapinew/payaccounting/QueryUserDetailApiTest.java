package com.xjy.autotest.openapinew.payaccounting;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import com.xjy.autotest.testbase.openapi.OpenapiTestBasis;
import com.xjy.autotest.utils.DigestUtil;
import com.xjy.autotest.annotation.AutoTest;
import org.junit.jupiter.api.DisplayName;

/**
 * @author miantiao Created on 2019/07/17.
 */
public class QueryUserDetailApiTest extends OpenapiTestBasis {
	
	@AutoTest(file = "openapinew/payaccounting/queryUserDetailApiTestSuccess.csv")
	@DisplayName("查询用户状态信息--成功用例")
	public void queryUserDetailApiTestSuccess(	int testId, String status, String code,
												// 基本参数
												String service, String version, String partnerId,
												String securityCheckCode, String signType, String merchantOrderNo,
												String context, String returnUrl, String notifyUrl,
												// 业务参数
												String outUserId,
												//返回数据
												String signContractsStatus, String certifyStatus,
												String bindPhoneStatus, String detail) {
		//初始化数据
		service = "queryUserDetail";
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
		print("查询用户状态信息response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		JSONObject info = JSONObject.parseObject(result.getString("info"));
		assertEquals(signContractsStatus, info.getString("signContractsStatus"));
		assertEquals(certifyStatus, info.getString("certifyStatus"));
		assertEquals(bindPhoneStatus, info.getString("bindPhoneStatus"));
		assertEquals(detail, info.getString("detail"));
		//数据验证
		//清除数据
	}
	@AutoTest(file = "openapinew/payaccounting/queryUserDetailApiTestFailOne.csv")
	@DisplayName("查询用户状态信息--参数检查用例")
	public void queryUserDetailApiTestFailOne(	int testId, String status, String code,
												  // 基本参数
												  String service, String version, String partnerId,
												  String securityCheckCode, String signType, String merchantOrderNo,
												  String context, String returnUrl, String notifyUrl,
												  // 业务参数
												  String outUserId,
												  //返回数据
												  String signContractsStatus, String certifyStatus,
												  String bindPhoneStatus, String detail) {
		//初始化数据
		service = "queryUserDetail";
		partnerId = pId;
		securityCheckCode = secretKey;
		merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		//清除数据
		//准备数据
		//测试过程
		//主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
//		dataMap.put("outUserId", outUserId);//外部用户ID
		//签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
		print("查询用户状态信息response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		assertNull(result.getString("info"));
		//数据验证
		//清除数据
	}

	//用户不存在
	@AutoTest(file = "openapinew/payaccounting/queryUserDetailApiTestFailTwo.csv")
	@DisplayName("查询用户状态信息--失败用例")
	public void queryUserDetailApiTestFailTwo(	int testId, String status, String code,
												  // 基本参数
												  String service, String version, String partnerId,
												  String securityCheckCode, String signType, String merchantOrderNo,
												  String context, String returnUrl, String notifyUrl,
												  // 业务参数
												  String outUserId,
												  //返回数据
												  String signContractsStatus, String certifyStatus,
												  String bindPhoneStatus, String detail) {
		//初始化数据
		service = "queryUserDetail";
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
		print("查询用户状态信息response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		assertNull(result.getString("info"));
		//数据验证
		//清除数据
	}
}
