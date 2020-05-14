package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.MerchantStationService;
import com.xyb.gas.merchant.api.order.ChangeMerchantStationStatusOrder;
import dal.model.gas_merchant.GasMerchantStationDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


/**
 * @author nuomi@xyb.com
 * Created on 2018/09/28.
 */
public class MerchantStationServiceChangeStatusTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantStationService merchantStationService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceChangeStatusTestSuccess.csv")
    @DisplayName("修改油站状态--成功用例")
    public void merchantStationServiceChangeStatusTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String stationStatus,
            ChangeMerchantStationStatusOrder order
    ) {
        // 清除数据
        // 准备数据
        Date rawAddTime = DateUtils.parseDate2("2019-11-20 14:19:47");
        gasMerchantInitDataBase.initStationsWithOilGun(partnerId, order.getId(), "测试油站", "test001",
                null, stationStatus, null, null, null, rawAddTime, rawAddTime);
        // 测试过程
        // 调用接口
        SimpleResult result = merchantStationService.changeStatus(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        GasMerchantStationDO stationInfo = merchantTestBase.findGasMerchantStationByStationId(order.getId()).get(0);
        sleep(3);
        dal.model.gas_silverbolt.GasMerchantStationDO stationInfoxx =
                silverboltTestBase.findGasMerchantStationByStationId(order.getId()).get(0);
        assertEquals(order.getStatus().code(), stationInfo.getStatus());
        assertNotEquals(rawAddTime, stationInfo.getRawUpdateTime());
        assertEquals(order.getStatus().code(), stationInfoxx.getStatus());
        assertNotEquals(rawAddTime, stationInfoxx.getRawUpdateTime());
        // 清除数据
        merchantTestBase.cleanGasMerchantStationByStationId(order.getId());
        silverboltTestBase.cleanGasMerchantStationByStationId(order.getId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceChangeStatusTestFailOne.csv")
    @DisplayName("修改油站状态--参数非法")
    public void merchantStationServiceChangeStatusTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ChangeMerchantStationStatusOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setStatus(null);
        }
        if (testId == 1002) {
            order.setId(null);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantStationService.changeStatus(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.油站不存在
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceChangeStatusTestFailTwo.csv")
    @DisplayName("修改油站状态--失败用例")
    public void merchantStationServiceChangeStatusTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ChangeMerchantStationStatusOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        SimpleResult result = merchantStationService.changeStatus(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
