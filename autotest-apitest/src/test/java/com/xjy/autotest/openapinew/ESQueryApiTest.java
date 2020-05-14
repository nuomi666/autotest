package com.xjy.autotest.openapinew;

import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.PayTestBase;
import com.xjy.autotest.testbase.openapi.OpenapiTestBasis;
import dal.model.pay.PaymentInstructionDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

/**
 * @author ychaoyang
 * Created on 2018/08/27.
 */
public class ESQueryApiTest extends OpenapiTestBasis {

    @Autowired
    PayTestBase payTestBase;

    @AutoTest(file = "openapinew/orderQueryApiTestSuccess.csv")
    @DisplayName("ES查询--成功用例")
    public void orderQueryApiTestSuccess(
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
            String bizNo
    ) {
        //初始化数据
        service = "orderQuery";
        partnerId = pId;
        securityCheckCode = secretKey;
        String url = "http://192.168.2.127:9200/_sql";

        String sql = "select  * from payment_instruction where biz_no = '1j051n9l24s051hge8er'";
        //清除数据
        //准备数据
        //测试过程
        url = url + "?sql=" + sql;
        bizNo = "1j0zmr2e2ss051hge8er";
        print(url);
        //调用接口
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        //结果验证
        print("ES查询response:" + response.toString());
        JSONObject result = JSONObject.parseObject(response.getBody());

        JSONObject jsonObject = result.getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source");
        PaymentInstructionDO paymentInstructionDO = payTestBase.findPaymentInstructionByBizNo(bizNo).get(0);
        paymentInstructionDO.setRawUpdateTime(null);
        paymentInstructionDO.setState(paymentInstructionDO.getState().toUpperCase());
        assertEquals(paymentInstructionDO, jsonToObject(jsonObject, PaymentInstructionDO.class));

        //数据验证
        //清除数据
    }


}
