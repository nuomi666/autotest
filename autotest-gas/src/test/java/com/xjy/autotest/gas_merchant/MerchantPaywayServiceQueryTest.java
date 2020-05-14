package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.ApplyGoodsType;
import com.xyb.gas.merchant.api.enums.PaywayActionType;
import com.xyb.gas.merchant.api.enums.PaywayModelType;
import com.xyb.gas.merchant.api.enums.PaywayTerminalType;
import com.xyb.gas.merchant.api.facade.MerchantPaywayService;
import com.xyb.gas.merchant.api.info.payway.MerchantPaywayAttributeInfo;
import com.xyb.gas.merchant.api.info.payway.MerchantPaywayInfo;
import com.xyb.gas.merchant.api.info.payway.PaywaySceneInfo;
import com.xyb.gas.merchant.api.order.payway.QueryMerchantPaywayOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2019/11/18.
 */
public class MerchantPaywayServiceQueryTest extends SpringBootTestBase {

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
    @AutoTest(file = "gas_merchant/merchantPaywayServiceQueryTestSuccess.csv")
    @DisplayName("查询支付方式--成功用例")
    public void merchantPaywayServiceQueryTestSuccess(
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
            QueryMerchantPaywayOrder order
    ) {
        // 清除数据
        // 准备数据
        gasMerchantInitDataBase.initGasMerchantPayway(platPartnerId, payWayCode, payWayName, payWayType, channelCode,
                barCode, null, applyGoodsType,
                paywayTerminalType, paywayModelType, paywayActionType, payWayStatus, print);
        // 测试过程
        // 调用接口
        BizResult<MerchantPaywayInfo> result = merchantPaywayService.query(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        assertEquals(platPartnerId, result.getInfo().getPartnerId());
        assertEquals(payWayType, result.getInfo().getPaywayType());
        assertEquals(payWayCode, result.getInfo().getPaywayCode());
        assertEquals(payWayName, result.getInfo().getPaywayName());
        assertEquals(null, result.getInfo().getPaywayIcon());
        assertEquals(null, result.getInfo().getPaywaySmallIcon());
        PaywaySceneInfo paywaySceneInfo = result.getInfo().getPaywaySceneInfo();
        paywaySceneInfo.getActionTerminalMap().get(paywayActionType).contains(paywayTerminalType);
        paywaySceneInfo.getBarCodeList().contains(barCode);
        paywaySceneInfo.getModelList().contains(paywayModelType);
        assertEquals(null, paywaySceneInfo.getApiPartnerId());
        assertEquals(applyGoodsType, paywaySceneInfo.getApplyGoodsType());
        assertEquals(0, paywaySceneInfo.getStationList().size());
        MerchantPaywayAttributeInfo paywayAttributeInfo = result.getInfo().getPaywayAttributeInfo();
        assertEquals(print, paywayAttributeInfo.isPrint());
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantPaywayByPlatPartnerIdAndPaywayCode(platPartnerId, payWayCode);
        silverboltTestBase.cleanGasMerchantPayWayByPartnerIdAndPayWayCode(platPartnerId, payWayCode);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantPaywayServiceQueryTestFailOne.csv")
    @DisplayName("查询支付方式--参数非法")
    public void merchantPaywayServiceQueryTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryMerchantPaywayOrder order
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
        BizResult<MerchantPaywayInfo> result = merchantPaywayService.query(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }

    /**
     * 1001.未查询到数据
     */
    @AutoTest(file = "gas_merchant/merchantPaywayServiceQueryTestFailTwo.csv")
    @DisplayName("查询支付方式--失败用例")
    public void merchantPaywayServiceQueryTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryMerchantPaywayOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantPaywayByPaywayCode(order.getPaywayCode());
        // 准备数据
        // 测试过程
        // 调用接口
        BizResult<MerchantPaywayInfo> result = merchantPaywayService.query(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
        gasMerchantTestBase.cleanGasMerchantPaywayByPlatPartnerIdAndPaywayCode(order.getPlatPartnerId(),
                order.getPaywayCode());
        silverboltTestBase.cleanGasMerchantPayWayByPartnerIdAndPayWayCode(order.getPlatPartnerId(),
                order.getPaywayCode());
    }
}
