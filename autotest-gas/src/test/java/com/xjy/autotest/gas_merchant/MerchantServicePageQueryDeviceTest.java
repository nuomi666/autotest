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
import com.xyb.adk.common.lang.result.PagedResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.DeviceType;
import com.xyb.gas.merchant.api.enums.UserLoginStatus;
import com.xyb.gas.merchant.api.facade.MerchantService;
import com.xyb.gas.merchant.api.info.DeviceWorkInfo;
import com.xyb.gas.merchant.api.order.PageQueryMerchantDeviceOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


/**
 * @author nuomi
 * Created on 2019/11/26.
 */
public class MerchantServicePageQueryDeviceTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantService merchantService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    /**
     * 1001.只传终端类型查询
     * 1002.传入终端类型和商户ID查询
     * 1003.传入终端类型、商户ID和设备编号查询
     */
    @AutoTest(file = "gas_merchant/merchantServicePageQueryDeviceTestSuccess.csv")
    @DisplayName("分页查询商户终端登陆收银员信息--成功用例")
    public void merchantServicePageQueryDeviceTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String partnerId1,
            String partnerName, String partnerName1,
            String shortName, String shortName1,
            String mobile, String mobile1,
            String sourceKey, String sourceKey1,
            String merchantStatus, String merchantStatus1,
            String model, String model1,
            String userId, String userId1,
            String userName, String userName1,
            String stationId, String stationName,
            String stationId1, String stationName1,
            String account, String account1,
            String deviceCode, String deviceCode1, String deviceCode2,
            PageQueryMerchantDeviceOrder order
    ) {
        // 清除数据
        // 准备数据
        Date loginTime = DateUtils.parseDate2("2019-11-20 14:19:47");
        Date logoutTime = DateUtils.parseDate2("2019-11-20 18:19:47");
        Date loginTime1 = DateUtils.parseDate2("2019-11-22 10:30:47");
        Date loginTime2 = DateUtils.parseDate2("2019-11-26 12:30:47");
        //商户数据
        gasMerchantInitDataBase.initGasMerchants(partnerId, partnerId1, partnerName, partnerName1, shortName,
                shortName1, mobile, mobile1, sourceKey, sourceKey1, merchantStatus, merchantStatus1, model, model1,
                null, null);
        //登录信息
        gasMerchantInitDataBase.initGasLoginLogWithLogOut(true, partnerId, partnerName,
                stationId, stationName, userId, userName, account,
                deviceCode, loginTime, logoutTime);
        gasMerchantInitDataBase.initGasLoginLogWithLogin(false, partnerId, partnerName,
                stationId, stationName, userId, userName, account,
                deviceCode, loginTime1);
        gasMerchantInitDataBase.initGasLoginLogWithLogin(true, partnerId1, partnerName1,
                stationId1, stationName1, userId1, userName1, account1,
                deviceCode1, loginTime2);
        //终端信息
        gasMerchantInitDataBase.initGasMerchantDevice(partnerId, userId, deviceCode, UserLoginStatus.login.code());
        gasMerchantInitDataBase.initGasMerchantDevice(partnerId, null, deviceCode2, UserLoginStatus.logout.code());
        gasMerchantInitDataBase.initGasMerchantDevice(partnerId1, userId1, deviceCode1, UserLoginStatus.login.code());
        // 测试过程
        // 调用接口
        PagedResult<DeviceWorkInfo> result = merchantService.pageQueryDevice(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            deviceWorkInfoAssert(3, result.getInfoList(), partnerId, partnerId1, partnerName, partnerName1,
                    userId, userId1, userName, userName1, account, account1, deviceCode, deviceCode1, deviceCode2,
                    loginTime1, loginTime2);
        }
        if (testId == 1002) {
            deviceWorkInfoAssert(2, result.getInfoList(), partnerId, partnerId1, partnerName, partnerName1,
                    userId, userId1, userName, userName1, account, account1, deviceCode, deviceCode1, deviceCode2,
                    loginTime1, loginTime2);
        }
        if (testId == 1003) {
            deviceWorkInfoAssert(1, result.getInfoList(), partnerId, partnerId1, partnerName, partnerName1,
                    userId, userId1, userName, userName1, account, account1, deviceCode, deviceCode1, deviceCode2,
                    loginTime1, loginTime2);
        }
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId1);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId1);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId1);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId1);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId1);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId1);
        merchantTestBase.cleanGasMerchantDeviceByDeviceCode(deviceCode);
        merchantTestBase.cleanGasMerchantDeviceByDeviceCode(deviceCode1);
        merchantTestBase.cleanGasMerchantDeviceByDeviceCode(deviceCode2);
        merchantTestBase.cleanGasLoginLogByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasLoginLogByPlatPartnerId(partnerId1);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId1);
    }

    /**
     * 1001.终端类型为空
     * 1002.gid为空
     * 1003.order为空
     */
    @AutoTest(file = "gas_merchant/merchantServicePageQueryDeviceTestFailOne.csv")
    @DisplayName("分页查询商户终端登陆收银员信息--参数非法")
    public void merchantServicePageQueryDeviceTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            PageQueryMerchantDeviceOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setDeviceType(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        PagedResult<DeviceWorkInfo> result = merchantService.pageQueryDevice(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 商户终端登陆收银员信息校验
     *
     * @param count
     * @param deviceInfos
     * @param partnerId
     * @param partnerId1
     * @param partnerName
     * @param partnerName1
     * @param userId
     * @param userId1
     * @param userName
     * @param userName1
     * @param account
     * @param account1
     * @param deviceCode
     * @param deviceCode1
     * @param deviceCode2
     * @param loginTime
     * @param loginTime1
     */
    private void deviceWorkInfoAssert(
            int count,
            List<DeviceWorkInfo> deviceInfos,
            String partnerId, String partnerId1,
            String partnerName, String partnerName1,
            String userId, String userId1,
            String userName, String userName1,
            String account, String account1,
            String deviceCode, String deviceCode1,
            String deviceCode2, Date loginTime,
            Date loginTime1
    ) {
        assertEquals(count, deviceInfos.size());
        for (DeviceWorkInfo deviceInfo : deviceInfos) {
            assertEquals(DeviceType.POS, deviceInfo.getDeviceType());
            if (deviceCode.equals(deviceInfo.getDeviceCode())) {
                assertEquals(partnerId, deviceInfo.getPartnerId());
                assertEquals(partnerId, deviceInfo.getPlatPartnerId());
                assertEquals(partnerName, deviceInfo.getPartnerName());
                assertEquals(account, deviceInfo.getAccount());
                assertEquals(userName, deviceInfo.getUserName());
                assertEquals(userId, deviceInfo.getUserId());
                assertEquals(loginTime, deviceInfo.getWorkStartTime());
            }
            if (deviceCode1.equals(deviceInfo.getDeviceCode())) {
                assertEquals(partnerId1, deviceInfo.getPartnerId());
                assertEquals(partnerId1, deviceInfo.getPlatPartnerId());
                assertEquals(partnerName1, deviceInfo.getPartnerName());
                assertEquals(account1, deviceInfo.getAccount());
                assertEquals(userName1, deviceInfo.getUserName());
                assertEquals(userId1, deviceInfo.getUserId());
                assertEquals(loginTime1, deviceInfo.getWorkStartTime());
            }
            if (deviceCode2.equals(deviceInfo.getDeviceCode())) {
                assertEquals(partnerId, deviceInfo.getPartnerId());
                assertEquals(partnerId, deviceInfo.getPlatPartnerId());
                assertEquals(partnerName, deviceInfo.getPartnerName());
                assertEquals(null, deviceInfo.getAccount());
                assertEquals(null, deviceInfo.getUserName());
                assertEquals(null, deviceInfo.getUserId());
                assertEquals(null, deviceInfo.getWorkStartTime());
            }
        }
    }
}
