package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.CollectionModel;
import com.xyb.gas.merchant.api.enums.EnableStatus;
import com.xyb.gas.merchant.api.enums.SourceType;
import com.xyb.gas.merchant.api.facade.MerchantTradePayService;
import com.xyb.gas.merchant.api.info.MerchantAndStationInfo;
import com.xyb.gas.merchant.api.info.MerchantInfo;
import com.xyb.gas.merchant.api.info.MerchantStationInfo;
import com.xyb.gas.merchant.api.order.QueryMerchantAndStationOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author nuomi
 * Created on 2019/12/18.
 */
public class MerchantTradePayServiceQueryMerchantAndStationTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantTradePayService merchantTradePayService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    /**
     * 场景：公众号交易
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantTradePayServiceQueryMerchantAndStationTestSuccess.csv")
    @DisplayName("验证并获取商户及油站信息--成功用例")
    public void merchantTradePayServiceQueryMerchantAndStationTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String partnerName,
            String shortName, String mobile,
            String sourceKey, String merchantStatus,
            String stationId, String stationName,
            String stationCode, Double longitude, Double latitude,
            QueryMerchantAndStationOrder order
    ) {
        // 清除数据
        // 准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date rawAddTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -3, -4, 0, 0);
        //商家信息
        gasMerchantInitDataBase.initGasMerchants(partnerId, null, partnerName, null, shortName, null, mobile, null,
                sourceKey, null, merchantStatus, null, "Merchant", null, rawAddTime, null);
        //油站
        gasMerchantInitDataBase.initStationsWithLocation(partnerId, null, partnerId, null,
                stationId, null, stationName, null,
                stationCode, null, longitude, null,
                latitude, null, "ABLE", null);
        // 测试过程
        order.setStationId(stationId);
        // 调用接口
        BizResult<MerchantAndStationInfo> result = merchantTradePayService.queryMerchantAndStation(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        MerchantInfo merchant = result.getInfo().getMerchantInfo();
        MerchantStationInfo station = result.getInfo().getMerchantStationInfo();
        //商家信息
        merchantAssert(merchant, partnerId, partnerName, shortName,
                mobile, "1jc7w1m29ks031hge7p8", "001iys5hlniks541g00",
                null, null, null,
                "0*60*60*1000+0*60*1000+0" + "*1000", "1",
                rawAddTime, SourceType.WeChat, sourceKey, false, null, CollectionModel.Merchant);
        //油站信息
        stationAssert(station, partnerId, stationId, stationCode, stationName,
                "重庆市", "市辖区", "渝北区", null,
                "金开大道互联网产业园13幢3楼", longitude, latitude);
        // 清除数据
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId);
        merchantTestBase.cleanGasMerchantUserStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantUserStationByStationId(stationId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantTradePayServiceQueryMerchantAndStationTestFailOne.csv")
    @DisplayName("验证并获取商户及油站信息--参数非法")
    public void merchantTradePayServiceQueryMerchantAndStationTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryMerchantAndStationOrder order
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
        BizResult<MerchantAndStationInfo> result = merchantTradePayService.queryMerchantAndStation(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.商家不存在
     * 1002.用户不存在
     * 1003.油站不是该商户下的
     */
    @AutoTest(file = "gas_merchant/merchantTradePayServiceQueryMerchantAndStationTestFailTwo.csv")
    @DisplayName("验证并获取商户及油站信息--失败用例")
    public void merchantTradePayServiceQueryMerchantAndStationTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String partnerId1, String partnerName,
            String shortName, String mobile,
            String sourceKey, String merchantStatus,
            String stationId, String stationName,
            String stationCode, Double longitude, Double latitude,
            QueryMerchantAndStationOrder order
    ) {
        // 清除数据
        // 准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date rawAddTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -3, -4, 0, 0);
        //商家信息
        if (testId != 1001) {
            gasMerchantInitDataBase.initGasMerchants(partnerId, null, partnerName, null, shortName, null, mobile, null,
                    sourceKey, null, merchantStatus, null, "Merchant", null, rawAddTime, null);
        }
        //油站
        if (testId == 1003) {
            gasMerchantInitDataBase.initStationsWithLocation(partnerId1, null, partnerId, null,
                    stationId, null, stationName, null,
                    stationCode, null, longitude, null,
                    latitude, null, "ABLE", null);
        } else {
            gasMerchantInitDataBase.initStationsWithLocation(partnerId, null, partnerId, null,
                    stationId, null, stationName, null,
                    stationCode, null, longitude, null,
                    latitude, null, "ABLE", null);
        }
        // 测试过程
        if (testId != 1002) {
            order.setStationId(stationId);
        }
        // 调用接口
        BizResult<MerchantAndStationInfo> result = merchantTradePayService.queryMerchantAndStation(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId1);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId);
        merchantTestBase.cleanGasMerchantUserStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId1);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantUserStationByStationId(stationId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
    }

    /**
     * 商户信息
     */
    private void merchantAssert(MerchantInfo merchant,
                                String platPartnerId,
                                String partnerName,
                                String shortName,
                                String mobileNo,
                                String accountNo,
                                String marketAccountNo,
                                String email,
                                String headImgUrl,
                                Date queryDepth,
                                String dayTime,
                                String monthTime,
                                Date rawAddTime,
                                SourceType sourceType,
                                String sourceKey,
                                boolean authorized,
                                String authorizerRefreshToken,
                                CollectionModel collectionModel
    ) {
        assertEquals(platPartnerId, merchant.getPlatPartnerId());//开发没返回
        assertEquals(platPartnerId, merchant.getPartnerId());
        assertEquals(partnerName, merchant.getPartnerName());
        assertEquals(shortName, merchant.getShortName());
        assertEquals(mobileNo, merchant.getMobileNo());
        assertEquals(accountNo, merchant.getAccountNo());
        assertEquals(marketAccountNo, merchant.getMarketAccountNo());
        assertEquals("ABLE", merchant.getStatus().code());
        assertEquals(email, merchant.getEmail());
        assertEquals(headImgUrl, merchant.getHeadImgUrl());
        assertEquals(queryDepth, merchant.getQueryDepth());
        assertEquals(dayTime, merchant.getDayTime());
        assertEquals(monthTime, merchant.getMonthTime());
        assertEquals(rawAddTime, merchant.getRawAddTime());
        assertEquals(sourceKey, merchant.getSourceKey());
        assertEquals(sourceType, merchant.getSourceType());
        assertEquals(authorized, merchant.isAuthorized());
        assertEquals(authorizerRefreshToken, merchant.getAuthorizerRefreshToken());
        assertEquals(collectionModel, merchant.getCollectionModel());
    }

    /**
     * 油站信息
     */
    private void stationAssert(MerchantStationInfo station,
                               String partnerId,
                               String stationId,
                               String stationCode,
                               String stationName,
                               String provinceName,
                               String cityName,
                               String districtName,
                               String phoneNo,
                               String stationAddress,
                               Double longitude,
                               Double latitude
    ) {
        assertEquals(partnerId, station.getPlatPartnerId());
        assertEquals(partnerId, station.getPartnerId());
        assertEquals(stationId, station.getStationId());
        assertEquals(stationCode, station.getStationCode());
        assertEquals(stationName, station.getStationName());
//        assertEquals(provinceName, station.getProvinceName());开发没返回
//        assertEquals(cityName, station.getCityName());
//        assertEquals(districtName, station.getDistrictName());
        assertEquals(phoneNo, station.getPhoneNo());
        assertEquals(stationAddress, station.getStationAddress());
        assertEquals(EnableStatus.ABLE, station.getStatus());
        assertEquals(false, station.isConnectOilMachine());
        assertEquals(latitude, station.getLatitude());
        assertEquals(longitude, station.getLongitude());
    }
}
