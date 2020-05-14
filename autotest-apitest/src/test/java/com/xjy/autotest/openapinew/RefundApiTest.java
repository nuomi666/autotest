package com.xjy.autotest.openapinew;

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
 * Created on 2018/08/24.
 */
public class RefundApiTest extends OpenapiTestBasis {

    @AutoTest(file = "openapinew/refundApiTestSuccess.csv")
    @DisplayName("退款--成功用例")
    public void refundApiTestSuccess(
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
            String extensionContext,
            String externalMetaData,
            String memo,
            String notifyCategory,
            String notifyGroup,
            String notifyVersion,
            String orderNo,
            String redirectUrl,
            String refundAmount
    ) {
        //初始化数据
        service = "refund";
        partnerId = pId;
        securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();

        bizNo = "1k4bd83noss051hge8er";
        refundAmount = "0.01";
        //清除数据
        //准备数据
        //测试过程
        //主订单
        Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
        dataMap.put("bizNo", bizNo);//平台订单号(不可与商户订单号同时为空)
        dataMap.put("orderNo", orderNo);//商户订单号(不可与平台订单号同时为空)
        dataMap.put("extensionContext", extensionContext);//extensionContext
        dataMap.put("externalMetaData", externalMetaData);//externalMetaData
        dataMap.put("memo", memo);//memo
        dataMap.put("refundAmount", refundAmount);//退款金额
        //签名
        String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.setAll(dataMap);
        map.add("sign", sign);
        print(map);
        //调用接口
        ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
        //结果验证
        print("退款response:" + response.toString());
        JSONObject result = JSONObject.parseObject(response.getBody());
        assertEquals(status, result.getString("status"));
        assertEquals(code, result.getString("code"));
        //数据验证
        //清除数据
    }
}
