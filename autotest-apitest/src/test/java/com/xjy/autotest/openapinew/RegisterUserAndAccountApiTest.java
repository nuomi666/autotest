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
 * Created on 2018/08/28.
 */
public class RegisterUserAndAccountApiTest extends OpenapiTestBasis {

    @AutoTest(file = "openapinew/registerUserAndAccountApiTestSuccess.csv")
    @DisplayName("注册用户并创建账户--成功用例")
    public void registerUserAndAccountApiTestSuccess(
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
            String accountType,
            String address,
            String certifyStatus,
            String certNo,
            String certType,
            String city,
            String country,
            String district,
            String memo,
            String merchantMode,
            String merchantUserId,
            String mobile,
            String parentUserId,
            String partnerId1,
            String payPassword,
            String phone,
            String province,
            String realName,
            String registerFrom,
            String registerIp,
            String tag,
            String userName,
            String userStatus,
            String userType,
            String zipCode
    ) {
        //初始化数据
        service = "registerUserAndAccount";
        partnerId = pId;
        securityCheckCode = secretKey;
        merchantOrderNo = "merchantOrderNo" + System.currentTimeMillis();
        merchantUserId = "merchantUserId" + System.currentTimeMillis();

        realName = "安静了";
        userName = "hhcs007";
        userType = "PARTNER";
        userType = "PERSONAL";
        merchantMode = "NORMAL";
        //清除数据
        //准备数据
        //测试过程
        //主订单
        Map<String, String> dataMap = new HashMap<String, String>();
        buildMap(service, version, partnerId, signType, merchantOrderNo, context, notifyUrl, returnUrl, dataMap);
        parentUserId = partnerId;
        //dataMap.put("accountType", accountType);//账户类型，默认标准账户
        //dataMap.put("address", address);//地址
        //dataMap.put("certifyStatus", certifyStatus);//认证状态
        //dataMap.put("certNo", certNo);//证件号
        //dataMap.put("certType", certType);//证件类型
        //dataMap.put("city", city);//城市
        //dataMap.put("country", country);//国家
        //dataMap.put("district", district);//城市
        //dataMap.put("memo", memo);//备注
        dataMap.put("merchantMode", merchantMode);//商户模式
        dataMap.put("merchantUserId", merchantUserId);//外部用户ID
        //dataMap.put("mobile", mobile);//手机
        dataMap.put("parentUserId", parentUserId);//父级用户ID，平台商在boss后台创建，选择初始的平台商userId，签约商的父级id可以为签约商/平台商的userid，个人用户父级id可以为任意角色的userid
        dataMap.put("payPassword", payPassword);//支付密码
        //dataMap.put("phone", phone);//固定电话
        //dataMap.put("province", province);//省份
        dataMap.put("realName", realName);//用户真实姓名
        //dataMap.put("registerFrom", registerFrom);//注册来源
        //dataMap.put("registerIp", registerIp);//注册IP
        //dataMap.put("tag", tag);//账户标签
        dataMap.put("userName", userName);//用户名
        dataMap.put("userStatus", userStatus);//用户状态,默认正常
        dataMap.put("userType", userType);//用户类型
        //dataMap.put("zipCode", zipCode);//邮编
        //签名
        String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.setAll(dataMap);
        map.add("sign", sign);
        print(map);
        //调用接口
        ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
        //结果验证
        print("注册用户并创建账户response:" + response.toString());
        JSONObject result = JSONObject.parseObject(response.getBody());
        assertEquals(status, result.getString("status"));
        assertEquals(code, result.getString("code"));
        //数据验证
        //清除数据
    }
}
