package com.xjy.autotest.gas_trade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_tradeTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.trade.api.info.DepositBackTicketInfo;
import com.xyb.gas.trade.api.order.GasTradeTerminalOrder;
import com.xyb.gas.trade.api.service.GasTradeTicketService;
import dal.model.gas_trade.GasTradeDepositBackDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi@xyb.com
 * Created on 2018/09/10.
 */
public class GasTradeTicketServiceDepositBackTicketTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    GasTradeTicketService gasTradeTicketService;

//	@Autowired
//	Gas_tradeTestBase gasTradeTestBase;
	/**
	 * 1001
	 */
	@AutoTest(file = "gas_trade/gasTradeTicketServiceDepositBackTicketTestSuccess.csv")
	@DisplayName("充退打印小票--成功用例")
	public void gasTradeTicketServiceDepositBackTicketTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			GasTradeTerminalOrder order,
			GasTradeDepositBackDO gasTradeDepositBackDO
	) {
		// 清除数据
//		gasTradeTestBase.cleanGasTradeDepositBackByBizNo(gasTradeDepositBackDO.getBizNo());
//		 准备数据
//		gasTradeTestBase.insertGasTradeDepositBack(gasTradeDepositBackDO);
		// 测试过程
		order.setGid(GID.newGID());
		// 调用接口
		BizResult<DepositBackTicketInfo> result = gasTradeTicketService.depositBackTicket(order);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		DepositBackTicketInfo info=result.getInfo();
		assertEquals(gasTradeDepositBackDO.getAmount(),info.getAmount().getCent());
		assertEquals(gasTradeDepositBackDO.getBalance(),info.getBalance().getCent());
		assertEquals(gasTradeDepositBackDO.getCardBizType(),info.getCardBizType().code());
		assertEquals(gasTradeDepositBackDO.getCardNo(),info.getCardNo());
		assertEquals(gasTradeDepositBackDO.getCardType(),info.getCardType().code());
		//assertEquals(gasTradeDepositBackDO.getf(),info.getFavourAmount());
		assertEquals(gasTradeDepositBackDO.getMemberType(),info.getMemberType().code());
		assertEquals(gasTradeDepositBackDO.getNickName(),info.getNickName());
		assertEquals(gasTradeDepositBackDO.getPayAmount(),info.getPayAmount().getCent());
		assertEquals(gasTradeDepositBackDO.getRealName(),info.getRealName());
		assertEquals(gasTradeDepositBackDO.getPayAmount(),info.getRefundAmount().getCent());
		assertEquals(gasTradeDepositBackDO.getBizNo(),info.getBizNo());
		assertEquals(gasTradeDepositBackDO.getFinishTime(),info.getFinishTime());
		assertEquals(gasTradeDepositBackDO.getOperateName(),info.getOperateName());
		assertEquals(gasTradeDepositBackDO.getPartnerName(),info.getPartnerName());
		assertEquals(gasTradeDepositBackDO.getPayNo(),info.getPayNo());
		assertEquals(gasTradeDepositBackDO.getStationName(),info.getStationName());
		assertEquals(gasTradeDepositBackDO.getTradePayType(),info.getTradePayType());
		// 清除数据
//		gasTradeTestBase.cleanGasTradeDepositBackByBizNo(gasTradeDepositBackDO.getBizNo());
	}
}
