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
import com.xyb.clear.api.order.bill.BillTaskConfUpdateOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：更新对账配置
 * Created on 2018/07/06.
 */
public class ManagerConfServiceUpdateTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION,group = "clear")
    ManagerConfService managerConfService;

	@Autowired
	ClearTestBase clearTestBase;
	/**
	 * 1001 必填参数，修改成功
	 * 1002 全填参数，修改成功
	 */
	@AutoTest(file = "clear/managerConfServiceUpdateTestSuccess.csv")
	@DisplayName("更新对账配置--成功用例")
	public void managerConfServiceUpdateTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			BillTaskConfUpdateOrder billTaskConfUpdateOrder,
			// 数据库参数
			BillTaskConfDO billTaskConfDO,
			// 干扰参数
			BillTaskConfDO billTaskConfDO1,
			// 结果参数
			String code,
			String description
	) {
		// 清除数据
		clearTestBase.cleanBillTaskConfById(billTaskConfDO.getId());
		clearTestBase.cleanBillTaskConfById(billTaskConfDO1.getId());
		// 准备数据
		clearTestBase.insertBillTaskConf(billTaskConfDO);
		clearTestBase.insertBillTaskConf(billTaskConfDO1);
		// 测试过程
		if(testId == 1001){
			billTaskConfUpdateOrder.setMemo(null);
		}
		// 调用接口
		StandardResultInfo result = managerConfService.update(billTaskConfUpdateOrder);
		// 结果验证
		assertResult(testId,Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 数据验证
		BillTaskConfDO DO = clearTestBase.findBillTaskConfById(billTaskConfDO.getId()).get(0);
		assertEquals(billTaskConfUpdateOrder.getPartnerId(),DO.getPartnerId());
		assertEquals(billTaskConfUpdateOrder.getBillTime(),DO.getBillTime());
		assertEquals(billTaskConfUpdateOrder.getBillCycle(),DO.getBillCycle());
		assertEquals(billTaskConfUpdateOrder.getBillChannelTime(),DO.getBillChannelTime());
		if(testId == 1001){
			assertEquals(billTaskConfDO.getMemo(),DO.getMemo());
		}else if(testId == 1002) {
			assertEquals(billTaskConfUpdateOrder.getMemo(), DO.getMemo());
		}
		assertNotNull(DO.getRawAddTime());
		assertEquals(billTaskConfUpdateOrder.getUseStatus().toString(),DO.getUseStatus());
		assertEquals(billTaskConfUpdateOrder.getChannelId(),DO.getChannelId());
		assertNotNull(DO.getRawUpdateTime());
		assertEquals(billTaskConfUpdateOrder.getId(),DO.getId());
		// 清除数据
		clearTestBase.cleanBillTaskConfById(billTaskConfDO.getId());
		clearTestBase.cleanBillTaskConfById(billTaskConfDO1.getId());
	}

	/**
	 * 1001 order为空，提示order不能为空
	 * 1002 gid为空，提示gid不能为空
	 * 1003 id为空，提示id不能为空
	 * 1004 billChannelTime为空，提示billChannelTime不能为空
	 * 1005 billTime为空，提示billTime不能为空
	 * 1006 billCycle为空，提示billCycle不能为空
	 * 1007 channelId为空，提示channelId不能为空
	 * 1008 useStatus为空，提示useStatus不能为空
	 * 1009 gid长度为34，提示gid长度只能为35
	 * 1010 gid长度为36，提示gid长度只能为35
	 * 1011 partnerId长度为19，提示partnerId长度只能为20
	 * 1012 partnerId长度为21，提示partnerId长度只能为20
	 * 1013 billChannelTime格式不正确，提示billChannelTime格式错误
	 * 1014 billTime格式不正确，提示billTime格式错误
	 * 1015 channelId长度为0，提示channelId长度只能为1-64
	 * 1016 channelId长度为65，提示channelId长度只能为1-64
	 * 1017 memo长度为101，提示memo长度最大只能为100
	 */
	@AutoTest(file = "clear/managerConfServiceUpdateTestOne.csv")
	@DisplayName("更新对账配置--失败用例一")
	public void managerConfServiceUpdateTestOne(
			// 基本参数
			int testId,
			// 业务参数
			BillTaskConfUpdateOrder billTaskConfUpdateOrder,
			// 结果参数
			String code,
			String description
	){
		// 清除数据
		// 准备数据
		// 测试过程
		if(testId == 1001){
			billTaskConfUpdateOrder = null;
		}
		if(testId == 1002){
			billTaskConfUpdateOrder.setGid(null);
		}
		if(testId == 1003){
			billTaskConfUpdateOrder.setId(null);
		}
		if(testId == 1004){
			billTaskConfUpdateOrder.setBillChannelTime(null);
		}
		if(testId == 1005){
			billTaskConfUpdateOrder.setBillTime(null);
		}
		if(testId == 1006){
			billTaskConfUpdateOrder.setBillCycle(null);
		}
		if(testId == 1007){
			billTaskConfUpdateOrder.setChannelId(null);
		}
		if(testId == 1008){
			billTaskConfUpdateOrder.setUseStatus(null);
		}
		// 调用接口
		StandardResultInfo result = managerConfService.update(billTaskConfUpdateOrder);
		// 结果检查
		assertResult(testId, Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		// 清除数据
	}

	/**
	 * 1001 对账配置不存在，更新失败
	 */
	@AutoTest(file = "clear/managerConfServiceUpdateTestTwo.csv")
	@DisplayName("更新对账配置--失败用例二")
	public void managerConfServiceUpdateTestTwo(
			// 基本参数
			int testId,
			// 业务参数
			BillTaskConfUpdateOrder billTaskConfUpdateOrder,
			// 数据库参数
			BillTaskConfDO billTaskConfDO,
			// 结果参数
			String code,
			String description
	){
		// 清除数据
		clearTestBase.cleanBillTaskConfById(billTaskConfDO.getId());
		// 准备数据
		clearTestBase.insertBillTaskConf(billTaskConfDO);
		// 测试过程
		// 调用接口
		StandardResultInfo result = managerConfService.update(billTaskConfUpdateOrder);
		// 结果检查
		assertResult(testId, Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		BillTaskConfDO DO = clearTestBase.findBillTaskConfByChannelId(billTaskConfDO.getChannelId()).get(0);
		assertEquals(billTaskConfDO.getId(),DO.getId());
		assertNotNull(DO.getRawUpdateTime());
		assertEquals(billTaskConfDO.getChannelId(),DO.getChannelId());
		assertEquals(billTaskConfDO.getUseStatus(),DO.getUseStatus());
		assertNotNull(DO.getRawAddTime());
		assertEquals(billTaskConfDO.getMemo(),DO.getMemo());
		assertEquals(billTaskConfDO.getBillChannelTime(),DO.getBillChannelTime());
		assertEquals(billTaskConfDO.getBillCycle(),DO.getBillCycle());
		assertEquals(billTaskConfDO.getBillTime(),DO.getBillTime());
		assertEquals(billTaskConfDO.getPartnerId(),DO.getPartnerId());
		// 清除数据
		clearTestBase.cleanBillTaskConfById(billTaskConfDO.getId());
	}
}
