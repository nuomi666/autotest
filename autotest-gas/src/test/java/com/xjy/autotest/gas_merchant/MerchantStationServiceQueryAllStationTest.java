package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.MerchantStationService;
import com.xyb.gas.merchant.api.info.MerchantStationInfo;
import com.xyb.gas.merchant.api.order.QueryAllStationOrder;
import com.xyb.gas.merchant.api.result.BizCollectionResult;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/01/09.
 */
public class MerchantStationServiceQueryAllStationTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantStationService merchantStationService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceQueryAllStationTestSuccess.csv")
    @DisplayName("查询全量油站信息--成功用例")
    public void merchantStationServiceQueryAllStationTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String partnerId1,
            String stationId, String stationName,
            String stationCode, String stationId1,
            String stationName1, String stationCode1,
            String stationId2, String stationName2,
            String stationCode2,
            QueryAllStationOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasMerchantStationByStationId(stationId);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId1);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId2);
        // 准备数据
        merchantTestBase.insertGasMerchantStation(0L, stationId, partnerId, partnerId, stationName, stationCode,
                null, "ABLE", Byte.valueOf("0"), 500000L, 500100L, 500112L, "金开大道互联网产业园13幢3楼", 106.489838082,
                29.6219092167, null, null);
        merchantTestBase.insertGasMerchantStation(0L, stationId1, partnerId, partnerId, stationName1, stationCode1,
                null, "ABLE", Byte.valueOf("0"), 500000L, 500100L, 500112L, "金开大道互联网产业园13幢3楼", 106.489838082,
                29.6219092167, null, null);
        merchantTestBase.insertGasMerchantStation(0L, stationId2, partnerId1, partnerId1, stationName2, stationCode2,
                null, "ABLE", Byte.valueOf("0"), 500000L, 500100L, 500112L, "金开大道互联网产业园13幢3楼", 106.489838082,
                29.6219092167, null, null);
        // 测试过程
        // 调用接口
        BizCollectionResult<MerchantStationInfo> result = merchantStationService.queryAllStation(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        assertEquals(3, result.getInfos().size());
        List<String> stationIdsxx = new ArrayList<>();
        for (MerchantStationInfo station : result.getInfos()) {
            stationIdsxx.add(station.getStationId());
            if (stationId.equals(station.getStationId())) {
                stationAssert(station,
                        partnerId, stationId, stationName, stationCode, "重庆市",
                        "市辖区", "渝北区", null, "ABLE",
                        "金开大道互联网产业园13幢3楼", 106.489838082, 29.6219092167);
            }
            if (stationId1.equals(station.getStationId())) {
                stationAssert(station,
                        partnerId, stationId1, stationName1, stationCode1, "重庆市",
                        "市辖区", "渝北区", null, "ABLE",
                        "金开大道互联网产业园13幢3楼", 106.489838082, 29.6219092167);
            }
            if (stationId2.equals(station.getStationId())) {
                stationAssert(station,
                        partnerId1, stationId2, stationName2, stationCode2, "重庆市",
                        "市辖区", "渝北区", null, "ABLE",
                        "金开大道互联网产业园13幢3楼", 106.489838082, 29.6219092167);
            }
        }
        assertTrue(stationIdsxx.contains(stationId));
        assertTrue(stationIdsxx.contains(stationId1));
        assertTrue(stationIdsxx.contains(stationId2));
        // 清除数据
        merchantTestBase.cleanGasMerchantStationByStationId(stationId);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId1);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId2);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceQueryAllStationTestFailOne.csv")
    @DisplayName("查询全量油站信息--参数非法")
    public void merchantStationServiceQueryAllStationTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryAllStationOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setGid(null);
        }
        if (testId == 1002) {
            order = null;
        }
        // 调用接口
        BizCollectionResult<MerchantStationInfo> result = merchantStationService.queryAllStation(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 油站信息
     */
    private void stationAssert(MerchantStationInfo stationInfo,
                               String partnerId,
                               String stationId,
                               String stationName,
                               String stationCode,
                               String provinceName,
                               String cityName,
                               String districtName,
                               String phoneNo,
                               String status,
                               String stationAddress,
                               Double longitude,
                               Double latitude
    ) {
        assertEquals(partnerId, stationInfo.getPlatPartnerId());
        assertEquals(partnerId, stationInfo.getPartnerId());
        assertEquals(stationId, stationInfo.getStationId());
        assertEquals(stationName, stationInfo.getStationName());
        assertEquals(stationCode, stationInfo.getStationCode());
        assertEquals(provinceName, stationInfo.getProvinceName());
        assertEquals(cityName, stationInfo.getCityName());
        assertEquals(districtName, stationInfo.getDistrictName());
        assertEquals(phoneNo, stationInfo.getPhoneNo());
        assertEquals(status, stationInfo.getStatus().code());
        assertEquals(false, stationInfo.isConnectOilMachine());
        assertEquals(stationAddress, stationInfo.getStationAddress());
        assertEquals(latitude, stationInfo.getLatitude());
        assertEquals(longitude, stationInfo.getLongitude());
    }
}
