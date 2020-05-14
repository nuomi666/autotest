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
 * Created on 2018/08/28.
 */
public class RegisterAccountApiTest extends OpenapiTestBasis {

	@AutoTest(file = "openapinew/registerAccountApiTestSuccess.csv")
	@DisplayName("开通账户--成功用例")
	public void registerAccountApiTestSuccess(
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
	        String accountType,
	        String bandAccountNo,
	        String memo,
	        String payModel,
	        String tag,
	        String userId
			){
		//初始化数据
		service = "registerAccount";
		partnerId = pId;
		securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();

        userId = "S0301809271600000177";
        tag = "test2";
		//清除数据
		//准备数据
		//测试过程
        //主订单
		Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("accountType", accountType);//账户类型
		dataMap.put("bandAccountNo", bandAccountNo);//绑定账号
		dataMap.put("memo", memo);//备注
		dataMap.put("payModel", payModel);//支付模型 由1/0字符组成，1表示支持，0表示不支持 目前能力循序 转账-充值-提现
		dataMap.put("tag", tag);//标签
		dataMap.put("userId", userId);//用户ID
        //签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
    	print("开通账户response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		//数据验证
		//清除数据
	}
}
