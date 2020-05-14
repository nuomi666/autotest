package com.xjy.autotest.openapinew;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.testbase.openapi.OpenapiTestBasis;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import com.xjy.autotest.utils.DigestUtil;
import com.xjy.autotest.annotation.AutoTest;
import org.junit.jupiter.api.DisplayName;

/**
 * @author ychaoyang
 * Created on 2018/12/03.
 */
public class CiticMerchantEntryApiTest extends OpenapiTestBasis {

	@AutoTest(file = "openapinew/citicMerchantEntryApiTestSuccess.csv")
	@DisplayName("电商管家进件--成功用例")
	public void citicMerchantEntryApiTestSuccess(
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
	        String subMerchantAbbr,
	        String subMerchantAddress,
	        String subMerchantContact,
	        String subMerchantContactPhone,
	        String subMerchantEmail,
	        String subMerchantName
			){
		//初始化数据
		service = "citicMerchantEntry";
		partnerId = pId;
		securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();

        subMerchantName = "兴仁县蓝天加油站";
        subMerchantAbbr = "兴仁县蓝天加油站";

        subMerchantAddress = "重庆市渝北区金开大道西段互联网产业园13栋";
        subMerchantContact = "黄洪婧";
        subMerchantContactPhone = "18883184341";
        subMerchantEmail = "jingjing@xinyebang.com";
		//清除数据
		//准备数据
		//测试过程
        //主订单
		Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
        dataMap.put("subMerchantName", subMerchantName);//商户名称
        dataMap.put("subMerchantAbbr", subMerchantAbbr);//商户简称
        dataMap.put("subMerchantAddress", subMerchantAddress);//商户办公地址
        dataMap.put("subMerchantContact", subMerchantContact);//商户联系人
        dataMap.put("subMerchantContactPhone", subMerchantContactPhone);//商户联系电话
        dataMap.put("subMerchantEmail", subMerchantEmail);//商户联系邮箱
        //签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
    	print("电商管家进件response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		//数据验证
		//清除数据
	}
}
