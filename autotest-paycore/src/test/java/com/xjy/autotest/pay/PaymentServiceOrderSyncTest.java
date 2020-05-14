package com.xjy.autotest.pay;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.PayTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.pay.api.settlement.info.PaymentInfo;
import com.xyb.pay.api.settlement.info.PaymentQueryOrderInfo;
import com.xyb.pay.api.settlement.order.AccountPaymentOrder;
import com.xyb.pay.api.settlement.order.payment.PaymentOrder;
import com.xyb.pay.api.settlement.order.payment.balance.BalancePaymentApplyOrder;
import com.xyb.pay.api.settlement.order.payment.balance.BalancePaymentConfirmOrder;
import com.xyb.pay.api.settlement.service.AccountPaymentService;
import com.xyb.pay.api.settlement.service.BalancePaymentService;
import dal.model.pay.DepositInstructionDO;
import dal.model.pay.PaymentInstructionDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.*;

import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.pay.api.settlement.service.PaymentService;
import com.xyb.pay.api.settlement.order.QueryOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author huairen
 * Created on 2019/04/25.
 * <p>
 * 备注：暂不支持同步刷卡支付订单
 */
public class PaymentServiceOrderSyncTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, timeout = 80000)
    PaymentService paymentService;

    @Reference(version = DUBBO_VERSION, timeout = 80000)
    AccountPaymentService accountPaymentService;

    @Reference(version = DUBBO_VERSION)
    BalancePaymentService balancePaymentService;

    @Autowired
    PayTestBase payTestBase;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 普通模式，订单支付，线上支付，订单状态为成功，渠道状态为成功
     * 1002 普通模式，订单支付，线上支付，订单状态为处理中，渠道状态为成功
     * 1003 普通模式，订单支付，线上支付，订单状态为处理中，渠道状态为失败
     * 1004 普通模式，订单支付，线上支付，订单状态为处理中，渠道状态为处理中
     * 1005 普通模式，订单支付，线上支付，订单状态为失败，渠道状态为成功
     * 1006 普通模式，订单支付，线上支付，订单状态为失败，渠道状态为失败
     * 1007 普通模式，订单支付，线上支付，订单状态为失败，渠道状态为处理中（同步返回FAIL）
     * 1008 普通模式，订单支付，线上支付，订单状态为网关挂起，渠道状态为成功
     * 1009 普通模式，订单支付，线上支付，订单状态为网关查询挂起，渠道状态为成功
     * 1010 普通模式，订单支付，线上支付，订单状态为网关查询挂起，渠道状态为失败
     * 1011 普通模式，订单支付，线上支付，订单状态为网关查询挂起，渠道状态为处理中
     * 1012 普通模式，订单支付，线上支付，刷卡支付，订单状态为成功
     * 1013 普通模式，订单支付，线上支付，刷卡支付，订单状态为失败，渠道状态为成功
     * 1014 普通模式，订单支付，线上支付，刷卡支付，订单状态为处理中，渠道状态为成功
     * 1015 普通模式，订单支付，线上支付，刷卡支付，订单状态为处理中，渠道状态为失败
     * 1016 普通模式，订单支付，线上支付，刷卡支付，订单状态为处理中，渠道状态为处理中
     * 1017 普通模式，订单支付，线下支付，订单状态为成功
     * 1018 普通模式，订单支付，线下支付，订单状态为失败
     * 1019 普通模式，订单支付，线下支付，订单状态为处理中
     * 1020 普通模式，账务支付，线上支付，订单状态为成功，渠道状态为失败
     * 1021 普通模式，账务支付，线上支付，订单状态为处理中，渠道状态为成功
     * 1022 普通模式，账务支付，线上支付，订单状态为处理中，渠道状态为失败
     * 1023 普通模式，账务支付，线上支付，订单状态为处理中，渠道状态为处理中
     * 1024 普通模式，账务支付，线上支付，订单状态为失败，渠道状态为成功
     * 1025 普通模式，账务支付，线上支付，订单状态为失败，渠道状态为失败
     * 1026 普通模式，账务支付，线上支付，订单状态为失败，渠道状态为处理中
     * 1027 普通模式，账务支付，线上支付，订单状态为挂起，渠道状态为成功
     * 1028 普通模式，账务支付，线上支付，订单状态为查询挂起，渠道状态为成功
     * 1029 普通模式，账务支付，线上支付，订单状态为查询挂起，渠道状态为失败
     * 1030 普通模式，账务支付，线上支付，订单状态为查询挂起，渠道状态为处理中
     * 1031 普通模式，账务支付，线上支付，刷卡支付，订单状态为成功
     * 1032 普通模式，账务支付，线上支付，刷卡支付，订单状态为失败，渠道状态为失败
     * 1033 普通模式，账务支付，线上支付，刷卡支付，订单状态为处理中，渠道状态为成功
     * 1034 普通模式，账务支付，线上支付，刷卡支付，订单状态为处理中，渠道状态为失败
     * 1035 普通模式，账务支付，线上支付，刷卡支付，订单状态为处理中，渠道状态为处理中
     * 1036 普通模式，账务支付，线下支付，订单状态为成功
     * 1037 普通模式，账务支付，线下支付，订单状态为失败
     * 1038 普通模式，账务支付，线下支付，订单状态为处理中
     * 1039 普通模式，余额支付订单，订单状态为成功
     * 1040 普通模式，余额支付订单，订单状态为失败
     * 1041 普通模式，余额支付订单，订单状态为处理中
     * 1042 大商户模式，订单支付，线上支付，订单状态为成功，渠道状态为成功
     * 1043 大商户模式，订单支付，线上支付，订单状态为处理中，渠道状态为成功
     * 1044 大商户模式，订单支付，线上支付，订单状态为处理中，渠道状态为失败
     * 1045 大商户模式，订单支付，线上支付，订单状态为处理中，渠道状态为处理中
     * 1046 大商户模式，订单支付，线上支付，订单状态为失败，渠道状态为成功
     * 1047 大商户模式，订单支付，线上支付，订单状态为失败，渠道状态为失败
     * 1048 大商户模式，订单支付，线上支付，订单状态为失败，渠道状态为处理中
     * 1049 大商户模式，订单支付，线上支付，订单状态为挂起，渠道状态为成功
     * 1050 大商户模式，订单支付，线上支付，订单状态为查询挂起，渠道状态为成功
     * 1051 大商户模式，订单支付，线上支付，订单状态为查询挂起，渠道状态为失败
     * 1052 大商户模式，订单支付，线上支付，订单状态为查询挂起，渠道状态为处理中
     * 1053 大商户模式，订单支付，线上支付，刷卡支付，订单状态为成功
     * 1054 大商户模式，订单支付，线上支付，刷卡支付，订单状态为失败
     * 1055 大商户模式，订单支付，线上支付，刷卡支付，订单状态为处理中，渠道状态为成功
     * 1056 大商户模式，订单支付，线上支付，刷卡支付，订单状态为处理中，渠道状态为失败
     * 1057 大商户模式，订单支付，线上支付，刷卡支付，订单状态为处理中，渠道状态为处理中
     * 1058 大商户模式，订单支付，线下支付，订单状态为成功
     * 1059 大商户模式，订单支付，线下支付，订单状态为失败
     * 1060 大商户模式，订单支付，线下支付，订单状态为处理中
     * 1061 大商户模式，账务支付，线上支付，订单状态为成功，渠道状态为成功
     * 1062 大商户模式，账务支付，线上支付，订单状态为处理中，渠道状态为成功
     * 1063 大商户模式，账务支付，线上支付，订单状态为处理中，渠道状态为失败
     * 1064 大商户模式，账务支付，线上支付，订单状态为处理中，渠道状态为处理中
     * 1065 大商户模式，账务支付，线上支付，订单状态为失败，渠道状态为成功
     * 1066 大商户模式，账务支付，线上支付，订单状态为失败，渠道状态为失败
     * 1067 大商户模式，账务支付，线上支付，订单状态为失败，渠道状态为处理中
     * 1068 大商户模式，账务支付，线上支付，订单状态为挂起，渠道状态为成功
     * 1069 大商户模式，账务支付，线上支付，订单状态为查询挂起，渠道状态为成功
     * 1070 大商户模式，账务支付，线上支付，订单状态为查询挂起，渠道状态为失败
     * 1071 大商户模式，账务支付，线上支付，订单状态为查询挂起，渠道状态为处理中
     * 1072 大商户模式，账务支付，线上支付，刷卡支付，订单状态为成功
     * 1073 大商户模式，账务支付，线上支付，刷卡支付，订单状态为失败
     * 1074 大商户模式，账务支付，线上支付，刷卡支付，订单状态为处理中，渠道状态为成功
     * 1075 大商户模式，账务支付，线上支付，刷卡支付，订单状态为处理中，渠道状态为失败
     * 1076 大商户模式，账务支付，线上支付，刷卡支付，订单状态为处理中，渠道状态为处理中
     * 1077 大商户模式，账务支付，线下支付，订单状态为成功
     * 1078 大商户模式，账务支付，线下支付，订单状态为失败
     * 1079 大商户模式，账务支付，线下支付，订单状态为处理中
     * 1080 大商户模式，余额支付订单，订单状态为成功
     * 1081 大商户模式，余额支付订单，订单状态为失败
     * 1082 大商户模式，余额支付订单，订单状态为处理中
     */
    @AutoTest(file = "pay/paymentServiceOrderSyncTestSuccess.csv")
    @DisplayName("订单结果同步--成功用例")
    public void paymentServiceOrderSyncTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            String tradeState,
            // 业务参数
            QueryOrder order,
            PaymentOrder payOrder,
            AccountPaymentOrder accPayOrder,
            BalancePaymentApplyOrder applyOrder,
            BalancePaymentConfirmOrder confirmOrder,
            String bizNo
    ) {
        // 清除数据
        // 准备数据
        //订单支付
        if ((testId <= 1019) || (testId >= 1042 && testId <= 1060)) {
            BizResult<PaymentInfo> rs = paymentService.orderPay(payOrder);
            bizNo = rs.getInfo().getBizNo();
            if ((testId >= 1005 && testId <= 1011)
                    || (testId >= 1018 && testId <= 1019)
                    || (testId >= 1046 && testId <= 1052)
                    || (testId >= 1059 && testId <= 1060)
            ) {
                PaymentInstructionDO paymentInstructionDO = payTestBase.findPaymentInstructionByBizNo(bizNo).get(0);
                if ((testId >= 1005 & testId <= 1007)
                        || (testId >= 1046 & testId <= 1048)
                ) {
                    paymentInstructionDO.setStatus("FAIL");
                    paymentInstructionDO.setState("gw_fail");
                }
                if (testId == 1008 || testId == 1049) {
                    paymentInstructionDO.setStatus("PROCESSING");
                    paymentInstructionDO.setState("gw_suspend");
                }
                if ((testId >= 1009 & testId <= 1011)
                        || (testId >= 1052 & testId <= 1057)
                ) {
                    paymentInstructionDO.setStatus("PROCESSING");
                    paymentInstructionDO.setState("gw_query_suspend");
                }
                if (testId == 1018 || testId == 1059) {
                    paymentInstructionDO.setStatus("FAIL");
                    paymentInstructionDO.setState("gw_fail");
                }
                if (testId == 1019 || testId == 1060) {
                    paymentInstructionDO.setStatus("PROCESSING");
                    paymentInstructionDO.setState("gw_query_suspend");
                }
                payTestBase.updatePaymentInstructionByBizNo(bizNo, paymentInstructionDO);
            }
        }
        //账务支付
        if ((testId >= 1020 && testId <= 1038)
                || (testId >= 1061 && testId <= 1079)) {
            BizResult<PaymentInfo> rs = accountPaymentService.chargePay(accPayOrder);
            bizNo = rs.getInfo() == null ? null : rs.getInfo().getBizNo();
            order.setMerchantOrderNo(accPayOrder.getMerchantOrderNo());
            if ((testId >= 1024 && testId <= 1030)
                    || (testId >= 1037 && testId <= 1038)
                    || (testId >= 1065 && testId <= 1071)
                    || (testId >= 1078 && testId <= 1079)
            ) {
                DepositInstructionDO depositInstructionDO = payTestBase.findDepositInstructionByMerchantOrderNo(accPayOrder.getMerchantOrderNo()).get(0);
                if ((testId >= 1024 && testId <= 1026)
                        || (testId >= 1065 && testId <= 1067)
                ) {
                    depositInstructionDO.setStatus("FAIL");
                    depositInstructionDO.setState("gw_fail");
                }
                if (testId == 1027 || testId == 1068) {
                    depositInstructionDO.setStatus("PROCESSING");
                    depositInstructionDO.setState("gw_suspend");
                }
                if ((testId >= 1028 && testId <= 1030)
                        || (testId >= 1069 && testId <= 1071)) {
                    depositInstructionDO.setStatus("PROCESSING");
                    depositInstructionDO.setState("gw_query_suspend");
                }
                if (testId == 1037 || testId == 1078) {
                    depositInstructionDO.setStatus("FAIL");
                    depositInstructionDO.setState("gw_fail");
                }
                if (testId == 1038 || testId == 1079) {
                    depositInstructionDO.setStatus("PROCESSING");
                    depositInstructionDO.setState("gw_query_suspend");
                }
                payTestBase.updateDepositInstructionByMerchantOrderNo(accPayOrder.getMerchantOrderNo(), depositInstructionDO);
            }
        }
        //余额支付
        if ((testId >= 1039 && testId <= 1041)
                || (testId >= 1080 && testId <= 1082)
        ) {
            BizResult<PaymentInfo> rs = balancePaymentService.apply(applyOrder);
            bizNo = rs.getInfo().getBizNo();
            confirmOrder.setBizNo(bizNo);
            BizResult<PaymentInfo> rs1 = balancePaymentService.confirm(confirmOrder);
            PaymentInstructionDO paymentInstructionDO = payTestBase.findPaymentInstructionByBizNo(bizNo).get(0);
            if (testId == 1040 || testId == 1081) {
                paymentInstructionDO.setStatus("FAIL");
                paymentInstructionDO.setState("gw_fail");
            }
            if (testId == 1041 || testId == 1082) {
                paymentInstructionDO.setStatus("PROCESSING");
                paymentInstructionDO.setState("gw_suspend");
            }
            payTestBase.updatePaymentInstructionByBizNo(bizNo, paymentInstructionDO);

        }
        if (testId == 1001 || testId == 1012 ||
                testId == 1042 || testId == 1053
        ) {
            waitPaymentOrderStatus("SUCCESS", bizNo);

        }

        if (testId == 1020 || testId == 1031
                || testId == 1061 || testId == 1072) {
            waitDepositOrderStatus("SUCCESS", accPayOrder.getMerchantOrderNo());
        }
        // 测试过程
        order.setBizNo(bizNo);
        print(order);
        // 调用接口
        BizResult<PaymentQueryOrderInfo> result = paymentService.orderSync(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        assertEquals(tradeState, result.getInfo().getTradeState());
        assertNotNull(result.getInfo().getFinishTime());
        assertFalse(result.toString().contains("privateKey"));
        // 数据验证
        //订单支付
        if ((testId <= 1019)
                || (testId >= 1042 && testId <= 1060)) {
            PaymentInstructionDO paymentInstructionDO = payTestBase.findPaymentInstructionByBizNo(bizNo).get(0);
            assertEquals(tradeState, paymentInstructionDO.getStatus());
            if ("ONLINE".equals(paymentInstructionDO.getTransTag())) {
                assertEquals(result.getInfo().getPartnerFee().getCent(), paymentInstructionDO.getPartnerFee());
            }
            if ((testId <= 1019) || (testId >= 1053 && testId <= 1060)) {
                //大商户模式刷卡和线下支付仍走普通模式
                assertEquals("NORMAL", paymentInstructionDO.getMerchantMode());
            }
            if ((testId >= 1042 && testId <= 1052)) {
                assertEquals("BIGMERCHANT", paymentInstructionDO.getMerchantMode());
            }
        }
        //账务支付
        if ((testId >= 1020 && testId <= 1038)
                || (testId >= 1061 && testId <= 1079)) {
            DepositInstructionDO depositInstructionDO = payTestBase.findDepositInstructionByMerchantOrderNo(accPayOrder.getMerchantOrderNo()).get(0);
            assertEquals(tradeState, depositInstructionDO.getStatus());
            if ("ONLINE".equals(depositInstructionDO.getTransTag())) {
                assertEquals(result.getInfo().getPartnerFee().getCent(), depositInstructionDO.getPartnerFee());
            }
            if ((testId >= 1020 && testId <= 1030) || (testId >= 1072 && testId <= 1079)) {
                //大商户模式刷卡和线下支付仍走普通模式
                assertEquals("NORMAL", depositInstructionDO.getMerchantMode());
            }
            if ((testId >= 1061 && testId <= 1071)) {
                assertEquals("BIGMERCHANT", depositInstructionDO.getMerchantMode());
            }
            assertEquals(result.getInfo().getBalance().getCent(), depositInstructionDO.getPayeeUserBalance());
        }
        //余额支付
        if ((testId >= 1039 && testId <= 1041)
                || (testId >= 1080 && testId <= 1082)) {
            PaymentInstructionDO paymentInstructionDO = payTestBase.findPaymentInstructionByBizNo(bizNo).get(0);
            assertEquals(tradeState, paymentInstructionDO.getStatus());
            if ("ONLINE".equals(paymentInstructionDO.getTransTag())) {
                assertEquals(result.getInfo().getPartnerFee().getCent(), paymentInstructionDO.getPartnerFee());
            }
            assertEquals("NORMAL", paymentInstructionDO.getMerchantMode());
            assertEquals(result.getInfo().getBalance().getCent(), paymentInstructionDO.getPayerBalance());
        }
        // 清除数据
        // payTestBase.cleanPaymentInstructionByBizNo(bizNo);
    }

    /**
     * 1001 订单不存在
     * 1002 普通模式，订单支付，线上支付，订单状态为处理中，渠道查询超时
     */
    @AutoTest(file = "pay/paymentServiceOrderSyncTestFailTwo.csv")
    @DisplayName("订单结果同步--失败用例")
    public void paymentServiceOrderSyncTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            String tradeState,
            // 业务参数
            QueryOrder order,
            PaymentOrder payOrder,
            AccountPaymentOrder accPayOrder
    ) {
        // 清除数据
        // 准备数据
        if (testId == 1002) {
            BizResult<PaymentInfo> rs = paymentService.orderPay(payOrder);
            String bizNo = rs.getInfo().getBizNo();
            order.setBizNo(bizNo);
        }
        // 测试过程
        // 调用接口
        BizResult<PaymentQueryOrderInfo> result = paymentService.orderSync(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        if (testId == 1002) {
            assertEquals(tradeState, result.getInfo().getTradeState());
        }
        assertFalse(result.toString().contains("privateKey"));
        // 数据验证
        // 清除数据
    }

    /**
     * 等待订单状态更新
     *
     * @param status
     * @param bizNo
     */
    public void waitPaymentOrderStatus(String status, String bizNo) {
        for (int i = 0; i < 10; i++) {
            PaymentInstructionDO paymentInstructionDO = payTestBase.findPaymentInstructionByBizNo(bizNo).get(0);
            if (status.equals(paymentInstructionDO.getStatus())) {
                return;
            } else {
                sleep(1);
            }
        }

    }

    /**
     * 等待订单状态更新
     *
     * @param status
     * @param merchantOrderNo
     */
    public void waitDepositOrderStatus(String status, String merchantOrderNo) {
        for (int i = 0; i < 10; i++) {
            DepositInstructionDO depositInstructionDO = payTestBase.findDepositInstructionByMerchantOrderNo(merchantOrderNo).get(0);
            if (status.equals(depositInstructionDO.getStatus())) {
                return;
            } else {
                sleep(1);
            }
        }

    }
}
