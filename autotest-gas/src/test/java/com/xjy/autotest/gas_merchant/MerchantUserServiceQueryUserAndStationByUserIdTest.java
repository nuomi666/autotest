package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.MerchantUserService;
import com.xyb.gas.merchant.api.info.MerchantStationInfo;
import com.xyb.gas.merchant.api.info.MerchantUserDetailInfo;
import com.xyb.gas.merchant.api.order.QueryMerchantUserOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


/**
 * @author nuomi
 * Created on 2020/01/06.
 */
public class MerchantUserServiceQueryUserAndStationByUserIdTest extends SpringBootTestBase {

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
     * -1.根据员工id 查询油站以及员工信息
     * -2. 注意该接口为查询验证接口 如果不存在应返回失败
     * -3. 该接口提供给h5 油站推广使用(推广注册)
     * 1001.查询站长
     * 1002.查询收银员
     * 1003.查询地推员
     */
    @AutoTest(file = "gas_merchant/merchantUserServiceQueryUserAndStationByUserIdTestSuccess.csv")
    @DisplayName("查询用户详情--成功用例")
    public void merchantUserServiceQueryUserAndStationByUserIdTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String mobile,
            String sourceKey, String stationCode,
            String stationName, String userType,
            String roleType,
            String roleName, String deviceType,
            String sourceName, String account,
            String password, String operatorMobile,
            QueryMerchantUserOrder order
    ) {
        // 清除数据
        // 准备数据
        Map<String, Object> params = gasMerchantInitDataBase.initMerchantUser(partnerId, mobile,
                sourceKey, "Merchant", "ABLE", stationCode,
                stationName, userType, "NORMAL", roleType, roleName,
                deviceType, account, sourceName, password, operatorMobile);
        String userId = params.get("userId").toString();
        String stationId = params.get("stationId").toString();
        String roleNo = params.get("roleNo").toString();
        // 测试过程
        order.setUserId(userId);
        // 调用接口
        BizResult<MerchantUserDetailInfo> result =
                merchantUserService.queryUserAndStationByUserId(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        MerchantUserDetailInfo userInfo = result.getInfo();
        gasMerchantUserAssert(userInfo, partnerId, "自动化测试商家", userId, userType,
                "用户名", operatorMobile, account, "NORMAL");
//        RoleInfo roleInfo = result.getInfo().getRoleInfo();
//        assertEquals(null, roleInfo.getParentId());
//        assertEquals(roleId, roleInfo.getId());
//        assertEquals(roleType, roleInfo.getRoleType().code());
//        assertEquals(roleName, roleInfo.getRoleName());
        List<MerchantStationInfo> stationInfos = result.getInfo().getStationInfos();
        assertEquals(1, stationInfos.size());
        for (MerchantStationInfo stationInfo : stationInfos) {//其他油站信息开发没返回
//            assertEquals(partnerId, stationInfo.getPartnerId());
            assertEquals(stationId, stationInfo.getStationId());
            assertEquals(stationCode, stationInfo.getStationCode());
            assertEquals(stationName, stationInfo.getStationName());
            assertEquals("互联网产业园", stationInfo.getStationAddress());
            assertEquals("ABLE", stationInfo.getStatus().code());
            assertEquals(false, stationInfo.isConnectOilMachine());
        }
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantStationByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantUserStationByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantDeviceByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanRoleByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanUserUniqueKeyByUserId(userId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantUserByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantUserStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
    }

    /**
     *
     */
    @AutoTest(file = "gas_merchant/merchantUserServiceQueryUserAndStationByUserIdTestFailOne.csv")
    @DisplayName("查询用户详情--参数非法")
    public void merchantUserServiceQueryUserAndStationByUserIdTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryMerchantUserOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setUserId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        BizResult<MerchantUserDetailInfo> result =
                merchantUserService.queryUserAndStationByUserId(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * -1.根据员工id 查询油站以及员工信息
     * -2. 注意该接口为查询验证接口 如果不存在应返回失败
     * -3. 该接口提供给h5 油站推广使用(推广注册)
     * 1001.商家不存在
     */
    @AutoTest(file = "gas_merchant/merchantUserServiceQueryUserAndStationByUserIdTestFailTwo.csv")
    @DisplayName("查询用户详情--失败用例")
    public void merchantUserServiceQueryUserAndStationByUserIdTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryMerchantUserOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        BizResult<MerchantUserDetailInfo> result =
                merchantUserService.queryUserAndStationByUserId(order);
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
}
