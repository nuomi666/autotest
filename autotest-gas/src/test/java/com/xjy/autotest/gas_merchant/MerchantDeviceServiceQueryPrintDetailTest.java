package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.DeviceType;
import com.xyb.gas.merchant.api.enums.PrintType;
import com.xyb.gas.merchant.api.facade.MerchantDeviceService;
import com.xyb.gas.merchant.api.info.DevicePrintInfo;
import com.xyb.gas.merchant.api.order.common.CommonBaseOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2019/10/18.
 */
public class MerchantDeviceServiceQueryPrintDetailTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantDeviceService merchantDeviceService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantDeviceServiceQueryPrintDetailTestSuccess.csv")
    @DisplayName("查询小票详情--成功用例")
    public void merchantDeviceServiceQueryPrintDetailTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId, String stationId,
            PrintType printType, String printTitle, int sleepTime,
            CommonBaseOrder order
    ) {
        // 清除数据
        // 准备数据
        gasMerchantInitDataBase.initGasDevicePrint(platPartnerId, order.getId(), stationId, printType.code(),
                printTitle, sleepTime);
        // 测试过程
        // 调用接口
        BizResult<DevicePrintInfo> result = merchantDeviceService.queryPrintDetail(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        DevicePrintInfo printInfo = result.getInfo();
//        assertEquals(platPartnerId, printInfo.getPartnerId());
        assertEquals(platPartnerId, printInfo.getPlatPartnerId());
        assertEquals(printType, printInfo.getPrintType());
        assertEquals(printTitle, printInfo.getPrintTitle());
        assertEquals(DeviceType.POS, printInfo.getDeviceType());
        assertEquals(stationId, printInfo.getStationId());
        assertEquals(order.getId(), printInfo.getPrintId());
        assertEquals(sleepTime, printInfo.getPrintSleep());
        // 清除数据
        gasMerchantTestBase.cleanGasDevicePrintByPrintId(order.getId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantDeviceServiceQueryPrintDetailTestFailOne.csv")
    @DisplayName("查询小票详情--参数非法")
    public void merchantDeviceServiceQueryPrintDetailTestFailOne(
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
            order.setGid(null);
        }
        if (testId == 1002) {
            order.setId(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        BizResult<DevicePrintInfo> result = merchantDeviceService.queryPrintDetail(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantDeviceServiceQueryPrintDetailFailTwo.csv")
    @DisplayName("查询小票详情--失败用例")
    public void merchantDeviceServiceQueryPrintDetailFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CommonBaseOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasDevicePrintByPrintId(order.getId());
        // 准备数据
        // 测试过程
        order.setGid(GID.newGID());
        // 调用接口
        BizResult<DevicePrintInfo> result = merchantDeviceService.queryPrintDetail(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        gasMerchantTestBase.cleanGasDevicePrintByPrintId(order.getId());
    }

}
