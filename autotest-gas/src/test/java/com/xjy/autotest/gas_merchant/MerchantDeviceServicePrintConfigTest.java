package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.DeviceType;
import com.xyb.gas.merchant.api.enums.PrintType;
import com.xyb.gas.merchant.api.facade.MerchantDeviceService;
import com.xyb.gas.merchant.api.order.ManageDevicePrintConfigOrder;
import dal.model.gas_merchant.GasDevicePrintDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author nuomi@xinyebang.com
 * Created on 2018/08/21.
 */
public class MerchantDeviceServicePrintConfigTest extends SpringBootTestBase {

    @Reference(version = "1.0")
    MerchantDeviceService merchantDeviceService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001.新增小票配置，只传必填参数
     * 1002.新增小票配置，传入所有项
     * 1003.更新小票配置
     * 1004.同一油站新增多个小票配置
     */
    @AutoTest(file = "gas_merchant/merchantDeviceServicePrintConfigTestSuccess.csv")
    @DisplayName("终端小票配置--成功用例")
    public void merchantDeviceServicePrintConfigTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String stationId, String printId, PrintType printType,
            String printTitle, int sleepTime,
            ManageDevicePrintConfigOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasDevicePrintByPrintId(order.getPrintId());
        gasMerchantTestBase.cleanGasDevicePrintByPrintId(printId);
        gasMerchantTestBase.cleanGasDevicePrintByStationId(order.getStationId());
        gasMerchantTestBase.cleanGasDevicePrintByStationId(stationId);
        // 准备数据
        if (testId >= 1003) {
            gasMerchantInitDataBase.initGasDevicePrint(order.getPlatPartnerId(), printId, stationId, printType.code(),
                    printTitle, sleepTime);
        }
        // 测试过程
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = merchantDeviceService.printConfig(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasDevicePrintDO> gasDevicePrintDOS =
                gasMerchantTestBase.findGasDevicePrintByStationId(order.getStationId());
        if (testId == 1004) {
            assertEquals(2, gasDevicePrintDOS.size());
        } else {
            assertEquals(1, gasDevicePrintDOS.size());
        }
        for (GasDevicePrintDO gasDevicePrint : gasDevicePrintDOS) {
            if (testId == 1004) {
                if (gasDevicePrint.getPrintId().equals(printId)) {
                    assertEquals(printId, gasDevicePrint.getPrintId());
                    assertEquals(order.getPlatPartnerId(), gasDevicePrint.getPlatPartnerId());
                    assertEquals(stationId, gasDevicePrint.getStationId());
                    assertEquals(DeviceType.POS.code(), gasDevicePrint.getDeviceType());
                    assertEquals(printType.code(), gasDevicePrint.getPrintType());
                    assertEquals(printTitle, gasDevicePrint.getPrintTitle());
                    assertEquals(sleepTime, gasDevicePrint.getPrintSleep());
                } else {
                    //assertEquals(order.getId(), gasDevicePrint.getPrintId());
                    assertEquals(order.getPartnerId(), gasDevicePrint.getPlatPartnerId());
                    assertEquals(order.getStationId(), gasDevicePrint.getStationId());
                    assertEquals(order.getDeviceType().code(), gasDevicePrint.getDeviceType());
                    assertEquals(order.getPrintType().code(), gasDevicePrint.getPrintType());
                    assertEquals(order.getPrintTitle(), gasDevicePrint.getPrintTitle());
                    assertEquals(order.getPrintSleep(), gasDevicePrint.getPrintSleep());
                    assertEquals(DateUtils.formatDate(DateUtils.getSqlDate()),
                            DateUtils.formatDate(gasDevicePrint.getRawAddTime()));
                    assertEquals(DateUtils.formatDate(DateUtils.getSqlDate()),
                            DateUtils.formatDate(gasDevicePrint.getRawUpdateTime()));
                }
            } else {
//                assertEquals(order.getPrintId(), gasDevicePrint.getPrintId());
                assertEquals(order.getPartnerId(), gasDevicePrint.getPlatPartnerId());
                assertEquals(order.getStationId(), gasDevicePrint.getStationId());
                assertEquals(order.getDeviceType().code(), gasDevicePrint.getDeviceType());
                assertEquals(order.getPrintType().code(), gasDevicePrint.getPrintType());
                assertEquals(order.getPrintTitle(), gasDevicePrint.getPrintTitle());
                assertEquals(order.getPrintSleep(), gasDevicePrint.getPrintSleep());
//				assertNotEquals(gasDevicePrintDO.getRawUpdateTime(), gasDevicePrint.getRawUpdateTime());
            }
        }
        // 清除数据
        gasMerchantTestBase.cleanGasDevicePrintByPrintId(order.getPrintId());
        gasMerchantTestBase.cleanGasDevicePrintByPrintId(printId);
        gasMerchantTestBase.cleanGasDevicePrintByStationId(order.getStationId());
        gasMerchantTestBase.cleanGasDevicePrintByStationId(stationId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantDeviceServicePrintConfigTestFailOne.csv")
    @DisplayName("终端小票配置--参数非法")
    public void merchantDeviceServicePrintConfigTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ManageDevicePrintConfigOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setGid(null);
        }
        if (testId == 1002) {
            order.setStationId(null);
        }
        if (testId == 1003) {
            order.setPrintType(null);
        }
        if (testId == 1004) {
            order.setPrintTitle(null);
        }
        if (testId == 1005) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1006) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantDeviceService.printConfig(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }

    /**
     * 1001.修改时，小票配置未找到
     */
    @AutoTest(file = "gas_merchant/merchantDeviceServicePrintConfigTestFailTwo.csv")
    @DisplayName("终端小票配置--参数非法")
    public void merchantDeviceServicePrintConfigTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ManageDevicePrintConfigOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasDevicePrintByPrintId(order.getPrintId());
        // 准备数据
        // 测试过程
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = merchantDeviceService.printConfig(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }
}
