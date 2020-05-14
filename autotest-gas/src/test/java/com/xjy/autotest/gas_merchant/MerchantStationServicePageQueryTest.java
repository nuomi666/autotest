package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.PagedResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.MerchantStationService;
import com.xyb.gas.merchant.api.info.MerchantStationInfo;
import com.xyb.gas.merchant.api.order.PageQueryMerchantStationOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/01/09.
 */
public class MerchantStationServicePageQueryTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantStationService merchantStationService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    /**
     * 1001.输入平台商ID查询，每页显示10条，显示第1页
     * 1002.输入平台商ID查询，每页显示2条，显示第1页
     * 1003.输入平台商ID和油站列表，每页显示10条，显示第1页
     * 1004.输入平台商ID和关键字查询，每页显示10条，显示第1页
     * 1005.未查询到数据
     */
    @AutoTest(file = "gas_merchant/merchantStationServicePageQueryTestSuccess.csv")
    @DisplayName("分页查询商户油站--成功用例")
    public void merchantStationServicePageQueryTestSuccess(
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
            String stationCode2, String stationId3,
            String stationName3, String stationCode3,
            PageQueryMerchantStationOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasMerchantStationByStationId(stationId);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId1);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId2);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId3);
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
        //干扰数据
        merchantTestBase.insertGasMerchantStation(0L, stationId3, partnerId1, partnerId1, stationName3, stationCode3,
                null, "ABLE", Byte.valueOf("0"), 500000L, 500100L, 500112L, "金开大道互联网产业园13幢3楼", 106.489838082,
                29.6219092167, null, null);
        // 测试过程
        List<String> stationIds = new ArrayList<String>();
        stationIds.add(stationId);
        if (testId == 1003 || testId == 1005) {
            order.setStationIds(stationIds);
        }
        // 调用接口
        PagedResult<MerchantStationInfo> result = merchantStationService.pageQuery(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            assertEquals(3, result.getInfoList().size());
            stationAssert(result.getInfoList().get(0),
                    partnerId, stationId2, stationName2, stationCode2, "重庆市",
                    "市辖区", "渝北区", null, "ABLE",
                    "金开大道互联网产业园13幢3楼", 106.489838082, 29.6219092167);
            stationAssert(result.getInfoList().get(1),
                    partnerId, stationId1, stationName1, stationCode1, "重庆市",
                    "市辖区", "渝北区", null, "ABLE",
                    "金开大道互联网产业园13幢3楼", 106.489838082, 29.6219092167);
            stationAssert(result.getInfoList().get(2),
                    partnerId, stationId, stationName, stationCode, "重庆市",
                    "市辖区", "渝北区", null, "ABLE",
                    "金开大道互联网产业园13幢3楼", 106.489838082, 29.6219092167);
        }
        if (testId == 1002) {
            assertEquals(2, result.getInfoList().size());
            stationAssert(result.getInfoList().get(0),
                    partnerId, stationId2, stationName2, stationCode2, "重庆市",
                    "市辖区", "渝北区", null, "ABLE",
                    "金开大道互联网产业园13幢3楼", 106.489838082, 29.6219092167);
            stationAssert(result.getInfoList().get(1),
                    partnerId, stationId1, stationName1, stationCode1, "重庆市",
                    "市辖区", "渝北区", null, "ABLE",
                    "金开大道互联网产业园13幢3楼", 106.489838082, 29.6219092167);
        }
        if (testId == 1003 || testId == 1004) {
            assertEquals(1, result.getInfoList().size());
            stationAssert(result.getInfoList().get(0),
                    partnerId, stationId, stationName, stationCode, "重庆市",
                    "市辖区", "渝北区", null, "ABLE",
                    "金开大道互联网产业园13幢3楼", 106.489838082, 29.6219092167);
        }
        if (testId == 1005) {
            assertEquals(0, result.getInfoList().size());
        }
        // 清除数据
        merchantTestBase.cleanGasMerchantStationByStationId(stationId);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId1);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId2);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId3);
    }

    /**
     *
     */
    @AutoTest(file = "gas_merchant/merchantStationServicePageQueryTestFailOne.csv")
    @DisplayName("分页查询商户油站--参数非法")
    public void merchantStationServicePageQueryTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            PageQueryMerchantStationOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPlatPartnerId(null);
            order.setPartnerId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        PagedResult<MerchantStationInfo> result = merchantStationService.pageQuery(order);
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
