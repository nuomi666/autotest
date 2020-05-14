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
import com.xyb.gas.merchant.api.enums.*;
import com.xyb.gas.merchant.api.facade.MerchantTradePayService;
import com.xyb.gas.merchant.api.info.MerchantInfo;
import com.xyb.gas.merchant.api.info.MerchantStationInfo;
import com.xyb.gas.merchant.api.info.MerchantUserInfo;
import com.xyb.gas.merchant.api.info.OneKeyFuncInfo;
import com.xyb.gas.merchant.api.order.QueryOneKeyFuncOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author nuomi
 * Created on 2019/12/17.
 */
public class MerchantTradePayServiceQueryOnKeyFuncInfoTest extends SpringBootTestBase {

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
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantTradePayServiceQueryOnKeyFuncInfoTestSuccess.csv")
    @DisplayName("验证并获取一键加油信息--成功用例")
    public void merchantTradePayServiceQueryOnKeyFuncInfoTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            //商家
            String partnerId, String partnerName,
            String shortName, String mobile,
            String sourceKey, String merchantStatus,
            //油站
            String stationId, String stationName,
            String stationCode,
            //操作员
            String userId,
            //终端
            String deviceCode, String loginStatus,
            QueryOneKeyFuncOrder queryOneKeyFuncOrder
    ) {
        // 清除数据
        // 准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date rawAddTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -3, -4, 0, 0);
        Date rawAddTime1 = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -3, -4, 0, 0);
        Date loginTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, -1, 0, 0);
        //商家信息
        gasMerchantInitDataBase.initGasMerchants(partnerId, null, partnerName, null, shortName, null, mobile, null,
                sourceKey, null, merchantStatus, null, "Merchant", null, rawAddTime, null);
        //油站
        gasMerchantInitDataBase.initStationsWithOperator(partnerId, stationId, stationName, stationCode, userId,
                UserType.DEVICE.code(),
                1L, "nuomi", "123456",
                null, EnableStatus.ABLE.code(), null, null, loginTime, rawAddTime1, null);
        //终端
        gasMerchantInitDataBase.initGasMerchantDevice(partnerId, userId, deviceCode, loginStatus);
        //一键加油
        gasMerchantInitDataBase.initGasDeviceFunction(partnerId, userId, stationId, deviceCode);
        // 测试过程
        queryOneKeyFuncOrder.setStationId(stationId);
        // 调用接口
        BizResult<OneKeyFuncInfo> result = merchantTradePayService.queryOnKeyFuncInfo(queryOneKeyFuncOrder);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        MerchantInfo merchant = result.getInfo().getMerchantInfo();
        MerchantUserInfo merchantUser = result.getInfo().getUserInfo();
        MerchantStationInfo station = result.getInfo().getStationInfo();
        assertEquals(deviceCode, result.getInfo().getDeviceCode());
        //商家信息
        merchantAssert(merchant, partnerId, partnerName, shortName,
                mobile, "1jc7w1m29ks031hge7p8", "001iys5hlniks541g00",
                null, null, null,
                "0*60*60*1000+0*60*1000+0" + "*1000", "1",
                rawAddTime, SourceType.WeChat, sourceKey, false, null, CollectionModel.Merchant);
        //操作员信息
        merchantUserAssert(merchantUser, userId, "用户名",
                partnerId, null, "nuomi", loginTime, loginTime, null);
        //油站信息
        stationAssert(station, partnerId, stationId, stationCode, stationName,
                "重庆市", "市辖区", "渝北区", null,
                "金开大道互联网产业园13幢3楼", 106.489838082, 29.6219092167);
        // 清除数据
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId);
        merchantTestBase.cleanGasMerchantUserByUserId(userId);
        merchantTestBase.cleanGasMerchantUserStationByStationId(stationId);
        merchantTestBase.cleanGasMerchantDeviceByDeviceCode(deviceCode);
        merchantTestBase.cleanGasMerchantDeviceFunctionByStationId(stationId);
        silverboltTestBase.cleanGasMerchantUserByUserId(userId);
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
    @AutoTest(file = "gas_merchant/merchantTradePayServiceQueryOnKeyFuncInfoTestFailOne.csv")
    @DisplayName("验证并获取一键加油信息--参数非法")
    public void merchantTradePayServiceQueryOnKeyFuncInfoTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryOneKeyFuncOrder queryOneKeyFuncOrder
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            queryOneKeyFuncOrder.setPartnerId(null);
            queryOneKeyFuncOrder.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            queryOneKeyFuncOrder.setStationId(null);
        }
        if (testId == 1003) {
            queryOneKeyFuncOrder.setGid(null);
        }
        if (testId == 1004) {
            queryOneKeyFuncOrder = null;
        }
        // 调用接口
        BizResult<OneKeyFuncInfo> result = merchantTradePayService.queryOnKeyFuncInfo(queryOneKeyFuncOrder);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.商家不存在
     * 1002.油站不存在
     * 1003.操作员不存在
     * 1004.pos机未登陆
     * 1005.pos机未开启一键加油
     */
    @AutoTest(file = "gas_merchant/merchantTradePayServiceQueryOnKeyFuncInfoTestFailTwo.csv")
    @DisplayName("验证并获取一键加油信息--失败用例")
    public void merchantTradePayServiceQueryOnKeyFuncInfoTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            //商家
            String partnerId, String partnerName,
            String shortName, String mobile,
            String sourceKey, String merchantStatus,
            //油站
            String stationId, String stationName,
            String stationCode,
            //操作员
            String userId,
            //终端
            String deviceCode, String loginStatus,
            QueryOneKeyFuncOrder queryOneKeyFuncOrder
    ) {
        // 清除数据
        // 准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date rawAddTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -3, -4, 0, 0);
        Date rawAddTime1 = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -3, -4, 0, 0);
        Date loginTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, -1, 0, 0);
        //商家信息
        if (testId != 1001) {
            gasMerchantInitDataBase.initGasMerchants(partnerId, null, partnerName, null, shortName, null, mobile, null,
                    sourceKey, null, merchantStatus, null, "Merchant", null, rawAddTime, null);
        }
        //油站
        if (testId != 1002 && testId != 1003) {
            gasMerchantInitDataBase.initStationsWithOperator(partnerId, stationId, stationName, stationCode, userId,
                    UserType.DEVICE.code(),
                    1L, "nuomi", "123456",
                    null, EnableStatus.ABLE.code(), null, null, loginTime, rawAddTime1, null);
        }
        //终端
        gasMerchantInitDataBase.initGasMerchantDevice(partnerId, userId, deviceCode, loginStatus);
        //一键加油
        if (testId != 1005) {
            gasMerchantInitDataBase.initGasDeviceFunction(partnerId, userId, stationId, deviceCode);
        }
        // 测试过程
        queryOneKeyFuncOrder.setStationId(stationId);
        // 调用接口
        BizResult<OneKeyFuncInfo> result = merchantTradePayService.queryOnKeyFuncInfo(queryOneKeyFuncOrder);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId);
        merchantTestBase.cleanGasMerchantUserByUserId(userId);
        merchantTestBase.cleanGasMerchantUserStationByStationId(stationId);
        merchantTestBase.cleanGasMerchantDeviceByDeviceCode(deviceCode);
        merchantTestBase.cleanGasMerchantDeviceFunctionByStationId(stationId);
        silverboltTestBase.cleanGasMerchantUserByUserId(userId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
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
     * 操作员信息
     */
    private void merchantUserAssert(MerchantUserInfo merchantUser,
                                    String userId,
                                    String userName,
                                    String partnerId,
                                    String mobileNo,
                                    String account,
                                    Date lastLoginTime,
                                    Date lastLoginSuccessTime,
                                    Date lastLogoutSuccessTime
    ) {
        assertEquals(userId, merchantUser.getUserId());
        assertEquals(userName, merchantUser.getUserName());
        assertEquals(partnerId, merchantUser.getPlatPartnerId());
        assertEquals(partnerId, merchantUser.getPartnerId());
        assertEquals(mobileNo, merchantUser.getMobileNo());
        assertEquals(account, merchantUser.getAccount());
        assertEquals(UserStatus.NORMAL, merchantUser.getStatus());
        assertEquals(5, merchantUser.getLoginErrorLimit());
        assertEquals(0, merchantUser.getLoginErrorCount());
        assertEquals(lastLoginTime, merchantUser.getLastLoginTime());
        assertEquals(lastLoginSuccessTime, merchantUser.getLastLoginSuccessTime());
        assertEquals(lastLogoutSuccessTime, merchantUser.getLastLogoutSuccessTime());
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
        assertEquals(provinceName, station.getProvinceName());
        assertEquals(cityName, station.getCityName());
        assertEquals(districtName, station.getDistrictName());
        assertEquals(phoneNo, station.getPhoneNo());
        assertEquals(stationAddress, station.getStationAddress());
        assertEquals(EnableStatus.ABLE, station.getStatus());
        assertEquals(false, station.isConnectOilMachine());
        assertEquals(latitude, station.getLatitude());
        assertEquals(longitude, station.getLongitude());
    }
}
