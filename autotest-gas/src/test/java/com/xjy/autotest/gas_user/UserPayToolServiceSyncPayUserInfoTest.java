package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.*;
import com.xjy.autotest.testbase.InitData.GasUserInitDataBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.UserPayToolService;
import com.xyb.gas.user.api.enums.GeneralizeSource;
import com.xyb.gas.user.api.order.SyncPayUserInfoOrder;
import dal.model.gas_user.UserDO;
import dal.model.gas_user.UserPayToolInfoDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2020/01/17.
 */
public class UserPayToolServiceSyncPayUserInfoTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserPayToolService userPayToolService;

    @Autowired
    GasUserInitDataBase gasUserInitDataBase;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    Gas_userTestBase userTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;


    /**
     * openId在同一商家下是唯一的
     * 1001
     */
    @AutoTest(file = "gas_user/userPayToolServiceSyncPayUserInfoTestSuccess.csv")
    @DisplayName("同步支付宝、微信绑定信息--成功用例")
    public void userPayToolServiceSyncPayUserInfoTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String openId, String sourceFrom,
            SyncPayUserInfoOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserPayToolInfoByOpenId(openId);
        userTestBase.cleanUserPayToolInfoByOpenId(order.getOpenId());
        // 准备数据
        if (testId >= 1003) {
            gasUserInitDataBase.initUser(partnerId, order.getUserId(), null, "sorami",
                    "15215689745", GeneralizeSource.AUTONOMY_GENERALIZE.code(),
                    null, null, null, null, null, null);
        }
        if (testId == 1004) {
            userTestBase.insertUserPayToolInfo(0L, userId, partnerId, partnerId, openId, sourceFrom, null,
                    null);
        }
        // 测试过程
        // 调用接口
        SimpleResult result = userPayToolService.syncPayUserInfo(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        UserPayToolInfoDO payToolInfo = userTestBase.findUserPayToolInfoByOpenId(order.getOpenId()).get(0);
        assertEquals(order.getPartnerId(), payToolInfo.getPartnerId());
        assertEquals(order.getPlatPartnerId(), payToolInfo.getPlatPartnerId());
        assertEquals(order.getOpenId(), payToolInfo.getOpenId());
        assertEquals(order.getUserId(), payToolInfo.getUserId());
        assertEquals(order.getType().code(), payToolInfo.getType());
        if (testId >= 1003) {
            UserDO user = userTestBase.findUserByUserId(order.getUserId()).get(0);
            assertEquals("true", user.getPayed());
        }
        // 清除数据
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        userTestBase.cleanUserByUserId(userId);
        userTestBase.cleanUserCardInfoByUserId(userId);
        userTestBase.cleanUserPayToolInfoByOpenId(openId);
        userTestBase.cleanUserPayToolInfoByOpenId(order.getOpenId());
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasUserByUserId(userId);
    }

    /**
     *
     */
    @AutoTest(file = "gas_user/userPayToolServiceSyncPayUserInfoTestFailOne.csv")
    @DisplayName("同步支付宝、微信绑定信息--参数非法")
    public void userPayToolServiceSyncPayUserInfoTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            SyncPayUserInfoOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setOpenId(null);
        }
        if (testId == 1002) {
            order.setType(null);
        }
        if (testId == 1003) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        SimpleResult result = userPayToolService.syncPayUserInfo(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * openId在同一商家下是唯一的
     * 1001
     */
    @AutoTest(file = "gas_user/userPayToolServiceSyncPayUserInfoTestFailTwo.csv")
    @DisplayName("同步支付宝、微信绑定信息--失败用例")
    public void userPayToolServiceSyncPayUserInfoTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            SyncPayUserInfoOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        SimpleResult result = userPayToolService.syncPayUserInfo(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
