package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.common.collect.Sets;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xjy.autotest.utils.StringUtils;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.security.DigestUtil;
import com.xyb.gas.merchant.api.enums.UkType;
import com.xyb.gas.merchant.api.enums.UserLoginStatus;
import com.xyb.gas.merchant.api.enums.UserStatus;
import com.xyb.gas.merchant.api.facade.MerchantUserService;
import com.xyb.gas.merchant.api.order.ModifyMerchantUserOrder;
import dal.model.gas_merchant.GasMerchantUserDO;
import dal.model.gas_merchant.GasMerchantUserStationDO;
import dal.model.gas_merchant.UserUniqueKeyDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author nuomi
 * Created on 2020/01/06.
 */
public class MerchantUserServiceModifyUserTest extends SpringBootTestBase {

    @Reference(version = "1.0")
    MerchantUserService merchantUserService;

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
    @AutoTest(file = "gas_merchant/merchantUserServiceModifyUserTestSuccess.csv")
    @DisplayName("修改商户用户--成功用例")
    public void merchantUserServiceModifyUserTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String userType,
            String userTypexx,
            String mobileNo,
            String roleType,
            String roleTypexx,
            String roleName,
            String roleNamexx,
            String roleCode,
            String account,
            String password,
            String operatorMobile,
            ModifyMerchantUserOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanRoleByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanUserUniqueKey();
        silverboltTestBase.cleanGasMerchantUserByPartnerId(order.getPlatPartnerId());
        // 准备数据
        //商户信息
        Map<String, Object> params = gasMerchantInitDataBase.initMerchantUser(order.getPlatPartnerId(), mobileNo,
                null, "Merchant", "ABLE", "test001",
                "测试油站", userType, "NORMAL", roleType, roleName,
                null, account, null, password, operatorMobile);
        String roleNo = params.get("roleNo").toString();
        String userId = params.get("userId").toString();
        String stationId = params.get("stationId").toString();
        //角色信息
        gasMerchantTestBase.insertRole(0L, OID.newID(), roleCode, roleTypexx, order.getPlatPartnerId(),
                roleNamexx, roleNamexx, null, null);
        String roleNo1 =
                gasMerchantInitDataBase.findRoleByRoleTypeAndRoleCode(order.getPlatPartnerId(), roleTypexx, roleCode
                ).get(0).getRoleNo();
        // 测试过程
        Set<String> stationIds = Sets.newHashSet();
        stationIds.add(stationId);
        if (testId != 1001) {
            order.setStationIds(stationIds);
        }
        order.setRoleNo(roleNo1);
        order.setUserId(userId);
        // 调用接口
        SimpleResult result = merchantUserService.modifyUser(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasMerchantUserDO> gasMerchantUsers =
                gasMerchantTestBase.findGasMerchantUserByPlatPartnerId(order.getPlatPartnerId());
        List<GasMerchantUserStationDO> relations =
                gasMerchantTestBase.findGasMerchantUserStationByStationId(stationId);
        List<UserUniqueKeyDO> uniqueKeys = gasMerchantTestBase.findUserUniqueKeyByUserId(order.getUserId());
        if (testId != 1001) {
            assertEquals(stationId, relations.get(0).getStationId());
            assertEquals(gasMerchantUsers.get(0).getUserId(), relations.get(0).getUserId());
        }
        gasMerchantUserAssert(gasMerchantUsers.get(0), order.getPlatPartnerId(), userTypexx,
                order.getUserName(),
                order.getMobileNo(), order.getAccount(), order.getPassword(), order.getRoleNo());
        if (testId <= 1003) {
            assertEquals(1, uniqueKeys.size());
            assertEquals(UkType.ACCOUNT.code(), uniqueKeys.get(0).getUkType());
            assertEquals(order.getAccount(), uniqueKeys.get(0).getUniqueKey());
        }
        if (testId >= 1004) {
            assertEquals(2, uniqueKeys.size());
            for (UserUniqueKeyDO uniqueKey : uniqueKeys) {
                if (UkType.ACCOUNT.code().equals(uniqueKey.getUkType())) {
                    assertEquals(String.join("_", order.getPlatPartnerId(), order.getAccount()),
                            uniqueKey.getUniqueKey());
                }
                if (UkType.MOBILE.code().equals(uniqueKey.getUkType())) {
                    assertEquals(String.join("_", order.getPlatPartnerId(), order.getMobileNo()),
                            uniqueKey.getUniqueKey());
                }
            }
        }
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(order.getPlatPartnerId());
        xybUserTestBase.cleanUserByUserId(order.getPlatPartnerId());
        xybUserTestBase.cleanAccountByUserId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanRoleByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanUserUniqueKey();
        gasMerchantTestBase.cleanGasMerchantStationByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMerchantUserStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantUserByPartnerId(order.getPlatPartnerId());
        silverboltTestBase.cleanGasMerchantUserStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantUserServiceModifyUserTestFailOne.csv")
    @DisplayName("修改商户用户--参数非法")
    public void merchantUserServiceModifyUserTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ModifyMerchantUserOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setUserName(null);
        }
        if (testId == 1002) {
            order.setRoleNo(null);
        }
        if (testId == 1003) {
            order.setAccount(null);
        }
        if (testId == 1004) {
            order.setPassword(null);
        }
        if (testId == 1005) {
            order.setMobileNo("fss2123sds");
        }
        if (testId == 1006) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1007) {
            order.setUserId(null);
        }
        if (testId == 1008) {
            order.setGid(null);
        }
        if (testId == 1009) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantUserService.modifyUser(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.用户不存在
     * 1002.修改的手机号已存在
     * 1003.修改为站长时未关联油站
     * 1004.修改为收银员时未关联油站
     * 1005.修改的用户已登录
     */
    @AutoTest(file = "gas_merchant/merchantUserServiceModifyUserTestFailTwo.csv")
    @DisplayName("修改商户用户--失败用例")
    public void merchantUserServiceModifyUserTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String userType,
            String mobileNo,
            String roleType,
            String roleTypexx,
            String roleName,
            String roleNamexx,
            String roleCode,
            String account,
            String password,
            String userId1,
            ModifyMerchantUserOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMerchantDeviceByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanRoleByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanUserUniqueKey();
        silverboltTestBase.cleanGasMerchantUserByPartnerId(order.getPlatPartnerId());
        // 准备数据
        //商户信息
        Map<String, Object> params = gasMerchantInitDataBase.initMerchantUser(order.getPlatPartnerId(), mobileNo,
                null, "Merchant", "ABLE", "test001",
                "测试油站", userType, "NORMAL", roleType, roleName,
                null, account, null, password, null);
        String roleNo = params.get("roleNo").toString();
        String userId = params.get("userId").toString();
        String stationId = params.get("stationId").toString();
        //角色信息
        gasMerchantTestBase.insertRole(0L, OID.newID(), roleCode, roleTypexx, order.getPlatPartnerId(),
                roleNamexx, roleNamexx, null, null);
        String roleNo1 =
                gasMerchantInitDataBase.findRoleByRoleTypeAndRoleCode(order.getPlatPartnerId(), roleTypexx,
                        roleCode).get(0).getRoleNo();
        if (testId == 1002) {
            gasMerchantInitDataBase.initGasMerchantUser(order.getPlatPartnerId(), userId1, roleNo1,
                    userType, "15525814777", "123456", "naxxx");
            gasMerchantTestBase.insertUserUniqueKey(0L, userId1, UkType.ACCOUNT.code(), "naxxx");
            gasMerchantTestBase.insertUserUniqueKey(0L, userId1, UkType.MOBILE.code(), String.join("_",
                    order.getPlatPartnerId(), "15525814777"));
        }
        if (testId == 1005) {
            gasMerchantInitDataBase.initGasMerchantDevice(order.getPlatPartnerId(), userId,
                    "B1814738591", UserLoginStatus.login.code());
        }
        // 测试过程
        if (testId != 1001) {
            order.setUserId(userId);
        }
        Set<String> stationIds = Sets.newHashSet();
        if (testId != 1003 && testId != 1004) {
            stationIds.add(stationId);
        }
        order.setStationIds(stationIds);
        order.setRoleNo(roleNo1);
        // 调用接口
        SimpleResult result = merchantUserService.modifyUser(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(order.getPlatPartnerId());
        xybUserTestBase.cleanUserByUserId(order.getPlatPartnerId());
        xybUserTestBase.cleanAccountByUserId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanRoleByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanUserUniqueKey();
        gasMerchantTestBase.cleanGasMerchantStationByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMerchantUserStationByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantDeviceByPlatPartnerId(order.getPlatPartnerId());
        silverboltTestBase.cleanGasMerchantUserByPartnerId(order.getPlatPartnerId());
        silverboltTestBase.cleanGasMerchantUserStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
    }

    /**
     * 商家操作员信息
     */
    private void gasMerchantUserAssert(
            GasMerchantUserDO userInfo,
            String platPartnerId,
            String userType,
            String userName,
            String mobile,
            String account,
            String password,
            String roleNo
    ) {
        assertEquals(roleNo, userInfo.getRoleNo());
        assertEquals(account, userInfo.getAccount());
        assertEquals(userName, userInfo.getUserName());
        assertEquals(mobile, userInfo.getMobileNo());
        assertEquals(userType, userInfo.getUserType());
        assertEquals(platPartnerId, userInfo.getPlatPartnerId());
        assertEquals(platPartnerId, userInfo.getPartnerId());
//                assertEquals(order.getUserName(), userInfo.getSalt());随机生成的6位数字
        if (StringUtils.isBlank(userInfo.getSalt())) {
            assertEquals(DigestUtil.digestWithMD5(password), userInfo.getPassword());
        } else {
            assertEquals(DigestUtil.digestWithMD5(password + userInfo.getSalt().substring(2)),
                    userInfo.getPassword());
        }
        assertEquals(UserStatus.NORMAL.code(), userInfo.getStatus());
//        if (UserType.BOSS.code().equals(userInfo.getUserType())) {
//            assertEquals(account, userInfo.getUqKey());
//        }
//        if (UserType.DEVICE.code().equals(userInfo.getUserType()) || UserType.UNLOGIN.code().equals(userInfo
//        .getUserType())) {
//            assertEquals(String.join("_", platPartnerId, account), userInfo.getUqKey());
//        }
        assertEquals(0, userInfo.getLoginErrorCount().intValue());
        assertEquals(5, userInfo.getLoginErrorLimit());
        assertEquals(null, userInfo.getLastLoginTime());
        assertEquals(null, userInfo.getLastLoginSuccessTime());
        assertEquals(null, userInfo.getLastLogoutSuccessTime());
        assertNotNull(userInfo.getRawAddTime());
        assertNotEquals(userInfo.getRawAddTime(), userInfo.getRawUpdateTime());
    }
}
