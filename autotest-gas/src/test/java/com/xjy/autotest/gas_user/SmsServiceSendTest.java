package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.SmsService;
import com.xyb.gas.user.api.order.SendValidateCodeOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;


/**
 * @author nuomi@xyb.com
 * Created on 2018/10/27.
 */
public class SmsServiceSendTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    SmsService smsService;

    @Resource(name = "stringRedisTemplate")
    private StringRedisTemplate redisTemplate;

    String SMS_CODE_PREFIX = "validate_";

    /**
     * 1001.发送验证码
     * 1002.第一次验证码还未过期时，再发送
     */
    @AutoTest(file = "gas_user/smsServiceSendTestSuccess.csv")
    @DisplayName("发送验证码给用户--成功用例")
    public void smsServiceSendTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            SendValidateCodeOrder order
    ) {
        // 清除数据
        // 准备数据
        String key = "gas-user:" + order.getPlatPartnerId() + order.getMobile();
        if (testId == 1002) {//上次的验证码
            redisTemplate.opsForValue().set(key, "2587");
        }
        // 测试过程
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = smsService.send(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//		assertEquals(code, result.getCode());
        // 数据验证
        String valiCode = redisTemplate.opsForValue().get(key);//验证码为随机生成的
        if (testId == 1002) {
            assertNotEquals("2587", valiCode);
        }
        String time = redisTemplate.opsForValue().get(SMS_CODE_PREFIX + key);//失效次数
        assertEquals(3, Integer.valueOf(time).intValue());
        // 清除数据
        redisTemplate.delete(key);
        redisTemplate.delete(SMS_CODE_PREFIX + key);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/smsServiceSendTestFailOne.csv")
    @DisplayName("发送验证码给用户--成功用例")
    public void smsServiceSendTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            SendValidateCodeOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setType(null);
        }
        if (testId == 1003) {
            order.setMerchantName(null);
        }
        if (testId == 1004) {
            order.setMobile(null);
        }
        if (testId == 1005) {
            order.setGid(null);
        }
        if (testId == 1006) {
            order = null;
        }
        // 调用接口
        SimpleResult result = smsService.send(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
