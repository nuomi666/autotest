package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.RuleDescriptionType;
import com.xyb.gas.merchant.api.facade.RuleDescriptionService;
import com.xyb.gas.merchant.api.order.ModifyOilStationDescriptionOrder;
import dal.model.gas_merchant.GasOilStationDescriptionDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author nuomi
 * Created on 2019/12/30.
 */
public class RuleDescriptionServiceUpdOilStationDescriptionTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    RuleDescriptionService ruleDescriptionService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    /**
     * 1001.新增
     * 1002.更新
     */
    @AutoTest(file = "gas_merchant/ruleDescriptionServiceUpdOilStationDescriptionTestSuccess.csv")
    @DisplayName("设置今日油价说明信息描述--成功用例")
    public void ruleDescriptionServiceUpdOilStationDescriptionTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId,
            String partnerId, String partnerId1,
            String stationId, String stationId1,
            String stationName, String stationName1,
            String stationCode, String stationCode1,
            String stationStatus, String stationStatus1,
            String dec,
            ModifyOilStationDescriptionOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasMerchantStationByStationId(stationId);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId1);
        merchantTestBase.cleanGasOilStationDescriptionByStationId(stationId);
        merchantTestBase.cleanGasOilStationDescriptionByStationId(stationId1);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId1);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId1);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId1);
        // 准备数据
        gasMerchantInitDataBase.initStationsWithOneMerchant(platPartnerId, platPartnerId, partnerId, partnerId1,
                stationId, stationId1, stationName, stationName1, stationCode, stationCode1,
                stationStatus, stationStatus1);
        if (testId == 1002) {
            merchantTestBase.insertGasOilStationDescription(0, partnerId, platPartnerId, stationId,
                    RuleDescriptionType.Description.code(), null, null,
                    dec);
            //干扰数据
            merchantTestBase.insertGasOilStationDescription(0, partnerId1, platPartnerId, stationId1,
                    RuleDescriptionType.Description.code(), null, null,
                    dec);
        }
        // 测试过程
        order.setStationId(stationId);
        // 调用接口
        SimpleResult result = ruleDescriptionService.updOilStationDescription(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasOilStationDescriptionDO> stationDecs =
                merchantTestBase.findGasOilStationDescriptionByStationId(stationId);
        List<GasOilStationDescriptionDO> stationDecs1 =
                merchantTestBase.findGasOilStationDescriptionByStationId(stationId1);
        ruleDescriptionAssert(stationDecs.get(0),
                partnerId, platPartnerId,
                order.getStationId(), order.getDescription());
        if (testId == 1002) {
            ruleDescriptionAssert(stationDecs1.get(0),
                    partnerId1, platPartnerId,
                    stationId1, dec);
        }
        // 清除数据
        merchantTestBase.cleanGasMerchantStationByStationId(stationId);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId1);
        merchantTestBase.cleanGasOilStationDescriptionByStationId(stationId);
        merchantTestBase.cleanGasOilStationDescriptionByStationId(stationId1);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId1);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId1);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId1);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/ruleDescriptionServiceUpdOilStationDescriptionTestFailOne.csv")
    @DisplayName("设置今日油价说明信息描述-参数非法")
    public void ruleDescriptionServiceUpdOilStationDescriptionTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ModifyOilStationDescriptionOrder order
    ) {
        // 清除数据
        // 准备数据

        // 测试过程
        if (testId == 1001) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setStationId(null);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        SimpleResult result = ruleDescriptionService.updOilStationDescription(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 今日油价说明
     */
    private void ruleDescriptionAssert(
            GasOilStationDescriptionDO dec,
            String partnerId,
            String platPartnerId,
            String stationId,
            String description
    ) {
        assertEquals(partnerId, dec.getPartnerId());
        assertEquals(platPartnerId, dec.getPlatPartnerId());
        assertEquals(RuleDescriptionType.Description.code(), dec.getType());
        assertEquals(stationId, dec.getStationId());
        assertEquals(description, dec.getDescription());
    }
}
