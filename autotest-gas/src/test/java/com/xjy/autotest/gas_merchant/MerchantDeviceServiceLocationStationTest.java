package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.MerchantDeviceService;
import com.xyb.gas.merchant.api.order.LocationStationOrder;
import dal.model.gas_merchant.GasMerchantDeviceFunctionDO;
import dal.model.gas_merchant.GasMerchantStationDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author nuomi@xinyebang.com
 * Created on 2018/08/21.
 */
public class MerchantDeviceServiceLocationStationTest extends SpringBootTestBase {

    @Reference(version = "1.0")
    MerchantDeviceService merchantDeviceService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantDeviceServiceLocationStationTestSuccess.csv")
    @DisplayName("定位油站--成功用例")
    public void merchantDeviceServiceLocationStationTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId, String userId,
            LocationStationOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantDeviceFunctionByStationId(order.getStationId());
        // 准备数据
        //油站
        gasMerchantInitDataBase.initStationsWithOilGun(platPartnerId, order.getStationId(), null, null, null, null,
                "ABLE",
                null, null,
                null, null);
        //一键加油
        gasMerchantInitDataBase.initGasDeviceFunction(platPartnerId, userId, order.getStationId(),
                order.getDeviceCode());
        // 测试过程
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = merchantDeviceService.locationStation(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasMerchantStationDO> stations =
                gasMerchantTestBase.findGasMerchantStationByStationId(order.getStationId());
        List<GasMerchantDeviceFunctionDO> DeviceFunctions =
                gasMerchantTestBase.findGasMerchantDeviceFunctionByStationId(order.getStationId());
        assertTrue(stations.size() == 1);
        for (GasMerchantStationDO station : stations) {
            assertEquals(station.getLongitude(), order.getLongitude());
            assertEquals(station.getLatitude(), order.getLatitude());
        }
        for (GasMerchantDeviceFunctionDO DeviceFunction : DeviceFunctions) {
            assertEquals(DeviceFunction.getUserId(), order.getUserId());
        }
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantStationByStationId(order.getStationId());
        gasMerchantTestBase.cleanGasMerchantDeviceFunctionByStationId(order.getStationId());
        silverboltTestBase.cleanGasMerchantStationByStationId(order.getStationId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantDeviceServiceLocationStationTestFailOne.csv")
    @DisplayName("定位油站--参数非法")
    public void merchantDeviceServiceLocationStationTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            LocationStationOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setStationId(null);
        }
        if (testId == 1002) {
            order.setDeviceCode(null);
        }
        if (testId == 1003) {
            order.setUserId(null);
        }
        if (testId == 1004) {
            order.setLatitude(null);
        }
        if (testId == 1005) {
            order.setLongitude(null);
        }
        if (testId == 1006) {
            order.setGid(null);
        }
        if (testId == 1007) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantDeviceService.locationStation(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.未找到对应的油站
     * 1002.该油站未开启一键加油功能
     * 1003.该pos机未开启一键加油
     */
    @AutoTest(file = "gas_merchant/merchantDeviceServiceLocationStationTestFailTwo.csv")
    @DisplayName("定位油站--成功用例")
    public void merchantDeviceServiceLocationStationTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId, String userId,
            String stationId, String deviceCode,
            LocationStationOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantDeviceFunctionByStationId(order.getStationId());
        // 准备数据
        //油站
        if (testId != 1001) {
            gasMerchantInitDataBase.initStationsWithOilGun(platPartnerId, order.getStationId(), null, null,
                    null, null, "ABLE",
                    null, null, null, null);
        }
        //一键加油
        gasMerchantInitDataBase.initGasDeviceFunction(platPartnerId, userId, stationId,
                deviceCode);
        // 测试过程
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = merchantDeviceService.locationStation(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantStationByStationId(order.getStationId());
        gasMerchantTestBase.cleanGasMerchantStationByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantDeviceFunctionByStationId(order.getStationId());
        gasMerchantTestBase.cleanGasMerchantDeviceFunctionByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationId(order.getStationId());
    }
}
