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
import com.xyb.gas.merchant.api.info.payway.VerifyMerchantPaywayInfo;
import com.xyb.gas.merchant.api.order.payway.VerifyPaywayOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2019/11/20.
 */
public class MerchantPaywayServiceVerifyPaywayTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantPaywayService merchantPaywayService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 当交易方式为付款时，支付方式编码必传的，因为银商的条码和微信支付宝的有相同的，无法识别。当为充值时，
     * 支付方式编码可为空，充值只有支付宝和微信两种，可以通过条码识别出支付方式
     * <p>
     * 某些特定的场景：当支付动作为充值时，商品配置肯定是为空的。当验证方式为条码时且支付方式编码为空时，以条码
     * 的验证方式为准，当验证方式为条码时且支付方式编码不为空时，则以支付方式编码和条码的传入为准
     * 当验证方式为支付方式时，以支付方式编码的传入为准。同步订单时则只看api商户id。
     * <p>
     * 1001.条码充值
     * 1002.支付方式充值，支付模式为记账
     * 1003.支付方式充退，支付模式为公众号/服务窗
     * 1004.条码付款，无支付方式编码
     * 1005.条码付款，带有支付方式编码
     * 1006.支付方式付款，支付模式为条码
     * 1007.支付方式退款，支付模式为余额
     * 1008.支付方式退款，支付模式为银行卡刷卡
     * 1009.同步付款，商品配置为油品
     * 1010.同步退款
     */
    @AutoTest(file = "gas_merchant/merchantPaywayServiceVerifyPaywayTestSuccess.csv", project = "gas_silverbolt")
    @DisplayName("验证支付方式--成功用例")
    public void merchantPaywayServiceVerifyPaywayTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId, String platPartnerId1,
            String payWayCode, String payWayCode1,
            String payWayName, String payWayName1,
            String payWayType, String payWayType1,
            String barCode, String barCode1, String apiPartnerId, String apiPartnerId1,
            ApplyGoodsType applyGoodsType, ApplyGoodsType applyGoodsType1,
            PaywayTerminalType paywayTerminalType, PaywayTerminalType paywayTerminalType1,
            PaywayModelType paywayModelType, PaywayModelType paywayModelType1,
            PaywayActionType paywayActionType, PaywayActionType paywayActionType1,
            String payWayStatus, boolean print,
            VerifyPaywayOrder order
    ) {
        // 清除数据
        // 准备数据
        gasMerchantInitDataBase.initGasMerchantPayway(platPartnerId, payWayCode, payWayName, payWayType, payWayCode,
                barCode, apiPartnerId, applyGoodsType,
                paywayTerminalType, paywayModelType, paywayActionType, payWayStatus, print);
        //干扰数据
        gasMerchantInitDataBase.initGasMerchantPayway(platPartnerId1, payWayCode1, payWayName1, payWayType1,
                payWayCode1, barCode1, apiPartnerId1, applyGoodsType1,
                paywayTerminalType1, paywayModelType1, paywayActionType1, payWayStatus, print);
        // 测试过程
        // 调用接口
        BizResult<VerifyMerchantPaywayInfo> result = merchantPaywayService.verifyPayway(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        VerifyMerchantPaywayInfo paywayInfos = result.getInfo();
        assertEquals(platPartnerId, paywayInfos.getPartnerId());
        assertEquals(payWayCode, paywayInfos.getPaywayCode());
        assertEquals(payWayName, paywayInfos.getPaywayName());
        assertEquals(payWayType, paywayInfos.getPaywayType());
        assertEquals(payWayCode, paywayInfos.getChannelCode());
        assertEquals(null, paywayInfos.getChannelFunction());
        assertEquals(order.getBarCode(), paywayInfos.getBarCode());
        assertEquals(apiPartnerId, paywayInfos.getApiPartnerId());
        assertEquals(order.getModelType(), paywayInfos.getModelType());
        assertEquals(paywayActionType, paywayInfos.getActionType());
        assertEquals(order.getApplyGoodsType(), paywayInfos.getApplyGoodsType());
        assertEquals(print, paywayInfos.getAttributeInfo().isPrint());
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantPaywayByPlatPartnerIdAndPaywayCode(platPartnerId1, payWayCode1);
        gasMerchantTestBase.cleanGasMerchantPaywayByPlatPartnerIdAndPaywayCode(platPartnerId, payWayCode);
        silverboltTestBase.cleanGasMerchantPayWayByPartnerIdAndPayWayCode(platPartnerId1, payWayCode1);
        silverboltTestBase.cleanGasMerchantPayWayByPartnerIdAndPayWayCode(platPartnerId, payWayCode);
    }

    /**
     * 1001.验证类型为空
     * 1002.支付模式类型为空
     * 1003.支付动作类型为空
     * 1004.商户号为空
     * 1005.同步类型的api为空
     * 1006.付款类型的，商品配置为空
     * 1007.付款类型的，支付方式编码为空
     * 1008.条码支付的，条码为空
     * 1009.gid为空
     * 1010.order为空
     */
    @AutoTest(file = "gas_merchant/merchantPaywayServiceVerifyPaywayTestFailOne.csv")
    @DisplayName("验证支付方式--参数非法")
    public void merchantPaywayServiceVerifyPaywayTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            VerifyPaywayOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setVerifyPaywayType(null);
        }
        if (testId == 1002) {
            order.setModelType(null);
        }
        if (testId == 1003) {
            order.setActionType(null);
        }
        if (testId == 1004) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1005) {
            order.setApiPartnerId(null);
        }
        if (testId == 1006) {
            order.setApplyGoodsType(null);
        }
        if (testId == 1007) {
            order.setPaywayCode(null);
        }
        if (testId == 1008) {
            order.setBarCode(null);
        }
        if (testId == 1009) {
            order.setGid(null);
        }
        if (testId == 1010) {
            order = null;
        }
        // 调用接口
        BizResult<VerifyMerchantPaywayInfo> result = merchantPaywayService.verifyPayway(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 当交易方式为付款时，支付方式编码必传的，因为银商的条码和微信支付宝的有相同的，无法识别。当为充值时，
     * 支付方式编码可为空，充值只有支付宝和微信两种，可以通过条码识别出支付方式
     * <p>
     * 某些特定的场景：当支付动作为充值时，商品配置肯定是为空的。当验证方式为条码时且支付方式编码为空时，以条码
     * 的验证方式为准，当验证方式为条码时且支付方式编码不为空时，则以支付方式编码和条码的传入为准
     * 当验证方式为支付方式时，以支付方式编码的传入为准。同步订单时则只看api商户id。
     * <p>
     * 1001.商户未配置支付方式
     * 1002.传入的支付方式商家没有
     * 1003.对应的支付模式没有
     * 1004.条码付款，无支付方式编码
     * 1005.条码支付，条码传错
     * 1006.同步订单的api传错
     */
    @AutoTest(file = "gas_merchant/merchantPaywayServiceVerifyPaywayTestFailTwo.csv")
    @DisplayName("验证支付方式--失败用例")
    public void merchantPaywayServiceVerifyPaywayTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId, String platPartnerId1,
            String payWayCode, String payWayCode1,
            String payWayName, String payWayName1,
            String payWayType, String payWayType1,
            String barCode, String barCode1, String apiPartnerId, String apiPartnerId1,
            ApplyGoodsType applyGoodsType, ApplyGoodsType applyGoodsType1,
            PaywayTerminalType paywayTerminalType, PaywayTerminalType paywayTerminalType1,
            PaywayModelType paywayModelType, PaywayModelType paywayModelType1,
            PaywayActionType paywayActionType, PaywayActionType paywayActionType1,
            String payWayStatus, boolean print,
            VerifyPaywayOrder order
    ) {
        // 清除数据
        // 准备数据
        if (testId != 1001) {
            gasMerchantInitDataBase.initGasMerchantPayway(platPartnerId, payWayCode, payWayName, payWayType, payWayCode,
                    barCode, apiPartnerId, applyGoodsType,
                    paywayTerminalType, paywayModelType, paywayActionType, payWayStatus, print);
            //干扰数据
            gasMerchantInitDataBase.initGasMerchantPayway(platPartnerId1, payWayCode1, payWayName1, payWayType1,
                    payWayCode1, barCode1, apiPartnerId1, applyGoodsType1,
                    paywayTerminalType1, paywayModelType1, paywayActionType1, payWayStatus, print);
        }
        // 测试过程
        // 调用接口
        BizResult<VerifyMerchantPaywayInfo> result = merchantPaywayService.verifyPayway(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantPaywayByPlatPartnerIdAndPaywayCode(platPartnerId1, payWayCode1);
        gasMerchantTestBase.cleanGasMerchantPaywayByPlatPartnerIdAndPaywayCode(platPartnerId, payWayCode);
        silverboltTestBase.cleanGasMerchantPayWayByPartnerIdAndPayWayCode(platPartnerId1, payWayCode1);
        silverboltTestBase.cleanGasMerchantPayWayByPartnerIdAndPayWayCode(platPartnerId, payWayCode);
    }
}
