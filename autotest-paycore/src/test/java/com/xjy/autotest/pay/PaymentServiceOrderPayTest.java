package com.xjy.autotest.pay;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONArray;
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
import com.xyb.adk.common.util.money.Money;
import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
import com.xyb.gateway.api.base.GatewayOrder;
import com.xyb.gateway.api.base.GatewayResult;
import com.xyb.gateway.api.service.GatewayService;
import com.xyb.pay.api.settlement.info.PaymentInfo;
import com.xyb.pay.api.settlement.order.payment.PaymentOrder;
import com.xyb.pay.api.settlement.service.PaymentService;
import dal.model.pay.MqMessageRecordDO;
import dal.model.pay.PayNotifyTaskDO;
import dal.model.pay.PaymentInstructionDO;
import dal.model.pay.TransOrderRecordDO;
import dal.model.user.AccountDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;


/**
 * @author ychaoyang
 * Created on 2018/07/11.
 * <p>
 * 订单
 * 服务应用场景：
 * 1.用户支付时扫码获取预支付信息，在收银台付款后，系统收到支付成功通知即支付完成
 * 2.收银员用扫码枪扫用户的支付码，渠道同步返回支付结果，即支付完成
 * <p>
 * 开发实现逻辑：
 * 1.订单入库幂等校验 -> 查询商户模式 -> 查询路由信息 -> 调网关系统获取预支付信息
 * 2.接收网关支付结果通知 -> 更新订单表状态 -> 异步通知结果给调用方
 * <p>
 * 用例整体设计：网关mock2秒后会自动通知结果（成功时），mock也能接收异步通知，可用orderNo查询通知结果
 * <p>
 * 涉及系统：pay、user、cashier、clear、gateway、autotestmock
 * <p>
 * 涉及表：
 * payment_instruction --订单支付记录表
 * trans_order_record --各种交易汇总表
 * mq_message_record --MQ记录表
 * pay_notify_task --异步通知记录表
 * <p>
 * 特别注意：
 * 1.大商户模式，会更新商户关联账户余额，一般模式不更新
 * 2.支付成功才会有异步通知
 */
@DisplayName("订单支付")
public class PaymentServiceOrderPayTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    PaymentService paymentService;

    @Reference(version = DUBBO_VERSION, group = "gwAdvanceProvider")
    GatewayService gatewayService;

    @Reference(version = DUBBO_VERSION, group = "payment_online_retry_suspend")
    ScheduleCallBackService scheduleCallBackService;

    @Reference(version = DUBBO_VERSION, group = "mqSendScheduleService")
    ScheduleCallBackService scheduleCallBackService1;

    @Autowired
    PayTestBase payTestBase;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 必填参数，线上支付，一般商户模式，微信扫码支付，0.01元
     * 1002 全填参数，线上支付，一般商户模式，支付宝扫码支付，10000元
     * 1003 全填参数，线上支付，大商户模式，微信公众号支付，100元
     * 1004 全填参数，线上支付，一般商户模式，支付宝服务窗支付，4.44元
     * 1005 全填参数，线上支付，一般商户模式，微信反扫（条码）支付，0.01元,同步返回成功
     * 1006 全填参数，线上支付，一般商户模式，支付宝反扫（条码）支付，102元，同步反查成功
     * 1007 全填参数，线上支付，一般商户模式，刷卡支付，99元
     * 1008 全填参数，线上支付，一般商户模式，微信公众号支付，1元，分润
     */
    @AutoTest(file = "pay/paymentServiceOrderPayTestSuccess.csv")
    @DisplayName("订单支付--成功用例")
    public void paymentServiceOrderPayTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            PaymentOrder order
    ) throws ParseException {

        // 清除数据
        payTestBase.cleanDepositInstructionByPartnerId(order.getPartnerId());
        // 准备数据
        AccountDO relationAccountDO = null;
        // 关联账户余额
        if (testId == 1003) {
            relationAccountDO = userTestBase.findAccountByUserId(order.getPartnerId()).stream()
                    .filter((acc) -> ("POOL".equals(acc.getTag()))).findFirst().get();
        }
        // 测试过程
        print(order);
        if (testId == 1008) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("payerUserId", order.getPartnerId());
            jsonObject.put("payeeUserId", "20180615001234567896");
            jsonObject.put("profitPercent", "0.2");
            JSONArray jsons = new JSONArray();
            jsons.add(jsonObject);
            // order.setProfitInfo(jsons.toJSONString());
        }
        // 调用接口
        BizResult<PaymentInfo> result = paymentService.orderPay(order);
        print(result);
        // 结果验证
        print(result.getInfo().getPrePayInfo());
        String bizNo = result.getInfo().getBizNo();
        assertEquals(bizResult.getStatus(), result.getStatus());
        assertEquals(bizResult.getCode(), result.getCode());

        assertFalse(result.toString().contains("privateKey"));
        // 数据验证
        // payment_instruction表
        PaymentInstructionDO paymentInstructionDO = payTestBase.findPaymentInstructionByReqId(order.getReqId()).get(0);
        assertEquals("PAYMENT", paymentInstructionDO.getTransType());
        assertEquals("ONLINE", paymentInstructionDO.getTransTag());
        assertEquals(bizNo, paymentInstructionDO.getBizNo());
        assertEquals(order.getReqId(), paymentInstructionDO.getReqId());
        assertEquals(order.getGid(), paymentInstructionDO.getGid());
        assertEquals(order.getPartnerId(), paymentInstructionDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), paymentInstructionDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), paymentInstructionDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), paymentInstructionDO.getPlatMerchantOrderNo());
        assertEquals(order.getPayAmount().getCent(), paymentInstructionDO.getPayAmount());
        assertEquals(order.getPayAmount().multiply(paymentInstructionDO.getPartnerRate()).divide(10000).getCent(), paymentInstructionDO.getPartnerFee());
        assertEquals(order.getPayChannelId(), paymentInstructionDO.getPayChannelId());
        assertEquals(bizResult.getStatus().code().toUpperCase(), paymentInstructionDO.getStatus());
        assertEquals(order.getMemo(), paymentInstructionDO.getMemo());
        assertEquals(order.getExternalMetaData(), paymentInstructionDO.getExternalmetadata());
        // trans_order_record表
        TransOrderRecordDO transOrderRecordDO = payTestBase.findTransOrderRecordByReqId(order.getReqId()).get(0);
        assertEquals("PAYMENT", transOrderRecordDO.getTransType());
        assertEquals("ONLINE", transOrderRecordDO.getTransTag());
        assertEquals(paymentInstructionDO.getBizNo(), transOrderRecordDO.getBizNo());
        assertEquals(order.getReqId(), transOrderRecordDO.getReqId());
        assertEquals(order.getGid(), transOrderRecordDO.getGid());
        assertEquals(order.getPartnerId(), transOrderRecordDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), transOrderRecordDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), transOrderRecordDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), transOrderRecordDO.getPlatMerchantOrderNo());
        if (testId <= 1004 || testId >= 1007) {
            assertEquals("PROCESSING", paymentInstructionDO.getStatus());
            assertEquals("gw_advance", paymentInstructionDO.getState());
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
            if (testId == 1003) {
                params.put("cashPooling", true);
            }
            gatewayOrder.setParams(params);
            GatewayResult<AbstractInfo> result1 = gatewayService.gatewayNotity(gatewayOrder);
            print(result1);
            assertEquals(Status.SUCCESS, result1.getStatus());

            // 数据验证
            PaymentInstructionDO paymentInstructionDO1 = payTestBase.findPaymentInstructionByReqId(order.getReqId()).get(0);
            assertEquals("SUCCESS", paymentInstructionDO1.getStatus());
            assertEquals("finished", paymentInstructionDO1.getState());
            assertEquals(order.getPayAmount().multiply(paymentInstructionDO.getPartnerRate())
                    .divide(10000).getCent(), paymentInstructionDO1.getPartnerFee());
            //异步通知验证
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            map.add("order", bizNo);
            ResponseEntity<String> response = restTemplate.postForEntity(QUERY_NOTIFY_URL, map, String.class);
            JSONObject jsonObject = JSONObject.parseObject(response.getBody());
            JSONObject context = JSONObject.parseObject(jsonObject.getString("context"));
            assertEquals(bizNo, jsonObject.getString("bizNo"));
            assertEquals("SUCCESS", jsonObject.getString("status"));
            assertEquals(order.getGid(), jsonObject.getString("gid"));
            assertEquals(order.getReqId(), jsonObject.getString("reqId"));
            assertEquals(order.getMerchantOrderNo(), context.getString("merchantOrderNo"));
            assertEquals("PAYMENT", context.getString("transType"));
            assertEquals(order.getPartnerId(), context.getString("partnerId"));
            assertEquals(order.getPlatPartnerId(), context.getString("platPartnerId"));
            assertEquals(order.getPlatMerchantOrderNo(), context.getString("platMerchantOrderNo"));
            assertEquals("comn_00_0000", context.getString("code"));
            assertEquals(order.getMemo(), context.getString("memo"));
            assertEquals(order.getPayAmount().multiply(paymentInstructionDO.getPartnerRate()).divide(10000).toString(),
                    context.getJSONObject("partnerFee").getString("amount"));
            // pay_notify_task表
            PayNotifyTaskDO payNotifyTaskDO = payTestBase.findPayNotifyTaskByBizNo(bizNo).get(0);
            assertEquals("SUCCESS", payNotifyTaskDO.getStatus());
        }
        if (testId == 1003) {
            // 关联账户余额校验
            AccountDO relationAccountDO1 = userTestBase.findAccountByUserId(order.getPartnerId()).stream()
                    .filter((acc) -> ("POOL".equals(acc.getTag()))).findFirst().get();
            assertEquals(relationAccountDO.getBalance() + order.getPayAmount().getCent(), relationAccountDO1.getBalance());
        }
        if (testId == 1005 || testId == 1006) {
            assertEquals(order.getPayAmount().multiply(paymentInstructionDO.getPartnerRate()).divide(10000)
                    , result.getInfo().getPartnerFee());
        }
        // mq_message_record表
        MqMessageRecordDO mqMessageRecordDO = payTestBase.findMqMessageRecordByBizNo(bizNo).get(0);
        assertEquals(paymentInstructionDO.getGid(), mqMessageRecordDO.getGid());
        assertEquals(paymentInstructionDO.getReqId(), mqMessageRecordDO.getReqId());
        assertEquals(paymentInstructionDO.getTransType(), mqMessageRecordDO.getTransType());
        assertEquals(paymentInstructionDO.getTransTag(), mqMessageRecordDO.getTransTag());
        assertEquals("SUCCESS", mqMessageRecordDO.getStatus());
        //调mq定时任务
        scheduleCallBackService1.justDoIT();
        sleep(4);
        MqMessageRecordDO mqMessageRecordDO1 = payTestBase.findMqMessageRecordByBizNo(bizNo).get(0);
        assertEquals("SUCCESS", mqMessageRecordDO1.getStatus());
        //ES数据验证

/*        String sql1 = "select  * from payment_instruction where biz_no = '" + bizNo + "'";
        JSONObject jsonObject = getObjectFromES(sql1);
        PaymentInstructionDO paymentInstructionDO1 = payTestBase.findPaymentInstructionByReqId(order.getReqId()).get(0);
        paymentInstructionDO1.setRawUpdateTime(null);
        paymentInstructionDO1.setStatus(paymentInstructionDO1.getStatus().toLowerCase());
        paymentInstructionDO1.setPayeeTransDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(jsonObject.getString("payee_trans_date").replace("T", " ")));
        paymentInstructionDO1.setExtensionContext(jsonObject.getString("extension_context"));
        assertEquals(paymentInstructionDO1, jsonToObject(jsonObject, PaymentInstructionDO.class));

        String sql2 = "SELECT * FROM trans_order_record where biz_no = '" + bizNo + "'";
        JSONObject jsonObject1 = getObjectFromES(sql2);
        transOrderRecordDO.setRawUpdateTime(null);
        assertEquals(transOrderRecordDO, jsonToObject(jsonObject1, TransOrderRecordDO.class));*/


        // 清除数据
        payTestBase.cleanDepositInstructionByPartnerId(order.getPartnerId());
    }

    /**
     * 1001 gid传空
     * 1002 reqId传空
     * 1003 partnerId传空
     * 1004 merchantOrderNo传空
     * 1007 notifyCategory传空
     * 1008 notifyUrl传空
     * 1009 notifyVersion传空
     * 1010 notifyGroup传空
     * 1011 transTag传空
     * 1012 depositAmount传空
     * 1013 depositChannelId传空
     * 1014 remoteIp传空
     */
    @AutoTest(file = "pay/paymentServiceOrderPayTestFailOne.csv")
    @DisplayName("参数缺省--失败用例")
    public void paymentServiceOrderPayTestFailOne(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            PaymentOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        BizResult result = paymentService.orderPay(order);
        // 结果验证
        print(result);
        assertEquals(bizResult.getCode(), result.getCode());
        assertEquals(bizResult.getStatus(), result.getStatus());
        if (testId != 1012 && testId != 1013) {
            assertEquals(bizResult.getMessage(), result.getMessage());
        }
        assertFalse(result.toString().contains("privateKey"));
        // 数据验证
        // 清除数据
    }

    /**
     * 1001 支付渠道不存在
     * 1002 微信公众号支付openId错误
     * 1003 支付宝服务窗支付userId错误
     * 1004 authCode错误-微信
     * 1005 authCode错误-支付宝
     * 1006 重复请求-失败
     * 1007 重复请求-成功
     * 1008 条码支付超时-成功
     * 1009 条码支付超时-失败
     * 1010 merchorderNo重复-成功
     */
    @AutoTest(file = "pay/paymentServiceOrderPayTestFaiTwo.csv")
    @DisplayName("订单支付失败--失败用例")
    public void paymentServiceOrderPayTestFaiTwo(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            PaymentOrder order
    ) {
        // 清除数据
        payTestBase.cleanPaymentInstructionByPartnerId(order.getPartnerId());
        // 准备数据
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setMerchantOrderNo(OID.newID());
        print(order);
        if (testId == 1006 || testId == 1007 || testId == 1010) {
            paymentService.orderPay(order);
        }
        if (testId == 1010) {
            order.setPayAmount(new Money(1));
            order.setReqId(OID.newID());
        }
        // 调用接口
        BizResult<PaymentInfo> result = paymentService.orderPay(order);
        // 结果验证
        print(result);
        assertEquals(bizResult.getStatus(), result.getStatus());
        assertEquals(bizResult.getCode(), result.getCode());
        assertFalse(result.toString().contains("privateKey"));
        if (testId == 1006 || testId == 1007 || testId == 1010) {
            assertTrue(result.isIdempotent());
        } else {
            assertFalse(result.isIdempotent());
        }
        // 数据验证

        if (testId == 1008) {
            PaymentInstructionDO paymentInstructionDO = payTestBase.findPaymentInstructionByReqId(order.getReqId()).get(0);
            assertEquals("PROCESSING", paymentInstructionDO.getStatus());
            //调定时任务
            sleep(5);
            scheduleCallBackService.justDoIT();
            sleep(3);
            PaymentInstructionDO paymentInstructionDO1 = payTestBase.findPaymentInstructionByReqId(order.getReqId()).get(0);
            assertEquals("SUCCESS", paymentInstructionDO1.getStatus());
            assertEquals("finished", paymentInstructionDO1.getState());
            //异步通知验证
            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("order", result.getInfo().getBizNo());
            ResponseEntity<String> response = restTemplate.postForEntity(QUERY_NOTIFY_URL, map, String.class);
            JSONObject jsonObject = JSONObject.parseObject(response.getBody());
            JSONObject context = JSONObject.parseObject(jsonObject.getString("context"));
            assertEquals(order.getMerchantOrderNo(), context.getString("merchantOrderNo"));
            assertEquals(paymentInstructionDO.getBizNo(), jsonObject.getString("bizNo"));
            assertEquals("SUCCESS", jsonObject.getString("status"));
            assertEquals("comn_00_0000", jsonObject.getString("code"));
            assertEquals(order.getGid(), jsonObject.getString("gid"));
            assertEquals(order.getReqId(), jsonObject.getString("reqId"));
        }
        if (testId == 1009) {
            PaymentInstructionDO paymentInstructionDO = payTestBase.findPaymentInstructionByReqId(order.getReqId()).get(0);
            assertEquals("FAIL", paymentInstructionDO.getStatus());
            assertEquals("gw_fail", paymentInstructionDO.getState());
        }
        if (testId == 1010) {
            PaymentInstructionDO paymentInstructionDO = payTestBase.findPaymentInstructionByMerchantOrderNo(order.getMerchantOrderNo()).get(0);
            assertEquals("SUCCESS", paymentInstructionDO.getStatus());
            assertEquals("finished", paymentInstructionDO.getState());
        }
        //调mq定时任务
        scheduleCallBackService1.justDoIT();
        // 清除数据
        // payTestBase.cleanPaymentInstructionByPartnerId(order.getPartnerId());
    }
}
