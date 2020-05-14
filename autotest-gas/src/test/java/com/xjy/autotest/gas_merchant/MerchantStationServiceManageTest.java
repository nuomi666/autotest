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
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.DateUtil;
import com.xyb.gas.merchant.api.enums.GoodsGroupType;
import com.xyb.gas.merchant.api.enums.GoodsType;
import com.xyb.gas.merchant.api.facade.MerchantStationService;
import com.xyb.gas.merchant.api.order.ManageMerchantStationOrder;
import dal.model.gas_merchant.GasMerchantStationDO;
import dal.model.gas_merchant.GasStationGoodsDO;
import dal.model.gas_merchant.GasStationOilGunDO;
import dal.model.merchant.MerchantInfoDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author nuomi
 * Created on 2020/01/08.
 */
public class MerchantStationServiceManageTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantStationService merchantStationService;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceManageTestSuccess.csv")
    @DisplayName("商户油站管理--成功用例")
    public void merchantStationServiceManageTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String stationName, String stationCode,
            String phoneNo, String goodsName,
            String goodsCode, String goodsName1,
            String goodsCode1,
            ManageMerchantStationOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        merchantTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        merchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
        merchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode1);
        merchantTestBase.cleanGasMerchantStationByPlatPartnerId(order.getPlatPartnerId());
        merchantTestBase.cleanGasMerchantStationByStationName(order.getStationName());
        merchantTestBase.cleanGasStationOilGunByStationId(order.getStationId());
        merchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(order.getStationId(), goodsCode);
        merchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(order.getStationId(), goodsCode1);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode1);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(order.getPlatPartnerId());
        xybMerchantTestBase.cleanMerchantInfoByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        //商家
        if (testId == 1002) {
            gasMerchantInitDataBase.initGasMerchant(order.getPlatPartnerId(), "糯米测试商家", "wxa2557eabb23b47e8",
                    "测试商家", OID.newID(), OID.newID(),
                    OID.newID(), "MerchantAndStation", null, "ABLE");
        } else {
            gasMerchantInitDataBase.initGasMerchant(order.getPlatPartnerId(), "糯米测试商家", "wxa2557eabb23b47e8",
                    "测试商家", OID.newID(), OID.newID(),
                    OID.newID(), "Merchant", null, "ABLE");
        }
        //商家商品
        gasMerchantInitDataBase.initGasMerchantGoods(order.getPlatPartnerId(),
                GoodsGroupType.GASOLINE.code(), GoodsType.OIL.code(),
                goodsName, goodsCode, GoodsGroupType.GASOLINE.code(),
                GoodsType.OIL.code(), goodsName1, goodsCode1,
                null, null, null, null);
        if (testId >= 1003) {
            merchantTestBase.insertGasMerchantStation(0L, order.getStationId(), order.getPlatPartnerId(),
                    order.getPartnerId(), stationName, stationCode,
                    phoneNo, "ABLE", Byte.valueOf("0"), 500000L, 500100L, 500112L, "金开大道互联网产业园13幢3楼", 106.489838082,
                    29.6219092167, null, null);
            silverboltTestBase.insertGasMerchantStation(0L, order.getPlatPartnerId(), order.getPartnerId(),
                    order.getStationId(), stationName, stationCode,
                    phoneNo, "ABLE", Byte.valueOf("0"), 500000L, "重庆市", 500100L, "市辖区", 500112L, "渝北区",
                    "金开大道互联网产业园13幢3" +
                            "楼", 106.489838082, 29.6219092167, null,
                    null, null, null);
        }
        if (testId == 1004) {//分配给油站的油品
            merchantTestBase.insertGasStationOilGun(0L, order.getPlatPartnerId(), order.getPartnerId(),
                    order.getStationId(), "1", goodsCode,
                    null, null, 1);
            merchantTestBase.insertGasStationGoods(0L, order.getPlatPartnerId(), order.getPartnerId(),
                    order.getStationId(), goodsName, goodsCode,
                    GoodsType.OIL.code(), null, null, null, null);
        }

        // 测试过程
        Set<String> goodsCodeList = new HashSet<>();
        goodsCodeList.add(goodsCode1);
        order.setGoodsCodeList(goodsCodeList);
        // 调用接口
        SimpleResult result = merchantStationService.manage(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        //        assertEquals(code, result.getCode());
        // 数据验证
        //油站
        List<GasMerchantStationDO> stations =
                merchantTestBase.findGasMerchantStationByStationName(order.getStationName());
        String stationId = stations.get(0).getStationId();
        stationAssert(stations.get(0),
                order.getPlatPartnerId(), order.getPartnerId(),
                stationId, order.getStationName(), order.getStationCode(),
                order.getProvinceId(), order.getCityId(),
                order.getDistrictId(), order.getPhoneNo(),
                order.getStationAddress(), null, null);
        sleep(3);
        List<dal.model.gas_silverbolt.GasMerchantStationDO> stationsxx =
                silverboltTestBase.findGasMerchantStationByStationId(stationId);
        silverboltStationAssert(stationsxx.get(0),
                order.getPlatPartnerId(), order.getPartnerId(),
                stationId, order.getStationName(), order.getStationCode(),
                order.getProvinceId(), "四川省", order.getCityId(),
                "成都市", order.getDistrictId(),
                "锦江区", order.getPhoneNo(),
                order.getStationAddress(), null, null);
        //商品
        List<GasStationGoodsDO> goodsInfos =
                merchantTestBase.findGasStationGoodsByStationId(stationId);
        oilAssert(goodsInfos.get(0),
                order.getPlatPartnerId(), order.getPartnerId(),
                stationId, goodsCode1, goodsName1);
        //油枪
        if (testId == 1004) {//删除配置的油号时会删除对应的油枪
            List<GasStationOilGunDO> oilGuns = merchantTestBase.findGasStationOilGunByStationId(stationId);
            assertEquals(0, oilGuns.size());
        }
        //清结算商户信息
        List<MerchantInfoDO> merchantInfos =
                xybMerchantTestBase.findMerchantInfoByPartnerId(stations.get(0).getPartnerId());
        if (testId == 1002) {
            xybMerchantByplatPartnerId(merchantInfos.get(0), order.getPlatPartnerId(), stations.get(0).getPartnerId(),
                    order.getStationName(), order.getStationName(), "PARTNER");
        }
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(order.getPlatPartnerId());
        xybMerchantTestBase.cleanMerchantInfoByPlatPartnerId(order.getPlatPartnerId());
        xybUserTestBase.cleanUserByUserId(order.getPlatPartnerId());
        xybUserTestBase.cleanAccountByUserId(order.getPlatPartnerId());
        merchantTestBase.cleanGasMerchantByPlatPartnerId(order.getPlatPartnerId());
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(order.getPlatPartnerId());
        merchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        merchantTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        merchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
        merchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode1);
        merchantTestBase.cleanGasMerchantStationByPlatPartnerId(order.getPlatPartnerId());
        merchantTestBase.cleanGasMerchantStationByStationId(stationId);
        merchantTestBase.cleanGasStationOilGunByStationId(order.getStationId());
        merchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId, goodsCode);
        merchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId, goodsCode1);
        silverboltTestBase.cleanGasMerchantByPartnerId(order.getPlatPartnerId());
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode1);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceManageTestFailOne.csv")
    @DisplayName("商户油站管理--参数非法")
    public void merchantStationServiceManageTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String goodsCode1,
            ManageMerchantStationOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        Set<String> goodsCodeList = new HashSet<>();
        goodsCodeList.add(goodsCode1);
        order.setGoodsCodeList(goodsCodeList);
        if (testId == 1001) {
            order.setPlatPartnerId(null);
            order.setPartnerId(null);
        }
        if (testId == 1002) {
            order.setStationName(null);
        }
        if (testId == 1003) {
            order.setStationCode(null);
        }
        if (testId == 1004) {
            order.setPhoneNo(null);
        }
        if (testId == 1005) {
            order.setProvinceId(null);
        }
        if (testId == 1006) {
            order.setCityId(null);
        }
        if (testId == 1007) {
            order.setDistrictId(null);
        }
        if (testId == 1008) {
            order.setStationAddress(null);
        }
        if (testId == 1009) {
            order.setGid(null);
        }
        if (testId == 1010) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantStationService.manage(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        //        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.新增时已存在相同的油站编码
     * 1002.修改的油站不存在
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceManageTestFailTwo.csv")
    @DisplayName("商户油站管理--失败用例")
    public void merchantStationServiceManageTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String stationName, String stationId,
            String phoneNo, String goodsName,
            String goodsCode, String goodsName1,
            String goodsCode1,
            ManageMerchantStationOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        merchantTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        merchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
        merchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode1);
        merchantTestBase.cleanGasMerchantStationByPlatPartnerId(order.getPlatPartnerId());
        merchantTestBase.cleanGasMerchantStationByStationName(order.getStationName());
        merchantTestBase.cleanGasStationOilGunByStationId(order.getStationId());
        merchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(order.getStationId(), goodsCode);
        merchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(order.getStationId(), goodsCode1);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode1);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(order.getPlatPartnerId());
        xybMerchantTestBase.cleanMerchantInfoByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        //商家
        gasMerchantInitDataBase.initGasMerchant(order.getPlatPartnerId(), "糯米测试商家", "wxa2557eabb23b47e8",
                "测试商家", OID.newID(), OID.newID(),
                OID.newID(), "Merchant", null, "ABLE");
        //商家商品
        gasMerchantInitDataBase.initGasMerchantGoods(order.getPlatPartnerId(),
                GoodsGroupType.GASOLINE.code(), GoodsType.OIL.code(),
                goodsName, goodsCode, GoodsGroupType.GASOLINE.code(),
                GoodsType.OIL.code(), goodsName1, goodsCode1,
                null, null, null, null);
        if (testId == 1001) {
            merchantTestBase.insertGasMerchantStation(0L, stationId, order.getPlatPartnerId(),
                    order.getPartnerId(), stationName, order.getStationCode(),
                    phoneNo, "ABLE", Byte.valueOf("0"), 500000L, 500100L, 500112L, "金开大道互联网产业园13幢3楼", 106.489838082,
                    29.6219092167, null, null);
            silverboltTestBase.insertGasMerchantStation(0L, order.getPlatPartnerId(), order.getPartnerId(),
                    stationId, stationName, order.getStationCode(),
                    phoneNo, "ABLE", Byte.valueOf("0"), 500000L, "重庆市", 500100L, "市辖区", 500112L, "渝北区",
                    "金开大道互联网产业园13幢3" +
                            "楼", 106.489838082, 29.6219092167, null,
                    null, null, null);
        }
        if (testId == 1001) {//分配给油站的油品
            merchantTestBase.insertGasStationOilGun(0L, order.getPlatPartnerId(), order.getPartnerId(),
                    stationId, "1", goodsCode,
                    null, null, 1);
            merchantTestBase.insertGasStationGoods(0L, order.getPlatPartnerId(), order.getPartnerId(),
                    stationId, goodsName, goodsCode,
                    GoodsType.OIL.code(), null, null, null, null);
        }

        // 测试过程
        Set<String> goodsCodeList = new HashSet<>();
        goodsCodeList.add(goodsCode1);
        order.setGoodsCodeList(goodsCodeList);
        // 调用接口
        SimpleResult result = merchantStationService.manage(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        //        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(order.getPlatPartnerId());
        xybMerchantTestBase.cleanMerchantInfoByPlatPartnerId(order.getPlatPartnerId());
        xybUserTestBase.cleanAccountByUserId(order.getPlatPartnerId());
        merchantTestBase.cleanGasMerchantByPlatPartnerId(order.getPlatPartnerId());
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(order.getPlatPartnerId());
        merchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        merchantTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        merchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
        merchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode1);
        merchantTestBase.cleanGasMerchantStationByPlatPartnerId(order.getPlatPartnerId());
        merchantTestBase.cleanGasMerchantStationByStationId(stationId);
        merchantTestBase.cleanGasStationOilGunByStationId(order.getStationId());
        merchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId, goodsCode);
        merchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId, goodsCode1);
        silverboltTestBase.cleanGasMerchantByPartnerId(order.getPlatPartnerId());
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode1);
    }

    /**
     * 油站信息
     */
    private void stationAssert(GasMerchantStationDO stationInfo,
                               String platPartnerId,
                               String partnerId,
                               String stationId,
                               String stationName,
                               String stationCode,
                               Long provinceId,
                               Long cityId,
                               Long districtId,
                               String phoneNo,
                               String stationAddress,
                               Double longitude,
                               Double latitude
    ) {
        assertEquals(platPartnerId, stationInfo.getPlatPartnerId());
//        assertEquals(partnerId, stationInfo.getPartnerId());油站模式时为自动生成的
        assertEquals(stationId, stationInfo.getStationId());
        assertEquals(stationName, stationInfo.getStationName());
        assertEquals(stationCode, stationInfo.getStationCode());
        assertEquals(provinceId, stationInfo.getProvinceId());
        assertEquals(cityId, stationInfo.getCityId());
        assertEquals(districtId, stationInfo.getDistrictId());
        assertEquals(phoneNo, stationInfo.getPhoneNo());
        assertEquals("ABLE", stationInfo.getStatus());
        assertEquals(Byte.valueOf("0"), stationInfo.getConnectOilMachine());
        assertEquals(stationAddress, stationInfo.getStationAddress());
        //定位成功就是网关返回的值，失败则为空
//        assertEquals(null, stationInfo.getLatitude());
//        assertEquals(null, stationInfo.getLongitude());
    }

    /**
     * 油站信息
     */
    private void silverboltStationAssert(dal.model.gas_silverbolt.GasMerchantStationDO stationInfo,
                                         String platPartnerId,
                                         String partnerId,
                                         String stationId,
                                         String stationName,
                                         String stationCode,
                                         Long provinceId,
                                         String provinceName,
                                         Long cityId,
                                         String cityName,
                                         Long districtId,
                                         String districtName,
                                         String phoneNo,
                                         String stationAddress,
                                         Double longitude,
                                         Double latitude
    ) {
        assertEquals(platPartnerId, stationInfo.getPlatPartnerId());
        assertEquals(partnerId, stationInfo.getPartnerId());
        assertEquals(stationId, stationInfo.getStationId());
        assertEquals(stationName, stationInfo.getStationName());
        assertEquals(stationCode, stationInfo.getStationCode());
        assertEquals(provinceId, stationInfo.getProvinceId());
        assertEquals(provinceName, stationInfo.getProvinceName());
        assertEquals(cityId, stationInfo.getCityId());
        assertEquals(cityName, stationInfo.getCityName());
        assertEquals(districtId, stationInfo.getDistrictId());
        assertEquals(districtName, stationInfo.getDistrictName());
        assertEquals(phoneNo, stationInfo.getPhoneNo());
        assertEquals("ABLE", stationInfo.getStatus());
        assertEquals(Byte.valueOf("0"), stationInfo.getConnectOilMachine());
        assertEquals(stationAddress, stationInfo.getStationAddress());
        //定位成功就是网关返回的值，失败则为空
//        assertEquals(null, stationInfo.getLatitude());
//        assertEquals(null, stationInfo.getLongitude());
    }

    /**
     * 油品信息
     */
    private void oilAssert(GasStationGoodsDO oil,
                           String platPartnerId,
                           String partnerId,
                           String stationId,
                           String goodsCode,
                           String goodsName
    ) {
        assertEquals(platPartnerId, oil.getPlatPartnerId());
        assertEquals(partnerId, oil.getPartnerId());
        assertEquals(stationId, oil.getStationId());
        assertEquals(goodsCode, oil.getGoodsCode());
        assertEquals(goodsName, oil.getGoodsName());
        assertEquals(GoodsType.OIL.code(), oil.getGoodsType());
        assertEquals("ABLE", oil.getStatus());
        assertEquals(null, oil.getOrderNo());
    }

    /**
     * 断言清结算商户信息
     */
    private void xybMerchantByplatPartnerId(MerchantInfoDO info, String platPartnerId,
                                            String partnerId,
                                            String partnerName, String shortName,
                                            String partnerType) {
        assertEquals(partnerId, info.getPartnerId());
        assertEquals(platPartnerId, info.getPlatPartnerId());
        assertEquals(null, info.getIndustryLine());
        assertEquals(null, info.getOutPartnerId());
        assertEquals(partnerName, info.getPartnerName());
        assertEquals(shortName, info.getPartnerAbbrName());
        assertEquals(null, info.getPartnerRegisterAddress());
        assertEquals("INSIDE", info.getRegisterFrom());
        assertEquals(partnerType, info.getPartnerType());
        assertEquals("ACTIVE", info.getPartnerStatus());
//        assertEquals(realName, merchantInfos.get(0).getSecurityCode());
        assertEquals(null, info.getOwnService());
        assertEquals("MD5", info.getDigestType());
        assertEquals(DateUtil.dtSimpleFormat(info.getRawAddTime()),
                DateUtil.dtSimpleFormat(info.getRawUpdateTime()));
    }
}
