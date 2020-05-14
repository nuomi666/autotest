package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.MerchantService;
import com.xyb.gas.merchant.api.order.AuthorizeMerchantOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2019/08/08.
 */
public class MerchantServiceAuthorizeTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantService merchantService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantServiceAuthorizeTestSuccess.csv")
    @DisplayName("商户授权--成功用例")
    public void merchantServiceAuthorizeTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String sourcekey,
            AuthorizeMerchantOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasMerchantSourceDataBySourceTypeAndSourceKey(order.getSourceType().code(),
                sourcekey);
        // 准备数据
        // 测试过程
        // 调用接口
        SimpleResult result = merchantService.authorize(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
