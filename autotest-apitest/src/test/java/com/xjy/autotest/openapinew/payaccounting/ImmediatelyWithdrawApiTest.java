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
 * @author miantiao Created on 2019/07/26.
 * 提现：必须先绑银行卡。
 * 收单：必须实名（所有会员都是实名的）。
 * 绑卡：必须先签约和绑定手机号（由会员系统做的校验，通联本身并未做校验）。
 * 签约：必须先实名。
 * 绑手机：企业需要实名才能绑手机。
 * 目前企业和个人签约用户，只要注册都必须是实名的。
 */
public class ImmediatelyWithdrawApiTest extends OpenapiTestBasis {
	/**
	 * 1001、企业提现对公银行卡
	 * 1002、企业提现至法定代表人对私银行卡
	 * 1003、个人提现
	 */
	@AutoTest(file = "openapinew/payaccounting/immediatelyWithdrawApiTestSuccess.csv")
	@DisplayName("会员余额提现--成功用例")
	public void immediatelyWithdrawApiTestSuccess(	int testId, String status, String code,
													// 基本参数
													String service, String version, String partnerId,
													String securityCheckCode, String signType, String merchantOrderNo,
													String context, String returnUrl, String notifyUrl,
													// 业务参数
													String amount, String bankCardNo, String payeeOutUserId) {
		//初始化数据
		service = "immediatelyWithdraw";
		partnerId = pId;
		securityCheckCode = secretKey;
		merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		//清除数据
		//准备数据
		//测试过程
		//主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("amount", amount);//提现金额
		dataMap.put("bankCardNo", bankCardNo);//银行卡号
		dataMap.put("payeeOutUserId", payeeOutUserId);//提现账户信息
		//签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
		print("会员余额提现response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		assertNotNull(result.getString("bizNo"));
		assertNotNull(result.getString("applyDate"));
		//数据验证
		//清除数据
	}
	@AutoTest(file = "openapinew/payaccounting/immediatelyWithdrawApiTestFailOne.csv")
	@DisplayName("会员余额提现--参数检查用例")
	public void immediatelyWithdrawApiTestFailOne(	int testId, String status, String code,
													  // 基本参数
													  String service, String version, String partnerId,
													  String securityCheckCode, String signType, String merchantOrderNo,
													  String context, String returnUrl, String notifyUrl,
													  // 业务参数
													  String amount, String bankCardNo, String payeeOutUserId) {
		//初始化数据
		service = "immediatelyWithdraw";
		partnerId = pId;
		securityCheckCode = secretKey;
		merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		//清除数据
		//准备数据
		//测试过程
		//主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		if(testId!=1001) {
			dataMap.put("amount", amount);//提现金额
		}
		if(testId!=1002) {
			dataMap.put("bankCardNo", bankCardNo);//银行卡号
		}
		if(testId!=1003) {
			dataMap.put("payeeOutUserId", payeeOutUserId);//提现账户信息
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
		print("会员余额提现response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		assertNull(result.getString("bizNo"));
		assertNull(result.getString("applyDate"));
		//数据验证
		//清除数据
	}

	/**
	 * 1001、相同订单号，重复提交提现申请。(处理中的提现订单)（目前测试环境通联都是成功，没有处理中）但可以更新造数据
	 * 1002、相同订单号，重复提交提现申请。(提现成功的订单)//采用debug的方式修改提现订单的状态为成功
	 * 1003、提现商户/人不存在。
	 * 1004、可提现余额不足。
	 * 1005、传入的提现银行卡未绑定。（也覆盖卡号错误）
	 * 1006、提现签约商状态不可用（后台未对商户进行管理，暂时不覆盖）
	 * 1007、平台商状态不可用（后台未对商户进行管理，暂时不覆盖）
	 */
	@AutoTest(file = "openapinew/payaccounting/immediatelyWithdrawApiTestFailTwo.csv")
	@DisplayName("会员余额提现--失败用例")
	public void immediatelyWithdrawApiTestFailTwo(	int testId, String status, String code,String description,String message,
													  // 基本参数
													  String service, String version, String partnerId,
													  String securityCheckCode, String signType, String merchantOrderNo,
													  String context, String returnUrl, String notifyUrl,
													  // 业务参数
													  String amount, String bankCardNo, String payeeOutUserId) {
		//初始化数据
		service = "immediatelyWithdraw";
		partnerId = pId;
		securityCheckCode = secretKey;
		merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		//清除数据
		//准备数据
		//测试过程
		//主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("amount", amount);//提现金额
		dataMap.put("bankCardNo", bankCardNo);//银行卡号
		dataMap.put("payeeOutUserId", payeeOutUserId);//提现账户信息
		//签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		if(testId==1001){
			restTemplate.postForEntity(openapiTestUrl, map, String.class);
		}
		if(testId==1002){
			restTemplate.postForEntity(openapiTestUrl, map, String.class);
			//采用debug的方式修改提现订单的状态为成功
			System.out.println("进入debug模式");
		}
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
		print("会员余额提现response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		assertEquals(description, result.getString("description"));
		assertEquals(message, result.getString("message"));
		//数据验证
		//清除数据
	}
}
