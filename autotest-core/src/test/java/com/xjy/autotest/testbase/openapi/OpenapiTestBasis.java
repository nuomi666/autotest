package com.xjy.autotest.testbase.openapi;

import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.utils.DateUtils;
import com.xjy.autotest.utils.DigestUtil;
import com.xjy.autotest.utils.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yu on 2017/9/28.
 */
public class OpenapiTestBasis extends OpenapiTestParameters {


    @BeforeAll
    static void init() {
//        new JSchUtil().go();
    }

//	@AfterAll
//	static void tearDown() {
//
//	}

    protected RestTemplate restTemplate = new RestTemplate();

    /**
     * 创建订单
     *
     * @param partnerId
     * @param key
     * @param merchOrderNo
     * @param tradeScene
     * @param sellerMerchUserId
     * @param payerMerchUserId
     * @param profitType
     * @param amount
     * @param discountAmount
     * @param discountMerchUserId
     * @return
     */
    public JSONObject orderCreate(String partnerId, String key, String merchOrderNo, String tradeScene, String
            sellerMerchUserId, String payerMerchUserId, String profitType, String amount, String discountAmount,
                                  String discountMerchUserId) {
        //主订单
        String tradeTime = DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
        String closeTime = DateUtils.formatDate(DateUtils.getEndDateOfDay(new Date()), "yyyy-MM-dd HH:mm:ss");
        String requestNo = "requestNo2" + System.currentTimeMillis();
        String service = "orderCreate";
        String protocol = "HTTP_FORM_JSON";
        String version = "1.0";
        String signType = "MD5";
        String context = "context";
        String notifyUrl = NOTIFY_URL;
        String returnUrl = NOTIFY_URL;
        String tradeMemo = "tradeMemo";
        String userIp = "127.0.0.1";
        String buyerMerchUserId = payerMerchUserId;
        Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(requestNo, protocol, service, version, partnerId, signType, merchOrderNo, context, notifyUrl,
                returnUrl, dataMap);
        dataMap.put("tradeScene", tradeScene);//交易场景
        dataMap.put("tradeName", "交易名称");//交易名称
        dataMap.put("sellerMerchUserId", sellerMerchUserId);//卖家商户用户id
        dataMap.put("buyerMerchUserId", buyerMerchUserId);//买家商户用户id
        dataMap.put("payerMerchUserId", payerMerchUserId);//付款人商户用户id
        dataMap.put("profitType", profitType);//清分类型
        dataMap.put("amount", amount);//交易金额
        if (StringUtils.isNotBlank(discountAmount)) {
            dataMap.put("discountAmount", discountAmount);//优惠金额
        }
        if (StringUtils.isNotBlank(discountMerchUserId)) {
            dataMap.put("discountMerchUserId", discountMerchUserId);//优惠金账户
        }
        dataMap.put("tradeTime", tradeTime);//交易时间
        dataMap.put("closeTime", closeTime);//自动关闭时间
        dataMap.put("tradeMemo", tradeMemo);//交易备注
        dataMap.put("userIp", userIp);//用户ip
        //签名
        String sign = DigestUtil.digest(dataMap, key, DigestUtil.DigestALGEnum.MD5, "UTF-8");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.setAll(dataMap);
        map.add("sign", sign);
        print(map);
        //调用接口
        ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
        //结果验证
        print("创建支付订单response:" + response.toString());
        JSONObject result = JSONObject.parseObject(response.getBody());
        assertEquals("EXECUTE_SUCCESS", result.getString("resultCode"));
        return result;
    }

    /**
     * 余额支付
     *
     * @param partnerId
     * @param key
     * @param merchOrderNo
     * @param payerMerchUserId
     * @return
     */
    public JSONObject balancePay(String partnerId, String key, String merchOrderNo, String payerMerchUserId) {
        String requestNo = "requestNo1" + System.currentTimeMillis();
        String service = "balancePay";
        String protocol = "HTTP_FORM_JSON";
        String version = "1.0";
        String signType = "MD5";
        String context = "context";
        String notifyUrl = NOTIFY_URL;
        String returnUrl = NOTIFY_URL;
        String userIp = "127.0.0.1";
        //主订单
        Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(requestNo, protocol, service, version, partnerId, signType, merchOrderNo, context, notifyUrl,
                returnUrl, dataMap);
        dataMap.put("payerMerchUserId", payerMerchUserId);//付款人商户用户id
        dataMap.put("userIp", userIp);//用户ip
        //签名
        String sign = DigestUtil.digest(dataMap, key, DigestUtil.DigestALGEnum.MD5, "UTF-8");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.setAll(dataMap);
        map.add("sign", sign);
        print(map);
        //调用接口
        ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
        //结果验证
        print("余额支付response:" + response.toString());
        JSONObject result = JSONObject.parseObject(response.getBody());
        return result;
    }

    /**
     * 组装公共参数
     *
     * @param requestNo
     * @param protocol
     * @param service
     * @param version
     * @param partnerId
     * @param signType
     * @param merchOrderNo
     * @param context
     * @param notifyUrl
     * @param returnUrl
     * @param dataMap
     */
    public void buildMap(String requestNo, String protocol, String service, String version, String partnerId,
                         String signType, String merchOrderNo, String context, String notifyUrl, String
                                 returnUrl, Map<String, String> dataMap) {
        if (StringUtils.isNotBlank(requestNo)) {
            dataMap.put("requestNo", requestNo);
        }
        if (StringUtils.isNotBlank(protocol)) {
            dataMap.put("protocol", protocol);
        }
        if (StringUtils.isNotBlank(service)) {
            dataMap.put("service", service);
        }
        if (StringUtils.isNotBlank(version)) {
            dataMap.put("version", version);
        }
        if (StringUtils.isNotBlank(partnerId)) {
            dataMap.put("partnerId", partnerId);
        }
        if (StringUtils.isNotBlank(signType)) {
            dataMap.put("signType", signType);
        }
        if (StringUtils.isNotBlank(merchOrderNo)) {
            dataMap.put("merchOrderNo", merchOrderNo);
        }
        if (StringUtils.isNotBlank(context)) {
            dataMap.put("context", context);
        }
        if (StringUtils.isNotBlank(notifyUrl)) {
            dataMap.put("notifyUrl", notifyUrl);
        }
        if (StringUtils.isNotBlank(returnUrl)) {
            dataMap.put("returnUrl", returnUrl);
        }
    }

    /**
     * 组装公共参数
     *
     * @param dataMap
     */
    public void buildMap(String service, String version, String partnerId, String signType, String merchantOrderNo,
                         String context, String notifyUrl, String returnUrl, Map<String, String> dataMap) {
        if (StringUtils.isNotBlank(service)) {
            dataMap.put("service", service);
        }
        if (StringUtils.isNotBlank(version)) {
            dataMap.put("version", version);
        }
        if (StringUtils.isNotBlank(partnerId)) {
            dataMap.put("partnerId", partnerId);
        }
        if (StringUtils.isNotBlank(signType)) {
            dataMap.put("signType", signType);
        }
        if (StringUtils.isNotBlank(merchantOrderNo)) {
            dataMap.put("merchantOrderNo", merchantOrderNo);
        }
        if (StringUtils.isNotBlank(context)) {
            dataMap.put("context", context);
        }
        if (StringUtils.isNotBlank(notifyUrl)) {
            dataMap.put("notifyUrl", notifyUrl);
        }
        if (StringUtils.isNotBlank(returnUrl)) {
            dataMap.put("returnUrl", returnUrl);
        }
    }

}
