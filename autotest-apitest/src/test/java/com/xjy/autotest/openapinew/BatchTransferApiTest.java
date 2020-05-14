package com.xjy.autotest.openapinew;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.testbase.openapi.OpenapiTestBasis;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import com.xjy.autotest.utils.DigestUtil;
import com.xjy.autotest.annotation.AutoTest;
import org.junit.jupiter.api.DisplayName;

/**
 * @author ychaoyang
 * Created on 2018/08/29.
 */
public class BatchTransferApiTest extends OpenapiTestBasis {

    @AutoTest(file = "openapinew/batchTransferApiTestSuccess.csv")
    @DisplayName("批量转账--成功用例")
    public void batchTransferApiTestSuccess(
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
            String extensionContext,
            String externalMetaData,
            String memo,
            String payeeUserId,
            String payeeUserTag,
            String payerUserId,
            String payerUserTag,
            String amount,
            String payeeUserId1,
            String payeeUserTag1,
            String payerUserId1,
            String payerUserTag1,
            String amount1
    ) {
        //初始化数据
        service = "batchTransfer";
        partnerId = pId;
        securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
        //清除数据
        //准备数据
        //测试过程
        //infos
        payerUserId = "S0301808281000000074";
        payerUserTag = "S0301808281000000075";
        payeeUserId = "S0301808291500000077";
        payeeUserTag = "S0301808291500000078";
        amount = "0.01";
        amount1 = "0.01";

        Map<Object, Object> infosMap = new HashMap<Object, Object>();
        infosMap.put("payeeUserId", payeeUserId);//payeeUserId
        infosMap.put("payeeUserTag", payeeUserTag);//payeeUserTag
        infosMap.put("payerUserId", payerUserId);//payerUserId
        infosMap.put("payerUserTag", payerUserTag);//payerUserTag
        infosMap.put("amount", amount);//amount

        Map<Object, Object> infosMap1 = new HashMap<Object, Object>();
        infosMap1.put("payeeUserId", payeeUserId1);//payeeUserId
        infosMap1.put("payeeUserTag", payeeUserTag1);//payeeUserTag
        infosMap1.put("payerUserId", payerUserId1);//payerUserId
        infosMap1.put("payerUserTag", payerUserTag1);//payerUserTag
        infosMap1.put("amount", amount1);//amount

        List<Map<Object, Object>> infos = new ArrayList<Map<Object, Object>>();
        infos.add(infosMap);
        infos.add(infosMap);
        //infos.add(infosMap1);
        //infos.add(infosMap1);
        //infos.add(infosMap1);
        //infos.add(infosMap1);
        //主订单
        Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
        //dataMap.put("extensionContext", extensionContext);//extensionContext
        //dataMap.put("externalMetaData", externalMetaData);//外部数据域（原样返回、仅存储）
        dataMap.put("infos", JSON.toJSONString(infos));//infos
        dataMap.put("memo", memo);//描述
        //签名
        String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.setAll(dataMap);
        map.add("sign", sign);
        print(map);
        //调用接口
        ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
        //结果验证
        print("批量转账response:" + response.toString());
        JSONObject result = JSONObject.parseObject(response.getBody());
        assertEquals(status, result.getString("status"));
        assertEquals(code, result.getString("code"));
        //数据验证
        //清除数据
    }
}
