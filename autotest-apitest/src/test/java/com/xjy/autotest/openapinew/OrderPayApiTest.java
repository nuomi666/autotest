package com.xjy.autotest.openapinew;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.openapi.OpenapiTestBasis;
import com.xjy.autotest.utils.DigestUtil;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.util.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ychaoyang
 * Created on 2018/08/22.
 */
public class OrderPayApiTest extends OpenapiTestBasis {

    @AutoTest(file = "openapinew/orderPayApiTestSuccess.csv")
    @DisplayName("统一订单支付--成功用例")
    public void orderPayApiTestSuccess(
            int testId,
            String status,
            String code,
            // 基本参数
            String protocol,
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
            String authCode,
            String memo,
            String openId,
            String payAmount,
            String payChannelId,
            String redirectUrl,
            String remoteIp,
            String transTag,
            String userId,
            String profitInfo
    ) {
        //初始化数据
        service = "orderPay";
        partnerId = pId;
        securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + OID.newID();
        //merchantOrderNo = "merchantOrderNo1564561729382";
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
        //payChannelId = "alipay_scan_pay";
        //支付宝条码
        //payChannelId = "alipay_code_pay";
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

        //authCode = "322401910218036567";
        //authCode = "322406211395845072";
        String terminalId = "00002222";

        authCode = "";

        payAmount = "1";

        JSONObject json = new JSONObject();
        //json.put("payerUserId", "S0301907101500091588");
        json.put("payeeUserId", "20180615001234567891");
        //json.put("profitAmount", new Money(0.02));
        //json.put("profitPercent", 0.4);

        JSONObject json1 = new JSONObject();
        json1.put("payerUserId", "S0301909041500092052");
        json1.put("payeeUserId", "S0301909041100092050");
        json1.put("profitAmount", new Money(0.01));
        //json1.put("profitPercent", 0.1);

        JSONArray jsonArray = new JSONArray();
        //jsonArray.add(json);
        jsonArray.add(json1);
        profitInfo = jsonArray.toJSONString();
        //清除数据
        //准备数据
        //测试过程
        //主订单
        Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
        dataMap.put("authCode", authCode);//条码支付必传
        dataMap.put("memo", "订单编码号[1jqv2sqipog0#汽油付款订单");//描述
        dataMap.put("openId", openId);//微信公众号必传
        dataMap.put("payAmount", payAmount);//支付金额
        dataMap.put("payChannelId", payChannelId);//支付渠道ID
        dataMap.put("remoteIp", remoteIp);//远程IP
        dataMap.put("transTag", transTag);//交易标签
        dataMap.put("userId", userId);//支付宝服务窗支付必传
        dataMap.put("terminalId", terminalId);//终端号
        //dataMap.put("profitInfo", profitInfo);
        //签名
        String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.setAll(dataMap);
        map.add("sign", sign);
        print(map);
        //调用接口
        ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
        //结果验证
        print("统一订单支付response:" + response.getBody());
        JSONObject result = JSONObject.parseObject(response.getBody());
        JSONObject info = JSONObject.parseObject(result.getString("info"));
        print(info);
        print(info.get("bizNo"));
        print(info.get("merchantOrderNo"));
        assertEquals(status, result.getString("status"));
        //assertEquals(code, result.getString("code"));
        //数据验证

        //清除数据
        //生成cashier链接
        String bizNo = info.getString("bizNo");
        Map<String, String> dataMap1 = new HashMap();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap1);
        dataMap1.put("bizNo", bizNo);//支付单号
        dataMap1.put("redirectUrl", redirectUrl);//备注
        dataMap1.put("service", "cashierPay");
        //签名
        String sign1 = DigestUtil.digest(dataMap1, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
        MultiValueMap<String, String> map1 = new LinkedMultiValueMap();
        map1.setAll(dataMap1);
        map1.add("sign", sign1);
        String url = openapiTestUrl + "?" + formatUrlMap(dataMap1, false, false);
        //调用接口
        ResponseEntity<String> response1 = restTemplate.postForEntity(url, map1, String.class);
        //结果验证
        print("收银台跳转response:" + response1.toString());
        String cashierUrl = response1.getHeaders().getLocation().toString();
        //System.out.println(cashierUrl);

        if (!payChannelId.contains("public_pay")) {
            return;
        }
        MultiValueMap<String, String> map2 = new LinkedMultiValueMap<String, String>();
        map2.add("content", cashierUrl);
        map2.add("size", "500");
        String qrcodeUrl = "http://rx.autotest.fun/qrcode";
        ResponseEntity<String> response2 = restTemplate.postForEntity(qrcodeUrl, map2, String.class);
        print(qrcodeUrl);
        //Pattern pattern = Pattern.compile("http://.*png");
        //Matcher matcher = pattern.matcher(response2.getBody());
        //if (matcher.find()) {
        //    System.out.println(matcher.group());
        //}

    }
}
