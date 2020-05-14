package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.OperateType;
import com.xyb.gas.merchant.api.enums.VoiceBroadcastType;
import com.xyb.gas.merchant.api.facade.VoiceBroadcastConfigService;
import com.xyb.gas.merchant.api.order.voicebroadcast.ManageVoiceBroadcastConfigOrder;
import com.xyb.gas.merchant.api.order.voicebroadcast.VoiceBroadcastFieldOrder;
import dal.model.gas_merchant.GasVoiceBroadcastFieldDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2019/12/19.
 */
public class VoiceBroadcastConfigServiceManageBroadcastConfigTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    VoiceBroadcastConfigService voiceBroadcastConfigService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 更新相同类型的语音配置时是先做的删除再新增
     * 1001.新增一个字段的
     * 1002.新增多个字段的
     * 1003.修改多个字段
     */
    @AutoTest(file = "gas_merchant/voiceBroadcastConfigServiceManageBroadcastConfigTestSuccess.csv", project =
            "gas_merchant")
    @DisplayName("语音播报配置管理--成功用例")
    public void voiceBroadcastConfigServiceManageBroadcastConfigTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            VoiceBroadcastType broadcastType,
            ManageVoiceBroadcastConfigOrder order,
            VoiceBroadcastFieldOrder fieldOrder,
            VoiceBroadcastFieldOrder fieldOrder1
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(broadcastType.code(),
                fieldOrder.getFieldCode());
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(order.getBroadcastType().code(),
                fieldOrder.getFieldCode());
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(order.getBroadcastType().code(),
                fieldOrder1.getFieldCode());
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(broadcastType.code(),
                fieldOrder1.getFieldCode());
        // 准备数据
        gasMerchantTestBase.insertGasVoiceBroadcastField(1, broadcastType.code(), "oilGun", "油枪号",
                null, "1", "号枪,"
                , OperateType.NO.code(), null, null);
        // 测试过程
        List<VoiceBroadcastFieldOrder> fieldOrders = new ArrayList<VoiceBroadcastFieldOrder>();
        fieldOrders.add(fieldOrder);
        if (testId >= 1002) {
            fieldOrders.add(fieldOrder1);
        }
        order.setFieldOrders(fieldOrders);
        // 调用接口broadcastType.code()
        SimpleResult result = voiceBroadcastConfigService.manageBroadcastConfig(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasVoiceBroadcastFieldDO> fields =
                gasMerchantTestBase.findGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(order.getBroadcastType().code(), fieldOrder.getFieldCode());
        assertEquals(1, fields.size());
        voiceBroadcastFieldAssert(fields.get(0), order.getBroadcastType().code(),
                fieldOrder1.getFieldCode(), fieldOrder1.getFieldName(),
                fieldOrder1.getPreValue(), fieldOrder1.getDefaultValue(),
                fieldOrder1.getSuffixValue(), fieldOrder1.getRequired().code());
        List<GasVoiceBroadcastFieldDO> fields1 =
                gasMerchantTestBase.findGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(order.getBroadcastType().code(), fieldOrder1.getFieldCode());
        if (testId >= 1002) {
            assertEquals(1, fields1.size());
            voiceBroadcastFieldAssert(fields1.get(0), order.getBroadcastType().code(),
                    fieldOrder1.getFieldCode(), fieldOrder1.getFieldName(),
                    fieldOrder1.getPreValue(), fieldOrder1.getDefaultValue(),
                    fieldOrder1.getSuffixValue(), fieldOrder1.getRequired().code());
        }
        List<GasVoiceBroadcastFieldDO> fieldsxx =
                gasMerchantTestBase.findGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(order.getBroadcastType().code(), "oilGun");
        assertEquals(0, fieldsxx.size());
        // 清除数据
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(broadcastType.code(),
                fieldOrder.getFieldCode());
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(order.getBroadcastType().code(),
                fieldOrder.getFieldCode());
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(order.getBroadcastType().code(),
                fieldOrder1.getFieldCode());
        gasMerchantTestBase.cleanGasVoiceBroadcastFieldByBroadcastTypeAndFieldCode(broadcastType.code(),
                fieldOrder1.getFieldCode());
    }

    /**
     *
     */
    @AutoTest(file = "gas_merchant/voiceBroadcastConfigServiceManageBroadcastConfigTestFailOne.csv", project =
            "gas_merchant")
    @DisplayName("语音播报配置管理--参数非法")
    public void voiceBroadcastConfigServiceManageBroadcastConfigTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ManageVoiceBroadcastConfigOrder order,
            VoiceBroadcastFieldOrder fieldOrder
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        List<VoiceBroadcastFieldOrder> fieldOrders = new ArrayList<VoiceBroadcastFieldOrder>();
        if (testId == 1002) {
            fieldOrder.setFieldCode(null);
        }
        if (testId == 1003) {
            fieldOrder.setFieldName(null);
        }
        if (testId == 1004) {
            fieldOrder.setDefaultValue(null);
        }
        if (testId == 1005) {
            fieldOrder.setRequired(null);
        }
        if (testId == 1006) {
            fieldOrder = null;
        }
        fieldOrders.add(fieldOrder);
        order.setFieldOrders(fieldOrders);
        if (testId == 1001) {
            order.setBroadcastType(null);
        }
        if (testId == 1007) {
            order.setGid(null);
        }
        if (testId == 1008) {
            order = null;
        }
        // 调用接口
        SimpleResult result = voiceBroadcastConfigService.manageBroadcastConfig(order);
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
            GasVoiceBroadcastFieldDO field,
            String castType,
            String fieldCode,
            String fieldName,
            String preValue,
            String defValue,
            String sufValue,
            String required
    ) {
        assertEquals(castType, field.getBroadcastType());
        assertEquals(fieldCode, field.getFieldCode());
        assertEquals(fieldName, field.getFieldName());
        assertEquals(preValue, field.getPreValue());
        assertEquals(defValue, field.getDefaultValue());
        assertEquals(sufValue, field.getSuffixValue());
        assertEquals(required, field.getRequired());
    }
}
