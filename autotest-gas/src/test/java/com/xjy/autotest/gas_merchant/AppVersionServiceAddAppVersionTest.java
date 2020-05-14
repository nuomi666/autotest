package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.AppVersionService;
import com.xyb.gas.merchant.api.info.version.AppVersionInfo;
import com.xyb.gas.merchant.api.order.version.AddAppVersionOrder;
import dal.model.gas_merchant.GasAppVersionDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author nuomi
 * Created on 2020/05/11.
 */
public class AppVersionServiceAddAppVersionTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    AppVersionService appVersionService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/appVersionServiceAddAppVersionTestSuccess.csv")
    @DisplayName("新增应用版本--成功用例")
    public void appVersionServiceAddAppVersionTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AddAppVersionOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasAppVersionByAppCodeAndStoreCode(order.getAppCode(), order.getStoreCode());
        // 准备数据
        // 测试过程
        // 调用接口
        BizResult<AppVersionInfo> result = appVersionService.addAppVersion(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        AppVersionInfo info = result.getInfo();
        assertEquals(order.getAppCode(), info.getAppCode());
        assertEquals(order.getAppName(), info.getAppName());
        assertEquals(order.getVersionCode(), info.getVersionCode());
        assertEquals(order.getVersionName(), info.getVersionName());
        assertEquals(order.getStoreCode(), info.getStoreCode());
        assertEquals(order.getStoreName(), info.getStoreName());
        assertEquals(order.getUpgradeLevel(), info.getUpgradeLevel());
        assertEquals(order.getUpgradeContent(), info.getUpgradeContent());
        // 清除数据
        gasMerchantTestBase.cleanGasAppVersionByAppCodeAndStoreCode(order.getAppCode(), order.getStoreCode());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/appVersionServiceAddAppVersionTestFailOne.csv")
    @DisplayName("新增应用版本--参数非法")
    public void appVersionServiceAddAppVersionTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AddAppVersionOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setAppCode(null);
        }
        if (testId == 1002) {
            order.setVersionCode(null);
        }
        if (testId == 1003) {
            order.setStoreCode(null);
        }
        if (testId == 1004) {
            order.setUpgradeLevel(null);
        }
        if (testId == 1005) {
            order.setGid(null);
        }
        if (testId == 1006) {
            order = null;
        }
        // 调用接口
        BizResult<AppVersionInfo> result = appVersionService.addAppVersion(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/appVersionServiceAddAppVersionTestFailTwo.csv")
    @DisplayName("新增应用版本--失败用例")
    public void appVersionServiceAddAppVersionTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AddAppVersionOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasAppVersionByAppCodeAndStoreCode(order.getAppCode(), order.getStoreCode());
        // 准备数据
        if (testId == 1002) {
            gasMerchantTestBase.insertGasAppVersion(0L, order.getAppCode(), order.getAppName(),
                    order.getVersionCode() + 1,
                    order.getVersionName(), order.getStoreCode(), order.getStoreName(), order.getUpgradeLevel().code(),
                    order.getUpgradeContent(), null, null);
        } else {
            gasMerchantTestBase.insertGasAppVersion(0L, order.getAppCode(), order.getAppName(), order.getVersionCode(),
                    order.getVersionName(), order.getStoreCode(), order.getStoreName(), order.getUpgradeLevel().code(),
                    order.getUpgradeContent(), null, null);
        }
        // 测试过程
        // 调用接口
        BizResult<AppVersionInfo> result = appVersionService.addAppVersion(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasAppVersionDO> infos = gasMerchantTestBase.findGasAppVersionByAppCodeAndStoreCode(order.getAppCode(),
                order.getStoreCode());
        assertEquals(1, infos.size());
        // 清除数据
        gasMerchantTestBase.cleanGasAppVersionByAppCodeAndStoreCode(order.getAppCode(), order.getStoreCode());
    }
}
