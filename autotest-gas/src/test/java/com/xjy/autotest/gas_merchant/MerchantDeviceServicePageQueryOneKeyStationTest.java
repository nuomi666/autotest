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
import com.xyb.adk.common.lang.result.PagedResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.gas.merchant.api.enums.*;
import com.xyb.gas.merchant.api.facade.MerchantDeviceService;
import com.xyb.gas.merchant.api.info.GoodsPriceInfo;
import com.xyb.gas.merchant.api.info.OneKeyStationInfo;
import com.xyb.gas.merchant.api.order.PageQueryOneKeyStationOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author nuomi
 * Created on 2019/11/08.
 */
public class MerchantDeviceServicePageQueryOneKeyStationTest extends SpringBootTestBase {

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
     * 1001.商家模式下的定位到多个油站，其中一个未开启一键加油，查询今日油价
     * 1002.商家油站模式下的定位到多个油站显示的油价
     */
    @AutoTest(file = "gas_merchant/merchantDeviceServicePageQueryOneKeyStationTestSuccess.csv")
    @DisplayName("分页查询今日油价--成功用例")
    public void merchantDeviceServicePageQueryOneKeyStationTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId, String partnerName, String model,
            String partnerId, String partnerId1,
            //油站
            String stationId, String stationId1,
            String stationName, String stationName1,
            String stationCode, String stationCode1,
            String stationStatus, String stationStatus1,
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
            PageQueryOneKeyStationOrder order
    ) {
        // 清除数据
        // 准备数据
        //商家
        gasMerchantInitDataBase.initGasMerchant(platPartnerId, partnerName, null, null, "1jlit8stfxpo11hge7qi",
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
        if (testId == 1001) {
            gasMerchantInitDataBase.initStationsWithLocation(platPartnerId, null, partnerId, partnerId1,
                    stationId, stationId1, stationName, stationName1, stationCode, stationCode1, order.getLongitude(),
                    order.getLongitude(), order.getLatitude(), order.getLatitude(),
                    stationStatus, stationStatus1);
        } else {
            gasMerchantInitDataBase.initStationsWithLocation(platPartnerId, platPartnerId, partnerId, partnerId1,
                    stationId, stationId1, stationName, stationName1, stationCode, stationCode1, order.getLongitude(),
                    order.getLongitude(), order.getLatitude(), order.getLatitude(),
                    stationStatus, stationStatus1);
        }
        //操作员
        gasMerchantInitDataBase.initGasMerchantUser(platPartnerId, userId, OID.newID(), UserType.DEVICE.code(), null,
                "123456"
                , "syy111");
        gasMerchantInitDataBase.initGasMerchantUser(platPartnerId, userId1, OID.newID(), UserType.DEVICE.code(), null
                , "123456"
                , "syy222");
        //终端
        gasMerchantInitDataBase.initGasMerchantDevice(platPartnerId, userId, deviceCode,
                UserLoginStatus.login.code());
        Map<String, Object> param = gasMerchantInitDataBase.initGasDeviceFunction(platPartnerId, userId, stationId,
                deviceCode);
        if (testId == 1002) {
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
        PagedResult<OneKeyStationInfo> result = merchantDeviceService.pageQueryOneKeyStation(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            oneKeyStationInfoAssert(result, 1, platPartnerId, partnerId, partnerId1, stationId, stationId1,
                    stationName, stationName1, stationCode, stationCode1,
                    order.getLongitude(), order.getLatitude(), goodsName, goodsCode, goodsName1, goodsCode1,
                    goodsName2, goodsCode2, goodsPrice, listedPrice,
                    goodsPrice1, listedPrice1, goodsPrice2, listedPrice2, userId, deviceCode, userId1, deviceCode1);
        }
        if (testId == 1002) {
            oneKeyStationInfoAssert(result, 2, platPartnerId, partnerId, partnerId1, stationId, stationId1,
                    stationName, stationName1, stationCode, stationCode1,
                    order.getLongitude(), order.getLatitude(), goodsName, goodsCode, goodsName1, goodsCode1,
                    goodsName2, goodsCode2, goodsPrice, listedPrice,
                    goodsPrice1, listedPrice1, goodsPrice2, listedPrice2, userId, deviceCode, userId1, deviceCode1);
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
    @AutoTest(file = "gas_merchant/merchantDeviceServicePageQueryOneKeyStationTestFailOne.csv")
    @DisplayName("分页查询今日油价--成功用例")
    public void merchantDeviceServicePageQueryOneKeyStationTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
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
        PagedResult<OneKeyStationInfo> result = merchantDeviceService.pageQueryOneKeyStation(order);
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
            PagedResult<OneKeyStationInfo> result,
            int count,
            // 业务参数
            String platPartnerId,
            String partnerId, String partnerId1,
            //油站
            String stationId, String stationId1,
            String stationName, String stationName1,
            String stationCode, String stationCode1,
            Double longitude, Double latitude,
            //油品
            String goodsName, String goodsCode,
            String goodsName1, String goodsCode1,
            String goodsName2, String goodsCode2,
            //油价
            Money goodsPrice, Money listedPrice,
            Money goodsPrice1, Money listedPrice1,
            Money goodsPrice2, Money listedPrice2,
            String userId, String deviceCode,
            String userId1, String deviceCode1
    ) {
        assertEquals(count, result.getInfoSize());
        for (OneKeyStationInfo info : result.getInfoList()) {
            assertEquals(platPartnerId, info.getPlatPartnerId());
            if (stationId.equals(info.getStationId())) {
                assertEquals(partnerId, info.getPartnerId());
                assertEquals(stationCode, info.getStationCode());
                assertEquals(stationName, info.getStationName());
                assertEquals(EnableStatus.ABLE, info.getStatus());
                assertEquals(null, info.getStationAddress());
                assertEquals(deviceCode, info.getDeviceCode());
                assertEquals(true, info.isOpen());
//                assertEquals(userId, info.getUserId());没有查询操作员表
//                assertEquals("用户名", info.getUserName());
                assertEquals(longitude, info.getLongitude());
                assertEquals(latitude, info.getLatitude());
                assertEquals(true, info.isReport());
                assertEquals(0.0, info.getDistance());
                assertEquals(null, info.getOilDescript());
                List<GoodsPriceInfo> goodsPriceInfos = info.getGoodsPriceInfos();
                List<String> codes = new ArrayList<>();
                for (GoodsPriceInfo goodsPriceInfo : goodsPriceInfos) {
                    assertEquals(GoodsType.OIL, goodsPriceInfo.getGoodsType());
                    codes.add(goodsPriceInfo.getGoodsCode());
                    if (goodsCode.equals(goodsPriceInfo.getGoodsCode())) {
                        assertEquals(goodsName, goodsPriceInfo.getGoodsName());
                        //  assertEquals(GoodsGroupType.GASOLINE, goodsPriceInfo.getGoodsGroupType());开发没返回
                        assertEquals(goodsPrice, goodsPriceInfo.getGoodsPrice());
                        assertEquals(listedPrice, goodsPriceInfo.getListedPrice());
                    }
                    if (goodsCode1.equals(goodsPriceInfo.getGoodsCode())) {
                        assertEquals(goodsName1, goodsPriceInfo.getGoodsName());
//                        assertEquals(GoodsGroupType.GASOLINE, goodsPriceInfo.getGoodsGroupType());
                        assertEquals(goodsPrice1, goodsPriceInfo.getGoodsPrice());
                        assertEquals(listedPrice1, goodsPriceInfo.getListedPrice());
                    }
                }
                assertTrue(codes.contains(goodsCode));
                assertTrue(codes.contains(goodsCode1));
            }
            if (stationId1.equals(info.getStationId())) {
                assertEquals(partnerId1, info.getPartnerId());
                assertEquals(stationCode1, info.getStationCode());
                assertEquals(stationName1, info.getStationName());
                assertEquals(EnableStatus.ABLE, info.getStatus());
                assertEquals(null, info.getStationAddress());
                assertEquals(deviceCode1, info.getDeviceCode());
                assertEquals(true, info.isOpen());
//                assertEquals(userId1, info.getUserId());
//                assertEquals("用户名", info.getUserName());
                assertEquals(longitude, info.getLongitude());
                assertEquals(latitude, info.getLatitude());
                assertEquals(true, info.isReport());
                assertEquals(0.0, info.getDistance());
                assertEquals(null, info.getOilDescript());
                List<GoodsPriceInfo> goodsPriceInfos = info.getGoodsPriceInfos();
                List<String> codes = new ArrayList<>();
                for (GoodsPriceInfo goodsPriceInfo : goodsPriceInfos) {
                    assertEquals(GoodsType.OIL, goodsPriceInfo.getGoodsType());
                    codes.add(goodsPriceInfo.getGoodsCode());
                    if (goodsCode.equals(goodsPriceInfo.getGoodsCode())) {
                        assertEquals(goodsName, goodsPriceInfo.getGoodsName());
//                        assertEquals(GoodsGroupType.GASOLINE, goodsPriceInfo.getGoodsGroupType());
                        assertEquals(goodsPrice, goodsPriceInfo.getGoodsPrice());
                        assertEquals(listedPrice, goodsPriceInfo.getListedPrice());
                    }
                    if (goodsCode2.equals(goodsPriceInfo.getGoodsCode())) {
                        assertEquals(goodsName2, goodsPriceInfo.getGoodsName());
//                        assertEquals(GoodsGroupType.DIESEL_OIL, goodsPriceInfo.getGoodsGroupType());
                        assertEquals(goodsPrice2, goodsPriceInfo.getGoodsPrice());
                        assertEquals(listedPrice2, goodsPriceInfo.getListedPrice());
                    }
                }
                assertTrue(codes.contains(goodsCode));
                assertTrue(codes.contains(goodsCode2));
            }
        }
    }
}
