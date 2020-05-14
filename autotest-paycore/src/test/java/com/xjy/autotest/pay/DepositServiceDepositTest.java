package com.xjy.autotest.pay;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.PayTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.AbstractInfo;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
import com.xyb.gateway.api.base.GatewayOrder;
import com.xyb.gateway.api.base.GatewayResult;
import com.xyb.gateway.api.service.GatewayService;
import com.xyb.pay.api.settlement.info.PaymentInfo;
import com.xyb.pay.api.settlement.order.AccountPaymentOrder;
import com.xyb.pay.api.settlement.service.AccountPaymentService;
import dal.model.pay.DepositInstructionDO;
import dal.model.pay.MqMessageRecordDO;
import dal.model.pay.TransOrderRecordDO;
import dal.model.user.AccountDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author ychaoyang
 * Created on 2018/07/11.
 */
@DisplayName("账务支付")
public class DepositServiceDepositTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, timeout = 80000)
    AccountPaymentService accountPaymentService;

    @Reference(version = DUBBO_VERSION, group = "gwAdvanceProvider")
    GatewayService gatewayService;

    @Reference(version = DUBBO_VERSION, group = "deposit_retry_suspend")
    ScheduleCallBackService scheduleCallBackService;

    @Reference(version = DUBBO_VERSION, group = "mqSendScheduleService")
    ScheduleCallBackService scheduleCallBackService1;

    @Autowired
    PayTestBase payTestBase;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 微信扫码充值
     * 1002 支付宝扫码充值
     * 1003 微信公众号充值-大商户模式
     * 1004 支付宝服务窗充值
     * 1005 微信反扫（条码）支付
     * 1006 微信反扫（条码）支付反查成功
     * 1007 刷卡支付
     */
    @AutoTest(file = "pay/depositServiceDepositTestSuccess.csv")
    @DisplayName("账务支付--成功用例")
    public void depositServiceDepositTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            AccountPaymentOrder order,
            GatewayOrder gatewayOrder
    ) {
        // 清除数据
        //payTestBase.cleanDepositInstructionByPartnerId(order.getPartnerId());
        // 准备数据
        //账务余额
        AccountDO PayeeAccountDO = userTestBase.findAccountByAccountNo(order.getPayeeUserId()).get(0);
        AccountDO relationAccountDO = null;
        if (testId == 1003) {
            relationAccountDO = userTestBase.findAccountByUserId(order.getPartnerId()).stream().filter((acc) -> ("POOL".equals(acc.getTag()))).findFirst().get();
        }
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        print(order);
        // 调用接口
        BizResult<PaymentInfo> result = accountPaymentService.chargePay(order);
        // 结果验证
        print(result);
        print(result.getInfo().getPrePayInfo());
        assertEquals(bizResult.getStatus(), result.getStatus());
        assertEquals(bizResult.getCode(), result.getCode());
        assertFalse(result.toString().contains("privateKey"));
        String bizNo = result.getInfo().getBizNo();
        // 数据验证
        DepositInstructionDO depositInstructionDO = payTestBase.findDepositInstructionByReqId(order.getReqId()).get(0);
        assertEquals("DEPOSIT", depositInstructionDO.getTransType());
        assertEquals(order.getGid(), depositInstructionDO.getGid());
        assertEquals(order.getPartnerId(), depositInstructionDO.getPartnerId());
        assertEquals(order.getPlatPartnerId(), depositInstructionDO.getPlatPartnerId());
        assertEquals(order.getMemo(), depositInstructionDO.getMemo());
        assertEquals(order.getExternalMetaData(), depositInstructionDO.getExternalmetadata());
        TransOrderRecordDO transOrderRecordDO = payTestBase.findTransOrderRecordByReqId(order.getReqId()).get(0);
        assertEquals("DEPOSIT", transOrderRecordDO.getTransType());
        assertEquals("ONLINE", transOrderRecordDO.getTransTag());
        assertEquals(order.getReqId(), transOrderRecordDO.getReqId());
        assertEquals(order.getGid(), transOrderRecordDO.getGid());
        assertEquals(order.getPartnerId(), transOrderRecordDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), transOrderRecordDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), transOrderRecordDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), transOrderRecordDO.getPlatMerchantOrderNo());
        if (testId <= 1004) {
            assertEquals("PROCESSING", depositInstructionDO.getStatus());
            assertEquals("gw_advance", depositInstructionDO.getState());
            sleep(3);
            // 模拟异步通知
            gatewayOrder.setGid(order.getGid());
            gatewayOrder.setReqId(bizNo);
            gatewayOrder.setPartnerId(order.getPartnerId());
            gatewayOrder.setMerchantOrderNo(order.getMerchantOrderNo());
            gatewayOrder.setPlatPartnerId(order.getPlatPartnerId());
            gatewayOrder.setPlatMerchantOrderNo(order.getPlatMerchantOrderNo());
            gatewayOrder.setSettleChannelId("swiftwechatscan");
            gatewayOrder.setChannelPartnerId("102525559737");
            Map<String, Object> params = new HashMap();
            if (testId == 1003) {
                params.put("cashPooling", true);
            }
            gatewayOrder.setParams(params);
            GatewayResult<AbstractInfo> result1 = gatewayService.gatewayNotity(gatewayOrder);
            print(result1);
            assertEquals(Status.SUCCESS, result1.getStatus());
        }
        if (testId == 1007) {
            assertEquals("PROCESSING", depositInstructionDO.getStatus());
            assertEquals("gw_advance", depositInstructionDO.getState());
            sleep(3);
        }
        //数据验证
        DepositInstructionDO depositInstructionDO1 = payTestBase.findDepositInstructionByReqId(order.getReqId()).get(0);
        assertEquals("SUCCESS", depositInstructionDO1.getStatus());
        assertEquals("finished", depositInstructionDO1.getState());
        assertEquals(order.getPayAmount().multiply(depositInstructionDO1.getPartnerRate()).divide(10000).getCent(), depositInstructionDO1.getPartnerFee());
        //账务余额
        AccountDO PayeeAccountDO1 = userTestBase.findAccountByAccountNo(order.getPayeeUserId()).get(0);
        assertEquals(PayeeAccountDO.getBalance() + order.getPayAmount().getCent(), PayeeAccountDO1.getBalance());
        assertEquals(PayeeAccountDO.getFreezeBalance(), PayeeAccountDO1.getFreezeBalance());
        assertEquals(depositInstructionDO1.getPayeeUserBalance(), PayeeAccountDO1.getBalance()-PayeeAccountDO1.getFreezeBalance());

        if (testId == 1003) {
            AccountDO relationAccountDO1 = userTestBase.findAccountByUserId(order.getPartnerId()).stream().filter(
                    (acc) -> ("POOL".equals(acc.getTag()))).collect(Collectors.toList()).get(0);
            assertEquals(relationAccountDO.getBalance() + order.getPayAmount().getCent(), relationAccountDO1.getBalance());
        }
        if (testId <= 1004 || testId == 1007) {
            //异步通知验证
            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("order", bizNo);
            ResponseEntity<String> response = restTemplate.postForEntity(QUERY_NOTIFY_URL, map, String.class);
            JSONObject jsonObject = JSONObject.parseObject(response.getBody());
            assertEquals(bizNo, jsonObject.getString("bizNo"));
            assertEquals("SUCCESS", jsonObject.getString("status"));
            assertEquals("comn_00_0000", jsonObject.getString("code"));
            assertEquals(order.getGid(), jsonObject.getString("gid"));
            assertEquals(order.getReqId(), jsonObject.getString("reqId"));
            JSONObject context = JSONObject.parseObject(jsonObject.getString("context"));
            assertEquals(order.getMerchantOrderNo(), context.getString("merchantOrderNo"));
            assertEquals("DEPOSIT", context.getString("transType"));
            assertEquals(order.getPartnerId(), context.getString("partnerId"));
            assertEquals(order.getPlatPartnerId(), context.getString("platPartnerId"));
            assertEquals(order.getPlatMerchantOrderNo(), context.getString("platMerchantOrderNo"));
            assertEquals(PayeeAccountDO1.getBalance() - PayeeAccountDO1.getFreezeBalance() + "", context.getJSONObject("balance").getString("cent"));
            assertEquals(order.getPayAmount().multiply(depositInstructionDO.getPartnerRate()).divide(10000).toString(), context.getJSONObject("partnerFee").getString("amount"));
        }
        if (testId == 1005 || testId == 1006) {
            assertEquals(order.getPayAmount().multiply(depositInstructionDO.getPartnerRate()).divide(10000), result.getInfo().getPartnerFee());
        }
        MqMessageRecordDO mqMessageRecordDO = payTestBase.findMqMessageRecordByBizNo(bizNo).get(0);
        assertEquals(depositInstructionDO.getGid(), mqMessageRecordDO.getGid());
        assertEquals(depositInstructionDO.getReqId(), mqMessageRecordDO.getReqId());
        assertEquals(depositInstructionDO.getTransType(), mqMessageRecordDO.getTransType());
        assertEquals(depositInstructionDO.getTransTag(), mqMessageRecordDO.getTransTag());
        assertEquals("SUCCESS", mqMessageRecordDO.getStatus());
        //调mq定时任务
        scheduleCallBackService1.justDoIT();
        sleep(2);
        MqMessageRecordDO mqMessageRecordDO1 = payTestBase.findMqMessageRecordByBizNo(bizNo).get(0);
        assertEquals("SUCCESS", mqMessageRecordDO1.getStatus());
        // 清除数据
        payTestBase.cleanDepositInstructionByReqId(order.getReqId());
    }

    /**
     * 1001 gid传空
     * 1002 reqId传空
     * 1003 partnerid传空
     * 1004 merchantOrderNo传空
     * 1007 transTag传空
     * 1008 notifyCategory传空
     * 1009 notifyUrl传空
     * 1010 notifyVersion传空
     * 1011 notifyGroup传空
     * 1012 payeeUserId传空
     * 1013 payeeUserTag传空
     * 1014 payAmount传空
     * 1015 payChannelId传空
     * 1016 remoteIp传空
     */
    @AutoTest(file = "pay/depositServiceDepositTestFailOne.csv")
    @DisplayName("账务支付-参数缺省--失败用例")
    public void depositServiceDepositTestFailOne(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            AccountPaymentOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        print(order);
        // 调用接口
        BizResult result = accountPaymentService.chargePay(order);
        // 结果验证
        print(result);
        assertEquals(bizResult.getCode(), result.getCode());
        assertEquals(bizResult.getStatus(), result.getStatus());
        if (testId != 1007 && testId != 1014) {
            assertEquals(bizResult.getMessage(), result.getMessage());
        }
        assertFalse(result.toString().contains("privateKey"));
        // 数据验证
        // 清除数据
    }

    /**
     * 1001 payeeUserId不存在
     * 1002 depositChannelId不存在
     * 1003 authCode错误
     * 1004 条码支付超时后成功
     * 1005 条码支付超时后失败
     */
    @AutoTest(file = "pay/depositServiceDepositTestFailTwo.csv")
    @DisplayName("账务支付失败--失败用例")
    public void depositServiceDepositTestFailTwo(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            AccountPaymentOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        print(order);
        // 调用接口
        BizResult<PaymentInfo> result = accountPaymentService.chargePay(order);
        // 结果验证
        print(result);
        assertEquals(bizResult.getStatus(), result.getStatus());
        assertEquals(bizResult.getCode(), result.getCode());
        assertFalse(result.toString().contains("privateKey"));
        // 数据验证
        if (testId == 1003) {
            DepositInstructionDO depositInstructionDO = payTestBase.findDepositInstructionByReqId(order.getReqId()).get(0);
            assertEquals("FAIL", depositInstructionDO.getStatus());
        }
        if (testId == 1004) {
            DepositInstructionDO depositInstructionDO = payTestBase.findDepositInstructionByReqId(order.getReqId()).get(0);
            assertEquals("PROCESSING", depositInstructionDO.getStatus());
            //调充值挂起定时任务
            sleep(2);
            scheduleCallBackService.justDoIT();
            sleep(3);
            DepositInstructionDO depositInstructionDO1 = payTestBase.findDepositInstructionByReqId(order.getReqId()).get(0);
            assertEquals("SUCCESS", depositInstructionDO1.getStatus());
            assertEquals("finished", depositInstructionDO1.getState());
            //异步通知验证
            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("order", result.getInfo().getBizNo());
            ResponseEntity<String> response = restTemplate.postForEntity(QUERY_NOTIFY_URL, map, String.class);
            JSONObject jsonObject = JSONObject.parseObject(response.getBody());
            JSONObject context = JSONObject.parseObject(jsonObject.getString("context"));
            assertEquals(order.getMerchantOrderNo(), context.getString("merchantOrderNo"));
            assertEquals(depositInstructionDO.getBizNo(), jsonObject.getString("bizNo"));
            assertEquals("SUCCESS", jsonObject.getString("status"));
            assertEquals("comn_00_0000", jsonObject.getString("code"));
            assertEquals(order.getGid(), jsonObject.getString("gid"));
            assertEquals(order.getReqId(), jsonObject.getString("reqId"));
        }
        if (testId == 1005) {
            DepositInstructionDO depositInstructionDO1 = payTestBase.findDepositInstructionByReqId(order.getReqId()).get(0);
            assertEquals("FAIL", depositInstructionDO1.getStatus());
            assertEquals("gw_fail", depositInstructionDO1.getState());
        }
        // 清除数据
        payTestBase.cleanDepositInstructionByReqId(order.getReqId());
    }

}
