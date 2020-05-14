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
import com.xyb.clear.api.order.bill.BillTaskConfIdOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：删除对账配置
 * Created on 2018/07/06.
 */
public class ManagerConfServiceDeleteTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION,group = "clear")
    ManagerConfService managerConfService;

	@Autowired
	ClearTestBase clearTestBase;

	/**
	 * 1001 删除对账配置成功
	 */
	@AutoTest(file = "clear/managerConfServiceDeleteTestSuccess.csv")
	@DisplayName("删除对账配置--成功用例")
	public void managerConfServiceDeleteTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			BillTaskConfIdOrder billTaskConfIdOrder,
			// 数据库参数
			BillTaskConfDO billTaskConfDO,
			// 干扰数据
			BillTaskConfDO billTaskConfDO1,
			// 结果参数
			String code,
			String description
	) {
		// 清除数据
		clearTestBase.cleanBillTaskConfByChannelId(billTaskConfDO.getChannelId());
		clearTestBase.cleanBillTaskConfByChannelId(billTaskConfDO1.getChannelId());
		// 准备数据
		clearTestBase.insertBillTaskConf(billTaskConfDO);
		clearTestBase.insertBillTaskConf(billTaskConfDO1);
		// 测试过程
		// 调用接口
		StandardResultInfo result = managerConfService.delete(billTaskConfIdOrder);
		// 结果验证
		assertResult(testId, Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 数据验证
		ArrayList list = new ArrayList();
		assertEquals(list,clearTestBase.findBillTaskConfByChannelId(billTaskConfDO.getChannelId()));

		BillTaskConfDO DO = clearTestBase.findBillTaskConfByChannelId(billTaskConfDO1.getChannelId()).get(0);
		assertEquals(billTaskConfDO1.getId(),DO.getId());
		assertEquals(billTaskConfDO1.getRawUpdateTime(),DO.getRawUpdateTime());
		assertEquals(billTaskConfDO1.getChannelId(),DO.getChannelId());
		assertEquals(billTaskConfDO1.getUseStatus(),DO.getUseStatus());
		assertEquals(billTaskConfDO1.getRawAddTime(),DO.getRawAddTime());
		assertEquals(billTaskConfDO1.getMemo(),DO.getMemo());
		assertEquals(billTaskConfDO1.getBillChannelTime(),DO.getBillChannelTime());
		assertEquals(billTaskConfDO1.getBillCycle(),DO.getBillCycle());
		assertEquals(billTaskConfDO1.getBillTime(),DO.getBillTime());
		assertEquals(billTaskConfDO1.getPartnerId(),DO.getPartnerId());

		// 清除数据
		clearTestBase.cleanBillTaskConfByChannelId(billTaskConfDO.getChannelId());
		clearTestBase.cleanBillTaskConfByChannelId(billTaskConfDO1.getChannelId());
	}

	/**
	 * 1001 order为空，提示order不能为空
	 * 1002 gid为空，提示gid不能为空
	 * 1003 id为空，提示id不能为空
	 * 1004 gid长度为34，提示gid长度只能为35
	 * 1005 gid长度为36，提示gid长度只能为35
	 */
	@AutoTest(file = "clear/managerConfServiceDeleteTestFailOne.csv")
	@DisplayName("删除对账配置--失败用例一")
	public void managerConfServiceDeleteTestFailOne(
			// 基本参数
			int testId,
			// 业务参数
			BillTaskConfIdOrder billTaskConfIdOrder,
			// 结果参数
			String code,
			String description
	){
		// 清除数据
		// 准备数据
		// 测试过程
		if(testId == 1001){
			billTaskConfIdOrder = null;
		}
		if(testId == 1002){
			billTaskConfIdOrder.setGid(null);
		}
		if(testId == 1003){
			billTaskConfIdOrder.setId(null);
		}
		// 调用接口
		StandardResultInfo result = managerConfService.delete(billTaskConfIdOrder);
		// 结果验证
		assertResult(testId, Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
	}

	/**
	 * 1001 配置规则不存在，删除失败
	 */
	@AutoTest(file = "clear/managerConfServiceDeleteTestFailTwo.csv")
	@DisplayName("删除对账配置--失败用例二")
	public void managerConfServiceDeleteTestFailTwo(
			// 基本参数
			int testId,
			// 业务参数
			BillTaskConfIdOrder billTaskConfIdOrder,
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
		StandardResultInfo result = managerConfService.delete(billTaskConfIdOrder);
		// 结果验证
		assertResult(testId, Status.FAIL,code,result);
		assertEquals(description,result.getDescription());
		// 参数校验
		BillTaskConfDO DO = clearTestBase.findBillTaskConfByChannelId(billTaskConfDO.getChannelId()).get(0);
		assertEquals(billTaskConfDO.getId(),DO.getId());
		assertEquals(billTaskConfDO.getRawUpdateTime(),DO.getRawUpdateTime());
		assertEquals(billTaskConfDO.getChannelId(),DO.getChannelId());
		assertEquals(billTaskConfDO.getUseStatus(),DO.getUseStatus());
		assertEquals(billTaskConfDO.getRawAddTime(),DO.getRawAddTime());
		assertEquals(billTaskConfDO.getMemo(),DO.getMemo());
		assertEquals(billTaskConfDO.getBillChannelTime(),DO.getBillChannelTime());
		assertEquals(billTaskConfDO.getBillCycle(),DO.getBillCycle());
		assertEquals(billTaskConfDO.getBillTime(),DO.getBillTime());
		assertEquals(billTaskConfDO.getPartnerId(),DO.getPartnerId());
		// 清除数据
		clearTestBase.cleanBillTaskConfById(billTaskConfDO.getId());
	}
}
