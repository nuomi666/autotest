package com.xjy.autotest.clear;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.ClearTestBase;
import com.xyb.adk.common.lang.result.StandardResultInfo;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.clear.api.order.settlement.SettlementTaskConfUpdateOrder;
import com.xyb.clear.api.result.settlement.ClearTransTypeInfo;
import com.xyb.clear.api.service.settlement.ManagerSettlementTaskConfService;
import dal.model.clear.ClearTransTypeConfDO;
import dal.model.clear.SettlementTaskConfDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author lvdou
 * Created on 2018/08/03.
 * 服务名：更新结算配置
 */
public class ManagerSettlementTaskConfServiceUpdateTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION,group = "clear")
	ManagerSettlementTaskConfService managerSettlementTaskConfService;

	@Autowired
	ClearTestBase clearTestBase;

	/**
	 * 1001 必填参数，不修改结算配置
	 */
	@AutoTest(file = "clear/managerSettlementTaskConfServiceUpdateTestSuccess.csv")
	@DisplayName("更新结算配置--成功用例")
	public void managerSettlementTaskConfServiceUpdateTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			SettlementTaskConfUpdateOrder settlementTaskConfUpdateOrder,
			ClearTransTypeInfo clearTransTypeInfo,
			// 数据库参数
			SettlementTaskConfDO settlementTaskConfDO,
			ClearTransTypeConfDO clearTransTypeConfDO,
			// 干扰参数
			SettlementTaskConfDO settlementTaskConfDO1,
			// 结果参数
			String code,
			String description
	) {
		// 清除数据
		clearTestBase.cleanSettlementTaskConfByPartnerId(settlementTaskConfDO.getPartnerId());
		clearTestBase.cleanSettlementTaskConfByPartnerId(settlementTaskConfDO1.getPartnerId());
		clearTestBase.cleanClearTransTypeConfByPartnerId(clearTransTypeConfDO.getPartnerId());
		// 准备数据
		clearTestBase.insertSettlementTaskConf(settlementTaskConfDO);
		clearTestBase.insertSettlementTaskConf(settlementTaskConfDO1);
		clearTestBase.insertClearTransTypeConf(clearTransTypeConfDO);
		// 测试过程
        List<ClearTransTypeInfo> transTypeInfos = new ArrayList<ClearTransTypeInfo>();
        transTypeInfos.add(clearTransTypeInfo);
		settlementTaskConfUpdateOrder.setTransTypeInfos(transTypeInfos);
		// 调用接口
		StandardResultInfo result = managerSettlementTaskConfService.update(settlementTaskConfUpdateOrder);
		// 结果验证
		assertResult(testId, Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 数据验证
		SettlementTaskConfDO DO = clearTestBase.findSettlementTaskConfByPartnerId(settlementTaskConfDO.getPartnerId()).get(0);

		ClearTransTypeConfDO DO1 = clearTestBase.findClearTransTypeConfByPartnerId(clearTransTypeConfDO.getPartnerId()).get(0);
		if(testId == 1002) {
			assertEquals(settlementTaskConfUpdateOrder.getClearTime(),DO.getClearTime());
			assertEquals(settlementTaskConfUpdateOrder.getId(),DO.getId());
			assertEquals(settlementTaskConfUpdateOrder.getIsClear(),DO.getIsClear());
			assertEquals(settlementTaskConfUpdateOrder.getIsSettlement(),DO.getIsSettlement());
			assertEquals(settlementTaskConfUpdateOrder.getIsUse(),DO.getIsUse());
			assertEquals(settlementTaskConfUpdateOrder.getMemo(),DO.getMemo());
			assertEquals(settlementTaskConfUpdateOrder.getPartnerId(),DO.getPartnerId());
			//assertEquals(settlementTaskConfUpdateOrder.getSettlementAccountNo(),DO.getSettlementAccountNo());
			//assertEquals(settlementTaskConfUpdateOrder.getSettlementCardNo(),DO.getSettlementCardNo());
			//assertEquals(settlementTaskConfUpdateOrder.getSettlementChannelId(),DO.getSettlementChannelId());
			assertEquals(settlementTaskConfUpdateOrder.getSettlementCycle(),DO.getSettlementCycle());
			//assertEquals(settlementTaskConfUpdateOrder.getSettlementName(),DO.getSettlementName());
			assertEquals(settlementTaskConfUpdateOrder.getSettlementTime(),DO.getSettlementTime());
			assertEquals(settlementTaskConfUpdateOrder.getSettlementType(),DO.getSettlementType());


		}
	}
}
