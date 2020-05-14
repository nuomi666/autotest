package com.xjy.autotest.enums;

/**
 * @Author: xiongmao
 * @Date: 2018-01-2018/1/22-14:40
 * @Desc: 出租排序枚举
 **/
public enum RentOrderType {
    DEFAULT("DEFAULT","默认排序"),
    TIME("TIME","时间排序"),
    RENTALUP("TOTALUP","租金从低到高"),
    RENTALDOWN("TOTALDOWN","租金从高到低"),
    ACREAGEUP("ACREAGEUP","面积从小到大"),
    ACREAGEDOWN("ACREAGEDOWN","面积从大到小")

    ;

    private String code;

    private String message;

    private RentOrderType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static RentOrderType getByCode(String code) {
        for (RentOrderType result : values()) {
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
        for (RentOrderType _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<RentOrderType> getAllEnum() {
        java.util.List<RentOrderType> list = new java.util.ArrayList<RentOrderType>(values().length);
        for (RentOrderType _enum : values()) {
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
        for (RentOrderType _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}
