package com.xjy.autotest.enums;

/**
 * @Author: xiongmao
 * @Date: 2018-01-30
 * @Desc: 房屋出租类型
 **/
public enum HouseRentType {
    WHOLE("WHOLE","整租"),
    COOPERATIVE("COOPERATIVE","合租"),
    ALONE("ALONE","单间"),
    MAIN_REST("MAIN_REST","主卧"),
    MINOR_REST("MINOR_REST","次卧"),

    ;

    private String code;

    private String message;

    private HouseRentType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static HouseRentType getByCode(String code) {
        for (HouseRentType result : values()) {
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
        for (HouseRentType _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<HouseRentType> getAllEnum() {
        java.util.List<HouseRentType> list = new java.util.ArrayList<HouseRentType>(values().length);
        for (HouseRentType _enum : values()) {
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
        for (HouseRentType _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}
