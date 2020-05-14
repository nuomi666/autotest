package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.OperateType;
import com.xyb.gas.merchant.api.enums.VoiceBroadcastType;
import com.xyb.gas.merchant.api.facade.VoiceBroadcastService;
import com.xyb.gas.merchant.api.info.voicebroadcast.StationVoiceBroadcastConfigInfo;
import com.xyb.gas.merchant.api.info.voicebroadcast.StationVoiceBroadcastInfo;
import com.xyb.gas.merchant.api.info.voicebroadcast.VoiceBroadcastConfigInfo;
import com.xyb.gas.merchant.api.info.voicebroadcast.VoiceBroadcastFieldInfo;
import com.xyb.gas.merchant.api.order.voicebroadcast.QueryStationVoiceBroadcastConfigOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2019/12/26.
 */
public class VoiceBroadcastServiceQueryStationVoiceBroadcastConfigTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    VoiceBroadcastService voiceBroadcastService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 当油站还没配置语音信息时，默认查出配置信息里的所有必填字段
     * 1001
     */
    @AutoTest(file = "gas_merchant/voiceBroadcastServiceQueryStationVoiceBroadcastConfigTestSuccess.csv")
    @DisplayName("查询油站语音播报配置信息--成功用例")
    public void voiceBroadcastServiceQueryStationVoiceBroadcastConfigTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String stationId,
            VoiceBroadcastType broadcastType,
            QueryStationVoiceBroadcastConfigOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(VoiceBroadcastType.Cashier.code(),
                "oilGun");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(VoiceBroadcastType.Cashier.code(),
                "oilAmount");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(VoiceBroadcastType.Recharge.code()
                , "oilAmount");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(VoiceBroadcastType.CashierRefund.code(), "paywayName");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(VoiceBroadcastType.RechargeRefund.code(), "mobile");
        gasMerchantTestBase.cleanGasStationVoiceBroadcastByStationId(stationId);
        gasMerchantTestBase.cleanGasStationVoiceBroadcastByStationId(order.getStationId());
        // 准备数据
        List<String> fieldCodes = new ArrayList<String>();
        List<String> fieldCodes1 = new ArrayList<String>();
        List<String> fieldCodesxx = new ArrayList<String>();
        fieldCodes.add("oilAmount");
        if (testId == 1002) {
            fieldCodes.add("oilGun");
        }
        fieldCodesxx.add("oilAmount");
        fieldCodes1.add("paywayName");
        gasMerchantTestBase.insertGasVoiceBroadcastField(0, VoiceBroadcastType.Cashier.code(), "oilGun", "油枪号",
                null, "1", "号枪,"
                , OperateType.NO.code(), null, null);
        gasMerchantTestBase.insertGasVoiceBroadcastField(0, VoiceBroadcastType.Cashier.code(), "oilAmount", "油品金额",
                null, "80", "元,"
                , OperateType.YES.code(), null, null);
        gasMerchantTestBase.insertGasVoiceBroadcastField(0, VoiceBroadcastType.Recharge.code(), "oilAmount", "油品金额xx",
                null, "8", "元,"
                , OperateType.NO.code(), null, null);
        gasMerchantTestBase.insertGasVoiceBroadcastField(0, VoiceBroadcastType.CashierRefund.code(), "paywayName",
                "支付方式",
                null, "现金", null
                , OperateType.YES.code(), null, null);
        gasMerchantTestBase.insertGasVoiceBroadcastField(0, VoiceBroadcastType.RechargeRefund.code(), "mobile",
                "手机号",
                "手机号", "13333333333", null
                , OperateType.NO.code(), null, null);
        if (testId != 1004) {
            gasMerchantTestBase.insertGasStationVoiceBroadcast(0, order.getStationId(),
                    VoiceBroadcastType.Cashier.code(),
                    JSON.toJSONString(fieldCodes), null, null);
        }
        if (testId == 1003) {
            gasMerchantTestBase.insertGasStationVoiceBroadcast(0, order.getStationId(),
                    VoiceBroadcastType.Recharge.code(),
                    JSON.toJSONString(fieldCodesxx), null, null);
        }
        //干扰数据
        gasMerchantTestBase.insertGasStationVoiceBroadcast(0, stationId, broadcastType.code(),
                JSON.toJSONString(fieldCodesxx), null, null);
        // 测试过程
        // 调用接口
        BizResult<StationVoiceBroadcastConfigInfo> result =
                voiceBroadcastService.queryStationVoiceBroadcastConfig(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<VoiceBroadcastConfigInfo> configInfos = result.getInfo().getConfigInfos();
        assertEquals(4, configInfos.size());
        for (VoiceBroadcastConfigInfo configInfo : configInfos) {
            if (VoiceBroadcastType.Cashier.equals(configInfo.getBroadcastType())) {
                assertEquals(2, configInfo.getFieldInfos().size());
                for (VoiceBroadcastFieldInfo info : configInfo.getFieldInfos()) {
                    if ("oilGun".equals(info.getFieldCode())) {
                        voiceBroadcastFieldAssert(info,
                                "oilGun", "油枪号",
                                null, "1",
                                "号枪,", OperateType.NO.code());
                    }
                    if ("oilAmount".equals(info.getFieldCode())) {
                        voiceBroadcastFieldAssert(info,
                                "oilAmount", "油品金额",
                                null, "80",
                                "元,", OperateType.YES.code());
                    }
                }
            }
            if (VoiceBroadcastType.Recharge.equals(configInfo.getBroadcastType())) {
                assertEquals(1, configInfo.getFieldInfos().size());
                voiceBroadcastFieldAssert(configInfo.getFieldInfos().get(0),
                        "oilAmount", "油品金额xx",
                        null, "8",
                        "元,", OperateType.NO.code());
            }
            if (VoiceBroadcastType.CashierRefund.equals(configInfo.getBroadcastType())) {
                assertEquals(1, configInfo.getFieldInfos().size());
                voiceBroadcastFieldAssert(configInfo.getFieldInfos().get(0),
                        "paywayName", "支付方式",
                        null, "现金",
                        null, OperateType.YES.code());
            }
            if (VoiceBroadcastType.RechargeRefund.equals(configInfo.getBroadcastType())) {
                assertEquals(1, configInfo.getFieldInfos().size());
                voiceBroadcastFieldAssert(configInfo.getFieldInfos().get(0),
                        "mobile", "手机号",
                        "手机号", "13333333333",
                        null, OperateType.NO.code());
            }
        }
        List<StationVoiceBroadcastInfo> broadcastInfos = result.getInfo().getBroadcastInfos();
        assertEquals(4, broadcastInfos.size());
        for (StationVoiceBroadcastInfo broadcastInfo : broadcastInfos) {
            assertEquals(order.getStationId(), broadcastInfo.getStationId());
            if (VoiceBroadcastType.Cashier.equals(broadcastInfo.getBroadcastType())) {
                if (testId == 1002) {
                    assertEquals(JSON.toJSONString(fieldCodes), JSON.toJSONString(broadcastInfo.getFieldCodes()));
                } else {
                    assertEquals(JSON.toJSONString(fieldCodesxx), JSON.toJSONString(broadcastInfo.getFieldCodes()));
                }
            }
            if (VoiceBroadcastType.Recharge.equals(broadcastInfo.getBroadcastType())) {
                if (testId == 1003) {
                    assertEquals(JSON.toJSONString(fieldCodesxx), JSON.toJSONString(broadcastInfo.getFieldCodes()));
                } else {
                    assertEquals(0, broadcastInfo.getFieldCodes().size());
                }
            }
            if (VoiceBroadcastType.CashierRefund.equals(broadcastInfo.getBroadcastType())) {
                assertEquals(JSON.toJSONString(fieldCodes1), JSON.toJSONString(broadcastInfo.getFieldCodes()));
            }
            if (VoiceBroadcastType.RechargeRefund.equals(broadcastInfo.getBroadcastType())) {
                assertEquals(0, broadcastInfo.getFieldCodes().size());
            }
        }
        // 清除数据
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(VoiceBroadcastType.Cashier.code(),
                "oilGun");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(VoiceBroadcastType.Cashier.code(),
                "oilAmount");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(VoiceBroadcastType.Recharge.code()
                , "oilAmount");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(VoiceBroadcastType.CashierRefund.code(), "paywayName");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(VoiceBroadcastType.RechargeRefund.code(), "mobile");
        gasMerchantTestBase.cleanGasStationVoiceBroadcastByStationId(stationId);
        gasMerchantTestBase.cleanGasStationVoiceBroadcastByStationId(order.getStationId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/voiceBroadcastServiceQueryStationVoiceBroadcastConfigTestFailOne.csv")
    @DisplayName("查询油站语音播报配置信息--参数非法")
    public void voiceBroadcastServiceQueryStationVoiceBroadcastConfigTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryStationVoiceBroadcastConfigOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setStationId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        BizResult<StationVoiceBroadcastConfigInfo> result =
                voiceBroadcastService.queryStationVoiceBroadcastConfig(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.缺少字段配置
     */
    @AutoTest(file = "gas_merchant/voiceBroadcastServiceQueryStationVoiceBroadcastConfigTestFailTwo.csv")
    @DisplayName("查询油站语音播报配置信息--失败用例")
    public void voiceBroadcastServiceQueryStationVoiceBroadcastConfigTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryStationVoiceBroadcastConfigOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(VoiceBroadcastType.Cashier.code(),
                "oilGun");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(VoiceBroadcastType.Cashier.code(),
                "oilAmount");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(VoiceBroadcastType.Recharge.code()
                , "oilAmount");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(VoiceBroadcastType.CashierRefund.code(), "paywayName");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(VoiceBroadcastType.RechargeRefund.code(), "mobile");
        gasMerchantTestBase.cleanGasStationVoiceBroadcastByStationId(order.getStationId());
        // 准备数据
        // 测试过程
        // 调用接口
        BizResult<StationVoiceBroadcastConfigInfo> result =
                voiceBroadcastService.queryStationVoiceBroadcastConfig(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(VoiceBroadcastType.Cashier.code(),
                "oilGun");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(VoiceBroadcastType.Cashier.code(),
                "oilAmount");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(VoiceBroadcastType.Recharge.code()
                , "oilAmount");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(VoiceBroadcastType.CashierRefund.code(), "paywayName");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(VoiceBroadcastType.RechargeRefund.code(), "mobile");
        gasMerchantTestBase.cleanGasStationVoiceBroadcastByStationId(order.getStationId());
    }

    /**
     * 语音播报字段配置
     */
    private void voiceBroadcastFieldAssert(
            VoiceBroadcastFieldInfo field,
            String fieldCode,
            String fieldName,
            String preValue,
            String defValue,
            String sufValue,
            String required
    ) {
        assertEquals(fieldCode, field.getFieldCode());
        assertEquals(fieldName, field.getFieldName());
        assertEquals(preValue, field.getPreValue());
        assertEquals(defValue, field.getDefaultValue());
        assertEquals(sufValue, field.getSuffixValue());
        assertEquals(required, field.getRequired().code());
    }
}
