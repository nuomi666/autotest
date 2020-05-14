package com.xjy.autotest.clear;

import com.baomidou.mybatisplus.plugins.Page;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.ClearTestBase;
import com.xyb.adk.common.lang.result.Status;
import dal.model.clear.BillBatchStatisticsDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.xyb.clear.api.result.bill.BillBatchStatisticsQueryResult;
import com.xyb.clear.api.service.bill.QueryBillInfoService;
import com.xyb.clear.api.order.bill.BillBatchStatisticsQueryOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：查询批量统计
 * Created on 2018/07/24.
 */
public class QueryBillInfoServiceQueryBillBatchStatisticsTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION,group = "clear")
    QueryBillInfoService queryBillInfoService;

	@Autowired
	ClearTestBase clearTestBase;
	/**
	 * 1001 无条件查询，默认分页信息
	 * 1002 无条件查询，每页两条数据，查询第一页
	 * 1003 无条件查询，每页一条数据，查询第二页
	 * 1004 无条件查询，每页一条数据，查询第三页
	 * 1005 根据batchNo查询，每页一条数据，查询第一页
	 * 1006 根据partnerId查询，每页一条数据，查询第一页
	 * 1007 根据platPartnerId查询，每页一条数据，查询第一页
	 * 1008 根据channelId查询，每页一条数据，查询第一页
	 * 1009 根据billDate查询，每页一条数据，查询第一页
	 * 1010 根据channelPartnerId查询，每页一条数据，查询第一页
	 * 1011 根据tradeType查询，每页一条数据，查询第一页
	 * 1012 根据channelOrderCount查询，每页一条数据，查询第一页
	 * 1013 根据channelOrderAmount查询，每页一条数据，查询第一页
	 * 1014 根据errorOrderCount查询，每页一条数据，查询第一页
	 * 1015 根据errorOrderAmount查询，每页一条数据，查询第一页
	 * 1016 根据rawAddTime查询，每页一条数据，查询第一页
	 * 1017 根据rawUpdateTime查询，每页一条数据，查询第一页
	 * 1018 根据id查询，每页一条数据，查询第一页
	 * 1019 查询不到信息，返回为空
	 */
	@AutoTest(file = "clear/queryBillInfoServiceQueryBillBatchStatisticsTestSuccess.csv")
	@DisplayName("查询批量统计--成功用例")
	public void queryBillInfoServiceQueryBillBatchStatisticsTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			BillBatchStatisticsQueryOrder billBatchStatisticsQueryOrder,
			// 分页参数
			Page page,
			// 数据库参数
			BillBatchStatisticsDO billBatchStatisticsDO,
			BillBatchStatisticsDO billBatchStatisticsDO1,
			BillBatchStatisticsDO billBatchStatisticsDO2,
			// 结果参数
			String code,
			String description
	) {
		// 清除数据
		clearTestBase.cleanBillBatchStatisticsByBatchNo(billBatchStatisticsDO.getBatchNo());
		clearTestBase.cleanBillBatchStatisticsByBatchNo(billBatchStatisticsDO1.getBatchNo());
		clearTestBase.cleanBillBatchStatisticsByBatchNo(billBatchStatisticsDO2.getBatchNo());
		// 准备数据
		clearTestBase.insertBillBatchStatistics(billBatchStatisticsDO);
		clearTestBase.insertBillBatchStatistics(billBatchStatisticsDO1);
		clearTestBase.insertBillBatchStatistics(billBatchStatisticsDO2);
		// 测试过程
		billBatchStatisticsQueryOrder.setPage(page);
		// 调用接口
		BillBatchStatisticsQueryResult result = queryBillInfoService.queryBillBatchStatistics(billBatchStatisticsQueryOrder);
		// 结果验证
		assertResult(testId, Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 数据验证
		if(testId == 1001 || testId == 1002) {
			assertEquals(result.getInfos().get(0).getBatchNo(), billBatchStatisticsDO2.getBatchNo());
			assertEquals(result.getInfos().get(0).getBillDate(), billBatchStatisticsDO2.getBillDate());
			assertEquals(result.getInfos().get(0).getChannelId(), billBatchStatisticsDO2.getChannelId());
			assertEquals(result.getInfos().get(0).getChannelOrderAmount().getCent(), billBatchStatisticsDO2.getChannelOrderAmount());
			assertEquals(result.getInfos().get(0).getChannelOrderCount(), billBatchStatisticsDO2.getChannelOrderCount());
			assertEquals(result.getInfos().get(0).getChannelPartnerId(), billBatchStatisticsDO2.getChannelPartnerId());
			assertEquals(result.getInfos().get(0).getErrorOrderAmount().getCent(), billBatchStatisticsDO2.getErrorOrderAmount());
			assertEquals(result.getInfos().get(0).getErrorOrderCount(), billBatchStatisticsDO2.getErrorOrderCount());
			assertEquals(result.getInfos().get(0).getId(), billBatchStatisticsDO2.getId());
			assertEquals(result.getInfos().get(0).getPartnerId(), billBatchStatisticsDO2.getPartnerId());
			assertEquals(result.getInfos().get(0).getPlatPartnerId(), billBatchStatisticsDO2.getPlatPartnerId());
			assertEquals(result.getInfos().get(0).getRawAddTime(), billBatchStatisticsDO2.getRawAddTime());
			assertEquals(result.getInfos().get(0).getRawUpdateTime(), billBatchStatisticsDO2.getRawUpdateTime());
			assertEquals(result.getInfos().get(0).getTradeType().toString(), billBatchStatisticsDO2.getTradeType());

			assertEquals(result.getInfos().get(1).getBatchNo(), billBatchStatisticsDO1.getBatchNo());
			assertEquals(result.getInfos().get(1).getBillDate(), billBatchStatisticsDO1.getBillDate());
			assertEquals(result.getInfos().get(1).getChannelId(), billBatchStatisticsDO1.getChannelId());
			assertEquals(result.getInfos().get(1).getChannelOrderAmount().getCent(), billBatchStatisticsDO1.getChannelOrderAmount());
			assertEquals(result.getInfos().get(1).getChannelOrderCount(), billBatchStatisticsDO1.getChannelOrderCount());
			assertEquals(result.getInfos().get(1).getChannelPartnerId(), billBatchStatisticsDO1.getChannelPartnerId());
			assertEquals(result.getInfos().get(1).getErrorOrderAmount().getCent(), billBatchStatisticsDO1.getErrorOrderAmount());
			assertEquals(result.getInfos().get(1).getErrorOrderCount(), billBatchStatisticsDO1.getErrorOrderCount());
			assertEquals(result.getInfos().get(1).getId(), billBatchStatisticsDO1.getId());
			assertEquals(result.getInfos().get(1).getPartnerId(), billBatchStatisticsDO1.getPartnerId());
			assertEquals(result.getInfos().get(1).getPlatPartnerId(), billBatchStatisticsDO1.getPlatPartnerId());
			assertEquals(result.getInfos().get(1).getRawAddTime(), billBatchStatisticsDO1.getRawAddTime());
			assertEquals(result.getInfos().get(1).getRawUpdateTime(), billBatchStatisticsDO1.getRawUpdateTime());
			assertEquals(result.getInfos().get(1).getTradeType().toString(), billBatchStatisticsDO1.getTradeType());
		}
		if(testId == 1001) {
			assertEquals(result.getInfos().get(2).getBatchNo(), billBatchStatisticsDO.getBatchNo());
			assertEquals(result.getInfos().get(2).getBillDate(), billBatchStatisticsDO.getBillDate());
			assertEquals(result.getInfos().get(2).getChannelId(), billBatchStatisticsDO.getChannelId());
			assertEquals(result.getInfos().get(2).getChannelOrderAmount().getCent(), billBatchStatisticsDO.getChannelOrderAmount());
			assertEquals(result.getInfos().get(2).getChannelOrderCount(), billBatchStatisticsDO.getChannelOrderCount());
			assertEquals(result.getInfos().get(2).getChannelPartnerId(), billBatchStatisticsDO.getChannelPartnerId());
			assertEquals(result.getInfos().get(2).getErrorOrderAmount().getCent(), billBatchStatisticsDO.getErrorOrderAmount());
			assertEquals(result.getInfos().get(2).getErrorOrderCount(), billBatchStatisticsDO.getErrorOrderCount());
			assertEquals(result.getInfos().get(2).getId(), billBatchStatisticsDO.getId());
			assertEquals(result.getInfos().get(2).getPartnerId(), billBatchStatisticsDO.getPartnerId());
			assertEquals(result.getInfos().get(2).getPlatPartnerId(), billBatchStatisticsDO.getPlatPartnerId());
			assertEquals(result.getInfos().get(2).getRawAddTime(), billBatchStatisticsDO.getRawAddTime());
			assertEquals(result.getInfos().get(2).getRawUpdateTime(), billBatchStatisticsDO.getRawUpdateTime());
			assertEquals(result.getInfos().get(2).getTradeType().toString(), billBatchStatisticsDO.getTradeType());
		}
		if(testId == 1003){
			assertEquals(result.getInfos().get(0).getBatchNo(), billBatchStatisticsDO1.getBatchNo());
			assertEquals(result.getInfos().get(0).getBillDate(), billBatchStatisticsDO1.getBillDate());
			assertEquals(result.getInfos().get(0).getChannelId(), billBatchStatisticsDO1.getChannelId());
			assertEquals(result.getInfos().get(0).getChannelOrderAmount().getCent(), billBatchStatisticsDO1.getChannelOrderAmount());
			assertEquals(result.getInfos().get(0).getChannelOrderCount(), billBatchStatisticsDO1.getChannelOrderCount());
			assertEquals(result.getInfos().get(0).getChannelPartnerId(), billBatchStatisticsDO1.getChannelPartnerId());
			assertEquals(result.getInfos().get(0).getErrorOrderAmount().getCent(), billBatchStatisticsDO1.getErrorOrderAmount());
			assertEquals(result.getInfos().get(0).getErrorOrderCount(), billBatchStatisticsDO1.getErrorOrderCount());
			assertEquals(result.getInfos().get(0).getId(), billBatchStatisticsDO1.getId());
			assertEquals(result.getInfos().get(0).getPartnerId(), billBatchStatisticsDO1.getPartnerId());
			assertEquals(result.getInfos().get(0).getPlatPartnerId(), billBatchStatisticsDO1.getPlatPartnerId());
			assertEquals(result.getInfos().get(0).getRawAddTime(), billBatchStatisticsDO1.getRawAddTime());
			assertEquals(result.getInfos().get(0).getRawUpdateTime(), billBatchStatisticsDO1.getRawUpdateTime());
			assertEquals(result.getInfos().get(0).getTradeType().toString(), billBatchStatisticsDO1.getTradeType());
		}
		if(testId == 1004){
			assertEquals(result.getInfos().get(0).getBatchNo(), billBatchStatisticsDO.getBatchNo());
			assertEquals(result.getInfos().get(0).getBillDate(), billBatchStatisticsDO.getBillDate());
			assertEquals(result.getInfos().get(0).getChannelId(), billBatchStatisticsDO.getChannelId());
			assertEquals(result.getInfos().get(0).getChannelOrderAmount().getCent(), billBatchStatisticsDO.getChannelOrderAmount());
			assertEquals(result.getInfos().get(0).getChannelOrderCount(), billBatchStatisticsDO.getChannelOrderCount());
			assertEquals(result.getInfos().get(0).getChannelPartnerId(), billBatchStatisticsDO.getChannelPartnerId());
			assertEquals(result.getInfos().get(0).getErrorOrderAmount().getCent(), billBatchStatisticsDO.getErrorOrderAmount());
			assertEquals(result.getInfos().get(0).getErrorOrderCount(), billBatchStatisticsDO.getErrorOrderCount());
			assertEquals(result.getInfos().get(0).getId(), billBatchStatisticsDO.getId());
			assertEquals(result.getInfos().get(0).getPartnerId(), billBatchStatisticsDO.getPartnerId());
			assertEquals(result.getInfos().get(0).getPlatPartnerId(), billBatchStatisticsDO.getPlatPartnerId());
			assertEquals(result.getInfos().get(0).getRawAddTime(), billBatchStatisticsDO.getRawAddTime());
			assertEquals(result.getInfos().get(0).getRawUpdateTime(), billBatchStatisticsDO.getRawUpdateTime());
			assertEquals(result.getInfos().get(0).getTradeType().toString(), billBatchStatisticsDO.getTradeType());
		}
		if(testId >= 1005 && testId <= 1017){
			assertEquals(result.getInfos().get(0).getBatchNo(), billBatchStatisticsDO.getBatchNo());
			assertEquals(result.getInfos().get(0).getBillDate(), billBatchStatisticsDO.getBillDate());
			assertEquals(result.getInfos().get(0).getChannelId(), billBatchStatisticsDO.getChannelId());
			assertEquals(result.getInfos().get(0).getChannelOrderAmount().getCent(), billBatchStatisticsDO.getChannelOrderAmount());
			assertEquals(result.getInfos().get(0).getChannelOrderCount(), billBatchStatisticsDO.getChannelOrderCount());
			assertEquals(result.getInfos().get(0).getChannelPartnerId(), billBatchStatisticsDO.getChannelPartnerId());
			assertEquals(result.getInfos().get(0).getErrorOrderAmount().getCent(), billBatchStatisticsDO.getErrorOrderAmount());
			assertEquals(result.getInfos().get(0).getErrorOrderCount(), billBatchStatisticsDO.getErrorOrderCount());
			assertEquals(result.getInfos().get(0).getId(), billBatchStatisticsDO.getId());
			assertEquals(result.getInfos().get(0).getPartnerId(), billBatchStatisticsDO.getPartnerId());
			assertEquals(result.getInfos().get(0).getPlatPartnerId(), billBatchStatisticsDO.getPlatPartnerId());
			assertEquals(result.getInfos().get(0).getRawAddTime(), billBatchStatisticsDO.getRawAddTime());
			assertEquals(result.getInfos().get(0).getRawUpdateTime(), billBatchStatisticsDO.getRawUpdateTime());
			assertEquals(result.getInfos().get(0).getTradeType().toString(), billBatchStatisticsDO.getTradeType());
		}
		if(testId == 1019){
			assertNull(result.getInfos());
		}
		// 清除数据
		clearTestBase.cleanBillBatchStatisticsByBatchNo(billBatchStatisticsDO.getBatchNo());
		clearTestBase.cleanBillBatchStatisticsByBatchNo(billBatchStatisticsDO1.getBatchNo());
		clearTestBase.cleanBillBatchStatisticsByBatchNo(billBatchStatisticsDO2.getBatchNo());
	}
}
