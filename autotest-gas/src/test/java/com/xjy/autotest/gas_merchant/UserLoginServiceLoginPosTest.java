package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.*;
import com.xyb.gas.merchant.api.facade.UserLoginService;
import com.xyb.gas.merchant.api.info.*;
import com.xyb.gas.merchant.api.info.permission.PermissionInfo;
import com.xyb.gas.merchant.api.order.UserLoginPosOrder;
import com.xyb.gas.merchant.api.result.login.SignInResult;
import dal.model.gas_silverbolt.GasTerminalLoginDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author nuomi
 * Created on 2019/12/31.
 */
public class UserLoginServiceLoginPosTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserLoginService userLoginService;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/userLoginServiceLoginPosTestSuccess.csv")
    @DisplayName("登录pos机--成功用例")
    public void userLoginServiceLoginPosTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String mobile,
            String sourceKey, String model,
            String merchantStatus, String goodsCode,
            String goodsName, String account,
            String password, String operatorMobile,
            String deviceCode, String loginStatus,
            UserLoginPosOrder order
    ) {
        // 清除数据
        // 准备数据
        Map<String, Object> param = gasMerchantInitDataBase.initPosGasRole(partnerId, mobile,
                sourceKey, model, merchantStatus, UserType.DEVICE.code(),
                UserStatus.NORMAL.code(), account, password, operatorMobile,
                deviceCode, loginStatus, "1", goodsCode, goodsName);
        String permissionId = param.get("permissionId").toString();
        String roleNo = param.get("roleNo").toString();
        String productId = param.get("productId").toString();
        String userId = param.get("userId").toString();
        String stationId = param.get("stationId").toString();
        // 测试过程
        // 调用接口
        SignInResult result = userLoginService.signInPos(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        MerchantUserInfo userInfo = result.getInfo().getUserInfo();
        userInfoAssert(userInfo, partnerId, partnerId, userId, "用户名", operatorMobile, account);
        MerchantInfo merchantInfo = result.getInfo().getMerchantInfo();
        merchantInfoAssert(merchantInfo, partnerId, partnerId,
                "自动化测试商家", "自动化测试",
                mobile, "1jc7w1m29ks031hge7p8", "001iys5hlniks541g00",
                null, null, null,
                "0*60*60*1000+0*60*1000+0" + "*1000",
                "1", SourceType.WeChat.code(), sourceKey, model);
        List<PermissionInfo> permissions = result.getInfo().getInfos();
        resourceInfAssert(permissions.get(0), permissionId,
                "POS", "OneKeyPayManage", "一键加油管理",
                null, null, null,
                null, "COMMON",
                "MENU", null, null, 4);
        List<LoginStationDetailInfo> stationInfos = result.getInfo().getStationInfos();
        stationInfoAssert(stationInfos.get(0), partnerId, partnerId, stationId,
                "test001", "自动化测试油站");
        List<StationOilGunInfo> stationOilGunInfos = result.getInfo().getStationInfos().get(0).getOilGunInfos();
        oilGunInfoAssert(stationOilGunInfos.get(0),
                partnerId, partnerId, stationId,
                "1", "98", "98#汽油");
        List<GoodsInfo> goodsInfos = result.getInfo().getStationInfos().get(0).getGoodsInfos();
        goodsInfoAssert(goodsInfos.get(0), "98", "98#汽油");
        List<String> stationIds = result.getInfo().getStationIds();
        assertTrue(stationIds.contains(stationId));
        assertEquals(RoleType.Terminal, result.getInfo().getRoleType());
        assertEquals(roleNo, result.getInfo().getRoleNo());
        //分析数据校验
        sleep(5);
        List<GasTerminalLoginDO> loginInfos = silverboltTestBase.findGasTerminalLoginByUserId(userId);
        terminalLoginInfoAssert(loginInfos.get(0),
                partnerId, stationId, "自动化测试油站",
                userId, "用户名",
                account, deviceCode, result.getInfo().getLoginSuccessTime());
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantRoleByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanUserUniqueKeyByUserId(userId);
        gasMerchantTestBase.cleanRoleByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanProductByProductId(productId);
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId);
        gasMerchantTestBase.cleanMerchantProductByProductId(productId);
        gasMerchantTestBase.cleanProductPermissionByProductId(productId);
        gasMerchantTestBase.cleanRoleProductByRoleNo(roleNo);
        gasMerchantTestBase.cleanRolePermissionByRoleNo(roleNo);
        gasMerchantTestBase.cleanGasMerchantDeviceByDeviceCode(deviceCode);
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        gasMerchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantUserByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantUserStationByStationId(stationId);
        silverboltTestBase.cleanGasTerminalLoginByUserId(userId);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/userLoginServiceLoginPosTestFailOne.csv")
    @DisplayName("登录pos机--参数非法")
    public void userLoginServiceLoginPosTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            UserLoginPosOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setAccount(null);
        }
        if (testId == 1002) {
            order.setPassword(null);
        }
        if (testId == 1003) {
            order.setDeviceCode(null);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        SignInResult result = userLoginService.signInPos(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.未找到对应的pos机
     * 1002.账号状态异常
     * 1003.没有登录权限
     * 1004.账号不存在
     * 1005.密码错误
     * 1006.pos机已经登录
     * 1007.账号已经登录其他pos机
     */
    @AutoTest(file = "gas_merchant/userLoginServiceLoginPosTestFailTwo.csv")
    @DisplayName("登录pos机--失败用例")
    public void userLoginServiceLoginPosTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String mobile,
            String sourceKey, String model,
            String merchantStatus, String userType,
            String userStatus, String account,
            String password, String operatorMobile,
            String deviceCode, String loginStatus,
            UserLoginPosOrder order
    ) {
        // 清除数据
        // 准备数据
        Map<String, Object> param = gasMerchantInitDataBase.initPosGasRole(partnerId, mobile,
                sourceKey, model, merchantStatus, userType,
                userStatus, account, password, operatorMobile,
                deviceCode, loginStatus, "1", "98", "98#汽油");
        Long roleId = Long.valueOf(param.get("roleId").toString());
        Long resourceId = Long.valueOf(param.get("resourceId").toString());
        String userId = param.get("userId").toString();
        String stationId = param.get("stationId").toString();
        if (testId == 1007) {
            gasMerchantTestBase.insertGasMerchantDevice(0L, partnerId, partnerId,
                    DeviceType.POS.code(), "3b6fe3a7", "login", userId, null, null);
        }
        // 测试过程
        // 调用接口
        SignInResult result = userLoginService.signInPos(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantRoleByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasRoleById(roleId);
        gasMerchantTestBase.cleanGasMerchantRoleResourceByRoleId(roleId);
        gasMerchantTestBase.cleanGasDeviceResourceById(resourceId);
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantStationByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantUserStationByStationId(stationId);
        gasMerchantTestBase.cleanGasStationOilGunByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantDeviceByDeviceCode(deviceCode);
        gasMerchantTestBase.cleanGasMerchantDeviceByDeviceCode("3b6fe3a7");
        gasMerchantTestBase.cleanGasGoodsByGoodsCode("98");
        gasMerchantTestBase.cleanGasMerchantGoodsByGoodsCode("98");
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantUserByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantUserStationByStationId(stationId);
        silverboltTestBase.cleanGasTerminalLoginByUserId(userId);
        silverboltTestBase.cleanGasGoodsByGoodsCode("98");
        silverboltTestBase.cleanGasMerchantGoodsByGoodsCode("98");
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
    }

    /**
     * 用户信息
     */
    private void userInfoAssert(
            MerchantUserInfo userInfo,
            String platPartnerId,
            String partnerId,
            String userId,
            String userName,
            String mobileNo,
            String account
    ) {
        assertEquals(platPartnerId, userInfo.getPlatPartnerId());
        assertEquals(partnerId, userInfo.getPartnerId());
        assertEquals(userId, userInfo.getUserId());
        assertEquals(userName, userInfo.getUserName());
        assertEquals(mobileNo, userInfo.getMobileNo());
        assertEquals(account, userInfo.getAccount());
        assertEquals(UserStatus.NORMAL, userInfo.getStatus());
        assertEquals(5, userInfo.getLoginErrorLimit());
        assertEquals(0, userInfo.getLoginErrorCount());
        assertEquals(null, userInfo.getLastLogoutSuccessTime());
//        assertEquals(DateUtils.getSqlDate(), userInfo.getLastLoginTime());
//        assertEquals(DateUtils.getSqlDate(), userInfo.getLastLoginSuccessTime());
    }

    /**
     * 商户信息
     */
    private void merchantInfoAssert(
            MerchantInfo merchantInfo,
            String platPartnerId,
            String partnerId,
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
            String sourceType,
            String sourceKey,
            String model
    ) {
        assertEquals(platPartnerId, merchantInfo.getPlatPartnerId());
        assertEquals(partnerId, merchantInfo.getPartnerId());
        assertEquals(partnerName, merchantInfo.getPartnerName());
        assertEquals(shortName, merchantInfo.getShortName());
        assertEquals(mobileNo, merchantInfo.getMobileNo());
        assertEquals(accountNo, merchantInfo.getAccountNo());
        assertEquals(marketAccountNo, merchantInfo.getMarketAccountNo());
        assertEquals(email, merchantInfo.getEmail());
        assertEquals("ABLE", merchantInfo.getStatus().code());
        assertEquals(headImgUrl, merchantInfo.getHeadImgUrl());
        assertEquals(queryDepth, merchantInfo.getQueryDepth());
        assertEquals(dayTime, merchantInfo.getDayTime());
        assertEquals(monthTime, merchantInfo.getMonthTime());
        assertEquals(sourceType, merchantInfo.getSourceType().code());
        assertEquals(sourceKey, merchantInfo.getSourceKey());
        assertEquals(false, merchantInfo.isAuthorized());
        assertEquals(null, merchantInfo.getAuthorizerRefreshToken());
        assertEquals(model, merchantInfo.getCollectionModel().code());
    }

    /**
     * 油站信息
     */
    private void stationInfoAssert(
            LoginStationDetailInfo stationInfo,
            String platPartnerId,
            String partnerId,
            String stationId,
            String stationCode,
            String stationName
    ) {
        assertEquals(platPartnerId, stationInfo.getPlatPartnerId());
        assertEquals(partnerId, stationInfo.getPartnerId());
        assertEquals(stationId, stationInfo.getStationId());
        assertEquals(stationCode, stationInfo.getStationCode());
        assertEquals(stationName, stationInfo.getStationName());
        assertEquals(null, stationInfo.getPhoneNo());
        assertEquals("ABLE", stationInfo.getStatus().code());
        assertEquals(500000L, stationInfo.getProvinceId());
        assertEquals("重庆市", stationInfo.getProvinceName());
        assertEquals(500100L, stationInfo.getCityId());
        assertEquals("市辖区", stationInfo.getCityName());
        assertEquals(500112L, stationInfo.getDistrictId());
        assertEquals("渝北区", stationInfo.getDistrictName());
        assertEquals("金开大道互联网产业园13幢3楼", stationInfo.getStationAddress());
        assertEquals(false, stationInfo.getConnectOilMachine().booleanValue());
    }

    /**
     * 油枪信息
     */
    private void oilGunInfoAssert(
            StationOilGunInfo oilGunInfo,
            String platPartnerId,
            String partnerId,
            String stationId,
            String gunNo,
            String goodsCode,
            String goodsName
    ) {
//        assertEquals(platPartnerId, oilGunInfo.getPlatPartnerId());开发没返回
//        assertEquals(partnerId, oilGunInfo.getPartnerId());
        assertEquals(stationId, oilGunInfo.getStationId());
        assertEquals(gunNo, oilGunInfo.getOilGunNo());
        assertEquals(goodsCode, oilGunInfo.getGoodsCode());
        assertEquals(goodsName, oilGunInfo.getGoodsName());
        assertEquals(GoodsGroupType.GASOLINE, oilGunInfo.getGoodsGroupType());
//        assertEquals(1, oilGunInfo.getSortNo());开发没返回
    }

    /**
     * 商品信息
     */
    private void goodsInfoAssert(
            GoodsInfo goodsInfo,
            String goodsCode,
            String goodsName
    ) {
        assertEquals(goodsCode, goodsInfo.getGoodsCode());
        assertEquals(goodsName, goodsInfo.getGoodsName());
        assertEquals(GoodsType.OIL, goodsInfo.getGoodsType());
        assertEquals(GoodsGroupType.GASOLINE, goodsInfo.getGoodsGroupType());
        assertEquals(null, goodsInfo.getOrderNo());
    }

    /**
     * 权限资源
     */
    private void resourceInfAssert(
            PermissionInfo info,
            String permissionId,
            String deviceType,
            String code,
            String name,
            String parentId,
            String parentName,
            String parentCode,
            String url,
            String permissionCategory,
            String resourceType,
            String icon,
            String memo,
            int orderNo
    ) {
        assertEquals(permissionId, info.getPermissionId());
        assertEquals(name, info.getName());
        assertEquals(code, info.getCode());
        assertEquals(parentId, info.getParentId());
        assertEquals(parentName, info.getParentName());
        assertEquals(parentCode, info.getParentCode());
        assertEquals(url, info.getUrl());
        assertEquals(deviceType, info.getDeviceType().code());
        assertEquals(permissionCategory, info.getPermissionCategory().code());
        assertEquals(resourceType, info.getResourceType().code());
        assertEquals(orderNo, info.getOrderNo().intValue());
        assertEquals(icon, info.getIcon());
        assertEquals(memo, info.getMemo());
    }

    /**
     * 终端登录信息
     */
    private void terminalLoginInfoAssert(
            GasTerminalLoginDO loginInfo,
            String partnerId,
            String stationId,
            String stationName,
            String userId,
            String userName,
            String account,
            String deviceCode,
            Date loginTime
    ) {
        assertEquals(userId, loginInfo.getUserId());
        assertEquals(partnerId, loginInfo.getPartnerId());
        assertEquals(stationId, loginInfo.getStationId());
        assertEquals(stationName, loginInfo.getStationName());
        assertEquals(account, loginInfo.getAccount());
        assertEquals(userName, loginInfo.getUserName());
        assertEquals(deviceCode, loginInfo.getDeviceCode());
        assertEquals(DeviceType.POS.code(), loginInfo.getDeviceType());
        assertEquals(loginTime, loginInfo.getLoginTime());
    }
}
