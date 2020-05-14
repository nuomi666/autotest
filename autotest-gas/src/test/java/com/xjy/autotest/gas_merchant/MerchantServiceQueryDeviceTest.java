package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.DeviceType;
import com.xyb.gas.merchant.api.enums.UserLoginStatus;
import com.xyb.gas.merchant.api.facade.MerchantService;
import com.xyb.gas.merchant.api.info.DeviceInfo;
import com.xyb.gas.merchant.api.order.QueryMerchantDeviceOrder;
import com.xyb.gas.merchant.api.result.BizCollectionResult;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2019/11/25.
 */
public class MerchantServiceQueryDeviceTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantService merchantService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantServiceQueryDeviceTestSuccess.csv")
    @DisplayName("查询商户终端信息--成功用例")
    public void merchantServiceQueryDeviceTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String userId, String deviceCode,
            String deviceCode1,
            QueryMerchantDeviceOrder order
    ) {
        // 清除数据
        // 准备数据
        gasMerchantInitDataBase.initGasMerchant(order.getPlatPartnerId(), "测试商家007", null, "测试商家",
                "1jc7w1m29ks031hge7p8",
                "001iys5hlniks541g00", "1jhb00i98ws031hge7p0", "Merchant", null, "ABLE");
        gasMerchantInitDataBase.initGasMerchantDevice(order.getPlatPartnerId(), null, deviceCode,
                UserLoginStatus.logout.code());
        if (testId == 1002) {
            gasMerchantInitDataBase.initGasMerchantDevice(order.getPlatPartnerId(), userId, deviceCode1,
                    UserLoginStatus.login.code());
        }
        // 测试过程
        // 调用接口
        BizCollectionResult<DeviceInfo> result = merchantService.queryDevice(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<String> deviceCodes = new ArrayList<>();
        for (DeviceInfo deviceInfo : result.getInfos()) {
            deviceCodes.add(deviceInfo.getDeviceCode());
            assertEquals(order.getPlatPartnerId(), deviceInfo.getPlatPartnerId());
            assertEquals(order.getDeviceType(), deviceInfo.getDeviceType());
        }
        if (testId == 1001) {
            deviceCodes.contains(deviceCode);
        }
        if (testId == 1002) {
            deviceCodes.contains(deviceCode);
            deviceCodes.contains(deviceCode1);
        }
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(order.getPlatPartnerId());
        xybUserTestBase.cleanUserByUserId(order.getPlatPartnerId());
        xybUserTestBase.cleanAccountByUserId(order.getPlatPartnerId());
        xybUserTestBase.cleanAccountByAccountNo("1jc7w1m29ks031hge7p8");
        xybUserTestBase.cleanAccountByAccountNo("001iys5hlniks541g00");
        merchantTestBase.cleanGasMerchantByPlatPartnerId(order.getPlatPartnerId());
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(order.getPlatPartnerId());
        merchantTestBase.cleanGasMerchantDeviceByDeviceCode(deviceCode);
        merchantTestBase.cleanGasMerchantDeviceByDeviceCode(deviceCode1);
        silverboltTestBase.cleanGasMerchantByPartnerId(order.getPlatPartnerId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantServiceQueryDeviceTestFailOne.csv")
    @DisplayName("查询商户终端信息--参数非法")
    public void merchantServiceQueryDeviceTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryMerchantDeviceOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPlatPartnerId(null);
            order.setPartnerId(null);
        }
        if (testId == 1002) {
            order.setDeviceType(null);
        }
        if (testId == 1003) {
            order.setDeviceType(DeviceType.BOSS);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        BizCollectionResult<DeviceInfo> result = merchantService.queryDevice(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据

    }
}
