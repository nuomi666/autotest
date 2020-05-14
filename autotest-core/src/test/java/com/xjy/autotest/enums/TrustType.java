package com.xjy.autotest.enums;

/**
 * @Author: Jax
 * @Date: 2018-01-2018/1/22-11:28
 * @Desc: 委托类型
 **/
public enum TrustType {

    ORAL("ORAL","口头"),

    GENERAL("GENERAL","一般"),

    REGULAR("REGULAR","专任"),

    FOREIGN("FOREIGN","外单")

    ;

    private String code;

    private String message;

    private TrustType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static TrustType getByCode(String code) {
        for (TrustType result : values()) {
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
        for (TrustType _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<TrustType> getAllEnum() {
        java.util.List<TrustType> list = new java.util.ArrayList<TrustType>(values().length);
        for (TrustType _enum : values()) {
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
        for (TrustType _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}
