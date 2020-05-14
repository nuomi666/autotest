package com.xjy.autotest.clear;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.ClearTestBase;
import com.xyb.clear.api.enmus.BillSolveStatus;
import com.xyb.clear.api.enmus.BillStatus;
import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
import dal.model.clear.BillErrorOrderDO;
import dal.model.clear.BillReconciliationDetailDO;
import dal.model.clear.BillTaskConfDO;
import dal.model.clear.BillTaskLogDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


/**
 * @author lvdou
 * 服务名：对账单对账任务
 * Created on 2018/07/27.
 */
public class BillReconciliationTaskTest extends SpringBootTestBase {
    @Reference(version = DUBBO_VERSION, group = "clearBillReconciliationTask")
    ScheduleCallBackService scheduleCallBackService;

    @Autowired
    ClearTestBase clearTestBase;

    /**
     * 1001 两条数据，渠道商户数据存在，账平，调用定时任务
     * 1002 两条数据，一条账平，一条渠道数据缺失，调用定时任务
     * 1003 两条数据，一条账平，一条商户数据缺失，调用定时任务
     * 1004 两条数据，一条渠道数据缺失，一条商户数据缺失，调用定时任务
     * 1005 两条数据，一条账平，一条账不平，调用定时任务
     * 1006 对账配置不存在，调用定时任务
     */
    @AutoTest(file = "clear/billReconciliationTaskTestSuccess.csv")
    @DisplayName("对账单对账任务--成功用例")
    public void billReconciliationTaskTestSuccess(
            // 基本参数
            int testId,
            // 数据库参数
            BillTaskLogDO billTaskLogDO,
            // 对账明细数据
            BillReconciliationDetailDO billReconciliationDetailDO,
            BillReconciliationDetailDO billReconciliationDetailDO1,
            // 对账配置数据
            BillTaskConfDO billTaskConfDO
    ){
        if(testId != 1006){
            return;
        }
        // 清除数据
        clearTestBase.cleanBillTaskLogByBatchNo(billTaskLogDO.getBatchNo());
        clearTestBase.cleanBillReconciliationDetailByBatchNo(billReconciliationDetailDO.getBatchNo());
        clearTestBase.cleanBillReconciliationDetailByBatchNo(billReconciliationDetailDO1.getBatchNo());
        clearTestBase.cleanBillTaskConfById(billTaskConfDO.getId());
        clearTestBase.cleanBillErrorOrderByBatchNo(billTaskLogDO.getBatchNo());
        // 准备数据
        clearTestBase.insertBillTaskLog(billTaskLogDO);
        clearTestBase.insertBillReconciliationDetail(billReconciliationDetailDO);
        clearTestBase.insertBillReconciliationDetail(billReconciliationDetailDO1);
        clearTestBase.insertBillTaskConf(billTaskConfDO);
        // 测试过程
        // 调用接口
        scheduleCallBackService.justDoIT();
        // 结果检查
        // 参数校验
        if(testId == 1001) {
            assertEquals(BillStatus.SUCCESS.code(), clearTestBase.findBillTaskLogByBatchNo(billTaskLogDO.getBatchNo()).get(0).getBillStatus());
            assertEquals("对账成功，无差错记录", clearTestBase.findBillTaskLogByBatchNo(billTaskLogDO.getBatchNo()).get(0).getBillComment());

            assertEquals(BillStatus.SUCCESS.code(),clearTestBase.findBillReconciliationDetailById(billReconciliationDetailDO.getId()).get(0).getBillStatus());
            assertEquals(BillStatus.SUCCESS.code(),clearTestBase.findBillReconciliationDetailById(billReconciliationDetailDO1.getId()).get(0).getBillStatus());

            ArrayList list = new ArrayList();
            assertEquals(list,clearTestBase.findBillErrorOrderByBatchNo(billTaskLogDO.getBatchNo()));
        }
        if(testId == 1002){
            assertEquals(BillStatus.FAIL.code(), clearTestBase.findBillTaskLogByBatchNo(billTaskLogDO.getBatchNo()).get(0).getBillStatus());
            assertEquals("还有1条差错未处理", clearTestBase.findBillTaskLogByBatchNo(billTaskLogDO.getBatchNo()).get(0).getBillComment());

            assertEquals(BillStatus.ERROR_NO_CHANNEL.code(),clearTestBase.findBillReconciliationDetailById(billReconciliationDetailDO.getId()).get(0).getBillStatus());
            assertEquals(BillStatus.SUCCESS.code(),clearTestBase.findBillReconciliationDetailById(billReconciliationDetailDO1.getId()).get(0).getBillStatus());

            BillErrorOrderDO DO = clearTestBase.findBillErrorOrderByBatchNo(billTaskLogDO.getBatchNo()).get(0);

            assertEquals(BillSolveStatus.INIT.code(),DO.getSolveStatus());
            assertEquals(billReconciliationDetailDO.getBatchNo(),DO.getBatchNo());
            assertNotNull(DO.getRawAddTime());
            assertNotNull(DO.getRawUpdateTime());
            assertNotNull(DO.getId());
            assertNull(DO.getSolveComment());
            assertEquals(BillStatus.ERROR_NO_CHANNEL.code(),DO.getBillStatus());
            assertNull(DO.getChannelOrderAmount());
            assertNull(DO.getChannelOrderNo());
            assertEquals(billReconciliationDetailDO.getMerchantOrderAmount(),DO.getMerchantOrderAmount());
            assertEquals(billReconciliationDetailDO.getMerchantOrderNo(),DO.getMerchantOrderNo());
            assertEquals(billReconciliationDetailDO.getMerchantTradeNo(),DO.getMerchantTradeNo());
            assertEquals(billReconciliationDetailDO.getOrderKey(),DO.getOrderKey());
            assertEquals(billReconciliationDetailDO.getPartnerId(),DO.getPartnerId());
            assertEquals(billReconciliationDetailDO.getPlatPartnerId(),DO.getPlatPartnerId());
            assertEquals(billReconciliationDetailDO.getTradeType().toString(),DO.getTradeType());
        }
        if(testId == 1003){
            assertEquals(BillStatus.FAIL.code(), clearTestBase.findBillTaskLogByBatchNo(billTaskLogDO.getBatchNo()).get(0).getBillStatus());
            assertEquals("还有1条差错未处理", clearTestBase.findBillTaskLogByBatchNo(billTaskLogDO.getBatchNo()).get(0).getBillComment());

            assertEquals(BillStatus.ERROR_NO_MERCHANT.code(),clearTestBase.findBillReconciliationDetailById(billReconciliationDetailDO.getId()).get(0).getBillStatus());
            assertEquals(BillStatus.SUCCESS.code(),clearTestBase.findBillReconciliationDetailById(billReconciliationDetailDO1.getId()).get(0).getBillStatus());

            BillErrorOrderDO DO = clearTestBase.findBillErrorOrderByBatchNo(billTaskLogDO.getBatchNo()).get(0);

            assertEquals(BillSolveStatus.INIT.code(),DO.getSolveStatus());
            assertEquals(billReconciliationDetailDO.getBatchNo(),DO.getBatchNo());
            assertNotNull(DO.getRawAddTime());
            assertNotNull(DO.getRawUpdateTime());
            assertNotNull(DO.getId());
            assertNull(DO.getSolveComment());
            assertEquals(BillStatus.ERROR_NO_MERCHANT.code(),DO.getBillStatus());
            assertEquals(billReconciliationDetailDO.getChannelOrderAmount(),DO.getChannelOrderAmount());
            assertEquals(billReconciliationDetailDO.getChannelOrderNo(),DO.getChannelOrderNo());
            assertNull(DO.getMerchantOrderAmount());
            assertNull(DO.getMerchantOrderNo());
            assertNull(DO.getMerchantTradeNo());
            assertEquals(billReconciliationDetailDO.getOrderKey(),DO.getOrderKey());
            assertEquals(billReconciliationDetailDO.getPartnerId(),DO.getPartnerId());
            assertEquals(billReconciliationDetailDO.getPlatPartnerId(),DO.getPlatPartnerId());
            assertEquals(billReconciliationDetailDO.getTradeType().toString(),DO.getTradeType());
        }
        if(testId == 1004){
            assertEquals(BillStatus.FAIL.code(), clearTestBase.findBillTaskLogByBatchNo(billTaskLogDO.getBatchNo()).get(0).getBillStatus());
            assertEquals("还有2条差错未处理", clearTestBase.findBillTaskLogByBatchNo(billTaskLogDO.getBatchNo()).get(0).getBillComment());

            assertEquals(BillStatus.ERROR_NO_MERCHANT.code(),clearTestBase.findBillReconciliationDetailById(billReconciliationDetailDO.getId()).get(0).getBillStatus());
            assertEquals(BillStatus.ERROR_NO_CHANNEL.code(),clearTestBase.findBillReconciliationDetailById(billReconciliationDetailDO1.getId()).get(0).getBillStatus());

            BillErrorOrderDO DO = clearTestBase.findBillErrorOrderByBatchNo(billTaskLogDO.getBatchNo()).get(0);

            assertEquals(BillSolveStatus.INIT.code(),DO.getSolveStatus());
            assertEquals(billReconciliationDetailDO.getBatchNo(),DO.getBatchNo());
            assertNotNull(DO.getRawAddTime());
            assertNotNull(DO.getRawUpdateTime());
            assertNotNull(DO.getId());
            assertNull(DO.getSolveComment());
            assertEquals(BillStatus.ERROR_NO_MERCHANT.code(),DO.getBillStatus());
            assertEquals(billReconciliationDetailDO.getChannelOrderAmount(),DO.getChannelOrderAmount());
            assertEquals(billReconciliationDetailDO.getChannelOrderNo(),DO.getChannelOrderNo());
            assertNull(DO.getMerchantOrderAmount());
            assertNull(DO.getMerchantOrderNo());
            assertNull(DO.getMerchantTradeNo());
            assertEquals(billReconciliationDetailDO.getOrderKey(),DO.getOrderKey());
            assertEquals(billReconciliationDetailDO.getPartnerId(),DO.getPartnerId());
            assertEquals(billReconciliationDetailDO.getPlatPartnerId(),DO.getPlatPartnerId());
            assertEquals(billReconciliationDetailDO.getTradeType().toString(),DO.getTradeType());

            BillErrorOrderDO DO1 = clearTestBase.findBillErrorOrderByBatchNo(billTaskLogDO.getBatchNo()).get(1);

            assertEquals(BillSolveStatus.INIT.code(),DO1.getSolveStatus());
            assertEquals(billReconciliationDetailDO1.getBatchNo(),DO1.getBatchNo());
            assertNotNull(DO1.getRawAddTime());
            assertNotNull(DO1.getRawUpdateTime());
            assertNotNull(DO1.getId());
            assertNull(DO1.getSolveComment());
            assertEquals(BillStatus.ERROR_NO_CHANNEL.code(),DO1.getBillStatus());
            assertNull(DO1.getChannelOrderAmount());
            assertNull(DO1.getChannelOrderNo());
            assertEquals(billReconciliationDetailDO1.getMerchantOrderAmount(),DO1.getMerchantOrderAmount());
            assertEquals(billReconciliationDetailDO1.getMerchantOrderNo(),DO1.getMerchantOrderNo());
            assertEquals(billReconciliationDetailDO1.getMerchantTradeNo(),DO1.getMerchantTradeNo());
            assertEquals(billReconciliationDetailDO1.getOrderKey(),DO1.getOrderKey());
            assertEquals(billReconciliationDetailDO1.getPartnerId(),DO1.getPartnerId());
            assertEquals(billReconciliationDetailDO1.getPlatPartnerId(),DO1.getPlatPartnerId());
            assertEquals(billReconciliationDetailDO1.getTradeType().toString(),DO1.getTradeType());
        }
        if(testId == 1005){
            assertEquals(BillStatus.FAIL.code(), clearTestBase.findBillTaskLogByBatchNo(billTaskLogDO.getBatchNo()).get(0).getBillStatus());
            assertEquals("还有1条差错未处理", clearTestBase.findBillTaskLogByBatchNo(billTaskLogDO.getBatchNo()).get(0).getBillComment());

            assertEquals(BillStatus.ERROR_AMOUNT.code(),clearTestBase.findBillReconciliationDetailById(billReconciliationDetailDO.getId()).get(0).getBillStatus());
            assertEquals(BillStatus.SUCCESS.code(),clearTestBase.findBillReconciliationDetailById(billReconciliationDetailDO1.getId()).get(0).getBillStatus());

            BillErrorOrderDO DO = clearTestBase.findBillErrorOrderByBatchNo(billTaskLogDO.getBatchNo()).get(0);

            assertEquals(BillSolveStatus.INIT.code(),DO.getSolveStatus());
            assertEquals(billReconciliationDetailDO.getBatchNo(),DO.getBatchNo());
            assertNotNull(DO.getRawAddTime());
            assertNotNull(DO.getRawUpdateTime());
            assertNotNull(DO.getId());
            assertNull(DO.getSolveComment());
            assertEquals(BillStatus.ERROR_AMOUNT.code(),DO.getBillStatus());
            assertEquals(billReconciliationDetailDO.getChannelOrderAmount(),DO.getChannelOrderAmount());
            assertEquals(billReconciliationDetailDO.getChannelOrderNo(),DO.getChannelOrderNo());
            assertEquals(billReconciliationDetailDO.getMerchantOrderAmount(),DO.getMerchantOrderAmount());
            assertEquals(billReconciliationDetailDO.getMerchantOrderNo(),DO.getMerchantOrderNo());
            assertEquals(billReconciliationDetailDO.getMerchantTradeNo(),DO.getMerchantTradeNo());
            assertEquals(billReconciliationDetailDO.getOrderKey(),DO.getOrderKey());
            assertEquals(billReconciliationDetailDO.getPartnerId(),DO.getPartnerId());
            assertEquals(billReconciliationDetailDO.getPlatPartnerId(),DO.getPlatPartnerId());
            assertEquals(billReconciliationDetailDO.getTradeType().toString(),DO.getTradeType());
        }
        if(testId == 1006){
            assertEquals(BillStatus.INIT.code(), clearTestBase.findBillTaskLogByBatchNo(billTaskLogDO.getBatchNo()).get(0).getBillStatus());
            assertNull(clearTestBase.findBillTaskLogByBatchNo(billTaskLogDO.getBatchNo()).get(0).getBillComment());

            assertEquals(BillStatus.SUCCESS.code(),clearTestBase.findBillReconciliationDetailById(billReconciliationDetailDO.getId()).get(0).getBillStatus());
            assertEquals(BillStatus.SUCCESS.code(),clearTestBase.findBillReconciliationDetailById(billReconciliationDetailDO1.getId()).get(0).getBillStatus());



            ArrayList list = new ArrayList();
            assertEquals(list,clearTestBase.findBillErrorOrderByBatchNo(billTaskLogDO.getBatchNo()));
        }
        // 清除数据
        clearTestBase.cleanBillTaskLogByBatchNo(billTaskLogDO.getBatchNo());
        clearTestBase.cleanBillReconciliationDetailByBatchNo(billReconciliationDetailDO.getBatchNo());
        clearTestBase.cleanBillReconciliationDetailByBatchNo(billReconciliationDetailDO1.getBatchNo());
        clearTestBase.cleanBillTaskConfById(billTaskConfDO.getId());
        clearTestBase.cleanBillErrorOrderByBatchNo(billTaskLogDO.getBatchNo());

        }
}
