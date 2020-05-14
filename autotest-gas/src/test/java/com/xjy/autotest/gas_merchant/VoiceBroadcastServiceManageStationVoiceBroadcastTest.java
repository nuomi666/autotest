package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.OperateType;
import com.xyb.gas.merchant.api.enums.VoiceBroadcastType;
import com.xyb.gas.merchant.api.facade.VoiceBroadcastService;
import com.xyb.gas.merchant.api.order.voicebroadcast.ManageStationVoiceBroadcastOrder;
import com.xyb.gas.merchant.api.order.voicebroadcast.VoiceBroadcastOrder;
import dal.model.gas_merchant.GasStationVoiceBroadcastDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2019/12/24.
 */
public class VoiceBroadcastServiceManageStationVoiceBroadcastTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    VoiceBroadcastService voiceBroadcastService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 字典里没有这个字段时，油站也能新增成功，这应该算一个BUG，开发暂时没改。因为pos机在
     * 配置信息时，只会用到字典里查出来的字段
     * 1001.新增同一播报类型，一个字段
     * 1002.新增同一播报类型，多个字段
     * 1003.新增多种播报类型，一个字段
     * 1004.新增多种播报类型，多个字段
     * 1005.新增多种播报类型，其中包含修改和新增字段
     */
    @AutoTest(file = "gas_merchant/voiceBroadcastServiceManageStationVoiceBroadcastTestSuccess.csv")
    @DisplayName("配置油站语音播报信息--成功用例")
    public void voiceBroadcastServiceManageStationVoiceBroadcastTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            VoiceBroadcastType broadcastType,
            VoiceBroadcastType broadcastType1,
            ManageStationVoiceBroadcastOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(broadcastType.code(), "oilGun");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(broadcastType1.code(), "oilAmount");
        gasMerchantTestBase.cleanGasStationVoiceBroadcastByStationId(order.getStationId());
        // 准备数据
        List<String> fieldCodesxx = new ArrayList<String>();
        fieldCodesxx.add("payAmount");
        gasMerchantTestBase.insertGasVoiceBroadcastField(0, broadcastType.code(), "oilGun", "油枪号",
                null, "1", "号枪,"
                , OperateType.NO.code(), null, null);
        gasMerchantTestBase.insertGasVoiceBroadcastField(0, broadcastType1.code(), "oilAmount", "油品金额",
                null, "80", "元,"
                , OperateType.NO.code(), null, null);
        if (testId == 1005) {
            gasMerchantTestBase.insertGasStationVoiceBroadcast(0, order.getStationId(), broadcastType1.code(),
                    JSON.toJSONString(fieldCodesxx), null, null);
        }
        // 测试过程
        VoiceBroadcastOrder broadcastOrder = new VoiceBroadcastOrder();
        VoiceBroadcastOrder broadcastOrder1 = new VoiceBroadcastOrder();
        List<String> fieldCodes = new ArrayList<String>();
        List<String> fieldCodes1 = new ArrayList<String>();
        fieldCodes.add("oilGun");
        if (testId == 1002 || testId == 1004) {
            fieldCodes.add("oilAmount");
        }
        broadcastOrder.setFieldCodes(fieldCodes);
        broadcastOrder.setBroadcastType(broadcastType);
        if (testId == 1003 || testId == 1005) {
            fieldCodes1.add("oilAmount");
            broadcastOrder1.setFieldCodes(fieldCodes1);
            broadcastOrder1.setBroadcastType(broadcastType1);
        }
        if (testId == 1004) {
            broadcastOrder1.setFieldCodes(fieldCodes);
            broadcastOrder1.setBroadcastType(broadcastType1);
        }
        List<VoiceBroadcastOrder> broadcastOrders = new ArrayList<VoiceBroadcastOrder>();
        broadcastOrders.add(broadcastOrder);
        if (testId >= 1003) {
            broadcastOrders.add(broadcastOrder1);
        }
        order.setBroadcastOrders(broadcastOrders);
//        manageStationVoiceBroadcastOrder.setBroadcastOrders_voiceBroadcastOrder(broadcastOrders_voiceBroadcastOrder);
        // 调用接口
        SimpleResult result = voiceBroadcastService.manageStationVoiceBroadcast(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasStationVoiceBroadcastDO> voiceBroadcasts =
                gasMerchantTestBase.findGasStationVoiceBroadcastByStationId(order.getStationId());
        if (testId == 1001 || testId == 1002) {
            assertEquals(1, voiceBroadcasts.size());
            stationVoiceBroadcastAssert(voiceBroadcasts.get(0),
                    order.getStationId(), JSON.toJSONString(fieldCodes),
                    broadcastType.code());
        }
        if (testId >= 1003) {
            assertEquals(2, voiceBroadcasts.size());
            for (GasStationVoiceBroadcastDO voiceBroadcast : voiceBroadcasts) {
                if (broadcastType.code().equals(voiceBroadcast.getBroadcastType())) {
                    stationVoiceBroadcastAssert(voiceBroadcast,
                            order.getStationId(), JSON.toJSONString(fieldCodes),
                            broadcastType.code());
                }
                if (broadcastType1.code().equals(voiceBroadcast.getBroadcastType())) {
                    stationVoiceBroadcastAssert(voiceBroadcast,
                            order.getStationId(), JSON.toJSONString(broadcastOrder1.getFieldCodes()),
                            broadcastType1.code());
                }
            }
        }
        // 清除数据
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(broadcastType.code(), "oilGun");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(broadcastType1.code(), "oilAmount");
        gasMerchantTestBase.cleanGasStationVoiceBroadcastByStationId(order.getStationId());
    }

    /**
     *
     */
    @AutoTest(file = "gas_merchant/voiceBroadcastServiceManageStationVoiceBroadcastTestFailOne.csv")
    @DisplayName("配置油站语音播报信息--参数非法")
    public void voiceBroadcastServiceManageStationVoiceBroadcastTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            VoiceBroadcastType broadcastType,
            ManageStationVoiceBroadcastOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        VoiceBroadcastOrder broadcastOrder = new VoiceBroadcastOrder();
        List<String> fieldCodes = new ArrayList<String>();
        fieldCodes.add("oilGun");
        broadcastOrder.setFieldCodes(fieldCodes);
        broadcastOrder.setBroadcastType(broadcastType);
        if (testId == 1001) {
            broadcastOrder.setFieldCodes(null);
        }
        if (testId == 1002) {
            broadcastOrder.setBroadcastType(null);
        }
        List<VoiceBroadcastOrder> broadcastOrders = new ArrayList<VoiceBroadcastOrder>();
        broadcastOrders.add(broadcastOrder);
        order.setBroadcastOrders(broadcastOrders);
        if (testId == 1003) {
            order.setBroadcastOrders(null);
        }
        if (testId == 1004) {
            order.setStationId(null);
        }
        if (testId == 1005) {
            order.setGid(null);
        }
        if (testId == 1006) {
            order = null;
        }
        // 调用接口
        SimpleResult result = voiceBroadcastService.manageStationVoiceBroadcast(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.缺少字段配置信息
     * 1002.缺少必选字段
     */
    @AutoTest(file = "gas_merchant/voiceBroadcastServiceManageStationVoiceBroadcastTestFailTwo.csv")
    @DisplayName("配置油站语音播报信息--失败用例")
    public void voiceBroadcastServiceManageStationVoiceBroadcastTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            VoiceBroadcastType broadcastType,
            ManageStationVoiceBroadcastOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(broadcastType.code(), "oilGun");
        gasMerchantTestBase.cleanGasStationVoiceBroadcastByStationId(order.getStationId());
        // 准备数据
        if (testId == 1002) {
            gasMerchantTestBase.insertGasVoiceBroadcastField(1, broadcastType.code(), "oilGun", "油枪号",
                    null, "1", "号枪,"
                    , OperateType.YES.code(), null, null);
        }
        // 测试过程
        VoiceBroadcastOrder broadcastOrder = new VoiceBroadcastOrder();
        List<String> fieldCodes = new ArrayList<String>();
        fieldCodes.add("oilName");
        broadcastOrder.setFieldCodes(fieldCodes);
        broadcastOrder.setBroadcastType(broadcastType);
        List<VoiceBroadcastOrder> broadcastOrders = new ArrayList<VoiceBroadcastOrder>();
        broadcastOrders.add(broadcastOrder);
        order.setBroadcastOrders(broadcastOrders);
        // 调用接口
        SimpleResult result = voiceBroadcastService.manageStationVoiceBroadcast(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasStationVoiceBroadcastDO> voiceBroadcasts =
                gasMerchantTestBase.findGasStationVoiceBroadcastByStationId(order.getStationId());
        // 清除数据
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(broadcastType.code(), "oilGun");
        gasMerchantTestBase.cleanGasStationVoiceBroadcastByStationId(order.getStationId());
    }

    /**
     * 油站语音播报字段配置
     */
    private void stationVoiceBroadcastAssert(
            GasStationVoiceBroadcastDO stationBroadcast,
            String stationId,
            String fieldCode,
            String castType
    ) {
        assertEquals(stationId, stationBroadcast.getStationId());
        assertEquals(castType, stationBroadcast.getBroadcastType());
        assertEquals(fieldCode, stationBroadcast.getFieldCodes());
    }
}
