package com.xjy.autotest.clear;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.clear.api.order.settlement.QueryPartnerBillClearStatisticsOrder;
import com.xyb.clear.api.result.settlement.QueryPartnerBillClearStatisticsResult;
import com.xyb.clear.api.service.settlement.QuerySettlementInfoService;
import org.junit.jupiter.api.DisplayName;


/**
 * @author huairen
 * Created on 2019/08/01.
 */
public class QuerySettlementInfoServiceQueryPartnerBillClearStatisticsTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "clear")
    QuerySettlementInfoService querySettlementInfoService;

    /**
     * 1001 查询商户账务清分信息
     */
    @AutoTest(file = "clear/querySettlementInfoServiceQueryPartnerBillClearStatisticsTestSuccess.csv")
    @DisplayName("查询商户账务清分信息--成功用例")
    public void querySettlementInfoServiceQueryPartnerBillClearStatisticsTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryPartnerBillClearStatisticsOrder queryPartnerBillClearStatisticsOrder
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        QueryPartnerBillClearStatisticsResult result = querySettlementInfoService.queryPartnerBillClearStatistics(queryPartnerBillClearStatisticsOrder);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
