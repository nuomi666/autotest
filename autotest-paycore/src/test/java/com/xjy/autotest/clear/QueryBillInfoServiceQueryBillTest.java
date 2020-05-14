package com.xjy.autotest.clear;

import com.baomidou.mybatisplus.plugins.Page;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.ClearTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.clear.api.order.bill.BillQueryPageOrder;
import dal.model.clear.BillReconciliationDetailDO;
import dal.model.clear.BillTaskLogDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.xyb.clear.api.result.bill.BillQueryResult;
import com.xyb.clear.api.service.bill.QueryBillInfoService;
import com.xyb.clear.api.order.bill.BillDownOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：查询对账单
 * Created on 2018/07/27.
 */
public class QueryBillInfoServiceQueryBillTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION,group = "clear")
    QueryBillInfoService queryBillInfoService;

	@Autowired
	ClearTestBase clearTestBase;
	/**
	 * 1001 查询出三条数据，默认分页信息
	 * 1002 查询出三条数据，每页两条数据，查询第一页
	 * 1003 查询出三条数据，每页一条数据，查询第二页
	 * 1004 查询出三条数据，每页一条数据，查询第三页
	 * 1005 查询出一条数据，每页一条数据，查询第一页
	 */
	@AutoTest(file = "clear/queryBillInfoServiceQueryBillTestSuccess.csv")
	@DisplayName("查询对账单--成功用例")
	public void queryBillInfoServiceQueryBillTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
            BillQueryPageOrder billDownOrder,
			// 分页数据
			Page page,
			// 对账记录参数
			BillTaskLogDO billTaskLogDO,
			// 数据库参数
			BillReconciliationDetailDO billReconciliationDetailDO,
			BillReconciliationDetailDO billReconciliationDetailDO1,
			BillReconciliationDetailDO billReconciliationDetailDO2,
			// 结果参数
			String code,
			String description
	) {
		// 清除数据
		clearTestBase.cleanBillTaskLogByBatchNo(billTaskLogDO.getBatchNo());
		clearTestBase.cleanBillReconciliationDetailByBatchNo(billReconciliationDetailDO.getBatchNo());
		clearTestBase.cleanBillReconciliationDetailByBatchNo(billReconciliationDetailDO1.getBatchNo());
		clearTestBase.cleanBillReconciliationDetailByBatchNo(billReconciliationDetailDO2.getBatchNo());
		// 准备数据
		clearTestBase.insertBillTaskLog(billTaskLogDO);
		clearTestBase.insertBillReconciliationDetail(billReconciliationDetailDO);
		clearTestBase.insertBillReconciliationDetail(billReconciliationDetailDO1);
		clearTestBase.insertBillReconciliationDetail(billReconciliationDetailDO2);
		// 测试过程
		//billDownOrder.setPage(page);
		// 调用接口
		BillQueryResult result = queryBillInfoService.queryBill(billDownOrder);
		// 结果验证
		assertResult(testId, Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 数据验证
		if(testId == 1001 || testId == 1002) {
			//assertEquals(result.getInfos().get(0).getId(), billReconciliationDetailDO.getId());
			assertEquals(result.getInfos().get(0).getMerchantAmount().getCent(), billReconciliationDetailDO.getMerchantAmount());
			assertEquals(result.getInfos().get(0).getMerchantFee(), billReconciliationDetailDO.getMerchantFee().floatValue());
			assertEquals(result.getInfos().get(0).getMerchantFeeAmount().getCent(), billReconciliationDetailDO.getMerchantFeeAmount());
			assertEquals(result.getInfos().get(0).getMerchantOrderAmount().getCent(), billReconciliationDetailDO.getMerchantOrderAmount());
			assertEquals(result.getInfos().get(0).getMerchantRefundNo(), billReconciliationDetailDO.getMerchantRefundNo());
			assertEquals(result.getInfos().get(0).getMerchantTradeNo(), billReconciliationDetailDO.getMerchantTradeNo());
			assertEquals(result.getInfos().get(0).getMerchantTradeTime(), billReconciliationDetailDO.getMerchantTradeTime());
			assertEquals(result.getInfos().get(0).getPartnerId(), billReconciliationDetailDO.getPartnerId());
			assertEquals(result.getInfos().get(0).getTradeType().toString(), billReconciliationDetailDO.getTradeType());

			//assertEquals(result.getInfos().get(1).getId(), billReconciliationDetailDO1.getId());
			assertEquals(result.getInfos().get(1).getMerchantAmount().getCent(), billReconciliationDetailDO1.getMerchantAmount());
			assertEquals(result.getInfos().get(1).getMerchantFee(), billReconciliationDetailDO1.getMerchantFee().floatValue());
			assertEquals(result.getInfos().get(1).getMerchantFeeAmount().getCent(), billReconciliationDetailDO1.getMerchantFeeAmount());
			assertEquals(result.getInfos().get(1).getMerchantOrderAmount().getCent(), billReconciliationDetailDO1.getMerchantOrderAmount());
			assertEquals(result.getInfos().get(1).getMerchantRefundNo(), billReconciliationDetailDO1.getMerchantRefundNo());
			assertEquals(result.getInfos().get(1).getMerchantTradeNo(), billReconciliationDetailDO1.getMerchantTradeNo());
			assertEquals(result.getInfos().get(1).getMerchantTradeTime(), billReconciliationDetailDO1.getMerchantTradeTime());
			assertEquals(result.getInfos().get(1).getPartnerId(), billReconciliationDetailDO1.getPartnerId());
			assertEquals(result.getInfos().get(1).getTradeType().toString(), billReconciliationDetailDO1.getTradeType());
		}
		if(testId == 1001) {
			//assertEquals(result.getInfos().get(2).getId(), billReconciliationDetailDO2.getId());
			assertEquals(result.getInfos().get(2).getMerchantAmount().getCent(), billReconciliationDetailDO2.getMerchantAmount());
			assertEquals(result.getInfos().get(2).getMerchantFee(), billReconciliationDetailDO2.getMerchantFee().floatValue());
			assertEquals(result.getInfos().get(2).getMerchantFeeAmount().getCent(), billReconciliationDetailDO2.getMerchantFeeAmount());
			assertEquals(result.getInfos().get(2).getMerchantOrderAmount().getCent(), billReconciliationDetailDO2.getMerchantOrderAmount());
			assertEquals(result.getInfos().get(2).getMerchantRefundNo(), billReconciliationDetailDO2.getMerchantRefundNo());
			assertEquals(result.getInfos().get(2).getMerchantTradeNo(), billReconciliationDetailDO2.getMerchantTradeNo());
			assertEquals(result.getInfos().get(2).getMerchantTradeTime(), billReconciliationDetailDO2.getMerchantTradeTime());
			assertEquals(result.getInfos().get(2).getPartnerId(), billReconciliationDetailDO2.getPartnerId());
			assertEquals(result.getInfos().get(2).getTradeType().toString(), billReconciliationDetailDO2.getTradeType());
		}
		if(testId == 1003){
			//assertEquals(result.getInfos().get(0).getId(), billReconciliationDetailDO1.getId());
			assertEquals(result.getInfos().get(0).getMerchantAmount().getCent(), billReconciliationDetailDO1.getMerchantAmount());
			assertEquals(result.getInfos().get(0).getMerchantFee(), billReconciliationDetailDO1.getMerchantFee().floatValue());
			assertEquals(result.getInfos().get(0).getMerchantFeeAmount().getCent(), billReconciliationDetailDO1.getMerchantFeeAmount());
			assertEquals(result.getInfos().get(0).getMerchantOrderAmount().getCent(), billReconciliationDetailDO1.getMerchantOrderAmount());
			assertEquals(result.getInfos().get(0).getMerchantRefundNo(), billReconciliationDetailDO1.getMerchantRefundNo());
			assertEquals(result.getInfos().get(0).getMerchantTradeNo(), billReconciliationDetailDO1.getMerchantTradeNo());
			assertEquals(result.getInfos().get(0).getMerchantTradeTime(), billReconciliationDetailDO1.getMerchantTradeTime());
			assertEquals(result.getInfos().get(0).getPartnerId(), billReconciliationDetailDO1.getPartnerId());
			assertEquals(result.getInfos().get(0).getTradeType().toString(), billReconciliationDetailDO1.getTradeType());
		}
		if(testId == 1004){
			//assertEquals(result.getInfos().get(0).getId(), billReconciliationDetailDO2.getId());
			assertEquals(result.getInfos().get(0).getMerchantAmount().getCent(), billReconciliationDetailDO2.getMerchantAmount());
			assertEquals(result.getInfos().get(0).getMerchantFee(), billReconciliationDetailDO2.getMerchantFee().floatValue());
			assertEquals(result.getInfos().get(0).getMerchantFeeAmount().getCent(), billReconciliationDetailDO2.getMerchantFeeAmount());
			assertEquals(result.getInfos().get(0).getMerchantOrderAmount().getCent(), billReconciliationDetailDO2.getMerchantOrderAmount());
			assertEquals(result.getInfos().get(0).getMerchantRefundNo(), billReconciliationDetailDO2.getMerchantRefundNo());
			assertEquals(result.getInfos().get(0).getMerchantTradeNo(), billReconciliationDetailDO2.getMerchantTradeNo());
			assertEquals(result.getInfos().get(0).getMerchantTradeTime(), billReconciliationDetailDO2.getMerchantTradeTime());
			assertEquals(result.getInfos().get(0).getPartnerId(), billReconciliationDetailDO2.getPartnerId());
			assertEquals(result.getInfos().get(0).getTradeType().toString(), billReconciliationDetailDO2.getTradeType());
		}
		if(testId == 1005){
			//assertEquals(result.getInfos().get(0).getId(), billReconciliationDetailDO.getId());
			assertEquals(result.getInfos().get(0).getMerchantAmount().getCent(), billReconciliationDetailDO.getMerchantAmount());
			assertEquals(result.getInfos().get(0).getMerchantFee(), billReconciliationDetailDO.getMerchantFee().floatValue());
			assertEquals(result.getInfos().get(0).getMerchantFeeAmount().getCent(), billReconciliationDetailDO.getMerchantFeeAmount());
			assertEquals(result.getInfos().get(0).getMerchantOrderAmount().getCent(), billReconciliationDetailDO.getMerchantOrderAmount());
			assertEquals(result.getInfos().get(0).getMerchantRefundNo(), billReconciliationDetailDO.getMerchantRefundNo());
			assertEquals(result.getInfos().get(0).getMerchantTradeNo(), billReconciliationDetailDO.getMerchantTradeNo());
			assertEquals(result.getInfos().get(0).getMerchantTradeTime(), billReconciliationDetailDO.getMerchantTradeTime());
			assertEquals(result.getInfos().get(0).getPartnerId(), billReconciliationDetailDO.getPartnerId());
			assertEquals(result.getInfos().get(0).getTradeType().toString(), billReconciliationDetailDO.getTradeType());
		}
		// 清除数据
		clearTestBase.cleanBillTaskLogByBatchNo(billTaskLogDO.getBatchNo());
		clearTestBase.cleanBillReconciliationDetailByBatchNo(billReconciliationDetailDO.getBatchNo());
		clearTestBase.cleanBillReconciliationDetailByBatchNo(billReconciliationDetailDO1.getBatchNo());
		clearTestBase.cleanBillReconciliationDetailByBatchNo(billReconciliationDetailDO2.getBatchNo());
	}

	/**
	 * 1001 order为空，提示order不能为空
	 * 1002 partnerId为空，提示partnerId不能为空
	 * 1003 channelId为空，提示channelId不能为空
	 * 1004 billDate为空，提示billDate不能为空
	 * 1005 partnerId长度为19，提示partnerId长度只能为20
	 * 1006 partnerId长度为21，提示partnerId长度只能为20
	 * 1007 channelId长度为101，提示channelId长度只能为1-100
	 * 1008 billDate长度为7，提示billDate长度只能为8
	 * 1009 billDate长度为9，提示billDate长度只能为8
	 */
	@AutoTest(file = "clear/queryBillInfoServiceQueryBillTestFailOne.csv")
	@DisplayName("查询对账单--失败用例一")
	public void queryBillInfoServiceQueryBillTestFailOne(
			// 基本参数
			int testId,
			// 业务参数
            BillQueryPageOrder billDownOrder,
			// 结果参数
			String code,
			String description
	){
		// 清除数据
		// 准备数据
		// 测试过程
		if(testId == 1001){
			billDownOrder = null;
		}
		if(testId == 1002){
			billDownOrder.setPartnerId(null);
		}
		if(testId == 1003){
			//billDownOrder.setChannelId(null);
		}
		if(testId == 1004){
			billDownOrder.setBillDate(null);
		}
		// 调用接口
		// 调用接口
		BillQueryResult result = queryBillInfoService.queryBill(billDownOrder);
		// 结果验证
		assertResult(testId, Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 结果检查
		assertNull(result.getInfos());
		// 清除数据
	}

	/**
	 * 1001 对账记录不存在，查询失败
	 * 1002 对账记录状态为初始化，查询失败
	 * 1003 对账记录状态为失败，查询失败
	 */
	@AutoTest(file = "clear/queryBillInfoServiceQueryBillTestFailTwo.csv")
	@DisplayName("查询对账单--失败用例二")
	public void queryBillInfoServiceQueryBillTestFailTwo(
			// 基本参数
			int testId,
			// 业务参数
            BillQueryPageOrder billDownOrder,
			// 分页数据
			Page page,
			// 对账记录参数
			BillTaskLogDO billTaskLogDO,
			// 数据库参数
			BillReconciliationDetailDO billReconciliationDetailDO,
			// 结果参数
			String code,
			String description
	){
		// 清除数据
		clearTestBase.cleanBillTaskLogByBatchNo(billTaskLogDO.getBatchNo());
		clearTestBase.cleanBillReconciliationDetailByBatchNo(billReconciliationDetailDO.getBatchNo());
		// 准备数据
		clearTestBase.insertBillTaskLog(billTaskLogDO);
		clearTestBase.insertBillReconciliationDetail(billReconciliationDetailDO);
		// 测试过程
		// 调用接口
		BillQueryResult result = queryBillInfoService.queryBill(billDownOrder);
		// 结果验证
		assertResult(testId, Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 结果检查
		assertNull(result.getInfos());
		// 清除数据
		clearTestBase.cleanBillTaskLogByBatchNo(billTaskLogDO.getBatchNo());
		clearTestBase.cleanBillReconciliationDetailByBatchNo(billReconciliationDetailDO.getBatchNo());
	}

}
