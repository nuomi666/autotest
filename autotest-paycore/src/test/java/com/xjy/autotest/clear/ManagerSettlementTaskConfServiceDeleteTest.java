package com.xjy.autotest.clear;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.ClearTestBase;
import com.xyb.adk.common.lang.result.Status;
import dal.model.clear.ClearTransTypeConfDO;
import dal.model.clear.SettlementTaskConfDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.xyb.adk.common.lang.result.StandardResultInfo;
import com.xyb.clear.api.service.settlement.ManagerSettlementTaskConfService;
import com.xyb.clear.api.order.BaseIdOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：删除结算配置
 * Created on 2018/08/03.
 */
public class ManagerSettlementTaskConfServiceDeleteTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION,group = "clear")
    ManagerSettlementTaskConfService managerSettlementTaskConfService;

	@Autowired
	ClearTestBase clearTestBase;
	/**
	 * 1001 结算配置存在，删除配置成功
	 */
	@AutoTest(file = "clear/managerSettlementTaskConfServiceDeleteTestSuccess.csv")
	@DisplayName("删除结算配置--成功用例")
	public void managerSettlementTaskConfServiceDeleteTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			BaseIdOrder baseIdOrder,
			// 数据库参数
			SettlementTaskConfDO settlementTaskConfDO,
			SettlementTaskConfDO settlementTaskConfDO1,
			// 清分交易类型参数
			ClearTransTypeConfDO clearTransTypeConfDO,
			ClearTransTypeConfDO clearTransTypeConfDO1,
			// 结果参数
			String code,
			String description
	) {
		// 清除数据
		clearTestBase.cleanSettlementTaskConfByPartnerId(settlementTaskConfDO.getPartnerId());
		clearTestBase.cleanSettlementTaskConfByPartnerId(settlementTaskConfDO1.getPartnerId());
		clearTestBase.cleanClearTransTypeConfByPartnerId(clearTransTypeConfDO.getPartnerId());
		clearTestBase.cleanClearTransTypeConfByPartnerId(clearTransTypeConfDO1.getPartnerId());
		// 准备数据
		clearTestBase.insertSettlementTaskConf(settlementTaskConfDO);
		clearTestBase.insertSettlementTaskConf(settlementTaskConfDO1);
		clearTestBase.insertClearTransTypeConf(clearTransTypeConfDO);
		clearTestBase.insertClearTransTypeConf(clearTransTypeConfDO1);
		// 测试过程
		// 调用接口
		StandardResultInfo result = managerSettlementTaskConfService.delete(baseIdOrder);
		// 结果验证
		assertResult(testId, Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 数据验证
		assertEquals(0,clearTestBase.findSettlementTaskConfByPartnerId(settlementTaskConfDO.getPartnerId()));
		assertEquals(1,clearTestBase.findSettlementTaskConfByPartnerId(settlementTaskConfDO1.getPartnerId()));
		// 清除数据
		clearTestBase.cleanSettlementTaskConfByPartnerId(settlementTaskConfDO.getPartnerId());
		clearTestBase.cleanSettlementTaskConfByPartnerId(settlementTaskConfDO1.getPartnerId());
		clearTestBase.cleanClearTransTypeConfByPartnerId(clearTransTypeConfDO.getPartnerId());
		clearTestBase.cleanClearTransTypeConfByPartnerId(clearTransTypeConfDO1.getPartnerId());
	}

	@AutoTest(file = "clear/managerSettlementTaskConfServiceDeleteTestFailOne.csv")
	@DisplayName("删除结算配置--失败用例一")
	public void managerSettlementTaskConfServiceDeleteTestFailOne(
			// 基本参数
			int testId,
			// 业务参数
			BaseIdOrder baseIdOrder,
			// 结果参数
			String code,
			String description
	){
		// 清除数据
		// 准备数据
		// 测试过程
		if(testId == 1001){
			baseIdOrder = null;
		}
		if(testId == 1002){
			baseIdOrder.setId(null);
		}
		// 调用接口
		StandardResultInfo result = managerSettlementTaskConfService.delete(baseIdOrder);
		// 结果检查
		assertResult(testId,Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		// 清除数据
	}

	/**
	 * 1001 结算配置不存在，删除失败
	 */
	@AutoTest(file = "clear/managerSettlementTaskConfServiceDeleteTestFailOne.csv")
	@DisplayName("删除结算配置--失败用例二")
	public void managerSettlementTaskConfServiceDeleteTestFailTwo(
			// 基本参数
			int testId,
			// 业务参数
			BaseIdOrder baseIdOrder,
			// 数据库参数
			SettlementTaskConfDO settlementTaskConfDO,
			// 清分交易类型参数
			ClearTransTypeConfDO clearTransTypeConfDO,
			// 结果参数
			String code,
			String description
	){
		// 清除数据
		clearTestBase.cleanSettlementTaskConfByPartnerId(settlementTaskConfDO.getPartnerId());
		clearTestBase.cleanClearTransTypeConfByPartnerId(clearTransTypeConfDO.getPartnerId());
		// 准备数据
		clearTestBase.insertSettlementTaskConf(settlementTaskConfDO);
		clearTestBase.insertClearTransTypeConf(clearTransTypeConfDO);
		// 测试过程
		// 调用接口
		StandardResultInfo result = managerSettlementTaskConfService.delete(baseIdOrder);
		// 结果检查
		assertResult(testId,Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		assertEquals(1,clearTestBase.findSettlementTaskConfByPartnerId(settlementTaskConfDO.getPartnerId()));
		// 清除数据
		clearTestBase.cleanSettlementTaskConfByPartnerId(settlementTaskConfDO.getPartnerId());
		clearTestBase.cleanClearTransTypeConfByPartnerId(clearTransTypeConfDO.getPartnerId());
	}
}
