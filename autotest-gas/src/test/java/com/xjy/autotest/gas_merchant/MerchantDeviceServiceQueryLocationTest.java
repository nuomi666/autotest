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
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.UserLoginStatus;
import com.xyb.gas.merchant.api.facade.MerchantDeviceService;
import com.xyb.gas.merchant.api.info.OneKeyStationInfo;
import com.xyb.gas.merchant.api.order.common.CommonBaseOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


/**
 * @author nuomi
 * Created on 2019/11/07.
 */
public class MerchantDeviceServiceQueryLocationTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
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
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantDeviceServiceQueryLocationTestSuccess.csv")
    @DisplayName("查询油站定位--成功用例")
    public void merchantDeviceServiceQueryLocationTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId, String userId,
            String stationId, String deviceCode,
            CommonBaseOrder order
    ) {
        // 清除数据
        // 准备数据
        //商家
        gasMerchantInitDataBase.initGasMerchant(platPartnerId, null, null, null, "1jlit8stfxpo11hge7qi",
                "1jlit82lowpo11hge7qi", "1jlit82lpllo11hge7qi", "Merchant", null, "ABLE");
        //油站
        gasMerchantInitDataBase.initStationsWithOilGun(platPartnerId, stationId, null, null,
                null, "ABLE", null, null,
                null, null, null);
        //终端
        gasMerchantInitDataBase.initGasMerchantDevice(platPartnerId, userId, deviceCode,
                UserLoginStatus.login.code());
        Map<String, Object> param = gasMerchantInitDataBase.initGasDeviceFunction(platPartnerId, userId, stationId,
                deviceCode);
//        String id = param.get("id").toString();
        // 测试过程
        order.setGid(GID.newGID());
        order.setId(stationId);
        // 调用接口
        BizResult<OneKeyStationInfo> result = merchantDeviceService.queryLocation(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        assertEquals(platPartnerId, result.getInfo().getPlatPartnerId());
        assertEquals(platPartnerId, result.getInfo().getPartnerId());
        assertEquals(stationId, result.getInfo().getStationId());
        assertEquals(null, result.getInfo().getStationName());
        assertEquals(null, result.getInfo().getStationCode());
        assertEquals("金开大道互联网产业园13幢3楼", result.getInfo().getStationAddress());
        assertEquals("ABLE", result.getInfo().getStatus().code());
        assertEquals(null, result.getInfo().getUserName());
        assertEquals(true, result.getInfo().isOpen());
        assertEquals(true, result.getInfo().isReport());
        assertEquals(userId, result.getInfo().getUserId());
        assertEquals(106.489838082, result.getInfo().getLongitude());
        assertEquals(29.6219092167, result.getInfo().getLatitude());
        assertEquals(deviceCode, result.getInfo().getDeviceCode());
        assertEquals(0.0, result.getInfo().getDistance());
        assertEquals(null, result.getInfo().getOilDescript());
        assertEquals(null, result.getInfo().getGoodsPriceInfos());
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantDeviceFunctionByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasMerchantStationByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantDeviceByPlatPartnerId(platPartnerId);
        silverboltTestBase.cleanGasMerchantGoodsByPartnerId(platPartnerId);
        silverboltTestBase.cleanGasMerchantUserByUserId(userId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(platPartnerId);
        xybUserTestBase.cleanAccountByUserId(platPartnerId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantDeviceServiceQueryLocationTestFailOne.csv")
    @DisplayName("查询油站定位--参数非法")
    public void merchantDeviceServiceQueryLocationTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CommonBaseOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        BizResult<OneKeyStationInfo> result = merchantDeviceService.queryLocation(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

}
