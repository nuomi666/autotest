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
import com.xyb.gas.merchant.api.info.voicebroadcast.StationVoiceBroadcastTypeInfo;
import com.xyb.gas.merchant.api.info.voicebroadcast.VoiceBroadcastFieldInfo;
import com.xyb.gas.merchant.api.order.voicebroadcast.QueryStationVoiceBroadcastByTypeOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2019/12/26.
 */
public class VoiceBroadcastServiceQueryStationVoiceBroadcastByTypeTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    VoiceBroadcastService voiceBroadcastService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 当油站还没配置语音信息时，默认查出此类型的所有语音信息
     * 1001
     */
    @AutoTest(file = "gas_merchant/voiceBroadcastServiceQueryStationVoiceBroadcastByTypeTestSuccess.csv")
    @DisplayName("根据类型查询油站语音播报信息--成功用例")
    public void voiceBroadcastServiceQueryStationVoiceBroadcastByTypeTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            VoiceBroadcastType broadcastType,
            VoiceBroadcastType broadcastType1,
            QueryStationVoiceBroadcastByTypeOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(broadcastType.code(), "oilGun");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(broadcastType.code(), "oilAmount");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(broadcastType1.code(), "oilAmount");
        gasMerchantTestBase.cleanGasStationVoiceBroadcastByStationId(order.getStationId());
        // 准备数据
        List<String> fieldCodes = new ArrayList<String>();
        List<String> fieldCodesxx = new ArrayList<String>();
        fieldCodes.add("oilAmount");
        if (testId == 1002) {
            fieldCodes.add("oilGun");
        }
        fieldCodesxx.add("oilAmount");
        gasMerchantTestBase.insertGasVoiceBroadcastField(0, broadcastType.code(), "oilGun", "油枪号",
                null, "1", "号枪,"
                , OperateType.NO.code(), null, null);
        gasMerchantTestBase.insertGasVoiceBroadcastField(0, broadcastType.code(), "oilAmount", "油品金额",
                null, "80", "元,"
                , OperateType.YES.code(), null, null);
        gasMerchantTestBase.insertGasVoiceBroadcastField(0, broadcastType1.code(), "oilAmount", "油品金额xx",
                null, "8", "元,"
                , OperateType.NO.code(), null, null);
        if (testId != 1003) {
            gasMerchantTestBase.insertGasStationVoiceBroadcast(0, order.getStationId(), broadcastType.code(),
                    JSON.toJSONString(fieldCodes), null, null);
        }
        //干扰数据
        gasMerchantTestBase.insertGasStationVoiceBroadcast(0, order.getStationId(), broadcastType1.code(),
                JSON.toJSONString(fieldCodesxx), null, null);
        // 测试过程
        // 调用接口
        BizResult<StationVoiceBroadcastTypeInfo> result =
                voiceBroadcastService.queryStationVoiceBroadcastByType(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        assertEquals(order.getStationId(), result.getInfo().getStationId());
        assertEquals(order.getBroadcastType(), result.getInfo().getBroadcastType());
        List<VoiceBroadcastFieldInfo> fieldInfos = result.getInfo().getFieldInfos();
        if (testId == 1001) {
            assertEquals(1, fieldInfos.size());
            fieldAssert(fieldInfos.get(0), "oilAmount", "油品金额",
                    null, "80",
                    "元,", OperateType.YES.code());
        }
        if (testId >= 1002) {
            assertEquals(2, fieldInfos.size());
            for (VoiceBroadcastFieldInfo fieldInfo : fieldInfos) {
                if ("oilAmount".equals(fieldInfo.getFieldCode())) {
                    fieldAssert(fieldInfo, "oilAmount", "油品金额",
                            null, "80",
                            "元,", OperateType.YES.code());
                }
                if ("oilGun".equals(fieldInfo.getFieldCode())) {
                    fieldAssert(fieldInfo, "oilGun", "油枪号",
                            null, "1",
                            "号枪,", OperateType.NO.code());
                }
            }
        }
        // 清除数据
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(broadcastType.code(), "oilGun");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(broadcastType.code(), "oilAmount");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(broadcastType1.code(), "oilAmount");
        gasMerchantTestBase.cleanGasStationVoiceBroadcastByStationId(order.getStationId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/voiceBroadcastServiceQueryStationVoiceBroadcastByTypeTestFailOne.csv")
    @DisplayName("根据类型查询油站语音播报信息--参数非法")
    public void voiceBroadcastServiceQueryStationVoiceBroadcastByTypeTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryStationVoiceBroadcastByTypeOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setStationId(null);
        }
        if (testId == 1002) {
            order.setBroadcastType(null);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        BizResult<StationVoiceBroadcastTypeInfo> result =
                voiceBroadcastService.queryStationVoiceBroadcastByType(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 当油站还没配置语音信息时，默认查出此类型的所有语音信息
     * 1001
     */
    @AutoTest(file = "gas_merchant/voiceBroadcastServiceQueryStationVoiceBroadcastByTypeTestFailTwo.csv")
    @DisplayName("根据类型查询油站语音播报信息--失败用例")
    public void voiceBroadcastServiceQueryStationVoiceBroadcastByTypeTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryStationVoiceBroadcastByTypeOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        BizResult<StationVoiceBroadcastTypeInfo> result =
                voiceBroadcastService.queryStationVoiceBroadcastByType(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 字段信息
     */
    private void fieldAssert(
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
