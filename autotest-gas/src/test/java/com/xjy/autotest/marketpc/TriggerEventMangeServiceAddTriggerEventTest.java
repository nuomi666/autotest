//package com.xjy.autotest.marketpc;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.google.common.collect.Maps;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_marketpcTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.marketpc.api.common.enums.DataSource;
//import com.xyb.gas.marketpc.api.common.enums.KeyType;
//import com.xyb.gas.marketpc.api.manage.TriggerEventMangeService;
//import com.xyb.gas.marketpc.api.manage.order.TriggerEventDataOrder;
//import com.xyb.gas.marketpc.api.manage.order.TriggerEventOrder;
//import dal.model.gas_marketpc.TriggerEventDO;
//import dal.model.gas_marketpc.TriggerEventDataDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//
///**
// * @author nuomi@xyb.com
// * Created on 2018/10/16.
// */
//public class TriggerEventMangeServiceAddTriggerEventTest extends SpringBootTestBase{
//
//	@Reference(version = DUBBO_VERSION_1)
//    TriggerEventMangeService triggerEventMangeService;
//
//	@Autowired
//	Gas_marketpcTestBase gasMarketpcTestBase;
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "marketpc/triggerEventMangeServiceAddTriggerEventTestSuccess.csv")
//	@DisplayName("新增触发事件--成功用例")
//	public void triggerEventMangeServiceAddTriggerEventTestSuccess(
//			// 基本参数
//			int testId,
//            Status status,
//            String code,
//			// 业务参数
//			TriggerEventOrder order,
//			TriggerEventDataOrder triggerEventDataOrder
//	) {
//		// 清除数据
//		gasMarketpcTestBase.cleanTriggerEventByEventName(order.getEventName());
////        gasMarketpcTestBase.cleanTriggerEventDataByKeyCode("");
//		// 准备数据
//		// 测试过程
//		//枚举
//		Map<String, String> sexEnums=Maps.newHashMap();
//		sexEnums.put("MAN","男");
//		sexEnums.put("WOMAN","女");
//		sexEnums.put("OTHER","其他");
//		Map<String, String> memberTypeEnums=Maps.newHashMap();
//		memberTypeEnums.put("NORMAL","普通用户");
//		memberTypeEnums.put("SPECIAL_CAR","专车用户");
//		Map<String, String> gradeEnums=Maps.newHashMap();
//		gradeEnums.put("GRADE_COMMON","普通会员");
//		gradeEnums.put("GRADE_SILVER","白银会员");
//		gradeEnums.put("GRADE_GOLD","黄金会员");
//		gradeEnums.put("GRADE_DIAMONDS","钻石会员");
//		Map<String, String> payWayEnums=Maps.newHashMap();
//		payWayEnums.put("CASH","现金");
//		payWayEnums.put("WECHAT","微信");
//		payWayEnums.put("ALI","支付宝");
//		payWayEnums.put("UNION","银联刷卡");
//		payWayEnums.put("REMAINING","会员卡");
//        //字段属性
//		TriggerEventDataOrder sex = new TriggerEventDataOrder();
//		sex.setDataSource(DataSource.USER);
//		sex.setEnums(sexEnums);
//		sex.setEventRoute("userRegister");
//		sex.setKeyCode("user_sex");
//		sex.setKeyType(KeyType.ENUM);
//		sex.setKeyName("用户性别");
//		TriggerEventDataOrder userAge = new  TriggerEventDataOrder();
//		userAge.setDataSource(DataSource.USER);
//		userAge.setEventRoute("userRegister");
//		userAge.setKeyCode("user_age");
//		userAge.setKeyType(KeyType.INTEGER);
//		userAge.setKeyName("用户年龄");
//		TriggerEventDataOrder memberType = new  TriggerEventDataOrder();
//		memberType.setDataSource(DataSource.USER);
//		memberType.setEnums(memberTypeEnums);
//		memberType.setEventRoute("userRegister");
//		memberType.setKeyCode("user_memberType");
//		memberType.setKeyType(KeyType.ENUM);
//		memberType.setKeyName("用户类型");
//		TriggerEventDataOrder birthday = new  TriggerEventDataOrder();
//		birthday.setDataSource(DataSource.USER);
//		birthday.setEventRoute("USER_BIRTHDAY");
//		birthday.setKeyCode("user_short_birthday");
//		birthday.setKeyType(KeyType.STRING);
//		birthday.setKeyName("生日");
//		TriggerEventDataOrder isFull = new  TriggerEventDataOrder();
//		isFull.setDataSource(DataSource.EVENT);
//		isFull.setEventRoute("userUpdate");
//		isFull.setKeyCode("isfull");
//		isFull.setKeyType(KeyType.BOOLEAN);
//		isFull.setKeyName("是否完善资料");
//		TriggerEventDataOrder ispayed = new  TriggerEventDataOrder();
//		ispayed.setDataSource(DataSource.USER);
//		ispayed.setEventRoute("USER_BIRTHDAY");
//		ispayed.setKeyCode("user_payed");
//		ispayed.setKeyType(KeyType.BOOLEAN);
//		ispayed.setKeyName("是否进行过支付");
//		TriggerEventDataOrder grade = new TriggerEventDataOrder();
//		grade.setDataSource(DataSource.USER);
//		grade.setEnums(gradeEnums);
//		if(testId==1004) {
//			grade.setEventRoute("PAYMENT");
//		}else {
//			grade.setEventRoute("DEPOSIT");
//		}
//		grade.setKeyCode("user_grade");
//		grade.setKeyType(KeyType.ENUM);
//		grade.setKeyName("用户等级");
//		TriggerEventDataOrder oilAmount = new  TriggerEventDataOrder();
//		oilAmount.setDataSource(DataSource.EVENT);
//		oilAmount.setEventRoute("PAYMENT");
//		oilAmount.setKeyCode("GAS_TOTAL_AMOUNT");
//		oilAmount.setKeyType(KeyType.MONEY);
//		oilAmount.setKeyName("油品金额");
//		TriggerEventDataOrder goodsAmount = new  TriggerEventDataOrder();
//		goodsAmount.setDataSource(DataSource.EVENT);
//		goodsAmount.setEventRoute("PAYMENT");
//		goodsAmount.setKeyCode("GOODS_TOTAL_AMOUNT");
//		goodsAmount.setKeyType(KeyType.MONEY);
//		goodsAmount.setKeyName("商品金额");
//		TriggerEventDataOrder transAmount = new  TriggerEventDataOrder();
//		transAmount.setDataSource(DataSource.EVENT);
//		if(testId==1003) {
//			transAmount.setEventRoute("DEPOSIT");
//		}else {
//			transAmount.setEventRoute("PAYMENT");
//		}
//		transAmount.setKeyCode("transAmount");
//		transAmount.setKeyType(KeyType.MONEY);
//		if(testId==1003) {
//			transAmount.setKeyName("充值金额");
//		}else {
//			transAmount.setKeyName("付款金额");
//		}
//		TriggerEventDataOrder payAmount = new  TriggerEventDataOrder();
//		payAmount.setDataSource(DataSource.EVENT);
//		payAmount.setEventRoute("PAYMENT");
//		payAmount.setKeyType(KeyType.MONEY);
//		payAmount.setKeyCode("payAmount");
//		payAmount.setKeyName("实付金额");
//		TriggerEventDataOrder totalAmount = new  TriggerEventDataOrder();
//		totalAmount.setDataSource(DataSource.SILVERBLOT);
//		totalAmount.setModuleName("表名;模型名称;查询粒度");
//		totalAmount.setEventRoute("PAYMENT");
//		totalAmount.setKeyCode("totalAmount");
//		totalAmount.setKeyType(KeyType.MONEY);
//		totalAmount.setKeyName("累计消费金额");
//		TriggerEventDataOrder oilCode = new  TriggerEventDataOrder();
//		oilCode.setDataSource(DataSource.EVENT);
//		oilCode.setEventRoute("PAYMENT");
//		oilCode.setKeyCode("oilName");
//		oilCode.setKeyType(KeyType.STRING);
//		oilCode.setKeyName("油品");
//		TriggerEventDataOrder oilLiter = new  TriggerEventDataOrder();
//		oilLiter.setDataSource(DataSource.EVENT);
//		oilLiter.setEventRoute("PAYMENT");
//		oilLiter.setKeyCode("oilLiter");
//		oilLiter.setKeyType(KeyType.DOUBLE);
//		oilLiter.setKeyName("油品升数");
//		TriggerEventDataOrder payWay = new  TriggerEventDataOrder();
//		payWay.setDataSource(DataSource.EVENT);
//		payWay.setEnums(payWayEnums);
//		if(testId==1003) {
//			payWay.setEventRoute("DEPOSIT");
//		}else {
//			payWay.setEventRoute("PAYMENT");
//		}
//		payWay.setKeyCode("payWay");
//		payWay.setKeyType(KeyType.ENUM);
//		payWay.setKeyName("付款方式");
//		//附加属性
//		List<TriggerEventDataOrder> dataOrders = new ArrayList<TriggerEventDataOrder>();
//		if(testId==1001){
//			dataOrders.add(userAge);
//			dataOrders.add(memberType);
//		}
//		if(testId==1002){
//			dataOrders.add(isFull);
//		}
//		if(testId==1003){
//			dataOrders.add(grade);
//			dataOrders.add(transAmount);
//			dataOrders.add(payWay);
//		}
//		if(testId==1004){
//			dataOrders.add(transAmount);
//			dataOrders.add(grade);
//			dataOrders.add(payWay);
//			dataOrders.add(totalAmount);
//			dataOrders.add(oilAmount);
//			dataOrders.add(goodsAmount);
//			dataOrders.add(payAmount);
//		}
//		if(testId==1005){
//			dataOrders.add(birthday);
//			dataOrders.add(ispayed);
//		}
//		order.setDataOrders(dataOrders);
//		order.setGid(GID.newGID());
//		for(TriggerEventDataOrder dataOrder:dataOrders) {
//			gasMarketpcTestBase.cleanTriggerEventDataByKeyName(dataOrder.getEventRoute());
//		}
//		// 调用接口
//		SimpleResult result = triggerEventMangeService.AddTriggerEvent(order);
//		// 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		List<TriggerEventDO> events=gasMarketpcTestBase.findTriggerEventByEventName(order.getEventName());
//		assertTrue(events.size()>0);
//		List<TriggerEventDataDO> eventDatas=gasMarketpcTestBase.findTriggerEventDataByKeyName(triggerEventDataOrder.getKeyName());
//		// 清除数据
////		gasMarketpcTestBase.cleanTriggerEventByEventName(order.getEventName());
////		gasMarketpcTestBase.cleanTriggerEventDataByKeyName(triggerEventDataOrder.getKeyName());
//	}
//}
