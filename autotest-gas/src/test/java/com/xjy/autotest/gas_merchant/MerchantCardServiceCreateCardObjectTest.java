package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.MerchantCardService;
import com.xyb.gas.merchant.api.order.CreateCardObjectOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2019/10/16.
 */
public class MerchantCardServiceCreateCardObjectTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantCardService merchantCardService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantCardServiceCreateCardObjectTestSuccess.csv")
    @DisplayName("添加商户卡主体--成功用例")
    public void merchantCardServiceCreateCardObjectTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CreateCardObjectOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        SimpleResult result = merchantCardService.createCardObject(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
