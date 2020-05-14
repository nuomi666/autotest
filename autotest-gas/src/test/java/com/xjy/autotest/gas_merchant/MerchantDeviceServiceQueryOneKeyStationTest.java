package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.gas.merchant.api.enums.*;
import com.xyb.gas.merchant.api.facade.MerchantDeviceService;
import com.xyb.gas.merchant.api.info.GoodsPriceInfo;
import com.xyb.gas.merchant.api.info.OneKeyStationInfo;
import com.xyb.gas.merchant.api.info.QueryOneKeyStationInfo;
import com.xyb.gas.merchant.api.order.PageQueryOneKeyStationOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author nuomi
 * Created on 2019/11/14.
 */
public class MerchantDeviceServiceQueryOneKeyStationTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantDeviceService merchantDeviceService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    /**
     * 1001.指定范围内的一个油站
     * 1002.指定范围外的一个油站
     * 1003.指定范围内和指定范围外各一个油站
     * 1004.指定范围内多个油站
     * 1005.指定范围外多个油站，一键加油展示附近油站数量为1
     */
    @AutoTest(file = "gas_merchant/merchantDeviceServiceQueryOneKeyStationTestSuccess.csv")
    @DisplayName("查询一键加油油站--成功用例")
    public void merchantDeviceServiceQueryOneKeyStationTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId, String model,
            String partnerId, String partnerId1,
            //油站
            String stationId, String stationId1,
            String stationName, String stationName1,
            String stationCode, String stationCode1,
            String stationStatus, String stationStatus1,
            Double longitude, Double longitude1,
            Double latitude, Double latitude1,
            //油品
            String goodsName, String goodsCode,
            String goodsName1, String goodsCode1,
            String goodsName2, String goodsCode2,
            //油价
            String planId, String planId1, Date effectTime,
            Money goodsPrice, Money listedPrice,
            Money goodsPrice1, Money listedPrice1,
            Money goodsPrice2, Money listedPrice2,
            String userId, String deviceCode,
            String userId1, String deviceCode1,
            double dis, double dis1,
            PageQueryOneKeyStationOrder order
    ) {
        // 清除数据
        // 准备数据
        //商家
        gasMerchantInitDataBase.initGasMerchant(platPartnerId, null, null, null, "1jlit8stfxpo11hge7qi",
                "1jlit82lowpo11hge7qi", "1jlit82lpllo11hge7qi", model, null, "ABLE");
        //商家油号
        gasMerchantInitDataBase.initGasMerchantGoods(platPartnerId, GoodsGroupType.GASOLINE.code(),
                GoodsType.OIL.code(), goodsName, goodsCode,
                GoodsGroupType.GASOLINE.code(), GoodsType.OIL.code(), goodsName1, goodsCode1,
                GoodsGroupType.DIESEL_OIL.code(), GoodsType.OIL.code(), goodsName2,
                goodsCode2);
        //油站油号
        gasMerchantInitDataBase.initGasStationGoods(platPartnerId, stationId, goodsName, goodsCode, goodsName1,
                goodsCode1, null, null);
        gasMerchantInitDataBase.initGasStationGoods(platPartnerId, stationId1, goodsName, goodsCode, goodsName2,
                goodsCode2, null, null);
        //油站
        gasMerchantInitDataBase.initStationsWithLocation(platPartnerId, platPartnerId, partnerId, partnerId1,
                stationId, stationId1, stationName, stationName1, stationCode, stationCode1, longitude,
                longitude1, latitude, latitude1, stationStatus, stationStatus1);
        //操作员
        gasMerchantInitDataBase.initGasMerchantUser(platPartnerId, userId, OID.newID(), UserType.DEVICE.code(), null,
                "123456"
                , "syy111");
        gasMerchantInitDataBase.initGasMerchantUser(platPartnerId, userId1, OID.newID(), UserType.DEVICE.code(), null
                , "123456"
                , "syy222");
        //终端
        if (testId != 1002) {
            gasMerchantInitDataBase.initGasMerchantDevice(platPartnerId, userId, deviceCode,
                    UserLoginStatus.login.code());
            gasMerchantInitDataBase.initGasDeviceFunction(platPartnerId, userId, stationId,
                    deviceCode);
        }
        if (testId != 1001) {
            gasMerchantInitDataBase.initGasMerchantDevice(platPartnerId, userId1, deviceCode1,
                    UserLoginStatus.login.code());
            gasMerchantInitDataBase.initGasDeviceFunction(platPartnerId, userId1, stationId1,
                    deviceCode1);
        }
        //油价
        gasMerchantInitDataBase.initGasStationGoodsPrice(platPartnerId, stationId, planId, null, effectTime,
                goodsName, goodsCode, goodsPrice, listedPrice, goodsName1, goodsCode1, goodsPrice1, listedPrice1,
                null, null, null, null
        );
        gasMerchantInitDataBase.initGasStationGoodsPrice(platPartnerId, stationId1, planId1, null, effectTime,
                goodsName, goodsCode, goodsPrice, listedPrice, goodsName2, goodsCode2, goodsPrice2, listedPrice2,
                null, null, null, null
        );
        // 测试过程
        // 调用接口
        BizResult<QueryOneKeyStationInfo> result = merchantDeviceService.queryOneKeyStation(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        //500m内的油站
        List<OneKeyStationInfo> inStations = result.getInfo().getDistanceStationList();
        //500m外的油站
        List<OneKeyStationInfo> outStations = result.getInfo().getStationList();
        if (testId == 1001) {
            assertEquals(1, inStations.size());
            assertEquals(0, outStations.size());
            oneKeyStationInfoAssert(inStations, platPartnerId, partnerId, stationId, stationName, stationCode, null,
                    longitude, latitude, goodsName, goodsCode, goodsName1, goodsCode1,
                    goodsPrice, listedPrice, goodsPrice1, listedPrice1,
                    dis, null, deviceCode);
        }
        if (testId == 1002) {
            assertEquals(0, inStations.size());
            assertEquals(1, outStations.size());
            oneKeyStationInfoAssert(outStations, platPartnerId, partnerId, stationId1, stationName1, stationCode1, null,
                    longitude1, latitude1, goodsName, goodsCode, goodsName2, goodsCode2,
                    goodsPrice, listedPrice, goodsPrice2, listedPrice2,
                    dis1, null, deviceCode1);
        }
        if (testId == 1003) {
            assertEquals(1, inStations.size());
            assertEquals(1, outStations.size());
            oneKeyStationInfoAssert(inStations, platPartnerId, partnerId, stationId, stationName, stationCode, null,
                    longitude, latitude, goodsName, goodsCode, goodsName1, goodsCode1,
                    goodsPrice, listedPrice, goodsPrice1, listedPrice1,
                    dis, null, deviceCode);
            oneKeyStationInfoAssert(outStations, platPartnerId, partnerId, stationId1, stationName1, stationCode1, null,
                    longitude1, latitude1, goodsName, goodsCode, goodsName2, goodsCode2,
                    goodsPrice, listedPrice, goodsPrice2, listedPrice2,
                    dis1, null, deviceCode1);
        }
        if (testId == 1004) {
            assertEquals(2, inStations.size());
            assertEquals(0, outStations.size());
            oneKeyStationInfoAssert(inStations, platPartnerId, partnerId, stationId, stationName, stationCode, null,
                    longitude, latitude, goodsName, goodsCode, goodsName1, goodsCode1,
                    goodsPrice, listedPrice, goodsPrice1, listedPrice1,
                    dis, null, deviceCode);
            assertEquals(partnerId1, inStations.get(1).getPartnerId());
            assertEquals(stationId1, inStations.get(1).getStationId());
            assertEquals(stationCode1, inStations.get(1).getStationCode());
            assertEquals(stationName1, inStations.get(1).getStationName());
            assertEquals(EnableStatus.ABLE, inStations.get(1).getStatus());
            assertEquals(null, inStations.get(1).getStationAddress());
            assertEquals(deviceCode1, inStations.get(1).getDeviceCode());
            assertEquals(true, inStations.get(1).isOpen());
//            assertEquals(userId1, outStations.get(1).getUserId());
//            assertEquals("用户名", outStations.get(1).getUserName());
            assertEquals(longitude1, inStations.get(1).getLongitude());
            assertEquals(latitude1, inStations.get(1).getLatitude());
            assertEquals(true, inStations.get(1).isReport());
            assertEquals(dis1, inStations.get(1).getDistance());
            assertEquals(null, inStations.get(1).getOilDescript());
            List<GoodsPriceInfo> goodsPriceInfos1 = inStations.get(1).getGoodsPriceInfos();
            List<String> codes1 = new ArrayList<>();
            for (GoodsPriceInfo goodsPriceInfo : goodsPriceInfos1) {
                assertEquals(GoodsType.OIL, goodsPriceInfo.getGoodsType());
                codes1.add(goodsPriceInfo.getGoodsCode());
                if (goodsCode.equals(goodsPriceInfo.getGoodsCode())) {
                    assertEquals(goodsName, goodsPriceInfo.getGoodsName());
                    assertEquals(null, goodsPriceInfo.getGoodsGroupType());
                    assertEquals(goodsPrice, goodsPriceInfo.getGoodsPrice());
                    assertEquals(listedPrice, goodsPriceInfo.getListedPrice());
                }
                if (goodsCode2.equals(goodsPriceInfo.getGoodsCode())) {
                    assertEquals(goodsName2, goodsPriceInfo.getGoodsName());
                    assertEquals(null, goodsPriceInfo.getGoodsGroupType());
                    assertEquals(goodsPrice2, goodsPriceInfo.getGoodsPrice());
                    assertEquals(listedPrice2, goodsPriceInfo.getListedPrice());
                }
            }
            assertTrue(codes1.contains(goodsCode));
            assertTrue(codes1.contains(goodsCode2));
        }
        if (testId == 1005) {
            assertEquals(0, inStations.size());
            assertEquals(1, outStations.size());
            oneKeyStationInfoAssert(outStations, platPartnerId, partnerId, stationId, stationName, stationCode, null,
                    longitude, latitude, goodsName, goodsCode, goodsName1, goodsCode1,
                    goodsPrice, listedPrice, goodsPrice1, listedPrice1,
                    dis, null, deviceCode);
        }
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode2);
        gasMerchantTestBase.cleanGasMerchantGoodsByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasStationGoodsByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasMerchantStationByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasMerchantDeviceByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasMerchantDeviceFunctionByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasStationGoodsPricePlanByPlatPartnerId(platPartnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(platPartnerId);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode2);
        silverboltTestBase.cleanGasMerchantGoodsByPartnerId(platPartnerId);
        silverboltTestBase.cleanGasMerchantUserByUserId(userId);
        silverboltTestBase.cleanGasMerchantUserByUserId(userId1);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(platPartnerId);
        xybUserTestBase.cleanAccountByUserId(platPartnerId);
    }

    /**
     *
     */
    @AutoTest(file = "gas_merchant/merchantDeviceServiceQueryOneKeyStationTestFailOne.csv")
    @DisplayName("查询一键加油油站--参数非法")
    public void merchantDeviceServiceQueryOneKeyStationTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            PageQueryOneKeyStationOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setLatitude(null);
        }
        if (testId == 1002) {
            order.setLongitude(null);
        }
        if (testId == 1003) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        BizResult<QueryOneKeyStationInfo> result = merchantDeviceService.queryOneKeyStation(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }

    /**
     * 一键加油列表油价数据校验
     */
    private void oneKeyStationInfoAssert(
            // 基本参数
            List<OneKeyStationInfo> stationInfos,
            // 业务参数
            String platPartnerId,
            String partnerId,
            //油站
            String stationId, String stationName,
            String stationCode, String addr,
            Double longitude, Double latitude,
            //油品
            String goodsName, String goodsCode,
            String goodsName1, String goodsCode1,
            //油价
            Money goodsPrice, Money listedPrice,
            Money goodsPrice1, Money listedPrice1,
            double distance, String oilDescript, String deviceCode
    ) {
        assertEquals(platPartnerId, stationInfos.get(0).getPlatPartnerId());
        assertEquals(partnerId, stationInfos.get(0).getPartnerId());
        assertEquals(stationId, stationInfos.get(0).getStationId());
        assertEquals(stationCode, stationInfos.get(0).getStationCode());
        assertEquals(stationName, stationInfos.get(0).getStationName());
        assertEquals(EnableStatus.ABLE, stationInfos.get(0).getStatus());
        assertEquals(addr, stationInfos.get(0).getStationAddress());
        assertEquals(deviceCode, stationInfos.get(0).getDeviceCode());
        assertEquals(true, stationInfos.get(0).isOpen());
//            assertEquals(userId, inStations.get(0).getUserId());
//            assertEquals("用户名", inStations.get(0).getUserName());
        assertEquals(longitude, stationInfos.get(0).getLongitude());
        assertEquals(latitude, stationInfos.get(0).getLatitude());
        assertEquals(true, stationInfos.get(0).isReport());
        assertEquals(distance, stationInfos.get(0).getDistance());
        assertEquals(oilDescript, stationInfos.get(0).getOilDescript());
        List<GoodsPriceInfo> goodsPriceInfos = stationInfos.get(0).getGoodsPriceInfos();
        List<String> codes = new ArrayList<>();
        for (GoodsPriceInfo goodsPriceInfo : goodsPriceInfos) {
            assertEquals(GoodsType.OIL, goodsPriceInfo.getGoodsType());
            codes.add(goodsPriceInfo.getGoodsCode());
            if (goodsCode.equals(goodsPriceInfo.getGoodsCode())) {
                assertEquals(goodsName, goodsPriceInfo.getGoodsName());
                assertEquals(null, goodsPriceInfo.getGoodsGroupType());
                assertEquals(goodsPrice, goodsPriceInfo.getGoodsPrice());
                assertEquals(listedPrice, goodsPriceInfo.getListedPrice());
            }
            if (goodsCode1.equals(goodsPriceInfo.getGoodsCode())) {
                assertEquals(goodsName1, goodsPriceInfo.getGoodsName());
                assertEquals(null, goodsPriceInfo.getGoodsGroupType());
                assertEquals(goodsPrice1, goodsPriceInfo.getGoodsPrice());
                assertEquals(listedPrice1, goodsPriceInfo.getListedPrice());
            }
        }
        assertTrue(codes.contains(goodsCode));
        assertTrue(codes.contains(goodsCode1));
    }
}
