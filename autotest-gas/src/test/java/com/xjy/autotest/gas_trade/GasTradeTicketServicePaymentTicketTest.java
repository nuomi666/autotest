//package com.xjy.autotest.gas_trade;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xjy.autotest.testbase.Gas_tradeTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.BizResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.merchant.api.facade.MerchantGoodsService;
//import com.xyb.gas.trade.api.info.GasTradeGoodsInfo;
//import com.xyb.gas.trade.api.info.GasTradeOilInfo;
//import com.xyb.gas.trade.api.info.PaymentTicketInfo;
//import com.xyb.gas.trade.api.order.GasTradeTerminalOrder;
//import com.xyb.gas.trade.api.service.GasTradeTicketService;
//import dal.model.gas_trade.GasTradeGoodsDO;
//import dal.model.gas_trade.GasTradeOilDO;
//import dal.model.gas_trade.GasTradePaymentDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//
///**
// * @author nuomi@xyb.com
// * Created on 2018/09/10.
// */
//public class GasTradeTicketServicePaymentTicketTest extends SpringBootTestBase{
//
//	@Reference(version = DUBBO_VERSION)
//    GasTradeTicketService gasTradeTicketService;
//
//	@Reference(version = DUBBO_VERSION)
//	MerchantGoodsService merchantGoodsService;
//
//	@Autowired
//	Gas_tradeTestBase gasTradeTestBase;
//
//	@Autowired
//	Gas_merchantTestBase gasMerchantTestBase;
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_trade/gasTradeTicketServicePaymentTicketTestSuccess.csv")
//	@DisplayName("付款打印小票--成功用例")
//	public void gasTradeTicketServicePaymentTicketTestSuccess(
//			// 基本参数
//			int testId,
//            Status status,
//            String code,
//			// 业务参数
//			GasTradeTerminalOrder order,
//			GasTradePaymentDO gasTradePaymentDO
//	) {
//		// 清除数据
//		gasTradeTestBase.cleanGasTradePaymentByBizNo(gasTradePaymentDO.getBizNo());
//		// 准备数据
//		gasTradeTestBase.insertGasTradePayment(gasTradePaymentDO);
//		// 测试过程
//		order.setGid(GID.newGID());
//		// 调用接口
//		BizResult<PaymentTicketInfo> result = gasTradeTicketService.paymentTicket(order);
//		// 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
//		// 数据验证
//		List<GasTradeGoodsDO> goods=gasTradeTestBase.findGasTradeGoodsByTradeNo(gasTradePaymentDO.getBizNo());
//		List<GasTradeOilDO> oils=gasTradeTestBase.findGasTradeOilByTradeNo(gasTradePaymentDO.getBizNo());
//		PaymentTicketInfo info=result.getInfo();
//		List<GasTradeGoodsInfo> goodsInfos=info.getTradeGoods();
//		GasTradeOilInfo oilInfo=info.getTradeOil();
//		assertEquals(gasTradePaymentDO.getAmount(),info.getAmount().getCent());
//		assertEquals(gasTradePaymentDO.getBalance(),info.getBalance().getCent());
//		assertEquals(gasTradePaymentDO.getCarNumber(),info.getCarNumber());
//		assertEquals(gasTradePaymentDO.getFavourAmount(),info.getFavourAmount().getCent());
//		assertEquals(gasTradePaymentDO.getOrderType(),info.getOrderType().code());
//		assertEquals(gasTradePaymentDO.getPayAmount(),info.getPayAmount().getCent());
//		assertEquals(gasTradePaymentDO.getBizNo(),info.getBizNo());
//		assertEquals(gasTradePaymentDO.getPayNo(),info.getPayNo());
//		assertEquals(gasTradePaymentDO.getFinishTime(),info.getFinishTime());
//		assertEquals(gasTradePaymentDO.getPartnerName(),info.getPartnerName());
//		assertEquals(gasTradePaymentDO.getStationName(),info.getStationName());
//		assertEquals(gasTradePaymentDO.getOperateName(),info.getOperateName());
//		assertEquals(gasTradePaymentDO.getTradePayType(),info.getTradePayType());
//		assertEquals(gasTradePaymentDO.getFavourAmount(), info.getFavourAmount());
//		//油品信息
//		for(GasTradeOilDO oil:oils){
//			assertEquals(oil.getAmount(),oilInfo.getAmount().getCent());
//			assertEquals(oil.getCode(),oilInfo.getCode());
//			assertEquals(oil.getLiter(),oilInfo.getLiter());
//			assertEquals(oil.getOilName(),oilInfo.getName());
//			assertEquals(oil.getOilGun(),oilInfo.getOilGun());
//			assertEquals(oil.getPrice(),oilInfo.getPrice().getCent());
//		}
//		//商品信息
//		for(GasTradeGoodsDO good:goods){
//			for(GasTradeGoodsInfo goodsInfo:goodsInfos) {
//				if(good.getCode().equals(goodsInfo.getCode())) {
//					assertEquals(good.getAmount(), goodsInfo.getAmount().getCent());
//					assertEquals(good.getCode(), goodsInfo.getCode());
//					assertEquals(good.getGoodsType(), goodsInfo.getGoodsType());
//					assertEquals(good.getGoodsName(), goodsInfo.getName());
//					assertEquals(good.getPrice(), goodsInfo.getPrice().getCent());
//				}
//			}
//		}
//		// 清除数据
//		gasTradeTestBase.cleanGasTradePaymentByBizNo(gasTradePaymentDO.getBizNo());
//	}
//}
