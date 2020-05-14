package com.xjy.autotest.enums;

/**
 * @Author: xiongmao
 * @Date: 2018-01-30
 * @Desc: 产权年限枚举
 **/
public enum LimitYearType {

    SEVEN("SEVEN","70年"),

    FIVE("FIVE","50年"),

    FOUR("FOUR","40年"),
    THREE("THREE","30年")

    ;

    private String code;

    private String message;

    private LimitYearType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static LimitYearType getByCode(String code) {
        for (LimitYearType result : values()) {
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
        for (LimitYearType _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<LimitYearType> getAllEnum() {
        java.util.List<LimitYearType> list = new java.util.ArrayList<LimitYearType>(values().length);
        for (LimitYearType _enum : values()) {
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
        for (LimitYearType _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}
