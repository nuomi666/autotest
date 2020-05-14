//package com.xjy.autotest.marketpc;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.google.common.collect.Lists;
//import com.google.common.collect.Sets;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_marketpcTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.marketpc.api.common.CampaignRule;
//import com.xyb.gas.marketpc.api.common.TimeSlot;
//import com.xyb.gas.marketpc.api.common.TriggerRule;
//import com.xyb.gas.marketpc.api.common.enums.Comparator;
//import com.xyb.gas.marketpc.api.common.enums.GoodsAmountType;
//import com.xyb.gas.marketpc.api.common.enums.PromotionWay;
//import com.xyb.gas.marketpc.api.manage.CampaignManageService;
//import com.xyb.gas.marketpc.api.manage.order.CreateCampaignOrder;
//import com.xyb.gas.trade.api.enums.TradePayType;
//import com.xyb.gas.user.api.enums.UserGrade;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//import java.util.Set;
//
//
//
///**
// * @author nuomi@xyb.com
// * Created on 2018/10/16.
// */
//public class CampaignManageServiceCreateTest extends SpringBootTestBase{
//
//	@Reference(version = DUBBO_VERSION_1)
//    CampaignManageService campaignManageService;
//
//	@Autowired
//	Gas_marketpcTestBase gasMarketpcTestBase;
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "marketpc/campaignManageServiceCreateTestSuccess.csv")
//	@DisplayName("新增活动配置--成功用例")
//	public void campaignManageServiceCreateTestSuccess(
//			// 基本参数
//			int testId,
//            Status status,
//            String code,
//			// 业务参数
//			CreateCampaignOrder order,
//			Integer integer,
//			TriggerRule triggerRule,
//			CampaignRule campaignRule
//	) {
//		// 清除数据
//		gasMarketpcTestBase.cleanSalesCampaignByName(order.getName());
//		// 准备数据
//		// 测试过程
//		/**
//		 * 优惠/赠送参数值
//		 *
//		 * 优惠--满减--根据优惠金额类型区分（可能存在多条） 数组第一个参数表示优惠金额类型，第二个参数表示商品编码（如果不是商品分类，则不填），第三个参数表示条件金额， 第四个参数减少金额
//		 * 优惠--折扣--根据优惠金额类型区分（可能存在多条） 数组第一个参数表示优惠金额类型，第二个参数表示商品编码（如果不是商品分类，则不填），第三个参数表示折扣率
//		 * 优惠--立减--根据优惠金额类型区分（可能存在多条） 数组第一个参数只能填入TRANS_AMOUNT，第二个参数不填，第三个参数表示立减金额
//		 * 优惠--直降--对应具体商品（可能存在多条） 数组第一个参数只能填入GOODS_TYPE，第二个参数表示商品编码，第三个参数表示直降金额
//		 *
//		 * 赠送--积分--只有一条 若为赠送固定值，则数组第一个参数为空，第二个参数表示赠送积分数；否则数组第一个参数为积分方案类型，第二个参数表示积分方案编号
//		 * 赠送--优惠券--可能存在多条 数组第一个参数为优惠券id，第二个参数表示赠送优惠券张数
//		 *      * 赠送--储值金--只有一条 数组第一个参数赠送储值金金额
//		 */
//		String[] manjian=new String[4];
//		String[] zhekou=new String[3];
//		String[] lijian=new String[3];
//		String[] zhijiang=new String[3];
//		String[] jifen=new String[2];
//		String[] jifenxx=new String[2];
//		String[] jifen1=new String[2];
//		String[] jifen2=new String[2];
//		String[] quan=new String[2];
//		String[] quanxx=new String[2];
//		String[] quan1=new String[2];
//		String[] jine=new String[1];
//		List<String[]> manjianParams = Lists.newArrayList();
//		manjian[0] = GoodsAmountType.GAS_AMOUNT.code();
//		manjian[1] = "#95";//商品编码
//		manjian[2] = "100";//条件金额
//		manjian[3] = "5";//优惠金额
//		manjianParams.add(manjian);
//		List<String[]> zhekouParams = Lists.newArrayList();
//		zhekou[0] = GoodsAmountType.GAS_AMOUNT.code();
//		zhekou[1] = "#95";//商品编码
//		zhekou[2] = "0.88";//折扣率
//		zhekouParams.add(zhekou);
//		List<String[]> lijianParams = Lists.newArrayList();
//		lijian[0] = GoodsAmountType.TRANS_AMOUNT.code();
//		lijian[1] = "#95";//商品编码
//		lijian[2] = "10";//金额
//		lijianParams.add(lijian);
//		List<String[]> zhijiangParams = Lists.newArrayList();
//		zhijiang[0] = GoodsAmountType.GOODS_TYPE.code();
//		zhijiang[1] = "#95";//商品编码
//		zhijiang[2] = "1";//金额
//		zhijiangParams.add(zhijiang);
//		List<String[]> jifenParams = Lists.newArrayList();
//		jifen[0] = "";
//		jifen[1] = "10";//积分
//		jifenParams.add(jifen);
//		List<String[]> jifenParamsxx = Lists.newArrayList();
//		jifenxx[0] = "";
//		jifenxx[1] = "33";//实付赠送积分
//		jifenParamsxx.add(jifenxx);
//		List<String[]> updateJifenParams = Lists.newArrayList();
//		jifen2[0] = "";
//		jifen2[1] = "500";//积分
//		updateJifenParams.add(jifen2);
//		//第二个商户
//		List<String[]> jifenParams1 = Lists.newArrayList();
//		jifen1[0] = "";
//		jifen1[1] = "20";//积分
//		jifenParams1.add(jifen1);
//		List<String[]> youhuiquanParams = Lists.newArrayList();
//		quan[0] = "001iskvq1gb8s107pr00";//优惠券ID
//		quan[1] = "1";//数量
//		youhuiquanParams.add(quan);
//		List<String[]> youhuiquanParamsxx = Lists.newArrayList();
//		quanxx[0] = "001iskvq42zks107pr00";//优惠券ID
//		quanxx[1] = "1";//数量
//		youhuiquanParamsxx.add(quanxx);
//		//第二个商户
//		List<String[]> youhuiquanParams1 = Lists.newArrayList();
//		quan1[0] = "001imj6lf24cs107pr00";//优惠券ID
//		quan1[1] = "1";//数量
//		youhuiquanParams1.add(quan1);
//		List<String[]> zengjineParams = Lists.newArrayList();
//		jine[0] = "10";//赠送金额
//		zengjineParams.add(jine);
//        //活动规则
//		//触发规则
//		//会员等级
//		TriggerRule grade=new TriggerRule();
//		grade.setComparator(Comparator.EQUAL);
//		grade.setLeftValue("user_grade");
//		grade.setRightValue(UserGrade.GRADE_GOLD.code());
//		//金额（送积分）
//		TriggerRule amount=new TriggerRule();
//		amount.setComparator(Comparator.GREATER_EQUAL);
//		amount.setLeftValue("transAmount");
//		amount.setRightValue("100");
//		//金额（送券）
//		TriggerRule amount1=new TriggerRule();
//		amount1.setComparator(Comparator.GREATER_EQUAL);
//		amount1.setLeftValue("transAmount");
//		amount1.setRightValue("102");
//		//金额（送金额）
//		TriggerRule amount2=new TriggerRule();
//		amount2.setComparator(Comparator.GREATER_EQUAL);
//		amount2.setLeftValue("transAmount");
//		amount2.setRightValue("110");
//		//实付金额（送积分）
//		TriggerRule payAmount=new TriggerRule();
//		payAmount.setComparator(Comparator.GREATER_EQUAL);
//		payAmount.setLeftValue("payAmount");
//		payAmount.setRightValue("90");
//		//实付金额（送券）
//		TriggerRule payAmount1=new TriggerRule();
//		payAmount1.setComparator(Comparator.GREATER_EQUAL);
//		payAmount1.setLeftValue("payAmount");
//		payAmount1.setRightValue("80");
//		//渠道
//		TriggerRule payWay=new TriggerRule();
//		payWay.setComparator(Comparator.EQUAL);
//		payWay.setLeftValue("payWay");
//		payWay.setRightValue(TradePayType.WECHAT.code());
//		//赠券触发规则
//		List<TriggerRule> couponTriggerRules=Lists.newArrayList();
//		couponTriggerRules.add(grade);
//		couponTriggerRules.add(amount1);
//		//赠金额触发规则
//		List<TriggerRule> amountTriggerRules=Lists.newArrayList();
//		amountTriggerRules.add(grade);
//		amountTriggerRules.add(amount2);
//		//赠积分触发规则
//		List<TriggerRule> pointsTriggerRules=Lists.newArrayList();
//		pointsTriggerRules.add(grade);
//		pointsTriggerRules.add(amount);
//		//实付金额赠积分
//		List<TriggerRule> pointsRules=Lists.newArrayList();
//		pointsRules.add(payAmount);
//		//实付金额赠券
//		List<TriggerRule> couponRules=Lists.newArrayList();
//		couponRules.add(payAmount1);
//		//打折触发规则
//		List<TriggerRule> discountTriggerRules=Lists.newArrayList();
//		discountTriggerRules.add(amount);
//		discountTriggerRules.add(payWay);
//		//满减触发规则
//		List<TriggerRule> decreaseTriggerRules=Lists.newArrayList();
//		decreaseTriggerRules.add(amount);
//		//decreaseTriggerRules.add(payWay);
//		//直降触发规则
//		List<TriggerRule> downTriggerRules=Lists.newArrayList();
//		downTriggerRules.add(amount);
//		//downTriggerRules.add(payWay);
//		//注册送券
//		CampaignRule registerCouponRule=new CampaignRule();
//		registerCouponRule.setPromotionWay(PromotionWay.giveCoupon);
//		//registerCouponRule.setTriggerRules(couponTriggerRules);
//		registerCouponRule.setActionName("赠券");
//		registerCouponRule.setTriggerName("注册送券");
//		registerCouponRule.setEventRoute("userRegister");
//		registerCouponRule.setDiscountParams(youhuiquanParams);
//		//完善资料送券
//		CampaignRule updateCouponRule=new CampaignRule();
//		updateCouponRule.setPromotionWay(PromotionWay.giveCoupon);
//		//updateCouponRule.setTriggerRules(couponTriggerRules);
//		updateCouponRule.setActionName("赠券");
//		updateCouponRule.setTriggerName("完善资料送券");
//		updateCouponRule.setEventRoute("userUpdate");
//		updateCouponRule.setDiscountParams(youhuiquanParams);
//		//生日送券
//		CampaignRule birthCouponRule=new CampaignRule();
//		birthCouponRule.setPromotionWay(PromotionWay.giveCoupon);
//		//birthCouponRule.setTriggerRules(couponTriggerRules);
//		birthCouponRule.setActionName("赠券");
//		birthCouponRule.setTriggerName("生日送券");
//		birthCouponRule.setEventRoute("USER_BIRTHDAY");
//		if(testId==1004) {
//			birthCouponRule.setDiscountParams(youhuiquanParams1);
//		}else {
//			birthCouponRule.setDiscountParams(youhuiquanParams);
//		}
//		//消费送券
//		CampaignRule payCouponRule=new CampaignRule();
//		payCouponRule.setPromotionWay(PromotionWay.giveCoupon);
//		payCouponRule.setTriggerRules(couponTriggerRules);
//		payCouponRule.setActionName("赠券");
//		payCouponRule.setTriggerName("消费送券");
//		payCouponRule.setEventRoute("PAYMENT");
//		payCouponRule.setDiscountParams(youhuiquanParams);
//		//实付送券
//		CampaignRule payCouponRulexx=new CampaignRule();
//		payCouponRulexx.setPromotionWay(PromotionWay.giveCoupon);
//		payCouponRulexx.setTriggerRules(couponRules);
//		payCouponRulexx.setActionName("赠券");
//		payCouponRulexx.setTriggerName("实付送券");
//		payCouponRulexx.setEventRoute("PAYMENT");
//		payCouponRulexx.setDiscountParams(youhuiquanParamsxx);
//		//实付送积分
//		CampaignRule paypointsRule=new CampaignRule();
//		paypointsRule.setPromotionWay(PromotionWay.givePoints);
//		paypointsRule.setTriggerRules(pointsRules);
//		paypointsRule.setActionName("赠积分");
//		paypointsRule.setTriggerName("实付送积分");
//		paypointsRule.setEventRoute("PAYMENT");
//		paypointsRule.setDiscountParams(jifenParamsxx);
//		//充值赠券
//		CampaignRule depositCouponRule=new CampaignRule();
//		depositCouponRule.setPromotionWay(PromotionWay.giveCoupon);
//		depositCouponRule.setTriggerRules(couponTriggerRules);
//		depositCouponRule.setActionName("赠券");
//		depositCouponRule.setTriggerName("充值送券");
//		depositCouponRule.setEventRoute("DEPOSIT");
//		depositCouponRule.setDiscountParams(youhuiquanParams);
//		//赠金额
//		CampaignRule amountRule=new CampaignRule();
//		amountRule.setPromotionWay(PromotionWay.giveMoney);
//		amountRule.setTriggerRules(amountTriggerRules);
//		amountRule.setActionName("赠金额");
//		amountRule.setTriggerName("充值赠金额");
//		amountRule.setEventRoute("DEPOSIT");
//		amountRule.setDiscountParams(zengjineParams);
//		//注册送积分
//		CampaignRule registerPointsRule=new CampaignRule();
//		registerPointsRule.setPromotionWay(PromotionWay.givePoints);
//		//registerCouponRule.setTriggerRules(pointsTriggerRules);
//		registerPointsRule.setActionName("赠积分");
//		registerPointsRule.setTriggerName("注册送积分");
//		registerPointsRule.setEventRoute("userRegister");
//		if(testId==1005||testId==1006){
//			registerPointsRule.setDiscountParams(updateJifenParams);
//		}else{
//			registerPointsRule.setDiscountParams(jifenParams);
//		}
//		//完善资料送积分
//		CampaignRule updatePointsRule=new CampaignRule();
//		updatePointsRule.setPromotionWay(PromotionWay.givePoints);
//		//registerCouponRule.setTriggerRules(pointsTriggerRules);
//		updatePointsRule.setActionName("赠积分");
//		updatePointsRule.setTriggerName("完善资料送积分");
//		updatePointsRule.setEventRoute("userUpdate");
//		updatePointsRule.setDiscountParams(jifenParams);
//		//生日送积分
//		CampaignRule bitrthPointsRule=new CampaignRule();
//		bitrthPointsRule.setPromotionWay(PromotionWay.givePoints);
//		//registerCouponRule.setTriggerRules(pointsTriggerRules);
//		bitrthPointsRule.setActionName("赠积分");
//		bitrthPointsRule.setTriggerName("生日积分");
//		bitrthPointsRule.setEventRoute("USER_BIRTHDAY");
//		if(testId==1004) {
//			bitrthPointsRule.setDiscountParams(jifenParams1);
//		}else {
//			bitrthPointsRule.setDiscountParams(jifenParams);
//		}
//		//消费赠积分
//		CampaignRule payPointsRule=new CampaignRule();
//		payPointsRule.setPromotionWay(PromotionWay.givePoints);
//		payPointsRule.setTriggerRules(pointsTriggerRules);
//		payPointsRule.setActionName("赠积分");
//		payPointsRule.setTriggerName("消费赠积分");
//		payPointsRule.setEventRoute("PAYMENT");
//		payPointsRule.setDiscountParams(jifenParams);
//		//充值赠积分
//		CampaignRule depositPointsRule=new CampaignRule();
//		depositPointsRule.setPromotionWay(PromotionWay.givePoints);
//		depositPointsRule.setTriggerRules(pointsTriggerRules);
//		depositPointsRule.setActionName("赠积分");
//		depositPointsRule.setTriggerName("充值赠积分");
//		depositPointsRule.setEventRoute("DEPOSIT");
//		depositPointsRule.setDiscountParams(jifenParams);
//		//打折
//		CampaignRule discountRule=new CampaignRule();
//		discountRule.setPromotionWay(PromotionWay.rebate);
//		discountRule.setTriggerRules(discountTriggerRules);
//		discountRule.setActionName("折扣");
//		discountRule.setTriggerName("油品8.8折");
//		discountRule.setEventRoute("PAYMENT");
//		discountRule.setDiscountParams(zhekouParams);
//		//满减
//		CampaignRule decreaseRule=new CampaignRule();
//		decreaseRule.setPromotionWay(PromotionWay.fullReduce);
//		decreaseRule.setTriggerRules(decreaseTriggerRules);
//		decreaseRule.setActionName("满减");
//		decreaseRule.setTriggerName("满100减5元");
//		decreaseRule.setEventRoute("PAYMENT");
//		decreaseRule.setDiscountParams(manjianParams);
//		//直降
//		CampaignRule downRule=new CampaignRule();
//		downRule.setPromotionWay(PromotionWay.priceReduce);
//		downRule.setTriggerRules(downTriggerRules);
//		downRule.setActionName("直降");
//		downRule.setTriggerName("一升油降1元");
//		downRule.setEventRoute("PAYMENT");
//		downRule.setDiscountParams(zhijiangParams);
//		//充值优惠
//		List<CampaignRule> depositRules = Lists.newArrayList();
//		depositRules.add(amountRule);
//		depositRules.add(depositCouponRule);
//		depositRules.add(depositPointsRule);
//		//消费优惠
//		List<CampaignRule> paymentRules = Lists.newArrayList();
//		paymentRules.add(payCouponRule);
//		paymentRules.add(payPointsRule);
//		paymentRules.add(decreaseRule);
//		paymentRules.add(discountRule);
//		paymentRules.add(downRule);
//		//实付赠送
//		List<CampaignRule> realRules = Lists.newArrayList();
//		realRules.add(decreaseRule);
//		realRules.add(payCouponRulexx);
//		realRules.add(paypointsRule);
//		//日常注册、完善资料、生日赠送
//		List<CampaignRule> alwaysRules = Lists.newArrayList();
//		alwaysRules.add(registerCouponRule);
//		alwaysRules.add(registerPointsRule);
//		alwaysRules.add(updateCouponRule);
//		alwaysRules.add(updatePointsRule);
//		alwaysRules.add(birthCouponRule);
//		alwaysRules.add(bitrthPointsRule);
//		//测试送积分更新会员等级
//		List<CampaignRule> updateGradeRules = Lists.newArrayList();
//		updateGradeRules.add(registerPointsRule);
//		//执行时间
//		List<Integer> days = Lists.newArrayList();
//		days.add(1);
//		days.add(4);
//		//触发事件路由
//		Set<String> eventRoutes = Sets.newHashSet();
//		if(testId==1002||testId==1007) {
//			eventRoutes.add("PAYMENT");
//		}
//		if(testId==1001||testId==1004) {
//			eventRoutes.add("userRegister");
//			eventRoutes.add("userUpdate");
//			eventRoutes.add("USER_BIRTHDAY");
//		}
//		if(testId==1003) {
//			eventRoutes.add("DEPOSIT");
//		}
//		if(testId==1005||testId==1006) {
//			eventRoutes.add("userRegister");
//		}
//		//禁用油站ID
//		Set<String> stationIds = Sets.newHashSet();
//		stationIds.add("001if9yazl84g025uu00");
//		TimeSlot timeSlot=new TimeSlot();
//		timeSlot.setStartTime("00:00");
//		timeSlot.setEndTime("23:59");
//        if(testId==1004) {
//			order.setCampaignRules(alwaysRules);
//		}
//		if(testId==1003) {//充值活动
////			order.setTimeSlot(timeSlot);
////			order.setDays(days);
////			order.setUseTimeUnit(UseTimeUnit.WEEKLY);
//			order.setCampaignRules(depositRules);
//			order.setStationIds(stationIds);
//		}
//		if(testId==1001) {//日常活动
//			order.setCampaignRules(alwaysRules);
//		}
//		if(testId==1002) {//付款活动
//			order.setCampaignRules(paymentRules);
//			//order.setStationIds(stationIds);
//		}
//		if(testId==1005||testId==1006) {
//			order.setCampaignRules(updateGradeRules);
//		}
//		if(testId==1007) {//测实付金额
//			order.setCampaignRules(realRules);
//		}
//		order.setEventRoutes(eventRoutes);
//		order.setGid(GID.newGID());
//		// 调用接口
//		SimpleResult result = campaignManageService.create(order);
//		// 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		// 清除数据
//	}
//}
