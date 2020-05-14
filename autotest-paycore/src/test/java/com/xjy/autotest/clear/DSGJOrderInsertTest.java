package com.xjy.autotest.clear;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.ClearTestBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
import dal.model.clear.ClearDsgjOrderDO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author ychaoyang
 * Created on 18/11/22.
 */
public class DSGJOrderInsertTest extends SpringBootTestBase {

    //上传清分文件
    @Reference(version = DUBBO_VERSION, group = "dsgjClearFileTask")
    ScheduleCallBackService scheduleCallBackService;

    //下载清分结果文件
    @Reference(version = DUBBO_VERSION, group = "dsgjDwonClearResultFileTask")
    ScheduleCallBackService scheduleCallBackService1;

    //
    @Reference(version = DUBBO_VERSION, group = "dsgjReconciliationClearResultTask")
    ScheduleCallBackService scheduleCallBackService2;

    @Autowired
    ClearTestBase clearTestBase;

    @AutoTest(file = "clear/dSGJOrderInsertTest.csv")
    public void dSGJOrderInsertTest(
            int testId,
            ClearDsgjOrderDO clearDsgjOrderDO
    ) {
        //20180615001234567890  1350000
        //20180615001234567893  100000-20000
        if (testId == 1001) {
            clearTestBase.cleanClearDsgjOrderByPlatPartnerId(clearDsgjOrderDO.getPlatPartnerId());
        }
        clearDsgjOrderDO.setOrderKey(OID.newID());
        clearDsgjOrderDO.setChannelTradeNo(OID.newID());
        clearDsgjOrderDO.setChannelRefundNo(OID.newID());
        clearDsgjOrderDO.setMerchantOrderNo(OID.newID());
        clearDsgjOrderDO.setPlatMerchantOrderNo(OID.newID());
        clearDsgjOrderDO.setMerchantTradeNo(OID.newID());
        clearDsgjOrderDO.setMerchantRefundNo(OID.newID());
        clearDsgjOrderDO.setTradeTime(DateUtils.changeDays(new Date(), -1));
        clearDsgjOrderDO.setClearDate(DateUtils.formatDate(DateUtils.changeDays(new Date(), -1), "yyyyMMdd"));
        clearDsgjOrderDO.setRawAddTime(new Date());
        clearDsgjOrderDO.setRawUpdateTime(new Date());
        clearTestBase.insertClearDsgjOrder(clearDsgjOrderDO);
    }

    @AutoTest(file = "clear/billInitChannelTaskTestSuccess.csv")
    public void test(int testId) {
        //上传清分文件
        if (testId == 1001) {
            scheduleCallBackService.justDoIT();
        }
    }

    @AutoTest(file = "clear/billInitChannelTaskTestSuccess.csv")
    public void test1(int testId) {
        //下载清分结果文件
        if (testId == 1001) {
            scheduleCallBackService1.justDoIT();
        }
    }

    @AutoTest(file = "clear/billInitChannelTaskTestSuccess.csv")
    public void test2(int testId) {
        //清分结果文件
        if (testId == 1001) {
            scheduleCallBackService2.justDoIT();
        }
    }
}
