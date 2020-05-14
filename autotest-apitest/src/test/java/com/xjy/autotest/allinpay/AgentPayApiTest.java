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
 * Created on 2019/07/30.
 */
public class AgentPayApiTest extends OpenapiTestBasis {

    @AutoTest(file = "allinpay/agentPayApiTestSuccess.csv")
    @DisplayName("订单代付支付--成功用例")
    public void agentPayApiTestSuccess(
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
            String agentPayerList,
            String externalMetaData,
            String memo,
            String payAmount,
            String payeeUserId
    ) {
        //初始化数据
        service = "agentPay";
        partnerId = pId;
        securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
        //merchantOrderNo = "merchantOrderNo1564562427217";
        //清除数据
        //准备数据
        //测试过程
        payAmount = "0.01";
        payeeUserId = "S0301907261500091743";
        JSONObject payerList = new JSONObject();
        String bizNo = "1jh20z98j0s051hge8er";
        payerList.put(bizNo, "0.01");
        //主订单
        Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
        dataMap.put("agentPayerList", payerList.toString());//代付列表（key=代付平台订单号,value=付款金额）
        dataMap.put("externalMetaData", externalMetaData);//外部数据域（原样返回、仅存储）
        dataMap.put("memo", memo);//描述
        dataMap.put("payAmount", payAmount);//支付金额(支付金额=收款列表金额总和)
        dataMap.put("payeeUserId", payeeUserId);//收款人userId
        //签名
        String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.setAll(dataMap);
        map.add("sign", sign);
        print(map);
        //调用接口
        ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
        //结果验证
        print("订单代付支付response:" + response.toString());
        JSONObject result = JSONObject.parseObject(response.getBody());
        assertEquals(status, result.getString("status"));
        assertEquals(code, result.getString("code"));
        //数据验证
        //清除数据
    }
}
