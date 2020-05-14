package com.xjy.autotest.clear;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.ClearTestBase;
import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
import dal.model.clear.BillTaskConfDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

public class BillInitChannelTaskTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "clearBillInitChannelTask")
    ScheduleCallBackService scheduleCallBackService;

    @Autowired
    ClearTestBase clearTestBase;

    /**
     * 1001 网关返回数据，初始化成功
     * 1002 无对账配置，初始化失败
     * 1003 对账配置状态不正确，初始化失败
     */
    @AutoTest(file = "clear/billInitChannelTaskTestSuccess.csv")
    @DisplayName("初始化渠道数据--成功用例")
    public void billInitChannelTaskTestSuccess(
            // 基本参数
            int testId,
            // 对账配置参数
            BillTaskConfDO billTaskConfDO
    ){
        // 清除数据
        clearTestBase.cleanBillTaskConfById(billTaskConfDO.getId());
        // 准备数据
        clearTestBase.insertBillTaskConf(billTaskConfDO);
        // 测试过程
        // 调用接口
        scheduleCallBackService.justDoIT();
        // 结果检查
        // 参数校验
    }
}
