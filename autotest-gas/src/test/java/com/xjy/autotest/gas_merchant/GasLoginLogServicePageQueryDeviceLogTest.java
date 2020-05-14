package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.PagedResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.DeviceType;
import com.xyb.gas.merchant.api.facade.GasLoginLogService;
import com.xyb.gas.merchant.api.info.GasLoginLogInfo;
import com.xyb.gas.merchant.api.order.PageQueryGasLoginLogOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


/**
 * @author nuomi
 * Created on 2019/10/15.
 */
public class GasLoginLogServicePageQueryDeviceLogTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    GasLoginLogService gasLoginLogService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001.只传必填项，查询出来2条，每页显示10条，显示第1页
     * 1002.只传必填项，查询出来3条，每页显示2条，显示第1页
     * 1003.只传必填项，查询出来3条，每页显示2条，显示第2页
     * 1004.传入所有项，查询出来2条，每页显示10条，显示第1页
     */
    @AutoTest(file = "gas_merchant/gasLoginLogServicePageQueryDeviceLogTestSuccess.csv")
    @DisplayName("分页查询设备登陆、登出记录--成功用例")
    public void gasLoginLogServicePageQueryDeviceLogTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId, String partnerName,
            String stationId, String stationId1, String stationName, String stationName1,
            String userId, String userId1, String userName, String userName1,
            String account, String account1, String deviceCode,
            PageQueryGasLoginLogOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasLoginLogByPlatPartnerId(platPartnerId);
        // 准备数据
        Date loginTime = DateUtils.parseDate2("2019-10-01 10:10:10");
        Date loginTime1 = DateUtils.parseDate2("2019-10-02 11:11:11");
        Date loginTime2 = DateUtils.parseDate2("2019-10-03 12:12:12");
        Date loginTime3 = DateUtils.parseDate2("2019-10-01 08:08:08");
        Date logOutTime = DateUtils.parseDate2("2019-10-01 12:00:00");
        Date logOutTime1 = DateUtils.parseDate2("2019-10-02 16:00:00");
        Date logOutTime2 = DateUtils.parseDate2("2019-10-01 10:00:00");
        gasMerchantInitDataBase.initGasLoginLogWithLogOut(false, platPartnerId, partnerName, stationId, stationName
                , userId, userName, account, deviceCode, loginTime, logOutTime);
        if (testId == 1002 || testId == 1004) {//相同的油站不同的收银员登录过
            gasMerchantInitDataBase.initGasLoginLogWithLogOut(false, platPartnerId, partnerName, stationId,
                    stationName, userId1, userName1, account1, deviceCode, loginTime1, logOutTime1);
        }
        if (testId == 1003) {//不同的油站不同的收银员登录过
            gasMerchantInitDataBase.initGasLoginLogWithLogOut(false, platPartnerId, partnerName, stationId1,
                    stationName1, userId1, userName1, account1, deviceCode, loginTime3, logOutTime2);
        }
        gasMerchantInitDataBase.initGasLoginLogWithLogin(false, platPartnerId, partnerName, stationId, stationName,
                userId, userName, account, deviceCode, loginTime2);
        // 测试过程
        order.setGid(GID.newGID());
        if (testId != 1004) {
            order.setUserId(null);
        }
        // 调用接口
        PagedResult<GasLoginLogInfo> result = gasLoginLogService.pageQueryDeviceLog(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasLoginLogInfo> loginInfos = result.getInfoList();
        for (GasLoginLogInfo loginInfo : loginInfos) {
            assertEquals(DeviceType.POS, loginInfo.getDeviceType());
            assertEquals(deviceCode, loginInfo.getDeviceCode());
            assertEquals(platPartnerId, loginInfo.getPlatPartnerId());
            assertEquals(platPartnerId, loginInfo.getPartnerId());
            assertEquals(partnerName, loginInfo.getPlatPartnerName());
        }
        if (testId == 1001 || testId == 1004) {
            assertEquals(2, loginInfos.size());
            assertEquals(loginTime, loginInfos.get(1).getLoginTime());
            assertEquals(logOutTime, loginInfos.get(1).getLogoutTime());
            assertEquals(loginTime2, loginInfos.get(0).getLoginTime());
            assertEquals(null, loginInfos.get(0).getLogoutTime());
            for (GasLoginLogInfo loginInfo : loginInfos) {
                assertEquals(stationId, loginInfo.getStationId());
                assertEquals(stationName, loginInfo.getStationName());
                assertEquals(account, loginInfo.getAccount());
                assertEquals(userId, loginInfo.getUserId());
                assertEquals(userName, loginInfo.getUserName());
            }
        }
        if (testId == 1002) {
            assertEquals(2, loginInfos.size());
            assertEquals(loginTime1, loginInfos.get(1).getLoginTime());
            assertEquals(logOutTime1, loginInfos.get(1).getLogoutTime());
            assertEquals(account1, loginInfos.get(1).getAccount());
            assertEquals(userId1, loginInfos.get(1).getUserId());
            assertEquals(userName1, loginInfos.get(1).getUserName());
            assertEquals(loginTime2, loginInfos.get(0).getLoginTime());
            assertEquals(account, loginInfos.get(0).getAccount());
            assertEquals(userId, loginInfos.get(0).getUserId());
            assertEquals(userName, loginInfos.get(0).getUserName());
            assertEquals(null, loginInfos.get(0).getLogoutTime());
            for (GasLoginLogInfo loginInfo : loginInfos) {
                assertEquals(stationId, loginInfo.getStationId());
                assertEquals(stationName, loginInfo.getStationName());
            }
        }
        if (testId == 1003) {
            assertEquals(1, loginInfos.size());
            for (GasLoginLogInfo loginInfo : loginInfos) {
                assertEquals(stationId1, loginInfo.getStationId());
                assertEquals(stationName1, loginInfo.getStationName());
                assertEquals(account1, loginInfo.getAccount());
                assertEquals(userId1, loginInfo.getUserId());
                assertEquals(userName1, loginInfo.getUserName());
                assertEquals(loginTime3, loginInfo.getLoginTime());
                assertEquals(logOutTime2, loginInfo.getLogoutTime());
            }
        }
        // 清除数据
        gasMerchantTestBase.cleanGasLoginLogByPlatPartnerId(platPartnerId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/gasLoginLogServicePageQueryDeviceLogTestFailOne.csv")
    @DisplayName("分页查询设备登陆、登出记录--参数非法")
    public void gasLoginLogServicePageQueryDeviceLogTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            PageQueryGasLoginLogOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setDeviceType(DeviceType.BOSS);
        }
        if (testId == 1002) {
            order.setDeviceType(null);
        }
        if (testId == 1003) {
            order.setDeviceCode(null);
        }
        if (testId == 1004) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1005) {
            order.setGid(null);
        }
        if (testId == 1006) {
            order = null;
        }
        // 调用接口
        PagedResult<GasLoginLogInfo> result = gasLoginLogService.pageQueryDeviceLog(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
