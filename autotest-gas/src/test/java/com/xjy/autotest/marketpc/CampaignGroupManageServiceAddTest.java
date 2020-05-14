//package com.xjy.autotest.marketpc;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_marketpcTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.marketpc.api.manage.CampaignGroupManageService;
//import com.xyb.gas.marketpc.api.manage.order.AddSalesCampaignGroupOrder;
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
// * Created on 2018/10/17.
// */
//public class CampaignGroupManageServiceAddTest extends SpringBootTestBase{
//
//	@Reference(version = DUBBO_VERSION_1)
//    CampaignGroupManageService campaignGroupManageService;
//
//	@Autowired
//	Gas_marketpcTestBase gasMarketpcTestBase;
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "marketpc/campaignGroupManageServiceAddTestSuccess.csv")
//	@DisplayName("新增活动组--成功用例")
//	public void campaignGroupManageServiceAddTestSuccess(
//			// 基本参数
//			int testId,
//            Status status,
//            String code,
//			// 业务参数
//			AddSalesCampaignGroupOrder order,
//			String campaignNo
//	) {
//		// 清除数据
//		gasMarketpcTestBase.cleanSalesCampaignGroupByPartnerId(order.getPartnerId());
//		// 准备数据
//		// 测试过程
//        List<String> campaignNos = new ArrayList<String>();
//        if(testId==1001){
//			campaignNos.add("001isl8nd7ywg045ek00");
//			campaignNos.add("001isl8nbu4gg045ek00");
//		}
//		if(testId==1002){
//			campaignNos.add("001ipq7b36x0g045ek00");
//		}
//		if(testId==1003){
//			campaignNos.add("001ipq7b443gg045ek00");
//		}
//		if(testId==1004){
//			campaignNos.add("001ipq7b4c74g045ek00");
//		}
//		order.setCampaignNos(campaignNos);
//		order.setGid(GID.newGID());
//		// 调用接口
//		SimpleResult result = campaignGroupManageService.add(order);
//		// 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		// 清除数据
//	}
//}
