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
import com.xyb.clear.api.result.bill.BillTaskConfInfo;
import com.xyb.clear.api.service.bill.ManagerConfService;
import com.xyb.clear.api.order.bill.BillTaskConfIdOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：根据ID查询对账配置
 * Created on 2018/07/06.
 */
public class ManagerConfServiceFindByIdTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION,group = "clear")
    ManagerConfService managerConfService;

	@Autowired
	ClearTestBase clearTestBase;
	/**
	 * 1001 ID对应的对账配置存在，查询成功
	 */
	@AutoTest(file = "clear/managerConfServiceFindByIdTestSuccess.csv")
	@DisplayName("根据ID查询对账配置--成功用例")
	public void managerConfServiceFindByIdTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			BillTaskConfIdOrder billTaskConfIdOrder,
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
		// 调用接口
		BillTaskConfInfo result = managerConfService.findById(billTaskConfIdOrder);
		// 结果验证
		assertResult(testId, Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 数据验证
		assertEquals(result.getChannelId(),billTaskConfDO.getChannelId());
		assertEquals(result.getId(),billTaskConfDO.getId());
		assertEquals(result.getPartnerId(),billTaskConfDO.getPartnerId());
		assertEquals(result.getRawAddTime(),billTaskConfDO.getRawAddTime());
		assertEquals(result.getRawUpdateTime(),billTaskConfDO.getRawUpdateTime());
		assertEquals(result.getUseStatus().toString(),billTaskConfDO.getUseStatus());
		assertEquals(result.getMemo(),billTaskConfDO.getMemo());
		assertEquals(result.getBillTime(),billTaskConfDO.getBillTime());
		assertEquals(result.getBillCycle(),billTaskConfDO.getBillCycle());
		assertEquals(result.getBillChannelTime(),billTaskConfDO.getBillChannelTime());
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
	@AutoTest(file = "clear/managerConfServiceFindByIdTestFailOne.csv")
	@DisplayName("根据ID查询对账配置--失败用例一")
	public void managerConfServiceFindByIdTestFailOne(
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
		BillTaskConfInfo result = managerConfService.findById(billTaskConfIdOrder);
		// 结果验证
		assertResult(testId, Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		assertNull(result.getBizNo());
		assertNull(result.getChannelId());
		assertNull(result.getPartnerId());
		assertNull(result.getRawAddTime());
		assertNull(result.getRawUpdateTime());
		assertNull(result.getUseStatus());
		assertNull(result.getBillChannelTime());
		assertNull(result.getBillCycle());
		assertNull(result.getBillTime());
		assertNull(result.getMemo());
		// 清除数据
	}

	/**
	 * 1001 id对应的对账配置不存在，查询成功，返回为空
	 */
	@AutoTest(file = "clear/managerConfServiceFindByIdTestFailTwo.csv")
	@DisplayName("根据ID查询对账配置--失败用例二")
	public void managerConfServiceFindByIdTestFailTwo(
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
		clearTestBase.cleanBillTaskConfByChannelId(billTaskConfDO.getChannelId());
		// 准备数据
		clearTestBase.insertBillTaskConf(billTaskConfDO);
		// 测试过程
		// 调用接口
		BillTaskConfInfo result = managerConfService.findById(billTaskConfIdOrder);
		// 结果验证
		assertResult(testId, Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		assertNull(result.getBizNo());
		assertNull(result.getChannelId());
		assertNull(result.getPartnerId());
		assertNull(result.getRawAddTime());
		assertNull(result.getRawUpdateTime());
		assertNull(result.getUseStatus());
		assertNull(result.getBillChannelTime());
		assertNull(result.getBillCycle());
		assertNull(result.getBillTime());
		assertNull(result.getMemo());
		// 清除数据
		clearTestBase.cleanBillTaskConfByChannelId(billTaskConfDO.getChannelId());
	}
}
