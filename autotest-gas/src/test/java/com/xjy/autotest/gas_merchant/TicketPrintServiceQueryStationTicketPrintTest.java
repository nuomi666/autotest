package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.TicketPrintService;
import com.xyb.gas.merchant.api.info.ticket.StationTicketPrintInfo;
import com.xyb.gas.merchant.api.info.ticket.TicketPrintInfo;
import com.xyb.gas.merchant.api.order.ticket.QueryStationTicketPrintOrder;
import com.xyb.gas.merchant.api.order.ticket.TicketPrintOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2019/12/19.
 */
public class TicketPrintServiceQueryStationTicketPrintTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    TicketPrintService ticketPrintService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001.未查到数据
     * 1002.查询出一条
     * 1003.查询出多条
     */
    @AutoTest(file = "gas_merchant/ticketPrintServiceQueryStationTicketPrintTestSuccess.csv")
    @DisplayName("查询油站小票的打印信息--成功用例")
    public void ticketPrintServiceQueryStationTicketPrintTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryStationTicketPrintOrder order,
            TicketPrintOrder ticketPrintOrder,
            TicketPrintOrder ticketPrintOrder1
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasTicketPrintByStationId(order.getStationId());
        // 准备数据
        if (testId != 1001) {
            gasMerchantTestBase.insertGasTicketPrint(0, order.getStationId(), ticketPrintOrder.getPrintType().code(),
                    ticketPrintOrder.getPrintNum(),
                    3, ticketPrintOrder.getMemo(), null, null);
        }
        if (testId == 1003) {
            gasMerchantTestBase.insertGasTicketPrint(0, order.getStationId(), ticketPrintOrder1.getPrintType().code()
                    , ticketPrintOrder1.getPrintNum(),
                    3, ticketPrintOrder1.getMemo(), null, null);
        }
        // 测试过程
        // 调用接口
        BizResult<StationTicketPrintInfo> result =
                ticketPrintService.queryStationTicketPrint(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        StationTicketPrintInfo ticketInfos = result.getInfo();
        if (testId == 1001) {
            assertEquals(null, ticketInfos);
        }
        if (testId == 1002) {
            assertEquals(1, ticketInfos.getPrintInfos().size());
            assertEquals(3, ticketInfos.getPrintSleep());
            assertEquals(order.getStationId(), ticketInfos.getStationId());
            for (TicketPrintInfo tickePrint : ticketInfos.getPrintInfos()) {
                ticketPrintAssert(tickePrint, ticketPrintOrder.getPrintType().code(), ticketPrintOrder.getPrintNum(),
                        ticketPrintOrder.getMemo());
            }
        }
        if (testId == 1003) {
            assertEquals(2, ticketInfos.getPrintInfos().size());
            assertEquals(3, ticketInfos.getPrintSleep());
            assertEquals(order.getStationId(), ticketInfos.getStationId());
            List<String> printTypes = new ArrayList<>();
            for (TicketPrintInfo tickePrint : ticketInfos.getPrintInfos()) {
                printTypes.add(tickePrint.getPrintType().code());
                if (ticketPrintOrder.getPrintType().code().equals(tickePrint.getPrintType())) {
                    ticketPrintAssert(tickePrint, ticketPrintOrder.getPrintType().code(),
                            ticketPrintOrder.getPrintNum(), ticketPrintOrder.getMemo());
                }
                if (ticketPrintOrder1.getPrintType().code().equals(tickePrint.getPrintType())) {
                    ticketPrintAssert(tickePrint, ticketPrintOrder.getPrintType().code(),
                            ticketPrintOrder.getPrintNum(), ticketPrintOrder.getMemo());
                }
            }
            assertTrue(printTypes.contains(ticketPrintOrder.getPrintType().code()));
            assertTrue(printTypes.contains(ticketPrintOrder1.getPrintType().code()));
        }
        // 清除数据
        gasMerchantTestBase.cleanGasTicketPrintByStationId(order.getStationId());
    }

    /**
     *
     */
    @AutoTest(file = "gas_merchant/ticketPrintServiceQueryStationTicketPrintTestFailOne.csv")
    @DisplayName("查询油站小票的打印信息--参数非法")
    public void ticketPrintServiceQueryStationTicketPrintTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryStationTicketPrintOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setStationId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        BizResult<StationTicketPrintInfo> result =
                ticketPrintService.queryStationTicketPrint(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }

    /**
     * 油站小票打印信息校验
     *
     * @param tickePrint
     * @param printNum
     * @param memo
     */
    private void ticketPrintAssert(
            TicketPrintInfo tickePrint,
            String printType,
            int printNum,
            String memo
    ) {
        assertEquals(printType, tickePrint.getPrintType().code());
        assertEquals(printNum, tickePrint.getPrintNum());
        assertEquals(memo, tickePrint.getMemo());
    }
}
