package com.xjy.autotest.clear;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.ClearTestBase;
import com.xyb.adk.common.lang.result.Status;
import dal.model.clear.BillErrorOrderDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.xyb.clear.api.result.bill.BillErrorQueryResult;
import com.xyb.clear.api.service.bill.QueryBillInfoService;
import com.xyb.clear.api.order.bill.BillErrorOrderQueryOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：查询差错处理
 * Created on 2018/07/24.
 */
public class QueryBillInfoServiceQueryBillErrorTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    QueryBillInfoService queryBillInfoService;

	@Autowired
	ClearTestBase clearTestBase;
	/**
	 * 1001 无条件查询，每页三条数据，查询第一页
	 * 1002 无条件查询，每页两条数据，查询第一页
	 * 1003 无条件查询，每页一条数据，查询第二页
	 * 1004 无条件查询，每页一条数据，查询第三页
	 * 1005 根据batchNo查询，每页一条数据，查询第一页
	 * 1006 根据partnerId查询，每页一条数据，查询第一页
	 * 1007 根据platPartnerId查询，每页一条数据，查询第一页
	 * 1008 根据orderKey查询，每页一条数据，查询第一页
	 * 1009 根据billStatus查询，每页一条数据，查询第一页
	 * 1010 根据tradeType查询，每页一条数据，查询第一页
	 * 1011 根据channelOrderNo查询，每页一条数据，查询第一页
	 * 1012 根据merchantOrderNo查询，每页一条数据，查询第一页
	 * 1013 根据channelId查询，每页一条数据，查询第一页
	 * 1014 根据所有查询条件查询，每页一条数据，查询第一页
	 */
	@AutoTest(file = "clear/queryBillInfoServiceQueryBillErrorTestSuccess.csv")
	@DisplayName("查询差错处理--成功用例")
	public void queryBillInfoServiceQueryBillErrorTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			BillErrorOrderQueryOrder billErrorOrderQueryOrder,
			// 数据库参数
			BillErrorOrderDO billErrorOrderDO,
			BillErrorOrderDO billErrorOrderDO1,
			BillErrorOrderDO billErrorOrderDO2,
			// 结果参数
			String code,
			String description
	) {
		// 清除数据
		clearTestBase.cleanBillErrorOrderByBatchNo(billErrorOrderDO.getBatchNo());
		clearTestBase.cleanBillErrorOrderByBatchNo(billErrorOrderDO1.getBatchNo());
		clearTestBase.cleanBillErrorOrderByBatchNo(billErrorOrderDO2.getBatchNo());
		// 准备数据
		clearTestBase.insertBillErrorOrder(billErrorOrderDO);
		clearTestBase.insertBillErrorOrder(billErrorOrderDO1);
		clearTestBase.insertBillErrorOrder(billErrorOrderDO2);
		// 测试过程
		if(testId != 1014){
			billErrorOrderQueryOrder = null;
			billErrorOrderQueryOrder.setPage(billErrorOrderQueryOrder.getPage());
		}
		// 调用接口
		BillErrorQueryResult result = queryBillInfoService.queryBillError(billErrorOrderQueryOrder);
		// 结果验证
		assertResult(testId, Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 数据验证
		if(testId == 1001 || testId == 1002) {
			assertEquals(result.getInfos().get(0).getBatchNo(), billErrorOrderDO.getBatchNo());
			assertEquals(result.getInfos().get(0).getBillStatus(), billErrorOrderDO.getBillStatus());
			assertEquals(result.getInfos().get(0).getChannelOrderAmount(), billErrorOrderDO.getChannelOrderAmount());
			assertEquals(result.getInfos().get(0).getChannelOrderNo(), billErrorOrderDO.getChannelOrderNo());
			assertEquals(result.getInfos().get(0).getId(), billErrorOrderDO.getId());
			assertEquals(result.getInfos().get(0).getMerchantOrderAmount(), billErrorOrderDO.getMerchantOrderAmount());
			assertEquals(result.getInfos().get(0).getMerchantOrderNo(), billErrorOrderDO.getMerchantOrderNo());
			assertEquals(result.getInfos().get(0).getMerchantTradeNo(), billErrorOrderDO.getMerchantTradeNo());
			assertEquals(result.getInfos().get(0).getOrderKey(), billErrorOrderDO.getOrderKey());
			assertEquals(result.getInfos().get(0).getPartnerId(), billErrorOrderDO.getPartnerId());
			assertEquals(result.getInfos().get(0).getPlatPartnerId(), billErrorOrderDO.getPlatPartnerId());
			assertEquals(result.getInfos().get(0).getRawAddTime(), billErrorOrderDO.getRawAddTime());
			assertEquals(result.getInfos().get(0).getRawUpdateTime(), billErrorOrderDO.getRawUpdateTime());
			assertEquals(result.getInfos().get(0).getSolveComment(), billErrorOrderDO.getSolveComment());
			assertEquals(result.getInfos().get(0).getSolveStatus(), billErrorOrderDO.getSolveStatus());
			assertEquals(result.getInfos().get(0).getTradeType(), billErrorOrderDO.getTradeType());

			assertEquals(result.getInfos().get(1).getBatchNo(), billErrorOrderDO1.getBatchNo());
			assertEquals(result.getInfos().get(1).getBillStatus(), billErrorOrderDO1.getBillStatus());
			assertEquals(result.getInfos().get(1).getChannelOrderAmount(), billErrorOrderDO1.getChannelOrderAmount());
			assertEquals(result.getInfos().get(1).getChannelOrderNo(), billErrorOrderDO1.getChannelOrderNo());
			assertEquals(result.getInfos().get(1).getId(), billErrorOrderDO1.getId());
			assertEquals(result.getInfos().get(1).getMerchantOrderAmount(), billErrorOrderDO1.getMerchantOrderAmount());
			assertEquals(result.getInfos().get(1).getMerchantOrderNo(), billErrorOrderDO1.getMerchantOrderNo());
			assertEquals(result.getInfos().get(1).getMerchantTradeNo(), billErrorOrderDO1.getMerchantTradeNo());
			assertEquals(result.getInfos().get(1).getOrderKey(), billErrorOrderDO1.getOrderKey());
			assertEquals(result.getInfos().get(1).getPartnerId(), billErrorOrderDO1.getPartnerId());
			assertEquals(result.getInfos().get(1).getPlatPartnerId(), billErrorOrderDO1.getPlatPartnerId());
			assertEquals(result.getInfos().get(1).getRawAddTime(), billErrorOrderDO1.getRawAddTime());
			assertEquals(result.getInfos().get(1).getRawUpdateTime(), billErrorOrderDO1.getRawUpdateTime());
			assertEquals(result.getInfos().get(1).getSolveComment(), billErrorOrderDO1.getSolveComment());
			assertEquals(result.getInfos().get(1).getSolveStatus(), billErrorOrderDO1.getSolveStatus());
			assertEquals(result.getInfos().get(1).getTradeType(), billErrorOrderDO1.getTradeType());
		}
		if(testId == 1001) {
			assertEquals(result.getInfos().get(2).getBatchNo(), billErrorOrderDO2.getBatchNo());
			assertEquals(result.getInfos().get(2).getBillStatus(), billErrorOrderDO2.getBillStatus());
			assertEquals(result.getInfos().get(2).getChannelOrderAmount(), billErrorOrderDO2.getChannelOrderAmount());
			assertEquals(result.getInfos().get(2).getChannelOrderNo(), billErrorOrderDO2.getChannelOrderNo());
			assertEquals(result.getInfos().get(2).getId(), billErrorOrderDO2.getId());
			assertEquals(result.getInfos().get(2).getMerchantOrderAmount(), billErrorOrderDO2.getMerchantOrderAmount());
			assertEquals(result.getInfos().get(2).getMerchantOrderNo(), billErrorOrderDO2.getMerchantOrderNo());
			assertEquals(result.getInfos().get(2).getMerchantTradeNo(), billErrorOrderDO2.getMerchantTradeNo());
			assertEquals(result.getInfos().get(2).getOrderKey(), billErrorOrderDO2.getOrderKey());
			assertEquals(result.getInfos().get(2).getPartnerId(), billErrorOrderDO2.getPartnerId());
			assertEquals(result.getInfos().get(2).getPlatPartnerId(), billErrorOrderDO2.getPlatPartnerId());
			assertEquals(result.getInfos().get(2).getRawAddTime(), billErrorOrderDO2.getRawAddTime());
			assertEquals(result.getInfos().get(2).getRawUpdateTime(), billErrorOrderDO2.getRawUpdateTime());
			assertEquals(result.getInfos().get(2).getSolveComment(), billErrorOrderDO2.getSolveComment());
			assertEquals(result.getInfos().get(2).getSolveStatus(), billErrorOrderDO2.getSolveStatus());
			assertEquals(result.getInfos().get(2).getTradeType(), billErrorOrderDO2.getTradeType());
		}
		if(testId == 1003){
			assertEquals(result.getInfos().get(0).getBatchNo(), billErrorOrderDO1.getBatchNo());
			assertEquals(result.getInfos().get(0).getBillStatus(), billErrorOrderDO1.getBillStatus());
			assertEquals(result.getInfos().get(0).getChannelOrderAmount(), billErrorOrderDO1.getChannelOrderAmount());
			assertEquals(result.getInfos().get(0).getChannelOrderNo(), billErrorOrderDO1.getChannelOrderNo());
			assertEquals(result.getInfos().get(0).getId(), billErrorOrderDO1.getId());
			assertEquals(result.getInfos().get(0).getMerchantOrderAmount(), billErrorOrderDO1.getMerchantOrderAmount());
			assertEquals(result.getInfos().get(0).getMerchantOrderNo(), billErrorOrderDO1.getMerchantOrderNo());
			assertEquals(result.getInfos().get(0).getMerchantTradeNo(), billErrorOrderDO1.getMerchantTradeNo());
			assertEquals(result.getInfos().get(0).getOrderKey(), billErrorOrderDO1.getOrderKey());
			assertEquals(result.getInfos().get(0).getPartnerId(), billErrorOrderDO1.getPartnerId());
			assertEquals(result.getInfos().get(0).getPlatPartnerId(), billErrorOrderDO1.getPlatPartnerId());
			assertEquals(result.getInfos().get(0).getRawAddTime(), billErrorOrderDO1.getRawAddTime());
			assertEquals(result.getInfos().get(0).getRawUpdateTime(), billErrorOrderDO1.getRawUpdateTime());
			assertEquals(result.getInfos().get(0).getSolveComment(), billErrorOrderDO1.getSolveComment());
			assertEquals(result.getInfos().get(0).getSolveStatus(), billErrorOrderDO1.getSolveStatus());
			assertEquals(result.getInfos().get(0).getTradeType(), billErrorOrderDO1.getTradeType());
		}
		if(testId == 1004){
			assertEquals(result.getInfos().get(0).getBatchNo(), billErrorOrderDO2.getBatchNo());
			assertEquals(result.getInfos().get(0).getBillStatus(), billErrorOrderDO2.getBillStatus());
			assertEquals(result.getInfos().get(0).getChannelOrderAmount(), billErrorOrderDO2.getChannelOrderAmount());
			assertEquals(result.getInfos().get(0).getChannelOrderNo(), billErrorOrderDO2.getChannelOrderNo());
			assertEquals(result.getInfos().get(0).getId(), billErrorOrderDO2.getId());
			assertEquals(result.getInfos().get(0).getMerchantOrderAmount(), billErrorOrderDO2.getMerchantOrderAmount());
			assertEquals(result.getInfos().get(0).getMerchantOrderNo(), billErrorOrderDO2.getMerchantOrderNo());
			assertEquals(result.getInfos().get(0).getMerchantTradeNo(), billErrorOrderDO2.getMerchantTradeNo());
			assertEquals(result.getInfos().get(0).getOrderKey(), billErrorOrderDO2.getOrderKey());
			assertEquals(result.getInfos().get(0).getPartnerId(), billErrorOrderDO2.getPartnerId());
			assertEquals(result.getInfos().get(0).getPlatPartnerId(), billErrorOrderDO2.getPlatPartnerId());
			assertEquals(result.getInfos().get(0).getRawAddTime(), billErrorOrderDO2.getRawAddTime());
			assertEquals(result.getInfos().get(0).getRawUpdateTime(), billErrorOrderDO2.getRawUpdateTime());
			assertEquals(result.getInfos().get(0).getSolveComment(), billErrorOrderDO2.getSolveComment());
			assertEquals(result.getInfos().get(0).getSolveStatus(), billErrorOrderDO2.getSolveStatus());
			assertEquals(result.getInfos().get(0).getTradeType(), billErrorOrderDO2.getTradeType());
		}
		if(testId >= 1005 && testId <= 1014){
			assertEquals(result.getInfos().get(0).getBatchNo(), billErrorOrderDO.getBatchNo());
			assertEquals(result.getInfos().get(0).getBillStatus(), billErrorOrderDO.getBillStatus());
			assertEquals(result.getInfos().get(0).getChannelOrderAmount(), billErrorOrderDO.getChannelOrderAmount());
			assertEquals(result.getInfos().get(0).getChannelOrderNo(), billErrorOrderDO.getChannelOrderNo());
			assertEquals(result.getInfos().get(0).getId(), billErrorOrderDO.getId());
			assertEquals(result.getInfos().get(0).getMerchantOrderAmount(), billErrorOrderDO.getMerchantOrderAmount());
			assertEquals(result.getInfos().get(0).getMerchantOrderNo(), billErrorOrderDO.getMerchantOrderNo());
			assertEquals(result.getInfos().get(0).getMerchantTradeNo(), billErrorOrderDO.getMerchantTradeNo());
			assertEquals(result.getInfos().get(0).getOrderKey(), billErrorOrderDO.getOrderKey());
			assertEquals(result.getInfos().get(0).getPartnerId(), billErrorOrderDO.getPartnerId());
			assertEquals(result.getInfos().get(0).getPlatPartnerId(), billErrorOrderDO.getPlatPartnerId());
			assertEquals(result.getInfos().get(0).getRawAddTime(), billErrorOrderDO.getRawAddTime());
			assertEquals(result.getInfos().get(0).getRawUpdateTime(), billErrorOrderDO.getRawUpdateTime());
			assertEquals(result.getInfos().get(0).getSolveComment(), billErrorOrderDO.getSolveComment());
			assertEquals(result.getInfos().get(0).getSolveStatus(), billErrorOrderDO.getSolveStatus());
			assertEquals(result.getInfos().get(0).getTradeType(), billErrorOrderDO.getTradeType());
		}
		// 清除数据
		clearTestBase.cleanBillErrorOrderByBatchNo(billErrorOrderDO.getBatchNo());
		clearTestBase.cleanBillErrorOrderByBatchNo(billErrorOrderDO1.getBatchNo());
		clearTestBase.cleanBillErrorOrderByBatchNo(billErrorOrderDO2.getBatchNo());
	}

	/**
	 * 1001 order为空，提示order不能为空
	 * 1002 batchNo长度为101，提示batchNo长度最大只能为100
	 * 1003 partnerId长度为19，提示partnerId长度只能为20
	 * 1004 partnerId长度为21，提示partnerId长度只能为20
	 * 1005 platPartnerId长度为19，提示platPartnerId长度只能为20
	 * 1006 platPartnerId长度为21，提示platPartnerId长度只能为20
	 * 1007 orderKey长度为29，提示orderKey长度只能为30
	 * 1008 orderKey长度为31，提示orderKey长度只能为30
	 * 1009 channelOrderNo长度为19，提示channelOrderNo长度只能为20
	 * 1010 channelOrderNo长度为21，提示channelOrderNo长度只能为20
	 * 1011 merchantOrderNo长度为19，提示merchantOrderNo长度只能为20
	 * 1012 merchantOrderNo长度为21，提示merchantOrderNo长度只能为20
	 * 1013 channelId长度为65，提示channelId长度只能为1-64
	 */
	@AutoTest(file = "clear/queryBillInfoServiceQueryBillErrorTestFailOne.csv")
	@DisplayName("查询差错处理--失败用例一")
	public void queryBillInfoServiceQueryBillErrorTestFailOne(
			// 基本参数
			int testId,
			// 业务参数
			BillErrorOrderQueryOrder billErrorOrderQueryOrder,
			// 结果参数
			String code,
			String description
	){
		// 清除数据
		// 准备数据
		// 测试过程
		if(testId == 1001){
			billErrorOrderQueryOrder = null;
		}
		// 调用接口
		BillErrorQueryResult result = queryBillInfoService.queryBillError(billErrorOrderQueryOrder);
		// 结果验证
		assertResult(testId, Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 参数校验
		assertNull(result.getInfos());
		// 清除数据
	}
}
