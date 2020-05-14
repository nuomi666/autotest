package com.xjy.autotest.enums;



/**
 * @Author: Jax
 * @Date: 2018-01-2018/1/22-11:37
 * @Desc:
 **/
public enum KeyStatus {


    RESERVE_KEY("RESERVE_KEY","预钥"),

    BORROW_KEY("BORROW_KEY","借钥"),

    HAS_KEY("HAS_KEY","有钥"),

    DIRECT("DIRECT","直接")

    ;

    private String code;

    private String message;

    private KeyStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static KeyStatus getByCode(String code) {
        for (KeyStatus result : values()) {
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
        for (KeyStatus _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<KeyStatus> getAllEnum() {
        java.util.List<KeyStatus> list = new java.util.ArrayList<KeyStatus>(values().length);
        for (KeyStatus _enum : values()) {
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
        for (KeyStatus _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}
