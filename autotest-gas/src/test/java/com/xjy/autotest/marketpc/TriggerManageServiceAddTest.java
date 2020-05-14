//package com.xjy.autotest.marketpc;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_marketpcTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.marketpc.api.manage.TriggerManageService;
//import com.xyb.gas.marketpc.api.manage.order.AddTriggerConditionOrder;
//import dal.model.gas_marketpc.TriggerConditionDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//
///**
// * @author nuomi@xyb.com
// * Created on 2018/10/16.
// */
//public class TriggerManageServiceAddTest extends SpringBootTestBase{
//
//	@Reference(version = DUBBO_VERSION_1)
//    TriggerManageService triggerManageService;
//
//	@Autowired
//	Gas_marketpcTestBase gasMarketpcTestBase;
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "marketpc/triggerManageServiceAddTestSuccess.csv")
//	@DisplayName("创建触发条件--成功用例")
//	public void triggerManageServiceAddTestSuccess(
//			// 基本参数
//			int testId,
//            Status status,
//            String code,
//			// 业务参数
//			AddTriggerConditionOrder order,
//			String keyCode
//	) {
//		// 清除数据
//		gasMarketpcTestBase.cleanTriggerConditionByConditionName(order.getConditionName());
//		// 准备数据
//		// 测试过程
//        List<String> params = new ArrayList<String>();
//        params.add(keyCode);
//        if(testId==1001||testId==1004||testId==1006) {
//			order.setParams(params);
//		}
////		if(testId==1003){
////			params.add("isComplete");
////			order.setParams(params);
////		}
//		order.setGid(GID.newGID());
//		// 调用接口
//		SimpleResult result = triggerManageService.add(order);
//		// 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		List<TriggerConditionDO> conditions=gasMarketpcTestBase.findTriggerConditionByConditionName(order.getConditionName());
//		assertTrue(conditions.size()>0);
//		// 清除数据
//		//gasMarketpcTestBase.cleanTriggerConditionByConditionName(order.getConditionName());
//	}
//}
