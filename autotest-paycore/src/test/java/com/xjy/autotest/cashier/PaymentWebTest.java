package com.xjy.autotest.cashier;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.pay.api.settlement.order.payment.PaymentOrder;

import java.util.HashMap;
import java.util.Map;

public class PaymentWebTest extends SpringBootTestBase {

    @AutoTest(file = "cashier/paymentWebTestSuccess.csv")
    public void paymentWebTestSuccess(
            int testId,
            PaymentOrder order
    ) {
        String str = "http://192.168.2.223:8085/cashier/payment.htm?";
        Map<String, String> map = new HashMap<>();
        map.put("transTag", order.getTransTag().code());
        //map.put("payeeUserId", order.getPayeeUserId());
        map.put("payAmount", order.getPayAmount() + "");
        map.put("payChannelId", order.getPayChannelId());
        //map.put("payChannelId", "5");
        map.put("authCode", order.getAuthCode());
        map.put("userId", order.getUserId());
        map.put("openId", order.getOpenId());
        map.put("remoteIp", order.getRemoteIp());
        map.put("domainName", order.getDomainName());
        map.put("notifyCategory", order.getNotifyCategory().code());
        map.put("notifyUrl", order.getNotifyUrl());
        map.put("notifyGroup", order.getNotifyGroup());
        map.put("notifyVersion", order.getNotifyVersion());
        map.put("redirectUrl", order.getRedirectUrl());
        map.put("externalMetaData", order.getExternalMetaData());
        map.put("memo", "支付宝支付");
        map.put("reqId", OID.newID());
        map.put("gid", GID.newGID());
        map.put("partnerId", order.getPartnerId());
        map.put("platPartnerId", order.getPlatPartnerId());
        map.put("merchantOrderNo", "merchNo" + System.currentTimeMillis());
        map.put("platMerchantOrderNo", OID.newID());
        String url = formatUrlMap(map, false, false);
        System.out.printf(str + url);
        assertEquals(1, 2);
    }


}
