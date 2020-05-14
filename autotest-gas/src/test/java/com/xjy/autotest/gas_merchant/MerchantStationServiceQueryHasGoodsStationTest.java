package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.GoodsType;
import com.xyb.gas.merchant.api.facade.MerchantStationService;
import com.xyb.gas.merchant.api.info.MerchantStationInfo;
import com.xyb.gas.merchant.api.order.QueryHasGoodsStationOrder;
import com.xyb.gas.merchant.api.result.BizCollectionResult;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/01/08.
 */
public class MerchantStationServiceQueryHasGoodsStationTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantStationService merchantStationService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    /**
     * 即使传了油站id也是查询的所有，并且城市信息也没返回,分页也没做，估计这接口没啥用
     * 1001.传商户ID和一个油站查询，每页显示10条，显示第1页
     * 1002.传商户ID和多个油站查询，每页显示10条，显示第1页
     * 1003.只传商户ID查询，每页显示2条，显示第1页
     * 1004.只传商户ID查询，每页显示2条，显示第2页
     * 1005.未查询到数据
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceQueryHasGoodsStationTestSuccess.csv")
    @DisplayName("分页查询已分配了油品信息的所有油站列表--成功用例")
    public void merchantStationServiceQueryHasGoodsStationTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId,
            String stationId, String stationId1,
            String stationId2, String stationId3,
            String stationName, String stationName1,
            String stationName2, String stationCode,
            String stationCode1, String stationCode2,
            String goodsCode, String goodsName,
            QueryHasGoodsStationOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasMerchantStationByStationId(stationId);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId1);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId2);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId3);
        merchantTestBase.cleanGasStationGoodsByStationId(stationId);
        merchantTestBase.cleanGasStationGoodsByStationId(stationId1);
        merchantTestBase.cleanGasStationGoodsByStationId(stationId2);
        merchantTestBase.cleanGasStationGoodsByStationId(stationId3);
        // 准备数据
        Date rawAddTime = DateUtils.parseDate("2019-11-22");
        Date rawAddTime1 = DateUtils.parseDate("2019-12-22");
        Date rawAddTime2 = DateUtils.parseDate("2020-01-02");
        //油站
        merchantTestBase.insertGasMerchantStation(0L, stationId, partnerId, partnerId, stationName, stationCode, null
                , "ABLE", Byte.valueOf("0"), 500000L, 500100L, 500112L, "金开大道互联网产业园13幢3楼", 106.489838082,
                29.6219092167, rawAddTime, rawAddTime);
        merchantTestBase.insertGasMerchantStation(0L, stationId1, partnerId, partnerId, stationName1, stationCode1, null
                , "ABLE", Byte.valueOf("0"), 500000L, 500100L, 500112L, "金开大道互联网产业园13幢3楼", 106.489838082,
                29.6219092167, rawAddTime1, rawAddTime1);
        merchantTestBase.insertGasMerchantStation(0L, stationId2, partnerId, partnerId, stationName2, stationCode2, null
                , "ABLE", Byte.valueOf("0"), 500000L, 500100L, 500112L, "金开大道互联网产业园13幢3楼", 106.489838082,
                29.6219092167, rawAddTime2, rawAddTime2);
        //干扰数据(没分配油号的)
        merchantTestBase.insertGasMerchantStation(0L, stationId3, partnerId, partnerId, "干扰油站", "erro001", null
                , "ABLE", Byte.valueOf("0"), 500000L, 500100L, 500112L, "金开大道互联网产业园13幢3楼", 106.489838082,
                29.6219092167, null, null);
        //油站油品
        merchantTestBase.insertGasStationGoods(0L, partnerId, partnerId, stationId, goodsName, goodsCode,
                GoodsType.OIL.code(), null, null, null, null);
        merchantTestBase.insertGasStationGoods(0L, partnerId, partnerId, stationId1, goodsName, goodsCode,
                GoodsType.OIL.code(), null, null, null, null);
        merchantTestBase.insertGasStationGoods(0L, partnerId, partnerId, stationId2, goodsName, goodsCode,
                GoodsType.OIL.code(), null, null, null, null);
        // 测试过程
        List<String> stationIds = new ArrayList<String>();
        if (testId == 1001) {
            stationIds.add(stationId);
        }
        if (testId == 1002) {
            stationIds.add(stationId1);
            stationIds.add(stationId2);
        }
        if (testId == 1005) {
            stationIds.add(stationId3);
        }
        order.setStationIds(stationIds);
        // 调用接口
        BizCollectionResult<MerchantStationInfo> result = merchantStationService.queryHasGoodsStation(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001 || testId == 1002) {
            assertEquals(3, result.getInfos().size());
            List<String> stationIdsxx = new ArrayList<>();
            for (MerchantStationInfo station : result.getInfos()) {
                stationIdsxx.add(station.getStationId());
                if (stationId.equals(station.getStationId())) {
                    stationAssert(station, partnerId, stationId, stationName, stationCode,
                            null, null, null, null,
                            "金开大道互联网产业园13幢3楼", 106.489838082, 29.6219092167);
                }
                if (stationId1.equals(station.getStationId())) {
                    stationAssert(station, partnerId, stationId1, stationName1, stationCode1,
                            null, null, null, null,
                            "金开大道互联网产业园13幢3楼", 106.489838082, 29.6219092167);
                }
                if (stationId2.equals(station.getStationId())) {
                    stationAssert(station, partnerId, stationId2, stationName2, stationCode2,
                            null, null, null, null,
                            "金开大道互联网产业园13幢3楼", 106.489838082, 29.6219092167);
                }
            }
            assertTrue(stationIdsxx.contains(stationId));
            assertTrue(stationIdsxx.contains(stationId1));
            assertTrue(stationIdsxx.contains(stationId2));
        }
        if (testId == 1003) {
            assertEquals(2, result.getInfos().size());
            List<String> stationIdsxx = new ArrayList<>();
            for (MerchantStationInfo station : result.getInfos()) {
                stationIdsxx.add(station.getStationId());
                if (stationId1.equals(station.getStationId())) {
                    stationAssert(station, partnerId, stationId1, stationName1, stationCode1,
                            null, null, null, null,
                            "金开大道互联网产业园13幢3楼", 106.489838082, 29.6219092167);
                }
                if (stationId2.equals(station.getStationId())) {
                    stationAssert(station, partnerId, stationId2, stationName2, stationCode2,
                            null, null, null, null,
                            "金开大道互联网产业园13幢3楼", 106.489838082, 29.6219092167);
                }
            }
            assertTrue(stationIdsxx.contains(stationId1));
            assertTrue(stationIdsxx.contains(stationId2));
        }
        if (testId == 1004) {
            assertEquals(1, result.getInfos().size());
            stationAssert(result.getInfos().iterator().next(),
                    partnerId, stationId, stationName, stationCode,
                    null, null, null, null,
                    "金开大道互联网产业园13幢3楼", 106.489838082, 29.6219092167);
        }
        if (testId == 1005) {
            assertEquals(0, result.getInfos().size());
        }
        // 清除数据
        merchantTestBase.cleanGasMerchantStationByStationId(stationId);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId1);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId2);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId3);
        merchantTestBase.cleanGasStationGoodsByStationId(stationId);
        merchantTestBase.cleanGasStationGoodsByStationId(stationId1);
        merchantTestBase.cleanGasStationGoodsByStationId(stationId2);
        merchantTestBase.cleanGasStationGoodsByStationId(stationId3);
    }

    /**
     * 油站信息
     */
    private void stationAssert(MerchantStationInfo station,
                               String partnerId,
                               String id,
                               String name,
                               String code,
                               String province,
                               String city,
                               String district,
                               String phone,
                               String address,
                               Double longitude,
                               Double latitude
    ) {
        assertEquals(partnerId, station.getPlatPartnerId());
        assertEquals(partnerId, station.getPartnerId());
        assertEquals(id, station.getStationId());
        assertEquals(code, station.getStationCode());
        assertEquals(name, station.getStationName());
        assertEquals(address, station.getStationAddress());
        assertEquals(city, station.getCityName());
        assertEquals(district, station.getDistrictName());
        assertEquals(province, station.getProvinceName());
        assertEquals(phone, station.getPhoneNo());
        assertEquals("ABLE", station.getStatus().code());
        assertEquals(false, station.isConnectOilMachine());
        assertEquals(longitude, station.getLongitude());
        assertEquals(latitude, station.getLatitude());
    }
}
