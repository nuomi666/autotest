package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.AppVersionService;
import com.xyb.gas.merchant.api.order.version.DeleteAppVersionOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2020/05/11.
 */
public class AppVersionServiceDeleteAppVersionTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    AppVersionService appVersionService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/appVersionServiceDeleteAppVersionTestSuccess.csv")
    @DisplayName("删除应用版本--成功用例")
    public void appVersionServiceDeleteAppVersionTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            DeleteAppVersionOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        BizResult result = appVersionService.deleteAppVersion(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
