package com.xjy.autotest.openapinew;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import com.xjy.autotest.testbase.openapi.OpenapiTestBasis;
import com.xjy.autotest.utils.DigestUtil;
import com.xjy.autotest.annotation.AutoTest;
import org.junit.jupiter.api.DisplayName;

/**
 * @author ychaoyang
 * Created on 2018/10/23.
 */
public class ApplyApiTest extends OpenapiTestBasis {

    @AutoTest(file = "openapinew/applyApiTestSuccess.csv")
    @DisplayName("请求余额支付--成功用例")
    public void applyApiTestSuccess(
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
            String amount,
            String externalMetaData,
            String link,
            String memo,
            String payerUserId,
            String payerUserTag
    ) {
        //初始化数据
        service = "apply";
        partnerId = pId;
        securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
        // payerUserId = "J0301811051400000290";
        // payerUserTag = "001imyyfggj0s0368h00";
        payerUserId = "20180615001234567891";
        payerUserTag = "20180615001234567891";
        amount = "0.01";
        //清除数据
        //准备数据
        //测试过程
        //主订单
        Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
        dataMap.put("amount", amount);//支付金额
        //dataMap.put("externalMetaData", externalMetaData);//外部数据域（原样返回、仅存储）
        //dataMap.put("link", link);//是否需要账号联动，true 需要，false 不需要
        dataMap.put("memo", memo);//描述
        dataMap.put("payerUserId", payerUserId);//付款人userId
        dataMap.put("payerUserTag", payerUserTag);//付款人Tag
        //签名
        String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.setAll(dataMap);
        map.add("sign", sign);
        print(map);
        //调用接口
        ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
        //结果验证
        print("请求余额支付response:" + response.toString());
        JSONObject result = JSONObject.parseObject(response.getBody());
        JSONObject info = JSONObject.parseObject(result.getString("info"));
        System.out.println(info.getString("bizNo"));
        assertEquals(status, result.getString("status"));
        assertEquals(code, result.getString("code"));
        //数据验证
        //清除数据
    }
}
