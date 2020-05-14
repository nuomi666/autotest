package com.xjy.autotest.openapinew;

import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.openapi.OpenapiTestBasis;
import com.xjy.autotest.utils.DigestUtil;
import org.junit.jupiter.api.DisplayName;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ychaoyang
 * Created on 2018/12/30.
 */
public class UnfreezeBalanceApiTest extends OpenapiTestBasis {

	@AutoTest(file = "openapinew/unfreezeBalanceApiTestSuccess.csv")
	@DisplayName("解冻--成功用例")
	public void unfreezeBalanceApiTestSuccess(
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
	        String accountNo,
	        String amount,
	        String freezeCode,
	        String linkAccountNo,
	        String memo,
	        String payChannel,
	        String tag,
	        String transType,
	        String userId
			){
		//初始化数据
		service = "unfreezeBalance";
		partnerId = pId;
		securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		freezeCode ="CLEAR";
		accountNo = "001iqtr0w2uks0368h00";
		amount = "0.42";
		//清除数据
		//准备数据
		//测试过程
        //主订单
		Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("accountNo", accountNo);//账号
		dataMap.put("amount", amount);//交易金额
		dataMap.put("freezeCode", freezeCode);//冻结类型
//		dataMap.put("linkAccountNo", linkAccountNo);//联动账户账号
//		dataMap.put("memo", memo);//备注
//		dataMap.put("payChannel", payChannel);//渠道信息，该信息仅作为记录
//		dataMap.put("tag", tag);//账户标签
//		dataMap.put("transType", transType);//交易类型，默认通用
//		dataMap.put("userId", userId);//用户ID
        //签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
    	print("解冻response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		//数据验证
		//清除数据
	}
}
