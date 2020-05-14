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
 * @author miantiao Created on 2019/07/15.
 * 提现：必须先绑银行卡。
 * 收单：必须实名（所有会员都是实名的）。
 * 绑卡：必须先签约和绑定手机号（由会员系统做的校验，通联本身并未做校验）。
 * 签约：必须先实名。
 * 绑手机：企业需要实名才能绑手机。
 * 目前企业和个人签约用户，只要注册都必须是实名的。
 */
public class BindMobileApiTest extends OpenapiTestBasis {
	@Autowired
	MerchantTestBase merchantTestBase;
	//不同手机号统一userId多次绑定（异常）

	@AutoTest(file = "openapinew/payaccounting/bindMobileApiTestSuccess.csv")
	@DisplayName("绑定手机号--成功用例")
	public void bindMobileApiTestSuccess(	int testId, String status, String code,
											// 基本参数
											String service, String version, String partnerId, String securityCheckCode,
											String signType, String merchantOrderNo, String context, String returnUrl,
											String notifyUrl,
											// 业务参数
											String outUserId, String phone, String verificationCode) {
		//初始化数据
		service = "bindMobile";
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
		dataMap.put("phone", phone);//手机号
		dataMap.put("verificationCode", verificationCode);//验证码
		//签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
		print("绑定手机号response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		//数据验证
		//清除数据
	}
	/**
	 * 1001、会员不存在
	 * 1002、平台商不存在
	 * 1003、重复绑定（同手机号-新验证码）--目前由欣业邦会员系统校验拦截已绑定手机号不再去通联绑定了，返回成功的处理。
	 * 1004、重复绑定（不同手机号不同验证码）--目前由欣业邦会员系统校验拦截已绑定手机号不再去通联绑定了，返回失败和拒绝此次绑定的处理。
	 * 1005、不发送验证码，直接给码绑定(与1006一致）
	 * 1006、发送了验证码，但给码与发送不匹配
	 * 1007、企业会员未实名，申请绑定---xyb-merchant系统进行的拦截
	 */
	@AutoTest(file = "openapinew/payaccounting/bindMobileApiTestFailTwo.csv")
	@DisplayName("绑定手机号--失败用例")
	public void bindMobileApiTestFailTwo(	int testId, String status, String code,
											 // 基本参数
											 String service, String version, String partnerId, String securityCheckCode,
											 String signType, String merchantOrderNo, String context, String returnUrl,
											 String notifyUrl,
											 // 业务参数
											 String outUserId, String phone, String verificationCode) {
		if(testId==1001||testId==1002||testId==1005||testId==1006||testId==1007){
			return;
		}
		//初始化数据
		service = "bindMobile";
		if(testId!=1002){
			partnerId = pId;
		}
		securityCheckCode = secretKey;
		merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		//清除数据
		if(testId==1001){
			merchantTestBase.cleanMerchantByOutUserId(outUserId);
		}
		//准备数据
		//测试过程
		//主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("outUserId", outUserId);//外部用户ID
		dataMap.put("phone", phone);//手机号
		dataMap.put("verificationCode", verificationCode);//验证码
		//签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
		print("绑定手机号response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		//数据验证
		//清除数据
	}
}
