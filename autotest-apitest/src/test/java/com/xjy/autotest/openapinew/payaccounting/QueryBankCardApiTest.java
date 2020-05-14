package com.xjy.autotest.openapinew.payaccounting;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.utils.StringUtils;
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
public class QueryBankCardApiTest extends OpenapiTestBasis {


	@Autowired
	MerchantTestBase merchantTestBase;

	@AutoTest(file = "openapinew/payaccounting/queryBankCardApiTestSuccess.csv")
	@DisplayName("查询会员绑定银行卡--成功用例")
	public void queryBankCardApiTestSuccess(int testId, String status, String code,
											// 基本参数
											String service, String version, String partnerId, String securityCheckCode,
											String signType, String merchantOrderNo, String context, String returnUrl,
											String notifyUrl,
											// 业务参数
											String outUserId,
											//验证数据
											int size,
											String bankCardNo1,String bankCardName1,String bankCardPhone1,
											String bankCardNo2,String bankCardName2,String bankCardPhone2
	) {
		//初始化数据
		service = "queryBankCard";
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
		print("查询会员绑定银行卡response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		//	返回数据验证
		JSONArray bankCardInfos=JSONObject.parseArray(result.getString("bankCardInfos"));
		assertEquals(size,bankCardInfos.size());
		for (Object bankCardInfo:bankCardInfos) {
			JSONObject bankCarcInfo=JSONObject.parseObject(bankCardInfo.toString());
			if(StringUtils.isNotBlank(bankCardNo1)&&bankCardNo1.equals(bankCarcInfo.getString("bankCardNo"))) {
				assertEquals(bankCardName1, bankCarcInfo.getString("bankCardName"));
				assertEquals(bankCardPhone1, bankCarcInfo.getString("bankCardPhone"));
			}else if(StringUtils.isNotBlank(bankCardNo2)&&bankCardNo2.equals(bankCarcInfo.getString("bankCardNo"))) {
				assertEquals(bankCardName2, bankCarcInfo.getString("bankCardName"));
				assertEquals(bankCardPhone2, bankCarcInfo.getString("bankCardPhone"));
			}else {
				assertFalse(true);
			}
			assertNotNull(bankCarcInfo.getString("rawAddTime"));
			assertNotNull(bankCarcInfo.getString("rawUpdateTime"));
		}
		//数据验证
		//清除数据
	}
	//1001、outUserId必传
	@AutoTest(file = "openapinew/payaccounting/queryBankCardApiTestFailOne.csv")
	@DisplayName("查询会员绑定银行卡--参数检查用例")
	public void queryBankCardApiTestFailOne(int testId, String status, String code,
											// 基本参数
											String service, String version, String partnerId, String securityCheckCode,
											String signType, String merchantOrderNo, String context, String returnUrl,
											String notifyUrl,
											// 业务参数
											String outUserId
											) {
		//初始化数据
		service = "queryBankCard";
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
		print("查询会员绑定银行卡response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		assertNull(result.getString("bankCardInfos"));
		//数据验证
		//清除数据
	}

	//1001、会员不存在
	@AutoTest(file = "openapinew/payaccounting/queryBankCardApiTestFailTwo.csv")
	@DisplayName("查询会员绑定银行卡--失败用例")
	public void queryBankCardApiTestFailTwo(int testId, String status, String code,
											// 基本参数
											String service, String version, String partnerId, String securityCheckCode,
											String signType, String merchantOrderNo, String context, String returnUrl,
											String notifyUrl,
											// 业务参数
											String outUserId
	) {
		//初始化数据
		service = "queryBankCard";
		partnerId = pId;
		securityCheckCode = secretKey;
		merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		//清除数据
		merchantTestBase.cleanMerchantByOutUserId(outUserId);
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
		print("查询会员绑定银行卡response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		assertNull(result.getString("bankCardInfos"));
		//数据验证
		//清除数据
	}
}
