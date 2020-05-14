package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.OperateType;
import com.xyb.gas.merchant.api.enums.VoiceBroadcastType;
import com.xyb.gas.merchant.api.facade.VoiceBroadcastConfigService;
import com.xyb.gas.merchant.api.info.voicebroadcast.VoiceBroadcastConfigInfo;
import com.xyb.gas.merchant.api.info.voicebroadcast.VoiceBroadcastFieldInfo;
import com.xyb.gas.merchant.api.order.voicebroadcast.QueryVoiceBroadcastConfigOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2019/12/24.
 */
public class VoiceBroadcastConfigServiceQueryBroadcastConfigTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    VoiceBroadcastConfigService voiceBroadcastConfigService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/voiceBroadcastConfigServiceQueryBroadcastConfigTestSuccess.csv")
    @DisplayName("语音播报配置详情--成功用例")
    public void voiceBroadcastConfigServiceQueryBroadcastConfigTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            VoiceBroadcastType broadcastType,
            QueryVoiceBroadcastConfigOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(broadcastType.code(),
                "oilGun");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(order.getBroadcastType().code(),
                "oilGun");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(order.getBroadcastType().code(),
                "oilAmount");
        // 准备数据
        if (testId != 1001) {
            gasMerchantTestBase.insertGasVoiceBroadcastField(0, order.getBroadcastType().code(), "oilGun", "油枪号",
                    null, "1", "号枪,"
                    , OperateType.NO.code(), null, null);
        }
        if (testId == 1003) {
            gasMerchantTestBase.insertGasVoiceBroadcastField(0, order.getBroadcastType().code(), "oilAmount", "油品金额",
                    null, "80", "元,"
                    , OperateType.NO.code(), null, null);
        }
        //干扰数据
        gasMerchantTestBase.insertGasVoiceBroadcastField(0, broadcastType.code(), "oilGun", "油枪号",
                null, "1", "号枪,"
                , OperateType.NO.code(), null, null);
        // 测试过程
        // 调用接口
        BizResult<VoiceBroadcastConfigInfo> result =
                voiceBroadcastConfigService.queryBroadcastConfig(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        assertEquals(order.getBroadcastType(), result.getInfo().getBroadcastType());
        if (testId == 1001) {
            assertEquals(null, result.getInfo().getFieldInfos());
        }
        if (testId == 1002) {
            assertEquals(1, result.getInfo().getFieldInfos().size());
            voiceBroadcastFieldAssert(result.getInfo().getFieldInfos().get(0),
                    "oilGun", "油枪号",
                    null, "80",
                    "号枪,", OperateType.NO.code());
        }
        if (testId == 1003) {
            assertEquals(2, result.getInfo().getFieldInfos().size());
            for (VoiceBroadcastFieldInfo info : result.getInfo().getFieldInfos()) {
                if ("oilAmount".equals(info.getFieldCode())) {
                    voiceBroadcastFieldAssert(info,
                            "oilAmount", "油品金额",
                            null, "80",
                            "元,", OperateType.NO.code());
                }
                if ("oilGun".equals(info.getFieldCode())) {
                    voiceBroadcastFieldAssert(info,
                            "oilGun", "油枪号",
                            null, "1",
                            "号枪,", OperateType.NO.code());
                }
            }
        }
        // 清除数据
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(broadcastType.code(),
                "oilGun");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(order.getBroadcastType().code(),
                "oilGun");
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(order.getBroadcastType().code(),
                "oilAmount");
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/voiceBroadcastConfigServiceQueryBroadcastConfigTestFailOne.csv")
    @DisplayName("语音播报配置详情--参数非法")
    public void voiceBroadcastConfigServiceQueryBroadcastConfigTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryVoiceBroadcastConfigOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setBroadcastType(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        BizResult<VoiceBroadcastConfigInfo> result =
                voiceBroadcastConfigService.queryBroadcastConfig(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
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
        assertEquals(required, field.getRequired());
    }
}
