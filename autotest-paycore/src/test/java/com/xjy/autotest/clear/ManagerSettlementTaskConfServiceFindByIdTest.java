package com.xjy.autotest.clear;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.ClearTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.clear.api.order.BaseIdOrder;
import com.xyb.clear.api.result.settlement.SettlementTaskConfInfo;
import com.xyb.clear.api.service.settlement.ManagerSettlementTaskConfService;
import dal.model.clear.ClearTransTypeConfDO;
import dal.model.clear.SettlementTaskConfDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * Created on 2018/08/03.
 * 服务名：查询结算配置详情
 */
public class ManagerSettlementTaskConfServiceFindByIdTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION,group = "clear")
	ManagerSettlementTaskConfService managerSettlementTaskConfService;

	@Autowired
	ClearTestBase clearTestBase;
	/**
	 * 1001
	 */
	@AutoTest(file = "clear/managerSettlementTaskConfServiceFindByIdTestSuccess.csv")
	@DisplayName("--成功用例")
	public void managerSettlementTaskConfServiceFindByIdTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			BaseIdOrder baseIdOrder,
			// 数据库参数
			SettlementTaskConfDO settlementTaskConfDO,
			ClearTransTypeConfDO clearTransTypeConfDO,
			ClearTransTypeConfDO clearTransTypeConfDO1,
			// 干扰参数
			SettlementTaskConfDO settlementTaskConfDO1,
			ClearTransTypeConfDO clearTransTypeConfDO2,
			// 结果参数
			String code,
			String description
	) {
		// 清除数据
		clearTestBase.cleanSettlementTaskConfByPartnerId(settlementTaskConfDO.getPartnerId());
		clearTestBase.cleanSettlementTaskConfByPartnerId(settlementTaskConfDO1.getPartnerId());
		clearTestBase.cleanClearTransTypeConfByPartnerId(clearTransTypeConfDO.getPartnerId());
		clearTestBase.cleanClearTransTypeConfByPartnerId(clearTransTypeConfDO1.getPartnerId());
		clearTestBase.cleanClearTransTypeConfByPartnerId(clearTransTypeConfDO2.getPartnerId());
		// 准备数据
		clearTestBase.insertSettlementTaskConf(settlementTaskConfDO);
		clearTestBase.insertSettlementTaskConf(settlementTaskConfDO1);
		clearTestBase.insertClearTransTypeConf(clearTransTypeConfDO);
		if(testId != 1001) {
			clearTestBase.insertClearTransTypeConf(clearTransTypeConfDO1);
		}
		clearTestBase.insertClearTransTypeConf(clearTransTypeConfDO2);
		// 测试过程
		// 调用接口
		SettlementTaskConfInfo result = managerSettlementTaskConfService.findById(baseIdOrder);
		// 结果验证
		assertResult(testId, Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 数据验证
		assertEquals(settlementTaskConfDO.getClearTime(),result.getClearTime());
		assertEquals(settlementTaskConfDO.getId(),result.getId());
		assertEquals(settlementTaskConfDO.getIsClear(),result.getIsClear());
		assertEquals(settlementTaskConfDO.getIsSettlement(),result.getIsSettlement());
		assertEquals(settlementTaskConfDO.getIsUse(),result.getIsUse());
		assertEquals(settlementTaskConfDO.getMemo(),result.getMemo());
		assertEquals(settlementTaskConfDO.getPartnerId(),result.getPartnerId());
		assertNotNull(result.getRawAddTime());
		assertNotNull(result.getRawUpdateTime());
		//assertEquals(settlementTaskConfDO.getSettlementAccountNo(),result.getSettlementAccountNo());
		//assertEquals(settlementTaskConfDO.getSettlementCardNo(),result.getSettlementCardNo());
		//assertEquals(settlementTaskConfDO.getSettlementChannelId(),result.getSettlementChannelId());
		assertEquals(settlementTaskConfDO.getSettlementCycle(),result.getSettlementCycle());
		//assertEquals(settlementTaskConfDO.getSettlementName(),result.getSettlementName());
		assertEquals(settlementTaskConfDO.getSettlementTime(),result.getSettlementTime());
		assertEquals(settlementTaskConfDO.getSettlementType(),result.getSettlementType());
	}
}
