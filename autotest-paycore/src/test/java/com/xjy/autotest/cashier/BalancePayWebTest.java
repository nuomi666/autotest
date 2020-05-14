package com.xjy.autotest.cashier;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.pay.api.settlement.order.payment.balance.BalancePaymentApplyOrder;

import java.util.HashMap;
import java.util.Map;

public class BalancePayWebTest extends SpringBootTestBase {

    @AutoTest(file = "cashier/balancePayWebTestSuccess.csv")
    public void balancePayWebTestSuccess(
            int testId,
            BalancePaymentApplyOrder order
    ) {
        String str = "http://192.168.2.223:8085/cashier/balancePay.htm?";

        Map<String, String> map = new HashMap<>();
        map.put("payerUserId", order.getPayerUserId());
        map.put("payerUserTag", order.getPayerUserId());
        map.put("payerUserId", "S0301808171000000050");
        map.put("payerUserTag", "S0301808171000000050");
        map.put("payeeUserId", order.getPartnerId());
        map.put("payeeUserId", "S0301808171000000046");
        map.put("amount", "1");
        map.put("redirectUrl", order.getRedirectUrl());
        map.put("memo", "余额支付");
        map.put("reqId", OID.newID());
        map.put("gid", GID.newGID());
        map.put("partnerId", order.getPartnerId());
        map.put("platPartnerId", order.getPlatPartnerId());
        map.put("partnerId", "S0301808171000000046");
        map.put("platPartnerId", "S0301808171000000046");
        map.put("merchantOrderNo", OID.newID());
        map.put("platMerchantOrderNo", OID.newID());
        map.put("notifyCategory", "DUBBO");
        map.put("notifyGroup", "autotest-pay");
        map.put("notifyVersion", "1.0.0");
        String url = formatUrlMap(map, false, false);
        System.out.printf(str + url);
        assertEquals(1, 2);
    }


}
