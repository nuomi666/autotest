package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.UserLoginStatus;
import com.xyb.gas.merchant.api.enums.UserType;
import com.xyb.gas.merchant.api.facade.MerchantDeviceService;
import com.xyb.gas.merchant.api.order.SetOneKeyFuncOrder;
import dal.model.gas_merchant.GasMerchantDeviceFunctionDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author nuomi@xinyebang.com
 * Created on 2018/08/21.
 */
public class MerchantDeviceServiceOneKeyFuncTest extends SpringBootTestBase {

    @Reference(version = "1.0")
    MerchantDeviceService merchantDeviceService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    /**
     * 1001.开启一键加油
     * 1002.修改已开启的一键加油
     */
    @AutoTest(file = "gas_merchant/merchantDeviceServiceOneKeyFuncTestSuccess.csv")
    @DisplayName("设置一键加油--成功用例")
    public void merchantDeviceServiceOneKeyFuncTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId, String partnerName, String userId,
            String stationId, String deviceCode,
            SetOneKeyFuncOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantDeviceFunctionByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantDeviceFunctionByStationId(order.getStationId());
        // 准备数据
        //商家
        gasMerchantInitDataBase.initGasMerchant(platPartnerId, partnerName, null, null, "1jlit8stfxpo11hge7qi",
                "1jlit82lowpo11hge7qi", "1jlit82lpllo11hge7qi", "Merchant", null, "ABLE");
        //商家操作员
        gasMerchantInitDataBase.initGasMerchantUser(platPartnerId, userId, OID.newID(), UserType.DEVICE.code(), null,
                "123456"
                , "cs123");
        //油站
        gasMerchantInitDataBase.initStationsWithOilGun(platPartnerId, stationId, null, null,
                null, "ABLE", null, null, null,
                null, null);
        //终端
        gasMerchantInitDataBase.initGasMerchantDevice(platPartnerId, order.getUserId(), order.getDeviceCode(),
                UserLoginStatus.login.code());
        if (testId == 1002) {
            gasMerchantInitDataBase.initGasDeviceFunction(platPartnerId, userId, stationId, deviceCode);
            gasMerchantInitDataBase.initGasMerchantDevice(platPartnerId, userId, deviceCode,
                    UserLoginStatus.login.code());
        }
        // 测试过程
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = merchantDeviceService.oneKeyFunc(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        gasDeviceFunctionAssert(platPartnerId, order.getUserId(), order.getStationId(), order.getDeviceCode(),
                order.isOpen() ? Byte.valueOf("1") : Byte.valueOf("0"));
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantDeviceFunctionByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantDeviceFunctionByStationId(order.getStationId());
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasMerchantStationByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantDeviceByPlatPartnerId(platPartnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(platPartnerId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantUserByUserId(userId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(platPartnerId);
        xybUserTestBase.cleanAccountByUserId(platPartnerId);
    }

    /**
     *
     */
    @AutoTest(file = "gas_merchant/merchantDeviceServiceOneKeyFuncTestFailOne.csv")
    @DisplayName("设置一键加油--参数非法")
    public void merchantDeviceServiceOneKeyFuncTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            SetOneKeyFuncOrder order
    ) {
        // 清除数据
        // 准备数据

        // 测试过程
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setStationId(null);
        }
        if (testId == 1002) {
            order.setDeviceCode(null);
        }
        if (testId == 1003) {
            order.setUserId(null);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantDeviceService.oneKeyFunc(order);
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
     */
    @AutoTest(file = "gas_merchant/merchantDeviceServiceOneKeyFuncTestFailTwo.csv")
    @DisplayName("设置一键加油--失败用例")
    public void merchantDeviceServiceOneKeyFuncTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId, String userId,
            String stationId, String deviceCode,
            SetOneKeyFuncOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantDeviceFunctionByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantDeviceFunctionByStationId(order.getStationId());
        // 准备数据
        //商家
        if (testId != 1001) {
            gasMerchantInitDataBase.initGasMerchant(platPartnerId, null, null, null, "1jlit8stfxpo11hge7qi",
                    "1jlit82lowpo11hge7qi", "1jlit82lpllo11hge7qi", "Merchant", null, "ABLE");
        }
        //商家操作员
        gasMerchantInitDataBase.initGasMerchantUser(platPartnerId, userId, OID.newID(), UserType.DEVICE.code(), null,
                "123456"
                , "cs123");
        //油站
        if (testId != 1002) {
            gasMerchantInitDataBase.initStationsWithOilGun(platPartnerId, stationId, null, null,
                    null, "ABLE", null, null,
                    null, null, null);
        }
        //终端
        gasMerchantInitDataBase.initGasMerchantDevice(platPartnerId, order.getUserId(), order.getDeviceCode(),
                UserLoginStatus.login.code());
        if (testId == 1002) {
            gasMerchantInitDataBase.initGasDeviceFunction(platPartnerId, userId, stationId, deviceCode);
            gasMerchantInitDataBase.initGasMerchantDevice(platPartnerId, userId, deviceCode,
                    UserLoginStatus.login.code());
        }
        // 测试过程
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = merchantDeviceService.oneKeyFunc(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasMerchantDeviceFunctionDO> deviceFunctionDOS =
                gasMerchantTestBase.findGasMerchantDeviceFunctionByStationId(stationId);
        assertTrue(deviceFunctionDOS.size() == 0);
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantDeviceFunctionByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantDeviceFunctionByStationId(order.getStationId());
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasMerchantStationByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantDeviceByPlatPartnerId(platPartnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(platPartnerId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantUserByUserId(userId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(platPartnerId);
        xybUserTestBase.cleanAccountByUserId(platPartnerId);
    }

    /**
     * 商家油站功能配置表校验
     *
     * @param platPartnerId
     * @param userId
     * @param stationId
     * @param deviceCode
     */
    private void gasDeviceFunctionAssert(
            String platPartnerId,
            String userId,
            String stationId,
            String deviceCode,
            Byte open
    ) {
        List<GasMerchantDeviceFunctionDO> deviceFunctionDOS =
                gasMerchantTestBase.findGasMerchantDeviceFunctionByStationId(stationId);
        assertEquals(1, deviceFunctionDOS.size());
        for (GasMerchantDeviceFunctionDO functionInfo : deviceFunctionDOS) {
            assertEquals(platPartnerId, functionInfo.getPlatPartnerId());
            assertEquals(platPartnerId, functionInfo.getPartnerId());
            assertEquals(stationId, functionInfo.getStationId());
            assertEquals("ONE_KEY", functionInfo.getFuncType());
            assertEquals(open, functionInfo.getOpen());
            assertEquals("POS", functionInfo.getDeviceType());
            assertEquals(deviceCode, functionInfo.getDeviceCode());
            assertEquals(userId, functionInfo.getUserId());
        }
    }
}
