package com.xjy.autotest.allinpay;

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
 * Created on 2019/07/04.
 */
public class AllinPaySetCompanyInfoApiTest extends OpenapiTestBasis {

	@AutoTest(file = "allinpay/allinPaySetCompanyInfoApiTestSuccess.csv")
	@DisplayName("云商通企业实名--成功用例")
	public void allinPaySetCompanyInfoApiTestSuccess(
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
	        String bankName,
	        String bankSettlementUrl,
	        String businessLicense,
	        String businessLicenseUrl,
	        String companyName,
	        String icpUrl,
	        String identityType,
	        String industryPermitUrl,
	        String legalCerificateBackUrl,
	        String legalCerificateFrontUrl,
	        String legalIds,
	        String legalName,
	        String legalPhone,
	        String organizationCode,
	        String organizationCodeUrl,
	        String orgCreditCodeUrl,
	        String parentBankName,
	        String taxCertificateUrl,
	        String taxRegister,
	        String uniCredit,
	        String unionBank
			){
		//初始化数据
		service = "allinPaySetCompanyInfo";
		partnerId = pId;
		securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();

		accountNo = "110932076810902";
		bankName = "北京欣业邦信息技术有限公司";
		companyName = "北京欣业邦信息技术有限公司";
		identityType = "IDENTITY_CARD";
		legalIds = "622827197901174116";
		legalName = "慕向洲";
		legalPhone = "18580627269";
		parentBankName = "招商银行";
		unionBank = "308100005141";
		uniCredit = "91110107MA01A5YX2E";
		//businessLicense = "91110107MA01A5YX2E";
		organizationCode = "";
		taxRegister = "";
		//清除数据
		//准备数据
		businessLicenseUrl = "https://i.loli.net/2019/09/09/3SRDK8UQtpH2gOM.jpg";
		legalCerificateFrontUrl = "https://i.loli.net/2019/09/09/NJeTSKyA3hQkECj.jpg";
		legalCerificateBackUrl = "https://i.loli.net/2019/09/09/E4tNZTzwUbX7cG9.jpg";
		bankSettlementUrl = "https://i.loli.net/2019/09/09/CkSZxomr89sBYzv.png";
		//测试过程
        //主订单
		Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("accountNo", accountNo);//企业对公银行卡账户(云商通必传)
		dataMap.put("bankName", bankName);//开户行支行名称(云商通必传)
		dataMap.put("bankSettlementUrl", bankSettlementUrl);//对公账户开户许可证图片URL
		dataMap.put("businessLicense", businessLicense);//营业执照(三证)
		dataMap.put("businessLicenseUrl", businessLicenseUrl);//营业执照图片URL
		dataMap.put("companyName", companyName);//企业名称(云商通必传)
		//dataMap.put("icpUrl", icpUrl);//icp备案许可图片URL
		dataMap.put("identityType", identityType);//法人证件类型(云商通必传)
		//dataMap.put("industryPermitUrl", industryPermitUrl);//行业许可证图片URL
		dataMap.put("legalCerificateBackUrl", legalCerificateBackUrl);//企业法人证件-反面图片URL
		dataMap.put("legalCerificateFrontUrl", legalCerificateFrontUrl);//企业法人证件-正面图片URL
		dataMap.put("legalIds", legalIds);//法人证件号码(云商通必传)
		dataMap.put("legalName", legalName);//法人姓名(云商通必传)
		dataMap.put("legalPhone", legalPhone);//法人手机号码(云商通必传)
		//dataMap.put("organizationCode", organizationCode);//组织机构代码(三证)
		//dataMap.put("organizationCodeUrl", organizationCodeUrl);//组织机构代码证图片URL
		//dataMap.put("orgCreditCodeUrl", orgCreditCodeUrl);//结构信用代码证图片URL
		dataMap.put("parentBankName", parentBankName);//开户银行名称(云商通必传)
		//dataMap.put("taxCertificateUrl", taxCertificateUrl);//税务登记证图片URL
		//dataMap.put("taxRegister", taxRegister);//税务登记证(三证)
		dataMap.put("uniCredit", uniCredit);//统一社会信用(一证) 三证一证 二选一
		dataMap.put("unionBank", unionBank);//开户行支付行号(云商通必传)
        //签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
    	print("云商通企业实名response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		//数据验证
		//清除数据
	}
}
