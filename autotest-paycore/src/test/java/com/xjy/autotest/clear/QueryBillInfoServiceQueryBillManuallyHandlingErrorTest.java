package com.xjy.autotest.clear;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.ClearTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.clear.api.order.bill.BillErrorManuallyHandlingQueryOrder;
import com.xyb.clear.api.result.bill.BillErrorManuallyHandlingQueryInfo;
import com.xyb.clear.api.result.bill.BillErrorManuallyHandlingQueryResult;
import com.xyb.clear.api.service.bill.QueryBillInfoService;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author huairen
 * Created on 2019/10/24.
 */
public class QueryBillInfoServiceQueryBillManuallyHandlingErrorTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "clear")
    QueryBillInfoService queryBillInfoService;

    @Autowired
    ClearTestBase clearTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "clear/queryBillInfoServiceQueryBillManuallyHandlingErrorTestSuccess.csv")
    @DisplayName("查询手动差错处理查询--成功用例")
    public void queryBillInfoServiceQueryBillManuallyHandlingErrorTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            BillErrorManuallyHandlingQueryOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        BillErrorManuallyHandlingQueryResult result = queryBillInfoService.queryBillManuallyHandlingError(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        List<BillErrorManuallyHandlingQueryInfo> infos = result.getInfos();
        for (BillErrorManuallyHandlingQueryInfo info : infos) {

        }
        // 清除数据
    }
}
