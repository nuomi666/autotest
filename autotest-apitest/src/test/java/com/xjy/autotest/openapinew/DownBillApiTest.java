package com.xjy.autotest.openapinew;

import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.openapi.OpenapiTestBasis;
import com.xjy.autotest.utils.DigestUtil;
import org.junit.jupiter.api.DisplayName;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ychaoyang
 * Created on 2018/08/29.
 */
public class DownBillApiTest extends OpenapiTestBasis {

    @AutoTest(file = "openapinew/downBillApiTestSuccess.csv")
    @DisplayName("下载对账单--成功用例")
    public void downBillApiTestSuccess(
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
            String billDate,
            String channelId,
            String partnerId1
    ) throws Exception {
        //初始化数据
        service = "downBill";
        partnerId = pId;
        securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
        billDate = "20181204";
        //清除数据
        //准备数据
        //测试过程

        //主订单
        Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
        dataMap.put("billDate", billDate);//对账日期格式yyyyMMdd
        //dataMap.put("channelId", channelId);//渠道ID
        //签名
        String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.setAll(dataMap);
        map.add("sign", sign);
        print(map);
        //调用接口
        ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
        //结果验证
        print("下载对账单response:" + response.toString());
        JSONObject result = JSONObject.parseObject(response.getBody());
        assertEquals(status, result.getString("status"));
        assertEquals(code, result.getString("code"));
        //解码
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] byt = decoder.decode(result.getString("buffer"));
        System.out.println(new String(byt, "UTF-8"));
        File file = new File("D:\\下载\\test.txt");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(byt);
        System.out.println("写入成功");
        fos.close();
        //数据验证
        //清除数据
    }
}
