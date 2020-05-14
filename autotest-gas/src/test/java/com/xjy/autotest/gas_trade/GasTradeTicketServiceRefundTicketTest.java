//package com.xjy.autotest.gas_trade;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_tradeTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.BizResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.trade.api.info.GasTradeFavourInfo;
//import com.xyb.gas.trade.api.info.GasTradeGoodsInfo;
//import com.xyb.gas.trade.api.info.GasTradeOilInfo;
//import com.xyb.gas.trade.api.info.RefundTicketInfo;
//import com.xyb.gas.trade.api.order.GasTradeTerminalOrder;
//import com.xyb.gas.trade.api.service.GasTradeTicketService;
//import dal.model.gas_trade.GasTradeGoodsDO;
//import dal.model.gas_trade.GasTradeOilDO;
//import dal.model.gas_trade.GasTradePaymentDO;
//import dal.model.gas_trade.GasTradeRefundDO;
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
//public class GasTradeTicketServiceRefundTicketTest extends SpringBootTestBase{
//
//	@Reference(version = DUBBO_VERSION)
//    GasTradeTicketService gasTradeTicketService;
//
//	@Autowired
//	Gas_tradeTestBase gasTradeTestBase;
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_trade/gasTradeTicketServiceRefundTicketTestSuccess.csv")
//	@DisplayName("退款打印小票--成功用例")
//	public void gasTradeTicketServiceRefundTicketTestSuccess(
//			// 基本参数
//			int testId,
//            Status status,
//            String code,
//			// 业务参数
//			GasTradeTerminalOrder order,
//			GasTradeRefundDO gasTradeRefundDO,
//			GasTradePaymentDO gasTradePaymentDO
//	) {
//		// 清除数据
//		gasTradeTestBase.cleanGasTradeRefundByBizNo(gasTradeRefundDO.getBizNo());
//		gasTradeTestBase.cleanGasTradePaymentByBizNo(gasTradeRefundDO.getTradeNo());
//		// 准备数据
//		gasTradeTestBase.insertGasTradeRefund(gasTradeRefundDO);
//		gasTradeTestBase.insertGasTradePayment(gasTradePaymentDO);
//		// 测试过程
//		order.setGid(GID.newGID());
//		// 调用接口
//		BizResult<RefundTicketInfo> result = gasTradeTicketService.refundTicket(order);
//		// 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
//		// 数据验证
//		List<GasTradeGoodsDO> goods=gasTradeTestBase.findGasTradeGoodsByTradeNo(gasTradeRefundDO.getBizNo());
//		List<GasTradeOilDO> oils=gasTradeTestBase.findGasTradeOilByTradeNo(gasTradeRefundDO.getBizNo());
//		RefundTicketInfo info=result.getInfo();
//		List<GasTradeGoodsInfo> goodsInfos=info.getTradeGoods();
//		List<GasTradeFavourInfo> tradeFavours=info.getTradeFavours();
//		GasTradeOilInfo oilInfo=info.getTradeOil();
//		assertEquals(gasTradeRefundDO.getAmount(),info.getAmount().getCent());
//		assertEquals(gasTradeRefundDO.getBalance(),info.getBalance().getCent());
//		assertEquals(gasTradeRefundDO.getPayAmount(),info.getRefundAmount().getCent());
//		assertEquals(gasTradePaymentDO.getFavourAmount(),info.getFavourAmount().getCent());
//		assertEquals(gasTradePaymentDO.getOrderType(),info.getOrderType().code());
//		assertEquals(gasTradeRefundDO.getPayAmount(),info.getPayAmount().getCent());
//		assertEquals(gasTradeRefundDO.getBizNo(),info.getBizNo());
//		assertEquals(gasTradeRefundDO.getPayNo(),info.getPayNo());
//		assertEquals(gasTradeRefundDO.getFinishTime(),info.getFinishTime());
//		assertEquals(gasTradeRefundDO.getPartnerName(),info.getPartnerName());
//		assertEquals(gasTradeRefundDO.getStationName(),info.getStationName());
//		assertEquals(gasTradeRefundDO.getOperateName(),info.getOperateName());
//		assertEquals(gasTradeRefundDO.getTradePayType(),info.getTradePayType());
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
//		gasTradeTestBase.cleanGasTradeRefundByBizNo(gasTradeRefundDO.getBizNo());
//		gasTradeTestBase.cleanGasTradePaymentByBizNo(gasTradeRefundDO.getTradeNo());
//	}
//}
