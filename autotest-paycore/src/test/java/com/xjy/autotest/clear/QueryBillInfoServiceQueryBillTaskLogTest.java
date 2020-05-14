//package com.xjy.autotest.clear;
//
//import com.baomidou.mybatisplus.plugins.Page;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.testbase.ClearTestBase;
//import com.xyb.adk.common.lang.result.Status;
//import dal.model.clear.BillTaskLogDO;
//import org.junit.jupiter.api.DisplayName;
//import com.alibaba.dubbo.config.annotation.Reference;
//import java.util.Date;
//import java.util.ArrayList;
//import java.util.List;
//import com.xyb.clear.api.result.bill.BillTaskLogQueryResult;
//import com.xyb.clear.api.service.bill.QueryBillInfoService;
//import com.xyb.clear.api.order.bill.BillTaskLogQueryOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
///**
// * @author lvdou
// * 服务名：查询任务日志
// * Created on 2018/07/24.
// */
//public class QueryBillInfoServiceQueryBillTaskLogTest extends SpringBootTestBase{
//
//	@Reference(version = DUBBO_VERSION,group = "clear")
//    QueryBillInfoService queryBillInfoService;
//
//	@Autowired
//	ClearTestBase clearTestBase;
//	/**
//	 * 1001 无条件查询，默认分页信息
//	 * 1002 无条件查询，每页两条数据，查询第一页
//	 * 1003 无条件查询，每页一条数据，查询第二页
//	 * 1004 无条件查询，每页一条数据，查询第三页
//	 * 1005 根据batchNo查询，每页一条数据，查询第一页
//	 * 1006 根据billDate查询，每页一条数据，查询第一页
//	 * 1007 根据所有查询条件查询，每页一条数据，查询第一页
//	 * 1008 根据partnerId查询，每页一条数据，查询第一页
//	 * 1009 根据id查询，每页一条数据，查询第一页
//	 */
//	@AutoTest(file = "clear/queryBillInfoServiceQueryBillTaskLogTestSuccess.csv")
//	@DisplayName("查询任务日志--成功用例")
//	public void queryBillInfoServiceQueryBillTaskLogTestSuccess(
//			// 基本参数
//			int testId,
//			// 业务参数
//			BillTaskLogQueryOrder billTaskLogQueryOrder,
//			// 数据库参数
//			BillTaskLogDO billTaskLogDO,
//			BillTaskLogDO billTaskLogDO1,
//			BillTaskLogDO billTaskLogDO2,
//			// 分页参数
//			Page page,
//			// 结果参数
//			String code,
//			String description
//	) {
//		// 清除数据
//		clearTestBase.cleanBillTaskLogByBatchNo(billTaskLogDO.getBatchNo());
//		clearTestBase.cleanBillTaskLogByBatchNo(billTaskLogDO1.getBatchNo());
//		clearTestBase.cleanBillTaskLogByBatchNo(billTaskLogDO2.getBatchNo());
//		// 准备数据
//		clearTestBase.insertBillTaskLog(billTaskLogDO);
//		clearTestBase.insertBillTaskLog(billTaskLogDO1);
//		clearTestBase.insertBillTaskLog(billTaskLogDO2);
//		// 测试过程
//		billTaskLogQueryOrder.setPage(page);
//		// 调用接口
//		BillTaskLogQueryResult result = queryBillInfoService.queryBillTaskLog(billTaskLogQueryOrder);
//		// 结果验证
//		assertResult(testId, Status.SUCCESS,code,result);
//		assertEquals(description,result.getDescription());
//		// 数据验证
//		if(testId == 1001 || testId == 1002) {
//			assertEquals(result.getInfos().get(0).getBatchNo(), billTaskLogDO.getBatchNo());
//			assertEquals(result.getInfos().get(0).getBillChannelTime(), billTaskLogDO.getBillChannelTime());
//			assertEquals(result.getInfos().get(0).getBillComment(), billTaskLogDO.getBillComment());
//			assertNotNull(result.getInfos().get(0).getBillDate());
//			assertEquals(result.getInfos().get(0).getBillStatus().toString(), billTaskLogDO.getBillStatus());
//			assertEquals(result.getInfos().get(0).getBillTime(), billTaskLogDO.getBillTime());
//			assertEquals(result.getInfos().get(0).getChannelComment(), billTaskLogDO.getChannelComment());
//			assertEquals(result.getInfos().get(0).getChannelStatus().toString(), billTaskLogDO.getChannelStatus());
//			assertEquals(result.getInfos().get(0).getId(), billTaskLogDO.getId());
//			assertEquals(result.getInfos().get(0).getRawAddTime(), billTaskLogDO.getRawAddTime());
//			assertEquals(result.getInfos().get(0).getRawUpdateTime(), billTaskLogDO.getRawUpdateTime());
//
//			assertEquals(result.getInfos().get(1).getBatchNo(), billTaskLogDO1.getBatchNo());
//			assertEquals(result.getInfos().get(1).getBillChannelTime(), billTaskLogDO1.getBillChannelTime());
//			assertEquals(result.getInfos().get(1).getBillComment(), billTaskLogDO1.getBillComment());
//			assertNotNull(result.getInfos().get(1).getBillDate());
//			assertEquals(result.getInfos().get(1).getBillStatus().toString(), billTaskLogDO1.getBillStatus());
//			assertEquals(result.getInfos().get(1).getBillTime(), billTaskLogDO1.getBillTime());
//			assertEquals(result.getInfos().get(1).getChannelComment(), billTaskLogDO1.getChannelComment());
//			assertEquals(result.getInfos().get(1).getChannelStatus().toString(), billTaskLogDO1.getChannelStatus());
//			assertEquals(result.getInfos().get(1).getId(), billTaskLogDO1.getId());
//			assertEquals(result.getInfos().get(1).getRawAddTime(), billTaskLogDO1.getRawAddTime());
//			assertEquals(result.getInfos().get(1).getRawUpdateTime(), billTaskLogDO1.getRawUpdateTime());
//		}
//		if(testId == 1001) {
//			assertEquals(result.getInfos().get(2).getBatchNo(), billTaskLogDO2.getBatchNo());
//			assertEquals(result.getInfos().get(2).getBillChannelTime(), billTaskLogDO2.getBillChannelTime());
//			assertEquals(result.getInfos().get(2).getBillComment(), billTaskLogDO2.getBillComment());
//			assertNotNull(result.getInfos().get(2).getBillDate());
//			assertEquals(result.getInfos().get(2).getBillStatus().toString(), billTaskLogDO2.getBillStatus());
//			assertEquals(result.getInfos().get(2).getBillTime(), billTaskLogDO2.getBillTime());
//			assertEquals(result.getInfos().get(2).getChannelComment(), billTaskLogDO2.getChannelComment());
//			assertEquals(result.getInfos().get(2).getChannelStatus().toString(), billTaskLogDO2.getChannelStatus());
//			assertEquals(result.getInfos().get(2).getId(), billTaskLogDO2.getId());
//			assertEquals(result.getInfos().get(2).getRawAddTime(), billTaskLogDO2.getRawAddTime());
//			assertEquals(result.getInfos().get(2).getRawUpdateTime(), billTaskLogDO2.getRawUpdateTime());
//		}
//		if(testId == 1003){
//			assertEquals(result.getInfos().get(0).getBatchNo(), billTaskLogDO1.getBatchNo());
//			assertEquals(result.getInfos().get(0).getBillChannelTime(), billTaskLogDO1.getBillChannelTime());
//			assertEquals(result.getInfos().get(0).getBillComment(), billTaskLogDO1.getBillComment());
//			assertNotNull(result.getInfos().get(0).getBillDate());
//			assertEquals(result.getInfos().get(0).getBillStatus().toString(), billTaskLogDO1.getBillStatus());
//			assertEquals(result.getInfos().get(0).getBillTime(), billTaskLogDO1.getBillTime());
//			assertEquals(result.getInfos().get(0).getChannelComment(), billTaskLogDO1.getChannelComment());
//			assertEquals(result.getInfos().get(0).getChannelStatus().toString(), billTaskLogDO1.getChannelStatus());
//			assertEquals(result.getInfos().get(0).getId(), billTaskLogDO1.getId());
//			assertEquals(result.getInfos().get(0).getRawAddTime(), billTaskLogDO1.getRawAddTime());
//			assertEquals(result.getInfos().get(0).getRawUpdateTime(), billTaskLogDO1.getRawUpdateTime());
//		}
//		if(testId == 1004){
//			assertEquals(result.getInfos().get(0).getBatchNo(), billTaskLogDO2.getBatchNo());
//			assertEquals(result.getInfos().get(0).getBillChannelTime(), billTaskLogDO2.getBillChannelTime());
//			assertEquals(result.getInfos().get(0).getBillComment(), billTaskLogDO2.getBillComment());
//			assertNotNull(result.getInfos().get(0).getBillDate());
//			assertEquals(result.getInfos().get(0).getBillStatus().toString(), billTaskLogDO2.getBillStatus());
//			assertEquals(result.getInfos().get(0).getBillTime(), billTaskLogDO2.getBillTime());
//			assertEquals(result.getInfos().get(0).getChannelComment(), billTaskLogDO2.getChannelComment());
//			assertEquals(result.getInfos().get(0).getChannelStatus().toString(), billTaskLogDO2.getChannelStatus());
//			assertEquals(result.getInfos().get(0).getId(), billTaskLogDO2.getId());
//			assertEquals(result.getInfos().get(0).getRawAddTime(), billTaskLogDO2.getRawAddTime());
//			assertEquals(result.getInfos().get(0).getRawUpdateTime(), billTaskLogDO2.getRawUpdateTime());
//		}
//		if(testId >= 1005 && testId <= 1009){
//			assertEquals(result.getInfos().get(0).getBatchNo(), billTaskLogDO.getBatchNo());
//			assertEquals(result.getInfos().get(0).getBillChannelTime(), billTaskLogDO.getBillChannelTime());
//			assertEquals(result.getInfos().get(0).getBillComment(), billTaskLogDO.getBillComment());
//			assertNotNull(result.getInfos().get(0).getBillDate());
//			assertEquals(result.getInfos().get(0).getBillStatus().toString(), billTaskLogDO.getBillStatus());
//			assertEquals(result.getInfos().get(0).getBillTime(), billTaskLogDO.getBillTime());
//			assertEquals(result.getInfos().get(0).getChannelComment(), billTaskLogDO.getChannelComment());
//			assertEquals(result.getInfos().get(0).getChannelStatus().toString(), billTaskLogDO.getChannelStatus());
//			assertEquals(result.getInfos().get(0).getId(), billTaskLogDO.getId());
//			assertEquals(result.getInfos().get(0).getRawAddTime(), billTaskLogDO.getRawAddTime());
//			assertEquals(result.getInfos().get(0).getRawUpdateTime(), billTaskLogDO.getRawUpdateTime());
//		}
//		// 清除数据
//		clearTestBase.cleanBillTaskLogByBatchNo(billTaskLogDO.getBatchNo());
//		clearTestBase.cleanBillTaskLogByBatchNo(billTaskLogDO1.getBatchNo());
//		clearTestBase.cleanBillTaskLogByBatchNo(billTaskLogDO2.getBatchNo());
//	}
//
//	/**
//	 * 1001 order为空，提示order不能为空
//	 * 1002 batchNo长度为101，提示batchNo长度最大为100
//	 * 1003 billDate长度为9，提示billDate长度最大为8
//	 */
//	@AutoTest(file = "clear/queryBillInfoServiceQueryBillTaskLogTestFailOne.csv")
//	@DisplayName("查询任务日志--失败用例一")
//	public void queryBillInfoServiceQueryBillTaskLogTestFailOne(
//			// 基本参数
//			int testId,
//			// 业务参数
//			BillTaskLogQueryOrder billTaskLogQueryOrder,
//			// 结果参数
//			String code,
//			String description
//	){
//		// 清除数据
//		// 准备数据
//		// 测试过程
//		if(testId == 1001){
//			billTaskLogQueryOrder = null;
//		}
//		// 调用接口
//		BillTaskLogQueryResult result = queryBillInfoService.queryBillTaskLog(billTaskLogQueryOrder);
//		// 结果验证
//		assertResult(testId, Status.FAIL,code,result);
//		assertEquals(description,result.getMessage());
//		// 参数校验
//		assertNull(result.getInfos());
//		assertEquals(0,result.getTotal());
//		// 清除数据
//	}
//
//}
