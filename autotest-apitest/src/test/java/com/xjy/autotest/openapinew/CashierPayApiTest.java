package com.xjy.autotest.openapinew;

import java.util.HashMap;
import java.util.Map;

import com.xjy.autotest.testbase.openapi.OpenapiTestBasis;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import com.xjy.autotest.utils.DigestUtil;
import com.xjy.autotest.annotation.AutoTest;
import org.junit.jupiter.api.DisplayName;

/**
 * @author ychaoyang
 * Created on 2018/08/24.
 */
public class CashierPayApiTest extends OpenapiTestBasis {

    @AutoTest(file = "openapinew/cashierPayApiTestSuccess.csv")
    @DisplayName("收银台跳转--成功用例")
    public void cashierPayApiTestSuccess(
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
            String bizNo,
            String memo,
            String redirectUrl
    ) {
        //初始化数据
        service = "cashierPay";
        partnerId = pId;
        securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
        //merchantOrderNo = "merchantOrderNo1536718793221";

        bizNo = "001ipmrnow6ws056y000";
        redirectUrl = "http://rx.autotest.fun/api/receive.json?appId=123124321";
        //cashier.shenmapay.com/cashier/pay.htm
        //清除数据
        //准备数据
        //测试过程
        //主订单
        Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
        dataMap.put("bizNo", bizNo);//支付单号
        //dataMap.put("memo", memo);//备注
        dataMap.put("redirectUrl", redirectUrl);//备注
        //签名
        String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.setAll(dataMap);
        map.add("sign", sign);
        dataMap.put("sign", sign);
        openapiTestUrl = openapiTestUrl + "?" + formatUrlMap(dataMap, false, false);
        //System.out.println(openapiTestUrl);
        //调用接口
        //ResponseEntity<String> response = restTemplate.exchange(openapiTestUrl, HttpMethod.GET, null, String.class);
        ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
        //结果验证
        print("收银台跳转response:" + response.toString());
        System.out.println(response.getHeaders().getLocation().toString());
        //数据验证
        //清除数据
    }
}
