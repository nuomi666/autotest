package com.xjy.autotest.openapinew;

import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.openapi.OpenapiTestBasis;
import com.xjy.autotest.utils.DigestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ychaoyang
 * Created on 2018/08/27.
 */
public class ChargePayApiTest extends OpenapiTestBasis {


    @AutoTest(file = "openapinew/chargePayApiTestSuccess.csv")
    @DisplayName("账务支付--成功用例")
    public void chargePayApiTestSuccess(
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
            String payeeUserId,
            String payeeUserTag,
            String transTag,
            String payAmount,
            String payChannelId,
            String couponIds,
            String authCode,
            String userId,
            String openId,
            String remoteIp,
            String domainName,
            String notifyCategory,
            String notifyUrl1,
            String notifyGroup,
            String notifyVersion,
            String redirectUrl,
            String externalMetaData,
            String memo,
            String extensionContext
    ) {
        //初始化数据
        service = "chargePay";
        partnerId = pId;
        securityCheckCode = secretKey;
        String terminalId = "12345666";
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
        //merchantOrderNo = "merchantOrderNo1562813987884";

        //公众号支付
        payChannelId = "wechat_public_pay";
        //微信扫码
        //payChannelId = "wechat_scan_pay";
        //微信条码
        //payChannelId = "wechat_code_pay";
        //微信小程序
        // payChannelId = "wechat_small_pay";
        //服务窗支付
        //payChannelId = "alipay_public_pay";
        //支付宝扫码
        // payChannelId = "alipay_scan_pay";
        //支付宝条码
        //payChannelId = "alipay_code_pay";
        //支付宝H5
        // payChannelId = "alipay_h5_pay";
        //支付宝APP
        // payChannelId = "alipay_app_pay";
        //刷卡
        // payChannelId = "card_pay";
        //云闪付
        // payChannelId = "union_code_pay";
        //翼支付
        //payChannelId = "bestpay_code_pay";
        //和包支付
        //payChannelId = "cmpay_code_pay";
        //卡券核销
        //payChannelId = "coupon_verify";
        //和悦云闪付
        //payChannelId = "kindly_key";
        terminalId = "00002222";

        authCode = "288463859897658146";

//        payeeUserTag = "S0301808281000000075";
//        payeeUserId = "S0301808281000000074";
        //payeeUserId = "S0301810291300000286";
        //payeeUserTag = "123456";

        //openId = "oMJGHsxKvSsePdX5tC6veng46Rsg";
        openId = "oBsYYv-uVbzUiKZrWlFiUbBdXh_4";
        payAmount = "0.01";
        //清除数据
        //测试过程
        //准备数据
        //transTag = "OFFLINE";
        //主订单
        Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
        dataMap.put("payeeUserId", payeeUserId);//收款人userId
        dataMap.put("payeeUserTag", payeeUserTag);//收款人userTag
        dataMap.put("transTag", transTag);//交易标签
        dataMap.put("payAmount", payAmount);//支付金额
        dataMap.put("payChannelId", payChannelId);//支付渠道ID
        dataMap.put("couponIds", couponIds);//优惠券id数组
        dataMap.put("authCode", authCode);//authCode，条码支付必传
        dataMap.put("userId", userId);//userId，支付宝服务窗支付必传
        dataMap.put("openId", openId);//openId，微信公众号必传
        dataMap.put("remoteIp", remoteIp);//远程IP
        dataMap.put("memo", memo);//描述
        dataMap.put("terminalId", terminalId);//终端号
        //dataMap.put("extensionContext", extensionContext);//extensionContext
        //签名
        String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.setAll(dataMap);
        map.add("sign", sign);
        print(map);
        print(openapiTestUrl);
        //调用接口
        ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
        //结果验证
        print("账务支付response:" + response.toString());
        JSONObject result = JSONObject.parseObject(response.getBody());
        JSONObject info = JSONObject.parseObject(result.getString("info"));
        String prePayInfo = info.getString("prePayInfo");
        System.out.println(info.getString("bizNo"));
        System.out.println(prePayInfo);
        assertEquals(status, result.getString("status"));
        //assertEquals(code, result.getString("code"));
        String bizNo = info.getString("bizNo");
        //数据验证
        //清除数据
        //生成cashier链接
        dataMap.put("bizNo", bizNo);//支付单号
        dataMap.put("redirectUrl", redirectUrl);//备注
        dataMap.put("service", "cashierPay");
        //签名
        String sign1 = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
        MultiValueMap<String, String> map1 = new LinkedMultiValueMap<String, String>();
        map1.setAll(dataMap);
        map1.add("sign", sign1);
        openapiTestUrl = openapiTestUrl + "?" + formatUrlMap(dataMap, false, false);
        //调用接口
        ResponseEntity<String> response1 = restTemplate.postForEntity(openapiTestUrl, map1, String.class);
        //结果验证
        print("收银台跳转response:" + response1.toString());
        String cashierUrl = response1.getHeaders().getLocation().toString();
        System.out.println(cashierUrl);

        if (!payChannelId.contains("public_pay")) {
            return;
        }
        MultiValueMap<String, String> map2 = new LinkedMultiValueMap<String, String>();
        map2.add("content", cashierUrl);
        map2.add("size", "500");
        String qrcodeUrl = "http://rx.autotest.fun/qrcode";
        ResponseEntity<String> response2 = restTemplate.postForEntity(qrcodeUrl, map2, String.class);
        print(qrcodeUrl);
    }

    @Test
    void test() {
        //scheduleCallBackService.justDoIT();
        print("调异步通知重试成功");
        new Thread(() -> System.out.println("测试")).start();
    }
}
