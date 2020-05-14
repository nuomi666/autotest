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
 * @author miantiao Created on 2019/07/16.
 */
public class SendVerificationCodeApiTest extends OpenapiTestBasis {
	
	@AutoTest(file = "openapinew/payaccounting/sendVerificationCodeApiTestSuccess.csv")
	@DisplayName("发送验证码--成功用例")
	public void sendVerificationCodeApiTestSuccess(	int testId, String status, String code,
													// 基本参数
													String service, String version, String partnerId,
													String securityCheckCode, String signType, String merchantOrderNo,
													String context, String returnUrl, String notifyUrl,
													// 业务参数
													String outUserId, String phone) {
		//初始化数据
		service = "sendVerificationCode";
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
		dataMap.put("phone", phone);//手机号
		//签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
		print("发送验证码response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		//数据验证
		//清除数据
	}

	@AutoTest(file = "openapinew/payaccounting/sendVerificationCodeApiTestFailOne.csv")
	@DisplayName("发送验证码--参数检查用例")
	public void sendVerificationCodeApiTestFailOne(	int testId, String status, String code,
													   // 基本参数
													   String service, String version, String partnerId,
													   String securityCheckCode, String signType, String merchantOrderNo,
													   String context, String returnUrl, String notifyUrl,
													   // 业务参数
													   String outUserId, String phone) {
		//初始化数据
		service = "sendVerificationCode";
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
		dataMap.put("phone", phone);//手机号
		//签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
		print("发送验证码response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		//数据验证
		//清除数据
	}

	@AutoTest(file = "openapinew/payaccounting/sendVerificationCodeApiTestFailTwo.csv")
	@DisplayName("发送验证码--失败用例")
	public void sendVerificationCodeApiTestFailTwo(	int testId, String status, String code,
													   // 基本参数
													   String service, String version, String partnerId,
													   String securityCheckCode, String signType, String merchantOrderNo,
													   String context, String returnUrl, String notifyUrl,
													   // 业务参数
													   String outUserId, String phone) {
		//初始化数据
		service = "sendVerificationCode";
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
		dataMap.put("phone", phone);//手机号
		//签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
		print("发送验证码response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		//数据验证
		//清除数据
	}
}
