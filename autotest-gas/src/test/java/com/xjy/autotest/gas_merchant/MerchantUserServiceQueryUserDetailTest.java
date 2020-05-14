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
import com.xyb.gas.merchant.api.info.role.RoleInfo;
import com.xyb.gas.merchant.api.info.user.QueryMerchantUserDetailInfo;
import com.xyb.gas.merchant.api.order.QueryMerchantUserOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


/**
 * @author nuomi
 * Created on 2020/01/07.
 */
public class MerchantUserServiceQueryUserDetailTest extends SpringBootTestBase {

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
    @AutoTest(file = "gas_merchant/merchantUserServiceQueryUserDetailTestSuccess.csv")
    @DisplayName("查询用户详情--成功用例")
    public void merchantUserServiceQueryUserDetailTestSuccess(
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
        if (testId != 1004) {
            order.setUserId(userId);
        }
        // 调用接口
        BizResult<QueryMerchantUserDetailInfo> result = merchantUserService.queryUserDetail(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        QueryMerchantUserDetailInfo userInfo = result.getInfo();
        if (testId == 1004) {
            assertEquals(null, userInfo);
        } else {
            gasMerchantUserAssert(userInfo, partnerId, "自动化测试商家", userId, userType,
                    "用户名", operatorMobile, account, "NORMAL");
            RoleInfo roleInfo = result.getInfo().getRoleInfo();
            assertEquals(roleNo, roleInfo.getRoleNo());
            assertEquals(roleType, roleInfo.getRoleType().code());
            assertEquals(roleName, roleInfo.getRoleName());
            List<String> stationInfos = result.getInfo().getStationInfos();
            assertEquals(1, stationInfos.size());
//            for (MerchantStationInfo stationInfo : stationInfos) {//其他油站信息开发没返回
//            assertEquals(partnerId, stationInfo.getPartnerId());
//                assertEquals(stationId, stationInfo.getStationId());
//                assertEquals(stationCode, stationInfo.getStationCode());
//                assertEquals(stationName, stationInfo.getStationName());
//                assertEquals("互联网产业园", stationInfo.getStationAddress());
//                assertEquals("ABLE", stationInfo.getStatus().code());
//                assertEquals(false, stationInfo.isConnectOilMachine());
//            }
        }
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanRoleByRoleNo(roleNo);
        gasMerchantTestBase.cleanUserUniqueKeyByUserId(userId);
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
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantUserServiceQueryUserDetailTestFailOne.csv")
    @DisplayName("查询用户详情--参数非法")
    public void merchantUserServiceQueryUserDetailTestFailOne(
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
        BizResult<QueryMerchantUserDetailInfo> result = merchantUserService.queryUserDetail(order);
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
            QueryMerchantUserDetailInfo userInfo,
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
//        assertEquals(platPartnerName, userInfo.getPartnerName());
        assertEquals(status, userInfo.getStatus().code());
        assertEquals(5, userInfo.getLoginErrorLimit());
    }
}
