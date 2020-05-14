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
//import com.xyb.gas.trade.api.order.TradeDepositOrder;
//import com.xyb.gas.trade.api.service.TradeDepositService;
//import dal.model.gas_trade.GasTradeDepositBackDO;
//import dal.model.gas_trade.GasTradeDepositDO;
//import dal.model.gas_user.UserCardInfoDO;
//import dal.model.gas_user.UserDO;
//import dal.model.user.AccountDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Date;
//import java.util.Map;
//
///**
// * @author nuomi@xinyebang.com
// * @date 2018/12/21
// */
//public class DepositBackNotify extends SpringBootTestBase {
//    @Reference(group = "gas_trade_deposit_back_advance", version = "1.0")
//    TransNotifyService depositBack;
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
//     * 先走一笔充值，拿充值的bizno走一笔冲退造数据。
//     */
//    @AutoTest(file = "gas_trade/depositBackNotifyTestSuccess.csv")
//    @DisplayName("充退挂起定时重试--成功用例")
//    public void depositBackNotifyTestSuccess(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            TransNotifyOrder notifyOrder,
//            GasTradeDepositDO gasTradeDepositDO,
//            GasTradeDepositBackDO gasTradeDepositBackDO,
//            UserCardInfoDO userCardInfoDO,
//            UserDO gasUserDO,
//            dal.model.user.UserDO userDO,
//            AccountDO accountDO
//    ) {
//        // 清除数据
//        gasTradeTestBase.cleanGasTradeDepositByBizNo(gasTradeDepositDO.getBizNo());
//        gasTradeTestBase.cleanGasTradeDepositBackByBizNo(gasTradeDepositBackDO.getBizNo());
//        gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//        gasUserTestBase.cleanUserCardInfoByCardNo(userCardInfoDO.getCardNo());
//        userTestBase.cleanUserByUserId(userDO.getUserId());
//        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
//        // 准备数据
//        gasTradeTestBase.insertGasTradeDeposit(gasTradeDepositDO);
//        gasTradeTestBase.insertGasTradeDepositBack(gasTradeDepositBackDO);
//        gasUserTestBase.insertUser(gasUserDO);
//        gasUserTestBase.insertUserCardInfo(userCardInfoDO);
//        userTestBase.insertUser(userDO);
//        userTestBase.insertAccount(accountDO);
//        // 测试过程
//        Map<String, Object> context = Maps.newHashMap();
//        notifyOrder.setBizNo(OID.newID());
//        notifyOrder.setGid(GID.newGID());
//        // 调用接口
//        SimpleResult notifyResult=depositBack.notify(notifyOrder);
//        // 结果验证
//        print(notifyResult);
//        assertEquals(status,notifyResult.getStatus());
//        // 数据验证
//        //充退信息
//        GasTradeDepositBackDO depositBackInfo = gasTradeTestBase.findGasTradeDepositBackByDepositNo("").get(0);
//        assertEquals("finished", depositBackInfo.getState());
//        assertEquals("success", depositBackInfo.getStatus());
//        assertEquals("comn_00_0000", depositBackInfo.getCode());
//        // 清除数据
//        gasTradeTestBase.cleanGasTradeDepositByBizNo(gasTradeDepositDO.getBizNo());
//        gasTradeTestBase.cleanGasTradeDepositBackByBizNo(gasTradeDepositBackDO.getBizNo());
//        gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//        gasUserTestBase.cleanUserCardInfoByCardNo(userCardInfoDO.getCardNo());
//        userTestBase.cleanUserByUserId(userDO.getUserId());
//        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
//    }
//}
