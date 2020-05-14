package com.xjy.autotest.pay;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.PayTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.pay.api.settlement.info.PaymentQueryOrderInfo;
import com.xyb.pay.api.settlement.order.QueryOrder;
import com.xyb.pay.api.settlement.service.PaymentService;
import dal.model.pay.*;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author ychaoyang
 * Created on 2018/07/27.
 */
public class PaymentServiceOrderQueryTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    PaymentService paymentService;

    @Autowired
    PayTestBase payTestBase;

    /**
     * 1001 查询支付成功订单
     * 1002 查询支付失败订单
     * 1003 查询支付初始订单
     * 1004 查询线下支付成功订单
     * 1005 查询充值成功订单
     * 1006 查询充值失败订单
     * 1007 查询充值初始订单
     * 1008 查询线下充值成功订单
     * 1009 查询退款成功订单
     * 1010 查询退款失败订单
     * 1011 查询退款初始订单
     * 1012 查询线下退款成功订单
     * 1013 查询余额支付成功订单
     * 1014 查询提现成功订单
     * 1015 查询提现失败订单
     * 1016 查询提现初始订单
     */
    @AutoTest(file = "pay/paymentServiceOrderQueryTestSuccess.csv")
    @DisplayName("订单查询--成功用例")
    public void paymentServiceOrderQueryTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            QueryOrder order,
            //准备数据
            TransOrderRecordDO transOrderRecordDO,
            //支付订单
            PaymentInstructionDO paymentInstructionDO,
            //充值订单
            DepositInstructionDO depositInstructionDO,
            //提现订单
            RefundInstructionDO refundInstructionDO,
            //退款订单
            WithdrawInstructionDO withdrawInstructionDO
    ) {
        // 清除数据
        payTestBase.cleanTransOrderRecordById(transOrderRecordDO.getId());
        payTestBase.cleanTransOrderRecordByBizNo(transOrderRecordDO.getBizNo());
        payTestBase.cleanPaymentInstructionById(paymentInstructionDO.getId());
        payTestBase.cleanDepositInstructionById(depositInstructionDO.getId());
        payTestBase.cleanRefundInstructionById(refundInstructionDO.getId());
        // 准备数据
        payTestBase.insertTransOrderRecord(transOrderRecordDO);
        payTestBase.insertPaymentInstruction(paymentInstructionDO);
        payTestBase.insertDepositInstruction(depositInstructionDO);
        payTestBase.insertRefundInstruction(refundInstructionDO);
        //创建订单
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        print(order);
        // 调用接口
        BizResult<PaymentQueryOrderInfo> result = paymentService.orderQuery(order);

        // 结果验证
        print(result);
        assertEquals(bizResult.getStatus(), result.getStatus());
        assertEquals(bizResult.getCode(), result.getCode());
        assertFalse(result.toString().contains("privateKey"));
        PaymentQueryOrderInfo info = result.getInfo();
        if (testId <= 1004 || testId == 1013) {
            assertEquals(order.getBizNo(), info.getBizNo());
            assertEquals(paymentInstructionDO.getRawAddTime(), info.getCreateTime());
            assertEquals(paymentInstructionDO.getDiscountAmount(), info.getDiscountAmount().getCent());
            assertEquals(paymentInstructionDO.getExternalmetadata(), info.getExternalMetaData());
            assertEquals(paymentInstructionDO.getFinishTime(), info.getFinishTime());
            assertEquals(transOrderRecordDO.getGid(), info.getGid());
            assertEquals(transOrderRecordDO.getMerchantOrderNo(), info.getMerchantOrderNo());
            assertEquals(paymentInstructionDO.getPartnerId(), info.getPartnerId());
            assertEquals(paymentInstructionDO.getPayAmount(), info.getPayAmount().getCent());
            assertEquals(paymentInstructionDO.getPayChannel(), info.getPayChannel());
            assertEquals(paymentInstructionDO.getPayType(), info.getPayType());
            assertEquals(paymentInstructionDO.getPayerUserId(), info.getPayer());
            assertEquals(paymentInstructionDO.getRealPayAmount(), info.getRealPayAmount().getCent());
            assertEquals(null, info.getRefundAmount());
            assertEquals(transOrderRecordDO.getReqId(), info.getReqId());
            assertEquals(paymentInstructionDO.getStatus(), info.getTradeState());
            assertEquals(paymentInstructionDO.getTransTag(), info.getTransTag().code());
            assertEquals(paymentInstructionDO.getTransType(), info.getTransType().code());
            assertEquals(paymentInstructionDO.getPayerUserId(), info.getUserId());
        }
        if (testId >= 1005 && testId <= 1008) {
            assertEquals(depositInstructionDO.getRawAddTime(), info.getCreateTime());
            assertEquals(depositInstructionDO.getDiscountAmount(), info.getDiscountAmount().getCent());
            assertEquals(depositInstructionDO.getExternalmetadata(), info.getExternalMetaData());
            assertEquals(depositInstructionDO.getFinishTime(), info.getFinishTime());
            assertEquals(transOrderRecordDO.getGid(), info.getGid());
            assertEquals(transOrderRecordDO.getMerchantOrderNo(), info.getMerchantOrderNo());
            assertEquals(depositInstructionDO.getPartnerId(), info.getPartnerId());
            assertEquals(depositInstructionDO.getPayAmount(), info.getPayAmount().getCent());
            assertEquals(depositInstructionDO.getPayChannel(), info.getPayChannel());
            assertEquals(depositInstructionDO.getPayType(), info.getPayType());
            assertEquals(null, info.getPayer());
            assertEquals(depositInstructionDO.getRealPayAmount(), info.getRealPayAmount().getCent());
            assertEquals(null, info.getRefundAmount());
            assertEquals(transOrderRecordDO.getReqId(), info.getReqId());
            assertEquals(depositInstructionDO.getStatus(), info.getTradeState());
            assertEquals(depositInstructionDO.getTransTag(), info.getTransTag().code());
            assertEquals(depositInstructionDO.getTransType(), info.getTransType().code());
            assertEquals(depositInstructionDO.getPayeeUserId(), info.getUserId());
        }
        if (testId >= 1009 && testId <= 1012) {
            assertEquals(order.getBizNo(), info.getBizNo());
            assertEquals(refundInstructionDO.getRawAddTime(), info.getCreateTime());
            assertEquals(null, info.getDiscountAmount());
            assertEquals(refundInstructionDO.getExternalMetaData(), info.getExternalMetaData());
            assertEquals(refundInstructionDO.getFinishTime(), info.getFinishTime());
            assertEquals(transOrderRecordDO.getGid(), info.getGid());
            assertEquals(transOrderRecordDO.getMerchantOrderNo(), info.getMerchantOrderNo());
            assertEquals(refundInstructionDO.getPartnerId(), info.getPartnerId());
            //assertEquals(refundInstructionDO.gett, info.getPayType());
            assertEquals(null, info.getPayer());
            assertEquals(refundInstructionDO.getPayAmount(), info.getRealPayAmount().getCent());
            assertEquals(refundInstructionDO.getRefundAmount(), info.getRefundAmount().getCent());
            assertEquals(transOrderRecordDO.getReqId(), info.getReqId());
            assertEquals(refundInstructionDO.getStatus(), info.getTradeState());
            assertEquals(refundInstructionDO.getTransTag(), info.getTransTag().code());
            assertEquals("REFUND", info.getTransType().code());
            assertEquals(null, info.getUserId());
        }

        // 数据验证
        // 清除数据
        payTestBase.cleanTransOrderRecordById(transOrderRecordDO.getId());
        payTestBase.cleanPaymentInstructionById(paymentInstructionDO.getId());
        payTestBase.cleanDepositInstructionById(depositInstructionDO.getId());
        payTestBase.cleanRefundInstructionById(refundInstructionDO.getId());
    }

    /**
     * 1001 gid传空
     * 1002 reqId传空
     * 1003 partnerid传空
     * 1004 merchantOrderNo传空
     */
    @AutoTest(file = "pay/paymentServiceOrderQueryTestFailOne.csv")
    @DisplayName("参数缺省--失败用例")
    public void paymentServiceOrderQueryTestFailOne(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            QueryOrder order
            //准备数据
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        print(order);
        // 调用接口
        BizResult<PaymentQueryOrderInfo> result = paymentService.orderQuery(order);
        // 结果验证
        print(result);
        assertEquals(bizResult.getStatus(), result.getStatus());
        assertEquals(bizResult.getCode(), result.getCode());
        assertFalse(result.toString().contains("privateKey"));
        // 数据验证
        // 清除数据
    }

    /**
     * 1001 订单不存在bizNo查询
     * 1002 订单不存在merchNo查询
     * 1003 充值订单不存在merchNo查询
     * 1004 退款订单不存在merchNo查询
     */
    @AutoTest(file = "pay/paymentServiceOrderQueryTestFailTwo.csv")
    @DisplayName("查询失败--失败用例")
    public void paymentServiceOrderQueryTestFailTwo(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            QueryOrder order
            //准备数据
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        print(order);
        // 调用接口
        BizResult<PaymentQueryOrderInfo> result = paymentService.orderQuery(order);
        // 结果验证
        print(result);
        assertEquals(bizResult.getStatus(), result.getStatus());
        assertEquals(bizResult.getCode(), result.getCode());
        assertFalse(result.toString().contains("privateKey"));
        // 数据验证
        // 清除数据
    }

}
