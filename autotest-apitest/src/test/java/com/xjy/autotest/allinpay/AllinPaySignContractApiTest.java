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
public class AllinPaySignContractApiTest extends OpenapiTestBasis {

    @AutoTest(file = "allinpay/allinPaySignContractApiTestSuccess.csv")
    @DisplayName("云商通电子签约--成功用例")
    public void allinPaySignContractApiTestSuccess(
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
            String jumpUrl
    ) {
        //初始化数据
        service = "allinPaySignContract";
        partnerId = pId;
        securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();

        jumpUrl = notifyUrl;
        //清除数据
        //准备数据
        //测试过程
        //主订单
        Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
        dataMap.put("jumpUrl", jumpUrl);//签订之后，跳转返回的页面地址
        //签名
        String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.setAll(dataMap);
        map.add("sign", sign);
        print(map);
        //调用接口
        ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
        //结果验证
        print("云商通电子签约response:" + response.toString());
        JSONObject result = JSONObject.parseObject(response.getBody());
        assertEquals(status, result.getString("status"));
        assertEquals(code, result.getString("code"));
        System.out.println(result.getJSONObject("info").getString("url"));
        //数据验证
        //清除数据
    }
}
