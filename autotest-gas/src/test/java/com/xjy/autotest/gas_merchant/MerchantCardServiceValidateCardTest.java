package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.MerchantCardService;
import com.xyb.gas.merchant.api.order.ValidateMerchantCardOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2019/10/17.
 */
public class MerchantCardServiceValidateCardTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantCardService merchantCardService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001.商家模式下的会员开卡验卡
     * 1002.油站模式下的会员开卡验卡
     */
    @AutoTest(file = "gas_merchant/merchantCardServiceValidateCardTestSuccess.csv")
    @DisplayName("会员实体卡开卡验卡--成功用例")
    public void merchantCardServiceValidateCardTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ValidateMerchantCardOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantCardByCardNo(order.getCardNo());
        // 准备数据
        gasMerchantInitDataBase.initGasMerchantCard(order.getPlatPartnerId(), 1L, "Admin", order.getCardNo(), null,
                null,
                null);
        // 测试过程
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = merchantCardService.validateCard(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantCardByPlatPartnerId(order.getPlatPartnerId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantCardServiceValidateCardTestFailOne.csv")
    @DisplayName("会员实体卡开卡验卡--参数非法")
    public void merchantCardServiceValidateCardTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ValidateMerchantCardOrder order
    ) {
        // 清除数据

        // 准备数据

        // 测试过程
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setGid(null);
        }
        if (testId == 1002) {
            order.setCardNo(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantCardService.validateCard(order);
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
    @AutoTest(file = "gas_merchant/merchantCardServiceValidateCardTestFailTwo.csv")
    @DisplayName("会员实体卡开卡验卡--失败用例")
    public void merchantCardServiceValidateCardTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ValidateMerchantCardOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantCardByCardNo(order.getCardNo());
        // 准备数据
        // 测试过程
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = merchantCardService.validateCard(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
