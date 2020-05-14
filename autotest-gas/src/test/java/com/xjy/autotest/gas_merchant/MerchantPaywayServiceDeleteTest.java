package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.ApplyGoodsType;
import com.xyb.gas.merchant.api.enums.PaywayActionType;
import com.xyb.gas.merchant.api.enums.PaywayModelType;
import com.xyb.gas.merchant.api.enums.PaywayTerminalType;
import com.xyb.gas.merchant.api.facade.MerchantPaywayService;
import com.xyb.gas.merchant.api.order.payway.DeleteMerchantPaywayOrder;
import dal.model.gas_merchant.GasMerchantPaywayDO;
import dal.model.gas_silverbolt.GasMerchantPayWayDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author nuomi
 * Created on 2019/11/18.
 */
public class MerchantPaywayServiceDeleteTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantPaywayService merchantPaywayService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantPaywayServiceDeleteTestSuccess.csv")
    @DisplayName("删除商户支付方式--成功用例")
    public void merchantPaywayServiceDeleteTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId, String platPartnerId1,
            String payWayCode, String payWayName,
            String payWayType, String channelCode,
            String barCode, ApplyGoodsType applyGoodsType,
            PaywayTerminalType paywayTerminalType,
            PaywayModelType paywayModelType, PaywayActionType paywayActionType,
            String payWayStatus, boolean print,
            DeleteMerchantPaywayOrder order
    ) {
        // 清除数据
        // 准备数据
        gasMerchantInitDataBase.initGasMerchantPayway(platPartnerId, payWayCode, payWayName, payWayType, channelCode,
                barCode, null, applyGoodsType,
                paywayTerminalType, paywayModelType, paywayActionType, payWayStatus, print);
        //干扰数据
        gasMerchantInitDataBase.initGasMerchantPayway(platPartnerId1, payWayCode, payWayName, payWayType, channelCode,
                barCode, null, applyGoodsType,
                paywayTerminalType, paywayModelType, paywayActionType, payWayStatus, print);
        // 测试过程
        order.setPaywayCode(payWayCode);
        // 调用接口
        SimpleResult result = merchantPaywayService.delete(order);
        sleep(3);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasMerchantPaywayDO> gasMerchantPaywayDO =
                gasMerchantTestBase.findGasMerchantPaywayByPlatPartnerIdAndPaywayCode(platPartnerId, payWayCode);
        List<GasMerchantPayWayDO> silverPaywayDOsilverboltTestBase =
                silverboltTestBase.findGasMerchantPayWayByPartnerIdAndPayWayCode(platPartnerId, payWayCode);
        assertEquals(0, gasMerchantPaywayDO.size());
        assertEquals(0, silverPaywayDOsilverboltTestBase.size());
        List<GasMerchantPaywayDO> gasMerchantPaywayDO1 =
                gasMerchantTestBase.findGasMerchantPaywayByPlatPartnerIdAndPaywayCode(platPartnerId1, payWayCode);
        assertTrue(gasMerchantPaywayDO1.size() > 0);
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantPaywayByPlatPartnerIdAndPaywayCode(platPartnerId, payWayCode);
        gasMerchantTestBase.cleanGasMerchantPaywayByPlatPartnerIdAndPaywayCode(platPartnerId1, payWayCode);
        silverboltTestBase.cleanGasMerchantPayWayByPartnerIdAndPayWayCode(platPartnerId, payWayCode);
        silverboltTestBase.cleanGasMerchantPayWayByPartnerIdAndPayWayCode(platPartnerId1, payWayCode);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantPaywayServiceDeleteTestFailOne.csv")
    @DisplayName("删除商户支付方式--参数非法")
    public void merchantPaywayServiceDeleteTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            DeleteMerchantPaywayOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPaywayCode(null);
        }
        if (testId == 1002) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantPaywayService.delete(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.数据不存在
     */
    @AutoTest(file = "gas_merchant/merchantPaywayServiceDeleteTestFailTwo.csv")
    @DisplayName("删除商户支付方式--失败用例")
    public void merchantPaywayServiceDeleteTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId, String payWayCode, String payWayName,
            String payWayType, String channelCode,
            String barCode, ApplyGoodsType applyGoodsType,
            PaywayTerminalType paywayTerminalType,
            PaywayModelType paywayModelType, PaywayActionType paywayActionType,
            String payWayStatus, boolean print,
            DeleteMerchantPaywayOrder order
    ) {
        // 清除数据
        // 准备数据
        gasMerchantInitDataBase.initGasMerchantPayway(platPartnerId, payWayCode, payWayName, payWayType, channelCode,
                barCode, null, applyGoodsType,
                paywayTerminalType, paywayModelType, paywayActionType, payWayStatus, print);
        // 测试过程
        // 调用接口
        SimpleResult result = merchantPaywayService.delete(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        GasMerchantPaywayDO gasMerchantPaywayDO =
                gasMerchantTestBase.findGasMerchantPaywayByPaywayCode(payWayCode).stream().filter(payWay -> (platPartnerId.equals(payWay.getPartnerId()))).findFirst().get();
        GasMerchantPayWayDO silverPaywayDOsilverboltTestBase =
                silverboltTestBase.findGasMerchantPayWayByPayWayCode(payWayCode).stream().filter(payWay -> (platPartnerId.equals(payWay.getPartnerId()))).findFirst().get();
        assertNotEquals(null, gasMerchantPaywayDO);
        assertNotEquals(null, silverPaywayDOsilverboltTestBase);
        // 清除数据
        gasMerchantInitDataBase.cleanGasMerchantPaywayByPartnerIdAndCode(platPartnerId, payWayCode);
        gasMerchantInitDataBase.cleanGasMerchantPayWayByPartnerIdAndCode(platPartnerId, payWayCode);
    }
}
