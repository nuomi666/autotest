//package com.xjy.autotest.marketpc;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.google.common.collect.Sets;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_marketpcTestBase;
//import com.xjy.autotest.testbase.PromotionTestBase;
//import com.xjy.autotest.utils.DateUtils;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.id.OID;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.adk.common.util.money.Money;
//import com.xyb.gas.marketpc.api.common.TimeSlot;
//import com.xyb.gas.marketpc.api.manage.CouponManageService;
//import com.xyb.gas.marketpc.api.manage.order.AddCouponDefinitionOrder;
//import com.xyb.promotion.api.coupon.enums.CouponType;
//import dal.model.promotion.CouponDefinitionDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Set;
//
//
///**
// * @author nuomi@xyb.com
// * Created on 2018/10/15.
// */
//public class CouponManageServiceAddTest extends SpringBootTestBase{
//
//	@Reference(version = DUBBO_VERSION_1)
//    CouponManageService couponManageService;
//
//	@Autowired
//	Gas_marketpcTestBase gasMarketpcTestBase;
//
//	@Autowired
//	PromotionTestBase promotionTestBase;
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "marketpc/couponManageServiceAddTestSuccess.csv")
//	@DisplayName("优惠券新增--成功用例")
//	public void couponManageServiceAddTestSuccess(
//			// 基本参数
//			int testId,
//            Status status,
//            String code,
//			// 业务参数
//			AddCouponDefinitionOrder order,
//			TimeSlot timeSlot
//	) {
//		// 清除数据
//		gasMarketpcTestBase.cleanCouponByCouponName(order.getName());
//		promotionTestBase.cleanCouponDefinitionByName(order.getName());
//		// 准备数据
//		Date timeSlotStartTime=DateUtils.parseDate("2018-10-26");
//		Date timeSlotEndTime=DateUtils.parseDate("2019-10-26");
//		Object discountData=new Double(0.88);
//		Object instantData1=new Money(5,00);
//		CouponType.OverCouponAmountData items=new CouponType.OverCouponAmountData();
//		items.add(new Money(100,00),new Money(200,00),new Money(5,00));
//		// 测试过程
//		Set<String> goodsCodes = Sets.newHashSet();
//		goodsCodes.add("#98");
//		Set<String> stationIds = Sets.newHashSet();
//		stationIds.add("001if9yazl84g025eh00");
//        List<Integer> days = new ArrayList<Integer>();
//        days.add(1);
//        List<TimeSlot> timeSlots = new ArrayList<TimeSlot>();
//		timeSlot.setStartTime("12:00");
//		timeSlot.setEndTime("14:00");
//        timeSlots.add(timeSlot);
//        if(testId==1001||testId==1004){
//			order.setAmountData(discountData);
//			order.setGoodsCodes(goodsCodes);
//		}
//		if(testId==1003){
//			order.setAmountData(instantData1);
//		}
//		if(testId==1002){
//			order.setAmountData(items);
//		}
//		Date validStartTime=DateUtils.changeSecond(new Date(),10);
//		order.setValidStartTime(validStartTime);
//		order.setStationIds(stationIds);
//		order.setDays(days);
//		order.setTimeSlots(timeSlots);
//		order.setInnerName(OID.newID());
//		order.setGid(GID.newGID());
////		order.setMerchantOrderNo(OID.newID());
//		// 调用接口
//		SimpleResult result = couponManageService.add(order);
//		// 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		List<CouponDefinitionDO> couponDefinitionDOS=promotionTestBase.findCouponDefinitionByInnerName(order.getInnerName());
//		assertEquals(1,couponDefinitionDOS.size());
//		// 清除数据
////		gasMarketpcTestBase.cleanCouponByCouponName(order.getName());
////		promotionTestBase.cleanCouponDefinitionByName(order.getName());
//	}
//}
