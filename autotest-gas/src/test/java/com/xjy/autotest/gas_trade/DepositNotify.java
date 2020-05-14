//package com.xjy.autotest.gas_trade;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.google.common.collect.Maps;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_tradeTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xjy.autotest.testbase.UserTestBase;
//import com.xjy.autotest.utils.DateUtils;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.id.OID;
//import com.xyb.adk.common.lang.notify.TransNotifyService;
//import com.xyb.adk.common.lang.order.TransNotifyOrder;
//import com.xyb.adk.common.lang.result.BizResult;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.adk.common.util.money.Money;
//import com.xyb.gas.trade.api.info.TradeDepositInfo;
//import com.xyb.gas.trade.api.info.TradePaymentInfo;
//import com.xyb.gas.trade.api.order.TradeDepositOrder;
//import com.xyb.gas.trade.api.order.TradeGoodsOrder;
//import com.xyb.gas.trade.api.order.TradeOilOrder;
//import com.xyb.gas.trade.api.order.TradePaymentOrder;
//import com.xyb.gas.trade.api.service.TradeDepositService;
//import com.xyb.gas.trade.api.service.TradePaymentService;
//import dal.model.gas_trade.GasTradeDepositDO;
//import dal.model.gas_trade.GasTradePaymentDO;
//import dal.model.gas_user.UserCardInfoDO;
//import dal.model.gas_user.UserDO;
//import dal.model.user.AccountDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author nuomi@xinyebang.com
// * @date 2018/12/21
// */
//public class DepositNotify extends SpringBootTestBase {
//    @Reference(group = "gas_trade_deposit_advance", version = "1.0")
//    TransNotifyService deposit;
//
//    @Reference(version = "1.0")
//    TradeDepositService tradeDepositService;
//
//    @Autowired
//    Gas_tradeTestBase gasTradeTestBase;
//
//    @Autowired
//    UserTestBase userTestBase;
//
//    @Autowired
//    Gas_userTestBase gasUserTestBase;
//
//    /**
//     * 1001
//     */
//    @AutoTest(file = "gas_trade/depositNotifyTestSuccess.csv")
//    @DisplayName("模拟通知回调--成功用例")
//    public void depositNotifyTestSuccess(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            TransNotifyOrder notifyOrder,
//            GasTradeDepositDO gasTradeDepositDO,
//            UserCardInfoDO userCardInfoDO,
//            UserDO gasUserDO,
//            dal.model.user.UserDO userDO,
//            AccountDO accountDO
//    ) {
//        // 清除数据
//        gasTradeTestBase.cleanGasTradeDepositByBizNo(gasTradeDepositDO.getBizNo());
//        gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//        gasUserTestBase.cleanUserCardInfoByCardNo(userCardInfoDO.getCardNo());
//        userTestBase.cleanUserByUserId(userDO.getUserId());
//        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
//        // 准备数据
//        gasTradeTestBase.insertGasTradeDeposit(gasTradeDepositDO);
//        gasUserTestBase.insertUser(gasUserDO);
//        gasUserTestBase.insertUserCardInfo(userCardInfoDO);
//        userTestBase.insertUser(userDO);
//        userTestBase.insertAccount(accountDO);
//        // 测试过程
//        Map<String, Object> context = Maps.newHashMap();
//        notifyOrder.setBizNo(OID.newID());
//        notifyOrder.setGid(GID.newGID());
//        // 调用接口
//        SimpleResult notifyResult=deposit.notify(notifyOrder);
//        // 结果验证
//        print(notifyResult);
//        assertEquals(status,notifyResult.getStatus());
//        // 数据验证
//        GasTradeDepositDO dep=gasTradeTestBase.findGasTradeDepositByBizNo(gasTradeDepositDO.getBizNo()).get(0);
//        if(testId==1001||testId==1003||testId==1005||testId==1006) {
//            assertEquals("finished", dep.getState());
//            assertEquals("success", dep.getStatus());
//            assertEquals("comn_00_0000", dep.getCode());
//        }else {
//            assertEquals(gasTradeDepositDO.getState(), dep.getState());
//            assertEquals(gasTradeDepositDO.getStatus(), dep.getStatus());
//            assertEquals(gasTradeDepositDO.getCode(), dep.getCode());
//        }
//        AccountDO acc=userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0);
//        if(testId==1001) {
//            assertEquals(Money.cent(accountDO.getBalance()).add(Money.cent(dep.getAmount())), Money.cent(acc.getBalance()));
//            assertEquals(Money.cent(accountDO.getHisOutAmount()).add(Money.cent(dep.getAmount())), Money.cent(acc.getHisInAmount()));
//        }else {
//            assertEquals(Money.cent(accountDO.getBalance()), Money.cent(acc.getBalance()));
//            assertEquals(Money.cent(accountDO.getHisOutAmount()), Money.cent(acc.getHisOutAmount()));
//        }
//        // 清除数据
//        gasTradeTestBase.cleanGasTradeDepositByBizNo(gasTradeDepositDO.getBizNo());
//        gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//        gasUserTestBase.cleanUserCardInfoByCardNo(userCardInfoDO.getCardNo());
//        userTestBase.cleanUserByUserId(userDO.getUserId());
//        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
//    }
//}
