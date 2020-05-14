package com.xjy.autotest.clear;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.clear.api.order.settlement.BatchQueryPartnerClearStatisticsOrder;
import com.xyb.clear.api.result.settlement.ClearStatisticsSummaryInfo;
import com.xyb.clear.api.service.settlement.QuerySettlementInfoService;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;


/**
 * @author huairen
 * Created on 2019/10/23.
 */
public class QuerySettlementInfoServiceQueryClearStatisticsSummaryTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "clear")
    QuerySettlementInfoService querySettlementInfoService;

    /**
     * 1001
     */
    @AutoTest(file = "clear/querySettlementInfoServiceQueryClearStatisticsSummaryTestSuccess.csv")
    @DisplayName("查询商户清分统计明细汇总--成功用例")
    public void querySettlementInfoServiceQueryClearStatisticsSummaryTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            BatchQueryPartnerClearStatisticsOrder order,
            String partnerId
    ) {
        // 清除数据
        // 准备数据
        partnerId = "S0301810232300000120";
        String startDate = "20190801";
        String endDate = "20190831";
        //order.setChannelId("cdzsyh");
        order.setChannelId(null);
        // 测试过程
        List<String> partnerIds = new ArrayList<String>();
        partnerIds.add(partnerId);
        partnerIds.add("S0301902182100025489");
        partnerIds.add("G0701909142100272700");
        partnerIds.add("G0701909142100299919");
        partnerIds.add("G0701909142100262149");
        partnerIds.add("G0701909142100255854");
        partnerIds.add("G0701909142100275323");
        partnerIds.add("G0701909142100258854");
        partnerIds.add("G0701909142100264916");
        partnerIds.add("G0701909142100294549");
        partnerIds.add("G0701909142100236934");
        partnerIds.add("G0701909142100236934");
        partnerIds.add("G0701909142100240008");
        partnerIds.add("G0701909142100296313");
        partnerIds.add("G0701909142100234838");
        order.setPartnerIds(partnerIds);
        order.setStartDate(startDate);
        order.setEndDate(endDate);
        // 调用接口
		BizResult<ClearStatisticsSummaryInfo> result = querySettlementInfoService.queryClearStatisticsSummary(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
