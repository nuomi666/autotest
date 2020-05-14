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
 * @author miantiao Created on 2019/07/17.
 */
public class QueryBalanceApiTest extends OpenapiTestBasis {
	@Autowired
	MerchantTestBase merchantTestBase;

	/**
	 * 1001、企业用户。
	 * 1002、个人用户。
	 * 1003、个人用户（未做任何交易，通联不开账户但可以执行查询余额）
	 *
	 */
	@AutoTest(file = "openapinew/payaccounting/queryBalanceApiTestSuccess.csv")
	@DisplayName("查询会员余额--成功用例")
	public void queryBalanceApiTestSuccess(	int testId, String status, String code,
											// 基本参数
											String service, String version, String partnerId, String securityCheckCode,
											String signType, String merchantOrderNo, String context, String returnUrl,
											String notifyUrl,
											// 业务参数
											String outUserId,
											   //返回数据
											   String balance,String freezeBalance) {
		//初始化数据
		service = "queryBalance";
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
		print("查询会员余额response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		JSONObject info = JSONObject.parseObject(result.getString("info"));
		JSONObject balanceInfo=JSONObject.parseObject(info.getString("balance"));
		JSONObject freezeBalanceInfo=JSONObject.parseObject(info.getString("freezeBalance"));
		assertEquals(balance, balanceInfo.getString("amount"));
		assertEquals(freezeBalance, freezeBalanceInfo.getString("amount"));
		//数据验证
		//清除数据
	}

	@AutoTest(file = "openapinew/payaccounting/queryBalanceApiTestFailOne.csv")
	@DisplayName("查询会员余额--参数检查用例")
	public void queryBalanceApiTestFailOne(	int testId, String status, String code,
											   // 基本参数
											   String service, String version, String partnerId, String securityCheckCode,
											   String signType, String merchantOrderNo, String context, String returnUrl,
											   String notifyUrl,
											   // 业务参数
											   String outUserId,
											   //返回数据
											   String balance,String freezeBalance) {
		//初始化数据
		service = "queryBalance";
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
			dataMap.put("outUserId", outUserId);//外部用户ID,不传入。
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
		print("查询会员余额response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		assertNull(JSONObject.parseObject(result.getString("info")));
		//清除数据
	}


	/**
	 * 1001、用户不存在。
	 * 1002、企业用户未通过实名(使用一个已申请开户未审核通过的用户测试），不允许查询，提示“查询余额失败失败:当前用户不可用。
	 */

	@AutoTest(file = "openapinew/payaccounting/queryBalanceApiTestFailTwo.csv")
	@DisplayName("查询会员余额--失败用例")
	public void queryBalanceApiTestFailTwo(	int testId, String status, String code,
											   // 基本参数
											   String service, String version, String partnerId, String securityCheckCode,
											   String signType, String merchantOrderNo, String context, String returnUrl,
											   String notifyUrl,
											   // 业务参数
											   String outUserId,
											   //返回数据
											   String balance,String freezeBalance) {
		//初始化数据
		service = "queryBalance";
		partnerId = pId;
		securityCheckCode = secretKey;
		merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		//清除数据
		if(testId==1001) {
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
		print("查询会员余额response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		assertNull(JSONObject.parseObject(result.getString("info")));
		//数据验证
		//清除数据
	}
}
