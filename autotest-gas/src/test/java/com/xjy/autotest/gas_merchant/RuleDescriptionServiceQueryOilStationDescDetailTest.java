package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.RuleDescriptionType;
import com.xyb.gas.merchant.api.facade.RuleDescriptionService;
import com.xyb.gas.merchant.api.info.OilStationDescriptionInfo;
import com.xyb.gas.merchant.api.order.QueryOilStationDescriptionOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2019/12/30.
 */
public class RuleDescriptionServiceQueryOilStationDescDetailTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    RuleDescriptionService ruleDescriptionService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/ruleDescriptionServiceQueryOilStationDescDetailTestSuccess.csv")
    @DisplayName("查询今日油价说明信息描述--成功用例")
    public void ruleDescriptionServiceQueryOilStationDescDetailTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String platPartnerId,
            String stationId, String stationId1,
            String type, String dec, String decxx,
            QueryOilStationDescriptionOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasOilStationDescriptionByStationId(stationId);
        merchantTestBase.cleanGasOilStationDescriptionByStationId(stationId1);
        // 准备数据
        merchantTestBase.insertGasOilStationDescription(0, order.getPartnerId(), order.getPlatPartnerId(), stationId,
                RuleDescriptionType.Description.code(), null, null,
                dec);
        //干扰数据
        merchantTestBase.insertGasOilStationDescription(0, partnerId, platPartnerId, stationId1,
                type, null, null, decxx);
        // 测试过程
        order.setStationId(stationId);
        // 调用接口
        BizResult<OilStationDescriptionInfo> result = ruleDescriptionService.queryOilStationDescDetail(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        ruleDescriptionAssert(result.getInfo(),
                order.getPartnerId(), order.getPlatPartnerId(),
                stationId, dec);
        // 清除数据
        merchantTestBase.cleanGasOilStationDescriptionByStationId(stationId);
        merchantTestBase.cleanGasOilStationDescriptionByStationId(stationId1);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/ruleDescriptionServiceQueryOilStationDescDetailTestFailOne.csv")
    @DisplayName("查询今日油价说明信息描述--参数非法")
    public void ruleDescriptionServiceQueryOilStationDescDetailTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryOilStationDescriptionOrder order
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
        BizResult<OilStationDescriptionInfo> result = ruleDescriptionService.queryOilStationDescDetail(order);
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
            OilStationDescriptionInfo dec,
            String partnerId,
            String platPartnerId,
            String stationId,
            String description
    ) {
        assertEquals(partnerId, dec.getPartnerId());
        assertEquals(platPartnerId, dec.getPlatPartnerId());
        assertEquals(RuleDescriptionType.Description.code(), dec.getRuleType().code());
        assertEquals(stationId, dec.getStationId());
        assertEquals(description, dec.getDescription());
    }
}
