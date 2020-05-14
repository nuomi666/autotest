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
import com.xyb.pay.api.settlement.info.RefundInfo;
import com.xyb.pay.api.settlement.order.RefundOrder;
import com.xyb.pay.api.settlement.order.payment.PaymentOrder;
import com.xyb.pay.api.settlement.service.PaymentService;
import com.xyb.pay.api.settlement.service.RefundService;
import dal.model.pay.MqMessageRecordDO;
import dal.model.pay.RefundInstructionDO;
import dal.model.pay.TransOrderRecordDO;
import dal.model.user.AccountDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author ychaoyang
 * Created on 2018/07/27.
 */
public class RefundServiceRefundTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, timeout = 80000)
    RefundService refundService;

    @Reference(version = DUBBO_VERSION, timeout = 80000)
    PaymentService paymentService;

    @Reference(version = DUBBO_VERSION, group = "gwAdvanceProvider")
    GatewayService gatewayService;

    @Reference(version = DUBBO_VERSION, group = "refund_retry_schedule")
    ScheduleCallBackService scheduleCallBackService;

    @Reference(version = DUBBO_VERSION, group = "mqSendScheduleService")
    ScheduleCallBackService scheduleCallBackService1;

    @Autowired
    PayTestBase payTestBase;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 微信扫码支付退款
     * 1002 支付宝扫码支付退款
     * 1003 微信公众号支付退款/大商户模式退款
     * 1004 支付宝服务窗支付退款
     * 1005 微信反扫（条码）支付退款
     * 1006 支付宝反扫（条码）支付退款
     * 1007 支付宝反扫（条码）支付多次退款,不支持多次退款
     * 1008 刷卡退款
     * 1009 刷卡退款,多次申请退款（刷卡不支持多次退款）
     */
    @AutoTest(file = "pay/refundServiceRefundTestSuccess.csv")
    @DisplayName("--成功用例")
    public void refundServiceRefundTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            PaymentOrder paymentOrder,
            RefundOrder order

    ) {
        // 清除数据
        // 准备数据
        AccountDO relationAccountDO = null;
        if (testId == 1003) {
            relationAccountDO = userTestBase.findAccountByUserId(order.getPartnerId()).stream().filter((acc) -> ("POOL".equals(acc.getTag()))).findFirst().get();
        }
        paymentOrder.setReqId(OID.newID());
        paymentOrder.setGid(GID.newGID());
        paymentOrder.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        print(paymentOrder);
        // 调用接口
        BizResult<PaymentInfo> result1 = paymentService.orderPay(paymentOrder);
        print(result1);
        String bizNo = result1.getInfo().getBizNo();
        if (testId <= 1004 || testId == 1008 || testId == 1009) {
            sleep(3);
        }

        if (testId == 1009) {
            order.setReqId(OID.newID());
            order.setOrderNo(paymentOrder.getMerchantOrderNo());
            order.setMerchantOrderNo(OID.newID());
            order.setGid(GID.newGID());
            BizResult<RefundInfo> refundResult = refundService.refund(order);
            assertEquals(Status.PROCESSING, refundResult.getStatus());
        }
        // 测试过程
        order.setReqId(OID.newID());
        if (testId <= 1003) {
            order.setBizNo(bizNo);
        } else {
            order.setOrderNo(paymentOrder.getMerchantOrderNo());
        }
        order.setGid(GID.newGID());
        order.setMerchantOrderNo(OID.newID());
        if (testId <= 1006) {
            order.setRefundAmount(paymentOrder.getPayAmount());
        }
        if (testId == 1007) {
            order.setReqId(OID.newID());
            order.setOrderNo(paymentOrder.getMerchantOrderNo());
            order.setGid(GID.newGID());
            order.setMerchantOrderNo(OID.newID());
            order.setRefundAmount(paymentOrder.getPayAmount());
            BizResult<RefundInfo> refundResult = refundService.refund(order);
            assertEquals(Status.SUCCESS, refundResult.getStatus());
            assertEquals("comn_00_0000", refundResult.getCode());
            RefundInstructionDO refundInstructionDO1 = payTestBase.findRefundInstructionByReqId(order.getReqId()).get(0);
            assertEquals("SUCCESS", refundInstructionDO1.getStatus());
            assertEquals("finished", refundInstructionDO1.getState());
        }
        print(order);
        // 调用接口
        BizResult<RefundInfo> result = refundService.refund(order);
        // 结果验证
        print(result);
        print(result.getInfo());
        assertEquals(bizResult.getStatus(), result.getStatus());
        assertEquals(bizResult.getCode(), result.getCode());
        assertFalse(result.toString().contains("privateKey"));
        if (testId == 1008) {
            sleep(5);
        }
        if (testId == 1009 || testId == 1007) {
            return;
        }
        String refundBizNo = result.getInfo().getBizNo();
        // 数据验证
        RefundInstructionDO refundInstructionDO = payTestBase.findRefundInstructionByReqId(order.getReqId()).get(0);
        assertEquals("REFUND", refundInstructionDO.getTransType());
        assertEquals("ONLINE", refundInstructionDO.getTransTag());
        assertEquals(order.getReqId(), refundInstructionDO.getReqId());
        assertEquals(order.getGid(), refundInstructionDO.getGid());
        assertEquals(order.getPartnerId(), refundInstructionDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), refundInstructionDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), refundInstructionDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), refundInstructionDO.getPlatMerchantOrderNo());
        assertEquals(bizNo, refundInstructionDO.getPaymentBizNo());
        if (testId <= 1007) {
            assertEquals(refundBizNo, refundInstructionDO.getBizNo());
        }
        assertEquals(paymentOrder.getPayAmount().getCent(), refundInstructionDO.getPayAmount());
        assertEquals(order.getRefundAmount().getCent(), refundInstructionDO.getRefundAmount());
        assertEquals("SUCCESS", refundInstructionDO.getStatus());
        assertEquals("finished", refundInstructionDO.getState());
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
        if (testId == 1003) {
            AccountDO relationAccountDO1 = userTestBase.findAccountByUserId(order.getPartnerId()).stream().filter((acc) -> ("POOL".equals(acc.getTag()))).findFirst().get();
            assertEquals(relationAccountDO.getBalance(), relationAccountDO1.getBalance());
        }
        //调退款定时任务
        sleep(5);
        scheduleCallBackService.justDoIT();
        sleep(4);
        // 模拟异步通知
        GatewayOrder gatewayOrder = new GatewayOrder();
        gatewayOrder.setGid(order.getGid());
        gatewayOrder.setReqId(bizNo);
        gatewayOrder.setPartnerId(order.getPartnerId());
        gatewayOrder.setMerchantOrderNo(order.getMerchantOrderNo());
        gatewayOrder.setPlatPartnerId(order.getPlatPartnerId());
        gatewayOrder.setPlatMerchantOrderNo(order.getPlatMerchantOrderNo());
        gatewayOrder.setChannelPartnerId("102525559737");
        gatewayOrder.setSettleChannelId("swiftwechatscan");
        Map<String, Object> params = new HashMap();
        gatewayOrder.setParams(params);
        GatewayResult<AbstractInfo> result2 = gatewayService.gatewayNotity(gatewayOrder);
        print(result2);
        assertEquals(Status.SUCCESS, result2.getStatus());

        MqMessageRecordDO mqMessageRecordDO = payTestBase.findMqMessageRecordByBizNo(refundBizNo).get(0);
        assertEquals(refundInstructionDO.getGid(), mqMessageRecordDO.getGid());
        assertEquals(refundInstructionDO.getReqId(), mqMessageRecordDO.getReqId());
        assertEquals(refundInstructionDO.getTransType(), mqMessageRecordDO.getTransType());
        assertEquals(refundInstructionDO.getTransTag(), mqMessageRecordDO.getTransTag());
        assertEquals("FAIL", mqMessageRecordDO.getStatus());
        //调mq定时任务
        scheduleCallBackService1.justDoIT();
        sleep(2);
        MqMessageRecordDO mqMessageRecordDO1 = payTestBase.findMqMessageRecordByBizNo(bizNo).get(0);
        assertEquals("SUCCESS", mqMessageRecordDO1.getStatus());
        // 清除数据
    }

    /**
     * 1001 bizNo和orderNo同时传空
     * 1002 refundAmount传空
     * 1003 memo传空
     * 1004 reqId传空
     * 1005 partnerId传空
     * 1006 merchantOrderNo传空
     * 1009 gid传空
     */
    @AutoTest(file = "pay/refundServiceRefundTestFailOne.csv")
    @DisplayName("参数缺省--失败用例")
    public void refundServiceRefundTestFailOne(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            PaymentOrder paymentOrder,
            RefundOrder order

    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        print(order);
        // 调用接口
        BizResult<RefundInfo> result = refundService.refund(order);
        // 结果验证
        print(result);
        assertEquals(bizResult.getStatus(), result.getStatus());
        assertEquals(bizResult.getCode(), result.getCode());
        assertFalse(result.toString().contains("privateKey"));
        // 数据验证
        // 清除数据
    }

    /**
     * 1001 bizNo不存在
     * 1002 orderNo不存在
     * 1003 原订单未支付成功
     * 1004 退款金额大于原订单金额
     * 1005 退款金额大于可退款金额
     * 1006 渠道返回退款失败
     * 1007 渠道退款超时,退款成功
     * 1008 渠道退款挂起,退款失败
     * 1009 渠道退款挂起,退款处理中
     * 1010 渠道退款挂起,退款成功
     * 1011 重复退款请求，原退款成功
     * 1012 重复退款请求，原退款失败
     * 1013 重复退款请求，原退款失败
     * 1014 退款reqId和gid跟支付订单号重复
     * 1015 大商户模式资金池账户余额不足
     * 1016 大商户模式渠道返回退款失败
     * 1017 大商户模式渠道退款挂起,退款成功
     */
    @AutoTest(file = "pay/refundServiceRefundTestFailTwo.csv")
    @DisplayName("退款失败--失败用例")
    public void refundServiceRefundTestFailTwo(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            PaymentOrder paymentOrder,
            RefundOrder order
    ) {
        // 清除数据
        // 准备数据
        paymentOrder.setReqId(OID.newID());
        paymentOrder.setGid(GID.newGID());
        paymentOrder.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        print(paymentOrder);
        String bizNo = "";
        AccountDO relationAccountDO = null;
        // 关联账户余额
        if (testId >= 1015) {
            relationAccountDO = userTestBase.findAccountByUserId(order.getPartnerId()).stream()
                    .filter((acc) -> ("POOL".equals(acc.getTag()))).findFirst().get();
        }
        // 调用接口
        if (testId >= 1003) {
            BizResult<PaymentInfo> result1 = paymentService.orderPay(paymentOrder);
            print(result1);
            if (testId >= 1004) {
                bizNo = result1.getInfo().getBizNo();
                order.setBizNo(bizNo);
                if (testId <= 1005 || testId >= 1015) {
                    sleep(5);
                }
            }
        }
        if (testId == 1003) {
            order.setOrderNo(paymentOrder.getMerchantOrderNo());
        }
        if (testId == 1005) {
            order.setReqId(OID.newID());
            order.setGid(GID.newGID());
            order.setMerchantOrderNo(OID.newID());
            BizResult<RefundInfo> result1 = refundService.refund(order);
            print(result1);
        }
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setMerchantOrderNo(OID.newID());
        if (testId >= 1011 && testId <= 1013) {
            BizResult<RefundInfo> result1 = refundService.refund(order);
            print(result1);
            sleep(2);
            if (testId == 1013) {
                order.setMerchantOrderNo(order.getMerchantOrderNo());

            }
        }
        if (testId == 1014) {
            order.setReqId(paymentOrder.getReqId());
            order.setGid(paymentOrder.getGid());
        }
        AccountDO relationAccountDO1 = null;
        if (testId >= 1015) {
            // 关联账户余额校验
            relationAccountDO1 = userTestBase.findAccountByUserId(order.getPartnerId()).stream()
                    .filter((acc) -> ("POOL".equals(acc.getTag()))).findFirst().get();
            assertEquals(relationAccountDO.getBalance() + paymentOrder.getPayAmount().getCent(), relationAccountDO1.getBalance());
            if (testId == 1015) {
                relationAccountDO1.setBalance(0L);
                relationAccountDO1.setFreezeBalance(0L);
                userTestBase.updateAccountByAccountNo(relationAccountDO1.getAccountNo(), relationAccountDO1);
            }
        }
        print(order);
        // 调用接口
        BizResult<RefundInfo> result = refundService.refund(order);
        // 结果验证
        print(result);
        assertEquals(bizResult.getStatus(), result.getStatus());
        assertEquals(bizResult.getCode(), result.getCode());
        assertFalse(result.toString().contains("privateKey"));
        if (testId >= 1011 && testId <= 1014) {
            assertTrue(result.isIdempotent());
        } else {
            assertFalse(result.isIdempotent());
        }
        // 数据验证
        List<RefundInstructionDO> list = payTestBase.findRefundInstructionByReqId(order.getReqId());
        if (testId <= 1003) {
            assertEquals(0, list.size());
        }
        if (testId == 1006) {
            RefundInstructionDO refundInstructionDO = list.get(0);
            assertEquals("FAIL", refundInstructionDO.getStatus());
        }
        if ((testId >= 1007 && testId <= 1010) || testId == 1017) {
            RefundInstructionDO refundInstructionDO = list.get(0);
            assertEquals("PROCESSING", refundInstructionDO.getStatus());
            assertEquals("gw_suspend", refundInstructionDO.getState());
            //调退款定时任务
            sleep(5);
            scheduleCallBackService.justDoIT();
            sleep(4);
            refundInstructionDO = payTestBase.findRefundInstructionByReqId(order.getReqId()).get(0);
            if (testId == 1007 || testId == 1010) {
                assertEquals("SUCCESS", refundInstructionDO.getStatus());
                assertEquals("finished", refundInstructionDO.getState());
            }
            if (testId == 1008) {
                assertEquals("FAIL", refundInstructionDO.getStatus());
                assertEquals("gw_fail", refundInstructionDO.getState());
            }
            if (testId == 1009) {
                assertEquals("PROCESSING", refundInstructionDO.getStatus());
                assertEquals("gw_suspend", refundInstructionDO.getState());
            }
            if (testId <= 1008 || testId == 1010) {
                //异步通知验证
                MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
                map.add("order", refundInstructionDO.getBizNo());
                ResponseEntity<String> response = restTemplate.postForEntity(QUERY_NOTIFY_URL, map, String.class);
                JSONObject jsonObject = JSONObject.parseObject(response.getBody());
                JSONObject context = JSONObject.parseObject(jsonObject.getString("context"));
                assertEquals(order.getMerchantOrderNo(), context.getString("merchantOrderNo"));
                assertEquals(refundInstructionDO.getBizNo(), jsonObject.getString("bizNo"));
                //assertEquals("comn_00_0000", jsonObject.getString("code"));
                assertEquals(order.getGid(), jsonObject.getString("gid"));
                assertEquals(order.getReqId(), jsonObject.getString("reqId"));
                if (testId == 1007) {
                    assertEquals("SUCCESS", jsonObject.getString("status"));
                }
                if (testId == 1008) {
                    assertEquals("FAIL", jsonObject.getString("status"));
                }
                //调mq定时任务
                scheduleCallBackService1.justDoIT();
                sleep(2);
            }
        }

        if (testId == 1011) {
            RefundInfo refundInfo = result.getInfo();
            assertEquals(order.getRefundAmount(), refundInfo.getRefundAmount());
            assertEquals(order.getMerchantOrderNo(), refundInfo.getMerchantOrderNo());
            assertEquals(order.getReqId(), refundInfo.getReqId());
            RefundInstructionDO refundInstructionDO = list.get(0);
            assertEquals(bizResult.getStatus().name(), refundInstructionDO.getStatus());
            assertEquals(refundInfo.getBizNo(), refundInstructionDO.getBizNo());
        }
        if (testId == 1012 || testId == 1013) {
            RefundInstructionDO refundInstructionDO = list.get(0);
            assertEquals(bizResult.getStatus().name(), refundInstructionDO.getStatus());
        }

        if (testId >= 1015) {
            // 关联账户余额校验
            AccountDO relationAccountDO2 = userTestBase.findAccountByUserId(order.getPartnerId()).stream()
                    .filter((acc) -> ("POOL".equals(acc.getTag()))).findFirst().get();
            if (testId <= 1016) {
                assertEquals(relationAccountDO1.getBalance(), relationAccountDO2.getBalance());
            }
            if (testId == 1017) {
                assertEquals(relationAccountDO.getBalance(), relationAccountDO2.getBalance());
            }
        }
        // 清除数据
    }

}
