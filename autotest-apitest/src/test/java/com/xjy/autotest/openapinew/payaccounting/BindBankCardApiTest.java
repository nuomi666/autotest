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
 * @author miantiao Created on 2019/07/16.
 *  绑卡：必须先签约和绑定手机号（由会员系统做的校验，通联本身并未做校验）。
 *  提现：必须先绑银行卡。
 *	收单：必须实名（所有会员都是实名的）。
 * 	绑卡：必须先签约和绑定手机号（由会员系统做的校验，通联本身并未做校验）。
 * 	签约：必须先实名。
 * 	绑手机：企业需要实名才能绑手机。
 * 	目前企业和个人签约用户，只要注册都必须是实名的。
 */
public class BindBankCardApiTest extends OpenapiTestBasis {
	@Autowired
	MerchantTestBase merchantTestBase;
	//绑卡前必须签约和绑定手机号，这个校验是由会员系统做的校验，通联本身并未做校验
	//企业只能绑定一张卡由通联进行拦截处理的
	@AutoTest(file = "openapinew/payaccounting/bindBankCardApiTestSuccess.csv")
	@DisplayName("会员绑定银行卡--成功用例")
	public void bindBankCardApiTestSuccess(	int testId, String status, String code,
											// 基本参数
											String service, String version, String partnerId, String securityCheckCode,
											String signType, String merchantOrderNo, String context, String returnUrl,
											String notifyUrl,
											// 业务参数
											String bankCardIDcard, String bankCardName, String bankCardNo,
											String bankCardPhone, String outUserId) {
		//初始化数据
		service = "bindBankCard";
		partnerId = pId;
		securityCheckCode = secretKey;
		merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		//清除数据
		//准备数据
		//测试过程
		//主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("bankCardIDcard", bankCardIDcard);//开户人身份证号
		dataMap.put("bankCardName", bankCardName);//开户人姓名
		dataMap.put("bankCardNo", bankCardNo);//银行卡号
		dataMap.put("bankCardPhone", bankCardPhone);//银行预留手机号
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
		print("会员绑定银行卡response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		//数据验证
		//清除数据
	}

	@AutoTest(file = "openapinew/payaccounting/bindBankCardApiTestFailOne.csv")
	@DisplayName("会员绑定银行卡--参数检查用例")
	public void bindBankCardApiTestFailOne(	int testId, String status, String code,
											   // 基本参数
											   String service, String version, String partnerId, String securityCheckCode,
											   String signType, String merchantOrderNo, String context, String returnUrl,
											   String notifyUrl,
											   // 业务参数
											   String bankCardIDcard, String bankCardName, String bankCardNo,
											   String bankCardPhone, String outUserId) {
		//初始化数据
		service = "bindBankCard";
		partnerId = pId;
		securityCheckCode = secretKey;
		merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		//清除数据
		//准备数据
		//测试过程
		//主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("bankCardIDcard", bankCardIDcard);//开户人身份证号
		dataMap.put("bankCardName", bankCardName);//开户人姓名
		dataMap.put("bankCardNo", bankCardNo);//银行卡号
		dataMap.put("bankCardPhone", bankCardPhone);//银行预留手机号
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
		print("会员绑定银行卡response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		//数据验证
		//清除数据
	}

	/**
	 * 四要素不匹配，通联环境验证不了，需要后续跟上mock
	 * 1001、重复绑定（个人）
	 * 1002、企业绑定第二张法定代表人的个人银行卡
	 * 1003、outUserId不存在
	 * 1004、个人绑卡的真实名与实名真实名不一致
	 * 1005、个人绑卡的身份证证件号与实名身份证证件号不一致
	 * 1006、企业未实名通过，申请绑定法定代表人个人银行卡-------可能不需要，会被未签约场景代替
	 * 1007、个人绑卡未签约
	 * 1008、个人绑卡未绑定手机
	 * 1009、企业法定代表人绑卡未签约
	 */

	@AutoTest(file = "openapinew/payaccounting/bindBankCardApiTestFailTwo.csv")
	@DisplayName("会员绑定银行卡--失败用例")
	public void bindBankCardApiTestFailTwo(	int testId, String status, String code,
											   // 基本参数
											   String service, String version, String partnerId, String securityCheckCode,
											   String signType, String merchantOrderNo, String context, String returnUrl,
											   String notifyUrl,
											   // 业务参数
											   String bankCardIDcard, String bankCardName, String bankCardNo,
											   String bankCardPhone, String outUserId) {
		//初始化数据
		service = "bindBankCard";
		partnerId = pId;
		securityCheckCode = secretKey;
		merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		//清除数据
		if(testId==1003){
			merchantTestBase.cleanMerchantByOutUserId(outUserId);
		}
		//准备数据
		//测试过程
		//主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("bankCardIDcard", bankCardIDcard);//开户人身份证号
		dataMap.put("bankCardName", bankCardName);//开户人姓名
		dataMap.put("bankCardNo", bankCardNo);//银行卡号
		dataMap.put("bankCardPhone", bankCardPhone);//银行预留手机号
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
		print("会员绑定银行卡response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		//数据验证
		//清除数据
	}
}
