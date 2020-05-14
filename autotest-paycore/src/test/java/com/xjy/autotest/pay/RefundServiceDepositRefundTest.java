package com.xjy.autotest.pay;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.PayTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
import com.xyb.pay.api.settlement.info.PaymentInfo;
import com.xyb.pay.api.settlement.info.RefundInfo;
import com.xyb.pay.api.settlement.order.AccountPaymentOrder;
import com.xyb.pay.api.settlement.order.RefundOrder;
import com.xyb.pay.api.settlement.service.AccountPaymentService;
import com.xyb.pay.api.settlement.service.RefundService;
import com.xyb.user.api.info.account.AccountTradeResultInfo;
import com.xyb.user.api.order.account.AccountFreezeOrder;
import com.xyb.user.api.service.account.AccountTransService;
import dal.model.pay.DepositInstructionDO;
import dal.model.pay.RefundInstructionDO;
import dal.model.pay.TransOrderRecordDO;
import dal.model.user.AccountDO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

/**
 * @author ychaoyang
 * Created on 18/8/9.
 */
public class RefundServiceDepositRefundTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    AccountPaymentService accountPaymentService;

    @Reference(version = DUBBO_VERSION)
    RefundService refundService;

    @Reference(version = DUBBO_VERSION)
    AccountTransService accountTransService;

    @Reference(version = DUBBO_VERSION, group = "refund_retry_schedule")
    ScheduleCallBackService scheduleCallBackService;

    @Reference(version = DUBBO_VERSION, group = "mqSendScheduleService")
    ScheduleCallBackService scheduleCallBackService1;

    @Autowired
    PayTestBase payTestBase;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 通用充值退款
     * 1002 GAS充值退款
     * 1003 电商管家充值退款
     * 1004 渠道退款超时，退款成功
     * 1005 渠道退款处理中
     * 1006 重复退款，原退款成功
     */
    @AutoTest(file = "pay/refundServiceDepositRefundTestSuccess.csv")
    public void refundServiceDepositRefundTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            AccountPaymentOrder depositOrder,
            RefundOrder order,
            AccountFreezeOrder accountFreezeOrder
    ) {
        // 清除数据
        // 准备数据
        //退款前账务余额
        //充值余额账户
        AccountDO PayeeAccountDO = userTestBase.findAccountByAccountNo(depositOrder.getPayeeUserId()).get(0);
        AccountDO relationAccountDO = null;
        if (testId == 1003) {
            relationAccountDO = userTestBase.findAccountByUserId(order.getPartnerId()).stream().filter((acc) -> ("POOL".equals(acc.getTag()))).findFirst().get();
        }
        // 测试过程
        depositOrder.setReqId(OID.newID());
        depositOrder.setGid(GID.newGID());
        depositOrder.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        print(depositOrder);
        // 调用充值接口
        BizResult<PaymentInfo> bizResult1 = accountPaymentService.chargePay(depositOrder);
        // 结果验证
        print(bizResult1);
        print(bizResult1.getParams().get("payInfo"));
        assertEquals(bizResult1.getStatus(), bizResult1.getStatus());
        assertEquals(bizResult1.getCode(), bizResult1.getCode());
        String bizNo = bizResult1.getInfo().getBizNo();
        sleep(5);
        // 测试过程
        order.setOrderNo(depositOrder.getMerchantOrderNo());
        order.setGid(GID.newGID());
        order.setReqId(OID.newID());
        order.setMerchantOrderNo(OID.newID());
        print(order);
        if (testId == 1002) {
            accountFreezeOrder.setAmount(order.getRefundAmount());
            accountFreezeOrder.setAccountNo(depositOrder.getPayeeUserId());
            accountFreezeOrder.setGid(GID.newGID());
            accountFreezeOrder.setReqId(OID.newID());
            accountFreezeOrder.setMerchantOrderNo(OID.newID());
            BizResult<AccountTradeResultInfo> bizResult2 = accountTransService.freezeBalance(accountFreezeOrder);
            assertEquals(Status.SUCCESS, bizResult2.getStatus());
        }
        if (testId == 1006) {
            BizResult<RefundInfo> result1 = refundService.refund(order);
            print(result1);
        }
        // 调用退款接口
        BizResult<RefundInfo> result = refundService.refund(order);
        // 结果验证
        print(result);
        print(result.getInfo());
        assertEquals(bizResult.getStatus(), result.getStatus());
        assertEquals(bizResult.getCode(), result.getCode());
        String refundBizNo = result.getInfo().getBizNo();
        assertFalse(result.getInfo().toString().contains("privateKey"));

        //数据验证
        RefundInstructionDO refundInstructionDO = payTestBase.findRefundInstructionByReqId(order.getReqId()).get(0);
        assertEquals("REFUND", refundInstructionDO.getTransType());
        assertEquals("ONLINE", refundInstructionDO.getTransTag());
        assertEquals(refundBizNo, refundInstructionDO.getBizNo());
        assertEquals(order.getReqId(), refundInstructionDO.getReqId());
        assertEquals(order.getGid(), refundInstructionDO.getGid());
        assertEquals(order.getPartnerId(), refundInstructionDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), refundInstructionDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), refundInstructionDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), refundInstructionDO.getPlatMerchantOrderNo());
        assertEquals(bizNo, refundInstructionDO.getPaymentBizNo());
        assertEquals(depositOrder.getPayeeUserId(), refundInstructionDO.getPayerUserId());
        assertEquals(depositOrder.getPayAmount().getCent(), refundInstructionDO.getPayAmount());
        assertEquals(order.getRefundAmount().getCent(), refundInstructionDO.getRefundAmount());
        if (testId <= 1003 || testId == 1006) {
            assertEquals("SUCCESS", refundInstructionDO.getStatus());
            assertEquals("finished", refundInstructionDO.getState());
        }
        if (testId == 1004 || testId == 1005) {
            assertEquals("PROCESSING", refundInstructionDO.getStatus());
            assertEquals("gw_suspend", refundInstructionDO.getState());
            //调退款定时任务
            sleep(5);
            scheduleCallBackService.justDoIT();
            sleep(4);
            refundInstructionDO = payTestBase.findRefundInstructionByReqId(order.getReqId()).get(0);
            if (testId == 1004) {
                assertEquals("SUCCESS", refundInstructionDO.getStatus());
                assertEquals("finished", refundInstructionDO.getState());
            }
            if (testId == 1005) {
                assertEquals("PROCESSING", refundInstructionDO.getStatus());
                assertEquals("gw_suspend", refundInstructionDO.getState());
                return;
            }
        }
        TransOrderRecordDO transOrderRecordDO = payTestBase.findTransOrderRecordByReqId(order.getReqId()).get(0);
        assertEquals("REFUND", transOrderRecordDO.getTransType());
        assertEquals("ONLINE", transOrderRecordDO.getTransTag());
        assertEquals(refundBizNo, transOrderRecordDO.getBizNo());
        assertEquals(order.getReqId(), transOrderRecordDO.getReqId());
        assertEquals(order.getGid(), transOrderRecordDO.getGid());
        assertEquals(order.getPartnerId(), transOrderRecordDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), transOrderRecordDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), transOrderRecordDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), transOrderRecordDO.getPlatMerchantOrderNo());

        DepositInstructionDO depositInstructionDO = payTestBase.findDepositInstructionByBizNo(bizNo).get(0);
        assertEquals("ALL", depositInstructionDO.getOrderRefundStatus());
        //账务余额
        AccountDO PayeeAccountDO1 = userTestBase.findAccountByAccountNo(depositOrder.getPayeeUserId()).get(0);
        assertEquals(PayeeAccountDO.getBalance() + depositOrder.getPayAmount().getCent() - order.getRefundAmount().getCent(), PayeeAccountDO1.getBalance());
        assertEquals(PayeeAccountDO.getFreezeBalance(), PayeeAccountDO1.getFreezeBalance());
        if (testId == 1003) {
            AccountDO relationAccountDO1 = userTestBase.findAccountByUserId(order.getPartnerId()).stream().filter(
                    (acc) -> ("POOL".equals(acc.getTag()))).collect(Collectors.toList()).get(0);
            assertEquals(relationAccountDO.getBalance(), relationAccountDO1.getBalance());
        }
        // 清除数据
        payTestBase.cleanRefundInstructionByReqId(order.getReqId());
        payTestBase.cleanDepositInstructionByReqId(depositOrder.getReqId());
    }

    /**
     * 1001 渠道退款失败
     * 1002 渠道退款超时，退款失败
     * 1003 重复退款请求，原退款失败
     * 1004 一般模式用户余额不足
     * 1005 大商户模式用户余额不足
     * 1006 大商户模式资金池余额不足
     */
    @AutoTest(file = "pay/refundServiceDepositRefundTestFailOne.csv")
    public void refundServiceDepositRefundTestFailOne(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            AccountPaymentOrder depositOrder,
            RefundOrder order
    ) {
        // 清除数据
        // 准备数据
        //退款前账务余额
        //充值余额账户
        AccountDO PayeeAccountDO = userTestBase.findAccountByAccountNo(depositOrder.getPayeeUserId()).get(0);
        AccountDO relationAccountDO = null;
        // 关联账户余额
        if (testId >= 1005) {
            relationAccountDO = userTestBase.findAccountByUserId(order.getPartnerId()).stream()
                    .filter((acc) -> ("POOL".equals(acc.getTag()))).findFirst().get();
        }
        // 测试过程
        depositOrder.setReqId(OID.newID());
        depositOrder.setGid(GID.newGID());
        depositOrder.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        print(depositOrder);
        // 调用充值接口
        BizResult<PaymentInfo> bizResult1 = accountPaymentService.chargePay(depositOrder);
        // 结果验证
        print(bizResult1);
        print(bizResult1.getParams().get("payInfo"));
        assertEquals(bizResult1.getCode(), bizResult1.getCode());
        assertEquals(bizResult1.getStatus(), bizResult1.getStatus());
        String bizNo = bizResult1.getInfo().getBizNo();
        sleep(5);
        //账务余额
        AccountDO payeeAccountDO1 = userTestBase.findAccountByAccountNo(depositOrder.getPayeeUserId()).get(0);
        if (testId == 1004 || testId == 1005 || testId == 1006) {
            payeeAccountDO1.setBalance(0L);
            payeeAccountDO1.setFreezeBalance(0L);
            userTestBase.updateAccountByAccountNo(payeeAccountDO1.getAccountNo(), payeeAccountDO1);
        }
        AccountDO relationAccountDO1 = null;
        if (testId >= 1005) {
            // 关联账户余额校验
            relationAccountDO1 = userTestBase.findAccountByUserId(order.getPartnerId()).stream()
                    .filter((acc) -> ("POOL".equals(acc.getTag()))).findFirst().get();
            assertEquals(relationAccountDO.getBalance() + depositOrder.getPayAmount().getCent(), relationAccountDO1.getBalance());
            if (testId == 1006) {
                relationAccountDO1.setBalance(0L);
                relationAccountDO1.setFreezeBalance(0L);
                userTestBase.updateAccountByAccountNo(relationAccountDO1.getAccountNo(), relationAccountDO1);
            }
        }
        // 测试过程
        order.setOrderNo(depositOrder.getMerchantOrderNo());
        order.setGid(GID.newGID());
        order.setReqId(OID.newID());
        order.setMerchantOrderNo(OID.newID());
        if (testId == 1003) {
            BizResult<RefundInfo> result1 = refundService.refund(order);
            print(result1);
            sleep(2);
        }
        print(order);
        // 调用退款接口
        BizResult<RefundInfo> result = refundService.refund(order);
        // 结果验证
        print(result);
        print(result.getInfo());
        assertEquals(bizResult.getStatus(), result.getStatus());
        assertEquals(bizResult.getCode(), result.getCode());
        assertFalse(result.toString().contains("privateKey"));
        //数据验证
        RefundInstructionDO refundInstructionDO = payTestBase.findRefundInstructionByReqId(order.getReqId()).get(0);
        assertEquals("REFUND", refundInstructionDO.getTransType());
        assertEquals("ONLINE", refundInstructionDO.getTransTag());
        //assertEquals(order.getBizNo(), refundInstructionDO.getBizNo());
        assertEquals(order.getReqId(), refundInstructionDO.getReqId());
        assertEquals(order.getGid(), refundInstructionDO.getGid());
        assertEquals(order.getPartnerId(), refundInstructionDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), refundInstructionDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), refundInstructionDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), refundInstructionDO.getPlatMerchantOrderNo());
        assertEquals(bizNo, refundInstructionDO.getPaymentBizNo());
        assertEquals(depositOrder.getPayeeUserId(), refundInstructionDO.getPayerUserId());
        assertEquals(depositOrder.getPayAmount().getCent(), refundInstructionDO.getPayAmount());
        assertEquals(order.getRefundAmount().getCent(), refundInstructionDO.getRefundAmount());
        if (testId == 1001 || testId == 1003) {
            assertEquals("FAIL", refundInstructionDO.getStatus());
            assertEquals("refund_fail", refundInstructionDO.getState());
        }

        TransOrderRecordDO transOrderRecordDO = payTestBase.findTransOrderRecordByReqId(order.getReqId()).get(0);
        assertEquals("REFUND", transOrderRecordDO.getTransType());
        assertEquals("ONLINE", transOrderRecordDO.getTransTag());
        assertEquals(refundInstructionDO.getBizNo(), transOrderRecordDO.getBizNo());
        assertEquals(order.getReqId(), transOrderRecordDO.getReqId());
        assertEquals(order.getGid(), transOrderRecordDO.getGid());
        assertEquals(order.getPartnerId(), transOrderRecordDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), transOrderRecordDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), transOrderRecordDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), transOrderRecordDO.getPlatMerchantOrderNo());
        if (testId == 1002) {
            assertEquals("PROCESSING", refundInstructionDO.getStatus());
            assertEquals("gw_suspend", refundInstructionDO.getState());
            //调退款定时任务
            sleep(5);
            scheduleCallBackService.justDoIT();
            sleep(3);
            refundInstructionDO = payTestBase.findRefundInstructionByReqId(order.getReqId()).get(0);
            assertEquals("FAIL", refundInstructionDO.getStatus());
            assertEquals("refund_fail", refundInstructionDO.getState());
            //调mq定时任务
            scheduleCallBackService1.justDoIT();
            sleep(2);
        }
        //账务余额
        AccountDO PayeeAccountDO2 = userTestBase.findAccountByAccountNo(depositOrder.getPayeeUserId()).get(0);
        assertEquals(payeeAccountDO1.getBalance(), PayeeAccountDO2.getBalance());
        assertEquals(payeeAccountDO1.getFreezeBalance(), PayeeAccountDO2.getFreezeBalance());
        if (testId >= 1005) {
            // 关联账户余额校验
            AccountDO relationAccountDO2 = userTestBase.findAccountByUserId(order.getPartnerId()).stream()
                    .filter((acc) -> ("POOL".equals(acc.getTag()))).findFirst().get();
            assertEquals(relationAccountDO1.getBalance(), relationAccountDO2.getBalance());
        }
        // 清除数据
        payTestBase.cleanRefundInstructionByReqId(order.getReqId());
        payTestBase.cleanDepositInstructionByReqId(depositOrder.getReqId());
    }

}
