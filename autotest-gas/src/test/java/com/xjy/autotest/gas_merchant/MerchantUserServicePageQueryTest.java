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
import com.xyb.gas.merchant.api.enums.RoleType;
import com.xyb.gas.merchant.api.enums.UserType;
import com.xyb.gas.merchant.api.facade.MerchantUserService;
import com.xyb.gas.merchant.api.info.MerchantStationInfo;
import com.xyb.gas.merchant.api.info.MerchantUserDetailInfo;
import com.xyb.gas.merchant.api.info.RoleInfo;
import com.xyb.gas.merchant.api.order.PageQueryMerchantUserOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author nuomi
 * Created on 2020/01/07.
 */
public class MerchantUserServicePageQueryTest extends SpringBootTestBase {

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
     * 1001.根据操作员类型查询，每页显示10条，显示第1页
     * 1002.根据油站id查，每页显示10条，显示第1页
     * 1003.只传商家id查，每页显示2条，显示第1页
     * 1004.传入所有项查，每页显示10条，显示第1页
     * 1005.查询的角色不存在
     */
    @AutoTest(file = "gas_merchant/merchantUserServicePageQueryTestSuccess.csv")
    @DisplayName("分页查询用户--成功用例")
    public void merchantUserServicePageQueryTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String mobile,
            String sourceKey, String stationCode,
            String stationName, String userId1,
            String userId2, String userType,
            String roleName, String roleName1,
            String roleName2, String deviceType,
            String sourceName, String account,
            String password, String operatorMobile,
            PageQueryMerchantUserOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasRoleByRoleName(roleName1);
        gasMerchantTestBase.cleanGasRoleByRoleName(roleName2);
        gasMerchantTestBase.cleanGasMerchantUserByUserId(userId1);
        gasMerchantTestBase.cleanGasMerchantUserByUserId(userId2);
        silverboltTestBase.cleanGasMerchantUserByUserId(userId1);
        silverboltTestBase.cleanGasMerchantUserByUserId(userId2);
        // 准备数据
        //商家管理员
        Map<String, Object> params = gasMerchantInitDataBase.initMerchantUser(partnerId, mobile,
                sourceKey, "Merchant", "ABLE", stationCode,
                stationName, userType, "NORMAL", RoleType.Supplier.code(), roleName,
                deviceType, account, null, password, operatorMobile);
        String roleNo = params.get("roleNo").toString();
        String userId = params.get("userId").toString();
        String stationId = params.get("stationId").toString();
        //角色
        gasMerchantTestBase.insertRole(0L, OID.newID(), "00000000000000000000", RoleType.Terminal.code(), partnerId,
                roleName1, "系统预设收银员", null, null);
        String roleNo1 =
                gasMerchantInitDataBase.findRoleByRoleTypeAndRoleCode(partnerId, RoleType.Terminal.code(),
                        "00000000000000000000").get(0).getRoleNo();
        gasMerchantTestBase.insertRole(0L, OID.newID(), "33333", RoleType.Nonoperation.code(), partnerId,
                roleName2, "地推员", null, null);
        String roleNo2 =
                gasMerchantInitDataBase.findRoleByRoleTypeAndRoleCode(partnerId, RoleType.Nonoperation.code(), "33333"
                ).get(0).getRoleNo();
        //收银员
        gasMerchantTestBase.insertGasMerchantUser(0L, userId1, null, roleNo1, UserType.DEVICE.code(), partnerId,
                partnerId,
                "收银员", null,
                "aa", null, null, "NORMAL", "aa", 0, 5, null, null, null, null, null);
        silverboltTestBase.insertGasMerchantUser(0L, partnerId, userId1, null, roleNo1,
                UserType.DEVICE.code(), "收银员",
                null, "aa", null, null,
                "NORMAL",
                "aa", 0, 5, null, null, null, null, null, null, null);
        //地推员
        gasMerchantTestBase.insertGasMerchantUser(0L, userId2, null, roleNo2, UserType.DEVICE.code(), partnerId,
                partnerId,
                "地推员", null,
                "bb", null, null, "NORMAL", "bb", 0, 5, null, null, null, null, null);
        silverboltTestBase.insertGasMerchantUser(0L, partnerId, userId2, null, roleNo2,
                UserType.DEVICE.code(), "地推员",
                null, "bb", null, null,
                "NORMAL",
                "bb", 0, 5, null, null, null, null, null, null, null);
        //关联油站
        gasMerchantTestBase.insertGasMerchantUserStation(0L, userId1, stationId);
        gasMerchantTestBase.insertGasMerchantUserStation(0L, userId2, stationId);
        silverboltTestBase.insertGasMerchantUserStation(0L, partnerId, userId1, null, UserType.DEVICE.code(), "收银员",
                null, "aa", "NORMAL", stationId, null, null);
        silverboltTestBase.insertGasMerchantUserStation(0L, partnerId, userId2, null, UserType.DEVICE.code(), "地推员",
                null, "bb", "NORMAL", stationId, null, null);
        // 测试过程
        List<RoleType> roleTypes = new ArrayList<RoleType>();
        roleTypes.add(RoleType.Supplier);
        if (testId == 1001 || testId == 1004) {
            order.setRoleTypes(roleTypes);
        }
        if (testId == 1002) {
            order.setStationId(stationId);
        }
        if (testId == 1004) {
            order.setRoleNo(roleNo);
        }
        // 调用接口
        PagedResult<MerchantUserDetailInfo> result = merchantUserService.pageQuery(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<MerchantUserDetailInfo> userInfos = result.getInfoList();
        if (testId == 1001 || testId == 1004) {
            assertEquals(1, userInfos.size());
            gasMerchantUserAssert(userInfos.get(0), partnerId, "自动化测试商家", userId, userType,
                    "用户名", operatorMobile, account, "NORMAL");
            gasMerchantRoleAssert(userInfos.get(0).getRoleInfo(), null, roleNo, RoleType.Supplier.code(), roleName);
            List<MerchantStationInfo> stationInfos = userInfos.get(0).getStationInfos();
            assertEquals(0, stationInfos.size());
        }
        if (testId == 1002 || testId == 1003) {
            assertEquals(2, userInfos.size());
            //操作员
            gasMerchantUserAssert(userInfos.get(0), partnerId, "自动化测试商家", userId2, UserType.DEVICE.code(),
                    "地推员", null, "bb", "NORMAL");
            gasMerchantUserAssert(userInfos.get(1), partnerId, "自动化测试商家", userId1, UserType.DEVICE.code(),
                    "收银员", null, "aa", "NORMAL");
            //角色
            gasMerchantRoleAssert(userInfos.get(0).getRoleInfo(), null, roleNo2, RoleType.Nonoperation.code(),
                    roleName2);
            gasMerchantRoleAssert(userInfos.get(1).getRoleInfo(), null, roleNo1, RoleType.Terminal.code(), roleName1);
            //油站
            for (MerchantUserDetailInfo userInfo : userInfos) {
                List<MerchantStationInfo> stationInfos = userInfo.getStationInfos();
                assertEquals(1, stationInfos.size());
                gasMerchantStationAssert(stationInfos.get(0), stationId, stationCode, stationName, "互联网产业园");
            }
        }
        if (testId == 1005) {
            assertEquals(0, userInfos.size());
        }
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanRoleByRoleNo(roleNo);
        gasMerchantTestBase.cleanRoleByRoleNo(roleNo1);
        gasMerchantTestBase.cleanRoleByRoleNo(roleNo2);
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantRoleByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantStationByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantUserStationByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantDeviceByPlatPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantUserByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantUserStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
    }

    /**
     *
     */
    @AutoTest(file = "gas_merchant/merchantUserServicePageQueryTestFailOne.csv")
    @DisplayName("分页查询用户--参数非法")
    public void merchantUserServicePageQueryTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            PageQueryMerchantUserOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setGid(null);
        }
        if (testId == 1002) {
            order = null;
        }
        // 调用接口
        PagedResult<MerchantUserDetailInfo> result = merchantUserService.pageQuery(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 商家操作员信息
     */
    private void gasMerchantUserAssert(
            MerchantUserDetailInfo userInfo,
            String platPartnerId,
            String platPartnerName,
            String userId,
            String userType,
            String userName,
            String mobile,
            String account,
            String status
    ) {
        assertEquals(userId, userInfo.getUserId());
        assertEquals(account, userInfo.getAccount());
        assertEquals(userName, userInfo.getUserName());
        assertEquals(mobile, userInfo.getMobileNo());
        assertEquals(userType, userInfo.getUserType().code());
        assertEquals(platPartnerId, userInfo.getPlatPartnerId());
        assertEquals(platPartnerId, userInfo.getPartnerId());
        assertEquals(platPartnerName, userInfo.getPartnerName());
        assertEquals(status, userInfo.getStatus().code());
        assertEquals(5, userInfo.getLoginErrorLimit());
    }

    /**
     * 油站信息
     */
    private void gasMerchantStationAssert(
            MerchantStationInfo stationInfo,
            String stationId,
            String stationCode,
            String stationName,
            String addr
    ) {
//            assertEquals(partnerId, stationInfo.getPartnerId());
        assertEquals(stationId, stationInfo.getStationId());
        assertEquals(stationCode, stationInfo.getStationCode());
        assertEquals(stationName, stationInfo.getStationName());
//        assertEquals("互联网产业园", stationInfo.getStationAddress());地址开发没返回
        assertEquals("ABLE", stationInfo.getStatus().code());
        assertEquals(false, stationInfo.isConnectOilMachine());
    }

    /**
     * 角色信息
     */
    private void gasMerchantRoleAssert(
            RoleInfo roleInfo,
            String parentId,
            String roleNo,
            String roleType,
            String roleName
    ) {
        assertEquals(parentId, roleInfo.getParentId());
        assertEquals(roleNo, roleInfo.getRoleNo());
        assertEquals(roleType, roleInfo.getRoleType().code());
        assertEquals(roleName, roleInfo.getRoleName());
    }
}
