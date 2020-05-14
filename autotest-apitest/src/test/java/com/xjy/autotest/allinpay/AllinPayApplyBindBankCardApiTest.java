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
 * Created on 2019/07/10.
 */
public class AllinPayApplyBindBankCardApiTest extends OpenapiTestBasis {

    @AutoTest(file = "allinpay/allinPayApplyBindBankCardApiTestSuccess.csv")
    @DisplayName("通联请求绑定银行卡--成功用例")
    public void allinPayApplyBindBankCardApiTestSuccess(
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
            String bankCardIDcard,
            String bankCardName,
            String bankCardNo,
            String bankCardPhone
    ) {
        //初始化数据
        service = "allinPayApplyBindBankCard";
        partnerId = pId;
        securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();

        bankCardIDcard = "500235198510107998";
        bankCardName = "于朝洋";
        bankCardNo = "6226660903688287";
        bankCardPhone = "18580627269";
        //清除数据
        //准备数据
        //测试过程
        //主订单
        Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
        dataMap.put("bankCardIDcard", bankCardIDcard);//开户人身份证号
        dataMap.put("bankCardName", bankCardName);//开户人姓名
        dataMap.put("bankCardNo", bankCardNo);//银行卡号
        dataMap.put("bankCardPhone", bankCardPhone);//银行预留手机号
        //签名
        String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.setAll(dataMap);
        map.add("sign", sign);
        print(map);
        //调用接口
        ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
        //结果验证
        print("通联请求绑定银行卡response:" + response.toString());
        JSONObject result = JSONObject.parseObject(response.getBody());
        assertEquals(status, result.getString("status"));
        assertEquals(code, result.getString("code"));
        //数据验证
        //清除数据
    }
}
