//package com.xjy.autotest.marketpc;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.google.common.collect.Maps;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_marketpcTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xjy.autotest.testbase.UserTestBase;
//import com.xjy.autotest.utils.DateUtils;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.id.OID;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.adk.common.util.money.Money;
//import com.xyb.gas.marketpc.api.trans.DiscountCalculateService;
//import com.xyb.gas.marketpc.api.trans.order.CalculateDiscountOrder;
//import com.xyb.gas.marketpc.api.trans.order.GasInfo;
//import com.xyb.gas.marketpc.api.trans.order.GoodsInfo;
//import com.xyb.gas.marketpc.api.trans.result.CalculateDiscountResult;
//import dal.model.gas_user.UserCardInfoDO;
//import dal.model.gas_user.UserDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//
//
///**
// * @author nuomi@xyb.com
// * Created on 2018/10/15.
// */
//public class DiscountCalculateServiceCalculateTest extends SpringBootTestBase{
//
//	@Reference(version = DUBBO_VERSION_1)
//    DiscountCalculateService discountCalculateService;
//
//	@Autowired
//	UserTestBase userTestBase;
//
//	@Autowired
//	Gas_userTestBase gasUserTestBase;
//
//	@Autowired
//	Gas_marketpcTestBase gasMarketpcTestBase;
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "marketpc/discountCalculateServiceCalculateTestSuccess.csv")
//	@DisplayName("计算优惠--成功用例")
//	public void discountCalculateServiceCalculateTestSuccess(
//			// 基本参数
//			int testId,
//            Status status,
//            String code,
//			// 业务参数
//			CalculateDiscountOrder order,
//			GasInfo gasInfo,
//			GoodsInfo goodsInfo,
//			String couponId
//	) {
//		// 清除数据
//		gasMarketpcTestBase.cleanUserActionEventByPartnerId(order.getPartnerId());
//		gasMarketpcTestBase.cleanGiveCouponDetailByPartnerId(order.getPartnerId());
//		gasMarketpcTestBase.cleanGiveMoneyDetailByPartnerId(order.getPartnerId());
//		gasMarketpcTestBase.cleanGiveGoodsDetailByPartnerId(order.getPartnerId());
//		gasMarketpcTestBase.cleanGivePointsDetailByPartnerId(order.getPartnerId());
//		// 准备数据
//		// 测试过程
//		dal.model.user.UserDO userInfo=userTestBase.findUserByUserId(order.getUserId()).get(0);
//		UserDO gasUserInfo=gasUserTestBase.findUserByUserId(order.getUserId()).get(0);
//		UserCardInfoDO gasCardInfo=gasUserTestBase.findUserCardInfoByUserId(order.getUserId()).get(0);
////		UserCarInfoDO carInfo=gasUserTestBase.findUserCarInfoByUserId(order.getUserId()).get(0);
//		Map<String, String> favourParams =Maps.newHashMap();
//		favourParams.put("userId", gasUserInfo.getUserId());
//		favourParams.put("mobile", gasUserInfo.getMobile());
//		favourParams.put("realName", userInfo.getRealName());
//		favourParams.put("cardNo",gasCardInfo.getCardNo());
//		favourParams.put("nickName", gasUserInfo.getNickName());
//		favourParams.put("carNumber", null);
//		favourParams.put("accountTag", gasCardInfo.getAccountTag());
//		favourParams.put("transAmount", String.valueOf(new Money(120,00)));
//		favourParams.put("cardType", gasCardInfo.getCardType());
//		favourParams.put("cardBizType",  gasCardInfo.getTag());
//        List<GoodsInfo> goods = new ArrayList<GoodsInfo>();
//        goods.add(goodsInfo);
//        List<String> couponIds = new ArrayList<String>();
//        couponIds.add("001isozbwitos107pr00");
//        //油品信息
//		order.setGasInfo(gasInfo);
//		//商品列表信息
//		//order.setGoods(goods);
//		//优惠券
//		if(testId==1001) {//使用优惠券
//			order.setCouponIds(couponIds);
//		}
//		order.setContext(favourParams);
//		order.setEventId(OID.newID());
//		order.setGid(GID.newGID());
//		order.setTransTime(DateUtils.getSqlDate());
//		// 调用接口
//		CalculateDiscountResult result = discountCalculateService.calculate(order);
//		// 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		// 清除数据
//	}
//}
