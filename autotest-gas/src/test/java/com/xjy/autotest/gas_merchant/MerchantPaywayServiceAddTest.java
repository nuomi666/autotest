package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.InitData.GasSilverboltInitBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.ApplyGoodsType;
import com.xyb.gas.merchant.api.enums.PaywayActionType;
import com.xyb.gas.merchant.api.enums.PaywayModelType;
import com.xyb.gas.merchant.api.enums.PaywayTerminalType;
import com.xyb.gas.merchant.api.facade.MerchantPaywayService;
import com.xyb.gas.merchant.api.order.payway.ManageMerchantPaywayOrder;
import com.xyb.gas.merchant.api.order.payway.MerchantPaywayAttributeOrder;
import com.xyb.gas.merchant.api.order.payway.PaywaySceneOrder;
import dal.model.gas_merchant.GasMerchantPaywayDO;
import dal.model.gas_silverbolt.GasMerchantPayWayDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author nuomi
 * Created on 2019/11/21.
 */
public class MerchantPaywayServiceAddTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantPaywayService merchantPaywayService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    GasSilverboltInitBase gasSilverboltInitBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantPaywayServiceAddTestSuccess.csv")
    @DisplayName("添加商户支付方式--成功用例")
    public void merchantPaywayServiceAddTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String paywayType,
            String paywayName, String paywayIcon,
            String paywaySmallIcon, String channelCode,
            String channelFunction,
            String barCode, String barCode1, PaywayActionType paywayActionType,
            PaywayActionType paywayActionType1,
            PaywayModelType paywayModelType, PaywayModelType paywayModelType1,
            PaywayTerminalType paywayTerminalType, PaywayTerminalType paywayTerminalType1,
            boolean print,
            ManageMerchantPaywayOrder order,
            PaywaySceneOrder paywaySceneOrder,
            MerchantPaywayAttributeOrder attribute
    ) {
        // 清除数据
        gasMerchantInitDataBase.cleanGasMerchantPayWayByPartnerIdAndCode(order.getPlatPartnerId(),
                order.getPaywayCode());
        gasMerchantInitDataBase.cleanGasMerchantPaywayByPartnerIdAndCode(order.getPlatPartnerId(),
                order.getPaywayCode());
        // 准备数据
        gasSilverboltInitBase.initGasPaywayDict(order.getPaywayCode(), paywayType, paywayName, paywayIcon,
                paywaySmallIcon, channelCode, channelFunction);
        // 测试过程
        //支付模式
        List<String> modelList = new ArrayList<String>();
        modelList.add(paywayModelType.code());
        if (testId == 1004) {
            modelList.add(paywayModelType1.code());
        }
        //终端类型
        List<PaywayTerminalType> terminalTypes = Lists.newArrayList();
        terminalTypes.add(paywayTerminalType);
        if (testId == 1001) {
            terminalTypes.add(paywayTerminalType1);
        }
        //条码规则
        List<String> barCodeList = new ArrayList<String>();
        barCodeList.add(barCode);
        if (testId == 1004) {
            barCodeList.add(barCode1);
        }
        //支付动作类型终端配置
        Map<PaywayActionType, List<PaywayTerminalType>> actionTerminalMap = Maps.newHashMap();
        actionTerminalMap.put(paywayActionType, terminalTypes);
        if (testId == 1004 || testId == 1007) {
            actionTerminalMap.put(paywayActionType1, terminalTypes);
        }
        paywaySceneOrder.setModelList(modelList);
        paywaySceneOrder.setActionTerminalMap(actionTerminalMap);
        List<String> stationList = new ArrayList<>();
//        stationList.add(string);
        paywaySceneOrder.setStationList(stationList);
        attribute.setPrint(print);
        paywaySceneOrder.setBarCodeList(barCodeList);
        if (testId != 1001) {
            order.setPaywaySceneOrder(paywaySceneOrder);
            order.setAttribute(attribute);
        }
        // 调用接口
        SimpleResult result = merchantPaywayService.add(order);
        sleep(3);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            gasMerchantPayWayAssert(order.getPlatPartnerId(), order.getPaywayCode(), paywayName, paywayType, paywayIcon,
                    paywaySmallIcon,
                    channelCode, channelFunction, null, null);
        } else {
            gasMerchantPayWayAssert(order.getPlatPartnerId(), order.getPaywayCode(), paywayName, paywayType, paywayIcon,
                    paywaySmallIcon,
                    channelCode, channelFunction, JSON.toJSONString(paywaySceneOrder), JSON.toJSONString(attribute));
        }
        silverboltMerchantPayWayAssert(order.getPlatPartnerId(), order.getPaywayCode(), paywayName);
        // 清除数据
        gasMerchantInitDataBase.cleanGasMerchantPayWayByPartnerIdAndCode(order.getPlatPartnerId(),
                order.getPaywayCode());
        gasMerchantInitDataBase.cleanGasMerchantPaywayByPartnerIdAndCode(order.getPlatPartnerId(),
                order.getPaywayCode());
        silverboltTestBase.cleanGasPaywayDictByPaywayCode(order.getPaywayCode());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantPaywayServiceAddTestFailOne.csv")
    @DisplayName("添加商户支付方式--参数非法")
    public void merchantPaywayServiceAddTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ManageMerchantPaywayOrder order,
            PaywaySceneOrder paywaySceneOrder,
            MerchantPaywayAttributeOrder attribute
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        //支付模式
        List<String> modelList = new ArrayList<String>();
        //条码规则
        List<String> barCodeList = new ArrayList<String>();
        //支付动作类型终端配置
        Map<PaywayActionType, List<PaywayTerminalType>> actionTerminalMap = Maps.newHashMap();
        paywaySceneOrder.setModelList(modelList);
        paywaySceneOrder.setActionTerminalMap(actionTerminalMap);
        paywaySceneOrder.setBarCodeList(barCodeList);
        order.setPaywaySceneOrder(paywaySceneOrder);
        order.setAttribute(attribute);
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
        SimpleResult result = merchantPaywayService.add(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据

    }

    /**
     * 1001.支付方式配置查询失败
     * 1002.商家已经存在该支付方式
     */
    @AutoTest(file = "gas_merchant/merchantPaywayServiceAddTestFailTwo.csv")
    @DisplayName("添加商户支付方式--失败用例")
    public void merchantPaywayServiceAddTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String paywayType,
            String paywayName, String paywayIcon,
            String paywaySmallIcon, String channelCode,
            String channelFunction,
            String barCode, PaywayActionType paywayActionType,
            PaywayModelType paywayModelType,
            PaywayTerminalType paywayTerminalType,
            boolean print,
            ManageMerchantPaywayOrder order,
            PaywaySceneOrder paywaySceneOrder,
            MerchantPaywayAttributeOrder attribute
    ) {
        // 清除数据
        gasMerchantInitDataBase.cleanGasMerchantPayWayByPartnerIdAndCode(order.getPlatPartnerId(),
                order.getPaywayCode());
        gasMerchantInitDataBase.cleanGasMerchantPaywayByPartnerIdAndCode(order.getPlatPartnerId(),
                order.getPaywayCode());
        // 准备数据
        if (testId == 1002) {
            gasSilverboltInitBase.initGasPaywayDict(order.getPaywayCode(), paywayType, paywayName, paywayIcon,
                    paywaySmallIcon, channelCode, channelFunction);
            gasMerchantInitDataBase.initGasMerchantPayway(order.getPlatPartnerId(), order.getPaywayCode(), paywayName
                    , paywayType, order.getPaywayCode(),
                    barCode, null, ApplyGoodsType.OIL,
                    paywayTerminalType, paywayModelType, paywayActionType, "ABLE", print);
        }
        // 测试过程
        // 调用接口
        SimpleResult result = merchantPaywayService.add(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        gasMerchantInitDataBase.cleanGasMerchantPayWayByPartnerIdAndCode(order.getPlatPartnerId(),
                order.getPaywayCode());
        gasMerchantInitDataBase.cleanGasMerchantPaywayByPartnerIdAndCode(order.getPlatPartnerId(),
                order.getPaywayCode());
        silverboltTestBase.cleanGasPaywayDictByPaywayCode(order.getPaywayCode());
    }

    /**
     * 商户支付方式配置表校验
     *
     * @param partnerId
     * @param paywayCode
     * @param paywayName
     * @param paywayType
     * @param paywayIcon
     * @param paywaySmallIcon
     * @param channelCode
     * @param channelFunction
     * @param paywayScene
     * @param paywayAttribute
     */
    private void gasMerchantPayWayAssert(
            String partnerId,
            String paywayCode,
            String paywayName,
            String paywayType,
            String paywayIcon,
            String paywaySmallIcon,
            String channelCode,
            String channelFunction,
            String paywayScene,
            String paywayAttribute
    ) {
        GasMerchantPaywayDO paywayDO =
                gasMerchantTestBase.findGasMerchantPaywayByPlatPartnerIdAndPaywayCode(partnerId, paywayCode).get(0);
        assertEquals(partnerId, paywayDO.getPlatPartnerId());
        assertEquals(paywayCode, paywayDO.getPaywayCode());
        assertEquals(paywayName, paywayDO.getPaywayName());
        assertEquals(paywayType, paywayDO.getPaywayType());
        assertEquals(paywayIcon, paywayDO.getPaywayIcon());
        assertEquals(paywaySmallIcon, paywayDO.getPaywaySmallIcon());
        assertEquals(channelCode, paywayDO.getChannelCode());
        assertEquals(channelFunction, paywayDO.getChannelFunction());
        assertEquals(paywayScene, paywayDO.getPaywayScene());
        assertEquals("ABLE", paywayDO.getStatus());
        assertEquals(paywayAttribute, paywayDO.getPaywayAttribute());
//        assertEquals(rawAddTime, paywayDO.getRawAddTime());
//        assertEquals(rawUpdateTime, paywayDO.getRawUpdateTime());
    }

    /**
     * 分析数据校验
     *
     * @param partnerId
     * @param paywayCode
     * @param paywayName
     */
    private void silverboltMerchantPayWayAssert(
            String partnerId,
            String paywayCode,
            String paywayName
    ) {
        GasMerchantPayWayDO paywayDO =
                silverboltTestBase.findGasMerchantPayWayByPartnerIdAndPayWayCode(partnerId, paywayCode).get(0);
        assertEquals(partnerId, paywayDO.getPartnerId());
        assertEquals(paywayCode, paywayDO.getPayWayCode());
        assertEquals(paywayName, paywayDO.getPayWayName());
//        assertEquals(rawAddTime, paywayDO.getRawAddTime());
//        assertEquals(rawUpdateTime, paywayDO.getRawUpdateTime());
    }
}
