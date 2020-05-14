package com.xjy.autotest.pay;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
import com.xyb.pay.api.settlement.order.file.FileUploadOrder;
import com.xyb.pay.api.settlement.service.FileService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author ychaoyang
 * Created on 2018/11/21.
 */
@Disabled
public class FileServiceUploadTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    FileService fileService;

    //下载文件
    @Reference(version = DUBBO_VERSION, group = "com.xyb.pay.b.e.s.f.SettlementResultFileDownloadInvoke")
    ScheduleCallBackService scheduleCallBackService;

    //解析文件
    @Reference(version = DUBBO_VERSION, group = "com.xyb.pay.b.e.s.f.SettlementResultFileAnalysisInvoke")
    ScheduleCallBackService scheduleCallBackService1;

    //解冻下账
    @Reference(version = DUBBO_VERSION, group = "com.xyb.pay.b.e.s.w.SettlementDelayWithdrawAccountClearInvoke")
    ScheduleCallBackService scheduleCallBackService2;

    //退汇文件处理
    @Reference(version = DUBBO_VERSION, group = "com.xyb.pay.b.e.s.f.SettlementRemittanceFileAnalysisInvoke")
    ScheduleCallBackService scheduleCallBackService3;

    /**
     * 1001
     */
    @AutoTest(file = "pay/fileServiceUploadTestSuccess.csv")
    @DisplayName("--成功用例")
    public void fileServiceUploadTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            FileUploadOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setPlatMerchantOrderNo("pmerchNo" + System.currentTimeMillis());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());

        order.setBatchNo(OID.newID());
        order.setFileName("1001070000000000022019010901");
        order.setOperateDate(new Date());
        Map<String, Object> params = new HashMap();
        params.put("channelId", "dsgj");
        params.put("platPartnerId", "20180615001234567800");
        order.setParams(params);
        // 调用接口
        BizResult result = fileService.upload(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    @AutoTest(file = "pay/fileServiceUploadTestSuccess.csv")
    public void test() {
        //下载提现结果文件
        scheduleCallBackService.justDoIT();
    }

    @AutoTest(file = "pay/fileServiceUploadTestSuccess.csv")
    public void test1() {
        //解析提现结果文件
        scheduleCallBackService1.justDoIT();
    }

    @AutoTest(file = "pay/fileServiceUploadTestSuccess.csv")
    public void test2() {
        //解冻下账
        scheduleCallBackService2.justDoIT();
    }

    @AutoTest(file = "pay/fileServiceUploadTestSuccess.csv")
    public void test3() {
        //退汇
        scheduleCallBackService3.justDoIT();
    }
}
