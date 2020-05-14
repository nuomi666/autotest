package com.xjy.autotest.pay;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.PayTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.util.money.Money;
import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
import com.xyb.pay.api.settlement.info.PaymentInfo;
import com.xyb.pay.api.settlement.order.payment.balance.BalancePaymentConfirmOrder;
import com.xyb.pay.api.settlement.service.BalancePaymentService;
import dal.model.pay.AccountOperateRecordDO;
import dal.model.pay.PayNotifyTaskDO;
import dal.model.pay.PaymentInstructionDO;
import dal.model.user.AccountDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


/**
 * @author ychaoyang
 * Created on 2018/07/17.
 */
public class BalancePaymentServiceConfirmTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    BalancePaymentService balancePaymentService;

    @Autowired
    PayTestBase payTestBase;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 确认余额支付0.01元
     * 1002 确认余额支付1.11元
     */
    @AutoTest(file = "pay/balancePaymentServiceConfirmTestSuccess.csv")
    @DisplayName("确认余额支付--成功用例")
    public void balancePaymentServiceConfirmTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            BalancePaymentConfirmOrder order,
            PaymentInstructionDO paymentInstructionDO,
            PayNotifyTaskDO payNotifyTaskDO
    ) {
        // 清除数据
        payTestBase.cleanPaymentInstructionByBizNo(paymentInstructionDO.getBizNo());
        payTestBase.cleanPaymentInstructionByMerchantOrderNo(paymentInstructionDO.getMerchantOrderNo());
        payTestBase.cleanPayNotifyTaskByBizNo(paymentInstructionDO.getBizNo());
        // 准备数据
        //关联账户
        AccountDO relationAccountDO = userTestBase.findAccountByUserId(order.getPartnerId()).stream().filter(
                (acc) -> ("balance".equals(acc.getTag()))).findFirst().get();
        paymentInstructionDO.setPayerAccBizNo(OID.newID());
        paymentInstructionDO.setRelationAccBizNo(OID.newID());
        paymentInstructionDO.setPayeeAccBizNo(OID.newID());
        paymentInstructionDO.setBizNo(OID.newID());
        if (testId == 1003) {
            relationAccountDO.setBalance(relationAccountDO.getBalance() + paymentInstructionDO.getPayAmount());
            userTestBase.updateAccountByAccountNo(relationAccountDO.getAccountNo(), relationAccountDO);
            paymentInstructionDO.setRelationAccountNo(relationAccountDO.getAccountNo());
        }
        payTestBase.insertPaymentInstruction(paymentInstructionDO);
        payNotifyTaskDO.setBizNo(paymentInstructionDO.getBizNo());
        payTestBase.insertPayNotifyTask(payNotifyTaskDO);
        //付款方账务余额
        AccountDO payerAccountDO = userTestBase.findAccountByAccountNo(paymentInstructionDO.getPayerUserId()).get(0);
        payerAccountDO.setBalance(payerAccountDO.getBalance() + paymentInstructionDO.getPayAmount());
        userTestBase.updateAccountByAccountNo(paymentInstructionDO.getPayerUserId(), payerAccountDO);
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setMerchantOrderNo(OID.newID());
        order.setBizNo(paymentInstructionDO.getBizNo());
        // 调用接口
        BizResult<PaymentInfo> result = balancePaymentService.confirm(order);
        // 结果验证
        print(result);
        assertEquals(bizResult.getCode(), result.getCode());
        assertEquals(bizResult.getStatus(), result.getStatus());
        // 数据验证
        PaymentInstructionDO paymentInstructionDO1 = payTestBase.findPaymentInstructionById(paymentInstructionDO.getId()).get(0);
        assertEquals("SUCCESS", paymentInstructionDO1.getStatus());
        assertEquals("finished", paymentInstructionDO1.getState());

        //账务验证
        AccountDO payerAccountAfter = userTestBase.findAccountByAccountNo(paymentInstructionDO.getPayerUserId()).get(0);
        AccountDO relationAccountDO1 = userTestBase.findAccountByUserId(order.getPartnerId()).stream().filter(
                (acc) -> ("balance".equals(acc.getTag()))).findFirst().get();
        assertEquals(payerAccountDO.getBalance() - paymentInstructionDO.getPayAmount(), payerAccountAfter.getBalance());
        if (testId == 1003) {
            //assertEquals(relationAccountDO.getBalance() - paymentInstructionDO.getPayAmount(), relationAccountDO1.getBalance());
        }
        //余额验证
        Money balance = result.getInfo().getBalance();
        assertEquals(balance.getCent(), payerAccountAfter.getBalance() - payerAccountAfter.getFreezeBalance());
        assertEquals(balance.getCent(), paymentInstructionDO1.getPayerBalance());
        if (testId <= 1004) {
            //异步通知验证
            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("order", order.getBizNo());
            ResponseEntity<String> response = restTemplate.postForEntity(QUERY_NOTIFY_URL, map, String.class);
            JSONObject jsonObject = JSONObject.parseObject(response.getBody());
            JSONObject context = JSONObject.parseObject(jsonObject.getString("context"));
            assertEquals(paymentInstructionDO.getMerchantOrderNo(), context.getString("merchantOrderNo"));
            assertEquals(paymentInstructionDO.getBizNo(), jsonObject.getString("bizNo"));
            assertEquals("comn_00_0000", jsonObject.getString("code"));
            assertEquals(paymentInstructionDO.getGid(), jsonObject.getString("gid"));
            assertEquals(paymentInstructionDO.getReqId(), jsonObject.getString("reqId"));
            assertEquals("SUCCESS", jsonObject.getString("status"));
            assertEquals("PAYMENT", context.getString("transType"));
            assertEquals("SUCCESS", context.getString("status"));
            assertEquals(order.getPartnerId(), context.getString("partnerId"));
            assertEquals(order.getPlatPartnerId(), context.getString("platPartnerId"));
            assertEquals(order.getPlatMerchantOrderNo(), context.getString("platMerchantOrderNo"));
            assertEquals(payerAccountAfter.getBalance() - payerAccountAfter.getFreezeBalance() + "", context.getJSONObject("balance").getString("cent"));
        }
        // 清除数据
        payTestBase.cleanPaymentInstructionByBizNo(paymentInstructionDO.getBizNo());
        payTestBase.cleanPaymentInstructionByMerchantOrderNo(paymentInstructionDO.getMerchantOrderNo());
        payTestBase.cleanPayNotifyTaskByBizNo(payNotifyTaskDO.getBizNo());
    }

    /**
     * 1001 gid传空
     * 1002 reqId传空
     * 1003 partnerid传空
     * 1004 merchantOrderNo传空
     * 1007 bizNo传空
     * 1008 password传空
     */
    @AutoTest(file = "pay/balancePaymentServiceConfirmTestFailOne.csv")
    @DisplayName("参数缺省--失败用例")
    public void balancePaymentServiceConfirmTestFailOne(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            BalancePaymentConfirmOrder order,
            PaymentInstructionDO paymentInstructionDO
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        BizResult result = balancePaymentService.confirm(order);
        // 结果验证
        print(result);
        assertEquals(bizResult.getStatus(), result.getStatus());
        assertEquals(bizResult.getCode(), result.getCode());
        assertEquals(bizResult.getMessage(), result.getMessage());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001 bizNo不存在
     * 1002 密码错误
     * 1003 密码错误,再次提交
     * 1004 余额不足
     * 1005 重复请求
     */
    @AutoTest(file = "pay/balancePaymentServiceConfirmTestFailTwo.csv")
    @DisplayName("确认余额支付失败--失败用例")
    public void balancePaymentServiceConfirmTestFailTwo(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            BalancePaymentConfirmOrder order,
            PaymentInstructionDO paymentInstructionDO,
            String password1
    ) {
        // 清除数据
        payTestBase.cleanPaymentInstructionByBizNo(paymentInstructionDO.getBizNo());
        payTestBase.cleanPaymentInstructionByMerchantOrderNo(paymentInstructionDO.getMerchantOrderNo());
        // 准备数据
        paymentInstructionDO.setPayerAccBizNo(OID.newID());
        paymentInstructionDO.setRelationAccBizNo(OID.newID());
        paymentInstructionDO.setPayeeAccBizNo(OID.newID());
        paymentInstructionDO.setBizNo(OID.newID());
        if (testId != 1001) {
            payTestBase.insertPaymentInstruction(paymentInstructionDO);
        }
        AccountDO accountDO = null;
        if (testId == 1003 || testId == 1005) {
            accountDO = userTestBase.findAccountByAccountNo(paymentInstructionDO.getPayerUserId()).get(0);
            accountDO.setBalance(accountDO.getBalance() + paymentInstructionDO.getPayAmount());
            userTestBase.updateAccountByAccountNo(paymentInstructionDO.getPayerUserId(), accountDO);
        }
        // 测试过程
        order.setBizNo(paymentInstructionDO.getBizNo());
        if (testId == 1003 || testId == 1005) {
            order.setGid(GID.newGID());
            order.setReqId(OID.newID());
            order.setMerchantOrderNo(OID.newID());
            balancePaymentService.confirm(order);
        }
        order.setGid(GID.newGID());
        order.setReqId(OID.newID());
        order.setMerchantOrderNo(OID.newID());
        if (testId == 1003) {
            order.setPassword(password1);
        }
        // 调用接口
        BizResult result = balancePaymentService.confirm(order);
        // 结果验证
        print(result);
        assertEquals(bizResult.getStatus(), result.getStatus());
        assertEquals(bizResult.getCode(), result.getCode());
        // 数据验证
        if (testId == 1003 || testId == 1005) {
            //账务验证
            AccountDO accountAfter = userTestBase.findAccountByAccountNo(paymentInstructionDO.getPayerUserId()).get(0);
            assertEquals(accountDO.getBalance() - paymentInstructionDO.getPayAmount(), accountAfter.getBalance());
        }
        // 清除数据
        payTestBase.cleanPaymentInstructionByBizNo(paymentInstructionDO.getBizNo());
        payTestBase.cleanPaymentInstructionByMerchantOrderNo(paymentInstructionDO.getMerchantOrderNo());
    }
}
