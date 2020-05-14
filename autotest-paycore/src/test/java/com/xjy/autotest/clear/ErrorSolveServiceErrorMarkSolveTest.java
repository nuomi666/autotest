package com.xjy.autotest.clear;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.ClearTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.clear.api.enmus.BillSolveStatus;
import com.xyb.clear.api.enmus.BillStatus;
import dal.model.clear.BillErrorOrderDO;
import dal.model.clear.BillReconciliationDetailDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.xyb.adk.common.lang.result.StandardResultInfo;
import com.xyb.clear.api.service.bill.ErrorSolveService;
import com.xyb.clear.api.order.bill.BillErrorSolveOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：差错处理
 * Created on 2018/07/27.
 */
public class ErrorSolveServiceErrorMarkSolveTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION,group = "clear")
    ErrorSolveService errorSolveService;

	@Autowired
	ClearTestBase clearTestBase;
	/**
	 * 1001 状态为金额错误，进行差错处理
	 * 1002 状态为缺少内部订单，进行差错处理
	 * 1003 状态为缺少外部订单，进行差错处理
	 * 1004 状态为已解决，再次进行差错处理
	 */
	@AutoTest(file = "clear/errorSolveServiceErrorMarkSolveTestSuccess.csv")
	@DisplayName("差错处理--成功用例")
	public void errorSolveServiceErrorMarkSolveTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			BillErrorSolveOrder billErrorSolveOrder,
			// 数据库参数
			BillErrorOrderDO billErrorOrderDO,
			BillReconciliationDetailDO billReconciliationDetailDO,
			// 干扰数据
			BillErrorOrderDO billErrorOrderDO1,
			BillReconciliationDetailDO billReconciliationDetailDO1,
			// 结果参数
			String code,
			String description
	) {
		// 清除数据
		clearTestBase.cleanBillErrorOrderByBatchNo(billErrorOrderDO.getBatchNo());
		clearTestBase.cleanBillErrorOrderByBatchNo(billErrorOrderDO1.getBatchNo());
		clearTestBase.cleanBillReconciliationDetailByBatchNo(billErrorOrderDO.getBatchNo());
		clearTestBase.cleanBillReconciliationDetailByBatchNo(billErrorOrderDO1.getBatchNo());
		// 准备数据
		clearTestBase.insertBillErrorOrder(billErrorOrderDO);
		clearTestBase.insertBillErrorOrder(billErrorOrderDO1);
		clearTestBase.insertBillReconciliationDetail(billReconciliationDetailDO);
		clearTestBase.insertBillReconciliationDetail(billReconciliationDetailDO1);
		// 测试过程
		// 调用接口
		StandardResultInfo result = errorSolveService.errorMarkSolve(billErrorSolveOrder);
		// 结果验证
		assertResult(testId, Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 数据验证
		assertEquals(BillSolveStatus.RESOLVED.toString(),clearTestBase.findBillErrorOrderByBatchNo(billErrorOrderDO.getBatchNo()).get(0).getSolveStatus());

		assertEquals(billErrorOrderDO1.getSolveStatus(),clearTestBase.findBillErrorOrderByBatchNo(billErrorOrderDO1.getBatchNo()).get(0).getSolveStatus());

		assertEquals(BillStatus.SUCCESS.toString(),clearTestBase.findBillReconciliationDetailByBatchNo(billErrorOrderDO.getBatchNo()).get(0).getBillStatus());

		assertEquals(billReconciliationDetailDO1.getBillStatus(),clearTestBase.findBillReconciliationDetailByBatchNo(billErrorOrderDO1.getBatchNo()).get(0).getBillStatus());

		assertEquals(billErrorSolveOrder.getSolveComment(),clearTestBase.findBillErrorOrderByBatchNo(billErrorOrderDO.getBatchNo()).get(0).getSolveComment());
		// 清除数据
		clearTestBase.cleanBillErrorOrderByBatchNo(billErrorOrderDO.getBatchNo());
		clearTestBase.cleanBillErrorOrderByBatchNo(billErrorOrderDO1.getBatchNo());
		clearTestBase.cleanBillReconciliationDetailByBatchNo(billErrorOrderDO.getBatchNo());
		clearTestBase.cleanBillReconciliationDetailByBatchNo(billErrorOrderDO1.getBatchNo());
	}

	/**
	 * 1001 order为空，提示order不能为空
	 * 1002 orderKey为空，提示orderKey不能为空
	 * 1003 solveComment为空，提示solveComment不能为空
	 * 1004 orderKey长度为101，提示orderKey长度只能为1-100
	 * 1005 solveComment长度为101，提示solveComment长度只能为1-100
	 */
	@AutoTest(file = "clear/errorSolveServiceErrorMarkSolveTestFailOne.csv")
	@DisplayName("差错处理--失败用例一")
	public void errorSolveServiceErrorMarkSolveTestFailOne(
			// 基本参数
			int testId,
			// 业务参数
			BillErrorSolveOrder billErrorSolveOrder,
			// 结果参数
			String code,
			String description
	){
		// 清除数据
		// 准备数据
		// 测试过程
		if(testId == 1001){
			billErrorSolveOrder = null;
		}
		if(testId == 1002){
			billErrorSolveOrder.setOrderKey(null);
		}
		if(testId == 1003){
			billErrorSolveOrder.setSolveComment(null);
		}
		// 调用接口
		StandardResultInfo result = errorSolveService.errorMarkSolve(billErrorSolveOrder);
		// 结果验证
		assertResult(testId, Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		// 清除数据

	}

	/**
	 * 1001 差错记录不存在，差错处理失败
	 */
	@AutoTest(file = "clear/errorSolveServiceErrorMarkSolveTestFailTwo.csv")
	@DisplayName("差错处理--失败用例二")
	public void errorSolveServiceErrorMarkSolveTestFailTwo(
			// 基本参数
			int testId,
			// 业务参数
			BillErrorSolveOrder billErrorSolveOrder,
			// 数据库参数
			BillErrorOrderDO billErrorOrderDO,
			BillReconciliationDetailDO billReconciliationDetailDO,
			// 结果参数
			String code,
			String description
	){
		// 清除数据
		clearTestBase.cleanBillErrorOrderByBatchNo(billErrorOrderDO.getBatchNo());
		clearTestBase.cleanBillReconciliationDetailByBatchNo(billErrorOrderDO.getBatchNo());
		// 准备数据
		clearTestBase.insertBillErrorOrder(billErrorOrderDO);
		clearTestBase.insertBillReconciliationDetail(billReconciliationDetailDO);
		// 测试过程
		// 调用接口
		StandardResultInfo result = errorSolveService.errorMarkSolve(billErrorSolveOrder);
		// 结果验证
		assertResult(testId, Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		assertEquals(billErrorOrderDO.getSolveStatus(),clearTestBase.findBillErrorOrderByBatchNo(billErrorOrderDO.getBatchNo()).get(0).getSolveStatus());
		assertEquals(billReconciliationDetailDO.getBillStatus(),clearTestBase.findBillReconciliationDetailByBatchNo(billErrorOrderDO.getBatchNo()).get(0).getBillStatus());
		// 清除数据
		clearTestBase.cleanBillErrorOrderByBatchNo(billErrorOrderDO.getBatchNo());
		clearTestBase.cleanBillReconciliationDetailByBatchNo(billErrorOrderDO.getBatchNo());

	}
}
