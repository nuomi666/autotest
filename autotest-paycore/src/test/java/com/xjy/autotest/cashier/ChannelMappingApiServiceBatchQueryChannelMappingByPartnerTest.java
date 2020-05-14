package com.xjy.autotest.cashier;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.cashier.api.info.channelmapping.QueryChannelMappingInfo;
import com.xyb.cashier.api.order.channelmapping.BatchQueryChannelMappingOrder;
import com.xyb.cashier.api.result.channelmapping.QueryChannelMappingListResult;
import com.xyb.cashier.api.service.ChannelMappingApiService;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;


/**
 * @author huairen
 * Created on 2019/10/23.
 */
public class ChannelMappingApiServiceBatchQueryChannelMappingByPartnerTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "cashier")
    ChannelMappingApiService channelMappingApiService;

    /**
     * 1001
     */
    @AutoTest(file = "cashier/channelMappingApiServiceBatchQueryChannelMappingByPartnerTestSuccess.csv")
    @DisplayName("批量查询商户拥有的渠道列表--成功用例")
    public void channelMappingApiServiceBatchQueryChannelMappingByPartnerTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            BatchQueryChannelMappingOrder batchQueryChannelMappingOrder,
            String partnerId
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        List<String> partnerIds = new ArrayList<String>();
        partnerIds.add(partnerId);
        batchQueryChannelMappingOrder.setPartnerIds(partnerIds);
		Page page = new Page(0, 10);
		batchQueryChannelMappingOrder.setPage(page);
        // 调用接口
        QueryChannelMappingListResult result = channelMappingApiService.batchQueryChannelMappingByPartner(batchQueryChannelMappingOrder);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        List<QueryChannelMappingInfo> infos = result.getInfos();
        for (QueryChannelMappingInfo info : infos) {
            print(info.getChannelName() + "+" + info.getChannelId());
        }
        // 清除数据
    }
}
