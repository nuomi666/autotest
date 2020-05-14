package com.xjy.autotest.openapinew.payaccounting;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import com.xjy.autotest.testbase.openapi.OpenapiTestBasis;
import com.xjy.autotest.utils.DigestUtil;
import com.xjy.autotest.annotation.AutoTest;
import org.junit.jupiter.api.DisplayName;

/**
 * @author miantiao Created on 2019/07/19.
 */
/**
 * 1.收款方需实名 才能收款，个人会员需实名认证，企业会员需审核通过；（通联)
 * 提现：必须先绑银行卡。
 * 收单：必须实名（所有会员都是实名的）。
 * 绑卡：必须先签约和绑定手机号（由会员系统做的校验，通联本身并未做校验）。
 * 签约：必须先实名。
 * 绑手机：企业需要实名才能绑手机。
 * 目前企业和个人签约用户，只要注册都必须是实名的。
 *
 * 进入235-/usr/local/ngrok/启动ngrok才能扫码访问，nohup ./ngrok-linux -config=./ngrok.cfg -subdomain=hft 8089
 */
public class CreateProfitPayOrderApiTest extends OpenapiTestBasis {
	/**
	 * 1001、只收钱不分润
	 * 1002、分给一个人（固定金额）
	 * 1003、分给2个人（固定金额+比例）
	 * 1004、收款方为金额为0，总金额被瓜分完毕（分账方相同）
	 */
	@AutoTest(file = "openapinew/payaccounting/createProfitPayOrderApiTestSuccess.csv")
	@DisplayName("创建支付分账订单--成功用例")
	public void createProfitPayOrderApiTestSuccess(	int testId, String status, String code,
													// 基本参数
													String service, String version, String partnerId,
													String securityCheckCode, String signType, String merchantOrderNo,
													String context, String returnUrl, String notifyUrl,
													// 业务参数
													String payAmount, String payeeOutUserId, String remark,
													String profitOutUserId, String profitAmount, String profitPercent,
													String profitRemark,
													String profitOutUserId2, String profitAmount2,
													String profitPercent2, String profitRemark2) {
		if(testId==1001||testId==1002||testId==1004){
			return;
		}
		//初始化数据
		service = "createProfitPayOrder";
		partnerId = pId;
		securityCheckCode = secretKey;
		merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		//清除数据
		//准备数据
		//测试过程
		//具体分账信息

		List<Map<Object, Object>> profitOrders = new ArrayList<Map<Object, Object>>();
		Map<Object, Object> profitOrdersMap = new HashMap<Object, Object>();
		profitOrdersMap.put("profitOutUserId", profitOutUserId);//佣金收款人信息
		profitOrdersMap.put("profitAmount", profitAmount);//分润金额
		profitOrdersMap.put("profitPercent", profitPercent);//分润比例
		profitOrdersMap.put("profitRemark", profitRemark);//分润标注

		if(testId==1002||testId==1003||testId==1004){
			profitOrders.add(profitOrdersMap);
		}

		Map<Object, Object> profitOrdersMap2 = new HashMap<Object, Object>();
		profitOrdersMap2.put("profitOutUserId", profitOutUserId2);//佣金收款人信息
		profitOrdersMap2.put("profitAmount", profitAmount2);//分润金额
		profitOrdersMap2.put("profitPercent", profitPercent2);//分润比例
		profitOrdersMap2.put("profitRemark", profitRemark2);//分润标注


		if(testId==1003||testId==1004) {
			profitOrders.add(profitOrdersMap2);
		}
		//主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("payAmount", payAmount);//订单金额(单位:元)
		dataMap.put("payeeOutUserId", payeeOutUserId);//收款人信息
		dataMap.put("remark", remark);//备注信息
		if(testId!=1001) {
			dataMap.put("profitOrders", JSON.toJSONString(profitOrders));//具体分账信息
		}
		//签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
		print("创建支付分账订单response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		JSONObject info=JSONObject.parseObject(result.getString("info"));
		JSONObject amount=JSONObject.parseObject(info.getString("payAmount"));
		assertEquals(payAmount,amount.getString("amount"));
		assertNotNull(info.getString("payUrl"));
		System.out.println("payUrl:"+info.getString("payUrl"));
		//数据验证
		//清除数据
	}
	// 1001、付款金额为空
	// 1002、收款人为空
	// 1003、remark字符超100个字符
	// 1004、分账方为空
	// 1005、同一条分账信息中,固定金额和比例分账方式至少有其一
	// 1006、同一条分账信息中既有分账固定金额又包含比例
	// 1007、profitRemark字符超100个字符
	@AutoTest(file = "openapinew/payaccounting/createProfitPayOrderApiTestFailOne.csv")
	@DisplayName("创建支付分账订单--参数检查用例")
	public void createProfitPayOrderApiTestFailOne(	int testId, String status, String code,
													   // 基本参数
													   String service, String version, String partnerId,
													   String securityCheckCode, String signType, String merchantOrderNo,
													   String context, String returnUrl, String notifyUrl,
													   // 业务参数
													   String payAmount, String payeeOutUserId, String remark,
													   String profitOutUserId, String profitAmount, String profitPercent,
													   String profitRemark) {
		//初始化数据
		service = "createProfitPayOrder";
		partnerId = pId;
		securityCheckCode = secretKey;
		merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		//清除数据
		//准备数据
		//测试过程
		//具体分账信息
		List<Map<Object, Object>> profitOrders = new ArrayList<Map<Object, Object>>();
		Map<Object, Object> profitOrdersMap = new HashMap<Object, Object>();
		if(testId!=1004) {
			profitOrdersMap.put("profitOutUserId", profitOutUserId);//佣金收款人信息
		}
		if(testId!=1005) {
			profitOrdersMap.put("profitAmount", profitAmount);//分润金额
			profitOrdersMap.put("profitPercent", profitPercent);//分润比例
		}
		profitOrdersMap.put("profitRemark", profitRemark);//分润标注
		profitOrders.add(profitOrdersMap);
		//主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		if(testId!=1001) {
			dataMap.put("payAmount", payAmount);//订单金额(单位:元)
		}
		if(testId!=1002) {
			dataMap.put("payeeOutUserId", payeeOutUserId);//收款人信息
		}
		dataMap.put("remark", remark);//备注信息
		if(testId>=1004) {
			dataMap.put("profitOrders", JSON.toJSONString(profitOrders));//具体分账信息
		}
		//签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
		print("创建支付分账订单response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		assertEquals(null,JSONObject.parseObject(result.getString("info")));
		//数据验证
		//清除数据
	}

	/**
	 * 1001、重复发起（订单在处理中）
	 * 1002、重复发起（订单已完成）
	 * 1003、收款方企业会员还在实名中未审核状态
	 * 1004、分账方企业会员还在实名中未审核状态
	 * 1005、收款方不存在
	 * 1006、分账方不存在
	 * 1008、收款方与分账方outUserId一样
	 * 1009、同一条分账信息中既有分账固定金额又包含比例-------
	 * 1010、分账固定金额总额超过总金额
	 * 1011、分账比例总额超过100%
	 * 1012、分账固定金额结合分账比例汇总超过总收单金额
     *
	 * 1013、平台商状态可用--未做对应商户后台管理，暂时不覆盖
	 * 1014、签约商状态不可用--未做对应商户后台管理，暂时不覆盖
	 * 1000、平台商账户不存在(openapi已经拦截，通用处理机制，不做测试）
	 */
	@AutoTest(file = "openapinew/payaccounting/createProfitPayOrderApiTestFailTwo.csv")
	@DisplayName("创建支付分账订单--失败用例")
	public void createProfitPayOrderApiTestFailTwo(	int testId, String status, String code,String description,String message,
													   // 基本参数
													   String service, String version, String partnerId,
													   String securityCheckCode, String signType, String merchantOrderNo,
													   String context, String returnUrl, String notifyUrl,
													   // 业务参数
													   String payAmount, String payeeOutUserId, String remark,
													   String profitOutUserId, String profitAmount, String profitPercent,
													   String profitRemark,
													   String profitOutUserId2, String profitAmount2,
													   String profitPercent2, String profitRemark2) {
		//初始化数据
		service = "createProfitPayOrder";
		partnerId = pId;
		securityCheckCode = secretKey;
		merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
		if(testId==1002){
            merchantOrderNo="merchantOrderNo1564972984359";
        }
		//清除数据
		//准备数据
		//测试过程
		//具体分账信息

		List<Map<Object, Object>> profitOrders = new ArrayList<Map<Object, Object>>();
		Map<Object, Object> profitOrdersMap = new HashMap<Object, Object>();
		profitOrdersMap.put("profitOutUserId", profitOutUserId);//佣金收款人信息
		profitOrdersMap.put("profitAmount", profitAmount);//分润金额
		profitOrdersMap.put("profitPercent", profitPercent);//分润比例
		profitOrdersMap.put("profitRemark", profitRemark);//分润标注
		profitOrders.add(profitOrdersMap);

		Map<Object, Object> profitOrdersMap2 = new HashMap<Object, Object>();
		profitOrdersMap2.put("profitOutUserId", profitOutUserId2);//佣金收款人信息
		profitOrdersMap2.put("profitAmount", profitAmount2);//分润金额
		profitOrdersMap2.put("profitPercent", profitPercent2);//分润比例
		profitOrdersMap2.put("profitRemark", profitRemark2);//分润标注
		profitOrders.add(profitOrdersMap2);
		//主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
		dataMap.put("payAmount", payAmount);//订单金额(单位:元)
		dataMap.put("payeeOutUserId", payeeOutUserId);//收款人信息
		dataMap.put("remark", remark);//备注信息
		dataMap.put("profitOrders", JSON.toJSONString(profitOrders));//具体分账信息
		//签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		if(testId==1001){
			ResponseEntity<String> response1=restTemplate.postForEntity(openapiTestUrl, map, String.class);
		}
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
		print("创建支付分账订单response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody());
		assertEquals(status, result.getString("status"));
		assertEquals(code, result.getString("code"));
		assertEquals(description, result.getString("description"));
		assertEquals(message, result.getString("message"));
		assertEquals(null,JSONObject.parseObject(result.getString("info")));
		//数据验证
		//清除数据
	}
}
