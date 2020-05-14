//package com.xjy.autotest.marketpc;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_marketpcTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.marketpc.api.manage.ActionManageService;
//import com.xyb.gas.marketpc.api.manage.order.AddActionOrder;
//import dal.model.gas_marketpc.ActionDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//
///**
// * @author nuomi@xyb.com
// * Created on 2018/10/16.
// */
//public class ActionManageServiceAddTest extends SpringBootTestBase{
//
//	@Reference(version = DUBBO_VERSION_1)
//    ActionManageService actionManageService;
//
//	@Autowired
//	Gas_marketpcTestBase gasMarketpcTestBase;
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "marketpc/actionManageServiceAddTestSuccess.csv")
//	@DisplayName("新增执行动作--成功用例")
//	public void actionManageServiceAddTestSuccess(
//			// 基本参数
//			int testId,
//            Status status,
//            String code,
//			// 业务参数
//			AddActionOrder order
//	) {
//		// 清除数据
//		gasMarketpcTestBase.cleanActionByActionName(order.getActionName());
//		// 准备数据
//		// 测试过程
//		order.setGid(GID.newGID());
//		// 调用接口
//		SimpleResult result = actionManageService.add(order);
//		// 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		List<ActionDO> actions= gasMarketpcTestBase.findActionByActionName(order.getActionName());
//		assertTrue(actions.size()>0);
//		// 清除数据
////		gasMarketpcTestBase.cleanActionByActionName(order.getActionName());
//	}
//}
