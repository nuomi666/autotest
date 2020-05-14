package com.xjy.autotest.clear;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.ClearTestBase;
import com.xyb.adk.common.lang.result.Status;
import dal.model.clear.BillTaskConfDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.xyb.adk.common.lang.result.StandardResultInfo;
import com.xyb.clear.api.service.bill.ManagerConfService;
import com.xyb.clear.api.order.bill.BillTaskConfOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：新增对账配置管理
 * Created on 2018/07/06.
 */
public class ManagerConfServiceCreateTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION,group = "clear")
    ManagerConfService managerConfService;

	@Autowired
	ClearTestBase clearTestBase;
	/**
	 * 1001 必填参数，启动状态为启动，新增成功
	 * 1002 全填参数，启动状态为未启动，新增成功
	 * 1003 全填参数，同一商户不同渠道配置，新增成功
	 */
	@AutoTest(file = "clear/managerConfServiceCreateTestSuccess.csv")
	@DisplayName("新增对账配置管理--成功用例")
	public void managerConfServiceCreateTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			BillTaskConfOrder billTaskConfOrder,
			// 数据库参数
			BillTaskConfDO billTaskConfDO,
			// 结果参数
			String code,
			String description
	) {
		// 清除数据
		clearTestBase.cleanBillTaskConfByPartnerId(billTaskConfOrder.getPartnerId());
		// 准备数据
		if(testId == 1003){
			clearTestBase.insertBillTaskConf(billTaskConfDO);
		}
		// 测试过程
		if(testId == 1001) {
			billTaskConfOrder.setMemo(null);
		}
		// 调用接口
		StandardResultInfo result = managerConfService.create(billTaskConfOrder);
		// 结果验证
		assertResult(testId, Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 数据验证

		BillTaskConfDO DO = clearTestBase.findBillTaskConfByChannelId(billTaskConfOrder.getChannelId()).get(0);

		assertEquals(billTaskConfOrder.getBillChannelTime(),DO.getBillChannelTime());
		assertEquals(billTaskConfOrder.getBillCycle(),DO.getBillCycle());
		assertEquals(billTaskConfOrder.getBillTime(),DO.getBillTime());
		assertEquals(billTaskConfOrder.getChannelId(),DO.getChannelId());
		assertEquals(billTaskConfOrder.getPartnerId(),DO.getPartnerId());
		assertEquals(billTaskConfOrder.getUseStatus().toString(),DO.getUseStatus());
		assertNotNull(DO.getRawAddTime());
		assertNotNull(DO.getRawUpdateTime());
		assertNotNull(DO.getId());
		if(testId != 1001) {
			assertEquals(billTaskConfOrder.getMemo(), DO.getMemo());
		}else{
			assertNull(DO.getMemo());
		}
		// 清除数据
		clearTestBase.cleanBillTaskConfByPartnerId(billTaskConfOrder.getPartnerId());
	}


	/**
	 * 1001 order为空，提示order不能为空
	 * 1002 gid为空，提示gid不能为空
	 * 1003 partnerId为空，提示partnerId不能为空
	 * 1004 billChannelTime为空，提示billChannelTime不能为空
	 * 1005 billTime为空，提示billTime不能为空
	 * 1006 billCycle为空，提示billCycle不能为空
	 * 1007 channelId为空，提示channelId不能为空
	 * 1008 useStatus为空，提示useStatus不能为空
	 * 1009 gid长度为34，提示gid长度只能为35
	 * 1010 gid长度为36，提示gid长度只能为35
	 * 1011 partnerId长度为19，提示partnerId长度为20
	 * 1012 partnerId长度为21，提示partnerId长度只能为20
	 * 1013 billChannelTime格式错误，提示billChannelTime格式错误
	 * 1014 billTime格式错误，提示billTime格式错误
	 * 1015 channelId长度为0，提示channelId长度只能为1-64
	 * 1016 channelId长度为65，提示channelId长度只能为1-64
	 * 1017 memo长度为101，提示memo长度只能为1-100
	 */
	@AutoTest(file = "clear/managerConfServiceCreateTestFailOne.csv")
	@DisplayName("新增对账配置管理--失败用例一")
	public void managerConfServiceCreateTestFailOne(
			// 基本参数
			int testId,
			// 业务参数
			BillTaskConfOrder billTaskConfOrder,
			// 结果参数
			String code,
			String description
	){
		// 清除数据
		// 准备数据
		// 测试过程
		if(testId == 1001){
			billTaskConfOrder = null;
		}
		if(testId == 1002){
			billTaskConfOrder.setGid(null);
		}
		if(testId == 1003){
			billTaskConfOrder.setPartnerId(null);
		}
		if(testId == 1004){
			billTaskConfOrder.setBillChannelTime(null);
		}
		if(testId == 1005){
			billTaskConfOrder.setBillTime(null);
		}
		if(testId == 1006){
			billTaskConfOrder.setBillCycle(null);
		}
		if(testId == 1007){
			billTaskConfOrder.setChannelId(null);
		}
		if(testId == 1008){
			billTaskConfOrder.setUseStatus(null);
		}
		// 调用接口
		StandardResultInfo result = managerConfService.create(billTaskConfOrder);
		// 结果验证
		assertResult(testId, Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		if(testId != 1001) {
			ArrayList list = new ArrayList();
			assertEquals(list, clearTestBase.findBillTaskConfByChannelId(billTaskConfOrder.getChannelId()));
		}
		// 清除数据

	}

	/**
	 * 1001 对账配置已经存在，新增失败
	 */
	@AutoTest(file = "clear/managerConfServiceCreateTestFailTwo.csv")
	@DisplayName("新增对账配置管理--失败用例二")
	public void managerConfServiceCreateTestFailTwo(
			// 基本参数
			int testId,
			// 业务参数
			BillTaskConfOrder billTaskConfOrder,
			// 数据库参数
			BillTaskConfDO billTaskConfDO,
			// 结果参数
			String code,
			String description
	){
		// 清除数据
		clearTestBase.cleanBillTaskConfByChannelId(billTaskConfDO.getChannelId());
		// 准备数据
		clearTestBase.insertBillTaskConf(billTaskConfDO);
		// 测试过程
		// 调用接口
		StandardResultInfo result = managerConfService.create(billTaskConfOrder);
		// 结果验证
		assertResult(testId, Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		BillTaskConfDO DO = clearTestBase.findBillTaskConfByChannelId(billTaskConfOrder.getChannelId()).get(0);

		assertEquals(billTaskConfDO.getBillChannelTime(),DO.getBillChannelTime());
		assertEquals(billTaskConfDO.getBillCycle(),DO.getBillCycle());
		assertEquals(billTaskConfDO.getBillTime(),DO.getBillTime());
		assertEquals(billTaskConfDO.getChannelId(),DO.getChannelId());
		assertEquals(billTaskConfDO.getPartnerId(),DO.getPartnerId());
		assertEquals(billTaskConfDO.getUseStatus().toString(),DO.getUseStatus());
		assertEquals(billTaskConfDO.getRawAddTime(),DO.getRawAddTime());
		assertEquals(billTaskConfDO.getRawUpdateTime(),DO.getRawUpdateTime());
		assertEquals(billTaskConfDO.getId(),DO.getId());
		assertEquals(billTaskConfDO.getMemo(), DO.getMemo());
		// 清除数据
		clearTestBase.cleanBillTaskConfByChannelId(billTaskConfDO.getChannelId());
	}
}
