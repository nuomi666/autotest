package com.xjy.autotest.gas_trade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_tradeTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.trade.api.info.DepositTicketInfo;
import com.xyb.gas.trade.api.order.GasTradeTerminalOrder;
import com.xyb.gas.trade.api.service.GasTradeTicketService;
import dal.model.gas_trade.GasTradeDepositDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi@xyb.com
 * Created on 2018/09/10.
 */
public class GasTradeTicketServiceDepositTicketTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    GasTradeTicketService gasTradeTicketService;

//	@Autowired
//	Gas_tradeTestBase gasTradeTestBase;
	/**
	 * 1001
	 */
	@AutoTest(file = "gas_trade/gasTradeTicketServiceDepositTicketTestSuccess.csv")
	@DisplayName("充值打印小票--成功用例")
	public void gasTradeTicketServiceDepositTicketTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			GasTradeTerminalOrder order,
			GasTradeDepositDO gasTradeDepositDO
	) {
		// 清除数据
//		gasTradeTestBase.cleanGasTradeDepositByBizNo(gasTradeDepositDO.getBizNo());
		// 准备数据
//		gasTradeTestBase.insertGasTradeDeposit(gasTradeDepositDO);
		// 测试过程
		order.setGid(GID.newGID());
		// 调用接口
		BizResult<DepositTicketInfo> result = gasTradeTicketService.depositTicket(order);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		DepositTicketInfo info=result.getInfo();
		assertEquals(gasTradeDepositDO.getRealName(),info.getRealName());
		assertEquals(gasTradeDepositDO.getNickName(),info.getNickName());
		assertEquals(gasTradeDepositDO.getMemberType(),info.getMemberType().code());
		assertEquals(gasTradeDepositDO.getCardNo(),info.getCardNo());
		assertEquals(gasTradeDepositDO.getCardType(),info.getCardType().code());
		assertEquals(gasTradeDepositDO.getCardBizType(),info.getCardBizType().code());
		assertEquals(gasTradeDepositDO.getAmount(),info.getAmount().getCent());
		assertEquals(gasTradeDepositDO.getPayAmount(),info.getPayAmount().getCent());
		assertEquals(gasTradeDepositDO.getFavourAmount(),info.getFavourAmount().getCent());
		assertEquals(gasTradeDepositDO.getBalance(),info.getBalance().getCent());
		assertEquals(gasTradeDepositDO.getBizNo(),info.getBizNo());
		assertEquals(gasTradeDepositDO.getPayNo(),info.getPayNo());
		assertEquals(gasTradeDepositDO.getFinishTime(),info.getFinishTime());
		assertEquals(gasTradeDepositDO.getPartnerName(),info.getPartnerName());
		assertEquals(gasTradeDepositDO.getStationName(),info.getStationName());
		assertEquals(gasTradeDepositDO.getOperateName(),info.getOperateName());
		assertEquals(gasTradeDepositDO.getTradePayType(),info.getTradePayType());
		// 清除数据
//		gasTradeTestBase.cleanGasTradeDepositByBizNo(gasTradeDepositDO.getBizNo());
	}
}
