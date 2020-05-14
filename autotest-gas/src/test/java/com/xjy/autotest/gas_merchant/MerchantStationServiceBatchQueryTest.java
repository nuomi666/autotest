package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.MerchantStationService;
import com.xyb.gas.merchant.api.info.MerchantStationInfo;
import com.xyb.gas.merchant.api.order.BatchQueryMerchantStationOrder;
import com.xyb.gas.merchant.api.result.BizCollectionResult;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/01/09.
 */
public class MerchantStationServiceBatchQueryTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantStationService merchantStationService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    /**
     * 1001.查询单个
     * 1002.查询多个
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceBatchQueryTestSuccess.csv")
    @DisplayName("批量查询油站信息--成功用例")
    public void merchantStationServiceBatchQueryTestSuccess(
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
            BatchQueryMerchantStationOrder order
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
        merchantTestBase.insertGasMerchantStation(0L, stationId2, partnerId, partnerId, stationName2, stationCode2,
                null, "ABLE", Byte.valueOf("0"), 500000L, 500100L, 500112L, "金开大道互联网产业园13幢3楼", 106.489838082,
                29.6219092167, null, null);
        // 测试过程
        List<String> stationIds = new ArrayList<String>();
        stationIds.add(stationId);
        if (testId == 1002) {
            stationIds.add(stationId1);
        }
        order.setStationIds(stationIds);
        // 调用接口
        BizCollectionResult<MerchantStationInfo> result = merchantStationService.batchQuery(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            assertEquals(1, result.getInfos().size());
            stationAssert(result.getInfos().iterator().next(),
                    partnerId, stationId, stationName, stationCode, "重庆市",
                    "市辖区", "渝北区", null, "ABLE",
                    "金开大道互联网产业园13幢3楼", 106.489838082, 29.6219092167);
        }
        if (testId == 1002) {
            assertEquals(2, result.getInfos().size());
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
            }
            assertTrue(stationIdsxx.contains(stationId));
            assertTrue(stationIdsxx.contains(stationId1));
        }
        // 清除数据
        merchantTestBase.cleanGasMerchantStationByStationId(stationId);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId1);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId2);
    }

    /**
     *
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceBatchQueryTestFailOne.csv")
    @DisplayName("批量查询油站信息--参数非法")
    public void merchantStationServiceBatchQueryTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String stationId,
            BatchQueryMerchantStationOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        List<String> stationIds = new ArrayList<String>();
        if (testId != 1001) {
            stationIds.add(stationId);
        }
        order.setStationIds(stationIds);
        if (testId == 1002) {
            order.setStationIds(null);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        BizCollectionResult<MerchantStationInfo> result = merchantStationService.batchQuery(order);
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
