package com.xjy.autotest.allinpay;

import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.PayTestBase;
import com.xjy.autotest.testbase.openapi.OpenapiTestBasis;
import com.xjy.autotest.utils.DigestUtil;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ychaoyang
 * Created on 2019/09/17.
 */
public class RetryBatchApiTest extends OpenapiTestBasis {


    @Autowired
    PayTestBase payTestBase;

    @AutoTest(file = "allinpay/retryBatchApiTestSuccess.csv")
    @DisplayName("批量重试清分--成功用例")
    public void retryBatchApiTestSuccess(
            int testId,
            String status,
            String code,
            // 基本参数
            String service,
            String version,
            String signType,
            String merchantOrderNo,
            String context,
            String returnUrl,
            String notifyUrl,
            // 业务参数
            String securityCheckCode,
            String partnerId,
            String channelId,
            String startDate,
            String endDate
    ) {
        //List<UserDO> list = payTestBase.findUser();
        //for (UserDO userDO : list) {
        //    if ("F".equals(userDO.getStatus())) {
        //        continue;
        //    }
            //初始化数据
            service = "retryBatch";
            //partnerId = userDO.getUserId();
            securityCheckCode = "111111";
            merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();

            //startDate = DateUtil.shortDate(userDO.getRawAddTime());
            //清除数据
            //准备数据
            //测试过程
            //主订单
            Map<String, String> dataMap = new HashMap<String, String>();
            buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
            dataMap.put("channelId", "cqzsyh");//channelId
            dataMap.put("startDate", "20190201");//开始账期
            dataMap.put("endDate", "20190401");//结束账期
            dataMap.put("cycle", "DAY");//结束账期
            //签名
            String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            map.setAll(dataMap);
            map.add("sign", sign);
            print(map);
            //调用接口
            ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
            //结果验证
            print("批量重试清分response:" + response.toString());
            JSONObject result = JSONObject.parseObject(response.getBody());
            assertEquals(status, result.getString("status"));
            assertEquals(code, result.getString("code"));
            //数据验证
            //清除数据
            //userDO.setStatus("F");
            //payTestBase.updateUserByUserId(partnerId, userDO);
            //print("++++++++++执行成功，休息3秒++++++++");
            //print(userDO);
            //sleep(3);
        //}
    }
}
