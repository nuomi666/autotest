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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ychaoyang
 * Created on 2019/07/30.
 */
public class AgentCollectApiTest extends OpenapiTestBasis {

    @AutoTest(file = "allinpay/agentCollectApiTestSuccess.csv")
    @DisplayName("订单代收支付--成功用例")
    public void agentCollectApiTestSuccess(
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
            String agentPayeeList,
            String authCode,
            String domainName,
            String externalMetaData,
            String memo,
            String openId,
            String payAmount,
            String payChannelId,
            String payerUserId,
            String remoteIp,
            String userId
    ) {
        //初始化数据
        service = "agentCollect";
        partnerId = pId;
        securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
        //merchantOrderNo = "merchantOrderNo1564562882216";
        //清除数据
        //准备数据
        //测试过程
        //微信扫码
        payChannelId = "wechat_scan_pay_agent";
        //刷卡
        payChannelId = "card_pay_agent";
        payAmount = "0.01";
        payerUserId = "S0301909041500092052";
        String payeeUserId = "S0301909061500092055";
        JSONObject payeeList = new JSONObject();
        payeeList.put(payeeUserId, "0.01");
        //payeeList.put("S0301907260900091735", "0.01");
        //主订单
        Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
        dataMap.put("agentPayeeList", payeeList.toString());//收款列表（key=收款人userId,value=收款金额）
        dataMap.put("authCode", authCode);//authCode，条码支付必传
        dataMap.put("domainName", domainName);//域名
        dataMap.put("externalMetaData", externalMetaData);//外部数据域（原样返回、仅存储）
        dataMap.put("memo", memo);//描述
        dataMap.put("openId", openId);//openId，微信公众号必传
        dataMap.put("payAmount", payAmount);//支付金额(支付金额=收款列表金额总和)
        dataMap.put("payChannelId", payChannelId);//支付渠道ID
        dataMap.put("payerUserId", payerUserId);//付款人userId
        dataMap.put("userId", userId);//userId，支付宝服务窗支付必传
        dataMap.put("remoteIp", remoteIp);//远程IP
        //签名
        String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.setAll(dataMap);
        map.add("sign", sign);
        print(map);
        //调用接口
        ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
        //结果验证
        print("订单代收支付response:" + response.toString());
        JSONObject result = JSONObject.parseObject(response.getBody());
        assertEquals(status, result.getString("status"));
        assertEquals(code, result.getString("code"));
        JSONObject info = JSONObject.parseObject(result.getString("info"));
        print(info);
        print(info.get("bizNo"));
        //数据验证
        //清除数据
        //生成cashier链接
        String bizNo = info.getString("bizNo");
        Map<String, String> dataMap1 = new HashMap();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap1);
        dataMap1.put("bizNo", bizNo);//支付单号
        dataMap1.put("redirectUrl", returnUrl);//备注
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
        System.out.println(cashierUrl);

        if (!payChannelId.contains("public_pay")) {
            return;
        }
        MultiValueMap<String, String> map2 = new LinkedMultiValueMap<String, String>();
        map2.add("content", cashierUrl);
        map2.add("size", "500");
        String qrcodeUrl = "http://www.mxnzp.com/api/qrcode/create/single";
        ResponseEntity<String> response2 = restTemplate.postForEntity(qrcodeUrl, map2, String.class);
        print(response2);
        Pattern pattern = Pattern.compile("http://.*png");
        Matcher matcher = pattern.matcher(response2.getBody());
        if (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
