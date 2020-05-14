package com.xjy.autotest.openapinew;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import com.xjy.autotest.testbase.openapi.OpenapiTestBasis;
import com.xjy.autotest.utils.DigestUtil;
import com.xjy.autotest.annotation.AutoTest;
import org.junit.jupiter.api.DisplayName;

/**
 * @author ychaoyang
 * Created on 2019/06/11.
 */
public class QueryPayByTradeNoApiTest extends OpenapiTestBasis {

	@AutoTest(file = "openapinew/queryPayByTradeNoApiTestSuccess.csv")
	@DisplayName("根据交易流水号查询支付信息--成功用例")
	public void queryPayByTradeNoApiTestSuccess(
			int testId,
			String status,
			String code,
			// 基本参数
			String service,
			String version,
			String partnerId,
			String securityCheckCode,
			String signType,
			String merchantOrderNo,
			String context,
			String returnUrl,
			String notifyUrl,
			// 业务参数
	        String payNo
			){
		//初始化数据
		service = "queryPayByTradeNo";
		partnerId = "S0301905311500091446";
		securityCheckCode = "46e4f74b59b1ec39c784602ad20908c6";
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		payNo = "A1906061141550030002";
		//清除数据
		//准备数据
		//测试过程
        //主订单
		Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("payNo", payNo);//支付流水号
		dataMap.put("password", "22222");//支付流水号
        //签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
    	print("根据交易流水号查询支付信息response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		//数据验证
		//清除数据
	}
}
