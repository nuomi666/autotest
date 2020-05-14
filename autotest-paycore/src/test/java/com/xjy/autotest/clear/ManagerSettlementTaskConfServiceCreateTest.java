package com.xjy.autotest.clear;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.ClearTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.StandardResultInfo;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.clear.api.enmus.UseStatus;
import com.xyb.clear.api.order.settlement.SettlementTaskConfOrder;
import com.xyb.clear.api.result.settlement.ClearTransTypeInfo;
import com.xyb.clear.api.service.settlement.ManagerSettlementTaskConfService;
import dal.model.clear.ClearTransTypeConfDO;
import dal.model.clear.SettlementTaskConfDO;
import dal.model.user.UserDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author lvdou
 * 服务名：创建结算配置
 * Created on 2018/08/02.
 */
public class ManagerSettlementTaskConfServiceCreateTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION,group = "clear")
    ManagerSettlementTaskConfService managerSettlementTaskConfService;

	@Autowired
	ClearTestBase clearTestBase;

	@Autowired
	UserTestBase userTestBase;
	/**
	 * 1001 必填参数，创建结算配置成功
	 * 1002 全填参数，一个交易列表类型，创建结算配置成功
	 * 1003 全填参数，两个交易列表类型，创建结算配置成功
	 */
	@AutoTest(file = "clear/managerSettlementTaskConfServiceCreateTestSuccess.csv")
	@DisplayName("创建结算配置--成功用例")
	public void managerSettlementTaskConfServiceCreateTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			UserDO user,
			SettlementTaskConfOrder settlementTaskConfOrder,
			ClearTransTypeInfo clearTransTypeInfo,
			ClearTransTypeInfo clearTransTypeInfo1,
			// 结果参数
			String code,
			String description
	) {
		// 清除数据
		clearTestBase.cleanSettlementTaskConfByPartnerId(settlementTaskConfOrder.getPartnerId());
		//clearTestBase.cleanClearTransTypeConfAll();
		userTestBase.cleanUserByUserId(user.getUserId());
		// 准备数据
		userTestBase.insertUser(user);
		// 测试过程
		if(testId != 1001) {
			List<ClearTransTypeInfo> transTypeInfos = new ArrayList<ClearTransTypeInfo>();
			transTypeInfos.add(clearTransTypeInfo);
			if (testId == 1003) {
				transTypeInfos.add(clearTransTypeInfo1);
			}
			settlementTaskConfOrder.setTransTypeInfos(transTypeInfos);
		}
		// 调用接口
		StandardResultInfo result = managerSettlementTaskConfService.create(settlementTaskConfOrder);
		// 结果验证
		assertResult(testId, Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 数据验证
		SettlementTaskConfDO DO = clearTestBase.findSettlementTaskConfByPartnerId(settlementTaskConfOrder.getPartnerId()).get(0);

		assertEquals(settlementTaskConfOrder.getPartnerId(),DO.getPartnerId());
		assertEquals(settlementTaskConfOrder.getSettlementCycle(),DO.getSettlementCycle());
		assertEquals(settlementTaskConfOrder.getClearTime(),DO.getClearTime());
		assertEquals(settlementTaskConfOrder.getSettlementTime(),DO.getSettlementTime());
		assertNotNull(DO.getRawAddTime());
		assertNotNull(DO.getRawUpdateTime());
		if(testId == 1001){
			assertEquals(UseStatus.N.toString(),DO.getIsClear());
			assertEquals(UseStatus.N.toString(),DO.getIsSettlement());
			assertEquals(UseStatus.N.toString(),DO.getIsUse());
		}else{
			assertEquals(settlementTaskConfOrder.getIsClear().toString(),DO.getIsClear());
			assertEquals(settlementTaskConfOrder.getIsSettlement().toString(),DO.getIsSettlement());
			assertEquals(settlementTaskConfOrder.getIsUse().toString(),DO.getIsUse());
			assertEquals(settlementTaskConfOrder.getSettlementType().toString(),DO.getSettlementType());
			//assertEquals(settlementTaskConfOrder.getSettlementAccountNo(),DO.getSettlementAccountNo());
			//assertEquals(settlementTaskConfOrder.getSettlementCardNo(),DO.getSettlementCardNo());
			//assertEquals(settlementTaskConfOrder.getSettlementChannelId(),DO.getSettlementChannelId());
			//assertEquals(settlementTaskConfOrder.getSettlementName(),DO.getSettlementName());
			assertEquals(settlementTaskConfOrder.getMemo(),DO.getMemo());
		}
		if(testId == 1002 ){
			ClearTransTypeConfDO DO1 = clearTestBase.findClearTransTypeConfByPartnerId(settlementTaskConfOrder.getPartnerId()).get(0);

			assertNotNull(DO1.getRawAddTime());
			assertNotNull(DO1.getRawUpdateTime());
			assertNotNull(DO1.getId());
			assertEquals(settlementTaskConfOrder.getTransTypeInfos().get(0).getClearConfType().toString(),DO1.getClearConfType());
			assertEquals(settlementTaskConfOrder.getTransTypeInfos().get(0).getOrderType(),DO1.getOrderType());
			assertEquals(settlementTaskConfOrder.getTransTypeInfos().get(0).getPartnerId(),DO1.getPartnerId());
			assertEquals(settlementTaskConfOrder.getTransTypeInfos().get(0).getTransTag().toString().toString(),DO1.getTransTag());
			assertEquals(settlementTaskConfOrder.getTransTypeInfos().get(0).getTransType().toString(),DO1.getTransType());
		}
		if(testId == 1003){

			ClearTransTypeConfDO DO1 = clearTestBase.findClearTransTypeConfByPartnerId(settlementTaskConfOrder.getPartnerId()).get(1);

			assertNotNull(DO1.getRawAddTime());
			assertNotNull(DO1.getRawUpdateTime());
			assertNotNull(DO1.getId());
			assertEquals(settlementTaskConfOrder.getTransTypeInfos().get(0).getClearConfType().toString(),DO1.getClearConfType());
			assertEquals(settlementTaskConfOrder.getTransTypeInfos().get(0).getOrderType(),DO1.getOrderType());
			assertEquals(settlementTaskConfOrder.getPartnerId(),DO1.getPartnerId());
			assertEquals(settlementTaskConfOrder.getTransTypeInfos().get(0).getTransTag().toString().toString(),DO1.getTransTag());
			assertEquals(settlementTaskConfOrder.getTransTypeInfos().get(0).getTransType().toString(),DO1.getTransType());

			ClearTransTypeConfDO DO2 = clearTestBase.findClearTransTypeConfByPartnerId(settlementTaskConfOrder.getPartnerId()).get(0);

			assertNotNull(DO2.getRawAddTime());
			assertNotNull(DO2.getRawUpdateTime());
			assertNotNull(DO2.getId());
			assertEquals(settlementTaskConfOrder.getTransTypeInfos().get(1).getClearConfType().toString(),DO2.getClearConfType());
			assertEquals(settlementTaskConfOrder.getTransTypeInfos().get(1).getOrderType(),DO2.getOrderType());
			assertEquals(settlementTaskConfOrder.getPartnerId(),DO2.getPartnerId());
			assertEquals(settlementTaskConfOrder.getTransTypeInfos().get(1).getTransTag().toString().toString(),DO2.getTransTag());
			assertEquals(settlementTaskConfOrder.getTransTypeInfos().get(1).getTransType().toString(),DO2.getTransType());
		}
		// 清除数据
		clearTestBase.cleanSettlementTaskConfByPartnerId(settlementTaskConfOrder.getPartnerId());
		//clearTestBase.cleanClearTransTypeConfAll();
	}

	/**
	 * 1001 order为空，提示order不能为空
	 * 1002 gid为空，提示gid不能为空
	 * 1003 partnerId为空，提示partnerId不能为空
	 * 1004 settlementCycle为空，提示settlementCycle不能为空
	 * 1005 clearTime为空，提示clearTime不能为空
	 * 1006 settlementTime为空，提示settlementTime不能为空
	 * 1007 gid长度为34，提示gid长度只能为35
	 * 1008 gid长度为36，提示gid长度只能为35
	 * 1009 partnerId长度为19，提示partnerId长度只能为20
	 * 1010 partnerId长度为21，提示partnerId长度只能为20
	 * 1011 clearTime格式不正确，提示clearTime格式不正确
	 * 1012 settlementTime格式不正确，提示settlementTime格式不正确
	 */
	@AutoTest(file = "clear/managerSettlementTaskConfServiceCreateTestFailOne.csv")
	@DisplayName("创建结算配置--失败用例一")
	public void managerSettlementTaskConfServiceCreateTestFailOne(
			// 基本参数
			int testId,
			// 业务参数
			SettlementTaskConfOrder settlementTaskConfOrder,
			// 结果参数
			String code,
			String description
	){
		// 清除数据
		// 准备数据
		// 测试过程
		if(testId == 1001){
			settlementTaskConfOrder = null;
		}
		if(testId == 1002){
			settlementTaskConfOrder.setGid(null);
		}
		if(testId == 1003){
			settlementTaskConfOrder.setPartnerId(null);
		}
		if(testId == 1004){
			settlementTaskConfOrder.setSettlementCycle(null);
		}
		if(testId == 1005){
			settlementTaskConfOrder.setClearTime(null);
		}
		if(testId == 1006){
			settlementTaskConfOrder.setSettlementTime(null);
		}
		// 调用接口
		StandardResultInfo result = managerSettlementTaskConfService.create(settlementTaskConfOrder);
		// 结果验证
		assertResult(testId, Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		// 清除数据
	}

	/**
	 * 1001 商户结算配置已经存在，添加失败
	 * 1002 结算配置下清分交易类型配置存在，添加失败
	 */
	@AutoTest(file = "clear/managerSettlementTaskConfServiceCreateTestFaiTwo.csv")
	@DisplayName("创建结算配置--失败用例二")
	public void managerSettlementTaskConfServiceCreateTestFaiTwo(
			// 基本参数
			int testId,
			// 业务参数
			SettlementTaskConfOrder settlementTaskConfOrder,
			// 数据库参数
			SettlementTaskConfDO settlementTaskConfDO,
			ClearTransTypeConfDO clearTransTypeConfDO,
			// 结果参数
			String code,
			String description
	){
		// 清除数据
		clearTestBase.cleanSettlementTaskConfByPartnerId(settlementTaskConfOrder.getPartnerId());
		clearTestBase.cleanClearTransTypeConfByPartnerId(settlementTaskConfOrder.getPartnerId());
		// 准备数据
		clearTestBase.insertSettlementTaskConf(settlementTaskConfDO);
		if(testId == 1002){
			clearTestBase.insertClearTransTypeConf(clearTransTypeConfDO);
		}
		// 测试过程
		// 调用接口
		StandardResultInfo result = managerSettlementTaskConfService.create(settlementTaskConfOrder);
		// 结果验证
		assertResult(testId, Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		assertEquals(1,clearTestBase.findSettlementTaskConfByPartnerId(settlementTaskConfOrder.getPartnerId()).size());
		if(testId == 1002) {
			assertEquals(1, clearTestBase.findClearTransTypeConfByPartnerId(settlementTaskConfOrder.getPartnerId()).size());
		}else{
			assertEquals(0, clearTestBase.findClearTransTypeConfByPartnerId(settlementTaskConfOrder.getPartnerId()).size());
		}
		// 清除数据
		clearTestBase.cleanSettlementTaskConfByPartnerId(settlementTaskConfOrder.getPartnerId());
		clearTestBase.cleanClearTransTypeConfByPartnerId(settlementTaskConfOrder.getPartnerId());
	}
}
