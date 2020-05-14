package com.xjy.autotest.clear;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.ClearTestBase;
import com.xyb.adk.common.lang.result.PagedResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.clear.api.order.settlement.BatchQueryPartnerClearStatisticsOrder;
import com.xyb.clear.api.result.settlement.ClearStatisticsInfo;
import com.xyb.clear.api.service.settlement.QuerySettlementInfoService;
import dal.model.clear.ClearStatisticsDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author huairen
 * Created on 2019/10/24.
 */
public class QuerySettlementInfoServiceBatchQueryPartnerClearStatisticsListTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "clear")
    QuerySettlementInfoService querySettlementInfoService;

    @Autowired
    ClearTestBase clearTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "clear/querySettlementInfoServiceBatchQueryPartnerClearStatisticsListTestSuccess.csv")
    @DisplayName("批量查询商户清分统计明细--成功用例")
    public void querySettlementInfoServiceBatchQueryPartnerClearStatisticsListTestSuccess(
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
        partnerId = "S0301902182100025489";
        String startDate = "20190801";
        String endDate = "20190831";
        // 测试过程
        List<String> partnerIds = new ArrayList<String>();
        partnerIds.add(partnerId);
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
        order.setChannelId(null);
        order.setStartDate(startDate);
        order.setEndDate(endDate);
        print(order);
        // 调用接口
        PagedResult<ClearStatisticsInfo> result = querySettlementInfoService.batchQueryPartnerClearStatisticsList(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        List<ClearStatisticsInfo> infos = result.getInfoList();
        int a = 1;
        for (ClearStatisticsInfo info : infos) {
            print(a + "+" + info.toString());
            a++;
            List<ClearStatisticsDO> ls = clearTestBase.findClearStatisticsByPartnerIdAndSettlementDate(info.getPartnerId(), info.getSettlementDate());
            if (ls.isEmpty()) {
                continue;
            }
            ClearStatisticsDO clearStatisticsDO = ls.get(0);
            //assertEquals(info.getChannelId(), order.getChannelId());
            assertEquals(info.getClearAmount().getCent(), clearStatisticsDO.getClearAmount());
            assertEquals(info.getOrderAmount().getCent(), clearStatisticsDO.getOrderAmount());
            assertEquals(info.getRefundAmount().getCent(), clearStatisticsDO.getRefundAmount());
            assertEquals(info.getTransactionAmount().getCent(), clearStatisticsDO.getTransactionAmount());
            assertEquals(info.getTransactionCount(), clearStatisticsDO.getTransactionCount());
            assertEquals(info.getRefundCount(), clearStatisticsDO.getRefundCount());
            assertEquals(info.getMerchantFeeAmount(), clearStatisticsDO.getMerchantFeeAmount());
            assertEquals(info.getPartnerRealName(), clearStatisticsDO.getPartnerRealName());

        }
        // 清除数据
    }
}
