package com.xjy.autotest.gas.pages.order;

import com.xjy.autotest.gas.pages.GasHomePage;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * @author ychaoyang
 * Created on 2020-2-18.
 */
public class OrderCenterPage extends GasHomePage {

    /**
     * 消费订单
     *
     * @return
     */
    public PaymentOrderPage paymentOrder() {
        $(byLinkText("消费订单")).click();
        return new PaymentOrderPage();
    }

    /**
     * 消费退款订单
     *
     * @return
     */
    public PaymentOrderPage paymentRefundOrder() {
        $(byLinkText("消费订单")).click();
        $(byText("退款订单")).click();
        return new PaymentOrderPage();
    }

    /**
     * 充值订单
     *
     * @return
     */
    public DepositOrderPage depositOrder() {
        $(byLinkText("充值订单")).click();
        return new DepositOrderPage();
    }

    /**
     * 充退订单
     *
     * @return
     */
    public DepositOrderPage depositRefundOrder() {
        $(byLinkText("充值订单")).click();
        $(byText("充退订单")).click();
        return new DepositOrderPage();
    }

}
