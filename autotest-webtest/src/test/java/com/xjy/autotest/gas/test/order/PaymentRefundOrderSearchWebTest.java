package com.xjy.autotest.gas.test.order;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.order.PaymentOrderPage;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author ychaoyang
 * Created on 2020-2-19.
 */
public class PaymentRefundOrderSearchWebTest extends WebTestBase {
    @Autowired
    Gas_merchantTestBase gas_merchantTestBase;

    /**
     * 1001 根据全部查询条件查询订单信息
     * 1002 根据退款单号查询
     * 1003 根据支付单号查询
     */
    @AutoTest(file = "gas/paymentRefundOrderSearchWebTestSuccess.csv")
    @DisplayName("消费退款订单查询--成功用例")
    public void paymentRefundOrderSearchWebTestSuccess(
            int testId,
            String userName,
            String password,
            String bizNo,
            String tradeNo,
            String stationCode,
            String stationName,
            String mobile,
            String carNumber,
            String finishTime,
            String finishTime1,
            String tradePayType,
            String status
    ) {
        //清除数据
        //打开加好油中台页面
        open(testUrlGas);
        //登录并查询订单
        PaymentOrderPage paymentOrderPage = new GasLoginPage()
                .login(USER_NAME_JHY, PASS_WORD_JHY)
                .orderCenter()
                .paymentRefundOrder()
                .searchPaymentRefundOrder(tradeNo, bizNo, stationCode, stationName, mobile, carNumber, finishTime, finishTime1, tradePayType, status);
        //页面数据验证
        paymentOrderPage.checkRefundOrderData(bizNo, tradeNo, stationCode, stationName, mobile, carNumber, finishTime, tradePayType, status);
        //数据库数据验证
        //删除数据

    }
}
