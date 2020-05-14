package com.xjy.autotest.enums;

/**
 * @Author: xiongmao
 * @Date: 2018-2-1
 * @Desc: 出售金额区间类型
 **/
public enum SalePriceType {

    FOUR_LOW("FOUR_LOW","40万以下"),
    FOUR_SIX("FOUR_SIX","40-60万"),
    SIX_EIGHT("SIX_EIGHT","60-80万"),
    EIGHT_TEN("EIGHT_TEN","80-100万"),
    TENUP("TENUP","100-120万"),
    TWELVE_HIGH("TWELVE_HIGH","120万以上")
    ;

    private String code;

    private String message;

    private SalePriceType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static SalePriceType getByCode(String code) {
        for (SalePriceType result : values()) {
            if (result.code().equals(code)) {
                return result;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举值
     *
     * @return List<String>
     */
    public static java.util.List<String> getAllEnumCode() {
        java.util.List<String> list = new java.util.ArrayList<String>(values().length);
        for (SalePriceType _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<SalePriceType> getAllEnum() {
        java.util.List<SalePriceType> list = new java.util.ArrayList<SalePriceType>(values().length);
        for (SalePriceType _enum : values()) {
            list.add(_enum);
        }
        return list;
    }

    /**
     * 获取全部枚举描述
     *
     * @return List<ListType>
     */
    public static java.util.List<String> getAllEnumMessage() {
        java.util.List<String> list = new java.util.ArrayList<String>(values().length);
        for (SalePriceType _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}
