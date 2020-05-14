//package com.xjy.autotest.gas_trade;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_tradeTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xjy.autotest.testbase.UserTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.id.OID;
//import com.xyb.adk.common.lang.result.BizResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.adk.common.util.money.Money;
//import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
//import com.xyb.gas.trade.api.enums.TerminalType;
//import com.xyb.gas.trade.api.info.TradeDepositBackPayInfo;
//import com.xyb.gas.trade.api.info.TradeDepositInfo;
//import com.xyb.gas.trade.api.order.TradeDepositBackOrder;
//import com.xyb.gas.trade.api.order.TradeDepositOrder;
//import com.xyb.gas.trade.api.service.TradeDepositBackService;
//import com.xyb.gas.trade.api.service.TradeDepositService;
//import dal.model.gas_trade.GasTradeDepositBackDO;
//import dal.model.gas_trade.GasTradeDepositDO;
//import dal.model.user.AccountDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * @author nuomi@xinyebang.com
// * @date 2018/9/6
// */
//public class ScheduleCallBackServiceDepositBackSuspendTest extends SpringBootTestBase {
//    @Reference(group = "gas_trade_deposit_back_suspend", version = "1.0")
//    ScheduleCallBackService depositBack;
//
//    @Reference(version = "1.0")
//    TradeDepositService tradeDepositService;
//
//    @Reference(version = "1.0")
//    TradeDepositBackService tradeDepositBackService;
//
//    @Autowired
//    Gas_tradeTestBase gasTradeTestBase;
//
//    @Autowired
//    UserTestBase userTestBase;
//
//    @Autowired
//    Gas_userTestBase gasUserBase;
//
//    /**
//     * 先走一笔充值，拿充值的bizno走一笔冲退造数据。
//     */
//    @AutoTest(file = "gas_trade/scheduleCallBackServiceDepositBackSuspendTestSuccess.csv")
//    @DisplayName("充退挂起定时重试--成功用例")
//    public void scheduleCallBackServiceDepositBackSuspendTestSuccess(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            String cardNoxx,
//            TradeDepositOrder order,
//            GasTradeDepositBackDO gasTradeDepositBackDO,
//            GasTradeDepositBackDO gasTradeDepositBackDO1
//    ) {
//        // 清除数据
//        gasTradeTestBase.cleanGasTradeDepositBackByBizNo(gasTradeDepositBackDO.getBizNo());
//        gasTradeTestBase.cleanGasTradeDepositBackByBizNo(gasTradeDepositBackDO1.getBizNo());
//        // 准备数据
//        AccountDO accountInfo = userTestBase.findAccountByUserId(gasUserBase.findUserCardInfoByCardNo(order.getCardNo()).get(0).getUserId()).get(0);
//        AccountDO accountInfo1 = userTestBase.findAccountByUserId(gasUserBase.findUserCardInfoByCardNo(cardNoxx).get(0).getUserId()).get(0);
//        //第一笔充值
//        order.setReqId(OID.newID());
//        order.setMerchantOrderNo(OID.newID());
//        order.setGid(GID.newGID());
//        BizResult<TradeDepositInfo> result = tradeDepositService.tradeDeposit(order);
//        sleep(3);
//        assertEquals("success", gasTradeTestBase.findGasTradeDepositByBizNo(result.getInfo().getBizNo()).get(0).getStatus());
//        assertEquals("finished", gasTradeTestBase.findGasTradeDepositByBizNo(result.getInfo().getBizNo()).get(0).getState());
//        assertEquals("comn_00_0000", gasTradeTestBase.findGasTradeDepositByBizNo(result.getInfo().getBizNo()).get(0).getCode());
//        //第二笔充值
//        order.setReqId(OID.newID());
//        order.setGid(GID.newGID());
//        order.setCardNo(cardNoxx);
//        if (testId == 1001) {
//            order.setPayAmount(new Money(151, 11));
//        } else {
//            order.setPayAmount(new Money(100, 00));
//        }
//        order.setMerchantOrderNo(OID.newID());
//        BizResult<TradeDepositInfo> result1 = tradeDepositService.tradeDeposit(order);
//        sleep(3);
//        assertEquals("success", gasTradeTestBase.findGasTradeDepositByBizNo(result1.getInfo().getBizNo()).get(0).getStatus());
//        assertEquals("finished", gasTradeTestBase.findGasTradeDepositByBizNo(result1.getInfo().getBizNo()).get(0).getState());
//        assertEquals("comn_00_0000", gasTradeTestBase.findGasTradeDepositByBizNo(result1.getInfo().getBizNo()).get(0).getCode());
//        //第一笔充退
//        gasTradeDepositBackDO.setDepositNo(result.getInfo().getBizNo());
//        gasTradeDepositBackDO.setReqId(OID.newID());
//        gasTradeDepositBackDO.setGid(GID.newGID());
//        gasTradeTestBase.insertGasTradeDepositBack(gasTradeDepositBackDO);
//        //第二笔充退
//        gasTradeDepositBackDO1.setDepositNo(result1.getInfo().getBizNo());
//        gasTradeDepositBackDO1.setReqId(OID.newID());
//        gasTradeDepositBackDO1.setGid(GID.newGID());
//        gasTradeDepositBackDO1.setPayNo(result1.getInfo().getPayNo());
//        if (testId == 1001) {//干扰数据(状态为pay_advance)
//            TradeDepositBackOrder backOrder = new TradeDepositBackOrder();
//            backOrder.setDepositNo(result1.getInfo().getBizNo());
//            backOrder.setPartnerId("S0301808271500000065");
//            backOrder.setTerminalType(TerminalType.POS);
//            backOrder.setTerminalCode("d01254");
//            backOrder.setOperateId("001if9yav9ikg025eh00");
//            backOrder.setStationId("001if9yazl84g025eh00");
//            backOrder.setGid(GID.newGID());
//            backOrder.setMerchantOrderNo(OID.newID());
//            backOrder.setReqId(OID.newID());
//            // 调用接口
//            BizResult<TradeDepositBackPayInfo> backResult = tradeDepositBackService.tradeDepositBack(backOrder);
//            assertEquals("processing", gasTradeTestBase.findGasTradeDepositBackByDepositNo(result1.getInfo().getBizNo()).get(0).getStatus());
//            assertEquals("pay_advance", gasTradeTestBase.findGasTradeDepositBackByDepositNo(result1.getInfo().getBizNo()).get(0).getState());
//            assertEquals("G03_03_0001", gasTradeTestBase.findGasTradeDepositBackByDepositNo(result1.getInfo().getBizNo()).get(0).getCode());
//        } else {
//            gasTradeTestBase.insertGasTradeDepositBack(gasTradeDepositBackDO1);
//        }
//        // 测试过程
//        // 调用接口
//        depositBack.justDoIT();
//        // 结果验证
//        // 数据验证
//        //充退信息
//        GasTradeDepositBackDO depositBackInfo = gasTradeTestBase.findGasTradeDepositBackByDepositNo(result.getInfo().getBizNo()).get(0);
//        GasTradeDepositBackDO depositBackInfo1 = gasTradeTestBase.findGasTradeDepositBackByDepositNo(result1.getInfo().getBizNo()).get(0);
//        assertEquals("finished", depositBackInfo.getState());
//        assertEquals("success", depositBackInfo.getStatus());
//        assertEquals("comn_00_0000", depositBackInfo.getCode());
//        if (testId == 1001) {
//            assertEquals("pay_advance", depositBackInfo1.getState());
//            assertEquals("processing", depositBackInfo1.getStatus());
//            assertEquals("comn_00_0000", depositBackInfo1.getCode());
//        } else {
//            assertEquals("pay_advance", depositBackInfo1.getState());
//            assertEquals("processing", depositBackInfo1.getStatus());
//            assertEquals("comn_00_0000", depositBackInfo1.getCode());
//        }
//        //充值信息
//        GasTradeDepositDO DepositInfo = gasTradeTestBase.findGasTradeDepositByBizNo(result.getInfo().getBizNo()).get(0);
//        GasTradeDepositDO DepositInfo1 = gasTradeTestBase.findGasTradeDepositByBizNo(result1.getInfo().getBizNo()).get(0);
//        assertEquals("refunded", DepositInfo.getState());
//        assertEquals("success", DepositInfo.getStatus());
//        assertEquals("comn_00_0000", DepositInfo.getCode());
//        if (testId == 1001) {
//            assertEquals("refunding", DepositInfo1.getState());
//            assertEquals("success", DepositInfo1.getStatus());
//            assertEquals("comn_00_0000", DepositInfo1.getCode());
//        } else {
//            assertEquals("refunded", DepositInfo1.getState());
//            assertEquals("success", DepositInfo1.getStatus());
//            assertEquals("comn_00_0000", DepositInfo1.getCode());
//        }
//        //账务信息
//        AccountDO accountInfoxx = userTestBase.findAccountByUserId(gasUserBase.findUserCardInfoByCardNo(order.getCardNo()).get(0).getUserId()).get(0);
//        AccountDO accountInfo1xx = userTestBase.findAccountByUserId(gasUserBase.findUserCardInfoByCardNo(cardNoxx).get(0).getUserId()).get(0);
//        assertEquals(Money.cent(accountInfo.getBalance()), Money.cent(accountInfoxx.getBalance()));
//        assertEquals(Money.cent(accountInfo.getFreezeBalance()), Money.cent(accountInfoxx.getFreezeBalance()));
//        assertEquals(Money.cent(accountInfo1.getBalance()).add(new Money(151, 11)), Money.cent(accountInfo1xx.getBalance()));
//        assertEquals(Money.cent(accountInfo1.getFreezeBalance()).add(new Money(151, 11)), Money.cent(accountInfo1xx.getFreezeBalance()));
//        // 清除数据
//        gasTradeTestBase.cleanGasTradeDepositByBizNo(result.getInfo().getBizNo());
//        gasTradeTestBase.cleanGasTradeDepositByBizNo(result1.getInfo().getBizNo());
//        gasTradeTestBase.cleanGasTradeDepositBackByBizNo(gasTradeDepositBackDO.getBizNo());
//        gasTradeTestBase.cleanGasTradeDepositBackByBizNo(gasTradeDepositBackDO1.getBizNo());
//        gasTradeTestBase.cleanGasTradeDepositBackByDepositNo(result.getInfo().getBizNo());
//        gasTradeTestBase.cleanGasTradeDepositBackByDepositNo(result1.getInfo().getBizNo());
//    }
//}
