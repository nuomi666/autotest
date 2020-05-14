package com.xjy.autotest.enums;

/**
 * @Author: xiongmao
 * @Date: 2018-2-1
 * @Desc: 租金类型
 **/
public enum RentPriceType {

    FIVE_LOW("FIVE_LOW","500以下"),
    FIVE_ONE("FIVE_ONE","500-1000元"),
    ONE_TWO("ONE_TWO","1000-2000元"),
    TWO_THREE("TWO_THREE","2000-3000元"),
    THREE_FIVE("THREE_FIVE","3000-5000元"),
    FIVE_HIGH("FIVE_HIGH","5000元以上")
    ;

    private String code;

    private String message;

    private RentPriceType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static RentPriceType getByCode(String code) {
        for (RentPriceType result : values()) {
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
        for (RentPriceType _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<RentPriceType> getAllEnum() {
        java.util.List<RentPriceType> list = new java.util.ArrayList<RentPriceType>(values().length);
        for (RentPriceType _enum : values()) {
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
        for (RentPriceType _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}
