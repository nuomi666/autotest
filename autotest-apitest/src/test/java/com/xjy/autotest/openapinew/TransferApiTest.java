package com.xjy.autotest.openapinew;

import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.openapi.OpenapiTestBasis;
import com.xjy.autotest.utils.DigestUtil;
import org.junit.jupiter.api.DisplayName;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ychaoyang
 * Created on 2018/11/05.
 */
public class TransferApiTest extends OpenapiTestBasis {

	@AutoTest(file = "openapinew/transferApiTestSuccess.csv")
	@DisplayName("单笔转账--成功用例")
	public void transferApiTestSuccess(
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
	        String externalMetaData,
	        String memo,
	        String payAmount,
	        String payeeFreezeAmount,
	        String payeeFreezeCode,
	        String payeeUserId,
	        String payeeUserTag,
	        String payerUnFreezeAmount,
	        String payerUnFreezeCode,
	        String payerUserId,
	        String payerUserTag
			){
		//初始化数据
		service = "transfer";
		partnerId = pId;
		securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		//清除数据
		//准备数据
		//测试过程
        //payerUserId = "S0301808281000000074";
        //payerUserTag = "S0301808281000000075";
        //payeeUserId = "S0301812061000000151";
        //payeeUserTag = "001iqd7v2evcs0368h00";
        payAmount = "0.1";
        //主订单
		Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("externalMetaData", externalMetaData);//外部数据域（原样返回、仅存储）
		dataMap.put("memo", memo);//描述
		dataMap.put("payAmount", payAmount);//转账金额
		dataMap.put("payeeFreezeAmount", payeeFreezeAmount);//收款方冻结金额
		dataMap.put("payeeFreezeCode", payeeFreezeCode);//收款方冻结码
		dataMap.put("payeeUserId", payeeUserId);//收款方会员ID
		dataMap.put("payeeUserTag", payeeUserTag);//收款方会员tag
		dataMap.put("payerUnFreezeAmount", payerUnFreezeAmount);//付款方解冻金额
		dataMap.put("payerUnFreezeCode", payerUnFreezeCode);//付款方解冻码
		dataMap.put("payerUserId", payerUserId);//付款方会员ID
		dataMap.put("payerUserTag", payerUserTag);//付款方会员tag
        //签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
    	print("单笔转账response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		//数据验证
		//清除数据
	}

	public static void main(String[] args) throws IOException {
		// 使用 System.in 创建 BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		System.out.println("Enter lines of text.");
		System.out.println("Enter 'end' to quit.");
		do {
			str = br.readLine();
			System.out.println(str);
		} while (!str.equals("end"));
	}
}
