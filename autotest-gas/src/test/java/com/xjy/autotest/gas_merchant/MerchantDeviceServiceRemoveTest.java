package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.PrintType;
import com.xyb.gas.merchant.api.facade.MerchantDeviceService;
import com.xyb.gas.merchant.api.order.common.CommonBaseOrder;
import dal.model.gas_merchant.GasDevicePrintDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author nuomi@xinyebang.com
 * Created on 2018/08/21.
 */
public class MerchantDeviceServiceRemoveTest extends SpringBootTestBase {

    @Reference(version = "1.0")
    MerchantDeviceService merchantDeviceService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantDeviceServiceRemoveTestSuccess.csv")
    @DisplayName("删除小票配置--成功用例")
    public void merchantDeviceServiceRemoveTestSuccess(
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
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = merchantDeviceService.remove(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasDevicePrintDO> gasDevicePrintDOS = gasMerchantTestBase.findGasDevicePrintByPrintId(order.getId());
        assertTrue(gasDevicePrintDOS.size() == 0);
        // 清除数据
        gasMerchantTestBase.cleanGasDevicePrintByPrintId(order.getId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantDeviceServiceRemoveTestFailOne.csv")
    @DisplayName("删除小票配置--参数非法")
    public void merchantDeviceServiceRemoveTestFailOne(
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
        SimpleResult result = merchantDeviceService.remove(order);
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
    @AutoTest(file = "gas_merchant/merchantDeviceServiceRemoveTestFailTwo.csv")
    @DisplayName("删除小票配置--失败用例")
    public void merchantDeviceServiceRemoveTestFailTwo(
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
        SimpleResult result = merchantDeviceService.remove(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        gasMerchantTestBase.cleanGasDevicePrintByPrintId(order.getId());
    }
}
