package com.xjy.autotest.enums;

import lombok.Getter;

/**
 * 付款方式
 */
@Getter
public enum PaymentType {
    NONE("NONE", "无"),
    CASH("CASH", "现金"),
    TRANSFER("TRANSFER", "企业转账"),
    CARD("CARD", "刷卡"),
    WXPAY("WXPAY", "微信"),
    ALIPAY("ALIPAY", "支付宝"),
    MOTORCADE_CARD("MOTORCADE_CARD", "车队卡");

    private String code;
    private String desc;

    private PaymentType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
