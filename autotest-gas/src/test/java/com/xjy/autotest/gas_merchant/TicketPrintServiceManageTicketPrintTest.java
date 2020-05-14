package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.TicketPrintService;
import com.xyb.gas.merchant.api.order.ticket.ManageTicketPrintOrder;
import com.xyb.gas.merchant.api.order.ticket.TicketPrintOrder;
import dal.model.gas_merchant.GasTicketPrintDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2019/12/18.
 */
public class TicketPrintServiceManageTicketPrintTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    TicketPrintService ticketPrintService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/ticketPrintServiceManageTicketPrintTestSuccess.csv")
    @DisplayName("小票打印配置--成功用例")
    public void ticketPrintServiceManageTicketPrintTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ManageTicketPrintOrder order,
            TicketPrintOrder ticketPrintOrder,
            TicketPrintOrder ticketPrintOrder1,
            TicketPrintOrder ticketPrintOrder2
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasTicketPrintByStationId(order.getStationId());
        // 准备数据
        gasMerchantTestBase.insertGasTicketPrint(0, order.getStationId(), ticketPrintOrder.getPrintType().code(), 3,
                3, "更新前配置", null, null);
        // 测试过程
        List<TicketPrintOrder> printOrders = new ArrayList<TicketPrintOrder>();
        printOrders.add(ticketPrintOrder);
        if (testId == 1002 || testId == 1004) {
            printOrders.add(ticketPrintOrder1);
            printOrders.add(ticketPrintOrder2);
        }
        order.setPrintOrders(printOrders);
        // 调用接口
        SimpleResult result = ticketPrintService.manageTicketPrint(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasTicketPrintDO> tickePrints = gasMerchantTestBase.findGasTicketPrintByStationId(order.getStationId());
        if (testId == 1001 || testId == 1003) {
            assertEquals(1, tickePrints.size());
            for (GasTicketPrintDO tickePrint : tickePrints) {
                ticketPrintAssert(tickePrint, order.getStationId(), ticketPrintOrder.getPrintType().code(),
                        ticketPrintOrder.getPrintNum(), order.getPrintSleep(), ticketPrintOrder.getMemo());
            }
        }
        if (testId == 1002 || testId == 1004) {
            assertEquals(3, tickePrints.size());
            List<String> printTypes = new ArrayList<>();
            for (GasTicketPrintDO tickePrint : tickePrints) {
                printTypes.add(tickePrint.getPrintType());
                if (ticketPrintOrder.getPrintType().code().equals(tickePrint.getPrintType())) {
                    ticketPrintAssert(tickePrint, order.getStationId(), ticketPrintOrder.getPrintType().code(),
                            ticketPrintOrder.getPrintNum(), order.getPrintSleep(), ticketPrintOrder.getMemo());
                }
                if (ticketPrintOrder1.getPrintType().code().equals(tickePrint.getPrintType())) {
                    ticketPrintAssert(tickePrint, order.getStationId(), ticketPrintOrder1.getPrintType().code(),
                            ticketPrintOrder1.getPrintNum(), order.getPrintSleep(), ticketPrintOrder1.getMemo());
                }
                if (ticketPrintOrder2.getPrintType().code().equals(tickePrint.getPrintType())) {
                    ticketPrintAssert(tickePrint, order.getStationId(), ticketPrintOrder2.getPrintType().code(),
                            ticketPrintOrder2.getPrintNum(), order.getPrintSleep(), ticketPrintOrder2.getMemo());
                }
            }
            assertTrue(printTypes.contains(ticketPrintOrder.getPrintType().code()));
            assertTrue(printTypes.contains(ticketPrintOrder1.getPrintType().code()));
            assertTrue(printTypes.contains(ticketPrintOrder2.getPrintType().code()));
        }
        // 清除数据
        gasMerchantTestBase.cleanGasTicketPrintByStationId(order.getStationId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/ticketPrintServiceManageTicketPrintTestFailOne.csv")
    @DisplayName("小票打印配置--参数非法")
    public void ticketPrintServiceManageTicketPrintTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ManageTicketPrintOrder order,
            TicketPrintOrder ticketPrintOrder
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        List<TicketPrintOrder> printOrders = new ArrayList<TicketPrintOrder>();
        if (testId == 1002) {
            ticketPrintOrder.setPrintType(null);
        }
        printOrders.add(ticketPrintOrder);
        order.setPrintOrders(printOrders);
        if (testId == 1001) {
            order.setStationId(null);
        }
        if (testId == 1003) {
            order.setPrintOrders(null);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        SimpleResult result = ticketPrintService.manageTicketPrint(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.重复新增相同类型小票
     */
    @AutoTest(file = "gas_merchant/ticketPrintServiceManageTicketPrintTestFailTwo.csv")
    @DisplayName("小票打印配置--失败用例")
    public void ticketPrintServiceManageTicketPrintTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ManageTicketPrintOrder order,
            TicketPrintOrder ticketPrintOrder,
            TicketPrintOrder ticketPrintOrder1,
            TicketPrintOrder ticketPrintOrder2
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasTicketPrintByStationId(order.getStationId());
        // 准备数据
        // 测试过程
        List<TicketPrintOrder> printOrders = new ArrayList<TicketPrintOrder>();
        printOrders.add(ticketPrintOrder);
        printOrders.add(ticketPrintOrder1);
        order.setPrintOrders(printOrders);
        // 调用接口
        SimpleResult result = ticketPrintService.manageTicketPrint(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        gasMerchantTestBase.cleanGasTicketPrintByStationId(order.getStationId());
    }

    /**
     * 油站小票打印信息校验
     *
     * @param tickePrint
     * @param stationId
     * @param stationType
     * @param printNum
     * @param printSleep
     * @param memo
     */
    private void ticketPrintAssert(
            GasTicketPrintDO tickePrint,
            String stationId,
            String stationType,
            int printNum,
            int printSleep,
            String memo
    ) {
        assertEquals(stationId, tickePrint.getStationId());
        assertEquals(stationType, tickePrint.getPrintType());
        assertEquals(printNum, tickePrint.getPrintNum().intValue());
        assertEquals(printSleep, tickePrint.getPrintSleep().intValue());
        assertEquals(memo, tickePrint.getMemo());
    }
}
