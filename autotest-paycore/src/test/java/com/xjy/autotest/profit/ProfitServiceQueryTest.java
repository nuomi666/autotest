package com.xjy.autotest.profit;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.ProfitTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.profit.api.order.ProfitDetailQueryOrder;
import com.xyb.profit.api.result.ProfitDetailQueryResult;
import com.xyb.profit.api.result.info.TransferInfo;
import com.xyb.profit.api.service.ProfitService;
import dal.model.profit.*;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author ychaoyang
 * Created on 2018/06/13.
 */
public class ProfitServiceQueryTest extends SpringBootTestBase {

	@Reference(version = DUBBO_VERSION, group = "profit_provider_group")
	public ProfitService profitService;

	@Autowired
	public ProfitTestBase profitTestBase;

	/**
	 * 1001 分润成功
	 * 1002 分润失败
	 * 1003 分润处理中
	 * 1004 分润初始化状态
	 * 1005 分润已退款
	 * 1006 多条分润记录
	 */
	@AutoTest(file = "profit/profitServiceQueryTestSuccess.csv")
	@DisplayName("分润明细查询--成功用例")
	public void profitServiceQueryTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			ProfitDetailQueryResult profitDetailQueryResult,
			ProfitDetailQueryOrder order,
			// 准备数据
			ProfitOrderDO profitOrderDO,
			TaskExecuteRecordDO taskExecuteRecordDO,
			ActionExecuteRecordDO actionExecuteRecordDO,
			ActionExecuteRecordDO actionExecuteRecordDO1,
			TransferInfo transferInfo,
			TransferInfo transferInfo1,
			RefundExecuteRecordDO refundExecuteRecordDO,
			ProfitRefundDO profitRefundDO
	) {
		// 清除数据
		profitTestBase.cleanProfitOrderById(profitOrderDO.getId());
		profitTestBase.cleanTaskExecuteRecordById(taskExecuteRecordDO.getId());
		profitTestBase.cleanActionExecuteRecordById(actionExecuteRecordDO.getId());
		profitTestBase.cleanActionExecuteRecordById(actionExecuteRecordDO1.getId());
		profitTestBase.cleanRefundExecuteRecordById(refundExecuteRecordDO.getId());
		profitTestBase.cleanProfitRefundById(profitRefundDO.getId());
		// 准备数据
		profitTestBase.insertProfitOrder(profitOrderDO);
		profitTestBase.insertTaskExecuteRecord(taskExecuteRecordDO);
		profitTestBase.insertActionExecuteRecord(actionExecuteRecordDO);
		if (testId == 1006) {
			profitTestBase.insertActionExecuteRecord(actionExecuteRecordDO1);
		}
		if (testId == 1005) {
			profitTestBase.insertRefundExecuteRecord(refundExecuteRecordDO);
		}
		// 测试过程
		order.setGid(GID.newGID());
		// 调用接口
		ProfitDetailQueryResult result = profitService.query(order);
		// 结果验证
		List infos = new ArrayList();
		infos.add(transferInfo);
		if (testId == 1006) {
			infos.add(transferInfo1);
		}
		profitDetailQueryResult.setInfos(infos);
		assertResultInfo(testId, profitDetailQueryResult, result);
		// 数据验证
		// 清除数据
		profitTestBase.cleanProfitOrderById(profitOrderDO.getId());
		profitTestBase.cleanTaskExecuteRecordById(taskExecuteRecordDO.getId());
		profitTestBase.cleanActionExecuteRecordById(actionExecuteRecordDO.getId());
		profitTestBase.cleanActionExecuteRecordById(actionExecuteRecordDO1.getId());
	}

	/**
	 * 1001 partnerId传空
	 * 1002 gid传空
	 * 1003 profitOrderNo传空
	 * 1004 tradeNo传空
	 * 1005 gid长度不够
	 */
	@AutoTest(file = "profit/profitServiceQueryTestFailOne.csv")
	@DisplayName("参数缺省--失败用例")
	public void profitServiceQueryTestFailOne(
			// 基本参数
			int testId,
			// 业务参数
			ProfitDetailQueryResult profitDetailQueryResult,
			ProfitDetailQueryOrder order
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		print(order);
		// 调用接口
		ProfitDetailQueryResult result = profitService.query(order);
		// 结果验证
		assertResultInfo(testId, profitDetailQueryResult, result);
		// 数据验证
		// 清除数据
	}

	/**
	 * 1001 交易单号不存在
	 * 1002 交易单号不属于该商户
	 */
	@AutoTest(file = "profit/profitServiceQueryTestFailTwo.csv")
	@DisplayName("分润明细查询--失败用例")
	public void profitServiceQueryTestFailTwo(
			// 基本参数
			int testId,
			// 业务参数
			ProfitDetailQueryResult profitDetailQueryResult,
			ProfitDetailQueryOrder order,
			// 准备数据
			ProfitOrderDO profitOrderDO,
			TaskExecuteRecordDO taskExecuteRecordDO,
			ActionExecuteRecordDO actionExecuteRecordDO,
			ActionExecuteRecordDO actionExecuteRecordDO1,
			TransferInfo transferInfo,
			TransferInfo transferInfo1
	) {
		// 清除数据
		profitTestBase.cleanProfitOrderById(profitOrderDO.getId());
//		profitTestBase.cleanProfitOrderByOrderNo(order.getProfitOrderNo());
		profitTestBase.cleanTaskExecuteRecordById(taskExecuteRecordDO.getId());
		profitTestBase.cleanActionExecuteRecordById(actionExecuteRecordDO.getId());
		profitTestBase.cleanActionExecuteRecordById(actionExecuteRecordDO1.getId());
		// 准备数据
		if (testId != 1001) {
			profitTestBase.insertProfitOrder(profitOrderDO);
			profitTestBase.insertTaskExecuteRecord(taskExecuteRecordDO);
			profitTestBase.insertActionExecuteRecord(actionExecuteRecordDO);
			profitTestBase.insertActionExecuteRecord(actionExecuteRecordDO1);
		}
		// 测试过程
		order.setGid(GID.newGID());
		// 调用接口
		ProfitDetailQueryResult result = profitService.query(order);
		// 结果验证
		assertResultInfo(testId, profitDetailQueryResult, result);
		// 数据验证
		// 清除数据
		profitTestBase.cleanProfitOrderById(profitOrderDO.getId());
		profitTestBase.cleanTaskExecuteRecordById(taskExecuteRecordDO.getId());
		profitTestBase.cleanActionExecuteRecordById(actionExecuteRecordDO.getId());
		profitTestBase.cleanActionExecuteRecordById(actionExecuteRecordDO1.getId());
	}
}
