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
import com.xyb.gas.merchant.api.enums.RoleType;
import com.xyb.gas.merchant.api.enums.SourceType;
import com.xyb.gas.merchant.api.enums.UserStatus;
import com.xyb.gas.merchant.api.enums.UserType;
import com.xyb.gas.merchant.api.facade.UserLoginService;
import com.xyb.gas.merchant.api.info.MerchantInfo;
import com.xyb.gas.merchant.api.info.MerchantUserInfo;
import com.xyb.gas.merchant.api.info.permission.PermissionInfo;
import com.xyb.gas.merchant.api.order.UserLoginBossOrder;
import com.xyb.gas.merchant.api.result.login.SignInResult;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author nuomi
 * Created on 2019/12/31.
 */
public class UserLoginServiceLoginTest extends SpringBootTestBase {

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
    @AutoTest(file = "gas_merchant/userLoginServiceLoginTestSuccess.csv")
    @DisplayName("登录商户平台--成功用例")
    public void userLoginServiceLoginTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String mobile,
            String sourceKey, String model,
            String merchantStatus, String account,
            String password, String operatorMobile,
            UserLoginBossOrder order
    ) {
        // 清除数据
        // 准备数据
        Map<String, Object> param = gasMerchantInitDataBase.initBossGasRole(partnerId, mobile,
                sourceKey, model, merchantStatus, UserType.BOSS.code(), UserStatus.NORMAL.code(), account,
                password, operatorMobile);
        String permissionId = param.get("permissionId").toString();
        String roleNo = param.get("roleNo").toString();
        String productId = param.get("productId").toString();
        String userId = param.get("userId").toString();
        // 测试过程
        // 调用接口
        SignInResult result = userLoginService.signInBoss(order);
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
                "1", SourceType.WeChat.code(),
                sourceKey, model);
        List<PermissionInfo> permissions = result.getInfo().getInfos();
        resourceInfAssert(permissions.get(0), permissionId,
                "BOSS", "MENU0529", "油站中心",
                null, null, null,
                null, "COMMON",
                "MENU", null, null, 4);
        assertEquals(RoleType.Supplier, result.getInfo().getRoleType());
        assertEquals(roleNo, result.getInfo().getRoleNo());
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
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantUserByPartnerId(partnerId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/userLoginServiceLoginTestFailOne.csv")
    @DisplayName("登录商户平台--参数非法")
    public void userLoginServiceLoginTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            UserLoginBossOrder order
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
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        SignInResult result = userLoginService.signInBoss(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.账号不存在
     * 1002.密码错误
     * 1003.账号被冻结
     * 1004.无登录权限
     */
    @AutoTest(file = "gas_merchant/userLoginServiceLoginTestFailTwo.csv")
    @DisplayName("登录商户平台--失败用例")
    public void userLoginServiceLoginTestFailTwo(
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
            UserLoginBossOrder order
    ) {
        // 清除数据
        // 准备数据
        Map<String, Object> param = gasMerchantInitDataBase.initBossGasRole(partnerId, mobile,
                sourceKey, model, merchantStatus, userType, userStatus, account,
                password, operatorMobile);
        String permissionId = param.get("permissionId").toString();
        String roleNo = param.get("roleNo").toString();
        String productId = param.get("productId").toString();
        String userId = param.get("userId").toString();
        // 测试过程
        // 调用接口
        SignInResult result = userLoginService.signInBoss(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantRoleByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanRoleByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanProductByProductId(productId);
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId);
        gasMerchantTestBase.cleanMerchantProductByProductId(productId);
        gasMerchantTestBase.cleanProductPermissionByProductId(productId);
        gasMerchantTestBase.cleanRoleProductByRoleNo(roleNo);
        gasMerchantTestBase.cleanRolePermissionByRoleNo(roleNo);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantUserByPartnerId(partnerId);
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
}
