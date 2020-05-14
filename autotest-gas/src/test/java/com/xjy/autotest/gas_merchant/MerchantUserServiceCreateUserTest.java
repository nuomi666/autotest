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
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.security.DigestUtil;
import com.xyb.gas.merchant.api.enums.UkType;
import com.xyb.gas.merchant.api.enums.UserStatus;
import com.xyb.gas.merchant.api.enums.UserType;
import com.xyb.gas.merchant.api.facade.MerchantUserService;
import com.xyb.gas.merchant.api.order.CreateMerchantUserOrder;
import dal.model.gas_merchant.GasMerchantUserDO;
import dal.model.gas_merchant.GasMerchantUserStationDO;
import dal.model.gas_merchant.UserUniqueKeyDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;


/**
 * @author nuomi@xinyebang.com
 * Created on 2018/08/21.
 */
public class MerchantUserServiceCreateUserTest extends SpringBootTestBase {

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
     * 由于操作员是收银员时，手机号也可以作为登录账号，目前要求的是一个商家下的操作员手机是唯一的。账号在
     * 同一类型的操作员下是要求唯一的。
     * 1001.新增商家管理员
     * 1002.新增地推员
     * 1003.新增站长
     * 1004.新增收银员，手机号为空
     * 1005.商户下存在一个商家管理员，新增一个相同账号的收银员
     */
    @AutoTest(file = "gas_merchant/merchantUserServiceCreateUserTestSuccess.csv")
    @DisplayName("创建商户用户--成功用例")
    public void merchantUserServiceCreateUserTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String stationId,
            String userId,
            String account,
            String password,
            String roleType,
            String roleName,
            String roleCode,
            String userType,
            CreateMerchantUserOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMerchantUserStationByStationId(stationId);
        gasMerchantTestBase.cleanRoleByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanUserUniqueKey();
        silverboltTestBase.cleanGasMerchantUserByPartnerId(order.getPlatPartnerId());
        silverboltTestBase.cleanGasMerchantUserStationByStationId(stationId);
        // 准备数据
        String roleNo = null;
        //商户信息
        gasMerchantInitDataBase.initGasMerchant(order.getPlatPartnerId(), null, null, null, null, null, null,
                "Merhcnat", null, "ABLE");
        //角色信息
        gasMerchantTestBase.insertRole(0L, order.getRoleNo(), roleCode, roleType, order.getPlatPartnerId(),
                roleName, roleName, null, null);
        if (testId == 1005) {
            gasMerchantTestBase.insertRole(0L, OID.newID(), "00000000000000000000", "Supplier",
                    order.getPlatPartnerId(),
                    "商家管理员", "商家管理员", null, null);
            roleNo =
                    gasMerchantInitDataBase.findRoleByRoleTypeAndRoleCode(order.getPlatPartnerId(), "Supplier",
                            "00000000000000000000"
                    ).get(0).getRoleNo();
            gasMerchantTestBase.insertGasMerchantUser(0L, userId, null, roleNo,
                    "BOSS", order.getPlatPartnerId(), order.getPlatPartnerId(), "用户名",
                    null, order.getAccount(), gasMerchantInitDataBase.encrypt(password, null), null,
                    "ABLE", account, 0, 5, null,
                    null, null, null, null);
            gasMerchantTestBase.insertUserUniqueKey(0L, userId, UkType.ACCOUNT.code(), order.getAccount());
        }
        // 测试过程
        Set<String> stationIds = Sets.newHashSet();
        stationIds.add(stationId);
        if (testId != 1001) {
            order.setStationIds(stationIds);
        }
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = merchantUserService.createUser(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasMerchantUserDO> gasMerchantUsers =
                gasMerchantTestBase.findGasMerchantUserByPlatPartnerId(order.getPlatPartnerId());
        List<GasMerchantUserStationDO> relations =
                gasMerchantTestBase.findGasMerchantUserStationByStationId(stationId);
        List<UserUniqueKeyDO> uniqueKeys =
                gasMerchantTestBase.findUserUniqueKeyByUserId(gasMerchantUsers.get(0).getUserId());
        if (testId <= 1003) {
            assertEquals("ACCOUNT", uniqueKeys.get(0).getUkType());
            assertEquals(order.getAccount(), uniqueKeys.get(0).getUniqueKey());
        }
        if (testId == 1004) {
            assertEquals("ACCOUNT", uniqueKeys.get(0).getUkType());
            assertEquals(String.join("_", order.getPlatPartnerId(), order.getAccount()),
                    uniqueKeys.get(0).getUniqueKey());
        }
        if (testId <= 1004) {
            assertEquals(1, gasMerchantUsers.size());
            if (testId != 1001) {
                assertEquals(stationId, relations.get(0).getStationId());
                assertEquals(gasMerchantUsers.get(0).getUserId(), relations.get(0).getUserId());
            }
            gasMerchantRoleAssert(gasMerchantUsers.get(0), order.getPlatPartnerId(), userType,
                    order.getUserName(),
                    order.getMobileNo(), order.getAccount(), order.getPassword(), order.getRoleNo());
        }
        if (testId == 1005) {
            assertEquals(2, gasMerchantUsers.size());
            for (GasMerchantUserDO gasMerchantUser : gasMerchantUsers) {
                if (UserType.BOSS.code().equals(gasMerchantUser.getUserType())) {
                    gasMerchantRoleAssert(gasMerchantUser, order.getPlatPartnerId(), UserType.BOSS.code(),
                            "用户名",
                            order.getMobileNo(), order.getAccount(), "123456", roleNo);
                }
                if (UserType.DEVICE.code().equals(gasMerchantUser.getUserType())) {
                    assertEquals(gasMerchantUser.getUserId(), relations.get(0).getUserId());
                    gasMerchantRoleAssert(gasMerchantUser, order.getPlatPartnerId(), UserType.DEVICE.code(),
                            order.getUserName(),
                            order.getMobileNo(), order.getAccount(), order.getPassword(), order.getRoleNo());
                }
            }
        }
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
        silverboltTestBase.cleanGasMerchantUserByPartnerId(order.getPlatPartnerId());
        silverboltTestBase.cleanGasMerchantUserStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
    }

    @AutoTest(file = "gas_merchant/merchantUserServiceCreateUserTestFailOne.csv")
    @DisplayName("创建商户用户--参数非法")
    public void merchantUserServiceCreateUserTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CreateMerchantUserOrder order
    ) {
        // 清除数据

        // 准备数据

        // 测试过程
        Set<String> stationIds = Sets.newHashSet();
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setUserName(null);
        }
        if (testId != 1002) {
            order.setRoleId(null);
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
            order.setGid(null);
        }
        if (testId == 1008) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantUserService.createUser(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }

    /**
     * 1001.商家不存在
     * 1002.商家下无该角色
     * 1003.创建站长时未关联油站
     * 1004.创建收银员时未关联油站
     * 1005.同一角色类型，账号已经存在
     * 1006.创建收银员，同一商家下手机号已存在
     */
    @AutoTest(file = "gas_merchant/merchantUserServiceCreateUserTestFailTwo.csv")
    @DisplayName("创建商户用户--失败用例")
    public void merchantUserServiceCreateUserTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String roleType,
            String roleName,
            String roleCode,
            String stationId,
            CreateMerchantUserOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        //商户信息
        if (testId != 1001) {
            gasMerchantInitDataBase.initGasMerchant(order.getPlatPartnerId(), null, null, null, null, null, null,
                    "Merhcnat", null, "ABLE");
        }
        //角色信息
        gasMerchantTestBase.insertRole(0L, order.getRoleNo(), roleCode, roleType, order.getPlatPartnerId(),
                roleName, roleName, null, null);
        //油站信息
        gasMerchantInitDataBase.initStationsWithOneMerchant(order.getPlatPartnerId(), null, order.getPartnerId(),
                null, stationId, null, "测试油站", null, "test001", null, "ABLE", null);
        if (testId == 1005) {
            gasMerchantInitDataBase.initGasMerchantUser(order.getPlatPartnerId(), OID.newID(), order.getRoleNo(),
                    UserType.DEVICE.code(), "13325814722", "123456", order.getAccount());
        }
        if (testId == 1006) {
            gasMerchantInitDataBase.initGasMerchantUser(order.getPlatPartnerId(), OID.newID(), order.getRoleNo(),
                    UserType.DEVICE.code(), order.getMobileNo(), "123456", "aaabbb");
        }
        // 测试过程
        Set<String> stationIds = Sets.newHashSet();
        stationIds.add(stationId);
        order.setGid(GID.newGID());
        if (testId != 1003 && testId != 1004) {
            order.setStationIds(stationIds);
        }
        // 调用接口
        SimpleResult result = merchantUserService.createUser(order);
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
        gasMerchantTestBase.cleanGasMerchantRoleByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMerchantStationByPlatPartnerId(order.getPlatPartnerId());
        silverboltTestBase.cleanGasMerchantUserByPartnerId(order.getPlatPartnerId());
        silverboltTestBase.cleanGasMerchantUserStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
    }

    private void gasMerchantRoleAssert(
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
        if (UserType.DEVICE.code().equals(userInfo.getUserType())) {
            assertEquals(String.join("_", platPartnerId, account), userInfo.getUqKey());
        } else {
            assertEquals(account, userInfo.getUqKey());
        }
        assertEquals(0, userInfo.getLoginErrorCount().intValue());
        assertEquals(5, userInfo.getLoginErrorLimit());
        assertEquals(null, userInfo.getLastLoginTime());
        assertEquals(null, userInfo.getLastLoginSuccessTime());
        assertEquals(null, userInfo.getLastLogoutSuccessTime());
        assertNotNull(userInfo.getRawAddTime());
        assertEquals(userInfo.getRawAddTime(), userInfo.getRawUpdateTime());
    }
}
