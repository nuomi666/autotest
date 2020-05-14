package com.xjy.autotest.openapinew.payaccounting;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.utils.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import com.xjy.autotest.testbase.openapi.OpenapiTestBasis;
import com.xjy.autotest.utils.DigestUtil;
import com.xjy.autotest.annotation.AutoTest;
import org.junit.jupiter.api.DisplayName;

import static com.alibaba.fastjson.JSON.parseObject;

/**
 * @author miantiao Created on 2019/08/22.
 */
public class QueryProfitPayDetailApiTest extends OpenapiTestBasis {
	/**
	 * 从数据表里去copy的已存在数据，并未用自动化实现测试用例，如果数据被删除，需要重新copy新的订单进行测试。
	 * 1001、有两个分账方，一条按金额分账，一条按比例分账，且两个分账方是同一个人，支付宝支付，支付完成的。
	 * 1002、有两个分账方，一条按金额分账，一条按比例分账，且两个分账方不是同一个人，待支付的。 1003、没有分账方，微信支付，支付完成的。
	 */
	@AutoTest(file = "openapinew/payaccounting/queryProfitPayDetailApiTestSuccess.csv")
	@DisplayName("查询订单信息--成功用例")
	public void queryProfitPayDetailApiTestSuccess(	int testId, String status, String code,
													// 基本参数
													String service, String version, String partnerId,
													String securityCheckCode, String signType, String merchantOrderNo,
													String context, String returnUrl, String notifyUrl,
													// 业务参数
													//返回参数
													String payNo, String payStatus, String payeeUserId,
													String payAmount, String payChannel, String remark,
													String rawAddTime, String finishDate, String profitUserId1,
													String profitAmount1, String profitPercent1, String profitReMark1,
													String profitUserId2, String profitAmount2, String profitPercent2,
													String profitReMark2, int infoSize) {
		//这属于测试库中的数据
		if(testId<=1003){
			return;
		}
		//初始化数据
		service = "queryProfitPayDetail";
		partnerId = pId;
		securityCheckCode = secretKey;
		//清除数据
		//准备数据
		//测试过程
		//主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		dataMap.put("payNo", payNo);
		buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		//签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		map.setAll(dataMap);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
		print("查询订单信息response:" + response.toString());
		JSONObject result = parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		JSONObject allInfo = JSONObject.parseObject(result.getString("info"));
		assertEquals(payNo, allInfo.getString("payNo"));
		assertEquals(payStatus, allInfo.getString("payStatus"));
		assertEquals(payeeUserId, allInfo.getString("payeeUserId"));
		
		assertEquals(payAmount, JSONObject.parseObject(allInfo.getString("payAmount")).getString("amount"));
		assertEquals(payChannel, allInfo.getString("payChannel"));
		assertEquals(remark, allInfo.getString("remark"));
		assertEquals(merchantOrderNo, allInfo.getString("merchantOrderNo"));
		assertEquals(rawAddTime, allInfo.getString("rawAddTime"));
		assertEquals(finishDate, allInfo.getString("finishDate"));
		JSONArray profitInfos = JSONArray.parseArray(allInfo.getString("profitInfos"));
		if (testId == 1003) {
			assertEquals(null, profitInfos);
		}
		if (testId == 1001 || testId == 1002|| testId == 1004) {
			assertEquals(infoSize, profitInfos.size());
			for (Object profitInfo : profitInfos) {
				JSONObject info = JSONObject.parseObject(profitInfo.toString());
				if (StringUtils.isNotBlank(profitReMark1) && profitReMark1.equals(info.getString("profitRemark"))) {
					assertEquals(profitAmount1,
						JSONObject.parseObject(info.getString("profitAmount")).getString("amount"));
					assertEquals(profitPercent1, info.getString("profitPercent"));
					assertEquals(profitUserId1, info.getString("profitUserId"));
				} else if (StringUtils.isNotBlank(profitReMark2)
							&& profitReMark2.equals(info.getString("profitRemark"))) {
					assertEquals(profitAmount2, JSONObject.parseObject(info.getString("profitAmount")));
					assertEquals(profitPercent2, info.getString("profitPercent"));
					assertEquals(profitUserId2, info.getString("profitUserId"));
				} else {
					assertTrue(false);
				}
			}
		}
		//数据验证
		//清除数据
	}
	
	//1001、payNo不传入
	@AutoTest(file = "openapinew/payaccounting/queryProfitPayDetailApiTestFailOne.csv")
	@DisplayName("查询订单信息--参数检查用例")
	public void queryProfitPayDetailApiTestFailOne(	int testId, String status, String code,
													// 基本参数
													String service, String version, String partnerId,
													String securityCheckCode, String signType, String merchantOrderNo,
													String context, String returnUrl, String notifyUrl, String payNo) {
		//初始化数据
		service = "queryProfitPayDetail";
		partnerId = pId;
		securityCheckCode = secretKey;
		//清除数据
		//准备数据
		//测试过程
		//主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		//签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
		print("查询订单信息response:" + response.toString());
		JSONObject result = parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		assertNull(result.getString("info"));
		//数据验证
		//清除数据
	}
	
	//1001、由于未对该house-finance进行自动化覆盖，随便制造的一个不存在的外部订单号测试，不够严谨
	@AutoTest(file = "openapinew/payaccounting/queryProfitPayDetailApiTestFailTwo.csv")
	@DisplayName("查询订单信息--业务异常用例")
	public void queryProfitPayDetailApiTestFailTwo(	int testId, String status, String code,
													// 基本参数
													String service, String version, String partnerId,
													String securityCheckCode, String signType, String merchantOrderNo,
													String context, String returnUrl, String notifyUrl, String payNo,
													String description, String message) {
		//初始化数据
		service = "queryProfitPayDetail";
		partnerId = pId;
		securityCheckCode = secretKey;
		//清除数据
		//准备数据
		//测试过程
		//主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		dataMap.put("payNo", payNo);
		buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		//签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
		print("查询订单信息response:" + response.toString());
		JSONObject result = parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		assertEquals(description, result.getString("description"));
		assertEquals(message, result.getString("message"));
		assertNull(result.getString("info"));
		//数据验证
		//清除数据
	}
}
