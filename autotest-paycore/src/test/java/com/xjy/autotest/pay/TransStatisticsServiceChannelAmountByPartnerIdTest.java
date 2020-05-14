package com.xjy.autotest.pay;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.PayTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.pay.api.settlement.info.ChannelAmountInfo;
import com.xyb.pay.api.settlement.order.ChannelAmountStatisticsOrder;
import com.xyb.pay.api.settlement.result.ChannelAmountStatisticsResult;
import com.xyb.pay.api.settlement.service.TransStatisticsService;
import dal.model.pay.DepositInstructionDO;
import dal.model.pay.PaymentInstructionDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author ychaoyang
 * Created on 2019/01/11.
 */
public class TransStatisticsServiceChannelAmountByPartnerIdTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    TransStatisticsService transStatisticsService;

    @Autowired
    PayTestBase payTestBase;

    /**
     * 1001 查询一个商户的统计
     * 1002 查询另一个商户的统计
     * 1003 查询两个商户的统计
     * 1004 查询两个商户的统计，排除线下支付
     * 1005 查询两个商户的统计，排除已退款订单
     * 1006 查询一个商户统计为空
     * 1007 查询两个商户，只有一个商户有数据
     */
    @AutoTest(file = "pay/transStatisticsServiceChannelAmountByPartnerIdTestSuccess.csv")
    @DisplayName("商户渠道金额统计--成功用例")
    public void transStatisticsServiceChannelAmountByPartnerIdTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ChannelAmountStatisticsOrder order,
            String partnerId,
            String partnerId1,
            //准备数据
            PaymentInstructionDO paymentInstructionDO,
            PaymentInstructionDO paymentInstructionDO1,
            PaymentInstructionDO paymentInstructionDO2,
            DepositInstructionDO depositInstructionDO,
            DepositInstructionDO depositInstructionDO1,
            DepositInstructionDO depositInstructionDO2
    ) {
        // 清除数据
        payTestBase.cleanDepositInstructionByPlatPartnerId(paymentInstructionDO.getPlatPartnerId());
        payTestBase.cleanPaymentInstructionByPlatPartnerId(depositInstructionDO.getPlatPartnerId());
        // 准备数据
        payTestBase.insertPaymentInstruction(paymentInstructionDO);
        payTestBase.insertPaymentInstruction(paymentInstructionDO1);
        payTestBase.insertPaymentInstruction(paymentInstructionDO2);
        payTestBase.insertDepositInstruction(depositInstructionDO);
        payTestBase.insertDepositInstruction(depositInstructionDO1);
        payTestBase.insertDepositInstruction(depositInstructionDO2);
        // 测试过程
        List<String> partnerIds = new ArrayList<String>();
        partnerIds.add(partnerId);
        if (testId >= 1003) {
            partnerIds.add(partnerId1);
        }
        order.setPartnerIds(partnerIds);
        order.setGid(GID.newGID());
        print(order);
        // 调用接口
        ChannelAmountStatisticsResult result = transStatisticsService.channelAmountByPartnerId(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        long fee = 0L;
        long amount = 0L;
        long fee1 = 0L;
        long amount1 = 0L;
        if (testId == 1001) {
            fee = paymentInstructionDO.getPartnerFee()
                    + paymentInstructionDO1.getPartnerFee()
                    + paymentInstructionDO2.getPartnerFee()
                    + depositInstructionDO.getPartnerFee()
                    + depositInstructionDO1.getPartnerFee()
                    + depositInstructionDO2.getPartnerFee();
            amount = paymentInstructionDO.getRealPayAmount()
                    + paymentInstructionDO1.getRealPayAmount()
                    + paymentInstructionDO2.getRealPayAmount()
                    + depositInstructionDO.getRealPayAmount()
                    + depositInstructionDO1.getRealPayAmount()
                    + depositInstructionDO2.getRealPayAmount();
        }
        if (testId == 1002) {
            fee = paymentInstructionDO.getPartnerFee()
                    + paymentInstructionDO1.getPartnerFee()
                    + depositInstructionDO.getPartnerFee()
                    + depositInstructionDO1.getPartnerFee();
            amount = paymentInstructionDO.getRealPayAmount()
                    + paymentInstructionDO1.getRealPayAmount()
                    + depositInstructionDO.getRealPayAmount()
                    + depositInstructionDO1.getRealPayAmount();
        }
        if (testId == 1003) {
            fee = paymentInstructionDO.getPartnerFee()
                    + depositInstructionDO.getPartnerFee();
            amount = paymentInstructionDO.getRealPayAmount()
                    + depositInstructionDO.getRealPayAmount();
            fee1 = paymentInstructionDO1.getPartnerFee()
                    + paymentInstructionDO2.getPartnerFee()
                    + depositInstructionDO1.getPartnerFee()
                    + depositInstructionDO2.getPartnerFee();
            amount1 = paymentInstructionDO1.getRealPayAmount()
                    + paymentInstructionDO2.getRealPayAmount()
                    + depositInstructionDO1.getRealPayAmount()
                    + depositInstructionDO2.getRealPayAmount();
        }
        if (testId == 1004) {
            fee = depositInstructionDO.getPartnerFee();
            amount = depositInstructionDO.getRealPayAmount();
            fee1 = paymentInstructionDO1.getPartnerFee()
                    + paymentInstructionDO2.getPartnerFee()
                    + depositInstructionDO1.getPartnerFee()
                    + depositInstructionDO2.getPartnerFee();
            amount1 = paymentInstructionDO1.getRealPayAmount()
                    + paymentInstructionDO2.getRealPayAmount()
                    + depositInstructionDO1.getRealPayAmount()
                    + depositInstructionDO2.getRealPayAmount();
        }
        if (testId == 1005) {
            fee = depositInstructionDO.getPartnerFee();
            amount = depositInstructionDO.getRealPayAmount();
            fee1 = paymentInstructionDO2.getPartnerFee()
                    + depositInstructionDO1.getPartnerFee()
                    + depositInstructionDO2.getPartnerFee();
            amount1 = paymentInstructionDO2.getRealPayAmount()
                    + depositInstructionDO1.getRealPayAmount()
                    + depositInstructionDO2.getRealPayAmount();
        }
        if (testId == 1007) {
            fee1 = paymentInstructionDO1.getPartnerFee()
                    + paymentInstructionDO2.getPartnerFee()
                    + depositInstructionDO1.getPartnerFee()
                    + depositInstructionDO2.getPartnerFee();
            amount1 = paymentInstructionDO1.getRealPayAmount()
                    + paymentInstructionDO2.getRealPayAmount()
                    + depositInstructionDO1.getRealPayAmount()
                    + depositInstructionDO2.getRealPayAmount();
        }
        if (testId <= 1005) {
            assertResult(result, partnerId, fee, amount);
        }
        if (testId >= 1003 && testId <= 1005 || testId == 1007) {
            assertResult(result, partnerId1, fee1, amount1);
        }
        if (testId == 1006) {
            assertEquals(0, result.getInfoList().size());
        }
        // 数据验证
        // 清除数据
        payTestBase.cleanDepositInstructionByPlatPartnerId(paymentInstructionDO.getPlatPartnerId());
        payTestBase.cleanPaymentInstructionByPlatPartnerId(depositInstructionDO.getPlatPartnerId());

    }

    /**
     * 1001 开始日期为空
     * 1002 结束日期为空
     * 1003 商户ID数组为空
     * 1004 gid为空
     */
    @AutoTest(file = "pay/transStatisticsServiceChannelAmountByPartnerIdTestFailOne.csv")
    @DisplayName("参数缺省--失败用例")
    public void transStatisticsServiceChannelAmountByPartnerIdTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ChannelAmountStatisticsOrder order,
            String partnerId
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        List<String> partnerIds = new ArrayList<String>();
        partnerIds.add(partnerId);
        if (testId != 1003) {
            order.setPartnerIds(partnerIds);
        }
        // 调用接口
        ChannelAmountStatisticsResult result = transStatisticsService.channelAmountByPartnerId(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
    }


    /**
     * 断言返回结果中的手续费和金额总数
     *
     * @param result
     * @param partnerId
     * @param fee
     * @param amount
     */
    public void assertResult(ChannelAmountStatisticsResult result, String partnerId, long fee, long amount) {
        ChannelAmountInfo channelAmountInfo1 = result.getInfoList().stream().filter((info) -> (partnerId.equals(info.getPartnerId()))).findFirst().get();
        assertEquals(fee, channelAmountInfo1.getFee().getCent());
        assertEquals(amount, channelAmountInfo1.getAmount().getCent());
    }
}
