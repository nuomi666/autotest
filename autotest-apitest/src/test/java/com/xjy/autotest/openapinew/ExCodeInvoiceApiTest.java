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
 * Created on 2019/06/03.
 */
public class ExCodeInvoiceApiTest extends OpenapiTestBasis {

	@AutoTest(file = "openapinew/exCodeInvoiceApiTestSuccess.csv")
	@DisplayName("跳转H5开票--成功用例")
	public void exCodeInvoiceApiTestSuccess(
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
	        String exCode
			){
		//初始化数据
		service = "exCodeInvoice";
		partnerId = "S0301901211800000914";
		securityCheckCode = "8be1064d1c9a1df14d2d466c0a4077bd";
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		exCode = "1j9ssoquuky031hge6v4";
		//清除数据
		//准备数据
		//测试过程
        //主订单
		Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("exCode", exCode);//流水单号
        //签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		dataMap.put("sign", sign);
		String url = openapiTestUrl + "?" + formatUrlMap(dataMap, false, false);
		print(url);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
    	print("跳转H5开票response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		//数据验证
		//清除数据
	}
}
